package com.blued.android.module.common.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/AnimationUtils.class */
public class AnimationUtils {
    public static AnimationSet a(View view, float f, float f2, int i, int i2) {
        if (view != null) {
            AnimationSet animationSet = new AnimationSet(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setRepeatCount(i);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setRepeatCount(i);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.setDuration(i2);
            animationSet.setFillAfter(false);
            animationSet.setRepeatCount(i);
            return animationSet;
        }
        return null;
    }

    public static void a(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(600L);
        view.startAnimation(alphaAnimation);
    }

    public static void a(final View view, float f, final int i, int i2, long j) {
        final AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(i2);
        final int[] iArr = {1};
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.common.utils.AnimationUtils.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View.this.setVisibility(4);
                if (iArr[0] < i) {
                    View.this.postDelayed(new Runnable() { // from class: com.blued.android.module.common.utils.AnimationUtils.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            View.this.startAnimation(animationSet);
                        }
                    }, 800L);
                }
                int[] iArr2 = iArr;
                iArr2[0] = iArr2[0] + 1;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                View.this.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                View.this.setVisibility(0);
            }
        });
        view.postDelayed(new Runnable() { // from class: com.blued.android.module.common.utils.AnimationUtils.2
            @Override // java.lang.Runnable
            public void run() {
                View.this.startAnimation(animationSet);
            }
        }, j);
    }

    public static void a(final View view, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.common.utils.AnimationUtils.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(alphaAnimation);
    }

    public static void b(final View view, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.common.utils.AnimationUtils.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View.this.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(alphaAnimation);
    }
}
