package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hj.class */
public class hj implements ir<hj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hk> f552a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f551a = new jh("ClientUploadData");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41474a = new iz("", (byte) 15, 1);

    public int a() {
        List<hk> list = this.f552a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hj hjVar) {
        int a2;
        if (getClass().equals(hjVar.getClass())) {
            int compareTo = Boolean.valueOf(m11851a()).compareTo(Boolean.valueOf(hjVar.m11851a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11851a() || (a2 = is.a(this.f552a, hjVar.f552a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(hjVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11850a() {
        if (this.f552a != null) {
            return;
        }
        throw new jd("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    public void a(hk hkVar) {
        if (this.f552a == null) {
            this.f552a = new ArrayList();
        }
        this.f552a.add(hkVar);
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                m11850a();
                return;
            }
            if (mo12032a.f887a == 1 && mo12032a.f41543a == 15) {
                ja mo12033a = jcVar.mo12033a();
                this.f552a = new ArrayList(mo12033a.f889a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= mo12033a.f889a) {
                        break;
                    }
                    hk hkVar = new hk();
                    hkVar.a(jcVar);
                    this.f552a.add(hkVar);
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
    public boolean m11851a() {
        return this.f552a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11852a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m11851a = m11851a();
        boolean m11851a2 = hjVar.m11851a();
        if (m11851a || m11851a2) {
            return m11851a && m11851a2 && this.f552a.equals(hjVar.f552a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11850a();
        jcVar.a(f551a);
        if (this.f552a != null) {
            jcVar.a(f41474a);
            jcVar.a(new ja((byte) 12, this.f552a.size()));
            for (hk hkVar : this.f552a) {
                hkVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m11852a((hj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<hk> list = this.f552a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
