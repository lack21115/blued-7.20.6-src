package external.org.apache.commons.lang3;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/CharUtils.class */
public class CharUtils {
    private static final String[] CHAR_STRING_ARRAY = new String[128];
    public static final char CR = '\r';
    public static final char LF = '\n';

    static {
        char c2 = 0;
        while (true) {
            char c3 = c2;
            if (c3 >= CHAR_STRING_ARRAY.length) {
                return;
            }
            CHAR_STRING_ARRAY[c3] = String.valueOf(c3);
            c2 = (char) (c3 + 1);
        }
    }

    public static boolean isAscii(char c2) {
        return c2 < 128;
    }

    public static boolean isAsciiAlpha(char c2) {
        if (c2 < 'A' || c2 > 'Z') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    public static boolean isAsciiAlphaLower(char c2) {
        return c2 >= 'a' && c2 <= 'z';
    }

    public static boolean isAsciiAlphaUpper(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }

    public static boolean isAsciiAlphanumeric(char c2) {
        if (c2 < 'A' || c2 > 'Z') {
            if (c2 < 'a' || c2 > 'z') {
                return c2 >= '0' && c2 <= '9';
            }
            return true;
        }
        return true;
    }

    public static boolean isAsciiControl(char c2) {
        return c2 < ' ' || c2 == 127;
    }

    public static boolean isAsciiNumeric(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean isAsciiPrintable(char c2) {
        return c2 >= ' ' && c2 < 127;
    }

    public static char toChar(Character ch) {
        if (ch == null) {
            throw new IllegalArgumentException("The Character must not be null");
        }
        return ch.charValue();
    }

    public static char toChar(Character ch, char c2) {
        return ch == null ? c2 : ch.charValue();
    }

    public static char toChar(String str) {
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The String must not be empty");
        }
        return str.charAt(0);
    }

    public static char toChar(String str, char c2) {
        return StringUtils.isEmpty(str) ? c2 : str.charAt(0);
    }

    @Deprecated
    public static Character toCharacterObject(char c2) {
        return Character.valueOf(c2);
    }

    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    public static int toIntValue(char c2) {
        if (isAsciiNumeric(c2)) {
            return c2 - '0';
        }
        throw new IllegalArgumentException("The character " + c2 + " is not in the range '0' - '9'");
    }

    public static int toIntValue(char c2, int i) {
        return !isAsciiNumeric(c2) ? i : c2 - '0';
    }

    public static int toIntValue(Character ch) {
        if (ch == null) {
            throw new IllegalArgumentException("The character must not be null");
        }
        return toIntValue(ch.charValue());
    }

    public static int toIntValue(Character ch, int i) {
        return ch == null ? i : toIntValue(ch.charValue(), i);
    }

    public static String toString(char c2) {
        return c2 < 128 ? CHAR_STRING_ARRAY[c2] : new String(new char[]{c2});
    }

    public static String toString(Character ch) {
        if (ch == null) {
            return null;
        }
        return toString(ch.charValue());
    }

    public static String unicodeEscaped(char c2) {
        return c2 < 16 ? "\\u000" + Integer.toHexString(c2) : c2 < 256 ? "\\u00" + Integer.toHexString(c2) : c2 < 4096 ? "\\u0" + Integer.toHexString(c2) : "\\u" + Integer.toHexString(c2);
    }

    public static String unicodeEscaped(Character ch) {
        if (ch == null) {
            return null;
        }
        return unicodeEscaped(ch.charValue());
    }
}
