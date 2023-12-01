package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/oned/EAN13Reader.class */
public final class EAN13Reader extends UPCEANReader {
    static final int[] FIRST_DIGIT_ENCODINGS = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] decodeMiddleCounters = new int[4];

    private static void determineFirstDigit(StringBuilder sb, int i) throws NotFoundException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 10) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i == FIRST_DIGIT_ENCODINGS[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int i;
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i3 >= 6 || i2 >= size) {
                break;
            }
            int decodeDigit = decodeDigit(bitArray, iArr2, i2, L_AND_G_PATTERNS);
            sb.append((char) ((decodeDigit % 10) + 48));
            int length = iArr2.length;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length) {
                    break;
                }
                i2 += iArr2[i6];
                i5 = i6 + 1;
            }
            int i7 = i;
            if (decodeDigit >= 10) {
                i7 = i | (1 << (5 - i3));
            }
            i3++;
            i4 = i7;
        }
        determineFirstDigit(sb, i);
        int i8 = findGuardPattern(bitArray, i2, true, MIDDLE_PATTERN)[1];
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= 6 || i8 >= size) {
                break;
            }
            sb.append((char) (decodeDigit(bitArray, iArr2, i8, L_PATTERNS) + 48));
            int length2 = iArr2.length;
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 < length2) {
                    i8 += iArr2[i12];
                    i11 = i12 + 1;
                }
            }
            i9 = i10 + 1;
        }
        return i8;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_13;
    }
}
