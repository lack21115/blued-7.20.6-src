package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import com.android.internal.R;
import java.util.Random;

/* loaded from: source-4181928-dex2jar.jar:android/view/animation/LayoutAnimationController.class */
public class LayoutAnimationController {
    public static final int ORDER_NORMAL = 0;
    public static final int ORDER_RANDOM = 2;
    public static final int ORDER_REVERSE = 1;
    protected Animation mAnimation;
    private float mDelay;
    private long mDuration;
    protected Interpolator mInterpolator;
    private long mMaxDelay;
    private int mOrder;
    protected Random mRandomizer;

    /* loaded from: source-4181928-dex2jar.jar:android/view/animation/LayoutAnimationController$AnimationParameters.class */
    public static class AnimationParameters {
        public int count;
        public int index;
    }

    public LayoutAnimationController(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LayoutAnimation);
        this.mDelay = Animation.Description.parseValue(obtainStyledAttributes.peekValue(1)).value;
        this.mOrder = obtainStyledAttributes.getInt(3, 0);
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId > 0) {
            setAnimation(context, resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId2 > 0) {
            setInterpolator(context, resourceId2);
        }
        obtainStyledAttributes.recycle();
    }

    public LayoutAnimationController(Animation animation) {
        this(animation, 0.5f);
    }

    public LayoutAnimationController(Animation animation, float f) {
        this.mDelay = f;
        setAnimation(animation);
    }

    public Animation getAnimation() {
        return this.mAnimation;
    }

    public final Animation getAnimationForView(View view) {
        long delayForView = getDelayForView(view) + this.mAnimation.getStartOffset();
        this.mMaxDelay = Math.max(this.mMaxDelay, delayForView);
        try {
            Animation mo1105clone = this.mAnimation.mo1105clone();
            mo1105clone.setStartOffset(delayForView);
            return mo1105clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public float getDelay() {
        return this.mDelay;
    }

    protected long getDelayForView(View view) {
        AnimationParameters animationParameters;
        if (view.getLayoutParams().layoutAnimationParameters == null) {
            return 0L;
        }
        float duration = this.mDelay * ((float) this.mAnimation.getDuration());
        long transformedIndex = getTransformedIndex(animationParameters) * duration;
        float f = duration * animationParameters.count;
        if (this.mInterpolator == null) {
            this.mInterpolator = new LinearInterpolator();
        }
        return this.mInterpolator.getInterpolation(((float) transformedIndex) / f) * f;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getOrder() {
        return this.mOrder;
    }

    protected int getTransformedIndex(AnimationParameters animationParameters) {
        switch (getOrder()) {
            case 1:
                return (animationParameters.count - 1) - animationParameters.index;
            case 2:
                if (this.mRandomizer == null) {
                    this.mRandomizer = new Random();
                }
                return (int) (animationParameters.count * this.mRandomizer.nextFloat());
            default:
                return animationParameters.index;
        }
    }

    public boolean isDone() {
        return AnimationUtils.currentAnimationTimeMillis() > (this.mAnimation.getStartTime() + this.mMaxDelay) + this.mDuration;
    }

    public void setAnimation(Context context, int i) {
        setAnimation(AnimationUtils.loadAnimation(context, i));
    }

    public void setAnimation(Animation animation) {
        this.mAnimation = animation;
        this.mAnimation.setFillBefore(true);
    }

    public void setDelay(float f) {
        this.mDelay = f;
    }

    public void setInterpolator(Context context, int i) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i));
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setOrder(int i) {
        this.mOrder = i;
    }

    public void start() {
        this.mDuration = this.mAnimation.getDuration();
        this.mMaxDelay = Long.MIN_VALUE;
        this.mAnimation.setStartTime(-1L);
    }

    public boolean willOverlap() {
        return this.mDelay < 1.0f;
    }
}
