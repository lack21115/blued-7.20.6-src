package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ip.class */
public class ip implements ir<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f867a;

    /* renamed from: a  reason: collision with other field name */
    public hv f868a;

    /* renamed from: a  reason: collision with other field name */
    public String f869a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f870a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f871b;

    /* renamed from: c  reason: collision with other field name */
    public String f872c;

    /* renamed from: d  reason: collision with other field name */
    public String f873d;

    /* renamed from: e  reason: collision with other field name */
    public String f874e;

    /* renamed from: f  reason: collision with other field name */
    public String f875f;

    /* renamed from: g  reason: collision with other field name */
    public String f876g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f866a = new jh("XmPushActionUnSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41535a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41536c = new iz("", (byte) 11, 3);
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
            int compareTo = Boolean.valueOf(m12020a()).compareTo(Boolean.valueOf(ipVar.m12020a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m12020a() || (a10 = is.a(this.f869a, ipVar.f869a)) == 0) {
                int compareTo2 = Boolean.valueOf(m12022b()).compareTo(Boolean.valueOf(ipVar.m12022b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m12022b() || (a9 = is.a(this.f868a, ipVar.f868a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m12023c()).compareTo(Boolean.valueOf(ipVar.m12023c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m12023c() || (a8 = is.a(this.f871b, ipVar.f871b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = is.a(this.f872c, ipVar.f872c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = is.a(this.f867a, ipVar.f867a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = is.a(this.f873d, ipVar.f873d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = is.a(this.f874e, ipVar.f874e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = is.a(this.f875f, ipVar.f875f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = is.a(this.f876g, ipVar.f876g)) == 0) {
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
        return this.f871b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m12019a() {
        if (this.f871b != null) {
            return;
        }
        throw new jd("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                m12019a();
                return;
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f869a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f868a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f871b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f872c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 10) {
                        this.f867a = jcVar.mo12031a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f873d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 11) {
                        this.f874e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 11) {
                        this.f875f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 11) {
                        this.f876g = jcVar.mo12037a();
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
        this.f870a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12020a() {
        return this.f869a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12021a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m12020a = m12020a();
        boolean m12020a2 = ipVar.m12020a();
        if ((m12020a || m12020a2) && !(m12020a && m12020a2 && this.f869a.equals(ipVar.f869a))) {
            return false;
        }
        boolean m12022b = m12022b();
        boolean m12022b2 = ipVar.m12022b();
        if ((m12022b || m12022b2) && !(m12022b && m12022b2 && this.f868a.m11909a(ipVar.f868a))) {
            return false;
        }
        boolean m12023c = m12023c();
        boolean m12023c2 = ipVar.m12023c();
        if ((m12023c || m12023c2) && !(m12023c && m12023c2 && this.f871b.equals(ipVar.f871b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ipVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f872c.equals(ipVar.f872c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ipVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f867a == ipVar.f867a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ipVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f873d.equals(ipVar.f873d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f874e.equals(ipVar.f874e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f875f.equals(ipVar.f875f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f876g.equals(ipVar.f876g);
        }
        return true;
    }

    public String b() {
        return this.f874e;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m12019a();
        jcVar.a(f866a);
        if (this.f869a != null && m12020a()) {
            jcVar.a(f41535a);
            jcVar.a(this.f869a);
            jcVar.b();
        }
        if (this.f868a != null && m12022b()) {
            jcVar.a(b);
            this.f868a.b(jcVar);
            jcVar.b();
        }
        if (this.f871b != null) {
            jcVar.a(f41536c);
            jcVar.a(this.f871b);
            jcVar.b();
        }
        if (this.f872c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f872c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f867a);
            jcVar.b();
        }
        if (this.f873d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f873d);
            jcVar.b();
        }
        if (this.f874e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f874e);
            jcVar.b();
        }
        if (this.f875f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f875f);
            jcVar.b();
        }
        if (this.f876g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f876g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m12022b() {
        return this.f868a != null;
    }

    public String c() {
        return this.f876g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m12023c() {
        return this.f871b != null;
    }

    public boolean d() {
        return this.f872c != null;
    }

    public boolean e() {
        return this.f870a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m12021a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f873d != null;
    }

    public boolean g() {
        return this.f874e != null;
    }

    public boolean h() {
        return this.f875f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f876g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        if (m12020a()) {
            sb.append("debug:");
            String str = this.f869a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m12022b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f868a;
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
        String str2 = this.f871b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f872c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f867a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f873d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f874e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f875f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f876g;
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
