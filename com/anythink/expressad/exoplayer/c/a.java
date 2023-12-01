package com.anythink.expressad.exoplayer.c;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/c/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private int f7220a;

    private void d(int i) {
        this.f7220a = i & this.f7220a;
    }

    public void a() {
        this.f7220a = 0;
    }

    public final void a(int i) {
        this.f7220a = i;
    }

    public final void b(int i) {
        this.f7220a = i | this.f7220a;
    }

    public final boolean b() {
        return c(Integer.MIN_VALUE);
    }

    public final boolean c() {
        return c(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c(int i) {
        return (this.f7220a & i) == i;
    }

    public final boolean d() {
        return c(1);
    }
}
