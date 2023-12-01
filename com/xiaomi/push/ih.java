package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ih.class */
public class ih implements ir<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f721a;

    /* renamed from: a  reason: collision with other field name */
    public long f722a;

    /* renamed from: a  reason: collision with other field name */
    public hv f723a;

    /* renamed from: a  reason: collision with other field name */
    public String f724a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f726a;

    /* renamed from: b  reason: collision with other field name */
    public int f728b;

    /* renamed from: b  reason: collision with other field name */
    public long f729b;

    /* renamed from: b  reason: collision with other field name */
    public String f730b;

    /* renamed from: c  reason: collision with other field name */
    public long f731c;

    /* renamed from: c  reason: collision with other field name */
    public String f732c;

    /* renamed from: d  reason: collision with other field name */
    public String f733d;

    /* renamed from: e  reason: collision with other field name */
    public String f734e;

    /* renamed from: f  reason: collision with other field name */
    public String f735f;

    /* renamed from: g  reason: collision with other field name */
    public String f736g;

    /* renamed from: h  reason: collision with other field name */
    public String f737h;

    /* renamed from: i  reason: collision with other field name */
    public String f738i;

    /* renamed from: j  reason: collision with other field name */
    public String f739j;

    /* renamed from: k  reason: collision with other field name */
    public String f740k;

    /* renamed from: l  reason: collision with other field name */
    public String f741l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f720a = new jh("XmPushActionRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27828a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27829c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 10, 6);
    private static final iz f = new iz("", (byte) 11, 7);
    private static final iz g = new iz("", (byte) 11, 8);
    private static final iz h = new iz("", (byte) 11, 9);
    private static final iz i = new iz("", (byte) 11, 10);
    private static final iz j = new iz("", (byte) 10, 11);
    private static final iz k = new iz("", (byte) 11, 12);
    private static final iz l = new iz("", (byte) 11, 13);
    private static final iz m = new iz("", (byte) 10, 14);
    private static final iz n = new iz("", (byte) 11, 15);
    private static final iz o = new iz("", (byte) 8, 16);
    private static final iz p = new iz("", (byte) 11, 17);
    private static final iz q = new iz("", (byte) 8, 18);
    private static final iz r = new iz("", (byte) 11, 19);
    private static final iz s = new iz("", (byte) 2, 20);
    private static final iz t = new iz("", (byte) 15, 21);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f725a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f727a = false;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ih ihVar) {
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
        int a20;
        int a21;
        if (getClass().equals(ihVar.getClass())) {
            int compareTo = Boolean.valueOf(m8932a()).compareTo(Boolean.valueOf(ihVar.m8932a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8932a() || (a21 = is.a(this.f724a, ihVar.f724a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8934b()).compareTo(Boolean.valueOf(ihVar.m8934b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8934b() || (a20 = is.a(this.f723a, ihVar.f723a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m8935c()).compareTo(Boolean.valueOf(ihVar.m8935c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m8935c() || (a19 = is.a(this.f730b, ihVar.f730b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a18 = is.a(this.f732c, ihVar.f732c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a17 = is.a(this.f722a, ihVar.f722a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a16 = is.a(this.f733d, ihVar.f733d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a15 = is.a(this.f734e, ihVar.f734e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a14 = is.a(this.f735f, ihVar.f735f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a13 = is.a(this.f736g, ihVar.f736g)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a12 = is.a(this.f729b, ihVar.f729b)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ihVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a11 = is.a(this.f737h, ihVar.f737h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ihVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a10 = is.a(this.f738i, ihVar.f738i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ihVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a9 = is.a(this.f731c, ihVar.f731c)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ihVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a8 = is.a(this.f739j, ihVar.f739j)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ihVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a7 = is.a(this.f721a, ihVar.f721a)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ihVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a6 = is.a(this.f740k, ihVar.f740k)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ihVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a5 = is.a(this.f728b, ihVar.f728b)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ihVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a4 = is.a(this.f741l, ihVar.f741l)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ihVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a3 = is.a(this.f727a, ihVar.f727a)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ihVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a2 = is.a(this.f726a, ihVar.f726a)) == 0) {
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
                return a20;
            }
            return a21;
        }
        return getClass().getName().compareTo(ihVar.getClass().getName());
    }

    public long a() {
        return this.f722a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8929a() {
        return this.f730b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m8930a() {
        return this.f726a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8931a() {
        if (this.f730b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f732c != null) {
        } else {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                if (e()) {
                    m8931a();
                    return;
                }
                throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f724a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f723a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f730b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f732c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 10) {
                        this.f722a = jcVar.mo8981a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f733d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 11) {
                        this.f734e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 11) {
                        this.f735f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 11) {
                        this.f736g = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 11:
                    if (mo8982a.f27852a == 10) {
                        this.f729b = jcVar.mo8981a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo8982a.f27852a == 11) {
                        this.f737h = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 13:
                    if (mo8982a.f27852a == 11) {
                        this.f738i = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 14:
                    if (mo8982a.f27852a == 10) {
                        this.f731c = jcVar.mo8981a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 15:
                    if (mo8982a.f27852a == 11) {
                        this.f739j = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 16:
                    if (mo8982a.f27852a == 8) {
                        this.f721a = jcVar.mo8980a();
                        d(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 17:
                    if (mo8982a.f27852a == 11) {
                        this.f740k = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 18:
                    if (mo8982a.f27852a == 8) {
                        this.f728b = jcVar.mo8980a();
                        e(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 19:
                    if (mo8982a.f27852a == 11) {
                        this.f741l = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 20:
                    if (mo8982a.f27852a == 2) {
                        this.f727a = jcVar.mo8992a();
                        f(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 21:
                    if (mo8982a.f27852a == 15) {
                        ja mo8983a = jcVar.mo8983a();
                        this.f726a = new ArrayList(mo8983a.f842a);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo8983a.f842a) {
                                this.f726a.add(jcVar.mo8987a());
                                i2 = i3 + 1;
                            } else {
                                jcVar.i();
                                continue;
                                jcVar.g();
                            }
                        }
                    }
                    break;
            }
            jf.a(jcVar, mo8982a.f27852a);
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f725a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8932a() {
        return this.f724a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8933a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m8932a = m8932a();
        boolean m8932a2 = ihVar.m8932a();
        if ((m8932a || m8932a2) && !(m8932a && m8932a2 && this.f724a.equals(ihVar.f724a))) {
            return false;
        }
        boolean m8934b = m8934b();
        boolean m8934b2 = ihVar.m8934b();
        if ((m8934b || m8934b2) && !(m8934b && m8934b2 && this.f723a.m8859a(ihVar.f723a))) {
            return false;
        }
        boolean m8935c = m8935c();
        boolean m8935c2 = ihVar.m8935c();
        if ((m8935c || m8935c2) && !(m8935c && m8935c2 && this.f730b.equals(ihVar.f730b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f732c.equals(ihVar.f732c))) || this.f722a != ihVar.f722a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f733d.equals(ihVar.f733d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f734e.equals(ihVar.f734e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f735f.equals(ihVar.f735f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f736g.equals(ihVar.f736g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f729b == ihVar.f729b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ihVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f737h.equals(ihVar.f737h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ihVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f738i.equals(ihVar.f738i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ihVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f731c == ihVar.f731c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ihVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f739j.equals(ihVar.f739j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ihVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f721a == ihVar.f721a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = ihVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f740k.equals(ihVar.f740k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = ihVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f728b == ihVar.f728b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = ihVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f741l.equals(ihVar.f741l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = ihVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f727a == ihVar.f727a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = ihVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f726a.equals(ihVar.f726a);
        }
        return true;
    }

    public String b() {
        return this.f735f;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8931a();
        jcVar.a(f720a);
        if (this.f724a != null && m8932a()) {
            jcVar.a(f27828a);
            jcVar.a(this.f724a);
            jcVar.b();
        }
        if (this.f723a != null && m8934b()) {
            jcVar.a(b);
            this.f723a.b(jcVar);
            jcVar.b();
        }
        if (this.f730b != null) {
            jcVar.a(f27829c);
            jcVar.a(this.f730b);
            jcVar.b();
        }
        if (this.f732c != null) {
            jcVar.a(d);
            jcVar.a(this.f732c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f722a);
        jcVar.b();
        if (this.f733d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f733d);
            jcVar.b();
        }
        if (this.f734e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f734e);
            jcVar.b();
        }
        if (this.f735f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f735f);
            jcVar.b();
        }
        if (this.f736g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f736g);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f729b);
            jcVar.b();
        }
        if (this.f737h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f737h);
            jcVar.b();
        }
        if (this.f738i != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f738i);
            jcVar.b();
        }
        if (m()) {
            jcVar.a(m);
            jcVar.a(this.f731c);
            jcVar.b();
        }
        if (this.f739j != null && n()) {
            jcVar.a(n);
            jcVar.a(this.f739j);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.mo8991a(this.f721a);
            jcVar.b();
        }
        if (this.f740k != null && p()) {
            jcVar.a(p);
            jcVar.a(this.f740k);
            jcVar.b();
        }
        if (q()) {
            jcVar.a(q);
            jcVar.mo8991a(this.f728b);
            jcVar.b();
        }
        if (this.f741l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f741l);
            jcVar.b();
        }
        if (s()) {
            jcVar.a(s);
            jcVar.a(this.f727a);
            jcVar.b();
        }
        if (this.f726a != null && t()) {
            jcVar.a(t);
            jcVar.a(new ja((byte) 11, this.f726a.size()));
            for (String str : this.f726a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f725a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8934b() {
        return this.f723a != null;
    }

    public String c() {
        return this.f736g;
    }

    public void c(boolean z) {
        this.f725a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8935c() {
        return this.f730b != null;
    }

    public void d(boolean z) {
        this.f725a.set(3, z);
    }

    public boolean d() {
        return this.f732c != null;
    }

    public void e(boolean z) {
        this.f725a.set(4, z);
    }

    public boolean e() {
        return this.f725a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m8933a((ih) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f725a.set(5, z);
    }

    public boolean f() {
        return this.f733d != null;
    }

    public boolean g() {
        return this.f734e != null;
    }

    public boolean h() {
        return this.f735f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f736g != null;
    }

    public boolean j() {
        return this.f725a.get(1);
    }

    public boolean k() {
        return this.f737h != null;
    }

    public boolean l() {
        return this.f738i != null;
    }

    public boolean m() {
        return this.f725a.get(2);
    }

    public boolean n() {
        return this.f739j != null;
    }

    public boolean o() {
        return this.f725a.get(3);
    }

    public boolean p() {
        return this.f740k != null;
    }

    public boolean q() {
        return this.f725a.get(4);
    }

    public boolean r() {
        return this.f741l != null;
    }

    public boolean s() {
        return this.f725a.get(5);
    }

    public boolean t() {
        return this.f726a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        if (m8932a()) {
            sb.append("debug:");
            String str = this.f724a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m8934b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f723a;
            if (hvVar == null) {
                sb.append(com.igexin.push.core.b.l);
                z = false;
            } else {
                sb.append(hvVar);
                z = false;
            }
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f730b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f732c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f722a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f733d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f734e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f736g;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f729b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f737h;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f738i;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f731c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f739j;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f721a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f740k;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f728b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f741l;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str11);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f727a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            List<String> list = this.f726a;
            if (list == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
