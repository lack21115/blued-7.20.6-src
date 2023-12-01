package com.android.internal.widget;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/SwipeDismissLayout.class */
public class SwipeDismissLayout extends FrameLayout {
    private static final float DISMISS_MIN_DRAG_WIDTH_RATIO = 0.33f;
    private static final String TAG = "SwipeDismissLayout";
    private int mActiveTouchId;
    private long mAnimationTime;
    private TimeInterpolator mCancelInterpolator;
    private boolean mDiscardIntercept;
    private TimeInterpolator mDismissInterpolator;
    private boolean mDismissed;
    private OnDismissedListener mDismissedListener;
    private float mDownX;
    private float mDownY;
    private float mLastX;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private ViewTreeObserver.OnEnterAnimationCompleteListener mOnEnterAnimationCompleteListener;
    private OnSwipeProgressChangedListener mProgressListener;
    private int mSlop;
    private boolean mSwiping;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/SwipeDismissLayout$OnDismissedListener.class */
    public interface OnDismissedListener {
        void onDismissed(SwipeDismissLayout swipeDismissLayout);
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/SwipeDismissLayout$OnSwipeProgressChangedListener.class */
    public interface OnSwipeProgressChangedListener {
        void onSwipeCancelled(SwipeDismissLayout swipeDismissLayout);

        void onSwipeProgressChanged(SwipeDismissLayout swipeDismissLayout, float f, float f2);
    }

    public SwipeDismissLayout(Context context) {
        super(context);
        this.mOnEnterAnimationCompleteListener = new ViewTreeObserver.OnEnterAnimationCompleteListener() { // from class: com.android.internal.widget.SwipeDismissLayout.1
            @Override // android.view.ViewTreeObserver.OnEnterAnimationCompleteListener
            public void onEnterAnimationComplete() {
                if (SwipeDismissLayout.this.getContext() instanceof Activity) {
                    ((Activity) SwipeDismissLayout.this.getContext()).convertFromTranslucent();
                }
            }
        };
        init(context);
    }

    public SwipeDismissLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnEnterAnimationCompleteListener = new ViewTreeObserver.OnEnterAnimationCompleteListener() { // from class: com.android.internal.widget.SwipeDismissLayout.1
            @Override // android.view.ViewTreeObserver.OnEnterAnimationCompleteListener
            public void onEnterAnimationComplete() {
                if (SwipeDismissLayout.this.getContext() instanceof Activity) {
                    ((Activity) SwipeDismissLayout.this.getContext()).convertFromTranslucent();
                }
            }
        };
        init(context);
    }

    public SwipeDismissLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnEnterAnimationCompleteListener = new ViewTreeObserver.OnEnterAnimationCompleteListener() { // from class: com.android.internal.widget.SwipeDismissLayout.1
            @Override // android.view.ViewTreeObserver.OnEnterAnimationCompleteListener
            public void onEnterAnimationComplete() {
                if (SwipeDismissLayout.this.getContext() instanceof Activity) {
                    ((Activity) SwipeDismissLayout.this.getContext()).convertFromTranslucent();
                }
            }
        };
        init(context);
    }

    private void dismiss() {
        if (this.mDismissedListener != null) {
            this.mDismissedListener.onDismissed(this);
        }
    }

    private void init(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mAnimationTime = getContext().getResources().getInteger(17694720);
        this.mCancelInterpolator = new DecelerateInterpolator(1.5f);
        this.mDismissInterpolator = new AccelerateInterpolator(1.5f);
    }

    private void resetMembers() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
        }
        this.mVelocityTracker = null;
        this.mTranslationX = 0.0f;
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mSwiping = false;
        this.mDismissed = false;
        this.mDiscardIntercept = false;
    }

    private void setProgress(float f) {
        this.mTranslationX = f;
        if (this.mProgressListener == null || f < 0.0f) {
            return;
        }
        this.mProgressListener.onSwipeProgressChanged(this, f / getWidth(), f);
    }

    private void updateDismiss(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - this.mDownX;
        if (!this.mDismissed) {
            this.mVelocityTracker.addMovement(motionEvent);
            this.mVelocityTracker.computeCurrentVelocity(1000);
            if (rawX > getWidth() * DISMISS_MIN_DRAG_WIDTH_RATIO && motionEvent.getRawX() >= this.mLastX) {
                this.mDismissed = true;
            }
        }
        if (this.mDismissed && this.mSwiping && rawX < getWidth() * DISMISS_MIN_DRAG_WIDTH_RATIO) {
            this.mDismissed = false;
        }
    }

    private void updateSwiping(MotionEvent motionEvent) {
        if (this.mSwiping) {
            return;
        }
        float rawX = motionEvent.getRawX() - this.mDownX;
        float rawY = motionEvent.getRawY() - this.mDownY;
        if ((rawX * rawX) + (rawY * rawY) <= this.mSlop * this.mSlop) {
            this.mSwiping = false;
            return;
        }
        boolean z = false;
        if (rawX > this.mSlop * 2) {
            z = false;
            if (Math.abs(rawY) < this.mSlop * 2) {
                z = true;
            }
        }
        this.mSwiping = z;
    }

    protected boolean canScroll(View view, boolean z, float f, float f2, float f3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            int childCount = viewGroup.getChildCount();
            while (true) {
                int i = childCount - 1;
                if (i < 0) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i);
                if (scrollX + f2 >= childAt.getLeft() && scrollX + f2 < childAt.getRight() && scrollY + f3 >= childAt.getTop() && scrollY + f3 < childAt.getBottom() && canScroll(childAt, true, f, (scrollX + f2) - childAt.getLeft(), (scrollY + f3) - childAt.getTop())) {
                    return true;
                }
                childCount = i;
            }
        }
        return z && view.canScrollHorizontally((int) (-f));
    }

    protected void cancel() {
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).convertFromTranslucent();
        }
        if (this.mProgressListener != null) {
            this.mProgressListener.onSwipeCancelled(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getContext() instanceof Activity) {
            getViewTreeObserver().addOnEnterAnimationCompleteListener(this.mOnEnterAnimationCompleteListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getContext() instanceof Activity) {
            getViewTreeObserver().removeOnEnterAnimationCompleteListener(this.mOnEnterAnimationCompleteListener);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        motionEvent.offsetLocation(this.mTranslationX, 0.0f);
        switch (motionEvent.getActionMasked()) {
            case 0:
                resetMembers();
                this.mDownX = motionEvent.getRawX();
                this.mDownY = motionEvent.getRawY();
                this.mActiveTouchId = motionEvent.getPointerId(0);
                this.mVelocityTracker = VelocityTracker.obtain();
                this.mVelocityTracker.addMovement(motionEvent);
                break;
            case 1:
            case 3:
                resetMembers();
                break;
            case 2:
                if (this.mVelocityTracker != null && !this.mDiscardIntercept) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActiveTouchId);
                    if (findPointerIndex != -1) {
                        float rawX = motionEvent.getRawX() - this.mDownX;
                        float x = motionEvent.getX(findPointerIndex);
                        float y = motionEvent.getY(findPointerIndex);
                        if (rawX != 0.0f && canScroll(this, false, rawX, x, y)) {
                            this.mDiscardIntercept = true;
                            break;
                        } else {
                            updateSwiping(motionEvent);
                            break;
                        }
                    } else {
                        Log.e(TAG, "Invalid pointer index: ignoring.");
                        this.mDiscardIntercept = true;
                        break;
                    }
                }
                break;
            case 5:
                this.mActiveTouchId = motionEvent.getPointerId(motionEvent.getActionIndex());
                break;
            case 6:
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex) == this.mActiveTouchId) {
                    this.mActiveTouchId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                    break;
                }
                break;
        }
        return !this.mDiscardIntercept && this.mSwiping;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getActionMasked()) {
            case 1:
                updateDismiss(motionEvent);
                if (this.mDismissed) {
                    dismiss();
                } else if (this.mSwiping) {
                    cancel();
                }
                resetMembers();
                return true;
            case 2:
                this.mVelocityTracker.addMovement(motionEvent);
                this.mLastX = motionEvent.getRawX();
                updateSwiping(motionEvent);
                if (this.mSwiping) {
                    if (getContext() instanceof Activity) {
                        ((Activity) getContext()).convertToTranslucent(null, null);
                    }
                    setProgress(motionEvent.getRawX() - this.mDownX);
                    return true;
                }
                return true;
            case 3:
                cancel();
                resetMembers();
                return true;
            default:
                return true;
        }
    }

    public void setOnDismissedListener(OnDismissedListener onDismissedListener) {
        this.mDismissedListener = onDismissedListener;
    }

    public void setOnSwipeProgressChangedListener(OnSwipeProgressChangedListener onSwipeProgressChangedListener) {
        this.mProgressListener = onSwipeProgressChangedListener;
    }
}
