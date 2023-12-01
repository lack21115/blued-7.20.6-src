package com.igexin.push.e.b;

import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/b/f.class */
public abstract class f extends com.igexin.c.a.d.f {
    long d;

    private f(long j) {
        super(5);
        this.d = j;
        a(j, TimeUnit.MILLISECONDS);
    }

    public f(long j, byte b) {
        this(j);
    }

    protected abstract void b();

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws Exception {
        super.b_();
        b();
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }
}
