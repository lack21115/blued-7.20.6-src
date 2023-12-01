package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hx.class */
public class hx implements ir<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f615a;

    /* renamed from: a  reason: collision with other field name */
    public String f616a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f618a;

    /* renamed from: b  reason: collision with other field name */
    public String f619b;

    /* renamed from: c  reason: collision with other field name */
    public String f620c;

    /* renamed from: d  reason: collision with other field name */
    public String f621d;

    /* renamed from: e  reason: collision with other field name */
    public String f622e;

    /* renamed from: f  reason: collision with other field name */
    public String f623f;

    /* renamed from: g  reason: collision with other field name */
    public String f624g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f613a = new jh("XmPushActionAckNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27810a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27811c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 10, 7);
    private static final iz g = new iz("", (byte) 11, 8);
    private static final iz h = new iz("", (byte) 13, 9);
    private static final iz i = new iz("", (byte) 11, 10);
    private static final iz j = new iz("", (byte) 11, 11);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f617a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f614a = 0;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hx hxVar) {
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
        if (getClass().equals(hxVar.getClass())) {
            int compareTo = Boolean.valueOf(m8866a()).compareTo(Boolean.valueOf(hxVar.m8866a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8866a() || (a11 = is.a(this.f616a, hxVar.f616a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8868b()).compareTo(Boolean.valueOf(hxVar.m8868b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8868b() || (a10 = is.a(this.f615a, hxVar.f615a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hxVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = is.a(this.f619b, hxVar.f619b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = is.a(this.f620c, hxVar.f620c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = is.a(this.f621d, hxVar.f621d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = is.a(this.f614a, hxVar.f614a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hxVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = is.a(this.f622e, hxVar.f622e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = is.a(this.f618a, hxVar.f618a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hxVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = is.a(this.f623f, hxVar.f623f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hxVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = is.a(this.f624g, hxVar.f624g)) == 0) {
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
        return getClass().getName().compareTo(hxVar.getClass().getName());
    }

    public hx a(long j2) {
        this.f614a = j2;
        a(true);
        return this;
    }

    public hx a(hv hvVar) {
        this.f615a = hvVar;
        return this;
    }

    public hx a(String str) {
        this.f619b = str;
        return this;
    }

    public String a() {
        return this.f619b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m8864a() {
        return this.f618a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8865a() {
        if (this.f619b != null) {
            return;
        }
        throw new jd("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                m8865a();
                return;
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f616a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f615a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f619b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f620c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 11) {
                        this.f621d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 10) {
                        this.f614a = jcVar.mo8981a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 11) {
                        this.f622e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 13) {
                        jb mo8984a = jcVar.mo8984a();
                        this.f618a = new HashMap(mo8984a.f843a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo8984a.f843a) {
                                this.f618a.put(jcVar.mo8987a(), jcVar.mo8987a());
                                i2 = i3 + 1;
                            } else {
                                jcVar.h();
                                continue;
                                jcVar.g();
                            }
                        }
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 11) {
                        this.f623f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 11:
                    if (mo8982a.f27852a == 11) {
                        this.f624g = jcVar.mo8987a();
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
        this.f617a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8866a() {
        return this.f616a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8867a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m8866a = m8866a();
        boolean m8866a2 = hxVar.m8866a();
        if ((m8866a || m8866a2) && !(m8866a && m8866a2 && this.f616a.equals(hxVar.f616a))) {
            return false;
        }
        boolean m8868b = m8868b();
        boolean m8868b2 = hxVar.m8868b();
        if ((m8868b || m8868b2) && !(m8868b && m8868b2 && this.f615a.m8859a(hxVar.f615a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hxVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f619b.equals(hxVar.f619b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f620c.equals(hxVar.f620c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f621d.equals(hxVar.f621d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f614a == hxVar.f614a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hxVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f622e.equals(hxVar.f622e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hxVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f618a.equals(hxVar.f618a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hxVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f623f.equals(hxVar.f623f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hxVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f624g.equals(hxVar.f624g);
        }
        return true;
    }

    public hx b(String str) {
        this.f620c = str;
        return this;
    }

    public String b() {
        return this.f621d;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8865a();
        jcVar.a(f613a);
        if (this.f616a != null && m8866a()) {
            jcVar.a(f27810a);
            jcVar.a(this.f616a);
            jcVar.b();
        }
        if (this.f615a != null && m8868b()) {
            jcVar.a(b);
            this.f615a.b(jcVar);
            jcVar.b();
        }
        if (this.f619b != null) {
            jcVar.a(f27811c);
            jcVar.a(this.f619b);
            jcVar.b();
        }
        if (this.f620c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f620c);
            jcVar.b();
        }
        if (this.f621d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f621d);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f614a);
            jcVar.b();
        }
        if (this.f622e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f622e);
            jcVar.b();
        }
        if (this.f618a != null && h()) {
            jcVar.a(h);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f618a.size()));
            for (Map.Entry<String, String> entry : this.f618a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f623f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f623f);
            jcVar.b();
        }
        if (this.f624g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f624g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8868b() {
        return this.f615a != null;
    }

    public hx c(String str) {
        this.f621d = str;
        return this;
    }

    public boolean c() {
        return this.f619b != null;
    }

    public hx d(String str) {
        this.f622e = str;
        return this;
    }

    public boolean d() {
        return this.f620c != null;
    }

    public hx e(String str) {
        this.f623f = str;
        return this;
    }

    public boolean e() {
        return this.f621d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m8867a((hx) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f617a.get(0);
    }

    public boolean g() {
        return this.f622e != null;
    }

    public boolean h() {
        return this.f618a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f623f != null;
    }

    public boolean j() {
        return this.f624g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        if (m8866a()) {
            sb.append("debug:");
            String str = this.f616a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m8868b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f615a;
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
        String str2 = this.f619b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f620c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f621d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f614a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f622e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f618a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f623f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f624g;
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
