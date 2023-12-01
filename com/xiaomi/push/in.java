package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/in.class */
public class in implements ir<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f847a;

    /* renamed from: a  reason: collision with other field name */
    public hv f848a;

    /* renamed from: a  reason: collision with other field name */
    public String f849a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f850a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f851b;

    /* renamed from: b  reason: collision with other field name */
    public String f852b;

    /* renamed from: c  reason: collision with other field name */
    public long f853c;

    /* renamed from: c  reason: collision with other field name */
    public String f854c;

    /* renamed from: d  reason: collision with other field name */
    public String f855d;

    /* renamed from: e  reason: collision with other field name */
    public String f856e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f846a = new jh("XmPushActionUnRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41531a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41532c = new iz("", (byte) 11, 3);
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
            int compareTo = Boolean.valueOf(m12013a()).compareTo(Boolean.valueOf(inVar.m12013a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m12013a() || (a10 = is.a(this.f849a, inVar.f849a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(inVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a9 = is.a(this.f848a, inVar.f848a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a8 = is.a(this.f852b, inVar.f852b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = is.a(this.f854c, inVar.f854c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = is.a(this.f847a, inVar.f847a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = is.a(this.f855d, inVar.f855d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = is.a(this.f856e, inVar.f856e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = is.a(this.f851b, inVar.f851b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = is.a(this.f853c, inVar.f853c)) == 0) {
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
        return this.f856e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m12012a() {
        if (this.f852b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f854c != null) {
        } else {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                if (e()) {
                    m12012a();
                    return;
                }
                throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f849a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f848a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f852b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f854c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 10) {
                        this.f847a = jcVar.mo12031a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f855d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 11) {
                        this.f856e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 10) {
                        this.f851b = jcVar.mo12031a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 10) {
                        this.f853c = jcVar.mo12031a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
            }
            jf.a(jcVar, mo12032a.f41543a);
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f850a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12013a() {
        return this.f849a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12014a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m12013a = m12013a();
        boolean m12013a2 = inVar.m12013a();
        if ((m12013a || m12013a2) && !(m12013a && m12013a2 && this.f849a.equals(inVar.f849a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = inVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f848a.m11909a(inVar.f848a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f852b.equals(inVar.f852b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f854c.equals(inVar.f854c))) || this.f847a != inVar.f847a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f855d.equals(inVar.f855d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f856e.equals(inVar.f856e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f851b == inVar.f851b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f853c == inVar.f853c;
        }
        return true;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m12012a();
        jcVar.a(f846a);
        if (this.f849a != null && m12013a()) {
            jcVar.a(f41531a);
            jcVar.a(this.f849a);
            jcVar.b();
        }
        if (this.f848a != null && b()) {
            jcVar.a(b);
            this.f848a.b(jcVar);
            jcVar.b();
        }
        if (this.f852b != null) {
            jcVar.a(f41532c);
            jcVar.a(this.f852b);
            jcVar.b();
        }
        if (this.f854c != null) {
            jcVar.a(d);
            jcVar.a(this.f854c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f847a);
        jcVar.b();
        if (this.f855d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f855d);
            jcVar.b();
        }
        if (this.f856e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f856e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f851b);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f853c);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f850a.set(1, z);
    }

    public boolean b() {
        return this.f848a != null;
    }

    public void c(boolean z) {
        this.f850a.set(2, z);
    }

    public boolean c() {
        return this.f852b != null;
    }

    public boolean d() {
        return this.f854c != null;
    }

    public boolean e() {
        return this.f850a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m12014a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f855d != null;
    }

    public boolean g() {
        return this.f856e != null;
    }

    public boolean h() {
        return this.f850a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f850a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        if (m12013a()) {
            sb.append("debug:");
            String str = this.f849a;
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
            hv hvVar = this.f848a;
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
        String str2 = this.f852b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f854c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f847a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f855d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f856e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f851b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f853c);
        }
        sb.append(")");
        return sb.toString();
    }
}
