package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ia.class */
public class ia implements ir<ia, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f682a;

    /* renamed from: a  reason: collision with other field name */
    public hv f683a;

    /* renamed from: a  reason: collision with other field name */
    public String f684a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f686a;

    /* renamed from: b  reason: collision with other field name */
    public String f688b;

    /* renamed from: c  reason: collision with other field name */
    public String f690c;

    /* renamed from: d  reason: collision with other field name */
    public String f691d;

    /* renamed from: e  reason: collision with other field name */
    public String f692e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f681a = new jh("XmPushActionCommand");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41507a = new iz("", (byte) 12, 2);
    private static final iz b = new iz("", (byte) 11, 3);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41508c = new iz("", (byte) 11, 4);
    private static final iz d = new iz("", (byte) 11, 5);
    private static final iz e = new iz("", (byte) 15, 6);
    private static final iz f = new iz("", (byte) 11, 7);
    private static final iz g = new iz("", (byte) 11, 9);
    private static final iz h = new iz("", (byte) 2, 10);
    private static final iz i = new iz("", (byte) 2, 11);
    private static final iz j = new iz("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f685a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f687a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f689b = true;

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
            int compareTo = Boolean.valueOf(m11935a()).compareTo(Boolean.valueOf(iaVar.m11935a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11935a() || (a11 = is.a(this.f683a, iaVar.f683a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iaVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = is.a(this.f684a, iaVar.f684a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iaVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = is.a(this.f688b, iaVar.f688b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = is.a(this.f690c, iaVar.f690c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = is.a(this.f686a, iaVar.f686a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = is.a(this.f691d, iaVar.f691d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = is.a(this.f692e, iaVar.f692e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = is.a(this.f687a, iaVar.f687a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = is.a(this.f689b, iaVar.f689b)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = is.a(this.f682a, iaVar.f682a)) == 0) {
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
        this.f684a = str;
        return this;
    }

    public String a() {
        return this.f690c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11933a() {
        if (this.f684a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f688b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f690c != null) {
        } else {
            throw new jd("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                m11933a();
                return;
            }
            switch (mo12032a.f887a) {
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f683a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f684a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f688b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f690c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 15) {
                        ja mo12033a = jcVar.mo12033a();
                        this.f686a = new ArrayList(mo12033a.f889a);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < mo12033a.f889a) {
                                this.f686a.add(jcVar.mo12037a());
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
                    if (mo12032a.f41543a == 11) {
                        this.f691d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 11) {
                        this.f692e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 2) {
                        this.f687a = jcVar.mo12042a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 11:
                    if (mo12032a.f41543a == 2) {
                        this.f689b = jcVar.mo12042a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo12032a.f41543a == 10) {
                        this.f682a = jcVar.mo12031a();
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

    /* renamed from: a  reason: collision with other method in class */
    public void m11934a(String str) {
        if (this.f686a == null) {
            this.f686a = new ArrayList();
        }
        this.f686a.add(str);
    }

    public void a(boolean z) {
        this.f685a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11935a() {
        return this.f683a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11936a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean m11935a = m11935a();
        boolean m11935a2 = iaVar.m11935a();
        if ((m11935a || m11935a2) && !(m11935a && m11935a2 && this.f683a.m11909a(iaVar.f683a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iaVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f684a.equals(iaVar.f684a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iaVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f688b.equals(iaVar.f688b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iaVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f690c.equals(iaVar.f690c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iaVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f686a.equals(iaVar.f686a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iaVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f691d.equals(iaVar.f691d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iaVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f692e.equals(iaVar.f692e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iaVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f687a == iaVar.f687a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iaVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f689b == iaVar.f689b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iaVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f682a == iaVar.f682a;
        }
        return true;
    }

    public ia b(String str) {
        this.f688b = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11933a();
        jcVar.a(f681a);
        if (this.f683a != null && m11935a()) {
            jcVar.a(f41507a);
            this.f683a.b(jcVar);
            jcVar.b();
        }
        if (this.f684a != null) {
            jcVar.a(b);
            jcVar.a(this.f684a);
            jcVar.b();
        }
        if (this.f688b != null) {
            jcVar.a(f41508c);
            jcVar.a(this.f688b);
            jcVar.b();
        }
        if (this.f690c != null) {
            jcVar.a(d);
            jcVar.a(this.f690c);
            jcVar.b();
        }
        if (this.f686a != null && e()) {
            jcVar.a(e);
            jcVar.a(new ja((byte) 11, this.f686a.size()));
            for (String str : this.f686a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f691d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f691d);
            jcVar.b();
        }
        if (this.f692e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f692e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f687a);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f689b);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f682a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f685a.set(1, z);
    }

    public boolean b() {
        return this.f684a != null;
    }

    public ia c(String str) {
        this.f690c = str;
        return this;
    }

    public void c(boolean z) {
        this.f685a.set(2, z);
    }

    public boolean c() {
        return this.f688b != null;
    }

    public ia d(String str) {
        this.f691d = str;
        return this;
    }

    public boolean d() {
        return this.f690c != null;
    }

    public ia e(String str) {
        this.f692e = str;
        return this;
    }

    public boolean e() {
        return this.f686a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return m11936a((ia) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f691d != null;
    }

    public boolean g() {
        return this.f692e != null;
    }

    public boolean h() {
        return this.f685a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f685a.get(1);
    }

    public boolean j() {
        return this.f685a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m11935a()) {
            sb.append("target:");
            hv hvVar = this.f683a;
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
        String str = this.f684a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f688b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f690c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f686a;
            if (list == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f691d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f692e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f687a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f689b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f682a);
        }
        sb.append(")");
        return sb.toString();
    }
}
