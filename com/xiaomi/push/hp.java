package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hp.class */
public class hp implements ir<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f531a;

    /* renamed from: a  reason: collision with other field name */
    public hm f532a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f533a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f534a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f530a = new jh("NormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27794a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 15, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27795c = new iz("", (byte) 8, 3);

    public int a() {
        return this.f531a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m8824a()).compareTo(Boolean.valueOf(hpVar.m8824a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8824a() || (a4 = is.a(this.f531a, hpVar.f531a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hpVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = is.a(this.f534a, hpVar.f534a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hpVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = is.a(this.f532a, hpVar.f532a)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return a4;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public hm m8822a() {
        return this.f532a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8823a() {
        if (this.f534a != null) {
            return;
        }
        throw new jd("Required field 'configItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                break;
            }
            short s = mo8982a.f840a;
            if (s == 1) {
                if (mo8982a.f27852a == 8) {
                    this.f531a = jcVar.mo8980a();
                    a(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else if (s != 2) {
                if (s == 3 && mo8982a.f27852a == 8) {
                    this.f532a = hm.a(jcVar.mo8980a());
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else {
                if (mo8982a.f27852a == 15) {
                    ja mo8983a = jcVar.mo8983a();
                    this.f534a = new ArrayList(mo8983a.f842a);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= mo8983a.f842a) {
                            break;
                        }
                        hr hrVar = new hr();
                        hrVar.a(jcVar);
                        this.f534a.add(hrVar);
                        i = i2 + 1;
                    }
                    jcVar.i();
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            }
        }
        jcVar.f();
        if (m8824a()) {
            m8823a();
            return;
        }
        throw new jd("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f533a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8824a() {
        return this.f533a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8825a(hp hpVar) {
        if (hpVar != null && this.f531a == hpVar.f531a) {
            boolean b2 = b();
            boolean b3 = hpVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f534a.equals(hpVar.f534a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hpVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f532a.equals(hpVar.f532a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8823a();
        jcVar.a(f530a);
        jcVar.a(f27794a);
        jcVar.mo8991a(this.f531a);
        jcVar.b();
        if (this.f534a != null) {
            jcVar.a(b);
            jcVar.a(new ja((byte) 12, this.f534a.size()));
            for (hr hrVar : this.f534a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f532a != null && c()) {
            jcVar.a(f27795c);
            jcVar.mo8991a(this.f532a.a());
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public boolean b() {
        return this.f534a != null;
    }

    public boolean c() {
        return this.f532a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m8825a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f531a);
        sb.append(", ");
        sb.append("configItems:");
        List<hr> list = this.f534a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            hm hmVar = this.f532a;
            if (hmVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(hmVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
