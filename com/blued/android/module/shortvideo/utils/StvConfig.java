package com.blued.android.module.shortvideo.utils;

import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import java.io.File;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvConfig.class */
public class StvConfig {
    public static final String a = Environment.getExternalStorageDirectory() + "/ShortVideo/img/";
    private static String b;
    private static String c;

    public static String a() {
        File externalCacheDir;
        if (TextUtils.isEmpty(b) && (externalCacheDir = AppInfo.d().getExternalCacheDir()) != null && externalCacheDir.exists()) {
            externalCacheDir.mkdirs();
            String str = externalCacheDir.getAbsolutePath() + "/ShortVideo/";
            b = str;
            StvTools.c(str);
        }
        return b;
    }

    public static String b() {
        File externalCacheDir;
        if (TextUtils.isEmpty(c) && (externalCacheDir = AppInfo.d().getExternalCacheDir()) != null && externalCacheDir.exists()) {
            externalCacheDir.mkdirs();
            String str = externalCacheDir.getAbsolutePath() + "/AutnVideo/";
            c = str;
            StvTools.c(str);
            StvTools.c(a);
        }
        return c;
    }
}
