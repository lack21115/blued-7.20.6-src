package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/w.class */
final class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean is64Bit() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Process.is64Bit();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Boolean) Reflect.bf("dalvik.system.VMRuntime").bi("getRuntime").bi("is64Bit").get()).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static String tz() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
