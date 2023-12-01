package com.opos.cmn.biz.monitor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.opos.cmn.biz.monitor.MonitorEvent;
import com.opos.cmn.biz.monitor.b;
import com.opos.cmn.biz.monitor.b.e;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f24619a;
    private static volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.cmn.biz.monitor.b.a f24620c;
    private com.opos.cmn.biz.monitor.b.a d = new com.opos.cmn.biz.monitor.b.d();

    private a() {
    }

    public static a a() {
        a aVar;
        if (f24619a != null) {
            return f24619a;
        }
        synchronized (a.class) {
            try {
                if (f24619a != null) {
                    aVar = f24619a;
                } else {
                    f24619a = new a();
                    aVar = f24619a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private void a(final Context context, final String str, boolean z, long j) {
        b(context);
        final boolean a2 = e.a(str);
        boolean z2 = a2 || z;
        com.opos.cmn.an.f.a.b("MonitorManager", "send request url:" + str + ", isMixIn:" + a2 + ", isNeedTry:" + z + ", delayMill: " + j);
        final com.opos.cmn.biz.monitor.a.d dVar = new com.opos.cmn.biz.monitor.a.d(str);
        if (z2) {
            com.opos.cmn.biz.monitor.a.c.a().a(dVar);
        }
        final boolean z3 = z2;
        final Runnable runnable = new Runnable() { // from class: com.opos.cmn.biz.monitor.a.1
            @Override // java.lang.Runnable
            public void run() {
                new com.opos.cmn.biz.monitor.b.e(context, str, 3, a.this.b(), new e.a() { // from class: com.opos.cmn.biz.monitor.a.1.1
                    @Override // com.opos.cmn.biz.monitor.b.e.a
                    public void a() {
                        com.opos.cmn.an.f.a.b("MonitorManager", "onFail: " + str);
                        if (a2) {
                            com.opos.cmn.biz.monitor.a.c.a().a(true);
                        }
                    }

                    @Override // com.opos.cmn.biz.monitor.b.e.a
                    public void a(byte[] bArr) {
                        com.opos.cmn.an.f.a.b("MonitorManager", "onSuccess: " + str);
                        if (z3) {
                            if (a2) {
                                com.opos.cmn.an.f.a.b("MonitorManager", "mixIn monitor, remove cache");
                                if (!com.opos.cmn.biz.monitor.b.e.a(bArr)) {
                                    com.opos.cmn.an.f.a.b("MonitorManager", "request success but response fail");
                                }
                            } else {
                                com.opos.cmn.an.f.a.b("MonitorManager", "needTry monitor, remove cache");
                            }
                            com.opos.cmn.biz.monitor.a.c.a().b(dVar);
                        }
                        com.opos.cmn.biz.monitor.a.c.a().b();
                    }
                }).a();
            }
        };
        if (j <= 0) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.j.b.a().execute(runnable);
                }
            }, j);
        }
    }

    private void b(Context context) {
        if (b) {
            return;
        }
        a(context);
    }

    public void a(Context context) {
        a(context, null);
    }

    public void a(Context context, d dVar) {
        if (context == null) {
            com.opos.cmn.an.f.a.d("MonitorManager", "init monitor failed, context can not be null");
        } else if (b) {
        } else {
            com.opos.cmn.biz.monitor.a.c.a().a(context);
            b = true;
        }
    }

    public void a(Context context, String str, MonitorEvent monitorEvent) {
        b(context);
        a(context, str, monitorEvent, new b.a().a(true).a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
        if (r11.f24642a != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r8, java.lang.String r9, com.opos.cmn.biz.monitor.MonitorEvent r10, com.opos.cmn.biz.monitor.b r11) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r0.b(r1)
            r0 = r8
            if (r0 != 0) goto L13
            java.lang.String r0 = "report with context null"
            r8 = r0
        Lc:
            java.lang.String r0 = "MonitorManager"
            r1 = r8
            com.opos.cmn.an.f.a.d(r0, r1)
            return
        L13:
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L20
            java.lang.String r0 = "report with url null"
            r8 = r0
            goto Lc
        L20:
            r0 = r10
            r15 = r0
            r0 = r10
            if (r0 != 0) goto L3a
            java.lang.String r0 = "MonitorManager"
            java.lang.String r1 = "report with monitor event null"
            com.opos.cmn.an.f.a.b(r0, r1)
            com.opos.cmn.biz.monitor.MonitorEvent$b r0 = new com.opos.cmn.biz.monitor.MonitorEvent$b
            r1 = r0
            r1.<init>()
            com.opos.cmn.biz.monitor.MonitorEvent r0 = r0.a()
            r15 = r0
        L3a:
            r0 = r11
            if (r0 == 0) goto L49
            r0 = r9
            r10 = r0
            r0 = r11
            boolean r0 = r0.f24642a
            if (r0 == 0) goto L54
        L49:
            r0 = r8
            r1 = r9
            r2 = r15
            com.opos.cmn.biz.monitor.e$a r0 = com.opos.cmn.biz.monitor.e.a(r0, r1, r2)
            java.lang.String r0 = r0.f24663a
            r10 = r0
        L54:
            r0 = r11
            if (r0 == 0) goto L67
            r0 = r11
            boolean r0 = r0.b
            if (r0 == 0) goto L67
            r0 = 1
            r12 = r0
            goto L6a
        L67:
            r0 = 0
            r12 = r0
        L6a:
            r0 = r11
            if (r0 == 0) goto L79
            r0 = r11
            long r0 = r0.f24643c
            r13 = r0
            goto L7c
        L79:
            r0 = 0
            r13 = r0
        L7c:
            r0 = r7
            r1 = r8
            r2 = r10
            r3 = r12
            r4 = r13
            r0.a(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.monitor.a.a(android.content.Context, java.lang.String, com.opos.cmn.biz.monitor.MonitorEvent, com.opos.cmn.biz.monitor.b):void");
    }

    public com.opos.cmn.biz.monitor.b.a b() {
        com.opos.cmn.biz.monitor.b.a aVar = this.f24620c;
        return aVar != null ? aVar : this.d;
    }

    public String b(Context context, String str, MonitorEvent monitorEvent) {
        b(context);
        if (context == null) {
            return str;
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            MonitorEvent monitorEvent2 = monitorEvent;
            if (monitorEvent == null) {
                monitorEvent2 = new MonitorEvent.b().a();
            }
            str2 = e.a(context, str, monitorEvent2).f24663a;
        }
        return str2;
    }
}
