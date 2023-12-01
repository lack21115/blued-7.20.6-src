package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hw.class */
public class hw implements ir<hw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f639a;

    /* renamed from: a  reason: collision with other field name */
    public long f640a;

    /* renamed from: a  reason: collision with other field name */
    public hv f641a;

    /* renamed from: a  reason: collision with other field name */
    public ij f642a;

    /* renamed from: a  reason: collision with other field name */
    public String f643a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f645a;

    /* renamed from: a  reason: collision with other field name */
    public short f646a;

    /* renamed from: b  reason: collision with other field name */
    public String f648b;

    /* renamed from: b  reason: collision with other field name */
    public short f649b;

    /* renamed from: c  reason: collision with other field name */
    public String f650c;

    /* renamed from: d  reason: collision with other field name */
    public String f651d;

    /* renamed from: e  reason: collision with other field name */
    public String f652e;

    /* renamed from: f  reason: collision with other field name */
    public String f653f;

    /* renamed from: g  reason: collision with other field name */
    public String f654g;

    /* renamed from: h  reason: collision with other field name */
    public String f655h;

    /* renamed from: i  reason: collision with other field name */
    public String f656i;

    /* renamed from: j  reason: collision with other field name */
    public String f657j;

    /* renamed from: k  reason: collision with other field name */
    public String f658k;

    /* renamed from: l  reason: collision with other field name */
    public String f659l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f638a = new jh("XmPushActionAckMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41499a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41500c = new iz("", (byte) 11, 3);
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
    private BitSet f644a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f647a = false;

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
            int compareTo = Boolean.valueOf(m11911a()).compareTo(Boolean.valueOf(hwVar.m11911a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11911a() || (a21 = is.a(this.f643a, hwVar.f643a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hwVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a20 = is.a(this.f641a, hwVar.f641a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a19 = is.a(this.f648b, hwVar.f648b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a18 = is.a(this.f650c, hwVar.f650c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a17 = is.a(this.f640a, hwVar.f640a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a16 = is.a(this.f651d, hwVar.f651d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a15 = is.a(this.f652e, hwVar.f652e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a14 = is.a(this.f642a, hwVar.f642a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a13 = is.a(this.f653f, hwVar.f653f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a12 = is.a(this.f654g, hwVar.f654g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hwVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a11 = is.a(this.f647a, hwVar.f647a)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hwVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a10 = is.a(this.f655h, hwVar.f655h)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hwVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a9 = is.a(this.f656i, hwVar.f656i)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hwVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a8 = is.a(this.f657j, hwVar.f657j)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hwVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a7 = is.a(this.f646a, hwVar.f646a)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hwVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a6 = is.a(this.f649b, hwVar.f649b)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hwVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a5 = is.a(this.f658k, hwVar.f658k)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hwVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a4 = is.a(this.f659l, hwVar.f659l)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hwVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a3 = is.a(this.f639a, hwVar.f639a)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hwVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a2 = is.a(this.f645a, hwVar.f645a)) == 0) {
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
        this.f640a = j2;
        a(true);
        return this;
    }

    public hw a(String str) {
        this.f648b = str;
        return this;
    }

    public hw a(short s2) {
        this.f646a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f648b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f650c != null) {
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
                    a();
                    return;
                }
                throw new jd("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f643a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f641a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f648b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f650c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 10) {
                        this.f640a = jcVar.mo12031a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 11) {
                        this.f651d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f652e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 12) {
                        ij ijVar = new ij();
                        this.f642a = ijVar;
                        ijVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 11) {
                        this.f653f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 11) {
                        this.f654g = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 11:
                    if (mo12032a.f41543a == 2) {
                        this.f647a = jcVar.mo12042a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo12032a.f41543a == 11) {
                        this.f655h = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 13:
                    if (mo12032a.f41543a == 11) {
                        this.f656i = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 14:
                    if (mo12032a.f41543a == 11) {
                        this.f657j = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 15:
                    if (mo12032a.f41543a == 6) {
                        this.f646a = jcVar.mo12039a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 16:
                    if (mo12032a.f41543a == 6) {
                        this.f649b = jcVar.mo12039a();
                        d(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 20:
                    if (mo12032a.f41543a == 11) {
                        this.f658k = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 21:
                    if (mo12032a.f41543a == 11) {
                        this.f659l = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 22:
                    if (mo12032a.f41543a == 8) {
                        this.f639a = jcVar.mo12030a();
                        e(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 23:
                    if (mo12032a.f41543a == 13) {
                        jb mo12034a = jcVar.mo12034a();
                        this.f645a = new HashMap(mo12034a.f890a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo12034a.f890a) {
                                this.f645a.put(jcVar.mo12037a(), jcVar.mo12037a());
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
            jf.a(jcVar, mo12032a.f41543a);
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f644a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11911a() {
        return this.f643a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11912a(hw hwVar) {
        if (hwVar == null) {
            return false;
        }
        boolean m11911a = m11911a();
        boolean m11911a2 = hwVar.m11911a();
        if ((m11911a || m11911a2) && !(m11911a && m11911a2 && this.f643a.equals(hwVar.f643a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hwVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f641a.m11909a(hwVar.f641a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hwVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f648b.equals(hwVar.f648b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hwVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f650c.equals(hwVar.f650c))) || this.f640a != hwVar.f640a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hwVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f651d.equals(hwVar.f651d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hwVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f652e.equals(hwVar.f652e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hwVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f642a.m11993a(hwVar.f642a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hwVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f653f.equals(hwVar.f653f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hwVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f654g.equals(hwVar.f654g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hwVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f647a == hwVar.f647a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hwVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f655h.equals(hwVar.f655h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hwVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f656i.equals(hwVar.f656i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hwVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f657j.equals(hwVar.f657j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hwVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f646a == hwVar.f646a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hwVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f649b == hwVar.f649b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hwVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f658k.equals(hwVar.f658k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hwVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f659l.equals(hwVar.f659l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hwVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f639a == hwVar.f639a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hwVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f645a.equals(hwVar.f645a);
        }
        return true;
    }

    public hw b(String str) {
        this.f650c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f638a);
        if (this.f643a != null && m11911a()) {
            jcVar.a(f41499a);
            jcVar.a(this.f643a);
            jcVar.b();
        }
        if (this.f641a != null && b()) {
            jcVar.a(b);
            this.f641a.b(jcVar);
            jcVar.b();
        }
        if (this.f648b != null) {
            jcVar.a(f41500c);
            jcVar.a(this.f648b);
            jcVar.b();
        }
        if (this.f650c != null) {
            jcVar.a(d);
            jcVar.a(this.f650c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f640a);
        jcVar.b();
        if (this.f651d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f651d);
            jcVar.b();
        }
        if (this.f652e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f652e);
            jcVar.b();
        }
        if (this.f642a != null && h()) {
            jcVar.a(h);
            this.f642a.b(jcVar);
            jcVar.b();
        }
        if (this.f653f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f653f);
            jcVar.b();
        }
        if (this.f654g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f654g);
            jcVar.b();
        }
        if (k()) {
            jcVar.a(k);
            jcVar.a(this.f647a);
            jcVar.b();
        }
        if (this.f655h != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f655h);
            jcVar.b();
        }
        if (this.f656i != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f656i);
            jcVar.b();
        }
        if (this.f657j != null && n()) {
            jcVar.a(n);
            jcVar.a(this.f657j);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f646a);
            jcVar.b();
        }
        if (p()) {
            jcVar.a(p);
            jcVar.a(this.f649b);
            jcVar.b();
        }
        if (this.f658k != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f658k);
            jcVar.b();
        }
        if (this.f659l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f659l);
            jcVar.b();
        }
        if (s()) {
            jcVar.a(s);
            jcVar.mo12041a(this.f639a);
            jcVar.b();
        }
        if (this.f645a != null && t()) {
            jcVar.a(t);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f645a.size()));
            for (Map.Entry<String, String> entry : this.f645a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f644a.set(1, z);
    }

    public boolean b() {
        return this.f641a != null;
    }

    public hw c(String str) {
        this.f651d = str;
        return this;
    }

    public void c(boolean z) {
        this.f644a.set(2, z);
    }

    public boolean c() {
        return this.f648b != null;
    }

    public hw d(String str) {
        this.f652e = str;
        return this;
    }

    public void d(boolean z) {
        this.f644a.set(3, z);
    }

    public boolean d() {
        return this.f650c != null;
    }

    public void e(boolean z) {
        this.f644a.set(4, z);
    }

    public boolean e() {
        return this.f644a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return m11912a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f651d != null;
    }

    public boolean g() {
        return this.f652e != null;
    }

    public boolean h() {
        return this.f642a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f653f != null;
    }

    public boolean j() {
        return this.f654g != null;
    }

    public boolean k() {
        return this.f644a.get(1);
    }

    public boolean l() {
        return this.f655h != null;
    }

    public boolean m() {
        return this.f656i != null;
    }

    public boolean n() {
        return this.f657j != null;
    }

    public boolean o() {
        return this.f644a.get(2);
    }

    public boolean p() {
        return this.f644a.get(3);
    }

    public boolean q() {
        return this.f658k != null;
    }

    public boolean r() {
        return this.f659l != null;
    }

    public boolean s() {
        return this.f644a.get(4);
    }

    public boolean t() {
        return this.f645a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        if (m11911a()) {
            sb.append("debug:");
            String str = this.f643a;
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
            hv hvVar = this.f641a;
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
        String str2 = this.f648b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f650c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f640a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f651d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f652e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            ij ijVar = this.f642a;
            if (ijVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(ijVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f653f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f654g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f647a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f655h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f656i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f657j;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f646a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f649b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f658k;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f659l;
            if (str12 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f639a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f645a;
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
