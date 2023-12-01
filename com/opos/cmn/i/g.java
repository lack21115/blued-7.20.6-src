package com.opos.cmn.i;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.view.Window;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/g.class */
public final class g {
    public static void a(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null || !a((Context) activity)) {
            return;
        }
        a(activity, true);
        window.addFlags(4194304);
    }

    public static void a(Activity activity, boolean z) {
        if (activity == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("KeyguardUtils", "setShowWhenLocked =" + z);
        if (z) {
            if (Build.VERSION.SDK_INT > 27) {
                activity.setShowWhenLocked(true);
            }
            activity.getWindow().addFlags(524288);
            return;
        }
        if (Build.VERSION.SDK_INT > 27) {
            activity.setShowWhenLocked(false);
        }
        activity.getWindow().clearFlags(524288);
    }

    public static void a(Context context, Window window) {
        try {
            if (com.opos.cmn.a.a.c() && context != null && window != null && a(context) && Build.VERSION.SDK_INT <= 25) {
                window.addFlags(524288);
                window.addFlags(4194304);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("KeyguardUtils", "", (Throwable) e);
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        if (keyguardManager == null) {
            com.opos.cmn.an.f.a.a("KeyguardUtils", "null keyguard");
            return false;
        }
        com.opos.cmn.an.f.a.b("KeyguardUtils", "isKeyguardLocked -" + keyguardManager.isKeyguardLocked());
        return keyguardManager.isKeyguardLocked();
    }
}
