package com.tencent.thumbplayer.c.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLIOUtil;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.o;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/a/b.class */
public class b implements com.tencent.thumbplayer.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static String f39235a = "TPAssetResourceLoader";
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private ITPAssetResourceLoaderListener f39236c;
    private long d = 0;
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = ".mp4";
    private int i = 0;
    private ArrayList<d> j = new ArrayList<>();
    private TPAssetResourceLoadingContentInformationRequest k;
    private HandlerThread l;
    private HandlerThread m;
    private a n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/a/b$a.class */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        private void a(long j, long j2, String str, int i, int i2) {
            d dVar = new d(j, j2, i2, a(j, j2));
            dVar.a(b.this.m.getLooper());
            dVar.a(b.this.b(i, str));
            dVar.a(b.this.k);
            if (b.this.f39236c.shouldWaitForLoadingOfRequestedResource(dVar)) {
                b.this.a(dVar);
                TPLogUtil.i(b.f39235a, "add to mLoadingRequests, requestId: ".concat(String.valueOf(i2)));
            }
        }

        private boolean a(long j, long j2) {
            boolean z = b.this.d > 0 && j2 + j >= b.this.d;
            if (z) {
                b.this.f();
            }
            return z;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = b.f39235a;
            TPLogUtil.d(str, "mCallbackForResourceLoaderHandler msg : " + message.what);
            if (b.this.f39236c == null) {
                return;
            }
            int i = message.what;
            if (i != 256) {
                if (i != 257) {
                    return;
                }
                TPLogUtil.i(b.f39235a, "stop read data");
                b.this.b(message.arg1);
                return;
            }
            TPLogUtil.i(b.f39235a, "start read data");
            C1015b c1015b = (C1015b) message.obj;
            long j = c1015b.f39238a;
            long j2 = c1015b.b;
            String str2 = c1015b.f39239c;
            int i2 = message.arg1;
            int i3 = message.arg2;
            String str3 = b.f39235a;
            TPLogUtil.i(str3, "start read data, requestStart: " + j + " requestEnd:" + j2 + " requestId:" + i3);
            long a2 = b.this.a(j, j2);
            if (a2 <= 0) {
                TPLogUtil.e(b.f39235a, "requestLength invalid, check requestStart and requestEnd");
            } else {
                a(j, a2, str2, i2, i3);
            }
        }
    }

    /* renamed from: com.tencent.thumbplayer.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/a/b$b.class */
    static class C1015b {

        /* renamed from: a  reason: collision with root package name */
        long f39238a;
        long b;

        /* renamed from: c  reason: collision with root package name */
        String f39239c;

        private C1015b() {
        }
    }

    public b(Context context, Looper looper) {
        this.b = context;
        Looper looper2 = looper;
        if (looper == null) {
            HandlerThread b = o.a().b();
            this.l = b;
            looper2 = b.getLooper();
        }
        this.n = new a(looper2);
        this.m = o.a().a("TPAssetResourceLoader-dataWriteThread");
    }

    private int a(long j) {
        synchronized (this) {
            if (this.j == null) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                i = Math.max(i, this.j.get(i2).a(j));
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(long j, long j2) {
        if (j2 > 0) {
            return j2 - j;
        }
        long j3 = this.d;
        if (j3 <= 0) {
            return 536870912L;
        }
        return j3 - j;
    }

    private d a(int i) {
        synchronized (this) {
            if (this.j == null) {
                return null;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.j.size()) {
                    return null;
                }
                d dVar = this.j.get(i3);
                if (dVar.getLoadingDataRequest().a() == i) {
                    return dVar;
                }
                i2 = i3 + 1;
            }
        }
    }

    private String a(Context context, int i) {
        if (TextUtils.isEmpty(this.g)) {
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            File externalCacheFile = TPDLFileSystem.getExternalCacheFile(context, "resourceLoader", format + "-" + i + this.h);
            TPDLIOUtil.createFile(externalCacheFile);
            this.g = externalCacheFile.getAbsolutePath();
        }
        return this.g;
    }

    private void a(int i, int i2, int i3, Object obj) {
        a aVar = this.n;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
            obtainMessage.obj = obj;
            this.n.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        synchronized (this) {
            if (this.j != null) {
                this.j.add(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        d a2 = a(i);
        if (a2 != null) {
            a2.b();
            TPLogUtil.i(f39235a, "handleStopReadData, cancel the loading request with id ".concat(String.valueOf(i)));
            b(a2);
            this.f39236c.didCancelLoadingRequest(a2);
            return;
        }
        String str = f39235a;
        TPLogUtil.e(str, "TPAssetLoader can't find the request " + i + " with current loading requests");
    }

    private void b(d dVar) {
        synchronized (this) {
            if (this.j != null) {
                this.j.remove(dVar);
            }
        }
    }

    private String e() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        synchronized (this) {
            if (this.j != null) {
                Iterator<d> it = this.j.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.b();
                    this.f39236c.didCancelLoadingRequest(next);
                }
                this.j.clear();
            }
        }
    }

    @Override // com.tencent.thumbplayer.c.a.a
    public int a(int i, String str, int i2) {
        if (this.f39236c == null) {
            TPLogUtil.e(f39235a, "listener not set");
            return 0;
        }
        a(257, i2, 0, (Object) null);
        return 0;
    }

    @Override // com.tencent.thumbplayer.c.a.a
    public int a(int i, String str, long j, long j2) {
        if (this.f39236c == null) {
            TPLogUtil.e(f39235a, "listener not set");
            return 0;
        }
        String str2 = f39235a;
        TPLogUtil.i(str2, "onStartReadData, fileId:" + i + ", fileKey:" + str + ", requestStart:" + j + ", requestEnd:" + j2);
        int i2 = this.i + 1;
        C1015b c1015b = new C1015b();
        c1015b.f39238a = j;
        c1015b.b = j2;
        c1015b.f39239c = str;
        a(256, i, i2, c1015b);
        this.i = i2;
        return i2;
    }

    @Override // com.tencent.thumbplayer.c.a.a
    public long a(int i, String str) {
        return this.d;
    }

    @Override // com.tencent.thumbplayer.c.a.a
    public void a() {
        if (this.f39236c == null) {
            TPLogUtil.e(f39235a, "listener not set");
            return;
        }
        TPAssetResourceLoadingContentInformationRequest tPAssetResourceLoadingContentInformationRequest = new TPAssetResourceLoadingContentInformationRequest();
        this.k = tPAssetResourceLoadingContentInformationRequest;
        this.f39236c.fillInContentInformation(tPAssetResourceLoadingContentInformationRequest);
        this.e = this.k.contentType;
        this.d = this.k.dataTotalSize;
        this.f = this.k.dataFilePath;
        String str = f39235a;
        TPLogUtil.i(str, "proxy start, mDataTotalSize: " + this.d + " businessPath:" + this.f);
    }

    @Override // com.tencent.thumbplayer.c.a.a
    public void a(ITPAssetResourceLoaderListener iTPAssetResourceLoaderListener) {
        this.f39236c = iTPAssetResourceLoaderListener;
    }

    @Override // com.tencent.thumbplayer.c.a.a
    public int b(int i, String str, long j, long j2) {
        String str2 = f39235a;
        TPLogUtil.d(str2, "read data, offset:" + j + ", length:" + j2);
        int min = (int) Math.min((long) a(j), j2);
        if (min <= 0) {
            return -1;
        }
        String str3 = f39235a;
        TPLogUtil.d(str3, "on read data, fileId: " + i + " readOffset: " + j + " readLength:" + j2 + " readyLength:" + min);
        return min;
    }

    @Override // com.tencent.thumbplayer.c.a.a
    public String b(int i, String str) {
        String e = e();
        return !TextUtils.isEmpty(e) ? e : a(this.b, i);
    }

    @Override // com.tencent.thumbplayer.c.a.a
    public void b() {
        TPLogUtil.i(f39235a, "reset start");
        f();
        this.d = 0L;
        this.e = "";
        this.f = "";
        if (!TextUtils.isEmpty(this.g)) {
            try {
                new File(this.g).deleteOnExit();
                this.g = "";
            } catch (Exception e) {
                String str = f39235a;
                TPLogUtil.e(str, "reset, delete cache file has exception:" + e.toString());
            }
        }
        a aVar = this.n;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.thumbplayer.c.a.a
    public String c(int i, String str) {
        return this.e;
    }

    @Override // com.tencent.thumbplayer.c.a.a
    public void c() {
        TPLogUtil.i(f39235a, "release start");
        b();
        o.a().a(this.l, this.n);
        o.a().a(this.m, (Handler) null);
        this.l = null;
        this.m = null;
        this.n = null;
        this.j = null;
    }
}
