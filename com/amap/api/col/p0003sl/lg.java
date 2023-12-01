package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.lj;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.lg  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/lg.class */
public final class lg extends lf {
    public lg() {
        super(2048);
    }

    private int a(long j, List<mq> list) {
        b(list);
        int size = list.size();
        if (size <= 0) {
            return -1;
        }
        int[] iArr = new int[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return mb.a(this.f5361a, mb.a(this.f5361a, iArr));
            }
            mq mqVar = list.get(i2);
            int a2 = this.f5361a.a(mqVar.b);
            iArr[i2] = mc.a(this.f5361a, mqVar.f5387a == j && mqVar.f5387a != -1, mqVar.f5387a, (short) mqVar.f5388c, a2, mqVar.g, (short) mqVar.d);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0240, code lost:
        if (r0 < 0) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(com.amap.api.col.p0003sl.lj.a r12) {
        /*
            Method dump skipped, instructions count: 820
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.lg.a(com.amap.api.col.3sl.lj$a):int");
    }

    private int a(mp mpVar) {
        long j = mpVar.k;
        return lv.a(this.f5361a, mpVar.f5386c, j, (int) (mpVar.e * 1000000.0d), (int) (mpVar.d * 1000000.0d), (int) mpVar.f, (int) mpVar.i, (int) mpVar.g, (short) mpVar.h, mpVar.l);
    }

    private static void a(List<mj> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (mj mjVar : list) {
            if (mjVar instanceof ml) {
                ml mlVar = (ml) mjVar;
                mjVar.g = mf.a(mf.a(mlVar.j, mlVar.k));
            } else if (mjVar instanceof mm) {
                mm mmVar = (mm) mjVar;
                mjVar.g = mf.a(mf.a(mmVar.j, mmVar.k));
            } else if (mjVar instanceof mn) {
                mn mnVar = (mn) mjVar;
                mjVar.g = mf.a(mf.a(mnVar.j, mnVar.k));
            } else if (mjVar instanceof mk) {
                mk mkVar = (mk) mjVar;
                mjVar.g = mf.a(mf.a(mkVar.k, mkVar.l));
            }
        }
    }

    private static void b(List<mq> list) {
        for (mq mqVar : list) {
            mqVar.g = mf.b(mqVar.f5387a);
        }
    }

    public final byte[] a(mp mpVar, lj.a aVar, long j, List<mq> list) {
        super.a();
        try {
            int a2 = a(mpVar);
            int a3 = (aVar == null || aVar.f == null || aVar.f.size() <= 0) ? -1 : a(aVar);
            int i = -1;
            if (list != null) {
                i = -1;
                if (list.size() > 0) {
                    i = a(j, list);
                }
            }
            lo.a(this.f5361a);
            lo.a(this.f5361a, a2);
            if (a3 > 0) {
                lo.c(this.f5361a, a3);
            }
            if (i > 0) {
                lo.b(this.f5361a, i);
            }
            this.f5361a.c(lo.b(this.f5361a));
            return this.f5361a.c();
        } catch (Throwable th) {
            mt.a(th);
            return null;
        }
    }
}
