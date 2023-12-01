package com.kwad.sdk;

import android.os.SystemClock;
import android.util.Log;
import com.kwad.sdk.utils.y;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/g.class */
public final class g {
    private static boolean Yy;
    private static long Yz;

    public static void a(Throwable th, String str) {
        f.a(com.kwai.adclient.kscommerciallogger.model.a.aEm, str);
        com.kwad.components.core.c.a.b(th);
        com.kwad.sdk.core.d.b.d("SDKRevertHelper", "onInitError revert");
    }

    public static void f(Throwable th) {
        a(th, Log.getStackTraceString(th));
    }

    public static void sR() {
        if (Yy) {
            return;
        }
        Yy = true;
        Yz = SystemClock.elapsedRealtime();
    }

    public static void sS() {
        if (SystemClock.elapsedRealtime() - Yz < 10000) {
            com.kwad.sdk.core.d.b.d("SDKRevertHelper", "onException revert");
            sT();
        }
    }

    private static void sT() {
        y.a(KsAdSDKImpl.get().getContext(), "kssdk_api_pref", "curversion", "");
    }
}
