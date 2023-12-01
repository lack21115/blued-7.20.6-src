package com.anythink.expressad.atsignalcommon.windvane;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/n.class */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4274a = {"wv_hybrid:", "mraid:", "ssp:", "mvb_hybrid:"};
    private static final Pattern b = Pattern.compile("hybrid://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f4275c = Pattern.compile("mraid://(.+?):(.+?)/(.+?)(\\?(.*?))?");
    private static final Pattern d = Pattern.compile("ssp://(.+?):(.+?)/(.+?)(\\?(.*?))?");
    private static final Pattern e = Pattern.compile("mv://(.+?):(.+?)/(.+?)(\\?(.*?))?");
    private static Map<String, String> f = new HashMap();

    static {
        h[] values = h.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            h hVar = values[i2];
            f.put(hVar.a(), hVar.b());
            i = i2 + 1;
        }
    }

    public static boolean a(String str) {
        String[] strArr = f4274a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (strArr[i2].equals(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static Pattern b(String str) {
        if ("wv_hybrid:".equals(str)) {
            return e;
        }
        if ("mraid:".equals(str)) {
            return f4275c;
        }
        if ("ssp:".equals(str)) {
            return d;
        }
        if ("mvb_hybrid:".equals(str)) {
            return e;
        }
        return null;
    }

    public static String c(String str) {
        boolean z;
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.setLength(0);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return new String(stringBuffer);
            }
            char charAt = str.charAt(i2);
            if (charAt > 255) {
                stringBuffer.append("\\u");
                String upperCase = Integer.toHexString(charAt >>> '\b').toUpperCase();
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                String upperCase2 = Integer.toHexString(charAt & 255).toUpperCase();
                if (upperCase2.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase2);
            } else {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= 2) {
                        z = false;
                        break;
                    } else if (new char[]{'\'', '\\'}[i4] == charAt) {
                        stringBuffer.append("\\".concat(String.valueOf(charAt)));
                        z = true;
                        break;
                    } else {
                        i3 = i4 + 1;
                    }
                }
                if (!z) {
                    stringBuffer.append(charAt);
                }
            }
            i = i2 + 1;
        }
    }

    public static boolean d(String str) {
        return e(str).startsWith("image");
    }

    public static String e(String str) {
        String str2 = f.get(f(str));
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        return str3;
    }

    private static String f(String str) {
        String path;
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (path = Uri.parse(str).getPath()) == null || (lastIndexOf = path.lastIndexOf(".")) == -1) ? "" : path.substring(lastIndexOf + 1);
    }
}
