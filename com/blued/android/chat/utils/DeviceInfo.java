package com.blued.android.chat.utils;

import android.os.Build;
import com.blued.android.chat.ChatManager;
import java.util.TimeZone;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/utils/DeviceInfo.class */
public class DeviceInfo {
    public static boolean fitApiLevel(int i) {
        try {
            return Integer.parseInt(Build.VERSION.SDK) >= i;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String getCountry() {
        return ChatManager.context.getResources().getConfiguration().locale.getCountry();
    }

    public static String getDeviceInfo() {
        return "Language:" + getLanguage() + ", Country:" + getCountry() + ", TimeZone:" + getTimeZone();
    }

    private static String getLanguage() {
        return ChatManager.context.getResources().getConfiguration().locale.getLanguage();
    }

    private static String getTimeZone() {
        return TimeZone.getDefault().getID();
    }
}
