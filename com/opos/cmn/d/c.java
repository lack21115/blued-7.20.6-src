package com.opos.cmn.d;

import android.content.Context;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/d/c.class */
public class c {
    public static String a(Context context) {
        if (context != null) {
            return c(context) + File.separator + ".tmp";
        }
        return "";
    }

    public static String a(Context context, String str) {
        return (context == null || com.opos.cmn.an.c.a.a(str)) ? "" : b(context, a(str));
    }

    public static String a(String str) {
        return !com.opos.cmn.an.c.a.a(str) ? com.opos.cmn.an.a.c.a(str) : "";
    }

    public static String b(Context context) {
        if (context != null) {
            return c(context) + File.separator + ".material";
        }
        return "";
    }

    private static String b(Context context, String str) {
        if (context == null || com.opos.cmn.an.c.a.a(str)) {
            return "";
        }
        return b(context) + File.separator + str;
    }

    public static String c(Context context) {
        if (context != null) {
            try {
                return com.opos.cmn.an.d.b.a.a() ? context.getExternalFilesDir(".mob_ad").getAbsolutePath() : "";
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("", "getMobAdFolderPath", (Throwable) e);
                return "";
            }
        }
        return "";
    }
}
