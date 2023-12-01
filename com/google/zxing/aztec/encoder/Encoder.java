package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/aztec/encoder/Encoder.class */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    private static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return iArr;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                i5 |= bitArray.get((i4 * i) + i6) ? 1 << ((i - i6) - 1) : 0;
            }
            iArr[i4] = i5;
            i3 = i4 + 1;
        }
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                int i5 = i - i2;
                bitMatrix.set(i5, i5);
                int i6 = i5 + 1;
                bitMatrix.set(i6, i5);
                bitMatrix.set(i5, i6);
                int i7 = i + i2;
                bitMatrix.set(i7, i5);
                bitMatrix.set(i7, i6);
                bitMatrix.set(i7, i7 - 1);
                return;
            }
            int i8 = i - i4;
            int i9 = i8;
            while (true) {
                int i10 = i9;
                int i11 = i + i4;
                if (i10 <= i11) {
                    bitMatrix.set(i10, i8);
                    bitMatrix.set(i10, i11);
                    bitMatrix.set(i8, i10);
                    bitMatrix.set(i11, i10);
                    i9 = i10 + 1;
                }
            }
            i3 = i4 + 2;
        }
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = i / 2;
        if (!z) {
            for (int i3 = 0; i3 < 10; i3++) {
                int i4 = (i2 - 5) + i3 + (i3 / 5);
                if (bitArray.get(i3)) {
                    bitMatrix.set(i4, i2 - 7);
                }
                if (bitArray.get(i3 + 10)) {
                    bitMatrix.set(i2 + 7, i4);
                }
                if (bitArray.get(29 - i3)) {
                    bitMatrix.set(i4, i2 + 7);
                }
                if (bitArray.get(39 - i3)) {
                    bitMatrix.set(i2 - 7, i4);
                }
            }
            return;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 7) {
                return;
            }
            int i7 = (i2 - 3) + i6;
            if (bitArray.get(i6)) {
                bitMatrix.set(i7, i2 - 5);
            }
            if (bitArray.get(i6 + 7)) {
                bitMatrix.set(i2 + 5, i7);
            }
            if (bitArray.get(20 - i6)) {
                bitMatrix.set(i7, i2 + 5);
            }
            if (bitArray.get(27 - i6)) {
                bitMatrix.set(i2 - 5, i7);
            }
            i5 = i6 + 1;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x012e, code lost:
        if (r11 != com.google.zxing.aztec.encoder.Encoder.WORD_SIZE[r12]) goto L118;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.aztec.encoder.AztecCode encode(byte[] r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.encoder.Encoder.encode(byte[], int, int):com.google.zxing.aztec.encoder.AztecCode");
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        int size = bitArray.getSize() / i2;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i3 = i / i2;
        int[] bitsToWords = bitsToWords(bitArray, i2, i3);
        reedSolomonEncoder.encode(bitsToWords, i3 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        int length = bitsToWords.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                return bitArray2;
            }
            bitArray2.appendBits(bitsToWords[i5], i2);
            i4 = i5 + 1;
        }
    }

    static BitArray generateModeMessage(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i - 1, 5);
        bitArray.appendBits(i2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static GenericGF getGF(int i) {
        if (i != 4) {
            if (i != 6) {
                if (i != 8) {
                    if (i != 10) {
                        if (i == 12) {
                            return GenericGF.AZTEC_DATA_12;
                        }
                        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i)));
                    }
                    return GenericGF.AZTEC_DATA_10;
                }
                return GenericGF.AZTEC_DATA_8;
            }
            return GenericGF.AZTEC_DATA_6;
        }
        return GenericGF.AZTEC_PARAM;
    }

    static BitArray stuffBits(BitArray bitArray, int i) {
        int i2;
        int i3;
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i4 = (1 << i) - 2;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= size) {
                return bitArray2;
            }
            int i7 = 0;
            int i8 = 0;
            while (true) {
                i2 = i8;
                if (i7 >= i) {
                    break;
                }
                int i9 = i6 + i7;
                if (i9 < size) {
                    i3 = i2;
                    if (!bitArray.get(i9)) {
                        i7++;
                        i8 = i3;
                    }
                }
                i3 = i2 | (1 << ((i - 1) - i7));
                i7++;
                i8 = i3;
            }
            int i10 = i2 & i4;
            if (i10 == i4) {
                bitArray2.appendBits(i10, i);
            } else if (i10 == 0) {
                bitArray2.appendBits(i2 | 1, i);
            } else {
                bitArray2.appendBits(i2, i);
                i5 = i6 + i;
            }
            i6--;
            i5 = i6 + i;
        }
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }
}
