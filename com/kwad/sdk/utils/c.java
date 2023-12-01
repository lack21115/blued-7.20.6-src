package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/c.class */
public final class c {
    public static boolean bw(Context context) {
        try {
            if (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
                return false;
            }
            return !Environment.isExternalStorageLegacy();
        } catch (Throwable th) {
            return false;
        }
    }
}
