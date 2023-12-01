package com.tencent.tencentmap.mapsdk.maps.model.transform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/transform/OverlayAnimator.class */
public abstract class OverlayAnimator {
    private Animator.AnimatorListener mAnimatorListener;
    private AnimatorSet mAnimatorSet = new AnimatorSet();
    private long mDuration;
    private Object mObject;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/transform/OverlayAnimator$a.class */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            OverlayAnimator.this.innerAnimationEnd();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public OverlayAnimator(Object obj, long j) {
        this.mObject = obj;
        this.mDuration = j;
    }

    public void addAnimationListener() {
        if (this.mAnimatorSet == null) {
            return;
        }
        if (this.mAnimatorListener == null) {
            this.mAnimatorListener = new a();
        }
        this.mAnimatorSet.addListener(this.mAnimatorListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mAnimatorSet.addListener(animatorListener);
    }

    public void cancelAnimation() {
        synchronized (this) {
            this.mAnimatorSet.cancel();
        }
    }

    public abstract ValueAnimator createSegmentAnimator(int i);

    public void endAnimation() {
        synchronized (this) {
            this.mAnimatorSet.end();
        }
    }

    public AnimatorSet getAnimatorSet() {
        return this.mAnimatorSet;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Object getObject() {
        return this.mObject;
    }

    public void innerAnimationEnd() {
    }

    public void removeAnimationListener() {
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet == null) {
            return;
        }
        animatorSet.removeListener(this.mAnimatorListener);
        this.mAnimatorListener = null;
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.mAnimatorSet = animatorSet;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setObject(Object obj) {
        this.mObject = obj;
    }

    public void startAnimation() {
        synchronized (this) {
            if (!this.mAnimatorSet.isRunning()) {
                this.mAnimatorSet.start();
            }
        }
    }
}
