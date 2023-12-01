package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ey.class */
public class ey implements ir<ey, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f368a;

    /* renamed from: a  reason: collision with other field name */
    public int f369a;

    /* renamed from: a  reason: collision with other field name */
    public String f370a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f371a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f372b;

    /* renamed from: b  reason: collision with other field name */
    public String f373b;

    /* renamed from: c  reason: collision with other field name */
    public int f374c;

    /* renamed from: c  reason: collision with other field name */
    public String f375c;

    /* renamed from: d  reason: collision with other field name */
    public int f376d;

    /* renamed from: d  reason: collision with other field name */
    public String f377d;

    /* renamed from: e  reason: collision with other field name */
    public int f378e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f367a = new jh("StatsEvent");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27700a = new iz("", (byte) 3, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27701c = new iz("", (byte) 8, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 8, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 11, 8);
    private static final iz i = new iz("", (byte) 8, 9);
    private static final iz j = new iz("", (byte) 8, 10);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ey eyVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        if (getClass().equals(eyVar.getClass())) {
            int compareTo = Boolean.valueOf(m8687a()).compareTo(Boolean.valueOf(eyVar.m8687a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8687a() || (a11 = is.a(this.f368a, eyVar.f368a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(eyVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = is.a(this.f369a, eyVar.f369a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(eyVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = is.a(this.f372b, eyVar.f372b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(eyVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = is.a(this.f370a, eyVar.f370a)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(eyVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = is.a(this.f373b, eyVar.f373b)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(eyVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = is.a(this.f374c, eyVar.f374c)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(eyVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = is.a(this.f375c, eyVar.f375c)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(eyVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = is.a(this.f377d, eyVar.f377d)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(eyVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = is.a(this.f376d, eyVar.f376d)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(eyVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = is.a(this.f378e, eyVar.f378e)) == 0) {
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
            return a11;
        }
        return getClass().getName().compareTo(eyVar.getClass().getName());
    }

    public ey a(byte b2) {
        this.f368a = b2;
        a(true);
        return this;
    }

    public ey a(int i2) {
        this.f369a = i2;
        b(true);
        return this;
    }

    public ey a(String str) {
        this.f370a = str;
        return this;
    }

    public void a() {
        if (this.f370a != null) {
            return;
        }
        throw new jd("Required field 'connpt' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                if (!m8687a()) {
                    throw new jd("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!b()) {
                    throw new jd("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (c()) {
                    a();
                    return;
                } else {
                    throw new jd("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 3) {
                        this.f368a = jcVar.a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 8) {
                        this.f369a = jcVar.mo8980a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 8) {
                        this.f372b = jcVar.mo8980a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f370a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 11) {
                        this.f373b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 8) {
                        this.f374c = jcVar.mo8980a();
                        d(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f375c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 11) {
                        this.f377d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 8) {
                        this.f376d = jcVar.mo8980a();
                        e(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 8) {
                        this.f378e = jcVar.mo8980a();
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
        this.f371a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8687a() {
        return this.f371a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8688a(ey eyVar) {
        if (eyVar != null && this.f368a == eyVar.f368a && this.f369a == eyVar.f369a && this.f372b == eyVar.f372b) {
            boolean d2 = d();
            boolean d3 = eyVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f370a.equals(eyVar.f370a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = eyVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f373b.equals(eyVar.f373b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = eyVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f374c == eyVar.f374c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = eyVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f375c.equals(eyVar.f375c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = eyVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f377d.equals(eyVar.f377d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = eyVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f376d == eyVar.f376d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = eyVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f378e == eyVar.f378e;
            }
            return true;
        }
        return false;
    }

    public ey b(int i2) {
        this.f372b = i2;
        c(true);
        return this;
    }

    public ey b(String str) {
        this.f373b = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f367a);
        jcVar.a(f27700a);
        jcVar.a(this.f368a);
        jcVar.b();
        jcVar.a(b);
        jcVar.mo8991a(this.f369a);
        jcVar.b();
        jcVar.a(f27701c);
        jcVar.mo8991a(this.f372b);
        jcVar.b();
        if (this.f370a != null) {
            jcVar.a(d);
            jcVar.a(this.f370a);
            jcVar.b();
        }
        if (this.f373b != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f373b);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.mo8991a(this.f374c);
            jcVar.b();
        }
        if (this.f375c != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f375c);
            jcVar.b();
        }
        if (this.f377d != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f377d);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.mo8991a(this.f376d);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.mo8991a(this.f378e);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f371a.set(1, z);
    }

    public boolean b() {
        return this.f371a.get(1);
    }

    public ey c(int i2) {
        this.f374c = i2;
        d(true);
        return this;
    }

    public ey c(String str) {
        this.f375c = str;
        return this;
    }

    public void c(boolean z) {
        this.f371a.set(2, z);
    }

    public boolean c() {
        return this.f371a.get(2);
    }

    public ey d(int i2) {
        this.f376d = i2;
        e(true);
        return this;
    }

    public ey d(String str) {
        this.f377d = str;
        return this;
    }

    public void d(boolean z) {
        this.f371a.set(3, z);
    }

    public boolean d() {
        return this.f370a != null;
    }

    public void e(boolean z) {
        this.f371a.set(4, z);
    }

    public boolean e() {
        return this.f373b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ey)) {
            return m8688a((ey) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f371a.set(5, z);
    }

    public boolean f() {
        return this.f371a.get(3);
    }

    public boolean g() {
        return this.f375c != null;
    }

    public boolean h() {
        return this.f377d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f371a.get(4);
    }

    public boolean j() {
        return this.f371a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f368a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f369a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f372b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f370a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f373b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f374c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f375c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f377d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f376d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f378e);
        }
        sb.append(")");
        return sb.toString();
    }
}
