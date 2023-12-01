package com.blued.android.module.shortvideo.utils;

import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import java.io.File;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvConfig.class */
public class StvConfig {

    /* renamed from: a  reason: collision with root package name */
    public static final String f15839a = Environment.getExternalStorageDirectory() + "/ShortVideo/img/";
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static String f15840c;

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
        if (TextUtils.isEmpty(f15840c) && (externalCacheDir = AppInfo.d().getExternalCacheDir()) != null && externalCacheDir.exists()) {
            externalCacheDir.mkdirs();
            String str = externalCacheDir.getAbsolutePath() + "/AutnVideo/";
            f15840c = str;
            StvTools.c(str);
            StvTools.c(f15839a);
        }
        return f15840c;
    }
}
