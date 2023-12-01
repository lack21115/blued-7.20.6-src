package com.kwad.sdk.utils;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bc.class */
public final class bc {
    private static Class<?> aAJ;

    private static String eQ(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            return com.kwad.sdk.crash.utils.h.c(runtime.exec("getprop " + str).getInputStream());
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return null;
        }
    }

    private static Object g(String str, Object... objArr) {
        try {
            if (aAJ == null) {
                aAJ = Class.forName("android.os.SystemProperties");
            }
            return s.c(aAJ, str, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
            return null;
        }
    }

    public static String get(String str) {
        Object g = g(MonitorConstants.CONNECT_TYPE_GET, str);
        return g instanceof String ? (String) g : eQ(str);
    }
}
