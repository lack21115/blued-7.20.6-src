package com.anythink.expressad.exoplayer.c;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/c/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f7224a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f7225c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    private void a() {
        synchronized (this) {
        }
    }

    private void a(d dVar) {
        this.f7224a += dVar.f7224a;
        this.b += dVar.b;
        this.f7225c += dVar.f7225c;
        this.d += dVar.d;
        this.e += dVar.e;
        this.f += dVar.f;
        this.g += dVar.g;
        this.h = Math.max(this.h, dVar.h);
        this.i += dVar.i;
    }
}
