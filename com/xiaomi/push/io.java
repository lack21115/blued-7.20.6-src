package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/io.class */
public class io implements ir<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f858a;

    /* renamed from: a  reason: collision with other field name */
    public String f859a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f860a;

    /* renamed from: b  reason: collision with other field name */
    public String f861b;

    /* renamed from: c  reason: collision with other field name */
    public String f862c;

    /* renamed from: d  reason: collision with other field name */
    public String f863d;

    /* renamed from: e  reason: collision with other field name */
    public String f864e;

    /* renamed from: f  reason: collision with other field name */
    public String f865f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f857a = new jh("XmPushActionUnSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41533a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41534c = new iz("", (byte) 11, 3);
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
            int compareTo = Boolean.valueOf(m12016a()).compareTo(Boolean.valueOf(ioVar.m12016a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m12016a() || (a9 = is.a(this.f859a, ioVar.f859a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = is.a(this.f858a, ioVar.f858a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = is.a(this.f861b, ioVar.f861b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = is.a(this.f862c, ioVar.f862c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = is.a(this.f863d, ioVar.f863d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = is.a(this.f864e, ioVar.f864e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = is.a(this.f865f, ioVar.f865f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = is.a(this.f860a, ioVar.f860a)) == 0) {
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
        this.f861b = str;
        return this;
    }

    public void a() {
        if (this.f861b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f862c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f863d != null) {
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
                        this.f859a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f858a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f861b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f862c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f863d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 11) {
                        this.f864e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f865f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 15) {
                        ja mo12033a = jcVar.mo12033a();
                        this.f860a = new ArrayList(mo12033a.f889a);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < mo12033a.f889a) {
                                this.f860a.add(jcVar.mo12037a());
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
    public boolean m12016a() {
        return this.f859a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12017a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m12016a = m12016a();
        boolean m12016a2 = ioVar.m12016a();
        if ((m12016a || m12016a2) && !(m12016a && m12016a2 && this.f859a.equals(ioVar.f859a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f858a.m11909a(ioVar.f858a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f861b.equals(ioVar.f861b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f862c.equals(ioVar.f862c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ioVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f863d.equals(ioVar.f863d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f864e.equals(ioVar.f864e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f865f.equals(ioVar.f865f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ioVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f860a.equals(ioVar.f860a);
        }
        return true;
    }

    public io b(String str) {
        this.f862c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f857a);
        if (this.f859a != null && m12016a()) {
            jcVar.a(f41533a);
            jcVar.a(this.f859a);
            jcVar.b();
        }
        if (this.f858a != null && b()) {
            jcVar.a(b);
            this.f858a.b(jcVar);
            jcVar.b();
        }
        if (this.f861b != null) {
            jcVar.a(f41534c);
            jcVar.a(this.f861b);
            jcVar.b();
        }
        if (this.f862c != null) {
            jcVar.a(d);
            jcVar.a(this.f862c);
            jcVar.b();
        }
        if (this.f863d != null) {
            jcVar.a(e);
            jcVar.a(this.f863d);
            jcVar.b();
        }
        if (this.f864e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f864e);
            jcVar.b();
        }
        if (this.f865f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f865f);
            jcVar.b();
        }
        if (this.f860a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja((byte) 11, this.f860a.size()));
            for (String str : this.f860a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public boolean b() {
        return this.f858a != null;
    }

    public io c(String str) {
        this.f863d = str;
        return this;
    }

    public boolean c() {
        return this.f861b != null;
    }

    public io d(String str) {
        this.f864e = str;
        return this;
    }

    public boolean d() {
        return this.f862c != null;
    }

    public io e(String str) {
        this.f865f = str;
        return this;
    }

    public boolean e() {
        return this.f863d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m12017a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f864e != null;
    }

    public boolean g() {
        return this.f865f != null;
    }

    public boolean h() {
        return this.f860a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        if (m12016a()) {
            sb.append("debug:");
            String str = this.f859a;
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
            hv hvVar = this.f858a;
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
        String str2 = this.f861b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f862c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f863d;
        if (str4 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f864e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f865f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f860a;
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
