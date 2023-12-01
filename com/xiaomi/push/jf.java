package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/jf.class */
public class jf {

    /* renamed from: a  reason: collision with root package name */
    private static int f27858a = Integer.MAX_VALUE;

    public static void a(jc jcVar, byte b) {
        a(jcVar, b, f27858a);
    }

    public static void a(jc jcVar, byte b, int i) {
        if (i <= 0) {
            throw new iw("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                jcVar.mo8992a();
                return;
            case 3:
                jcVar.a();
                return;
            case 4:
                jcVar.mo8979a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jcVar.mo8989a();
                return;
            case 8:
                jcVar.mo8980a();
                return;
            case 10:
                jcVar.mo8981a();
                return;
            case 11:
                jcVar.mo8988a();
                return;
            case 12:
                jcVar.mo8986a();
                while (true) {
                    iz mo8982a = jcVar.mo8982a();
                    if (mo8982a.f27852a == 0) {
                        jcVar.f();
                        return;
                    } else {
                        a(jcVar, mo8982a.f27852a, i - 1);
                        jcVar.g();
                    }
                }
            case 13:
                jb mo8984a = jcVar.mo8984a();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= mo8984a.f843a) {
                        jcVar.h();
                        return;
                    }
                    byte b2 = mo8984a.f27855a;
                    int i4 = i - 1;
                    a(jcVar, b2, i4);
                    a(jcVar, mo8984a.b, i4);
                    i2 = i3 + 1;
                }
            case 14:
                jg mo8985a = jcVar.mo8985a();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= mo8985a.f844a) {
                        jcVar.j();
                        return;
                    } else {
                        a(jcVar, mo8985a.f27859a, i - 1);
                        i5 = i6 + 1;
                    }
                }
            case 15:
                ja mo8983a = jcVar.mo8983a();
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= mo8983a.f842a) {
                        jcVar.i();
                        return;
                    } else {
                        a(jcVar, mo8983a.f27854a, i - 1);
                        i7 = i8 + 1;
                    }
                }
        }
    }
}
