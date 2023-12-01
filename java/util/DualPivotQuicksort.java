package java.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/util/DualPivotQuicksort.class */
public final class DualPivotQuicksort {
    private static final int COUNTING_SORT_THRESHOLD_FOR_BYTE = 128;
    private static final int COUNTING_SORT_THRESHOLD_FOR_SHORT_OR_CHAR = 32768;
    private static final int INSERTION_SORT_THRESHOLD = 32;
    private static final int NUM_BYTE_VALUES = 256;
    private static final int NUM_CHAR_VALUES = 65536;
    private static final int NUM_SHORT_VALUES = 65536;

    private DualPivotQuicksort() {
    }

    private static void doSort(byte[] bArr, int i, int i2) {
        int i3;
        if ((i2 - i) + 1 < 32) {
            int i4 = i;
            while (true) {
                int i5 = i4 + 1;
                if (i5 > i2) {
                    return;
                }
                byte b = bArr[i5];
                int i6 = i5;
                while (true) {
                    i3 = i6 - 1;
                    if (i3 >= i && b < bArr[i3]) {
                        bArr[i3 + 1] = bArr[i3];
                        i6 = i3;
                    }
                }
                bArr[i3 + 1] = b;
                i4 = i5;
            }
        } else if ((i2 - i) + 1 <= 128) {
            dualPivotQuicksort(bArr, i, i2);
        } else {
            int[] iArr = new int[256];
            int i7 = i;
            while (true) {
                int i8 = i7;
                if (i8 > i2) {
                    break;
                }
                int i9 = bArr[i8] + 128;
                iArr[i9] = iArr[i9] + 1;
                i7 = i8 + 1;
            }
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= iArr.length || i > i2) {
                    return;
                }
                byte b2 = (byte) (i11 - 128);
                int i12 = iArr[i11];
                while (i12 > 0) {
                    bArr[i] = b2;
                    i12--;
                    i++;
                }
                i10 = i11 + 1;
            }
        }
    }

    private static void doSort(char[] cArr, int i, int i2) {
        int i3;
        if ((i2 - i) + 1 < 32) {
            int i4 = i;
            while (true) {
                int i5 = i4 + 1;
                if (i5 > i2) {
                    return;
                }
                char c = cArr[i5];
                int i6 = i5;
                while (true) {
                    i3 = i6 - 1;
                    if (i3 >= i && c < cArr[i3]) {
                        cArr[i3 + 1] = cArr[i3];
                        i6 = i3;
                    }
                }
                cArr[i3 + 1] = c;
                i4 = i5;
            }
        } else if ((i2 - i) + 1 <= 32768) {
            dualPivotQuicksort(cArr, i, i2);
        } else {
            int[] iArr = new int[65536];
            int i7 = i;
            while (true) {
                int i8 = i7;
                if (i8 > i2) {
                    break;
                }
                char c2 = cArr[i8];
                iArr[c2] = iArr[c2] + 1;
                i7 = i8 + 1;
            }
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= iArr.length || i > i2) {
                    return;
                }
                int i11 = iArr[i10];
                while (i11 > 0) {
                    cArr[i] = (char) i10;
                    i11--;
                    i++;
                }
                i9 = i10 + 1;
            }
        }
    }

    private static void doSort(double[] dArr, int i, int i2) {
        int i3;
        if ((i2 - i) + 1 >= 32) {
            dualPivotQuicksort(dArr, i, i2);
            return;
        }
        int i4 = i;
        while (true) {
            int i5 = i4 + 1;
            if (i5 > i2) {
                return;
            }
            double d = dArr[i5];
            int i6 = i5;
            while (true) {
                i3 = i6 - 1;
                if (i3 >= i && d < dArr[i3]) {
                    dArr[i3 + 1] = dArr[i3];
                    i6 = i3;
                }
            }
            dArr[i3 + 1] = d;
            i4 = i5;
        }
    }

    private static void doSort(float[] fArr, int i, int i2) {
        int i3;
        if ((i2 - i) + 1 >= 32) {
            dualPivotQuicksort(fArr, i, i2);
            return;
        }
        int i4 = i;
        while (true) {
            int i5 = i4 + 1;
            if (i5 > i2) {
                return;
            }
            float f = fArr[i5];
            int i6 = i5;
            while (true) {
                i3 = i6 - 1;
                if (i3 >= i && f < fArr[i3]) {
                    fArr[i3 + 1] = fArr[i3];
                    i6 = i3;
                }
            }
            fArr[i3 + 1] = f;
            i4 = i5;
        }
    }

    private static void doSort(int[] iArr, int i, int i2) {
        int i3;
        if ((i2 - i) + 1 >= 32) {
            dualPivotQuicksort(iArr, i, i2);
            return;
        }
        int i4 = i;
        while (true) {
            int i5 = i4 + 1;
            if (i5 > i2) {
                return;
            }
            int i6 = iArr[i5];
            int i7 = i5;
            while (true) {
                i3 = i7 - 1;
                if (i3 >= i && i6 < iArr[i3]) {
                    iArr[i3 + 1] = iArr[i3];
                    i7 = i3;
                }
            }
            iArr[i3 + 1] = i6;
            i4 = i5;
        }
    }

    private static void doSort(long[] jArr, int i, int i2) {
        int i3;
        if ((i2 - i) + 1 >= 32) {
            dualPivotQuicksort(jArr, i, i2);
            return;
        }
        int i4 = i;
        while (true) {
            int i5 = i4 + 1;
            if (i5 > i2) {
                return;
            }
            long j = jArr[i5];
            int i6 = i5;
            while (true) {
                i3 = i6 - 1;
                if (i3 >= i && j < jArr[i3]) {
                    jArr[i3 + 1] = jArr[i3];
                    i6 = i3;
                }
            }
            jArr[i3 + 1] = j;
            i4 = i5;
        }
    }

    private static void doSort(short[] sArr, int i, int i2) {
        int i3;
        if ((i2 - i) + 1 < 32) {
            int i4 = i;
            while (true) {
                int i5 = i4 + 1;
                if (i5 > i2) {
                    return;
                }
                short s = sArr[i5];
                int i6 = i5;
                while (true) {
                    i3 = i6 - 1;
                    if (i3 >= i && s < sArr[i3]) {
                        sArr[i3 + 1] = sArr[i3];
                        i6 = i3;
                    }
                }
                sArr[i3 + 1] = s;
                i4 = i5;
            }
        } else if ((i2 - i) + 1 <= 32768) {
            dualPivotQuicksort(sArr, i, i2);
        } else {
            int[] iArr = new int[65536];
            int i7 = i;
            while (true) {
                int i8 = i7;
                if (i8 > i2) {
                    break;
                }
                int i9 = sArr[i8] + 32768;
                iArr[i9] = iArr[i9] + 1;
                i7 = i8 + 1;
            }
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= iArr.length || i > i2) {
                    return;
                }
                short s2 = (short) (i11 - 32768);
                int i12 = iArr[i11];
                while (i12 > 0) {
                    sArr[i] = s2;
                    i12--;
                    i++;
                }
                i10 = i11 + 1;
            }
        }
    }

    private static void dualPivotQuicksort(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = ((i2 - i) + 1) / 6;
        int i6 = i + i5;
        int i7 = i2 - i5;
        int i8 = (i + i2) >>> 1;
        int i9 = i8 + i5;
        int i10 = i8 - i5;
        byte b = bArr[i6];
        byte b2 = bArr[i10];
        byte b3 = bArr[i8];
        byte b4 = bArr[i9];
        byte b5 = bArr[i7];
        byte b6 = b;
        byte b7 = b2;
        if (b > b2) {
            b6 = b2;
            b7 = b;
        }
        byte b8 = b4;
        byte b9 = b5;
        if (b4 > b5) {
            b8 = b5;
            b9 = b4;
        }
        byte b10 = b6;
        byte b11 = b3;
        if (b6 > b3) {
            b11 = b6;
            b10 = b3;
        }
        byte b12 = b7;
        byte b13 = b11;
        if (b7 > b11) {
            b12 = b11;
            b13 = b7;
        }
        byte b14 = b10;
        byte b15 = b8;
        if (b10 > b8) {
            b15 = b10;
            b14 = b8;
        }
        byte b16 = b13;
        byte b17 = b15;
        if (b13 > b15) {
            b16 = b15;
            b17 = b13;
        }
        byte b18 = b12;
        byte b19 = b9;
        if (b12 > b9) {
            b19 = b12;
            b18 = b9;
        }
        byte b20 = b18;
        byte b21 = b16;
        if (b18 > b16) {
            b20 = b16;
            b21 = b18;
        }
        byte b22 = b17;
        byte b23 = b19;
        if (b17 > b19) {
            b23 = b17;
            b22 = b19;
        }
        bArr[i6] = b14;
        bArr[i8] = b21;
        bArr[i7] = b23;
        bArr[i10] = bArr[i];
        bArr[i9] = bArr[i2];
        int i11 = i + 1;
        int i12 = i2 - 1;
        boolean z = b20 != b22;
        if (z) {
            int i13 = i11;
            loop0: while (true) {
                int i14 = i13;
                if (i14 > i12) {
                    int i15 = i11;
                    i3 = i12;
                    i4 = i15;
                    break;
                }
                byte b24 = bArr[i14];
                if (b24 < b20) {
                    if (i14 != i11) {
                        bArr[i14] = bArr[i11];
                        bArr[i11] = b24;
                    }
                    i11++;
                } else if (b24 > b22) {
                    while (bArr[i12] > b22) {
                        int i16 = i12 - 1;
                        if (i12 == i14) {
                            i4 = i11;
                            i3 = i16;
                            break loop0;
                        }
                        i12 = i16;
                    }
                    if (bArr[i12] < b20) {
                        bArr[i14] = bArr[i11];
                        bArr[i11] = bArr[i12];
                        bArr[i12] = b24;
                        i12--;
                        i11++;
                    } else {
                        bArr[i14] = bArr[i12];
                        bArr[i12] = b24;
                        i12--;
                    }
                } else {
                    continue;
                }
                i13 = i14 + 1;
            }
        } else {
            int i17 = i11;
            while (true) {
                int i18 = i17;
                if (i18 > i12) {
                    break;
                }
                byte b25 = bArr[i18];
                if (b25 != b20) {
                    int i19 = i12;
                    if (b25 < b20) {
                        if (i18 != i11) {
                            bArr[i18] = bArr[i11];
                            bArr[i11] = b25;
                        }
                        i11++;
                    } else {
                        while (bArr[i19] > b20) {
                            i19--;
                        }
                        if (bArr[i19] < b20) {
                            bArr[i18] = bArr[i11];
                            bArr[i11] = bArr[i19];
                            bArr[i19] = b25;
                            i12 = i19 - 1;
                            i11++;
                        } else {
                            bArr[i18] = b20;
                            bArr[i19] = b25;
                            i12 = i19 - 1;
                        }
                    }
                }
                i17 = i18 + 1;
            }
            int i20 = i11;
            i3 = i12;
            i4 = i20;
        }
        bArr[i] = bArr[i4 - 1];
        bArr[i4 - 1] = b20;
        bArr[i2] = bArr[i3 + 1];
        bArr[i3 + 1] = b22;
        doSort(bArr, i, i4 - 2);
        doSort(bArr, i3 + 2, i2);
        if (z) {
            int i21 = i3;
            int i22 = i4;
            if (i4 < i6) {
                i21 = i3;
                i22 = i4;
                if (i3 > i7) {
                    while (true) {
                        i21 = i3;
                        if (bArr[i4] != b20) {
                            break;
                        }
                        i4++;
                    }
                    while (bArr[i21] == b22) {
                        i21--;
                    }
                    int i23 = i4;
                    i22 = i4;
                    loop4: while (true) {
                        if (i23 > i21) {
                            break;
                        }
                        byte b26 = bArr[i23];
                        if (b26 == b22) {
                            while (bArr[i21] == b22) {
                                int i24 = i21 - 1;
                                if (i21 == i23) {
                                    i21 = i24;
                                    break loop4;
                                }
                                i21 = i24;
                            }
                            if (bArr[i21] == b20) {
                                bArr[i23] = bArr[i22];
                                bArr[i22] = b20;
                                i22++;
                            } else {
                                bArr[i23] = bArr[i21];
                            }
                            bArr[i21] = b22;
                            i21--;
                        } else if (b26 == b20) {
                            bArr[i23] = bArr[i22];
                            bArr[i22] = b20;
                            i22++;
                        }
                        i23++;
                    }
                }
            }
            doSort(bArr, i22, i21);
        }
    }

    private static void dualPivotQuicksort(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = ((i2 - i) + 1) / 6;
        int i6 = i + i5;
        int i7 = i2 - i5;
        int i8 = (i + i2) >>> 1;
        int i9 = i8 + i5;
        int i10 = i8 - i5;
        char c = cArr[i6];
        char c2 = cArr[i10];
        char c3 = cArr[i8];
        char c4 = cArr[i9];
        char c5 = cArr[i7];
        char c6 = c;
        char c7 = c2;
        if (c > c2) {
            c6 = c2;
            c7 = c;
        }
        char c8 = c4;
        char c9 = c5;
        if (c4 > c5) {
            c8 = c5;
            c9 = c4;
        }
        char c10 = c6;
        char c11 = c3;
        if (c6 > c3) {
            c11 = c6;
            c10 = c3;
        }
        char c12 = c7;
        char c13 = c11;
        if (c7 > c11) {
            c12 = c11;
            c13 = c7;
        }
        char c14 = c10;
        char c15 = c8;
        if (c10 > c8) {
            c15 = c10;
            c14 = c8;
        }
        char c16 = c13;
        char c17 = c15;
        if (c13 > c15) {
            c16 = c15;
            c17 = c13;
        }
        char c18 = c12;
        char c19 = c9;
        if (c12 > c9) {
            c19 = c12;
            c18 = c9;
        }
        char c20 = c18;
        char c21 = c16;
        if (c18 > c16) {
            c20 = c16;
            c21 = c18;
        }
        char c22 = c17;
        char c23 = c19;
        if (c17 > c19) {
            c23 = c17;
            c22 = c19;
        }
        cArr[i6] = c14;
        cArr[i8] = c21;
        cArr[i7] = c23;
        cArr[i10] = cArr[i];
        cArr[i9] = cArr[i2];
        int i11 = i + 1;
        int i12 = i2 - 1;
        boolean z = c20 != c22;
        if (z) {
            int i13 = i11;
            loop0: while (true) {
                int i14 = i13;
                if (i14 > i12) {
                    int i15 = i11;
                    i3 = i12;
                    i4 = i15;
                    break;
                }
                char c24 = cArr[i14];
                if (c24 < c20) {
                    if (i14 != i11) {
                        cArr[i14] = cArr[i11];
                        cArr[i11] = c24;
                    }
                    i11++;
                } else if (c24 > c22) {
                    while (cArr[i12] > c22) {
                        int i16 = i12 - 1;
                        if (i12 == i14) {
                            i4 = i11;
                            i3 = i16;
                            break loop0;
                        }
                        i12 = i16;
                    }
                    if (cArr[i12] < c20) {
                        cArr[i14] = cArr[i11];
                        cArr[i11] = cArr[i12];
                        cArr[i12] = c24;
                        i12--;
                        i11++;
                    } else {
                        cArr[i14] = cArr[i12];
                        cArr[i12] = c24;
                        i12--;
                    }
                } else {
                    continue;
                }
                i13 = i14 + 1;
            }
        } else {
            int i17 = i11;
            while (true) {
                int i18 = i17;
                if (i18 > i12) {
                    break;
                }
                char c25 = cArr[i18];
                if (c25 != c20) {
                    int i19 = i12;
                    if (c25 < c20) {
                        if (i18 != i11) {
                            cArr[i18] = cArr[i11];
                            cArr[i11] = c25;
                        }
                        i11++;
                    } else {
                        while (cArr[i19] > c20) {
                            i19--;
                        }
                        if (cArr[i19] < c20) {
                            cArr[i18] = cArr[i11];
                            cArr[i11] = cArr[i19];
                            cArr[i19] = c25;
                            i12 = i19 - 1;
                            i11++;
                        } else {
                            cArr[i18] = c20;
                            cArr[i19] = c25;
                            i12 = i19 - 1;
                        }
                    }
                }
                i17 = i18 + 1;
            }
            int i20 = i11;
            i3 = i12;
            i4 = i20;
        }
        cArr[i] = cArr[i4 - 1];
        cArr[i4 - 1] = c20;
        cArr[i2] = cArr[i3 + 1];
        cArr[i3 + 1] = c22;
        doSort(cArr, i, i4 - 2);
        doSort(cArr, i3 + 2, i2);
        if (z) {
            int i21 = i3;
            int i22 = i4;
            if (i4 < i6) {
                i21 = i3;
                i22 = i4;
                if (i3 > i7) {
                    while (true) {
                        i21 = i3;
                        if (cArr[i4] != c20) {
                            break;
                        }
                        i4++;
                    }
                    while (cArr[i21] == c22) {
                        i21--;
                    }
                    int i23 = i4;
                    i22 = i4;
                    loop4: while (true) {
                        if (i23 > i21) {
                            break;
                        }
                        char c26 = cArr[i23];
                        if (c26 == c22) {
                            while (cArr[i21] == c22) {
                                int i24 = i21 - 1;
                                if (i21 == i23) {
                                    i21 = i24;
                                    break loop4;
                                }
                                i21 = i24;
                            }
                            if (cArr[i21] == c20) {
                                cArr[i23] = cArr[i22];
                                cArr[i22] = c20;
                                i22++;
                            } else {
                                cArr[i23] = cArr[i21];
                            }
                            cArr[i21] = c22;
                            i21--;
                        } else if (c26 == c20) {
                            cArr[i23] = cArr[i22];
                            cArr[i22] = c20;
                            i22++;
                        }
                        i23++;
                    }
                }
            }
            doSort(cArr, i22, i21);
        }
    }

    private static void dualPivotQuicksort(double[] dArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = ((i2 - i) + 1) / 6;
        int i6 = i + i5;
        int i7 = i2 - i5;
        int i8 = (i + i2) >>> 1;
        int i9 = i8 + i5;
        int i10 = i8 - i5;
        double d = dArr[i6];
        double d2 = dArr[i10];
        double d3 = dArr[i8];
        double d4 = dArr[i9];
        double d5 = dArr[i7];
        double d6 = d;
        double d7 = d2;
        if (d > d2) {
            d6 = d2;
            d7 = d;
        }
        double d8 = d4;
        double d9 = d5;
        if (d4 > d5) {
            d8 = d5;
            d9 = d4;
        }
        double d10 = d6;
        double d11 = d3;
        if (d6 > d3) {
            d11 = d6;
            d10 = d3;
        }
        double d12 = d7;
        double d13 = d11;
        if (d7 > d11) {
            d12 = d11;
            d13 = d7;
        }
        double d14 = d10;
        double d15 = d8;
        if (d10 > d8) {
            d15 = d10;
            d14 = d8;
        }
        double d16 = d13;
        double d17 = d15;
        if (d13 > d15) {
            d16 = d15;
            d17 = d13;
        }
        double d18 = d12;
        double d19 = d9;
        if (d12 > d9) {
            d19 = d12;
            d18 = d9;
        }
        double d20 = d18;
        double d21 = d16;
        if (d18 > d16) {
            d20 = d16;
            d21 = d18;
        }
        double d22 = d17;
        double d23 = d19;
        if (d17 > d19) {
            d23 = d17;
            d22 = d19;
        }
        dArr[i6] = d14;
        dArr[i8] = d21;
        dArr[i7] = d23;
        dArr[i10] = dArr[i];
        dArr[i9] = dArr[i2];
        int i11 = i + 1;
        int i12 = i2 - 1;
        boolean z = d20 != d22;
        if (z) {
            int i13 = i11;
            loop0: while (true) {
                int i14 = i13;
                if (i14 > i12) {
                    int i15 = i11;
                    i3 = i12;
                    i4 = i15;
                    break;
                }
                double d24 = dArr[i14];
                if (d24 < d20) {
                    if (i14 != i11) {
                        dArr[i14] = dArr[i11];
                        dArr[i11] = d24;
                    }
                    i11++;
                } else if (d24 > d22) {
                    while (dArr[i12] > d22) {
                        int i16 = i12 - 1;
                        if (i12 == i14) {
                            i4 = i11;
                            i3 = i16;
                            break loop0;
                        }
                        i12 = i16;
                    }
                    if (dArr[i12] < d20) {
                        dArr[i14] = dArr[i11];
                        dArr[i11] = dArr[i12];
                        dArr[i12] = d24;
                        i12--;
                        i11++;
                    } else {
                        dArr[i14] = dArr[i12];
                        dArr[i12] = d24;
                        i12--;
                    }
                } else {
                    continue;
                }
                i13 = i14 + 1;
            }
        } else {
            int i17 = i11;
            while (true) {
                int i18 = i17;
                if (i18 > i12) {
                    break;
                }
                double d25 = dArr[i18];
                if (d25 != d20) {
                    int i19 = i12;
                    if (d25 < d20) {
                        if (i18 != i11) {
                            dArr[i18] = dArr[i11];
                            dArr[i11] = d25;
                        }
                        i11++;
                    } else {
                        while (dArr[i19] > d20) {
                            i19--;
                        }
                        if (dArr[i19] < d20) {
                            dArr[i18] = dArr[i11];
                            dArr[i11] = dArr[i19];
                            dArr[i19] = d25;
                            i12 = i19 - 1;
                            i11++;
                        } else {
                            dArr[i18] = d20;
                            dArr[i19] = d25;
                            i12 = i19 - 1;
                        }
                    }
                }
                i17 = i18 + 1;
            }
            int i20 = i11;
            i3 = i12;
            i4 = i20;
        }
        dArr[i] = dArr[i4 - 1];
        dArr[i4 - 1] = d20;
        dArr[i2] = dArr[i3 + 1];
        dArr[i3 + 1] = d22;
        doSort(dArr, i, i4 - 2);
        doSort(dArr, i3 + 2, i2);
        if (z) {
            int i21 = i3;
            int i22 = i4;
            if (i4 < i6) {
                i21 = i3;
                i22 = i4;
                if (i3 > i7) {
                    while (true) {
                        i21 = i3;
                        if (dArr[i4] != d20) {
                            break;
                        }
                        i4++;
                    }
                    while (dArr[i21] == d22) {
                        i21--;
                    }
                    int i23 = i4;
                    i22 = i4;
                    loop4: while (true) {
                        if (i23 > i21) {
                            break;
                        }
                        double d26 = dArr[i23];
                        if (d26 == d22) {
                            while (dArr[i21] == d22) {
                                int i24 = i21 - 1;
                                if (i21 == i23) {
                                    i21 = i24;
                                    break loop4;
                                }
                                i21 = i24;
                            }
                            if (dArr[i21] == d20) {
                                dArr[i23] = dArr[i22];
                                dArr[i22] = d20;
                                i22++;
                            } else {
                                dArr[i23] = dArr[i21];
                            }
                            dArr[i21] = d22;
                            i21--;
                        } else if (d26 == d20) {
                            dArr[i23] = dArr[i22];
                            dArr[i22] = d20;
                            i22++;
                        }
                        i23++;
                    }
                }
            }
            doSort(dArr, i22, i21);
        }
    }

    private static void dualPivotQuicksort(float[] fArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = ((i2 - i) + 1) / 6;
        int i6 = i + i5;
        int i7 = i2 - i5;
        int i8 = (i + i2) >>> 1;
        int i9 = i8 + i5;
        int i10 = i8 - i5;
        float f = fArr[i6];
        float f2 = fArr[i10];
        float f3 = fArr[i8];
        float f4 = fArr[i9];
        float f5 = fArr[i7];
        float f6 = f;
        float f7 = f2;
        if (f > f2) {
            f6 = f2;
            f7 = f;
        }
        float f8 = f4;
        float f9 = f5;
        if (f4 > f5) {
            f8 = f5;
            f9 = f4;
        }
        float f10 = f6;
        float f11 = f3;
        if (f6 > f3) {
            f11 = f6;
            f10 = f3;
        }
        float f12 = f7;
        float f13 = f11;
        if (f7 > f11) {
            f12 = f11;
            f13 = f7;
        }
        float f14 = f10;
        float f15 = f8;
        if (f10 > f8) {
            f15 = f10;
            f14 = f8;
        }
        float f16 = f13;
        float f17 = f15;
        if (f13 > f15) {
            f16 = f15;
            f17 = f13;
        }
        float f18 = f12;
        float f19 = f9;
        if (f12 > f9) {
            f19 = f12;
            f18 = f9;
        }
        float f20 = f18;
        float f21 = f16;
        if (f18 > f16) {
            f20 = f16;
            f21 = f18;
        }
        float f22 = f17;
        float f23 = f19;
        if (f17 > f19) {
            f23 = f17;
            f22 = f19;
        }
        fArr[i6] = f14;
        fArr[i8] = f21;
        fArr[i7] = f23;
        fArr[i10] = fArr[i];
        fArr[i9] = fArr[i2];
        int i11 = i + 1;
        int i12 = i2 - 1;
        boolean z = f20 != f22;
        if (z) {
            int i13 = i11;
            loop0: while (true) {
                int i14 = i13;
                if (i14 > i12) {
                    int i15 = i11;
                    i3 = i12;
                    i4 = i15;
                    break;
                }
                float f24 = fArr[i14];
                if (f24 < f20) {
                    if (i14 != i11) {
                        fArr[i14] = fArr[i11];
                        fArr[i11] = f24;
                    }
                    i11++;
                } else if (f24 > f22) {
                    while (fArr[i12] > f22) {
                        int i16 = i12 - 1;
                        if (i12 == i14) {
                            i4 = i11;
                            i3 = i16;
                            break loop0;
                        }
                        i12 = i16;
                    }
                    if (fArr[i12] < f20) {
                        fArr[i14] = fArr[i11];
                        fArr[i11] = fArr[i12];
                        fArr[i12] = f24;
                        i12--;
                        i11++;
                    } else {
                        fArr[i14] = fArr[i12];
                        fArr[i12] = f24;
                        i12--;
                    }
                } else {
                    continue;
                }
                i13 = i14 + 1;
            }
        } else {
            int i17 = i11;
            while (true) {
                int i18 = i17;
                if (i18 > i12) {
                    break;
                }
                float f25 = fArr[i18];
                if (f25 != f20) {
                    int i19 = i12;
                    if (f25 < f20) {
                        if (i18 != i11) {
                            fArr[i18] = fArr[i11];
                            fArr[i11] = f25;
                        }
                        i11++;
                    } else {
                        while (fArr[i19] > f20) {
                            i19--;
                        }
                        if (fArr[i19] < f20) {
                            fArr[i18] = fArr[i11];
                            fArr[i11] = fArr[i19];
                            fArr[i19] = f25;
                            i12 = i19 - 1;
                            i11++;
                        } else {
                            fArr[i18] = f20;
                            fArr[i19] = f25;
                            i12 = i19 - 1;
                        }
                    }
                }
                i17 = i18 + 1;
            }
            int i20 = i11;
            i3 = i12;
            i4 = i20;
        }
        fArr[i] = fArr[i4 - 1];
        fArr[i4 - 1] = f20;
        fArr[i2] = fArr[i3 + 1];
        fArr[i3 + 1] = f22;
        doSort(fArr, i, i4 - 2);
        doSort(fArr, i3 + 2, i2);
        if (z) {
            int i21 = i3;
            int i22 = i4;
            if (i4 < i6) {
                i21 = i3;
                i22 = i4;
                if (i3 > i7) {
                    while (true) {
                        i21 = i3;
                        if (fArr[i4] != f20) {
                            break;
                        }
                        i4++;
                    }
                    while (fArr[i21] == f22) {
                        i21--;
                    }
                    int i23 = i4;
                    i22 = i4;
                    loop4: while (true) {
                        if (i23 > i21) {
                            break;
                        }
                        float f26 = fArr[i23];
                        if (f26 == f22) {
                            while (fArr[i21] == f22) {
                                int i24 = i21 - 1;
                                if (i21 == i23) {
                                    i21 = i24;
                                    break loop4;
                                }
                                i21 = i24;
                            }
                            if (fArr[i21] == f20) {
                                fArr[i23] = fArr[i22];
                                fArr[i22] = f20;
                                i22++;
                            } else {
                                fArr[i23] = fArr[i21];
                            }
                            fArr[i21] = f22;
                            i21--;
                        } else if (f26 == f20) {
                            fArr[i23] = fArr[i22];
                            fArr[i22] = f20;
                            i22++;
                        }
                        i23++;
                    }
                }
            }
            doSort(fArr, i22, i21);
        }
    }

    private static void dualPivotQuicksort(int[] iArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = ((i2 - i) + 1) / 6;
        int i6 = i + i5;
        int i7 = i2 - i5;
        int i8 = (i + i2) >>> 1;
        int i9 = i8 + i5;
        int i10 = i8 - i5;
        int i11 = iArr[i6];
        int i12 = iArr[i10];
        int i13 = iArr[i8];
        int i14 = iArr[i9];
        int i15 = iArr[i7];
        int i16 = i11;
        int i17 = i12;
        if (i11 > i12) {
            i16 = i12;
            i17 = i11;
        }
        int i18 = i14;
        int i19 = i15;
        if (i14 > i15) {
            i18 = i15;
            i19 = i14;
        }
        int i20 = i16;
        int i21 = i13;
        if (i16 > i13) {
            i21 = i16;
            i20 = i13;
        }
        int i22 = i17;
        int i23 = i21;
        if (i17 > i21) {
            i22 = i21;
            i23 = i17;
        }
        int i24 = i20;
        int i25 = i18;
        if (i20 > i18) {
            i25 = i20;
            i24 = i18;
        }
        int i26 = i23;
        int i27 = i25;
        if (i23 > i25) {
            i26 = i25;
            i27 = i23;
        }
        int i28 = i22;
        int i29 = i19;
        if (i22 > i19) {
            i29 = i22;
            i28 = i19;
        }
        int i30 = i28;
        int i31 = i26;
        if (i28 > i26) {
            i30 = i26;
            i31 = i28;
        }
        int i32 = i27;
        int i33 = i29;
        if (i27 > i29) {
            i33 = i27;
            i32 = i29;
        }
        iArr[i6] = i24;
        iArr[i8] = i31;
        iArr[i7] = i33;
        iArr[i10] = iArr[i];
        iArr[i9] = iArr[i2];
        int i34 = i + 1;
        int i35 = i2 - 1;
        boolean z = i30 != i32;
        if (z) {
            int i36 = i34;
            loop0: while (true) {
                int i37 = i36;
                if (i37 > i35) {
                    int i38 = i34;
                    i3 = i35;
                    i4 = i38;
                    break;
                }
                int i39 = iArr[i37];
                if (i39 < i30) {
                    if (i37 != i34) {
                        iArr[i37] = iArr[i34];
                        iArr[i34] = i39;
                    }
                    i34++;
                } else if (i39 > i32) {
                    while (iArr[i35] > i32) {
                        int i40 = i35 - 1;
                        if (i35 == i37) {
                            i4 = i34;
                            i3 = i40;
                            break loop0;
                        }
                        i35 = i40;
                    }
                    if (iArr[i35] < i30) {
                        iArr[i37] = iArr[i34];
                        iArr[i34] = iArr[i35];
                        iArr[i35] = i39;
                        i35--;
                        i34++;
                    } else {
                        iArr[i37] = iArr[i35];
                        iArr[i35] = i39;
                        i35--;
                    }
                } else {
                    continue;
                }
                i36 = i37 + 1;
            }
        } else {
            int i41 = i34;
            while (true) {
                int i42 = i41;
                if (i42 > i35) {
                    break;
                }
                int i43 = iArr[i42];
                if (i43 != i30) {
                    int i44 = i35;
                    if (i43 < i30) {
                        if (i42 != i34) {
                            iArr[i42] = iArr[i34];
                            iArr[i34] = i43;
                        }
                        i34++;
                    } else {
                        while (iArr[i44] > i30) {
                            i44--;
                        }
                        if (iArr[i44] < i30) {
                            iArr[i42] = iArr[i34];
                            iArr[i34] = iArr[i44];
                            iArr[i44] = i43;
                            i35 = i44 - 1;
                            i34++;
                        } else {
                            iArr[i42] = i30;
                            iArr[i44] = i43;
                            i35 = i44 - 1;
                        }
                    }
                }
                i41 = i42 + 1;
            }
            int i45 = i34;
            i3 = i35;
            i4 = i45;
        }
        iArr[i] = iArr[i4 - 1];
        iArr[i4 - 1] = i30;
        iArr[i2] = iArr[i3 + 1];
        iArr[i3 + 1] = i32;
        doSort(iArr, i, i4 - 2);
        doSort(iArr, i3 + 2, i2);
        if (z) {
            int i46 = i3;
            int i47 = i4;
            if (i4 < i6) {
                i46 = i3;
                i47 = i4;
                if (i3 > i7) {
                    while (true) {
                        i46 = i3;
                        if (iArr[i4] != i30) {
                            break;
                        }
                        i4++;
                    }
                    while (iArr[i46] == i32) {
                        i46--;
                    }
                    int i48 = i4;
                    i47 = i4;
                    loop4: while (true) {
                        if (i48 > i46) {
                            break;
                        }
                        int i49 = iArr[i48];
                        if (i49 == i32) {
                            while (iArr[i46] == i32) {
                                int i50 = i46 - 1;
                                if (i46 == i48) {
                                    i46 = i50;
                                    break loop4;
                                }
                                i46 = i50;
                            }
                            if (iArr[i46] == i30) {
                                iArr[i48] = iArr[i47];
                                iArr[i47] = i30;
                                i47++;
                            } else {
                                iArr[i48] = iArr[i46];
                            }
                            iArr[i46] = i32;
                            i46--;
                        } else if (i49 == i30) {
                            iArr[i48] = iArr[i47];
                            iArr[i47] = i30;
                            i47++;
                        }
                        i48++;
                    }
                }
            }
            doSort(iArr, i47, i46);
        }
    }

    private static void dualPivotQuicksort(long[] jArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = ((i2 - i) + 1) / 6;
        int i6 = i + i5;
        int i7 = i2 - i5;
        int i8 = (i + i2) >>> 1;
        int i9 = i8 + i5;
        int i10 = i8 - i5;
        long j = jArr[i6];
        long j2 = jArr[i10];
        long j3 = jArr[i8];
        long j4 = jArr[i9];
        long j5 = jArr[i7];
        long j6 = j;
        long j7 = j2;
        if (j > j2) {
            j6 = j2;
            j7 = j;
        }
        long j8 = j4;
        long j9 = j5;
        if (j4 > j5) {
            j8 = j5;
            j9 = j4;
        }
        long j10 = j6;
        long j11 = j3;
        if (j6 > j3) {
            j11 = j6;
            j10 = j3;
        }
        long j12 = j7;
        long j13 = j11;
        if (j7 > j11) {
            j12 = j11;
            j13 = j7;
        }
        long j14 = j10;
        long j15 = j8;
        if (j10 > j8) {
            j15 = j10;
            j14 = j8;
        }
        long j16 = j13;
        long j17 = j15;
        if (j13 > j15) {
            j16 = j15;
            j17 = j13;
        }
        long j18 = j12;
        long j19 = j9;
        if (j12 > j9) {
            j19 = j12;
            j18 = j9;
        }
        long j20 = j18;
        long j21 = j16;
        if (j18 > j16) {
            j20 = j16;
            j21 = j18;
        }
        long j22 = j17;
        long j23 = j19;
        if (j17 > j19) {
            j23 = j17;
            j22 = j19;
        }
        jArr[i6] = j14;
        jArr[i8] = j21;
        jArr[i7] = j23;
        jArr[i10] = jArr[i];
        jArr[i9] = jArr[i2];
        int i11 = i + 1;
        int i12 = i2 - 1;
        boolean z = j20 != j22;
        if (z) {
            int i13 = i11;
            loop0: while (true) {
                int i14 = i13;
                if (i14 > i12) {
                    int i15 = i11;
                    i3 = i12;
                    i4 = i15;
                    break;
                }
                long j24 = jArr[i14];
                if (j24 < j20) {
                    if (i14 != i11) {
                        jArr[i14] = jArr[i11];
                        jArr[i11] = j24;
                    }
                    i11++;
                } else if (j24 > j22) {
                    while (jArr[i12] > j22) {
                        int i16 = i12 - 1;
                        if (i12 == i14) {
                            i4 = i11;
                            i3 = i16;
                            break loop0;
                        }
                        i12 = i16;
                    }
                    if (jArr[i12] < j20) {
                        jArr[i14] = jArr[i11];
                        jArr[i11] = jArr[i12];
                        jArr[i12] = j24;
                        i12--;
                        i11++;
                    } else {
                        jArr[i14] = jArr[i12];
                        jArr[i12] = j24;
                        i12--;
                    }
                } else {
                    continue;
                }
                i13 = i14 + 1;
            }
        } else {
            int i17 = i11;
            while (true) {
                int i18 = i17;
                if (i18 > i12) {
                    break;
                }
                long j25 = jArr[i18];
                if (j25 != j20) {
                    int i19 = i12;
                    if (j25 < j20) {
                        if (i18 != i11) {
                            jArr[i18] = jArr[i11];
                            jArr[i11] = j25;
                        }
                        i11++;
                    } else {
                        while (jArr[i19] > j20) {
                            i19--;
                        }
                        if (jArr[i19] < j20) {
                            jArr[i18] = jArr[i11];
                            jArr[i11] = jArr[i19];
                            jArr[i19] = j25;
                            i12 = i19 - 1;
                            i11++;
                        } else {
                            jArr[i18] = j20;
                            jArr[i19] = j25;
                            i12 = i19 - 1;
                        }
                    }
                }
                i17 = i18 + 1;
            }
            int i20 = i11;
            i3 = i12;
            i4 = i20;
        }
        jArr[i] = jArr[i4 - 1];
        jArr[i4 - 1] = j20;
        jArr[i2] = jArr[i3 + 1];
        jArr[i3 + 1] = j22;
        doSort(jArr, i, i4 - 2);
        doSort(jArr, i3 + 2, i2);
        if (z) {
            int i21 = i3;
            int i22 = i4;
            if (i4 < i6) {
                i21 = i3;
                i22 = i4;
                if (i3 > i7) {
                    while (true) {
                        i21 = i3;
                        if (jArr[i4] != j20) {
                            break;
                        }
                        i4++;
                    }
                    while (jArr[i21] == j22) {
                        i21--;
                    }
                    int i23 = i4;
                    i22 = i4;
                    loop4: while (true) {
                        if (i23 > i21) {
                            break;
                        }
                        long j26 = jArr[i23];
                        if (j26 == j22) {
                            while (jArr[i21] == j22) {
                                int i24 = i21 - 1;
                                if (i21 == i23) {
                                    i21 = i24;
                                    break loop4;
                                }
                                i21 = i24;
                            }
                            if (jArr[i21] == j20) {
                                jArr[i23] = jArr[i22];
                                jArr[i22] = j20;
                                i22++;
                            } else {
                                jArr[i23] = jArr[i21];
                            }
                            jArr[i21] = j22;
                            i21--;
                        } else if (j26 == j20) {
                            jArr[i23] = jArr[i22];
                            jArr[i22] = j20;
                            i22++;
                        }
                        i23++;
                    }
                }
            }
            doSort(jArr, i22, i21);
        }
    }

    private static void dualPivotQuicksort(short[] sArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = ((i2 - i) + 1) / 6;
        int i6 = i + i5;
        int i7 = i2 - i5;
        int i8 = (i + i2) >>> 1;
        int i9 = i8 + i5;
        int i10 = i8 - i5;
        short s = sArr[i6];
        short s2 = sArr[i10];
        short s3 = sArr[i8];
        short s4 = sArr[i9];
        short s5 = sArr[i7];
        short s6 = s;
        short s7 = s2;
        if (s > s2) {
            s6 = s2;
            s7 = s;
        }
        short s8 = s4;
        short s9 = s5;
        if (s4 > s5) {
            s8 = s5;
            s9 = s4;
        }
        short s10 = s6;
        short s11 = s3;
        if (s6 > s3) {
            s11 = s6;
            s10 = s3;
        }
        short s12 = s7;
        short s13 = s11;
        if (s7 > s11) {
            s12 = s11;
            s13 = s7;
        }
        short s14 = s10;
        short s15 = s8;
        if (s10 > s8) {
            s15 = s10;
            s14 = s8;
        }
        short s16 = s13;
        short s17 = s15;
        if (s13 > s15) {
            s16 = s15;
            s17 = s13;
        }
        short s18 = s12;
        short s19 = s9;
        if (s12 > s9) {
            s19 = s12;
            s18 = s9;
        }
        short s20 = s18;
        short s21 = s16;
        if (s18 > s16) {
            s20 = s16;
            s21 = s18;
        }
        short s22 = s17;
        short s23 = s19;
        if (s17 > s19) {
            s23 = s17;
            s22 = s19;
        }
        sArr[i6] = s14;
        sArr[i8] = s21;
        sArr[i7] = s23;
        sArr[i10] = sArr[i];
        sArr[i9] = sArr[i2];
        int i11 = i + 1;
        int i12 = i2 - 1;
        boolean z = s20 != s22;
        if (z) {
            int i13 = i11;
            loop0: while (true) {
                int i14 = i13;
                if (i14 > i12) {
                    int i15 = i11;
                    i3 = i12;
                    i4 = i15;
                    break;
                }
                short s24 = sArr[i14];
                if (s24 < s20) {
                    if (i14 != i11) {
                        sArr[i14] = sArr[i11];
                        sArr[i11] = s24;
                    }
                    i11++;
                } else if (s24 > s22) {
                    while (sArr[i12] > s22) {
                        int i16 = i12 - 1;
                        if (i12 == i14) {
                            i4 = i11;
                            i3 = i16;
                            break loop0;
                        }
                        i12 = i16;
                    }
                    if (sArr[i12] < s20) {
                        sArr[i14] = sArr[i11];
                        sArr[i11] = sArr[i12];
                        sArr[i12] = s24;
                        i12--;
                        i11++;
                    } else {
                        sArr[i14] = sArr[i12];
                        sArr[i12] = s24;
                        i12--;
                    }
                } else {
                    continue;
                }
                i13 = i14 + 1;
            }
        } else {
            int i17 = i11;
            while (true) {
                int i18 = i17;
                if (i18 > i12) {
                    break;
                }
                short s25 = sArr[i18];
                if (s25 != s20) {
                    int i19 = i12;
                    if (s25 < s20) {
                        if (i18 != i11) {
                            sArr[i18] = sArr[i11];
                            sArr[i11] = s25;
                        }
                        i11++;
                    } else {
                        while (sArr[i19] > s20) {
                            i19--;
                        }
                        if (sArr[i19] < s20) {
                            sArr[i18] = sArr[i11];
                            sArr[i11] = sArr[i19];
                            sArr[i19] = s25;
                            i12 = i19 - 1;
                            i11++;
                        } else {
                            sArr[i18] = s20;
                            sArr[i19] = s25;
                            i12 = i19 - 1;
                        }
                    }
                }
                i17 = i18 + 1;
            }
            int i20 = i11;
            i3 = i12;
            i4 = i20;
        }
        sArr[i] = sArr[i4 - 1];
        sArr[i4 - 1] = s20;
        sArr[i2] = sArr[i3 + 1];
        sArr[i3 + 1] = s22;
        doSort(sArr, i, i4 - 2);
        doSort(sArr, i3 + 2, i2);
        if (z) {
            int i21 = i3;
            int i22 = i4;
            if (i4 < i6) {
                i21 = i3;
                i22 = i4;
                if (i3 > i7) {
                    while (true) {
                        i21 = i3;
                        if (sArr[i4] != s20) {
                            break;
                        }
                        i4++;
                    }
                    while (sArr[i21] == s22) {
                        i21--;
                    }
                    int i23 = i4;
                    i22 = i4;
                    loop4: while (true) {
                        if (i23 > i21) {
                            break;
                        }
                        short s26 = sArr[i23];
                        if (s26 == s22) {
                            while (sArr[i21] == s22) {
                                int i24 = i21 - 1;
                                if (i21 == i23) {
                                    i21 = i24;
                                    break loop4;
                                }
                                i21 = i24;
                            }
                            if (sArr[i21] == s20) {
                                sArr[i23] = sArr[i22];
                                sArr[i22] = s20;
                                i22++;
                            } else {
                                sArr[i23] = sArr[i21];
                            }
                            sArr[i21] = s22;
                            i21--;
                        } else if (s26 == s20) {
                            sArr[i23] = sArr[i22];
                            sArr[i22] = s20;
                            i22++;
                        }
                        i23++;
                    }
                }
            }
            doSort(sArr, i22, i21);
        }
    }

    private static int findAnyZero(double[] dArr, int i, int i2) {
        while (true) {
            int i3 = (i + i2) >>> 1;
            double d = dArr[i3];
            if (d < 0.0d) {
                i = i3 + 1;
            } else if (d <= 0.0d) {
                return i3;
            } else {
                i2 = i3 - 1;
            }
        }
    }

    private static int findAnyZero(float[] fArr, int i, int i2) {
        while (true) {
            int i3 = (i + i2) >>> 1;
            float f = fArr[i3];
            if (f < 0.0f) {
                i = i3 + 1;
            } else if (f <= 0.0f) {
                return i3;
            } else {
                i2 = i3 - 1;
            }
        }
    }

    public static void sort(byte[] bArr) {
        doSort(bArr, 0, bArr.length - 1);
    }

    public static void sort(byte[] bArr, int i, int i2) {
        Arrays.checkStartAndEnd(bArr.length, i, i2);
        doSort(bArr, i, i2 - 1);
    }

    public static void sort(char[] cArr) {
        doSort(cArr, 0, cArr.length - 1);
    }

    public static void sort(char[] cArr, int i, int i2) {
        Arrays.checkStartAndEnd(cArr.length, i, i2);
        doSort(cArr, i, i2 - 1);
    }

    public static void sort(double[] dArr) {
        sortNegZeroAndNaN(dArr, 0, dArr.length - 1);
    }

    public static void sort(double[] dArr, int i, int i2) {
        Arrays.checkStartAndEnd(dArr.length, i, i2);
        sortNegZeroAndNaN(dArr, i, i2 - 1);
    }

    public static void sort(float[] fArr) {
        sortNegZeroAndNaN(fArr, 0, fArr.length - 1);
    }

    public static void sort(float[] fArr, int i, int i2) {
        Arrays.checkStartAndEnd(fArr.length, i, i2);
        sortNegZeroAndNaN(fArr, i, i2 - 1);
    }

    public static void sort(int[] iArr) {
        doSort(iArr, 0, iArr.length - 1);
    }

    public static void sort(int[] iArr, int i, int i2) {
        Arrays.checkStartAndEnd(iArr.length, i, i2);
        doSort(iArr, i, i2 - 1);
    }

    public static void sort(long[] jArr) {
        doSort(jArr, 0, jArr.length - 1);
    }

    public static void sort(long[] jArr, int i, int i2) {
        Arrays.checkStartAndEnd(jArr.length, i, i2);
        doSort(jArr, i, i2 - 1);
    }

    public static void sort(short[] sArr) {
        doSort(sArr, 0, sArr.length - 1);
    }

    public static void sort(short[] sArr, int i, int i2) {
        Arrays.checkStartAndEnd(sArr.length, i, i2);
        doSort(sArr, i, i2 - 1);
    }

    private static void sortNegZeroAndNaN(double[] dArr, int i, int i2) {
        long doubleToLongBits = Double.doubleToLongBits(0.0d);
        int i3 = 0;
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 > i2) {
                break;
            }
            double d = dArr[i5];
            if (d == 0.0d && doubleToLongBits == Double.doubleToRawLongBits(d)) {
                dArr[i5] = 0.0d;
                i3++;
            } else if (d != d) {
                dArr[i5] = dArr[i2];
                dArr[i2] = Double.NaN;
                i5--;
                i2--;
            }
            i4 = i5 + 1;
        }
        doSort(dArr, i, i2);
        if (i3 == 0) {
            return;
        }
        int findAnyZero = findAnyZero(dArr, i, i2);
        int i6 = findAnyZero;
        while (true) {
            int i7 = i6 - 1;
            if (i7 < i || dArr[i7] != 0.0d) {
                break;
            }
            findAnyZero = i7;
            i6 = i7;
        }
        int i8 = findAnyZero;
        while (true) {
            int i9 = i8;
            if (i9 >= findAnyZero + i3) {
                return;
            }
            dArr[i9] = 0.0d;
            i8 = i9 + 1;
        }
    }

    private static void sortNegZeroAndNaN(float[] fArr, int i, int i2) {
        int floatToIntBits = Float.floatToIntBits(0.0f);
        int i3 = 0;
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 > i2) {
                break;
            }
            float f = fArr[i5];
            if (f == 0.0f && floatToIntBits == Float.floatToRawIntBits(f)) {
                fArr[i5] = 0.0f;
                i3++;
            } else if (f != f) {
                fArr[i5] = fArr[i2];
                fArr[i2] = Float.NaN;
                i5--;
                i2--;
            }
            i4 = i5 + 1;
        }
        doSort(fArr, i, i2);
        if (i3 == 0) {
            return;
        }
        int findAnyZero = findAnyZero(fArr, i, i2);
        int i6 = findAnyZero;
        while (true) {
            int i7 = i6 - 1;
            if (i7 < i || fArr[i7] != 0.0f) {
                break;
            }
            findAnyZero = i7;
            i6 = i7;
        }
        int i8 = findAnyZero;
        while (true) {
            int i9 = i8;
            if (i9 >= findAnyZero + i3) {
                return;
            }
            fArr[i9] = 0.0f;
            i8 = i9 + 1;
        }
    }
}
