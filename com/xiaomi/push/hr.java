package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hr.class */
public class hr implements ir<hr, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f585a;

    /* renamed from: a  reason: collision with other field name */
    public long f586a;

    /* renamed from: a  reason: collision with other field name */
    public String f587a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f588a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f589a;

    /* renamed from: b  reason: collision with other field name */
    public int f590b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f591b;

    /* renamed from: c  reason: collision with other field name */
    public int f592c;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f584a = new jh("OnlineConfigItem");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41489a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41490c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", (byte) 8, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", (byte) 11, 6);
    private static final iz g = new iz("", (byte) 2, 7);

    public int a() {
        return this.f585a;
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
            int compareTo = Boolean.valueOf(m11881a()).compareTo(Boolean.valueOf(hrVar.m11881a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11881a() || (a8 = is.a(this.f585a, hrVar.f585a)) == 0) {
                int compareTo2 = Boolean.valueOf(m11883b()).compareTo(Boolean.valueOf(hrVar.m11883b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m11883b() || (a7 = is.a(this.f590b, hrVar.f590b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m11884c()).compareTo(Boolean.valueOf(hrVar.m11884c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m11884c() || (a6 = is.a(this.f589a, hrVar.f589a)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = is.a(this.f592c, hrVar.f592c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = is.a(this.f586a, hrVar.f586a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = is.a(this.f587a, hrVar.f587a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a2 = is.a(this.f591b, hrVar.f591b)) == 0) {
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
    public long m11878a() {
        return this.f586a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11879a() {
        return this.f587a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11880a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                m11880a();
                return;
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 8) {
                        this.f585a = jcVar.mo12030a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 8) {
                        this.f590b = jcVar.mo12030a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 2) {
                        this.f589a = jcVar.mo12042a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 8) {
                        this.f592c = jcVar.mo12030a();
                        d(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 10) {
                        this.f586a = jcVar.mo12031a();
                        e(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 11) {
                        this.f587a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 2) {
                        this.f591b = jcVar.mo12042a();
                        f(true);
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
        this.f588a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11881a() {
        return this.f588a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11882a(hr hrVar) {
        if (hrVar == null) {
            return false;
        }
        boolean m11881a = m11881a();
        boolean m11881a2 = hrVar.m11881a();
        if ((m11881a || m11881a2) && !(m11881a && m11881a2 && this.f585a == hrVar.f585a)) {
            return false;
        }
        boolean m11883b = m11883b();
        boolean m11883b2 = hrVar.m11883b();
        if ((m11883b || m11883b2) && !(m11883b && m11883b2 && this.f590b == hrVar.f590b)) {
            return false;
        }
        boolean m11884c = m11884c();
        boolean m11884c2 = hrVar.m11884c();
        if ((m11884c || m11884c2) && !(m11884c && m11884c2 && this.f589a == hrVar.f589a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hrVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f592c == hrVar.f592c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hrVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f586a == hrVar.f586a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hrVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f587a.equals(hrVar.f587a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hrVar.h();
        if (h || h2) {
            return h && h2 && this.f591b == hrVar.f591b;
        }
        return true;
    }

    public int b() {
        return this.f590b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11880a();
        jcVar.a(f584a);
        if (m11881a()) {
            jcVar.a(f41489a);
            jcVar.mo12041a(this.f585a);
            jcVar.b();
        }
        if (m11883b()) {
            jcVar.a(b);
            jcVar.mo12041a(this.f590b);
            jcVar.b();
        }
        if (m11884c()) {
            jcVar.a(f41490c);
            jcVar.a(this.f589a);
            jcVar.b();
        }
        if (d()) {
            jcVar.a(d);
            jcVar.mo12041a(this.f592c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f586a);
            jcVar.b();
        }
        if (this.f587a != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f587a);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(g);
            jcVar.a(this.f591b);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f588a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11883b() {
        return this.f588a.get(1);
    }

    public int c() {
        return this.f592c;
    }

    public void c(boolean z) {
        this.f588a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m11884c() {
        return this.f588a.get(2);
    }

    public void d(boolean z) {
        this.f588a.set(3, z);
    }

    public boolean d() {
        return this.f588a.get(3);
    }

    public void e(boolean z) {
        this.f588a.set(4, z);
    }

    public boolean e() {
        return this.f588a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hr)) {
            return m11882a((hr) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f588a.set(5, z);
    }

    public boolean f() {
        return this.f587a != null;
    }

    public boolean g() {
        return this.f591b;
    }

    public boolean h() {
        return this.f588a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        if (m11881a()) {
            sb.append("key:");
            sb.append(this.f585a);
            z = false;
        } else {
            z = true;
        }
        boolean z2 = z;
        if (m11883b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f590b);
            z2 = false;
        }
        boolean z3 = z2;
        if (m11884c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f589a);
            z3 = false;
        }
        boolean z4 = z3;
        if (d()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f592c);
            z4 = false;
        }
        boolean z5 = z4;
        if (e()) {
            if (!z4) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f586a);
            z5 = false;
        }
        if (f()) {
            if (!z5) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f587a;
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
            sb.append(this.f591b);
        }
        sb.append(")");
        return sb.toString();
    }
}
