package com.sobot.chat.widget.zxing.oned;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/UPCEWriter.class */
public final class UPCEWriter extends UPCEANWriter {
    private static final int CODE_WIDTH = 51;

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + UPCEANReader.getStandardUPCEANChecksum(UPCEReader.convertUPCEtoUPCA(str));
            } catch (FormatException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length != 8) {
            throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
        } else {
            try {
                if (!UPCEANReader.checkStandardUPCEANChecksum(UPCEReader.convertUPCEtoUPCA(str))) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException e2) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        checkNumeric(str);
        int digit = Character.digit(str.charAt(0), 10);
        if (digit != 0 && digit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i = UPCEReader.NUMSYS_AND_CHECK_DIGIT_PATTERNS[digit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int appendPattern = appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true);
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > 6) {
                appendPattern(zArr, appendPattern, UPCEANReader.END_PATTERN, false);
                return zArr;
            }
            int digit2 = Character.digit(str.charAt(i3), 10);
            int i4 = digit2;
            if (((i >> (6 - i3)) & 1) == 1) {
                i4 = digit2 + 10;
            }
            appendPattern += appendPattern(zArr, appendPattern, UPCEANReader.L_AND_G_PATTERNS[i4], false);
            i2 = i3 + 1;
        }
    }

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    protected Collection<BarcodeFormat> getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.UPC_E);
    }
}
