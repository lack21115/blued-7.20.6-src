package com.tencent.tencentmap.mapsdk.maps.storage;

import android.content.Context;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mapsdk.internal.f7;
import com.tencent.mapsdk.internal.ga;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/storage/StorageManager.class */
public class StorageManager {
    private static final String ROOT_DIR = "/tencentmapsdk/";
    private static StorageManager mInstance;
    private String mAppRootDir;
    private Context mContext;
    private String mCustomCacheRootPath;

    private StorageManager(Context context, String str) {
        if (context == null) {
            throw new Error("context can not be null");
        }
        this.mContext = context.getApplicationContext();
        this.mCustomCacheRootPath = str;
        updatePublicPath();
    }

    public static void clearMapCache(Context context, String str) {
        ga.e(getInstance(context, str).getCacheDir());
    }

    private static long getAvailableStorageSize(String str) {
        long blockSizeLong;
        long availableBlocksLong;
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT < 18) {
                blockSizeLong = statFs.getBlockSize();
                availableBlocksLong = statFs.getAvailableBlocks();
            } else {
                blockSizeLong = statFs.getBlockSizeLong();
                availableBlocksLong = statFs.getAvailableBlocksLong();
            }
            return ((blockSizeLong * availableBlocksLong) / 1024) / 1024;
        } catch (Exception e) {
            return 0L;
        }
    }

    private static String getExternalStoragePath(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        return externalFilesDir != null ? externalFilesDir.getAbsolutePath() : context.getFilesDir().getPath();
    }

    public static StorageManager getInstance(Context context, String str) {
        if (mInstance == null) {
            mInstance = new StorageManager(context, str);
        }
        return mInstance;
    }

    private String getStorageRootPath() {
        if (TextUtils.isEmpty(this.mCustomCacheRootPath)) {
            Context context = this.mContext;
            String externalStoragePath = getExternalStoragePath(context);
            String str = externalStoragePath;
            if (getAvailableStorageSize(externalStoragePath) < 5) {
                String path = context.getFilesDir().getPath();
                str = path;
                if (getAvailableStorageSize(path) < 5) {
                    str = getExternalStoragePath(context);
                }
            }
            return str;
        }
        return this.mCustomCacheRootPath;
    }

    private void updatePublicPath() {
        String storageRootPath = getStorageRootPath();
        String a2 = ga.a(this.mContext);
        if (f7.b(a2)) {
            this.mAppRootDir = storageRootPath + ROOT_DIR;
            return;
        }
        this.mAppRootDir = storageRootPath + ROOT_DIR + a2;
    }

    public File getCacheDir() {
        return new File(this.mAppRootDir);
    }
}
