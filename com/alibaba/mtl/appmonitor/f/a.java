package com.alibaba.mtl.appmonitor.f;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/f/a.class */
public class a {
    public static int a(String str) {
        if (b.c(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return 0;
    }
}
