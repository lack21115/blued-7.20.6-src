package com.anythink.expressad.exoplayer.h.b;

import com.anythink.expressad.exoplayer.j.k;
import com.anythink.expressad.exoplayer.j.t;
import com.anythink.expressad.exoplayer.m;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/b/c.class */
public abstract class c implements t.c {
    public final k b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4586c = 1;
    public final m d;
    public final int e;
    public final Object f;
    public final long g;
    public final long h;
    protected final com.anythink.expressad.exoplayer.j.h i;

    public c(com.anythink.expressad.exoplayer.j.h hVar, k kVar, m mVar, int i, Object obj, long j, long j2) {
        this.i = (com.anythink.expressad.exoplayer.j.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
        this.b = (k) com.anythink.expressad.exoplayer.k.a.a(kVar);
        this.d = mVar;
        this.e = i;
        this.f = obj;
        this.g = j;
        this.h = j2;
    }

    private long c() {
        return this.h - this.g;
    }

    public abstract long d();
}
