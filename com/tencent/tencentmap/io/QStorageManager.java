package com.tencent.tencentmap.io;

import android.content.Context;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/io/QStorageManager.class */
public class QStorageManager {
    public static final String DATA = "data/";
    private static QStorageManager mInstance;

    private QStorageManager(Context context) {
    }

    public static QStorageManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new QStorageManager(context);
        }
        return mInstance;
    }

    public void clearOldConfig(Context context, String str) {
    }

    public String getAssetsDynamicPath() {
        return null;
    }

    public String getAssetsLoadPath(String str) {
        return null;
    }

    public File getCacheDir() {
        return null;
    }

    public String getConfigPath(String str) {
        return null;
    }

    public String getConfigTempPath(String str) {
        return null;
    }

    public File getDataDir() {
        return null;
    }

    public String getMapPath() {
        return null;
    }

    public String getRouteBlockPath() {
        return null;
    }

    public String getSatPath() {
        return null;
    }
}
