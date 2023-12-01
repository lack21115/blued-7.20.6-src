package com.anythink.expressad.exoplayer.j;

import com.anythink.expressad.exoplayer.j.h;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/x.class */
public final class x implements h.a {

    /* renamed from: a  reason: collision with root package name */
    private final h.a f4777a;
    private final com.anythink.expressad.exoplayer.k.v b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4778c;

    private x(h.a aVar, com.anythink.expressad.exoplayer.k.v vVar, int i) {
        this.f4777a = aVar;
        this.b = vVar;
        this.f4778c = i;
    }

    private w b() {
        return new w(this.f4777a.a(), this.b, this.f4778c);
    }

    @Override // com.anythink.expressad.exoplayer.j.h.a
    public final /* synthetic */ h a() {
        return new w(this.f4777a.a(), this.b, this.f4778c);
    }
}
