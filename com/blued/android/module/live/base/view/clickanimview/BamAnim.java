package com.blued.android.module.live.base.view.clickanimview;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.OvershootInterpolator;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/clickanimview/BamAnim.class */
public class BamAnim {

    /* renamed from: a  reason: collision with root package name */
    public static OvershootInterpolator f11549a = new OvershootInterpolator(3.0f);

    public static void a(View view) {
        if (view.isClickable()) {
            c(view);
        }
    }

    public static void b(View view) {
        if (view.isClickable()) {
            d(view);
        }
    }

    public static void c(View view) {
        try {
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", view.getScaleX(), 0.9f), PropertyValuesHolder.ofFloat("scaleY", view.getScaleY(), 0.9f)).setDuration(300L);
            duration.setInterpolator(f11549a);
            duration.start();
        } catch (Exception e) {
        }
    }

    public static void d(View view) {
        try {
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", view.getScaleX(), 1.0f), PropertyValuesHolder.ofFloat("scaleY", view.getScaleY(), 1.0f)).setDuration(300L);
            duration.setInterpolator(f11549a);
            duration.start();
        } catch (Exception e) {
        }
    }
}
