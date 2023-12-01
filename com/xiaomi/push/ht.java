package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ht.class */
public class ht implements ir<ht, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f614a;

    /* renamed from: a  reason: collision with other field name */
    public long f615a;

    /* renamed from: a  reason: collision with other field name */
    public String f616a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f617a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f618a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f619a;

    /* renamed from: b  reason: collision with other field name */
    public int f620b;

    /* renamed from: b  reason: collision with other field name */
    public String f621b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f622b;

    /* renamed from: c  reason: collision with other field name */
    public int f623c;

    /* renamed from: c  reason: collision with other field name */
    public String f624c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f625c;

    /* renamed from: d  reason: collision with other field name */
    public String f626d;

    /* renamed from: e  reason: collision with other field name */
    public String f627e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f613a = new jh("PushMetaInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41493a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 10, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41494c = new iz("", (byte) 11, 3);
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
        this.f617a = new BitSet(5);
        this.f619a = false;
    }

    public ht(ht htVar) {
        BitSet bitSet = new BitSet(5);
        this.f617a = bitSet;
        bitSet.clear();
        this.f617a.or(htVar.f617a);
        if (htVar.m11898a()) {
            this.f616a = htVar.f616a;
        }
        this.f615a = htVar.f615a;
        if (htVar.m11904c()) {
            this.f621b = htVar.f621b;
        }
        if (htVar.m11905d()) {
            this.f624c = htVar.f624c;
        }
        if (htVar.e()) {
            this.f626d = htVar.f626d;
        }
        this.f614a = htVar.f614a;
        if (htVar.g()) {
            this.f627e = htVar.f627e;
        }
        this.f620b = htVar.f620b;
        this.f623c = htVar.f623c;
        if (htVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : htVar.f618a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f618a = hashMap;
        }
        if (htVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : htVar.f622b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f622b = hashMap2;
        }
        this.f619a = htVar.f619a;
        if (htVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : htVar.f625c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f625c = hashMap3;
        }
    }

    public int a() {
        return this.f614a;
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
            int compareTo = Boolean.valueOf(m11898a()).compareTo(Boolean.valueOf(htVar.m11898a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11898a() || (a14 = is.a(this.f616a, htVar.f616a)) == 0) {
                int compareTo2 = Boolean.valueOf(m11902b()).compareTo(Boolean.valueOf(htVar.m11902b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m11902b() || (a13 = is.a(this.f615a, htVar.f615a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m11904c()).compareTo(Boolean.valueOf(htVar.m11904c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m11904c() || (a12 = is.a(this.f621b, htVar.f621b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m11905d()).compareTo(Boolean.valueOf(htVar.m11905d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m11905d() || (a11 = is.a(this.f624c, htVar.f624c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(htVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a10 = is.a(this.f626d, htVar.f626d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(htVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a9 = is.a(this.f614a, htVar.f614a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(htVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a8 = is.a(this.f627e, htVar.f627e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(htVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a7 = is.a(this.f620b, htVar.f620b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(htVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a6 = is.a(this.f623c, htVar.f623c)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(htVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a5 = is.a(this.f618a, htVar.f618a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(htVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a4 = is.a(this.f622b, htVar.f622b)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(htVar.m()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!m() || (a3 = is.a(this.f619a, htVar.f619a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(htVar.n()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!n() || (a2 = is.a(this.f625c, htVar.f625c)) == 0) {
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
    public long m11893a() {
        return this.f615a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m11894a() {
        return new ht(this);
    }

    public ht a(int i2) {
        this.f614a = i2;
        b(true);
        return this;
    }

    public ht a(String str) {
        this.f616a = str;
        return this;
    }

    public ht a(Map<String, String> map) {
        this.f618a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11895a() {
        return this.f616a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m11896a() {
        return this.f618a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11897a() {
        if (this.f616a != null) {
            return;
        }
        throw new jd("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                if (m11902b()) {
                    m11897a();
                    return;
                }
                throw new jd("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f616a = jcVar.mo12037a();
                        break;
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 2:
                    if (mo12032a.f41543a == 10) {
                        this.f615a = jcVar.mo12031a();
                        a(true);
                        break;
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f621b = jcVar.mo12037a();
                        break;
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f624c = jcVar.mo12037a();
                        break;
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f626d = jcVar.mo12037a();
                        break;
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 6:
                    if (mo12032a.f41543a == 8) {
                        this.f614a = jcVar.mo12030a();
                        b(true);
                        break;
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f627e = jcVar.mo12037a();
                        break;
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 8:
                    if (mo12032a.f41543a == 8) {
                        this.f620b = jcVar.mo12030a();
                        c(true);
                        break;
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 9:
                    if (mo12032a.f41543a == 8) {
                        this.f623c = jcVar.mo12030a();
                        d(true);
                        break;
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 10:
                    if (mo12032a.f41543a == 13) {
                        jb mo12034a = jcVar.mo12034a();
                        this.f618a = new HashMap(mo12034a.f890a * 2);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= mo12034a.f890a) {
                                jcVar.h();
                                break;
                            } else {
                                this.f618a.put(jcVar.mo12037a(), jcVar.mo12037a());
                                i2 = i3 + 1;
                            }
                        }
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 11:
                    if (mo12032a.f41543a == 13) {
                        jb mo12034a2 = jcVar.mo12034a();
                        this.f622b = new HashMap(mo12034a2.f890a * 2);
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= mo12034a2.f890a) {
                                jcVar.h();
                                break;
                            } else {
                                this.f622b.put(jcVar.mo12037a(), jcVar.mo12037a());
                                i4 = i5 + 1;
                            }
                        }
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 12:
                    if (mo12032a.f41543a == 2) {
                        this.f619a = jcVar.mo12042a();
                        e(true);
                        break;
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                case 13:
                    if (mo12032a.f41543a == 13) {
                        jb mo12034a3 = jcVar.mo12034a();
                        this.f625c = new HashMap(mo12034a3.f890a * 2);
                        for (int i6 = 0; i6 < mo12034a3.f890a; i6++) {
                            this.f625c.put(jcVar.mo12037a(), jcVar.mo12037a());
                        }
                        jcVar.h();
                        break;
                    }
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
                default:
                    jf.a(jcVar, mo12032a.f41543a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f618a == null) {
            this.f618a = new HashMap();
        }
        this.f618a.put(str, str2);
    }

    public void a(boolean z) {
        this.f617a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11898a() {
        return this.f616a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11899a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        boolean m11898a = m11898a();
        boolean m11898a2 = htVar.m11898a();
        if (((m11898a || m11898a2) && !(m11898a && m11898a2 && this.f616a.equals(htVar.f616a))) || this.f615a != htVar.f615a) {
            return false;
        }
        boolean m11904c = m11904c();
        boolean m11904c2 = htVar.m11904c();
        if ((m11904c || m11904c2) && !(m11904c && m11904c2 && this.f621b.equals(htVar.f621b))) {
            return false;
        }
        boolean m11905d = m11905d();
        boolean m11905d2 = htVar.m11905d();
        if ((m11905d || m11905d2) && !(m11905d && m11905d2 && this.f624c.equals(htVar.f624c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = htVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f626d.equals(htVar.f626d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = htVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f614a == htVar.f614a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = htVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f627e.equals(htVar.f627e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = htVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f620b == htVar.f620b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = htVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f623c == htVar.f623c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = htVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f618a.equals(htVar.f618a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = htVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f622b.equals(htVar.f622b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = htVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f619a == htVar.f619a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = htVar.n();
        if (n || n2) {
            return n && n2 && this.f625c.equals(htVar.f625c);
        }
        return true;
    }

    public int b() {
        return this.f620b;
    }

    public ht b(int i2) {
        this.f620b = i2;
        c(true);
        return this;
    }

    public ht b(String str) {
        this.f621b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m11900b() {
        return this.f621b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m11901b() {
        return this.f622b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11897a();
        jcVar.a(f613a);
        if (this.f616a != null) {
            jcVar.a(f41493a);
            jcVar.a(this.f616a);
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f615a);
        jcVar.b();
        if (this.f621b != null && m11904c()) {
            jcVar.a(f41494c);
            jcVar.a(this.f621b);
            jcVar.b();
        }
        if (this.f624c != null && m11905d()) {
            jcVar.a(d);
            jcVar.a(this.f624c);
            jcVar.b();
        }
        if (this.f626d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f626d);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.mo12041a(this.f614a);
            jcVar.b();
        }
        if (this.f627e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f627e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.mo12041a(this.f620b);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.mo12041a(this.f623c);
            jcVar.b();
        }
        if (this.f618a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f618a.size()));
            for (Map.Entry<String, String> entry : this.f618a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f622b != null && k()) {
            jcVar.a(k);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f622b.size()));
            for (Map.Entry<String, String> entry2 : this.f622b.entrySet()) {
                jcVar.a(entry2.getKey());
                jcVar.a(entry2.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (m()) {
            jcVar.a(l);
            jcVar.a(this.f619a);
            jcVar.b();
        }
        if (this.f625c != null && n()) {
            jcVar.a(m);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f625c.size()));
            for (Map.Entry<String, String> entry3 : this.f625c.entrySet()) {
                jcVar.a(entry3.getKey());
                jcVar.a(entry3.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(String str, String str2) {
        if (this.f622b == null) {
            this.f622b = new HashMap();
        }
        this.f622b.put(str, str2);
    }

    public void b(boolean z) {
        this.f617a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11902b() {
        return this.f617a.get(0);
    }

    public int c() {
        return this.f623c;
    }

    public ht c(int i2) {
        this.f623c = i2;
        d(true);
        return this;
    }

    public ht c(String str) {
        this.f624c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m11903c() {
        return this.f624c;
    }

    public void c(boolean z) {
        this.f617a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m11904c() {
        return this.f621b != null;
    }

    public ht d(String str) {
        this.f626d = str;
        return this;
    }

    public String d() {
        return this.f626d;
    }

    public void d(boolean z) {
        this.f617a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m11905d() {
        return this.f624c != null;
    }

    public void e(boolean z) {
        this.f617a.set(4, z);
    }

    public boolean e() {
        return this.f626d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ht)) {
            return m11899a((ht) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f617a.get(1);
    }

    public boolean g() {
        return this.f627e != null;
    }

    public boolean h() {
        return this.f617a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f617a.get(3);
    }

    public boolean j() {
        return this.f618a != null;
    }

    public boolean k() {
        return this.f622b != null;
    }

    public boolean l() {
        return this.f619a;
    }

    public boolean m() {
        return this.f617a.get(4);
    }

    public boolean n() {
        return this.f625c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f616a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f615a);
        if (m11904c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f621b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
        }
        if (m11905d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f624c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f626d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f614a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f627e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f620b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f623c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f618a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f622b;
            if (map2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f619a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f625c;
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
