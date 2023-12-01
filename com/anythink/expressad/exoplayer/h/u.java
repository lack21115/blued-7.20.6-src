package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.h.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/u.class */
final class u implements r, r.a {

    /* renamed from: a  reason: collision with root package name */
    public final r[] f7508a;

    /* renamed from: c  reason: collision with root package name */
    private final h f7509c;
    private r.a e;
    private af f;
    private r[] g;
    private z h;
    private final ArrayList<r> d = new ArrayList<>();
    private final IdentityHashMap<y, Integer> b = new IdentityHashMap<>();

    public u(h hVar, r... rVarArr) {
        this.f7509c = hVar;
        this.f7508a = rVarArr;
        this.h = hVar.a(new z[0]);
    }

    private void f() {
        this.e.a((r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j, com.anythink.expressad.exoplayer.ac acVar) {
        return this.g[0].a(j, acVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j) {
        boolean z;
        boolean z2;
        int[] iArr = new int[fVarArr.length];
        int[] iArr2 = new int[fVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fVarArr.length) {
                break;
            }
            iArr[i2] = yVarArr[i2] == null ? -1 : this.b.get(yVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                ae f = fVarArr[i2].f();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    r[] rVarArr = this.f7508a;
                    if (i4 >= rVarArr.length) {
                        break;
                    } else if (rVarArr[i4].b().a(f) != -1) {
                        iArr2[i2] = i4;
                        break;
                    } else {
                        i3 = i4 + 1;
                    }
                }
            }
            i = i2 + 1;
        }
        this.b.clear();
        int length = fVarArr.length;
        y[] yVarArr2 = new y[length];
        y[] yVarArr3 = new y[fVarArr.length];
        com.anythink.expressad.exoplayer.i.f[] fVarArr2 = new com.anythink.expressad.exoplayer.i.f[fVarArr.length];
        ArrayList arrayList = new ArrayList(this.f7508a.length);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.f7508a.length) {
                System.arraycopy(yVarArr2, 0, yVarArr, 0, length);
                r[] rVarArr2 = new r[arrayList.size()];
                this.g = rVarArr2;
                arrayList.toArray(rVarArr2);
                this.h = this.f7509c.a(this.g);
                return j;
            }
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= fVarArr.length) {
                    break;
                }
                yVarArr3[i8] = iArr[i8] == i6 ? yVarArr[i8] : null;
                com.anythink.expressad.exoplayer.i.f fVar = null;
                if (iArr2[i8] == i6) {
                    fVar = fVarArr[i8];
                }
                fVarArr2[i8] = fVar;
                i7 = i8 + 1;
            }
            long a2 = this.f7508a[i6].a(fVarArr2, zArr, yVarArr3, zArr2, j);
            if (i6 == 0) {
                j = a2;
            } else if (a2 != j) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            int i9 = 0;
            boolean z3 = false;
            while (true) {
                z = z3;
                if (i9 >= fVarArr.length) {
                    break;
                }
                boolean z4 = true;
                if (iArr2[i9] == i6) {
                    com.anythink.expressad.exoplayer.k.a.b(yVarArr3[i9] != null);
                    yVarArr2[i9] = yVarArr3[i9];
                    this.b.put(yVarArr3[i9], Integer.valueOf(i6));
                    z2 = true;
                } else {
                    z2 = z;
                    if (iArr[i9] == i6) {
                        if (yVarArr3[i9] != null) {
                            z4 = false;
                        }
                        com.anythink.expressad.exoplayer.k.a.b(z4);
                        z2 = z;
                    }
                }
                i9++;
                z3 = z2;
            }
            if (z) {
                arrayList.add(this.f7508a[i6]);
            }
            i5 = i6 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
        r[] rVarArr = this.f7508a;
        int length = rVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            rVarArr[i2].a();
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j, boolean z) {
        r[] rVarArr = this.g;
        int length = rVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            rVarArr[i2].a(j, z);
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(r.a aVar, long j) {
        this.e = aVar;
        Collections.addAll(this.d, this.f7508a);
        r[] rVarArr = this.f7508a;
        int length = rVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            rVarArr[i2].a(this, j);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.anythink.expressad.exoplayer.h.r.a
    public final void a(r rVar) {
        this.d.remove(rVar);
        if (this.d.isEmpty()) {
            int i = 0;
            for (r rVar2 : this.f7508a) {
                i += rVar2.b().b;
            }
            ae[] aeVarArr = new ae[i];
            int i2 = 0;
            for (r rVar3 : this.f7508a) {
                af b = rVar3.b();
                int i3 = b.b;
                int i4 = 0;
                while (i4 < i3) {
                    aeVarArr[i2] = b.a(i4);
                    i4++;
                    i2++;
                }
            }
            this.f = new af(aeVarArr);
            this.e.a((r) this);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.z.a
    public final /* bridge */ /* synthetic */ void a(r rVar) {
        this.e.a((r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
        this.h.a_(j);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long b(long j) {
        long b = this.g[0].b(j);
        int i = 1;
        while (true) {
            int i2 = i;
            r[] rVarArr = this.g;
            if (i2 >= rVarArr.length) {
                return b;
            }
            if (rVarArr[i2].b(b) != b) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final af b() {
        return this.f;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        long c2 = this.f7508a[0].c();
        int i = 1;
        while (true) {
            int i2 = i;
            r[] rVarArr = this.f7508a;
            if (i2 >= rVarArr.length) {
                if (c2 != com.anythink.expressad.exoplayer.b.b) {
                    r[] rVarArr2 = this.g;
                    int length = rVarArr2.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length) {
                            break;
                        }
                        r rVar = rVarArr2[i4];
                        if (rVar != this.f7508a[0] && rVar.b(c2) != c2) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                        i3 = i4 + 1;
                    }
                }
                return c2;
            } else if (rVarArr[i2].c() != com.anythink.expressad.exoplayer.b.b) {
                throw new IllegalStateException("Child reported discontinuity.");
            } else {
                i = i2 + 1;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        if (this.d.isEmpty()) {
            return this.h.c(j);
        }
        int size = this.d.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            this.d.get(i2).c(j);
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        return this.h.d();
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        return this.h.e();
    }
}
