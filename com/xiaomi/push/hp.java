package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hp.class */
public class hp implements ir<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f578a;

    /* renamed from: a  reason: collision with other field name */
    public hm f579a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f580a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f581a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f577a = new jh("NormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41485a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 15, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41486c = new iz("", (byte) 8, 3);

    public int a() {
        return this.f578a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m11874a()).compareTo(Boolean.valueOf(hpVar.m11874a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11874a() || (a4 = is.a(this.f578a, hpVar.f578a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hpVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = is.a(this.f581a, hpVar.f581a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hpVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = is.a(this.f579a, hpVar.f579a)) == 0) {
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
    public hm m11872a() {
        return this.f579a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11873a() {
        if (this.f581a != null) {
            return;
        }
        throw new jd("Required field 'configItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                break;
            }
            short s = mo12032a.f887a;
            if (s == 1) {
                if (mo12032a.f41543a == 8) {
                    this.f578a = jcVar.mo12030a();
                    a(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else if (s != 2) {
                if (s == 3 && mo12032a.f41543a == 8) {
                    this.f579a = hm.a(jcVar.mo12030a());
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else {
                if (mo12032a.f41543a == 15) {
                    ja mo12033a = jcVar.mo12033a();
                    this.f581a = new ArrayList(mo12033a.f889a);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= mo12033a.f889a) {
                            break;
                        }
                        hr hrVar = new hr();
                        hrVar.a(jcVar);
                        this.f581a.add(hrVar);
                        i = i2 + 1;
                    }
                    jcVar.i();
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            }
        }
        jcVar.f();
        if (m11874a()) {
            m11873a();
            return;
        }
        throw new jd("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f580a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11874a() {
        return this.f580a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11875a(hp hpVar) {
        if (hpVar != null && this.f578a == hpVar.f578a) {
            boolean b2 = b();
            boolean b3 = hpVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f581a.equals(hpVar.f581a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hpVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f579a.equals(hpVar.f579a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11873a();
        jcVar.a(f577a);
        jcVar.a(f41485a);
        jcVar.mo12041a(this.f578a);
        jcVar.b();
        if (this.f581a != null) {
            jcVar.a(b);
            jcVar.a(new ja((byte) 12, this.f581a.size()));
            for (hr hrVar : this.f581a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f579a != null && c()) {
            jcVar.a(f41486c);
            jcVar.mo12041a(this.f579a.a());
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public boolean b() {
        return this.f581a != null;
    }

    public boolean c() {
        return this.f579a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m11875a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f578a);
        sb.append(", ");
        sb.append("configItems:");
        List<hr> list = this.f581a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            hm hmVar = this.f579a;
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
