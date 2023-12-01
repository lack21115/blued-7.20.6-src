package com.opos.exoplayer.core.f.a;

import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f11651a = u.f("GA94");
    private static final int b = u.f("DTG1");

    private static int a(m mVar) {
        int i = 0;
        while (mVar.b() != 0) {
            int g = mVar.g();
            int i2 = i + g;
            i = i2;
            if (g != 255) {
                return i2;
            }
        }
        return -1;
    }

    public static void a(long j, m mVar, n[] nVarArr) {
        int c2;
        while (mVar.b() > 1) {
            int a2 = a(mVar);
            int a3 = a(mVar);
            int d = mVar.d();
            if (a3 == -1 || a3 > mVar.b()) {
                com.opos.cmn.an.f.a.c("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                c2 = mVar.c();
            } else {
                if (a2 == 4 && a3 >= 8) {
                    int g = mVar.g();
                    int h = mVar.h();
                    int o = h == 49 ? mVar.o() : 0;
                    int g2 = mVar.g();
                    if (h == 47) {
                        mVar.d(1);
                    }
                    boolean z = g == 181 && (h == 49 || h == 47) && g2 == 3;
                    boolean z2 = z;
                    if (h == 49) {
                        z2 = z & (o == f11651a || o == b);
                    }
                    if (z2) {
                        int g3 = mVar.g();
                        mVar.d(1);
                        int i = (g3 & 31) * 3;
                        int d2 = mVar.d();
                        int length = nVarArr.length;
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= length) {
                                break;
                            }
                            n nVar = nVarArr[i3];
                            mVar.c(d2);
                            nVar.a(mVar, i);
                            nVar.a(j, 1, i, 0, null);
                            i2 = i3 + 1;
                        }
                    }
                }
                c2 = d + a3;
            }
            mVar.c(c2);
        }
    }
}
