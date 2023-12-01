package com.sobot.chat.widget.zxing.oned;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.FormatException;
import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.common.BitArray;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/UPCEReader.class */
public final class UPCEReader extends UPCEANReader {
    private static final int[] MIDDLE_END_PATTERN = {1, 1, 1, 1, 1, 1};
    static final int[][] NUMSYS_AND_CHECK_DIGIT_PATTERNS = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] decodeMiddleCounters = new int[4];

    public static String convertUPCEtoUPCA(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    private static void determineNumSysAndCheckDigit(StringBuilder sb, int i) throws NotFoundException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 > 1) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < 10) {
                    if (i == NUMSYS_AND_CHECK_DIGIT_PATTERNS[i3][i5]) {
                        sb.insert(0, (char) (i3 + 48));
                        sb.append((char) (i5 + 48));
                        return;
                    }
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sobot.chat.widget.zxing.oned.UPCEANReader
    public boolean checkChecksum(String str) throws FormatException {
        return super.checkChecksum(convertUPCEtoUPCA(str));
    }

    @Override // com.sobot.chat.widget.zxing.oned.UPCEANReader
    protected int[] decodeEnd(BitArray bitArray, int i) throws NotFoundException {
        return findGuardPattern(bitArray, i, true, MIDDLE_END_PATTERN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sobot.chat.widget.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
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
        determineNumSysAndCheckDigit(sb, i);
        return i2;
    }

    @Override // com.sobot.chat.widget.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.UPC_E;
    }
}
