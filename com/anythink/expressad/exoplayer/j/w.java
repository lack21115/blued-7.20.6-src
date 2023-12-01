package com.anythink.expressad.exoplayer.j;

import android.net.Uri;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/w.class */
public final class w implements h {

    /* renamed from: a  reason: collision with root package name */
    private final h f7614a;
    private final com.anythink.expressad.exoplayer.k.v b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7615c;

    public w(h hVar, com.anythink.expressad.exoplayer.k.v vVar, int i) {
        this.f7614a = (h) com.anythink.expressad.exoplayer.k.a.a(hVar);
        this.b = (com.anythink.expressad.exoplayer.k.v) com.anythink.expressad.exoplayer.k.a.a(vVar);
        this.f7615c = i;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        this.b.a(this.f7615c);
        return this.f7614a.a(bArr, i, i2);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) {
        this.b.a(this.f7615c);
        return this.f7614a.a(kVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        return this.f7614a.a();
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.f7614a.b();
    }
}
