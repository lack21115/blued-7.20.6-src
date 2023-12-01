package com.blued.android.module.live_china.view;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveFrameLayoutExKt.class */
public final class LiveFrameLayoutExKt {
    public static final FrameLayout a(FrameLayout frameLayout, Function1<? super FrameLayout, Unit> block) {
        Intrinsics.e(frameLayout, "<this>");
        Intrinsics.e(block, "block");
        frameLayout.removeAllViews();
        block.invoke(frameLayout);
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.85f, 1.0f, 0.85f, 1.0f, 1, 0.5f, 1, 0.5f);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveFrameLayoutExKt$toAddView$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        animationSet.setDuration(450L);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(1);
        animationSet.setInterpolator(new OvershootInterpolator());
        frameLayout.clearAnimation();
        frameLayout.startAnimation(animationSet);
        return frameLayout;
    }
}
