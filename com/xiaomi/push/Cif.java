package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/if.class */
public class Cif implements ir<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f673a;

    /* renamed from: a  reason: collision with other field name */
    public hv f674a;

    /* renamed from: a  reason: collision with other field name */
    public String f675a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f676a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f677a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f678a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f679a;

    /* renamed from: b  reason: collision with other field name */
    public String f680b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f681b;

    /* renamed from: c  reason: collision with other field name */
    public String f682c;

    /* renamed from: d  reason: collision with other field name */
    public String f683d;

    /* renamed from: e  reason: collision with other field name */
    public String f684e;

    /* renamed from: f  reason: collision with other field name */
    public String f685f;

    /* renamed from: g  reason: collision with other field name */
    public String f686g;

    /* renamed from: h  reason: collision with other field name */
    public String f687h;

    /* renamed from: i  reason: collision with other field name */
    public String f688i;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f672a = new jh("XmPushActionNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27824a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27825c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 2, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 13, 8);
    private static final iz i = new iz("", (byte) 11, 9);
    private static final iz j = new iz("", (byte) 11, 10);
    private static final iz k = new iz("", (byte) 11, 12);
    private static final iz l = new iz("", (byte) 11, 13);
    private static final iz m = new iz("", (byte) 11, 14);
    private static final iz n = new iz("", (byte) 10, 15);
    private static final iz o = new iz("", (byte) 2, 20);

    public Cif() {
        this.f677a = new BitSet(3);
        this.f679a = true;
        this.f681b = false;
    }

    public Cif(String str, boolean z) {
        this();
        this.f680b = str;
        this.f679a = z;
        m8916a(true);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
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
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m8917a()).compareTo(Boolean.valueOf(cif.m8917a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8917a() || (a16 = is.a(this.f675a, cif.f675a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8920b()).compareTo(Boolean.valueOf(cif.m8920b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8920b() || (a15 = is.a(this.f674a, cif.f674a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m8921c()).compareTo(Boolean.valueOf(cif.m8921c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m8921c() || (a14 = is.a(this.f680b, cif.f680b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a13 = is.a(this.f682c, cif.f682c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a12 = is.a(this.f683d, cif.f683d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a11 = is.a(this.f679a, cif.f679a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a10 = is.a(this.f684e, cif.f684e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a9 = is.a(this.f678a, cif.f678a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a8 = is.a(this.f685f, cif.f685f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(cif.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a7 = is.a(this.f686g, cif.f686g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(cif.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a6 = is.a(this.f687h, cif.f687h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(cif.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a5 = is.a(this.f688i, cif.f688i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(cif.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a4 = is.a(this.f676a, cif.f676a)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(cif.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a3 = is.a(this.f673a, cif.f673a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(cif.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a2 = is.a(this.f681b, cif.f681b)) == 0) {
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
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public hv a() {
        return this.f674a;
    }

    public Cif a(String str) {
        this.f680b = str;
        return this;
    }

    public Cif a(ByteBuffer byteBuffer) {
        this.f676a = byteBuffer;
        return this;
    }

    public Cif a(Map<String, String> map) {
        this.f678a = map;
        return this;
    }

    public Cif a(boolean z) {
        this.f679a = z;
        m8916a(true);
        return this;
    }

    public Cif a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8913a() {
        return this.f680b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m8914a() {
        return this.f678a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8915a() {
        if (this.f680b != null) {
            return;
        }
        throw new jd("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                if (f()) {
                    m8915a();
                    return;
                }
                throw new jd("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f675a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f674a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f680b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f682c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 11) {
                        this.f683d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 2) {
                        this.f679a = jcVar.mo8992a();
                        m8916a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f684e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 13) {
                        jb mo8984a = jcVar.mo8984a();
                        this.f678a = new HashMap(mo8984a.f843a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo8984a.f843a) {
                                this.f678a.put(jcVar.mo8987a(), jcVar.mo8987a());
                                i2 = i3 + 1;
                            } else {
                                jcVar.h();
                                continue;
                                jcVar.g();
                            }
                        }
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 11) {
                        this.f685f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 11) {
                        this.f686g = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo8982a.f27852a == 11) {
                        this.f687h = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 13:
                    if (mo8982a.f27852a == 11) {
                        this.f688i = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 14:
                    if (mo8982a.f27852a == 11) {
                        this.f676a = jcVar.mo8988a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 15:
                    if (mo8982a.f27852a == 10) {
                        this.f673a = jcVar.mo8981a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 20:
                    if (mo8982a.f27852a == 2) {
                        this.f681b = jcVar.mo8992a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
            }
            jf.a(jcVar, mo8982a.f27852a);
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f678a == null) {
            this.f678a = new HashMap();
        }
        this.f678a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8916a(boolean z) {
        this.f677a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8917a() {
        return this.f675a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8918a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m8917a = m8917a();
        boolean m8917a2 = cif.m8917a();
        if ((m8917a || m8917a2) && !(m8917a && m8917a2 && this.f675a.equals(cif.f675a))) {
            return false;
        }
        boolean m8920b = m8920b();
        boolean m8920b2 = cif.m8920b();
        if ((m8920b || m8920b2) && !(m8920b && m8920b2 && this.f674a.m8859a(cif.f674a))) {
            return false;
        }
        boolean m8921c = m8921c();
        boolean m8921c2 = cif.m8921c();
        if ((m8921c || m8921c2) && !(m8921c && m8921c2 && this.f680b.equals(cif.f680b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = cif.d();
        if ((d2 || d3) && !(d2 && d3 && this.f682c.equals(cif.f682c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = cif.e();
        if (((e2 || e3) && !(e2 && e3 && this.f683d.equals(cif.f683d))) || this.f679a != cif.f679a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = cif.g();
        if ((g2 || g3) && !(g2 && g3 && this.f684e.equals(cif.f684e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = cif.h();
        if ((h2 || h3) && !(h2 && h3 && this.f678a.equals(cif.f678a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = cif.i();
        if ((i2 || i3) && !(i2 && i3 && this.f685f.equals(cif.f685f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = cif.j();
        if ((j2 || j3) && !(j2 && j3 && this.f686g.equals(cif.f686g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = cif.k();
        if ((k2 || k3) && !(k2 && k3 && this.f687h.equals(cif.f687h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = cif.l();
        if ((l2 || l3) && !(l2 && l3 && this.f688i.equals(cif.f688i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = cif.m();
        if ((m2 || m3) && !(m2 && m3 && this.f676a.equals(cif.f676a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = cif.n();
        if ((n2 || n3) && !(n2 && n3 && this.f673a == cif.f673a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = cif.o();
        if (o2 || o3) {
            return o2 && o3 && this.f681b == cif.f681b;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m8919a() {
        a(is.a(this.f676a));
        return this.f676a.array();
    }

    public Cif b(String str) {
        this.f682c = str;
        return this;
    }

    public String b() {
        return this.f682c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8915a();
        jcVar.a(f672a);
        if (this.f675a != null && m8917a()) {
            jcVar.a(f27824a);
            jcVar.a(this.f675a);
            jcVar.b();
        }
        if (this.f674a != null && m8920b()) {
            jcVar.a(b);
            this.f674a.b(jcVar);
            jcVar.b();
        }
        if (this.f680b != null) {
            jcVar.a(f27825c);
            jcVar.a(this.f680b);
            jcVar.b();
        }
        if (this.f682c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f682c);
            jcVar.b();
        }
        if (this.f683d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f683d);
            jcVar.b();
        }
        jcVar.a(f);
        jcVar.a(this.f679a);
        jcVar.b();
        if (this.f684e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f684e);
            jcVar.b();
        }
        if (this.f678a != null && h()) {
            jcVar.a(h);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f678a.size()));
            for (Map.Entry<String, String> entry : this.f678a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f685f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f685f);
            jcVar.b();
        }
        if (this.f686g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f686g);
            jcVar.b();
        }
        if (this.f687h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f687h);
            jcVar.b();
        }
        if (this.f688i != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f688i);
            jcVar.b();
        }
        if (this.f676a != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f676a);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f673a);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f681b);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f677a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8920b() {
        return this.f674a != null;
    }

    public Cif c(String str) {
        this.f683d = str;
        return this;
    }

    public String c() {
        return this.f685f;
    }

    public void c(boolean z) {
        this.f677a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8921c() {
        return this.f680b != null;
    }

    public Cif d(String str) {
        this.f685f = str;
        return this;
    }

    public boolean d() {
        return this.f682c != null;
    }

    public boolean e() {
        return this.f683d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m8918a((Cif) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f677a.get(0);
    }

    public boolean g() {
        return this.f684e != null;
    }

    public boolean h() {
        return this.f678a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f685f != null;
    }

    public boolean j() {
        return this.f686g != null;
    }

    public boolean k() {
        return this.f687h != null;
    }

    public boolean l() {
        return this.f688i != null;
    }

    public boolean m() {
        return this.f676a != null;
    }

    public boolean n() {
        return this.f677a.get(1);
    }

    public boolean o() {
        return this.f677a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        if (m8917a()) {
            sb.append("debug:");
            String str = this.f675a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m8920b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f674a;
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
        String str2 = this.f680b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f682c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f683d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f679a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f684e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f678a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f685f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f686g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f687h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f688i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f676a;
            if (byteBuffer == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                is.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f673a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f681b);
        }
        sb.append(")");
        return sb.toString();
    }
}
