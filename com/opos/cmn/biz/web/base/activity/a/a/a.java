package com.opos.cmn.biz.web.base.activity.a.a;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/base/activity/a/a/a.class */
public class a {
    public static void a(Activity activity) {
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }

    private static void a(Activity activity, boolean z) {
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                int i = systemUiVisibility;
                if (Build.VERSION.SDK_INT >= 23) {
                    i = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
                }
                window.getDecorView().setSystemUiVisibility(i);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("Utils", "", e);
            }
        }
    }

    public static void b(Activity activity) {
        if (activity != null) {
            try {
                if (activity.getWindow() != null) {
                    Window window = activity.getWindow();
                    if (Build.VERSION.SDK_INT >= 23) {
                        window.getDecorView().setSystemUiVisibility(1280);
                        window.addFlags(Integer.MIN_VALUE);
                        window.setStatusBarColor(Color.parseColor("#F5EEEEEE"));
                    }
                    a(activity, !com.opos.cmn.biz.web.b.a.a.a(activity));
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("Utils", "setWhiteStatusBar", e);
            }
        }
    }
}
