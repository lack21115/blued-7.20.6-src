package com.igexin.push.e.b;

import com.igexin.push.c.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/b/d.class */
public final class d extends f {

    /* renamed from: a */
    public static final int f23609a = 20160629;
    public static final long b = 604800000;

    /* renamed from: c */
    private static final String f23610c = "PollingTimerTask";
    private long e;
    private AtomicBoolean f;

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/b/d$a.class */
    public static final class a {

        /* renamed from: a */
        private static final d f23611a = new d();

        private a() {
        }
    }

    public d() {
        super(604800000L, (byte) 0);
        this.e = com.igexin.push.config.d.y;
        this.f = new AtomicBoolean(false);
        this.p = true;
    }

    private void a(long j) {
        a(j, TimeUnit.MILLISECONDS);
    }

    private static d p() {
        return a.f23611a;
    }

    @Override // com.igexin.push.e.b.f
    protected final void b() {
        a(this.e, TimeUnit.MILLISECONDS);
        boolean a2 = com.igexin.push.f.c.a(System.currentTimeMillis());
        if (!com.igexin.push.core.e.u && com.igexin.push.core.e.n && com.igexin.push.core.e.p && com.igexin.push.core.e.s && !a2 && com.igexin.push.f.c.a()) {
            com.igexin.c.a.c.a.a("PollingTimerTask|run = true", new Object[0]);
            com.igexin.push.c.c cVar = c.b.f23335a;
            if (cVar.b && cVar.e != null && !(cVar.e instanceof com.igexin.push.c.d)) {
                cVar.e = new com.igexin.push.c.d();
            }
            com.igexin.push.core.e.O = 100L;
            e.g().a(com.igexin.push.core.e.O);
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return f23609a;
    }

    public final void g() {
        if (!this.f.getAndSet(true)) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this, false, true);
        }
        a(this.e);
    }

    public final void h() {
        a(604800000L, TimeUnit.MILLISECONDS);
    }
}
