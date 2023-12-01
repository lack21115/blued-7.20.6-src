package com.igexin.push.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/f.class */
public class f extends com.igexin.push.e.b.f {

    /* renamed from: c  reason: collision with root package name */
    private static f f9706c;
    private boolean e;
    private static final String b = b.f9692a + f.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f9705a = new AtomicBoolean(false);

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
                if (f9706c == null) {
                    f9706c = new f();
                }
                fVar = f9706c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    @Override // com.igexin.push.e.b.f
    public final void b() {
        a(b.f9693c, TimeUnit.MILLISECONDS);
        if (this.e) {
            com.igexin.c.a.c.a.a(b, "detect task already stop");
            com.igexin.c.a.c.a.a(b + "|detect task already stop", new Object[0]);
            return;
        }
        long j = b.f9693c;
        com.igexin.c.a.c.a.a(b + "|" + (b.f9693c / 1000) + "s passed, do task method, start redect ~~~~", new Object[0]);
        boolean e = com.igexin.push.f.c.e();
        com.igexin.push.core.e.n = e;
        if (e) {
            c.a().c();
            return;
        }
        long j2 = b.f9693c;
        com.igexin.c.a.c.a.a(b + "|" + (b.f9693c / 1000) + "s passed, network is unavailable, stop ###", new Object[0]);
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
