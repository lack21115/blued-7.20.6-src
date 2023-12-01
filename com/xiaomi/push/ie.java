package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ie.class */
public class ie implements ir<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hp> f671a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f670a = new jh("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27823a = new iz("", (byte) 15, 1);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m8910a()).compareTo(Boolean.valueOf(ieVar.m8910a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8910a() || (a2 = is.a(this.f671a, ieVar.f671a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(ieVar.getClass().getName());
    }

    public List<hp> a() {
        return this.f671a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8909a() {
        if (this.f671a != null) {
            return;
        }
        throw new jd("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                m8909a();
                return;
            }
            if (mo8982a.f840a == 1 && mo8982a.f27852a == 15) {
                ja mo8983a = jcVar.mo8983a();
                this.f671a = new ArrayList(mo8983a.f842a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= mo8983a.f842a) {
                        break;
                    }
                    hp hpVar = new hp();
                    hpVar.a(jcVar);
                    this.f671a.add(hpVar);
                    i = i2 + 1;
                }
                jcVar.i();
            } else {
                jf.a(jcVar, mo8982a.f27852a);
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8910a() {
        return this.f671a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8911a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m8910a = m8910a();
        boolean m8910a2 = ieVar.m8910a();
        if (m8910a || m8910a2) {
            return m8910a && m8910a2 && this.f671a.equals(ieVar.f671a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8909a();
        jcVar.a(f670a);
        if (this.f671a != null) {
            jcVar.a(f27823a);
            jcVar.a(new ja((byte) 12, this.f671a.size()));
            for (hp hpVar : this.f671a) {
                hpVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m8911a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<hp> list = this.f671a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
