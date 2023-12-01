package com.blued.android.module.media.audio.audio_manager;

import android.os.Build;
import android.util.Log;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLUtils.class */
public final class BLUtils {
    private BLUtils() {
    }

    public static String a() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
    }

    public static void a(String str) {
        Log.d(str, "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
    }

    public static void a(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }
}
