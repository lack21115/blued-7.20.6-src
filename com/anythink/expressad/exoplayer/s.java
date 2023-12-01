package com.anythink.expressad.exoplayer;

import android.util.Pair;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.s;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/s.class */
final class s {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7728a = 100;
    private final ae.a b = new ae.a();

    /* renamed from: c  reason: collision with root package name */
    private final ae.b f7729c = new ae.b();
    private long d;
    private ae e;
    private int f;
    private boolean g;
    private q h;
    private q i;
    private q j;
    private int k;
    private Object l;
    private long m;

    private s.a a(int i, long j, long j2) {
        this.e.a(i, this.b, false);
        int a2 = this.b.a(j);
        return a2 == -1 ? new s.a(i, j2) : new s.a(i, a2, this.b.b(a2), j2);
    }

    private r a(int i, int i2, int i3, long j, long j2) {
        s.a aVar = new s.a(i, i2, i3, j2);
        boolean b = b(aVar, Long.MIN_VALUE);
        boolean a2 = a(aVar, b);
        return new r(aVar, i3 == this.b.b(i2) ? this.b.d() : 0L, Long.MIN_VALUE, j, this.e.a(aVar.f7484a, this.b, false).c(aVar.b, aVar.f7485c), b, a2);
    }

    private r a(s.a aVar, long j, long j2) {
        this.e.a(aVar.f7484a, this.b, false);
        if (aVar.a()) {
            if (this.b.b(aVar.b, aVar.f7485c)) {
                return a(aVar.f7484a, aVar.b, aVar.f7485c, j, aVar.d);
            }
            return null;
        }
        return b(aVar.f7484a, j2, aVar.d);
    }

    private r a(q qVar, long j) {
        long j2;
        r rVar = qVar.h;
        if (rVar.f) {
            int a2 = this.e.a(rVar.f7726a.f7484a, this.b, this.f7729c, this.f, this.g);
            if (a2 == -1) {
                return null;
            }
            int i = this.e.a(a2, this.b, true).f7162c;
            Object obj = this.b.b;
            long j3 = rVar.f7726a.d;
            long j4 = 0;
            if (this.e.a(i, this.f7729c, false).f == a2) {
                Pair<Integer, Long> a3 = this.e.a(this.f7729c, this.b, i, b.b, Math.max(0L, (qVar.e + rVar.e) - j));
                if (a3 == null) {
                    return null;
                }
                a2 = a3.first.intValue();
                j4 = a3.second.longValue();
                if (qVar.i == null || !qVar.i.b.equals(obj)) {
                    j2 = this.d;
                    this.d = 1 + j2;
                } else {
                    j2 = qVar.i.h.f7726a.d;
                }
            } else {
                j2 = j3;
            }
            return a(a(a2, j4, j2), j4, j4);
        }
        s.a aVar = rVar.f7726a;
        this.e.a(aVar.f7484a, this.b, false);
        if (aVar.a()) {
            int i2 = aVar.b;
            int d = this.b.d(i2);
            if (d == -1) {
                return null;
            }
            int a4 = this.b.a(i2, aVar.f7485c);
            if (a4 < d) {
                if (this.b.b(i2, a4)) {
                    return a(aVar.f7484a, i2, a4, rVar.d, aVar.d);
                }
                return null;
            }
            return b(aVar.f7484a, rVar.d, aVar.d);
        } else if (rVar.f7727c != Long.MIN_VALUE) {
            int a5 = this.b.a(rVar.f7727c);
            if (a5 == -1) {
                return b(aVar.f7484a, rVar.f7727c, aVar.d);
            }
            int b = this.b.b(a5);
            if (this.b.b(a5, b)) {
                return a(aVar.f7484a, a5, b, rVar.f7727c, aVar.d);
            }
            return null;
        } else {
            int c2 = this.b.c();
            if (c2 == 0) {
                return null;
            }
            int i3 = c2 - 1;
            if (this.b.a(i3) != Long.MIN_VALUE || this.b.c(i3)) {
                return null;
            }
            int b2 = this.b.b(i3);
            if (this.b.b(i3, b2)) {
                return a(aVar.f7484a, i3, b2, this.b.d, aVar.d);
            }
            return null;
        }
    }

    private r a(r rVar, s.a aVar) {
        long j = rVar.b;
        long j2 = rVar.f7727c;
        boolean b = b(aVar, j2);
        boolean a2 = a(aVar, b);
        this.e.a(aVar.f7484a, this.b, false);
        return new r(aVar, j, j2, rVar.d, aVar.a() ? this.b.c(aVar.b, aVar.f7485c) : j2 == Long.MIN_VALUE ? this.b.d : j2, b, a2);
    }

    private r a(u uVar) {
        return a(uVar.f7739c, uVar.e, uVar.d);
    }

    private boolean a(s.a aVar, boolean z) {
        return !this.e.a(this.e.a(aVar.f7484a, this.b, false).f7162c, this.f7729c, false).e && this.e.b(aVar.f7484a, this.b, this.f7729c, this.f, this.g) && z;
    }

    private static boolean a(q qVar, r rVar) {
        r rVar2 = qVar.h;
        return rVar2.b == rVar.b && rVar2.f7727c == rVar.f7727c && rVar2.f7726a.equals(rVar.f7726a);
    }

    private long b(int i) {
        int a2;
        Object obj = this.e.a(i, this.b, true).b;
        int i2 = this.b.f7162c;
        Object obj2 = this.l;
        if (obj2 != null && (a2 = this.e.a(obj2)) != -1 && this.e.a(a2, this.b, false).f7162c == i2) {
            return this.m;
        }
        q e = e();
        while (true) {
            q qVar = e;
            if (qVar == null) {
                q e2 = e();
                while (true) {
                    q qVar2 = e2;
                    if (qVar2 == null) {
                        long j = this.d;
                        this.d = 1 + j;
                        return j;
                    }
                    int a3 = this.e.a(qVar2.b);
                    if (a3 != -1 && this.e.a(a3, this.b, false).f7162c == i2) {
                        return qVar2.h.f7726a.d;
                    }
                    e2 = qVar2.i;
                }
            } else if (qVar.b.equals(obj)) {
                return qVar.h.f7726a.d;
            } else {
                e = qVar.i;
            }
        }
    }

    private r b(int i, long j, long j2) {
        s.a aVar = new s.a(i, j2);
        this.e.a(aVar.f7484a, this.b, false);
        int b = this.b.b(j);
        long a2 = b == -1 ? Long.MIN_VALUE : this.b.a(b);
        boolean b2 = b(aVar, a2);
        return new r(aVar, j, a2, b.b, a2 == Long.MIN_VALUE ? this.b.d : a2, b2, a(aVar, b2));
    }

    private boolean b(s.a aVar, long j) {
        int c2 = this.e.a(aVar.f7484a, this.b, false).c();
        if (c2 == 0) {
            return true;
        }
        int i = c2 - 1;
        boolean a2 = aVar.a();
        if (this.b.a(i) != Long.MIN_VALUE) {
            return !a2 && j == Long.MIN_VALUE;
        }
        int d = this.b.d(i);
        if (d == -1) {
            return false;
        }
        if (a2 && aVar.b == i && aVar.f7485c == d - 1) {
            return true;
        }
        return !a2 && this.b.b(i) == d;
    }

    private boolean i() {
        q e = e();
        q qVar = e;
        if (e == null) {
            return true;
        }
        while (true) {
            int a2 = this.e.a(qVar.h.f7726a.f7484a, this.b, this.f7729c, this.f, this.g);
            while (qVar.i != null && !qVar.h.f) {
                qVar = qVar.i;
            }
            if (a2 == -1 || qVar.i == null || qVar.i.h.f7726a.f7484a != a2) {
                break;
            }
            qVar = qVar.i;
        }
        boolean a3 = a(qVar);
        qVar.h = a(qVar.h, qVar.h.f7726a);
        return (a3 && f()) ? false : true;
    }

    public final com.anythink.expressad.exoplayer.h.r a(z[] zVarArr, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.j.b bVar, com.anythink.expressad.exoplayer.h.s sVar, Object obj, r rVar) {
        q qVar = this.j;
        q qVar2 = new q(zVarArr, qVar == null ? rVar.b : qVar.e + this.j.h.e, hVar, bVar, sVar, obj, rVar);
        if (this.j != null) {
            com.anythink.expressad.exoplayer.k.a.b(f());
            this.j.i = qVar2;
        }
        this.l = null;
        this.j = qVar2;
        this.k++;
        return qVar2.f7724a;
    }

    public final s.a a(int i, long j) {
        long j2;
        int a2;
        Object obj = this.e.a(i, this.b, true).b;
        int i2 = this.b.f7162c;
        Object obj2 = this.l;
        if (obj2 == null || (a2 = this.e.a(obj2)) == -1 || this.e.a(a2, this.b, false).f7162c != i2) {
            q e = e();
            while (true) {
                q qVar = e;
                if (qVar == null) {
                    q e2 = e();
                    while (true) {
                        q qVar2 = e2;
                        if (qVar2 == null) {
                            j2 = this.d;
                            this.d = 1 + j2;
                            break;
                        }
                        int a3 = this.e.a(qVar2.b);
                        if (a3 != -1 && this.e.a(a3, this.b, false).f7162c == i2) {
                            j2 = qVar2.h.f7726a.d;
                            break;
                        }
                        e2 = qVar2.i;
                    }
                } else if (qVar.b.equals(obj)) {
                    j2 = qVar.h.f7726a.d;
                    break;
                } else {
                    e = qVar.i;
                }
            }
        } else {
            j2 = this.m;
        }
        return a(i, j, j2);
    }

    public final r a(long j, u uVar) {
        q qVar = this.j;
        return qVar == null ? a(uVar.f7739c, uVar.e, uVar.d) : a(qVar, j);
    }

    public final r a(r rVar, int i) {
        return a(rVar, rVar.f7726a.a(i));
    }

    public final void a(long j) {
        q qVar = this.j;
        if (qVar == null || !qVar.f) {
            return;
        }
        qVar.f7724a.a_(j - qVar.e);
    }

    public final void a(ae aeVar) {
        this.e = aeVar;
    }

    public final boolean a() {
        q qVar = this.j;
        if (qVar != null) {
            return !qVar.h.g && this.j.a() && this.j.h.e != b.b && this.k < 100;
        }
        return true;
    }

    public final boolean a(int i) {
        this.f = i;
        return i();
    }

    public final boolean a(com.anythink.expressad.exoplayer.h.r rVar) {
        q qVar = this.j;
        return qVar != null && qVar.f7724a == rVar;
    }

    public final boolean a(s.a aVar, long j) {
        int i = aVar.f7484a;
        q e = e();
        q qVar = null;
        while (e != null) {
            if (qVar == null) {
                e.h = a(e.h, i);
            } else if (i == -1 || !e.b.equals(this.e.a(i, this.b, true).b)) {
                return !a(qVar);
            } else {
                r a2 = a(qVar, j);
                if (a2 == null) {
                    return !a(qVar);
                }
                e.h = a(e.h, i);
                r rVar = e.h;
                if (!(rVar.b == a2.b && rVar.f7727c == a2.f7727c && rVar.f7726a.equals(a2.f7726a))) {
                    return !a(qVar);
                }
            }
            int i2 = i;
            if (e.h.f) {
                i2 = this.e.a(i, this.b, this.f7729c, this.f, this.g);
            }
            qVar = e;
            e = e.i;
            i = i2;
        }
        return true;
    }

    public final boolean a(q qVar) {
        com.anythink.expressad.exoplayer.k.a.b(qVar != null);
        this.j = qVar;
        boolean z = false;
        while (qVar.i != null) {
            qVar = qVar.i;
            if (qVar == this.i) {
                this.i = this.h;
                z = true;
            }
            qVar.c();
            this.k--;
        }
        this.j.i = null;
        return z;
    }

    public final boolean a(boolean z) {
        this.g = z;
        return i();
    }

    public final q b() {
        return this.j;
    }

    public final void b(boolean z) {
        q e = e();
        if (e != null) {
            this.l = z ? e.b : null;
            this.m = e.h.f7726a.d;
            e.c();
            a(e);
        } else if (!z) {
            this.l = null;
        }
        this.h = null;
        this.j = null;
        this.i = null;
        this.k = 0;
    }

    public final q c() {
        return this.h;
    }

    public final q d() {
        return this.i;
    }

    public final q e() {
        return f() ? this.h : this.j;
    }

    public final boolean f() {
        return this.h != null;
    }

    public final q g() {
        q qVar = this.i;
        com.anythink.expressad.exoplayer.k.a.b((qVar == null || qVar.i == null) ? false : true);
        q qVar2 = this.i.i;
        this.i = qVar2;
        return qVar2;
    }

    public final q h() {
        q qVar = this.h;
        if (qVar != null) {
            if (qVar == this.i) {
                this.i = qVar.i;
            }
            this.h.c();
            int i = this.k - 1;
            this.k = i;
            if (i == 0) {
                this.j = null;
                this.l = this.h.b;
                this.m = this.h.h.f7726a.d;
            }
            this.h = this.h.i;
        } else {
            q qVar2 = this.j;
            this.h = qVar2;
            this.i = qVar2;
        }
        return this.h;
    }
}
