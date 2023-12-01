package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hw.class */
public class hw implements ir<hw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f592a;

    /* renamed from: a  reason: collision with other field name */
    public long f593a;

    /* renamed from: a  reason: collision with other field name */
    public hv f594a;

    /* renamed from: a  reason: collision with other field name */
    public ij f595a;

    /* renamed from: a  reason: collision with other field name */
    public String f596a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f598a;

    /* renamed from: a  reason: collision with other field name */
    public short f599a;

    /* renamed from: b  reason: collision with other field name */
    public String f601b;

    /* renamed from: b  reason: collision with other field name */
    public short f602b;

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
    private static final jh f591a = new jh("XmPushActionAckMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27808a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27809c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", (byte) 11, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 12, 8);
    private static final iz i = new iz("", (byte) 11, 9);
    private static final iz j = new iz("", (byte) 11, 10);
    private static final iz k = new iz("", (byte) 2, 11);
    private static final iz l = new iz("", (byte) 11, 12);
    private static final iz m = new iz("", (byte) 11, 13);
    private static final iz n = new iz("", (byte) 11, 14);
    private static final iz o = new iz("", (byte) 6, 15);
    private static final iz p = new iz("", (byte) 6, 16);
    private static final iz q = new iz("", (byte) 11, 20);
    private static final iz r = new iz("", (byte) 11, 21);
    private static final iz s = new iz("", (byte) 8, 22);
    private static final iz t = new iz("", (byte) 13, 23);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f597a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f600a = false;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hw hwVar) {
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
        if (getClass().equals(hwVar.getClass())) {
            int compareTo = Boolean.valueOf(m8861a()).compareTo(Boolean.valueOf(hwVar.m8861a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8861a() || (a21 = is.a(this.f596a, hwVar.f596a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hwVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a20 = is.a(this.f594a, hwVar.f594a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a19 = is.a(this.f601b, hwVar.f601b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a18 = is.a(this.f603c, hwVar.f603c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a17 = is.a(this.f593a, hwVar.f593a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a16 = is.a(this.f604d, hwVar.f604d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a15 = is.a(this.f605e, hwVar.f605e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a14 = is.a(this.f595a, hwVar.f595a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a13 = is.a(this.f606f, hwVar.f606f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a12 = is.a(this.f607g, hwVar.f607g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hwVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a11 = is.a(this.f600a, hwVar.f600a)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hwVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a10 = is.a(this.f608h, hwVar.f608h)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hwVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a9 = is.a(this.f609i, hwVar.f609i)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hwVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a8 = is.a(this.f610j, hwVar.f610j)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hwVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a7 = is.a(this.f599a, hwVar.f599a)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hwVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a6 = is.a(this.f602b, hwVar.f602b)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hwVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a5 = is.a(this.f611k, hwVar.f611k)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hwVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a4 = is.a(this.f612l, hwVar.f612l)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hwVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a3 = is.a(this.f592a, hwVar.f592a)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hwVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a2 = is.a(this.f598a, hwVar.f598a)) == 0) {
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
        return getClass().getName().compareTo(hwVar.getClass().getName());
    }

    public hw a(long j2) {
        this.f593a = j2;
        a(true);
        return this;
    }

    public hw a(String str) {
        this.f601b = str;
        return this;
    }

    public hw a(short s2) {
        this.f599a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f601b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f603c != null) {
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
                    a();
                    return;
                }
                throw new jd("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f596a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f594a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f601b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f603c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 10) {
                        this.f593a = jcVar.mo8981a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 11) {
                        this.f604d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f605e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 12) {
                        ij ijVar = new ij();
                        this.f595a = ijVar;
                        ijVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 11) {
                        this.f606f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 11) {
                        this.f607g = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 11:
                    if (mo8982a.f27852a == 2) {
                        this.f600a = jcVar.mo8992a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo8982a.f27852a == 11) {
                        this.f608h = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 13:
                    if (mo8982a.f27852a == 11) {
                        this.f609i = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 14:
                    if (mo8982a.f27852a == 11) {
                        this.f610j = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 15:
                    if (mo8982a.f27852a == 6) {
                        this.f599a = jcVar.mo8989a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 16:
                    if (mo8982a.f27852a == 6) {
                        this.f602b = jcVar.mo8989a();
                        d(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 20:
                    if (mo8982a.f27852a == 11) {
                        this.f611k = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 21:
                    if (mo8982a.f27852a == 11) {
                        this.f612l = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 22:
                    if (mo8982a.f27852a == 8) {
                        this.f592a = jcVar.mo8980a();
                        e(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 23:
                    if (mo8982a.f27852a == 13) {
                        jb mo8984a = jcVar.mo8984a();
                        this.f598a = new HashMap(mo8984a.f843a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo8984a.f843a) {
                                this.f598a.put(jcVar.mo8987a(), jcVar.mo8987a());
                                i2 = i3 + 1;
                            } else {
                                jcVar.h();
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
        this.f597a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8861a() {
        return this.f596a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8862a(hw hwVar) {
        if (hwVar == null) {
            return false;
        }
        boolean m8861a = m8861a();
        boolean m8861a2 = hwVar.m8861a();
        if ((m8861a || m8861a2) && !(m8861a && m8861a2 && this.f596a.equals(hwVar.f596a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hwVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f594a.m8859a(hwVar.f594a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hwVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f601b.equals(hwVar.f601b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hwVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f603c.equals(hwVar.f603c))) || this.f593a != hwVar.f593a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hwVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f604d.equals(hwVar.f604d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hwVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f605e.equals(hwVar.f605e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hwVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f595a.m8943a(hwVar.f595a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hwVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f606f.equals(hwVar.f606f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hwVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f607g.equals(hwVar.f607g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hwVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f600a == hwVar.f600a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hwVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f608h.equals(hwVar.f608h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hwVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f609i.equals(hwVar.f609i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hwVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f610j.equals(hwVar.f610j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hwVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f599a == hwVar.f599a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hwVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f602b == hwVar.f602b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hwVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f611k.equals(hwVar.f611k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hwVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f612l.equals(hwVar.f612l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hwVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f592a == hwVar.f592a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hwVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f598a.equals(hwVar.f598a);
        }
        return true;
    }

    public hw b(String str) {
        this.f603c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f591a);
        if (this.f596a != null && m8861a()) {
            jcVar.a(f27808a);
            jcVar.a(this.f596a);
            jcVar.b();
        }
        if (this.f594a != null && b()) {
            jcVar.a(b);
            this.f594a.b(jcVar);
            jcVar.b();
        }
        if (this.f601b != null) {
            jcVar.a(f27809c);
            jcVar.a(this.f601b);
            jcVar.b();
        }
        if (this.f603c != null) {
            jcVar.a(d);
            jcVar.a(this.f603c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f593a);
        jcVar.b();
        if (this.f604d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f604d);
            jcVar.b();
        }
        if (this.f605e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f605e);
            jcVar.b();
        }
        if (this.f595a != null && h()) {
            jcVar.a(h);
            this.f595a.b(jcVar);
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
        if (k()) {
            jcVar.a(k);
            jcVar.a(this.f600a);
            jcVar.b();
        }
        if (this.f608h != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f608h);
            jcVar.b();
        }
        if (this.f609i != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f609i);
            jcVar.b();
        }
        if (this.f610j != null && n()) {
            jcVar.a(n);
            jcVar.a(this.f610j);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f599a);
            jcVar.b();
        }
        if (p()) {
            jcVar.a(p);
            jcVar.a(this.f602b);
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
        if (s()) {
            jcVar.a(s);
            jcVar.mo8991a(this.f592a);
            jcVar.b();
        }
        if (this.f598a != null && t()) {
            jcVar.a(t);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f598a.size()));
            for (Map.Entry<String, String> entry : this.f598a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f597a.set(1, z);
    }

    public boolean b() {
        return this.f594a != null;
    }

    public hw c(String str) {
        this.f604d = str;
        return this;
    }

    public void c(boolean z) {
        this.f597a.set(2, z);
    }

    public boolean c() {
        return this.f601b != null;
    }

    public hw d(String str) {
        this.f605e = str;
        return this;
    }

    public void d(boolean z) {
        this.f597a.set(3, z);
    }

    public boolean d() {
        return this.f603c != null;
    }

    public void e(boolean z) {
        this.f597a.set(4, z);
    }

    public boolean e() {
        return this.f597a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return m8862a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f604d != null;
    }

    public boolean g() {
        return this.f605e != null;
    }

    public boolean h() {
        return this.f595a != null;
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
        return this.f597a.get(1);
    }

    public boolean l() {
        return this.f608h != null;
    }

    public boolean m() {
        return this.f609i != null;
    }

    public boolean n() {
        return this.f610j != null;
    }

    public boolean o() {
        return this.f597a.get(2);
    }

    public boolean p() {
        return this.f597a.get(3);
    }

    public boolean q() {
        return this.f611k != null;
    }

    public boolean r() {
        return this.f612l != null;
    }

    public boolean s() {
        return this.f597a.get(4);
    }

    public boolean t() {
        return this.f598a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        if (m8861a()) {
            sb.append("debug:");
            String str = this.f596a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f594a;
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
        String str2 = this.f601b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f603c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f593a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f604d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f605e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            ij ijVar = this.f595a;
            if (ijVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(ijVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
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
            sb.append("isOnline:");
            sb.append(this.f600a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f608h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f609i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f610j;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f599a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f602b);
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
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f592a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f598a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
