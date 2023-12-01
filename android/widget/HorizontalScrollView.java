package android.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.alipay.sdk.util.i;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:android/widget/HorizontalScrollView.class */
public class HorizontalScrollView extends FrameLayout {
    private static final int ANIMATED_SCROLL_GAP = 250;
    private static final int INVALID_POINTER = -1;
    private static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final String TAG = "HorizontalScrollView";
    private int mActivePointerId;
    private View mChildToScrollTo;
    private EdgeEffect mEdgeGlowLeft;
    private EdgeEffect mEdgeGlowRight;
    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLayoutDirty;
    private int mLastMotionX;
    private long mLastScroll;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private SavedState mSavedState;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/HorizontalScrollView$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.HorizontalScrollView.SavedState.1
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
        public boolean isLayoutRtl;
        public int scrollPosition;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
            this.isLayoutRtl = parcel.readInt() == 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + " isLayoutRtl=" + this.isLayoutRtl + i.d;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.scrollPosition);
            parcel.writeInt(this.isLayoutRtl ? 1 : 0);
        }
    }

    public HorizontalScrollView(Context context) {
        this(context, null);
    }

    public HorizontalScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843603);
    }

    public HorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public HorizontalScrollView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        initScrollView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalScrollView, i, i2);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
    }

    private boolean canScroll() {
        View childAt = getChildAt(0);
        boolean z = false;
        if (childAt != null) {
            z = false;
            if (getWidth() < this.mPaddingLeft + childAt.getWidth() + this.mPaddingRight) {
                z = true;
            }
        }
        return z;
    }

    private static int clamp(int i, int i2, int i3) {
        int i4;
        if (i2 >= i3 || i < 0) {
            i4 = 0;
        } else {
            i4 = i;
            if (i2 + i > i3) {
                return i3 - i2;
            }
        }
        return i4;
    }

    private void doScrollX(int i) {
        if (i != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(i, 0);
            } else {
                scrollBy(i, 0);
            }
        }
    }

    private View findFocusableViewInBounds(boolean z, int i, int i2) {
        ArrayList<View> focusables = getFocusables(2);
        View view = null;
        boolean z2 = false;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2 = focusables.get(i3);
            int left = view2.getLeft();
            int right = view2.getRight();
            View view3 = view;
            boolean z3 = z2;
            if (i < right) {
                view3 = view;
                z3 = z2;
                if (left < i2) {
                    boolean z4 = i < left && right < i2;
                    if (view == null) {
                        view3 = view2;
                        z3 = z4;
                    } else {
                        boolean z5 = (z && left < view.getLeft()) || (!z && right > view.getRight());
                        if (z2) {
                            view3 = view;
                            z3 = z2;
                            if (z4) {
                                view3 = view;
                                z3 = z2;
                                if (z5) {
                                    view3 = view2;
                                    z3 = z2;
                                }
                            }
                        } else if (z4) {
                            view3 = view2;
                            z3 = true;
                        } else {
                            view3 = view;
                            z3 = z2;
                            if (z5) {
                                view3 = view2;
                                z3 = z2;
                            }
                        }
                    }
                }
            }
            i3++;
            view = view3;
            z2 = z3;
        }
        return view;
    }

    private View findFocusableViewInMyBounds(boolean z, int i, View view) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        int i2 = i + horizontalFadingEdgeLength;
        int width = (getWidth() + i) - horizontalFadingEdgeLength;
        return (view == null || view.getLeft() >= width || view.getRight() <= i2) ? findFocusableViewInBounds(z, i2, width) : view;
    }

    private int getScrollRange() {
        int i = 0;
        if (getChildCount() > 0) {
            i = Math.max(0, getChildAt(0).getWidth() - ((getWidth() - this.mPaddingLeft) - this.mPaddingRight));
        }
        return i;
    }

    private boolean inChild(int i, int i2) {
        boolean z = false;
        if (getChildCount() > 0) {
            int i3 = this.mScrollX;
            View childAt = getChildAt(0);
            z = false;
            if (i2 >= childAt.getTop()) {
                z = false;
                if (i2 < childAt.getBottom()) {
                    z = false;
                    if (i >= childAt.getLeft() - i3) {
                        z = false;
                        if (i < childAt.getRight() - i3) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    private void initOrResetVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.mContext);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mOverscrollDistance = viewConfiguration.getScaledOverscrollDistance();
        this.mOverflingDistance = viewConfiguration.getScaledOverflingDistance();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isOffScreen(View view) {
        boolean z = false;
        if (!isWithinDeltaOfScreen(view, 0)) {
            z = true;
        }
        return z;
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && isViewDescendantOf((View) parent, view2);
    }

    private boolean isWithinDeltaOfScreen(View view, int i) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return this.mTempRect.right + i >= getScrollX() && this.mTempRect.left - i <= getScrollX() + getWidth();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i = action == 0 ? 1 : 0;
            this.mLastMotionX = (int) motionEvent.getX(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private boolean scrollAndFocus(int i, int i2, int i3) {
        boolean z;
        int width = getWidth();
        int scrollX = getScrollX();
        int i4 = scrollX + width;
        boolean z2 = i == 17;
        View findFocusableViewInBounds = findFocusableViewInBounds(z2, i2, i3);
        View view = findFocusableViewInBounds;
        if (findFocusableViewInBounds == null) {
            view = this;
        }
        if (i2 < scrollX || i3 > i4) {
            doScrollX(z2 ? i2 - scrollX : i3 - i4);
            z = true;
        } else {
            z = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(computeScrollDeltaToGetChildRectOnScreen, 0);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z) {
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (!z) {
                smoothScrollBy(computeScrollDeltaToGetChildRectOnScreen, 0);
                return z2;
            }
            scrollBy(computeScrollDeltaToGetChildRectOnScreen, 0);
        }
        return z2;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public boolean arrowScroll(int i) {
        int i2;
        boolean z = false;
        View findFocus = findFocus();
        View view = findFocus;
        if (findFocus == this) {
            view = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !isWithinDeltaOfScreen(findNextFocus, maxScrollAmount)) {
            if (i != 17 || getScrollX() >= maxScrollAmount) {
                i2 = maxScrollAmount;
                if (i == 66) {
                    i2 = maxScrollAmount;
                    if (getChildCount() > 0) {
                        int right = getChildAt(0).getRight();
                        int scrollX = getScrollX() + getWidth();
                        i2 = maxScrollAmount;
                        if (right - scrollX < maxScrollAmount) {
                            i2 = right - scrollX;
                        }
                    }
                }
            } else {
                i2 = getScrollX();
            }
            if (i2 != 0) {
                if (i != 66) {
                    i2 = -i2;
                }
                doScrollX(i2);
            }
            return z;
        }
        findNextFocus.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
        doScrollX(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        findNextFocus.requestFocus(i);
        if (view != null && view.isFocused() && isOffScreen(view)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        z = true;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return Math.max(0, super.computeHorizontalScrollOffset());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        int i;
        int childCount = getChildCount();
        int width = (getWidth() - this.mPaddingLeft) - this.mPaddingRight;
        if (childCount == 0) {
            return width;
        }
        int right = getChildAt(0).getRight();
        int i2 = this.mScrollX;
        int max = Math.max(0, right - width);
        if (i2 < 0) {
            i = right - i2;
        } else {
            i = right;
            if (i2 > max) {
                i = right + (i2 - max);
            }
        }
        return i;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int i = this.mScrollX;
            int i2 = this.mScrollY;
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (i != currX || i2 != currY) {
                int scrollRange = getScrollRange();
                int overScrollMode = getOverScrollMode();
                boolean z = true;
                if (overScrollMode != 0) {
                    z = overScrollMode == 1 && scrollRange > 0;
                }
                overScrollBy(currX - i, currY - i2, i, i2, scrollRange, 0, this.mOverflingDistance, 0, false);
                onScrollChanged(this.mScrollX, this.mScrollY, i, i2);
                if (z) {
                    if (currX < 0 && i >= 0) {
                        this.mEdgeGlowLeft.onAbsorb((int) this.mScroller.getCurrVelocity());
                    } else if (currX > scrollRange && i <= scrollRange) {
                        this.mEdgeGlowRight.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                }
            }
            if (awakenScrollBars()) {
                return;
            }
            postInvalidateOnAnimation();
        }
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int width = getWidth();
        int scrollX = getScrollX();
        int i = scrollX + width;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i2 = scrollX;
        if (rect.left > 0) {
            i2 = scrollX + horizontalFadingEdgeLength;
        }
        int i3 = i;
        if (rect.right < getChildAt(0).getWidth()) {
            i3 = i - horizontalFadingEdgeLength;
        }
        if (rect.right > i3 && rect.left > i2) {
            return Math.min(rect.width() > width ? 0 + (rect.left - i2) : 0 + (rect.right - i3), getChildAt(0).getRight() - i3);
        } else if (rect.left >= i2 || rect.right >= i3) {
            return 0;
        } else {
            return Math.max(rect.width() > width ? 0 - (i3 - rect.right) : 0 - (i2 - rect.left), -getScrollX());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mEdgeGlowLeft != null) {
            int i = this.mScrollX;
            if (!this.mEdgeGlowLeft.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - this.mPaddingTop) - this.mPaddingBottom;
                canvas.rotate(270.0f);
                canvas.translate((-height) + this.mPaddingTop, Math.min(0, i));
                this.mEdgeGlowLeft.setSize(height, getWidth());
                if (this.mEdgeGlowLeft.draw(canvas)) {
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(save);
            }
            if (this.mEdgeGlowRight.isFinished()) {
                return;
            }
            int save2 = canvas.save();
            int width = getWidth();
            int height2 = getHeight();
            int i2 = this.mPaddingTop;
            int i3 = this.mPaddingBottom;
            canvas.rotate(90.0f);
            canvas.translate(-this.mPaddingTop, -(Math.max(getScrollRange(), i) + width));
            this.mEdgeGlowRight.setSize((height2 - i2) - i3, width);
            if (this.mEdgeGlowRight.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save2);
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        if (!canScroll()) {
            boolean z = false;
            if (isFocused()) {
                View findFocus = findFocus();
                View view = findFocus;
                if (findFocus == this) {
                    view = null;
                }
                View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, 66);
                z = false;
                if (findNextFocus != null) {
                    z = false;
                    if (findNextFocus != this) {
                        z = false;
                        if (findNextFocus.requestFocus(66)) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
        boolean z2 = false;
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 21:
                    if (!keyEvent.isAltPressed()) {
                        z2 = arrowScroll(17);
                        break;
                    } else {
                        z2 = fullScroll(17);
                        break;
                    }
                case 22:
                    if (!keyEvent.isAltPressed()) {
                        z2 = arrowScroll(66);
                        break;
                    } else {
                        z2 = fullScroll(66);
                        break;
                    }
                case 62:
                    pageScroll(keyEvent.isShiftPressed() ? 17 : 66);
                    z2 = false;
                    break;
                default:
                    z2 = false;
                    break;
            }
        }
        return z2;
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            int width = (getWidth() - this.mPaddingRight) - this.mPaddingLeft;
            this.mScroller.fling(this.mScrollX, this.mScrollY, i, 0, 0, Math.max(0, getChildAt(0).getWidth() - width), 0, 0, width / 2, 0);
            boolean z = i > 0;
            View findFocus = findFocus();
            View findFocusableViewInMyBounds = findFocusableViewInMyBounds(z, this.mScroller.getFinalX(), findFocus);
            View view = findFocusableViewInMyBounds;
            if (findFocusableViewInMyBounds == null) {
                view = this;
            }
            if (view != findFocus) {
                view.requestFocus(z ? 66 : 17);
            }
            postInvalidateOnAnimation();
        }
    }

    public boolean fullScroll(int i) {
        boolean z = i == 66;
        int width = getWidth();
        this.mTempRect.left = 0;
        this.mTempRect.right = width;
        if (z && getChildCount() > 0) {
            this.mTempRect.right = getChildAt(0).getRight();
            this.mTempRect.left = this.mTempRect.right - width;
        }
        return scrollAndFocus(i, this.mTempRect.left, this.mTempRect.right);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.mScrollX < horizontalFadingEdgeLength) {
            return this.mScrollX / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * (this.mRight - this.mLeft));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int right = (getChildAt(0).getRight() - this.mScrollX) - (getWidth() - this.mPaddingRight);
        if (right < horizontalFadingEdgeLength) {
            return right / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void measureChild(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), getChildMeasureSpec(i2, this.mPaddingTop + this.mPaddingBottom, view.getLayoutParams().height));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, 0), getChildMeasureSpec(i3, this.mPaddingTop + this.mPaddingBottom + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i;
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (!this.mIsBeingDragged) {
                        float axisValue = (motionEvent.getMetaState() & 1) != 0 ? -motionEvent.getAxisValue(9) : motionEvent.getAxisValue(10);
                        if (axisValue != 0.0f) {
                            int horizontalScrollFactor = (int) (getHorizontalScrollFactor() * axisValue);
                            int scrollRange = getScrollRange();
                            int i2 = this.mScrollX;
                            int i3 = i2 + horizontalScrollFactor;
                            if (i3 < 0) {
                                i = 0;
                            } else {
                                i = i3;
                                if (i3 > scrollRange) {
                                    i = scrollRange;
                                }
                            }
                            if (i != i2) {
                                super.scrollTo(i, this.mScrollY);
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(HorizontalScrollView.class.getName());
        accessibilityEvent.setScrollable(getScrollRange() > 0);
        accessibilityEvent.setScrollX(this.mScrollX);
        accessibilityEvent.setScrollY(this.mScrollY);
        accessibilityEvent.setMaxScrollX(getScrollRange());
        accessibilityEvent.setMaxScrollY(this.mScrollY);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(HorizontalScrollView.class.getName());
        int scrollRange = getScrollRange();
        if (scrollRange > 0) {
            accessibilityNodeInfo.setScrollable(true);
            if (isEnabled() && this.mScrollX > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (!isEnabled() || this.mScrollX >= scrollRange) {
                return;
            }
            accessibilityNodeInfo.addAction(4096);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (action & 255) {
            case 0:
                int x = (int) motionEvent.getX();
                if (!inChild(x, (int) motionEvent.getY())) {
                    this.mIsBeingDragged = false;
                    recycleVelocityTracker();
                    break;
                } else {
                    this.mLastMotionX = x;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(motionEvent);
                    if (!this.mScroller.isFinished()) {
                        z = true;
                    }
                    this.mIsBeingDragged = z;
                    break;
                }
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mScroller.springBack(this.mScrollX, this.mScrollY, 0, getScrollRange(), 0, 0)) {
                    postInvalidateOnAnimation();
                    break;
                }
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex != -1) {
                        int x2 = (int) motionEvent.getX(findPointerIndex);
                        if (Math.abs(x2 - this.mLastMotionX) > this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionX = x2;
                            initVelocityTrackerIfNotExists();
                            this.mVelocityTracker.addMovement(motionEvent);
                            if (this.mParent != null) {
                                this.mParent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    } else {
                        Log.e(TAG, "Invalid pointerId=" + i + " in onInterceptTouchEvent");
                        break;
                    }
                }
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.mLastMotionX = (int) motionEvent.getX(actionIndex);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionX = (int) motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                break;
        }
        return this.mIsBeingDragged;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        if (getChildCount() > 0) {
            i5 = getChildAt(0).getMeasuredWidth();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getChildAt(0).getLayoutParams();
            i6 = layoutParams.leftMargin + layoutParams.rightMargin;
        }
        layoutChildren(i, i2, i3, i4, i5 > (((i3 - i) - getPaddingLeftWithForeground()) - getPaddingRightWithForeground()) - i6);
        this.mIsLayoutDirty = false;
        if (this.mChildToScrollTo != null && isViewDescendantOf(this.mChildToScrollTo, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!isLaidOut()) {
            int max = Math.max(0, i5 - (((i3 - i) - this.mPaddingLeft) - this.mPaddingRight));
            if (this.mSavedState != null) {
                if (isLayoutRtl() == this.mSavedState.isLayoutRtl) {
                    this.mScrollX = this.mSavedState.scrollPosition;
                } else {
                    this.mScrollX = max - this.mSavedState.scrollPosition;
                }
                this.mSavedState = null;
            } else if (isLayoutRtl()) {
                this.mScrollX = max - this.mScrollX;
            }
            if (this.mScrollX > max) {
                this.mScrollX = max;
            } else if (this.mScrollX < 0) {
                this.mScrollX = 0;
            }
        }
        scrollTo(this.mScrollX, this.mScrollY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mFillViewport && View.MeasureSpec.getMode(i) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredWidth = getMeasuredWidth();
            if (childAt.getMeasuredWidth() < measuredWidth) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec((measuredWidth - this.mPaddingLeft) - this.mPaddingRight, 1073741824), getChildMeasureSpec(i2, this.mPaddingTop + this.mPaddingBottom, ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height));
            }
        }
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.mScroller.isFinished()) {
            super.scrollTo(i, i2);
        } else {
            int i3 = this.mScrollX;
            int i4 = this.mScrollY;
            this.mScrollX = i;
            this.mScrollY = i2;
            invalidateParentIfNeeded();
            onScrollChanged(this.mScrollX, this.mScrollY, i3, i4);
            if (z) {
                this.mScroller.springBack(this.mScrollX, this.mScrollY, 0, getScrollRange(), 0, 0);
            }
        }
        awakenScrollBars();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        if (i == 2) {
            i2 = 66;
        } else {
            i2 = i;
            if (i == 1) {
                i2 = 17;
            }
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i2) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        if (findNextFocus == null || isOffScreen(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i2, rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (this.mContext.getApplicationInfo().targetSdkVersion <= 18) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSavedState = savedState;
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        if (this.mContext.getApplicationInfo().targetSdkVersion <= 18) {
            return super.onSaveInstanceState();
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = this.mScrollX;
        savedState.isLayoutRtl = isLayoutRtl();
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !isWithinDeltaOfScreen(findFocus, this.mRight - this.mLeft)) {
            return;
        }
        findFocus.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
        doScrollX(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (getChildCount() == 0) {
                    return false;
                }
                boolean z = !this.mScroller.isFinished();
                this.mIsBeingDragged = z;
                if (z && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                this.mLastMotionX = (int) motionEvent.getX();
                this.mActivePointerId = motionEvent.getPointerId(0);
                return true;
            case 1:
                if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                    if (getChildCount() > 0) {
                        if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                            fling(-xVelocity);
                        } else if (this.mScroller.springBack(this.mScrollX, this.mScrollY, 0, getScrollRange(), 0, 0)) {
                            postInvalidateOnAnimation();
                        }
                    }
                    this.mActivePointerId = -1;
                    this.mIsBeingDragged = false;
                    recycleVelocityTracker();
                    if (this.mEdgeGlowLeft != null) {
                        this.mEdgeGlowLeft.onRelease();
                        this.mEdgeGlowRight.onRelease();
                        return true;
                    }
                    return true;
                }
                return true;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex == -1) {
                    Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                    return true;
                }
                int x = (int) motionEvent.getX(findPointerIndex);
                int i = this.mLastMotionX - x;
                int i2 = i;
                if (!this.mIsBeingDragged) {
                    i2 = i;
                    if (Math.abs(i) > this.mTouchSlop) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.mIsBeingDragged = true;
                        i2 = i > 0 ? i - this.mTouchSlop : i + this.mTouchSlop;
                    }
                }
                if (this.mIsBeingDragged) {
                    this.mLastMotionX = x;
                    int i3 = this.mScrollX;
                    int i4 = this.mScrollY;
                    int scrollRange = getScrollRange();
                    int overScrollMode = getOverScrollMode();
                    boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                    if (overScrollBy(i2, 0, this.mScrollX, 0, scrollRange, 0, this.mOverscrollDistance, 0, true)) {
                        this.mVelocityTracker.clear();
                    }
                    if (z2) {
                        int i5 = i3 + i2;
                        if (i5 < 0) {
                            this.mEdgeGlowLeft.onPull(i2 / getWidth(), 1.0f - (motionEvent.getY(findPointerIndex) / getHeight()));
                            if (!this.mEdgeGlowRight.isFinished()) {
                                this.mEdgeGlowRight.onRelease();
                            }
                        } else if (i5 > scrollRange) {
                            this.mEdgeGlowRight.onPull(i2 / getWidth(), motionEvent.getY(findPointerIndex) / getHeight());
                            if (!this.mEdgeGlowLeft.isFinished()) {
                                this.mEdgeGlowLeft.onRelease();
                            }
                        }
                        if (this.mEdgeGlowLeft != null) {
                            if (this.mEdgeGlowLeft.isFinished() && this.mEdgeGlowRight.isFinished()) {
                                return true;
                            }
                            postInvalidateOnAnimation();
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return true;
            case 3:
                if (!this.mIsBeingDragged || getChildCount() <= 0) {
                    return true;
                }
                if (this.mScroller.springBack(this.mScrollX, this.mScrollY, 0, getScrollRange(), 0, 0)) {
                    postInvalidateOnAnimation();
                }
                this.mActivePointerId = -1;
                this.mIsBeingDragged = false;
                recycleVelocityTracker();
                if (this.mEdgeGlowLeft != null) {
                    this.mEdgeGlowLeft.onRelease();
                    this.mEdgeGlowRight.onRelease();
                    return true;
                }
                return true;
            case 4:
            case 5:
            default:
                return true;
            case 6:
                onSecondaryPointerUp(motionEvent);
                return true;
        }
    }

    public boolean pageScroll(int i) {
        boolean z = i == 66;
        int width = getWidth();
        if (z) {
            this.mTempRect.left = getScrollX() + width;
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                if (this.mTempRect.left + width > childAt.getRight()) {
                    this.mTempRect.left = childAt.getRight() - width;
                }
            }
        } else {
            this.mTempRect.left = getScrollX() - width;
            if (this.mTempRect.left < 0) {
                this.mTempRect.left = 0;
            }
        }
        this.mTempRect.right = this.mTempRect.left + width;
        return scrollAndFocus(i, this.mTempRect.left, this.mTempRect.right);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (isEnabled()) {
                    int width = getWidth();
                    int i2 = this.mPaddingLeft;
                    int min = Math.min(this.mScrollX + ((width - i2) - this.mPaddingRight), getScrollRange());
                    if (min != this.mScrollX) {
                        smoothScrollTo(min, 0);
                        return true;
                    }
                    return false;
                }
                return false;
            case 8192:
                if (isEnabled()) {
                    int width2 = getWidth();
                    int i3 = this.mPaddingLeft;
                    int max = Math.max(0, this.mScrollX - ((width2 - i3) - this.mPaddingRight));
                    if (max != this.mScrollX) {
                        smoothScrollTo(max, 0);
                        return true;
                    }
                    return false;
                }
                return false;
            default:
                return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.mIsLayoutDirty) {
            this.mChildToScrollTo = view2;
        } else {
            scrollToChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int clamp = clamp(i, (getWidth() - this.mPaddingRight) - this.mPaddingLeft, childAt.getWidth());
            int clamp2 = clamp(i2, (getHeight() - this.mPaddingBottom) - this.mPaddingTop, childAt.getHeight());
            if (clamp == this.mScrollX && clamp2 == this.mScrollY) {
                return;
            }
            super.scrollTo(clamp, clamp2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.mFillViewport) {
            this.mFillViewport = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        if (i == 2) {
            this.mEdgeGlowLeft = null;
            this.mEdgeGlowRight = null;
        } else if (this.mEdgeGlowLeft == null) {
            Context context = getContext();
            this.mEdgeGlowLeft = new EdgeEffect(context);
            this.mEdgeGlowRight = new EdgeEffect(context);
        }
        super.setOverScrollMode(i);
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.mSmoothScrollingEnabled = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i, int i2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            int width = getWidth();
            int i3 = this.mPaddingRight;
            int max = Math.max(0, getChildAt(0).getWidth() - ((width - i3) - this.mPaddingLeft));
            int i4 = this.mScrollX;
            this.mScroller.startScroll(i4, this.mScrollY, Math.max(0, Math.min(i4 + i, max)) - i4, 0);
            postInvalidateOnAnimation();
        } else {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            scrollBy(i, i2);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void smoothScrollTo(int i, int i2) {
        smoothScrollBy(i - this.mScrollX, i2 - this.mScrollY);
    }
}
