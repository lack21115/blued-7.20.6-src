package com.tencent.smtt.sdk.stat;

import java.lang.reflect.Array;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/stat/a.class */
public class a {
    private static final int[] f = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};
    private static final int[] g = {40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};
    private static final int[] h = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
    private static final int[] i = {14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};
    private static final int[] j = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
    private static final int[] k = {16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};
    private static final int[][][] l = {new int[]{new int[]{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7}, new int[]{0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8}, new int[]{4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0}, new int[]{15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}}, new int[]{new int[]{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10}, new int[]{3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5}, new int[]{0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15}, new int[]{13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}}, new int[]{new int[]{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8}, new int[]{13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1}, new int[]{13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7}, new int[]{1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}}, new int[]{new int[]{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15}, new int[]{13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9}, new int[]{10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4}, new int[]{3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}}, new int[]{new int[]{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9}, new int[]{14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6}, new int[]{4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14}, new int[]{11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}}, new int[]{new int[]{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11}, new int[]{10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8}, new int[]{9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6}, new int[]{4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}}, new int[]{new int[]{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1}, new int[]{13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6}, new int[]{1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2}, new int[]{6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}}, new int[]{new int[]{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7}, new int[]{1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2}, new int[]{7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8}, new int[]{2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}}};
    private static final int[] m = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f38881a = {98, -24, 57, -84, -115, 117, 55, 121};
    public static final byte[] b = {-25, -101, -115, 1, 47, 7, -27, -59, 18, Byte.MIN_VALUE, 123, 79, -44, 37, 46, 115};

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f38882c = {37, -110, 60, Byte.MAX_VALUE, 42, -27, -17, -110};
    public static final byte[] d = {-122, -8, -23, -84, -125, 113, 84, 99};
    public static final byte[] e = "AL!#$AC9Ahg@KLJ1".getBytes();

    private static void a(int[] iArr, int i2) {
        int i3;
        int[] iArr2 = new int[28];
        int[] iArr3 = new int[28];
        int[] iArr4 = new int[28];
        int[] iArr5 = new int[28];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 28) {
                break;
            }
            iArr2[i5] = iArr[i5];
            iArr3[i5] = iArr[i5 + 28];
            i4 = i5 + 1;
        }
        if (i2 == 1) {
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= 27) {
                    break;
                }
                int i8 = i7 + 1;
                iArr4[i7] = iArr2[i8];
                iArr5[i7] = iArr3[i8];
                i6 = i8;
            }
            iArr4[27] = iArr2[0];
            iArr5[27] = iArr3[0];
            i3 = 0;
        } else {
            i3 = 0;
            if (i2 == 2) {
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= 26) {
                        break;
                    }
                    int i11 = i10 + 2;
                    iArr4[i10] = iArr2[i11];
                    iArr5[i10] = iArr3[i11];
                    i9 = i10 + 1;
                }
                iArr4[26] = iArr2[0];
                iArr5[26] = iArr3[0];
                iArr4[27] = iArr2[1];
                iArr5[27] = iArr3[1];
                i3 = 0;
            }
        }
        while (i3 < 28) {
            iArr[i3] = iArr4[i3];
            iArr[i3 + 28] = iArr5[i3];
            i3++;
        }
    }

    private static void a(int[] iArr, int i2, int i3, int[][] iArr2) {
        int[] iArr3 = new int[32];
        int[] iArr4 = new int[32];
        int[] iArr5 = new int[32];
        int[] iArr6 = new int[32];
        int[] iArr7 = new int[48];
        int[][] iArr8 = (int[][]) Array.newInstance(Integer.TYPE, 8, 6);
        int[] iArr9 = new int[8];
        int[] iArr10 = new int[32];
        int[] iArr11 = new int[32];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 32) {
                break;
            }
            iArr3[i5] = iArr[i5];
            iArr4[i5] = iArr[i5 + 32];
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= 48) {
                break;
            }
            iArr7[i7] = iArr4[j[i7] - 1];
            iArr7[i7] = iArr7[i7] + iArr2[i2][i7];
            if (iArr7[i7] == 2) {
                iArr7[i7] = 0;
            }
            i6 = i7 + 1;
        }
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= 8) {
                break;
            }
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= 6) {
                    break;
                }
                iArr8[i9][i11] = iArr7[(i9 * 6) + i11];
                i10 = i11 + 1;
            }
            iArr9[i9] = l[i9][(iArr8[i9][0] << 1) + iArr8[i9][5]][(iArr8[i9][1] << 3) + (iArr8[i9][2] << 2) + (iArr8[i9][3] << 1) + iArr8[i9][4]];
            int i12 = 0;
            while (true) {
                int i13 = i12;
                if (i13 < 4) {
                    iArr10[((i9 * 4) + 3) - i13] = iArr9[i9] % 2;
                    iArr9[i9] = iArr9[i9] / 2;
                    i12 = i13 + 1;
                }
            }
            i8 = i9 + 1;
        }
        int i14 = 0;
        while (true) {
            int i15 = i14;
            if (i15 >= 32) {
                return;
            }
            iArr11[i15] = iArr10[k[i15] - 1];
            iArr5[i15] = iArr4[i15];
            iArr6[i15] = iArr3[i15] + iArr11[i15];
            if (iArr6[i15] == 2) {
                iArr6[i15] = 0;
            }
            if ((i3 == 0 && i2 == 0) || (i3 == 1 && i2 == 15)) {
                iArr[i15] = iArr6[i15];
                iArr[i15 + 32] = iArr5[i15];
            } else {
                iArr[i15] = iArr5[i15];
                iArr[i15 + 32] = iArr6[i15];
            }
            i14 = i15 + 1;
        }
    }

    private static void a(int[] iArr, byte[] bArr) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 8) {
                return;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < 8) {
                    bArr[i3] = (byte) (bArr[i3] + (iArr[(i3 << 3) + i5] << (7 - i5)));
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }

    private static void a(int[] iArr, int[][] iArr2) {
        int[] iArr3 = new int[56];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 56) {
                break;
            }
            iArr3[i3] = iArr[h[i3] - 1];
            i2 = i3 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 16) {
                return;
            }
            a(iArr3, m[i5]);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < 48) {
                    iArr2[i5][i7] = iArr3[i[i7] - 1];
                    i6 = i7 + 1;
                }
            }
            i4 = i5 + 1;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, int i2) {
        boolean z;
        if (bArr2 != null && bArr != null) {
            try {
                byte[] c2 = c(bArr);
                byte[] b2 = b(bArr2);
                int length = b2.length;
                int i3 = length / 8;
                byte[] bArr3 = new byte[length];
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= i3) {
                        break;
                    }
                    byte[] bArr4 = new byte[8];
                    byte[] bArr5 = new byte[8];
                    System.arraycopy((Object) c2, 0, (Object) bArr4, 0, 8);
                    int i6 = i5 * 8;
                    System.arraycopy((Object) b2, i6, (Object) bArr5, 0, 8);
                    System.arraycopy((Object) b(bArr4, bArr5, i2), 0, (Object) bArr3, i6, 8);
                    i4 = i5 + 1;
                }
                byte[] bArr6 = bArr3;
                if (i2 == 0) {
                    int length2 = bArr2.length;
                    byte[] bArr7 = new byte[length2];
                    System.arraycopy((Object) bArr3, 0, (Object) bArr7, 0, length2);
                    int i7 = length2 - 1;
                    byte b3 = bArr7[i7];
                    bArr6 = bArr3;
                    if (b3 > 0) {
                        bArr6 = bArr3;
                        if (b3 <= 8) {
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= b3) {
                                    z = true;
                                    break;
                                } else if (b3 != bArr7[i7 - i9]) {
                                    z = false;
                                    break;
                                } else {
                                    i8 = i9 + 1;
                                }
                            }
                            bArr6 = bArr3;
                            if (z) {
                                int i10 = length2 - b3;
                                bArr6 = new byte[i10];
                                System.arraycopy((Object) bArr7, 0, (Object) bArr6, 0, i10);
                            }
                        }
                    }
                }
                return bArr6;
            } catch (Exception e2) {
                return bArr2;
            }
        }
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0081 A[LOOP:2: B:18:0x007b->B:20:0x0081, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(int[] r6, int r7, int[][] r8) {
        /*
            r0 = 8
            byte[] r0 = new byte[r0]
            r12 = r0
            r0 = 64
            int[] r0 = new int[r0]
            r13 = r0
            r0 = 64
            int[] r0 = new int[r0]
            r14 = r0
            r0 = 0
            r11 = r0
            r0 = 0
            r9 = r0
        L17:
            r0 = r9
            r1 = 64
            if (r0 >= r1) goto L31
            r0 = r13
            r1 = r9
            r2 = r6
            int[] r3 = com.tencent.smtt.sdk.stat.a.f
            r4 = r9
            r3 = r3[r4]
            r4 = 1
            int r3 = r3 - r4
            r2 = r2[r3]
            r0[r1] = r2
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L17
        L31:
            r0 = r7
            r1 = 1
            if (r0 != r1) goto L55
            r0 = 0
            r10 = r0
        L39:
            r0 = r11
            r9 = r0
            r0 = r10
            r1 = 16
            if (r0 >= r1) goto L7b
            r0 = r13
            r1 = r10
            r2 = r7
            r3 = r8
            a(r0, r1, r2, r3)
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            r10 = r0
            goto L39
        L55:
            r0 = r11
            r9 = r0
            r0 = r7
            if (r0 != 0) goto L7b
            r0 = 15
            r10 = r0
        L60:
            r0 = r11
            r9 = r0
            r0 = r10
            r1 = -1
            if (r0 <= r1) goto L7b
            r0 = r13
            r1 = r10
            r2 = r7
            r3 = r8
            a(r0, r1, r2, r3)
            r0 = r10
            r1 = 1
            int r0 = r0 - r1
            r10 = r0
            goto L60
        L7b:
            r0 = r9
            r1 = 64
            if (r0 >= r1) goto L96
            r0 = r14
            r1 = r9
            r2 = r13
            int[] r3 = com.tencent.smtt.sdk.stat.a.g
            r4 = r9
            r3 = r3[r4]
            r4 = 1
            int r3 = r3 - r4
            r2 = r2[r3]
            r0[r1] = r2
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L7b
        L96:
            r0 = r14
            r1 = r12
            a(r0, r1)
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.stat.a.a(int[], int, int[][]):byte[]");
    }

    private static int[] a(byte[] bArr) {
        int[] iArr = new int[8];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 8) {
                break;
            }
            iArr[i3] = bArr[i3];
            if (iArr[i3] < 0) {
                iArr[i3] = iArr[i3] + 256;
                iArr[i3] = iArr[i3] % 256;
            }
            i2 = i3 + 1;
        }
        int[] iArr2 = new int[64];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 8) {
                return iArr2;
            }
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < 8) {
                    iArr2[((i5 * 8) + 7) - i7] = iArr[i5] % 2;
                    iArr[i5] = iArr[i5] / 2;
                    i6 = i7 + 1;
                }
            }
            i4 = i5 + 1;
        }
    }

    private static byte[] b(byte[] bArr) {
        int length = bArr.length;
        int i2 = 8 - (length % 8);
        int i3 = length + i2;
        byte[] bArr2 = new byte[i3];
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, length);
        while (length < i3) {
            bArr2[length] = (byte) i2;
            length++;
        }
        return bArr2;
    }

    private static byte[] b(byte[] bArr, byte[] bArr2, int i2) {
        if (bArr.length == 8 && bArr2.length == 8 && (i2 == 1 || i2 == 0)) {
            int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, 16, 48);
            int[] a2 = a(bArr);
            int[] a3 = a(bArr2);
            a(a2, iArr);
            return a(a3, i2, iArr);
        }
        throw new RuntimeException("Data Format Error !");
    }

    private static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 8) {
                break;
            }
            bArr2[i3] = 0;
            i2 = i3 + 1;
        }
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, bArr.length > 8 ? 8 : bArr.length);
        return bArr2;
    }
}
