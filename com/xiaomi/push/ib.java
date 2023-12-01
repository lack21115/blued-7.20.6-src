package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ib.class */
public class ib implements ir<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f647a;

    /* renamed from: a  reason: collision with other field name */
    public hv f648a;

    /* renamed from: a  reason: collision with other field name */
    public String f649a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f651a;

    /* renamed from: b  reason: collision with other field name */
    public String f653b;

    /* renamed from: c  reason: collision with other field name */
    public String f654c;

    /* renamed from: d  reason: collision with other field name */
    public String f655d;

    /* renamed from: e  reason: collision with other field name */
    public String f656e;

    /* renamed from: f  reason: collision with other field name */
    public String f657f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f646a = new jh("XmPushActionCommandResult");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27818a = new iz("", (byte) 12, 2);
    private static final iz b = new iz("", (byte) 11, 3);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27819c = new iz("", (byte) 11, 4);
    private static final iz d = new iz("", (byte) 11, 5);
    private static final iz e = new iz("", (byte) 10, 7);
    private static final iz f = new iz("", (byte) 11, 8);
    private static final iz g = new iz("", (byte) 11, 9);
    private static final iz h = new iz("", (byte) 15, 10);
    private static final iz i = new iz("", (byte) 11, 12);
    private static final iz j = new iz("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f650a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f652a = true;

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
            int compareTo = Boolean.valueOf(m8890a()).compareTo(Boolean.valueOf(ibVar.m8890a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8890a() || (a11 = is.a(this.f648a, ibVar.f648a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8892b()).compareTo(Boolean.valueOf(ibVar.m8892b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8892b() || (a10 = is.a(this.f649a, ibVar.f649a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m8893c()).compareTo(Boolean.valueOf(ibVar.m8893c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m8893c() || (a9 = is.a(this.f653b, ibVar.f653b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = is.a(this.f654c, ibVar.f654c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = is.a(this.f647a, ibVar.f647a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = is.a(this.f655d, ibVar.f655d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = is.a(this.f656e, ibVar.f656e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = is.a(this.f651a, ibVar.f651a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = is.a(this.f657f, ibVar.f657f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ibVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = is.a(this.f652a, ibVar.f652a)) == 0) {
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
        return this.f649a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m8888a() {
        return this.f651a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8889a() {
        if (this.f649a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f653b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f654c != null) {
        } else {
            throw new jd("Required field 'cmdName' was not present! Struct: " + toString());
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
                    m8889a();
                    return;
                }
                throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo8982a.f840a) {
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f648a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f649a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f653b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 11) {
                        this.f654c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 10) {
                        this.f647a = jcVar.mo8981a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 11) {
                        this.f655d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 11) {
                        this.f656e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 15) {
                        ja mo8983a = jcVar.mo8983a();
                        this.f651a = new ArrayList(mo8983a.f842a);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo8983a.f842a) {
                                this.f651a.add(jcVar.mo8987a());
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
                    if (mo8982a.f27852a == 11) {
                        this.f657f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 13:
                    if (mo8982a.f27852a == 2) {
                        this.f652a = jcVar.mo8992a();
                        b(true);
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
        this.f650a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8890a() {
        return this.f648a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8891a(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean m8890a = m8890a();
        boolean m8890a2 = ibVar.m8890a();
        if ((m8890a || m8890a2) && !(m8890a && m8890a2 && this.f648a.m8859a(ibVar.f648a))) {
            return false;
        }
        boolean m8892b = m8892b();
        boolean m8892b2 = ibVar.m8892b();
        if ((m8892b || m8892b2) && !(m8892b && m8892b2 && this.f649a.equals(ibVar.f649a))) {
            return false;
        }
        boolean m8893c = m8893c();
        boolean m8893c2 = ibVar.m8893c();
        if ((m8893c || m8893c2) && !(m8893c && m8893c2 && this.f653b.equals(ibVar.f653b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ibVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f654c.equals(ibVar.f654c))) || this.f647a != ibVar.f647a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ibVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f655d.equals(ibVar.f655d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ibVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f656e.equals(ibVar.f656e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ibVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f651a.equals(ibVar.f651a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ibVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f657f.equals(ibVar.f657f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ibVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f652a == ibVar.f652a;
        }
        return true;
    }

    public String b() {
        return this.f654c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8889a();
        jcVar.a(f646a);
        if (this.f648a != null && m8890a()) {
            jcVar.a(f27818a);
            this.f648a.b(jcVar);
            jcVar.b();
        }
        if (this.f649a != null) {
            jcVar.a(b);
            jcVar.a(this.f649a);
            jcVar.b();
        }
        if (this.f653b != null) {
            jcVar.a(f27819c);
            jcVar.a(this.f653b);
            jcVar.b();
        }
        if (this.f654c != null) {
            jcVar.a(d);
            jcVar.a(this.f654c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f647a);
        jcVar.b();
        if (this.f655d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f655d);
            jcVar.b();
        }
        if (this.f656e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f656e);
            jcVar.b();
        }
        if (this.f651a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja((byte) 11, this.f651a.size()));
            for (String str : this.f651a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f657f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f657f);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f652a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f650a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8892b() {
        return this.f649a != null;
    }

    public String c() {
        return this.f657f;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8893c() {
        return this.f653b != null;
    }

    public boolean d() {
        return this.f654c != null;
    }

    public boolean e() {
        return this.f650a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m8891a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f655d != null;
    }

    public boolean g() {
        return this.f656e != null;
    }

    public boolean h() {
        return this.f651a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f657f != null;
    }

    public boolean j() {
        return this.f650a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m8890a()) {
            sb.append("target:");
            hv hvVar = this.f648a;
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
        String str = this.f649a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f653b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f654c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f647a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f655d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f656e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f651a;
            if (list == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f657f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f652a);
        }
        sb.append(")");
        return sb.toString();
    }
}
