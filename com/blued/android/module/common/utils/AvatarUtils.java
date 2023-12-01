package com.blued.android.module.common.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/AvatarUtils.class */
public class AvatarUtils {
    public static String a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (i == 0) {
            return str + "!200x200.png";
        } else if (i == 2) {
            return str + "!300x300.png";
        } else if (i != 3) {
            return str + "!100x100.png";
        } else {
            return str + "!480x480.png";
        }
    }

    public static String a(String str) {
        return a(str, AppInfo.l);
    }

    public static String a(String str, int i) {
        return a(str, i, false);
    }

    public static String a(String str, int i, boolean z) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i2 = i;
        if (i == 0) {
            i2 = AppInfo.l;
        }
        if (z) {
            str2 = i2 > 480 ? "!640x640.png" : "!480x480.png";
            if (i2 > 640) {
                str2 = "!720x720.png";
            }
            if (i2 > 720) {
                str2 = "!1080x1080.png";
            }
            if (i2 > 1080) {
                str2 = "!original.png";
            }
        } else {
            str2 = i2 > 480 ? "!640x960.png" : "!480x720.png";
            if (i2 > 640) {
                str2 = "!720x1080.png";
            }
            if (i2 > 720) {
                str2 = "!1080x1620.png";
            }
            if (i2 > 1080) {
                str2 = "!original.png";
            }
        }
        return str + str2;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = AppInfo.l;
        String str2 = i > 480 ? "!640x640.png" : "!480x480.png";
        if (i > 640) {
            str2 = "!720x720.png";
        }
        if (i > 720) {
            str2 = "!1080x1080.png";
        }
        if (i > 1080) {
            str2 = "!original.png";
        }
        return str + str2;
    }
}
