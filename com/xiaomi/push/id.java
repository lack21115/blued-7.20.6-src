package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/id.class */
public class id implements ir<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f716a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f715a = new jh("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41513a = new iz("", (byte) 15, 1);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
        int a2;
        if (getClass().equals(idVar.getClass())) {
            int compareTo = Boolean.valueOf(m11956a()).compareTo(Boolean.valueOf(idVar.m11956a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11956a() || (a2 = is.a(this.f716a, idVar.f716a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(idVar.getClass().getName());
    }

    public List<hr> a() {
        return this.f716a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11955a() {
        if (this.f716a != null) {
            return;
        }
        throw new jd("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                m11955a();
                return;
            }
            if (mo12032a.f887a == 1 && mo12032a.f41543a == 15) {
                ja mo12033a = jcVar.mo12033a();
                this.f716a = new ArrayList(mo12033a.f889a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= mo12033a.f889a) {
                        break;
                    }
                    hr hrVar = new hr();
                    hrVar.a(jcVar);
                    this.f716a.add(hrVar);
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
    public boolean m11956a() {
        return this.f716a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11957a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m11956a = m11956a();
        boolean m11956a2 = idVar.m11956a();
        if (m11956a || m11956a2) {
            return m11956a && m11956a2 && this.f716a.equals(idVar.f716a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11955a();
        jcVar.a(f715a);
        if (this.f716a != null) {
            jcVar.a(f41513a);
            jcVar.a(new ja((byte) 12, this.f716a.size()));
            for (hr hrVar : this.f716a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m11957a((id) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<hr> list = this.f716a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
