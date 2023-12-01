package com.opos.mobad.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadConfig;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a.class */
public class a {
    private static volatile a b;

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f25945c = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private Context f25946a;
    private com.opos.cmn.func.dl.a d;
    private b e;
    private InterfaceC0689a f;
    private ConcurrentHashMap<String, DownloadRequest> g = new ConcurrentHashMap<>();
    private boolean h = false;
    private AtomicBoolean i = new AtomicBoolean(false);

    /* renamed from: com.opos.mobad.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a$a.class */
    public interface InterfaceC0689a {
        void a(String str);

        void a(String str, int i, long j, long j2);

        void a(String str, long j, long j2);

        void b(String str);

        void b(String str, long j, long j2);

        void c(String str);

        void c(String str, long j, long j2);

        void d(String str, long j, long j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a$b.class */
    public class b implements com.opos.cmn.func.dl.base.b {
        private b() {
        }

        private boolean a(DownloadRequest downloadRequest) {
            return (downloadRequest == null || TextUtils.isEmpty(downloadRequest.f24869a) || !a.this.g.containsKey(downloadRequest.f24869a)) ? false : true;
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null) {
                return;
            }
            a.this.f.a(downloadRequest.f24869a, downloadResponse.f24874c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "fail exception:" + dlException);
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null || dlException == null) {
                return;
            }
            if (dlException.a() == 1013) {
                a.this.f.c(downloadRequest.f24869a);
            } else {
                a.this.f.a(downloadRequest.f24869a, dlException.a(), downloadResponse.f24874c, downloadResponse.d);
            }
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void b(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null) {
                return;
            }
            a.this.f.b(downloadRequest.f24869a, downloadResponse.f24874c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void c(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null) {
                return;
            }
            a.this.f.b(downloadRequest.f24869a, downloadResponse.f24874c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void d(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null) {
                return;
            }
            a.this.f.c(downloadRequest.f24869a, downloadResponse.f24874c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void e(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null) {
                return;
            }
            a.this.f.d(downloadRequest.f24869a, downloadResponse.f24874c, downloadResponse.d);
            a.this.f(downloadRequest.f24869a);
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void f(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "complete ");
            if (!a(downloadRequest) || a.this.f == null) {
                return;
            }
            a.this.f.b(downloadRequest.f24869a);
            a.this.f(downloadRequest.f24869a);
        }
    }

    private a(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.f25946a = applicationContext;
        this.d = new com.opos.cmn.func.dl.a(applicationContext);
        this.e = new b();
    }

    public static a a(Context context) {
        if (b == null) {
            synchronized (f25945c) {
                if (b == null) {
                    b = new a(context);
                }
            }
        }
        return b;
    }

    private void b() {
        if (this.i.get()) {
            return;
        }
        a(3, (InterfaceC0689a) null);
    }

    private void e(String str) {
        if (com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.d.b.a.b(str)) {
            return;
        }
        com.opos.cmn.an.d.b.a.f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g.remove(str);
    }

    public int a(final String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "add to download but url is empty");
            return -1;
        }
        try {
            b();
            com.opos.cmn.an.f.a.b("DownloadApkTool", "add download request:" + str);
            if (!this.h && !"WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(this.f25946a))) {
                this.h = true;
            }
            DownloadRequest.a c2 = new DownloadRequest.a(str).a(this.h).b(com.opos.cmn.d.a.b(this.f25946a)).c(com.opos.cmn.d.b.a(str)).b(false).c(true);
            if (!TextUtils.isEmpty(str2)) {
                c2.a(str2);
            }
            DownloadRequest a2 = c2.a(this.f25946a);
            this.g.put(str, a2);
            this.d.a(a2);
            if (this.f != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opos.mobad.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f != null) {
                            a.this.f.a(str);
                        }
                    }
                });
            }
            return a2.f;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloadApkTool", "", (Throwable) e);
            return -1;
        }
    }

    public void a() {
        try {
            this.d.b(this.e);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloadApkTool", "", (Throwable) e);
        }
    }

    public void a(int i, InterfaceC0689a interfaceC0689a) {
        if (this.i.compareAndSet(false, true)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "init download apk manager");
            this.f = interfaceC0689a;
            e(com.opos.cmn.d.a.b(this.f25946a));
            DownloadConfig downloadConfig = new DownloadConfig();
            downloadConfig.a(i).a(true).a(0.005f, 1000, 524288);
            this.d.a(downloadConfig);
            this.d.a(this.e);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "addMobileTask but url is empty");
            return;
        }
        b();
        this.h = true;
        com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.b(downloadRequest);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download but url is empty");
            return;
        }
        b();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.c(downloadRequest);
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "cancel download but url is empty");
            return;
        }
        b();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "cancel download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.d(downloadRequest);
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "resume download but url is empty");
            return;
        }
        b();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "resume download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.a(downloadRequest);
        }
    }
}
