package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/az.class */
public final class az {
    public static boolean Es() {
        return y.i("ksadsdk_pref", "config_data_transfer", false);
    }

    private static void Et() {
        y.h("ksadsdk_pref", "config_data_transfer", true);
    }

    public static void Eu() {
        y.h("ksadsdk_pref", "splash_daily_transfer", true);
    }

    public static boolean Ev() {
        return y.i("ksadsdk_pref", "splash_daily_transfer", false);
    }

    public static void Ew() {
        y.h("ksadsdk_pref", "reward_auto_transfer", true);
    }

    public static boolean Ex() {
        return y.i("ksadsdk_pref", "reward_auto_transfer", false);
    }

    public static void Ey() {
        y.h("ksadsdk_pref", "interstitial_aggregate_transfer", true);
    }

    public static boolean Ez() {
        return y.i("ksadsdk_pref", "interstitial_aggregate_transfer", false);
    }

    public static String ap(Context context, String str) {
        File file = new File(context.getFilesDir(), str);
        if (file.exists()) {
            try {
                String D = com.kwad.sdk.crash.utils.h.D(file);
                return TextUtils.isEmpty(D) ? "" : D;
            } catch (Throwable th) {
                return "";
            }
        }
        return "";
    }

    public static void j(final Context context, final String str, final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.az.1
            @Override // java.lang.Runnable
            public final void run() {
                az.k(Context.this, str, str2);
            }
        });
    }

    public static void k(Context context, String str, String str2) {
        com.kwad.sdk.crash.utils.h.g(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
        Et();
    }
}
