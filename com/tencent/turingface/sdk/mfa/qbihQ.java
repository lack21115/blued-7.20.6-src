package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/qbihQ.class */
public final class qbihQ {
    public static String a(Context context) {
        return Build.VERSION.SDK_INT >= 14 ? System.getProperty("http.proxyHost") : Proxy.getHost(context);
    }

    public static int b(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                return Integer.parseInt(System.getProperty("http.proxyPort"));
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return Proxy.getPort(context);
    }
}
