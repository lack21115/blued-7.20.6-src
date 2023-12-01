package com.weimob.library.groups.imageloader.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import com.weimob.library.groups.imageloader.core.DisplayImageOptions;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/core/DefaultConfigurationFactory.class */
public class DefaultConfigurationFactory {
    public static Bitmap.Config getBitmapConfig() {
        return Bitmap.Config.RGB_565;
    }

    public static DisplayImageOptions getDefaultDisplayImageOptions(Context context) {
        return new DisplayImageOptions.Builder(context).build();
    }

    public static int getEncodeMaxCacheSize() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return 1048576;
        }
        return min < 33554432 ? 2097152 : 4194304;
    }

    public static int getMaxDiskCacheSize() {
        return 104857600;
    }

    public static int getMaxMemoryCacheSize(Context context) {
        int min = Math.min(((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (min < 33554432) {
            return 4194304;
        }
        if (min < 67108864) {
            return IntentFilter.MATCH_CATEGORY_TYPE;
        }
        if (Build.VERSION.SDK_INT < 11) {
            return 8388608;
        }
        return min / 5;
    }
}
