package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/l.class */
public final class l implements h {

    /* renamed from: a  reason: collision with root package name */
    private final com.opos.exoplayer.core.i.m f11522a = new com.opos.exoplayer.core.i.m(10);
    private com.opos.exoplayer.core.c.n b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11523c;
    private long d;
    private int e;
    private int f;

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.f11523c = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        if (z) {
            this.f11523c = true;
            this.d = j;
            this.e = 0;
            this.f = 0;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 4);
        this.b = a2;
        a2.a(Format.a(dVar.c(), com.anythink.expressad.exoplayer.k.o.V, (String) null, -1, (DrmInitData) null));
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        if (this.f11523c) {
            int b = mVar.b();
            int i = this.f;
            if (i < 10) {
                int min = Math.min(b, 10 - i);
                System.arraycopy(mVar.f11808a, mVar.d(), this.f11522a.f11808a, this.f, min);
                if (min + this.f == 10) {
                    this.f11522a.c(0);
                    if (73 != this.f11522a.g() || 68 != this.f11522a.g() || 51 != this.f11522a.g()) {
                        com.opos.cmn.an.f.a.c("Id3Reader", "Discarding invalid ID3 tag");
                        this.f11523c = false;
                        return;
                    }
                    this.f11522a.d(3);
                    this.e = this.f11522a.t() + 10;
                }
            }
            int min2 = Math.min(b, this.e - this.f);
            this.b.a(mVar, min2);
            this.f = min2 + this.f;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
        int i;
        if (this.f11523c && (i = this.e) != 0 && this.f == i) {
            this.b.a(this.d, 1, i, 0, null);
            this.f11523c = false;
        }
    }
}
