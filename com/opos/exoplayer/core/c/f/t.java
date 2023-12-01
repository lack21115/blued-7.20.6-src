package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.c.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/t.class */
public final class t implements com.opos.exoplayer.core.c.e {

    /* renamed from: a  reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f25226a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.f.t.1
        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new t()};
        }
    };
    private static final long b = com.opos.exoplayer.core.i.u.f("AC-3");

    /* renamed from: c  reason: collision with root package name */
    private static final long f25227c = com.opos.exoplayer.core.i.u.f("EAC3");
    private static final long d = com.opos.exoplayer.core.i.u.f("HEVC");
    private final int e;
    private final List<com.opos.exoplayer.core.i.s> f;
    private final com.opos.exoplayer.core.i.m g;
    private final SparseIntArray h;
    private final u.c i;
    private final SparseArray<u> j;
    private final SparseBooleanArray k;
    private com.opos.exoplayer.core.c.g l;
    private int m;
    private boolean n;
    private u o;
    private int p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/t$a.class */
    public class a implements q {
        private final com.opos.exoplayer.core.i.l b = new com.opos.exoplayer.core.i.l(new byte[4]);

        public a() {
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.m mVar) {
            if (mVar.g() != 0) {
                return;
            }
            mVar.d(7);
            int b = mVar.b() / 4;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= b) {
                    break;
                }
                mVar.a(this.b, 4);
                int c2 = this.b.c(16);
                this.b.b(3);
                if (c2 == 0) {
                    this.b.b(13);
                } else {
                    int c3 = this.b.c(13);
                    t.this.j.put(c3, new r(new b(c3)));
                    t.b(t.this);
                }
                i = i2 + 1;
            }
            if (t.this.e != 2) {
                t.this.j.remove(0);
            }
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/t$b.class */
    class b implements q {
        private final com.opos.exoplayer.core.i.l b = new com.opos.exoplayer.core.i.l(new byte[5]);

        /* renamed from: c  reason: collision with root package name */
        private final SparseArray<u> f25230c = new SparseArray<>();
        private final SparseIntArray d = new SparseIntArray();
        private final int e;

        public b(int i) {
            this.e = i;
        }

        private u.b a(com.opos.exoplayer.core.i.m mVar, int i) {
            String str;
            ArrayList arrayList;
            int d = mVar.d();
            int i2 = i + d;
            String str2 = null;
            ArrayList arrayList2 = null;
            int i3 = -1;
            while (mVar.d() < i2) {
                int g = mVar.g();
                int g2 = mVar.g() + mVar.d();
                if (g == 5) {
                    long m = mVar.m();
                    if (m != t.b) {
                        if (m != t.f25227c) {
                            str = str2;
                            arrayList = arrayList2;
                            if (m == t.d) {
                                i3 = 36;
                                str = str2;
                                arrayList = arrayList2;
                            }
                        }
                        i3 = 135;
                        str = str2;
                        arrayList = arrayList2;
                    }
                    i3 = 129;
                    str = str2;
                    arrayList = arrayList2;
                } else {
                    if (g != 106) {
                        if (g != 122) {
                            if (g == 123) {
                                i3 = 138;
                                str = str2;
                                arrayList = arrayList2;
                            } else if (g == 10) {
                                str = mVar.e(3).trim();
                                arrayList = arrayList2;
                            } else {
                                str = str2;
                                arrayList = arrayList2;
                                if (g == 89) {
                                    arrayList = new ArrayList();
                                    while (mVar.d() < g2) {
                                        String trim = mVar.e(3).trim();
                                        int g3 = mVar.g();
                                        byte[] bArr = new byte[4];
                                        mVar.a(bArr, 0, 4);
                                        arrayList.add(new u.a(trim, g3, bArr));
                                    }
                                    i3 = 89;
                                    str = str2;
                                }
                            }
                        }
                        i3 = 135;
                        str = str2;
                        arrayList = arrayList2;
                    }
                    i3 = 129;
                    str = str2;
                    arrayList = arrayList2;
                }
                mVar.d(g2 - mVar.d());
                str2 = str;
                arrayList2 = arrayList;
            }
            mVar.c(i2);
            return new u.b(i3, str2, arrayList2, Arrays.copyOfRange(mVar.f25496a, d, i2));
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.m mVar) {
            com.opos.exoplayer.core.i.s sVar;
            if (mVar.g() != 2) {
                return;
            }
            if (t.this.e == 1 || t.this.e == 2 || t.this.m == 1) {
                sVar = (com.opos.exoplayer.core.i.s) t.this.f.get(0);
            } else {
                sVar = new com.opos.exoplayer.core.i.s(((com.opos.exoplayer.core.i.s) t.this.f.get(0)).a());
                t.this.f.add(sVar);
            }
            mVar.d(2);
            int h = mVar.h();
            mVar.d(5);
            mVar.a(this.b, 2);
            this.b.b(4);
            mVar.d(this.b.c(12));
            if (t.this.e == 2 && t.this.o == null) {
                u.b bVar = new u.b(21, null, null, new byte[0]);
                t tVar = t.this;
                tVar.o = tVar.i.a(21, bVar);
                t.this.o.a(sVar, t.this.l, new u.d(h, 21, 8192));
            }
            this.f25230c.clear();
            this.d.clear();
            int b = mVar.b();
            while (true) {
                int i = b;
                if (i <= 0) {
                    break;
                }
                mVar.a(this.b, 5);
                int c2 = this.b.c(8);
                this.b.b(3);
                int c3 = this.b.c(13);
                this.b.b(4);
                int c4 = this.b.c(12);
                u.b a2 = a(mVar, c4);
                int i2 = c2;
                if (c2 == 6) {
                    i2 = a2.f25233a;
                }
                int i3 = i - (c4 + 5);
                int i4 = t.this.e == 2 ? i2 : c3;
                if (!t.this.k.get(i4)) {
                    u a3 = (t.this.e == 2 && i2 == 21) ? t.this.o : t.this.i.a(i2, a2);
                    if (t.this.e != 2 || c3 < this.d.get(i4, 8192)) {
                        this.d.put(i4, c3);
                        this.f25230c.put(i4, a3);
                    }
                }
                b = i3;
            }
            int size = this.d.size();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= size) {
                    break;
                }
                int keyAt = this.d.keyAt(i6);
                t.this.k.put(keyAt, true);
                u valueAt = this.f25230c.valueAt(i6);
                if (valueAt != null) {
                    if (valueAt != t.this.o) {
                        valueAt.a(sVar, t.this.l, new u.d(h, keyAt, 8192));
                    }
                    t.this.j.put(this.d.valueAt(i6), valueAt);
                }
                i5 = i6 + 1;
            }
            if (t.this.e != 2) {
                t.this.j.remove(this.e);
                t tVar2 = t.this;
                tVar2.m = tVar2.e == 1 ? 0 : t.this.m - 1;
                if (t.this.m != 0) {
                    return;
                }
                t.this.l.a();
            } else if (t.this.n) {
                return;
            } else {
                t.this.l.a();
                t.this.m = 0;
            }
            t.this.n = true;
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        }
    }

    public t() {
        this(0);
    }

    public t(int i) {
        this(1, i);
    }

    public t(int i, int i2) {
        this(i, new com.opos.exoplayer.core.i.s(0L), new e(i2));
    }

    public t(int i, com.opos.exoplayer.core.i.s sVar, u.c cVar) {
        this.i = (u.c) com.opos.exoplayer.core.i.a.a(cVar);
        this.e = i;
        if (i == 1 || i == 2) {
            this.f = Collections.singletonList(sVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add(sVar);
        }
        this.g = new com.opos.exoplayer.core.i.m(new byte[9400], 0);
        this.k = new SparseBooleanArray();
        this.j = new SparseArray<>();
        this.h = new SparseIntArray();
        e();
    }

    static /* synthetic */ int b(t tVar) {
        int i = tVar.m;
        tVar.m = i + 1;
        return i;
    }

    private void e() {
        this.k.clear();
        this.j.clear();
        SparseArray<u> a2 = this.i.a();
        int size = a2.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.j.put(0, new r(new a()));
                this.o = null;
                return;
            }
            this.j.put(a2.keyAt(i2), a2.valueAt(i2));
            i = i2 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int i;
        byte[] bArr = this.g.f25496a;
        if (9400 - this.g.d() < 188) {
            int b2 = this.g.b();
            if (b2 > 0) {
                System.arraycopy((Object) bArr, this.g.d(), (Object) bArr, 0, b2);
            }
            this.g.a(bArr, b2);
        }
        while (this.g.b() < 188) {
            int c2 = this.g.c();
            int a2 = fVar.a(bArr, c2, 9400 - c2);
            if (a2 == -1) {
                return -1;
            }
            this.g.b(c2 + a2);
        }
        int c3 = this.g.c();
        int d2 = this.g.d();
        int i2 = d2;
        while (true) {
            i = i2;
            if (i >= c3 || bArr[i] == 71) {
                break;
            }
            i2 = i + 1;
        }
        this.g.c(i);
        int i3 = i + 188;
        if (i3 > c3) {
            int i4 = (i - d2) + this.p;
            this.p = i4;
            if (this.e != 2 || i4 <= 376) {
                return 0;
            }
            throw new com.opos.exoplayer.core.o("Cannot find sync byte. Most likely not a Transport Stream.");
        }
        this.p = 0;
        int o = this.g.o();
        if ((8388608 & o) == 0) {
            boolean z = (4194304 & o) != 0;
            int i5 = (2096896 & o) >> 8;
            boolean z2 = (o & 32) != 0;
            u uVar = (o & 16) != 0 ? this.j.get(i5) : null;
            if (uVar != null) {
                if (this.e != 2) {
                    int i6 = o & 15;
                    int i7 = this.h.get(i5, i6 - 1);
                    this.h.put(i5, i6);
                    if (i7 != i6) {
                        if (i6 != ((i7 + 1) & 15)) {
                            uVar.a();
                        }
                    }
                }
                if (z2) {
                    this.g.d(this.g.g());
                }
                this.g.b(i3);
                uVar.a(this.g, z);
                this.g.b(c3);
            }
        }
        this.g.c(i3);
        return 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        int size = this.f.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.g.a();
                this.h.clear();
                e();
                this.p = 0;
                return;
            }
            this.f.get(i2).d();
            i = i2 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.l = gVar;
        gVar.a(new l.b(com.anythink.expressad.exoplayer.b.b));
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        byte[] bArr = this.g.f25496a;
        fVar.c(bArr, 0, 940);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 188) {
                return false;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 == 5) {
                    fVar.b(i2);
                    return true;
                } else if (bArr[(i4 * 188) + i2] != 71) {
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
