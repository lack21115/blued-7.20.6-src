package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/oned/EAN8Reader.class */
public final class EAN8Reader extends UPCEANReader {
    private final int[] decodeMiddleCounters = new int[4];

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4 || i >= size) {
                break;
            }
            sb.append((char) (decodeDigit(bitArray, iArr2, i, L_PATTERNS) + 48));
            int length = iArr2.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < length) {
                    i += iArr2[i5];
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
        int i6 = findGuardPattern(bitArray, i, true, MIDDLE_PATTERN)[1];
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= 4 || i6 >= size) {
                break;
            }
            sb.append((char) (decodeDigit(bitArray, iArr2, i6, L_PATTERNS) + 48));
            int length2 = iArr2.length;
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 < length2) {
                    i6 += iArr2[i10];
                    i9 = i10 + 1;
                }
            }
            i7 = i8 + 1;
        }
        return i6;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_8;
    }
}
