package com.anythink.expressad.exoplayer.h.a;

import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.p;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a/d.class */
final class d extends p {

    /* renamed from: c  reason: collision with root package name */
    private final a f4562c;

    public d(ae aeVar, a aVar) {
        super(aeVar);
        com.anythink.expressad.exoplayer.k.a.b(aeVar.c() == 1);
        com.anythink.expressad.exoplayer.k.a.b(aeVar.b() == 1);
        this.f4562c = aVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
    public final ae.a a(int i, ae.a aVar, boolean z) {
        this.b.a(i, aVar, z);
        aVar.a(aVar.f4322a, aVar.b, aVar.f4323c, aVar.d, aVar.b(), this.f4562c);
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
    public final ae.b a(int i, ae.b bVar, boolean z, long j) {
        ae.b a2 = super.a(i, bVar, z, j);
        if (a2.i == com.anythink.expressad.exoplayer.b.b) {
            a2.i = this.f4562c.k;
        }
        return a2;
    }
}
