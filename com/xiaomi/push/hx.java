package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hx.class */
public class hx implements ir<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f662a;

    /* renamed from: a  reason: collision with other field name */
    public String f663a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f665a;

    /* renamed from: b  reason: collision with other field name */
    public String f666b;

    /* renamed from: c  reason: collision with other field name */
    public String f667c;

    /* renamed from: d  reason: collision with other field name */
    public String f668d;

    /* renamed from: e  reason: collision with other field name */
    public String f669e;

    /* renamed from: f  reason: collision with other field name */
    public String f670f;

    /* renamed from: g  reason: collision with other field name */
    public String f671g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f660a = new jh("XmPushActionAckNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41501a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41502c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 10, 7);
    private static final iz g = new iz("", (byte) 11, 8);
    private static final iz h = new iz("", (byte) 13, 9);
    private static final iz i = new iz("", (byte) 11, 10);
    private static final iz j = new iz("", (byte) 11, 11);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f664a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f661a = 0;

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
            int compareTo = Boolean.valueOf(m11916a()).compareTo(Boolean.valueOf(hxVar.m11916a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11916a() || (a11 = is.a(this.f663a, hxVar.f663a)) == 0) {
                int compareTo2 = Boolean.valueOf(m11918b()).compareTo(Boolean.valueOf(hxVar.m11918b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m11918b() || (a10 = is.a(this.f662a, hxVar.f662a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hxVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = is.a(this.f666b, hxVar.f666b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = is.a(this.f667c, hxVar.f667c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = is.a(this.f668d, hxVar.f668d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = is.a(this.f661a, hxVar.f661a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hxVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = is.a(this.f669e, hxVar.f669e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = is.a(this.f665a, hxVar.f665a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hxVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = is.a(this.f670f, hxVar.f670f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hxVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = is.a(this.f671g, hxVar.f671g)) == 0) {
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
        this.f661a = j2;
        a(true);
        return this;
    }

    public hx a(hv hvVar) {
        this.f662a = hvVar;
        return this;
    }

    public hx a(String str) {
        this.f666b = str;
        return this;
    }

    public String a() {
        return this.f666b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m11914a() {
        return this.f665a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11915a() {
        if (this.f666b != null) {
            return;
        }
        throw new jd("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                m11915a();
                return;
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f663a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f662a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f666b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f667c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f668d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 10) {
                        this.f661a = jcVar.mo12031a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 11) {
                        this.f669e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 13) {
                        jb mo12034a = jcVar.mo12034a();
                        this.f665a = new HashMap(mo12034a.f890a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo12034a.f890a) {
                                this.f665a.put(jcVar.mo12037a(), jcVar.mo12037a());
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
                    if (mo12032a.f41543a == 11) {
                        this.f670f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 11:
                    if (mo12032a.f41543a == 11) {
                        this.f671g = jcVar.mo12037a();
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
        this.f664a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11916a() {
        return this.f663a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11917a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m11916a = m11916a();
        boolean m11916a2 = hxVar.m11916a();
        if ((m11916a || m11916a2) && !(m11916a && m11916a2 && this.f663a.equals(hxVar.f663a))) {
            return false;
        }
        boolean m11918b = m11918b();
        boolean m11918b2 = hxVar.m11918b();
        if ((m11918b || m11918b2) && !(m11918b && m11918b2 && this.f662a.m11909a(hxVar.f662a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hxVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f666b.equals(hxVar.f666b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f667c.equals(hxVar.f667c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f668d.equals(hxVar.f668d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f661a == hxVar.f661a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hxVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f669e.equals(hxVar.f669e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hxVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f665a.equals(hxVar.f665a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hxVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f670f.equals(hxVar.f670f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hxVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f671g.equals(hxVar.f671g);
        }
        return true;
    }

    public hx b(String str) {
        this.f667c = str;
        return this;
    }

    public String b() {
        return this.f668d;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11915a();
        jcVar.a(f660a);
        if (this.f663a != null && m11916a()) {
            jcVar.a(f41501a);
            jcVar.a(this.f663a);
            jcVar.b();
        }
        if (this.f662a != null && m11918b()) {
            jcVar.a(b);
            this.f662a.b(jcVar);
            jcVar.b();
        }
        if (this.f666b != null) {
            jcVar.a(f41502c);
            jcVar.a(this.f666b);
            jcVar.b();
        }
        if (this.f667c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f667c);
            jcVar.b();
        }
        if (this.f668d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f668d);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f661a);
            jcVar.b();
        }
        if (this.f669e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f669e);
            jcVar.b();
        }
        if (this.f665a != null && h()) {
            jcVar.a(h);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f665a.size()));
            for (Map.Entry<String, String> entry : this.f665a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f670f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f670f);
            jcVar.b();
        }
        if (this.f671g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f671g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11918b() {
        return this.f662a != null;
    }

    public hx c(String str) {
        this.f668d = str;
        return this;
    }

    public boolean c() {
        return this.f666b != null;
    }

    public hx d(String str) {
        this.f669e = str;
        return this;
    }

    public boolean d() {
        return this.f667c != null;
    }

    public hx e(String str) {
        this.f670f = str;
        return this;
    }

    public boolean e() {
        return this.f668d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m11917a((hx) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f664a.get(0);
    }

    public boolean g() {
        return this.f669e != null;
    }

    public boolean h() {
        return this.f665a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f670f != null;
    }

    public boolean j() {
        return this.f671g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        if (m11916a()) {
            sb.append("debug:");
            String str = this.f663a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m11918b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f662a;
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
        String str2 = this.f666b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f667c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f668d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f661a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f669e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f665a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f670f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f671g;
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
