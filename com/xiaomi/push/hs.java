package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hs.class */
public class hs implements ir<hs, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f547a;

    /* renamed from: a  reason: collision with other field name */
    public ht f548a;

    /* renamed from: a  reason: collision with other field name */
    public hv f549a;

    /* renamed from: a  reason: collision with other field name */
    public String f550a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f551a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f552a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f553b;

    /* renamed from: b  reason: collision with other field name */
    public String f554b;

    /* renamed from: c  reason: collision with other field name */
    public long f555c;

    /* renamed from: c  reason: collision with other field name */
    public String f556c;

    /* renamed from: d  reason: collision with other field name */
    public String f557d;

    /* renamed from: e  reason: collision with other field name */
    public String f558e;

    /* renamed from: f  reason: collision with other field name */
    public String f559f;

    /* renamed from: g  reason: collision with other field name */
    public String f560g;

    /* renamed from: h  reason: collision with other field name */
    public String f561h;

    /* renamed from: i  reason: collision with other field name */
    public String f562i;

    /* renamed from: j  reason: collision with other field name */
    public String f563j;

    /* renamed from: k  reason: collision with other field name */
    public String f564k;

    /* renamed from: l  reason: collision with other field name */
    public String f565l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f546a = new jh("PushMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27800a = new iz("", (byte) 12, 1);
    private static final iz b = new iz("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27801c = new iz("", (byte) 11, 3);
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
            int compareTo = Boolean.valueOf(m8838a()).compareTo(Boolean.valueOf(hsVar.m8838a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8838a() || (a19 = is.a(this.f549a, hsVar.f549a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8840b()).compareTo(Boolean.valueOf(hsVar.m8840b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8840b() || (a18 = is.a(this.f550a, hsVar.f550a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m8841c()).compareTo(Boolean.valueOf(hsVar.m8841c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m8841c() || (a17 = is.a(this.f554b, hsVar.f554b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hsVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a16 = is.a(this.f556c, hsVar.f556c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a15 = is.a(this.f547a, hsVar.f547a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a14 = is.a(this.f553b, hsVar.f553b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hsVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a13 = is.a(this.f557d, hsVar.f557d)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a12 = is.a(this.f558e, hsVar.f558e)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a11 = is.a(this.f559f, hsVar.f559f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hsVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a10 = is.a(this.f560g, hsVar.f560g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a9 = is.a(this.f561h, hsVar.f561h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hsVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a8 = is.a(this.f548a, hsVar.f548a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hsVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a7 = is.a(this.f562i, hsVar.f562i)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hsVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a6 = is.a(this.f552a, hsVar.f552a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hsVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a5 = is.a(this.f563j, hsVar.f563j)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hsVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a4 = is.a(this.f555c, hsVar.f555c)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hsVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a3 = is.a(this.f564k, hsVar.f564k)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hsVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a2 = is.a(this.f565l, hsVar.f565l)) == 0) {
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
        return this.f547a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8836a() {
        return this.f550a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8837a() {
        if (this.f550a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f554b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f556c != null) {
        } else {
            throw new jd("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                m8837a();
                return;
            }
            short s = mo8982a.f840a;
            if (s == 20) {
                if (mo8982a.f27852a == 11) {
                    this.f564k = jcVar.mo8987a();
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else if (s != 21) {
                switch (s) {
                    case 1:
                        if (mo8982a.f27852a == 12) {
                            hv hvVar = new hv();
                            this.f549a = hvVar;
                            hvVar.a(jcVar);
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 2:
                        if (mo8982a.f27852a == 11) {
                            this.f550a = jcVar.mo8987a();
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 3:
                        if (mo8982a.f27852a == 11) {
                            this.f554b = jcVar.mo8987a();
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 4:
                        if (mo8982a.f27852a == 11) {
                            this.f556c = jcVar.mo8987a();
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 5:
                        if (mo8982a.f27852a == 10) {
                            this.f547a = jcVar.mo8981a();
                            a(true);
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 6:
                        if (mo8982a.f27852a == 10) {
                            this.f553b = jcVar.mo8981a();
                            b(true);
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 7:
                        if (mo8982a.f27852a == 11) {
                            this.f557d = jcVar.mo8987a();
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 8:
                        if (mo8982a.f27852a == 11) {
                            this.f558e = jcVar.mo8987a();
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 9:
                        if (mo8982a.f27852a == 11) {
                            this.f559f = jcVar.mo8987a();
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 10:
                        if (mo8982a.f27852a == 11) {
                            this.f560g = jcVar.mo8987a();
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 11:
                        if (mo8982a.f27852a == 11) {
                            this.f561h = jcVar.mo8987a();
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 12:
                        if (mo8982a.f27852a == 12) {
                            ht htVar = new ht();
                            this.f548a = htVar;
                            htVar.a(jcVar);
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 13:
                        if (mo8982a.f27852a == 11) {
                            this.f562i = jcVar.mo8987a();
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 14:
                        if (mo8982a.f27852a == 2) {
                            this.f552a = jcVar.mo8992a();
                            c(true);
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 15:
                        if (mo8982a.f27852a == 11) {
                            this.f563j = jcVar.mo8987a();
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    case 16:
                        if (mo8982a.f27852a == 10) {
                            this.f555c = jcVar.mo8981a();
                            d(true);
                            break;
                        }
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                    default:
                        jf.a(jcVar, mo8982a.f27852a);
                        break;
                }
                jcVar.g();
            } else {
                if (mo8982a.f27852a == 11) {
                    this.f565l = jcVar.mo8987a();
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            }
        }
    }

    public void a(boolean z) {
        this.f551a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8838a() {
        return this.f549a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8839a(hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean m8838a = m8838a();
        boolean m8838a2 = hsVar.m8838a();
        if ((m8838a || m8838a2) && !(m8838a && m8838a2 && this.f549a.m8859a(hsVar.f549a))) {
            return false;
        }
        boolean m8840b = m8840b();
        boolean m8840b2 = hsVar.m8840b();
        if ((m8840b || m8840b2) && !(m8840b && m8840b2 && this.f550a.equals(hsVar.f550a))) {
            return false;
        }
        boolean m8841c = m8841c();
        boolean m8841c2 = hsVar.m8841c();
        if ((m8841c || m8841c2) && !(m8841c && m8841c2 && this.f554b.equals(hsVar.f554b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hsVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f556c.equals(hsVar.f556c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hsVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f547a == hsVar.f547a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hsVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f553b == hsVar.f553b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hsVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f557d.equals(hsVar.f557d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hsVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f558e.equals(hsVar.f558e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hsVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f559f.equals(hsVar.f559f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hsVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f560g.equals(hsVar.f560g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hsVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f561h.equals(hsVar.f561h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hsVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f548a.m8849a(hsVar.f548a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hsVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f562i.equals(hsVar.f562i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hsVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f552a == hsVar.f552a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hsVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f563j.equals(hsVar.f563j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hsVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f555c == hsVar.f555c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hsVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f564k.equals(hsVar.f564k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hsVar.r();
        if (r2 || r3) {
            return r2 && r3 && this.f565l.equals(hsVar.f565l);
        }
        return true;
    }

    public String b() {
        return this.f554b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8837a();
        jcVar.a(f546a);
        if (this.f549a != null && m8838a()) {
            jcVar.a(f27800a);
            this.f549a.b(jcVar);
            jcVar.b();
        }
        if (this.f550a != null) {
            jcVar.a(b);
            jcVar.a(this.f550a);
            jcVar.b();
        }
        if (this.f554b != null) {
            jcVar.a(f27801c);
            jcVar.a(this.f554b);
            jcVar.b();
        }
        if (this.f556c != null) {
            jcVar.a(d);
            jcVar.a(this.f556c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f547a);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f553b);
            jcVar.b();
        }
        if (this.f557d != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f557d);
            jcVar.b();
        }
        if (this.f558e != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f558e);
            jcVar.b();
        }
        if (this.f559f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f559f);
            jcVar.b();
        }
        if (this.f560g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f560g);
            jcVar.b();
        }
        if (this.f561h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f561h);
            jcVar.b();
        }
        if (this.f548a != null && l()) {
            jcVar.a(l);
            this.f548a.b(jcVar);
            jcVar.b();
        }
        if (this.f562i != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f562i);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f552a);
            jcVar.b();
        }
        if (this.f563j != null && o()) {
            jcVar.a(o);
            jcVar.a(this.f563j);
            jcVar.b();
        }
        if (p()) {
            jcVar.a(p);
            jcVar.a(this.f555c);
            jcVar.b();
        }
        if (this.f564k != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f564k);
            jcVar.b();
        }
        if (this.f565l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f565l);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f551a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8840b() {
        return this.f550a != null;
    }

    public String c() {
        return this.f556c;
    }

    public void c(boolean z) {
        this.f551a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8841c() {
        return this.f554b != null;
    }

    public void d(boolean z) {
        this.f551a.set(3, z);
    }

    public boolean d() {
        return this.f556c != null;
    }

    public boolean e() {
        return this.f551a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hs)) {
            return m8839a((hs) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f551a.get(1);
    }

    public boolean g() {
        return this.f557d != null;
    }

    public boolean h() {
        return this.f558e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f559f != null;
    }

    public boolean j() {
        return this.f560g != null;
    }

    public boolean k() {
        return this.f561h != null;
    }

    public boolean l() {
        return this.f548a != null;
    }

    public boolean m() {
        return this.f562i != null;
    }

    public boolean n() {
        return this.f551a.get(2);
    }

    public boolean o() {
        return this.f563j != null;
    }

    public boolean p() {
        return this.f551a.get(3);
    }

    public boolean q() {
        return this.f564k != null;
    }

    public boolean r() {
        return this.f565l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m8838a()) {
            sb.append("to:");
            hv hvVar = this.f549a;
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
        String str = this.f550a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f554b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f556c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f547a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f553b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f557d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f558e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f559f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f560g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f561h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            ht htVar = this.f548a;
            if (htVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(htVar);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f562i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f552a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f563j;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f555c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f564k;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f565l;
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
