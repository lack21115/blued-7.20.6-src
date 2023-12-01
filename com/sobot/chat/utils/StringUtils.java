package com.sobot.chat.utils;

import android.content.Context;
import com.anythink.expressad.video.dynview.a.a;
import com.igexin.push.core.b;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/StringUtils.class */
public final class StringUtils {
    private static final String CHARSET_NAME = "UTF-8";
    private static final char SEPARATOR = '_';
    private static Pattern p1 = Pattern.compile("<([a-zA-Z]+)[^<>]*>");

    public static String camelCase(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        StringBuilder sb = new StringBuilder(lowerCase.length());
        boolean z = false;
        for (int i = 0; i < lowerCase.length(); i++) {
            char charAt = lowerCase.charAt(i);
            if (charAt == '_') {
                z = true;
            } else if (z) {
                sb.append(Character.toUpperCase(charAt));
                z = false;
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String capCamelCase(String str) {
        if (str == null) {
            return null;
        }
        String camelCase = camelCase(str);
        return camelCase.substring(0, 1).toUpperCase() + camelCase.substring(1);
    }

    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        }
        return null;
    }

    public static List<String> getImgSrc(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("<img.*src\\s*=\\s*(.*?)[^>]*?>", 2).matcher(str);
        String str2 = "";
        while (matcher.find()) {
            String str3 = str2 + "," + matcher.group();
            Matcher matcher2 = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(str3);
            while (true) {
                str2 = str3;
                if (matcher2.find()) {
                    arrayList.add(matcher2.group(1));
                }
            }
        }
        return arrayList;
    }

    public static String getRandomNum(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return sb.toString();
            }
            sb.append(String.valueOf(new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}[random.nextInt(10)]));
            i2 = i3 + 1;
        }
    }

    public static String getRandomStr(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return sb.toString();
            }
            sb.append(String.valueOf(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}[random.nextInt(36)]));
            i2 = i3 + 1;
        }
    }

    public static String htmlAbbr(String str, int i) {
        boolean z;
        boolean z2;
        int i2;
        if (str == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = 0;
        boolean z3 = false;
        boolean z4 = false;
        int i4 = 0;
        while (true) {
            if (i3 < str.length()) {
                char charAt = str.charAt(i3);
                if (charAt == '<') {
                    z = true;
                    z2 = z4;
                    i2 = i4;
                } else if (charAt == '&') {
                    z2 = true;
                    z = z3;
                    i2 = i4;
                } else if (charAt == '>' && z3) {
                    i2 = i4 - 1;
                    z = false;
                    z2 = z4;
                } else {
                    z = z3;
                    z2 = z4;
                    i2 = i4;
                    if (charAt == ';') {
                        z = z3;
                        z2 = z4;
                        i2 = i4;
                        if (z4) {
                            z2 = false;
                            i2 = i4;
                            z = z3;
                        }
                    }
                }
                i4 = i2;
                if (!z) {
                    i4 = i2;
                    if (!z2) {
                        try {
                            i4 = i2 + String.valueOf(charAt).getBytes("GBK").length;
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            i4 = i2;
                        }
                    }
                }
                if (i4 > i - 3) {
                    stringBuffer.append("...");
                    break;
                }
                stringBuffer.append(charAt);
                i3++;
                z3 = z;
                z4 = z2;
            } else {
                break;
            }
        }
        Matcher matcher = p1.matcher(stringBuffer.toString().replaceAll("(>)[^<>]*(<?)", "$1$2").replaceAll("</?(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/?>", "").replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>", "$2"));
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
        }
        int size = arrayList.size();
        while (true) {
            int i5 = size - 1;
            if (i5 < 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append("</");
            stringBuffer.append((String) arrayList.get(i5));
            stringBuffer.append(SimpleComparison.GREATER_THAN_OPERATION);
            size = i5;
        }
    }

    public static boolean isDouble(String str) {
        if (isEmpty(str)) {
            return false;
        }
        try {
            Double.parseDouble(str);
            if (str.length() <= 0 || !".".equals(str.substring(str.length() - 1, str.length()))) {
                return str.contains(".");
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isEmpty(Object obj) {
        return obj == null || "".equals(obj) || b.l.equals(obj);
    }

    public static boolean isInteger(String str) {
        if (isEmpty(str)) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumber(String str) {
        return isInteger(str) || isDouble(str);
    }

    public static boolean isURL(String str) {
        return str.toLowerCase().matches("^((https|http|ftp|rtsp|mms)?://)?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,5})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$");
    }

    public static boolean isZh(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith(a.V);
    }

    public static String stripHtml(String str) {
        return isEmpty(str) ? "" : Pattern.compile("<.+?>").matcher(str).replaceAll("");
    }

    public static String toMobileHtml(String str) {
        return str == null ? "" : str.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
    }

    public static String uncamelCase(String str) {
        boolean z;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean z2 = false;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            boolean isUpperCase = i < str.length() - 1 ? Character.isUpperCase(str.charAt(i + 1)) : true;
            if (i <= 0 || !Character.isUpperCase(charAt)) {
                z = false;
            } else {
                if (!z2 || !isUpperCase) {
                    sb.append('_');
                }
                z = true;
            }
            z2 = z;
            sb.append(Character.toLowerCase(charAt));
            i++;
        }
        return sb.toString();
    }
}
