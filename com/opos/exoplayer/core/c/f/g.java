package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/g.class */
public final class g implements h {

    /* renamed from: a  reason: collision with root package name */
    private final List<u.a> f25194a;
    private final com.opos.exoplayer.core.c.n[] b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25195c;
    private int d;
    private int e;
    private long f;

    public g(List<u.a> list) {
        this.f25194a = list;
        this.b = new com.opos.exoplayer.core.c.n[list.size()];
    }

    private boolean a(com.opos.exoplayer.core.i.m mVar, int i) {
        if (mVar.b() == 0) {
            return false;
        }
        if (mVar.g() != i) {
            this.f25195c = false;
        }
        this.d--;
        return this.f25195c;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.f25195c = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        if (z) {
            this.f25195c = true;
            this.f = j;
            this.e = 0;
            this.d = 2;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.length) {
                return;
            }
            u.a aVar = this.f25194a.get(i2);
            dVar.a();
            com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 3);
            a2.a(Format.a(dVar.c(), com.anythink.expressad.exoplayer.k.o.aj, (String) null, -1, 0, Collections.singletonList(aVar.f25232c), aVar.f25231a, (DrmInitData) null));
            this.b[i2] = a2;
            i = i2 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        com.opos.exoplayer.core.c.n[] nVarArr;
        if (this.f25195c) {
            if (this.d != 2 || a(mVar, 32)) {
                if (this.d != 1 || a(mVar, 0)) {
                    int d = mVar.d();
                    int b = mVar.b();
                    for (com.opos.exoplayer.core.c.n nVar : this.b) {
                        mVar.c(d);
                        nVar.a(mVar, b);
                    }
                    this.e += b;
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
        if (!this.f25195c) {
            return;
        }
        com.opos.exoplayer.core.c.n[] nVarArr = this.b;
        int length = nVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.f25195c = false;
                return;
            } else {
                nVarArr[i2].a(this.f, 1, this.e, 0, null);
                i = i2 + 1;
            }
        }
    }
}
