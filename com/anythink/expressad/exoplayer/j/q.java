package com.anythink.expressad.exoplayer.j;

import com.anythink.expressad.exoplayer.j.s;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/q.class */
public final class q extends s.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f7598a;
    private final aa<? super h> b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7599c;
    private final int d;
    private final boolean e;

    public q(String str) {
        this(str, null);
    }

    public q(String str, aa<? super h> aaVar) {
        this(str, aaVar, (byte) 0);
    }

    private q(String str, aa<? super h> aaVar, byte b) {
        this.f7598a = str;
        this.b = aaVar;
        this.f7599c = 8000;
        this.d = 8000;
        this.e = false;
    }

    private p b(s.f fVar) {
        return new p(this.f7598a, null, this.b, this.f7599c, this.d, this.e, fVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.s.a
    protected final /* synthetic */ s a(s.f fVar) {
        return new p(this.f7598a, null, this.b, this.f7599c, this.d, this.e, fVar);
    }
}
