package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ih.class */
public class ih implements ir<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f768a;

    /* renamed from: a  reason: collision with other field name */
    public long f769a;

    /* renamed from: a  reason: collision with other field name */
    public hv f770a;

    /* renamed from: a  reason: collision with other field name */
    public String f771a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f773a;

    /* renamed from: b  reason: collision with other field name */
    public int f775b;

    /* renamed from: b  reason: collision with other field name */
    public long f776b;

    /* renamed from: b  reason: collision with other field name */
    public String f777b;

    /* renamed from: c  reason: collision with other field name */
    public long f778c;

    /* renamed from: c  reason: collision with other field name */
    public String f779c;

    /* renamed from: d  reason: collision with other field name */
    public String f780d;

    /* renamed from: e  reason: collision with other field name */
    public String f781e;

    /* renamed from: f  reason: collision with other field name */
    public String f782f;

    /* renamed from: g  reason: collision with other field name */
    public String f783g;

    /* renamed from: h  reason: collision with other field name */
    public String f784h;

    /* renamed from: i  reason: collision with other field name */
    public String f785i;

    /* renamed from: j  reason: collision with other field name */
    public String f786j;

    /* renamed from: k  reason: collision with other field name */
    public String f787k;

    /* renamed from: l  reason: collision with other field name */
    public String f788l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f767a = new jh("XmPushActionRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41519a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41520c = new iz("", (byte) 11, 3);
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
    private BitSet f772a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f774a = false;

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
            int compareTo = Boolean.valueOf(m11982a()).compareTo(Boolean.valueOf(ihVar.m11982a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11982a() || (a21 = is.a(this.f771a, ihVar.f771a)) == 0) {
                int compareTo2 = Boolean.valueOf(m11984b()).compareTo(Boolean.valueOf(ihVar.m11984b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m11984b() || (a20 = is.a(this.f770a, ihVar.f770a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m11985c()).compareTo(Boolean.valueOf(ihVar.m11985c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m11985c() || (a19 = is.a(this.f777b, ihVar.f777b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a18 = is.a(this.f779c, ihVar.f779c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a17 = is.a(this.f769a, ihVar.f769a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a16 = is.a(this.f780d, ihVar.f780d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a15 = is.a(this.f781e, ihVar.f781e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a14 = is.a(this.f782f, ihVar.f782f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a13 = is.a(this.f783g, ihVar.f783g)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a12 = is.a(this.f776b, ihVar.f776b)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ihVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a11 = is.a(this.f784h, ihVar.f784h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ihVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a10 = is.a(this.f785i, ihVar.f785i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ihVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a9 = is.a(this.f778c, ihVar.f778c)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ihVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a8 = is.a(this.f786j, ihVar.f786j)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ihVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a7 = is.a(this.f768a, ihVar.f768a)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ihVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a6 = is.a(this.f787k, ihVar.f787k)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ihVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a5 = is.a(this.f775b, ihVar.f775b)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ihVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a4 = is.a(this.f788l, ihVar.f788l)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ihVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a3 = is.a(this.f774a, ihVar.f774a)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ihVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a2 = is.a(this.f773a, ihVar.f773a)) == 0) {
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
        return this.f769a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11979a() {
        return this.f777b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m11980a() {
        return this.f773a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11981a() {
        if (this.f777b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f779c != null) {
        } else {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                if (e()) {
                    m11981a();
                    return;
                }
                throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f771a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f770a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f777b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f779c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 10) {
                        this.f769a = jcVar.mo12031a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f780d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 11) {
                        this.f781e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 11) {
                        this.f782f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 11) {
                        this.f783g = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 11:
                    if (mo12032a.f41543a == 10) {
                        this.f776b = jcVar.mo12031a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo12032a.f41543a == 11) {
                        this.f784h = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 13:
                    if (mo12032a.f41543a == 11) {
                        this.f785i = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 14:
                    if (mo12032a.f41543a == 10) {
                        this.f778c = jcVar.mo12031a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 15:
                    if (mo12032a.f41543a == 11) {
                        this.f786j = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 16:
                    if (mo12032a.f41543a == 8) {
                        this.f768a = jcVar.mo12030a();
                        d(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 17:
                    if (mo12032a.f41543a == 11) {
                        this.f787k = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 18:
                    if (mo12032a.f41543a == 8) {
                        this.f775b = jcVar.mo12030a();
                        e(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 19:
                    if (mo12032a.f41543a == 11) {
                        this.f788l = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 20:
                    if (mo12032a.f41543a == 2) {
                        this.f774a = jcVar.mo12042a();
                        f(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 21:
                    if (mo12032a.f41543a == 15) {
                        ja mo12033a = jcVar.mo12033a();
                        this.f773a = new ArrayList(mo12033a.f889a);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo12033a.f889a) {
                                this.f773a.add(jcVar.mo12037a());
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
            jf.a(jcVar, mo12032a.f41543a);
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f772a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11982a() {
        return this.f771a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11983a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m11982a = m11982a();
        boolean m11982a2 = ihVar.m11982a();
        if ((m11982a || m11982a2) && !(m11982a && m11982a2 && this.f771a.equals(ihVar.f771a))) {
            return false;
        }
        boolean m11984b = m11984b();
        boolean m11984b2 = ihVar.m11984b();
        if ((m11984b || m11984b2) && !(m11984b && m11984b2 && this.f770a.m11909a(ihVar.f770a))) {
            return false;
        }
        boolean m11985c = m11985c();
        boolean m11985c2 = ihVar.m11985c();
        if ((m11985c || m11985c2) && !(m11985c && m11985c2 && this.f777b.equals(ihVar.f777b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f779c.equals(ihVar.f779c))) || this.f769a != ihVar.f769a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f780d.equals(ihVar.f780d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f781e.equals(ihVar.f781e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f782f.equals(ihVar.f782f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f783g.equals(ihVar.f783g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f776b == ihVar.f776b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ihVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f784h.equals(ihVar.f784h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ihVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f785i.equals(ihVar.f785i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ihVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f778c == ihVar.f778c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ihVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f786j.equals(ihVar.f786j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ihVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f768a == ihVar.f768a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = ihVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f787k.equals(ihVar.f787k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = ihVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f775b == ihVar.f775b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = ihVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f788l.equals(ihVar.f788l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = ihVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f774a == ihVar.f774a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = ihVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f773a.equals(ihVar.f773a);
        }
        return true;
    }

    public String b() {
        return this.f782f;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11981a();
        jcVar.a(f767a);
        if (this.f771a != null && m11982a()) {
            jcVar.a(f41519a);
            jcVar.a(this.f771a);
            jcVar.b();
        }
        if (this.f770a != null && m11984b()) {
            jcVar.a(b);
            this.f770a.b(jcVar);
            jcVar.b();
        }
        if (this.f777b != null) {
            jcVar.a(f41520c);
            jcVar.a(this.f777b);
            jcVar.b();
        }
        if (this.f779c != null) {
            jcVar.a(d);
            jcVar.a(this.f779c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f769a);
        jcVar.b();
        if (this.f780d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f780d);
            jcVar.b();
        }
        if (this.f781e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f781e);
            jcVar.b();
        }
        if (this.f782f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f782f);
            jcVar.b();
        }
        if (this.f783g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f783g);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f776b);
            jcVar.b();
        }
        if (this.f784h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f784h);
            jcVar.b();
        }
        if (this.f785i != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f785i);
            jcVar.b();
        }
        if (m()) {
            jcVar.a(m);
            jcVar.a(this.f778c);
            jcVar.b();
        }
        if (this.f786j != null && n()) {
            jcVar.a(n);
            jcVar.a(this.f786j);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.mo12041a(this.f768a);
            jcVar.b();
        }
        if (this.f787k != null && p()) {
            jcVar.a(p);
            jcVar.a(this.f787k);
            jcVar.b();
        }
        if (q()) {
            jcVar.a(q);
            jcVar.mo12041a(this.f775b);
            jcVar.b();
        }
        if (this.f788l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f788l);
            jcVar.b();
        }
        if (s()) {
            jcVar.a(s);
            jcVar.a(this.f774a);
            jcVar.b();
        }
        if (this.f773a != null && t()) {
            jcVar.a(t);
            jcVar.a(new ja((byte) 11, this.f773a.size()));
            for (String str : this.f773a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f772a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11984b() {
        return this.f770a != null;
    }

    public String c() {
        return this.f783g;
    }

    public void c(boolean z) {
        this.f772a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m11985c() {
        return this.f777b != null;
    }

    public void d(boolean z) {
        this.f772a.set(3, z);
    }

    public boolean d() {
        return this.f779c != null;
    }

    public void e(boolean z) {
        this.f772a.set(4, z);
    }

    public boolean e() {
        return this.f772a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m11983a((ih) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f772a.set(5, z);
    }

    public boolean f() {
        return this.f780d != null;
    }

    public boolean g() {
        return this.f781e != null;
    }

    public boolean h() {
        return this.f782f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f783g != null;
    }

    public boolean j() {
        return this.f772a.get(1);
    }

    public boolean k() {
        return this.f784h != null;
    }

    public boolean l() {
        return this.f785i != null;
    }

    public boolean m() {
        return this.f772a.get(2);
    }

    public boolean n() {
        return this.f786j != null;
    }

    public boolean o() {
        return this.f772a.get(3);
    }

    public boolean p() {
        return this.f787k != null;
    }

    public boolean q() {
        return this.f772a.get(4);
    }

    public boolean r() {
        return this.f788l != null;
    }

    public boolean s() {
        return this.f772a.get(5);
    }

    public boolean t() {
        return this.f773a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        if (m11982a()) {
            sb.append("debug:");
            String str = this.f771a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m11984b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f770a;
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
        String str2 = this.f777b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f779c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f769a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f780d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f781e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f783g;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f776b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f784h;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f785i;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f778c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f786j;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f768a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f787k;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f775b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f788l;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str11);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f774a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            List<String> list = this.f773a;
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
