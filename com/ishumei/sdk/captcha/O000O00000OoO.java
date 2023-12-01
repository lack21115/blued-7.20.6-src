package com.ishumei.sdk.captcha;

import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/sdk/captcha/O000O00000OoO.class */
public class O000O00000OoO {
    public static boolean O0000O000000oO(String str) {
        if (str == null) {
            return true;
        }
        return str.isEmpty();
    }

    public static boolean O0000O000000oO(String str, String str2) {
        return TextUtils.equals(str, str2);
    }

    public static boolean O000O00000OoO(String str) {
        return !O0000O000000oO(str);
    }
}
