package com.alipay.apmobilesecuritysdk.otherid;

import android.content.Context;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.c.d;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper.class */
public class UmidSdkWrapper {
    private static final String UMIDTOKEN_FILE_NAME = "xxxwww_v2";
    private static final String UMIDTOKEN_KEY_NAME = "umidtk";
    private static volatile String cachedUmidToken = "";
    private static volatile boolean initUmidFinished = false;

    private static String compatUmidBug(Context context, String str) {
        if (a.a(str) || a.a(str, "000000000000000000000000")) {
            String utdid = UtdidWrapper.getUtdid(context);
            String str2 = utdid;
            if (utdid != null) {
                str2 = utdid;
                if (utdid.contains("?")) {
                    str2 = "";
                }
            }
            return a.a(str2) ? "" : str2;
        }
        return str;
    }

    public static String getSecurityToken(Context context) {
        String str;
        synchronized (UmidSdkWrapper.class) {
            try {
                str = cachedUmidToken;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public static String startUmidTaskSync(Context context, int i) {
        return "";
    }

    private static void updateLocalUmidToken(Context context, String str) {
        synchronized (UmidSdkWrapper.class) {
            try {
                if (a.b(str)) {
                    d.a(context, UMIDTOKEN_FILE_NAME, UMIDTOKEN_KEY_NAME, str);
                    cachedUmidToken = str;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
