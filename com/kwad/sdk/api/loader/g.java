package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/g.class */
public final class g {
    static String ZA = "autoRevert";

    public static String ao(Context context) {
        return getVersion(context, "curversion");
    }

    public static String ap(Context context) {
        return getVersion(context, "newversion");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String aq(Context context) {
        return getVersion(context, "apiversion");
    }

    private static void b(Context context, String str, String str2) {
        t.c(context, str, str2);
    }

    private static String getVersion(Context context, String str) {
        return t.d(context, str, "");
    }

    public static void h(Context context, String str) {
        b(context, "curversion", str);
    }

    public static void i(Context context, String str) {
        b(context, "newversion", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(Context context, String str) {
        b(context, "apiversion", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length || i2 >= split2.length) {
                    break;
                }
                try {
                    int parseInt = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
                    if (parseInt > 0) {
                        return true;
                    }
                    if (parseInt < 0) {
                        return false;
                    }
                    i = i2 + 1;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return split.length > split2.length;
        }
        return true;
    }
}
