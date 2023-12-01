package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import com.android.internal.R;
import java.net.HttpURLConnection;

@Deprecated
/* loaded from: source-4181928-dex2jar.jar:android/widget/Gallery.class */
public class Gallery extends AbsSpinner implements GestureDetector.OnGestureListener {
    private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
    private static final String TAG = "Gallery";
    private static final boolean localLOGV = false;
    private int mAnimationDuration;
    private AdapterView.AdapterContextMenuInfo mContextMenuInfo;
    private Runnable mDisableSuppressSelectionChangedRunnable;
    private int mDownTouchPosition;
    private View mDownTouchView;
    private FlingRunnable mFlingRunnable;
    private GestureDetector mGestureDetector;
    private int mGravity;
    private boolean mIsFirstScroll;
    private boolean mIsRtl;
    private int mLeftMost;
    private boolean mReceivedInvokeKeyDown;
    private int mRightMost;
    private int mSelectedCenterOffset;
    private View mSelectedChild;
    private boolean mShouldCallbackDuringFling;
    private boolean mShouldCallbackOnUnselectedItemClick;
    private boolean mShouldStopFling;
    private int mSpacing;
    private boolean mSuppressSelectionChanged;
    private float mUnselectedAlpha;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Gallery$FlingRunnable.class */
    public class FlingRunnable implements Runnable {
        private int mLastFlingX;
        private Scroller mScroller;

        public FlingRunnable() {
            this.mScroller = new Scroller(Gallery.this.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endFling(boolean z) {
            this.mScroller.forceFinished(true);
            if (z) {
                Gallery.this.scrollIntoSlots();
            }
        }

        private void startCommon() {
            Gallery.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            if (Gallery.this.mItemCount == 0) {
                endFling(true);
                return;
            }
            Gallery.this.mShouldStopFling = false;
            Scroller scroller = this.mScroller;
            boolean computeScrollOffset = scroller.computeScrollOffset();
            int currX = scroller.getCurrX();
            int i = this.mLastFlingX - currX;
            if (i > 0) {
                Gallery.this.mDownTouchPosition = Gallery.this.mIsRtl ? (Gallery.this.mFirstPosition + Gallery.this.getChildCount()) - 1 : Gallery.this.mFirstPosition;
                max = Math.min(((Gallery.this.getWidth() - Gallery.this.mPaddingLeft) - Gallery.this.mPaddingRight) - 1, i);
            } else {
                Gallery.this.getChildCount();
                Gallery.this.mDownTouchPosition = Gallery.this.mIsRtl ? Gallery.this.mFirstPosition : (Gallery.this.mFirstPosition + Gallery.this.getChildCount()) - 1;
                max = Math.max(-(((Gallery.this.getWidth() - Gallery.this.mPaddingRight) - Gallery.this.mPaddingLeft) - 1), i);
            }
            Gallery.this.trackMotionScroll(max);
            if (!computeScrollOffset || Gallery.this.mShouldStopFling) {
                endFling(true);
                return;
            }
            this.mLastFlingX = currX;
            Gallery.this.post(this);
        }

        public void startUsingDistance(int i) {
            if (i == 0) {
                return;
            }
            startCommon();
            this.mLastFlingX = 0;
            this.mScroller.startScroll(0, 0, -i, 0, Gallery.this.mAnimationDuration);
            Gallery.this.post(this);
        }

        public void startUsingVelocity(int i) {
            if (i == 0) {
                return;
            }
            startCommon();
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.mLastFlingX = i2;
            this.mScroller.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            Gallery.this.post(this);
        }

        public void stop(boolean z) {
            Gallery.this.removeCallbacks(this);
            endFling(z);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/Gallery$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public Gallery(Context context) {
        this(context, null);
    }

    public Gallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.galleryStyle);
    }

    public Gallery(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public Gallery(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSpacing = 0;
        this.mAnimationDuration = HttpURLConnection.HTTP_BAD_REQUEST;
        this.mFlingRunnable = new FlingRunnable();
        this.mDisableSuppressSelectionChangedRunnable = new Runnable() { // from class: android.widget.Gallery.1
            @Override // java.lang.Runnable
            public void run() {
                Gallery.this.mSuppressSelectionChanged = false;
                Gallery.this.selectionChanged();
            }
        };
        this.mShouldCallbackDuringFling = true;
        this.mShouldCallbackOnUnselectedItemClick = true;
        this.mIsRtl = true;
        this.mGestureDetector = new GestureDetector(context, this);
        this.mGestureDetector.setIsLongpressEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Gallery, i, i2);
        int i3 = obtainStyledAttributes.getInt(0, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        int i4 = obtainStyledAttributes.getInt(1, -1);
        if (i4 > 0) {
            setAnimationDuration(i4);
        }
        setSpacing(obtainStyledAttributes.getDimensionPixelOffset(2, 0));
        setUnselectedAlpha(obtainStyledAttributes.getFloat(3, 0.5f));
        obtainStyledAttributes.recycle();
        this.mGroupFlags |= 1024;
        this.mGroupFlags |= 2048;
    }

    private int calculateTop(View view, boolean z) {
        int measuredHeight = z ? getMeasuredHeight() : getHeight();
        int measuredHeight2 = z ? view.getMeasuredHeight() : view.getHeight();
        switch (this.mGravity) {
            case 16:
                return this.mSpinnerPadding.top + ((((measuredHeight - this.mSpinnerPadding.bottom) - this.mSpinnerPadding.top) - measuredHeight2) / 2);
            case 48:
                return this.mSpinnerPadding.top;
            case 80:
                return (measuredHeight - this.mSpinnerPadding.bottom) - measuredHeight2;
            default:
                return 0;
        }
    }

    private void detachOffScreenChildren(boolean z) {
        int i;
        int i2;
        int childCount = getChildCount();
        int i3 = this.mFirstPosition;
        int i4 = 0;
        int i5 = 0;
        if (z) {
            int i6 = this.mPaddingLeft;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < childCount; i9++) {
                int i10 = this.mIsRtl ? (childCount - 1) - i9 : i9;
                View childAt = getChildAt(i10);
                if (childAt.getRight() >= i6) {
                    break;
                }
                i7 = i10;
                i8++;
                this.mRecycler.put(i3 + i10, childAt);
            }
            i = i8;
            i2 = i7;
            if (!this.mIsRtl) {
                i2 = 0;
                i = i8;
            }
        } else {
            int width = getWidth();
            int i11 = this.mPaddingRight;
            int i12 = childCount;
            while (true) {
                int i13 = i12 - 1;
                if (i13 < 0) {
                    break;
                }
                int i14 = this.mIsRtl ? (childCount - 1) - i13 : i13;
                View childAt2 = getChildAt(i14);
                if (childAt2.getLeft() <= width - i11) {
                    break;
                }
                i4 = i14;
                i5++;
                this.mRecycler.put(i3 + i14, childAt2);
                i12 = i13;
            }
            i = i5;
            i2 = i4;
            if (this.mIsRtl) {
                i2 = 0;
                i = i5;
            }
        }
        detachViewsFromParent(i2, i);
        if (z != this.mIsRtl) {
            this.mFirstPosition += i;
        }
    }

    private boolean dispatchLongPress(View view, int i, long j) {
        boolean z = false;
        if (this.mOnItemLongClickListener != null) {
            z = this.mOnItemLongClickListener.onItemLongClick(this, this.mDownTouchView, this.mDownTouchPosition, j);
        }
        boolean z2 = z;
        if (!z) {
            this.mContextMenuInfo = new AdapterView.AdapterContextMenuInfo(view, i, j);
            z2 = super.showContextMenuForChild(this);
        }
        if (z2) {
            performHapticFeedback(0);
        }
        return z2;
    }

    private void dispatchPress(View view) {
        if (view != null) {
            view.setPressed(true);
        }
        setPressed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchUnpress() {
        int childCount = getChildCount();
        while (true) {
            int i = childCount - 1;
            if (i < 0) {
                setPressed(false);
                return;
            } else {
                getChildAt(i).setPressed(false);
                childCount = i;
            }
        }
    }

    private void fillToGalleryLeft() {
        if (this.mIsRtl) {
            fillToGalleryLeftRtl();
        } else {
            fillToGalleryLeftLtr();
        }
    }

    private void fillToGalleryLeftLtr() {
        int i;
        int i2;
        int i3 = this.mSpacing;
        int i4 = this.mPaddingLeft;
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            i2 = childAt.getLeft() - i3;
        } else {
            i = 0;
            i2 = (this.mRight - this.mLeft) - this.mPaddingRight;
            this.mShouldStopFling = true;
        }
        while (i2 > i4 && i >= 0) {
            View makeAndAddView = makeAndAddView(i, i - this.mSelectedPosition, i2, false);
            this.mFirstPosition = i;
            i2 = makeAndAddView.getLeft() - i3;
            i--;
        }
    }

    private void fillToGalleryLeftRtl() {
        int i;
        int i2;
        int i3 = this.mSpacing;
        int i4 = this.mPaddingLeft;
        int childCount = getChildCount();
        int i5 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            i2 = childAt.getLeft() - i3;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            i2 = (this.mRight - this.mLeft) - this.mPaddingRight;
            this.mShouldStopFling = true;
        }
        while (i2 > i4 && i < this.mItemCount) {
            i2 = makeAndAddView(i, i - this.mSelectedPosition, i2, false).getLeft() - i3;
            i++;
        }
    }

    private void fillToGalleryRight() {
        if (this.mIsRtl) {
            fillToGalleryRightRtl();
        } else {
            fillToGalleryRightLtr();
        }
    }

    private void fillToGalleryRightLtr() {
        int i;
        int i2;
        int i3 = this.mSpacing;
        int i4 = this.mRight;
        int i5 = this.mLeft;
        int i6 = this.mPaddingRight;
        int childCount = getChildCount();
        int i7 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            i2 = childAt.getRight() + i3;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            i2 = this.mPaddingLeft;
            this.mShouldStopFling = true;
        }
        while (i2 < (i4 - i5) - i6 && i < i7) {
            i2 = makeAndAddView(i, i - this.mSelectedPosition, i2, true).getRight() + i3;
            i++;
        }
    }

    private void fillToGalleryRightRtl() {
        int i;
        int i2;
        int i3 = this.mSpacing;
        int i4 = this.mRight;
        int i5 = this.mLeft;
        int i6 = this.mPaddingRight;
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            i2 = childAt.getRight() + i3;
        } else {
            i = 0;
            i2 = this.mPaddingLeft;
            this.mShouldStopFling = true;
        }
        while (i2 < (i4 - i5) - i6 && i >= 0) {
            View makeAndAddView = makeAndAddView(i, i - this.mSelectedPosition, i2, true);
            this.mFirstPosition = i;
            i2 = makeAndAddView.getRight() + i3;
            i--;
        }
    }

    private int getCenterOfGallery() {
        return (((getWidth() - this.mPaddingLeft) - this.mPaddingRight) / 2) + this.mPaddingLeft;
    }

    private static int getCenterOfView(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private View makeAndAddView(int i, int i2, int i3, boolean z) {
        View view;
        if (this.mDataChanged || (view = this.mRecycler.get(i)) == null) {
            View view2 = this.mAdapter.getView(i, null, this);
            setUpChild(view2, i2, i3, z);
            return view2;
        }
        int left = view.getLeft();
        this.mRightMost = Math.max(this.mRightMost, view.getMeasuredWidth() + left);
        this.mLeftMost = Math.min(this.mLeftMost, left);
        setUpChild(view, i2, i3, z);
        return view;
    }

    private void offsetChildrenLeftAndRight(int i) {
        int childCount = getChildCount();
        while (true) {
            int i2 = childCount - 1;
            if (i2 < 0) {
                return;
            }
            getChildAt(i2).offsetLeftAndRight(i);
            childCount = i2;
        }
    }

    private void onFinishedMovement() {
        if (this.mSuppressSelectionChanged) {
            this.mSuppressSelectionChanged = false;
            super.selectionChanged();
        }
        this.mSelectedCenterOffset = 0;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollIntoSlots() {
        if (getChildCount() == 0 || this.mSelectedChild == null) {
            return;
        }
        int centerOfGallery = getCenterOfGallery() - getCenterOfView(this.mSelectedChild);
        if (centerOfGallery != 0) {
            this.mFlingRunnable.startUsingDistance(centerOfGallery);
        } else {
            onFinishedMovement();
        }
    }

    private boolean scrollToChild(int i) {
        View childAt = getChildAt(i);
        if (childAt != null) {
            this.mFlingRunnable.startUsingDistance(getCenterOfGallery() - getCenterOfView(childAt));
            return true;
        }
        return false;
    }

    private void setSelectionToCenterChild() {
        int i;
        View view = this.mSelectedChild;
        if (this.mSelectedChild == null) {
            return;
        }
        int centerOfGallery = getCenterOfGallery();
        if (view.getLeft() > centerOfGallery || view.getRight() < centerOfGallery) {
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            int childCount = getChildCount() - 1;
            while (true) {
                i = i3;
                if (childCount < 0) {
                    break;
                }
                View childAt = getChildAt(childCount);
                if (childAt.getLeft() <= centerOfGallery && childAt.getRight() >= centerOfGallery) {
                    i = childCount;
                    break;
                }
                int min = Math.min(Math.abs(childAt.getLeft() - centerOfGallery), Math.abs(childAt.getRight() - centerOfGallery));
                int i4 = i2;
                if (min < i2) {
                    i4 = min;
                    i3 = childCount;
                }
                childCount--;
                i2 = i4;
            }
            int i5 = this.mFirstPosition + i;
            if (i5 != this.mSelectedPosition) {
                setSelectedPositionInt(i5);
                setNextSelectedPositionInt(i5);
                checkSelectionChanged();
            }
        }
    }

    private void setUpChild(View view, int i, int i2, boolean z) {
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = (LayoutParams) generateDefaultLayoutParams();
        }
        addViewInLayout(view, z != this.mIsRtl ? -1 : 0, layoutParams2, true);
        view.setSelected(i == 0);
        view.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, layoutParams2.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, layoutParams2.height));
        int calculateTop = calculateTop(view, true);
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth = view.getMeasuredWidth();
        if (z) {
            i3 = i2 + measuredWidth;
        } else {
            i3 = i2;
            i2 -= measuredWidth;
        }
        view.layout(i2, calculateTop, i3, calculateTop + measuredHeight);
    }

    private void updateSelectedItemMetadata() {
        View view = this.mSelectedChild;
        View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        this.mSelectedChild = childAt;
        if (childAt == null) {
            return;
        }
        childAt.setSelected(true);
        childAt.setFocusable(true);
        if (hasFocus()) {
            childAt.requestFocus();
        }
        if (view == null || view == childAt) {
            return;
        }
        view.setSelected(false);
        view.setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return this.mSelectedPosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return this.mItemCount;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent.dispatch(this, null, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
        if (this.mSelectedChild != null) {
            this.mSelectedChild.setPressed(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetSelected(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsSpinner, android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        int i3 = this.mSelectedPosition - this.mFirstPosition;
        if (i3 >= 0) {
            if (i2 == i - 1) {
                return i3;
            }
            if (i2 >= i3) {
                return i2 + 1;
            }
        }
        return i2;
    }

    @Override // android.widget.AbsSpinner
    int getChildHeight(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean getChildStaticTransformation(View view, Transformation transformation) {
        transformation.clear();
        transformation.setAlpha(view == this.mSelectedChild ? 1.0f : this.mUnselectedAlpha);
        return true;
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        if (r0 > r0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int getLimitedMotionScrollAmount(boolean r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            r8 = r0
            r0 = r5
            r1 = r4
            boolean r1 = r1.mIsRtl
            if (r0 == r1) goto L27
            r0 = r4
            int r0 = r0.mItemCount
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
        L12:
            r0 = r4
            r1 = r7
            r2 = r4
            int r2 = r2.mFirstPosition
            int r1 = r1 - r2
            android.view.View r0 = r0.getChildAt(r1)
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L2c
            r0 = r6
            r7 = r0
        L25:
            r0 = r7
            return r0
        L27:
            r0 = 0
            r7 = r0
            goto L12
        L2c:
            r0 = r11
            int r0 = getCenterOfView(r0)
            r9 = r0
            r0 = r4
            int r0 = r0.getCenterOfGallery()
            r10 = r0
            r0 = r5
            if (r0 == 0) goto L57
            r0 = r8
            r7 = r0
            r0 = r9
            r1 = r10
            if (r0 <= r1) goto L25
        L47:
            r0 = r10
            r1 = r9
            int r0 = r0 - r1
            r7 = r0
            r0 = r5
            if (r0 == 0) goto L60
            r0 = r7
            r1 = r6
            int r0 = java.lang.Math.max(r0, r1)
            return r0
        L57:
            r0 = r9
            r1 = r10
            if (r0 < r1) goto L47
            r0 = 0
            return r0
        L60:
            r0 = r7
            r1 = r6
            int r0 = java.lang.Math.min(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.Gallery.getLimitedMotionScrollAmount(boolean, int):int");
    }

    @Override // android.widget.AbsSpinner
    void layout(int i, boolean z) {
        this.mIsRtl = isLayoutRtl();
        int i2 = this.mSpinnerPadding.left;
        int i3 = this.mRight;
        int i4 = this.mLeft;
        int i5 = this.mSpinnerPadding.left;
        int i6 = this.mSpinnerPadding.right;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        if (this.mNextSelectedPosition >= 0) {
            setSelectedPositionInt(this.mNextSelectedPosition);
        }
        recycleAllViews();
        detachAllViewsFromParent();
        this.mRightMost = 0;
        this.mLeftMost = 0;
        this.mFirstPosition = this.mSelectedPosition;
        View makeAndAddView = makeAndAddView(this.mSelectedPosition, 0, 0, true);
        makeAndAddView.offsetLeftAndRight(((((((i3 - i4) - i5) - i6) / 2) + i2) - (makeAndAddView.getWidth() / 2)) + this.mSelectedCenterOffset);
        fillToGalleryRight();
        fillToGalleryLeft();
        this.mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        updateSelectedItemMetadata();
    }

    boolean moveNext() {
        if (this.mItemCount <= 0 || this.mSelectedPosition >= this.mItemCount - 1) {
            return false;
        }
        scrollToChild((this.mSelectedPosition - this.mFirstPosition) + 1);
        return true;
    }

    boolean movePrevious() {
        if (this.mItemCount <= 0 || this.mSelectedPosition <= 0) {
            return false;
        }
        scrollToChild((this.mSelectedPosition - this.mFirstPosition) - 1);
        return true;
    }

    void onCancel() {
        onUp();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.mFlingRunnable.stop(false);
        this.mDownTouchPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (this.mDownTouchPosition >= 0) {
            this.mDownTouchView = getChildAt(this.mDownTouchPosition - this.mFirstPosition);
            this.mDownTouchView.setPressed(true);
        }
        this.mIsFirstScroll = true;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.mShouldCallbackDuringFling) {
            removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
            if (!this.mSuppressSelectionChanged) {
                this.mSuppressSelectionChanged = true;
            }
        }
        this.mFlingRunnable.startUsingVelocity((int) (-f));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z || this.mSelectedChild == null) {
            return;
        }
        this.mSelectedChild.requestFocus(i);
        this.mSelectedChild.setSelected(true);
    }

    @Override // android.widget.AbsSpinner, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Gallery.class.getName());
    }

    @Override // android.widget.AbsSpinner, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z = true;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Gallery.class.getName());
        if (this.mItemCount <= 1) {
            z = false;
        }
        accessibilityNodeInfo.setScrollable(z);
        if (isEnabled()) {
            if (this.mItemCount > 0 && this.mSelectedPosition < this.mItemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            if (!isEnabled() || this.mItemCount <= 0 || this.mSelectedPosition <= 0) {
                return;
            }
            accessibilityNodeInfo.addAction(8192);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 21:
                if (this.mIsRtl ? moveNext() : movePrevious()) {
                    playSoundEffect(1);
                    return true;
                }
                break;
            case 22:
                if (this.mIsRtl ? movePrevious() : moveNext()) {
                    playSoundEffect(3);
                    return true;
                }
                break;
            case 23:
            case 66:
                this.mReceivedInvokeKeyDown = true;
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (KeyEvent.isConfirmKey(i)) {
            if (this.mReceivedInvokeKeyDown && this.mItemCount > 0) {
                dispatchPress(this.mSelectedChild);
                postDelayed(new Runnable() { // from class: android.widget.Gallery.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Gallery.this.dispatchUnpress();
                    }
                }, ViewConfiguration.getPressedStateDuration());
                performItemClick(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mAdapter.getItemId(this.mSelectedPosition));
            }
            this.mReceivedInvokeKeyDown = false;
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = true;
        layout(0, false);
        this.mInLayout = false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.mDownTouchPosition < 0) {
            return;
        }
        performHapticFeedback(0);
        dispatchLongPress(this.mDownTouchView, this.mDownTouchPosition, getItemIdAtPosition(this.mDownTouchPosition));
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.mParent.requestDisallowInterceptTouchEvent(true);
        if (this.mShouldCallbackDuringFling) {
            if (this.mSuppressSelectionChanged) {
                this.mSuppressSelectionChanged = false;
            }
        } else if (this.mIsFirstScroll) {
            if (!this.mSuppressSelectionChanged) {
                this.mSuppressSelectionChanged = true;
            }
            postDelayed(this.mDisableSuppressSelectionChangedRunnable, 250L);
        }
        trackMotionScroll(((int) f) * (-1));
        this.mIsFirstScroll = false;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.mDownTouchPosition >= 0) {
            scrollToChild(this.mDownTouchPosition - this.mFirstPosition);
            if (this.mShouldCallbackOnUnselectedItemClick || this.mDownTouchPosition == this.mSelectedPosition) {
                performItemClick(this.mDownTouchView, this.mDownTouchPosition, this.mAdapter.getItemId(this.mDownTouchPosition));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            onUp();
        } else if (action == 3) {
            onCancel();
            return onTouchEvent;
        }
        return onTouchEvent;
    }

    void onUp() {
        if (this.mFlingRunnable.mScroller.isFinished()) {
            scrollIntoSlots();
        }
        dispatchUnpress();
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        boolean z;
        if (super.performAccessibilityAction(i, bundle)) {
            z = true;
        } else {
            switch (i) {
                case 4096:
                    z = false;
                    if (isEnabled()) {
                        z = false;
                        if (this.mItemCount > 0) {
                            z = false;
                            if (this.mSelectedPosition < this.mItemCount - 1) {
                                return scrollToChild((this.mSelectedPosition - this.mFirstPosition) + 1);
                            }
                        }
                    }
                    break;
                case 8192:
                    z = false;
                    if (isEnabled()) {
                        z = false;
                        if (this.mItemCount > 0) {
                            z = false;
                            if (this.mSelectedPosition > 0) {
                                return scrollToChild((this.mSelectedPosition - this.mFirstPosition) - 1);
                            }
                        }
                    }
                    break;
                default:
                    return false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AdapterView
    public void selectionChanged() {
        if (this.mSuppressSelectionChanged) {
            return;
        }
        super.selectionChanged();
    }

    public void setAnimationDuration(int i) {
        this.mAnimationDuration = i;
    }

    public void setCallbackDuringFling(boolean z) {
        this.mShouldCallbackDuringFling = z;
    }

    public void setCallbackOnUnselectedItemClick(boolean z) {
        this.mShouldCallbackOnUnselectedItemClick = z;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            this.mGravity = i;
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AdapterView
    public void setSelectedPositionInt(int i) {
        super.setSelectedPositionInt(i);
        updateSelectedItemMetadata();
    }

    public void setSpacing(int i) {
        this.mSpacing = i;
    }

    public void setUnselectedAlpha(float f) {
        this.mUnselectedAlpha = f;
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        if (!isPressed() || this.mSelectedPosition < 0) {
            return false;
        }
        return dispatchLongPress(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView < 0) {
            return false;
        }
        return dispatchLongPress(view, positionForView, this.mAdapter.getItemId(positionForView));
    }

    void trackMotionScroll(int i) {
        if (getChildCount() == 0) {
            return;
        }
        boolean z = i < 0;
        int limitedMotionScrollAmount = getLimitedMotionScrollAmount(z, i);
        if (limitedMotionScrollAmount != i) {
            this.mFlingRunnable.endFling(false);
            onFinishedMovement();
        }
        offsetChildrenLeftAndRight(limitedMotionScrollAmount);
        detachOffScreenChildren(z);
        if (z) {
            fillToGalleryRight();
        } else {
            fillToGalleryLeft();
        }
        this.mRecycler.clear();
        setSelectionToCenterChild();
        View view = this.mSelectedChild;
        if (view != null) {
            this.mSelectedCenterOffset = (view.getLeft() + (view.getWidth() / 2)) - (getWidth() / 2);
        }
        onScrollChanged(0, 0, 0, 0);
        invalidate();
    }
}
