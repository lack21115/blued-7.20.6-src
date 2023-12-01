package com.sobot.chat.widget.zxing.oned;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/ITFWriter.class */
public final class ITFWriter extends OneDimensionalCodeWriter {
    private static final int N = 1;
    private static final int W = 3;
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[] END_PATTERN = {3, 1, 1};
    private static final int[][] PATTERNS = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        checkNumeric(str);
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

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    protected Collection<BarcodeFormat> getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.ITF);
    }
}
