package com.opos.exoplayer.core.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/b/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private int f25067a;

    public void a() {
        this.f25067a = 0;
    }

    public final void a_(int i) {
        this.f25067a = i;
    }

    public final void b(int i) {
        this.f25067a = i | this.f25067a;
    }

    public final void c(int i) {
        this.f25067a = i & this.f25067a;
    }

    public final boolean c() {
        return d(4);
    }

    public final boolean d() {
        return d(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean d(int i) {
        return (this.f25067a & i) == i;
    }

    public final boolean d_() {
        return d(Integer.MIN_VALUE);
    }
}
