package com.sobot.chat.api.apiUtils;

import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/apiUtils/SobotBaseUrl.class */
public class SobotBaseUrl {
    private static String api_host;
    private static final String baseHost = "https://api.sobot.com/";
    public static final String defaultHostname = "api.sobot.com";
    private static String mHost;

    public static String getApi_Host() {
        return !TextUtils.isEmpty(api_host) ? api_host : baseHost;
    }

    public static String getBaseIp() {
        return getApi_Host() + "chat-sdk/sdk/user/v2/";
    }

    @Deprecated
    public static String getHost() {
        return !TextUtils.isEmpty(mHost) ? mHost : baseHost;
    }

    public static void setApi_Host(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("/")) {
            api_host = str;
            mHost = str;
            return;
        }
        String str2 = str + "/";
        api_host = str2;
        mHost = str2;
    }

    @Deprecated
    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("/")) {
            mHost = str;
            api_host = str;
            return;
        }
        String str2 = str + "/";
        mHost = str2;
        api_host = str2;
    }
}
