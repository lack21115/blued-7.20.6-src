package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hs.class */
public class hs implements ir<hs, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f594a;

    /* renamed from: a  reason: collision with other field name */
    public ht f595a;

    /* renamed from: a  reason: collision with other field name */
    public hv f596a;

    /* renamed from: a  reason: collision with other field name */
    public String f597a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f598a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f599a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f600b;

    /* renamed from: b  reason: collision with other field name */
    public String f601b;

    /* renamed from: c  reason: collision with other field name */
    public long f602c;

    /* renamed from: c  reason: collision with other field name */
    public String f603c;

    /* renamed from: d  reason: collision with other field name */
    public String f604d;

    /* renamed from: e  reason: collision with other field name */
    public String f605e;

    /* renamed from: f  reason: collision with other field name */
    public String f606f;

    /* renamed from: g  reason: collision with other field name */
    public String f607g;

    /* renamed from: h  reason: collision with other field name */
    public String f608h;

    /* renamed from: i  reason: collision with other field name */
    public String f609i;

    /* renamed from: j  reason: collision with other field name */
    public String f610j;

    /* renamed from: k  reason: collision with other field name */
    public String f611k;

    /* renamed from: l  reason: collision with other field name */
    public String f612l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f593a = new jh("PushMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41491a = new iz("", (byte) 12, 1);
    private static final iz b = new iz("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41492c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", (byte) 10, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 11, 8);
    private static final iz i = new iz("", (byte) 11, 9);
    private static final iz j = new iz("", (byte) 11, 10);
    private static final iz k = new iz("", (byte) 11, 11);
    private static final iz l = new iz("", (byte) 12, 12);
    private static final iz m = new iz("", (byte) 11, 13);
    private static final iz n = new iz("", (byte) 2, 14);
    private static final iz o = new iz("", (byte) 11, 15);
    private static final iz p = new iz("", (byte) 10, 16);
    private static final iz q = new iz("", (byte) 11, 20);
    private static final iz r = new iz("", (byte) 11, 21);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hs hsVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        if (getClass().equals(hsVar.getClass())) {
            int compareTo = Boolean.valueOf(m11888a()).compareTo(Boolean.valueOf(hsVar.m11888a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11888a() || (a19 = is.a(this.f596a, hsVar.f596a)) == 0) {
                int compareTo2 = Boolean.valueOf(m11890b()).compareTo(Boolean.valueOf(hsVar.m11890b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m11890b() || (a18 = is.a(this.f597a, hsVar.f597a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m11891c()).compareTo(Boolean.valueOf(hsVar.m11891c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m11891c() || (a17 = is.a(this.f601b, hsVar.f601b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hsVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a16 = is.a(this.f603c, hsVar.f603c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a15 = is.a(this.f594a, hsVar.f594a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a14 = is.a(this.f600b, hsVar.f600b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hsVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a13 = is.a(this.f604d, hsVar.f604d)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a12 = is.a(this.f605e, hsVar.f605e)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a11 = is.a(this.f606f, hsVar.f606f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hsVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a10 = is.a(this.f607g, hsVar.f607g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a9 = is.a(this.f608h, hsVar.f608h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hsVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a8 = is.a(this.f595a, hsVar.f595a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hsVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a7 = is.a(this.f609i, hsVar.f609i)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hsVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a6 = is.a(this.f599a, hsVar.f599a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hsVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a5 = is.a(this.f610j, hsVar.f610j)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hsVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a4 = is.a(this.f602c, hsVar.f602c)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hsVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a3 = is.a(this.f611k, hsVar.f611k)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hsVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a2 = is.a(this.f612l, hsVar.f612l)) == 0) {
                                                                                    return 0;
                                                                                }
                                                                                return a2;
                                                                            }
                                                                            return a3;
                                                                        }
                                                                        return a4;
                                                                    }
                                                                    return a5;
                                                                }
                                                                return a6;
                                                            }
                                                            return a7;
                                                        }
                                                        return a8;
                                                    }
                                                    return a9;
                                                }
                                                return a10;
                                            }
                                            return a11;
                                        }
                                        return a12;
                                    }
                                    return a13;
                                }
                                return a14;
                            }
                            return a15;
                        }
                        return a16;
                    }
                    return a17;
                }
                return a18;
            }
            return a19;
        }
        return getClass().getName().compareTo(hsVar.getClass().getName());
    }

    public long a() {
        return this.f594a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11886a() {
        return this.f597a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11887a() {
        if (this.f597a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f601b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f603c != null) {
        } else {
            throw new jd("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                m11887a();
                return;
            }
            short s = mo12032a.f887a;
            if (s == 20) {
                if (mo12032a.f41543a == 11) {
                    this.f611k = jcVar.mo12037a();
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else if (s != 21) {
                switch (s) {
                    case 1:
                        if (mo12032a.f41543a == 12) {
                            hv hvVar = new hv();
                            this.f596a = hvVar;
                            hvVar.a(jcVar);
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 2:
                        if (mo12032a.f41543a == 11) {
                            this.f597a = jcVar.mo12037a();
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 3:
                        if (mo12032a.f41543a == 11) {
                            this.f601b = jcVar.mo12037a();
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 4:
                        if (mo12032a.f41543a == 11) {
                            this.f603c = jcVar.mo12037a();
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 5:
                        if (mo12032a.f41543a == 10) {
                            this.f594a = jcVar.mo12031a();
                            a(true);
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 6:
                        if (mo12032a.f41543a == 10) {
                            this.f600b = jcVar.mo12031a();
                            b(true);
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 7:
                        if (mo12032a.f41543a == 11) {
                            this.f604d = jcVar.mo12037a();
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 8:
                        if (mo12032a.f41543a == 11) {
                            this.f605e = jcVar.mo12037a();
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 9:
                        if (mo12032a.f41543a == 11) {
                            this.f606f = jcVar.mo12037a();
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 10:
                        if (mo12032a.f41543a == 11) {
                            this.f607g = jcVar.mo12037a();
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 11:
                        if (mo12032a.f41543a == 11) {
                            this.f608h = jcVar.mo12037a();
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 12:
                        if (mo12032a.f41543a == 12) {
                            ht htVar = new ht();
                            this.f595a = htVar;
                            htVar.a(jcVar);
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 13:
                        if (mo12032a.f41543a == 11) {
                            this.f609i = jcVar.mo12037a();
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 14:
                        if (mo12032a.f41543a == 2) {
                            this.f599a = jcVar.mo12042a();
                            c(true);
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 15:
                        if (mo12032a.f41543a == 11) {
                            this.f610j = jcVar.mo12037a();
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    case 16:
                        if (mo12032a.f41543a == 10) {
                            this.f602c = jcVar.mo12031a();
                            d(true);
                            break;
                        }
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                    default:
                        jf.a(jcVar, mo12032a.f41543a);
                        break;
                }
                jcVar.g();
            } else {
                if (mo12032a.f41543a == 11) {
                    this.f612l = jcVar.mo12037a();
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            }
        }
    }

    public void a(boolean z) {
        this.f598a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11888a() {
        return this.f596a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11889a(hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean m11888a = m11888a();
        boolean m11888a2 = hsVar.m11888a();
        if ((m11888a || m11888a2) && !(m11888a && m11888a2 && this.f596a.m11909a(hsVar.f596a))) {
            return false;
        }
        boolean m11890b = m11890b();
        boolean m11890b2 = hsVar.m11890b();
        if ((m11890b || m11890b2) && !(m11890b && m11890b2 && this.f597a.equals(hsVar.f597a))) {
            return false;
        }
        boolean m11891c = m11891c();
        boolean m11891c2 = hsVar.m11891c();
        if ((m11891c || m11891c2) && !(m11891c && m11891c2 && this.f601b.equals(hsVar.f601b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hsVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f603c.equals(hsVar.f603c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hsVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f594a == hsVar.f594a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hsVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f600b == hsVar.f600b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hsVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f604d.equals(hsVar.f604d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hsVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f605e.equals(hsVar.f605e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hsVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f606f.equals(hsVar.f606f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hsVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f607g.equals(hsVar.f607g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hsVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f608h.equals(hsVar.f608h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hsVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f595a.m11899a(hsVar.f595a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hsVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f609i.equals(hsVar.f609i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hsVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f599a == hsVar.f599a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hsVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f610j.equals(hsVar.f610j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hsVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f602c == hsVar.f602c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hsVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f611k.equals(hsVar.f611k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hsVar.r();
        if (r2 || r3) {
            return r2 && r3 && this.f612l.equals(hsVar.f612l);
        }
        return true;
    }

    public String b() {
        return this.f601b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11887a();
        jcVar.a(f593a);
        if (this.f596a != null && m11888a()) {
            jcVar.a(f41491a);
            this.f596a.b(jcVar);
            jcVar.b();
        }
        if (this.f597a != null) {
            jcVar.a(b);
            jcVar.a(this.f597a);
            jcVar.b();
        }
        if (this.f601b != null) {
            jcVar.a(f41492c);
            jcVar.a(this.f601b);
            jcVar.b();
        }
        if (this.f603c != null) {
            jcVar.a(d);
            jcVar.a(this.f603c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f594a);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f600b);
            jcVar.b();
        }
        if (this.f604d != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f604d);
            jcVar.b();
        }
        if (this.f605e != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f605e);
            jcVar.b();
        }
        if (this.f606f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f606f);
            jcVar.b();
        }
        if (this.f607g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f607g);
            jcVar.b();
        }
        if (this.f608h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f608h);
            jcVar.b();
        }
        if (this.f595a != null && l()) {
            jcVar.a(l);
            this.f595a.b(jcVar);
            jcVar.b();
        }
        if (this.f609i != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f609i);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f599a);
            jcVar.b();
        }
        if (this.f610j != null && o()) {
            jcVar.a(o);
            jcVar.a(this.f610j);
            jcVar.b();
        }
        if (p()) {
            jcVar.a(p);
            jcVar.a(this.f602c);
            jcVar.b();
        }
        if (this.f611k != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f611k);
            jcVar.b();
        }
        if (this.f612l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f612l);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f598a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11890b() {
        return this.f597a != null;
    }

    public String c() {
        return this.f603c;
    }

    public void c(boolean z) {
        this.f598a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m11891c() {
        return this.f601b != null;
    }

    public void d(boolean z) {
        this.f598a.set(3, z);
    }

    public boolean d() {
        return this.f603c != null;
    }

    public boolean e() {
        return this.f598a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hs)) {
            return m11889a((hs) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f598a.get(1);
    }

    public boolean g() {
        return this.f604d != null;
    }

    public boolean h() {
        return this.f605e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f606f != null;
    }

    public boolean j() {
        return this.f607g != null;
    }

    public boolean k() {
        return this.f608h != null;
    }

    public boolean l() {
        return this.f595a != null;
    }

    public boolean m() {
        return this.f609i != null;
    }

    public boolean n() {
        return this.f598a.get(2);
    }

    public boolean o() {
        return this.f610j != null;
    }

    public boolean p() {
        return this.f598a.get(3);
    }

    public boolean q() {
        return this.f611k != null;
    }

    public boolean r() {
        return this.f612l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m11888a()) {
            sb.append("to:");
            hv hvVar = this.f596a;
            if (hvVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(hvVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f597a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f601b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f603c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f594a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f600b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f604d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f605e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f606f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f607g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f608h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            ht htVar = this.f595a;
            if (htVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(htVar);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f609i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f599a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f610j;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f602c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f611k;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f612l;
            if (str12 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
