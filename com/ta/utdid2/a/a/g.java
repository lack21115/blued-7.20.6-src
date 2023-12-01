package com.ta.utdid2.a.a;

import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/a/a/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f34898a = Pattern.compile("([\t\r\n])+");

    public static int a(String str) {
        int i = 0;
        if (str.length() > 0) {
            i = 0;
            for (char c2 : str.toCharArray()) {
                i = (i * 31) + c2;
            }
        }
        return i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m9885a(String str) {
        return str == null || str.length() <= 0;
    }
}
