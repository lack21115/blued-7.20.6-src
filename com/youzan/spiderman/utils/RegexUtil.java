package com.youzan.spiderman.utils;

import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/RegexUtil.class */
public class RegexUtil {
    public static boolean isMatch(String str, String str2) {
        return Pattern.compile(str).matcher(str2).find();
    }
}
