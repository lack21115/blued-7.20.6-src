package com.tencent.mapsdk.internal;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.map.lib.models.AccessibleTouchItem;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f7.class */
public class f7 {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f23750a = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    public static int a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= (split.length > split2.length ? split2.length : split.length)) {
                if (split.length != split2.length) {
                    return split.length - split2.length;
                }
                return 0;
            }
            int intValue = Integer.valueOf(split[i2]).intValue() - Integer.valueOf(split2[i2]).intValue();
            if (intValue != 0) {
                return intValue;
            }
            i = i2 + 1;
        }
    }

    public static CharSequence a(String[] strArr, int[] iArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return spannableStringBuilder;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strArr[i2]);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(iArr[i2]), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            i = i2 + 1;
        }
    }

    public static String a(long j) {
        return f23750a.format(Long.valueOf(j));
    }

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static String a(Collection<String> collection, String str) {
        if (collection == null || collection.isEmpty() || str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str2 : collection) {
            if (i == collection.size() - 1) {
                sb.append(str2);
            } else {
                sb.append(str2);
                sb.append(str);
            }
            i++;
        }
        return sb.toString();
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(256);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
            i = i2 + 1;
        }
    }

    public static String a(byte[] bArr, String str) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean b(String str, String str2) {
        if (str2 == null || str == null) {
            return false;
        }
        return str2.contains(str);
    }

    public static boolean c(String str) {
        try {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean c(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 != null) {
            return str2.equals(str);
        }
        return false;
    }

    public static boolean d(String str) {
        boolean z = false;
        if (b(str)) {
            return false;
        }
        if (str.equals(AccessibleTouchItem.MY_LOCATION_PREFIX) || str.equals("当前位置") || str.equals("我在哪") || str.equals("我在哪儿") || str.equals("我在的位置") || str.equals("我的位置在哪") || str.equals("我的位置在哪儿")) {
            z = true;
        }
        return z;
    }

    public static boolean d(String str, String str2) {
        boolean z = false;
        if (str2 != null) {
            if (str == null) {
                return false;
            }
            z = false;
            if (str2.indexOf(str) == 0) {
                z = true;
            }
        }
        return z;
    }

    public static int e(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i + 1;
            i2 = str.substring(i, i3).matches("[一-龥]") ? i2 + 1 : (int) (i2 + 0.5d);
            i = i3;
        }
        return (int) Math.ceil(i2);
    }

    public static String f(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public static String g(String str) {
        if (b(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".");
        String str2 = str;
        if (lastIndexOf > 0) {
            str2 = str.substring(0, lastIndexOf);
        }
        return str2;
    }

    public static String h(String str) {
        if (b(str)) {
            return str;
        }
        try {
            URI uri = new URI(str);
            String[] split = uri.getQuery().split(ContainerUtils.FIELD_DELIMITER);
            Arrays.sort(split);
            StringBuilder sb = new StringBuilder();
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), sb.toString(), uri.getFragment()).toString();
                }
                sb.append(split[i2]);
                i = i2 + 1;
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String i(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "gbk");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static String j(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            return "";
        }
    }
}
