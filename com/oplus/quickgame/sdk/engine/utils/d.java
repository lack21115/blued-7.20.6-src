package com.oplus.quickgame.sdk.engine.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, String> f24407a = new HashMap<>(8);

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/d$a.class */
    public enum a {
        INSTALL,
        OPEN
    }

    private static int a(char c2) {
        int i;
        int i2;
        if (c2 < '0' || c2 > '9') {
            if (c2 >= 'A' && c2 <= 'Z') {
                i2 = c2 + '\n';
                i = 65;
            } else if (c2 < 'a' || c2 > 'z') {
                return 0;
            } else {
                int i3 = c2 + '$';
                i = 97;
                i2 = i3;
            }
            return i2 - i;
        }
        return c2 - '0';
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 3) {
            return -1;
        }
        String substring = str.substring(str.length() - 1, str.length());
        String substring2 = str.substring(str.length() - 2, str.length() - 1);
        String substring3 = str.substring(str.length() - 3, str.length() - 2);
        try {
            return Integer.parseInt(substring) + (Integer.parseInt(substring2) * 10) + (Integer.parseInt(substring3) * 100);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f24407a.put(str, str2);
    }

    public static boolean a(a aVar) {
        String c2 = c(aVar == a.INSTALL ? "xgame_install_android_version_black_list" : "xgame_open_android_version_black_list");
        String[] strArr = null;
        if (!TextUtils.isEmpty(c2)) {
            strArr = c2.split("#");
        }
        if (strArr == null) {
            return false;
        }
        int c3 = e.c();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (String.valueOf(c3).equalsIgnoreCase(strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean a(a aVar, Context context) {
        int a2;
        String c2 = c(aVar == a.INSTALL ? "xgame_install_imei_range_2" : "xgame_open_imei_range_2");
        String[] split = !TextUtils.isEmpty(c2) ? c2.split("-") : null;
        if (split == null || split.length < 2) {
            return false;
        }
        int[] iArr = new int[2];
        try {
            iArr[0] = Integer.parseInt(split[0]);
            iArr[1] = Integer.parseInt(split[1]);
            if (Build.VERSION.SDK_INT >= 29) {
                String d = e.d(context);
                if (TextUtils.isEmpty(d)) {
                    return true;
                }
                a2 = b(d);
            } else {
                String b = e.b(context);
                if (TextUtils.isEmpty(b)) {
                    return true;
                }
                a2 = a(b);
            }
            return a2 != -1 && a2 >= iArr[0] && a2 <= iArr[1];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 3) {
            return -1;
        }
        String substring = str.substring(str.length() - 1);
        String substring2 = str.substring(str.length() - 2, str.length() - 1);
        String substring3 = str.substring(str.length() - 3, str.length() - 2);
        try {
            return ((a(substring.toCharArray()[0]) + ((a(substring2.toCharArray()[0]) * 10) + (a(substring3.toCharArray()[0]) * 100))) * 999) / 6882;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean b(a aVar) {
        String c2 = c(aVar == a.INSTALL ? "xgame_install_phone_black_list" : "xgame_open_phone_black_list");
        String[] strArr = null;
        if (!TextUtils.isEmpty(c2)) {
            strArr = c2.split("#");
        }
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (Build.MODEL.equalsIgnoreCase(strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : f24407a.get(str);
    }
}
