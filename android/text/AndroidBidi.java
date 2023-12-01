package android.text;

import android.text.Layout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/text/AndroidBidi.class */
public class AndroidBidi {
    AndroidBidi() {
    }

    public static int bidi(int i, char[] cArr, byte[] bArr, int i2, boolean z) {
        int i3;
        if (cArr == null || bArr == null) {
            throw new NullPointerException();
        }
        if (i2 < 0 || cArr.length < i2 || bArr.length < i2) {
            throw new IndexOutOfBoundsException();
        }
        switch (i) {
            case -2:
                i3 = -1;
                break;
            case -1:
                i3 = 1;
                break;
            case 0:
            default:
                i3 = 0;
                break;
            case 1:
                i3 = 0;
                break;
            case 2:
                i3 = -2;
                break;
        }
        return (runBidi(i3, cArr, bArr, i2, z) & 1) == 0 ? 1 : -1;
    }

    public static Layout.Directions directions(int i, byte[] bArr, int i2, char[] cArr, int i3, int i4) {
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (i4 == 0) {
            return Layout.DIRS_ALL_LEFT_TO_RIGHT;
        }
        int i11 = i == 1 ? 0 : 1;
        int i12 = bArr[i2];
        int i13 = i12;
        int i14 = 1;
        int i15 = i2 + 1;
        while (i15 < i2 + i4) {
            byte b = bArr[i15];
            int i16 = i12;
            int i17 = i14;
            if (b != i12) {
                i16 = b;
                i17 = i14 + 1;
            }
            i15++;
            i12 = i16;
            i14 = i17;
        }
        int i18 = i14;
        int i19 = i4;
        if ((i12 & 1) != (i11 & 1)) {
            int i20 = i4;
            while (true) {
                int i21 = i20 - 1;
                i10 = i21;
                if (i21 < 0) {
                    break;
                }
                char c2 = cArr[i3 + i21];
                if (c2 == '\n') {
                    i10 = i21 - 1;
                    break;
                }
                i20 = i21;
                if (c2 != ' ') {
                    i20 = i21;
                    if (c2 != '\t') {
                        i10 = i21;
                        break;
                    }
                }
            }
            int i22 = i10 + 1;
            i18 = i14;
            i19 = i22;
            if (i22 != i4) {
                i18 = i14 + 1;
                i19 = i22;
            }
        }
        if (i18 == 1 && i13 == i11) {
            return (i13 & 1) != 0 ? Layout.DIRS_ALL_RIGHT_TO_LEFT : Layout.DIRS_ALL_LEFT_TO_RIGHT;
        }
        int[] iArr = new int[i18 * 2];
        int i23 = i13;
        int i24 = i13 << 26;
        int i25 = i2;
        int i26 = i13;
        int i27 = i2;
        int i28 = 1;
        while (i27 < i2 + i19) {
            byte b2 = bArr[i27];
            if (b2 != i26) {
                if (b2 > i23) {
                    i9 = b2;
                    i7 = i13;
                } else {
                    i9 = i23;
                    i7 = i13;
                    if (b2 < i13) {
                        i7 = b2;
                        i9 = i23;
                    }
                }
                int i29 = i28 + 1;
                iArr[i28] = (i27 - i25) | i24;
                iArr[i29] = i27 - i2;
                i24 = b2 << 26;
                i25 = i27;
                i8 = i29 + 1;
                i23 = i9;
                i26 = b2;
            } else {
                i7 = i13;
                i8 = i28;
            }
            i27++;
            i28 = i8;
            i13 = i7;
        }
        iArr[i28] = ((i2 + i19) - i25) | i24;
        if (i19 < i4) {
            int i30 = i28 + 1;
            iArr[i30] = i19;
            iArr[i30 + 1] = (i4 - i19) | (i11 << 26);
        }
        if ((i13 & 1) == i11) {
            i5 = i13 + 1;
            z = i23 > i5;
        } else {
            i5 = i13;
            z = i18 > 1;
        }
        if (z) {
            int i31 = i23;
            while (true) {
                int i32 = i31 - 1;
                if (i32 < i5) {
                    break;
                }
                int i33 = 0;
                while (true) {
                    int i34 = i33;
                    if (i34 < iArr.length) {
                        int i35 = i34;
                        if (bArr[iArr[i34]] >= i32) {
                            int i36 = i34;
                            while (true) {
                                i6 = i36 + 2;
                                if (i6 >= iArr.length || bArr[iArr[i6]] < i32) {
                                    break;
                                }
                                i36 = i6;
                            }
                            int i37 = i34;
                            int i38 = i6 - 2;
                            while (true) {
                                int i39 = i38;
                                if (i37 >= i39) {
                                    break;
                                }
                                int i40 = iArr[i37];
                                iArr[i37] = iArr[i39];
                                iArr[i39] = i40;
                                int i41 = iArr[i37 + 1];
                                iArr[i37 + 1] = iArr[i39 + 1];
                                iArr[i39 + 1] = i41;
                                i37 += 2;
                                i38 = i39 - 2;
                            }
                            i35 = i6 + 2;
                        }
                        i33 = i35 + 2;
                    }
                }
                i31 = i32;
            }
        }
        return new Layout.Directions(iArr);
    }

    private static native int runBidi(int i, char[] cArr, byte[] bArr, int i2, boolean z);
}
