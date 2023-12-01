package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/a.class */
final class a {

    /* renamed from: com.opos.exoplayer.core.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/a$a.class */
    public static final class C0481a {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f11423a;
        public final int[] b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11424c;
        public final long[] d;
        public final int[] e;
        public final long f;

        private C0481a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
            this.f11423a = jArr;
            this.b = iArr;
            this.f11424c = i;
            this.d = jArr2;
            this.e = iArr2;
            this.f = j;
        }
    }

    public static C0481a a(int i, long[] jArr, int[] iArr, long j) {
        int i2;
        int i3 = 8192 / i;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i2 = i5;
            if (i4 >= length) {
                break;
            }
            int a2 = u.a(iArr[i4], i3);
            i4++;
            i5 = i2 + a2;
        }
        long[] jArr2 = new long[i2];
        int[] iArr2 = new int[i2];
        long[] jArr3 = new long[i2];
        int[] iArr3 = new int[i2];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < iArr.length; i9++) {
            int i10 = iArr[i9];
            long j2 = jArr[i9];
            while (i10 > 0) {
                int min = Math.min(i3, i10);
                jArr2[i6] = j2;
                iArr2[i6] = i * min;
                i7 = Math.max(i7, iArr2[i6]);
                jArr3[i6] = i8 * j;
                iArr3[i6] = 1;
                j2 += iArr2[i6];
                i8 += min;
                i10 -= min;
                i6++;
            }
        }
        return new C0481a(jArr2, iArr2, i7, jArr3, iArr3, i8 * j);
    }
}
