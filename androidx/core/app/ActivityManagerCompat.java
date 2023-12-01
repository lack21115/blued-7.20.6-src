package androidx.core.app;

import android.app.ActivityManager;
import android.os.Build;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/ActivityManagerCompat.class */
public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
    }

    public static boolean isLowRamDevice(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return false;
    }
}
