package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ij.class */
public class ij implements ir<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hs f752a;

    /* renamed from: a  reason: collision with other field name */
    public hv f753a;

    /* renamed from: a  reason: collision with other field name */
    public String f754a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f756a;

    /* renamed from: b  reason: collision with other field name */
    public String f758b;

    /* renamed from: c  reason: collision with other field name */
    public String f759c;

    /* renamed from: d  reason: collision with other field name */
    public String f760d;

    /* renamed from: e  reason: collision with other field name */
    public String f761e;

    /* renamed from: f  reason: collision with other field name */
    public String f762f;

    /* renamed from: g  reason: collision with other field name */
    public String f763g;

    /* renamed from: h  reason: collision with other field name */
    public String f764h;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f751a = new jh("XmPushActionSendMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27832a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27833c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 11, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 12, 8);
    private static final iz i = new iz("", (byte) 2, 9);
    private static final iz j = new iz("", (byte) 13, 10);
    private static final iz k = new iz("", (byte) 11, 11);
    private static final iz l = new iz("", (byte) 11, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f755a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f757a = true;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
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
        int a12;
        int a13;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m8942a()).compareTo(Boolean.valueOf(ijVar.m8942a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8942a() || (a13 = is.a(this.f754a, ijVar.f754a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8944b()).compareTo(Boolean.valueOf(ijVar.m8944b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8944b() || (a12 = is.a(this.f753a, ijVar.f753a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m8945c()).compareTo(Boolean.valueOf(ijVar.m8945c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m8945c() || (a11 = is.a(this.f758b, ijVar.f758b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m8946d()).compareTo(Boolean.valueOf(ijVar.m8946d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m8946d() || (a10 = is.a(this.f759c, ijVar.f759c)) == 0) {
                            int compareTo5 = Boolean.valueOf(m8947e()).compareTo(Boolean.valueOf(ijVar.m8947e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m8947e() || (a9 = is.a(this.f760d, ijVar.f760d)) == 0) {
                                int compareTo6 = Boolean.valueOf(m8948f()).compareTo(Boolean.valueOf(ijVar.m8948f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!m8948f() || (a8 = is.a(this.f761e, ijVar.f761e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a7 = is.a(this.f762f, ijVar.f762f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a6 = is.a(this.f752a, ijVar.f752a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ijVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a5 = is.a(this.f757a, ijVar.f757a)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ijVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a4 = is.a(this.f756a, ijVar.f756a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ijVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a3 = is.a(this.f763g, ijVar.f763g)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ijVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a2 = is.a(this.f764h, ijVar.f764h)) == 0) {
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
                return a12;
            }
            return a13;
        }
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public hs a() {
        return this.f752a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8940a() {
        return this.f758b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8941a() {
        if (this.f758b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f759c != null) {
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
                m8941a();
                return;
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f754a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f753a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f758b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f759c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 11) {
                        this.f760d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 11) {
                        this.f761e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f762f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 12) {
                        hs hsVar = new hs();
                        this.f752a = hsVar;
                        hsVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 2) {
                        this.f757a = jcVar.mo8992a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 13) {
                        jb mo8984a = jcVar.mo8984a();
                        this.f756a = new HashMap(mo8984a.f843a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo8984a.f843a) {
                                this.f756a.put(jcVar.mo8987a(), jcVar.mo8987a());
                                i2 = i3 + 1;
                            } else {
                                jcVar.h();
                                continue;
                                jcVar.g();
                            }
                        }
                    }
                    break;
                case 11:
                    if (mo8982a.f27852a == 11) {
                        this.f763g = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo8982a.f27852a == 11) {
                        this.f764h = jcVar.mo8987a();
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
        this.f755a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8942a() {
        return this.f754a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8943a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m8942a = m8942a();
        boolean m8942a2 = ijVar.m8942a();
        if ((m8942a || m8942a2) && !(m8942a && m8942a2 && this.f754a.equals(ijVar.f754a))) {
            return false;
        }
        boolean m8944b = m8944b();
        boolean m8944b2 = ijVar.m8944b();
        if ((m8944b || m8944b2) && !(m8944b && m8944b2 && this.f753a.m8859a(ijVar.f753a))) {
            return false;
        }
        boolean m8945c = m8945c();
        boolean m8945c2 = ijVar.m8945c();
        if ((m8945c || m8945c2) && !(m8945c && m8945c2 && this.f758b.equals(ijVar.f758b))) {
            return false;
        }
        boolean m8946d = m8946d();
        boolean m8946d2 = ijVar.m8946d();
        if ((m8946d || m8946d2) && !(m8946d && m8946d2 && this.f759c.equals(ijVar.f759c))) {
            return false;
        }
        boolean m8947e = m8947e();
        boolean m8947e2 = ijVar.m8947e();
        if ((m8947e || m8947e2) && !(m8947e && m8947e2 && this.f760d.equals(ijVar.f760d))) {
            return false;
        }
        boolean m8948f = m8948f();
        boolean m8948f2 = ijVar.m8948f();
        if ((m8948f || m8948f2) && !(m8948f && m8948f2 && this.f761e.equals(ijVar.f761e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f762f.equals(ijVar.f762f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ijVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f752a.m8839a(ijVar.f752a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ijVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f757a == ijVar.f757a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ijVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f756a.equals(ijVar.f756a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ijVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f763g.equals(ijVar.f763g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ijVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f764h.equals(ijVar.f764h);
        }
        return true;
    }

    public String b() {
        return this.f759c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8941a();
        jcVar.a(f751a);
        if (this.f754a != null && m8942a()) {
            jcVar.a(f27832a);
            jcVar.a(this.f754a);
            jcVar.b();
        }
        if (this.f753a != null && m8944b()) {
            jcVar.a(b);
            this.f753a.b(jcVar);
            jcVar.b();
        }
        if (this.f758b != null) {
            jcVar.a(f27833c);
            jcVar.a(this.f758b);
            jcVar.b();
        }
        if (this.f759c != null) {
            jcVar.a(d);
            jcVar.a(this.f759c);
            jcVar.b();
        }
        if (this.f760d != null && m8947e()) {
            jcVar.a(e);
            jcVar.a(this.f760d);
            jcVar.b();
        }
        if (this.f761e != null && m8948f()) {
            jcVar.a(f);
            jcVar.a(this.f761e);
            jcVar.b();
        }
        if (this.f762f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f762f);
            jcVar.b();
        }
        if (this.f752a != null && h()) {
            jcVar.a(h);
            this.f752a.b(jcVar);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f757a);
            jcVar.b();
        }
        if (this.f756a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f756a.size()));
            for (Map.Entry<String, String> entry : this.f756a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f763g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f763g);
            jcVar.b();
        }
        if (this.f764h != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f764h);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8944b() {
        return this.f753a != null;
    }

    public String c() {
        return this.f761e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8945c() {
        return this.f758b != null;
    }

    public String d() {
        return this.f762f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m8946d() {
        return this.f759c != null;
    }

    public String e() {
        return this.f763g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m8947e() {
        return this.f760d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m8943a((ij) obj);
        }
        return false;
    }

    public String f() {
        return this.f764h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m8948f() {
        return this.f761e != null;
    }

    public boolean g() {
        return this.f762f != null;
    }

    public boolean h() {
        return this.f752a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f755a.get(0);
    }

    public boolean j() {
        return this.f756a != null;
    }

    public boolean k() {
        return this.f763g != null;
    }

    public boolean l() {
        return this.f764h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        if (m8942a()) {
            sb.append("debug:");
            String str = this.f754a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m8944b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f753a;
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
        String str2 = this.f758b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f759c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        if (m8947e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f760d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (m8948f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f761e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f762f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            hs hsVar = this.f752a;
            if (hsVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(hsVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f757a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f756a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f763g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f764h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
