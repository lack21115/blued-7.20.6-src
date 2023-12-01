package com.android.internal.widget.multiwaveview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.R;
import com.android.internal.widget.multiwaveview.Ease;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/GlowPadView.class */
public class GlowPadView extends View {
    private static final boolean DEBUG = false;
    private static final int HIDE_ANIMATION_DELAY = 200;
    private static final int HIDE_ANIMATION_DURATION = 200;
    private static final int INITIAL_SHOW_HANDLE_DURATION = 200;
    private static final int RETURN_TO_HOME_DELAY = 1200;
    private static final int RETURN_TO_HOME_DURATION = 200;
    private static final int REVEAL_GLOW_DELAY = 0;
    private static final int REVEAL_GLOW_DURATION = 0;
    private static final float RING_SCALE_COLLAPSED = 0.5f;
    private static final float RING_SCALE_EXPANDED = 1.0f;
    private static final int SHOW_ANIMATION_DELAY = 50;
    private static final int SHOW_ANIMATION_DURATION = 200;
    private static final float SNAP_MARGIN_DEFAULT = 20.0f;
    private static final int STATE_FINISH = 5;
    private static final int STATE_FIRST_TOUCH = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_SNAP = 4;
    private static final int STATE_START = 1;
    private static final int STATE_TRACKING = 3;
    private static final String TAG = "GlowPadView";
    private static final float TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED = 1.3f;
    private static final float TARGET_SCALE_COLLAPSED = 0.8f;
    private static final float TARGET_SCALE_EXPANDED = 1.0f;
    private static final AudioAttributes VIBRATION_ATTRIBUTES = new AudioAttributes.Builder().setContentType(4).setUsage(13).build();
    private static final int WAVE_ANIMATION_DURATION = 1000;
    private int mActiveTarget;
    private boolean mAllowScaling;
    private boolean mAlwaysTrackFinger;
    private boolean mAnimatingTargets;
    private Tweener mBackgroundAnimator;
    private ArrayList<String> mDirectionDescriptions;
    private int mDirectionDescriptionsResourceId;
    private boolean mDragging;
    private int mFeedbackCount;
    private float mFirstItemOffset;
    private AnimationBundle mGlowAnimations;
    private float mGlowRadius;
    private int mGrabbedState;
    private int mGravity;
    private TargetDrawable mHandleDrawable;
    private int mHorizontalInset;
    private boolean mInitialLayout;
    private float mInnerRadius;
    private boolean mMagneticTargets;
    private int mMaxTargetHeight;
    private int mMaxTargetWidth;
    private int mNewTargetResources;
    private OnTriggerListener mOnTriggerListener;
    private float mOuterRadius;
    private TargetDrawable mOuterRing;
    private PointCloud mPointCloud;
    private int mPointerId;
    private Animator.AnimatorListener mResetListener;
    private Animator.AnimatorListener mResetListenerWithPing;
    private float mRingScaleFactor;
    private float mSnapMargin;
    private AnimationBundle mTargetAnimations;
    private ArrayList<String> mTargetDescriptions;
    private int mTargetDescriptionsResourceId;
    private ArrayList<TargetDrawable> mTargetDrawables;
    private int mTargetResourceId;
    private Animator.AnimatorListener mTargetUpdateListener;
    private ValueAnimator.AnimatorUpdateListener mUpdateListener;
    private int mVerticalInset;
    private int mVibrationDuration;
    private Vibrator mVibrator;
    private AnimationBundle mWaveAnimations;
    private float mWaveCenterX;
    private float mWaveCenterY;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle.class */
    public class AnimationBundle extends ArrayList<Tweener> {
        private static final long serialVersionUID = -6319262269245852568L;
        private boolean mSuspended;

        private AnimationBundle() {
        }

        public void cancel() {
            int size = size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    clear();
                    return;
                } else {
                    get(i2).animator.cancel();
                    i = i2 + 1;
                }
            }
        }

        public void setSuspended(boolean z) {
            this.mSuspended = z;
        }

        public void start() {
            if (this.mSuspended) {
                return;
            }
            int size = size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                get(i2).animator.start();
                i = i2 + 1;
            }
        }

        public void stop() {
            int size = size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    clear();
                    return;
                } else {
                    get(i2).animator.end();
                    i = i2 + 1;
                }
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/GlowPadView$OnTriggerListener.class */
    public interface OnTriggerListener {
        public static final int CENTER_HANDLE = 1;
        public static final int NO_HANDLE = 0;

        void onFinishFinalAnimation();

        void onGrabbed(View view, int i);

        void onGrabbedStateChange(View view, int i);

        void onReleased(View view, int i);

        void onTrigger(View view, int i);
    }

    public GlowPadView(Context context) {
        this(context, null);
    }

    public GlowPadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTargetDrawables = new ArrayList<>();
        this.mWaveAnimations = new AnimationBundle();
        this.mTargetAnimations = new AnimationBundle();
        this.mGlowAnimations = new AnimationBundle();
        this.mFeedbackCount = 3;
        this.mVibrationDuration = 0;
        this.mActiveTarget = -1;
        this.mRingScaleFactor = 1.0f;
        this.mOuterRadius = 0.0f;
        this.mSnapMargin = 0.0f;
        this.mFirstItemOffset = 0.0f;
        this.mMagneticTargets = false;
        this.mResetListener = new AnimatorListenerAdapter() { // from class: com.android.internal.widget.multiwaveview.GlowPadView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                GlowPadView.this.switchToState(0, GlowPadView.this.mWaveCenterX, GlowPadView.this.mWaveCenterY);
                GlowPadView.this.dispatchOnFinishFinalAnimation();
            }
        };
        this.mResetListenerWithPing = new AnimatorListenerAdapter() { // from class: com.android.internal.widget.multiwaveview.GlowPadView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                GlowPadView.this.ping();
                GlowPadView.this.switchToState(0, GlowPadView.this.mWaveCenterX, GlowPadView.this.mWaveCenterY);
                GlowPadView.this.dispatchOnFinishFinalAnimation();
            }
        };
        this.mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.internal.widget.multiwaveview.GlowPadView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GlowPadView.this.invalidate();
            }
        };
        this.mTargetUpdateListener = new AnimatorListenerAdapter() { // from class: com.android.internal.widget.multiwaveview.GlowPadView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (GlowPadView.this.mNewTargetResources != 0) {
                    GlowPadView.this.internalSetTargetResources(GlowPadView.this.mNewTargetResources);
                    GlowPadView.this.mNewTargetResources = 0;
                    GlowPadView.this.hideTargets(false, false);
                }
                GlowPadView.this.mAnimatingTargets = false;
            }
        };
        this.mGravity = 48;
        this.mInitialLayout = true;
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GlowPadView);
        this.mInnerRadius = obtainStyledAttributes.getDimension(1, this.mInnerRadius);
        this.mOuterRadius = obtainStyledAttributes.getDimension(8, this.mOuterRadius);
        this.mSnapMargin = obtainStyledAttributes.getDimension(11, this.mSnapMargin);
        this.mFirstItemOffset = (float) Math.toRadians(obtainStyledAttributes.getFloat(14, (float) Math.toDegrees(this.mFirstItemOffset)));
        this.mVibrationDuration = obtainStyledAttributes.getInt(10, this.mVibrationDuration);
        this.mFeedbackCount = obtainStyledAttributes.getInt(12, this.mFeedbackCount);
        this.mAllowScaling = obtainStyledAttributes.getBoolean(16, false);
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        this.mHandleDrawable = new TargetDrawable(resources, peekValue != null ? peekValue.resourceId : 0);
        this.mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE);
        this.mOuterRing = new TargetDrawable(resources, getResourceId(obtainStyledAttributes, 6));
        this.mAlwaysTrackFinger = obtainStyledAttributes.getBoolean(13, false);
        this.mMagneticTargets = obtainStyledAttributes.getBoolean(15, this.mMagneticTargets);
        int resourceId = getResourceId(obtainStyledAttributes, 7);
        Drawable drawable = resourceId != 0 ? context.getDrawable(resourceId) : null;
        this.mGlowRadius = obtainStyledAttributes.getDimension(9, 0.0f);
        this.mPointCloud = new PointCloud(drawable);
        this.mPointCloud.makePointCloud(this.mInnerRadius, this.mOuterRadius);
        this.mPointCloud.glowManager.setRadius(this.mGlowRadius);
        TypedValue typedValue = new TypedValue();
        if (obtainStyledAttributes.getValue(4, typedValue)) {
            internalSetTargetResources(typedValue.resourceId);
        }
        if (this.mTargetDrawables == null || this.mTargetDrawables.size() == 0) {
            throw new IllegalStateException("Must specify at least one target drawable");
        }
        if (obtainStyledAttributes.getValue(2, typedValue)) {
            int i = typedValue.resourceId;
            if (i == 0) {
                throw new IllegalStateException("Must specify target descriptions");
            }
            setTargetDescriptionsResourceId(i);
        }
        if (obtainStyledAttributes.getValue(3, typedValue)) {
            int i2 = typedValue.resourceId;
            if (i2 == 0) {
                throw new IllegalStateException("Must specify direction descriptions");
            }
            setDirectionDescriptionsResourceId(i2);
        }
        this.mGravity = obtainStyledAttributes.getInt(0, 48);
        obtainStyledAttributes.recycle();
        setVibrateEnabled(this.mVibrationDuration > 0);
        assignDefaultsIfNeeded();
    }

    private void announceTargets() {
        StringBuilder sb = new StringBuilder();
        int size = this.mTargetDrawables.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            String targetDescription = getTargetDescription(i2);
            String directionDescription = getDirectionDescription(i2);
            if (!TextUtils.isEmpty(targetDescription) && !TextUtils.isEmpty(directionDescription)) {
                sb.append(String.format(directionDescription, targetDescription));
            }
            i = i2 + 1;
        }
        if (sb.length() > 0) {
            announceForAccessibility(sb.toString());
        }
    }

    private void assignDefaultsIfNeeded() {
        if (this.mOuterRadius == 0.0f) {
            this.mOuterRadius = Math.max(this.mOuterRing.getWidth(), this.mOuterRing.getHeight()) / 2.0f;
        }
        if (this.mSnapMargin == 0.0f) {
            this.mSnapMargin = TypedValue.applyDimension(1, SNAP_MARGIN_DEFAULT, getContext().getResources().getDisplayMetrics());
        }
        if (this.mInnerRadius == 0.0f) {
            this.mInnerRadius = this.mHandleDrawable.getWidth() / 10.0f;
        }
    }

    private void computeInsets(int i, int i2) {
        int absoluteGravity = Gravity.getAbsoluteGravity(this.mGravity, getLayoutDirection());
        switch (absoluteGravity & 7) {
            case 3:
                this.mHorizontalInset = 0;
                break;
            case 4:
            default:
                this.mHorizontalInset = i / 2;
                break;
            case 5:
                this.mHorizontalInset = i;
                break;
        }
        switch (absoluteGravity & 112) {
            case 48:
                this.mVerticalInset = 0;
                return;
            case 80:
                this.mVerticalInset = i2;
                return;
            default:
                this.mVerticalInset = i2 / 2;
                return;
        }
    }

    private float computeScaleFactor(int i, int i2, int i3, int i4) {
        if (this.mAllowScaling) {
            int absoluteGravity = Gravity.getAbsoluteGravity(this.mGravity, getLayoutDirection());
            float f = 1.0f;
            switch (absoluteGravity & 7) {
                case 3:
                case 5:
                    break;
                case 4:
                default:
                    f = 1.0f;
                    if (i > i3) {
                        f = ((i3 * 1.0f) - this.mMaxTargetWidth) / (i - this.mMaxTargetWidth);
                        break;
                    }
                    break;
            }
            float f2 = 1.0f;
            switch (absoluteGravity & 112) {
                case 48:
                case 80:
                    break;
                default:
                    f2 = 1.0f;
                    if (i2 > i4) {
                        f2 = ((1.0f * i4) - this.mMaxTargetHeight) / (i2 - this.mMaxTargetHeight);
                        break;
                    }
                    break;
            }
            return Math.min(f, f2);
        }
        return 1.0f;
    }

    private void deactivateTargets() {
        int size = this.mTargetDrawables.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.mActiveTarget = -1;
                return;
            } else {
                this.mTargetDrawables.get(i2).setState(TargetDrawable.STATE_INACTIVE);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnFinishFinalAnimation() {
        if (this.mOnTriggerListener != null) {
            this.mOnTriggerListener.onFinishFinalAnimation();
        }
    }

    private void dispatchTriggerEvent(int i) {
        vibrate();
        if (this.mOnTriggerListener != null) {
            this.mOnTriggerListener.onTrigger(this, i);
        }
    }

    private float dist2(float f, float f2) {
        return (f * f) + (f2 * f2);
    }

    private void doFinish() {
        int i = this.mActiveTarget;
        if (i != -1) {
            highlightSelected(i);
            hideGlow(200, 1200, 0.0f, this.mResetListener);
            dispatchTriggerEvent(i);
            if (!this.mAlwaysTrackFinger) {
                this.mTargetAnimations.stop();
            }
        } else {
            hideGlow(200, 0, 0.0f, this.mResetListenerWithPing);
            hideTargets(true, false);
        }
        setGrabbedState(0);
    }

    private void dump() {
        Log.v(TAG, "Outer Radius = " + this.mOuterRadius);
        Log.v(TAG, "SnapMargin = " + this.mSnapMargin);
        Log.v(TAG, "FeedbackCount = " + this.mFeedbackCount);
        Log.v(TAG, "VibrationDuration = " + this.mVibrationDuration);
        Log.v(TAG, "GlowRadius = " + this.mGlowRadius);
        Log.v(TAG, "WaveCenterX = " + this.mWaveCenterX);
        Log.v(TAG, "WaveCenterY = " + this.mWaveCenterY);
    }

    private float getAngle(float f, int i) {
        return this.mFirstItemOffset + (i * f);
    }

    private String getDirectionDescription(int i) {
        if (this.mDirectionDescriptions == null || this.mDirectionDescriptions.isEmpty()) {
            this.mDirectionDescriptions = loadDescriptions(this.mDirectionDescriptionsResourceId);
            if (this.mTargetDrawables.size() != this.mDirectionDescriptions.size()) {
                return null;
            }
        }
        return this.mDirectionDescriptions.get(i);
    }

    private int getResourceId(TypedArray typedArray, int i) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return 0;
        }
        return peekValue.resourceId;
    }

    private float getRingHeight() {
        return this.mRingScaleFactor * Math.max(this.mOuterRing.getHeight(), 2.0f * this.mOuterRadius);
    }

    private float getRingWidth() {
        return this.mRingScaleFactor * Math.max(this.mOuterRing.getWidth(), 2.0f * this.mOuterRadius);
    }

    private float getScaledGlowRadiusSquared() {
        return square(AccessibilityManager.getInstance(this.mContext).isEnabled() ? TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED * this.mGlowRadius : this.mGlowRadius);
    }

    private float getSliceAngle() {
        return (float) ((-6.283185307179586d) / this.mTargetDrawables.size());
    }

    private String getTargetDescription(int i) {
        if (this.mTargetDescriptions == null || this.mTargetDescriptions.isEmpty()) {
            this.mTargetDescriptions = loadDescriptions(this.mTargetDescriptionsResourceId);
            if (this.mTargetDrawables.size() != this.mTargetDescriptions.size()) {
                return null;
            }
        }
        return this.mTargetDescriptions.get(i);
    }

    private void handleCancel(MotionEvent motionEvent) {
        this.mActiveTarget = -1;
        int findPointerIndex = motionEvent.findPointerIndex(this.mPointerId);
        int i = findPointerIndex;
        if (findPointerIndex == -1) {
            i = 0;
        }
        switchToState(5, motionEvent.getX(i), motionEvent.getY(i));
    }

    private void handleDown(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        float x = motionEvent.getX(actionIndex);
        float y = motionEvent.getY(actionIndex);
        switchToState(1, x, y);
        if (!trySwitchToFirstTouchState(x, y)) {
            this.mDragging = false;
            return;
        }
        this.mPointerId = motionEvent.getPointerId(actionIndex);
        updateGlowPosition(x, y);
    }

    private void handleMove(MotionEvent motionEvent) {
        int i = -1;
        int historySize = motionEvent.getHistorySize();
        ArrayList<TargetDrawable> arrayList = this.mTargetDrawables;
        int size = arrayList.size();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int findPointerIndex = motionEvent.findPointerIndex(this.mPointerId);
        if (findPointerIndex == -1) {
            return;
        }
        int i2 = 0;
        while (i2 < historySize + 1) {
            float historicalX = i2 < historySize ? motionEvent.getHistoricalX(findPointerIndex, i2) : motionEvent.getX(findPointerIndex);
            float historicalY = i2 < historySize ? motionEvent.getHistoricalY(findPointerIndex, i2) : motionEvent.getY(findPointerIndex);
            float f4 = historicalX - this.mWaveCenterX;
            float f5 = historicalY - this.mWaveCenterY;
            float sqrt = (float) Math.sqrt(dist2(f4, f5));
            float f6 = sqrt > this.mOuterRadius ? this.mOuterRadius / sqrt : 1.0f;
            double atan2 = Math.atan2(-f5, f4);
            if (!this.mDragging) {
                trySwitchToFirstTouchState(historicalX, historicalY);
            }
            float f7 = f3;
            int i3 = i;
            if (this.mDragging) {
                float f8 = (this.mRingScaleFactor * this.mOuterRadius) - this.mSnapMargin;
                int i4 = 0;
                while (true) {
                    f7 = f3;
                    i3 = i;
                    if (i4 < size) {
                        TargetDrawable targetDrawable = arrayList.get(i4);
                        double d = this.mFirstItemOffset + ((((i4 - 0.5d) * 2.0d) * 3.141592653589793d) / size);
                        double d2 = this.mFirstItemOffset + ((((i4 + 0.5d) * 2.0d) * 3.141592653589793d) / size);
                        float f9 = f3;
                        int i5 = i;
                        if (targetDrawable.isEnabled()) {
                            f9 = f3;
                            i5 = i;
                            if ((atan2 > d && atan2 <= d2) || (6.283185307179586d + atan2 > d && 6.283185307179586d + atan2 <= d2) || (atan2 - 6.283185307179586d > d && atan2 - 6.283185307179586d <= d2)) {
                                f9 = f3;
                                i5 = i;
                                if (dist2(f4, f5) > f8 * f8) {
                                    i5 = i4;
                                    f9 = (float) (-atan2);
                                }
                            }
                        }
                        i4++;
                        f3 = f9;
                        i = i5;
                    }
                }
            }
            float f10 = f4 * f6;
            float f11 = f5 * f6;
            i2++;
            f3 = f7;
            i = i3;
            f = f10;
            f2 = f11;
        }
        if (this.mDragging) {
            if (i != -1) {
                switchToState(4, f, f2);
                updateGlowPosition(f, f2);
            } else {
                switchToState(3, f, f2);
                updateGlowPosition(f, f2);
            }
            if (this.mActiveTarget != i) {
                if (this.mActiveTarget != -1) {
                    TargetDrawable targetDrawable2 = arrayList.get(this.mActiveTarget);
                    if (targetDrawable2.hasState(TargetDrawable.STATE_FOCUSED)) {
                        targetDrawable2.setState(TargetDrawable.STATE_INACTIVE);
                    }
                    if (this.mMagneticTargets) {
                        updateTargetPosition(this.mActiveTarget, this.mWaveCenterX, this.mWaveCenterY);
                    }
                }
                if (i != -1) {
                    TargetDrawable targetDrawable3 = arrayList.get(i);
                    if (targetDrawable3.hasState(TargetDrawable.STATE_FOCUSED)) {
                        targetDrawable3.setState(TargetDrawable.STATE_FOCUSED);
                    }
                    if (this.mMagneticTargets) {
                        updateTargetPosition(i, this.mWaveCenterX, this.mWaveCenterY, f3);
                    }
                    if (AccessibilityManager.getInstance(this.mContext).isEnabled()) {
                        announceForAccessibility(getTargetDescription(i));
                    }
                }
            }
            this.mActiveTarget = i;
        }
    }

    private void handleUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mPointerId) {
            switchToState(5, motionEvent.getX(actionIndex), motionEvent.getY(actionIndex));
        }
    }

    private void hideGlow(int i, int i2, float f, Animator.AnimatorListener animatorListener) {
        this.mGlowAnimations.cancel();
        this.mGlowAnimations.add(Tweener.to(this.mPointCloud.glowManager, i, "ease", Ease.Quart.easeOut, "delay", Integer.valueOf(i2), "alpha", Float.valueOf(f), "x", Float.valueOf(0.0f), "y", Float.valueOf(0.0f), "onUpdate", this.mUpdateListener, "onComplete", animatorListener));
        this.mGlowAnimations.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTargets(boolean z, boolean z2) {
        this.mTargetAnimations.cancel();
        this.mAnimatingTargets = z;
        int i = z ? 200 : 0;
        int i2 = z ? 200 : 0;
        float f = z2 ? 1.0f : 0.8f;
        int size = this.mTargetDrawables.size();
        TimeInterpolator timeInterpolator = Ease.Cubic.easeOut;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                break;
            }
            TargetDrawable targetDrawable = this.mTargetDrawables.get(i4);
            targetDrawable.setState(TargetDrawable.STATE_INACTIVE);
            this.mTargetAnimations.add(Tweener.to(targetDrawable, i, "ease", timeInterpolator, "alpha", Float.valueOf(0.0f), "scaleX", Float.valueOf(f), "scaleY", Float.valueOf(f), "delay", Integer.valueOf(i2), "onUpdate", this.mUpdateListener));
            i3 = i4 + 1;
        }
        float f2 = (z2 ? 1.0f : 0.5f) * this.mRingScaleFactor;
        this.mTargetAnimations.add(Tweener.to(this.mOuterRing, i, "ease", timeInterpolator, "alpha", Float.valueOf(0.0f), "scaleX", Float.valueOf(f2), "scaleY", Float.valueOf(f2), "delay", Integer.valueOf(i2), "onUpdate", this.mUpdateListener, "onComplete", this.mTargetUpdateListener));
        this.mTargetAnimations.start();
    }

    private void hideUnselected(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mTargetDrawables.size()) {
                return;
            }
            if (i3 != i) {
                this.mTargetDrawables.get(i3).setAlpha(0.0f);
            }
            i2 = i3 + 1;
        }
    }

    private void highlightSelected(int i) {
        this.mTargetDrawables.get(i).setState(TargetDrawable.STATE_ACTIVE);
        hideUnselected(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalSetTargetResources(int i) {
        ArrayList<TargetDrawable> loadDrawableArray = loadDrawableArray(i);
        this.mTargetDrawables = loadDrawableArray;
        this.mTargetResourceId = i;
        int width = this.mHandleDrawable.getWidth();
        int height = this.mHandleDrawable.getHeight();
        int size = loadDrawableArray.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                break;
            }
            TargetDrawable targetDrawable = loadDrawableArray.get(i3);
            width = Math.max(width, targetDrawable.getWidth());
            height = Math.max(height, targetDrawable.getHeight());
            i2 = i3 + 1;
        }
        if (this.mMaxTargetWidth == width && this.mMaxTargetHeight == height) {
            updateTargetPositions(this.mWaveCenterX, this.mWaveCenterY);
            updatePointCloudPosition(this.mWaveCenterX, this.mWaveCenterY);
            return;
        }
        this.mMaxTargetWidth = width;
        this.mMaxTargetHeight = height;
        requestLayout();
    }

    private ArrayList<String> loadDescriptions(int i) {
        TypedArray obtainTypedArray = getContext().getResources().obtainTypedArray(i);
        int length = obtainTypedArray.length();
        ArrayList<String> arrayList = new ArrayList<>(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                obtainTypedArray.recycle();
                return arrayList;
            }
            arrayList.add(obtainTypedArray.getString(i3));
            i2 = i3 + 1;
        }
    }

    private ArrayList<TargetDrawable> loadDrawableArray(int i) {
        Resources resources = getContext().getResources();
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        int length = obtainTypedArray.length();
        ArrayList<TargetDrawable> arrayList = new ArrayList<>(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                obtainTypedArray.recycle();
                return arrayList;
            }
            TypedValue peekValue = obtainTypedArray.peekValue(i3);
            arrayList.add(new TargetDrawable(resources, peekValue != null ? peekValue.resourceId : 0));
            i2 = i3 + 1;
        }
    }

    private boolean replaceTargetDrawables(Resources resources, int i, int i2) {
        boolean z;
        if (i == 0 || i2 == 0) {
            z = false;
        } else {
            boolean z2 = false;
            ArrayList<TargetDrawable> arrayList = this.mTargetDrawables;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                TargetDrawable targetDrawable = arrayList.get(i3);
                boolean z3 = z2;
                if (targetDrawable != null) {
                    z3 = z2;
                    if (targetDrawable.getResourceId() == i) {
                        targetDrawable.setDrawable(resources, i2);
                        z3 = true;
                    }
                }
                i3++;
                z2 = z3;
            }
            z = z2;
            if (z2) {
                requestLayout();
                return z2;
            }
        }
        return z;
    }

    private int resolveMeasured(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        switch (View.MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                return Math.min(size, i2);
            case 0:
                return i2;
            default:
                return size;
        }
    }

    private void setGrabbedState(int i) {
        if (i != this.mGrabbedState) {
            if (i != 0) {
                vibrate();
            }
            this.mGrabbedState = i;
            if (this.mOnTriggerListener != null) {
                if (i == 0) {
                    this.mOnTriggerListener.onReleased(this, 1);
                } else {
                    this.mOnTriggerListener.onGrabbed(this, 1);
                }
                this.mOnTriggerListener.onGrabbedStateChange(this, i);
            }
        }
    }

    private void showGlow(int i, int i2, float f, Animator.AnimatorListener animatorListener) {
        this.mGlowAnimations.cancel();
        this.mGlowAnimations.add(Tweener.to(this.mPointCloud.glowManager, i, "ease", Ease.Cubic.easeIn, "delay", Integer.valueOf(i2), "alpha", Float.valueOf(f), "onUpdate", this.mUpdateListener, "onComplete", animatorListener));
        this.mGlowAnimations.start();
    }

    private void showTargets(boolean z) {
        this.mTargetAnimations.stop();
        this.mAnimatingTargets = z;
        int i = z ? 50 : 0;
        int i2 = z ? 200 : 0;
        int size = this.mTargetDrawables.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                float f = this.mRingScaleFactor * 1.0f;
                this.mTargetAnimations.add(Tweener.to(this.mOuterRing, i2, "ease", Ease.Cubic.easeOut, "alpha", Float.valueOf(1.0f), "scaleX", Float.valueOf(f), "scaleY", Float.valueOf(f), "delay", Integer.valueOf(i), "onUpdate", this.mUpdateListener, "onComplete", this.mTargetUpdateListener));
                this.mTargetAnimations.start();
                return;
            }
            TargetDrawable targetDrawable = this.mTargetDrawables.get(i4);
            targetDrawable.setState(TargetDrawable.STATE_INACTIVE);
            this.mTargetAnimations.add(Tweener.to(targetDrawable, i2, "ease", Ease.Cubic.easeOut, "alpha", Float.valueOf(1.0f), "scaleX", Float.valueOf(1.0f), "scaleY", Float.valueOf(1.0f), "delay", Integer.valueOf(i), "onUpdate", this.mUpdateListener));
            i3 = i4 + 1;
        }
    }

    private float square(float f) {
        return f * f;
    }

    private void startBackgroundAnimation(int i, float f) {
        Drawable background = getBackground();
        if (!this.mAlwaysTrackFinger || background == null) {
            return;
        }
        if (this.mBackgroundAnimator != null) {
            this.mBackgroundAnimator.animator.cancel();
        }
        this.mBackgroundAnimator = Tweener.to(background, i, "ease", Ease.Cubic.easeIn, "alpha", Integer.valueOf((int) (255.0f * f)), "delay", 50);
        this.mBackgroundAnimator.animator.start();
    }

    private void startWaveAnimation() {
        this.mWaveAnimations.cancel();
        this.mPointCloud.waveManager.setAlpha(1.0f);
        this.mPointCloud.waveManager.setRadius(this.mHandleDrawable.getWidth() / 2.0f);
        this.mWaveAnimations.add(Tweener.to(this.mPointCloud.waveManager, 1000L, "ease", Ease.Quad.easeOut, "delay", 0, "radius", Float.valueOf(this.mOuterRadius * 2.0f), "onUpdate", this.mUpdateListener, "onComplete", new AnimatorListenerAdapter() { // from class: com.android.internal.widget.multiwaveview.GlowPadView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                GlowPadView.this.mPointCloud.waveManager.setRadius(0.0f);
                GlowPadView.this.mPointCloud.waveManager.setAlpha(0.0f);
            }
        }));
        this.mWaveAnimations.start();
    }

    private void stopAndHideWaveAnimation() {
        this.mWaveAnimations.cancel();
        this.mPointCloud.waveManager.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToState(int i, float f, float f2) {
        switch (i) {
            case 0:
                deactivateTargets();
                hideGlow(0, 0, 0.0f, null);
                startBackgroundAnimation(0, 0.0f);
                this.mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE);
                this.mHandleDrawable.setAlpha(1.0f);
                return;
            case 1:
                startBackgroundAnimation(0, 0.0f);
                return;
            case 2:
                this.mHandleDrawable.setAlpha(0.0f);
                deactivateTargets();
                showTargets(true);
                startBackgroundAnimation(200, 1.0f);
                setGrabbedState(1);
                if (AccessibilityManager.getInstance(this.mContext).isEnabled()) {
                    announceTargets();
                    return;
                }
                return;
            case 3:
                this.mHandleDrawable.setAlpha(0.0f);
                showGlow(0, 0, 1.0f, null);
                return;
            case 4:
                this.mHandleDrawable.setAlpha(0.0f);
                showGlow(0, 0, 0.0f, null);
                return;
            case 5:
                doFinish();
                return;
            default:
                return;
        }
    }

    private boolean trySwitchToFirstTouchState(float f, float f2) {
        float f3 = f - this.mWaveCenterX;
        float f4 = f2 - this.mWaveCenterY;
        if (this.mAlwaysTrackFinger || dist2(f3, f4) <= getScaledGlowRadiusSquared()) {
            switchToState(2, f, f2);
            updateGlowPosition(f3, f4);
            this.mDragging = true;
            return true;
        }
        return false;
    }

    private void updateGlowPosition(float f, float f2) {
        float x = this.mOuterRing.getX();
        float y = this.mOuterRing.getY();
        float f3 = 1.0f / this.mRingScaleFactor;
        float f4 = 1.0f / this.mRingScaleFactor;
        this.mPointCloud.glowManager.setX(this.mOuterRing.getX() + ((f - x) * f3));
        this.mPointCloud.glowManager.setY(this.mOuterRing.getY() + ((f2 - y) * f4));
    }

    private void updatePointCloudPosition(float f, float f2) {
        this.mPointCloud.setCenter(f, f2);
    }

    private void updateTargetPosition(int i, float f, float f2) {
        updateTargetPosition(i, f, f2, getAngle(getSliceAngle(), i));
    }

    private void updateTargetPosition(int i, float f, float f2, float f3) {
        float ringWidth = getRingWidth() / 2.0f;
        float ringHeight = getRingHeight() / 2.0f;
        if (i >= 0) {
            TargetDrawable targetDrawable = this.mTargetDrawables.get(i);
            targetDrawable.setPositionX(f);
            targetDrawable.setPositionY(f2);
            targetDrawable.setX(((float) Math.cos(f3)) * ringWidth);
            targetDrawable.setY(((float) Math.sin(f3)) * ringHeight);
        }
    }

    private void updateTargetPositions(float f, float f2) {
        updateTargetPositions(f, f2, false);
    }

    private void updateTargetPositions(float f, float f2, boolean z) {
        int size = this.mTargetDrawables.size();
        float sliceAngle = getSliceAngle();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            if (!z || i2 != this.mActiveTarget) {
                updateTargetPosition(i2, f, f2, getAngle(sliceAngle, i2));
            }
            i = i2 + 1;
        }
    }

    private void vibrate() {
        boolean z = true;
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), "haptic_feedback_enabled", 1, -2) == 0) {
            z = false;
        }
        if (this.mVibrator == null || !z) {
            return;
        }
        this.mVibrator.vibrate(this.mVibrationDuration, VIBRATION_ATTRIBUTES);
    }

    public int getDirectionDescriptionsResourceId() {
        return this.mDirectionDescriptionsResourceId;
    }

    public int getResourceIdForTarget(int i) {
        TargetDrawable targetDrawable = this.mTargetDrawables.get(i);
        if (targetDrawable == null) {
            return 0;
        }
        return targetDrawable.getResourceId();
    }

    protected int getScaledSuggestedMinimumHeight() {
        return (int) ((this.mRingScaleFactor * Math.max(this.mOuterRing.getHeight(), 2.0f * this.mOuterRadius)) + this.mMaxTargetHeight);
    }

    protected int getScaledSuggestedMinimumWidth() {
        return (int) ((this.mRingScaleFactor * Math.max(this.mOuterRing.getWidth(), 2.0f * this.mOuterRadius)) + this.mMaxTargetWidth);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return (int) (Math.max(this.mOuterRing.getHeight(), 2.0f * this.mOuterRadius) + this.mMaxTargetHeight);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return (int) (Math.max(this.mOuterRing.getWidth(), 2.0f * this.mOuterRadius) + this.mMaxTargetWidth);
    }

    public int getTargetDescriptionsResourceId() {
        return this.mTargetDescriptionsResourceId;
    }

    public int getTargetPosition(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mTargetDrawables.size()) {
                return -1;
            }
            if (this.mTargetDrawables.get(i3).getResourceId() == i) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public int getTargetResourceId() {
        return this.mTargetResourceId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.mPointCloud.draw(canvas);
        this.mOuterRing.draw(canvas);
        int size = this.mTargetDrawables.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.mHandleDrawable.draw(canvas);
                return;
            }
            TargetDrawable targetDrawable = this.mTargetDrawables.get(i2);
            if (targetDrawable != null) {
                targetDrawable.draw(canvas);
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (AccessibilityManager.getInstance(this.mContext).isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            switch (action) {
                case 7:
                    motionEvent.setAction(2);
                    break;
                case 9:
                    motionEvent.setAction(0);
                    break;
                case 10:
                    motionEvent.setAction(1);
                    break;
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        super.onHoverEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float ringWidth = getRingWidth();
        float ringHeight = getRingHeight();
        float f = this.mHorizontalInset + ((this.mMaxTargetWidth + ringWidth) / 2.0f);
        float f2 = this.mVerticalInset + ((this.mMaxTargetHeight + ringHeight) / 2.0f);
        if (this.mInitialLayout) {
            stopAndHideWaveAnimation();
            hideTargets(false, false);
            this.mInitialLayout = false;
        }
        this.mOuterRing.setPositionX(f);
        this.mOuterRing.setPositionY(f2);
        this.mPointCloud.setScale(this.mRingScaleFactor);
        this.mHandleDrawable.setPositionX(f);
        this.mHandleDrawable.setPositionY(f2);
        updateTargetPositions(f, f2);
        updatePointCloudPosition(f, f2);
        updateGlowPosition(f, f2);
        this.mWaveCenterX = f;
        this.mWaveCenterY = f2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int resolveMeasured = resolveMeasured(i, suggestedMinimumWidth);
        int resolveMeasured2 = resolveMeasured(i2, suggestedMinimumHeight);
        this.mRingScaleFactor = computeScaleFactor(suggestedMinimumWidth, suggestedMinimumHeight, resolveMeasured, resolveMeasured2);
        computeInsets(resolveMeasured - getScaledSuggestedMinimumWidth(), resolveMeasured2 - getScaledSuggestedMinimumHeight());
        setMeasuredDimension(resolveMeasured, resolveMeasured2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                handleDown(motionEvent);
                handleMove(motionEvent);
                z = true;
                break;
            case 1:
            case 6:
                handleMove(motionEvent);
                handleUp(motionEvent);
                z = true;
                break;
            case 2:
                handleMove(motionEvent);
                z = true;
                break;
            case 3:
                handleMove(motionEvent);
                handleCancel(motionEvent);
                z = true;
                break;
            case 4:
                break;
            default:
                z = false;
                break;
        }
        invalidate();
        if (z) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ping() {
        if (this.mFeedbackCount > 0) {
            AnimationBundle animationBundle = this.mWaveAnimations;
            boolean z = true;
            if (animationBundle.size() > 0) {
                z = true;
                if (animationBundle.get(0).animator.isRunning()) {
                    z = true;
                    if (animationBundle.get(0).animator.getCurrentPlayTime() < 500) {
                        z = false;
                    }
                }
            }
            if (z) {
                startWaveAnimation();
            }
        }
    }

    public boolean replaceTargetDrawablesIfPresent(ComponentName componentName, String str, int i) {
        boolean z;
        if (i == 0) {
            z = false;
        } else {
            boolean z2 = false;
            if (componentName != null) {
                try {
                    PackageManager packageManager = this.mContext.getPackageManager();
                    Bundle bundle = packageManager.getActivityInfo(componentName, 128).metaData;
                    z2 = false;
                    if (bundle != null) {
                        int i2 = bundle.getInt(str);
                        z2 = false;
                        if (i2 != 0) {
                            z2 = replaceTargetDrawables(packageManager.getResourcesForActivity(componentName), i, i2);
                        }
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.w(TAG, "Failed to swap drawable; " + componentName.flattenToShortString() + " not found", e);
                    z2 = false;
                } catch (Resources.NotFoundException e2) {
                    Log.w(TAG, "Failed to swap drawable from " + componentName.flattenToShortString(), e2);
                    z2 = false;
                }
            }
            z = z2;
            if (!z2) {
                replaceTargetDrawables(this.mContext.getResources(), i, i);
                return z2;
            }
        }
        return z;
    }

    public void reset(boolean z) {
        this.mGlowAnimations.stop();
        this.mTargetAnimations.stop();
        startBackgroundAnimation(0, 0.0f);
        stopAndHideWaveAnimation();
        hideTargets(z, false);
        hideGlow(0, 0, 0.0f, null);
        Tweener.reset();
    }

    public void resumeAnimations() {
        this.mWaveAnimations.setSuspended(false);
        this.mTargetAnimations.setSuspended(false);
        this.mGlowAnimations.setSuspended(false);
        this.mWaveAnimations.start();
        this.mTargetAnimations.start();
        this.mGlowAnimations.start();
    }

    public void setDirectionDescriptionsResourceId(int i) {
        this.mDirectionDescriptionsResourceId = i;
        if (this.mDirectionDescriptions != null) {
            this.mDirectionDescriptions.clear();
        }
    }

    public void setEnableTarget(int i, boolean z) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mTargetDrawables.size()) {
                return;
            }
            TargetDrawable targetDrawable = this.mTargetDrawables.get(i3);
            if (targetDrawable.getResourceId() == i) {
                targetDrawable.setEnabled(z);
                return;
            }
            i2 = i3 + 1;
        }
    }

    public void setOnTriggerListener(OnTriggerListener onTriggerListener) {
        this.mOnTriggerListener = onTriggerListener;
    }

    public void setTargetDescriptionsResourceId(int i) {
        this.mTargetDescriptionsResourceId = i;
        if (this.mTargetDescriptions != null) {
            this.mTargetDescriptions.clear();
        }
    }

    public void setTargetResources(int i) {
        if (this.mAnimatingTargets) {
            this.mNewTargetResources = i;
        } else {
            internalSetTargetResources(i);
        }
    }

    public void setVibrateEnabled(boolean z) {
        if (z && this.mVibrator == null) {
            this.mVibrator = (Vibrator) getContext().getSystemService("vibrator");
        } else {
            this.mVibrator = null;
        }
    }

    public void suspendAnimations() {
        this.mWaveAnimations.setSuspended(true);
        this.mTargetAnimations.setSuspended(true);
        this.mGlowAnimations.setSuspended(true);
    }
}
