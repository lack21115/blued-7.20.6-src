package com.anythink.expressad.exoplayer.c;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/c/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private int f4381a;

    private void d(int i) {
        this.f4381a = i & this.f4381a;
    }

    public void a() {
        this.f4381a = 0;
    }

    public final void a(int i) {
        this.f4381a = i;
    }

    public final void b(int i) {
        this.f4381a = i | this.f4381a;
    }

    public final boolean b() {
        return c(Integer.MIN_VALUE);
    }

    public final boolean c() {
        return c(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c(int i) {
        return (this.f4381a & i) == i;
    }

    public final boolean d() {
        return c(1);
    }
}
