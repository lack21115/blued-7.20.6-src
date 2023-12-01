package android.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.CanvasProperty;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.MathUtils;
import android.view.HardwareCanvas;
import android.view.RenderNodeAnimator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/Ripple.class */
public class Ripple {
    private static final float GLOBAL_SPEED = 1.0f;
    private static final long RIPPLE_ENTER_DELAY = 80;
    private static final float WAVE_OPACITY_DECAY_VELOCITY = 3.0f;
    private static final float WAVE_TOUCH_DOWN_ACCELERATION = 1024.0f;
    private static final float WAVE_TOUCH_UP_ACCELERATION = 3400.0f;
    private ObjectAnimator mAnimOpacity;
    private ObjectAnimator mAnimRadius;
    private ObjectAnimator mAnimX;
    private ObjectAnimator mAnimY;
    private final Rect mBounds;
    private boolean mCanUseHardware;
    private boolean mCanceled;
    private float mClampedStartingX;
    private float mClampedStartingY;
    private float mDensity;
    private boolean mHardwareAnimating;
    private boolean mHasMaxRadius;
    private boolean mHasPendingHardwareExit;
    private float mOuterRadius;
    private float mOuterX;
    private float mOuterY;
    private final RippleDrawable mOwner;
    private int mPendingOpacityDuration;
    private int mPendingRadiusDuration;
    private CanvasProperty<Paint> mPropPaint;
    private CanvasProperty<Float> mPropRadius;
    private CanvasProperty<Float> mPropX;
    private CanvasProperty<Float> mPropY;
    private float mStartingX;
    private float mStartingY;
    private Paint mTempPaint;
    private static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final TimeInterpolator DECEL_INTERPOLATOR = new LogInterpolator();
    private final ArrayList<RenderNodeAnimator> mRunningAnimations = new ArrayList<>();
    private float mOpacity = 1.0f;
    private float mTweenRadius = 0.0f;
    private float mTweenX = 0.0f;
    private float mTweenY = 0.0f;
    private final AnimatorListenerAdapter mAnimationListener = new AnimatorListenerAdapter() { // from class: android.graphics.drawable.Ripple.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Ripple.this.removeSelf();
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/Ripple$LogInterpolator.class */
    private static final class LogInterpolator implements TimeInterpolator {
        private LogInterpolator() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return 1.0f - ((float) Math.pow(400.0d, (-f) * 1.4d));
        }
    }

    public Ripple(RippleDrawable rippleDrawable, Rect rect, float f, float f2) {
        this.mOwner = rippleDrawable;
        this.mBounds = rect;
        this.mStartingX = f;
        this.mStartingY = f2;
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
                this.mOpacity = 0.0f;
                this.mTweenX = 1.0f;
                this.mTweenY = 1.0f;
                this.mTweenRadius = 1.0f;
            }
        }
        this.mHardwareAnimating = false;
    }

    private void cancelSoftwareAnimations() {
        if (this.mAnimRadius != null) {
            this.mAnimRadius.cancel();
            this.mAnimRadius = null;
        }
        if (this.mAnimOpacity != null) {
            this.mAnimOpacity.cancel();
            this.mAnimOpacity = null;
        }
        if (this.mAnimX != null) {
            this.mAnimX.cancel();
            this.mAnimX = null;
        }
        if (this.mAnimY != null) {
            this.mAnimY.cancel();
            this.mAnimY = null;
        }
    }

    private void clampStartingPosition() {
        float exactCenterX = this.mBounds.exactCenterX();
        float exactCenterY = this.mBounds.exactCenterY();
        float f = this.mStartingX - exactCenterX;
        float f2 = this.mStartingY - exactCenterY;
        float f3 = this.mOuterRadius;
        if ((f * f) + (f2 * f2) <= f3 * f3) {
            this.mClampedStartingX = this.mStartingX;
            this.mClampedStartingY = this.mStartingY;
            return;
        }
        double atan2 = Math.atan2(f2, f);
        this.mClampedStartingX = ((float) (Math.cos(atan2) * f3)) + exactCenterX;
        this.mClampedStartingY = ((float) (Math.sin(atan2) * f3)) + exactCenterY;
    }

    private void createPendingHardwareExit(int i, int i2) {
        this.mHasPendingHardwareExit = true;
        this.mPendingRadiusDuration = i;
        this.mPendingOpacityDuration = i2;
        invalidateSelf();
    }

    private boolean drawHardware(HardwareCanvas hardwareCanvas, Paint paint) {
        if (this.mHasPendingHardwareExit) {
            cancelHardwareAnimations(false);
            startPendingHardwareExit(hardwareCanvas, paint);
        }
        hardwareCanvas.drawCircle(this.mPropX, this.mPropY, this.mPropRadius, this.mPropPaint);
        return true;
    }

    private boolean drawSoftware(Canvas canvas, Paint paint) {
        int alpha = paint.getAlpha();
        int i = (int) ((alpha * this.mOpacity) + 0.5f);
        float lerp = MathUtils.lerp(0.0f, this.mOuterRadius, this.mTweenRadius);
        boolean z = false;
        if (i > 0) {
            z = false;
            if (lerp > 0.0f) {
                float lerp2 = MathUtils.lerp(this.mClampedStartingX - this.mBounds.exactCenterX(), this.mOuterX, this.mTweenX);
                float lerp3 = MathUtils.lerp(this.mClampedStartingY - this.mBounds.exactCenterY(), this.mOuterY, this.mTweenY);
                paint.setAlpha(i);
                canvas.drawCircle(lerp2, lerp3, lerp, paint);
                paint.setAlpha(alpha);
                z = true;
            }
        }
        return z;
    }

    private void endSoftwareAnimations() {
        if (this.mAnimRadius != null) {
            this.mAnimRadius.end();
            this.mAnimRadius = null;
        }
        if (this.mAnimOpacity != null) {
            this.mAnimOpacity.end();
            this.mAnimOpacity = null;
        }
        if (this.mAnimX != null) {
            this.mAnimX.end();
            this.mAnimX = null;
        }
        if (this.mAnimY != null) {
            this.mAnimY.end();
            this.mAnimY = null;
        }
    }

    private void exitSoftware(int i, int i2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "radiusGravity", 1.0f);
        ofFloat.setAutoCancel(true);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(DECEL_INTERPOLATOR);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "xGravity", 1.0f);
        ofFloat2.setAutoCancel(true);
        ofFloat2.setDuration(i);
        ofFloat2.setInterpolator(DECEL_INTERPOLATOR);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "yGravity", 1.0f);
        ofFloat3.setAutoCancel(true);
        ofFloat3.setDuration(i);
        ofFloat3.setInterpolator(DECEL_INTERPOLATOR);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "opacity", 0.0f);
        ofFloat4.setAutoCancel(true);
        ofFloat4.setDuration(i2);
        ofFloat4.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat4.addListener(this.mAnimationListener);
        this.mAnimRadius = ofFloat;
        this.mAnimOpacity = ofFloat4;
        this.mAnimX = ofFloat2;
        this.mAnimY = ofFloat3;
        ofFloat.start();
        ofFloat4.start();
        ofFloat2.start();
        ofFloat3.start();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSelf() {
        if (this.mCanceled) {
            return;
        }
        this.mOwner.removeRipple(this);
    }

    private void startPendingHardwareExit(HardwareCanvas hardwareCanvas, Paint paint) {
        this.mHasPendingHardwareExit = false;
        int i = this.mPendingRadiusDuration;
        int i2 = this.mPendingOpacityDuration;
        float lerp = MathUtils.lerp(this.mClampedStartingX - this.mBounds.exactCenterX(), this.mOuterX, this.mTweenX);
        float lerp2 = MathUtils.lerp(this.mClampedStartingY - this.mBounds.exactCenterY(), this.mOuterY, this.mTweenY);
        float lerp3 = MathUtils.lerp(0.0f, this.mOuterRadius, this.mTweenRadius);
        Paint tempPaint = getTempPaint(paint);
        tempPaint.setAlpha((int) ((tempPaint.getAlpha() * this.mOpacity) + 0.5f));
        this.mPropPaint = CanvasProperty.createPaint(tempPaint);
        this.mPropRadius = CanvasProperty.createFloat(lerp3);
        this.mPropX = CanvasProperty.createFloat(lerp);
        this.mPropY = CanvasProperty.createFloat(lerp2);
        RenderNodeAnimator renderNodeAnimator = new RenderNodeAnimator(this.mPropRadius, this.mOuterRadius);
        renderNodeAnimator.setDuration(i);
        renderNodeAnimator.setInterpolator(DECEL_INTERPOLATOR);
        renderNodeAnimator.setTarget((Canvas) hardwareCanvas);
        renderNodeAnimator.start();
        RenderNodeAnimator renderNodeAnimator2 = new RenderNodeAnimator(this.mPropX, this.mOuterX);
        renderNodeAnimator2.setDuration(i);
        renderNodeAnimator2.setInterpolator(DECEL_INTERPOLATOR);
        renderNodeAnimator2.setTarget((Canvas) hardwareCanvas);
        renderNodeAnimator2.start();
        RenderNodeAnimator renderNodeAnimator3 = new RenderNodeAnimator(this.mPropY, this.mOuterY);
        renderNodeAnimator3.setDuration(i);
        renderNodeAnimator3.setInterpolator(DECEL_INTERPOLATOR);
        renderNodeAnimator3.setTarget((Canvas) hardwareCanvas);
        renderNodeAnimator3.start();
        RenderNodeAnimator renderNodeAnimator4 = new RenderNodeAnimator(this.mPropPaint, 1, 0.0f);
        renderNodeAnimator4.setDuration(i2);
        renderNodeAnimator4.setInterpolator(LINEAR_INTERPOLATOR);
        renderNodeAnimator4.addListener(this.mAnimationListener);
        renderNodeAnimator4.setTarget((Canvas) hardwareCanvas);
        renderNodeAnimator4.start();
        this.mRunningAnimations.add(renderNodeAnimator);
        this.mRunningAnimations.add(renderNodeAnimator4);
        this.mRunningAnimations.add(renderNodeAnimator2);
        this.mRunningAnimations.add(renderNodeAnimator3);
        this.mHardwareAnimating = true;
        this.mOpacity = 0.0f;
        this.mTweenX = 1.0f;
        this.mTweenY = 1.0f;
        this.mTweenRadius = 1.0f;
    }

    public void cancel() {
        this.mCanceled = true;
        cancelSoftwareAnimations();
        cancelHardwareAnimations(false);
        this.mCanceled = false;
    }

    public boolean draw(Canvas canvas, Paint paint) {
        boolean isHardwareAccelerated = canvas.isHardwareAccelerated();
        if (this.mCanUseHardware != isHardwareAccelerated && this.mCanUseHardware) {
            cancelHardwareAnimations(true);
        }
        this.mCanUseHardware = isHardwareAccelerated;
        return (isHardwareAccelerated && (this.mHardwareAnimating || this.mHasPendingHardwareExit)) ? drawHardware((HardwareCanvas) canvas, paint) : drawSoftware(canvas, paint);
    }

    public void enter() {
        cancel();
        int sqrt = (int) ((1000.0d * Math.sqrt((this.mOuterRadius / WAVE_TOUCH_DOWN_ACCELERATION) * this.mDensity)) + 0.5d);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "radiusGravity", 1.0f);
        ofFloat.setAutoCancel(true);
        ofFloat.setDuration(sqrt);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat.setStartDelay(RIPPLE_ENTER_DELAY);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "xGravity", 1.0f);
        ofFloat2.setAutoCancel(true);
        ofFloat2.setDuration(sqrt);
        ofFloat2.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat2.setStartDelay(RIPPLE_ENTER_DELAY);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "yGravity", 1.0f);
        ofFloat3.setAutoCancel(true);
        ofFloat3.setDuration(sqrt);
        ofFloat3.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat3.setStartDelay(RIPPLE_ENTER_DELAY);
        this.mAnimRadius = ofFloat;
        this.mAnimX = ofFloat2;
        this.mAnimY = ofFloat3;
        ofFloat.start();
        ofFloat2.start();
        ofFloat3.start();
    }

    public void exit() {
        float lerp = (this.mAnimRadius == null || !this.mAnimRadius.isRunning()) ? this.mOuterRadius : this.mOuterRadius - MathUtils.lerp(0.0f, this.mOuterRadius, this.mTweenRadius);
        cancel();
        int sqrt = (int) ((1000.0d * Math.sqrt((lerp / 4424.0f) * this.mDensity)) + 0.5d);
        int i = (int) (((1000.0f * this.mOpacity) / 3.0f) + 0.5f);
        if (this.mCanUseHardware) {
            createPendingHardwareExit(sqrt, i);
        } else {
            exitSoftware(sqrt, i);
        }
    }

    public void getBounds(Rect rect) {
        int i = (int) this.mOuterX;
        int i2 = (int) this.mOuterY;
        int i3 = ((int) this.mOuterRadius) + 1;
        rect.set(i - i3, i2 - i3, i + i3, i2 + i3);
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public float getRadiusGravity() {
        return this.mTweenRadius;
    }

    public float getXGravity() {
        return this.mTweenX;
    }

    public float getYGravity() {
        return this.mTweenY;
    }

    public boolean isHardwareAnimating() {
        return this.mHardwareAnimating;
    }

    public void jump() {
        this.mCanceled = true;
        endSoftwareAnimations();
        cancelHardwareAnimations(true);
        this.mCanceled = false;
    }

    public void move(float f, float f2) {
        this.mStartingX = f;
        this.mStartingY = f2;
        clampStartingPosition();
    }

    public void onHotspotBoundsChanged() {
        if (this.mHasMaxRadius) {
            return;
        }
        float width = this.mBounds.width() / 2.0f;
        float height = this.mBounds.height() / 2.0f;
        this.mOuterRadius = (float) Math.sqrt((width * width) + (height * height));
        clampStartingPosition();
    }

    public void setOpacity(float f) {
        this.mOpacity = f;
        invalidateSelf();
    }

    public void setRadiusGravity(float f) {
        this.mTweenRadius = f;
        invalidateSelf();
    }

    public void setXGravity(float f) {
        this.mTweenX = f;
        invalidateSelf();
    }

    public void setYGravity(float f) {
        this.mTweenY = f;
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
        clampStartingPosition();
    }
}
