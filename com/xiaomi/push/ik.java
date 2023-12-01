package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ik.class */
public class ik implements ir<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f813a;

    /* renamed from: a  reason: collision with other field name */
    public String f814a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f815a;

    /* renamed from: b  reason: collision with other field name */
    public String f816b;

    /* renamed from: c  reason: collision with other field name */
    public String f817c;

    /* renamed from: d  reason: collision with other field name */
    public String f818d;

    /* renamed from: e  reason: collision with other field name */
    public String f819e;

    /* renamed from: f  reason: collision with other field name */
    public String f820f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f812a = new jh("XmPushActionSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41525a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41526c = new iz("", (byte) 11, 3);
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
            int compareTo = Boolean.valueOf(m12000a()).compareTo(Boolean.valueOf(ikVar.m12000a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m12000a() || (a9 = is.a(this.f814a, ikVar.f814a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ikVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = is.a(this.f813a, ikVar.f813a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ikVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = is.a(this.f816b, ikVar.f816b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = is.a(this.f817c, ikVar.f817c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = is.a(this.f818d, ikVar.f818d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = is.a(this.f819e, ikVar.f819e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = is.a(this.f820f, ikVar.f820f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = is.a(this.f815a, ikVar.f815a)) == 0) {
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
        this.f816b = str;
        return this;
    }

    public void a() {
        if (this.f816b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f817c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f818d != null) {
        } else {
            throw new jd("Required field 'topic' was not present! Struct: " + toString());
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
                        this.f814a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f813a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f816b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f817c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f818d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 11) {
                        this.f819e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f820f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 15) {
                        ja mo12033a = jcVar.mo12033a();
                        this.f815a = new ArrayList(mo12033a.f889a);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < mo12033a.f889a) {
                                this.f815a.add(jcVar.mo12037a());
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
            jf.a(jcVar, mo12032a.f41543a);
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12000a() {
        return this.f814a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12001a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m12000a = m12000a();
        boolean m12000a2 = ikVar.m12000a();
        if ((m12000a || m12000a2) && !(m12000a && m12000a2 && this.f814a.equals(ikVar.f814a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ikVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f813a.m11909a(ikVar.f813a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ikVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f816b.equals(ikVar.f816b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ikVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f817c.equals(ikVar.f817c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ikVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f818d.equals(ikVar.f818d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ikVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f819e.equals(ikVar.f819e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f820f.equals(ikVar.f820f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f815a.equals(ikVar.f815a);
        }
        return true;
    }

    public ik b(String str) {
        this.f817c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f812a);
        if (this.f814a != null && m12000a()) {
            jcVar.a(f41525a);
            jcVar.a(this.f814a);
            jcVar.b();
        }
        if (this.f813a != null && b()) {
            jcVar.a(b);
            this.f813a.b(jcVar);
            jcVar.b();
        }
        if (this.f816b != null) {
            jcVar.a(f41526c);
            jcVar.a(this.f816b);
            jcVar.b();
        }
        if (this.f817c != null) {
            jcVar.a(d);
            jcVar.a(this.f817c);
            jcVar.b();
        }
        if (this.f818d != null) {
            jcVar.a(e);
            jcVar.a(this.f818d);
            jcVar.b();
        }
        if (this.f819e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f819e);
            jcVar.b();
        }
        if (this.f820f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f820f);
            jcVar.b();
        }
        if (this.f815a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja((byte) 11, this.f815a.size()));
            for (String str : this.f815a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public boolean b() {
        return this.f813a != null;
    }

    public ik c(String str) {
        this.f818d = str;
        return this;
    }

    public boolean c() {
        return this.f816b != null;
    }

    public ik d(String str) {
        this.f819e = str;
        return this;
    }

    public boolean d() {
        return this.f817c != null;
    }

    public ik e(String str) {
        this.f820f = str;
        return this;
    }

    public boolean e() {
        return this.f818d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m12001a((ik) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f819e != null;
    }

    public boolean g() {
        return this.f820f != null;
    }

    public boolean h() {
        return this.f815a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        if (m12000a()) {
            sb.append("debug:");
            String str = this.f814a;
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
            hv hvVar = this.f813a;
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
        String str2 = this.f816b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f817c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f818d;
        if (str4 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f819e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f820f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f815a;
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
