package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ig.class */
public class ig implements ir<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f737a;

    /* renamed from: a  reason: collision with other field name */
    public long f738a;

    /* renamed from: a  reason: collision with other field name */
    public hu f739a;

    /* renamed from: a  reason: collision with other field name */
    public hv f740a;

    /* renamed from: a  reason: collision with other field name */
    public String f741a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f743a;

    /* renamed from: b  reason: collision with other field name */
    public int f745b;

    /* renamed from: b  reason: collision with other field name */
    public long f746b;

    /* renamed from: b  reason: collision with other field name */
    public String f747b;

    /* renamed from: c  reason: collision with other field name */
    public int f749c;

    /* renamed from: c  reason: collision with other field name */
    public String f750c;

    /* renamed from: d  reason: collision with other field name */
    public String f752d;

    /* renamed from: e  reason: collision with other field name */
    public String f753e;

    /* renamed from: f  reason: collision with other field name */
    public String f754f;

    /* renamed from: g  reason: collision with other field name */
    public String f755g;

    /* renamed from: h  reason: collision with other field name */
    public String f756h;

    /* renamed from: i  reason: collision with other field name */
    public String f757i;

    /* renamed from: j  reason: collision with other field name */
    public String f758j;

    /* renamed from: k  reason: collision with other field name */
    public String f759k;

    /* renamed from: l  reason: collision with other field name */
    public String f760l;

    /* renamed from: m  reason: collision with other field name */
    public String f761m;

    /* renamed from: n  reason: collision with other field name */
    public String f762n;

    /* renamed from: o  reason: collision with other field name */
    public String f763o;

    /* renamed from: p  reason: collision with other field name */
    public String f764p;

    /* renamed from: q  reason: collision with other field name */
    public String f765q;

    /* renamed from: r  reason: collision with other field name */
    public String f766r;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f736a = new jh("XmPushActionRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41517a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41518c = new iz("", (byte) 11, 3);
    private static final iz d = new iz("", (byte) 11, 4);
    private static final iz e = new iz("", (byte) 11, 5);
    private static final iz f = new iz("", (byte) 11, 6);
    private static final iz g = new iz("", (byte) 11, 7);
    private static final iz h = new iz("", (byte) 11, 8);
    private static final iz i = new iz("", (byte) 11, 9);
    private static final iz j = new iz("", (byte) 11, 10);
    private static final iz k = new iz("", (byte) 11, 11);
    private static final iz l = new iz("", (byte) 11, 12);
    private static final iz m = new iz("", (byte) 8, 13);
    private static final iz n = new iz("", (byte) 8, 14);
    private static final iz o = new iz("", (byte) 11, 15);
    private static final iz p = new iz("", (byte) 11, 16);
    private static final iz q = new iz("", (byte) 11, 17);
    private static final iz r = new iz("", (byte) 11, 18);
    private static final iz s = new iz("", (byte) 8, 19);
    private static final iz t = new iz("", (byte) 8, 20);
    private static final iz u = new iz("", (byte) 2, 21);
    private static final iz v = new iz("", (byte) 10, 22);
    private static final iz w = new iz("", (byte) 10, 23);
    private static final iz x = new iz("", (byte) 11, 24);
    private static final iz y = new iz("", (byte) 11, 25);
    private static final iz z = new iz("", (byte) 2, 26);
    private static final iz A = new iz("", (byte) 13, 100);
    private static final iz B = new iz("", (byte) 2, 101);
    private static final iz C = new iz("", (byte) 11, 102);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f742a = new BitSet(8);

    /* renamed from: a  reason: collision with other field name */
    public boolean f744a = true;

    /* renamed from: c  reason: collision with other field name */
    public boolean f751c = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f748b = false;

    public boolean A() {
        return this.f743a != null;
    }

    public boolean B() {
        return this.f742a.get(7);
    }

    public boolean C() {
        return this.f766r != null;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ig igVar) {
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
        int a17;
        int a18;
        int a19;
        int a20;
        int a21;
        int a22;
        int a23;
        int a24;
        int a25;
        int a26;
        int a27;
        int a28;
        int a29;
        int a30;
        if (getClass().equals(igVar.getClass())) {
            int compareTo = Boolean.valueOf(m11974a()).compareTo(Boolean.valueOf(igVar.m11974a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11974a() || (a30 = is.a(this.f741a, igVar.f741a)) == 0) {
                int compareTo2 = Boolean.valueOf(m11976b()).compareTo(Boolean.valueOf(igVar.m11976b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m11976b() || (a29 = is.a(this.f740a, igVar.f740a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m11977c()).compareTo(Boolean.valueOf(igVar.m11977c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m11977c() || (a28 = is.a(this.f747b, igVar.f747b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a27 = is.a(this.f750c, igVar.f750c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a26 = is.a(this.f752d, igVar.f752d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a25 = is.a(this.f753e, igVar.f753e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a24 = is.a(this.f754f, igVar.f754f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a23 = is.a(this.f755g, igVar.f755g)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a22 = is.a(this.f756h, igVar.f756h)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a21 = is.a(this.f757i, igVar.f757i)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a20 = is.a(this.f758j, igVar.f758j)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a19 = is.a(this.f759k, igVar.f759k)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a18 = is.a(this.f737a, igVar.f737a)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a17 = is.a(this.f745b, igVar.f745b)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a16 = is.a(this.f760l, igVar.f760l)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(igVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a15 = is.a(this.f761m, igVar.f761m)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(igVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a14 = is.a(this.f762n, igVar.f762n)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(igVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a13 = is.a(this.f763o, igVar.f763o)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(igVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a12 = is.a(this.f749c, igVar.f749c)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(igVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a11 = is.a(this.f739a, igVar.f739a)) == 0) {
                                                                                            int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(igVar.u()));
                                                                                            if (compareTo21 != 0) {
                                                                                                return compareTo21;
                                                                                            }
                                                                                            if (!u() || (a10 = is.a(this.f744a, igVar.f744a)) == 0) {
                                                                                                int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(igVar.v()));
                                                                                                if (compareTo22 != 0) {
                                                                                                    return compareTo22;
                                                                                                }
                                                                                                if (!v() || (a9 = is.a(this.f738a, igVar.f738a)) == 0) {
                                                                                                    int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(igVar.w()));
                                                                                                    if (compareTo23 != 0) {
                                                                                                        return compareTo23;
                                                                                                    }
                                                                                                    if (!w() || (a8 = is.a(this.f746b, igVar.f746b)) == 0) {
                                                                                                        int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(igVar.x()));
                                                                                                        if (compareTo24 != 0) {
                                                                                                            return compareTo24;
                                                                                                        }
                                                                                                        if (!x() || (a7 = is.a(this.f764p, igVar.f764p)) == 0) {
                                                                                                            int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(igVar.y()));
                                                                                                            if (compareTo25 != 0) {
                                                                                                                return compareTo25;
                                                                                                            }
                                                                                                            if (!y() || (a6 = is.a(this.f765q, igVar.f765q)) == 0) {
                                                                                                                int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(igVar.z()));
                                                                                                                if (compareTo26 != 0) {
                                                                                                                    return compareTo26;
                                                                                                                }
                                                                                                                if (!z() || (a5 = is.a(this.f748b, igVar.f748b)) == 0) {
                                                                                                                    int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(igVar.A()));
                                                                                                                    if (compareTo27 != 0) {
                                                                                                                        return compareTo27;
                                                                                                                    }
                                                                                                                    if (!A() || (a4 = is.a(this.f743a, igVar.f743a)) == 0) {
                                                                                                                        int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(igVar.B()));
                                                                                                                        if (compareTo28 != 0) {
                                                                                                                            return compareTo28;
                                                                                                                        }
                                                                                                                        if (!B() || (a3 = is.a(this.f751c, igVar.f751c)) == 0) {
                                                                                                                            int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(igVar.C()));
                                                                                                                            if (compareTo29 != 0) {
                                                                                                                                return compareTo29;
                                                                                                                            }
                                                                                                                            if (!C() || (a2 = is.a(this.f766r, igVar.f766r)) == 0) {
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
                                                                return a17;
                                                            }
                                                            return a18;
                                                        }
                                                        return a19;
                                                    }
                                                    return a20;
                                                }
                                                return a21;
                                            }
                                            return a22;
                                        }
                                        return a23;
                                    }
                                    return a24;
                                }
                                return a25;
                            }
                            return a26;
                        }
                        return a27;
                    }
                    return a28;
                }
                return a29;
            }
            return a30;
        }
        return getClass().getName().compareTo(igVar.getClass().getName());
    }

    public ig a(int i2) {
        this.f737a = i2;
        a(true);
        return this;
    }

    public ig a(hu huVar) {
        this.f739a = huVar;
        return this;
    }

    public ig a(String str) {
        this.f747b = str;
        return this;
    }

    public String a() {
        return this.f747b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11973a() {
        if (this.f747b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f750c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f754f != null) {
        } else {
            throw new jd("Required field 'token' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                jcVar.f();
                m11973a();
                return;
            }
            short s2 = mo12032a.f887a;
            switch (s2) {
                case 1:
                    if (mo12032a.f41543a == 11) {
                        this.f741a = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo12032a.f41543a == 12) {
                        hv hvVar = new hv();
                        this.f740a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo12032a.f41543a == 11) {
                        this.f747b = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo12032a.f41543a == 11) {
                        this.f750c = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo12032a.f41543a == 11) {
                        this.f752d = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo12032a.f41543a == 11) {
                        this.f753e = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo12032a.f41543a == 11) {
                        this.f754f = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo12032a.f41543a == 11) {
                        this.f755g = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo12032a.f41543a == 11) {
                        this.f756h = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo12032a.f41543a == 11) {
                        this.f757i = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 11:
                    if (mo12032a.f41543a == 11) {
                        this.f758j = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo12032a.f41543a == 11) {
                        this.f759k = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 13:
                    if (mo12032a.f41543a == 8) {
                        this.f737a = jcVar.mo12030a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 14:
                    if (mo12032a.f41543a == 8) {
                        this.f745b = jcVar.mo12030a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 15:
                    if (mo12032a.f41543a == 11) {
                        this.f760l = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 16:
                    if (mo12032a.f41543a == 11) {
                        this.f761m = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 17:
                    if (mo12032a.f41543a == 11) {
                        this.f762n = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 18:
                    if (mo12032a.f41543a == 11) {
                        this.f763o = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 19:
                    if (mo12032a.f41543a == 8) {
                        this.f749c = jcVar.mo12030a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 20:
                    if (mo12032a.f41543a == 8) {
                        this.f739a = hu.a(jcVar.mo12030a());
                        continue;
                        jcVar.g();
                    }
                    break;
                case 21:
                    if (mo12032a.f41543a == 2) {
                        this.f744a = jcVar.mo12042a();
                        d(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 22:
                    if (mo12032a.f41543a == 10) {
                        this.f738a = jcVar.mo12031a();
                        e(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 23:
                    if (mo12032a.f41543a == 10) {
                        this.f746b = jcVar.mo12031a();
                        f(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 24:
                    if (mo12032a.f41543a == 11) {
                        this.f764p = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 25:
                    if (mo12032a.f41543a == 11) {
                        this.f765q = jcVar.mo12037a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 26:
                    if (mo12032a.f41543a == 2) {
                        this.f748b = jcVar.mo12042a();
                        g(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (mo12032a.f41543a == 13) {
                                jb mo12034a = jcVar.mo12034a();
                                this.f743a = new HashMap(mo12034a.f890a * 2);
                                int i2 = 0;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 >= mo12034a.f890a) {
                                        jcVar.h();
                                        break;
                                    } else {
                                        this.f743a.put(jcVar.mo12037a(), jcVar.mo12037a());
                                        i2 = i3 + 1;
                                    }
                                }
                            }
                            break;
                        case 101:
                            if (mo12032a.f41543a == 2) {
                                this.f751c = jcVar.mo12042a();
                                h(true);
                                break;
                            }
                            break;
                        case 102:
                            if (mo12032a.f41543a == 11) {
                                this.f766r = jcVar.mo12037a();
                                continue;
                            }
                            break;
                    }
                    jcVar.g();
                    break;
            }
            jf.a(jcVar, mo12032a.f41543a);
            jcVar.g();
        }
    }

    public void a(boolean z2) {
        this.f742a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11974a() {
        return this.f741a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11975a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m11974a = m11974a();
        boolean m11974a2 = igVar.m11974a();
        if ((m11974a || m11974a2) && !(m11974a && m11974a2 && this.f741a.equals(igVar.f741a))) {
            return false;
        }
        boolean m11976b = m11976b();
        boolean m11976b2 = igVar.m11976b();
        if ((m11976b || m11976b2) && !(m11976b && m11976b2 && this.f740a.m11909a(igVar.f740a))) {
            return false;
        }
        boolean m11977c = m11977c();
        boolean m11977c2 = igVar.m11977c();
        if ((m11977c || m11977c2) && !(m11977c && m11977c2 && this.f747b.equals(igVar.f747b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f750c.equals(igVar.f750c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f752d.equals(igVar.f752d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f753e.equals(igVar.f753e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f754f.equals(igVar.f754f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f755g.equals(igVar.f755g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f756h.equals(igVar.f756h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f757i.equals(igVar.f757i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = igVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f758j.equals(igVar.f758j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = igVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f759k.equals(igVar.f759k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = igVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f737a == igVar.f737a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = igVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f745b == igVar.f745b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = igVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f760l.equals(igVar.f760l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = igVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f761m.equals(igVar.f761m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = igVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f762n.equals(igVar.f762n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = igVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f763o.equals(igVar.f763o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = igVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f749c == igVar.f749c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = igVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f739a.equals(igVar.f739a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = igVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f744a == igVar.f744a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = igVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f738a == igVar.f738a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = igVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f746b == igVar.f746b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = igVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f764p.equals(igVar.f764p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = igVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f765q.equals(igVar.f765q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = igVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f748b == igVar.f748b)) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = igVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f743a.equals(igVar.f743a))) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = igVar.B();
        if ((B2 || B3) && !(B2 && B3 && this.f751c == igVar.f751c)) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = igVar.C();
        if (C2 || C3) {
            return C2 && C3 && this.f766r.equals(igVar.f766r);
        }
        return true;
    }

    public ig b(int i2) {
        this.f745b = i2;
        b(true);
        return this;
    }

    public ig b(String str) {
        this.f750c = str;
        return this;
    }

    public String b() {
        return this.f750c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11973a();
        jcVar.a(f736a);
        if (this.f741a != null && m11974a()) {
            jcVar.a(f41517a);
            jcVar.a(this.f741a);
            jcVar.b();
        }
        if (this.f740a != null && m11976b()) {
            jcVar.a(b);
            this.f740a.b(jcVar);
            jcVar.b();
        }
        if (this.f747b != null) {
            jcVar.a(f41518c);
            jcVar.a(this.f747b);
            jcVar.b();
        }
        if (this.f750c != null) {
            jcVar.a(d);
            jcVar.a(this.f750c);
            jcVar.b();
        }
        if (this.f752d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f752d);
            jcVar.b();
        }
        if (this.f753e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f753e);
            jcVar.b();
        }
        if (this.f754f != null) {
            jcVar.a(g);
            jcVar.a(this.f754f);
            jcVar.b();
        }
        if (this.f755g != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f755g);
            jcVar.b();
        }
        if (this.f756h != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f756h);
            jcVar.b();
        }
        if (this.f757i != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f757i);
            jcVar.b();
        }
        if (this.f758j != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f758j);
            jcVar.b();
        }
        if (this.f759k != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f759k);
            jcVar.b();
        }
        if (m()) {
            jcVar.a(m);
            jcVar.mo12041a(this.f737a);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.mo12041a(this.f745b);
            jcVar.b();
        }
        if (this.f760l != null && o()) {
            jcVar.a(o);
            jcVar.a(this.f760l);
            jcVar.b();
        }
        if (this.f761m != null && p()) {
            jcVar.a(p);
            jcVar.a(this.f761m);
            jcVar.b();
        }
        if (this.f762n != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f762n);
            jcVar.b();
        }
        if (this.f763o != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f763o);
            jcVar.b();
        }
        if (s()) {
            jcVar.a(s);
            jcVar.mo12041a(this.f749c);
            jcVar.b();
        }
        if (this.f739a != null && t()) {
            jcVar.a(t);
            jcVar.mo12041a(this.f739a.a());
            jcVar.b();
        }
        if (u()) {
            jcVar.a(u);
            jcVar.a(this.f744a);
            jcVar.b();
        }
        if (v()) {
            jcVar.a(v);
            jcVar.a(this.f738a);
            jcVar.b();
        }
        if (w()) {
            jcVar.a(w);
            jcVar.a(this.f746b);
            jcVar.b();
        }
        if (this.f764p != null && x()) {
            jcVar.a(x);
            jcVar.a(this.f764p);
            jcVar.b();
        }
        if (this.f765q != null && y()) {
            jcVar.a(y);
            jcVar.a(this.f765q);
            jcVar.b();
        }
        if (z()) {
            jcVar.a(z);
            jcVar.a(this.f748b);
            jcVar.b();
        }
        if (this.f743a != null && A()) {
            jcVar.a(A);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f743a.size()));
            for (Map.Entry<String, String> entry : this.f743a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (B()) {
            jcVar.a(B);
            jcVar.a(this.f751c);
            jcVar.b();
        }
        if (this.f766r != null && C()) {
            jcVar.a(C);
            jcVar.a(this.f766r);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z2) {
        this.f742a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11976b() {
        return this.f740a != null;
    }

    public ig c(int i2) {
        this.f749c = i2;
        c(true);
        return this;
    }

    public ig c(String str) {
        this.f752d = str;
        return this;
    }

    public String c() {
        return this.f754f;
    }

    public void c(boolean z2) {
        this.f742a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m11977c() {
        return this.f747b != null;
    }

    public ig d(String str) {
        this.f753e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f742a.set(3, z2);
    }

    public boolean d() {
        return this.f750c != null;
    }

    public ig e(String str) {
        this.f754f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f742a.set(4, z2);
    }

    public boolean e() {
        return this.f752d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m11975a((ig) obj);
        }
        return false;
    }

    public ig f(String str) {
        this.f755g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f742a.set(5, z2);
    }

    public boolean f() {
        return this.f753e != null;
    }

    public ig g(String str) {
        this.f756h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f742a.set(6, z2);
    }

    public boolean g() {
        return this.f754f != null;
    }

    public ig h(String str) {
        this.f759k = str;
        return this;
    }

    public void h(boolean z2) {
        this.f742a.set(7, z2);
    }

    public boolean h() {
        return this.f755g != null;
    }

    public int hashCode() {
        return 0;
    }

    public ig i(String str) {
        this.f763o = str;
        return this;
    }

    public boolean i() {
        return this.f756h != null;
    }

    public boolean j() {
        return this.f757i != null;
    }

    public boolean k() {
        return this.f758j != null;
    }

    public boolean l() {
        return this.f759k != null;
    }

    public boolean m() {
        return this.f742a.get(0);
    }

    public boolean n() {
        return this.f742a.get(1);
    }

    public boolean o() {
        return this.f760l != null;
    }

    public boolean p() {
        return this.f761m != null;
    }

    public boolean q() {
        return this.f762n != null;
    }

    public boolean r() {
        return this.f763o != null;
    }

    public boolean s() {
        return this.f742a.get(2);
    }

    public boolean t() {
        return this.f739a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        if (m11974a()) {
            sb.append("debug:");
            String str = this.f741a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m11976b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f740a;
            if (hvVar == null) {
                sb.append(com.igexin.push.core.b.l);
                z2 = false;
            } else {
                sb.append(hvVar);
                z2 = false;
            }
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f747b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f750c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f752d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f753e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f754f;
        if (str6 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f755g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f756h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f757i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f758j;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f759k;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f737a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f745b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f760l;
            if (str12 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f761m;
            if (str13 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f762n;
            if (str14 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f763o;
            if (str15 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f749c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            hu huVar = this.f739a;
            if (huVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(huVar);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f744a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f738a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f746b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f764p;
            if (str16 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f765q;
            if (str17 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f748b);
        }
        if (A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f743a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f751c);
        }
        if (C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f766r;
            if (str18 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f742a.get(3);
    }

    public boolean v() {
        return this.f742a.get(4);
    }

    public boolean w() {
        return this.f742a.get(5);
    }

    public boolean x() {
        return this.f764p != null;
    }

    public boolean y() {
        return this.f765q != null;
    }

    public boolean z() {
        return this.f742a.get(6);
    }
}
