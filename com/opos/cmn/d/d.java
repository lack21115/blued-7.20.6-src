package com.opos.cmn.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.opos.cmn.i.i;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/d/d.class */
public class d {
    public static String a() {
        return com.opos.cmn.an.d.b.a.b() + File.separator + ".mob_ad" + File.separator + ".material" + File.separator + ".video";
    }

    public static String a(Context context, String str) {
        if (com.opos.cmn.an.d.b.a.a()) {
            if (a(context)) {
                String a2 = a(str);
                if (com.opos.cmn.an.d.b.a.a(a2)) {
                    return a2;
                }
            }
            String c2 = c(context, str);
            return !com.opos.cmn.an.d.b.a.a(c2) ? "" : c2;
        }
        return "";
    }

    public static String a(Context context, String str, String str2) {
        if (com.opos.cmn.an.d.b.a.a()) {
            if (a(context)) {
                String a2 = a(str);
                if (b.a(a2, str2)) {
                    return a2;
                }
            }
            String c2 = c(context, str);
            return !b.a(c2, str2) ? "" : c2;
        }
        return "";
    }

    private static String a(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return "";
        }
        return com.opos.cmn.an.d.b.a.b() + File.separator + ".mob_ad" + File.separator + ".material" + File.separator + ".video" + File.separator + b.a(str);
    }

    public static boolean a(Context context) {
        if (i.a(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}) && Build.VERSION.SDK_INT < 33) {
            return Build.VERSION.SDK_INT < 29 || Environment.isExternalStorageLegacy();
        }
        return false;
    }

    public static String b(Context context) {
        return context.getExternalFilesDir(".mob_ad").getAbsolutePath() + File.separator + ".material" + File.separator + ".video";
    }

    public static String b(Context context, String str) {
        return (!com.opos.cmn.an.d.b.a.a() || com.opos.cmn.an.c.a.a(str)) ? "" : c(context, str);
    }

    private static String c(Context context, String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return "";
        }
        return context.getExternalFilesDir(".mob_ad").getAbsolutePath() + File.separator + ".material" + File.separator + ".video" + File.separator + b.a(str);
    }
}
