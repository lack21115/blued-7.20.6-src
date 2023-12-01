package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hj.class */
public class hj implements ir<hj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hk> f505a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f504a = new jh("ClientUploadData");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27783a = new iz("", (byte) 15, 1);

    public int a() {
        List<hk> list = this.f505a;
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
            int compareTo = Boolean.valueOf(m8801a()).compareTo(Boolean.valueOf(hjVar.m8801a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8801a() || (a2 = is.a(this.f505a, hjVar.f505a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(hjVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8800a() {
        if (this.f505a != null) {
            return;
        }
        throw new jd("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    public void a(hk hkVar) {
        if (this.f505a == null) {
            this.f505a = new ArrayList();
        }
        this.f505a.add(hkVar);
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                m8800a();
                return;
            }
            if (mo8982a.f840a == 1 && mo8982a.f27852a == 15) {
                ja mo8983a = jcVar.mo8983a();
                this.f505a = new ArrayList(mo8983a.f842a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= mo8983a.f842a) {
                        break;
                    }
                    hk hkVar = new hk();
                    hkVar.a(jcVar);
                    this.f505a.add(hkVar);
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
    public boolean m8801a() {
        return this.f505a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8802a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m8801a = m8801a();
        boolean m8801a2 = hjVar.m8801a();
        if (m8801a || m8801a2) {
            return m8801a && m8801a2 && this.f505a.equals(hjVar.f505a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8800a();
        jcVar.a(f504a);
        if (this.f505a != null) {
            jcVar.a(f27783a);
            jcVar.a(new ja((byte) 12, this.f505a.size()));
            for (hk hkVar : this.f505a) {
                hkVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m8802a((hj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<hk> list = this.f505a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
