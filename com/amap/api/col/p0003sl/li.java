package com.amap.api.col.p0003sl;

import java.util.List;

/* renamed from: com.amap.api.col.3sl.li  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/li.class */
public final class li extends lf {
    private static li b = new li();

    private li() {
        super(5120);
    }

    private static String a(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public static li b() {
        return b;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2, List<? extends lm> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            a();
            int a2 = lp.a((nb) this.f5361a, bArr);
            int[] iArr = new int[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                lm lmVar = list.get(i2);
                iArr[i2] = lu.a(this.f5361a, (byte) lmVar.a(), lu.a(this.f5361a, lmVar.b()));
                i = i2 + 1;
            }
            int a3 = lp.a(this.f5361a, iArr);
            int i3 = 0;
            if (bArr2 != null) {
                i3 = lp.b(this.f5361a, bArr2);
            }
            this.f5361a.c(lp.a(this.f5361a, a2, i3, a3));
            return this.f5361a.c();
        } catch (Throwable th) {
            mt.a(th);
            return null;
        }
    }

    public final byte[] c() {
        super.a();
        try {
            this.f5361a.c(ms.a(this.f5361a, mr.a(), this.f5361a.a(mr.f()), this.f5361a.a(mr.c()), (byte) mr.m(), this.f5361a.a(mr.i()), this.f5361a.a(mr.h()), this.f5361a.a(a(mr.g())), this.f5361a.a(a(mr.j())), mq.a(mr.n()), this.f5361a.a(mr.l()), this.f5361a.a(mr.k()), this.f5361a.a(mr.d()), this.f5361a.a(mr.e())));
            return this.f5361a.c();
        } catch (Exception e) {
            mt.a(e);
            return null;
        }
    }
}
