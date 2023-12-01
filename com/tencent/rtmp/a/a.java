package com.tencent.rtmp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.TXImageSprite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/a/a.class */
public final class a extends TXImageSprite {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapFactory.Options f24970a;
    private HandlerThread b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f24971c;
    private List<c> d;
    private Map<String, BitmapRegionDecoder> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.rtmp.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/a/a$a.class */
    public static final class RunnableC0833a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f24973a;
        private String b;

        public RunnableC0833a(a aVar, String str) {
            this.f24973a = new WeakReference<>(aVar);
            this.b = str;
        }

        private static float a(String str) {
            String str2;
            String str3;
            String[] split = str.split(":");
            if (split.length == 3) {
                String str4 = split[0];
                str3 = split[1];
                str2 = split[2];
            } else if (split.length == 2) {
                str3 = split[0];
                str2 = split[1];
            } else if (split.length == 1) {
                str2 = split[0];
                str3 = null;
            } else {
                str2 = null;
                str3 = null;
            }
            float f = 0.0f;
            if (str3 != null) {
                f = 0.0f + (Float.valueOf(str3).floatValue() * 60.0f);
            }
            float f2 = f;
            if (str2 != null) {
                f2 = f + Float.valueOf(str2).floatValue();
            }
            return f2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BufferedReader bufferedReader;
            IOException e;
            String readLine;
            a aVar = this.f24973a.get();
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    InputStream a2 = a.a(this.b);
                    if (a2 == null) {
                        return;
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(a2));
                    try {
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 != null && readLine2.length() != 0 && readLine2.contains("WEBVTT")) {
                            do {
                                readLine = bufferedReader.readLine();
                                if (readLine != null && readLine.contains("-->")) {
                                    String[] split = readLine.split(" --> ");
                                    if (split.length == 2) {
                                        String readLine3 = bufferedReader.readLine();
                                        c cVar = new c((byte) 0);
                                        cVar.f24976a = a(split[0]);
                                        cVar.b = a(split[1]);
                                        cVar.f24977c = readLine3;
                                        int indexOf = readLine3.indexOf("#");
                                        if (indexOf != -1) {
                                            cVar.d = readLine3.substring(0, indexOf);
                                        }
                                        int indexOf2 = readLine3.indexOf("=");
                                        if (indexOf2 != -1) {
                                            int i = indexOf2 + 1;
                                            if (i < readLine3.length()) {
                                                String[] split2 = readLine3.substring(i, readLine3.length()).split(",");
                                                if (split2.length == 4) {
                                                    cVar.e = Integer.valueOf(split2[0]).intValue();
                                                    cVar.f = Integer.valueOf(split2[1]).intValue();
                                                    cVar.g = Integer.valueOf(split2[2]).intValue();
                                                    cVar.h = Integer.valueOf(split2[3]).intValue();
                                                }
                                            }
                                        }
                                        if (aVar != null && aVar.d != null) {
                                            aVar.d.add(cVar);
                                        }
                                    }
                                }
                            } while (readLine != null);
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e2) {
                                return;
                            }
                        }
                        LiteavLog.e("TXImageSprite", "DownloadAndParseVTTFileTask : getVTT File Error!");
                        if (aVar != null) {
                            aVar.a();
                        }
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                        }
                    } catch (IOException e4) {
                        e = e4;
                        LiteavLog.e("TXImageSprite", "load image sprite failed.", e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                            }
                        }
                    } catch (Throwable th) {
                        bufferedReader2 = bufferedReader;
                        th = th;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e6) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    bufferedReader = null;
                    e = e7;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/a/a$b.class */
    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f24974a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f24975c;

        public b(a aVar, String str, String str2) {
            this.f24974a = new WeakReference<>(aVar);
            this.b = str;
            this.f24975c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = this.f24974a.get();
            if (this.f24974a == null || aVar == null) {
                return;
            }
            InputStream inputStream = null;
            InputStream inputStream2 = null;
            try {
                try {
                    InputStream a2 = a.a(this.f24975c);
                    String lastPathSegment = Uri.parse(this.f24975c).getLastPathSegment();
                    if (aVar.e != null) {
                        inputStream2 = a2;
                        inputStream = a2;
                        aVar.e.put(lastPathSegment, BitmapRegionDecoder.newInstance(a2, true));
                    }
                    if (a2 != null) {
                        try {
                            a2.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable th) {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                inputStream2 = inputStream;
                LiteavLog.e("TXImageSprite", "load bitmap from network failed.", e3);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/a/a$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public float f24976a;
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public String f24977c;
        public String d;
        public int e;
        public int f;
        public int g;
        public int h;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public a(Context context) {
        super(context);
        this.f24970a = new BitmapFactory.Options();
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        this.d = Collections.synchronizedList(arrayList);
        HashMap hashMap = new HashMap();
        this.e = hashMap;
        this.e = Collections.synchronizedMap(hashMap);
    }

    static /* synthetic */ InputStream a(String str) throws IOException {
        URLConnection openConnection = new URL(str).openConnection();
        openConnection.connect();
        openConnection.getInputStream();
        openConnection.setConnectTimeout(15000);
        openConnection.setReadTimeout(15000);
        return openConnection.getInputStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f24971c != null) {
            LiteavLog.i("TXImageSprite", " remove all tasks!");
            this.f24971c.removeCallbacksAndMessages(null);
            this.f24971c.post(new Runnable() { // from class: com.tencent.rtmp.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.d != null) {
                        a.this.d.clear();
                    }
                    if (a.this.e != null) {
                        for (BitmapRegionDecoder bitmapRegionDecoder : a.this.e.values()) {
                            if (bitmapRegionDecoder != null) {
                                bitmapRegionDecoder.recycle();
                            }
                        }
                        a.this.e.clear();
                    }
                }
            });
        }
    }

    @Override // com.tencent.rtmp.TXImageSprite
    public final Bitmap getThumbnail(float f) {
        c cVar;
        if (this.d.size() == 0) {
            return null;
        }
        int i = 0;
        int size = this.d.size() - 1;
        while (true) {
            int i2 = ((size - i) / 2) + i;
            if (this.d.get(i2).f24976a <= f && this.d.get(i2).b > f) {
                cVar = this.d.get(i2);
                break;
            } else if (i < size) {
                if (f < this.d.get(i2).b) {
                    if (f >= this.d.get(i2).f24976a) {
                        cVar = null;
                        break;
                    }
                    size = i2 - 1;
                } else {
                    i = i2 + 1;
                }
            } else {
                cVar = this.d.get(i);
                break;
            }
        }
        if (cVar == null) {
            return null;
        }
        BitmapRegionDecoder bitmapRegionDecoder = this.e.get(cVar.d);
        if (bitmapRegionDecoder == null) {
            return null;
        }
        Rect rect = new Rect();
        rect.left = cVar.e;
        rect.top = cVar.f;
        rect.right = cVar.e + cVar.g;
        rect.bottom = cVar.f + cVar.h;
        return bitmapRegionDecoder.decodeRegion(rect, this.f24970a);
    }

    @Override // com.tencent.rtmp.TXImageSprite
    public final void release() {
        a();
        if (this.b == null || this.f24971c == null) {
            return;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
            this.b.quitSafely();
        } else {
            this.b.quit();
        }
        this.f24971c = null;
        this.b = null;
    }

    @Override // com.tencent.rtmp.TXImageSprite
    public final void setVTTUrlAndImageUrls(String str, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e("TXImageSprite", "setVTTUrlAndImageUrls: vttUrl can't be null!");
            return;
        }
        a();
        if (this.b == null) {
            HandlerThread handlerThread = new HandlerThread("SuperVodThumbnailsWorkThread");
            this.b = handlerThread;
            handlerThread.start();
            this.f24971c = new Handler(this.b.getLooper());
        }
        this.f24971c.post(new RunnableC0833a(this, str));
        if (list == null || list.size() == 0) {
            return;
        }
        for (String str2 : list) {
            this.f24971c.post(new b(this, str, str2));
        }
    }
}
