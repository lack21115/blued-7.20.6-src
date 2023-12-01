package android.animation;

import android.view.animation.AnimationUtils;

/* loaded from: source-9557208-dex2jar.jar:android/animation/TimeAnimator.class */
public class TimeAnimator extends ValueAnimator {
    private TimeListener mListener;
    private long mPreviousTime = -1;

    /* loaded from: source-9557208-dex2jar.jar:android/animation/TimeAnimator$TimeListener.class */
    public interface TimeListener {
        void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.animation.ValueAnimator
    public void animateValue(float f) {
    }

    @Override // android.animation.ValueAnimator
    boolean animationFrame(long j) {
        long j2 = 0;
        if (this.mListener != null) {
            long j3 = this.mStartTime;
            if (this.mPreviousTime >= 0) {
                j2 = j - this.mPreviousTime;
            }
            this.mPreviousTime = j;
            this.mListener.onTimeUpdate(this, j - j3, j2);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.animation.ValueAnimator
    public void initAnimation() {
    }

    @Override // android.animation.ValueAnimator
    public void setCurrentPlayTime(long j) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.mStartTime = Math.max(this.mStartTime, currentAnimationTimeMillis - j);
        animationFrame(currentAnimationTimeMillis);
    }

    public void setTimeListener(TimeListener timeListener) {
        this.mListener = timeListener;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void start() {
        this.mPreviousTime = -1L;
        super.start();
    }
}
