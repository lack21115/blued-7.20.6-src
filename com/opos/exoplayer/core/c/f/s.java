package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/s.class */
public final class s implements q {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.exoplayer.core.i.s f11536a;
    private com.opos.exoplayer.core.c.n b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11537c;

    @Override // com.opos.exoplayer.core.c.f.q
    public void a(com.opos.exoplayer.core.i.m mVar) {
        if (!this.f11537c) {
            if (this.f11536a.c() == com.anythink.expressad.exoplayer.b.b) {
                return;
            }
            this.b.a(Format.a((String) null, com.anythink.expressad.exoplayer.k.o.ag, this.f11536a.c()));
            this.f11537c = true;
        }
        int b = mVar.b();
        this.b.a(mVar, b);
        this.b.a(this.f11536a.b(), 1, b, 0, null);
    }

    @Override // com.opos.exoplayer.core.c.f.q
    public void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        this.f11536a = sVar;
        dVar.a();
        com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 4);
        this.b = a2;
        a2.a(Format.a(dVar.c(), com.anythink.expressad.exoplayer.k.o.ag, (String) null, -1, (DrmInitData) null));
    }
}
