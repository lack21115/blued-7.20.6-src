package com.android.internal.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/DrawableHolder.class */
public class DrawableHolder implements Animator.AnimatorListener {
    private static final boolean DBG = false;
    public static final DecelerateInterpolator EASE_OUT_INTERPOLATOR = new DecelerateInterpolator();
    private static final String TAG = "DrawableHolder";
    private float mAlpha;
    private ArrayList<ObjectAnimator> mAnimators;
    private BitmapDrawable mDrawable;
    private ArrayList<ObjectAnimator> mNeedToStart;
    private float mScaleX;
    private float mScaleY;
    private float mX;
    private float mY;

    public DrawableHolder(BitmapDrawable bitmapDrawable) {
        this(bitmapDrawable, 0.0f, 0.0f);
    }

    public DrawableHolder(BitmapDrawable bitmapDrawable, float f, float f2) {
        this.mX = 0.0f;
        this.mY = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mAlpha = 1.0f;
        this.mAnimators = new ArrayList<>();
        this.mNeedToStart = new ArrayList<>();
        this.mDrawable = bitmapDrawable;
        this.mX = f;
        this.mY = f2;
        this.mDrawable.getPaint().setAntiAlias(true);
        this.mDrawable.setBounds(0, 0, this.mDrawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
    }

    private DrawableHolder addAnimation(ObjectAnimator objectAnimator, boolean z) {
        if (objectAnimator != null) {
            this.mAnimators.add(objectAnimator);
        }
        this.mNeedToStart.add(objectAnimator);
        return this;
    }

    public ObjectAnimator addAnimTo(long j, long j2, String str, float f, boolean z) {
        if (z) {
            removeAnimationFor(str);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, str, f);
        ofFloat.setDuration(j);
        ofFloat.setStartDelay(j2);
        ofFloat.setInterpolator(EASE_OUT_INTERPOLATOR);
        addAnimation(ofFloat, z);
        return ofFloat;
    }

    public void clearAnimations() {
        Iterator<ObjectAnimator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.mAnimators.clear();
    }

    public void draw(Canvas canvas) {
        if (this.mAlpha <= 0.00390625f) {
            return;
        }
        canvas.save(1);
        canvas.translate(this.mX, this.mY);
        canvas.scale(this.mScaleX, this.mScaleY);
        canvas.translate(getWidth() * (-0.5f), getHeight() * (-0.5f));
        this.mDrawable.setAlpha(Math.round(this.mAlpha * 255.0f));
        this.mDrawable.draw(canvas);
        canvas.restore();
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public BitmapDrawable getDrawable() {
        return this.mDrawable;
    }

    public int getHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public int getWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public float getX() {
        return this.mX;
    }

    public float getY() {
        return this.mY;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.mAnimators.remove(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    public void removeAnimationFor(String str) {
        Iterator it = ((ArrayList) this.mAnimators.clone()).iterator();
        while (it.hasNext()) {
            ObjectAnimator objectAnimator = (ObjectAnimator) it.next();
            if (str.equals(objectAnimator.getPropertyName())) {
                objectAnimator.cancel();
            }
        }
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    public void setScaleX(float f) {
        this.mScaleX = f;
    }

    public void setScaleY(float f) {
        this.mScaleY = f;
    }

    public void setX(float f) {
        this.mX = f;
    }

    public void setY(float f) {
        this.mY = f;
    }

    public void startAnimations(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mNeedToStart.size()) {
                this.mNeedToStart.clear();
                return;
            }
            ObjectAnimator objectAnimator = this.mNeedToStart.get(i2);
            objectAnimator.addUpdateListener(animatorUpdateListener);
            objectAnimator.addListener(this);
            objectAnimator.start();
            i = i2 + 1;
        }
    }
}
