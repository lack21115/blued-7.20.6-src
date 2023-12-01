package com.blued.android.framework.urlmanager;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/urlmanager/UrlFormatUtil.class */
public class UrlFormatUtil {
    public static String a(String str, String str2, Object... objArr) {
        if (str == null) {
            return "";
        }
        int i = 0;
        int length = objArr == null ? 0 : objArr.length;
        int parseInt = Integer.parseInt(str.substring(0, 1), 16) + 1;
        String[] strArr = new String[parseInt];
        while (i < parseInt) {
            strArr[i] = i < length ? String.valueOf(objArr[i]) : "";
            i++;
        }
        return String.format(str2 + str.substring(1), strArr);
    }
}
