package com.tencent.qmsp.sdk.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/f/f.class */
public class f {
    public static NetworkInfo a(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        } catch (Throwable th) {
            g.b("Qp.NU", 0, th.toString());
            return null;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo a2 = a(context);
        boolean z = false;
        if (a2 != null) {
            z = false;
            if (a2.getType() == 1) {
                z = true;
            }
        }
        return z;
    }
}
