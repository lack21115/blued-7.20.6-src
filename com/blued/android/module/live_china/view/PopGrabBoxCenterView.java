package com.blued.android.module.live_china.view;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGrabBoxCenterView.class */
public class PopGrabBoxCenterView extends PopGrabBoxView {

    /* renamed from: com.blued.android.module.live_china.view.PopGrabBoxCenterView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGrabBoxCenterView$1.class */
    class AnonymousClass1 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PopGrabBoxCenterView f15037a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f15037a.c();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // com.blued.android.module.live_china.view.PopGrabBoxView
    public void a() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.f15038a.startAnimation(alphaAnimation);
        this.b.startAnimation(AnimationUtils.loadAnimation(this.f15039c, R.anim.push_center_out));
    }
}
