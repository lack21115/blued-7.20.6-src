package com.anythink.expressad.exoplayer.j;

import com.anythink.expressad.exoplayer.j.h;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/x.class */
public final class x implements h.a {

    /* renamed from: a  reason: collision with root package name */
    private final h.a f7616a;
    private final com.anythink.expressad.exoplayer.k.v b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7617c;

    private x(h.a aVar, com.anythink.expressad.exoplayer.k.v vVar, int i) {
        this.f7616a = aVar;
        this.b = vVar;
        this.f7617c = i;
    }

    private w b() {
        return new w(this.f7616a.a(), this.b, this.f7617c);
    }

    @Override // com.anythink.expressad.exoplayer.j.h.a
    public final /* synthetic */ h a() {
        return new w(this.f7616a.a(), this.b, this.f7617c);
    }
}
