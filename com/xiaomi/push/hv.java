package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hv.class */
public class hv implements ir<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f585a;

    /* renamed from: d  reason: collision with other field name */
    public String f590d;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f583a = new jh("Target");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27806a = new iz("", (byte) 10, 1);
    private static final iz b = new iz("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27807c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 2, 5);
    private static final iz f = new iz("", (byte) 11, 7);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f586a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f584a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f588b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f589c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f587a = false;

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
            int compareTo = Boolean.valueOf(m8858a()).compareTo(Boolean.valueOf(hvVar.m8858a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8858a() || (a7 = is.a(this.f584a, hvVar.f584a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a6 = is.a(this.f585a, hvVar.f585a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a5 = is.a(this.f588b, hvVar.f588b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hvVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a4 = is.a(this.f589c, hvVar.f589c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hvVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a3 = is.a(this.f587a, hvVar.f587a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hvVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a2 = is.a(this.f590d, hvVar.f590d)) == 0) {
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
        if (this.f585a != null) {
            return;
        }
        throw new jd("Required field 'userId' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                break;
            }
            short s = mo8982a.f840a;
            if (s == 1) {
                if (mo8982a.f27852a == 10) {
                    this.f584a = jcVar.mo8981a();
                    a(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else if (s == 2) {
                if (mo8982a.f27852a == 11) {
                    this.f585a = jcVar.mo8987a();
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else if (s == 3) {
                if (mo8982a.f27852a == 11) {
                    this.f588b = jcVar.mo8987a();
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else if (s == 4) {
                if (mo8982a.f27852a == 11) {
                    this.f589c = jcVar.mo8987a();
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else if (s != 5) {
                if (s == 7 && mo8982a.f27852a == 11) {
                    this.f590d = jcVar.mo8987a();
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else {
                if (mo8982a.f27852a == 2) {
                    this.f587a = jcVar.mo8992a();
                    b(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            }
        }
        jcVar.f();
        if (m8858a()) {
            a();
            return;
        }
        throw new jd("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f586a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8858a() {
        return this.f586a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8859a(hv hvVar) {
        if (hvVar != null && this.f584a == hvVar.f584a) {
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f585a.equals(hvVar.f585a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f588b.equals(hvVar.f588b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hvVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f589c.equals(hvVar.f589c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hvVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f587a == hvVar.f587a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hvVar.f();
            if (f2 || f3) {
                return f2 && f3 && this.f590d.equals(hvVar.f590d);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f583a);
        jcVar.a(f27806a);
        jcVar.a(this.f584a);
        jcVar.b();
        if (this.f585a != null) {
            jcVar.a(b);
            jcVar.a(this.f585a);
            jcVar.b();
        }
        if (this.f588b != null && c()) {
            jcVar.a(f27807c);
            jcVar.a(this.f588b);
            jcVar.b();
        }
        if (this.f589c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f589c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f587a);
            jcVar.b();
        }
        if (this.f590d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f590d);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f586a.set(1, z);
    }

    public boolean b() {
        return this.f585a != null;
    }

    public boolean c() {
        return this.f588b != null;
    }

    public boolean d() {
        return this.f589c != null;
    }

    public boolean e() {
        return this.f586a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m8859a((hv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f590d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f584a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f585a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f588b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f589c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f587a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f590d;
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
