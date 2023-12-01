package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ip.class */
public class ip implements ir<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f820a;

    /* renamed from: a  reason: collision with other field name */
    public hv f821a;

    /* renamed from: a  reason: collision with other field name */
    public String f822a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f823a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f824b;

    /* renamed from: c  reason: collision with other field name */
    public String f825c;

    /* renamed from: d  reason: collision with other field name */
    public String f826d;

    /* renamed from: e  reason: collision with other field name */
    public String f827e;

    /* renamed from: f  reason: collision with other field name */
    public String f828f;

    /* renamed from: g  reason: collision with other field name */
    public String f829g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f819a = new jh("XmPushActionUnSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27844a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27845c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 10, 6);
    private static final iz f = new iz("", (byte) 11, 7);
    private static final iz g = new iz("", (byte) 11, 8);
    private static final iz h = new iz("", (byte) 11, 9);
    private static final iz i = new iz("", (byte) 11, 10);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ip ipVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(ipVar.getClass())) {
            int compareTo = Boolean.valueOf(m8970a()).compareTo(Boolean.valueOf(ipVar.m8970a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8970a() || (a10 = is.a(this.f822a, ipVar.f822a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8972b()).compareTo(Boolean.valueOf(ipVar.m8972b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8972b() || (a9 = is.a(this.f821a, ipVar.f821a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m8973c()).compareTo(Boolean.valueOf(ipVar.m8973c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m8973c() || (a8 = is.a(this.f824b, ipVar.f824b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = is.a(this.f825c, ipVar.f825c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = is.a(this.f820a, ipVar.f820a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = is.a(this.f826d, ipVar.f826d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = is.a(this.f827e, ipVar.f827e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = is.a(this.f828f, ipVar.f828f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = is.a(this.f829g, ipVar.f829g)) == 0) {
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
        return getClass().getName().compareTo(ipVar.getClass().getName());
    }

    public String a() {
        return this.f824b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8969a() {
        if (this.f824b != null) {
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
                m8969a();
                return;
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f822a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f821a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f824b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f825c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 10) {
                        this.f820a = jcVar.mo8981a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f826d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 11) {
                        this.f827e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 11) {
                        this.f828f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 11) {
                        this.f829g = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
            }
            jf.a(jcVar, mo8982a.f27852a);
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f823a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8970a() {
        return this.f822a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8971a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m8970a = m8970a();
        boolean m8970a2 = ipVar.m8970a();
        if ((m8970a || m8970a2) && !(m8970a && m8970a2 && this.f822a.equals(ipVar.f822a))) {
            return false;
        }
        boolean m8972b = m8972b();
        boolean m8972b2 = ipVar.m8972b();
        if ((m8972b || m8972b2) && !(m8972b && m8972b2 && this.f821a.m8859a(ipVar.f821a))) {
            return false;
        }
        boolean m8973c = m8973c();
        boolean m8973c2 = ipVar.m8973c();
        if ((m8973c || m8973c2) && !(m8973c && m8973c2 && this.f824b.equals(ipVar.f824b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ipVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f825c.equals(ipVar.f825c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ipVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f820a == ipVar.f820a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ipVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f826d.equals(ipVar.f826d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f827e.equals(ipVar.f827e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f828f.equals(ipVar.f828f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f829g.equals(ipVar.f829g);
        }
        return true;
    }

    public String b() {
        return this.f827e;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8969a();
        jcVar.a(f819a);
        if (this.f822a != null && m8970a()) {
            jcVar.a(f27844a);
            jcVar.a(this.f822a);
            jcVar.b();
        }
        if (this.f821a != null && m8972b()) {
            jcVar.a(b);
            this.f821a.b(jcVar);
            jcVar.b();
        }
        if (this.f824b != null) {
            jcVar.a(f27845c);
            jcVar.a(this.f824b);
            jcVar.b();
        }
        if (this.f825c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f825c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f820a);
            jcVar.b();
        }
        if (this.f826d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f826d);
            jcVar.b();
        }
        if (this.f827e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f827e);
            jcVar.b();
        }
        if (this.f828f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f828f);
            jcVar.b();
        }
        if (this.f829g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f829g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8972b() {
        return this.f821a != null;
    }

    public String c() {
        return this.f829g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8973c() {
        return this.f824b != null;
    }

    public boolean d() {
        return this.f825c != null;
    }

    public boolean e() {
        return this.f823a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m8971a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f826d != null;
    }

    public boolean g() {
        return this.f827e != null;
    }

    public boolean h() {
        return this.f828f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f829g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        if (m8970a()) {
            sb.append("debug:");
            String str = this.f822a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m8972b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f821a;
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
        String str2 = this.f824b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f825c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f820a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f826d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f827e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f828f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f829g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
