package com.huawei.hms.framework.common;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/common/PowerUtils.class */
public class PowerUtils {
    private static final String TAG = "PowerUtils";

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/common/PowerUtils$PowerMode.class */
    public static final class PowerMode {
        static int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        static int POWER_SAVER_MODE = 4;
        static String SMART_MODE_STATUS = "SmartModeStatus";
    }

    public static boolean isAppIdleMode(Context context) {
        if (context == null) {
            Logger.i(TAG, "isAppIdleMode Context is null!");
            return false;
        }
        String packageName = context.getPackageName();
        UsageStatsManager usageStatsManager = null;
        if (Build.VERSION.SDK_INT < 21) {
            Logger.i(TAG, "isAppIdleMode statsManager is null!");
        } else if (Build.VERSION.SDK_INT >= 22) {
            Object systemService = context.getSystemService(Context.USAGE_STATS_SERVICE);
            if (!(systemService instanceof UsageStatsManager)) {
                return false;
            }
            usageStatsManager = (UsageStatsManager) systemService;
        }
        if (usageStatsManager == null) {
            Logger.i(TAG, "isAppIdleMode statsManager is null!");
            return false;
        } else if (Build.VERSION.SDK_INT >= 23) {
            return usageStatsManager.isAppInactive(packageName);
        } else {
            return false;
        }
    }

    public static boolean isDozeIdleMode(Context context) {
        if (context == null) {
            Logger.i(TAG, "isDozeIdleMode Context is null!");
            return false;
        }
        Object systemService = ContextCompat.getSystemService(context, "power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager == null) {
            Logger.i(TAG, "isDozeIdleMode powerManager is null!");
            return false;
        } else if (Build.VERSION.SDK_INT < 23) {
            Logger.i(TAG, "isDozeIdleMode is version control state!");
            return false;
        } else {
            try {
                return powerManager.isDeviceIdleMode();
            } catch (RuntimeException e) {
                Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
                return false;
            }
        }
    }

    public static boolean isInteractive(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            if (systemService instanceof PowerManager) {
                PowerManager powerManager = (PowerManager) systemService;
                if (Build.VERSION.SDK_INT >= 20) {
                    try {
                        return powerManager.isInteractive();
                    } catch (RuntimeException e) {
                        Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName() + e.getMessage());
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean isWhilteList(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            String packageName = context.getPackageName();
            if (powerManager == null || Build.VERSION.SDK_INT < 23) {
                return false;
            }
            try {
                return powerManager.isIgnoringBatteryOptimizations(packageName);
            } catch (RuntimeException e) {
                Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
                return false;
            }
        }
        return false;
    }

    public static int readDataSaverMode(Context context) {
        if (context == null) {
            Logger.i(TAG, "readDataSaverMode manager is null!");
            return 0;
        }
        Object systemService = context.getSystemService(Context.CONNECTIVITY_SERVICE);
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            Logger.i(TAG, "readDataSaverMode Context is null!");
            return 0;
        } else if (Build.VERSION.SDK_INT < 16 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return 0;
        } else {
            if (!connectivityManager.isActiveNetworkMetered()) {
                Logger.v(TAG, "ConnectType is not Mobile Network!");
                return 0;
            } else if (Build.VERSION.SDK_INT >= 24) {
                return connectivityManager.getRestrictBackgroundStatus();
            } else {
                return 0;
            }
        }
    }

    public static int readPowerSaverMode(Context context) {
        int i;
        if (context != null) {
            int systemInt = SettingUtil.getSystemInt(context.getContentResolver(), PowerMode.SMART_MODE_STATUS, PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE);
            i = systemInt;
            if (systemInt == PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE) {
                Object systemService = ContextCompat.getSystemService(context, "power");
                PowerManager powerManager = null;
                if (systemService instanceof PowerManager) {
                    powerManager = (PowerManager) systemService;
                }
                i = systemInt;
                if (powerManager != null) {
                    if (Build.VERSION.SDK_INT < 21) {
                        Logger.i(TAG, "readPowerSaverMode is control by version!");
                        return systemInt;
                    }
                    try {
                        return powerManager.isPowerSaveMode() ? PowerMode.POWER_SAVER_MODE : PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE;
                    } catch (RuntimeException e) {
                        Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
                        return systemInt;
                    }
                }
            }
        } else {
            Logger.i(TAG, "readPowerSaverMode Context is null!");
            i = 0;
        }
        return i;
    }
}
