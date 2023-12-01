package com.sobot.chat.core;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/SobotUtil.class */
public class SobotUtil {
    static {
        System.loadLibrary("sobot");
    }

    public static native String getKey(String str, String str2, String str3, String str4, String str5);
}
