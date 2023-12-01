package com.opos.exoplayer.core.c.c;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e;
import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.c.g;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.c.i;
import com.opos.exoplayer.core.c.j;
import com.opos.exoplayer.core.c.k;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.o;
import java.io.EOFException;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/c/a.class */
public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f11415a = new h() { // from class: com.opos.exoplayer.core.c.c.a.1
        @Override // com.opos.exoplayer.core.c.h
        public e[] a() {
            return new e[]{new a()};
        }
    };
    private static final int b = u.f("Xing");

    /* renamed from: c  reason: collision with root package name */
    private static final int f11416c = u.f("Info");
    private static final int d = u.f("VBRI");
    private final int e;
    private final long f;
    private final m g;
    private final j h;
    private final i i;
    private g j;
    private n k;
    private int l;
    private Metadata m;
    private InterfaceC0480a n;
    private long o;
    private long p;
    private int q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.exoplayer.core.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/c/a$a.class */
    public interface InterfaceC0480a extends l {
        long a(long j);
    }

    public a() {
        this(0);
    }

    public a(int i) {
        this(i, com.anythink.expressad.exoplayer.b.b);
    }

    public a(int i, long j) {
        this.e = i;
        this.f = j;
        this.g = new m(10);
        this.h = new j();
        this.i = new i();
        this.o = com.anythink.expressad.exoplayer.b.b;
    }

    private static int a(m mVar, int i) {
        int i2;
        if (mVar.c() >= i + 4) {
            mVar.c(i);
            int o = mVar.o();
            i2 = o;
            if (o != b) {
                if (o == f11416c) {
                    return o;
                }
            }
            return i2;
        }
        if (mVar.c() >= 40) {
            mVar.c(36);
            int o2 = mVar.o();
            int i3 = d;
            if (o2 == i3) {
                return i3;
            }
        }
        i2 = 0;
        return i2;
    }

    private static boolean a(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    private boolean a(f fVar, boolean z) {
        int i;
        int a2;
        int i2 = z ? 16384 : 131072;
        fVar.a();
        if (fVar.c() == 0) {
            c(fVar);
            i = (int) fVar.b();
            if (!z) {
                fVar.b(i);
            }
        } else {
            i = 0;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!fVar.b(this.g.f11808a, 0, 4, i3 > 0)) {
                break;
            }
            this.g.c(0);
            int o = this.g.o();
            if ((i4 == 0 || a(o, i4)) && (a2 = j.a(o)) != -1) {
                i3++;
                if (i3 != 1) {
                    o = i4;
                    if (i3 == 4) {
                        break;
                    }
                } else {
                    j.a(o, this.h);
                }
                fVar.c(a2 - 4);
                i4 = o;
            } else {
                int i6 = i5 + 1;
                if (i5 == i2) {
                    if (z) {
                        return false;
                    }
                    throw new o("Searched too many bytes.");
                }
                if (z) {
                    fVar.a();
                    fVar.c(i + i6);
                } else {
                    fVar.b(1);
                }
                i5 = i6;
                i3 = 0;
                i4 = 0;
            }
        }
        if (z) {
            fVar.b(i + i5);
        } else {
            fVar.a();
        }
        this.l = i4;
        return true;
    }

    private int b(f fVar) {
        if (this.q == 0) {
            fVar.a();
            if (!fVar.b(this.g.f11808a, 0, 4, true)) {
                return -1;
            }
            this.g.c(0);
            int o = this.g.o();
            if (!a(o, this.l) || j.a(o) == -1) {
                fVar.b(1);
                this.l = 0;
                return 0;
            }
            j.a(o, this.h);
            if (this.o == com.anythink.expressad.exoplayer.b.b) {
                this.o = this.n.a(fVar.c());
                if (this.f != com.anythink.expressad.exoplayer.b.b) {
                    this.o = (this.f - this.n.a(0L)) + this.o;
                }
            }
            this.q = this.h.f11560c;
        }
        int a2 = this.k.a(fVar, this.q, true);
        if (a2 == -1) {
            return -1;
        }
        int i = this.q - a2;
        this.q = i;
        if (i <= 0) {
            this.k.a(((this.p * 1000000) / this.h.d) + this.o, 1, this.h.f11560c, 0, null);
            this.p += this.h.g;
            this.q = 0;
            return 0;
        }
        return 0;
    }

    private void c(f fVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            fVar.c(this.g.f11808a, 0, 10);
            this.g.c(0);
            if (this.g.k() != com.opos.exoplayer.core.metadata.id3.a.f11850a) {
                fVar.a();
                fVar.c(i2);
                return;
            }
            this.g.d(3);
            int t = this.g.t();
            int i3 = t + 10;
            if (this.m == null) {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.g.f11808a, 0, bArr, 0, 10);
                fVar.c(bArr, 10, t);
                Metadata a2 = new com.opos.exoplayer.core.metadata.id3.a((this.e & 2) != 0 ? i.f11557a : null).a(bArr, i3);
                this.m = a2;
                if (a2 != null) {
                    this.i.a(a2);
                }
            } else {
                fVar.c(t);
            }
            i = i2 + i3;
        }
    }

    private InterfaceC0480a d(f fVar) {
        int i;
        m mVar = new m(this.h.f11560c);
        fVar.c(mVar.f11808a, 0, this.h.f11560c);
        if ((this.h.f11559a & 1) != 0) {
            if (this.h.e != 1) {
                i = 36;
            }
            i = 21;
        } else {
            if (this.h.e == 1) {
                i = 13;
            }
            i = 21;
        }
        int a2 = a(mVar, i);
        if (a2 != b && a2 != f11416c) {
            if (a2 != d) {
                fVar.a();
                return null;
            }
            c a3 = c.a(fVar.d(), fVar.c(), this.h, mVar);
            fVar.b(this.h.f11560c);
            return a3;
        }
        d a4 = d.a(fVar.d(), fVar.c(), this.h, mVar);
        if (a4 != null && !this.i.a()) {
            fVar.a();
            fVar.c(i + 141);
            fVar.c(this.g.f11808a, 0, 3);
            this.g.c(0);
            this.i.a(this.g.k());
        }
        fVar.b(this.h.f11560c);
        d dVar = a4;
        if (a4 != null) {
            dVar = a4;
            if (!a4.a()) {
                dVar = a4;
                if (a2 == f11416c) {
                    dVar = e(fVar);
                }
            }
        }
        return dVar;
    }

    private InterfaceC0480a e(f fVar) {
        fVar.c(this.g.f11808a, 0, 4);
        this.g.c(0);
        j.a(this.g.o(), this.h);
        return new b(fVar.d(), fVar.c(), this.h);
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(f fVar, k kVar) {
        if (this.l == 0) {
            try {
                a(fVar, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.n == null) {
            InterfaceC0480a d2 = d(fVar);
            this.n = d2;
            if (d2 == null || (!d2.a() && (this.e & 1) != 0)) {
                this.n = e(fVar);
            }
            this.j.a(this.n);
            this.k.a(Format.a((String) null, this.h.b, (String) null, -1, 4096, this.h.e, this.h.d, -1, this.i.b, this.i.f11558c, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, (this.e & 2) != 0 ? null : this.m));
        }
        return b(fVar);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.l = 0;
        this.o = com.anythink.expressad.exoplayer.b.b;
        this.p = 0L;
        this.q = 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(g gVar) {
        this.j = gVar;
        this.k = gVar.a(0, 1);
        this.j.a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(f fVar) {
        return a(fVar, true);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
