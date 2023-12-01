package java.math;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/math/BitLevel.class */
public class BitLevel {
    private BitLevel() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int bitCount(BigInteger bigInteger) {
        int i;
        bigInteger.prepareJavaRepresentation();
        int i2 = 0;
        if (bigInteger.sign == 0) {
            return 0;
        }
        int firstNonzeroDigit = bigInteger.getFirstNonzeroDigit();
        if (bigInteger.sign > 0) {
            int i3 = firstNonzeroDigit;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= bigInteger.numberLength) {
                    break;
                }
                i2 += Integer.bitCount(bigInteger.digits[i4]);
                i3 = i4 + 1;
            }
        } else {
            int bitCount = 0 + Integer.bitCount(-bigInteger.digits[firstNonzeroDigit]);
            int i5 = firstNonzeroDigit;
            while (true) {
                int i6 = i5 + 1;
                if (i6 >= bigInteger.numberLength) {
                    break;
                }
                bitCount += Integer.bitCount(bigInteger.digits[i6] ^ (-1));
                i5 = i6;
            }
            i = (bigInteger.numberLength << 5) - bitCount;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int bitLength(BigInteger bigInteger) {
        bigInteger.prepareJavaRepresentation();
        if (bigInteger.sign == 0) {
            return 0;
        }
        int i = bigInteger.numberLength;
        int i2 = bigInteger.digits[bigInteger.numberLength - 1];
        int i3 = i2;
        if (bigInteger.sign < 0) {
            i3 = i2;
            if (bigInteger.getFirstNonzeroDigit() == bigInteger.numberLength - 1) {
                i3 = i2 - 1;
            }
        }
        return (i << 5) - Integer.numberOfLeadingZeros(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger flipBit(BigInteger bigInteger, int i) {
        int i2;
        int i3;
        bigInteger.prepareJavaRepresentation();
        int i4 = bigInteger.sign == 0 ? 1 : bigInteger.sign;
        int i5 = i >> 5;
        int max = Math.max(i5 + 1, bigInteger.numberLength) + 1;
        int[] iArr = new int[max];
        int i6 = 1 << (i & 31);
        System.arraycopy(bigInteger.digits, 0, iArr, 0, bigInteger.numberLength);
        if (bigInteger.sign >= 0) {
            iArr[i5] = iArr[i5] ^ i6;
        } else if (i5 >= bigInteger.numberLength) {
            iArr[i5] = i6;
        } else {
            int firstNonzeroDigit = bigInteger.getFirstNonzeroDigit();
            if (i5 > firstNonzeroDigit) {
                iArr[i5] = iArr[i5] ^ i6;
            } else if (i5 < firstNonzeroDigit) {
                iArr[i5] = -i6;
                int i7 = i5;
                while (true) {
                    i3 = i7 + 1;
                    if (i3 >= firstNonzeroDigit) {
                        break;
                    }
                    iArr[i3] = -1;
                    i7 = i3;
                }
                int i8 = iArr[i3];
                iArr[i3] = i8 - 1;
                iArr[i3] = i8;
            } else {
                iArr[i5] = -((-iArr[i5]) ^ i6);
                if (iArr[i5] == 0) {
                    int i9 = i5;
                    while (true) {
                        i2 = i9 + 1;
                        if (iArr[i2] != -1) {
                            break;
                        }
                        iArr[i2] = 0;
                        i9 = i2;
                    }
                    iArr[i2] = iArr[i2] + 1;
                }
            }
        }
        return new BigInteger(i4, max, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean nonZeroDroppedBits(int i, int[] iArr) {
        int i2;
        int i3 = i >> 5;
        int i4 = 0;
        while (true) {
            i2 = i4;
            if (i2 >= i3 || iArr[i2] != 0) {
                break;
            }
            i4 = i2 + 1;
        }
        return (i2 == i3 && (iArr[i2] << (32 - (i & 31))) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger shiftLeftOneBit(BigInteger bigInteger) {
        bigInteger.prepareJavaRepresentation();
        int i = bigInteger.numberLength;
        int i2 = i + 1;
        int[] iArr = new int[i2];
        shiftLeftOneBit(iArr, bigInteger.digits, i);
        return new BigInteger(bigInteger.sign, i2, iArr);
    }

    static void shiftLeftOneBit(int[] iArr, int[] iArr2, int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                break;
            }
            int i5 = iArr2[i4];
            iArr[i4] = (i5 << 1) | i2;
            i2 = i5 >>> 31;
            i3 = i4 + 1;
        }
        if (i2 != 0) {
            iArr[i] = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
        if ((r6.digits[r7] << (32 - r0)) != 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.math.BigInteger shiftRight(java.math.BigInteger r6, int r7) {
        /*
            Method dump skipped, instructions count: 197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.BitLevel.shiftRight(java.math.BigInteger, int):java.math.BigInteger");
    }

    static boolean shiftRight(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4;
        boolean z = true;
        int i5 = 0;
        while (true) {
            i4 = i5;
            if (i4 >= i2) {
                break;
            }
            z &= iArr2[i4] == 0;
            i5 = i4 + 1;
        }
        if (i3 == 0) {
            System.arraycopy(iArr2, i2, iArr, 0, i);
            return z;
        }
        int i6 = 32 - i3;
        boolean z2 = (iArr2[i4] << i6) == 0;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= i - 1) {
                iArr[i8] = iArr2[i8 + i2] >>> i3;
                return z & z2;
            }
            iArr[i8] = (iArr2[i8 + i2] >>> i3) | (iArr2[(i8 + i2) + 1] << i6);
            i7 = i8 + 1;
        }
    }

    static boolean testBit(BigInteger bigInteger, int i) {
        bigInteger.prepareJavaRepresentation();
        return (bigInteger.digits[i >> 5] & (1 << (i & 31))) != 0;
    }
}
