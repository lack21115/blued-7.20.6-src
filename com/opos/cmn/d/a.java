package com.opos.cmn.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.opos.cmn.i.i;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/d/a.class */
public class a {
    public static String a() {
        return com.opos.cmn.an.d.b.a.b() + File.separator + "MobDownload";
    }

    public static String a(Context context, String str) {
        return !com.opos.cmn.an.d.b.a.a() ? "" : b(context, str);
    }

    public static boolean a(Context context) {
        if (i.a(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"})) {
            return Build.VERSION.SDK_INT < 29 || Environment.isExternalStorageLegacy();
        }
        return false;
    }

    public static String b(Context context) {
        return c(context);
    }

    private static String b(Context context, String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return "";
        }
        return context.getExternalFilesDir("MobDownload").getAbsolutePath() + File.separator + b.a(str);
    }

    public static String c(Context context) {
        return context.getExternalFilesDir("MobDownload").getAbsolutePath();
    }
}
