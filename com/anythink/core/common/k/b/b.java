package com.anythink.core.common.k.b;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/b/b.class */
public abstract class b implements Runnable {
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    protected c h;
    protected boolean g = true;
    protected int i = 1;

    /* renamed from: a  reason: collision with root package name */
    private long f6800a = 0;
    private String b = "topon-default-thread";

    private void a(c cVar) {
        this.h = cVar;
    }

    private String c() {
        return this.b;
    }

    public abstract void a();

    public final void a(long j) {
        this.f6800a = j;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final long b() {
        return this.f6800a;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setName(this.b);
        a();
    }
}
