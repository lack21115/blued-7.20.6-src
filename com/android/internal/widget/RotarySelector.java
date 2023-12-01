package com.android.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.AudioAttributes;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/RotarySelector.class */
public class RotarySelector extends View {
    private static final int ARROW_SCRUNCH_DIP = 6;
    private static final boolean DBG = false;
    private static final int EDGE_PADDING_DIP = 9;
    private static final int EDGE_TRIGGER_DIP = 100;
    public static final int HORIZONTAL = 0;
    public static final int LEFT_HANDLE_GRABBED = 1;
    private static final String LOG_TAG = "RotarySelector";
    public static final int NOTHING_GRABBED = 0;
    static final int OUTER_ROTARY_RADIUS_DIP = 390;
    public static final int RIGHT_HANDLE_GRABBED = 2;
    static final int ROTARY_STROKE_WIDTH_DIP = 83;
    static final int SNAP_BACK_ANIMATION_DURATION_MILLIS = 300;
    static final int SPIN_ANIMATION_DURATION_MILLIS = 800;
    public static final int VERTICAL = 1;
    private static final long VIBRATE_LONG = 20;
    private static final long VIBRATE_SHORT = 20;
    private static final AudioAttributes VIBRATION_ATTRIBUTES = new AudioAttributes.Builder().setContentType(4).setUsage(13).build();
    private static final boolean VISUAL_DEBUG = false;
    private boolean mAnimating;
    private int mAnimatingDeltaXEnd;
    private int mAnimatingDeltaXStart;
    private long mAnimationDuration;
    private long mAnimationStartTime;
    private Bitmap mArrowLongLeft;
    private Bitmap mArrowLongRight;
    final Matrix mArrowMatrix;
    private Bitmap mArrowShortLeftAndRight;
    private Bitmap mBackground;
    private int mBackgroundHeight;
    private int mBackgroundWidth;
    final Matrix mBgMatrix;
    private float mDensity;
    private Bitmap mDimple;
    private Bitmap mDimpleDim;
    private int mDimpleSpacing;
    private int mDimpleWidth;
    private int mDimplesOfFling;
    private int mEdgeTriggerThresh;
    private int mGrabbedState;
    private final int mInnerRadius;
    private DecelerateInterpolator mInterpolator;
    private Bitmap mLeftHandleIcon;
    private int mLeftHandleX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private OnDialTriggerListener mOnDialTriggerListener;
    private int mOrientation;
    private final int mOuterRadius;
    private Paint mPaint;
    private Bitmap mRightHandleIcon;
    private int mRightHandleX;
    private int mRotaryOffsetX;
    private boolean mTriggered;
    private VelocityTracker mVelocityTracker;
    private Vibrator mVibrator;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/RotarySelector$OnDialTriggerListener.class */
    public interface OnDialTriggerListener {
        public static final int LEFT_HANDLE = 1;
        public static final int RIGHT_HANDLE = 2;

        void onDialTrigger(View view, int i);

        void onGrabbedStateChange(View view, int i);
    }

    public RotarySelector(Context context) {
        this(context, null);
    }

    public RotarySelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRotaryOffsetX = 0;
        this.mAnimating = false;
        this.mPaint = new Paint();
        this.mBgMatrix = new Matrix();
        this.mArrowMatrix = new Matrix();
        this.mGrabbedState = 0;
        this.mTriggered = false;
        this.mDimplesOfFling = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RotarySelector);
        this.mOrientation = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        this.mDensity = getResources().getDisplayMetrics().density;
        this.mBackground = getBitmapFor(R.drawable.jog_dial_bg);
        this.mDimple = getBitmapFor(R.drawable.jog_dial_dimple);
        this.mDimpleDim = getBitmapFor(R.drawable.jog_dial_dimple_dim);
        this.mArrowLongLeft = getBitmapFor(R.drawable.jog_dial_arrow_long_left_green);
        this.mArrowLongRight = getBitmapFor(R.drawable.jog_dial_arrow_long_right_red);
        this.mArrowShortLeftAndRight = getBitmapFor(R.drawable.jog_dial_arrow_short_left_and_right);
        this.mInterpolator = new DecelerateInterpolator(1.0f);
        this.mEdgeTriggerThresh = (int) (this.mDensity * 100.0f);
        this.mDimpleWidth = this.mDimple.getWidth();
        this.mBackgroundWidth = this.mBackground.getWidth();
        this.mBackgroundHeight = this.mBackground.getHeight();
        this.mOuterRadius = (int) (this.mDensity * 390.0f);
        this.mInnerRadius = (int) (307.0f * this.mDensity);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.mContext);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 2;
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void dispatchTriggerEvent(int i) {
        vibrate(20L);
        if (this.mOnDialTriggerListener != null) {
            this.mOnDialTriggerListener.onDialTrigger(this, i);
        }
    }

    private void drawCentered(Bitmap bitmap, Canvas canvas, int i, int i2) {
        canvas.drawBitmap(bitmap, i - (bitmap.getWidth() / 2), i2 - (bitmap.getHeight() / 2), this.mPaint);
    }

    private Bitmap getBitmapFor(int i) {
        return BitmapFactory.decodeResource(getContext().getResources(), i);
    }

    private int getYOnArc(int i, int i2, int i3, int i4) {
        int i5 = (i3 - i2) / 2;
        int i6 = i2 + i5;
        int i7 = (i / 2) - i4;
        return (i6 - ((int) Math.sqrt((i6 * i6) - (i7 * i7)))) + i5;
    }

    private boolean isHoriz() {
        return this.mOrientation == 0;
    }

    private void log(String str) {
        Log.d(LOG_TAG, str);
    }

    private void reset() {
        this.mAnimating = false;
        this.mRotaryOffsetX = 0;
        this.mDimplesOfFling = 0;
        setGrabbedState(0);
        this.mTriggered = false;
    }

    private void setGrabbedState(int i) {
        if (i != this.mGrabbedState) {
            this.mGrabbedState = i;
            if (this.mOnDialTriggerListener != null) {
                this.mOnDialTriggerListener.onGrabbedStateChange(this, this.mGrabbedState);
            }
        }
    }

    private void startAnimation(int i, int i2, int i3) {
        this.mAnimating = true;
        this.mAnimationStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mAnimationDuration = i3;
        this.mAnimatingDeltaXStart = i;
        this.mAnimatingDeltaXEnd = i2;
        setGrabbedState(0);
        this.mDimplesOfFling = 0;
        invalidate();
    }

    private void startAnimationWithVelocity(int i, int i2, int i3) {
        this.mAnimating = true;
        this.mAnimationStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mAnimationDuration = ((i2 - i) * 1000) / i3;
        this.mAnimatingDeltaXStart = i;
        this.mAnimatingDeltaXEnd = i2;
        setGrabbedState(0);
        invalidate();
    }

    private void updateAnimation() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mAnimationStartTime;
        long j = this.mAnimationDuration;
        int i = this.mAnimatingDeltaXStart - this.mAnimatingDeltaXEnd;
        boolean z = i < 0;
        if (j - currentAnimationTimeMillis <= 0) {
            reset();
            return;
        }
        this.mRotaryOffsetX = this.mAnimatingDeltaXEnd + ((int) (i * (1.0f - this.mInterpolator.getInterpolation(((float) currentAnimationTimeMillis) / ((float) this.mAnimationDuration)))));
        if (this.mDimplesOfFling > 0) {
            if (!z && this.mRotaryOffsetX < this.mDimpleSpacing * (-3)) {
                this.mRotaryOffsetX += this.mDimplesOfFling * this.mDimpleSpacing;
            } else if (z && this.mRotaryOffsetX > this.mDimpleSpacing * 3) {
                this.mRotaryOffsetX -= this.mDimplesOfFling * this.mDimpleSpacing;
            }
        }
        invalidate();
    }

    private void vibrate(long j) {
        boolean z = true;
        synchronized (this) {
            if (Settings.System.getIntForUser(this.mContext.getContentResolver(), Settings.System.HAPTIC_FEEDBACK_ENABLED, 1, -2) == 0) {
                z = false;
            }
            if (z) {
                if (this.mVibrator == null) {
                    this.mVibrator = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
                }
                this.mVibrator.vibrate(j, VIBRATION_ATTRIBUTES);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.mAnimating) {
            updateAnimation();
        }
        canvas.drawBitmap(this.mBackground, this.mBgMatrix, this.mPaint);
        this.mArrowMatrix.reset();
        switch (this.mGrabbedState) {
            case 0:
                break;
            case 1:
                this.mArrowMatrix.setTranslate(0.0f, 0.0f);
                if (!isHoriz()) {
                    this.mArrowMatrix.preRotate(-90.0f, 0.0f, 0.0f);
                    this.mArrowMatrix.postTranslate(0.0f, height);
                }
                canvas.drawBitmap(this.mArrowLongLeft, this.mArrowMatrix, this.mPaint);
                break;
            case 2:
                this.mArrowMatrix.setTranslate(0.0f, 0.0f);
                if (!isHoriz()) {
                    this.mArrowMatrix.preRotate(-90.0f, 0.0f, 0.0f);
                    this.mArrowMatrix.postTranslate(0.0f, (this.mBackgroundWidth - height) + height);
                }
                canvas.drawBitmap(this.mArrowLongRight, this.mArrowMatrix, this.mPaint);
                break;
            default:
                throw new IllegalStateException("invalid mGrabbedState: " + this.mGrabbedState);
        }
        int i = this.mBackgroundHeight;
        int i2 = isHoriz() ? height - i : width - i;
        int i3 = this.mLeftHandleX + this.mRotaryOffsetX;
        int yOnArc = getYOnArc(this.mBackgroundWidth, this.mInnerRadius, this.mOuterRadius, i3);
        int i4 = isHoriz() ? i3 : yOnArc + i2;
        int i5 = isHoriz() ? yOnArc + i2 : height - i3;
        if (this.mGrabbedState != 2) {
            drawCentered(this.mDimple, canvas, i4, i5);
            drawCentered(this.mLeftHandleIcon, canvas, i4, i5);
        } else {
            drawCentered(this.mDimpleDim, canvas, i4, i5);
        }
        int i6 = isHoriz() ? (width / 2) + this.mRotaryOffsetX : (height / 2) + this.mRotaryOffsetX;
        int yOnArc2 = getYOnArc(this.mBackgroundWidth, this.mInnerRadius, this.mOuterRadius, i6);
        if (isHoriz()) {
            drawCentered(this.mDimpleDim, canvas, i6, yOnArc2 + i2);
        } else {
            drawCentered(this.mDimpleDim, canvas, yOnArc2 + i2, height - i6);
        }
        int i7 = this.mRightHandleX + this.mRotaryOffsetX;
        int yOnArc3 = getYOnArc(this.mBackgroundWidth, this.mInnerRadius, this.mOuterRadius, i7);
        int i8 = isHoriz() ? i7 : yOnArc3 + i2;
        int i9 = isHoriz() ? yOnArc3 + i2 : height - i7;
        if (this.mGrabbedState != 1) {
            drawCentered(this.mDimple, canvas, i8, i9);
            drawCentered(this.mRightHandleIcon, canvas, i8, i9);
        } else {
            drawCentered(this.mDimpleDim, canvas, i8, i9);
        }
        int i10 = (this.mRotaryOffsetX + this.mLeftHandleX) - this.mDimpleSpacing;
        int i11 = this.mDimpleWidth / 2;
        while (i10 > (-i11)) {
            int yOnArc4 = getYOnArc(this.mBackgroundWidth, this.mInnerRadius, this.mOuterRadius, i10);
            if (isHoriz()) {
                drawCentered(this.mDimpleDim, canvas, i10, yOnArc4 + i2);
            } else {
                drawCentered(this.mDimpleDim, canvas, yOnArc4 + i2, height - i10);
            }
            i10 -= this.mDimpleSpacing;
        }
        int i12 = this.mRotaryOffsetX + this.mRightHandleX + this.mDimpleSpacing;
        int i13 = this.mRight;
        while (i12 < i13 + i11) {
            int yOnArc5 = getYOnArc(this.mBackgroundWidth, this.mInnerRadius, this.mOuterRadius, i12);
            if (isHoriz()) {
                drawCentered(this.mDimpleDim, canvas, i12, yOnArc5 + i2);
            } else {
                drawCentered(this.mDimpleDim, canvas, yOnArc5 + i2, height - i12);
            }
            i12 += this.mDimpleSpacing;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = isHoriz() ? View.MeasureSpec.getSize(i) : View.MeasureSpec.getSize(i2);
        int height = (this.mBackgroundHeight + this.mArrowShortLeftAndRight.getHeight()) - ((int) (6.0f * this.mDensity));
        if (isHoriz()) {
            setMeasuredDimension(size, height);
        } else {
            setMeasuredDimension(height, size);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = (int) (9.0f * this.mDensity);
        this.mLeftHandleX = (this.mDimpleWidth / 2) + i5;
        int i6 = isHoriz() ? i : i2;
        this.mRightHandleX = (i6 - i5) - (this.mDimpleWidth / 2);
        this.mDimpleSpacing = (i6 / 2) - this.mLeftHandleX;
        this.mBgMatrix.setTranslate(0.0f, 0.0f);
        if (isHoriz()) {
            this.mBgMatrix.postTranslate(0.0f, i2 - this.mBackgroundHeight);
            return;
        }
        int i7 = this.mBackgroundHeight;
        this.mBgMatrix.preRotate(-90.0f, 0.0f, 0.0f);
        this.mBgMatrix.postTranslate(i - i7, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mAnimating) {
            return true;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int height = getHeight();
        int x = isHoriz() ? (int) motionEvent.getX() : height - ((int) motionEvent.getY());
        int i = this.mDimpleWidth;
        switch (motionEvent.getAction()) {
            case 0:
                this.mTriggered = false;
                if (this.mGrabbedState != 0) {
                    reset();
                    invalidate();
                }
                if (x < this.mLeftHandleX + i) {
                    this.mRotaryOffsetX = x - this.mLeftHandleX;
                    setGrabbedState(1);
                    invalidate();
                    vibrate(20L);
                    return true;
                } else if (x > this.mRightHandleX - i) {
                    this.mRotaryOffsetX = x - this.mRightHandleX;
                    setGrabbedState(2);
                    invalidate();
                    vibrate(20L);
                    return true;
                } else {
                    return true;
                }
            case 1:
                if (this.mGrabbedState == 1 && Math.abs(x - this.mLeftHandleX) > 5) {
                    startAnimation(x - this.mLeftHandleX, 0, 300);
                } else if (this.mGrabbedState == 2 && Math.abs(x - this.mRightHandleX) > 5) {
                    startAnimation(x - this.mRightHandleX, 0, 300);
                }
                this.mRotaryOffsetX = 0;
                setGrabbedState(0);
                invalidate();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    return true;
                }
                return true;
            case 2:
                if (this.mGrabbedState == 1) {
                    this.mRotaryOffsetX = x - this.mLeftHandleX;
                    invalidate();
                    if (isHoriz()) {
                        height = getRight();
                    }
                    if (x < height - this.mEdgeTriggerThresh || this.mTriggered) {
                        return true;
                    }
                    this.mTriggered = true;
                    dispatchTriggerEvent(1);
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int max = Math.max(this.mMinimumVelocity, isHoriz() ? (int) velocityTracker.getXVelocity() : -((int) velocityTracker.getYVelocity()));
                    this.mDimplesOfFling = Math.max(8, Math.abs(max / this.mDimpleSpacing));
                    startAnimationWithVelocity(x - this.mLeftHandleX, this.mDimplesOfFling * this.mDimpleSpacing, max);
                    return true;
                } else if (this.mGrabbedState == 2) {
                    this.mRotaryOffsetX = x - this.mRightHandleX;
                    invalidate();
                    if (x > this.mEdgeTriggerThresh || this.mTriggered) {
                        return true;
                    }
                    this.mTriggered = true;
                    dispatchTriggerEvent(2);
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int min = Math.min(-this.mMinimumVelocity, isHoriz() ? (int) velocityTracker2.getXVelocity() : -((int) velocityTracker2.getYVelocity()));
                    this.mDimplesOfFling = Math.max(8, Math.abs(min / this.mDimpleSpacing));
                    startAnimationWithVelocity(x - this.mRightHandleX, -(this.mDimplesOfFling * this.mDimpleSpacing), min);
                    return true;
                } else {
                    return true;
                }
            case 3:
                reset();
                invalidate();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

    public void setLeftHandleResource(int i) {
        if (i != 0) {
            this.mLeftHandleIcon = getBitmapFor(i);
        }
        invalidate();
    }

    public void setOnDialTriggerListener(OnDialTriggerListener onDialTriggerListener) {
        this.mOnDialTriggerListener = onDialTriggerListener;
    }

    public void setRightHandleResource(int i) {
        if (i != 0) {
            this.mRightHandleIcon = getBitmapFor(i);
        }
        invalidate();
    }
}
