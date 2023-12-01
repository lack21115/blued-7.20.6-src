package com.blued.android.module.live_china.utils;

import android.graphics.Color;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/ColorUtil.class */
public class ColorUtil {
    public static int a(int i, int i2, float f) {
        return Color.parseColor(a("#" + Integer.toHexString(i), "#" + Integer.toHexString(i2), f));
    }

    public static String a(int i) {
        String hexString = Integer.toHexString(i);
        String str = hexString;
        if (hexString.length() == 1) {
            str = "0" + hexString;
        }
        return str;
    }

    public static String a(String str, String str2, float f) {
        int parseInt = Integer.parseInt(str.substring(1, 3), 16);
        int parseInt2 = Integer.parseInt(str.substring(3, 5), 16);
        int parseInt3 = Integer.parseInt(str.substring(5, 7), 16);
        int parseInt4 = Integer.parseInt(str.substring(7), 16);
        int parseInt5 = Integer.parseInt(str2.substring(1, 3), 16);
        int parseInt6 = Integer.parseInt(str2.substring(3, 5), 16);
        int parseInt7 = Integer.parseInt(str2.substring(5, 7), 16);
        int i = (int) (((parseInt5 - parseInt) * f) + parseInt);
        int i2 = (int) (((parseInt6 - parseInt2) * f) + parseInt2);
        int i3 = (int) (((parseInt7 - parseInt3) * f) + parseInt3);
        int parseInt8 = (int) (((Integer.parseInt(str2.substring(7), 16) - parseInt4) * f) + parseInt4);
        return "#" + a(i) + a(i2) + a(i3) + a(parseInt8);
    }
}
