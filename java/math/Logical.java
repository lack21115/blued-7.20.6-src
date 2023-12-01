package java.math;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/math/Logical.class */
public class Logical {
    private Logical() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger and(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3;
        if (bigInteger2.sign == 0 || bigInteger.sign == 0) {
            bigInteger3 = BigInteger.ZERO;
        } else {
            bigInteger3 = bigInteger;
            if (!bigInteger2.equals(BigInteger.MINUS_ONE)) {
                return bigInteger.equals(BigInteger.MINUS_ONE) ? bigInteger2 : bigInteger.sign > 0 ? bigInteger2.sign > 0 ? andPositive(bigInteger, bigInteger2) : andDiffSigns(bigInteger, bigInteger2) : bigInteger2.sign > 0 ? andDiffSigns(bigInteger2, bigInteger) : bigInteger.numberLength > bigInteger2.numberLength ? andNegative(bigInteger, bigInteger2) : andNegative(bigInteger2, bigInteger);
            }
        }
        return bigInteger3;
    }

    static BigInteger andDiffSigns(BigInteger bigInteger, BigInteger bigInteger2) {
        int firstNonzeroDigit = bigInteger.getFirstNonzeroDigit();
        int firstNonzeroDigit2 = bigInteger2.getFirstNonzeroDigit();
        if (firstNonzeroDigit2 >= bigInteger.numberLength) {
            return BigInteger.ZERO;
        }
        int i = bigInteger.numberLength;
        int[] iArr = new int[i];
        int max = Math.max(firstNonzeroDigit, firstNonzeroDigit2);
        int i2 = max;
        if (max == firstNonzeroDigit2) {
            iArr[max] = (-bigInteger2.digits[max]) & bigInteger.digits[max];
            i2 = max + 1;
        }
        int min = Math.min(bigInteger2.numberLength, bigInteger.numberLength);
        while (i2 < min) {
            iArr[i2] = (bigInteger2.digits[i2] ^ (-1)) & bigInteger.digits[i2];
            i2++;
        }
        if (i2 >= bigInteger2.numberLength) {
            while (i2 < bigInteger.numberLength) {
                iArr[i2] = bigInteger.digits[i2];
                i2++;
            }
        }
        return new BigInteger(1, i, iArr);
    }

    static BigInteger andNegative(BigInteger bigInteger, BigInteger bigInteger2) {
        int i;
        int i2;
        int firstNonzeroDigit = bigInteger.getFirstNonzeroDigit();
        int firstNonzeroDigit2 = bigInteger2.getFirstNonzeroDigit();
        if (firstNonzeroDigit >= bigInteger2.numberLength) {
            return bigInteger;
        }
        int max = Math.max(firstNonzeroDigit2, firstNonzeroDigit);
        int i3 = firstNonzeroDigit2 > firstNonzeroDigit ? (-bigInteger2.digits[max]) & (bigInteger.digits[max] ^ (-1)) : firstNonzeroDigit2 < firstNonzeroDigit ? (bigInteger2.digits[max] ^ (-1)) & (-bigInteger.digits[max]) : (-bigInteger2.digits[max]) & (-bigInteger.digits[max]);
        int i4 = i3;
        int i5 = max;
        if (i3 == 0) {
            int i6 = max + 1;
            while (i6 < bigInteger2.numberLength) {
                int i7 = (bigInteger.digits[i6] | bigInteger2.digits[i6]) ^ (-1);
                i3 = i7;
                if (i7 != 0) {
                    break;
                }
                i6++;
                i3 = i7;
            }
            i4 = i3;
            i5 = i6;
            if (i3 == 0) {
                while (i6 < bigInteger.numberLength) {
                    int i8 = bigInteger.digits[i6] ^ (-1);
                    i3 = i8;
                    if (i8 != 0) {
                        break;
                    }
                    i6++;
                    i3 = i8;
                }
                i4 = i3;
                i5 = i6;
                if (i3 == 0) {
                    int i9 = bigInteger.numberLength + 1;
                    int[] iArr = new int[i9];
                    iArr[i9 - 1] = 1;
                    return new BigInteger(-1, i9, iArr);
                }
            }
        }
        int i10 = bigInteger.numberLength;
        int[] iArr2 = new int[i10];
        iArr2[i5] = -i4;
        int i11 = i5;
        while (true) {
            i = i11 + 1;
            if (i >= bigInteger2.numberLength) {
                break;
            }
            iArr2[i] = bigInteger.digits[i] | bigInteger2.digits[i];
            i11 = i;
        }
        for (i2 = i; i2 < bigInteger.numberLength; i2++) {
            iArr2[i2] = bigInteger.digits[i2];
        }
        return new BigInteger(-1, i10, iArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger andNot(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger2.sign == 0 ? bigInteger : bigInteger.sign == 0 ? BigInteger.ZERO : bigInteger.equals(BigInteger.MINUS_ONE) ? bigInteger2.not() : bigInteger2.equals(BigInteger.MINUS_ONE) ? BigInteger.ZERO : bigInteger.sign > 0 ? bigInteger2.sign > 0 ? andNotPositive(bigInteger, bigInteger2) : andNotPositiveNegative(bigInteger, bigInteger2) : bigInteger2.sign > 0 ? andNotNegativePositive(bigInteger, bigInteger2) : andNotNegative(bigInteger, bigInteger2);
    }

    static BigInteger andNotNegative(BigInteger bigInteger, BigInteger bigInteger2) {
        int i;
        int firstNonzeroDigit = bigInteger.getFirstNonzeroDigit();
        int firstNonzeroDigit2 = bigInteger2.getFirstNonzeroDigit();
        if (firstNonzeroDigit >= bigInteger2.numberLength) {
            return BigInteger.ZERO;
        }
        int i2 = bigInteger2.numberLength;
        int[] iArr = new int[i2];
        int i3 = firstNonzeroDigit;
        if (firstNonzeroDigit < firstNonzeroDigit2) {
            iArr[i3] = -bigInteger.digits[i3];
            int min = Math.min(bigInteger.numberLength, firstNonzeroDigit2);
            while (true) {
                i3++;
                if (i3 >= min) {
                    break;
                }
                iArr[i3] = bigInteger.digits[i3] ^ (-1);
            }
            if (i3 == bigInteger.numberLength) {
                while (i3 < firstNonzeroDigit2) {
                    iArr[i3] = -1;
                    i3++;
                }
                iArr[i3] = bigInteger2.digits[i3] - 1;
            } else {
                iArr[i3] = (bigInteger.digits[i3] ^ (-1)) & (bigInteger2.digits[i3] - 1);
            }
        } else if (firstNonzeroDigit2 < firstNonzeroDigit) {
            iArr[i3] = (-bigInteger.digits[i3]) & bigInteger2.digits[i3];
        } else {
            iArr[i3] = (-bigInteger.digits[i3]) & (bigInteger2.digits[i3] - 1);
        }
        int min2 = Math.min(bigInteger.numberLength, bigInteger2.numberLength);
        while (true) {
            i3++;
            if (i3 >= min2) {
                break;
            }
            iArr[i3] = (bigInteger.digits[i3] ^ (-1)) & bigInteger2.digits[i3];
        }
        for (i = i3; i < bigInteger2.numberLength; i++) {
            iArr[i] = bigInteger2.digits[i];
        }
        return new BigInteger(1, i2, iArr);
    }

    static BigInteger andNotNegativePositive(BigInteger bigInteger, BigInteger bigInteger2) {
        int[] iArr;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int firstNonzeroDigit = bigInteger.getFirstNonzeroDigit();
        int firstNonzeroDigit2 = bigInteger2.getFirstNonzeroDigit();
        if (firstNonzeroDigit >= bigInteger2.numberLength) {
            return bigInteger;
        }
        int max = Math.max(bigInteger.numberLength, bigInteger2.numberLength);
        if (firstNonzeroDigit2 > firstNonzeroDigit) {
            int[] iArr2 = new int[max];
            int min = Math.min(bigInteger.numberLength, firstNonzeroDigit2);
            int i7 = firstNonzeroDigit;
            while (true) {
                i6 = i7;
                if (i6 >= min) {
                    break;
                }
                iArr2[i6] = bigInteger.digits[i6];
                i7 = i6 + 1;
            }
            i = i6;
            iArr = iArr2;
            if (i6 == bigInteger.numberLength) {
                int i8 = firstNonzeroDigit2;
                while (true) {
                    int i9 = i8;
                    i = i9;
                    iArr = iArr2;
                    if (i9 >= bigInteger2.numberLength) {
                        break;
                    }
                    iArr2[i9] = bigInteger2.digits[i9];
                    i8 = i9 + 1;
                }
            }
        } else {
            int i10 = (-bigInteger.digits[firstNonzeroDigit]) & (bigInteger2.digits[firstNonzeroDigit] ^ (-1));
            int i11 = i10;
            int i12 = firstNonzeroDigit;
            if (i10 == 0) {
                int min2 = Math.min(bigInteger2.numberLength, bigInteger.numberLength);
                int i13 = firstNonzeroDigit + 1;
                while (i13 < min2) {
                    int i14 = (bigInteger.digits[i13] | bigInteger2.digits[i13]) ^ (-1);
                    i10 = i14;
                    if (i14 != 0) {
                        break;
                    }
                    i13++;
                    i10 = i14;
                }
                i11 = i10;
                i12 = i13;
                if (i10 == 0) {
                    int i15 = i13;
                    int i16 = i10;
                    while (true) {
                        i2 = i16;
                        i3 = i15;
                        if (i15 >= bigInteger2.numberLength) {
                            break;
                        }
                        int i17 = bigInteger2.digits[i15] ^ (-1);
                        i2 = i17;
                        i3 = i15;
                        if (i17 != 0) {
                            break;
                        }
                        i15++;
                        i16 = i17;
                    }
                    while (i3 < bigInteger.numberLength) {
                        int i18 = bigInteger.digits[i3] ^ (-1);
                        i2 = i18;
                        if (i18 != 0) {
                            break;
                        }
                        i3++;
                        i2 = i18;
                    }
                    i11 = i2;
                    i12 = i3;
                    if (i2 == 0) {
                        int i19 = max + 1;
                        int[] iArr3 = new int[i19];
                        iArr3[i19 - 1] = 1;
                        return new BigInteger(-1, i19, iArr3);
                    }
                }
            }
            iArr = new int[max];
            iArr[i12] = -i11;
            i = i12 + 1;
        }
        int min3 = Math.min(bigInteger2.numberLength, bigInteger.numberLength);
        int i20 = i;
        while (true) {
            int i21 = i20;
            i4 = i21;
            if (i21 >= min3) {
                break;
            }
            iArr[i21] = bigInteger.digits[i21] | bigInteger2.digits[i21];
            i20 = i21 + 1;
        }
        while (true) {
            if (i4 >= bigInteger.numberLength) {
                break;
            }
            iArr[i4] = bigInteger.digits[i4];
            i4++;
        }
        for (i5 = i4; i5 < bigInteger2.numberLength; i5++) {
            iArr[i5] = bigInteger2.digits[i5];
        }
        return new BigInteger(-1, max, iArr);
    }

    static BigInteger andNotPositive(BigInteger bigInteger, BigInteger bigInteger2) {
        int i;
        int i2;
        int[] iArr = new int[bigInteger.numberLength];
        int min = Math.min(bigInteger.numberLength, bigInteger2.numberLength);
        int firstNonzeroDigit = bigInteger.getFirstNonzeroDigit();
        while (true) {
            i = firstNonzeroDigit;
            if (i >= min) {
                break;
            }
            iArr[i] = bigInteger.digits[i] & (bigInteger2.digits[i] ^ (-1));
            firstNonzeroDigit = i + 1;
        }
        for (i2 = i; i2 < bigInteger.numberLength; i2++) {
            iArr[i2] = bigInteger.digits[i2];
        }
        return new BigInteger(1, bigInteger.numberLength, iArr);
    }

    static BigInteger andNotPositiveNegative(BigInteger bigInteger, BigInteger bigInteger2) {
        int firstNonzeroDigit = bigInteger2.getFirstNonzeroDigit();
        int firstNonzeroDigit2 = bigInteger.getFirstNonzeroDigit();
        if (firstNonzeroDigit >= bigInteger.numberLength) {
            return bigInteger;
        }
        int min = Math.min(bigInteger.numberLength, bigInteger2.numberLength);
        int[] iArr = new int[min];
        while (firstNonzeroDigit2 < firstNonzeroDigit) {
            iArr[firstNonzeroDigit2] = bigInteger.digits[firstNonzeroDigit2];
            firstNonzeroDigit2++;
        }
        int i = firstNonzeroDigit2;
        if (firstNonzeroDigit2 == firstNonzeroDigit) {
            iArr[firstNonzeroDigit2] = bigInteger.digits[firstNonzeroDigit2] & (bigInteger2.digits[firstNonzeroDigit2] - 1);
            i = firstNonzeroDigit2 + 1;
        }
        while (i < min) {
            iArr[i] = bigInteger.digits[i] & bigInteger2.digits[i];
            i++;
        }
        return new BigInteger(1, min, iArr);
    }

    static BigInteger andPositive(BigInteger bigInteger, BigInteger bigInteger2) {
        int min = Math.min(bigInteger.numberLength, bigInteger2.numberLength);
        int max = Math.max(bigInteger.getFirstNonzeroDigit(), bigInteger2.getFirstNonzeroDigit());
        if (max >= min) {
            return BigInteger.ZERO;
        }
        int[] iArr = new int[min];
        while (max < min) {
            iArr[max] = bigInteger.digits[max] & bigInteger2.digits[max];
            max++;
        }
        return new BigInteger(1, min, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger not(BigInteger bigInteger) {
        int i;
        int i2;
        if (bigInteger.sign == 0) {
            return BigInteger.MINUS_ONE;
        }
        if (bigInteger.equals(BigInteger.MINUS_ONE)) {
            return BigInteger.ZERO;
        }
        int[] iArr = new int[bigInteger.numberLength + 1];
        if (bigInteger.sign <= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i4;
                if (bigInteger.digits[i4] != 0) {
                    break;
                }
                iArr[i4] = -1;
                i3 = i4 + 1;
            }
        } else if (bigInteger.digits[bigInteger.numberLength - 1] != -1) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                i = i6;
                if (bigInteger.digits[i6] != -1) {
                    break;
                }
                i5 = i6 + 1;
            }
        } else {
            int i7 = 0;
            while (true) {
                i2 = i7;
                if (i2 >= bigInteger.numberLength || bigInteger.digits[i2] != -1) {
                    break;
                }
                i7 = i2 + 1;
            }
            i = i2;
            if (i2 == bigInteger.numberLength) {
                iArr[i2] = 1;
                return new BigInteger(-bigInteger.sign, i2 + 1, iArr);
            }
        }
        iArr[i] = bigInteger.digits[i] + bigInteger.sign;
        while (true) {
            i++;
            if (i >= bigInteger.numberLength) {
                return new BigInteger(-bigInteger.sign, i, iArr);
            }
            iArr[i] = bigInteger.digits[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger or(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3;
        if (bigInteger2.equals(BigInteger.MINUS_ONE) || bigInteger.equals(BigInteger.MINUS_ONE)) {
            bigInteger3 = BigInteger.MINUS_ONE;
        } else {
            bigInteger3 = bigInteger;
            if (bigInteger2.sign != 0) {
                return bigInteger.sign == 0 ? bigInteger2 : bigInteger.sign > 0 ? bigInteger2.sign > 0 ? bigInteger.numberLength > bigInteger2.numberLength ? orPositive(bigInteger, bigInteger2) : orPositive(bigInteger2, bigInteger) : orDiffSigns(bigInteger, bigInteger2) : bigInteger2.sign > 0 ? orDiffSigns(bigInteger2, bigInteger) : bigInteger2.getFirstNonzeroDigit() > bigInteger.getFirstNonzeroDigit() ? orNegative(bigInteger2, bigInteger) : orNegative(bigInteger, bigInteger2);
            }
        }
        return bigInteger3;
    }

    static BigInteger orDiffSigns(BigInteger bigInteger, BigInteger bigInteger2) {
        int i;
        int i2;
        int i3;
        int firstNonzeroDigit = bigInteger2.getFirstNonzeroDigit();
        int firstNonzeroDigit2 = bigInteger.getFirstNonzeroDigit();
        if (firstNonzeroDigit2 >= bigInteger2.numberLength) {
            return bigInteger2;
        }
        int i4 = bigInteger2.numberLength;
        int[] iArr = new int[i4];
        if (firstNonzeroDigit < firstNonzeroDigit2) {
            int i5 = firstNonzeroDigit;
            while (true) {
                int i6 = i5;
                i = i6;
                if (i6 >= firstNonzeroDigit2) {
                    break;
                }
                iArr[i6] = bigInteger2.digits[i6];
                i5 = i6 + 1;
            }
        } else if (firstNonzeroDigit2 < firstNonzeroDigit) {
            iArr[firstNonzeroDigit2] = -bigInteger.digits[firstNonzeroDigit2];
            int min = Math.min(bigInteger.numberLength, firstNonzeroDigit);
            int i7 = firstNonzeroDigit2;
            while (true) {
                i2 = i7 + 1;
                if (i2 >= min) {
                    break;
                }
                iArr[i2] = bigInteger.digits[i2] ^ (-1);
                i7 = i2;
            }
            int i8 = i2;
            if (i2 != bigInteger.numberLength) {
                iArr[i2] = ((-bigInteger2.digits[i2]) | bigInteger.digits[i2]) ^ (-1);
            } else {
                while (i8 < firstNonzeroDigit) {
                    iArr[i8] = -1;
                    i8++;
                }
                iArr[i8] = bigInteger2.digits[i8] - 1;
                i2 = i8;
            }
            i = i2 + 1;
        } else {
            iArr[firstNonzeroDigit2] = -((-bigInteger2.digits[firstNonzeroDigit2]) | bigInteger.digits[firstNonzeroDigit2]);
            i = firstNonzeroDigit2 + 1;
        }
        int min2 = Math.min(bigInteger2.numberLength, bigInteger.numberLength);
        while (true) {
            if (i >= min2) {
                break;
            }
            iArr[i] = bigInteger2.digits[i] & (bigInteger.digits[i] ^ (-1));
            i++;
        }
        for (i3 = i; i3 < bigInteger2.numberLength; i3++) {
            iArr[i3] = bigInteger2.digits[i3];
        }
        return new BigInteger(-1, i4, iArr);
    }

    static BigInteger orNegative(BigInteger bigInteger, BigInteger bigInteger2) {
        int firstNonzeroDigit = bigInteger2.getFirstNonzeroDigit();
        int firstNonzeroDigit2 = bigInteger.getFirstNonzeroDigit();
        if (firstNonzeroDigit2 >= bigInteger2.numberLength) {
            return bigInteger2;
        }
        if (firstNonzeroDigit >= bigInteger.numberLength) {
            return bigInteger;
        }
        int min = Math.min(bigInteger.numberLength, bigInteger2.numberLength);
        int[] iArr = new int[min];
        if (firstNonzeroDigit == firstNonzeroDigit2) {
            iArr[firstNonzeroDigit2] = -((-bigInteger.digits[firstNonzeroDigit2]) | (-bigInteger2.digits[firstNonzeroDigit2]));
            firstNonzeroDigit = firstNonzeroDigit2;
        } else {
            while (firstNonzeroDigit < firstNonzeroDigit2) {
                iArr[firstNonzeroDigit] = bigInteger2.digits[firstNonzeroDigit];
                firstNonzeroDigit++;
            }
            iArr[firstNonzeroDigit] = bigInteger2.digits[firstNonzeroDigit] & (bigInteger.digits[firstNonzeroDigit] - 1);
        }
        while (true) {
            firstNonzeroDigit++;
            if (firstNonzeroDigit >= min) {
                return new BigInteger(-1, min, iArr);
            }
            iArr[firstNonzeroDigit] = bigInteger.digits[firstNonzeroDigit] & bigInteger2.digits[firstNonzeroDigit];
        }
    }

    static BigInteger orPositive(BigInteger bigInteger, BigInteger bigInteger2) {
        int i;
        int i2;
        int i3 = bigInteger.numberLength;
        int[] iArr = new int[i3];
        int i4 = 0;
        while (true) {
            i = i4;
            if (i >= bigInteger2.numberLength) {
                break;
            }
            iArr[i] = bigInteger.digits[i] | bigInteger2.digits[i];
            i4 = i + 1;
        }
        for (i2 = i; i2 < i3; i2++) {
            iArr[i2] = bigInteger.digits[i2];
        }
        return new BigInteger(1, i3, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger xor(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger2.sign == 0 ? bigInteger : bigInteger.sign == 0 ? bigInteger2 : bigInteger2.equals(BigInteger.MINUS_ONE) ? bigInteger.not() : bigInteger.equals(BigInteger.MINUS_ONE) ? bigInteger2.not() : bigInteger.sign > 0 ? bigInteger2.sign > 0 ? bigInteger.numberLength > bigInteger2.numberLength ? xorPositive(bigInteger, bigInteger2) : xorPositive(bigInteger2, bigInteger) : xorDiffSigns(bigInteger, bigInteger2) : bigInteger2.sign > 0 ? xorDiffSigns(bigInteger2, bigInteger) : bigInteger2.getFirstNonzeroDigit() > bigInteger.getFirstNonzeroDigit() ? xorNegative(bigInteger2, bigInteger) : xorNegative(bigInteger, bigInteger2);
    }

    static BigInteger xorDiffSigns(BigInteger bigInteger, BigInteger bigInteger2) {
        int[] iArr;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int max = Math.max(bigInteger2.numberLength, bigInteger.numberLength);
        int firstNonzeroDigit = bigInteger2.getFirstNonzeroDigit();
        int firstNonzeroDigit2 = bigInteger.getFirstNonzeroDigit();
        if (firstNonzeroDigit < firstNonzeroDigit2) {
            int[] iArr2 = new int[max];
            iArr2[firstNonzeroDigit] = bigInteger2.digits[firstNonzeroDigit];
            int min = Math.min(bigInteger2.numberLength, firstNonzeroDigit2);
            int i8 = firstNonzeroDigit;
            while (true) {
                i7 = i8 + 1;
                if (i7 >= min) {
                    break;
                }
                iArr2[i7] = bigInteger2.digits[i7];
                i8 = i7;
            }
            i = i7;
            iArr = iArr2;
            if (i7 == bigInteger2.numberLength) {
                while (true) {
                    i = i7;
                    iArr = iArr2;
                    if (i7 >= bigInteger.numberLength) {
                        break;
                    }
                    iArr2[i7] = bigInteger.digits[i7];
                    i7++;
                }
            }
        } else if (firstNonzeroDigit2 < firstNonzeroDigit) {
            int[] iArr3 = new int[max];
            iArr3[firstNonzeroDigit2] = -bigInteger.digits[firstNonzeroDigit2];
            int min2 = Math.min(bigInteger.numberLength, firstNonzeroDigit);
            while (true) {
                firstNonzeroDigit2++;
                if (firstNonzeroDigit2 >= min2) {
                    break;
                }
                iArr3[firstNonzeroDigit2] = bigInteger.digits[firstNonzeroDigit2] ^ (-1);
            }
            int i9 = firstNonzeroDigit2;
            if (firstNonzeroDigit2 != firstNonzeroDigit) {
                while (true) {
                    i4 = i9;
                    if (i9 >= firstNonzeroDigit) {
                        break;
                    }
                    iArr3[i9] = -1;
                    i9++;
                }
                while (true) {
                    i = i4;
                    iArr = iArr3;
                    if (i4 >= bigInteger2.numberLength) {
                        break;
                    }
                    iArr3[i4] = bigInteger2.digits[i4];
                    i4++;
                }
            } else {
                iArr3[firstNonzeroDigit2] = (bigInteger.digits[firstNonzeroDigit2] ^ (-bigInteger2.digits[firstNonzeroDigit2])) ^ (-1);
                i = firstNonzeroDigit2 + 1;
                iArr = iArr3;
            }
        } else {
            int i10 = bigInteger.digits[firstNonzeroDigit] ^ (-bigInteger2.digits[firstNonzeroDigit]);
            int i11 = i10;
            int i12 = firstNonzeroDigit;
            if (i10 == 0) {
                int min3 = Math.min(bigInteger.numberLength, bigInteger2.numberLength);
                int i13 = firstNonzeroDigit + 1;
                while (i13 < min3) {
                    int i14 = bigInteger.digits[i13] ^ (bigInteger2.digits[i13] ^ (-1));
                    i10 = i14;
                    if (i14 != 0) {
                        break;
                    }
                    i13++;
                    i10 = i14;
                }
                i11 = i10;
                i12 = i13;
                if (i10 == 0) {
                    int i15 = i13;
                    int i16 = i10;
                    while (true) {
                        i2 = i16;
                        i3 = i15;
                        if (i15 >= bigInteger.numberLength) {
                            break;
                        }
                        int i17 = bigInteger.digits[i15] ^ (-1);
                        i2 = i17;
                        i3 = i15;
                        if (i17 != 0) {
                            break;
                        }
                        i15++;
                        i16 = i17;
                    }
                    while (i3 < bigInteger2.numberLength) {
                        int i18 = bigInteger2.digits[i3] ^ (-1);
                        i2 = i18;
                        if (i18 != 0) {
                            break;
                        }
                        i3++;
                        i2 = i18;
                    }
                    i11 = i2;
                    i12 = i3;
                    if (i2 == 0) {
                        int i19 = max + 1;
                        int[] iArr4 = new int[i19];
                        iArr4[i19 - 1] = 1;
                        return new BigInteger(-1, i19, iArr4);
                    }
                }
            }
            iArr = new int[max];
            iArr[i12] = -i11;
            i = i12 + 1;
        }
        int min4 = Math.min(bigInteger2.numberLength, bigInteger.numberLength);
        int i20 = i;
        while (true) {
            int i21 = i20;
            i5 = i21;
            if (i21 >= min4) {
                break;
            }
            iArr[i21] = ((bigInteger2.digits[i21] ^ (-1)) ^ bigInteger.digits[i21]) ^ (-1);
            i20 = i21 + 1;
        }
        while (true) {
            if (i5 >= bigInteger.numberLength) {
                break;
            }
            iArr[i5] = bigInteger.digits[i5];
            i5++;
        }
        for (i6 = i5; i6 < bigInteger2.numberLength; i6++) {
            iArr[i6] = bigInteger2.digits[i6];
        }
        return new BigInteger(-1, max, iArr);
    }

    static BigInteger xorNegative(BigInteger bigInteger, BigInteger bigInteger2) {
        int i;
        int i2;
        int max = Math.max(bigInteger.numberLength, bigInteger2.numberLength);
        int[] iArr = new int[max];
        int firstNonzeroDigit = bigInteger.getFirstNonzeroDigit();
        int firstNonzeroDigit2 = bigInteger2.getFirstNonzeroDigit();
        int i3 = firstNonzeroDigit2;
        if (firstNonzeroDigit == firstNonzeroDigit2) {
            iArr[i3] = (-bigInteger.digits[i3]) ^ (-bigInteger2.digits[i3]);
        } else {
            iArr[i3] = -bigInteger2.digits[i3];
            int min = Math.min(bigInteger2.numberLength, firstNonzeroDigit);
            while (true) {
                i3++;
                if (i3 >= min) {
                    break;
                }
                iArr[i3] = bigInteger2.digits[i3] ^ (-1);
            }
            if (i3 == bigInteger2.numberLength) {
                while (i3 < firstNonzeroDigit) {
                    iArr[i3] = -1;
                    i3++;
                }
                iArr[i3] = bigInteger.digits[i3] - 1;
            } else {
                iArr[i3] = (-bigInteger.digits[i3]) ^ (bigInteger2.digits[i3] ^ (-1));
            }
        }
        int min2 = Math.min(bigInteger.numberLength, bigInteger2.numberLength);
        int i4 = i3;
        while (true) {
            int i5 = i4 + 1;
            i = i5;
            if (i5 >= min2) {
                break;
            }
            iArr[i5] = bigInteger.digits[i5] ^ bigInteger2.digits[i5];
            i4 = i5;
        }
        while (true) {
            if (i >= bigInteger.numberLength) {
                break;
            }
            iArr[i] = bigInteger.digits[i];
            i++;
        }
        for (i2 = i; i2 < bigInteger2.numberLength; i2++) {
            iArr[i2] = bigInteger2.digits[i2];
        }
        return new BigInteger(1, max, iArr);
    }

    static BigInteger xorPositive(BigInteger bigInteger, BigInteger bigInteger2) {
        int i;
        int i2;
        int i3 = bigInteger.numberLength;
        int[] iArr = new int[i3];
        int min = Math.min(bigInteger.getFirstNonzeroDigit(), bigInteger2.getFirstNonzeroDigit());
        while (true) {
            i = min;
            if (i >= bigInteger2.numberLength) {
                break;
            }
            iArr[i] = bigInteger.digits[i] ^ bigInteger2.digits[i];
            min = i + 1;
        }
        for (i2 = i; i2 < bigInteger.numberLength; i2++) {
            iArr[i2] = bigInteger.digits[i2];
        }
        return new BigInteger(1, i3, iArr);
    }
}
