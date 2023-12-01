package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/a.class */
public final class a {
    private static final String[] abE = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean aY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (by(host)) {
                return true;
            }
            return bz(host);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean by(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = abE;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (str.contains(strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static boolean bz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : d.ua()) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
