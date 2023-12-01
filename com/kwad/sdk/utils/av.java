package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/av.class */
public final class av {
    private static String aAn;
    private static File aAo;

    private static boolean Eo() {
        try {
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return false;
        }
    }

    public static File cA(Context context) {
        File file = aAo;
        if (file != null) {
            return file;
        }
        String str = null;
        if (Eo()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                str = null;
                if (externalCacheDir != null) {
                    str = externalCacheDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
                str = null;
            }
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = context.getCacheDir().getPath();
        }
        File file2 = new File(str2 + File.separator + "ksadsdk");
        aAo = file2;
        if (!file2.exists()) {
            aAo.mkdirs();
        }
        return aAo;
    }

    public static File cB(Context context) {
        String cz = cz(context);
        File file = new File(cz + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File cC(Context context) {
        String cz = cz(context);
        File file = new File(cz + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File cD(Context context) {
        String str;
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            str = cz(context);
        } else {
            str = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(str + File.separator + "ksadlog");
    }

    public static String cE(Context context) {
        if (context == null) {
            return "";
        }
        String path = context.getFilesDir().getPath();
        return path + File.separator + "ksadsdk";
    }

    public static String cF(Context context) {
        return cA(context).getPath() + "/cookie";
    }

    private static String cz(Context context) {
        if (TextUtils.isEmpty(aAn)) {
            String str = null;
            if (Eo()) {
                try {
                    File externalFilesDir = context.getExternalFilesDir(null);
                    str = null;
                    if (externalFilesDir != null) {
                        str = externalFilesDir.getPath();
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.printStackTrace(e);
                    str = null;
                }
            }
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = context.getFilesDir().getPath();
            }
            String str3 = str2 + File.separator + "ksadsdk";
            aAn = str3;
            return str3;
        }
        return aAn;
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        String cE = cE(context);
        return cE + File.separator + "ksad/download/js" + File.separator + str;
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        String cE = cE(context);
        return cE + File.separator + "ksad/download/js";
    }
}
