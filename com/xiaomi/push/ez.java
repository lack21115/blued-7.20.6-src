package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ez.class */
public class ez implements ir<ez, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f427a;

    /* renamed from: a  reason: collision with other field name */
    public List<ey> f428a;

    /* renamed from: b  reason: collision with other field name */
    public String f429b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f426a = new jh("StatsEvents");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41393a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41394c = new iz("", (byte) 15, 3);

    public ez() {
    }

    public ez(String str, List<ey> list) {
        this();
        this.f427a = str;
        this.f428a = list;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ez ezVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(ezVar.getClass())) {
            int compareTo = Boolean.valueOf(m11740a()).compareTo(Boolean.valueOf(ezVar.m11740a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11740a() || (a4 = is.a(this.f427a, ezVar.f427a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ezVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = is.a(this.f429b, ezVar.f429b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ezVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = is.a(this.f428a, ezVar.f428a)) == 0) {
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
        this.f429b = str;
        return this;
    }

    public void a() {
        if (this.f427a == null) {
            throw new jd("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f428a != null) {
        } else {
            throw new jd("Required field 'events' was not present! Struct: " + toString());
        }
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
            short s = mo12032a.f887a;
            if (s == 1) {
                if (mo12032a.f41543a == 11) {
                    this.f427a = jcVar.mo12037a();
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else if (s != 2) {
                if (s == 3 && mo12032a.f41543a == 15) {
                    ja mo12033a = jcVar.mo12033a();
                    this.f428a = new ArrayList(mo12033a.f889a);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= mo12033a.f889a) {
                            break;
                        }
                        ey eyVar = new ey();
                        eyVar.a(jcVar);
                        this.f428a.add(eyVar);
                        i = i2 + 1;
                    }
                    jcVar.i();
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else {
                if (mo12032a.f41543a == 11) {
                    this.f429b = jcVar.mo12037a();
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11740a() {
        return this.f427a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11741a(ez ezVar) {
        if (ezVar == null) {
            return false;
        }
        boolean m11740a = m11740a();
        boolean m11740a2 = ezVar.m11740a();
        if ((m11740a || m11740a2) && !(m11740a && m11740a2 && this.f427a.equals(ezVar.f427a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ezVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f429b.equals(ezVar.f429b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ezVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f428a.equals(ezVar.f428a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f426a);
        if (this.f427a != null) {
            jcVar.a(f41393a);
            jcVar.a(this.f427a);
            jcVar.b();
        }
        if (this.f429b != null && b()) {
            jcVar.a(b);
            jcVar.a(this.f429b);
            jcVar.b();
        }
        if (this.f428a != null) {
            jcVar.a(f41394c);
            jcVar.a(new ja((byte) 12, this.f428a.size()));
            for (ey eyVar : this.f428a) {
                eyVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public boolean b() {
        return this.f429b != null;
    }

    public boolean c() {
        return this.f428a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ez)) {
            return m11741a((ez) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f427a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f429b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<ey> list = this.f428a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
