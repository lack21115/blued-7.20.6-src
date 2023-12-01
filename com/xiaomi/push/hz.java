package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hz.class */
public class hz implements ir<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<ho> f677a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f676a = new jh("XmPushActionCollectData");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41504a = new iz("", (byte) 15, 1);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
        int a2;
        if (getClass().equals(hzVar.getClass())) {
            int compareTo = Boolean.valueOf(m11923a()).compareTo(Boolean.valueOf(hzVar.m11923a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11923a() || (a2 = is.a(this.f677a, hzVar.f677a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(hzVar.getClass().getName());
    }

    public hz a(List<ho> list) {
        this.f677a = list;
        return this;
    }

    public void a() {
        if (this.f677a != null) {
            return;
        }
        throw new jd("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                a();
                return;
            }
            if (mo12032a.f887a == 1 && mo12032a.f41543a == 15) {
                ja mo12033a = jcVar.mo12033a();
                this.f677a = new ArrayList(mo12033a.f889a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= mo12033a.f889a) {
                        break;
                    }
                    ho hoVar = new ho();
                    hoVar.a(jcVar);
                    this.f677a.add(hoVar);
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
    public boolean m11923a() {
        return this.f677a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11924a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m11923a = m11923a();
        boolean m11923a2 = hzVar.m11923a();
        if (m11923a || m11923a2) {
            return m11923a && m11923a2 && this.f677a.equals(hzVar.f677a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f676a);
        if (this.f677a != null) {
            jcVar.a(f41504a);
            jcVar.a(new ja((byte) 12, this.f677a.size()));
            for (ho hoVar : this.f677a) {
                hoVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m11924a((hz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<ho> list = this.f677a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
