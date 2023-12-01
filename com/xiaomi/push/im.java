package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/im.class */
public class im implements ir<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f833a;

    /* renamed from: a  reason: collision with other field name */
    public hv f834a;

    /* renamed from: a  reason: collision with other field name */
    public String f835a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f836a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f837a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f838b;

    /* renamed from: c  reason: collision with other field name */
    public String f839c;

    /* renamed from: d  reason: collision with other field name */
    public String f840d;

    /* renamed from: e  reason: collision with other field name */
    public String f841e;

    /* renamed from: f  reason: collision with other field name */
    public String f842f;

    /* renamed from: g  reason: collision with other field name */
    public String f843g;

    /* renamed from: h  reason: collision with other field name */
    public String f844h;

    /* renamed from: i  reason: collision with other field name */
    public String f845i;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f832a = new jh("XmPushActionUnRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41529a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41530c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 11, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 11, 8);
    private static final iz i = new iz("", (byte) 11, 9);
    private static final iz j = new iz("", (byte) 11, 10);
    private static final iz k = new iz("", (byte) 2, 11);
    private static final iz l = new iz("", (byte) 10, 12);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(im imVar) {
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
        if (getClass().equals(imVar.getClass())) {
            int compareTo = Boolean.valueOf(m12009a()).compareTo(Boolean.valueOf(imVar.m12009a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m12009a() || (a13 = is.a(this.f835a, imVar.f835a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(imVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a12 = is.a(this.f834a, imVar.f834a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(imVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a11 = is.a(this.f838b, imVar.f838b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a10 = is.a(this.f839c, imVar.f839c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a9 = is.a(this.f840d, imVar.f840d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a8 = is.a(this.f841e, imVar.f841e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a7 = is.a(this.f842f, imVar.f842f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a6 = is.a(this.f843g, imVar.f843g)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a5 = is.a(this.f844h, imVar.f844h)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a4 = is.a(this.f845i, imVar.f845i)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a3 = is.a(this.f837a, imVar.f837a)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a2 = is.a(this.f833a, imVar.f833a)) == 0) {
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
        return getClass().getName().compareTo(imVar.getClass().getName());
    }

    public im a(String str) {
        this.f838b = str;
        return this;
    }

    public void a() {
        if (this.f838b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f839c != null) {
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
                a();
                return;
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f835a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f834a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f838b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f839c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f840d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 11) {
                        this.f841e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f842f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 11) {
                        this.f843g = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 11) {
                        this.f844h = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 11) {
                        this.f845i = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 11:
                    if (mo12032a.f41543a == 2) {
                        this.f837a = jcVar.mo12042a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo12032a.f41543a == 10) {
                        this.f833a = jcVar.mo12031a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
            }
            jf.a(jcVar, mo12032a.f41543a);
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f836a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12009a() {
        return this.f835a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12010a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m12009a = m12009a();
        boolean m12009a2 = imVar.m12009a();
        if ((m12009a || m12009a2) && !(m12009a && m12009a2 && this.f835a.equals(imVar.f835a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = imVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f834a.m11909a(imVar.f834a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = imVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f838b.equals(imVar.f838b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f839c.equals(imVar.f839c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f840d.equals(imVar.f840d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f841e.equals(imVar.f841e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f842f.equals(imVar.f842f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f843g.equals(imVar.f843g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f844h.equals(imVar.f844h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = imVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f845i.equals(imVar.f845i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = imVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f837a == imVar.f837a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = imVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f833a == imVar.f833a;
        }
        return true;
    }

    public im b(String str) {
        this.f839c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f832a);
        if (this.f835a != null && m12009a()) {
            jcVar.a(f41529a);
            jcVar.a(this.f835a);
            jcVar.b();
        }
        if (this.f834a != null && b()) {
            jcVar.a(b);
            this.f834a.b(jcVar);
            jcVar.b();
        }
        if (this.f838b != null) {
            jcVar.a(f41530c);
            jcVar.a(this.f838b);
            jcVar.b();
        }
        if (this.f839c != null) {
            jcVar.a(d);
            jcVar.a(this.f839c);
            jcVar.b();
        }
        if (this.f840d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f840d);
            jcVar.b();
        }
        if (this.f841e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f841e);
            jcVar.b();
        }
        if (this.f842f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f842f);
            jcVar.b();
        }
        if (this.f843g != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f843g);
            jcVar.b();
        }
        if (this.f844h != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f844h);
            jcVar.b();
        }
        if (this.f845i != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f845i);
            jcVar.b();
        }
        if (k()) {
            jcVar.a(k);
            jcVar.a(this.f837a);
            jcVar.b();
        }
        if (l()) {
            jcVar.a(l);
            jcVar.a(this.f833a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f836a.set(1, z);
    }

    public boolean b() {
        return this.f834a != null;
    }

    public im c(String str) {
        this.f840d = str;
        return this;
    }

    public boolean c() {
        return this.f838b != null;
    }

    public im d(String str) {
        this.f842f = str;
        return this;
    }

    public boolean d() {
        return this.f839c != null;
    }

    public im e(String str) {
        this.f843g = str;
        return this;
    }

    public boolean e() {
        return this.f840d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m12010a((im) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f841e != null;
    }

    public boolean g() {
        return this.f842f != null;
    }

    public boolean h() {
        return this.f843g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f844h != null;
    }

    public boolean j() {
        return this.f845i != null;
    }

    public boolean k() {
        return this.f836a.get(0);
    }

    public boolean l() {
        return this.f836a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        if (m12009a()) {
            sb.append("debug:");
            String str = this.f835a;
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
            hv hvVar = this.f834a;
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
        String str2 = this.f838b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f839c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f840d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f841e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f842f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f843g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f844h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f845i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f837a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f833a);
        }
        sb.append(")");
        return sb.toString();
    }
}
