package com.zego.zegoliveroom.utils;

import android.os.Build;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/utils/ZegoCommonUtils.class */
public class ZegoCommonUtils {
    public static boolean isDeviceInBlackList() {
        return isMeizu_M5_Note_70_mt6755();
    }

    private static boolean isMeizu_M5_Note_70_mt6755() {
        return "meizu_M5 Note".equals(Build.PRODUCT) && "7.0".equals(Build.VERSION.RELEASE) && "mt6755".equals(Build.HARDWARE);
    }
}
