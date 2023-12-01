package com.anythink.expressad.exoplayer.h.b;

import com.anythink.expressad.exoplayer.j.k;
import com.anythink.expressad.exoplayer.m;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/b/i.class */
public abstract class i extends c {
    public final long j;

    public i(com.anythink.expressad.exoplayer.j.h hVar, k kVar, m mVar, int i, Object obj, long j, long j2, long j3) {
        super(hVar, kVar, mVar, i, obj, j, j2);
        com.anythink.expressad.exoplayer.k.a.a(mVar);
        this.j = j3;
    }

    public long e() {
        long j = this.j;
        if (j != -1) {
            return j + 1;
        }
        return -1L;
    }

    public abstract boolean f();
}
