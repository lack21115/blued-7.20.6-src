package com.anythink.expressad.foundation.g.d;

import com.huawei.hms.framework.common.ContainerUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/d/e.class */
public final class e {
    private static String a(long j) {
        if (j <= 0) {
            return "0M";
        }
        return String.format("%.1f", Float.valueOf((((float) j) / 1024.0f) / 1024.0f)) + "M";
    }

    private static String a(String str, String str2) {
        if (b(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str2;
        }
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    private static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    private static String c(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    private static String d(String str) {
        if (b(str)) {
            return str;
        }
        char charAt = str.charAt(0);
        String str2 = str;
        if (Character.isLetter(charAt)) {
            if (Character.isUpperCase(charAt)) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str.length());
            sb.append(Character.toUpperCase(charAt));
            sb.append(str.substring(1));
            str2 = sb.toString();
        }
        return str2;
    }

    private static String e(String str) {
        if (b(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
        }
    }

    private static String f(String str) {
        if (b(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile(".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*", 2).matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        return str;
    }

    private static String g(String str) {
        return b(str) ? str : str.replaceAll("&lt;", SimpleComparison.LESS_THAN_OPERATION).replaceAll("&gt;", SimpleComparison.GREATER_THAN_OPERATION).replaceAll("&amp;", ContainerUtils.FIELD_DELIMITER).replaceAll("&quot;", "\"");
    }

    private static String h(String str) {
        if (b(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= charArray.length) {
                return new String(charArray);
            }
            if (charArray[i2] == 12288) {
                charArray[i2] = ' ';
            } else if (charArray[i2] < 65281 || charArray[i2] > 65374) {
                charArray[i2] = charArray[i2];
            } else {
                charArray[i2] = (char) (charArray[i2] - 65248);
            }
            i = i2 + 1;
        }
    }

    private static String i(String str) {
        if (b(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= charArray.length) {
                return new String(charArray);
            }
            if (charArray[i2] == ' ') {
                charArray[i2] = 12288;
            } else if (charArray[i2] < '!' || charArray[i2] > '~') {
                charArray[i2] = charArray[i2];
            } else {
                charArray[i2] = (char) (charArray[i2] + 65248);
            }
            i = i2 + 1;
        }
    }
}
