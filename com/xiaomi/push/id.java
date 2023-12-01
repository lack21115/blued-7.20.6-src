package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/id.class */
public class id implements ir<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f669a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f668a = new jh("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27822a = new iz("", (byte) 15, 1);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
        int a2;
        if (getClass().equals(idVar.getClass())) {
            int compareTo = Boolean.valueOf(m8906a()).compareTo(Boolean.valueOf(idVar.m8906a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8906a() || (a2 = is.a(this.f669a, idVar.f669a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(idVar.getClass().getName());
    }

    public List<hr> a() {
        return this.f669a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8905a() {
        if (this.f669a != null) {
            return;
        }
        throw new jd("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                m8905a();
                return;
            }
            if (mo8982a.f840a == 1 && mo8982a.f27852a == 15) {
                ja mo8983a = jcVar.mo8983a();
                this.f669a = new ArrayList(mo8983a.f842a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= mo8983a.f842a) {
                        break;
                    }
                    hr hrVar = new hr();
                    hrVar.a(jcVar);
                    this.f669a.add(hrVar);
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
    public boolean m8906a() {
        return this.f669a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8907a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m8906a = m8906a();
        boolean m8906a2 = idVar.m8906a();
        if (m8906a || m8906a2) {
            return m8906a && m8906a2 && this.f669a.equals(idVar.f669a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8905a();
        jcVar.a(f668a);
        if (this.f669a != null) {
            jcVar.a(f27822a);
            jcVar.a(new ja((byte) 12, this.f669a.size()));
            for (hr hrVar : this.f669a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m8907a((id) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<hr> list = this.f669a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
