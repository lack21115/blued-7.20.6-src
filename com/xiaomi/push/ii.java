package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ii.class */
public class ii implements ir<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f790a;

    /* renamed from: a  reason: collision with other field name */
    public hv f791a;

    /* renamed from: a  reason: collision with other field name */
    public String f792a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f793a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f794b;

    /* renamed from: c  reason: collision with other field name */
    public String f795c;

    /* renamed from: d  reason: collision with other field name */
    public String f796d;

    /* renamed from: e  reason: collision with other field name */
    public String f797e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f789a = new jh("XmPushActionSendFeedbackResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41521a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41522c = new iz("", (byte) 11, 3);
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
            int compareTo = Boolean.valueOf(m11987a()).compareTo(Boolean.valueOf(iiVar.m11987a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11987a() || (a8 = is.a(this.f792a, iiVar.f792a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iiVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a7 = is.a(this.f791a, iiVar.f791a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a6 = is.a(this.f794b, iiVar.f794b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = is.a(this.f795c, iiVar.f795c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = is.a(this.f790a, iiVar.f790a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = is.a(this.f796d, iiVar.f796d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a2 = is.a(this.f797e, iiVar.f797e)) == 0) {
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
        if (this.f794b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f795c != null) {
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
                throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f792a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f791a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f794b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f795c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 10) {
                        this.f790a = jcVar.mo12031a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f796d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 11) {
                        this.f797e = jcVar.mo12037a();
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
        this.f793a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11987a() {
        return this.f792a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11988a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m11987a = m11987a();
        boolean m11987a2 = iiVar.m11987a();
        if ((m11987a || m11987a2) && !(m11987a && m11987a2 && this.f792a.equals(iiVar.f792a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iiVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f791a.m11909a(iiVar.f791a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iiVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f794b.equals(iiVar.f794b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iiVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f795c.equals(iiVar.f795c))) || this.f790a != iiVar.f790a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iiVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f796d.equals(iiVar.f796d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iiVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.f797e.equals(iiVar.f797e);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f789a);
        if (this.f792a != null && m11987a()) {
            jcVar.a(f41521a);
            jcVar.a(this.f792a);
            jcVar.b();
        }
        if (this.f791a != null && b()) {
            jcVar.a(b);
            this.f791a.b(jcVar);
            jcVar.b();
        }
        if (this.f794b != null) {
            jcVar.a(f41522c);
            jcVar.a(this.f794b);
            jcVar.b();
        }
        if (this.f795c != null) {
            jcVar.a(d);
            jcVar.a(this.f795c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f790a);
        jcVar.b();
        if (this.f796d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f796d);
            jcVar.b();
        }
        if (this.f797e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f797e);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public boolean b() {
        return this.f791a != null;
    }

    public boolean c() {
        return this.f794b != null;
    }

    public boolean d() {
        return this.f795c != null;
    }

    public boolean e() {
        return this.f793a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m11988a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f796d != null;
    }

    public boolean g() {
        return this.f797e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        if (m11987a()) {
            sb.append("debug:");
            String str = this.f792a;
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
            hv hvVar = this.f791a;
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
        String str2 = this.f794b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f795c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f790a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f796d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f797e;
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
