package com.sobot.chat.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/EmojiFilter.class */
public class EmojiFilter {
    public static boolean containsEmoji(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (isEmojiCharacter(str.charAt(i2))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static String filterEmoji(String str) {
        String removeNonBmpUnicode = removeNonBmpUnicode(str);
        if (containsEmoji(removeNonBmpUnicode)) {
            StringBuilder sb = null;
            int length = removeNonBmpUnicode.length();
            int i = 0;
            while (i < length) {
                char charAt = removeNonBmpUnicode.charAt(i);
                StringBuilder sb2 = sb;
                if (isEmojiCharacter(charAt)) {
                    sb2 = sb;
                    if (sb == null) {
                        sb2 = new StringBuilder(removeNonBmpUnicode.length());
                    }
                    sb2.append(charAt);
                }
                i++;
                sb = sb2;
            }
            if (sb != null && sb.length() != length) {
                return sb.toString();
            }
            return removeNonBmpUnicode;
        }
        return removeNonBmpUnicode;
    }

    public static boolean hasEmojiStr(String str) {
        return Pattern.compile("[^��-\uffff]", 66).matcher(str).find();
    }

    private static boolean isEmojiCharacter(char c2) {
        if (c2 == 0 || c2 == '\t' || c2 == '\n' || c2 == '\r') {
            return true;
        }
        if (c2 < ' ' || c2 > 55295) {
            if (c2 < 57344 || c2 > 65533) {
                return c2 >= 0 && c2 <= 65535;
            }
            return true;
        }
        return true;
    }

    public static String removeNonBmpUnicode(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("[^\\u0000-\\uFFFF]", "");
    }
}
