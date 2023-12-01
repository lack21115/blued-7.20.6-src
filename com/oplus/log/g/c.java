package com.oplus.log.g;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.oplus.log.core.e;
import com.oplus.log.g.d;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import java.io.File;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private com.oplus.log.g.a f24374a;
    private com.oplus.log.c b;

    /* renamed from: c  reason: collision with root package name */
    private com.oplus.log.a f24375c = new com.oplus.log.f.a();
    private int d = 0;
    private f e;
    private g f;
    private b g;
    private String h;
    private com.oplus.log.a.a i;

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f24379a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        long f24380c;
        long d;
        boolean e;
        String f;
        String g;
        String h;
        String i;
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g/c$b.class */
    public interface b {
        void a(com.oplus.log.g.b bVar);

        void a(String str, a aVar);
    }

    /* renamed from: com.oplus.log.g.c$c  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g/c$c.class */
    public static class C0614c {

        /* renamed from: a  reason: collision with root package name */
        String f24381a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        long f24382c;
        long d;
        boolean e;
        String f;

        public C0614c(String str, long j, long j2, boolean z, String str2, String str3) {
            this.f24381a = str;
            this.f24382c = j;
            this.d = j2;
            this.e = z;
            this.f = str2;
            this.b = str3;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g/c$d.class */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        String f24383a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        e f24384c;

        d(String str, String str2) {
            this.b = str;
            this.f24383a = str2;
        }

        void a(e eVar) {
            this.f24384c = eVar;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g/c$e.class */
    public interface e {
        void a(UserTraceConfigDto userTraceConfigDto);

        void a(String str);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g/c$f.class */
    public class f extends Handler {
        f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.obj instanceof C0614c) {
                c.this.a((C0614c) message.obj);
            } else if (message.obj instanceof a) {
                c.this.a((a) message.obj);
            } else if (message.obj instanceof d) {
                d dVar = (d) message.obj;
                c.this.b(dVar.b, dVar.f24383a, dVar.f24384c);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g/c$g.class */
    public interface g {
        void a();

        void a(String str);
    }

    public c(com.oplus.log.c cVar) {
        this.h = null;
        this.b = cVar == null ? new com.oplus.log.c() : cVar;
        this.h = this.b.f() + File.separator + ".zip";
        if (this.b.k() != null) {
            this.f24374a = this.b.k();
        }
        a();
    }

    private void a() {
        HandlerThread handlerThread = new HandlerThread(getClass().getName());
        handlerThread.start();
        this.e = new f(handlerThread.getLooper());
    }

    private void a(com.oplus.log.g.b bVar) {
        this.d = 0;
        com.oplus.log.g.d.a(this.h);
        b bVar2 = this.g;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        if (!aVar.e || com.oplus.log.d.c.b()) {
            try {
                if (this.i != null) {
                    this.i.a(new e.b() { // from class: com.oplus.log.g.c.2
                        @Override // com.oplus.log.core.e.b
                        public final void a() {
                            com.oplus.log.g.d.a(aVar.f24380c, aVar.d, c.this.b, c.this.h, aVar.f, new d.a() { // from class: com.oplus.log.g.c.2.1
                                @Override // com.oplus.log.g.d.a
                                public final void a(int i, File file) {
                                    c.this.a(aVar, i, file);
                                }

                                @Override // com.oplus.log.g.d.a
                                public final void a(int i, String str) {
                                    c.this.b(aVar, i, str);
                                }
                            });
                        }
                    });
                    return;
                }
                return;
            } catch (Exception e2) {
                b(aVar, -1, e2.toString());
                return;
            }
        }
        this.f24375c.b("report_log_info", "upload task need wifi connect");
        a(aVar, -121, "upload task need wifi connect");
        b bVar = this.g;
        if (bVar != null) {
            bVar.a("upload task need wifi connect", aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, int i, File file) {
        String str;
        String str2 = this.f24374a == null ? "report upload fail : HttpDelegate is null" : "";
        if (aVar == null) {
            str2 = "report upload fail : reportBody is null";
        }
        if (file == null) {
            str2 = "report upload fail : file is null";
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f24375c.c("report_log_info", str2);
            b bVar = this.g;
            if (bVar != null) {
                bVar.a(str2, aVar);
                return;
            }
            return;
        }
        try {
            try {
                try {
                    String a2 = com.oplus.log.g.a(aVar.f24379a, aVar.f, file.getName(), i, "", aVar.b, this.b.a(), this.b.b(), TextUtils.isEmpty(this.b.c()) ? com.oplus.log.d.b.b(com.oplus.log.d.b.a()) : this.b.c(), aVar.g, aVar.h, aVar.d, this.h, aVar.i, this.f24375c);
                    this.f24375c.a("NearX-HLog", "doReportUpload Code: ".concat(String.valueOf(a2)));
                    com.oplus.log.g.b a3 = this.f24374a.a(a2, file);
                    if (a3 != null && a3.a() == 200) {
                        a(a3);
                        return;
                    }
                    if (a3 == null) {
                        str = "report upload error:response is null";
                    } else {
                        str = "report upload error:response code is " + a3.a() + ", msg is " + a3.b();
                    }
                    try {
                        b(aVar, -110, str);
                    } catch (IOException e2) {
                        e = e2;
                        b(aVar, PackageManager.INSTALL_FAILED_USER_RESTRICTED, e.toString());
                        this.f24375c.c("report_log_info", "report upload network io exception:" + e.toString());
                        if (com.oplus.log.b.a()) {
                            e.printStackTrace();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        b(aVar, PackageManager.INSTALL_FAILED_USER_RESTRICTED, e.toString());
                        this.f24375c.c("report_log_info", "report upload network exception:" + e.toString());
                        if (com.oplus.log.b.a()) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (IOException e6) {
                e = e6;
            } catch (Exception e7) {
                e = e7;
            }
        } catch (IOException e8) {
            e = e8;
        } catch (Exception e9) {
            e = e9;
        }
    }

    private void a(a aVar, int i, String str) {
        com.oplus.log.a aVar2;
        String str2;
        if (this.f24374a == null) {
            aVar2 = this.f24375c;
            str2 = "upload code error : HttpDelegate is null";
        } else if (aVar != null) {
            try {
                String a2 = com.oplus.log.g.a(aVar.f24379a, aVar.f, "", i, str, aVar.b, this.b.a(), this.b.b(), TextUtils.isEmpty(this.b.c()) ? com.oplus.log.d.b.b(com.oplus.log.d.b.a()) : this.b.c(), aVar.g, aVar.h, aVar.d, this.h, aVar.i, this.f24375c);
                this.f24375c.a("NearX-HLog", "reportUpload Error Code: ".concat(String.valueOf(a2)));
                this.f24374a.a(a2);
                return;
            } catch (Exception e2) {
                com.oplus.log.a aVar3 = this.f24375c;
                aVar3.c("report_log_info", "upload code error:" + e2.toString());
                return;
            }
        } else {
            aVar2 = this.f24375c;
            str2 = "upload code error : UploadBody is null";
        }
        aVar2.c("report_log_info", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final C0614c c0614c) {
        if (!c0614c.e || com.oplus.log.d.c.b()) {
            try {
                if (this.i != null) {
                    this.i.a();
                }
                com.oplus.log.g.d.a(c0614c.f24382c, c0614c.d, this.b, this.h, c0614c.f, new d.a() { // from class: com.oplus.log.g.c.1
                    @Override // com.oplus.log.g.d.a
                    public final void a(int i, File file) {
                        c.this.a(c0614c, i, file);
                    }

                    @Override // com.oplus.log.g.d.a
                    public final void a(int i, String str) {
                        c.this.b(c0614c, i, str);
                    }
                });
                return;
            } catch (Exception e2) {
                b(c0614c, -1, e2.toString());
                return;
            }
        }
        this.f24375c.b("upload_log_info", "upload task need wifi connect");
        a(c0614c, -121, "upload task need wifi connect");
        g gVar = this.f;
        if (gVar != null) {
            gVar.a("upload task need wifi connect");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0614c c0614c, int i, File file) {
        String str;
        String str2 = this.f24374a == null ? "upload fail : HttpDelegate is null" : "";
        if (c0614c == null) {
            str2 = "upload fail : uploadBody is null";
        }
        if (file == null) {
            str2 = "upload fail : file is null";
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f24375c.c("upload_log_info", str2);
            g gVar = this.f;
            if (gVar != null) {
                gVar.a(str2);
                return;
            }
            return;
        }
        try {
            String a2 = com.oplus.log.g.a(c0614c.f24381a, c0614c.f, file.getName(), i, "", c0614c.b, this.b.a(), this.b.b(), TextUtils.isEmpty(this.b.c()) ? com.oplus.log.d.b.b(com.oplus.log.d.b.a()) : this.b.c());
            this.f24375c.a("NearX-HLog", "doUpload Code: ".concat(String.valueOf(a2)));
            com.oplus.log.g.b a3 = this.f24374a.a(a2, file);
            if (a3 != null && a3.a() == 200) {
                b();
                return;
            }
            if (a3 == null) {
                str = "upload error:response is null";
            } else {
                str = "upload error:response code is " + a3.a() + ", msg is " + a3.b();
            }
            b(c0614c, -110, str);
        } catch (IOException e2) {
            b(c0614c, PackageManager.INSTALL_FAILED_USER_RESTRICTED, e2.toString());
            this.f24375c.c("upload_log_info", "upload network io exception:" + e2.toString());
            if (com.oplus.log.b.a()) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            b(c0614c, PackageManager.INSTALL_FAILED_USER_RESTRICTED, e3.toString());
            this.f24375c.c("upload_log_info", "upload network exception:" + e3.toString());
            if (com.oplus.log.b.a()) {
                e3.printStackTrace();
            }
        }
    }

    private void a(C0614c c0614c, int i, String str) {
        com.oplus.log.a aVar;
        String str2;
        if (this.f24374a == null) {
            aVar = this.f24375c;
            str2 = "upload code error : HttpDelegate is null";
        } else if (c0614c != null) {
            try {
                String a2 = com.oplus.log.g.a(c0614c.f24381a, c0614c.f, "", i, str, c0614c.b, this.b.a(), this.b.b(), TextUtils.isEmpty(this.b.c()) ? com.oplus.log.d.b.b(com.oplus.log.d.b.a()) : this.b.c());
                this.f24375c.a("NearX-HLog", "upload Error Code: ".concat(String.valueOf(a2)));
                this.f24374a.a(a2);
                return;
            } catch (Exception e2) {
                com.oplus.log.a aVar2 = this.f24375c;
                aVar2.c("upload_log_info", "upload code error:" + e2.toString());
                if (com.oplus.log.b.a()) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        } else {
            aVar = this.f24375c;
            str2 = "upload code error : UploadBody is null";
        }
        aVar.c("upload_log_info", str2);
    }

    private void b() {
        this.d = 0;
        com.oplus.log.g.d.a(this.h);
        g gVar = this.f;
        if (gVar != null) {
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, int i, String str) {
        com.oplus.log.g.d.a(this.h);
        int i2 = this.d;
        if (i2 < 3) {
            int i3 = i2 + 1;
            this.d = i3;
            a(aVar, i3 * 2000);
            return;
        }
        this.f24375c.b("report_log_info", "report upload failed");
        this.d = 0;
        b bVar = this.g;
        if (bVar != null) {
            bVar.a("run out of retry:".concat(String.valueOf(str)), aVar);
        }
        a(aVar, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(C0614c c0614c, int i, String str) {
        com.oplus.log.g.d.a(this.h);
        int i2 = this.d;
        if (i2 < 3) {
            int i3 = i2 + 1;
            this.d = i3;
            a(c0614c, i3 * 2000);
            return;
        }
        this.f24375c.b("upload_log_info", "upload failed");
        this.d = 0;
        g gVar = this.f;
        if (gVar != null) {
            gVar.a("run out of retry:".concat(String.valueOf(str)));
        }
        a(c0614c, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, e eVar) {
        if (this.f24374a == null) {
            this.f24375c.c("upload_log_info", "check upload failed : HttpDelegate is null");
            return;
        }
        try {
            String a2 = com.oplus.log.g.a(str, str2, this.b.a(), this.b.b(), TextUtils.isEmpty(this.b.c()) ? com.oplus.log.d.b.b(com.oplus.log.d.b.a()) : this.b.c());
            this.f24375c.a("NearX-HLog", "doUploadChecker: ".concat(String.valueOf(a2)));
            UserTraceConfigDto b2 = this.f24374a.b(a2);
            if (b2 == null || (TextUtils.isEmpty(b2.getImei()) && TextUtils.isEmpty(b2.getOpenId()))) {
                if (eVar != null) {
                    eVar.a("userTraceConfigDto or device id is empty");
                }
            } else if (eVar != null) {
                this.f24375c.b("upload_log_info", "need upload log");
                eVar.a(b2);
            }
        } catch (Exception e2) {
            if (eVar != null) {
                eVar.a(e2.toString());
            }
        }
    }

    public void a(com.oplus.log.a.a aVar) {
        if (aVar != null) {
            this.i = aVar;
        }
    }

    public void a(a aVar, int i) {
        Message obtain = Message.obtain();
        obtain.obj = aVar;
        this.e.sendMessageDelayed(obtain, i);
    }

    public void a(C0614c c0614c, int i) {
        Message obtain = Message.obtain();
        obtain.obj = c0614c;
        this.e.sendMessageDelayed(obtain, i);
    }

    public void a(g gVar) {
        this.f = gVar;
    }

    public void a(String str, String str2, e eVar) {
        d dVar = new d(str, str2);
        dVar.a(eVar);
        Message obtain = Message.obtain();
        obtain.obj = dVar;
        this.e.sendMessage(obtain);
    }
}
