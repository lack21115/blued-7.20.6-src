package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ey.class */
public class ey implements ir<ey, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f415a;

    /* renamed from: a  reason: collision with other field name */
    public int f416a;

    /* renamed from: a  reason: collision with other field name */
    public String f417a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f418a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f419b;

    /* renamed from: b  reason: collision with other field name */
    public String f420b;

    /* renamed from: c  reason: collision with other field name */
    public int f421c;

    /* renamed from: c  reason: collision with other field name */
    public String f422c;

    /* renamed from: d  reason: collision with other field name */
    public int f423d;

    /* renamed from: d  reason: collision with other field name */
    public String f424d;

    /* renamed from: e  reason: collision with other field name */
    public int f425e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f414a = new jh("StatsEvent");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41391a = new iz("", (byte) 3, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41392c = new iz("", (byte) 8, 3);
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
            int compareTo = Boolean.valueOf(m11737a()).compareTo(Boolean.valueOf(eyVar.m11737a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11737a() || (a11 = is.a(this.f415a, eyVar.f415a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(eyVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = is.a(this.f416a, eyVar.f416a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(eyVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = is.a(this.f419b, eyVar.f419b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(eyVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = is.a(this.f417a, eyVar.f417a)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(eyVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = is.a(this.f420b, eyVar.f420b)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(eyVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = is.a(this.f421c, eyVar.f421c)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(eyVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = is.a(this.f422c, eyVar.f422c)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(eyVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = is.a(this.f424d, eyVar.f424d)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(eyVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = is.a(this.f423d, eyVar.f423d)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(eyVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = is.a(this.f425e, eyVar.f425e)) == 0) {
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
        this.f415a = b2;
        a(true);
        return this;
    }

    public ey a(int i2) {
        this.f416a = i2;
        b(true);
        return this;
    }

    public ey a(String str) {
        this.f417a = str;
        return this;
    }

    public void a() {
        if (this.f417a != null) {
            return;
        }
        throw new jd("Required field 'connpt' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                if (!m11737a()) {
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
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 3) {
                        this.f415a = jcVar.a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 8) {
                        this.f416a = jcVar.mo12030a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 8) {
                        this.f419b = jcVar.mo12030a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f417a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f420b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 8) {
                        this.f421c = jcVar.mo12030a();
                        d(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f422c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 11) {
                        this.f424d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 8) {
                        this.f423d = jcVar.mo12030a();
                        e(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 8) {
                        this.f425e = jcVar.mo12030a();
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
        this.f418a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11737a() {
        return this.f418a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11738a(ey eyVar) {
        if (eyVar != null && this.f415a == eyVar.f415a && this.f416a == eyVar.f416a && this.f419b == eyVar.f419b) {
            boolean d2 = d();
            boolean d3 = eyVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f417a.equals(eyVar.f417a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = eyVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f420b.equals(eyVar.f420b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = eyVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f421c == eyVar.f421c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = eyVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f422c.equals(eyVar.f422c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = eyVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f424d.equals(eyVar.f424d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = eyVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f423d == eyVar.f423d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = eyVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f425e == eyVar.f425e;
            }
            return true;
        }
        return false;
    }

    public ey b(int i2) {
        this.f419b = i2;
        c(true);
        return this;
    }

    public ey b(String str) {
        this.f420b = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f414a);
        jcVar.a(f41391a);
        jcVar.a(this.f415a);
        jcVar.b();
        jcVar.a(b);
        jcVar.mo12041a(this.f416a);
        jcVar.b();
        jcVar.a(f41392c);
        jcVar.mo12041a(this.f419b);
        jcVar.b();
        if (this.f417a != null) {
            jcVar.a(d);
            jcVar.a(this.f417a);
            jcVar.b();
        }
        if (this.f420b != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f420b);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.mo12041a(this.f421c);
            jcVar.b();
        }
        if (this.f422c != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f422c);
            jcVar.b();
        }
        if (this.f424d != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f424d);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.mo12041a(this.f423d);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.mo12041a(this.f425e);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f418a.set(1, z);
    }

    public boolean b() {
        return this.f418a.get(1);
    }

    public ey c(int i2) {
        this.f421c = i2;
        d(true);
        return this;
    }

    public ey c(String str) {
        this.f422c = str;
        return this;
    }

    public void c(boolean z) {
        this.f418a.set(2, z);
    }

    public boolean c() {
        return this.f418a.get(2);
    }

    public ey d(int i2) {
        this.f423d = i2;
        e(true);
        return this;
    }

    public ey d(String str) {
        this.f424d = str;
        return this;
    }

    public void d(boolean z) {
        this.f418a.set(3, z);
    }

    public boolean d() {
        return this.f417a != null;
    }

    public void e(boolean z) {
        this.f418a.set(4, z);
    }

    public boolean e() {
        return this.f420b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ey)) {
            return m11738a((ey) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f418a.set(5, z);
    }

    public boolean f() {
        return this.f418a.get(3);
    }

    public boolean g() {
        return this.f422c != null;
    }

    public boolean h() {
        return this.f424d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f418a.get(4);
    }

    public boolean j() {
        return this.f418a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f415a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f416a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f419b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f417a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f420b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f421c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f422c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f424d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f423d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f425e);
        }
        sb.append(")");
        return sb.toString();
    }
}
