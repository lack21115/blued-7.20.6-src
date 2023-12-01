package com.opos.exoplayer.core;

import com.opos.exoplayer.core.e.e;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/ae.class */
final class ae {

    /* renamed from: a  reason: collision with root package name */
    public final y f11375a;
    public final Object b;

    /* renamed from: c  reason: collision with root package name */
    public final e.b f11376c;
    public final long d;
    public final long e;
    public final int f;
    public final boolean g;
    public final com.opos.exoplayer.core.g.i h;
    public volatile long i;
    public volatile long j;

    public ae(y yVar, long j, com.opos.exoplayer.core.g.i iVar) {
        this(yVar, null, new e.b(0), j, com.anythink.expressad.exoplayer.b.b, 1, false, iVar);
    }

    public ae(y yVar, Object obj, e.b bVar, long j, long j2, int i, boolean z, com.opos.exoplayer.core.g.i iVar) {
        this.f11375a = yVar;
        this.b = obj;
        this.f11376c = bVar;
        this.d = j;
        this.e = j2;
        this.i = j;
        this.j = j;
        this.f = i;
        this.g = z;
        this.h = iVar;
    }

    private static void a(ae aeVar, ae aeVar2) {
        aeVar2.i = aeVar.i;
        aeVar2.j = aeVar.j;
    }

    public ae a(int i) {
        ae aeVar = new ae(this.f11375a, this.b, this.f11376c.a(i), this.d, this.e, this.f, this.g, this.h);
        a(this, aeVar);
        return aeVar;
    }

    public ae a(e.b bVar, long j, long j2) {
        y yVar = this.f11375a;
        Object obj = this.b;
        if (!bVar.a()) {
            j2 = -9223372036854775807L;
        }
        return new ae(yVar, obj, bVar, j, j2, this.f, this.g, this.h);
    }

    public ae a(com.opos.exoplayer.core.g.i iVar) {
        ae aeVar = new ae(this.f11375a, this.b, this.f11376c, this.d, this.e, this.f, this.g, iVar);
        a(this, aeVar);
        return aeVar;
    }

    public ae a(y yVar, Object obj) {
        ae aeVar = new ae(yVar, obj, this.f11376c, this.d, this.e, this.f, this.g, this.h);
        a(this, aeVar);
        return aeVar;
    }

    public ae a(boolean z) {
        ae aeVar = new ae(this.f11375a, this.b, this.f11376c, this.d, this.e, this.f, z, this.h);
        a(this, aeVar);
        return aeVar;
    }

    public ae b(int i) {
        ae aeVar = new ae(this.f11375a, this.b, this.f11376c, this.d, this.e, i, this.g, this.h);
        a(this, aeVar);
        return aeVar;
    }
}
