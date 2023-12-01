package android.widget;

import android.content.Context;
import android.os.PowerManager;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.android.internal.util.cm.PowerMenuConstants;

/* loaded from: source-4181928-dex2jar.jar:android/widget/OverScroller.class */
public class OverScroller {
    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    private static final int SCROLL_MODE = 0;
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMode;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/OverScroller$SplineOverScroller.class */
    public static class SplineOverScroller {
        private static final int BALLISTIC = 2;
        private static final int CUBIC = 1;
        private static final float END_TENSION = 1.0f;
        private static final float GRAVITY = 2000.0f;
        private static final float INFLEXION = 0.35f;
        private static final int NB_SAMPLES = 100;
        private static final float P1 = 0.175f;
        private static final float P2 = 0.35000002f;
        private static final int SPLINE = 0;
        private static final float START_TENSION = 0.5f;
        private float mCurrVelocity;
        private int mCurrentPosition;
        private float mDeceleration;
        private int mDuration;
        private int mFinal;
        private int mOver;
        private float mPhysicalCoeff;
        private final PowerManager mPm;
        private int mSplineDistance;
        private int mSplineDuration;
        private int mStart;
        private long mStartTime;
        private int mVelocity;
        private static float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] SPLINE_POSITION = new float[101];
        private static final float[] SPLINE_TIME = new float[101];
        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean mFinished = true;

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

        SplineOverScroller(Context context) {
            this.mPhysicalCoeff = 386.0878f * context.getResources().getDisplayMetrics().density * 160.0f * 0.84f;
            this.mPm = (PowerManager) context.getSystemService(PowerMenuConstants.GLOBAL_ACTION_KEY_POWER);
        }

        private void adjustDuration(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = (i4 + 1) / 100.0f;
                float f3 = SPLINE_TIME[i4];
                float f4 = SPLINE_TIME[i4 + 1];
                this.mDuration = (int) (this.mDuration * (f3 + (((abs - f) / (f2 - f)) * (f4 - f3))));
            }
        }

        private void fitOnBounceCurve(int i, int i2, int i3) {
            float f = (-i3) / this.mDeceleration;
            float sqrt = (float) Math.sqrt((2.0d * ((((i3 * i3) / 2.0f) / Math.abs(this.mDeceleration)) + Math.abs(i2 - i))) / Math.abs(this.mDeceleration));
            this.mStartTime -= (int) (1000.0f * (sqrt - f));
            this.mStart = i2;
            this.mVelocity = (int) ((-this.mDeceleration) * sqrt);
        }

        private static float getDeceleration(int i) {
            if (i > 0) {
                return -2000.0f;
            }
            return GRAVITY;
        }

        private double getSplineDeceleration(int i) {
            return Math.log((INFLEXION * Math.abs(i)) / (this.mFlingFriction * this.mPhysicalCoeff));
        }

        private double getSplineFlingDistance(int i) {
            return this.mFlingFriction * this.mPhysicalCoeff * Math.exp((DECELERATION_RATE / (DECELERATION_RATE - 1.0d)) * getSplineDeceleration(i));
        }

        private int getSplineFlingDuration(int i) {
            return (int) (1000.0d * Math.exp(getSplineDeceleration(i) / (DECELERATION_RATE - 1.0d)));
        }

        private void onEdgeReached() {
            float f = this.mVelocity * this.mVelocity;
            float abs = f / (Math.abs(this.mDeceleration) * 2.0f);
            float signum = Math.signum(this.mVelocity);
            float f2 = abs;
            if (abs > this.mOver) {
                this.mDeceleration = ((-signum) * f) / (this.mOver * 2.0f);
                f2 = this.mOver;
            }
            this.mOver = (int) f2;
            this.mState = 2;
            int i = this.mStart;
            if (this.mVelocity <= 0) {
                f2 = -f2;
            }
            this.mFinal = i + ((int) f2);
            this.mDuration = -((int) ((1000.0f * this.mVelocity) / this.mDeceleration));
        }

        private void startAfterEdge(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                startBounceAfterEdge(i, i5, i4);
            } else if (getSplineFlingDistance(i4) <= Math.abs(i6)) {
                startSpringback(i, i5, i4);
            } else {
                if (!z) {
                    i2 = i;
                }
                if (z) {
                    i3 = i;
                }
                fling(i, i4, i2, i3, this.mOver);
            }
        }

        private void startBounceAfterEdge(int i, int i2, int i3) {
            this.mDeceleration = getDeceleration(i3 == 0 ? i - i2 : i3);
            fitOnBounceCurve(i, i2, i3);
            onEdgeReached();
        }

        private void startSpringback(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.mCurrentPosition = i;
            this.mFinal = i2;
            int i4 = i - i2;
            this.mDeceleration = getDeceleration(i4);
            this.mVelocity = -i4;
            this.mOver = Math.abs(i4);
            this.mDuration = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.mDeceleration));
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        boolean continueWhenFinished() {
            boolean z = false;
            switch (this.mState) {
                case 0:
                    z = false;
                    if (this.mDuration < this.mSplineDuration) {
                        this.mStart = this.mFinal;
                        this.mVelocity = (int) this.mCurrVelocity;
                        this.mDeceleration = getDeceleration(this.mVelocity);
                        this.mStartTime += this.mDuration;
                        onEdgeReached();
                        update();
                        z = true;
                        break;
                    }
                    break;
                case 1:
                    break;
                case 2:
                    this.mStartTime += this.mDuration;
                    startSpringback(this.mFinal, this.mStart, 0);
                    update();
                    z = true;
                    break;
                default:
                    update();
                    z = true;
                    break;
            }
            return z;
        }

        void extendDuration(int i) {
            this.mDuration = ((int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) + i;
            this.mFinished = false;
        }

        void finish() {
            this.mCurrentPosition = this.mFinal;
            this.mFinished = true;
        }

        void fling(int i, int i2, int i3, int i4, int i5) {
            this.mOver = i5;
            this.mFinished = false;
            this.mVelocity = i2;
            this.mCurrVelocity = i2;
            this.mSplineDuration = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                startAfterEdge(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int splineFlingDuration = getSplineFlingDuration(i2);
                this.mSplineDuration = splineFlingDuration;
                this.mDuration = splineFlingDuration;
                d = getSplineFlingDistance(i2);
                this.mPm.cpuBoost(this.mDuration * 1000);
            }
            this.mSplineDistance = (int) (Math.signum(i2) * d);
            this.mFinal = this.mSplineDistance + i;
            if (this.mFinal < i3) {
                adjustDuration(this.mStart, this.mFinal, i3);
                this.mFinal = i3;
            }
            if (this.mFinal > i4) {
                adjustDuration(this.mStart, this.mFinal, i4);
                this.mFinal = i4;
            }
        }

        void notifyEdgeReached(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.mOver = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(i, i2, i2, (int) this.mCurrVelocity);
            }
        }

        void setFinalPosition(int i) {
            this.mFinal = i;
            this.mFinished = false;
        }

        void setFriction(float f) {
            this.mFlingFriction = f;
        }

        boolean springback(int i, int i2, int i3) {
            this.mFinished = true;
            this.mFinal = i;
            this.mStart = i;
            this.mVelocity = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                startSpringback(i, i2, 0);
            } else if (i > i3) {
                startSpringback(i, i3, 0);
            }
            return !this.mFinished;
        }

        void startScroll(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.mFinal = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.mDeceleration = 0.0f;
            this.mVelocity = 0;
        }

        boolean update() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis == 0) {
                return this.mDuration > 0;
            } else if (currentAnimationTimeMillis > this.mDuration) {
                return false;
            } else {
                double d = 0.0d;
                switch (this.mState) {
                    case 0:
                        float f = ((float) currentAnimationTimeMillis) / this.mSplineDuration;
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
                        d = this.mSplineDistance * f2;
                        this.mCurrVelocity = ((this.mSplineDistance * f3) / this.mSplineDuration) * 1000.0f;
                        break;
                    case 1:
                        float f7 = ((float) currentAnimationTimeMillis) / this.mDuration;
                        float f8 = f7 * f7;
                        float signum = Math.signum(this.mVelocity);
                        d = this.mOver * signum * ((3.0f * f8) - ((2.0f * f7) * f8));
                        this.mCurrVelocity = this.mOver * signum * 6.0f * ((-f7) + f8);
                        break;
                    case 2:
                        float f9 = ((float) currentAnimationTimeMillis) / 1000.0f;
                        this.mCurrVelocity = this.mVelocity + (this.mDeceleration * f9);
                        d = (this.mVelocity * f9) + (((this.mDeceleration * f9) * f9) / 2.0f);
                        break;
                }
                this.mCurrentPosition = this.mStart + ((int) Math.round(d));
                return true;
            }
        }

        void updateScroll(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.mFinal - this.mStart) * f);
        }
    }

    public OverScroller(Context context) {
        this(context, null);
    }

    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, float f, float f2) {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, float f, float f2, boolean z) {
        this(context, interpolator, z);
    }

    public OverScroller(Context context, Interpolator interpolator, boolean z) {
        if (interpolator == null) {
            this.mInterpolator = new Scroller.ViscousFluidInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
        this.mFlywheel = z;
        this.mScrollerX = new SplineOverScroller(context);
        this.mScrollerY = new SplineOverScroller(context);
    }

    public void abortAnimation() {
        this.mScrollerX.finish();
        this.mScrollerY.finish();
    }

    public boolean computeScrollOffset() {
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mScrollerX.mStartTime;
                int i = this.mScrollerX.mDuration;
                if (currentAnimationTimeMillis >= i) {
                    abortAnimation();
                    return true;
                }
                float interpolation = this.mInterpolator.getInterpolation(((float) currentAnimationTimeMillis) / i);
                this.mScrollerX.updateScroll(interpolation);
                this.mScrollerY.updateScroll(interpolation);
                return true;
            case 1:
                if (!this.mScrollerX.mFinished && !this.mScrollerX.update() && !this.mScrollerX.continueWhenFinished()) {
                    this.mScrollerX.finish();
                }
                if (this.mScrollerY.mFinished || this.mScrollerY.update() || this.mScrollerY.continueWhenFinished()) {
                    return true;
                }
                this.mScrollerY.finish();
                return true;
            default:
                return true;
        }
    }

    @Deprecated
    public void extendDuration(int i) {
        this.mScrollerX.extendDuration(i);
        this.mScrollerY.extendDuration(i);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i3;
        int i12 = i4;
        if (this.mFlywheel) {
            i11 = i3;
            i12 = i4;
            if (!isFinished()) {
                float f = this.mScrollerX.mCurrVelocity;
                float f2 = this.mScrollerY.mCurrVelocity;
                i11 = i3;
                i12 = i4;
                if (Math.signum(i3) == Math.signum(f)) {
                    i11 = i3;
                    i12 = i4;
                    if (Math.signum(i4) == Math.signum(f2)) {
                        i11 = (int) (i3 + f);
                        i12 = (int) (i4 + f2);
                    }
                }
            }
        }
        this.mMode = 1;
        this.mScrollerX.fling(i, i11, i5, i6, i9);
        this.mScrollerY.fling(i2, i12, i7, i8, i10);
    }

    public final void forceFinished(boolean z) {
        this.mScrollerX.mFinished = this.mScrollerY.mFinished = z;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.mScrollerX.mCurrVelocity * this.mScrollerX.mCurrVelocity) + (this.mScrollerY.mCurrVelocity * this.mScrollerY.mCurrVelocity));
    }

    public final int getCurrX() {
        return this.mScrollerX.mCurrentPosition;
    }

    public final int getCurrY() {
        return this.mScrollerY.mCurrentPosition;
    }

    @Deprecated
    public final int getDuration() {
        return Math.max(this.mScrollerX.mDuration, this.mScrollerY.mDuration);
    }

    public final int getFinalX() {
        return this.mScrollerX.mFinal;
    }

    public final int getFinalY() {
        return this.mScrollerY.mFinal;
    }

    public final int getStartX() {
        return this.mScrollerX.mStart;
    }

    public final int getStartY() {
        return this.mScrollerY.mStart;
    }

    public final boolean isFinished() {
        return this.mScrollerX.mFinished && this.mScrollerY.mFinished;
    }

    public boolean isOverScrolled() {
        if (this.mScrollerX.mFinished || this.mScrollerX.mState == 0) {
            return (this.mScrollerY.mFinished || this.mScrollerY.mState == 0) ? false : true;
        }
        return true;
    }

    public boolean isScrollingInDirection(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.mScrollerX.mFinal - this.mScrollerX.mStart)) && Math.signum(f2) == Math.signum((float) (this.mScrollerY.mFinal - this.mScrollerY.mStart));
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.mScrollerX.notifyEdgeReached(i, i2, i3);
    }

    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.mScrollerY.notifyEdgeReached(i, i2, i3);
    }

    @Deprecated
    public void setFinalX(int i) {
        this.mScrollerX.setFinalPosition(i);
    }

    @Deprecated
    public void setFinalY(int i) {
        this.mScrollerY.setFinalPosition(i);
    }

    public final void setFriction(float f) {
        this.mScrollerX.setFriction(f);
        this.mScrollerY.setFriction(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        if (interpolator == null) {
            this.mInterpolator = new Scroller.ViscousFluidInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.mScrollerX.springback(i, i3, i4) || this.mScrollerY.springback(i2, i5, i6);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        startScroll(i, i2, i3, i4, 250);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.mScrollerX.startScroll(i, i3, i5);
        this.mScrollerY.startScroll(i2, i4, i5);
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - Math.min(this.mScrollerX.mStartTime, this.mScrollerY.mStartTime));
    }
}
