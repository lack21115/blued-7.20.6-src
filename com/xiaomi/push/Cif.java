package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/if.class */
public class Cif implements ir<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f720a;

    /* renamed from: a  reason: collision with other field name */
    public hv f721a;

    /* renamed from: a  reason: collision with other field name */
    public String f722a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f723a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f724a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f725a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f726a;

    /* renamed from: b  reason: collision with other field name */
    public String f727b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f728b;

    /* renamed from: c  reason: collision with other field name */
    public String f729c;

    /* renamed from: d  reason: collision with other field name */
    public String f730d;

    /* renamed from: e  reason: collision with other field name */
    public String f731e;

    /* renamed from: f  reason: collision with other field name */
    public String f732f;

    /* renamed from: g  reason: collision with other field name */
    public String f733g;

    /* renamed from: h  reason: collision with other field name */
    public String f734h;

    /* renamed from: i  reason: collision with other field name */
    public String f735i;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f719a = new jh("XmPushActionNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41515a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41516c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 2, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 13, 8);
    private static final iz i = new iz("", (byte) 11, 9);
    private static final iz j = new iz("", (byte) 11, 10);
    private static final iz k = new iz("", (byte) 11, 12);
    private static final iz l = new iz("", (byte) 11, 13);
    private static final iz m = new iz("", (byte) 11, 14);
    private static final iz n = new iz("", (byte) 10, 15);
    private static final iz o = new iz("", (byte) 2, 20);

    public Cif() {
        this.f724a = new BitSet(3);
        this.f726a = true;
        this.f728b = false;
    }

    public Cif(String str, boolean z) {
        this();
        this.f727b = str;
        this.f726a = z;
        m11966a(true);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
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
        int a14;
        int a15;
        int a16;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m11967a()).compareTo(Boolean.valueOf(cif.m11967a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11967a() || (a16 = is.a(this.f722a, cif.f722a)) == 0) {
                int compareTo2 = Boolean.valueOf(m11970b()).compareTo(Boolean.valueOf(cif.m11970b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m11970b() || (a15 = is.a(this.f721a, cif.f721a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m11971c()).compareTo(Boolean.valueOf(cif.m11971c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m11971c() || (a14 = is.a(this.f727b, cif.f727b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a13 = is.a(this.f729c, cif.f729c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a12 = is.a(this.f730d, cif.f730d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a11 = is.a(this.f726a, cif.f726a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a10 = is.a(this.f731e, cif.f731e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a9 = is.a(this.f725a, cif.f725a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a8 = is.a(this.f732f, cif.f732f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(cif.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a7 = is.a(this.f733g, cif.f733g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(cif.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a6 = is.a(this.f734h, cif.f734h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(cif.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a5 = is.a(this.f735i, cif.f735i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(cif.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a4 = is.a(this.f723a, cif.f723a)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(cif.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a3 = is.a(this.f720a, cif.f720a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(cif.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a2 = is.a(this.f728b, cif.f728b)) == 0) {
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
                    return a14;
                }
                return a15;
            }
            return a16;
        }
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public hv a() {
        return this.f721a;
    }

    public Cif a(String str) {
        this.f727b = str;
        return this;
    }

    public Cif a(ByteBuffer byteBuffer) {
        this.f723a = byteBuffer;
        return this;
    }

    public Cif a(Map<String, String> map) {
        this.f725a = map;
        return this;
    }

    public Cif a(boolean z) {
        this.f726a = z;
        m11966a(true);
        return this;
    }

    public Cif a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11963a() {
        return this.f727b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m11964a() {
        return this.f725a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11965a() {
        if (this.f727b != null) {
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
                if (f()) {
                    m11965a();
                    return;
                }
                throw new jd("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f722a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f721a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f727b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f729c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f730d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 2) {
                        this.f726a = jcVar.mo12042a();
                        m11966a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f731e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 13) {
                        jb mo12034a = jcVar.mo12034a();
                        this.f725a = new HashMap(mo12034a.f890a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo12034a.f890a) {
                                this.f725a.put(jcVar.mo12037a(), jcVar.mo12037a());
                                i2 = i3 + 1;
                            } else {
                                jcVar.h();
                                continue;
                                jcVar.g();
                            }
                        }
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 11) {
                        this.f732f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 11) {
                        this.f733g = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo12032a.f41543a == 11) {
                        this.f734h = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 13:
                    if (mo12032a.f41543a == 11) {
                        this.f735i = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 14:
                    if (mo12032a.f41543a == 11) {
                        this.f723a = jcVar.mo12038a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 15:
                    if (mo12032a.f41543a == 10) {
                        this.f720a = jcVar.mo12031a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 20:
                    if (mo12032a.f41543a == 2) {
                        this.f728b = jcVar.mo12042a();
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

    public void a(String str, String str2) {
        if (this.f725a == null) {
            this.f725a = new HashMap();
        }
        this.f725a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11966a(boolean z) {
        this.f724a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11967a() {
        return this.f722a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11968a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m11967a = m11967a();
        boolean m11967a2 = cif.m11967a();
        if ((m11967a || m11967a2) && !(m11967a && m11967a2 && this.f722a.equals(cif.f722a))) {
            return false;
        }
        boolean m11970b = m11970b();
        boolean m11970b2 = cif.m11970b();
        if ((m11970b || m11970b2) && !(m11970b && m11970b2 && this.f721a.m11909a(cif.f721a))) {
            return false;
        }
        boolean m11971c = m11971c();
        boolean m11971c2 = cif.m11971c();
        if ((m11971c || m11971c2) && !(m11971c && m11971c2 && this.f727b.equals(cif.f727b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = cif.d();
        if ((d2 || d3) && !(d2 && d3 && this.f729c.equals(cif.f729c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = cif.e();
        if (((e2 || e3) && !(e2 && e3 && this.f730d.equals(cif.f730d))) || this.f726a != cif.f726a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = cif.g();
        if ((g2 || g3) && !(g2 && g3 && this.f731e.equals(cif.f731e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = cif.h();
        if ((h2 || h3) && !(h2 && h3 && this.f725a.equals(cif.f725a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = cif.i();
        if ((i2 || i3) && !(i2 && i3 && this.f732f.equals(cif.f732f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = cif.j();
        if ((j2 || j3) && !(j2 && j3 && this.f733g.equals(cif.f733g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = cif.k();
        if ((k2 || k3) && !(k2 && k3 && this.f734h.equals(cif.f734h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = cif.l();
        if ((l2 || l3) && !(l2 && l3 && this.f735i.equals(cif.f735i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = cif.m();
        if ((m2 || m3) && !(m2 && m3 && this.f723a.equals(cif.f723a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = cif.n();
        if ((n2 || n3) && !(n2 && n3 && this.f720a == cif.f720a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = cif.o();
        if (o2 || o3) {
            return o2 && o3 && this.f728b == cif.f728b;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m11969a() {
        a(is.a(this.f723a));
        return this.f723a.array();
    }

    public Cif b(String str) {
        this.f729c = str;
        return this;
    }

    public String b() {
        return this.f729c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11965a();
        jcVar.a(f719a);
        if (this.f722a != null && m11967a()) {
            jcVar.a(f41515a);
            jcVar.a(this.f722a);
            jcVar.b();
        }
        if (this.f721a != null && m11970b()) {
            jcVar.a(b);
            this.f721a.b(jcVar);
            jcVar.b();
        }
        if (this.f727b != null) {
            jcVar.a(f41516c);
            jcVar.a(this.f727b);
            jcVar.b();
        }
        if (this.f729c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f729c);
            jcVar.b();
        }
        if (this.f730d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f730d);
            jcVar.b();
        }
        jcVar.a(f);
        jcVar.a(this.f726a);
        jcVar.b();
        if (this.f731e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f731e);
            jcVar.b();
        }
        if (this.f725a != null && h()) {
            jcVar.a(h);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f725a.size()));
            for (Map.Entry<String, String> entry : this.f725a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f732f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f732f);
            jcVar.b();
        }
        if (this.f733g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f733g);
            jcVar.b();
        }
        if (this.f734h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f734h);
            jcVar.b();
        }
        if (this.f735i != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f735i);
            jcVar.b();
        }
        if (this.f723a != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f723a);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f720a);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f728b);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f724a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11970b() {
        return this.f721a != null;
    }

    public Cif c(String str) {
        this.f730d = str;
        return this;
    }

    public String c() {
        return this.f732f;
    }

    public void c(boolean z) {
        this.f724a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m11971c() {
        return this.f727b != null;
    }

    public Cif d(String str) {
        this.f732f = str;
        return this;
    }

    public boolean d() {
        return this.f729c != null;
    }

    public boolean e() {
        return this.f730d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m11968a((Cif) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f724a.get(0);
    }

    public boolean g() {
        return this.f731e != null;
    }

    public boolean h() {
        return this.f725a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f732f != null;
    }

    public boolean j() {
        return this.f733g != null;
    }

    public boolean k() {
        return this.f734h != null;
    }

    public boolean l() {
        return this.f735i != null;
    }

    public boolean m() {
        return this.f723a != null;
    }

    public boolean n() {
        return this.f724a.get(1);
    }

    public boolean o() {
        return this.f724a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        if (m11967a()) {
            sb.append("debug:");
            String str = this.f722a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m11970b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f721a;
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
        String str2 = this.f727b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f729c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f730d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f726a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f731e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f725a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f732f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f733g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f734h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f735i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f723a;
            if (byteBuffer == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                is.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f720a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f728b);
        }
        sb.append(")");
        return sb.toString();
    }
}
