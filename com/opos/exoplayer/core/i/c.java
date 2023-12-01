package com.opos.exoplayer.core.i;

import android.util.Pair;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f11792a = {0, 0, 0, 1};
    private static final int[] b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f11793c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private static int a(l lVar) {
        int c2 = lVar.c(5);
        int i = c2;
        if (c2 == 31) {
            i = lVar.c(6) + 32;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r0 == 29) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(com.opos.exoplayer.core.i.l r4, boolean r5) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.i.c.a(com.opos.exoplayer.core.i.l, boolean):android.util.Pair");
    }

    public static Pair<Integer, Integer> a(byte[] bArr) {
        return a(new l(bArr), false);
    }

    private static void a(l lVar, int i, int i2) {
        lVar.b(1);
        if (lVar.e()) {
            lVar.b(14);
        }
        boolean e = lVar.e();
        if (i2 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i == 6 || i == 20) {
            lVar.b(3);
        }
        if (e) {
            if (i == 22) {
                lVar.b(16);
            }
            if (i == 17 || i == 19 || i == 20 || i == 23) {
                lVar.b(3);
            }
            lVar.b(1);
        }
    }

    public static byte[] a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = f11792a;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, f11792a.length, i2);
        return bArr3;
    }

    private static int b(l lVar) {
        int c2 = lVar.c(4);
        if (c2 == 15) {
            return lVar.c(24);
        }
        a.a(c2 < 13);
        return b[c2];
    }
}
