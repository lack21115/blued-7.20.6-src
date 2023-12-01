package com.kwad.sdk.utils;

import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bj.class */
public final class bj {
    public static boolean aj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length || i2 >= split2.length) {
                break;
            }
            try {
                int parseInt = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
                if (parseInt > 0) {
                    return true;
                }
                if (parseInt < 0) {
                    return false;
                }
                i = i2 + 1;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return split.length >= split2.length;
    }
}
