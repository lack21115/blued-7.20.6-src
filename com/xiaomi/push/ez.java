package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ez.class */
public class ez implements ir<ez, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f380a;

    /* renamed from: a  reason: collision with other field name */
    public List<ey> f381a;

    /* renamed from: b  reason: collision with other field name */
    public String f382b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f379a = new jh("StatsEvents");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27702a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27703c = new iz("", (byte) 15, 3);

    public ez() {
    }

    public ez(String str, List<ey> list) {
        this();
        this.f380a = str;
        this.f381a = list;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ez ezVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(ezVar.getClass())) {
            int compareTo = Boolean.valueOf(m8690a()).compareTo(Boolean.valueOf(ezVar.m8690a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8690a() || (a4 = is.a(this.f380a, ezVar.f380a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ezVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = is.a(this.f382b, ezVar.f382b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ezVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = is.a(this.f381a, ezVar.f381a)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return a4;
        }
        return getClass().getName().compareTo(ezVar.getClass().getName());
    }

    public ez a(String str) {
        this.f382b = str;
        return this;
    }

    public void a() {
        if (this.f380a == null) {
            throw new jd("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f381a != null) {
        } else {
            throw new jd("Required field 'events' was not present! Struct: " + toString());
        }
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
            short s = mo8982a.f840a;
            if (s == 1) {
                if (mo8982a.f27852a == 11) {
                    this.f380a = jcVar.mo8987a();
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else if (s != 2) {
                if (s == 3 && mo8982a.f27852a == 15) {
                    ja mo8983a = jcVar.mo8983a();
                    this.f381a = new ArrayList(mo8983a.f842a);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= mo8983a.f842a) {
                            break;
                        }
                        ey eyVar = new ey();
                        eyVar.a(jcVar);
                        this.f381a.add(eyVar);
                        i = i2 + 1;
                    }
                    jcVar.i();
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else {
                if (mo8982a.f27852a == 11) {
                    this.f382b = jcVar.mo8987a();
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8690a() {
        return this.f380a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8691a(ez ezVar) {
        if (ezVar == null) {
            return false;
        }
        boolean m8690a = m8690a();
        boolean m8690a2 = ezVar.m8690a();
        if ((m8690a || m8690a2) && !(m8690a && m8690a2 && this.f380a.equals(ezVar.f380a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ezVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f382b.equals(ezVar.f382b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ezVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f381a.equals(ezVar.f381a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f379a);
        if (this.f380a != null) {
            jcVar.a(f27702a);
            jcVar.a(this.f380a);
            jcVar.b();
        }
        if (this.f382b != null && b()) {
            jcVar.a(b);
            jcVar.a(this.f382b);
            jcVar.b();
        }
        if (this.f381a != null) {
            jcVar.a(f27703c);
            jcVar.a(new ja((byte) 12, this.f381a.size()));
            for (ey eyVar : this.f381a) {
                eyVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public boolean b() {
        return this.f382b != null;
    }

    public boolean c() {
        return this.f381a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ez)) {
            return m8691a((ez) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f380a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f382b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<ey> list = this.f381a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
