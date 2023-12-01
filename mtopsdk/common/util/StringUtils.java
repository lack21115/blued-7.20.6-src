package mtopsdk.common.util;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/StringUtils.class */
public class StringUtils {
    public static String a(String str, String str2) {
        if (b(str) || b(str2)) {
            return null;
        }
        return (str.trim() + "$" + str2.trim()).toLowerCase();
    }

    public static boolean a(String str) {
        return !b(str);
    }

    public static boolean b(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }
}
