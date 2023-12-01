package java.math;

import android.widget.ExpandableListView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/math/Conversion.class */
public class Conversion {
    static final int[] digitFitInInt = {-1, -1, 31, 19, 15, 13, 11, 11, 10, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5};
    static final int[] bigRadices = {Integer.MIN_VALUE, 1162261467, 1073741824, 1220703125, 362797056, 1977326743, 1073741824, 387420489, 1000000000, 214358881, 429981696, 815730721, 1475789056, 170859375, 268435456, 410338673, 612220032, 893871739, 1280000000, 1801088541, 113379904, 148035889, 191102976, 244140625, 308915776, 387420489, 481890304, 594823321, 729000000, 887503681, 1073741824, 1291467969, 1544804416, 1838265625, 60466176};

    private Conversion() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bc, code lost:
        if (java.math.BitLevel.nonZeroDroppedBits(r0, r7.digits) != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double bigInteger2Double(java.math.BigInteger r7) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.Conversion.bigInteger2Double(java.math.BigInteger):double");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0170 A[LOOP:4: B:50:0x0168->B:52:0x0170, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String bigInteger2String(java.math.BigInteger r7, int r8) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.Conversion.bigInteger2String(java.math.BigInteger, int):java.lang.String");
    }

    static long divideLongByBillion(long j) {
        long j2;
        long j3;
        if (j >= 0) {
            j3 = j % 1000000000;
            j2 = j / 1000000000;
        } else {
            long j4 = j >>> 1;
            j2 = j4 / 500000000;
            j3 = ((j4 % 500000000) << 1) + (1 & j);
        }
        return (j3 << 32) | (ExpandableListView.PACKED_POSITION_VALUE_NULL & j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toDecimalScaledString(long j, int i) {
        long j2;
        int i2;
        boolean z = j < 0;
        long j3 = j;
        if (z) {
            j3 = -j;
        }
        if (j3 == 0) {
            switch (i) {
                case 0:
                    return "0";
                case 1:
                    return "0.0";
                case 2:
                    return "0.00";
                case 3:
                    return "0.000";
                case 4:
                    return "0.0000";
                case 5:
                    return "0.00000";
                case 6:
                    return "0.000000";
                default:
                    StringBuilder sb = new StringBuilder();
                    if (i < 0) {
                        sb.append("0E+");
                    } else {
                        sb.append("0E");
                    }
                    sb.append(i == Integer.MIN_VALUE ? "2147483648" : Integer.toString(-i));
                    return sb.toString();
            }
        }
        char[] cArr = new char[19];
        int i3 = 18;
        long j4 = j3;
        do {
            j2 = j4 / 10;
            i2 = i3 - 1;
            cArr[i2] = (char) (48 + (j4 - (10 * j2)));
            i3 = i2;
            j4 = j2;
        } while (j2 != 0);
        long j5 = ((18 - i2) - i) - 1;
        if (i == 0) {
            int i4 = i2;
            if (z) {
                i4 = i2 - 1;
                cArr[i4] = '-';
            }
            return new String(cArr, i4, 18 - i4);
        } else if (i <= 0 || j5 < -6) {
            int i5 = i2 + 1;
            StringBuilder sb2 = new StringBuilder(34 - i5);
            if (z) {
                sb2.append('-');
            }
            if (18 - i5 >= 1) {
                sb2.append(cArr[i2]);
                sb2.append('.');
                sb2.append(cArr, i2 + 1, (18 - i2) - 1);
            } else {
                sb2.append(cArr, i2, 18 - i2);
            }
            sb2.append('E');
            if (j5 > 0) {
                sb2.append('+');
            }
            sb2.append(Long.toString(j5));
            return sb2.toString();
        } else if (j5 >= 0) {
            int i6 = i2 + ((int) j5);
            int i7 = 18;
            while (true) {
                int i8 = i7 - 1;
                if (i8 < i6) {
                    break;
                }
                cArr[i8 + 1] = cArr[i8];
                i7 = i8;
            }
            cArr[i6 + 1] = '.';
            int i9 = i2;
            if (z) {
                i9 = i2 - 1;
                cArr[i9] = '-';
            }
            return new String(cArr, i9, (18 - i9) + 1);
        } else {
            int i10 = 2;
            while (true) {
                int i11 = i10;
                if (i11 >= (-j5) + 1) {
                    break;
                }
                i2--;
                cArr[i2] = '0';
                i10 = i11 + 1;
            }
            int i12 = i2 - 1;
            cArr[i12] = '.';
            int i13 = i12 - 1;
            cArr[i13] = '0';
            int i14 = i13;
            if (z) {
                i14 = i13 - 1;
                cArr[i14] = '-';
            }
            return new String(cArr, i14, 18 - i14);
        }
    }

    static String toDecimalScaledString(BigInteger bigInteger, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        int i6;
        bigInteger.prepareJavaRepresentation();
        int i7 = bigInteger.sign;
        int i8 = bigInteger.numberLength;
        int[] iArr = bigInteger.digits;
        if (i7 == 0) {
            switch (i) {
                case 0:
                    return "0";
                case 1:
                    return "0.0";
                case 2:
                    return "0.00";
                case 3:
                    return "0.000";
                case 4:
                    return "0.0000";
                case 5:
                    return "0.00000";
                case 6:
                    return "0.000000";
                default:
                    StringBuilder sb = new StringBuilder();
                    if (i < 0) {
                        sb.append("0E+");
                    } else {
                        sb.append("0E");
                    }
                    sb.append(-i);
                    return sb.toString();
            }
        }
        int i9 = (i8 * 10) + 1 + 7;
        char[] cArr = new char[i9 + 1];
        int i10 = i9;
        if (i8 != 1) {
            int[] iArr2 = new int[i8];
            System.arraycopy(iArr, 0, iArr2, 0, i8);
            loop4: while (true) {
                int i11 = i10;
                long j2 = 0;
                int i12 = i8;
                while (true) {
                    int i13 = i12 - 1;
                    if (i13 < 0) {
                        break;
                    }
                    long divideLongByBillion = divideLongByBillion((j2 << 32) + (iArr2[i13] & ExpandableListView.PACKED_POSITION_VALUE_NULL));
                    iArr2[i13] = (int) divideLongByBillion;
                    j2 = (int) (divideLongByBillion >> 32);
                    i12 = i13;
                }
                int i14 = (int) j2;
                int i15 = i11;
                do {
                    i2 = i15 - 1;
                    cArr[i2] = (char) ((i14 % 10) + 48);
                    i14 /= 10;
                    if (i14 == 0) {
                        break;
                    }
                    i15 = i2;
                } while (i2 != 0);
                i10 = i2;
                for (int i16 = 0; i16 < (9 - i11) + i2 && i10 > 0; i16++) {
                    i10--;
                    cArr[i10] = '0';
                }
                while (true) {
                    i8--;
                    if (iArr2[i8] == 0) {
                        if (i8 == 0) {
                            break loop4;
                        }
                    }
                }
                i8++;
            }
            int i17 = i10;
            while (true) {
                int i18 = i17;
                i3 = i18;
                if (cArr[i18] != '0') {
                    break;
                }
                i17 = i18 + 1;
            }
        } else {
            int i19 = iArr[0];
            if (i19 < 0) {
                long j3 = i19 & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                do {
                    j = j3 / 10;
                    i6 = i10 - 1;
                    cArr[i6] = (char) (((int) (j3 - (10 * j))) + 48);
                    i10 = i6;
                    j3 = j;
                } while (j != 0);
                i3 = i6;
            } else {
                do {
                    i4 = i19 / 10;
                    i5 = i10 - 1;
                    cArr[i5] = (char) ((i19 - (i4 * 10)) + 48);
                    i10 = i5;
                    i19 = i4;
                } while (i4 != 0);
                i3 = i5;
            }
        }
        boolean z = i7 < 0;
        int i20 = ((i9 - i3) - i) - 1;
        if (i == 0) {
            int i21 = i3;
            if (z) {
                i21 = i3 - 1;
                cArr[i21] = '-';
            }
            return new String(cArr, i21, i9 - i21);
        } else if (i <= 0 || i20 < -6) {
            int i22 = i3 + 1;
            StringBuilder sb2 = new StringBuilder((i9 + 16) - i22);
            if (z) {
                sb2.append('-');
            }
            if (i9 - i22 >= 1) {
                sb2.append(cArr[i3]);
                sb2.append('.');
                sb2.append(cArr, i3 + 1, (i9 - i3) - 1);
            } else {
                sb2.append(cArr, i3, i9 - i3);
            }
            sb2.append('E');
            if (i20 > 0) {
                sb2.append('+');
            }
            sb2.append(Integer.toString(i20));
            return sb2.toString();
        } else if (i20 >= 0) {
            int i23 = i3 + i20;
            int i24 = i9;
            while (true) {
                int i25 = i24 - 1;
                if (i25 < i23) {
                    break;
                }
                cArr[i25 + 1] = cArr[i25];
                i24 = i25;
            }
            cArr[i23 + 1] = '.';
            int i26 = i3;
            if (z) {
                i26 = i3 - 1;
                cArr[i26] = '-';
            }
            return new String(cArr, i26, (i9 - i26) + 1);
        } else {
            int i27 = 2;
            while (true) {
                int i28 = i27;
                if (i28 >= (-i20) + 1) {
                    break;
                }
                i3--;
                cArr[i3] = '0';
                i27 = i28 + 1;
            }
            int i29 = i3 - 1;
            cArr[i29] = '.';
            int i30 = i29 - 1;
            cArr[i30] = '0';
            int i31 = i30;
            if (z) {
                i31 = i30 - 1;
                cArr[i31] = '-';
            }
            return new String(cArr, i31, i9 - i31);
        }
    }
}
