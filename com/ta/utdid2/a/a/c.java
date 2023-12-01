package com.ta.utdid2.a.a;

import android.os.Build;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/a/a/c.class */
public class c {
    public static boolean a() {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 29) {
            if (Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'Q' && Build.VERSION.CODENAME.charAt(0) <= 'Z') {
                return true;
            }
            z = false;
        }
        return z;
    }
}
