package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/oned/ITFWriter.class */
public final class ITFWriter extends OneDimensionalCodeWriter {
    private static final int N = 1;
    private static final int W = 3;
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[] END_PATTERN = {3, 1, 1};
    private static final int[][] PATTERNS = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[(length * 9) + 9];
        int appendPattern = appendPattern(zArr, 0, START_PATTERN, true);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                appendPattern(zArr, appendPattern, END_PATTERN, true);
                return zArr;
            }
            int digit = Character.digit(str.charAt(i2), 10);
            int digit2 = Character.digit(str.charAt(i2 + 1), 10);
            int[] iArr = new int[10];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < 5) {
                    int i5 = i4 * 2;
                    int[][] iArr2 = PATTERNS;
                    iArr[i5] = iArr2[digit][i4];
                    iArr[i5 + 1] = iArr2[digit2][i4];
                    i3 = i4 + 1;
                }
            }
            appendPattern += appendPattern(zArr, appendPattern, iArr, true);
            i = i2 + 2;
        }
    }
}
