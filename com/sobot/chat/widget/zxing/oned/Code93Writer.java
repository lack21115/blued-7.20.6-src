package com.sobot.chat.widget.zxing.oned;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/Code93Writer.class */
public class Code93Writer extends OneDimensionalCodeWriter {
    private static int appendPattern(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 9) {
                return 9;
            }
            boolean z = true;
            if (((1 << (8 - i4)) & i2) == 0) {
                z = false;
            }
            zArr[i + i4] = z;
            i3 = i4 + 1;
        }
    }

    @Deprecated
    protected static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            zArr[i] = iArr[i2] != 0;
            i2++;
            i++;
        }
        return 9;
    }

    private static int computeChecksumIndex(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            int i4 = i3 + 1;
            i3 = i4;
            if (i4 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }

    static String convertToExtended(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (charAt == 0) {
                sb.append("bU");
            } else if (charAt <= 26) {
                sb.append('a');
                sb.append((char) ((charAt + 'A') - 1));
            } else if (charAt <= 31) {
                sb.append('b');
                sb.append((char) ((charAt + 'A') - 27));
            } else if (charAt == ' ' || charAt == '$' || charAt == '%' || charAt == '+') {
                sb.append(charAt);
            } else if (charAt <= ',') {
                sb.append('c');
                sb.append((char) ((charAt + 'A') - 33));
            } else if (charAt <= '9') {
                sb.append(charAt);
            } else if (charAt == ':') {
                sb.append("cZ");
            } else if (charAt <= '?') {
                sb.append('b');
                sb.append((char) ((charAt + 'F') - 59));
            } else if (charAt == '@') {
                sb.append("bV");
            } else if (charAt <= 'Z') {
                sb.append(charAt);
            } else if (charAt <= '_') {
                sb.append('b');
                sb.append((char) ((charAt + 'K') - 91));
            } else if (charAt == '`') {
                sb.append("bW");
            } else if (charAt <= 'z') {
                sb.append('d');
                sb.append((char) ((charAt + 'A') - 97));
            } else if (charAt > 127) {
                throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + charAt + "'");
            } else {
                sb.append('b');
                sb.append((char) ((charAt + 'P') - 123));
            }
            i = i2 + 1;
        }
    }

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int computeChecksumIndex;
        String convertToExtended = convertToExtended(str);
        int length = convertToExtended.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long after converting to extended encoding, but got " + length);
        }
        boolean[] zArr = new boolean[((convertToExtended.length() + 2 + 2) * 9) + 1];
        int appendPattern = appendPattern(zArr, 0, Code93Reader.ASTERISK_ENCODING);
        for (int i = 0; i < length; i++) {
            appendPattern += appendPattern(zArr, appendPattern, Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(convertToExtended.charAt(i))]);
        }
        int appendPattern2 = appendPattern + appendPattern(zArr, appendPattern, Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex(convertToExtended, 20)]);
        int appendPattern3 = appendPattern2 + appendPattern(zArr, appendPattern2, Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex(convertToExtended + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(computeChecksumIndex), 15)]);
        zArr[appendPattern3 + appendPattern(zArr, appendPattern3, Code93Reader.ASTERISK_ENCODING)] = true;
        return zArr;
    }

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    protected Collection<BarcodeFormat> getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.CODE_93);
    }
}
