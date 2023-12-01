package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/in.class */
public class in implements ir<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f800a;

    /* renamed from: a  reason: collision with other field name */
    public hv f801a;

    /* renamed from: a  reason: collision with other field name */
    public String f802a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f803a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f804b;

    /* renamed from: b  reason: collision with other field name */
    public String f805b;

    /* renamed from: c  reason: collision with other field name */
    public long f806c;

    /* renamed from: c  reason: collision with other field name */
    public String f807c;

    /* renamed from: d  reason: collision with other field name */
    public String f808d;

    /* renamed from: e  reason: collision with other field name */
    public String f809e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f799a = new jh("XmPushActionUnRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27840a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27841c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 10, 6);
    private static final iz f = new iz("", (byte) 11, 7);
    private static final iz g = new iz("", (byte) 11, 8);
    private static final iz h = new iz("", (byte) 10, 9);
    private static final iz i = new iz("", (byte) 10, 10);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(in inVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(inVar.getClass())) {
            int compareTo = Boolean.valueOf(m8963a()).compareTo(Boolean.valueOf(inVar.m8963a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8963a() || (a10 = is.a(this.f802a, inVar.f802a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(inVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a9 = is.a(this.f801a, inVar.f801a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a8 = is.a(this.f805b, inVar.f805b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = is.a(this.f807c, inVar.f807c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = is.a(this.f800a, inVar.f800a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = is.a(this.f808d, inVar.f808d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = is.a(this.f809e, inVar.f809e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = is.a(this.f804b, inVar.f804b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = is.a(this.f806c, inVar.f806c)) == 0) {
                                                return 0;
                                            }
                                            return a2;
                                        }
                                        return a3;
                                    }
                                    return a4;
                                }
                                return a5;
                            }
                            return a6;
                        }
                        return a7;
                    }
                    return a8;
                }
                return a9;
            }
            return a10;
        }
        return getClass().getName().compareTo(inVar.getClass().getName());
    }

    public String a() {
        return this.f809e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8962a() {
        if (this.f805b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f807c != null) {
        } else {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                if (e()) {
                    m8962a();
                    return;
                }
                throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f802a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f801a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f805b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f807c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 10) {
                        this.f800a = jcVar.mo8981a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f808d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 11) {
                        this.f809e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 10) {
                        this.f804b = jcVar.mo8981a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 10) {
                        this.f806c = jcVar.mo8981a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
            }
            jf.a(jcVar, mo8982a.f27852a);
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f803a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8963a() {
        return this.f802a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8964a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m8963a = m8963a();
        boolean m8963a2 = inVar.m8963a();
        if ((m8963a || m8963a2) && !(m8963a && m8963a2 && this.f802a.equals(inVar.f802a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = inVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f801a.m8859a(inVar.f801a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f805b.equals(inVar.f805b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f807c.equals(inVar.f807c))) || this.f800a != inVar.f800a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f808d.equals(inVar.f808d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f809e.equals(inVar.f809e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f804b == inVar.f804b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f806c == inVar.f806c;
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8962a();
        jcVar.a(f799a);
        if (this.f802a != null && m8963a()) {
            jcVar.a(f27840a);
            jcVar.a(this.f802a);
            jcVar.b();
        }
        if (this.f801a != null && b()) {
            jcVar.a(b);
            this.f801a.b(jcVar);
            jcVar.b();
        }
        if (this.f805b != null) {
            jcVar.a(f27841c);
            jcVar.a(this.f805b);
            jcVar.b();
        }
        if (this.f807c != null) {
            jcVar.a(d);
            jcVar.a(this.f807c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f800a);
        jcVar.b();
        if (this.f808d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f808d);
            jcVar.b();
        }
        if (this.f809e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f809e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f804b);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f806c);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f803a.set(1, z);
    }

    public boolean b() {
        return this.f801a != null;
    }

    public void c(boolean z) {
        this.f803a.set(2, z);
    }

    public boolean c() {
        return this.f805b != null;
    }

    public boolean d() {
        return this.f807c != null;
    }

    public boolean e() {
        return this.f803a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m8964a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f808d != null;
    }

    public boolean g() {
        return this.f809e != null;
    }

    public boolean h() {
        return this.f803a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f803a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        if (m8963a()) {
            sb.append("debug:");
            String str = this.f802a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f801a;
            if (hvVar == null) {
                sb.append(com.igexin.push.core.b.l);
                z = false;
            } else {
                sb.append(hvVar);
                z = false;
            }
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f805b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f807c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f800a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f808d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f809e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f804b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f806c);
        }
        sb.append(")");
        return sb.toString();
    }
}
