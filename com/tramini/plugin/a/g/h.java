package com.tramini.plugin.a.g;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/h.class */
public final class h {
    public static boolean a(Context context) {
        try {
            return b(context);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private static boolean b(Context context) {
        int port;
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                if (property2 == null) {
                    property2 = "-1";
                }
                port = Integer.parseInt(property2);
                str = property;
            } else {
                String host = Proxy.getHost(context);
                port = Proxy.getPort(context);
                str = host;
            }
            return (TextUtils.isEmpty(str) || port == -1) ? false : true;
        } catch (Throwable th) {
            return false;
        }
    }
}
