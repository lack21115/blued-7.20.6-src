package com.anythink.expressad.foundation.h;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.net.URL;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/x.class */
public final class x {
    public static String a(String str) {
        String str2 = str;
        try {
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
                if (URLUtil.isValidUrl(str)) {
                    str2 = new URL(str).getPath();
                }
            }
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2) {
        String str3 = str;
        try {
            if (!TextUtils.isEmpty(str)) {
                str3 = str;
                if (URLUtil.isValidUrl(str)) {
                    str3 = Uri.parse(str).getQueryParameter(str2);
                }
            }
            return str3;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int b(String str) {
        try {
            if (TextUtils.isEmpty(str) || !URLUtil.isValidUrl(str)) {
                return 0;
            }
            return Uri.parse(str).getQueryParameterNames().size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String c(String str) {
        String str2 = str;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("n_logo=0")) {
                    return str;
                }
                Set<String> queryParameterNames = Uri.parse(str).getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() != 0) {
                    return str + "&n_logo=0";
                }
                str2 = str + "?n_logo=0";
            }
            return str2;
        } catch (Exception e) {
            return str;
        }
    }
}
