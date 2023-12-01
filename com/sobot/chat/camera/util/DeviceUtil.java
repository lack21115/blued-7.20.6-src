package com.sobot.chat.camera.util;

import android.os.Build;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/util/DeviceUtil.class */
public class DeviceUtil {
    private static String[] huaweiRongyao = {"hwH60", "hwPE", "hwH30", "hwHol", "hwG750", "hw7D", "hwChe2"};

    public static String getDeviceInfo() {
        return "手机型号：" + Build.DEVICE + "\n系统版本：" + Build.VERSION.RELEASE + "\nSDK版本：" + Build.VERSION.SDK_INT;
    }

    public static String getDeviceModel() {
        return Build.DEVICE;
    }

    public static boolean isHuaWeiRongyao() {
        int length = huaweiRongyao.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (huaweiRongyao[i2].equals(getDeviceModel())) {
                return true;
            }
            i = i2 + 1;
        }
    }
}
