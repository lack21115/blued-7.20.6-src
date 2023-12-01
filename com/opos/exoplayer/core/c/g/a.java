package com.opos.exoplayer.core.c.g;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e;
import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.c.g;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.c.k;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.o;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/g/a.class */
public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f11552a = new h() { // from class: com.opos.exoplayer.core.c.g.a.1
        @Override // com.opos.exoplayer.core.c.h
        public e[] a() {
            return new e[]{new a()};
        }
    };
    private g b;

    /* renamed from: c  reason: collision with root package name */
    private n f11553c;
    private b d;
    private int e;
    private int f;

    @Override // com.opos.exoplayer.core.c.e
    public int a(f fVar, k kVar) {
        if (this.d == null) {
            b a2 = c.a(fVar);
            this.d = a2;
            if (a2 == null) {
                throw new o("Unsupported or unrecognized wav header.");
            }
            this.f11553c.a(Format.a((String) null, "audio/raw", (String) null, a2.e(), 32768, this.d.g(), this.d.f(), this.d.h(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            this.e = this.d.d();
        }
        if (!this.d.c()) {
            c.a(fVar, this.d);
            this.b.a(this.d);
        }
        int a3 = this.f11553c.a(fVar, 32768 - this.f, true);
        if (a3 != -1) {
            this.f += a3;
        }
        int i = this.f / this.e;
        if (i > 0) {
            long a4 = this.d.a(fVar.c() - this.f);
            int i2 = i * this.e;
            int i3 = this.f - i2;
            this.f = i3;
            this.f11553c.a(a4, 1, i2, i3, null);
        }
        return a3 == -1 ? -1 : 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.f = 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(g gVar) {
        this.b = gVar;
        this.f11553c = gVar.a(0, 1);
        this.d = null;
        gVar.a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(f fVar) {
        return c.a(fVar) != null;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
