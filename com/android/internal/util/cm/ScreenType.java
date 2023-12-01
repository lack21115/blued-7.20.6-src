package com.android.internal.util.cm;

import android.content.Context;
import android.view.DisplayInfo;
import android.view.WindowManager;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/ScreenType.class */
public class ScreenType {
    private static final int DEVICE_HYBRID = 1;
    private static final int DEVICE_PHONE = 0;
    private static final int DEVICE_TABLET = 2;
    private static int sDeviceType = -1;

    private static int getScreenType(Context context) {
        if (sDeviceType == -1) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayInfo displayInfo = new DisplayInfo();
            windowManager.getDefaultDisplay().getDisplayInfo(displayInfo);
            int min = (Math.min(displayInfo.logicalHeight, displayInfo.logicalWidth) * 160) / displayInfo.logicalDensityDpi;
            if (min < 600) {
                sDeviceType = 0;
            } else if (min < 720) {
                sDeviceType = 1;
            } else {
                sDeviceType = 2;
            }
        }
        return sDeviceType;
    }

    public static boolean isHybrid(Context context) {
        return getScreenType(context) == 1;
    }

    public static boolean isPhone(Context context) {
        return getScreenType(context) == 0;
    }

    public static boolean isTablet(Context context) {
        return getScreenType(context) == 2;
    }
}
