package com.sobot.chat.widget.zxing.oned;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/EAN8Writer.class */
public final class EAN8Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 67;

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + UPCEANReader.getStandardUPCEANChecksum(str);
            } catch (FormatException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length != 8) {
            throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
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
        boolean[] zArr = new boolean[67];
        int appendPattern = appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true) + 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 3) {
                break;
            }
            appendPattern += appendPattern(zArr, appendPattern, UPCEANReader.L_PATTERNS[Character.digit(str.charAt(i2), 10)], false);
            i = i2 + 1;
        }
        int appendPattern2 = appendPattern + appendPattern(zArr, appendPattern, UPCEANReader.MIDDLE_PATTERN, false);
        int i3 = 4;
        while (true) {
            int i4 = i3;
            if (i4 > 7) {
                appendPattern(zArr, appendPattern2, UPCEANReader.START_END_PATTERN, true);
                return zArr;
            }
            appendPattern2 += appendPattern(zArr, appendPattern2, UPCEANReader.L_PATTERNS[Character.digit(str.charAt(i4), 10)], true);
            i3 = i4 + 1;
        }
    }

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    protected Collection<BarcodeFormat> getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.EAN_8);
    }
}
