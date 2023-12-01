package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ig.class */
public class ig implements ir<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f690a;

    /* renamed from: a  reason: collision with other field name */
    public long f691a;

    /* renamed from: a  reason: collision with other field name */
    public hu f692a;

    /* renamed from: a  reason: collision with other field name */
    public hv f693a;

    /* renamed from: a  reason: collision with other field name */
    public String f694a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f696a;

    /* renamed from: b  reason: collision with other field name */
    public int f698b;

    /* renamed from: b  reason: collision with other field name */
    public long f699b;

    /* renamed from: b  reason: collision with other field name */
    public String f700b;

    /* renamed from: c  reason: collision with other field name */
    public int f702c;

    /* renamed from: c  reason: collision with other field name */
    public String f703c;

    /* renamed from: d  reason: collision with other field name */
    public String f705d;

    /* renamed from: e  reason: collision with other field name */
    public String f706e;

    /* renamed from: f  reason: collision with other field name */
    public String f707f;

    /* renamed from: g  reason: collision with other field name */
    public String f708g;

    /* renamed from: h  reason: collision with other field name */
    public String f709h;

    /* renamed from: i  reason: collision with other field name */
    public String f710i;

    /* renamed from: j  reason: collision with other field name */
    public String f711j;

    /* renamed from: k  reason: collision with other field name */
    public String f712k;

    /* renamed from: l  reason: collision with other field name */
    public String f713l;

    /* renamed from: m  reason: collision with other field name */
    public String f714m;

    /* renamed from: n  reason: collision with other field name */
    public String f715n;

    /* renamed from: o  reason: collision with other field name */
    public String f716o;

    /* renamed from: p  reason: collision with other field name */
    public String f717p;

    /* renamed from: q  reason: collision with other field name */
    public String f718q;

    /* renamed from: r  reason: collision with other field name */
    public String f719r;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f689a = new jh("XmPushActionRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27826a = new iz("", (byte) 11, 1);
    private static final iz b = new iz("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27827c = new iz("", (byte) 11, 3);
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
    private BitSet f695a = new BitSet(8);

    /* renamed from: a  reason: collision with other field name */
    public boolean f697a = true;

    /* renamed from: c  reason: collision with other field name */
    public boolean f704c = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f701b = false;

    public boolean A() {
        return this.f696a != null;
    }

    public boolean B() {
        return this.f695a.get(7);
    }

    public boolean C() {
        return this.f719r != null;
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
            int compareTo = Boolean.valueOf(m8924a()).compareTo(Boolean.valueOf(igVar.m8924a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8924a() || (a30 = is.a(this.f694a, igVar.f694a)) == 0) {
                int compareTo2 = Boolean.valueOf(m8926b()).compareTo(Boolean.valueOf(igVar.m8926b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m8926b() || (a29 = is.a(this.f693a, igVar.f693a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m8927c()).compareTo(Boolean.valueOf(igVar.m8927c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m8927c() || (a28 = is.a(this.f700b, igVar.f700b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a27 = is.a(this.f703c, igVar.f703c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a26 = is.a(this.f705d, igVar.f705d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a25 = is.a(this.f706e, igVar.f706e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a24 = is.a(this.f707f, igVar.f707f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a23 = is.a(this.f708g, igVar.f708g)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a22 = is.a(this.f709h, igVar.f709h)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a21 = is.a(this.f710i, igVar.f710i)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a20 = is.a(this.f711j, igVar.f711j)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a19 = is.a(this.f712k, igVar.f712k)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a18 = is.a(this.f690a, igVar.f690a)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a17 = is.a(this.f698b, igVar.f698b)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a16 = is.a(this.f713l, igVar.f713l)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(igVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a15 = is.a(this.f714m, igVar.f714m)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(igVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a14 = is.a(this.f715n, igVar.f715n)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(igVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a13 = is.a(this.f716o, igVar.f716o)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(igVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a12 = is.a(this.f702c, igVar.f702c)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(igVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a11 = is.a(this.f692a, igVar.f692a)) == 0) {
                                                                                            int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(igVar.u()));
                                                                                            if (compareTo21 != 0) {
                                                                                                return compareTo21;
                                                                                            }
                                                                                            if (!u() || (a10 = is.a(this.f697a, igVar.f697a)) == 0) {
                                                                                                int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(igVar.v()));
                                                                                                if (compareTo22 != 0) {
                                                                                                    return compareTo22;
                                                                                                }
                                                                                                if (!v() || (a9 = is.a(this.f691a, igVar.f691a)) == 0) {
                                                                                                    int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(igVar.w()));
                                                                                                    if (compareTo23 != 0) {
                                                                                                        return compareTo23;
                                                                                                    }
                                                                                                    if (!w() || (a8 = is.a(this.f699b, igVar.f699b)) == 0) {
                                                                                                        int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(igVar.x()));
                                                                                                        if (compareTo24 != 0) {
                                                                                                            return compareTo24;
                                                                                                        }
                                                                                                        if (!x() || (a7 = is.a(this.f717p, igVar.f717p)) == 0) {
                                                                                                            int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(igVar.y()));
                                                                                                            if (compareTo25 != 0) {
                                                                                                                return compareTo25;
                                                                                                            }
                                                                                                            if (!y() || (a6 = is.a(this.f718q, igVar.f718q)) == 0) {
                                                                                                                int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(igVar.z()));
                                                                                                                if (compareTo26 != 0) {
                                                                                                                    return compareTo26;
                                                                                                                }
                                                                                                                if (!z() || (a5 = is.a(this.f701b, igVar.f701b)) == 0) {
                                                                                                                    int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(igVar.A()));
                                                                                                                    if (compareTo27 != 0) {
                                                                                                                        return compareTo27;
                                                                                                                    }
                                                                                                                    if (!A() || (a4 = is.a(this.f696a, igVar.f696a)) == 0) {
                                                                                                                        int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(igVar.B()));
                                                                                                                        if (compareTo28 != 0) {
                                                                                                                            return compareTo28;
                                                                                                                        }
                                                                                                                        if (!B() || (a3 = is.a(this.f704c, igVar.f704c)) == 0) {
                                                                                                                            int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(igVar.C()));
                                                                                                                            if (compareTo29 != 0) {
                                                                                                                                return compareTo29;
                                                                                                                            }
                                                                                                                            if (!C() || (a2 = is.a(this.f719r, igVar.f719r)) == 0) {
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
        this.f690a = i2;
        a(true);
        return this;
    }

    public ig a(hu huVar) {
        this.f692a = huVar;
        return this;
    }

    public ig a(String str) {
        this.f700b = str;
        return this;
    }

    public String a() {
        return this.f700b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8923a() {
        if (this.f700b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f703c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f707f != null) {
        } else {
            throw new jd("Required field 'token' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                jcVar.f();
                m8923a();
                return;
            }
            short s2 = mo8982a.f840a;
            switch (s2) {
                case 1:
                    if (mo8982a.f27852a == 11) {
                        this.f694a = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 2:
                    if (mo8982a.f27852a == 12) {
                        hv hvVar = new hv();
                        this.f693a = hvVar;
                        hvVar.a(jcVar);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 3:
                    if (mo8982a.f27852a == 11) {
                        this.f700b = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 4:
                    if (mo8982a.f27852a == 11) {
                        this.f703c = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 5:
                    if (mo8982a.f27852a == 11) {
                        this.f705d = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 6:
                    if (mo8982a.f27852a == 11) {
                        this.f706e = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 7:
                    if (mo8982a.f27852a == 11) {
                        this.f707f = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 8:
                    if (mo8982a.f27852a == 11) {
                        this.f708g = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 9:
                    if (mo8982a.f27852a == 11) {
                        this.f709h = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 10:
                    if (mo8982a.f27852a == 11) {
                        this.f710i = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 11:
                    if (mo8982a.f27852a == 11) {
                        this.f711j = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 12:
                    if (mo8982a.f27852a == 11) {
                        this.f712k = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 13:
                    if (mo8982a.f27852a == 8) {
                        this.f690a = jcVar.mo8980a();
                        a(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 14:
                    if (mo8982a.f27852a == 8) {
                        this.f698b = jcVar.mo8980a();
                        b(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 15:
                    if (mo8982a.f27852a == 11) {
                        this.f713l = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 16:
                    if (mo8982a.f27852a == 11) {
                        this.f714m = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 17:
                    if (mo8982a.f27852a == 11) {
                        this.f715n = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 18:
                    if (mo8982a.f27852a == 11) {
                        this.f716o = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 19:
                    if (mo8982a.f27852a == 8) {
                        this.f702c = jcVar.mo8980a();
                        c(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 20:
                    if (mo8982a.f27852a == 8) {
                        this.f692a = hu.a(jcVar.mo8980a());
                        continue;
                        jcVar.g();
                    }
                    break;
                case 21:
                    if (mo8982a.f27852a == 2) {
                        this.f697a = jcVar.mo8992a();
                        d(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 22:
                    if (mo8982a.f27852a == 10) {
                        this.f691a = jcVar.mo8981a();
                        e(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 23:
                    if (mo8982a.f27852a == 10) {
                        this.f699b = jcVar.mo8981a();
                        f(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                case 24:
                    if (mo8982a.f27852a == 11) {
                        this.f717p = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 25:
                    if (mo8982a.f27852a == 11) {
                        this.f718q = jcVar.mo8987a();
                        continue;
                        jcVar.g();
                    }
                    break;
                case 26:
                    if (mo8982a.f27852a == 2) {
                        this.f701b = jcVar.mo8992a();
                        g(true);
                        continue;
                        jcVar.g();
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (mo8982a.f27852a == 13) {
                                jb mo8984a = jcVar.mo8984a();
                                this.f696a = new HashMap(mo8984a.f843a * 2);
                                int i2 = 0;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 >= mo8984a.f843a) {
                                        jcVar.h();
                                        break;
                                    } else {
                                        this.f696a.put(jcVar.mo8987a(), jcVar.mo8987a());
                                        i2 = i3 + 1;
                                    }
                                }
                            }
                            break;
                        case 101:
                            if (mo8982a.f27852a == 2) {
                                this.f704c = jcVar.mo8992a();
                                h(true);
                                break;
                            }
                            break;
                        case 102:
                            if (mo8982a.f27852a == 11) {
                                this.f719r = jcVar.mo8987a();
                                continue;
                            }
                            break;
                    }
                    jcVar.g();
                    break;
            }
            jf.a(jcVar, mo8982a.f27852a);
            jcVar.g();
        }
    }

    public void a(boolean z2) {
        this.f695a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8924a() {
        return this.f694a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8925a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m8924a = m8924a();
        boolean m8924a2 = igVar.m8924a();
        if ((m8924a || m8924a2) && !(m8924a && m8924a2 && this.f694a.equals(igVar.f694a))) {
            return false;
        }
        boolean m8926b = m8926b();
        boolean m8926b2 = igVar.m8926b();
        if ((m8926b || m8926b2) && !(m8926b && m8926b2 && this.f693a.m8859a(igVar.f693a))) {
            return false;
        }
        boolean m8927c = m8927c();
        boolean m8927c2 = igVar.m8927c();
        if ((m8927c || m8927c2) && !(m8927c && m8927c2 && this.f700b.equals(igVar.f700b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f703c.equals(igVar.f703c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f705d.equals(igVar.f705d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f706e.equals(igVar.f706e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f707f.equals(igVar.f707f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f708g.equals(igVar.f708g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f709h.equals(igVar.f709h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f710i.equals(igVar.f710i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = igVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f711j.equals(igVar.f711j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = igVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f712k.equals(igVar.f712k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = igVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f690a == igVar.f690a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = igVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f698b == igVar.f698b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = igVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f713l.equals(igVar.f713l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = igVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f714m.equals(igVar.f714m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = igVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f715n.equals(igVar.f715n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = igVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f716o.equals(igVar.f716o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = igVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f702c == igVar.f702c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = igVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f692a.equals(igVar.f692a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = igVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f697a == igVar.f697a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = igVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f691a == igVar.f691a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = igVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f699b == igVar.f699b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = igVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f717p.equals(igVar.f717p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = igVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f718q.equals(igVar.f718q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = igVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f701b == igVar.f701b)) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = igVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f696a.equals(igVar.f696a))) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = igVar.B();
        if ((B2 || B3) && !(B2 && B3 && this.f704c == igVar.f704c)) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = igVar.C();
        if (C2 || C3) {
            return C2 && C3 && this.f719r.equals(igVar.f719r);
        }
        return true;
    }

    public ig b(int i2) {
        this.f698b = i2;
        b(true);
        return this;
    }

    public ig b(String str) {
        this.f703c = str;
        return this;
    }

    public String b() {
        return this.f703c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8923a();
        jcVar.a(f689a);
        if (this.f694a != null && m8924a()) {
            jcVar.a(f27826a);
            jcVar.a(this.f694a);
            jcVar.b();
        }
        if (this.f693a != null && m8926b()) {
            jcVar.a(b);
            this.f693a.b(jcVar);
            jcVar.b();
        }
        if (this.f700b != null) {
            jcVar.a(f27827c);
            jcVar.a(this.f700b);
            jcVar.b();
        }
        if (this.f703c != null) {
            jcVar.a(d);
            jcVar.a(this.f703c);
            jcVar.b();
        }
        if (this.f705d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f705d);
            jcVar.b();
        }
        if (this.f706e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f706e);
            jcVar.b();
        }
        if (this.f707f != null) {
            jcVar.a(g);
            jcVar.a(this.f707f);
            jcVar.b();
        }
        if (this.f708g != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f708g);
            jcVar.b();
        }
        if (this.f709h != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f709h);
            jcVar.b();
        }
        if (this.f710i != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f710i);
            jcVar.b();
        }
        if (this.f711j != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f711j);
            jcVar.b();
        }
        if (this.f712k != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f712k);
            jcVar.b();
        }
        if (m()) {
            jcVar.a(m);
            jcVar.mo8991a(this.f690a);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.mo8991a(this.f698b);
            jcVar.b();
        }
        if (this.f713l != null && o()) {
            jcVar.a(o);
            jcVar.a(this.f713l);
            jcVar.b();
        }
        if (this.f714m != null && p()) {
            jcVar.a(p);
            jcVar.a(this.f714m);
            jcVar.b();
        }
        if (this.f715n != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f715n);
            jcVar.b();
        }
        if (this.f716o != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f716o);
            jcVar.b();
        }
        if (s()) {
            jcVar.a(s);
            jcVar.mo8991a(this.f702c);
            jcVar.b();
        }
        if (this.f692a != null && t()) {
            jcVar.a(t);
            jcVar.mo8991a(this.f692a.a());
            jcVar.b();
        }
        if (u()) {
            jcVar.a(u);
            jcVar.a(this.f697a);
            jcVar.b();
        }
        if (v()) {
            jcVar.a(v);
            jcVar.a(this.f691a);
            jcVar.b();
        }
        if (w()) {
            jcVar.a(w);
            jcVar.a(this.f699b);
            jcVar.b();
        }
        if (this.f717p != null && x()) {
            jcVar.a(x);
            jcVar.a(this.f717p);
            jcVar.b();
        }
        if (this.f718q != null && y()) {
            jcVar.a(y);
            jcVar.a(this.f718q);
            jcVar.b();
        }
        if (z()) {
            jcVar.a(z);
            jcVar.a(this.f701b);
            jcVar.b();
        }
        if (this.f696a != null && A()) {
            jcVar.a(A);
            jcVar.a(new jb((byte) 11, (byte) 11, this.f696a.size()));
            for (Map.Entry<String, String> entry : this.f696a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (B()) {
            jcVar.a(B);
            jcVar.a(this.f704c);
            jcVar.b();
        }
        if (this.f719r != null && C()) {
            jcVar.a(C);
            jcVar.a(this.f719r);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z2) {
        this.f695a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8926b() {
        return this.f693a != null;
    }

    public ig c(int i2) {
        this.f702c = i2;
        c(true);
        return this;
    }

    public ig c(String str) {
        this.f705d = str;
        return this;
    }

    public String c() {
        return this.f707f;
    }

    public void c(boolean z2) {
        this.f695a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8927c() {
        return this.f700b != null;
    }

    public ig d(String str) {
        this.f706e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f695a.set(3, z2);
    }

    public boolean d() {
        return this.f703c != null;
    }

    public ig e(String str) {
        this.f707f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f695a.set(4, z2);
    }

    public boolean e() {
        return this.f705d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m8925a((ig) obj);
        }
        return false;
    }

    public ig f(String str) {
        this.f708g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f695a.set(5, z2);
    }

    public boolean f() {
        return this.f706e != null;
    }

    public ig g(String str) {
        this.f709h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f695a.set(6, z2);
    }

    public boolean g() {
        return this.f707f != null;
    }

    public ig h(String str) {
        this.f712k = str;
        return this;
    }

    public void h(boolean z2) {
        this.f695a.set(7, z2);
    }

    public boolean h() {
        return this.f708g != null;
    }

    public int hashCode() {
        return 0;
    }

    public ig i(String str) {
        this.f716o = str;
        return this;
    }

    public boolean i() {
        return this.f709h != null;
    }

    public boolean j() {
        return this.f710i != null;
    }

    public boolean k() {
        return this.f711j != null;
    }

    public boolean l() {
        return this.f712k != null;
    }

    public boolean m() {
        return this.f695a.get(0);
    }

    public boolean n() {
        return this.f695a.get(1);
    }

    public boolean o() {
        return this.f713l != null;
    }

    public boolean p() {
        return this.f714m != null;
    }

    public boolean q() {
        return this.f715n != null;
    }

    public boolean r() {
        return this.f716o != null;
    }

    public boolean s() {
        return this.f695a.get(2);
    }

    public boolean t() {
        return this.f692a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        if (m8924a()) {
            sb.append("debug:");
            String str = this.f694a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m8926b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            hv hvVar = this.f693a;
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
        String str2 = this.f700b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f703c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f705d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f706e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f707f;
        if (str6 == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f708g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f709h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f710i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f711j;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f712k;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f690a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f698b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f713l;
            if (str12 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f714m;
            if (str13 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f715n;
            if (str14 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f716o;
            if (str15 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f702c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            hu huVar = this.f692a;
            if (huVar == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(huVar);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f697a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f691a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f699b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f717p;
            if (str16 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f718q;
            if (str17 == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f701b);
        }
        if (A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f696a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.l);
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f704c);
        }
        if (C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f719r;
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
        return this.f695a.get(3);
    }

    public boolean v() {
        return this.f695a.get(4);
    }

    public boolean w() {
        return this.f695a.get(5);
    }

    public boolean x() {
        return this.f717p != null;
    }

    public boolean y() {
        return this.f718q != null;
    }

    public boolean z() {
        return this.f695a.get(6);
    }
}
