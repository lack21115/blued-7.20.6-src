package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hz.class */
public class hz implements ir<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<ho> f630a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f629a = new jh("XmPushActionCollectData");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27813a = new iz("", (byte) 15, 1);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
        int a2;
        if (getClass().equals(hzVar.getClass())) {
            int compareTo = Boolean.valueOf(m8873a()).compareTo(Boolean.valueOf(hzVar.m8873a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8873a() || (a2 = is.a(this.f630a, hzVar.f630a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(hzVar.getClass().getName());
    }

    public hz a(List<ho> list) {
        this.f630a = list;
        return this;
    }

    public void a() {
        if (this.f630a != null) {
            return;
        }
        throw new jd("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                a();
                return;
            }
            if (mo8982a.f840a == 1 && mo8982a.f27852a == 15) {
                ja mo8983a = jcVar.mo8983a();
                this.f630a = new ArrayList(mo8983a.f842a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= mo8983a.f842a) {
                        break;
                    }
                    ho hoVar = new ho();
                    hoVar.a(jcVar);
                    this.f630a.add(hoVar);
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
    public boolean m8873a() {
        return this.f630a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8874a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m8873a = m8873a();
        boolean m8873a2 = hzVar.m8873a();
        if (m8873a || m8873a2) {
            return m8873a && m8873a2 && this.f630a.equals(hzVar.f630a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f629a);
        if (this.f630a != null) {
            jcVar.a(f27813a);
            jcVar.a(new ja((byte) 12, this.f630a.size()));
            for (ho hoVar : this.f630a) {
                hoVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m8874a((hz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<ho> list = this.f630a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
