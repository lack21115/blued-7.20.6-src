package com.opos.exoplayer.core;

import android.util.Pair;
import com.opos.exoplayer.core.e.e;
import com.opos.exoplayer.core.y;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/ad.class */
final class ad {

    /* renamed from: a  reason: collision with root package name */
    private final y.a f25061a = new y.a();
    private final y.b b = new y.b();

    /* renamed from: c  reason: collision with root package name */
    private long f25062c;
    private y d;
    private int e;
    private boolean f;
    private ab g;
    private ab h;
    private ab i;
    private int j;

    private ac a(int i, int i2, int i3, long j, long j2) {
        e.b bVar = new e.b(i, i2, i3, j2);
        boolean b = b(bVar, Long.MIN_VALUE);
        boolean a2 = a(bVar, b);
        return new ac(bVar, i3 == this.f25061a.b(i2) ? this.f25061a.e() : 0L, Long.MIN_VALUE, j, this.d.a(bVar.f25286a, this.f25061a).c(bVar.b, bVar.f25287c), b, a2);
    }

    private ac a(ab abVar, long j) {
        int i;
        int b;
        long a2;
        int i2;
        long j2;
        int i3;
        long j3;
        long j4;
        ac acVar = abVar.h;
        if (acVar.f) {
            int a3 = this.d.a(acVar.f25059a.f25286a, this.f25061a, this.b, this.e, this.f);
            if (a3 == -1) {
                return null;
            }
            int i4 = this.d.a(a3, this.f25061a, true).f25595c;
            Object obj = this.f25061a.b;
            long j5 = acVar.f25059a.d;
            long j6 = 0;
            if (this.d.a(i4, this.b).f == a3) {
                Pair<Integer, Long> a4 = this.d.a(this.b, this.f25061a, i4, com.anythink.expressad.exoplayer.b.b, Math.max(0L, (abVar.a() + acVar.e) - j));
                if (a4 == null) {
                    return null;
                }
                a3 = a4.first.intValue();
                j6 = a4.second.longValue();
                if (abVar.i == null || !abVar.i.b.equals(obj)) {
                    j4 = this.f25062c;
                    this.f25062c = 1 + j4;
                } else {
                    j4 = abVar.i.h.f25059a.d;
                }
            } else {
                j4 = j5;
            }
            return a(a(a3, j6, j4), j6, j6);
        }
        e.b bVar = acVar.f25059a;
        this.d.a(bVar.f25286a, this.f25061a);
        if (bVar.a()) {
            i = bVar.b;
            int d = this.f25061a.d(i);
            if (d == -1) {
                return null;
            }
            b = this.f25061a.a(i, bVar.f25287c);
            if (b >= d) {
                i3 = bVar.f25286a;
                j3 = acVar.d;
                return b(i3, j3, bVar.d);
            } else if (this.f25061a.b(i, b)) {
                i2 = bVar.f25286a;
                a2 = acVar.d;
                j2 = bVar.d;
                return a(i2, i, b, a2, j2);
            } else {
                return null;
            }
        }
        if (acVar.f25060c != Long.MIN_VALUE) {
            i = this.f25061a.a(acVar.f25060c);
            if (i == -1) {
                i3 = bVar.f25286a;
                j3 = acVar.f25060c;
                return b(i3, j3, bVar.d);
            }
            b = this.f25061a.b(i);
            if (!this.f25061a.b(i, b)) {
                return null;
            }
            i2 = bVar.f25286a;
            a2 = acVar.f25060c;
            j2 = bVar.d;
        } else {
            int d2 = this.f25061a.d();
            if (d2 == 0) {
                return null;
            }
            i = d2 - 1;
            if (this.f25061a.a(i) != Long.MIN_VALUE || this.f25061a.c(i)) {
                return null;
            }
            b = this.f25061a.b(i);
            if (!this.f25061a.b(i, b)) {
                return null;
            }
            a2 = this.f25061a.a();
            i2 = bVar.f25286a;
            j2 = bVar.d;
        }
        return a(i2, i, b, a2, j2);
    }

    private ac a(ac acVar, e.b bVar) {
        long j = acVar.b;
        long j2 = acVar.f25060c;
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.d.a(bVar.f25286a, this.f25061a);
        return new ac(bVar, j, j2, acVar.d, bVar.a() ? this.f25061a.c(bVar.b, bVar.f25287c) : j2 == Long.MIN_VALUE ? this.f25061a.a() : j2, b, a2);
    }

    private ac a(ae aeVar) {
        return a(aeVar.f25064c, aeVar.e, aeVar.d);
    }

    private ac a(e.b bVar, long j, long j2) {
        this.d.a(bVar.f25286a, this.f25061a);
        if (bVar.a()) {
            if (this.f25061a.b(bVar.b, bVar.f25287c)) {
                return a(bVar.f25286a, bVar.b, bVar.f25287c, j, bVar.d);
            }
            return null;
        }
        return b(bVar.f25286a, j2, bVar.d);
    }

    private e.b a(int i, long j, long j2) {
        this.d.a(i, this.f25061a);
        int a2 = this.f25061a.a(j);
        return a2 == -1 ? new e.b(i, j2) : new e.b(i, a2, this.f25061a.b(a2), j2);
    }

    private boolean a(ab abVar, ac acVar) {
        ac acVar2 = abVar.h;
        return acVar2.b == acVar.b && acVar2.f25060c == acVar.f25060c && acVar2.f25059a.equals(acVar.f25059a);
    }

    private boolean a(e.b bVar, boolean z) {
        return !this.d.a(this.d.a(bVar.f25286a, this.f25061a).f25595c, this.b).e && this.d.b(bVar.f25286a, this.f25061a, this.b, this.e, this.f) && z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
        return r11.h.f25059a.d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long b(int r7) {
        /*
            r6 = this;
            r0 = r6
            com.opos.exoplayer.core.y r0 = r0.d
            r1 = r7
            r2 = r6
            com.opos.exoplayer.core.y$a r2 = r2.f25061a
            r3 = 1
            com.opos.exoplayer.core.y$a r0 = r0.a(r1, r2, r3)
            java.lang.Object r0 = r0.b
            r12 = r0
            r0 = r6
            com.opos.exoplayer.core.ab r0 = r0.e()
            r11 = r0
        L18:
            r0 = r11
            if (r0 == 0) goto L40
            r0 = r11
            java.lang.Object r0 = r0.b
            r1 = r12
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
        L2a:
            r0 = r11
            com.opos.exoplayer.core.ac r0 = r0.h
            com.opos.exoplayer.core.e.e$b r0 = r0.f25059a
            long r0 = r0.d
            return r0
        L36:
            r0 = r11
            com.opos.exoplayer.core.ab r0 = r0.i
            r11 = r0
            goto L18
        L40:
            r0 = r6
            com.opos.exoplayer.core.y$a r0 = r0.f25061a
            int r0 = r0.f25595c
            r7 = r0
            r0 = r6
            com.opos.exoplayer.core.ab r0 = r0.e()
            r11 = r0
        L4e:
            r0 = r11
            if (r0 == 0) goto L85
            r0 = r6
            com.opos.exoplayer.core.y r0 = r0.d
            r1 = r11
            java.lang.Object r1 = r1.b
            int r0 = r0.a(r1)
            r8 = r0
            r0 = r8
            r1 = -1
            if (r0 == r1) goto L7b
            r0 = r6
            com.opos.exoplayer.core.y r0 = r0.d
            r1 = r8
            r2 = r6
            com.opos.exoplayer.core.y$a r2 = r2.f25061a
            com.opos.exoplayer.core.y$a r0 = r0.a(r1, r2)
            int r0 = r0.f25595c
            r1 = r7
            if (r0 != r1) goto L7b
            goto L2a
        L7b:
            r0 = r11
            com.opos.exoplayer.core.ab r0 = r0.i
            r11 = r0
            goto L4e
        L85:
            r0 = r6
            long r0 = r0.f25062c
            r9 = r0
            r0 = r6
            r1 = 1
            r2 = r9
            long r1 = r1 + r2
            r0.f25062c = r1
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.ad.b(int):long");
    }

    private ac b(int i, long j, long j2) {
        e.b bVar = new e.b(i, j2);
        this.d.a(bVar.f25286a, this.f25061a);
        int b = this.f25061a.b(j);
        long a2 = b == -1 ? Long.MIN_VALUE : this.f25061a.a(b);
        boolean b2 = b(bVar, a2);
        return new ac(bVar, j, a2, com.anythink.expressad.exoplayer.b.b, a2 == Long.MIN_VALUE ? this.f25061a.a() : a2, b2, a(bVar, b2));
    }

    private boolean b(e.b bVar, long j) {
        int d = this.d.a(bVar.f25286a, this.f25061a).d();
        if (d == 0) {
            return true;
        }
        int i = d - 1;
        boolean a2 = bVar.a();
        if (this.f25061a.a(i) != Long.MIN_VALUE) {
            return !a2 && j == Long.MIN_VALUE;
        }
        int d2 = this.f25061a.d(i);
        if (d2 == -1) {
            return false;
        }
        if (a2 && bVar.b == i && bVar.f25287c == d2 - 1) {
            return true;
        }
        return !a2 && this.f25061a.b(i) == d2;
    }

    private boolean j() {
        ab e = e();
        boolean z = true;
        ab abVar = e;
        if (e == null) {
            return true;
        }
        while (true) {
            int a2 = this.d.a(abVar.h.f25059a.f25286a, this.f25061a, this.b, this.e, this.f);
            while (abVar.i != null && !abVar.h.f) {
                abVar = abVar.i;
            }
            if (a2 == -1 || abVar.i == null || abVar.i.h.f25059a.f25286a != a2) {
                break;
            }
            abVar = abVar.i;
        }
        boolean a3 = a(abVar);
        abVar.h = a(abVar.h, abVar.h.f25059a);
        if (a3) {
            if (!f()) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public ac a(long j, ae aeVar) {
        ab abVar = this.i;
        return abVar == null ? a(aeVar) : a(abVar, j);
    }

    public ac a(ac acVar, int i) {
        return a(acVar, acVar.f25059a.a(i));
    }

    public com.opos.exoplayer.core.e.d a(t[] tVarArr, long j, com.opos.exoplayer.core.g.h hVar, com.opos.exoplayer.core.h.b bVar, com.opos.exoplayer.core.e.e eVar, Object obj, ac acVar) {
        long a2;
        ab abVar = this.i;
        if (abVar == null) {
            a2 = acVar.b + j;
        } else {
            a2 = this.i.h.e + abVar.a();
        }
        ab abVar2 = new ab(tVarArr, a2, hVar, bVar, eVar, obj, acVar);
        if (this.i != null) {
            com.opos.exoplayer.core.i.a.b(f());
            this.i.i = abVar2;
        }
        this.i = abVar2;
        this.j++;
        return abVar2.f25057a;
    }

    public e.b a(int i, long j) {
        return a(i, j, b(i));
    }

    public com.opos.exoplayer.core.g.i a(float f) {
        return this.i.a(f);
    }

    public void a(long j) {
        ab abVar = this.i;
        if (abVar != null) {
            abVar.c(j);
        }
    }

    public void a(y yVar) {
        this.d = yVar;
    }

    public boolean a() {
        ab abVar = this.i;
        if (abVar != null) {
            return !abVar.h.g && this.i.b() && this.i.h.e != com.anythink.expressad.exoplayer.b.b && this.j < 100;
        }
        return true;
    }

    public boolean a(int i) {
        this.e = i;
        return j();
    }

    public boolean a(ab abVar) {
        com.opos.exoplayer.core.i.a.b(abVar != null);
        this.i = abVar;
        boolean z = false;
        while (abVar.i != null) {
            abVar = abVar.i;
            if (abVar == this.h) {
                this.h = this.g;
                z = true;
            }
            abVar.d();
            this.j--;
        }
        this.i.i = null;
        return z;
    }

    public boolean a(com.opos.exoplayer.core.e.d dVar) {
        ab abVar = this.i;
        return abVar != null && abVar.f25057a == dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cd, code lost:
        if (a(r14) != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.opos.exoplayer.core.e.e.b r8, long r9) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.ad.a(com.opos.exoplayer.core.e.e$b, long):boolean");
    }

    public boolean a(boolean z) {
        this.f = z;
        return j();
    }

    public ab b() {
        return this.i;
    }

    public ab c() {
        return this.g;
    }

    public ab d() {
        return this.h;
    }

    public ab e() {
        return f() ? this.g : this.i;
    }

    public boolean f() {
        return this.g != null;
    }

    public ab g() {
        ab abVar = this.h;
        com.opos.exoplayer.core.i.a.b((abVar == null || abVar.i == null) ? false : true);
        ab abVar2 = this.h.i;
        this.h = abVar2;
        return abVar2;
    }

    public ab h() {
        ab abVar = this.g;
        if (abVar != null) {
            if (abVar == this.h) {
                this.h = abVar.i;
            }
            this.g.d();
            this.g = this.g.i;
            int i = this.j - 1;
            this.j = i;
            if (i == 0) {
                this.i = null;
            }
        } else {
            ab abVar2 = this.i;
            this.g = abVar2;
            this.h = abVar2;
        }
        return this.g;
    }

    public void i() {
        ab e = e();
        if (e != null) {
            e.d();
            a(e);
        }
        this.g = null;
        this.i = null;
        this.h = null;
        this.j = 0;
    }
}
