package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/floatingactionbutton/AnimatorTracker.class */
class AnimatorTracker {
    private Animator currentAnimator;

    public void cancelCurrent() {
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void clear() {
        this.currentAnimator = null;
    }

    public void onNextAnimationStart(Animator animator) {
        cancelCurrent();
        this.currentAnimator = animator;
    }
}
