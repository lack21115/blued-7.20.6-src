package android.app;

import android.content.pm.IPackageManager;

/* loaded from: source-9557208-dex2jar.jar:android/app/AppGlobals.class */
public class AppGlobals {
    public static Application getInitialApplication() {
        return ActivityThread.currentApplication();
    }

    public static String getInitialPackage() {
        return ActivityThread.currentPackageName();
    }

    public static int getIntCoreSetting(String str, int i) {
        ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
        int i2 = i;
        if (currentActivityThread != null) {
            i2 = currentActivityThread.getIntCoreSetting(str, i);
        }
        return i2;
    }

    public static IPackageManager getPackageManager() {
        return ActivityThread.getPackageManager();
    }
}
