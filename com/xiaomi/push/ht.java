package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ht.class */
public class ht implements ir<ht, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f567a;

    /* renamed from: a  reason: collision with other field name */
    public long f568a;

    /* renamed from: a  reason: collision with other field name */
    public String f569a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f570a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f571a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f572a;

    /* renamed from: b  reason: collision with other field name */
    public int f573b;

    /* renamed from: b  reason: collision with other field name */
    public String f574b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f575b;

    /* renamed from: c  reason: collision with other field name */
    public int f576c;

    /* renamed from: c  reason: collision with other field name */
    public String f577c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f578c;

    /* renamed from: d  reason: collision with other field name */
    public String f579d;

    /* renamed from: e  reason: collision with other field name */
    public String f580e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f566a = new jh("PushMetaInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27802a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 10, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27803c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 8, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 8, 8);
    private static final iz i = new iz("", (byte) 8, 9);
    private static final iz j = new iz("", (byte) 13, 10);
    private static final iz k = new iz("", (byte) 13, 11);
    private static final iz l = new iz("", (byte) 2, 12);
    private static final iz m = new iz("", (byte) 13, 13);

    public ht() {
        this.f570a = new BitSet(5);
        this.f572a = false;
    }

    public ht(ht htVar) {
        BitSet bitSet = new BitSet(5);
        this.f570a = bitSet;
        bitSet.clear();
        this.f570a.or(htVar.f570a);
        if (htVar.m8848a()) {
            this.f569a = htVar.f569a;
        }
        this.f568a = htVar.f568a;
        if (htVar.m8854c()) {
            this.f574b = htVar.f574b;
        }
        if (htVar.m8855d()) {
            this.f577c = htVar.f577c;
        }
        if (htVar.e()) {
            this.f579d = htVar.f579d;
        }
        this.f567a = htVar.f567a;
        if (htVar.g()) {
            this.f580e = htVar.f580e;
        }
        this.f573b = htVar.f573b;
        this.f576c = htVar.f576c;
        if (htVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : htVar.f571a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f571a = hashMap;
        }
        if (htVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : htVar.f575b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f575b = hashMap2;
        }
        this.f572a = htVar.f572a;
        if (htVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : htVar.f578c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f578c = hashMap3;
        }
    }

    public int a() {
        return this.f567a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ht htVar) {
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
        if (getClass().equals(htVar.getClass())) {
            int compareTo = Boolean.valueOf(m8848a()).compareTo(Boolean.valueOf(htVar.m8848a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8848a() || (a14 = is.a(this.f569a, htVar.f569a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8852b()).compareTo(Boolean.valueOf(htVar.m8852b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8852b() || (a13 = is.a(this.f568a, htVar.f568a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m8854c()).compareTo(Boolean.valueOf(htVar.m8854c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m8854c() || (a12 = is.a(this.f574b, htVar.f574b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m8855d()).compareTo(Boolean.valueOf(htVar.m8855d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m8855d() || (a11 = is.a(this.f577c, htVar.f577c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(htVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a10 = is.a(this.f579d, htVar.f579d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(htVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a9 = is.a(this.f567a, htVar.f567a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(htVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a8 = is.a(this.f580e, htVar.f580e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(htVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a7 = is.a(this.f573b, htVar.f573b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(htVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a6 = is.a(this.f576c, htVar.f576c)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(htVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a5 = is.a(this.f571a, htVar.f571a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(htVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a4 = is.a(this.f575b, htVar.f575b)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(htVar.m()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!m() || (a3 = is.a(this.f572a, htVar.f572a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(htVar.n()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!n() || (a2 = is.a(this.f578c, htVar.f578c)) == 0) {
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
        return getClass().getName().compareTo(htVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m8843a() {
        return this.f568a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m8844a() {
        return new ht(this);
    }

    public ht a(int i2) {
        this.f567a = i2;
        b(true);
        return this;
    }

    public ht a(String str) {
        this.f569a = str;
        return this;
    }

    public ht a(Map<String, String> map) {
        this.f571a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8845a() {
        return this.f569a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m8846a() {
        return this.f571a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8847a() {
        if (this.f569a != null) {
            return;
        }
        throw new jd("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                if (m8852b()) {
                    m8847a();
                    return;
                }
                throw new jd("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f569a = jcVar.mo8987a();
                        break;
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 2:
                    if (mo8982a.f27852a == 10) {
                        this.f568a = jcVar.mo8981a();
                        a(true);
                        break;
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f574b = jcVar.mo8987a();
                        break;
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f577c = jcVar.mo8987a();
                        break;
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 5:
                    if (mo8982a.f27852a == 11) {
                        this.f579d = jcVar.mo8987a();
                        break;
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 6:
                    if (mo8982a.f27852a == 8) {
                        this.f567a = jcVar.mo8980a();
                        b(true);
                        break;
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f580e = jcVar.mo8987a();
                        break;
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 8:
                    if (mo8982a.f27852a == 8) {
                        this.f573b = jcVar.mo8980a();
                        c(true);
                        break;
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 9:
                    if (mo8982a.f27852a == 8) {
                        this.f576c = jcVar.mo8980a();
                        d(true);
                        break;
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 10:
                    if (mo8982a.f27852a == 13) {
                        jb mo8984a = jcVar.mo8984a();
                        this.f571a = new HashMap(mo8984a.f843a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= mo8984a.f843a) {
                                jcVar.h();
                                break;
                            } else {
                                this.f571a.put(jcVar.mo8987a(), jcVar.mo8987a());
                                i2 = i3 + 1;
                            }
                        }
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 11:
                    if (mo8982a.f27852a == 13) {
                        jb mo8984a2 = jcVar.mo8984a();
                        this.f575b = new HashMap(mo8984a2.f843a * 2);
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= mo8984a2.f843a) {
                                jcVar.h();
                                break;
                            } else {
                                this.f575b.put(jcVar.mo8987a(), jcVar.mo8987a());
                                i4 = i5 + 1;
                            }
                        }
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 12:
                    if (mo8982a.f27852a == 2) {
                        this.f572a = jcVar.mo8992a();
                        e(true);
                        break;
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                case 13:
                    if (mo8982a.f27852a == 13) {
                        jb mo8984a3 = jcVar.mo8984a();
                        this.f578c = new HashMap(mo8984a3.f843a * 2);
                        for (int i6 = 0; i6 < mo8984a3.f843a; i6++) {
                            this.f578c.put(jcVar.mo8987a(), jcVar.mo8987a());
                        }
                        jcVar.h();
                        break;
                    }
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
                default:
                    jf.a(jcVar, mo8982a.f27852a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f571a == null) {
            this.f571a = new HashMap();
        }
        this.f571a.put(str, str2);
    }

    public void a(boolean z) {
        this.f570a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8848a() {
        return this.f569a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8849a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        boolean m8848a = m8848a();
        boolean m8848a2 = htVar.m8848a();
        if (((m8848a || m8848a2) && !(m8848a && m8848a2 && this.f569a.equals(htVar.f569a))) || this.f568a != htVar.f568a) {
            return false;
        }
        boolean m8854c = m8854c();
        boolean m8854c2 = htVar.m8854c();
        if ((m8854c || m8854c2) && !(m8854c && m8854c2 && this.f574b.equals(htVar.f574b))) {
            return false;
        }
        boolean m8855d = m8855d();
        boolean m8855d2 = htVar.m8855d();
        if ((m8855d || m8855d2) && !(m8855d && m8855d2 && this.f577c.equals(htVar.f577c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = htVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f579d.equals(htVar.f579d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = htVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f567a == htVar.f567a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = htVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f580e.equals(htVar.f580e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = htVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f573b == htVar.f573b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = htVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f576c == htVar.f576c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = htVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f571a.equals(htVar.f571a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = htVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f575b.equals(htVar.f575b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = htVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f572a == htVar.f572a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = htVar.n();
        if (n || n2) {
            return n && n2 && this.f578c.equals(htVar.f578c);
        }
        return true;
    }

    public int b() {
        return this.f573b;
    }

    public ht b(int i2) {
        this.f573b = i2;
        c(true);
        return this;
    }

    public ht b(String str) {
        this.f574b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m8850b() {
        return this.f574b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m8851b() {
        return this.f575b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8847a();
        jcVar.a(f566a);
        if (this.f569a != null) {
            jcVar.a(f27802a);
            jcVar.a(this.f569a);
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f568a);
        jcVar.b();
        if (this.f574b != null && m8854c()) {
            jcVar.a(f27803c);
            jcVar.a(this.f574b);
            jcVar.b();
        }
        if (this.f577c != null && m8855d()) {
            jcVar.a(d);
            jcVar.a(this.f577c);
            jcVar.b();
        }
        if (this.f579d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f579d);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.mo8991a(this.f567a);
            jcVar.b();
        }
        if (this.f580e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f580e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.mo8991a(this.f573b);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.mo8991a(this.f576c);
            jcVar.b();
        }
        if (this.f571a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f571a.size()));
            for (Map.Entry<String, String> entry : this.f571a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f575b != null && k()) {
            jcVar.a(k);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f575b.size()));
            for (Map.Entry<String, String> entry2 : this.f575b.entrySet()) {
                jcVar.a(entry2.getKey());
                jcVar.a(entry2.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (m()) {
            jcVar.a(l);
            jcVar.a(this.f572a);
            jcVar.b();
        }
        if (this.f578c != null && n()) {
            jcVar.a(m);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f578c.size()));
            for (Map.Entry<String, String> entry3 : this.f578c.entrySet()) {
                jcVar.a(entry3.getKey());
                jcVar.a(entry3.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(String str, String str2) {
        if (this.f575b == null) {
            this.f575b = new HashMap();
        }
        this.f575b.put(str, str2);
    }

    public void b(boolean z) {
        this.f570a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8852b() {
        return this.f570a.get(0);
    }

    public int c() {
        return this.f576c;
    }

    public ht c(int i2) {
        this.f576c = i2;
        d(true);
        return this;
    }

    public ht c(String str) {
        this.f577c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m8853c() {
        return this.f577c;
    }

    public void c(boolean z) {
        this.f570a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8854c() {
        return this.f574b != null;
    }

    public ht d(String str) {
        this.f579d = str;
        return this;
    }

    public String d() {
        return this.f579d;
    }

    public void d(boolean z) {
        this.f570a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m8855d() {
        return this.f577c != null;
    }

    public void e(boolean z) {
        this.f570a.set(4, z);
    }

    public boolean e() {
        return this.f579d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ht)) {
            return m8849a((ht) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f570a.get(1);
    }

    public boolean g() {
        return this.f580e != null;
    }

    public boolean h() {
        return this.f570a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f570a.get(3);
    }

    public boolean j() {
        return this.f571a != null;
    }

    public boolean k() {
        return this.f575b != null;
    }

    public boolean l() {
        return this.f572a;
    }

    public boolean m() {
        return this.f570a.get(4);
    }

    public boolean n() {
        return this.f578c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f569a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f568a);
        if (m8854c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f574b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
        }
        if (m8855d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f577c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f579d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f567a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f580e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f573b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f576c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f571a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f575b;
            if (map2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f572a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f578c;
            if (map3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
