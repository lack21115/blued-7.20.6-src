package com.soft.blued.ui.msg.util;

import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/util/ChatUtils.class */
public class ChatUtils {
    public static String a(boolean z, String str) {
        if (z && str.length() > 0) {
            boolean a2 = StringUtils.a(str.charAt(str.length() - 1));
            String str2 = a2 ? "你的" : "your";
            String str3 = a2 ? "他的" : "his";
            int lastIndexOf = str.lastIndexOf(str2);
            if (lastIndexOf > -1) {
                return str.substring(0, lastIndexOf) + str3 + str.substring(lastIndexOf + str2.length());
            }
        }
        return str;
    }
}
