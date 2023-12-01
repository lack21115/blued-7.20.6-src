package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hk.class */
public class hk implements ir<hk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f554a;

    /* renamed from: a  reason: collision with other field name */
    public String f555a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f556a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f557a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f558a;

    /* renamed from: b  reason: collision with other field name */
    public long f559b;

    /* renamed from: b  reason: collision with other field name */
    public String f560b;

    /* renamed from: c  reason: collision with other field name */
    public String f561c;

    /* renamed from: d  reason: collision with other field name */
    public String f562d;

    /* renamed from: e  reason: collision with other field name */
    public String f563e;

    /* renamed from: f  reason: collision with other field name */
    public String f564f;

    /* renamed from: g  reason: collision with other field name */
    public String f565g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f553a = new jh("ClientUploadDataItem");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41475a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41476c = new iz("", (byte) 11, 3);
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
            int compareTo = Boolean.valueOf(m11858a()).compareTo(Boolean.valueOf(hkVar.m11858a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11858a() || (a12 = is.a(this.f555a, hkVar.f555a)) == 0) {
                int compareTo2 = Boolean.valueOf(m11860b()).compareTo(Boolean.valueOf(hkVar.m11860b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m11860b() || (a11 = is.a(this.f560b, hkVar.f560b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m11861c()).compareTo(Boolean.valueOf(hkVar.m11861c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m11861c() || (a10 = is.a(this.f561c, hkVar.f561c)) == 0) {
                        int compareTo4 = Boolean.valueOf(m11862d()).compareTo(Boolean.valueOf(hkVar.m11862d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m11862d() || (a9 = is.a(this.f554a, hkVar.f554a)) == 0) {
                            int compareTo5 = Boolean.valueOf(m11863e()).compareTo(Boolean.valueOf(hkVar.m11863e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m11863e() || (a8 = is.a(this.f559b, hkVar.f559b)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a7 = is.a(this.f558a, hkVar.f558a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a6 = is.a(this.f562d, hkVar.f562d)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a5 = is.a(this.f563e, hkVar.f563e)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a4 = is.a(this.f564f, hkVar.f564f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hkVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a3 = is.a(this.f557a, hkVar.f557a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hkVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a2 = is.a(this.f565g, hkVar.f565g)) == 0) {
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
        return this.f559b;
    }

    public hk a(long j2) {
        this.f554a = j2;
        m11857a(true);
        return this;
    }

    public hk a(String str) {
        this.f555a = str;
        return this;
    }

    public hk a(Map<String, String> map) {
        this.f557a = map;
        return this;
    }

    public hk a(boolean z) {
        this.f558a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11854a() {
        return this.f555a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m11855a() {
        return this.f557a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11856a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                m11856a();
                return;
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f555a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 11) {
                        this.f560b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f561c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 10) {
                        this.f554a = jcVar.mo12031a();
                        m11857a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 10) {
                        this.f559b = jcVar.mo12031a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 2) {
                        this.f558a = jcVar.mo12042a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f562d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 11) {
                        this.f563e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 11) {
                        this.f564f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 13) {
                        jb mo12034a = jcVar.mo12034a();
                        this.f557a = new HashMap(mo12034a.f890a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo12034a.f890a) {
                                this.f557a.put(jcVar.mo12037a(), jcVar.mo12037a());
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
                        this.f565g = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
            }
            jf.a(jcVar, mo12032a.f41543a);
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f557a == null) {
            this.f557a = new HashMap();
        }
        this.f557a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11857a(boolean z) {
        this.f556a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11858a() {
        return this.f555a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11859a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m11858a = m11858a();
        boolean m11858a2 = hkVar.m11858a();
        if ((m11858a || m11858a2) && !(m11858a && m11858a2 && this.f555a.equals(hkVar.f555a))) {
            return false;
        }
        boolean m11860b = m11860b();
        boolean m11860b2 = hkVar.m11860b();
        if ((m11860b || m11860b2) && !(m11860b && m11860b2 && this.f560b.equals(hkVar.f560b))) {
            return false;
        }
        boolean m11861c = m11861c();
        boolean m11861c2 = hkVar.m11861c();
        if ((m11861c || m11861c2) && !(m11861c && m11861c2 && this.f561c.equals(hkVar.f561c))) {
            return false;
        }
        boolean m11862d = m11862d();
        boolean m11862d2 = hkVar.m11862d();
        if ((m11862d || m11862d2) && !(m11862d && m11862d2 && this.f554a == hkVar.f554a)) {
            return false;
        }
        boolean m11863e = m11863e();
        boolean m11863e2 = hkVar.m11863e();
        if ((m11863e || m11863e2) && !(m11863e && m11863e2 && this.f559b == hkVar.f559b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hkVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f558a == hkVar.f558a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hkVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f562d.equals(hkVar.f562d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hkVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f563e.equals(hkVar.f563e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hkVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f564f.equals(hkVar.f564f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hkVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f557a.equals(hkVar.f557a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hkVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.f565g.equals(hkVar.f565g);
        }
        return true;
    }

    public hk b(long j2) {
        this.f559b = j2;
        b(true);
        return this;
    }

    public hk b(String str) {
        this.f560b = str;
        return this;
    }

    public String b() {
        return this.f561c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11856a();
        jcVar.a(f553a);
        if (this.f555a != null && m11858a()) {
            jcVar.a(f41475a);
            jcVar.a(this.f555a);
            jcVar.b();
        }
        if (this.f560b != null && m11860b()) {
            jcVar.a(b);
            jcVar.a(this.f560b);
            jcVar.b();
        }
        if (this.f561c != null && m11861c()) {
            jcVar.a(f41476c);
            jcVar.a(this.f561c);
            jcVar.b();
        }
        if (m11862d()) {
            jcVar.a(d);
            jcVar.a(this.f554a);
            jcVar.b();
        }
        if (m11863e()) {
            jcVar.a(e);
            jcVar.a(this.f559b);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f558a);
            jcVar.b();
        }
        if (this.f562d != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f562d);
            jcVar.b();
        }
        if (this.f563e != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f563e);
            jcVar.b();
        }
        if (this.f564f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f564f);
            jcVar.b();
        }
        if (this.f557a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f557a.size()));
            for (Map.Entry<String, String> entry : this.f557a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f565g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f565g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f556a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11860b() {
        return this.f560b != null;
    }

    public hk c(String str) {
        this.f561c = str;
        return this;
    }

    public String c() {
        return this.f563e;
    }

    public void c(boolean z) {
        this.f556a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m11861c() {
        return this.f561c != null;
    }

    public hk d(String str) {
        this.f562d = str;
        return this;
    }

    public String d() {
        return this.f564f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m11862d() {
        return this.f556a.get(0);
    }

    public hk e(String str) {
        this.f563e = str;
        return this;
    }

    public String e() {
        return this.f565g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m11863e() {
        return this.f556a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m11859a((hk) obj);
        }
        return false;
    }

    public hk f(String str) {
        this.f564f = str;
        return this;
    }

    public boolean f() {
        return this.f556a.get(2);
    }

    public hk g(String str) {
        this.f565g = str;
        return this;
    }

    public boolean g() {
        return this.f562d != null;
    }

    public boolean h() {
        return this.f563e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f564f != null;
    }

    public boolean j() {
        return this.f557a != null;
    }

    public boolean k() {
        return this.f565g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        if (m11858a()) {
            sb.append("channel:");
            String str = this.f555a;
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
        if (m11860b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f560b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
            z2 = false;
        }
        boolean z3 = z2;
        if (m11861c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f561c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
            z3 = false;
        }
        boolean z4 = z3;
        if (m11862d()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f554a);
            z4 = false;
        }
        boolean z5 = z4;
        if (m11863e()) {
            if (!z4) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f559b);
            z5 = false;
        }
        boolean z6 = z5;
        if (f()) {
            if (!z5) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f558a);
            z6 = false;
        }
        boolean z7 = z6;
        if (g()) {
            if (!z6) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f562d;
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
            String str5 = this.f563e;
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
            String str6 = this.f564f;
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
            Map<String, String> map = this.f557a;
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
            String str7 = this.f565g;
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
