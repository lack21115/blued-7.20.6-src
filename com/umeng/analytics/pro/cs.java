package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cj;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/cs.class */
public class cs {

    /* renamed from: a  reason: collision with root package name */
    private static int f27019a = Integer.MAX_VALUE;

    public static cr a(byte[] bArr, cr crVar) {
        return bArr[0] > 16 ? new cj.a() : (bArr.length <= 1 || (bArr[1] & 128) == 0) ? crVar : new cj.a();
    }

    public static void a(int i) {
        f27019a = i;
    }

    public static void a(cp cpVar, byte b) throws bw {
        a(cpVar, b, f27019a);
    }

    public static void a(cp cpVar, byte b, int i) throws bw {
        if (i <= 0) {
            throw new bw("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                cpVar.t();
                return;
            case 3:
                cpVar.u();
                return;
            case 4:
                cpVar.y();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                cpVar.v();
                return;
            case 8:
                cpVar.w();
                return;
            case 10:
                cpVar.x();
                return;
            case 11:
                cpVar.A();
                return;
            case 12:
                cpVar.j();
                while (true) {
                    ck l = cpVar.l();
                    if (l.b == 0) {
                        cpVar.k();
                        return;
                    } else {
                        a(cpVar, l.b, i - 1);
                        cpVar.m();
                    }
                }
            case 13:
                cm n = cpVar.n();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= n.f27012c) {
                        cpVar.o();
                        return;
                    }
                    byte b2 = n.f27011a;
                    int i4 = i - 1;
                    a(cpVar, b2, i4);
                    a(cpVar, n.b, i4);
                    i2 = i3 + 1;
                }
            case 14:
                ct r = cpVar.r();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= r.b) {
                        cpVar.s();
                        return;
                    } else {
                        a(cpVar, r.f27020a, i - 1);
                        i5 = i6 + 1;
                    }
                }
            case 15:
                cl p = cpVar.p();
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= p.b) {
                        cpVar.q();
                        return;
                    } else {
                        a(cpVar, p.f27010a, i - 1);
                        i7 = i8 + 1;
                    }
                }
        }
    }
}
