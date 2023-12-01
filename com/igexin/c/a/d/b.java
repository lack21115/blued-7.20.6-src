package com.igexin.c.a.d;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/b.class */
public abstract class b implements com.igexin.c.a.d.a.e {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f9655a;
    private long b;
    protected String y = getClass().getName();

    @Override // com.igexin.c.a.d.a.e
    public final void a(boolean z) {
        this.f9655a = !z;
    }

    @Override // com.igexin.c.a.d.a.e
    public final void b(long j) {
        this.b = j;
    }

    @Override // com.igexin.c.a.d.a.e
    public final boolean i() {
        return this.f9655a;
    }

    @Override // com.igexin.c.a.d.a.e
    public final long j() {
        return this.b;
    }
}
