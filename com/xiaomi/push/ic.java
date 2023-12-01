package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ic.class */
public class ic implements ir<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hg f706a;

    /* renamed from: a  reason: collision with other field name */
    public ht f707a;

    /* renamed from: a  reason: collision with other field name */
    public hv f708a;

    /* renamed from: a  reason: collision with other field name */
    public String f709a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f710a;

    /* renamed from: b  reason: collision with other field name */
    public String f713b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f705a = new jh("XmPushActionContainer");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41511a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 2, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41512c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 11, 6);
    private static final iz g = new iz("", (byte) 12, 7);
    private static final iz h = new iz("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f711a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f712a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f714b = true;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ic icVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(icVar.getClass())) {
            int compareTo = Boolean.valueOf(m11949a()).compareTo(Boolean.valueOf(icVar.m11949a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11949a() || (a9 = is.a(this.f706a, icVar.f706a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(icVar.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a8 = is.a(this.f712a, icVar.f712a)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a7 = is.a(this.f714b, icVar.f714b)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a6 = is.a(this.f710a, icVar.f710a)) == 0) {
                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!f() || (a5 = is.a(this.f709a, icVar.f709a)) == 0) {
                                int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!g() || (a4 = is.a(this.f713b, icVar.f713b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a3 = is.a(this.f708a, icVar.f708a)) == 0) {
                                        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!i() || (a2 = is.a(this.f707a, icVar.f707a)) == 0) {
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
        return getClass().getName().compareTo(icVar.getClass().getName());
    }

    public hg a() {
        return this.f706a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m11945a() {
        return this.f707a;
    }

    public ic a(hg hgVar) {
        this.f706a = hgVar;
        return this;
    }

    public ic a(ht htVar) {
        this.f707a = htVar;
        return this;
    }

    public ic a(hv hvVar) {
        this.f708a = hvVar;
        return this;
    }

    public ic a(String str) {
        this.f709a = str;
        return this;
    }

    public ic a(ByteBuffer byteBuffer) {
        this.f710a = byteBuffer;
        return this;
    }

    public ic a(boolean z) {
        this.f712a = z;
        m11948a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11946a() {
        return this.f709a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11947a() {
        if (this.f706a == null) {
            throw new jd("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f710a == null) {
            throw new jd("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f708a != null) {
        } else {
            throw new jd("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                if (!c()) {
                    throw new jd("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m11947a();
                    return;
                } else {
                    throw new jd("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (mo12032a.f887a) {
                case 1:
                    if (mo12032a.f41543a == 8) {
                        this.f706a = hg.a(jcVar.mo12030a());
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 2) {
                        this.f712a = jcVar.mo12042a();
                        m11948a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 2) {
                        this.f714b = jcVar.mo12042a();
                        m11952b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f710a = jcVar.mo12038a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f709a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 11) {
                        this.f713b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f708a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 12) {
                        ht htVar = new ht();
                        this.f707a = htVar;
                        htVar.a(jcVar);
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
    public void m11948a(boolean z) {
        this.f711a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11949a() {
        return this.f706a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11950a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m11949a = m11949a();
        boolean m11949a2 = icVar.m11949a();
        if (((!m11949a && !m11949a2) || (m11949a && m11949a2 && this.f706a.equals(icVar.f706a))) && this.f712a == icVar.f712a && this.f714b == icVar.f714b) {
            boolean e2 = e();
            boolean e3 = icVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f710a.equals(icVar.f710a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = icVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f709a.equals(icVar.f709a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = icVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f713b.equals(icVar.f713b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = icVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f708a.m11909a(icVar.f708a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = icVar.i();
            if (i || i2) {
                return i && i2 && this.f707a.m11899a(icVar.f707a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m11951a() {
        a(is.a(this.f710a));
        return this.f710a.array();
    }

    public ic b(String str) {
        this.f713b = str;
        return this;
    }

    public ic b(boolean z) {
        this.f714b = z;
        m11952b(true);
        return this;
    }

    public String b() {
        return this.f713b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11947a();
        jcVar.a(f705a);
        if (this.f706a != null) {
            jcVar.a(f41511a);
            jcVar.mo12041a(this.f706a.a());
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f712a);
        jcVar.b();
        jcVar.a(f41512c);
        jcVar.a(this.f714b);
        jcVar.b();
        if (this.f710a != null) {
            jcVar.a(d);
            jcVar.a(this.f710a);
            jcVar.b();
        }
        if (this.f709a != null && f()) {
            jcVar.a(e);
            jcVar.a(this.f709a);
            jcVar.b();
        }
        if (this.f713b != null && g()) {
            jcVar.a(f);
            jcVar.a(this.f713b);
            jcVar.b();
        }
        if (this.f708a != null) {
            jcVar.a(g);
            this.f708a.b(jcVar);
            jcVar.b();
        }
        if (this.f707a != null && i()) {
            jcVar.a(h);
            this.f707a.b(jcVar);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m11952b(boolean z) {
        this.f711a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11953b() {
        return this.f712a;
    }

    public boolean c() {
        return this.f711a.get(0);
    }

    public boolean d() {
        return this.f711a.get(1);
    }

    public boolean e() {
        return this.f710a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m11950a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f709a != null;
    }

    public boolean g() {
        return this.f713b != null;
    }

    public boolean h() {
        return this.f708a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f707a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        hg hgVar = this.f706a;
        if (hgVar == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(hgVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f712a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f714b);
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f709a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f713b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        hv hvVar = this.f708a;
        if (hvVar == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(hvVar);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            ht htVar = this.f707a;
            if (htVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(htVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
