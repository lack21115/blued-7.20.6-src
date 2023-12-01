package com.kwad.sdk.crash.kwai;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/kwai/a.class */
public final class a {
    private static Context Op;
    private static String arl;

    private static File getDataDir(Context context) {
        File file = null;
        if (Build.VERSION.SDK_INT >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            file = context.getDataDir();
        }
        File file2 = file;
        if (file == null) {
            File file3 = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            file2 = file3;
            if (!file3.exists()) {
                return new File("/data/data/" + context.getPackageName());
            }
        }
        return file2;
    }

    public static void init(Context context, String str) {
        Op = context;
        arl = str;
    }

    public static boolean v(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static File zI() {
        File file = !TextUtils.isEmpty(arl) ? new File(arl) : new File(getDataDir(Op), "kwad_ex");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File zJ() {
        return new File(zI(), "java_crash/dump");
    }

    public static File zK() {
        return new File(zI(), "anr_log/dump");
    }

    public static File zL() {
        return new File(zI(), "native_crash_log/dump");
    }
}
