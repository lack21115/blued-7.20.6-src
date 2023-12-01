package com.youzan.spiderman.utils;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/StringUtils.class */
public class StringUtils {
    public static boolean containsAll(String str, CharSequence... charSequenceArr) {
        if (isEmpty(str)) {
            return false;
        }
        if (charSequenceArr == null) {
            return true;
        }
        int length = charSequenceArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!str.contains(charSequenceArr[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean containsIgnoreCase(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return false;
        }
        return str.toLowerCase().contains(str2.toLowerCase());
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        return (charSequence == null || charSequence2 == null) ? charSequence == null && charSequence2 == null : charSequence.toString().equals(charSequence2.toString());
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return (charSequence == null || charSequence2 == null) ? charSequence == null && charSequence2 == null : charSequence.toString().equalsIgnoreCase(charSequence2.toString());
    }

    public static boolean inList(CharSequence charSequence, CharSequence... charSequenceArr) {
        int length = charSequenceArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (equals(charSequence, charSequenceArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean inListIgnoreCase(CharSequence charSequence, CharSequence... charSequenceArr) {
        int length = charSequenceArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (equalsIgnoreCase(charSequence, charSequenceArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence... charSequenceArr) {
        if (charSequenceArr == null) {
            return true;
        }
        int length = charSequenceArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (isEmpty(charSequenceArr[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isNumber(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isStartWith(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (str.startsWith(strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static String join(List<String> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (str != null) {
                sb.append(',');
                sb.append(str);
            }
        }
        return sb.substring(1);
    }

    public static int toInt(CharSequence charSequence) {
        try {
            return Integer.valueOf(String.valueOf(charSequence)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    public static CharSequence truncate(CharSequence charSequence, int i) {
        if (charSequence == null) {
            return null;
        }
        if (charSequence.length() <= i) {
            return charSequence;
        }
        return charSequence.subSequence(0, i - 1).toString() + " ...";
    }
}
