package a.a.a.a.a.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/d/h.class */
public class h {
    public static String a() {
        String trim = Build.MODEL.trim();
        String a2 = a(Build.MANUFACTURER.trim(), trim);
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            str = a(Build.BRAND.trim(), trim);
        }
        StringBuilder sb = new StringBuilder();
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(trim);
        return a(sb.toString()).replace(" ", "_");
    }

    public static String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (charAt > 31 && charAt < 127) {
                sb.append(charAt);
            }
            i = i2 + 1;
        }
    }

    public static String a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }
}
