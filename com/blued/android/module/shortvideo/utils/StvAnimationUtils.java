package com.blued.android.module.shortvideo.utils;

import android.view.animation.Animation;
import android.widget.ImageView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvAnimationUtils.class */
public class StvAnimationUtils {

    /* renamed from: com.blued.android.module.shortvideo.utils.StvAnimationUtils$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvAnimationUtils$1.class */
    class AnonymousClass1 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f15838a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f15838a.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
