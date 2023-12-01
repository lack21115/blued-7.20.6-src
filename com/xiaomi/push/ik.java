package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ik.class */
public class ik implements ir<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f766a;

    /* renamed from: a  reason: collision with other field name */
    public String f767a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f768a;

    /* renamed from: b  reason: collision with other field name */
    public String f769b;

    /* renamed from: c  reason: collision with other field name */
    public String f770c;

    /* renamed from: d  reason: collision with other field name */
    public String f771d;

    /* renamed from: e  reason: collision with other field name */
    public String f772e;

    /* renamed from: f  reason: collision with other field name */
    public String f773f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f765a = new jh("XmPushActionSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27834a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27835c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 11, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 15, 8);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m8950a()).compareTo(Boolean.valueOf(ikVar.m8950a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8950a() || (a9 = is.a(this.f767a, ikVar.f767a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ikVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = is.a(this.f766a, ikVar.f766a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ikVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = is.a(this.f769b, ikVar.f769b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = is.a(this.f770c, ikVar.f770c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = is.a(this.f771d, ikVar.f771d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = is.a(this.f772e, ikVar.f772e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = is.a(this.f773f, ikVar.f773f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = is.a(this.f768a, ikVar.f768a)) == 0) {
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
        return getClass().getName().compareTo(ikVar.getClass().getName());
    }

    public ik a(String str) {
        this.f769b = str;
        return this;
    }

    public void a() {
        if (this.f769b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f770c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f771d != null) {
        } else {
            throw new jd("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f767a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f766a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f769b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f770c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 11) {
                        this.f771d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 11) {
                        this.f772e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f773f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 15) {
                        ja mo8983a = jcVar.mo8983a();
                        this.f768a = new ArrayList(mo8983a.f842a);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < mo8983a.f842a) {
                                this.f768a.add(jcVar.mo8987a());
                                i = i2 + 1;
                            } else {
                                jcVar.i();
                                continue;
                                jcVar.g();
                            }
                        }
                    }
                    break;
            }
            jf.a(jcVar, mo8982a.f27852a);
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8950a() {
        return this.f767a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8951a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m8950a = m8950a();
        boolean m8950a2 = ikVar.m8950a();
        if ((m8950a || m8950a2) && !(m8950a && m8950a2 && this.f767a.equals(ikVar.f767a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ikVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f766a.m8859a(ikVar.f766a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ikVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f769b.equals(ikVar.f769b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ikVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f770c.equals(ikVar.f770c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ikVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f771d.equals(ikVar.f771d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ikVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f772e.equals(ikVar.f772e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f773f.equals(ikVar.f773f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f768a.equals(ikVar.f768a);
        }
        return true;
    }

    public ik b(String str) {
        this.f770c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f765a);
        if (this.f767a != null && m8950a()) {
            jcVar.a(f27834a);
            jcVar.a(this.f767a);
            jcVar.b();
        }
        if (this.f766a != null && b()) {
            jcVar.a(b);
            this.f766a.b(jcVar);
            jcVar.b();
        }
        if (this.f769b != null) {
            jcVar.a(f27835c);
            jcVar.a(this.f769b);
            jcVar.b();
        }
        if (this.f770c != null) {
            jcVar.a(d);
            jcVar.a(this.f770c);
            jcVar.b();
        }
        if (this.f771d != null) {
            jcVar.a(e);
            jcVar.a(this.f771d);
            jcVar.b();
        }
        if (this.f772e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f772e);
            jcVar.b();
        }
        if (this.f773f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f773f);
            jcVar.b();
        }
        if (this.f768a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja((byte) 11, this.f768a.size()));
            for (String str : this.f768a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public boolean b() {
        return this.f766a != null;
    }

    public ik c(String str) {
        this.f771d = str;
        return this;
    }

    public boolean c() {
        return this.f769b != null;
    }

    public ik d(String str) {
        this.f772e = str;
        return this;
    }

    public boolean d() {
        return this.f770c != null;
    }

    public ik e(String str) {
        this.f773f = str;
        return this;
    }

    public boolean e() {
        return this.f771d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m8951a((ik) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f772e != null;
    }

    public boolean g() {
        return this.f773f != null;
    }

    public boolean h() {
        return this.f768a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        if (m8950a()) {
            sb.append("debug:");
            String str = this.f767a;
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
            hv hvVar = this.f766a;
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
        String str2 = this.f769b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f770c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f771d;
        if (str4 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f772e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f773f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f768a;
            if (list == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
