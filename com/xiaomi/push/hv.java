package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hv.class */
public class hv implements ir<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f632a;

    /* renamed from: d  reason: collision with other field name */
    public String f637d;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f630a = new jh("Target");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41497a = new iz("", (byte) 10, 1);
    private static final iz b = new iz("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41498c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 2, 5);
    private static final iz f = new iz("", (byte) 11, 7);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f633a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f631a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f635b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f636c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f634a = false;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hv hvVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (getClass().equals(hvVar.getClass())) {
            int compareTo = Boolean.valueOf(m11908a()).compareTo(Boolean.valueOf(hvVar.m11908a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11908a() || (a7 = is.a(this.f631a, hvVar.f631a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a6 = is.a(this.f632a, hvVar.f632a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a5 = is.a(this.f635b, hvVar.f635b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hvVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a4 = is.a(this.f636c, hvVar.f636c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hvVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a3 = is.a(this.f634a, hvVar.f634a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hvVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a2 = is.a(this.f637d, hvVar.f637d)) == 0) {
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
        return getClass().getName().compareTo(hvVar.getClass().getName());
    }

    public void a() {
        if (this.f632a != null) {
            return;
        }
        throw new jd("Required field 'userId' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                break;
            }
            short s = mo12032a.f887a;
            if (s == 1) {
                if (mo12032a.f41543a == 10) {
                    this.f631a = jcVar.mo12031a();
                    a(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else if (s == 2) {
                if (mo12032a.f41543a == 11) {
                    this.f632a = jcVar.mo12037a();
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else if (s == 3) {
                if (mo12032a.f41543a == 11) {
                    this.f635b = jcVar.mo12037a();
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else if (s == 4) {
                if (mo12032a.f41543a == 11) {
                    this.f636c = jcVar.mo12037a();
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else if (s != 5) {
                if (s == 7 && mo12032a.f41543a == 11) {
                    this.f637d = jcVar.mo12037a();
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else {
                if (mo12032a.f41543a == 2) {
                    this.f634a = jcVar.mo12042a();
                    b(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            }
        }
        jcVar.f();
        if (m11908a()) {
            a();
            return;
        }
        throw new jd("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f633a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11908a() {
        return this.f633a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11909a(hv hvVar) {
        if (hvVar != null && this.f631a == hvVar.f631a) {
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f632a.equals(hvVar.f632a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f635b.equals(hvVar.f635b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hvVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f636c.equals(hvVar.f636c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hvVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f634a == hvVar.f634a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hvVar.f();
            if (f2 || f3) {
                return f2 && f3 && this.f637d.equals(hvVar.f637d);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f630a);
        jcVar.a(f41497a);
        jcVar.a(this.f631a);
        jcVar.b();
        if (this.f632a != null) {
            jcVar.a(b);
            jcVar.a(this.f632a);
            jcVar.b();
        }
        if (this.f635b != null && c()) {
            jcVar.a(f41498c);
            jcVar.a(this.f635b);
            jcVar.b();
        }
        if (this.f636c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f636c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f634a);
            jcVar.b();
        }
        if (this.f637d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f637d);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f633a.set(1, z);
    }

    public boolean b() {
        return this.f632a != null;
    }

    public boolean c() {
        return this.f635b != null;
    }

    public boolean d() {
        return this.f636c != null;
    }

    public boolean e() {
        return this.f633a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m11909a((hv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f637d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f631a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f632a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f635b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f636c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f634a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f637d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
