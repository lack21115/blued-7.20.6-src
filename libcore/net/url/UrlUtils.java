package libcore.net.url;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Locale;

/* loaded from: source-2895416-dex2jar.jar:libcore/net/url/UrlUtils.class */
public final class UrlUtils {
    private UrlUtils() {
    }

    public static String authoritySafePath(String str, String str2) {
        String str3 = str2;
        if (str != null) {
            str3 = str2;
            if (!str.isEmpty()) {
                str3 = str2;
                if (!str2.isEmpty()) {
                    str3 = str2;
                    if (!str2.startsWith(BridgeUtil.SPLIT_MARK)) {
                        str3 = BridgeUtil.SPLIT_MARK + str2;
                    }
                }
            }
        }
        return str3;
    }

    public static String canonicalizePath(String str, boolean z) {
        int i;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 <= str.length()) {
            if (i4 == str.length()) {
                i = i4;
            } else if (str.charAt(i4) == '/') {
                i = i4 + 1;
            } else {
                i4++;
            }
            if (i4 == i2 + 1 && str.regionMatches(i2, ".", 0, 1)) {
                str = str.substring(0, i2) + str.substring(i);
                i4 = i2;
            } else if (i4 != i2 + 2 || !str.regionMatches(i2, "..", 0, 2)) {
                int i5 = i3;
                if (i4 > 0) {
                    i5 = i3 + 1;
                }
                i4++;
                i3 = i5;
                i2 = i4;
            } else if (i3 > 0 || z) {
                i3--;
                i4 = str.lastIndexOf(47, i2 - 2) + 1;
                str = str.substring(0, i4) + str.substring(i);
                i2 = i4;
            } else {
                i4++;
                i2 = i4;
            }
        }
        return str;
    }

    public static int findFirstOf(String str, String str2, int i, int i2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String getSchemePrefix(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf < 1) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexOf) {
                return str.substring(0, indexOf).toLowerCase(Locale.US);
            }
            if (!isValidSchemeChar(i2, str.charAt(i2))) {
                return null;
            }
            i = i2 + 1;
        }
    }

    public static boolean isValidSchemeChar(int i, char c2) {
        if (c2 < 'a' || c2 > 'z') {
            if (c2 < 'A' || c2 > 'Z') {
                if (i > 0) {
                    return (c2 >= '0' && c2 <= '9') || c2 == '+' || c2 == '-' || c2 == '.';
                }
                return false;
            }
            return true;
        }
        return true;
    }
}
