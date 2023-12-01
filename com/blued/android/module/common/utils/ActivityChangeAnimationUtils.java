package com.blued.android.module.common.utils;

import android.app.Activity;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ActivityChangeAnimationUtils.class */
public class ActivityChangeAnimationUtils {
    public static void a(Activity activity) {
        activity.overridePendingTransition(R.anim.push_down_in, R.anim.alpha_dark);
    }

    public static void b(Activity activity) {
        activity.overridePendingTransition(R.anim.push_up_in, R.anim.alpha_dark);
    }

    public static void c(Activity activity) {
        activity.overridePendingTransition(R.anim.alpha_dark, R.anim.push_down_out);
    }

    public static void d(Activity activity) {
        activity.overridePendingTransition(R.anim.alpha_dark, R.anim.push_up_out);
    }

    public static void e(Activity activity) {
        activity.overridePendingTransition(R.anim.activity_in_from_right, R.anim.activity_out_to_left);
    }

    public static void f(Activity activity) {
        activity.overridePendingTransition(R.anim.alpha_dark, R.anim.activity_out_to_right);
    }

    public static void g(Activity activity) {
        activity.overridePendingTransition(R.anim.activity_in_from_left, R.anim.alpha_dark);
    }

    public static void h(Activity activity) {
        activity.overridePendingTransition(R.anim.m_fade_in, R.anim.m_fade_out);
    }

    public static void i(Activity activity) {
        activity.overridePendingTransition(R.anim.scale_in, R.anim.scale_still);
    }

    public static void j(Activity activity) {
        activity.overridePendingTransition(R.anim.scale_still, R.anim.scale_out);
    }

    public static void k(Activity activity) {
        activity.overridePendingTransition(0, 0);
    }
}
