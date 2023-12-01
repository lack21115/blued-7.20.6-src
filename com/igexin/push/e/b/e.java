package com.igexin.push.e.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.igexin.push.core.e.f;
import com.igexin.push.core.k;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/b/e.class */
public final class e extends f {
    public static final int b = -2147483641;

    /* renamed from: c  reason: collision with root package name */
    private static final String f10004c = "RNTT";
    private static e e;

    /* renamed from: a  reason: collision with root package name */
    public long f10005a;
    private long f;

    private e() {
        super(com.igexin.push.config.c.g, (byte) 0);
        this.p = true;
        this.f = System.currentTimeMillis();
        this.f10005a = SystemClock.elapsedRealtime();
    }

    private void c(long j) {
        this.f10005a = j;
    }

    public static e g() {
        e eVar;
        synchronized (e.class) {
            try {
                if (e == null) {
                    e = new e();
                }
                eVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    private void h() {
        a(com.igexin.push.core.e.O);
    }

    public final void a(long j) {
        com.igexin.c.a.c.a.a("RNTT|refreshDelayTime, delay = ".concat(String.valueOf(j)), new Object[0]);
        a(j, TimeUnit.MILLISECONDS);
    }

    @Override // com.igexin.push.e.b.f
    protected final void b() {
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.k();
        boolean a2 = com.igexin.push.f.c.a(System.currentTimeMillis());
        boolean a3 = com.igexin.push.f.c.a();
        com.igexin.push.core.e.n = com.igexin.push.f.c.e();
        boolean z = com.igexin.push.core.e.u;
        boolean z2 = com.igexin.push.core.e.p;
        boolean z3 = com.igexin.push.core.e.s;
        com.igexin.c.a.c.a.a("RNTT|networkAvailable = " + com.igexin.push.core.e.n + "|,sdkOnline = " + com.igexin.push.core.e.u + ", sdkOn= " + com.igexin.push.core.e.p + ", pushOn =" + com.igexin.push.core.e.s + ", isSilentTime= " + a2 + ", blockEndTime= " + a3, new Object[0]);
        if (!com.igexin.push.core.e.n || !com.igexin.push.core.e.p || !com.igexin.push.core.e.s || com.igexin.push.core.e.u || a2 || !a3) {
            com.igexin.c.a.c.a.a("RNTT reconnect timer task stop, connect interval= 20min #######", new Object[0]);
            a(com.igexin.push.config.c.g, TimeUnit.MILLISECONDS);
        } else if (!com.igexin.push.f.c.f() && TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            a(900000L, TimeUnit.MILLISECONDS);
            com.igexin.c.a.c.a.a(f10004c, "date is error, set connect interval = 15min");
            com.igexin.c.a.c.a.a("RNTT|date is error, set connect interval = 15min", new Object[0]);
        } else {
            com.igexin.c.a.c.a.a("RNTT reconnect timer task isOnline = false, try login...", new Object[0]);
            if (System.currentTimeMillis() - this.f < 2500) {
                com.igexin.push.core.e.r++;
            }
            if (com.igexin.push.core.e.r > 30 && Math.abs(SystemClock.elapsedRealtime() - this.f10005a) < 72000.0d) {
                com.igexin.push.core.e.f.a();
                String str = com.igexin.push.core.e.A;
                com.igexin.c.a.c.a.a(com.igexin.push.core.e.f.f9902a + "| found a duplicate cid " + com.igexin.push.core.e.A, new Object[0]);
                com.igexin.push.core.e.L = null;
                com.igexin.push.core.e.f.d();
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass13(com.igexin.push.core.e.L), false, true);
                com.igexin.push.core.e.f.a().b();
                com.igexin.push.core.e.r = 0;
                g().f10005a = SystemClock.elapsedRealtime();
            }
            this.f = System.currentTimeMillis();
            k.a();
            k.b();
            a(1800000L, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return b;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
    }
}
