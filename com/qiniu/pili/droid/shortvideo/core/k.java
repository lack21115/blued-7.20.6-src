package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.qiniu.pili.droid.shortvideo.PLComposeItem;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import com.qiniu.pili.droid.shortvideo.PLVideoRange;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private Context f13877a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private com.qiniu.pili.droid.shortvideo.process.a.b f13878c;
    private com.qiniu.pili.droid.shortvideo.transcoder.a d;
    private com.qiniu.pili.droid.shortvideo.process.a.a e;
    private com.qiniu.pili.droid.shortvideo.f.f f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/k$a.class */
    public class a extends Thread {
        private List<Bitmap> b;

        /* renamed from: c  reason: collision with root package name */
        private int f13882c;
        private boolean d;
        private String e;
        private PLVideoSaveListener f;
        private volatile boolean g = false;

        public a(List<Bitmap> list, int i, boolean z, String str, PLVideoSaveListener pLVideoSaveListener) {
            this.b = list;
            this.f13882c = i;
            this.d = z;
            this.e = str;
            this.f = pLVideoSaveListener;
        }

        void a() {
            this.g = true;
        }

        boolean b() {
            if (this.g && this.f != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.k.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f.onSaveVideoCanceled();
                    }
                });
            }
            return this.g;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.qiniu.pili.droid.shortvideo.encode.b bVar = new com.qiniu.pili.droid.shortvideo.encode.b();
            bVar.a(this.f13882c);
            bVar.a(this.d);
            bVar.a(byteArrayOutputStream);
            Handler handler = new Handler(Looper.getMainLooper());
            int i = 0;
            while (true) {
                final int i2 = i;
                if (i2 >= this.b.size()) {
                    bVar.a();
                    try {
                        if (b()) {
                            return;
                        }
                        new FileOutputStream(new File(this.e)).write(byteArrayOutputStream.toByteArray());
                        if (this.f != null) {
                            if (b()) {
                                new File(this.e).delete();
                                return;
                            } else {
                                handler.post(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.k.a.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        a.this.f.onSaveVideoSuccess(a.this.e);
                                    }
                                });
                                return;
                            }
                        }
                        return;
                    } catch (IOException e) {
                        com.qiniu.pili.droid.shortvideo.f.e.t.e("ShortVideoComposerCore", "Error when saving gif file.");
                        if (this.f != null) {
                            handler.post(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.k.a.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.f.onSaveVideoFailed(0);
                                }
                            });
                            return;
                        }
                        return;
                    }
                } else if (b()) {
                    return;
                } else {
                    bVar.a(this.b.get(i2));
                    if (this.f != null) {
                        handler.post(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.k.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.f.onProgressUpdate(i2 / a.this.b.size());
                            }
                        });
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public k(Context context) {
        com.qiniu.pili.droid.shortvideo.f.e.t.c("ShortVideoComposerCore", "init +");
        Context applicationContext = context.getApplicationContext();
        this.f13877a = applicationContext;
        l.a(applicationContext);
        com.qiniu.pili.droid.shortvideo.f.e.t.c("ShortVideoComposerCore", "init -");
    }

    private JSONObject a(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, i);
            jSONObject.put("data_type", QosManager.a.config);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public void a() {
        a aVar = this.b;
        if (aVar == null) {
            com.qiniu.pili.droid.shortvideo.f.e.t.d("ShortVideoComposerCore", "No working gif thread to cancel");
            return;
        }
        aVar.a();
        this.b = null;
    }

    public void a(QosManager.KeyPoint keyPoint, String str, int i) {
        QosManager.a().a(a(str, i));
        QosManager.a().a(keyPoint);
    }

    public void a(String str, final long j, long j2, final int i, final int i2, final int i3, int i4, final boolean z, final String str2, final PLVideoSaveListener pLVideoSaveListener) {
        if (u.a().a(b.a.compose_gif, pLVideoSaveListener)) {
            if (str == null) {
                com.qiniu.pili.droid.shortvideo.f.e.t.e("ShortVideoComposerCore", "Input media file path empty! A valid file path required!");
            } else if (i <= 0) {
                com.qiniu.pili.droid.shortvideo.f.e.t.e("ShortVideoComposerCore", "Illegal parameter:pictureCount. A positive integer required!");
            } else if (j > j2 || j < 0 || j2 < 0) {
                com.qiniu.pili.droid.shortvideo.f.e.t.e("ShortVideoComposerCore", "Illegal parameter:startTimeMs & endTimeMs. endTimeMs should be greater than startTimeMs as positive integer!");
            } else if (i4 < 0 || i4 > 120) {
                com.qiniu.pili.droid.shortvideo.f.e.t.e("ShortVideoComposerCore", "Illegal parameter:gifFps. Gif frame rate should be an positive number that does not exceed 120!");
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.t.c("ShortVideoComposerCore", "extractVideoToGIF + ");
                this.f = new com.qiniu.pili.droid.shortvideo.f.f(str);
                final long j3 = (j2 - j) / i;
                final long j4 = 1000 / i4;
                com.qiniu.pili.droid.shortvideo.f.e.t.c("ShortVideoComposerCore", "Gif picture count:" + i + ", picture duration:" + j3);
                new Thread(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.k.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList arrayList = new ArrayList();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= i) {
                                break;
                            }
                            long j5 = j + (i6 * j3);
                            if (j5 >= k.this.f.g()) {
                                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.t;
                                eVar.d("ShortVideoComposerCore", "targetTimestampMs " + j5 + " has exceeded video end, exit.");
                                break;
                            }
                            PLVideoFrame a2 = k.this.f.a(j5, false, i2, i3);
                            if (a2 != null) {
                                com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.t;
                                eVar2.b("ShortVideoComposerCore", "adding picture timestamp:" + j5 + ", width:" + i2 + ", height:" + i3);
                                arrayList.add(a2.toBitmap());
                            } else {
                                com.qiniu.pili.droid.shortvideo.f.e eVar3 = com.qiniu.pili.droid.shortvideo.f.e.t;
                                eVar3.d("ShortVideoComposerCore", "cannot find picture at timestamp:" + j5);
                            }
                            i5 = i6 + 1;
                        }
                        com.qiniu.pili.droid.shortvideo.f.e.t.c("ShortVideoComposerCore", "composing bitmaps to gif...");
                        k.this.a(arrayList, (int) j4, z, str2, pLVideoSaveListener);
                        k.this.f.a();
                    }
                }).start();
                com.qiniu.pili.droid.shortvideo.f.e.t.c("ShortVideoComposerCore", "extractVideoToGIF - ");
            }
        }
    }

    public void a(List<Bitmap> list, int i, boolean z, String str, PLVideoSaveListener pLVideoSaveListener) {
        if (u.a().a(b.a.compose_gif, pLVideoSaveListener)) {
            a aVar = new a(list, i, z, str, pLVideoSaveListener);
            this.b = aVar;
            aVar.run();
        }
    }

    public boolean a(List<String> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        if (u.a().a(b.a.compose_video, pLVideoSaveListener)) {
            if (this.f13878c == null) {
                this.f13878c = new com.qiniu.pili.droid.shortvideo.process.a.b();
            }
            return this.f13878c.a(list, str, pLVideoEncodeSetting, pLVideoSaveListener);
        }
        return false;
    }

    public boolean a(List<PLComposeItem> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, String str2, float f, float f2, PLVideoSaveListener pLVideoSaveListener) {
        synchronized (this) {
            if (u.a().a(b.a.compose_item, pLVideoSaveListener)) {
                if (this.e == null) {
                    this.e = new com.qiniu.pili.droid.shortvideo.process.a.a();
                }
                return this.e.a(list, str, pLVideoEncodeSetting, str2, f, f2, pLVideoSaveListener);
            }
            return false;
        }
    }

    public boolean a(List<PLComposeItem> list, String str, boolean z, String str2, PLDisplayMode pLDisplayMode, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        if (u.a().a(b.a.compose_image, pLVideoSaveListener)) {
            if (this.d == null) {
                this.d = new com.qiniu.pili.droid.shortvideo.transcoder.a();
            }
            return this.d.a(list, str, z, str2, pLDisplayMode, pLVideoEncodeSetting, pLVideoSaveListener);
        }
        return false;
    }

    public void b() {
        com.qiniu.pili.droid.shortvideo.process.a.b bVar = this.f13878c;
        if (bVar != null) {
            bVar.a();
        }
    }

    public boolean b(List<PLVideoRange> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        if (u.a().a(b.a.compose_trim_video, pLVideoSaveListener)) {
            if (this.f13878c == null) {
                this.f13878c = new com.qiniu.pili.droid.shortvideo.process.a.b();
            }
            return this.f13878c.b(list, str, pLVideoEncodeSetting, pLVideoSaveListener);
        }
        return false;
    }

    public void c() {
        com.qiniu.pili.droid.shortvideo.process.a.a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void d() {
        com.qiniu.pili.droid.shortvideo.transcoder.a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }
}
