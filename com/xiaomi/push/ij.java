package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ij.class */
public class ij implements ir<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hs f799a;

    /* renamed from: a  reason: collision with other field name */
    public hv f800a;

    /* renamed from: a  reason: collision with other field name */
    public String f801a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f803a;

    /* renamed from: b  reason: collision with other field name */
    public String f805b;

    /* renamed from: c  reason: collision with other field name */
    public String f806c;

    /* renamed from: d  reason: collision with other field name */
    public String f807d;

    /* renamed from: e  reason: collision with other field name */
    public String f808e;

    /* renamed from: f  reason: collision with other field name */
    public String f809f;

    /* renamed from: g  reason: collision with other field name */
    public String f810g;

    /* renamed from: h  reason: collision with other field name */
    public String f811h;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f798a = new jh("XmPushActionSendMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41523a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41524c = new iz("", (byte) 11, 3);
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
    private BitSet f802a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f804a = true;

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
            int compareTo = Boolean.valueOf(m11992a()).compareTo(Boolean.valueOf(ijVar.m11992a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11992a() || (a13 = is.a(this.f801a, ijVar.f801a)) == 0) {
                int compareTo2 = Boolean.valueOf(m11994b()).compareTo(Boolean.valueOf(ijVar.m11994b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m11994b() || (a12 = is.a(this.f800a, ijVar.f800a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m11995c()).compareTo(Boolean.valueOf(ijVar.m11995c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m11995c() || (a11 = is.a(this.f805b, ijVar.f805b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m11996d()).compareTo(Boolean.valueOf(ijVar.m11996d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m11996d() || (a10 = is.a(this.f806c, ijVar.f806c)) == 0) {
                            int compareTo5 = Boolean.valueOf(m11997e()).compareTo(Boolean.valueOf(ijVar.m11997e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m11997e() || (a9 = is.a(this.f807d, ijVar.f807d)) == 0) {
                                int compareTo6 = Boolean.valueOf(m11998f()).compareTo(Boolean.valueOf(ijVar.m11998f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!m11998f() || (a8 = is.a(this.f808e, ijVar.f808e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a7 = is.a(this.f809f, ijVar.f809f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a6 = is.a(this.f799a, ijVar.f799a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ijVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a5 = is.a(this.f804a, ijVar.f804a)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ijVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a4 = is.a(this.f803a, ijVar.f803a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ijVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a3 = is.a(this.f810g, ijVar.f810g)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ijVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a2 = is.a(this.f811h, ijVar.f811h)) == 0) {
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
        return this.f799a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11990a() {
        return this.f805b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11991a() {
        if (this.f805b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f806c != null) {
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
                m11991a();
                return;
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f801a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f800a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f805b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f806c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f807d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 11) {
                        this.f808e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f809f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 12) {
                        hs hsVar = new hs();
                        this.f799a = hsVar;
                        hsVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 2) {
                        this.f804a = jcVar.mo12042a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 13) {
                        jb mo12034a = jcVar.mo12034a();
                        this.f803a = new HashMap(mo12034a.f890a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo12034a.f890a) {
                                this.f803a.put(jcVar.mo12037a(), jcVar.mo12037a());
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
                    if (mo12032a.f41543a == 11) {
                        this.f810g = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo12032a.f41543a == 11) {
                        this.f811h = jcVar.mo12037a();
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
        this.f802a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11992a() {
        return this.f801a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11993a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m11992a = m11992a();
        boolean m11992a2 = ijVar.m11992a();
        if ((m11992a || m11992a2) && !(m11992a && m11992a2 && this.f801a.equals(ijVar.f801a))) {
            return false;
        }
        boolean m11994b = m11994b();
        boolean m11994b2 = ijVar.m11994b();
        if ((m11994b || m11994b2) && !(m11994b && m11994b2 && this.f800a.m11909a(ijVar.f800a))) {
            return false;
        }
        boolean m11995c = m11995c();
        boolean m11995c2 = ijVar.m11995c();
        if ((m11995c || m11995c2) && !(m11995c && m11995c2 && this.f805b.equals(ijVar.f805b))) {
            return false;
        }
        boolean m11996d = m11996d();
        boolean m11996d2 = ijVar.m11996d();
        if ((m11996d || m11996d2) && !(m11996d && m11996d2 && this.f806c.equals(ijVar.f806c))) {
            return false;
        }
        boolean m11997e = m11997e();
        boolean m11997e2 = ijVar.m11997e();
        if ((m11997e || m11997e2) && !(m11997e && m11997e2 && this.f807d.equals(ijVar.f807d))) {
            return false;
        }
        boolean m11998f = m11998f();
        boolean m11998f2 = ijVar.m11998f();
        if ((m11998f || m11998f2) && !(m11998f && m11998f2 && this.f808e.equals(ijVar.f808e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f809f.equals(ijVar.f809f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ijVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f799a.m11889a(ijVar.f799a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ijVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f804a == ijVar.f804a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ijVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f803a.equals(ijVar.f803a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ijVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f810g.equals(ijVar.f810g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ijVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f811h.equals(ijVar.f811h);
        }
        return true;
    }

    public String b() {
        return this.f806c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11991a();
        jcVar.a(f798a);
        if (this.f801a != null && m11992a()) {
            jcVar.a(f41523a);
            jcVar.a(this.f801a);
            jcVar.b();
        }
        if (this.f800a != null && m11994b()) {
            jcVar.a(b);
            this.f800a.b(jcVar);
            jcVar.b();
        }
        if (this.f805b != null) {
            jcVar.a(f41524c);
            jcVar.a(this.f805b);
            jcVar.b();
        }
        if (this.f806c != null) {
            jcVar.a(d);
            jcVar.a(this.f806c);
            jcVar.b();
        }
        if (this.f807d != null && m11997e()) {
            jcVar.a(e);
            jcVar.a(this.f807d);
            jcVar.b();
        }
        if (this.f808e != null && m11998f()) {
            jcVar.a(f);
            jcVar.a(this.f808e);
            jcVar.b();
        }
        if (this.f809f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f809f);
            jcVar.b();
        }
        if (this.f799a != null && h()) {
            jcVar.a(h);
            this.f799a.b(jcVar);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f804a);
            jcVar.b();
        }
        if (this.f803a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f803a.size()));
            for (Map.Entry<String, String> entry : this.f803a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f810g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f810g);
            jcVar.b();
        }
        if (this.f811h != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f811h);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11994b() {
        return this.f800a != null;
    }

    public String c() {
        return this.f808e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m11995c() {
        return this.f805b != null;
    }

    public String d() {
        return this.f809f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m11996d() {
        return this.f806c != null;
    }

    public String e() {
        return this.f810g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m11997e() {
        return this.f807d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m11993a((ij) obj);
        }
        return false;
    }

    public String f() {
        return this.f811h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m11998f() {
        return this.f808e != null;
    }

    public boolean g() {
        return this.f809f != null;
    }

    public boolean h() {
        return this.f799a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f802a.get(0);
    }

    public boolean j() {
        return this.f803a != null;
    }

    public boolean k() {
        return this.f810g != null;
    }

    public boolean l() {
        return this.f811h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        if (m11992a()) {
            sb.append("debug:");
            String str = this.f801a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m11994b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f800a;
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
        String str3 = this.f806c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        if (m11997e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f807d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (m11998f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f808e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f809f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            hs hsVar = this.f799a;
            if (hsVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(hsVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f804a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f803a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f810g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f811h;
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
