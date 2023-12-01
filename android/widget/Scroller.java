package android.widget;

import android.content.Context;
import android.os.PowerManager;
import android.util.FloatMath;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.android.internal.util.cm.PowerMenuConstants;

/* loaded from: source-4181928-dex2jar.jar:android/widget/Scroller.class */
public class Scroller {
    private static final int DEFAULT_DURATION = 250;
    private static final float END_TENSION = 1.0f;
    private static final int FLING_MODE = 1;
    private static final float INFLEXION = 0.35f;
    private static final int NB_SAMPLES = 100;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final int SCROLL_MODE = 0;
    private static final float START_TENSION = 0.5f;
    private float mCurrVelocity;
    private int mCurrX;
    private int mCurrY;
    private float mDeceleration;
    private float mDeltaX;
    private float mDeltaY;
    private int mDistance;
    private int mDuration;
    private float mDurationReciprocal;
    private int mFinalX;
    private int mFinalY;
    private boolean mFinished;
    private float mFlingFriction;
    private boolean mFlywheel;
    private final Interpolator mInterpolator;
    private int mMaxX;
    private int mMaxY;
    private int mMinX;
    private int mMinY;
    private int mMode;
    private float mPhysicalCoeff;
    private final PowerManager mPm;
    private final float mPpi;
    private long mStartTime;
    private int mStartX;
    private int mStartY;
    private float mVelocity;
    private static float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final float[] SPLINE_POSITION = new float[101];
    private static final float[] SPLINE_TIME = new float[101];

    /* loaded from: source-4181928-dex2jar.jar:android/widget/Scroller$ViscousFluidInterpolator.class */
    static class ViscousFluidInterpolator implements Interpolator {
        private static final float VISCOUS_FLUID_NORMALIZE = 1.0f / viscousFluid(1.0f);
        private static final float VISCOUS_FLUID_OFFSET = 1.0f - (VISCOUS_FLUID_NORMALIZE * viscousFluid(1.0f));
        private static final float VISCOUS_FLUID_SCALE = 8.0f;

        private static float viscousFluid(float f) {
            float f2 = f * VISCOUS_FLUID_SCALE;
            return f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp(-f2))) : 0.36787945f + ((1.0f - 0.36787945f) * (1.0f - ((float) Math.exp(1.0f - f2))));
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float viscousFluid = VISCOUS_FLUID_NORMALIZE * viscousFluid(f);
            float f2 = viscousFluid;
            if (viscousFluid > 0.0f) {
                f2 = viscousFluid + VISCOUS_FLUID_OFFSET;
            }
            return f2;
        }
    }

    static {
        float f;
        float f2;
        float f3;
        float f4;
        float f5 = 0.0f;
        float f6 = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                float[] fArr = SPLINE_POSITION;
                SPLINE_TIME[100] = 1.0f;
                fArr[100] = 1.0f;
                return;
            }
            float f7 = i2 / 100.0f;
            float f8 = 1.0f;
            while (true) {
                f = f5 + ((f8 - f5) / 2.0f);
                f2 = 3.0f * f * (1.0f - f);
                float f9 = ((((1.0f - f) * P1) + (P2 * f)) * f2) + (f * f * f);
                if (Math.abs(f9 - f7) < 1.0E-5d) {
                    break;
                } else if (f9 > f7) {
                    f8 = f;
                } else {
                    f5 = f;
                }
            }
            SPLINE_POSITION[i2] = ((((1.0f - f) * START_TENSION) + f) * f2) + (f * f * f);
            float f10 = 1.0f;
            while (true) {
                f3 = f6 + ((f10 - f6) / 2.0f);
                f4 = 3.0f * f3 * (1.0f - f3);
                float f11 = ((((1.0f - f3) * START_TENSION) + f3) * f4) + (f3 * f3 * f3);
                if (Math.abs(f11 - f7) < 1.0E-5d) {
                    break;
                } else if (f11 > f7) {
                    f10 = f3;
                } else {
                    f6 = f3;
                }
            }
            SPLINE_TIME[i2] = ((((1.0f - f3) * P1) + (P2 * f3)) * f4) + (f3 * f3 * f3);
            i = i2 + 1;
        }
    }

    public Scroller(Context context) {
        this(context, null);
    }

    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public Scroller(Context context, Interpolator interpolator, boolean z) {
        this.mFlingFriction = ViewConfiguration.getScrollFriction();
        this.mFinished = true;
        if (interpolator == null) {
            this.mInterpolator = new ViscousFluidInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
        this.mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        this.mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        this.mFlywheel = z;
        this.mPhysicalCoeff = computeDeceleration(0.84f);
        this.mPm = (PowerManager) context.getSystemService(PowerMenuConstants.GLOBAL_ACTION_KEY_POWER);
    }

    private float computeDeceleration(float f) {
        return 386.0878f * this.mPpi * f;
    }

    private double getSplineDeceleration(float f) {
        return Math.log((INFLEXION * Math.abs(f)) / (this.mFlingFriction * this.mPhysicalCoeff));
    }

    private double getSplineFlingDistance(float f) {
        return this.mFlingFriction * this.mPhysicalCoeff * Math.exp((DECELERATION_RATE / (DECELERATION_RATE - 1.0d)) * getSplineDeceleration(f));
    }

    private int getSplineFlingDuration(float f) {
        return (int) (1000.0d * Math.exp(getSplineDeceleration(f) / (DECELERATION_RATE - 1.0d)));
    }

    public void abortAnimation() {
        this.mCurrX = this.mFinalX;
        this.mCurrY = this.mFinalY;
        this.mFinished = true;
    }

    public boolean computeScrollOffset() {
        if (this.mFinished) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
        if (currentAnimationTimeMillis >= this.mDuration) {
            this.mCurrX = this.mFinalX;
            this.mCurrY = this.mFinalY;
            this.mFinished = true;
            return true;
        }
        switch (this.mMode) {
            case 0:
                float interpolation = this.mInterpolator.getInterpolation(currentAnimationTimeMillis * this.mDurationReciprocal);
                this.mCurrX = this.mStartX + Math.round(this.mDeltaX * interpolation);
                this.mCurrY = this.mStartY + Math.round(this.mDeltaY * interpolation);
                return true;
            case 1:
                float f = currentAnimationTimeMillis / this.mDuration;
                int i = (int) (100.0f * f);
                float f2 = 1.0f;
                float f3 = 0.0f;
                if (i < 100) {
                    float f4 = i / 100.0f;
                    float f5 = (i + 1) / 100.0f;
                    float f6 = SPLINE_POSITION[i];
                    f3 = (SPLINE_POSITION[i + 1] - f6) / (f5 - f4);
                    f2 = f6 + ((f - f4) * f3);
                }
                this.mCurrVelocity = ((this.mDistance * f3) / this.mDuration) * 1000.0f;
                this.mCurrX = this.mStartX + Math.round((this.mFinalX - this.mStartX) * f2);
                this.mCurrX = Math.min(this.mCurrX, this.mMaxX);
                this.mCurrX = Math.max(this.mCurrX, this.mMinX);
                this.mCurrY = this.mStartY + Math.round((this.mFinalY - this.mStartY) * f2);
                this.mCurrY = Math.min(this.mCurrY, this.mMaxY);
                this.mCurrY = Math.max(this.mCurrY, this.mMinY);
                if (this.mCurrX == this.mFinalX && this.mCurrY == this.mFinalY) {
                    this.mFinished = true;
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

    public void extendDuration(int i) {
        this.mDuration = timePassed() + i;
        this.mDurationReciprocal = 1.0f / this.mDuration;
        this.mFinished = false;
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i3;
        int i10 = i4;
        if (this.mFlywheel) {
            i9 = i3;
            i10 = i4;
            if (!this.mFinished) {
                float currVelocity = getCurrVelocity();
                float f = this.mFinalX - this.mStartX;
                float f2 = this.mFinalY - this.mStartY;
                float sqrt = FloatMath.sqrt((f * f) + (f2 * f2));
                float f3 = f / sqrt;
                float f4 = f2 / sqrt;
                float f5 = f3 * currVelocity;
                float f6 = f4 * currVelocity;
                i9 = i3;
                i10 = i4;
                if (Math.signum(i3) == Math.signum(f5)) {
                    i9 = i3;
                    i10 = i4;
                    if (Math.signum(i4) == Math.signum(f6)) {
                        i9 = (int) (i3 + f5);
                        i10 = (int) (i4 + f6);
                    }
                }
            }
        }
        this.mMode = 1;
        this.mFinished = false;
        float sqrt2 = FloatMath.sqrt((i9 * i9) + (i10 * i10));
        this.mVelocity = sqrt2;
        this.mDuration = getSplineFlingDuration(sqrt2);
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = i;
        this.mStartY = i2;
        float f7 = sqrt2 == 0.0f ? 1.0f : i9 / sqrt2;
        float f8 = sqrt2 == 0.0f ? 1.0f : i10 / sqrt2;
        double splineFlingDistance = getSplineFlingDistance(sqrt2);
        this.mDistance = (int) (Math.signum(sqrt2) * splineFlingDistance);
        this.mMinX = i5;
        this.mMaxX = i6;
        this.mMinY = i7;
        this.mMaxY = i8;
        this.mFinalX = ((int) Math.round(f7 * splineFlingDistance)) + i;
        this.mFinalX = Math.min(this.mFinalX, this.mMaxX);
        this.mFinalX = Math.max(this.mFinalX, this.mMinX);
        this.mFinalY = ((int) Math.round(f8 * splineFlingDistance)) + i2;
        this.mFinalY = Math.min(this.mFinalY, this.mMaxY);
        this.mFinalY = Math.max(this.mFinalY, this.mMinY);
    }

    public final void forceFinished(boolean z) {
        this.mFinished = z;
    }

    public float getCurrVelocity() {
        return this.mMode == 1 ? this.mCurrVelocity : this.mVelocity - ((this.mDeceleration * timePassed()) / 2000.0f);
    }

    public final int getCurrX() {
        return this.mCurrX;
    }

    public final int getCurrY() {
        return this.mCurrY;
    }

    public final int getDuration() {
        return this.mDuration;
    }

    public final int getFinalX() {
        return this.mFinalX;
    }

    public final int getFinalY() {
        return this.mFinalY;
    }

    public final int getStartX() {
        return this.mStartX;
    }

    public final int getStartY() {
        return this.mStartY;
    }

    public final boolean isFinished() {
        return this.mFinished;
    }

    public boolean isScrollingInDirection(float f, float f2) {
        return !this.mFinished && Math.signum(f) == Math.signum((float) (this.mFinalX - this.mStartX)) && Math.signum(f2) == Math.signum((float) (this.mFinalY - this.mStartY));
    }

    public void setFinalX(int i) {
        this.mFinalX = i;
        this.mDeltaX = this.mFinalX - this.mStartX;
        this.mFinished = false;
    }

    public void setFinalY(int i) {
        this.mFinalY = i;
        this.mDeltaY = this.mFinalY - this.mStartY;
        this.mFinished = false;
    }

    public final void setFriction(float f) {
        this.mDeceleration = computeDeceleration(f);
        this.mFlingFriction = f;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        startScroll(i, i2, i3, i4, 250);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.mFinished = false;
        this.mDuration = i5;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = i;
        this.mStartY = i2;
        this.mFinalX = i + i3;
        this.mFinalY = i2 + i4;
        this.mDeltaX = i3;
        this.mDeltaY = i4;
        this.mDurationReciprocal = 1.0f / this.mDuration;
        this.mPm.cpuBoost(i5 * 1000);
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    }
}
