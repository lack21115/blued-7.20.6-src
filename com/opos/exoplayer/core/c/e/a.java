package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/a.class */
public class a implements com.opos.exoplayer.core.c.e {

    /* renamed from: a  reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f25152a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.e.a.1
        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    };
    private com.opos.exoplayer.core.c.g b;

    /* renamed from: c  reason: collision with root package name */
    private i f25153c;
    private boolean d;

    private static m a(m mVar) {
        mVar.c(0);
        return mVar;
    }

    private boolean b(com.opos.exoplayer.core.c.f fVar) {
        i hVar;
        f fVar2 = new f();
        if (fVar2.a(fVar, true) && (fVar2.b & 2) == 2) {
            int min = Math.min(fVar2.i, 8);
            m mVar = new m(min);
            fVar.c(mVar.f25496a, 0, min);
            if (d.a(a(mVar))) {
                hVar = new d();
            } else if (k.a(a(mVar))) {
                hVar = new k();
            } else if (!h.a(a(mVar))) {
                return false;
            } else {
                hVar = new h();
            }
            this.f25153c = hVar;
            return true;
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        if (this.f25153c == null) {
            if (!b(fVar)) {
                throw new o("Failed to determine bitstream type");
            }
            fVar.a();
        }
        if (!this.d) {
            n a2 = this.b.a(0, 1);
            this.b.a();
            this.f25153c.a(this.b, a2);
            this.d = true;
        }
        return this.f25153c.a(fVar, kVar);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        i iVar = this.f25153c;
        if (iVar != null) {
            iVar.a(j, j2);
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.b = gVar;
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        try {
            return b(fVar);
        } catch (o e) {
            return false;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
