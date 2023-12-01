package android.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.CanvasProperty;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.MathUtils;
import android.view.HardwareCanvas;
import android.view.RenderNodeAnimator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/RippleBackground.class */
public class RippleBackground {
    private static final int ENTER_DURATION = 667;
    private static final int ENTER_DURATION_FAST = 100;
    private static final float GLOBAL_SPEED = 1.0f;
    private static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final float WAVE_OPACITY_DECAY_VELOCITY = 3.0f;
    private static final float WAVE_OUTER_OPACITY_EXIT_VELOCITY_MAX = 4.5f;
    private static final float WAVE_OUTER_OPACITY_EXIT_VELOCITY_MIN = 1.5f;
    private static final float WAVE_OUTER_SIZE_INFLUENCE_MAX = 200.0f;
    private static final float WAVE_OUTER_SIZE_INFLUENCE_MIN = 40.0f;
    private ObjectAnimator mAnimOuterOpacity;
    private final Rect mBounds;
    private boolean mCanUseHardware;
    private int mColor;
    private float mDensity;
    private boolean mHardwareAnimating;
    private boolean mHasMaxRadius;
    private boolean mHasPendingHardwareExit;
    private float mOuterRadius;
    private float mOuterX;
    private float mOuterY;
    private final RippleDrawable mOwner;
    private int mPendingInflectionDuration;
    private int mPendingInflectionOpacity;
    private int mPendingOpacityDuration;
    private CanvasProperty<Paint> mPropOuterPaint;
    private CanvasProperty<Float> mPropOuterRadius;
    private CanvasProperty<Float> mPropOuterX;
    private CanvasProperty<Float> mPropOuterY;
    private Paint mTempPaint;
    private final ArrayList<RenderNodeAnimator> mRunningAnimations = new ArrayList<>();
    private float mOuterOpacity = 0.0f;
    private final AnimatorListenerAdapter mAnimationListener = new AnimatorListenerAdapter() { // from class: android.graphics.drawable.RippleBackground.2
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RippleBackground.this.mHardwareAnimating = false;
        }
    };

    public RippleBackground(RippleDrawable rippleDrawable, Rect rect) {
        this.mOwner = rippleDrawable;
        this.mBounds = rect;
    }

    private void cancelHardwareAnimations(boolean z) {
        ArrayList<RenderNodeAnimator> arrayList = this.mRunningAnimations;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            if (z) {
                arrayList.get(i2).end();
            } else {
                arrayList.get(i2).cancel();
            }
            i = i2 + 1;
        }
        arrayList.clear();
        if (this.mHasPendingHardwareExit) {
            this.mHasPendingHardwareExit = false;
            if (z) {
                this.mOuterOpacity = 0.0f;
            }
        }
        this.mHardwareAnimating = false;
    }

    private void cancelSoftwareAnimations() {
        if (this.mAnimOuterOpacity != null) {
            this.mAnimOuterOpacity.cancel();
            this.mAnimOuterOpacity = null;
        }
    }

    private void createPendingHardwareExit(int i, int i2, int i3) {
        this.mHasPendingHardwareExit = true;
        this.mPendingOpacityDuration = i;
        this.mPendingInflectionDuration = i2;
        this.mPendingInflectionOpacity = i3;
        invalidateSelf();
    }

    private boolean drawHardware(HardwareCanvas hardwareCanvas, Paint paint) {
        if (this.mHasPendingHardwareExit) {
            cancelHardwareAnimations(false);
            startPendingHardwareExit(hardwareCanvas, paint);
        }
        hardwareCanvas.drawCircle(this.mPropOuterX, this.mPropOuterY, this.mPropOuterRadius, this.mPropOuterPaint);
        return true;
    }

    private boolean drawSoftware(Canvas canvas, Paint paint) {
        int alpha = paint.getAlpha();
        int i = (int) ((alpha * this.mOuterOpacity) + 0.5f);
        float f = this.mOuterRadius;
        boolean z = false;
        if (i > 0) {
            z = false;
            if (f > 0.0f) {
                paint.setAlpha(i);
                canvas.drawCircle(this.mOuterX, this.mOuterY, f, paint);
                paint.setAlpha(alpha);
                z = true;
            }
        }
        return z;
    }

    private void endSoftwareAnimations() {
        if (this.mAnimOuterOpacity != null) {
            this.mAnimOuterOpacity.end();
            this.mAnimOuterOpacity = null;
        }
    }

    private void exitSoftware(int i, int i2, int i3) {
        ObjectAnimator ofFloat;
        if (i2 > 0) {
            ofFloat = ObjectAnimator.ofFloat(this, "outerOpacity", i3 / 255.0f);
            ofFloat.setAutoCancel(true);
            ofFloat.setDuration(i2);
            ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
            final int i4 = i - i2;
            if (i4 > 0) {
                ofFloat.addListener(new AnimatorListenerAdapter() { // from class: android.graphics.drawable.RippleBackground.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        animator.removeListener(this);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(RippleBackground.this, "outerOpacity", 0.0f);
                        ofFloat2.setAutoCancel(true);
                        ofFloat2.setDuration(i4);
                        ofFloat2.setInterpolator(RippleBackground.LINEAR_INTERPOLATOR);
                        ofFloat2.addListener(RippleBackground.this.mAnimationListener);
                        RippleBackground.this.mAnimOuterOpacity = ofFloat2;
                        ofFloat2.start();
                    }
                });
            } else {
                ofFloat.addListener(this.mAnimationListener);
            }
        } else {
            ofFloat = ObjectAnimator.ofFloat(this, "outerOpacity", 0.0f);
            ofFloat.setAutoCancel(true);
            ofFloat.setDuration(i);
            ofFloat.addListener(this.mAnimationListener);
        }
        this.mAnimOuterOpacity = ofFloat;
        ofFloat.start();
    }

    private Paint getTempPaint(Paint paint) {
        if (this.mTempPaint == null) {
            this.mTempPaint = new Paint();
        }
        this.mTempPaint.set(paint);
        return this.mTempPaint;
    }

    private void invalidateSelf() {
        this.mOwner.invalidateSelf();
    }

    private void startPendingHardwareExit(HardwareCanvas hardwareCanvas, Paint paint) {
        RenderNodeAnimator renderNodeAnimator;
        this.mHasPendingHardwareExit = false;
        int i = this.mPendingOpacityDuration;
        int i2 = this.mPendingInflectionDuration;
        int i3 = this.mPendingInflectionOpacity;
        Paint tempPaint = getTempPaint(paint);
        tempPaint.setAlpha((int) ((tempPaint.getAlpha() * this.mOuterOpacity) + 0.5f));
        this.mPropOuterPaint = CanvasProperty.createPaint(tempPaint);
        this.mPropOuterRadius = CanvasProperty.createFloat(this.mOuterRadius);
        this.mPropOuterX = CanvasProperty.createFloat(this.mOuterX);
        this.mPropOuterY = CanvasProperty.createFloat(this.mOuterY);
        if (i2 > 0) {
            renderNodeAnimator = new RenderNodeAnimator(this.mPropOuterPaint, 1, i3);
            renderNodeAnimator.setDuration(i2);
            renderNodeAnimator.setInterpolator(LINEAR_INTERPOLATOR);
            int i4 = i - i2;
            if (i4 > 0) {
                RenderNodeAnimator renderNodeAnimator2 = new RenderNodeAnimator(this.mPropOuterPaint, 1, 0.0f);
                renderNodeAnimator2.setDuration(i4);
                renderNodeAnimator2.setInterpolator(LINEAR_INTERPOLATOR);
                renderNodeAnimator2.setStartDelay(i2);
                renderNodeAnimator2.setStartValue(i3);
                renderNodeAnimator2.addListener(this.mAnimationListener);
                renderNodeAnimator2.setTarget((Canvas) hardwareCanvas);
                renderNodeAnimator2.start();
                this.mRunningAnimations.add(renderNodeAnimator2);
            } else {
                renderNodeAnimator.addListener(this.mAnimationListener);
            }
        } else {
            renderNodeAnimator = new RenderNodeAnimator(this.mPropOuterPaint, 1, 0.0f);
            renderNodeAnimator.setInterpolator(LINEAR_INTERPOLATOR);
            renderNodeAnimator.setDuration(i);
            renderNodeAnimator.addListener(this.mAnimationListener);
        }
        renderNodeAnimator.setTarget((Canvas) hardwareCanvas);
        renderNodeAnimator.start();
        this.mRunningAnimations.add(renderNodeAnimator);
        this.mHardwareAnimating = true;
        this.mOuterOpacity = 0.0f;
    }

    public void cancel() {
        cancelSoftwareAnimations();
        cancelHardwareAnimations(false);
    }

    public boolean draw(Canvas canvas, Paint paint) {
        this.mColor = paint.getColor();
        boolean isHardwareAccelerated = canvas.isHardwareAccelerated();
        if (this.mCanUseHardware != isHardwareAccelerated && this.mCanUseHardware) {
            cancelHardwareAnimations(true);
        }
        this.mCanUseHardware = isHardwareAccelerated;
        return (isHardwareAccelerated && (this.mHardwareAnimating || this.mHasPendingHardwareExit)) ? drawHardware((HardwareCanvas) canvas, paint) : drawSoftware(canvas, paint);
    }

    public void enter(boolean z) {
        cancel();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "outerOpacity", 0.0f, 1.0f);
        ofFloat.setAutoCancel(true);
        ofFloat.setDuration(z ? 100L : 667L);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        this.mAnimOuterOpacity = ofFloat;
        ofFloat.start();
    }

    public void exit() {
        cancel();
        float constrain = MathUtils.constrain((this.mOuterRadius - (40.0f * this.mDensity)) / (200.0f * this.mDensity), 0.0f, 1.0f);
        float lerp = MathUtils.lerp(WAVE_OUTER_OPACITY_EXIT_VELOCITY_MIN, WAVE_OUTER_OPACITY_EXIT_VELOCITY_MAX, constrain);
        int max = Math.max(0, (int) ((((1.0f - this.mOuterOpacity) * 1000.0f) / (3.0f + lerp)) + 0.5f));
        int alpha = (int) ((Color.alpha(this.mColor) * (this.mOuterOpacity + (((max * lerp) * constrain) / 1000.0f))) + 0.5f);
        if (this.mCanUseHardware) {
            createPendingHardwareExit(333, max, alpha);
        } else {
            exitSoftware(333, max, alpha);
        }
    }

    public void getBounds(Rect rect) {
        int i = (int) this.mOuterX;
        int i2 = (int) this.mOuterY;
        int i3 = ((int) this.mOuterRadius) + 1;
        rect.set(i - i3, i2 - i3, i + i3, i2 + i3);
    }

    public float getOuterOpacity() {
        return this.mOuterOpacity;
    }

    public void jump() {
        endSoftwareAnimations();
        cancelHardwareAnimations(true);
    }

    public void onHotspotBoundsChanged() {
        if (this.mHasMaxRadius) {
            return;
        }
        float width = this.mBounds.width() / 2.0f;
        float height = this.mBounds.height() / 2.0f;
        this.mOuterRadius = (float) Math.sqrt((width * width) + (height * height));
    }

    public void setOuterOpacity(float f) {
        this.mOuterOpacity = f;
        invalidateSelf();
    }

    public void setup(int i, float f) {
        if (i != -1) {
            this.mHasMaxRadius = true;
            this.mOuterRadius = i;
        } else {
            float width = this.mBounds.width() / 2.0f;
            float height = this.mBounds.height() / 2.0f;
            this.mOuterRadius = (float) Math.sqrt((width * width) + (height * height));
        }
        this.mOuterX = 0.0f;
        this.mOuterY = 0.0f;
        this.mDensity = f;
    }

    public boolean shouldDraw() {
        if (this.mCanUseHardware && this.mHardwareAnimating) {
            return true;
        }
        return this.mOuterOpacity > 0.0f && this.mOuterRadius > 0.0f;
    }
}
