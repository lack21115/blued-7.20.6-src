package com.sobot.chat.widget.zxing.oned;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/EAN13Writer.class */
public final class EAN13Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 95;

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + UPCEANReader.getStandardUPCEANChecksum(str);
            } catch (FormatException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length != 13) {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
        } else {
            try {
                if (!UPCEANReader.checkStandardUPCEANChecksum(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException e2) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        checkNumeric(str);
        int i = EAN13Reader.FIRST_DIGIT_ENCODINGS[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int appendPattern = appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true) + 0;
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > 6) {
                break;
            }
            int digit = Character.digit(str.charAt(i3), 10);
            int i4 = digit;
            if (((i >> (6 - i3)) & 1) == 1) {
                i4 = digit + 10;
            }
            appendPattern += appendPattern(zArr, appendPattern, UPCEANReader.L_AND_G_PATTERNS[i4], false);
            i2 = i3 + 1;
        }
        int appendPattern2 = appendPattern + appendPattern(zArr, appendPattern, UPCEANReader.MIDDLE_PATTERN, false);
        int i5 = 7;
        while (true) {
            int i6 = i5;
            if (i6 > 12) {
                appendPattern(zArr, appendPattern2, UPCEANReader.START_END_PATTERN, true);
                return zArr;
            }
            appendPattern2 += appendPattern(zArr, appendPattern2, UPCEANReader.L_PATTERNS[Character.digit(str.charAt(i6), 10)], true);
            i5 = i6 + 1;
        }
    }

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    protected Collection<BarcodeFormat> getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.EAN_13);
    }
}
