package com.kwad.components.core.r;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.s;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/d.class */
public final class d {
    public static void a(Activity activity, int i, boolean z) {
        a(activity, 0, true, true);
    }

    public static void a(Activity activity, int i, boolean z, boolean z2) {
        if (pO()) {
            b(activity, i, z);
            if (z2) {
                return;
            }
            activity.findViewById(R.id.content).setPadding(0, com.kwad.sdk.c.kwai.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static boolean a(Activity activity, boolean z) {
        try {
            int intValue = ((Integer) s.aa("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
            s.a((Object) activity.getWindow(), "setExtraFlags", Integer.valueOf(intValue), Integer.valueOf(intValue));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void b(Activity activity, int i, boolean z) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT < 21) {
            if (Build.VERSION.SDK_INT >= 19) {
                window.getDecorView().setSystemUiVisibility(1280);
                return;
            }
            return;
        }
        int i2 = 1280;
        if (z) {
            i2 = 1280;
            if (Build.VERSION.SDK_INT >= 23) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                if (as.DR()) {
                    a(activity, true);
                    i2 = 9472;
                } else {
                    i2 = 9472;
                    if (as.DS()) {
                        i.b(activity, true);
                        i2 = 9472;
                    }
                }
            }
        }
        window.getDecorView().setSystemUiVisibility(i2);
        window.setStatusBarColor(i);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    public static boolean pO() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
