package com.qiniu.android.collect;

import android.os.Environment;
import com.qiniu.android.utils.ContextGetter;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/collect/Config.class */
public final class Config {
    public static String dnscacheDir;
    public static int interval = 0;
    public static boolean isRecord = true;
    public static boolean isUpload = true;
    public static int maxRecordFileSize = 0;
    public static String preQueryHost;
    public static int rePreHost = 0;
    public static String recordDir;
    public static final String serverURL = "https://uplog.qbox.me/log/4";
    public static int uploadThreshold;

    static {
        try {
            recordDir = ContextGetter.applicationContext().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
        maxRecordFileSize = 2097152;
        uploadThreshold = 4096;
        interval = 10;
        dnscacheDir = Environment.getExternalStorageDirectory() + "/dnschache/";
        preQueryHost = "uc.qbox.me";
        rePreHost = 2;
    }

    public static void normal() {
        uploadThreshold = 4096;
        interval = 10;
    }

    public static void quick() {
        uploadThreshold = 1024;
        interval = 2;
    }

    public static void slow() {
        uploadThreshold = 153600;
        interval = 300;
    }
}
