package com.kwad.sdk.api.core;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/RequestParamsUtils.class */
public final class RequestParamsUtils {
    public static final String USER_AGENT_KEY = "User-Agent";
    private static String sUserAgent;

    public static String getUserAgent() {
        if (TextUtils.isEmpty(sUserAgent)) {
            sUserAgent = getUserAgentParams() + "ksad-android-3.3.40";
        }
        return sUserAgent;
    }

    private static String getUserAgentParams() {
        try {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            StringBuilder sb = new StringBuilder();
            int length = property.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    return sb.toString();
                }
                char charAt = property.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb.append(charAt);
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return "";
        }
    }
}
