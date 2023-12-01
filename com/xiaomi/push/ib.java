package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ib.class */
public class ib implements ir<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f694a;

    /* renamed from: a  reason: collision with other field name */
    public hv f695a;

    /* renamed from: a  reason: collision with other field name */
    public String f696a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f698a;

    /* renamed from: b  reason: collision with other field name */
    public String f700b;

    /* renamed from: c  reason: collision with other field name */
    public String f701c;

    /* renamed from: d  reason: collision with other field name */
    public String f702d;

    /* renamed from: e  reason: collision with other field name */
    public String f703e;

    /* renamed from: f  reason: collision with other field name */
    public String f704f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f693a = new jh("XmPushActionCommandResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41509a = new iz("", (byte) 12, 2);
    private static final iz b = new iz("", (byte) 11, 3);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41510c = new iz("", (byte) 11, 4);
    private static final iz d = new iz("", (byte) 11, 5);
    private static final iz e = new iz("", (byte) 10, 7);
    private static final iz f = new iz("", (byte) 11, 8);
    private static final iz g = new iz("", (byte) 11, 9);
    private static final iz h = new iz("", (byte) 15, 10);
    private static final iz i = new iz("", (byte) 11, 12);
    private static final iz j = new iz("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f697a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f699a = true;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ib ibVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        if (getClass().equals(ibVar.getClass())) {
            int compareTo = Boolean.valueOf(m11940a()).compareTo(Boolean.valueOf(ibVar.m11940a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11940a() || (a11 = is.a(this.f695a, ibVar.f695a)) == 0) {
                int compareTo2 = Boolean.valueOf(m11942b()).compareTo(Boolean.valueOf(ibVar.m11942b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m11942b() || (a10 = is.a(this.f696a, ibVar.f696a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m11943c()).compareTo(Boolean.valueOf(ibVar.m11943c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m11943c() || (a9 = is.a(this.f700b, ibVar.f700b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = is.a(this.f701c, ibVar.f701c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = is.a(this.f694a, ibVar.f694a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = is.a(this.f702d, ibVar.f702d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = is.a(this.f703e, ibVar.f703e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = is.a(this.f698a, ibVar.f698a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = is.a(this.f704f, ibVar.f704f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ibVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = is.a(this.f699a, ibVar.f699a)) == 0) {
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
            return a11;
        }
        return getClass().getName().compareTo(ibVar.getClass().getName());
    }

    public String a() {
        return this.f696a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m11938a() {
        return this.f698a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11939a() {
        if (this.f696a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f700b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f701c != null) {
        } else {
            throw new jd("Required field 'cmdName' was not present! Struct: " + toString());
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
                    m11939a();
                    return;
                }
                throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo12032a.f887a) {
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f695a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f696a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f700b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f701c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 10) {
                        this.f694a = jcVar.mo12031a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 11) {
                        this.f702d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 11) {
                        this.f703e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 15) {
                        ja mo12033a = jcVar.mo12033a();
                        this.f698a = new ArrayList(mo12033a.f889a);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo12033a.f889a) {
                                this.f698a.add(jcVar.mo12037a());
                                i2 = i3 + 1;
                            } else {
                                jcVar.i();
                                continue;
                                jcVar.g();
                            }
                        }
                    }
                    break;
                case 12:
                    if (mo12032a.f41543a == 11) {
                        this.f704f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 13:
                    if (mo12032a.f41543a == 2) {
                        this.f699a = jcVar.mo12042a();
                        b(true);
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
        this.f697a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11940a() {
        return this.f695a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11941a(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean m11940a = m11940a();
        boolean m11940a2 = ibVar.m11940a();
        if ((m11940a || m11940a2) && !(m11940a && m11940a2 && this.f695a.m11909a(ibVar.f695a))) {
            return false;
        }
        boolean m11942b = m11942b();
        boolean m11942b2 = ibVar.m11942b();
        if ((m11942b || m11942b2) && !(m11942b && m11942b2 && this.f696a.equals(ibVar.f696a))) {
            return false;
        }
        boolean m11943c = m11943c();
        boolean m11943c2 = ibVar.m11943c();
        if ((m11943c || m11943c2) && !(m11943c && m11943c2 && this.f700b.equals(ibVar.f700b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ibVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f701c.equals(ibVar.f701c))) || this.f694a != ibVar.f694a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ibVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f702d.equals(ibVar.f702d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ibVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f703e.equals(ibVar.f703e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ibVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f698a.equals(ibVar.f698a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ibVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f704f.equals(ibVar.f704f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ibVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f699a == ibVar.f699a;
        }
        return true;
    }

    public String b() {
        return this.f701c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11939a();
        jcVar.a(f693a);
        if (this.f695a != null && m11940a()) {
            jcVar.a(f41509a);
            this.f695a.b(jcVar);
            jcVar.b();
        }
        if (this.f696a != null) {
            jcVar.a(b);
            jcVar.a(this.f696a);
            jcVar.b();
        }
        if (this.f700b != null) {
            jcVar.a(f41510c);
            jcVar.a(this.f700b);
            jcVar.b();
        }
        if (this.f701c != null) {
            jcVar.a(d);
            jcVar.a(this.f701c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f694a);
        jcVar.b();
        if (this.f702d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f702d);
            jcVar.b();
        }
        if (this.f703e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f703e);
            jcVar.b();
        }
        if (this.f698a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja((byte) 11, this.f698a.size()));
            for (String str : this.f698a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f704f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f704f);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f699a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f697a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11942b() {
        return this.f696a != null;
    }

    public String c() {
        return this.f704f;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m11943c() {
        return this.f700b != null;
    }

    public boolean d() {
        return this.f701c != null;
    }

    public boolean e() {
        return this.f697a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m11941a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f702d != null;
    }

    public boolean g() {
        return this.f703e != null;
    }

    public boolean h() {
        return this.f698a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f704f != null;
    }

    public boolean j() {
        return this.f697a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m11940a()) {
            sb.append("target:");
            hv hvVar = this.f695a;
            if (hvVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(hvVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f696a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f700b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f701c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f694a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f702d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f703e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f698a;
            if (list == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f704f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f699a);
        }
        sb.append(")");
        return sb.toString();
    }
}
