package de.robv.android.xposed;

import android.os.SELinux;
import de.robv.android.xposed.services.BaseService;
import de.robv.android.xposed.services.BinderService;
import de.robv.android.xposed.services.DirectAccessService;
import de.robv.android.xposed.services.ZygoteService;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/SELinuxHelper.class */
public final class SELinuxHelper {
    private static boolean sIsSELinuxEnabled = false;
    private static BaseService sServiceAppDataFile = null;

    private SELinuxHelper() {
    }

    public static BaseService getAppDataFileService() {
        if (sServiceAppDataFile != null) {
            return sServiceAppDataFile;
        }
        throw new UnsupportedOperationException();
    }

    public static String getContext() {
        if (sIsSELinuxEnabled) {
            return SELinux.getContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initForProcess(String str) {
        if (!sIsSELinuxEnabled) {
            sServiceAppDataFile = new DirectAccessService();
        } else if (str == null) {
            sServiceAppDataFile = new ZygoteService();
        } else if (str.equals("android")) {
            sServiceAppDataFile = BinderService.getService(0);
        } else {
            sServiceAppDataFile = new DirectAccessService();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initOnce() {
        try {
            sIsSELinuxEnabled = SELinux.isSELinuxEnabled();
        } catch (NoClassDefFoundError e) {
        }
    }

    public static boolean isSELinuxEnabled() {
        return sIsSELinuxEnabled;
    }

    public static boolean isSELinuxEnforced() {
        return sIsSELinuxEnabled && SELinux.isSELinuxEnforced();
    }
}
