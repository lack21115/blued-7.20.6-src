package com.android.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.OverScroller;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/ResolverDrawerLayout.class */
public class ResolverDrawerLayout extends ViewGroup {
    private static final String TAG = "ResolverDrawerLayout";
    private int mActivePointerId;
    private float mCollapseOffset;
    private int mCollapsibleHeight;
    private boolean mDismissOnScrollerFinished;
    private float mInitialTouchX;
    private float mInitialTouchY;
    private boolean mIsDragging;
    private float mLastTouchY;
    private int mMaxCollapsedHeight;
    private int mMaxCollapsedHeightSmall;
    private int mMaxWidth;
    private final float mMinFlingVelocity;
    private OnDismissedListener mOnDismissedListener;
    private boolean mOpenOnClick;
    private boolean mOpenOnLayout;
    private RunOnDismissedListener mRunOnDismissedListener;
    private final OverScroller mScroller;
    private boolean mSmallCollapsed;
    private final Rect mTempRect;
    private int mTopOffset;
    private final ViewTreeObserver.OnTouchModeChangeListener mTouchModeChangeListener;
    private final int mTouchSlop;
    private int mUncollapsibleHeight;
    private final VelocityTracker mVelocityTracker;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/ResolverDrawerLayout$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public boolean alwaysShow;
        public boolean ignoreOffset;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ResolverDrawerLayout_LayoutParams);
            this.alwaysShow = obtainStyledAttributes.getBoolean(1, false);
            this.ignoreOffset = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.alwaysShow = layoutParams.alwaysShow;
            this.ignoreOffset = layoutParams.ignoreOffset;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/ResolverDrawerLayout$OnDismissedListener.class */
    public interface OnDismissedListener {
        void onDismissed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/ResolverDrawerLayout$RunOnDismissedListener.class */
    public class RunOnDismissedListener implements Runnable {
        private RunOnDismissedListener() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ResolverDrawerLayout.this.dispatchOnDismissed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/ResolverDrawerLayout$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.android.internal.widget.ResolverDrawerLayout.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean open;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.open = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.open ? 1 : 0);
        }
    }

    public ResolverDrawerLayout(Context context) {
        this(context, null);
    }

    public ResolverDrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResolverDrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mTempRect = new Rect();
        this.mTouchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: com.android.internal.widget.ResolverDrawerLayout.1
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public void onTouchModeChanged(boolean z) {
                if (!z && ResolverDrawerLayout.this.hasFocus() && ResolverDrawerLayout.this.isDescendantClipped(ResolverDrawerLayout.this.getFocusedChild())) {
                    ResolverDrawerLayout.this.smoothScrollTo(0, 0.0f);
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ResolverDrawerLayout, i, 0);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.mMaxCollapsedHeight = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.mMaxCollapsedHeightSmall = obtainStyledAttributes.getDimensionPixelSize(2, this.mMaxCollapsedHeight);
        obtainStyledAttributes.recycle();
        this.mScroller = new OverScroller(context, AnimationUtils.loadInterpolator(context, R.interpolator.decelerate_quint));
        this.mVelocityTracker = VelocityTracker.obtain();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    private void abortAnimation() {
        this.mScroller.abortAnimation();
        this.mRunOnDismissedListener = null;
        this.mDismissOnScrollerFinished = false;
    }

    private float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    private View findChildUnder(float f, float f2) {
        return findChildUnder(this, f, f2);
    }

    private static View findChildUnder(ViewGroup viewGroup, float f, float f2) {
        int childCount = viewGroup.getChildCount();
        while (true) {
            int i = childCount - 1;
            if (i < 0) {
                return null;
            }
            View childAt = viewGroup.getChildAt(i);
            if (isChildUnder(childAt, f, f2)) {
                return childAt;
            }
            childCount = i;
        }
    }

    private View findListChildUnder(float f, float f2) {
        View view;
        View findChildUnder = findChildUnder(f, f2);
        while (true) {
            View view2 = findChildUnder;
            view = view2;
            if (view2 == null) {
                break;
            }
            f -= view2.getX();
            f2 -= view2.getY();
            if (view2 instanceof AbsListView) {
                view = findChildUnder((ViewGroup) view2, f, f2);
                break;
            }
            findChildUnder = view2 instanceof ViewGroup ? findChildUnder((ViewGroup) view2, f, f2) : null;
        }
        return view;
    }

    private int getMaxCollapsedHeight() {
        return isSmallCollapsed() ? this.mMaxCollapsedHeightSmall : this.mMaxCollapsedHeight;
    }

    private static boolean isChildUnder(View view, float f, float f2) {
        float x = view.getX();
        float y = view.getY();
        return f >= x && f2 >= y && f < x + ((float) view.getWidth()) && f2 < y + ((float) view.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDescendantClipped(View view) {
        boolean z = false;
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (view.getParent() != this) {
            ViewParent parent = view.getParent();
            view = view;
            ViewParent viewParent = parent;
            while (true) {
                ViewParent viewParent2 = viewParent;
                if (viewParent2 == this) {
                    break;
                }
                view = (View) viewParent2;
                viewParent = view.getParent();
            }
        }
        int height = getHeight() - getPaddingBottom();
        int childCount = getChildCount();
        int indexOfChild = indexOfChild(view);
        while (true) {
            int i = indexOfChild + 1;
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                height = Math.min(height, childAt.getTop());
            }
            indexOfChild = i;
        }
        if (this.mTempRect.bottom > height) {
            z = true;
        }
        return z;
    }

    private boolean isListChildUnderClipped(float f, float f2) {
        View findListChildUnder = findListChildUnder(f, f2);
        return findListChildUnder != null && isDescendantClipped(findListChildUnder);
    }

    private boolean isMoving() {
        return this.mIsDragging || !this.mScroller.isFinished();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mInitialTouchX = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            this.mActivePointerId = motionEvent.getPointerId(i);
        }
    }

    private float performDrag(float f) {
        float max = Math.max(0.0f, Math.min(this.mCollapseOffset + f, this.mCollapsibleHeight + this.mUncollapsibleHeight));
        if (max != this.mCollapseOffset) {
            float f2 = max - this.mCollapseOffset;
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i2);
                if (!((LayoutParams) childAt.getLayoutParams()).ignoreOffset) {
                    childAt.offsetTopAndBottom((int) f2);
                }
                i = i2 + 1;
            }
            boolean z = this.mCollapseOffset != 0.0f;
            this.mCollapseOffset = max;
            this.mTopOffset = (int) (this.mTopOffset + f2);
            if (z != (max != 0.0f)) {
                notifyViewAccessibilityStateChangedIfNeeded(0);
            }
            postInvalidateOnAnimation();
            return f2;
        }
        return 0.0f;
    }

    private void resetTouch() {
        this.mActivePointerId = -1;
        this.mIsDragging = false;
        this.mOpenOnClick = false;
        this.mLastTouchY = 0.0f;
        this.mInitialTouchY = 0.0f;
        this.mInitialTouchX = 0.0f;
        this.mVelocityTracker.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScrollTo(int i, float f) {
        abortAnimation();
        int i2 = (int) this.mCollapseOffset;
        int i3 = i - i2;
        if (i3 == 0) {
            return;
        }
        int height = getHeight();
        int i4 = height / 2;
        float f2 = i4;
        float f3 = i4;
        float distanceInfluenceForSnapDuration = distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i3) * 1.0f) / height));
        float abs = Math.abs(f);
        this.mScroller.startScroll(0, i2, 0, i3, Math.min(abs > 0.0f ? Math.round(1000.0f * Math.abs((f2 + (f3 * distanceInfluenceForSnapDuration)) / abs)) * 4 : (int) (((Math.abs(i3) / height) + 1.0f) * 100.0f), 300));
        postInvalidateOnAnimation();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller.computeScrollOffset()) {
            boolean z = !this.mScroller.isFinished();
            performDrag(this.mScroller.getCurrY() - this.mCollapseOffset);
            if (z) {
                postInvalidateOnAnimation();
            } else if (!this.mDismissOnScrollerFinished || this.mOnDismissedListener == null) {
            } else {
                this.mRunOnDismissedListener = new RunOnDismissedListener();
                post(this.mRunOnDismissedListener);
            }
        }
    }

    void dispatchOnDismissed() {
        if (this.mOnDismissedListener != null) {
            this.mOnDismissedListener.onDismissed();
        }
        if (this.mRunOnDismissedListener != null) {
            removeCallbacks(this.mRunOnDismissedListener);
            this.mRunOnDismissedListener = null;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public boolean isCollapsed() {
        return this.mCollapseOffset > 0.0f;
    }

    public boolean isSmallCollapsed() {
        return this.mSmallCollapsed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this.mTouchModeChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnTouchModeChangeListener(this.mTouchModeChangeListener);
        abortAnimation();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ResolverDrawerLayout.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ResolverDrawerLayout.class.getName());
        if (!isEnabled() || this.mCollapseOffset == 0.0f) {
            return;
        }
        accessibilityNodeInfo.addAction(4096);
        accessibilityNodeInfo.setScrollable(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0062, code lost:
        if (r6.mOpenOnClick != false) goto L16;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.widget.ResolverDrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int i5 = this.mTopOffset;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= childCount) {
                return;
            }
            View childAt = getChildAt(i7);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8) {
                int i8 = i5 + layoutParams.topMargin;
                int i9 = i8;
                if (layoutParams.ignoreOffset) {
                    i9 = (int) (i8 - this.mCollapseOffset);
                }
                int measuredHeight = i9 + childAt.getMeasuredHeight();
                int measuredWidth = childAt.getMeasuredWidth();
                int i10 = paddingLeft + ((((width - paddingRight) - paddingLeft) - measuredWidth) / 2);
                childAt.layout(i10, i9, i10 + measuredWidth, measuredHeight);
                i5 = measuredHeight + layoutParams.bottomMargin;
            }
            i6 = i7 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = size;
        if (this.mMaxWidth >= 0) {
            i4 = Math.min(size, this.mMaxWidth);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int i6 = paddingTop;
            if (layoutParams.alwaysShow) {
                i6 = paddingTop;
                if (childAt.getVisibility() != 8) {
                    measureChildWithMargins(childAt, makeMeasureSpec, paddingLeft, makeMeasureSpec2, paddingTop);
                    i6 = paddingTop + layoutParams.topMargin + childAt.getMeasuredHeight() + layoutParams.bottomMargin;
                }
            }
            i5++;
            paddingTop = i6;
        }
        int i7 = 0;
        int i8 = paddingTop;
        while (true) {
            i3 = i8;
            if (i7 >= childCount) {
                break;
            }
            View childAt2 = getChildAt(i7);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            i8 = i3;
            if (!layoutParams2.alwaysShow) {
                i8 = i3;
                if (childAt2.getVisibility() != 8) {
                    measureChildWithMargins(childAt2, makeMeasureSpec, paddingLeft, makeMeasureSpec2, i3);
                    i8 = i3 + layoutParams2.topMargin + childAt2.getMeasuredHeight() + layoutParams2.bottomMargin;
                }
            }
            i7++;
        }
        this.mCollapsibleHeight = Math.max(0, (i3 - paddingTop) - getMaxCollapsedHeight());
        this.mUncollapsibleHeight = i3 - this.mCollapsibleHeight;
        if (isLaidOut()) {
            boolean z = this.mCollapseOffset != 0.0f;
            this.mCollapseOffset = Math.min(this.mCollapseOffset, this.mCollapsibleHeight);
            if (z != (this.mCollapseOffset != 0.0f)) {
                notifyViewAccessibilityStateChangedIfNeeded(0);
            }
        } else {
            this.mCollapseOffset = this.mOpenOnLayout ? 0.0f : this.mCollapsibleHeight;
        }
        this.mTopOffset = Math.max(0, size2 - i3) + ((int) this.mCollapseOffset);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int i = 0;
        boolean z2 = false;
        if (!z) {
            z2 = false;
            if (Math.abs(f2) > this.mMinFlingVelocity) {
                if (f2 <= 0.0f) {
                    i = this.mCollapsibleHeight;
                }
                smoothScrollTo(i, f2);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        boolean z = false;
        if (f2 > this.mMinFlingVelocity) {
            z = false;
            if (this.mCollapseOffset != 0.0f) {
                smoothScrollTo(0, f2);
                z = true;
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPrePerformAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.onNestedPrePerformAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (i != 4096 || this.mCollapseOffset == 0.0f) {
            return false;
        }
        smoothScrollTo(0, 0.0f);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            iArr[1] = (int) (-performDrag(-i2));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        if (i4 < 0) {
            performDrag(-i4);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        super.onNestedScrollAccepted(view, view2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mOpenOnLayout = savedState.open;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.open = this.mCollapsibleHeight > 0 && this.mCollapseOffset == 0.0f;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        super.onStopNestedScroll(view);
        if (this.mScroller.isFinished()) {
            smoothScrollTo(this.mCollapseOffset < ((float) (this.mCollapsibleHeight / 2)) ? 0 : this.mCollapsibleHeight, 0.0f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        this.mVelocityTracker.addMovement(motionEvent);
        boolean z = false;
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialTouchX = x;
                this.mLastTouchY = y;
                this.mInitialTouchY = y;
                this.mActivePointerId = motionEvent.getPointerId(0);
                boolean z2 = findChildUnder(this.mInitialTouchX, this.mInitialTouchY) != null;
                z = !(z2 || this.mOnDismissedListener == null) || this.mCollapsibleHeight > 0;
                this.mIsDragging = z2 && z;
                abortAnimation();
                break;
            case 1:
                boolean z3 = this.mIsDragging;
                this.mIsDragging = false;
                if (!z3 && findChildUnder(this.mInitialTouchX, this.mInitialTouchY) == null && findChildUnder(motionEvent.getX(), motionEvent.getY()) == null && this.mOnDismissedListener != null) {
                    dispatchOnDismissed();
                    resetTouch();
                    return true;
                } else if (this.mOpenOnClick && Math.abs(motionEvent.getX() - this.mInitialTouchX) < this.mTouchSlop && Math.abs(motionEvent.getY() - this.mInitialTouchY) < this.mTouchSlop) {
                    smoothScrollTo(0, 0.0f);
                    return true;
                } else {
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                    if (Math.abs(yVelocity) <= this.mMinFlingVelocity) {
                        smoothScrollTo(this.mCollapseOffset < ((float) (this.mCollapsibleHeight / 2)) ? 0 : this.mCollapsibleHeight, 0.0f);
                    } else if (this.mOnDismissedListener == null || yVelocity <= 0.0f || this.mCollapseOffset <= this.mCollapsibleHeight) {
                        smoothScrollTo(yVelocity < 0.0f ? 0 : this.mCollapsibleHeight, yVelocity);
                    } else {
                        smoothScrollTo(this.mCollapsibleHeight + this.mUncollapsibleHeight, yVelocity);
                        this.mDismissOnScrollerFinished = true;
                    }
                    resetTouch();
                    z = false;
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                int i = findPointerIndex;
                if (findPointerIndex < 0) {
                    Log.e(TAG, "Bad pointer id " + this.mActivePointerId + ", resetting");
                    i = 0;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    this.mInitialTouchX = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    this.mLastTouchY = y2;
                    this.mInitialTouchY = y2;
                }
                float x2 = motionEvent.getX(i);
                float y3 = motionEvent.getY(i);
                z = false;
                if (!this.mIsDragging) {
                    float f = y3 - this.mInitialTouchY;
                    z = false;
                    if (Math.abs(f) > this.mTouchSlop) {
                        z = false;
                        if (findChildUnder(x2, y3) != null) {
                            z = true;
                            this.mIsDragging = true;
                            this.mLastTouchY = Math.max(this.mLastTouchY - this.mTouchSlop, Math.min(this.mLastTouchY + f, this.mLastTouchY + this.mTouchSlop));
                        }
                    }
                }
                if (this.mIsDragging) {
                    performDrag(y3 - this.mLastTouchY);
                }
                this.mLastTouchY = y3;
                break;
            case 3:
                if (this.mIsDragging) {
                    smoothScrollTo(this.mCollapseOffset < ((float) (this.mCollapsibleHeight / 2)) ? 0 : this.mCollapsibleHeight, 0.0f);
                }
                resetTouch();
                return true;
            case 4:
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                this.mInitialTouchX = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                this.mLastTouchY = y4;
                this.mInitialTouchY = y4;
                z = false;
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                z = false;
                break;
            default:
                z = false;
                break;
        }
        return z;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (i != 4096 || this.mCollapseOffset == 0.0f) {
            return false;
        }
        smoothScrollTo(0, 0.0f);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || !isDescendantClipped(view2)) {
            return;
        }
        smoothScrollTo(0, 0.0f);
    }

    public void setOnDismissedListener(OnDismissedListener onDismissedListener) {
        this.mOnDismissedListener = onDismissedListener;
    }

    public void setSmallCollapsed(boolean z) {
        this.mSmallCollapsed = z;
        requestLayout();
    }
}
