package com.blued.android.chat.utils;

import com.blued.android.statistics.BluedStatistics;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/utils/DataUtils.class */
public class DataUtils {
    private static String chatRealHost = "";
    private static int chatRealHostPort = 0;
    private static String chatRealIpAddr = "";

    public static void imMessageFailed(String str, long j, String str2) {
        BluedStatistics.b().a(str, j, str2, chatRealHost, chatRealHostPort, chatRealIpAddr);
    }

    public static void imMessageSuccess(String str, long j) {
        BluedStatistics.b().a(str, j, chatRealHost, chatRealHostPort, chatRealIpAddr);
    }

    public static void imMsgFieldTypeError(String str) {
        BluedStatistics.c().a("IM_FIELD_TYPE", 0L, 0, str);
    }

    public static void setChatRealNetArgs(String str, int i, String str2) {
        chatRealHost = str;
        chatRealIpAddr = str2;
        chatRealHostPort = i;
    }
}
