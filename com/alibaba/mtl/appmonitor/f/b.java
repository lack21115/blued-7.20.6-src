package com.alibaba.mtl.appmonitor.f;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/f/b.class */
public class b {
    public static boolean c(String str) {
        return !isBlank(str);
    }

    public static boolean isBlank(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }
}
