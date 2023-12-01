package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/il.class */
public class il implements ir<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f775a;

    /* renamed from: a  reason: collision with other field name */
    public hv f776a;

    /* renamed from: a  reason: collision with other field name */
    public String f777a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f778a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f779b;

    /* renamed from: c  reason: collision with other field name */
    public String f780c;

    /* renamed from: d  reason: collision with other field name */
    public String f781d;

    /* renamed from: e  reason: collision with other field name */
    public String f782e;

    /* renamed from: f  reason: collision with other field name */
    public String f783f;

    /* renamed from: g  reason: collision with other field name */
    public String f784g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f774a = new jh("XmPushActionSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27836a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27837c = new iz("", (byte) 11, 3);
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
            int compareTo = Boolean.valueOf(m8954a()).compareTo(Boolean.valueOf(ilVar.m8954a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8954a() || (a10 = is.a(this.f777a, ilVar.f777a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8956b()).compareTo(Boolean.valueOf(ilVar.m8956b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8956b() || (a9 = is.a(this.f776a, ilVar.f776a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m8957c()).compareTo(Boolean.valueOf(ilVar.m8957c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m8957c() || (a8 = is.a(this.f779b, ilVar.f779b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = is.a(this.f780c, ilVar.f780c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = is.a(this.f775a, ilVar.f775a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = is.a(this.f781d, ilVar.f781d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = is.a(this.f782e, ilVar.f782e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = is.a(this.f783f, ilVar.f783f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = is.a(this.f784g, ilVar.f784g)) == 0) {
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
        return this.f779b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8953a() {
        if (this.f779b != null) {
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
                m8953a();
                return;
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f777a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f776a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f779b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f780c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 10) {
                        this.f775a = jcVar.mo8981a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f781d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 11) {
                        this.f782e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 11) {
                        this.f783f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 11) {
                        this.f784g = jcVar.mo8987a();
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
        this.f778a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8954a() {
        return this.f777a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8955a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m8954a = m8954a();
        boolean m8954a2 = ilVar.m8954a();
        if ((m8954a || m8954a2) && !(m8954a && m8954a2 && this.f777a.equals(ilVar.f777a))) {
            return false;
        }
        boolean m8956b = m8956b();
        boolean m8956b2 = ilVar.m8956b();
        if ((m8956b || m8956b2) && !(m8956b && m8956b2 && this.f776a.m8859a(ilVar.f776a))) {
            return false;
        }
        boolean m8957c = m8957c();
        boolean m8957c2 = ilVar.m8957c();
        if ((m8957c || m8957c2) && !(m8957c && m8957c2 && this.f779b.equals(ilVar.f779b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f780c.equals(ilVar.f780c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f775a == ilVar.f775a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f781d.equals(ilVar.f781d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f782e.equals(ilVar.f782e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f783f.equals(ilVar.f783f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f784g.equals(ilVar.f784g);
        }
        return true;
    }

    public String b() {
        return this.f782e;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8953a();
        jcVar.a(f774a);
        if (this.f777a != null && m8954a()) {
            jcVar.a(f27836a);
            jcVar.a(this.f777a);
            jcVar.b();
        }
        if (this.f776a != null && m8956b()) {
            jcVar.a(b);
            this.f776a.b(jcVar);
            jcVar.b();
        }
        if (this.f779b != null) {
            jcVar.a(f27837c);
            jcVar.a(this.f779b);
            jcVar.b();
        }
        if (this.f780c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f780c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f775a);
            jcVar.b();
        }
        if (this.f781d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f781d);
            jcVar.b();
        }
        if (this.f782e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f782e);
            jcVar.b();
        }
        if (this.f783f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f783f);
            jcVar.b();
        }
        if (this.f784g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f784g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8956b() {
        return this.f776a != null;
    }

    public String c() {
        return this.f784g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8957c() {
        return this.f779b != null;
    }

    public boolean d() {
        return this.f780c != null;
    }

    public boolean e() {
        return this.f778a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m8955a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f781d != null;
    }

    public boolean g() {
        return this.f782e != null;
    }

    public boolean h() {
        return this.f783f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f784g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        if (m8954a()) {
            sb.append("debug:");
            String str = this.f777a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m8956b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f776a;
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
        String str2 = this.f779b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f780c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f775a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f781d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f782e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f783f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f784g;
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
