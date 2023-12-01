package com.anythink.expressad.exoplayer.k;

import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/d.class */
public final class d {
    private static final int b = 15;
    private static final int d = -1;
    private static final int f = 2;
    private static final int g = 5;
    private static final int h = 22;
    private static final int i = 29;
    private static final int j = 31;

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f7643a = {0, 0, 0, 1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f7644c = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] e = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private d() {
    }

    private static int a(byte[] bArr, int i2) {
        int length = bArr.length;
        int length2 = f7643a.length;
        while (i2 <= length - length2) {
            if (b(bArr, i2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r0 == 29) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.util.Pair<java.lang.Integer, java.lang.Integer> a(com.anythink.expressad.exoplayer.k.r r3) {
        /*
            r0 = r3
            int r0 = b(r0)
            r7 = r0
            r0 = r3
            int r0 = c(r0)
            r4 = r0
            r0 = r3
            r1 = 4
            int r0 = r0.c(r1)
            r6 = r0
            r0 = r7
            r1 = 5
            if (r0 == r1) goto L20
            r0 = r6
            r5 = r0
            r0 = r7
            r1 = 29
            if (r0 != r1) goto L3d
        L20:
            r0 = r3
            int r0 = c(r0)
            r7 = r0
            r0 = r7
            r4 = r0
            r0 = r6
            r5 = r0
            r0 = r3
            int r0 = b(r0)
            r1 = 22
            if (r0 != r1) goto L3d
            r0 = r3
            r1 = 4
            int r0 = r0.c(r1)
            r5 = r0
            r0 = r7
            r4 = r0
        L3d:
            int[] r0 = com.anythink.expressad.exoplayer.k.d.e
            r1 = r5
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            r1 = -1
            if (r0 == r1) goto L4e
            r0 = 1
            r8 = r0
            goto L51
        L4e:
            r0 = 0
            r8 = r0
        L51:
            r0 = r8
            com.anythink.expressad.exoplayer.k.a.a(r0)
            r0 = r4
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = r5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            android.util.Pair r0 = android.util.Pair.create(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.d.a(com.anythink.expressad.exoplayer.k.r):android.util.Pair");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0026, code lost:
        if (r0 == 29) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(byte[] r4) {
        /*
            com.anythink.expressad.exoplayer.k.r r0 = new com.anythink.expressad.exoplayer.k.r
            r1 = r0
            r2 = r4
            r1.<init>(r2)
            r4 = r0
            r0 = r4
            int r0 = b(r0)
            r8 = r0
            r0 = r4
            int r0 = c(r0)
            r5 = r0
            r0 = r4
            r1 = 4
            int r0 = r0.c(r1)
            r7 = r0
            r0 = r8
            r1 = 5
            if (r0 == r1) goto L29
            r0 = r7
            r6 = r0
            r0 = r8
            r1 = 29
            if (r0 != r1) goto L46
        L29:
            r0 = r4
            int r0 = c(r0)
            r8 = r0
            r0 = r8
            r5 = r0
            r0 = r7
            r6 = r0
            r0 = r4
            int r0 = b(r0)
            r1 = 22
            if (r0 != r1) goto L46
            r0 = r4
            r1 = 4
            int r0 = r0.c(r1)
            r6 = r0
            r0 = r8
            r5 = r0
        L46:
            int[] r0 = com.anythink.expressad.exoplayer.k.d.e
            r1 = r6
            r0 = r0[r1]
            r6 = r0
            r0 = r6
            r1 = -1
            if (r0 == r1) goto L57
            r0 = 1
            r9 = r0
            goto L5a
        L57:
            r0 = 0
            r9 = r0
        L5a:
            r0 = r9
            com.anythink.expressad.exoplayer.k.a.a(r0)
            r0 = r5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = r6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            android.util.Pair r0 = android.util.Pair.create(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.d.a(byte[]):android.util.Pair");
    }

    private static void a(r rVar, int i2, int i3) {
        rVar.b(1);
        if (rVar.d()) {
            rVar.b(14);
        }
        boolean d2 = rVar.d();
        if (i3 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i2 == 6 || i2 == 20) {
            rVar.b(3);
        }
        if (d2) {
            if (i2 == 22) {
                rVar.b(16);
            }
            if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                rVar.b(3);
            }
            rVar.b(1);
        }
    }

    private static byte[] a(int i2, int i3) {
        int i4 = 0;
        int i5 = -1;
        while (true) {
            int[] iArr = f7644c;
            if (i4 >= iArr.length) {
                break;
            }
            if (i2 == iArr[i4]) {
                i5 = i4;
            }
            i4++;
        }
        int i6 = 0;
        int i7 = -1;
        while (true) {
            int[] iArr2 = e;
            if (i6 >= iArr2.length) {
                break;
            }
            if (i3 == iArr2[i6]) {
                i7 = i6;
            }
            i6++;
        }
        if (i2 == -1 || i7 == -1) {
            throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i2 + ", " + i3);
        }
        return new byte[]{(byte) (((i5 >> 1) & 7) | 16), (byte) (((i5 << 7) & 128) | ((i7 << 3) & 120))};
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = f7643a;
        byte[] bArr3 = new byte[bArr2.length + i3];
        System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, bArr2.length);
        System.arraycopy((Object) bArr, i2, (Object) bArr3, f7643a.length, i3);
        return bArr3;
    }

    private static int b(r rVar) {
        int c2 = rVar.c(5);
        int i2 = c2;
        if (c2 == 31) {
            i2 = rVar.c(6) + 32;
        }
        return i2;
    }

    private static boolean b(byte[] bArr, int i2) {
        if (bArr.length - i2 <= f7643a.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            byte[] bArr2 = f7643a;
            if (i4 >= bArr2.length) {
                return true;
            }
            if (bArr[i2 + i4] != bArr2[i4]) {
                return false;
            }
            i3 = i4 + 1;
        }
    }

    private static byte[] b(int i2, int i3) {
        return new byte[]{(byte) (((i2 >> 1) & 7) | 16), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [byte[], byte[][]] */
    private static byte[][] b(byte[] bArr) {
        int a2;
        if (!b(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        do {
            arrayList.add(Integer.valueOf(i2));
            a2 = a(bArr, i2 + f7643a.length);
            i2 = a2;
        } while (a2 != -1);
        ?? r0 = new byte[arrayList.size()];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= arrayList.size()) {
                return r0;
            }
            int intValue = ((Integer) arrayList.get(i4)).intValue();
            int intValue2 = (i4 < arrayList.size() - 1 ? ((Integer) arrayList.get(i4 + 1)).intValue() : bArr.length) - intValue;
            byte[] bArr2 = new byte[intValue2];
            System.arraycopy((Object) bArr, intValue, (Object) bArr2, 0, intValue2);
            r0[i4] = bArr2;
            i3 = i4 + 1;
        }
    }

    private static int c(r rVar) {
        int c2 = rVar.c(4);
        if (c2 == 15) {
            return rVar.c(24);
        }
        a.a(c2 < 13);
        return f7644c[c2];
    }
}
