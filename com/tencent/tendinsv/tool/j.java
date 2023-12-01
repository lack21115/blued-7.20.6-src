package com.tencent.tendinsv.tool;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.TraceLogger;
import com.tencent.tendinsv.listener.InitCallbacks;
import com.tencent.tendinsv.utils.t;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39068a = "Unknown_Operator";
    private static volatile j b;

    /* renamed from: c  reason: collision with root package name */
    private InitCallbacks f39069c;
    private String d;
    private Context e;
    private ExecutorService f;
    private ExecutorService g;

    private j() {
    }

    public static j a() {
        if (b == null) {
            synchronized (j.class) {
                try {
                    if (b == null) {
                        b = new j();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private void a(int i, long j, long j2, long j3) {
        String a2 = com.tencent.tendinsv.utils.b.a();
        String a3 = h.a(this.e);
        String b2 = h.b(this.e);
        String str = Build.BRAND + "|" + Build.VERSION.RELEASE + "|" + Build.MODEL;
        HashMap hashMap = new HashMap();
        hashMap.put("appId", this.d);
        hashMap.put("client", "2");
        hashMap.put("bundleld", "");
        hashMap.put("packageName", a3);
        hashMap.put("randoms", a2);
        hashMap.put("device", str);
        hashMap.put("version", com.tencent.tendinsv.b.ao);
        hashMap.put("packageSign", b2);
        String a4 = com.tencent.tendinsv.b.f38998ar == 0 ? com.tencent.tendinsv.utils.a.a(hashMap, com.tencent.tendinsv.utils.a.a(this.d)) : "";
        long currentTimeMillis = System.currentTimeMillis();
        String a5 = new com.tencent.tendinsv.utils.m().a();
        com.tencent.tendinsv.b.ak = (int) (System.currentTimeMillis() - currentTimeMillis);
        if (a5 != null) {
            com.tencent.tendinsv.b.y = "https://" + a5 + com.tencent.tendinsv.b.z;
            com.tencent.tendinsv.b.A = "https://" + a5 + com.tencent.tendinsv.b.B;
        }
        a(b2, a2, a3, a4, i, str, j, j2, j3);
    }

    private void a(String str, String str2, String str3, String str4, final int i, String str5, final long j, final long j2, final long j3) {
        Map<String, String> a2;
        com.tencent.tendinsv.d.b bVar;
        if (com.tencent.tendinsv.b.f38998ar == 0) {
            a2 = com.tencent.tendinsv.d.g.a().a(str, this.d, str2, str3, str4, str5);
            bVar = new com.tencent.tendinsv.d.b(com.tencent.tendinsv.b.y, this.e);
        } else {
            a2 = com.tencent.tendinsv.d.g.a().a(str, this.d, str2, str3, str5);
            bVar = new com.tencent.tendinsv.d.b(com.tencent.tendinsv.b.A, this.e);
        }
        final Map<String, String> map = a2;
        bVar.a(a2, new com.tencent.tendinsv.d.a() { // from class: com.tencent.tendinsv.tool.j.3
            @Override // com.tencent.tendinsv.d.c
            public void a(int i2, String str6) {
                InitCallbacks initCallbacks = j.this.f39069c;
                initCallbacks.initFailed(1007, i2, "getOperatorInfo()__onFailure==" + str6, str6, i, j, j2, j3);
            }

            /* JADX WARN: Removed duplicated region for block: B:88:0x0415 A[Catch: Exception -> 0x061a, TryCatch #0 {Exception -> 0x061a, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x000c, B:7:0x002d, B:9:0x0034, B:11:0x0051, B:13:0x005f, B:15:0x01ea, B:17:0x01f4, B:19:0x0229, B:21:0x0231, B:23:0x0241, B:25:0x0247, B:27:0x0257, B:29:0x025d, B:31:0x026d, B:33:0x0273, B:35:0x0283, B:37:0x0289, B:39:0x0299, B:41:0x02a8, B:43:0x02b2, B:45:0x02cd, B:47:0x02e5, B:48:0x030a, B:50:0x032a, B:52:0x0330, B:54:0x0342, B:56:0x0348, B:58:0x035a, B:60:0x0360, B:62:0x0373, B:64:0x0379, B:66:0x038c, B:68:0x0392, B:70:0x03a5, B:72:0x03ab, B:74:0x03be, B:76:0x03c4, B:78:0x03d7, B:80:0x03dd, B:83:0x03ea, B:86:0x040f, B:88:0x0415, B:90:0x0428, B:92:0x042e, B:94:0x0437, B:97:0x0450, B:99:0x045a, B:101:0x0463, B:103:0x04ca, B:105:0x04e3, B:111:0x055a, B:111:0x055a, B:112:0x055d, B:106:0x04f3, B:108:0x04fb, B:110:0x0504, B:95:0x0441, B:84:0x03fe, B:114:0x05a1, B:116:0x05c8, B:118:0x05f1), top: B:124:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:92:0x042e A[Catch: Exception -> 0x061a, TryCatch #0 {Exception -> 0x061a, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x000c, B:7:0x002d, B:9:0x0034, B:11:0x0051, B:13:0x005f, B:15:0x01ea, B:17:0x01f4, B:19:0x0229, B:21:0x0231, B:23:0x0241, B:25:0x0247, B:27:0x0257, B:29:0x025d, B:31:0x026d, B:33:0x0273, B:35:0x0283, B:37:0x0289, B:39:0x0299, B:41:0x02a8, B:43:0x02b2, B:45:0x02cd, B:47:0x02e5, B:48:0x030a, B:50:0x032a, B:52:0x0330, B:54:0x0342, B:56:0x0348, B:58:0x035a, B:60:0x0360, B:62:0x0373, B:64:0x0379, B:66:0x038c, B:68:0x0392, B:70:0x03a5, B:72:0x03ab, B:74:0x03be, B:76:0x03c4, B:78:0x03d7, B:80:0x03dd, B:83:0x03ea, B:86:0x040f, B:88:0x0415, B:90:0x0428, B:92:0x042e, B:94:0x0437, B:97:0x0450, B:99:0x045a, B:101:0x0463, B:103:0x04ca, B:105:0x04e3, B:111:0x055a, B:111:0x055a, B:112:0x055d, B:106:0x04f3, B:108:0x04fb, B:110:0x0504, B:95:0x0441, B:84:0x03fe, B:114:0x05a1, B:116:0x05c8, B:118:0x05f1), top: B:124:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:95:0x0441 A[Catch: Exception -> 0x061a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x061a, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x000c, B:7:0x002d, B:9:0x0034, B:11:0x0051, B:13:0x005f, B:15:0x01ea, B:17:0x01f4, B:19:0x0229, B:21:0x0231, B:23:0x0241, B:25:0x0247, B:27:0x0257, B:29:0x025d, B:31:0x026d, B:33:0x0273, B:35:0x0283, B:37:0x0289, B:39:0x0299, B:41:0x02a8, B:43:0x02b2, B:45:0x02cd, B:47:0x02e5, B:48:0x030a, B:50:0x032a, B:52:0x0330, B:54:0x0342, B:56:0x0348, B:58:0x035a, B:60:0x0360, B:62:0x0373, B:64:0x0379, B:66:0x038c, B:68:0x0392, B:70:0x03a5, B:72:0x03ab, B:74:0x03be, B:76:0x03c4, B:78:0x03d7, B:80:0x03dd, B:83:0x03ea, B:86:0x040f, B:88:0x0415, B:90:0x0428, B:92:0x042e, B:94:0x0437, B:97:0x0450, B:99:0x045a, B:101:0x0463, B:103:0x04ca, B:105:0x04e3, B:111:0x055a, B:111:0x055a, B:112:0x055d, B:106:0x04f3, B:108:0x04fb, B:110:0x0504, B:95:0x0441, B:84:0x03fe, B:114:0x05a1, B:116:0x05c8, B:118:0x05f1), top: B:124:0x0000 }] */
            @Override // com.tencent.tendinsv.d.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a(java.lang.String r14) {
                /*
                    Method dump skipped, instructions count: 1666
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.tendinsv.tool.j.AnonymousClass3.a(java.lang.String):void");
            }
        }, false, "");
    }

    private void d() {
        String b2 = t.b(this.e, "sdkVersion", "");
        if (com.tencent.tendinsv.utils.d.a(b2) || !com.tencent.tendinsv.b.ao.equals(b2)) {
            t.a(this.e, "sdkVersion", com.tencent.tendinsv.b.ao);
            e();
            com.tencent.tendinsv.c.e.a().a(this.e);
        }
    }

    private void e() {
        t.a(this.e, t.y, 0L);
        t.a(this.e, t.S, false);
    }

    public void a(int i, long j, long j2) {
        InitCallbacks initCallbacks;
        int i2;
        int i3;
        String str;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.H, "initStart--processName=", Integer.valueOf(i));
            com.tencent.tendinsv.b.V.set(com.tencent.tendinsv.b.U);
            this.f39069c = new com.tencent.tendinsv.c.c(this.e);
            boolean b2 = t.b(this.e, t.S, false);
            com.tencent.tendinsv.utils.h.a().a(this.e, b2, i, j, j2, uptimeMillis);
            String b3 = t.b(this.e, "appId", "");
            String b4 = t.b(this.e, t.h, "");
            if (!com.tencent.tendinsv.utils.d.a(this.d)) {
                try {
                    if (b2 && !com.tencent.tendinsv.utils.d.a(b3) && this.d.equals(b4)) {
                        long b5 = t.b(this.e, t.J, SystemClock.uptimeMillis());
                        long b6 = t.b(this.e, t.y, (long) com.anythink.expressad.d.a.b.P);
                        String b7 = t.b(this.e, t.E, "0");
                        if (!com.tencent.tendinsv.utils.d.b(b7) || !"1".equals(b7)) {
                            this.f39069c.initSuccessed(1022, 1022, com.tencent.tendinsv.b.ay, "cache", i, j, j2, uptimeMillis);
                            if ((SystemClock.uptimeMillis() - b5) / 1000 < b6) {
                                this.f39069c.initSuccessed(1022, 1022, com.tencent.tendinsv.b.ay, "cache", i, j, j2, uptimeMillis);
                                return;
                            } else {
                                a(i, j, j2, uptimeMillis);
                                return;
                            }
                        }
                        com.tencent.tendinsv.b.av = false;
                        initCallbacks = this.f39069c;
                        i2 = 1032;
                        i3 = 1032;
                        str = "用户被禁用";
                    }
                    t.a(this.e, t.h, this.d);
                    a(i, j, j2, uptimeMillis);
                    return;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "initStart--Exception_e=", e);
                    this.f39069c.initFailed(1014, 1014, "initStart--Exception_e=" + e, e.getClass().getSimpleName(), i, j, j2, uptimeMillis);
                    return;
                }
            }
            initCallbacks = this.f39069c;
            i2 = 1016;
            i3 = 1016;
            str = "AppId为空";
            initCallbacks.initFailed(i2, i3, str, "check_error", i, j, j2, uptimeMillis);
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void a(final Context context, String str, ExecutorService executorService) {
        this.d = str;
        this.e = context;
        this.g = executorService;
        m.a(context);
        l.a().a(context, executorService);
        i.a().a(context, str);
        c.a().a(context, str, executorService);
        g.a().a(context, str);
        d();
        com.tencent.tendinsv.utils.e.a(new Runnable() { // from class: com.tencent.tendinsv.tool.j.2
            @Override // java.lang.Runnable
            public void run() {
                k.a().a(context);
            }
        });
    }

    public void b() {
        Runnable runnable = new Runnable() { // from class: com.tencent.tendinsv.tool.j.1
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f == null || j.this.f.isShutdown()) {
                    j.this.f = new ThreadPoolExecutor(8, Integer.MAX_VALUE, 120L, TimeUnit.SECONDS, new LinkedBlockingDeque());
                }
                j.this.f.execute(new com.tencent.tendinsv.utils.n().a());
                t.a(j.this.e, "uuid", "");
                Process.setThreadPriority(-20);
                j.this.a(1, System.currentTimeMillis(), SystemClock.uptimeMillis());
            }
        };
        if (com.tencent.tendinsv.b.U != com.tencent.tendinsv.b.V.getAndSet(com.tencent.tendinsv.b.U)) {
            this.g.execute(runnable);
        } else {
            com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "Initialization is in progress");
        }
    }

    public void c() {
        try {
            String b2 = t.b(this.e, t.m, "");
            String b3 = t.b(this.e, t.q, "");
            if (com.tencent.tendinsv.b.D) {
                CtAuth.getInstance().init(this.e, b2, b3, new TraceLogger() { // from class: com.tencent.tendinsv.tool.j.4
                    @Override // cn.com.chinatelecom.account.api.TraceLogger
                    public void debug(String str, String str2) {
                        com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.I, "debug--S==", str, "_S1==", str2);
                    }

                    @Override // cn.com.chinatelecom.account.api.TraceLogger
                    public void info(String str, String str2) {
                        com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.I, "info--S==", str, "_S1==", str2);
                    }

                    @Override // cn.com.chinatelecom.account.api.TraceLogger
                    public void warn(String str, String str2, Throwable th) {
                        com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.I, "warn--S==", str, "_S1==", str2, "_Throwable==", th);
                    }
                });
            } else {
                CtAuth.getInstance().init(this.e, b2, b3, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.I, "Throwable--t", th);
        }
    }
}
