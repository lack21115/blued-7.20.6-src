package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hr.class */
public class hr implements ir<hr, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f538a;

    /* renamed from: a  reason: collision with other field name */
    public long f539a;

    /* renamed from: a  reason: collision with other field name */
    public String f540a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f541a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f542a;

    /* renamed from: b  reason: collision with other field name */
    public int f543b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f544b;

    /* renamed from: c  reason: collision with other field name */
    public int f545c;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f537a = new jh("OnlineConfigItem");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27798a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27799c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", (byte) 8, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", (byte) 11, 6);
    private static final iz g = new iz("", (byte) 2, 7);

    public int a() {
        return this.f538a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hr hrVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(hrVar.getClass())) {
            int compareTo = Boolean.valueOf(m8831a()).compareTo(Boolean.valueOf(hrVar.m8831a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8831a() || (a8 = is.a(this.f538a, hrVar.f538a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8833b()).compareTo(Boolean.valueOf(hrVar.m8833b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8833b() || (a7 = is.a(this.f543b, hrVar.f543b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m8834c()).compareTo(Boolean.valueOf(hrVar.m8834c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m8834c() || (a6 = is.a(this.f542a, hrVar.f542a)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = is.a(this.f545c, hrVar.f545c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = is.a(this.f539a, hrVar.f539a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = is.a(this.f540a, hrVar.f540a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a2 = is.a(this.f544b, hrVar.f544b)) == 0) {
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
        return getClass().getName().compareTo(hrVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m8828a() {
        return this.f539a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8829a() {
        return this.f540a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8830a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                m8830a();
                return;
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 8) {
                        this.f538a = jcVar.mo8980a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 8) {
                        this.f543b = jcVar.mo8980a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 2) {
                        this.f542a = jcVar.mo8992a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 8) {
                        this.f545c = jcVar.mo8980a();
                        d(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 10) {
                        this.f539a = jcVar.mo8981a();
                        e(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 11) {
                        this.f540a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 2) {
                        this.f544b = jcVar.mo8992a();
                        f(true);
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
        this.f541a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8831a() {
        return this.f541a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8832a(hr hrVar) {
        if (hrVar == null) {
            return false;
        }
        boolean m8831a = m8831a();
        boolean m8831a2 = hrVar.m8831a();
        if ((m8831a || m8831a2) && !(m8831a && m8831a2 && this.f538a == hrVar.f538a)) {
            return false;
        }
        boolean m8833b = m8833b();
        boolean m8833b2 = hrVar.m8833b();
        if ((m8833b || m8833b2) && !(m8833b && m8833b2 && this.f543b == hrVar.f543b)) {
            return false;
        }
        boolean m8834c = m8834c();
        boolean m8834c2 = hrVar.m8834c();
        if ((m8834c || m8834c2) && !(m8834c && m8834c2 && this.f542a == hrVar.f542a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hrVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f545c == hrVar.f545c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hrVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f539a == hrVar.f539a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hrVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f540a.equals(hrVar.f540a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hrVar.h();
        if (h || h2) {
            return h && h2 && this.f544b == hrVar.f544b;
        }
        return true;
    }

    public int b() {
        return this.f543b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8830a();
        jcVar.a(f537a);
        if (m8831a()) {
            jcVar.a(f27798a);
            jcVar.mo8991a(this.f538a);
            jcVar.b();
        }
        if (m8833b()) {
            jcVar.a(b);
            jcVar.mo8991a(this.f543b);
            jcVar.b();
        }
        if (m8834c()) {
            jcVar.a(f27799c);
            jcVar.a(this.f542a);
            jcVar.b();
        }
        if (d()) {
            jcVar.a(d);
            jcVar.mo8991a(this.f545c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f539a);
            jcVar.b();
        }
        if (this.f540a != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f540a);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(g);
            jcVar.a(this.f544b);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f541a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8833b() {
        return this.f541a.get(1);
    }

    public int c() {
        return this.f545c;
    }

    public void c(boolean z) {
        this.f541a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8834c() {
        return this.f541a.get(2);
    }

    public void d(boolean z) {
        this.f541a.set(3, z);
    }

    public boolean d() {
        return this.f541a.get(3);
    }

    public void e(boolean z) {
        this.f541a.set(4, z);
    }

    public boolean e() {
        return this.f541a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hr)) {
            return m8832a((hr) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f541a.set(5, z);
    }

    public boolean f() {
        return this.f540a != null;
    }

    public boolean g() {
        return this.f544b;
    }

    public boolean h() {
        return this.f541a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        if (m8831a()) {
            sb.append("key:");
            sb.append(this.f538a);
            z = false;
        } else {
            z = true;
        }
        boolean z2 = z;
        if (m8833b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f543b);
            z2 = false;
        }
        boolean z3 = z2;
        if (m8834c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f542a);
            z3 = false;
        }
        boolean z4 = z3;
        if (d()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f545c);
            z4 = false;
        }
        boolean z5 = z4;
        if (e()) {
            if (!z4) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f539a);
            z5 = false;
        }
        if (f()) {
            if (!z5) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f540a;
            String str2 = str;
            if (str == null) {
                str2 = com.igexin.push.core.b.l;
            }
            sb.append(str2);
            z5 = false;
        }
        if (h()) {
            if (!z5) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f544b);
        }
        sb.append(")");
        return sb.toString();
    }
}
