package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hk.class */
public class hk implements ir<hk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f507a;

    /* renamed from: a  reason: collision with other field name */
    public String f508a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f509a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f510a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f511a;

    /* renamed from: b  reason: collision with other field name */
    public long f512b;

    /* renamed from: b  reason: collision with other field name */
    public String f513b;

    /* renamed from: c  reason: collision with other field name */
    public String f514c;

    /* renamed from: d  reason: collision with other field name */
    public String f515d;

    /* renamed from: e  reason: collision with other field name */
    public String f516e;

    /* renamed from: f  reason: collision with other field name */
    public String f517f;

    /* renamed from: g  reason: collision with other field name */
    public String f518g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f506a = new jh("ClientUploadDataItem");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27784a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27785c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 10, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", (byte) 2, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 11, 8);
    private static final iz i = new iz("", (byte) 11, 9);
    private static final iz j = new iz("", (byte) 13, 10);
    private static final iz k = new iz("", (byte) 11, 11);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hk hkVar) {
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
        if (getClass().equals(hkVar.getClass())) {
            int compareTo = Boolean.valueOf(m8808a()).compareTo(Boolean.valueOf(hkVar.m8808a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8808a() || (a12 = is.a(this.f508a, hkVar.f508a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8810b()).compareTo(Boolean.valueOf(hkVar.m8810b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8810b() || (a11 = is.a(this.f513b, hkVar.f513b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m8811c()).compareTo(Boolean.valueOf(hkVar.m8811c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m8811c() || (a10 = is.a(this.f514c, hkVar.f514c)) == 0) {
                        int compareTo4 = Boolean.valueOf(m8812d()).compareTo(Boolean.valueOf(hkVar.m8812d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m8812d() || (a9 = is.a(this.f507a, hkVar.f507a)) == 0) {
                            int compareTo5 = Boolean.valueOf(m8813e()).compareTo(Boolean.valueOf(hkVar.m8813e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m8813e() || (a8 = is.a(this.f512b, hkVar.f512b)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a7 = is.a(this.f511a, hkVar.f511a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a6 = is.a(this.f515d, hkVar.f515d)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a5 = is.a(this.f516e, hkVar.f516e)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a4 = is.a(this.f517f, hkVar.f517f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hkVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a3 = is.a(this.f510a, hkVar.f510a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hkVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a2 = is.a(this.f518g, hkVar.f518g)) == 0) {
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
        return getClass().getName().compareTo(hkVar.getClass().getName());
    }

    public long a() {
        return this.f512b;
    }

    public hk a(long j2) {
        this.f507a = j2;
        m8807a(true);
        return this;
    }

    public hk a(String str) {
        this.f508a = str;
        return this;
    }

    public hk a(Map<String, String> map) {
        this.f510a = map;
        return this;
    }

    public hk a(boolean z) {
        this.f511a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8804a() {
        return this.f508a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m8805a() {
        return this.f510a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8806a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                m8806a();
                return;
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f508a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 11) {
                        this.f513b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f514c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 10) {
                        this.f507a = jcVar.mo8981a();
                        m8807a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 10) {
                        this.f512b = jcVar.mo8981a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 2) {
                        this.f511a = jcVar.mo8992a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f515d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 11) {
                        this.f516e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 11) {
                        this.f517f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 13) {
                        jb mo8984a = jcVar.mo8984a();
                        this.f510a = new HashMap(mo8984a.f843a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo8984a.f843a) {
                                this.f510a.put(jcVar.mo8987a(), jcVar.mo8987a());
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
                        this.f518g = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
            }
            jf.a(jcVar, mo8982a.f27852a);
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f510a == null) {
            this.f510a = new HashMap();
        }
        this.f510a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8807a(boolean z) {
        this.f509a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8808a() {
        return this.f508a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8809a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m8808a = m8808a();
        boolean m8808a2 = hkVar.m8808a();
        if ((m8808a || m8808a2) && !(m8808a && m8808a2 && this.f508a.equals(hkVar.f508a))) {
            return false;
        }
        boolean m8810b = m8810b();
        boolean m8810b2 = hkVar.m8810b();
        if ((m8810b || m8810b2) && !(m8810b && m8810b2 && this.f513b.equals(hkVar.f513b))) {
            return false;
        }
        boolean m8811c = m8811c();
        boolean m8811c2 = hkVar.m8811c();
        if ((m8811c || m8811c2) && !(m8811c && m8811c2 && this.f514c.equals(hkVar.f514c))) {
            return false;
        }
        boolean m8812d = m8812d();
        boolean m8812d2 = hkVar.m8812d();
        if ((m8812d || m8812d2) && !(m8812d && m8812d2 && this.f507a == hkVar.f507a)) {
            return false;
        }
        boolean m8813e = m8813e();
        boolean m8813e2 = hkVar.m8813e();
        if ((m8813e || m8813e2) && !(m8813e && m8813e2 && this.f512b == hkVar.f512b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hkVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f511a == hkVar.f511a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hkVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f515d.equals(hkVar.f515d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hkVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f516e.equals(hkVar.f516e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hkVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f517f.equals(hkVar.f517f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hkVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f510a.equals(hkVar.f510a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hkVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.f518g.equals(hkVar.f518g);
        }
        return true;
    }

    public hk b(long j2) {
        this.f512b = j2;
        b(true);
        return this;
    }

    public hk b(String str) {
        this.f513b = str;
        return this;
    }

    public String b() {
        return this.f514c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8806a();
        jcVar.a(f506a);
        if (this.f508a != null && m8808a()) {
            jcVar.a(f27784a);
            jcVar.a(this.f508a);
            jcVar.b();
        }
        if (this.f513b != null && m8810b()) {
            jcVar.a(b);
            jcVar.a(this.f513b);
            jcVar.b();
        }
        if (this.f514c != null && m8811c()) {
            jcVar.a(f27785c);
            jcVar.a(this.f514c);
            jcVar.b();
        }
        if (m8812d()) {
            jcVar.a(d);
            jcVar.a(this.f507a);
            jcVar.b();
        }
        if (m8813e()) {
            jcVar.a(e);
            jcVar.a(this.f512b);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f511a);
            jcVar.b();
        }
        if (this.f515d != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f515d);
            jcVar.b();
        }
        if (this.f516e != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f516e);
            jcVar.b();
        }
        if (this.f517f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f517f);
            jcVar.b();
        }
        if (this.f510a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f510a.size()));
            for (Map.Entry<String, String> entry : this.f510a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f518g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f518g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f509a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8810b() {
        return this.f513b != null;
    }

    public hk c(String str) {
        this.f514c = str;
        return this;
    }

    public String c() {
        return this.f516e;
    }

    public void c(boolean z) {
        this.f509a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8811c() {
        return this.f514c != null;
    }

    public hk d(String str) {
        this.f515d = str;
        return this;
    }

    public String d() {
        return this.f517f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m8812d() {
        return this.f509a.get(0);
    }

    public hk e(String str) {
        this.f516e = str;
        return this;
    }

    public String e() {
        return this.f518g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m8813e() {
        return this.f509a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m8809a((hk) obj);
        }
        return false;
    }

    public hk f(String str) {
        this.f517f = str;
        return this;
    }

    public boolean f() {
        return this.f509a.get(2);
    }

    public hk g(String str) {
        this.f518g = str;
        return this;
    }

    public boolean g() {
        return this.f515d != null;
    }

    public boolean h() {
        return this.f516e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f517f != null;
    }

    public boolean j() {
        return this.f510a != null;
    }

    public boolean k() {
        return this.f518g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        if (m8808a()) {
            sb.append("channel:");
            String str = this.f508a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        boolean z2 = z;
        if (m8810b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f513b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
            z2 = false;
        }
        boolean z3 = z2;
        if (m8811c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f514c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
            z3 = false;
        }
        boolean z4 = z3;
        if (m8812d()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f507a);
            z4 = false;
        }
        boolean z5 = z4;
        if (m8813e()) {
            if (!z4) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f512b);
            z5 = false;
        }
        boolean z6 = z5;
        if (f()) {
            if (!z5) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f511a);
            z6 = false;
        }
        boolean z7 = z6;
        if (g()) {
            if (!z6) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f515d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
            z7 = false;
        }
        boolean z8 = z7;
        if (h()) {
            if (!z7) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f516e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
            z8 = false;
        }
        boolean z9 = z8;
        if (i()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f517f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
            z9 = false;
        }
        if (j()) {
            if (!z9) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f510a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
                z9 = false;
            } else {
                sb.append(map);
                z9 = false;
            }
        }
        if (k()) {
            if (!z9) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f518g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
