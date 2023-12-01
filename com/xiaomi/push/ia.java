package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ia.class */
public class ia implements ir<ia, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f635a;

    /* renamed from: a  reason: collision with other field name */
    public hv f636a;

    /* renamed from: a  reason: collision with other field name */
    public String f637a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f639a;

    /* renamed from: b  reason: collision with other field name */
    public String f641b;

    /* renamed from: c  reason: collision with other field name */
    public String f643c;

    /* renamed from: d  reason: collision with other field name */
    public String f644d;

    /* renamed from: e  reason: collision with other field name */
    public String f645e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f634a = new jh("XmPushActionCommand");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27816a = new iz("", (byte) 12, 2);
    private static final iz b = new iz("", (byte) 11, 3);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27817c = new iz("", (byte) 11, 4);
    private static final iz d = new iz("", (byte) 11, 5);
    private static final iz e = new iz("", (byte) 15, 6);
    private static final iz f = new iz("", (byte) 11, 7);
    private static final iz g = new iz("", (byte) 11, 9);
    private static final iz h = new iz("", (byte) 2, 10);
    private static final iz i = new iz("", (byte) 2, 11);
    private static final iz j = new iz("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f638a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f640a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f642b = true;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ia iaVar) {
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
        if (getClass().equals(iaVar.getClass())) {
            int compareTo = Boolean.valueOf(m8885a()).compareTo(Boolean.valueOf(iaVar.m8885a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8885a() || (a11 = is.a(this.f636a, iaVar.f636a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iaVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = is.a(this.f637a, iaVar.f637a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iaVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = is.a(this.f641b, iaVar.f641b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = is.a(this.f643c, iaVar.f643c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = is.a(this.f639a, iaVar.f639a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = is.a(this.f644d, iaVar.f644d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = is.a(this.f645e, iaVar.f645e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = is.a(this.f640a, iaVar.f640a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = is.a(this.f642b, iaVar.f642b)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = is.a(this.f635a, iaVar.f635a)) == 0) {
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
        return getClass().getName().compareTo(iaVar.getClass().getName());
    }

    public ia a(String str) {
        this.f637a = str;
        return this;
    }

    public String a() {
        return this.f643c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8883a() {
        if (this.f637a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f641b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f643c != null) {
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
                m8883a();
                return;
            }
            switch (mo8982a.f840a) {
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f636a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f637a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f641b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 11) {
                        this.f643c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 15) {
                        ja mo8983a = jcVar.mo8983a();
                        this.f639a = new ArrayList(mo8983a.f842a);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo8983a.f842a) {
                                this.f639a.add(jcVar.mo8987a());
                                i2 = i3 + 1;
                            } else {
                                jcVar.i();
                                continue;
                                jcVar.g();
                            }
                        }
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f644d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 11) {
                        this.f645e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 2) {
                        this.f640a = jcVar.mo8992a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 11:
                    if (mo8982a.f27852a == 2) {
                        this.f642b = jcVar.mo8992a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo8982a.f27852a == 10) {
                        this.f635a = jcVar.mo8981a();
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

    /* renamed from: a  reason: collision with other method in class */
    public void m8884a(String str) {
        if (this.f639a == null) {
            this.f639a = new ArrayList();
        }
        this.f639a.add(str);
    }

    public void a(boolean z) {
        this.f638a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8885a() {
        return this.f636a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8886a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean m8885a = m8885a();
        boolean m8885a2 = iaVar.m8885a();
        if ((m8885a || m8885a2) && !(m8885a && m8885a2 && this.f636a.m8859a(iaVar.f636a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iaVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f637a.equals(iaVar.f637a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iaVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f641b.equals(iaVar.f641b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iaVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f643c.equals(iaVar.f643c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iaVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f639a.equals(iaVar.f639a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iaVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f644d.equals(iaVar.f644d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iaVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f645e.equals(iaVar.f645e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iaVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f640a == iaVar.f640a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iaVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f642b == iaVar.f642b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iaVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f635a == iaVar.f635a;
        }
        return true;
    }

    public ia b(String str) {
        this.f641b = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8883a();
        jcVar.a(f634a);
        if (this.f636a != null && m8885a()) {
            jcVar.a(f27816a);
            this.f636a.b(jcVar);
            jcVar.b();
        }
        if (this.f637a != null) {
            jcVar.a(b);
            jcVar.a(this.f637a);
            jcVar.b();
        }
        if (this.f641b != null) {
            jcVar.a(f27817c);
            jcVar.a(this.f641b);
            jcVar.b();
        }
        if (this.f643c != null) {
            jcVar.a(d);
            jcVar.a(this.f643c);
            jcVar.b();
        }
        if (this.f639a != null && e()) {
            jcVar.a(e);
            jcVar.a(new ja((byte) 11, this.f639a.size()));
            for (String str : this.f639a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f644d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f644d);
            jcVar.b();
        }
        if (this.f645e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f645e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f640a);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f642b);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f635a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f638a.set(1, z);
    }

    public boolean b() {
        return this.f637a != null;
    }

    public ia c(String str) {
        this.f643c = str;
        return this;
    }

    public void c(boolean z) {
        this.f638a.set(2, z);
    }

    public boolean c() {
        return this.f641b != null;
    }

    public ia d(String str) {
        this.f644d = str;
        return this;
    }

    public boolean d() {
        return this.f643c != null;
    }

    public ia e(String str) {
        this.f645e = str;
        return this;
    }

    public boolean e() {
        return this.f639a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return m8886a((ia) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f644d != null;
    }

    public boolean g() {
        return this.f645e != null;
    }

    public boolean h() {
        return this.f638a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f638a.get(1);
    }

    public boolean j() {
        return this.f638a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m8885a()) {
            sb.append("target:");
            hv hvVar = this.f636a;
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
        String str = this.f637a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f641b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f643c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f639a;
            if (list == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f644d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f645e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f640a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f642b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f635a);
        }
        sb.append(")");
        return sb.toString();
    }
}
