package com.blued.android.framework.view.SuperToast.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import com.blued.android.framework.view.SuperToast.SuperActivityToast;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/utils/AnimationUtils.class */
public class AnimationUtils {
    public static Animator a(SuperActivityToast superActivityToast) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f);
        return ObjectAnimator.ofPropertyValuesHolder(superActivityToast.k(), PropertyValuesHolder.ofFloat("translationY", -250.0f, 0.0f), ofFloat).setDuration(250L);
    }

    public static Animator b(SuperActivityToast superActivityToast) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f);
        return ObjectAnimator.ofPropertyValuesHolder(superActivityToast.k(), PropertyValuesHolder.ofFloat("translationY", 0.0f, -250.0f), ofFloat).setDuration(250L);
    }
}
