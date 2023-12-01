package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/SoundexUtils.class */
final class SoundexUtils {
    SoundexUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String clean(String str) {
        int i;
        String str2 = str;
        if (str != null) {
            if (str.length() == 0) {
                return str;
            }
            int length = str.length();
            char[] cArr = new char[length];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                i = i3;
                if (i2 >= length) {
                    break;
                }
                int i4 = i;
                if (Character.isLetter(str.charAt(i2))) {
                    cArr[i] = str.charAt(i2);
                    i4 = i + 1;
                }
                i2++;
                i3 = i4;
            }
            if (i == length) {
                return str.toUpperCase(Locale.ENGLISH);
            }
            str2 = new String(cArr, 0, i).toUpperCase(Locale.ENGLISH);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int difference(StringEncoder stringEncoder, String str, String str2) throws EncoderException {
        return differenceEncoded(stringEncoder.encode(str), stringEncoder.encode(str2));
    }

    static int differenceEncoded(String str, String str2) {
        int i = 0;
        if (str == null || str2 == null) {
            return 0;
        }
        int min = Math.min(str.length(), str2.length());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= min) {
                return i3;
            }
            int i4 = i3;
            if (str.charAt(i) == str2.charAt(i)) {
                i4 = i3 + 1;
            }
            i++;
            i2 = i4;
        }
    }
}
