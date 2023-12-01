package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/il.class */
public class il implements ir<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f822a;

    /* renamed from: a  reason: collision with other field name */
    public hv f823a;

    /* renamed from: a  reason: collision with other field name */
    public String f824a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f825a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f826b;

    /* renamed from: c  reason: collision with other field name */
    public String f827c;

    /* renamed from: d  reason: collision with other field name */
    public String f828d;

    /* renamed from: e  reason: collision with other field name */
    public String f829e;

    /* renamed from: f  reason: collision with other field name */
    public String f830f;

    /* renamed from: g  reason: collision with other field name */
    public String f831g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f821a = new jh("XmPushActionSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41527a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41528c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 10, 6);
    private static final iz f = new iz("", (byte) 11, 7);
    private static final iz g = new iz("", (byte) 11, 8);
    private static final iz h = new iz("", (byte) 11, 9);
    private static final iz i = new iz("", (byte) 11, 10);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(il ilVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(ilVar.getClass())) {
            int compareTo = Boolean.valueOf(m12004a()).compareTo(Boolean.valueOf(ilVar.m12004a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m12004a() || (a10 = is.a(this.f824a, ilVar.f824a)) == 0) {
                int compareTo2 = Boolean.valueOf(m12006b()).compareTo(Boolean.valueOf(ilVar.m12006b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m12006b() || (a9 = is.a(this.f823a, ilVar.f823a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m12007c()).compareTo(Boolean.valueOf(ilVar.m12007c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m12007c() || (a8 = is.a(this.f826b, ilVar.f826b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = is.a(this.f827c, ilVar.f827c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = is.a(this.f822a, ilVar.f822a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = is.a(this.f828d, ilVar.f828d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = is.a(this.f829e, ilVar.f829e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = is.a(this.f830f, ilVar.f830f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = is.a(this.f831g, ilVar.f831g)) == 0) {
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
        return getClass().getName().compareTo(ilVar.getClass().getName());
    }

    public String a() {
        return this.f826b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m12003a() {
        if (this.f826b != null) {
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
                m12003a();
                return;
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f824a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f823a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f826b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f827c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 10) {
                        this.f822a = jcVar.mo12031a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f828d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 11) {
                        this.f829e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 11) {
                        this.f830f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 11) {
                        this.f831g = jcVar.mo12037a();
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
        this.f825a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12004a() {
        return this.f824a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12005a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m12004a = m12004a();
        boolean m12004a2 = ilVar.m12004a();
        if ((m12004a || m12004a2) && !(m12004a && m12004a2 && this.f824a.equals(ilVar.f824a))) {
            return false;
        }
        boolean m12006b = m12006b();
        boolean m12006b2 = ilVar.m12006b();
        if ((m12006b || m12006b2) && !(m12006b && m12006b2 && this.f823a.m11909a(ilVar.f823a))) {
            return false;
        }
        boolean m12007c = m12007c();
        boolean m12007c2 = ilVar.m12007c();
        if ((m12007c || m12007c2) && !(m12007c && m12007c2 && this.f826b.equals(ilVar.f826b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f827c.equals(ilVar.f827c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f822a == ilVar.f822a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f828d.equals(ilVar.f828d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f829e.equals(ilVar.f829e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f830f.equals(ilVar.f830f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f831g.equals(ilVar.f831g);
        }
        return true;
    }

    public String b() {
        return this.f829e;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m12003a();
        jcVar.a(f821a);
        if (this.f824a != null && m12004a()) {
            jcVar.a(f41527a);
            jcVar.a(this.f824a);
            jcVar.b();
        }
        if (this.f823a != null && m12006b()) {
            jcVar.a(b);
            this.f823a.b(jcVar);
            jcVar.b();
        }
        if (this.f826b != null) {
            jcVar.a(f41528c);
            jcVar.a(this.f826b);
            jcVar.b();
        }
        if (this.f827c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f827c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f822a);
            jcVar.b();
        }
        if (this.f828d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f828d);
            jcVar.b();
        }
        if (this.f829e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f829e);
            jcVar.b();
        }
        if (this.f830f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f830f);
            jcVar.b();
        }
        if (this.f831g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f831g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m12006b() {
        return this.f823a != null;
    }

    public String c() {
        return this.f831g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m12007c() {
        return this.f826b != null;
    }

    public boolean d() {
        return this.f827c != null;
    }

    public boolean e() {
        return this.f825a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m12005a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f828d != null;
    }

    public boolean g() {
        return this.f829e != null;
    }

    public boolean h() {
        return this.f830f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f831g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        if (m12004a()) {
            sb.append("debug:");
            String str = this.f824a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m12006b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f823a;
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
        String str2 = this.f826b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f827c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f822a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f828d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f829e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f830f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f831g;
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
