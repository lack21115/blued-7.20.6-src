package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/jf.class */
public class jf {

    /* renamed from: a  reason: collision with root package name */
    private static int f41549a = Integer.MAX_VALUE;

    public static void a(jc jcVar, byte b) {
        a(jcVar, b, f41549a);
    }

    public static void a(jc jcVar, byte b, int i) {
        if (i <= 0) {
            throw new iw("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                jcVar.mo12042a();
                return;
            case 3:
                jcVar.a();
                return;
            case 4:
                jcVar.mo12029a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jcVar.mo12039a();
                return;
            case 8:
                jcVar.mo12030a();
                return;
            case 10:
                jcVar.mo12031a();
                return;
            case 11:
                jcVar.mo12038a();
                return;
            case 12:
                jcVar.mo12036a();
                while (true) {
                    iz mo12032a = jcVar.mo12032a();
                    if (mo12032a.f41543a == 0) {
                        jcVar.f();
                        return;
                    } else {
                        a(jcVar, mo12032a.f41543a, i - 1);
                        jcVar.g();
                    }
                }
            case 13:
                jb mo12034a = jcVar.mo12034a();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= mo12034a.f890a) {
                        jcVar.h();
                        return;
                    }
                    byte b2 = mo12034a.f41546a;
                    int i4 = i - 1;
                    a(jcVar, b2, i4);
                    a(jcVar, mo12034a.b, i4);
                    i2 = i3 + 1;
                }
            case 14:
                jg mo12035a = jcVar.mo12035a();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= mo12035a.f891a) {
                        jcVar.j();
                        return;
                    } else {
                        a(jcVar, mo12035a.f41550a, i - 1);
                        i5 = i6 + 1;
                    }
                }
            case 15:
                ja mo12033a = jcVar.mo12033a();
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= mo12033a.f889a) {
                        jcVar.i();
                        return;
                    } else {
                        a(jcVar, mo12033a.f41545a, i - 1);
                        i7 = i8 + 1;
                    }
                }
        }
    }
}
