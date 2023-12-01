package com.amap.api.col.p0003sl;

import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.amap.api.col.3sl.li  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/li.class */
public final class li extends lf {
    private static li b = new li();

    private li() {
        super(GL10.GL_BYTE);
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
            int a = lp.a((nb) this.a, bArr);
            int[] iArr = new int[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                lm lmVar = list.get(i2);
                iArr[i2] = lu.a(this.a, (byte) lmVar.a(), lu.a(this.a, lmVar.b()));
                i = i2 + 1;
            }
            int a2 = lp.a(this.a, iArr);
            int i3 = 0;
            if (bArr2 != null) {
                i3 = lp.b(this.a, bArr2);
            }
            this.a.c(lp.a(this.a, a, i3, a2));
            return this.a.c();
        } catch (Throwable th) {
            mt.a(th);
            return null;
        }
    }

    public final byte[] c() {
        super.a();
        try {
            this.a.c(ms.a(this.a, mr.a(), this.a.a(mr.f()), this.a.a(mr.c()), (byte) mr.m(), this.a.a(mr.i()), this.a.a(mr.h()), this.a.a(a(mr.g())), this.a.a(a(mr.j())), mq.a(mr.n()), this.a.a(mr.l()), this.a.a(mr.k()), this.a.a(mr.d()), this.a.a(mr.e())));
            return this.a.c();
        } catch (Exception e) {
            mt.a(e);
            return null;
        }
    }
}
