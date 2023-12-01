package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/w.class */
final class w {

    /* renamed from: a  reason: collision with root package name */
    private final List<Format> f25239a;
    private final com.opos.exoplayer.core.c.n[] b;

    public w(List<Format> list) {
        this.f25239a = list;
        this.b = new com.opos.exoplayer.core.c.n[list.size()];
    }

    public void a(long j, com.opos.exoplayer.core.i.m mVar) {
        com.opos.exoplayer.core.f.a.c.a(j, mVar, this.b);
    }

    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.length) {
                return;
            }
            dVar.a();
            com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 3);
            Format format = this.f25239a.get(i2);
            String str = format.f;
            boolean z = com.anythink.expressad.exoplayer.k.o.W.equals(str) || com.anythink.expressad.exoplayer.k.o.X.equals(str);
            com.opos.exoplayer.core.i.a.a(z, "Invalid closed caption mime type provided: " + str);
            a2.a(Format.a(format.f25000a != null ? format.f25000a : dVar.c(), str, (String) null, -1, format.x, format.y, format.z, (DrmInitData) null));
            this.b[i2] = a2;
            i = i2 + 1;
        }
    }
}
