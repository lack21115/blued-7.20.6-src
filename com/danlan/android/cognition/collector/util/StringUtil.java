package com.danlan.android.cognition.collector.util;

import android.text.TextUtils;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/util/StringUtil.class */
public class StringUtil {
    public static boolean isNumeric(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isDigit(charSequence.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }
}
