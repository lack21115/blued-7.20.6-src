package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ic.class */
public class ic implements ir<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hg f659a;

    /* renamed from: a  reason: collision with other field name */
    public ht f660a;

    /* renamed from: a  reason: collision with other field name */
    public hv f661a;

    /* renamed from: a  reason: collision with other field name */
    public String f662a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f663a;

    /* renamed from: b  reason: collision with other field name */
    public String f666b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f658a = new jh("XmPushActionContainer");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27820a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 2, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27821c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 11, 6);
    private static final iz g = new iz("", (byte) 12, 7);
    private static final iz h = new iz("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f664a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f665a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f667b = true;

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
            int compareTo = Boolean.valueOf(m8899a()).compareTo(Boolean.valueOf(icVar.m8899a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8899a() || (a9 = is.a(this.f659a, icVar.f659a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(icVar.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a8 = is.a(this.f665a, icVar.f665a)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a7 = is.a(this.f667b, icVar.f667b)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a6 = is.a(this.f663a, icVar.f663a)) == 0) {
                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!f() || (a5 = is.a(this.f662a, icVar.f662a)) == 0) {
                                int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!g() || (a4 = is.a(this.f666b, icVar.f666b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a3 = is.a(this.f661a, icVar.f661a)) == 0) {
                                        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!i() || (a2 = is.a(this.f660a, icVar.f660a)) == 0) {
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
        return this.f659a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m8895a() {
        return this.f660a;
    }

    public ic a(hg hgVar) {
        this.f659a = hgVar;
        return this;
    }

    public ic a(ht htVar) {
        this.f660a = htVar;
        return this;
    }

    public ic a(hv hvVar) {
        this.f661a = hvVar;
        return this;
    }

    public ic a(String str) {
        this.f662a = str;
        return this;
    }

    public ic a(ByteBuffer byteBuffer) {
        this.f663a = byteBuffer;
        return this;
    }

    public ic a(boolean z) {
        this.f665a = z;
        m8898a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8896a() {
        return this.f662a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8897a() {
        if (this.f659a == null) {
            throw new jd("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f663a == null) {
            throw new jd("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f661a != null) {
        } else {
            throw new jd("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                if (!c()) {
                    throw new jd("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m8897a();
                    return;
                } else {
                    throw new jd("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (mo8982a.f840a) {
                case 1:
                    if (mo8982a.f27852a == 8) {
                        this.f659a = hg.a(jcVar.mo8980a());
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 2) {
                        this.f665a = jcVar.mo8992a();
                        m8898a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 2) {
                        this.f667b = jcVar.mo8992a();
                        m8902b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f663a = jcVar.mo8988a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 11) {
                        this.f662a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 11) {
                        this.f666b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f661a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 12) {
                        ht htVar = new ht();
                        this.f660a = htVar;
                        htVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
            }
            jf.a(jcVar, mo8982a.f27852a);
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8898a(boolean z) {
        this.f664a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8899a() {
        return this.f659a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8900a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m8899a = m8899a();
        boolean m8899a2 = icVar.m8899a();
        if (((!m8899a && !m8899a2) || (m8899a && m8899a2 && this.f659a.equals(icVar.f659a))) && this.f665a == icVar.f665a && this.f667b == icVar.f667b) {
            boolean e2 = e();
            boolean e3 = icVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f663a.equals(icVar.f663a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = icVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f662a.equals(icVar.f662a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = icVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f666b.equals(icVar.f666b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = icVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f661a.m8859a(icVar.f661a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = icVar.i();
            if (i || i2) {
                return i && i2 && this.f660a.m8849a(icVar.f660a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m8901a() {
        a(is.a(this.f663a));
        return this.f663a.array();
    }

    public ic b(String str) {
        this.f666b = str;
        return this;
    }

    public ic b(boolean z) {
        this.f667b = z;
        m8902b(true);
        return this;
    }

    public String b() {
        return this.f666b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8897a();
        jcVar.a(f658a);
        if (this.f659a != null) {
            jcVar.a(f27820a);
            jcVar.mo8991a(this.f659a.a());
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f665a);
        jcVar.b();
        jcVar.a(f27821c);
        jcVar.a(this.f667b);
        jcVar.b();
        if (this.f663a != null) {
            jcVar.a(d);
            jcVar.a(this.f663a);
            jcVar.b();
        }
        if (this.f662a != null && f()) {
            jcVar.a(e);
            jcVar.a(this.f662a);
            jcVar.b();
        }
        if (this.f666b != null && g()) {
            jcVar.a(f);
            jcVar.a(this.f666b);
            jcVar.b();
        }
        if (this.f661a != null) {
            jcVar.a(g);
            this.f661a.b(jcVar);
            jcVar.b();
        }
        if (this.f660a != null && i()) {
            jcVar.a(h);
            this.f660a.b(jcVar);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m8902b(boolean z) {
        this.f664a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8903b() {
        return this.f665a;
    }

    public boolean c() {
        return this.f664a.get(0);
    }

    public boolean d() {
        return this.f664a.get(1);
    }

    public boolean e() {
        return this.f663a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m8900a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f662a != null;
    }

    public boolean g() {
        return this.f666b != null;
    }

    public boolean h() {
        return this.f661a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f660a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        hg hgVar = this.f659a;
        if (hgVar == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(hgVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f665a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f667b);
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f662a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f666b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        hv hvVar = this.f661a;
        if (hvVar == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(hvVar);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            ht htVar = this.f660a;
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
