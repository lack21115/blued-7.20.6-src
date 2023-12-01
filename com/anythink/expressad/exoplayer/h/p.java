package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.ae;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/p.class */
public abstract class p extends com.anythink.expressad.exoplayer.ae {
    protected final com.anythink.expressad.exoplayer.ae b;

    public p(com.anythink.expressad.exoplayer.ae aeVar) {
        this.b = aeVar;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public int a(int i, int i2, boolean z) {
        return this.b.a(i, i2, z);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public int a(Object obj) {
        return this.b.a(obj);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(boolean z) {
        return this.b.a(z);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public ae.a a(int i, ae.a aVar, boolean z) {
        return this.b.a(i, aVar, z);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public ae.b a(int i, ae.b bVar, boolean z, long j) {
        return this.b.a(i, bVar, z, j);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b() {
        return this.b.b();
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public int b(int i, int i2, boolean z) {
        return this.b.b(i, i2, z);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b(boolean z) {
        return this.b.b(z);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int c() {
        return this.b.c();
    }
}
