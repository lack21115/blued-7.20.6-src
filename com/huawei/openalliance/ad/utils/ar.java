package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/ar.class */
public abstract class ar {
    private static final String Code = "StoUtils";

    public static String B(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath();
            }
            return null;
        } catch (Exception e) {
            ge.I(Code, "getExternalFilesDir exception, use memory card folder.");
            return null;
        }
    }

    public static String Code(Context context) {
        String I;
        return (!V() || (I = I(context)) == null) ? V(context) : I;
    }

    static boolean Code() {
        try {
            if (ay.Code()) {
                return Environment.isExternalStorageRemovable();
            }
            return true;
        } catch (Throwable th) {
            ge.I(Code, "isExternalStorageRemovable, " + th.getClass().getSimpleName());
            return true;
        }
    }

    public static String I(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                return externalFilesDir.getAbsolutePath();
            }
            return null;
        } catch (Exception e) {
            ge.I(Code, "getExternalFilesDir exception, use memory card folder.");
            return null;
        }
    }

    public static String V(Context context) {
        File filesDir;
        return (context == null || (filesDir = context.getFilesDir()) == null) ? "" : filesDir.getAbsolutePath();
    }

    private static boolean V() {
        return TextUtils.equals(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState()) || !Code();
    }

    public static String Z(Context context) {
        File cacheDir;
        return (context == null || (cacheDir = context.getCacheDir()) == null) ? "" : cacheDir.getAbsolutePath();
    }
}
