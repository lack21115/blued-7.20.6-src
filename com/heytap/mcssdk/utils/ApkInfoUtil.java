package com.heytap.mcssdk.utils;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/utils/ApkInfoUtil.class */
public class ApkInfoUtil {
    private static final String FBE = "file";
    private static final String RO_CRYPTO_TYPE = "ro.crypto.type";

    private static String get(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isFBEVersion() {
        return "file".equals(get(RO_CRYPTO_TYPE));
    }
}
