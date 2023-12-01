package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ie.class */
public class ie implements ir<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hp> f718a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f717a = new jh("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41514a = new iz("", (byte) 15, 1);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m11960a()).compareTo(Boolean.valueOf(ieVar.m11960a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11960a() || (a2 = is.a(this.f718a, ieVar.f718a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(ieVar.getClass().getName());
    }

    public List<hp> a() {
        return this.f718a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11959a() {
        if (this.f718a != null) {
            return;
        }
        throw new jd("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                m11959a();
                return;
            }
            if (mo12032a.f887a == 1 && mo12032a.f41543a == 15) {
                ja mo12033a = jcVar.mo12033a();
                this.f718a = new ArrayList(mo12033a.f889a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= mo12033a.f889a) {
                        break;
                    }
                    hp hpVar = new hp();
                    hpVar.a(jcVar);
                    this.f718a.add(hpVar);
                    i = i2 + 1;
                }
                jcVar.i();
            } else {
                jf.a(jcVar, mo12032a.f41543a);
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11960a() {
        return this.f718a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11961a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m11960a = m11960a();
        boolean m11960a2 = ieVar.m11960a();
        if (m11960a || m11960a2) {
            return m11960a && m11960a2 && this.f718a.equals(ieVar.f718a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11959a();
        jcVar.a(f717a);
        if (this.f718a != null) {
            jcVar.a(f41514a);
            jcVar.a(new ja((byte) 12, this.f718a.size()));
            for (hp hpVar : this.f718a) {
                hpVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m11961a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<hp> list = this.f718a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
