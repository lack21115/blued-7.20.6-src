package com.igexin.push.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/f.class */
public class f extends com.igexin.push.e.b.f {

    /* renamed from: c  reason: collision with root package name */
    private static f f23314c;
    private boolean e;
    private static final String b = b.f23300a + f.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f23313a = new AtomicBoolean(false);

    private f() {
        super(10L, (byte) 0);
        this.p = true;
    }

    private void a(long j) {
        a(j, TimeUnit.MILLISECONDS);
    }

    public static f g() {
        f fVar;
        synchronized (f.class) {
            try {
                if (f23314c == null) {
                    f23314c = new f();
                }
                fVar = f23314c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    @Override // com.igexin.push.e.b.f
    public final void b() {
        a(b.f23301c, TimeUnit.MILLISECONDS);
        if (this.e) {
            com.igexin.c.a.c.a.a(b, "detect task already stop");
            com.igexin.c.a.c.a.a(b + "|detect task already stop", new Object[0]);
            return;
        }
        long j = b.f23301c;
        com.igexin.c.a.c.a.a(b + "|" + (b.f23301c / 1000) + "s passed, do task method, start redect ~~~~", new Object[0]);
        boolean e = com.igexin.push.f.c.e();
        com.igexin.push.core.e.n = e;
        if (e) {
            c.a().c();
            return;
        }
        long j2 = b.f23301c;
        com.igexin.c.a.c.a.a(b + "|" + (b.f23301c / 1000) + "s passed, network is unavailable, stop ###", new Object[0]);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 20150607;
    }

    public final void h() {
        this.p = false;
        this.e = true;
        k();
    }
}
