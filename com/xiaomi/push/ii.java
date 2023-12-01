package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ii.class */
public class ii implements ir<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f743a;

    /* renamed from: a  reason: collision with other field name */
    public hv f744a;

    /* renamed from: a  reason: collision with other field name */
    public String f745a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f746a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f747b;

    /* renamed from: c  reason: collision with other field name */
    public String f748c;

    /* renamed from: d  reason: collision with other field name */
    public String f749d;

    /* renamed from: e  reason: collision with other field name */
    public String f750e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f742a = new jh("XmPushActionSendFeedbackResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27830a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27831c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 10, 6);
    private static final iz f = new iz("", (byte) 11, 7);
    private static final iz g = new iz("", (byte) 11, 8);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ii iiVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(iiVar.getClass())) {
            int compareTo = Boolean.valueOf(m8937a()).compareTo(Boolean.valueOf(iiVar.m8937a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8937a() || (a8 = is.a(this.f745a, iiVar.f745a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iiVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a7 = is.a(this.f744a, iiVar.f744a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a6 = is.a(this.f747b, iiVar.f747b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = is.a(this.f748c, iiVar.f748c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = is.a(this.f743a, iiVar.f743a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = is.a(this.f749d, iiVar.f749d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a2 = is.a(this.f750e, iiVar.f750e)) == 0) {
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
        return getClass().getName().compareTo(iiVar.getClass().getName());
    }

    public void a() {
        if (this.f747b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f748c != null) {
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
                throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f745a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f744a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f747b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f748c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 10) {
                        this.f743a = jcVar.mo8981a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f749d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 11) {
                        this.f750e = jcVar.mo8987a();
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
        this.f746a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8937a() {
        return this.f745a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8938a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m8937a = m8937a();
        boolean m8937a2 = iiVar.m8937a();
        if ((m8937a || m8937a2) && !(m8937a && m8937a2 && this.f745a.equals(iiVar.f745a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iiVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f744a.m8859a(iiVar.f744a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iiVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f747b.equals(iiVar.f747b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iiVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f748c.equals(iiVar.f748c))) || this.f743a != iiVar.f743a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iiVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f749d.equals(iiVar.f749d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iiVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.f750e.equals(iiVar.f750e);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f742a);
        if (this.f745a != null && m8937a()) {
            jcVar.a(f27830a);
            jcVar.a(this.f745a);
            jcVar.b();
        }
        if (this.f744a != null && b()) {
            jcVar.a(b);
            this.f744a.b(jcVar);
            jcVar.b();
        }
        if (this.f747b != null) {
            jcVar.a(f27831c);
            jcVar.a(this.f747b);
            jcVar.b();
        }
        if (this.f748c != null) {
            jcVar.a(d);
            jcVar.a(this.f748c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f743a);
        jcVar.b();
        if (this.f749d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f749d);
            jcVar.b();
        }
        if (this.f750e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f750e);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public boolean b() {
        return this.f744a != null;
    }

    public boolean c() {
        return this.f747b != null;
    }

    public boolean d() {
        return this.f748c != null;
    }

    public boolean e() {
        return this.f746a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m8938a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f749d != null;
    }

    public boolean g() {
        return this.f750e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        if (m8937a()) {
            sb.append("debug:");
            String str = this.f745a;
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
            hv hvVar = this.f744a;
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
        String str2 = this.f747b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f748c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f743a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f749d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f750e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
