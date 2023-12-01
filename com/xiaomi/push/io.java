package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/io.class */
public class io implements ir<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f811a;

    /* renamed from: a  reason: collision with other field name */
    public String f812a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f813a;

    /* renamed from: b  reason: collision with other field name */
    public String f814b;

    /* renamed from: c  reason: collision with other field name */
    public String f815c;

    /* renamed from: d  reason: collision with other field name */
    public String f816d;

    /* renamed from: e  reason: collision with other field name */
    public String f817e;

    /* renamed from: f  reason: collision with other field name */
    public String f818f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f810a = new jh("XmPushActionUnSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27842a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27843c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 11, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 15, 8);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(io ioVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(ioVar.getClass())) {
            int compareTo = Boolean.valueOf(m8966a()).compareTo(Boolean.valueOf(ioVar.m8966a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8966a() || (a9 = is.a(this.f812a, ioVar.f812a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = is.a(this.f811a, ioVar.f811a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = is.a(this.f814b, ioVar.f814b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = is.a(this.f815c, ioVar.f815c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = is.a(this.f816d, ioVar.f816d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = is.a(this.f817e, ioVar.f817e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = is.a(this.f818f, ioVar.f818f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = is.a(this.f813a, ioVar.f813a)) == 0) {
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
        return getClass().getName().compareTo(ioVar.getClass().getName());
    }

    public io a(String str) {
        this.f814b = str;
        return this;
    }

    public void a() {
        if (this.f814b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f815c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f816d != null) {
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
                        this.f812a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f811a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f814b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f815c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 11) {
                        this.f816d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 11) {
                        this.f817e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f818f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 15) {
                        ja mo8983a = jcVar.mo8983a();
                        this.f813a = new ArrayList(mo8983a.f842a);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < mo8983a.f842a) {
                                this.f813a.add(jcVar.mo8987a());
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
    public boolean m8966a() {
        return this.f812a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8967a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m8966a = m8966a();
        boolean m8966a2 = ioVar.m8966a();
        if ((m8966a || m8966a2) && !(m8966a && m8966a2 && this.f812a.equals(ioVar.f812a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f811a.m8859a(ioVar.f811a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f814b.equals(ioVar.f814b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f815c.equals(ioVar.f815c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ioVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f816d.equals(ioVar.f816d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f817e.equals(ioVar.f817e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f818f.equals(ioVar.f818f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ioVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f813a.equals(ioVar.f813a);
        }
        return true;
    }

    public io b(String str) {
        this.f815c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f810a);
        if (this.f812a != null && m8966a()) {
            jcVar.a(f27842a);
            jcVar.a(this.f812a);
            jcVar.b();
        }
        if (this.f811a != null && b()) {
            jcVar.a(b);
            this.f811a.b(jcVar);
            jcVar.b();
        }
        if (this.f814b != null) {
            jcVar.a(f27843c);
            jcVar.a(this.f814b);
            jcVar.b();
        }
        if (this.f815c != null) {
            jcVar.a(d);
            jcVar.a(this.f815c);
            jcVar.b();
        }
        if (this.f816d != null) {
            jcVar.a(e);
            jcVar.a(this.f816d);
            jcVar.b();
        }
        if (this.f817e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f817e);
            jcVar.b();
        }
        if (this.f818f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f818f);
            jcVar.b();
        }
        if (this.f813a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja((byte) 11, this.f813a.size()));
            for (String str : this.f813a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public boolean b() {
        return this.f811a != null;
    }

    public io c(String str) {
        this.f816d = str;
        return this;
    }

    public boolean c() {
        return this.f814b != null;
    }

    public io d(String str) {
        this.f817e = str;
        return this;
    }

    public boolean d() {
        return this.f815c != null;
    }

    public io e(String str) {
        this.f818f = str;
        return this;
    }

    public boolean e() {
        return this.f816d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m8967a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f817e != null;
    }

    public boolean g() {
        return this.f818f != null;
    }

    public boolean h() {
        return this.f813a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        if (m8966a()) {
            sb.append("debug:");
            String str = this.f812a;
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
            hv hvVar = this.f811a;
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
        String str2 = this.f814b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f815c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f816d;
        if (str4 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f817e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f818f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f813a;
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
