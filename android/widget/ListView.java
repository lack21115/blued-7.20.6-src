package android.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.MathUtils;
import android.util.SparseBooleanArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.RemotableViewMethod;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.RemoteViews;
import com.android.internal.R;
import com.android.internal.util.Predicate;
import com.google.android.collect.Lists;
import java.util.ArrayList;

@RemoteViews.RemoteView
/* loaded from: source-4181928-dex2jar.jar:android/widget/ListView.class */
public class ListView extends AbsListView {
    private static final float MAX_SCROLL_FACTOR = 0.33f;
    private static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
    static final int NO_POSITION = -1;
    private boolean mAreAllItemsSelectable;
    private final ArrowScrollFocusResult mArrowScrollFocusResult;
    Drawable mDivider;
    int mDividerHeight;
    private boolean mDividerIsOpaque;
    private Paint mDividerPaint;
    private FocusSelector mFocusSelector;
    private boolean mFooterDividersEnabled;
    private ArrayList<FixedViewInfo> mFooterViewInfos;
    private boolean mHeaderDividersEnabled;
    private ArrayList<FixedViewInfo> mHeaderViewInfos;
    private boolean mIsCacheColorOpaque;
    private boolean mItemsCanFocus;
    Drawable mOverScrollFooter;
    Drawable mOverScrollHeader;
    private final Rect mTempRect;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/ListView$ArrowScrollFocusResult.class */
    public static class ArrowScrollFocusResult {
        private int mAmountToScroll;
        private int mSelectedPosition;

        private ArrowScrollFocusResult() {
        }

        public int getAmountToScroll() {
            return this.mAmountToScroll;
        }

        public int getSelectedPosition() {
            return this.mSelectedPosition;
        }

        void populate(int i, int i2) {
            this.mSelectedPosition = i;
            this.mAmountToScroll = i2;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ListView$FixedViewInfo.class */
    public class FixedViewInfo {
        public Object data;
        public boolean isSelectable;
        public View view;

        public FixedViewInfo() {
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ListView$FocusSelector.class */
    private class FocusSelector implements Runnable {
        private int mPosition;
        private int mPositionTop;

        private FocusSelector() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListView.this.setSelectionFromTop(this.mPosition, this.mPositionTop);
        }

        public FocusSelector setup(int i, int i2) {
            this.mPosition = i;
            this.mPositionTop = i2;
            return this;
        }
    }

    public ListView(Context context) {
        this(context, null);
    }

    public ListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ListView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mHeaderViewInfos = Lists.newArrayList();
        this.mFooterViewInfos = Lists.newArrayList();
        this.mAreAllItemsSelectable = true;
        this.mItemsCanFocus = false;
        this.mTempRect = new Rect();
        this.mArrowScrollFocusResult = new ArrowScrollFocusResult();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListView, i, i2);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(0);
        if (textArray != null) {
            setAdapter((ListAdapter) new ArrayAdapter(context, 17367043, textArray));
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        if (drawable != null) {
            setDivider(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(5);
        if (drawable2 != null) {
            setOverscrollHeader(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(6);
        if (drawable3 != null) {
            setOverscrollFooter(drawable3);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        if (dimensionPixelSize != 0) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mHeaderDividersEnabled = obtainStyledAttributes.getBoolean(3, true);
        this.mFooterDividersEnabled = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
    }

    private View addViewAbove(View view, int i) {
        int i2 = i - 1;
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, view.getTop() - this.mDividerHeight, false, this.mListPadding.left, false, this.mIsScrap[0]);
        return obtainView;
    }

    private View addViewBelow(View view, int i) {
        int i2 = i + 1;
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, view.getBottom() + this.mDividerHeight, true, this.mListPadding.left, false, this.mIsScrap[0]);
        return obtainView;
    }

    private void adjustViewsUpOrDown() {
        int i;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mStackFromBottom) {
                int bottom = getChildAt(childCount - 1).getBottom() - (getHeight() - this.mListPadding.bottom);
                int i2 = bottom;
                if (this.mFirstPosition + childCount < this.mItemCount) {
                    i2 = bottom + this.mDividerHeight;
                }
                i = i2;
                if (i2 > 0) {
                    i = 0;
                }
            } else {
                int top = getChildAt(0).getTop() - this.mListPadding.top;
                int i3 = top;
                if (this.mFirstPosition != 0) {
                    i3 = top - this.mDividerHeight;
                }
                i = i3;
                if (i3 < 0) {
                    i = 0;
                }
            }
            if (i != 0) {
                offsetChildrenTopAndBottom(-i);
            }
        }
    }

    private int amountToScroll(int i, int i2) {
        int height = getHeight() - this.mListPadding.bottom;
        int i3 = this.mListPadding.top;
        int childCount = getChildCount();
        if (i != 130) {
            int i4 = 0;
            if (i2 != -1) {
                i4 = i2 - this.mFirstPosition;
            }
            while (i4 < 0) {
                addViewAbove(getChildAt(0), this.mFirstPosition);
                this.mFirstPosition--;
                i4 = i2 - this.mFirstPosition;
            }
            int i5 = this.mFirstPosition;
            View childAt = getChildAt(i4);
            int i6 = i3;
            if (i5 + i4 > 0) {
                i6 = i3 + getArrowScrollPreviewLength();
            }
            if (childAt.getTop() >= i6) {
                return 0;
            }
            if (i2 == -1 || childAt.getBottom() - i6 < getMaxScrollAmount()) {
                int top = i6 - childAt.getTop();
                int i7 = top;
                if (this.mFirstPosition == 0) {
                    i7 = Math.min(top, i3 - getChildAt(0).getTop());
                }
                return Math.min(i7, getMaxScrollAmount());
            }
            return 0;
        }
        int i8 = childCount - 1;
        int i9 = childCount;
        if (i2 != -1) {
            i8 = i2 - this.mFirstPosition;
            i9 = childCount;
        }
        while (i9 <= i8) {
            addViewBelow(getChildAt(i9 - 1), (this.mFirstPosition + i9) - 1);
            i9++;
        }
        int i10 = this.mFirstPosition;
        View childAt2 = getChildAt(i8);
        int i11 = height;
        if (i10 + i8 < this.mItemCount - 1) {
            i11 = height - getArrowScrollPreviewLength();
        }
        if (childAt2.getBottom() <= i11) {
            return 0;
        }
        if (i2 == -1 || i11 - childAt2.getTop() < getMaxScrollAmount()) {
            int bottom = childAt2.getBottom() - i11;
            int i12 = bottom;
            if (this.mFirstPosition + i9 == this.mItemCount) {
                i12 = Math.min(bottom, getChildAt(i9 - 1).getBottom() - height);
            }
            return Math.min(i12, getMaxScrollAmount());
        }
        return 0;
    }

    private int amountToScrollToNewFocus(int i, View view, int i2) {
        int i3;
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (i == 33) {
            i3 = 0;
            if (this.mTempRect.top < this.mListPadding.top) {
                int i4 = this.mListPadding.top - this.mTempRect.top;
                i3 = i4;
                if (i2 > 0) {
                    i3 = i4 + getArrowScrollPreviewLength();
                }
            }
        } else {
            int height = getHeight() - this.mListPadding.bottom;
            i3 = 0;
            if (this.mTempRect.bottom > height) {
                int i5 = this.mTempRect.bottom - height;
                i3 = i5;
                if (i2 < this.mItemCount - 1) {
                    return i5 + getArrowScrollPreviewLength();
                }
            }
        }
        return i3;
    }

    private ArrowScrollFocusResult arrowScrollFocused(int i) {
        View findNextFocusFromRect;
        int lookForSelectablePositionOnScreen;
        View selectedView = getSelectedView();
        if (selectedView == null || !selectedView.hasFocus()) {
            if (i == 130) {
                int arrowScrollPreviewLength = this.mListPadding.top + (this.mFirstPosition > 0 ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getTop() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getTop();
                }
                this.mTempRect.set(0, arrowScrollPreviewLength, 0, arrowScrollPreviewLength);
            } else {
                boolean z = (this.mFirstPosition + getChildCount()) - 1 < this.mItemCount;
                int height = (getHeight() - this.mListPadding.bottom) - (z ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getBottom() < height) {
                    height = selectedView.getBottom();
                }
                this.mTempRect.set(0, height, 0, height);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        }
        if (findNextFocusFromRect != null) {
            int positionOfNewFocus = positionOfNewFocus(findNextFocusFromRect);
            if (this.mSelectedPosition != -1 && positionOfNewFocus != this.mSelectedPosition && (lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i)) != -1) {
                if (i == 130 && lookForSelectablePositionOnScreen < positionOfNewFocus) {
                    return null;
                }
                if (i == 33 && lookForSelectablePositionOnScreen > positionOfNewFocus) {
                    return null;
                }
            }
            int amountToScrollToNewFocus = amountToScrollToNewFocus(i, findNextFocusFromRect, positionOfNewFocus);
            int maxScrollAmount = getMaxScrollAmount();
            if (amountToScrollToNewFocus < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.mArrowScrollFocusResult.populate(positionOfNewFocus, amountToScrollToNewFocus);
                return this.mArrowScrollFocusResult;
            } else if (distanceToView(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.mArrowScrollFocusResult.populate(positionOfNewFocus, maxScrollAmount);
                return this.mArrowScrollFocusResult;
            } else {
                return null;
            }
        }
        return null;
    }

    private boolean arrowScrollImpl(int i) {
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i2 = this.mSelectedPosition;
        int nextSelectedPositionForDirection = nextSelectedPositionForDirection(selectedView, i2, i);
        int amountToScroll = amountToScroll(i, nextSelectedPositionForDirection);
        ArrowScrollFocusResult arrowScrollFocused = this.mItemsCanFocus ? arrowScrollFocused(i) : null;
        if (arrowScrollFocused != null) {
            nextSelectedPositionForDirection = arrowScrollFocused.getSelectedPosition();
            amountToScroll = arrowScrollFocused.getAmountToScroll();
        }
        boolean z = arrowScrollFocused != null;
        View view = selectedView;
        if (nextSelectedPositionForDirection != -1) {
            handleNewSelectionChange(selectedView, i, nextSelectedPositionForDirection, arrowScrollFocused != null);
            setSelectedPositionInt(nextSelectedPositionForDirection);
            setNextSelectedPositionInt(nextSelectedPositionForDirection);
            view = getSelectedView();
            i2 = nextSelectedPositionForDirection;
            if (this.mItemsCanFocus && arrowScrollFocused == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            z = true;
            checkSelectionChanged();
        }
        if (amountToScroll > 0) {
            if (i != 33) {
                amountToScroll = -amountToScroll;
            }
            scrollListItemsBy(amountToScroll);
            z = true;
        }
        if (this.mItemsCanFocus && arrowScrollFocused == null && view != null && view.hasFocus()) {
            View findFocus = view.findFocus();
            if (!isViewAncestorOf(findFocus, this) || distanceToView(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        View view2 = view;
        if (nextSelectedPositionForDirection == -1) {
            view2 = view;
            if (view != null) {
                view2 = view;
                if (!isViewAncestorOf(view, this)) {
                    view2 = null;
                    hideSelector();
                    this.mResurrectToPosition = -1;
                }
            }
        }
        if (z) {
            if (view2 != null) {
                positionSelectorLikeFocus(i2, view2);
                this.mSelectedTop = view2.getTop();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            invokeOnItemScrollListener();
            return true;
        }
        return false;
    }

    private void clearRecycledState(ArrayList<FixedViewInfo> arrayList) {
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) arrayList.get(i2).view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.recycledHeaderFooter = false;
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0256, code lost:
        if (r5.mPopup.isShowing() == false) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean commonKey(int r6, int r7, android.view.KeyEvent r8) {
        /*
            Method dump skipped, instructions count: 951
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.ListView.commonKey(int, int, android.view.KeyEvent):boolean");
    }

    private void correctTooHigh(int i) {
        if ((this.mFirstPosition + i) - 1 != this.mItemCount - 1 || i <= 0) {
            return;
        }
        int bottom = ((this.mBottom - this.mTop) - this.mListPadding.bottom) - getChildAt(i - 1).getBottom();
        View childAt = getChildAt(0);
        int top = childAt.getTop();
        if (bottom > 0) {
            if (this.mFirstPosition > 0 || top < this.mListPadding.top) {
                int i2 = bottom;
                if (this.mFirstPosition == 0) {
                    i2 = Math.min(bottom, this.mListPadding.top - top);
                }
                offsetChildrenTopAndBottom(i2);
                if (this.mFirstPosition > 0) {
                    fillUp(this.mFirstPosition - 1, childAt.getTop() - this.mDividerHeight);
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    private void correctTooLow(int i) {
        if (this.mFirstPosition != 0 || i <= 0) {
            return;
        }
        int top = getChildAt(0).getTop();
        int i2 = this.mListPadding.top;
        int i3 = (this.mBottom - this.mTop) - this.mListPadding.bottom;
        int i4 = top - i2;
        View childAt = getChildAt(i - 1);
        int bottom = childAt.getBottom();
        int i5 = (this.mFirstPosition + i) - 1;
        if (i4 > 0) {
            if (i5 >= this.mItemCount - 1 && bottom <= i3) {
                if (i5 == this.mItemCount - 1) {
                    adjustViewsUpOrDown();
                    return;
                }
                return;
            }
            int i6 = i4;
            if (i5 == this.mItemCount - 1) {
                i6 = Math.min(i4, bottom - i3);
            }
            offsetChildrenTopAndBottom(-i6);
            if (i5 < this.mItemCount - 1) {
                fillDown(i5 + 1, childAt.getBottom() + this.mDividerHeight);
                adjustViewsUpOrDown();
            }
        }
    }

    private int distanceToView(View view) {
        int i = 0;
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int i2 = (this.mBottom - this.mTop) - this.mListPadding.bottom;
        if (this.mTempRect.bottom < this.mListPadding.top) {
            i = this.mListPadding.top - this.mTempRect.bottom;
        } else if (this.mTempRect.top > i2) {
            return this.mTempRect.top - i2;
        }
        return i;
    }

    private void fillAboveAndBelow(View view, int i) {
        int i2 = this.mDividerHeight;
        if (this.mStackFromBottom) {
            fillDown(i + 1, view.getBottom() + i2);
            adjustViewsUpOrDown();
            fillUp(i - 1, view.getTop() - i2);
            return;
        }
        fillUp(i - 1, view.getTop() - i2);
        adjustViewsUpOrDown();
        fillDown(i + 1, view.getBottom() + i2);
    }

    private View fillDown(int i, int i2) {
        int i3 = this.mBottom - this.mTop;
        int i4 = i3;
        View view = null;
        int i5 = i;
        int i6 = i2;
        if ((this.mGroupFlags & 34) == 34) {
            i4 = i3 - this.mListPadding.bottom;
            i6 = i2;
            i5 = i;
            view = null;
        }
        while (i6 < i4 && i5 < this.mItemCount) {
            boolean z = i5 == this.mSelectedPosition;
            View makeAndAddView = makeAndAddView(i5, i6, true, this.mListPadding.left, z);
            i6 = makeAndAddView.getBottom() + this.mDividerHeight;
            if (z) {
                view = makeAndAddView;
            }
            i5++;
        }
        setVisibleRangeHint(this.mFirstPosition, (this.mFirstPosition + getChildCount()) - 1);
        return view;
    }

    private View fillFromMiddle(int i, int i2) {
        int i3 = i2 - i;
        int reconcileSelectedPosition = reconcileSelectedPosition();
        View makeAndAddView = makeAndAddView(reconcileSelectedPosition, i, true, this.mListPadding.left, true);
        this.mFirstPosition = reconcileSelectedPosition;
        int measuredHeight = makeAndAddView.getMeasuredHeight();
        if (measuredHeight <= i3) {
            makeAndAddView.offsetTopAndBottom((i3 - measuredHeight) / 2);
        }
        fillAboveAndBelow(makeAndAddView, reconcileSelectedPosition);
        if (this.mStackFromBottom) {
            correctTooLow(getChildCount());
            return makeAndAddView;
        }
        correctTooHigh(getChildCount());
        return makeAndAddView;
    }

    private View fillFromSelection(int i, int i2, int i3) {
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int i4 = this.mSelectedPosition;
        int topSelectionPixel = getTopSelectionPixel(i2, verticalFadingEdgeLength, i4);
        int bottomSelectionPixel = getBottomSelectionPixel(i3, verticalFadingEdgeLength, i4);
        View makeAndAddView = makeAndAddView(i4, i, true, this.mListPadding.left, true);
        if (makeAndAddView.getBottom() > bottomSelectionPixel) {
            makeAndAddView.offsetTopAndBottom(-Math.min(makeAndAddView.getTop() - topSelectionPixel, makeAndAddView.getBottom() - bottomSelectionPixel));
        } else if (makeAndAddView.getTop() < topSelectionPixel) {
            makeAndAddView.offsetTopAndBottom(Math.min(topSelectionPixel - makeAndAddView.getTop(), bottomSelectionPixel - makeAndAddView.getBottom()));
        }
        fillAboveAndBelow(makeAndAddView, i4);
        if (this.mStackFromBottom) {
            correctTooLow(getChildCount());
            return makeAndAddView;
        }
        correctTooHigh(getChildCount());
        return makeAndAddView;
    }

    private View fillFromTop(int i) {
        this.mFirstPosition = Math.min(this.mFirstPosition, this.mSelectedPosition);
        this.mFirstPosition = Math.min(this.mFirstPosition, this.mItemCount - 1);
        if (this.mFirstPosition < 0) {
            this.mFirstPosition = 0;
        }
        return fillDown(this.mFirstPosition, i);
    }

    private View fillSpecific(int i, int i2) {
        View view;
        View view2;
        boolean z = i == this.mSelectedPosition;
        View makeAndAddView = makeAndAddView(i, i2, true, this.mListPadding.left, z);
        this.mFirstPosition = i;
        int i3 = this.mDividerHeight;
        if (this.mStackFromBottom) {
            View fillDown = fillDown(i + 1, makeAndAddView.getBottom() + i3);
            adjustViewsUpOrDown();
            View fillUp = fillUp(i - 1, makeAndAddView.getTop() - i3);
            int childCount = getChildCount();
            view = fillUp;
            view2 = fillDown;
            if (childCount > 0) {
                correctTooLow(childCount);
                view = fillUp;
                view2 = fillDown;
            }
        } else {
            View fillUp2 = fillUp(i - 1, makeAndAddView.getTop() - i3);
            adjustViewsUpOrDown();
            View fillDown2 = fillDown(i + 1, makeAndAddView.getBottom() + i3);
            int childCount2 = getChildCount();
            view = fillUp2;
            view2 = fillDown2;
            if (childCount2 > 0) {
                correctTooHigh(childCount2);
                view2 = fillDown2;
                view = fillUp2;
            }
        }
        return z ? makeAndAddView : view != null ? view : view2;
    }

    private View fillUp(int i, int i2) {
        int i3 = 0;
        View view = null;
        int i4 = i;
        int i5 = i2;
        if ((this.mGroupFlags & 34) == 34) {
            i3 = this.mListPadding.top;
            i5 = i2;
            i4 = i;
            view = null;
        }
        while (i5 > i3 && i4 >= 0) {
            boolean z = i4 == this.mSelectedPosition;
            View makeAndAddView = makeAndAddView(i4, i5, false, this.mListPadding.left, z);
            i5 = makeAndAddView.getTop() - this.mDividerHeight;
            if (z) {
                view = makeAndAddView;
            }
            i4--;
        }
        this.mFirstPosition = i4 + 1;
        setVisibleRangeHint(this.mFirstPosition, (this.mFirstPosition + getChildCount()) - 1);
        return view;
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getVerticalFadingEdgeLength());
    }

    private int getBottomSelectionPixel(int i, int i2, int i3) {
        int i4 = i;
        if (i3 != this.mItemCount - 1) {
            i4 = i - i2;
        }
        return i4;
    }

    private int getTopSelectionPixel(int i, int i2, int i3) {
        int i4 = i;
        if (i3 > 0) {
            i4 = i + i2;
        }
        return i4;
    }

    private boolean handleHorizontalFocusWithinListItem(int i) {
        View selectedView;
        if (i == 17 || i == 66) {
            int childCount = getChildCount();
            if (!this.mItemsCanFocus || childCount <= 0 || this.mSelectedPosition == -1 || (selectedView = getSelectedView()) == null || !selectedView.hasFocus() || !(selectedView instanceof ViewGroup)) {
                return false;
            }
            View findFocus = selectedView.findFocus();
            View findNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) selectedView, findFocus, i);
            if (findNextFocus != null) {
                findFocus.getFocusedRect(this.mTempRect);
                offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
                offsetRectIntoDescendantCoords(findNextFocus, this.mTempRect);
                if (findNextFocus.requestFocus(i, this.mTempRect)) {
                    return true;
                }
            }
            View findNextFocus2 = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), findFocus, i);
            if (findNextFocus2 != null) {
                return isViewAncestorOf(findNextFocus2, this);
            }
            return false;
        }
        throw new IllegalArgumentException("direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
    }

    private void handleNewSelectionChange(View view, int i, int i2, boolean z) {
        int i3;
        View view2;
        boolean z2;
        if (i2 == -1) {
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        }
        int i4 = this.mSelectedPosition - this.mFirstPosition;
        int i5 = i2 - this.mFirstPosition;
        if (i == 33) {
            i3 = i4;
            view2 = getChildAt(i5);
            i4 = i5;
            z2 = true;
        } else {
            i3 = i5;
            view2 = view;
            view = getChildAt(i3);
            z2 = false;
        }
        int childCount = getChildCount();
        if (view2 != null) {
            view2.setSelected(!z && z2);
            measureAndAdjustDown(view2, i4, childCount);
        }
        if (view != null) {
            view.setSelected((z || z2) ? false : true);
            measureAndAdjustDown(view, i3, childCount);
        }
    }

    private boolean isDirectChildHeaderOrFooter(View view) {
        ArrayList<FixedViewInfo> arrayList = this.mHeaderViewInfos;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                ArrayList<FixedViewInfo> arrayList2 = this.mFooterViewInfos;
                int size2 = arrayList2.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size2) {
                        return false;
                    }
                    if (view == arrayList2.get(i4).view) {
                        return true;
                    }
                    i3 = i4 + 1;
                }
            } else if (view == arrayList.get(i2).view) {
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }

    private boolean isViewAncestorOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && isViewAncestorOf((View) parent, view2);
    }

    private int lookForSelectablePositionOnScreen(int i) {
        int i2;
        int i3 = this.mFirstPosition;
        if (i != 130) {
            int childCount = (getChildCount() + i3) - 1;
            int childCount2 = this.mSelectedPosition != -1 ? this.mSelectedPosition - 1 : (getChildCount() + i3) - 1;
            if (childCount2 < 0 || childCount2 >= this.mAdapter.getCount()) {
                return -1;
            }
            int i4 = childCount2;
            if (childCount2 > childCount) {
                i4 = childCount;
            }
            ListAdapter adapter = getAdapter();
            while (i4 >= i3) {
                if (adapter.isEnabled(i4)) {
                    i2 = i4;
                    if (getChildAt(i4 - i3).getVisibility() != 0) {
                    }
                }
                i4--;
            }
            return -1;
        }
        int i5 = this.mSelectedPosition != -1 ? this.mSelectedPosition + 1 : i3;
        if (i5 >= this.mAdapter.getCount()) {
            i2 = -1;
        } else {
            int i6 = i5;
            if (i5 < i3) {
                i6 = i3;
            }
            int lastVisiblePosition = getLastVisiblePosition();
            ListAdapter adapter2 = getAdapter();
            int i7 = i6;
            while (true) {
                int i8 = i7;
                if (i8 > lastVisiblePosition) {
                    return -1;
                }
                if (adapter2.isEnabled(i8)) {
                    i2 = i8;
                    if (getChildAt(i8 - i3).getVisibility() == 0) {
                        break;
                    }
                }
                i7 = i8 + 1;
            }
        }
        return i2;
    }

    private View makeAndAddView(int i, int i2, boolean z, int i3, boolean z2) {
        View activeView;
        if (!this.mDataChanged && (activeView = this.mRecycler.getActiveView(i)) != null) {
            setupChild(activeView, i, i2, z, i3, z2, true);
            return activeView;
        }
        View obtainView = obtainView(i, this.mIsScrap);
        setupChild(obtainView, i, i2, z, i3, z2, this.mIsScrap[0]);
        return obtainView;
    }

    private void measureAndAdjustDown(View view, int i, int i2) {
        int height = view.getHeight();
        measureItem(view);
        if (view.getMeasuredHeight() == height) {
            return;
        }
        relayoutMeasuredItem(view);
        int measuredHeight = view.getMeasuredHeight();
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            getChildAt(i).offsetTopAndBottom(measuredHeight - height);
        }
    }

    private void measureItem(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListPadding.left + this.mListPadding.right, layoutParams2.width);
        int i = layoutParams2.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    private void measureScrapChild(View view, int i, int i2) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        AbsListView.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = (AbsListView.LayoutParams) generateDefaultLayoutParams();
            view.setLayoutParams(layoutParams2);
        }
        layoutParams2.viewType = this.mAdapter.getItemViewType(i);
        layoutParams2.forceAdd = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.mListPadding.left + this.mListPadding.right, layoutParams2.width);
        int i3 = layoutParams2.height;
        view.measure(childMeasureSpec, i3 > 0 ? View.MeasureSpec.makeMeasureSpec(i3, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    private View moveSelection(View view, View view2, int i, int i2, int i3) {
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int i4 = this.mSelectedPosition;
        int topSelectionPixel = getTopSelectionPixel(i2, verticalFadingEdgeLength, i4);
        int bottomSelectionPixel = getBottomSelectionPixel(i2, verticalFadingEdgeLength, i4);
        if (i <= 0) {
            if (i < 0) {
                View makeAndAddView = view2 != null ? makeAndAddView(i4, view2.getTop(), true, this.mListPadding.left, true) : makeAndAddView(i4, view.getTop(), false, this.mListPadding.left, true);
                if (makeAndAddView.getTop() < topSelectionPixel) {
                    makeAndAddView.offsetTopAndBottom(Math.min(Math.min(topSelectionPixel - makeAndAddView.getTop(), bottomSelectionPixel - makeAndAddView.getBottom()), (i3 - i2) / 2));
                }
                fillAboveAndBelow(makeAndAddView, i4);
                return makeAndAddView;
            }
            int top = view.getTop();
            View makeAndAddView2 = makeAndAddView(i4, top, true, this.mListPadding.left, true);
            if (top < i2 && makeAndAddView2.getBottom() < i2 + 20) {
                makeAndAddView2.offsetTopAndBottom(i2 - makeAndAddView2.getTop());
            }
            fillAboveAndBelow(makeAndAddView2, i4);
            return makeAndAddView2;
        }
        View makeAndAddView3 = makeAndAddView(i4 - 1, view.getTop(), true, this.mListPadding.left, false);
        int i5 = this.mDividerHeight;
        View makeAndAddView4 = makeAndAddView(i4, makeAndAddView3.getBottom() + i5, true, this.mListPadding.left, true);
        if (makeAndAddView4.getBottom() > bottomSelectionPixel) {
            int min = Math.min(Math.min(makeAndAddView4.getTop() - topSelectionPixel, makeAndAddView4.getBottom() - bottomSelectionPixel), (i3 - i2) / 2);
            makeAndAddView3.offsetTopAndBottom(-min);
            makeAndAddView4.offsetTopAndBottom(-min);
        }
        if (this.mStackFromBottom) {
            fillDown(this.mSelectedPosition + 1, makeAndAddView4.getBottom() + i5);
            adjustViewsUpOrDown();
            fillUp(this.mSelectedPosition - 2, makeAndAddView4.getTop() - i5);
            return makeAndAddView4;
        }
        fillUp(this.mSelectedPosition - 2, makeAndAddView4.getTop() - i5);
        adjustViewsUpOrDown();
        fillDown(this.mSelectedPosition + 1, makeAndAddView4.getBottom() + i5);
        return makeAndAddView4;
    }

    private final int nextSelectedPositionForDirection(View view, int i, int i2) {
        int i3;
        if (i2 == 130) {
            int height = getHeight();
            int i4 = this.mListPadding.bottom;
            if (view == null || view.getBottom() > height - i4) {
                return -1;
            }
            i3 = (i == -1 || i < this.mFirstPosition) ? this.mFirstPosition : i + 1;
        } else {
            int i5 = this.mListPadding.top;
            if (view == null || view.getTop() < i5) {
                return -1;
            }
            int childCount = (this.mFirstPosition + getChildCount()) - 1;
            i3 = (i == -1 || i > childCount) ? childCount : i - 1;
        }
        if (i3 < 0 || i3 >= this.mAdapter.getCount()) {
            return -1;
        }
        return lookForSelectablePosition(i3, i2 == 130);
    }

    private int positionOfNewFocus(View view) {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
            }
            if (isViewAncestorOf(view, getChildAt(i2))) {
                return this.mFirstPosition + i2;
            }
            i = i2 + 1;
        }
    }

    private void relayoutMeasuredItem(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.mListPadding.left;
        int top = view.getTop();
        view.layout(i, top, i + measuredWidth, top + measuredHeight);
    }

    private void removeFixedViewInfo(View view, ArrayList<FixedViewInfo> arrayList) {
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            if (arrayList.get(i2).view == view) {
                arrayList.remove(i2);
                return;
            }
            i = i2 + 1;
        }
    }

    private void scrollListItemsBy(int i) {
        int i2;
        offsetChildrenTopAndBottom(i);
        int height = getHeight() - this.mListPadding.bottom;
        int i3 = this.mListPadding.top;
        AbsListView.RecycleBin recycleBin = this.mRecycler;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getBottom() < height && (i2 = (this.mFirstPosition + childCount) - 1) < this.mItemCount - 1) {
                childAt = addViewBelow(childAt, i2);
                childCount++;
            }
            if (childAt.getBottom() < height) {
                offsetChildrenTopAndBottom(height - childAt.getBottom());
            }
            View childAt2 = getChildAt(0);
            while (childAt2.getBottom() < i3) {
                if (recycleBin.shouldRecycleViewType(((AbsListView.LayoutParams) childAt2.getLayoutParams()).viewType)) {
                    recycleBin.addScrapView(childAt2, this.mFirstPosition);
                }
                detachViewFromParent(childAt2);
                childAt2 = getChildAt(0);
                this.mFirstPosition++;
            }
            return;
        }
        View childAt3 = getChildAt(0);
        while (childAt3.getTop() > i3 && this.mFirstPosition > 0) {
            childAt3 = addViewAbove(childAt3, this.mFirstPosition);
            this.mFirstPosition--;
        }
        if (childAt3.getTop() > i3) {
            offsetChildrenTopAndBottom(i3 - childAt3.getTop());
        }
        int childCount2 = getChildCount() - 1;
        View childAt4 = getChildAt(childCount2);
        while (true) {
            View view = childAt4;
            if (view.getTop() <= height) {
                return;
            }
            if (recycleBin.shouldRecycleViewType(((AbsListView.LayoutParams) view.getLayoutParams()).viewType)) {
                recycleBin.addScrapView(view, this.mFirstPosition + childCount2);
            }
            detachViewFromParent(view);
            childCount2--;
            childAt4 = getChildAt(childCount2);
        }
    }

    private void setupChild(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        Trace.traceBegin(8L, "setupListItem");
        boolean z4 = z2 && shouldShowSelector();
        boolean z5 = z4 != view.isSelected();
        int i4 = this.mTouchMode;
        boolean z6 = i4 > 0 && i4 < 3 && this.mMotionPosition == i;
        boolean z7 = z6 != view.isPressed();
        boolean z8 = !z3 || z5 || view.isLayoutRequested();
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        AbsListView.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = (AbsListView.LayoutParams) generateDefaultLayoutParams();
        }
        layoutParams2.viewType = this.mAdapter.getItemViewType(i);
        if ((!z3 || layoutParams2.forceAdd) && !(layoutParams2.recycledHeaderFooter && layoutParams2.viewType == -2)) {
            layoutParams2.forceAdd = false;
            if (layoutParams2.viewType == -2) {
                layoutParams2.recycledHeaderFooter = true;
            }
            addViewInLayout(view, z ? -1 : 0, layoutParams2, true);
        } else {
            attachViewToParent(view, z ? -1 : 0, layoutParams2);
        }
        if (z5) {
            view.setSelected(z4);
        }
        if (z7) {
            view.setPressed(z6);
        }
        if (this.mChoiceMode != 0 && this.mCheckStates != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.mCheckStates.get(i));
            } else if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
                view.setActivated(this.mCheckStates.get(i));
            }
        }
        if (z8) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListPadding.left + this.mListPadding.right, layoutParams2.width);
            int i5 = layoutParams2.height;
            view.measure(childMeasureSpec, i5 > 0 ? View.MeasureSpec.makeMeasureSpec(i5, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (!z) {
            i2 -= measuredHeight;
        }
        if (z8) {
            view.layout(i3, i2, i3 + measuredWidth, i2 + measuredHeight);
        } else {
            view.offsetLeftAndRight(i3 - view.getLeft());
            view.offsetTopAndBottom(i2 - view.getTop());
        }
        if (this.mCachingStarted && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (z3 && ((AbsListView.LayoutParams) view.getLayoutParams()).scrappedFromPosition != i) {
            view.jumpDrawablesToCurrentState();
        }
        Trace.traceEnd(8L);
    }

    private boolean shouldAdjustHeightForDivider(int i) {
        int i2 = this.mDividerHeight;
        Drawable drawable = this.mOverScrollHeader;
        Drawable drawable2 = this.mOverScrollFooter;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        if (i2 > 0 && this.mDivider != null) {
            boolean z3 = isOpaque() && !super.isOpaque();
            int i3 = this.mItemCount;
            int size = this.mHeaderViewInfos.size();
            int size2 = i3 - this.mFooterViewInfos.size();
            boolean z4 = i < size;
            boolean z5 = i >= size2;
            boolean z6 = this.mHeaderDividersEnabled;
            boolean z7 = this.mFooterDividersEnabled;
            if (z6 || !z4) {
                if (z7 || !z5) {
                    ListAdapter listAdapter = this.mAdapter;
                    if (this.mStackFromBottom) {
                        boolean z8 = i == (z ? 1 : 0);
                        if (z8) {
                            return false;
                        }
                        int i4 = i - 1;
                        if (listAdapter.isEnabled(i) && (z6 || (!z4 && i4 >= size))) {
                            if (z8) {
                                return true;
                            }
                            if (listAdapter.isEnabled(i4)) {
                                if (z7) {
                                    return true;
                                }
                                if (!z5 && i4 < size2) {
                                    return true;
                                }
                            }
                        }
                        return z3;
                    }
                    boolean z9 = i == i3 - 1;
                    if (z2 && z9) {
                        return false;
                    }
                    int i5 = i + 1;
                    if (listAdapter.isEnabled(i) && (z6 || (!z4 && i5 >= size))) {
                        if (z9) {
                            return true;
                        }
                        if (listAdapter.isEnabled(i5)) {
                            if (z7) {
                                return true;
                            }
                            if (!z5 && i5 < size2) {
                                return true;
                            }
                        }
                    }
                    return z3;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean showingBottomFadingEdge() {
        int childCount = getChildCount();
        return (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1 || getChildAt(childCount - 1).getBottom() < (this.mScrollY + getHeight()) - this.mListPadding.bottom;
    }

    private boolean showingTopFadingEdge() {
        boolean z = false;
        int i = this.mScrollY;
        int i2 = this.mListPadding.top;
        if (this.mFirstPosition > 0 || getChildAt(0).getTop() > i + i2) {
            z = true;
        }
        return z;
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true);
    }

    public void addFooterView(View view, Object obj, boolean z) {
        FixedViewInfo fixedViewInfo = new FixedViewInfo();
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.mFooterViewInfos.add(fixedViewInfo);
        this.mAreAllItemsSelectable &= z;
        if (this.mAdapter != null) {
            if (!(this.mAdapter instanceof HeaderViewListAdapter)) {
                this.mAdapter = new HeaderViewListAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, this.mAdapter);
            }
            if (this.mDataSetObserver != null) {
                this.mDataSetObserver.onChanged();
            }
        }
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        FixedViewInfo fixedViewInfo = new FixedViewInfo();
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.mHeaderViewInfos.add(fixedViewInfo);
        this.mAreAllItemsSelectable &= z;
        if (this.mAdapter != null) {
            if (!(this.mAdapter instanceof HeaderViewListAdapter)) {
                this.mAdapter = new HeaderViewListAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, this.mAdapter);
            }
            if (this.mDataSetObserver != null) {
                this.mDataSetObserver.onChanged();
            }
        }
    }

    public boolean areFooterDividersEnabled() {
        return this.mFooterDividersEnabled;
    }

    public boolean areHeaderDividersEnabled() {
        return this.mHeaderDividersEnabled;
    }

    boolean arrowScroll(int i) {
        try {
            this.mInLayout = true;
            boolean arrowScrollImpl = arrowScrollImpl(i);
            if (arrowScrollImpl) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return arrowScrollImpl;
        } finally {
            this.mInLayout = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AdapterView, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i;
        if (this.mCachingStarted) {
            this.mCachingActive = true;
        }
        int i2 = this.mDividerHeight;
        Drawable drawable = this.mOverScrollHeader;
        Drawable drawable2 = this.mOverScrollFooter;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        boolean z3 = i2 > 0 && this.mDivider != null;
        if (z3 || z || z2) {
            Rect rect = this.mTempRect;
            rect.left = this.mPaddingLeft;
            rect.right = (this.mRight - this.mLeft) - this.mPaddingRight;
            int childCount = getChildCount();
            int size = this.mHeaderViewInfos.size();
            int i3 = this.mItemCount;
            int size2 = i3 - this.mFooterViewInfos.size();
            boolean z4 = this.mHeaderDividersEnabled;
            boolean z5 = this.mFooterDividersEnabled;
            int i4 = this.mFirstPosition;
            boolean z6 = this.mAreAllItemsSelectable;
            ListAdapter listAdapter = this.mAdapter;
            boolean z7 = isOpaque() && !super.isOpaque();
            if (z7 && this.mDividerPaint == null && this.mIsCacheColorOpaque) {
                this.mDividerPaint = new Paint();
                this.mDividerPaint.setColor(getCacheColorHint());
            }
            Paint paint = this.mDividerPaint;
            int i5 = 0;
            int i6 = 0;
            if ((this.mGroupFlags & 34) == 34) {
                i5 = this.mListPadding.top;
                i6 = this.mListPadding.bottom;
            }
            int i7 = ((this.mBottom - this.mTop) - i6) + this.mScrollY;
            if (this.mStackFromBottom) {
                int i8 = this.mScrollY;
                if (childCount > 0 && z) {
                    rect.top = i8;
                    rect.bottom = getChildAt(0).getTop();
                    drawOverscrollHeader(canvas, drawable, rect);
                }
                int i9 = z ? 1 : 0;
                int i10 = i9;
                while (true) {
                    int i11 = i10;
                    if (i11 >= childCount) {
                        break;
                    }
                    int i12 = i4 + i11;
                    boolean z8 = i12 < size;
                    boolean z9 = i12 >= size2;
                    if ((z4 || !z8) && (z5 || !z9)) {
                        int top = getChildAt(i11).getTop();
                        if (z3 && top > i5) {
                            boolean z10 = i11 == i9;
                            int i13 = i12 - 1;
                            if (listAdapter.isEnabled(i12) && ((z4 || (!z8 && i13 >= size)) && (z10 || (listAdapter.isEnabled(i13) && (z5 || (!z9 && i13 < size2)))))) {
                                rect.top = top - i2;
                                rect.bottom = top;
                                drawDivider(canvas, rect, i11 - 1);
                            } else if (z7) {
                                rect.top = top - i2;
                                rect.bottom = top;
                                canvas.drawRect(rect, paint);
                            }
                        }
                    }
                    i10 = i11 + 1;
                }
                if (childCount > 0 && i8 > 0) {
                    if (z2) {
                        int i14 = this.mBottom;
                        rect.top = i14;
                        rect.bottom = i14 + i8;
                        drawOverscrollFooter(canvas, drawable2, rect);
                    } else if (z3) {
                        rect.top = i7;
                        rect.bottom = i7 + i2;
                        drawDivider(canvas, rect, -1);
                    }
                }
            } else {
                int i15 = 0;
                int i16 = this.mScrollY;
                if (childCount > 0 && i16 < 0) {
                    if (z) {
                        rect.bottom = 0;
                        rect.top = i16;
                        drawOverscrollHeader(canvas, drawable, rect);
                    } else if (z3) {
                        rect.bottom = 0;
                        rect.top = -i2;
                        drawDivider(canvas, rect, -1);
                    }
                }
                int i17 = 0;
                while (i17 < childCount) {
                    int i18 = i4 + i17;
                    boolean z11 = i18 < size;
                    boolean z12 = i18 >= size2;
                    if (!z4) {
                        i = i15;
                        if (z11) {
                            i17++;
                            i15 = i;
                        }
                    }
                    if (!z5) {
                        i = i15;
                        if (z12) {
                            i17++;
                            i15 = i;
                        }
                    }
                    int bottom = getChildAt(i17).getBottom();
                    boolean z13 = i17 == childCount - 1;
                    i = bottom;
                    if (z3) {
                        i = bottom;
                        if (bottom < i7) {
                            if (z2) {
                                i = bottom;
                                if (z13) {
                                }
                            }
                            int i19 = i18 + 1;
                            if (!listAdapter.isEnabled(i18) || ((!z4 && (z11 || i19 < size)) || (!z13 && (!listAdapter.isEnabled(i19) || (!z5 && (z12 || i19 >= size2)))))) {
                                i = bottom;
                                if (z7) {
                                    rect.top = bottom;
                                    rect.bottom = bottom + i2;
                                    canvas.drawRect(rect, paint);
                                    i = bottom;
                                }
                            } else {
                                rect.top = bottom;
                                rect.bottom = bottom + i2;
                                drawDivider(canvas, rect, i17);
                                i = bottom;
                            }
                        }
                    }
                    i17++;
                    i15 = i;
                }
                int i20 = this.mBottom + this.mScrollY;
                if (z2 && i4 + childCount == i3 && i20 > i15) {
                    rect.top = i15;
                    rect.bottom = i20;
                    drawOverscrollFooter(canvas, drawable2, rect);
                }
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        boolean z = dispatchKeyEvent;
        if (!dispatchKeyEvent) {
            z = dispatchKeyEvent;
            if (getFocusedChild() != null) {
                z = dispatchKeyEvent;
                if (keyEvent.getAction() == 0) {
                    z = onKeyDown(keyEvent.getKeyCode(), keyEvent);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.mCachingActive && view.mCachingFailed) {
            this.mCachingActive = false;
        }
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.mDivider;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumHeight = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.bottom - rect.top < minimumHeight) {
            rect.bottom = rect.top + minimumHeight;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumHeight = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.bottom - rect.top < minimumHeight) {
            rect.top = rect.bottom - minimumHeight;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.widget.AbsListView
    void fillGap(boolean z) {
        int childCount = getChildCount();
        if (!z) {
            int i = 0;
            if ((this.mGroupFlags & 34) == 34) {
                i = getListPaddingBottom();
            }
            fillUp(this.mFirstPosition - 1, childCount > 0 ? getChildAt(0).getTop() - this.mDividerHeight : getHeight() - i);
            correctTooLow(getChildCount());
            return;
        }
        int i2 = 0;
        if ((this.mGroupFlags & 34) == 34) {
            i2 = getListPaddingTop();
        }
        if (childCount > 0) {
            i2 = getChildAt(childCount - 1).getBottom() + this.mDividerHeight;
        }
        fillDown(this.mFirstPosition + childCount, i2);
        correctTooHigh(getChildCount());
    }

    @Override // android.widget.AbsListView
    int findMotionRow(int i) {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return -1;
        }
        if (this.mStackFromBottom) {
            int i2 = childCount;
            while (true) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    return -1;
                }
                if (i >= getChildAt(i3).getTop()) {
                    return this.mFirstPosition + i3;
                }
                i2 = i3;
            }
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= childCount) {
                    return -1;
                }
                if (i <= getChildAt(i5).getBottom()) {
                    return this.mFirstPosition + i5;
                }
                i4 = i5 + 1;
            }
        }
    }

    View findViewByPredicateInHeadersOrFooters(ArrayList<FixedViewInfo> arrayList, Predicate<View> predicate, View view) {
        View findViewByPredicate;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            View view2 = arrayList.get(i2).view;
            if (view2 != view && !view2.isRootNamespace() && (findViewByPredicate = view2.findViewByPredicate(predicate)) != null) {
                return findViewByPredicate;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public View findViewByPredicateTraversal(Predicate<View> predicate, View view) {
        View findViewByPredicateTraversal = super.findViewByPredicateTraversal(predicate, view);
        View view2 = findViewByPredicateTraversal;
        if (findViewByPredicateTraversal == null) {
            View findViewByPredicateInHeadersOrFooters = findViewByPredicateInHeadersOrFooters(this.mHeaderViewInfos, predicate, view);
            if (findViewByPredicateInHeadersOrFooters != null) {
                return findViewByPredicateInHeadersOrFooters;
            }
            View findViewByPredicateInHeadersOrFooters2 = findViewByPredicateInHeadersOrFooters(this.mFooterViewInfos, predicate, view);
            view2 = findViewByPredicateInHeadersOrFooters2;
            if (findViewByPredicateInHeadersOrFooters2 != null) {
                return findViewByPredicateInHeadersOrFooters2;
            }
        }
        return view2;
    }

    View findViewInHeadersOrFooters(ArrayList<FixedViewInfo> arrayList, int i) {
        View findViewById;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return null;
            }
            View view = arrayList.get(i3).view;
            if (!view.isRootNamespace() && (findViewById = view.findViewById(i)) != null) {
                return findViewById;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public View findViewTraversal(int i) {
        View findViewTraversal = super.findViewTraversal(i);
        View view = findViewTraversal;
        if (findViewTraversal == null) {
            View findViewInHeadersOrFooters = findViewInHeadersOrFooters(this.mHeaderViewInfos, i);
            if (findViewInHeadersOrFooters != null) {
                return findViewInHeadersOrFooters;
            }
            View findViewInHeadersOrFooters2 = findViewInHeadersOrFooters(this.mFooterViewInfos, i);
            view = findViewInHeadersOrFooters2;
            if (findViewInHeadersOrFooters2 != null) {
                return findViewInHeadersOrFooters2;
            }
        }
        return view;
    }

    View findViewWithTagInHeadersOrFooters(ArrayList<FixedViewInfo> arrayList, Object obj) {
        View findViewWithTag;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            View view = arrayList.get(i2).view;
            if (!view.isRootNamespace() && (findViewWithTag = view.findViewWithTag(obj)) != null) {
                return findViewWithTag;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public View findViewWithTagTraversal(Object obj) {
        View findViewWithTagTraversal = super.findViewWithTagTraversal(obj);
        View view = findViewWithTagTraversal;
        if (findViewWithTagTraversal == null) {
            View findViewWithTagInHeadersOrFooters = findViewWithTagInHeadersOrFooters(this.mHeaderViewInfos, obj);
            if (findViewWithTagInHeadersOrFooters != null) {
                return findViewWithTagInHeadersOrFooters;
            }
            View findViewWithTagInHeadersOrFooters2 = findViewWithTagInHeadersOrFooters(this.mFooterViewInfos, obj);
            view = findViewWithTagInHeadersOrFooters2;
            if (findViewWithTagInHeadersOrFooters2 != null) {
                return findViewWithTagInHeadersOrFooters2;
            }
        }
        return view;
    }

    boolean fullScroll(int i) {
        boolean z;
        if (i == 33) {
            z = false;
            if (this.mSelectedPosition != 0) {
                int lookForSelectablePositionAfter = lookForSelectablePositionAfter(this.mSelectedPosition, 0, true);
                if (lookForSelectablePositionAfter >= 0) {
                    this.mLayoutMode = 1;
                    setSelectionInt(lookForSelectablePositionAfter);
                    invokeOnItemScrollListener();
                }
                z = true;
            }
        } else {
            z = false;
            if (i == 130) {
                int i2 = this.mItemCount - 1;
                z = false;
                if (this.mSelectedPosition < i2) {
                    int lookForSelectablePositionAfter2 = lookForSelectablePositionAfter(this.mSelectedPosition, i2, false);
                    if (lookForSelectablePositionAfter2 >= 0) {
                        this.mLayoutMode = 3;
                        setSelectionInt(lookForSelectablePositionAfter2);
                        invokeOnItemScrollListener();
                    }
                    z = true;
                }
            }
        }
        if (z && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }
        return z;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        long[] jArr;
        if (this.mAdapter != null && this.mAdapter.hasStableIds()) {
            jArr = getCheckedItemIds();
        } else if (this.mChoiceMode == 0 || this.mCheckStates == null || this.mAdapter == null) {
            return new long[0];
        } else {
            SparseBooleanArray sparseBooleanArray = this.mCheckStates;
            int size = sparseBooleanArray.size();
            long[] jArr2 = new long[size];
            ListAdapter listAdapter = this.mAdapter;
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (sparseBooleanArray.valueAt(i2)) {
                    jArr2[i] = listAdapter.getItemId(sparseBooleanArray.keyAt(i2));
                    i++;
                }
            }
            jArr = jArr2;
            if (i != size) {
                long[] jArr3 = new long[i];
                System.arraycopy(jArr2, 0, jArr3, 0, i);
                return jArr3;
            }
        }
        return jArr;
    }

    public Drawable getDivider() {
        return this.mDivider;
    }

    public int getDividerHeight() {
        return this.mDividerHeight;
    }

    @Override // android.widget.AbsListView
    public int getFooterViewsCount() {
        return this.mFooterViewInfos.size();
    }

    @Override // android.widget.AbsListView
    public int getHeaderViewsCount() {
        return this.mHeaderViewInfos.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AbsListView
    public int getHeightForPosition(int i) {
        int heightForPosition = super.getHeightForPosition(i);
        int i2 = heightForPosition;
        if (shouldAdjustHeightForDivider(i)) {
            i2 = heightForPosition + this.mDividerHeight;
        }
        return i2;
    }

    public boolean getItemsCanFocus() {
        return this.mItemsCanFocus;
    }

    public int getMaxScrollAmount() {
        return (int) (MAX_SCROLL_FACTOR * (this.mBottom - this.mTop));
    }

    public Drawable getOverscrollFooter() {
        return this.mOverScrollFooter;
    }

    public Drawable getOverscrollHeader() {
        return this.mOverScrollHeader;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.mCachingActive && this.mIsCacheColorOpaque && this.mDividerIsOpaque && hasOpaqueScrollbars()) || super.isOpaque();
        boolean z2 = z;
        if (z) {
            int i = this.mListPadding != null ? this.mListPadding.top : this.mPaddingTop;
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getTop() > i) {
                z2 = false;
            } else {
                int height = getHeight();
                int i2 = this.mListPadding != null ? this.mListPadding.bottom : this.mPaddingBottom;
                View childAt2 = getChildAt(getChildCount() - 1);
                if (childAt2 == null) {
                    return false;
                }
                z2 = z;
                if (childAt2.getBottom() < height - i2) {
                    return false;
                }
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0274, code lost:
        if (isDirectChildHeaderOrFooter(r0) != false) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x036c A[Catch: all -> 0x01a8, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x01a8, blocks: (B:6:0x0011, B:8:0x0020, B:12:0x0033, B:14:0x0074, B:15:0x0078, B:32:0x00e6, B:34:0x00f1, B:36:0x00f6, B:38:0x00fc, B:49:0x0156, B:51:0x0166, B:52:0x01a7, B:59:0x01b7, B:61:0x01ce, B:64:0x01e4, B:67:0x01fb, B:72:0x0218, B:74:0x0221, B:77:0x022a, B:83:0x023c, B:81:0x0234, B:86:0x0256, B:91:0x026e, B:99:0x0297, B:94:0x0278, B:97:0x028a, B:101:0x029d, B:106:0x02b7, B:110:0x02da, B:111:0x02e6, B:179:0x0429, B:118:0x032b, B:120:0x0333, B:122:0x033a, B:124:0x0341, B:131:0x0355, B:139:0x036c, B:141:0x0377, B:143:0x037d, B:145:0x0384, B:148:0x0391, B:152:0x039e, B:154:0x03a6, B:158:0x03b7, B:226:0x05c1, B:229:0x05cf, B:231:0x05ea, B:161:0x03cd, B:163:0x03d5, B:165:0x03db, B:167:0x03eb, B:169:0x03fa, B:171:0x0411, B:173:0x0416, B:202:0x0525, B:134:0x035f, B:203:0x0535, B:204:0x053f, B:206:0x0547, B:211:0x0556, B:213:0x056a, B:215:0x0575, B:219:0x0580, B:220:0x0589, B:222:0x0591, B:224:0x05a5, B:225:0x05b2, B:180:0x043a, B:181:0x0446, B:182:0x0457, B:183:0x046c, B:184:0x047f, B:185:0x0490, B:114:0x0311, B:116:0x0318, B:186:0x04a1, B:187:0x04c1, B:189:0x04c8, B:191:0x04d3, B:193:0x04dd, B:194:0x04e8, B:195:0x04f1, B:197:0x04fc, B:199:0x0506, B:200:0x0511, B:201:0x051a, B:108:0x02d0, B:42:0x010f, B:47:0x0141, B:17:0x009d, B:22:0x00b8, B:24:0x00c0, B:26:0x00c7, B:28:0x00cd, B:30:0x00d8), top: B:238:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0525 A[Catch: all -> 0x01a8, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x01a8, blocks: (B:6:0x0011, B:8:0x0020, B:12:0x0033, B:14:0x0074, B:15:0x0078, B:32:0x00e6, B:34:0x00f1, B:36:0x00f6, B:38:0x00fc, B:49:0x0156, B:51:0x0166, B:52:0x01a7, B:59:0x01b7, B:61:0x01ce, B:64:0x01e4, B:67:0x01fb, B:72:0x0218, B:74:0x0221, B:77:0x022a, B:83:0x023c, B:81:0x0234, B:86:0x0256, B:91:0x026e, B:99:0x0297, B:94:0x0278, B:97:0x028a, B:101:0x029d, B:106:0x02b7, B:110:0x02da, B:111:0x02e6, B:179:0x0429, B:118:0x032b, B:120:0x0333, B:122:0x033a, B:124:0x0341, B:131:0x0355, B:139:0x036c, B:141:0x0377, B:143:0x037d, B:145:0x0384, B:148:0x0391, B:152:0x039e, B:154:0x03a6, B:158:0x03b7, B:226:0x05c1, B:229:0x05cf, B:231:0x05ea, B:161:0x03cd, B:163:0x03d5, B:165:0x03db, B:167:0x03eb, B:169:0x03fa, B:171:0x0411, B:173:0x0416, B:202:0x0525, B:134:0x035f, B:203:0x0535, B:204:0x053f, B:206:0x0547, B:211:0x0556, B:213:0x056a, B:215:0x0575, B:219:0x0580, B:220:0x0589, B:222:0x0591, B:224:0x05a5, B:225:0x05b2, B:180:0x043a, B:181:0x0446, B:182:0x0457, B:183:0x046c, B:184:0x047f, B:185:0x0490, B:114:0x0311, B:116:0x0318, B:186:0x04a1, B:187:0x04c1, B:189:0x04c8, B:191:0x04d3, B:193:0x04dd, B:194:0x04e8, B:195:0x04f1, B:197:0x04fc, B:199:0x0506, B:200:0x0511, B:201:0x051a, B:108:0x02d0, B:42:0x010f, B:47:0x0141, B:17:0x009d, B:22:0x00b8, B:24:0x00c0, B:26:0x00c7, B:28:0x00cd, B:30:0x00d8), top: B:238:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0556 A[Catch: all -> 0x01a8, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x01a8, blocks: (B:6:0x0011, B:8:0x0020, B:12:0x0033, B:14:0x0074, B:15:0x0078, B:32:0x00e6, B:34:0x00f1, B:36:0x00f6, B:38:0x00fc, B:49:0x0156, B:51:0x0166, B:52:0x01a7, B:59:0x01b7, B:61:0x01ce, B:64:0x01e4, B:67:0x01fb, B:72:0x0218, B:74:0x0221, B:77:0x022a, B:83:0x023c, B:81:0x0234, B:86:0x0256, B:91:0x026e, B:99:0x0297, B:94:0x0278, B:97:0x028a, B:101:0x029d, B:106:0x02b7, B:110:0x02da, B:111:0x02e6, B:179:0x0429, B:118:0x032b, B:120:0x0333, B:122:0x033a, B:124:0x0341, B:131:0x0355, B:139:0x036c, B:141:0x0377, B:143:0x037d, B:145:0x0384, B:148:0x0391, B:152:0x039e, B:154:0x03a6, B:158:0x03b7, B:226:0x05c1, B:229:0x05cf, B:231:0x05ea, B:161:0x03cd, B:163:0x03d5, B:165:0x03db, B:167:0x03eb, B:169:0x03fa, B:171:0x0411, B:173:0x0416, B:202:0x0525, B:134:0x035f, B:203:0x0535, B:204:0x053f, B:206:0x0547, B:211:0x0556, B:213:0x056a, B:215:0x0575, B:219:0x0580, B:220:0x0589, B:222:0x0591, B:224:0x05a5, B:225:0x05b2, B:180:0x043a, B:181:0x0446, B:182:0x0457, B:183:0x046c, B:184:0x047f, B:185:0x0490, B:114:0x0311, B:116:0x0318, B:186:0x04a1, B:187:0x04c1, B:189:0x04c8, B:191:0x04d3, B:193:0x04dd, B:194:0x04e8, B:195:0x04f1, B:197:0x04fc, B:199:0x0506, B:200:0x0511, B:201:0x051a, B:108:0x02d0, B:42:0x010f, B:47:0x0141, B:17:0x009d, B:22:0x00b8, B:24:0x00c0, B:26:0x00c7, B:28:0x00cd, B:30:0x00d8), top: B:238:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0589 A[Catch: all -> 0x01a8, TRY_ENTER, TryCatch #0 {all -> 0x01a8, blocks: (B:6:0x0011, B:8:0x0020, B:12:0x0033, B:14:0x0074, B:15:0x0078, B:32:0x00e6, B:34:0x00f1, B:36:0x00f6, B:38:0x00fc, B:49:0x0156, B:51:0x0166, B:52:0x01a7, B:59:0x01b7, B:61:0x01ce, B:64:0x01e4, B:67:0x01fb, B:72:0x0218, B:74:0x0221, B:77:0x022a, B:83:0x023c, B:81:0x0234, B:86:0x0256, B:91:0x026e, B:99:0x0297, B:94:0x0278, B:97:0x028a, B:101:0x029d, B:106:0x02b7, B:110:0x02da, B:111:0x02e6, B:179:0x0429, B:118:0x032b, B:120:0x0333, B:122:0x033a, B:124:0x0341, B:131:0x0355, B:139:0x036c, B:141:0x0377, B:143:0x037d, B:145:0x0384, B:148:0x0391, B:152:0x039e, B:154:0x03a6, B:158:0x03b7, B:226:0x05c1, B:229:0x05cf, B:231:0x05ea, B:161:0x03cd, B:163:0x03d5, B:165:0x03db, B:167:0x03eb, B:169:0x03fa, B:171:0x0411, B:173:0x0416, B:202:0x0525, B:134:0x035f, B:203:0x0535, B:204:0x053f, B:206:0x0547, B:211:0x0556, B:213:0x056a, B:215:0x0575, B:219:0x0580, B:220:0x0589, B:222:0x0591, B:224:0x05a5, B:225:0x05b2, B:180:0x043a, B:181:0x0446, B:182:0x0457, B:183:0x046c, B:184:0x047f, B:185:0x0490, B:114:0x0311, B:116:0x0318, B:186:0x04a1, B:187:0x04c1, B:189:0x04c8, B:191:0x04d3, B:193:0x04dd, B:194:0x04e8, B:195:0x04f1, B:197:0x04fc, B:199:0x0506, B:200:0x0511, B:201:0x051a, B:108:0x02d0, B:42:0x010f, B:47:0x0141, B:17:0x009d, B:22:0x00b8, B:24:0x00c0, B:26:0x00c7, B:28:0x00cd, B:30:0x00d8), top: B:238:0x0011 }] */
    @Override // android.widget.AbsListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layoutChildren() {
        /*
            Method dump skipped, instructions count: 1549
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.ListView.layoutChildren():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AdapterView
    public int lookForSelectablePosition(int i, boolean z) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
        int count = listAdapter.getCount();
        int i2 = i;
        if (!this.mAreAllItemsSelectable) {
            if (!z) {
                int min = Math.min(i, count - 1);
                while (true) {
                    int i3 = min;
                    i2 = i3;
                    if (i3 < 0) {
                        break;
                    }
                    i2 = i3;
                    if (listAdapter.isEnabled(i3)) {
                        break;
                    }
                    min = i3 - 1;
                }
            } else {
                int max = Math.max(0, i);
                while (true) {
                    int i4 = max;
                    i2 = i4;
                    if (i4 >= count) {
                        break;
                    }
                    i2 = i4;
                    if (listAdapter.isEnabled(i4)) {
                        break;
                    }
                    max = i4 + 1;
                }
            }
        }
        if (i2 < 0 || i2 >= count) {
            return -1;
        }
        return i2;
    }

    int lookForSelectablePositionAfter(int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || isInTouchMode()) {
            i3 = -1;
        } else {
            int lookForSelectablePosition = lookForSelectablePosition(i2, z);
            i3 = lookForSelectablePosition;
            if (lookForSelectablePosition == -1) {
                int count = listAdapter.getCount();
                int constrain = MathUtils.constrain(i, -1, count - 1);
                if (z) {
                    int min = Math.min(i2 - 1, count - 1);
                    while (true) {
                        i6 = min;
                        if (i6 <= constrain || listAdapter.isEnabled(i6)) {
                            break;
                        }
                        min = i6 - 1;
                    }
                    i5 = i6;
                    if (i6 <= constrain) {
                        return -1;
                    }
                } else {
                    int max = Math.max(0, i2 + 1);
                    while (true) {
                        i4 = max;
                        if (i4 >= constrain || listAdapter.isEnabled(i4)) {
                            break;
                        }
                        max = i4 + 1;
                    }
                    i5 = i4;
                    if (i4 >= constrain) {
                        return -1;
                    }
                }
                return i5;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int measureHeightOfChildren(int i, int i2, int i3, int i4, int i5) {
        int i6;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            i6 = this.mListPadding.top + this.mListPadding.bottom;
        } else {
            int i7 = this.mListPadding.top + this.mListPadding.bottom;
            int i8 = (this.mDividerHeight <= 0 || this.mDivider == null) ? 0 : this.mDividerHeight;
            int i9 = i3;
            if (i3 == -1) {
                i9 = listAdapter.getCount() - 1;
            }
            AbsListView.RecycleBin recycleBin = this.mRecycler;
            boolean recycleOnMeasure = recycleOnMeasure();
            boolean[] zArr = this.mIsScrap;
            int i10 = i2;
            int i11 = i7;
            int i12 = 0;
            while (true) {
                i6 = i12;
                if (i10 > i9) {
                    return i11;
                }
                View obtainView = obtainView(i10, zArr);
                measureScrapChild(obtainView, i10, i);
                int i13 = i11;
                if (i10 > 0) {
                    i13 = i11 + i8;
                }
                if (recycleOnMeasure && recycleBin.shouldRecycleViewType(((AbsListView.LayoutParams) obtainView.getLayoutParams()).viewType)) {
                    recycleBin.addScrapView(obtainView, -1);
                }
                i11 = i13 + obtainView.getMeasuredHeight();
                if (i11 < i4) {
                    int i14 = i6;
                    if (i5 >= 0) {
                        i14 = i6;
                        if (i10 >= i5) {
                            i14 = i11;
                        }
                    }
                    i10++;
                    i12 = i14;
                } else if (i5 < 0 || i10 <= i5 || i6 <= 0 || i11 == i4) {
                    return i4;
                }
            }
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                removeAllViews();
                return;
            } else {
                addHeaderView(getChildAt(i2));
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        int i2;
        super.onFocusChanged(z, i, rect);
        ListAdapter listAdapter = this.mAdapter;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        if (listAdapter != null) {
            i5 = 0;
            i6 = -1;
            if (z) {
                i5 = 0;
                i6 = -1;
                if (rect != null) {
                    rect.offset(this.mScrollX, this.mScrollY);
                    if (listAdapter.getCount() < getChildCount() + this.mFirstPosition) {
                        this.mLayoutMode = 0;
                        layoutChildren();
                    }
                    Rect rect2 = this.mTempRect;
                    int i7 = Integer.MAX_VALUE;
                    int childCount = getChildCount();
                    int i8 = this.mFirstPosition;
                    int i9 = 0;
                    while (true) {
                        i5 = i4;
                        i6 = i3;
                        if (i9 >= childCount) {
                            break;
                        }
                        if (listAdapter.isEnabled(i8 + i9)) {
                            View childAt = getChildAt(i9);
                            childAt.getDrawingRect(rect2);
                            offsetDescendantRectToMyCoords(childAt, rect2);
                            int distance = getDistance(rect, rect2, i);
                            i2 = i7;
                            if (distance < i7) {
                                i2 = distance;
                                i3 = i9;
                                i4 = childAt.getTop();
                            }
                        } else {
                            i2 = i7;
                        }
                        i9++;
                        i7 = i2;
                    }
                }
            }
        }
        if (i6 >= 0) {
            setSelectionFromTop(this.mFirstPosition + i6, i5);
        } else {
            requestLayout();
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ListView.class.getName());
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ListView.class.getName());
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(getCount(), 1, false, getSelectionModeForAccessibility()));
    }

    @Override // android.widget.AbsListView
    public void onInitializeAccessibilityNodeInfoForItem(View view, int i, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfoForItem(view, i, accessibilityNodeInfo);
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, 1, 0, 1, (layoutParams == null || layoutParams.viewType == -2) ? false : true, isItemChecked(i)));
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return commonKey(i, 1, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return commonKey(i, i2, keyEvent);
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return commonKey(i, 1, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0057, code lost:
        if (r0 == 0) goto L10;
     */
    @Override // android.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.ListView.onMeasure(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int i5 = this.mFirstPosition;
            int indexOfChild = indexOfChild(focusedChild);
            int max = Math.max(0, focusedChild.getBottom() - (i2 - this.mPaddingTop));
            int top = focusedChild.getTop();
            if (this.mFocusSelector == null) {
                this.mFocusSelector = new FocusSelector();
            }
            post(this.mFocusSelector.setup(i5 + indexOfChild, top - max));
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    boolean pageScroll(int i) {
        boolean z;
        int min;
        boolean z2;
        if (i != 33) {
            z = false;
            if (i == 130) {
                min = Math.min(this.mItemCount - 1, (this.mSelectedPosition + getChildCount()) - 1);
                z2 = true;
            }
            return z;
        }
        min = Math.max(0, (this.mSelectedPosition - getChildCount()) - 1);
        z2 = false;
        z = false;
        if (min >= 0) {
            int lookForSelectablePositionAfter = lookForSelectablePositionAfter(this.mSelectedPosition, min, z2);
            z = false;
            if (lookForSelectablePositionAfter >= 0) {
                this.mLayoutMode = 4;
                this.mSpecificTop = this.mPaddingTop + getVerticalFadingEdgeLength();
                if (z2 && lookForSelectablePositionAfter > this.mItemCount - getChildCount()) {
                    this.mLayoutMode = 3;
                }
                if (!z2 && lookForSelectablePositionAfter < getChildCount()) {
                    this.mLayoutMode = 1;
                }
                setSelectionInt(lookForSelectablePositionAfter);
                invokeOnItemScrollListener();
                if (!awakenScrollBars()) {
                    invalidate();
                }
                z = true;
            }
        }
        return z;
    }

    @ViewDebug.ExportedProperty(category = "list")
    protected boolean recycleOnMeasure() {
        return true;
    }

    public boolean removeFooterView(View view) {
        if (this.mFooterViewInfos.size() > 0) {
            boolean z = false;
            if (this.mAdapter != null) {
                z = false;
                if (((HeaderViewListAdapter) this.mAdapter).removeFooter(view)) {
                    if (this.mDataSetObserver != null) {
                        this.mDataSetObserver.onChanged();
                    }
                    z = true;
                }
            }
            removeFixedViewInfo(view, this.mFooterViewInfos);
            return z;
        }
        return false;
    }

    public boolean removeHeaderView(View view) {
        if (this.mHeaderViewInfos.size() > 0) {
            boolean z = false;
            if (this.mAdapter != null) {
                z = false;
                if (((HeaderViewListAdapter) this.mAdapter).removeHeader(view)) {
                    if (this.mDataSetObserver != null) {
                        this.mDataSetObserver.onChanged();
                    }
                    z = true;
                }
            }
            removeFixedViewInfo(view, this.mHeaderViewInfos);
            return z;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0091, code lost:
        if (r6.bottom < (r0 - r0)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0053, code lost:
        if (r0 > r0) goto L7;
     */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean requestChildRectangleOnScreen(android.view.View r5, android.graphics.Rect r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.ListView.requestChildRectangleOnScreen(android.view.View, android.graphics.Rect, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AbsListView
    public void resetList() {
        clearRecycledState(this.mHeaderViewInfos);
        clearRecycledState(this.mFooterViewInfos);
        super.resetList();
        this.mLayoutMode = 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.widget.AbsListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.mAdapter != null && this.mDataSetObserver != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        resetList();
        this.mRecycler.clear();
        if (this.mHeaderViewInfos.size() > 0 || this.mFooterViewInfos.size() > 0) {
            this.mAdapter = new HeaderViewListAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
        } else {
            this.mAdapter = listAdapter;
        }
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.mAdapter != null) {
            this.mAreAllItemsSelectable = this.mAdapter.areAllItemsEnabled();
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            checkFocus();
            this.mDataSetObserver = new AbsListView.AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            this.mRecycler.setViewTypeCount(this.mAdapter.getViewTypeCount());
            int lookForSelectablePosition = this.mStackFromBottom ? lookForSelectablePosition(this.mItemCount - 1, false) : lookForSelectablePosition(0, true);
            setSelectedPositionInt(lookForSelectablePosition);
            setNextSelectedPositionInt(lookForSelectablePosition);
            if (this.mItemCount == 0) {
                checkSelectionChanged();
            }
        } else {
            this.mAreAllItemsSelectable = true;
            checkFocus();
            checkSelectionChanged();
        }
        requestLayout();
    }

    @Override // android.widget.AbsListView
    public void setCacheColorHint(int i) {
        boolean z = (i >>> 24) == 255;
        this.mIsCacheColorOpaque = z;
        if (z) {
            if (this.mDividerPaint == null) {
                this.mDividerPaint = new Paint();
            }
            this.mDividerPaint.setColor(i);
        }
        super.setCacheColorHint(i);
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerHeight = 0;
        }
        this.mDivider = drawable;
        if (drawable == null || drawable.getOpacity() == -1) {
            z = true;
        }
        this.mDividerIsOpaque = z;
        requestLayout();
        invalidate();
    }

    public void setDividerHeight(int i) {
        this.mDividerHeight = i;
        requestLayout();
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.mFooterDividersEnabled = z;
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.mHeaderDividersEnabled = z;
        invalidate();
    }

    public void setItemsCanFocus(boolean z) {
        this.mItemsCanFocus = z;
        if (z) {
            return;
        }
        setDescendantFocusability(393216);
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.mOverScrollFooter = drawable;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.mOverScrollHeader = drawable;
        if (this.mScrollY < 0) {
            invalidate();
        }
    }

    @Override // android.widget.AbsListView
    @RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        super.setRemoteViewsAdapter(intent);
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        setSelectionFromTop(i, 0);
    }

    public void setSelectionAfterHeaderView() {
        int size = this.mHeaderViewInfos.size();
        if (size > 0) {
            this.mNextSelectedPosition = 0;
        } else if (this.mAdapter != null) {
            setSelection(size);
        } else {
            this.mNextSelectedPosition = size;
            this.mLayoutMode = 2;
        }
    }

    @Override // android.widget.AbsListView
    void setSelectionInt(int i) {
        setNextSelectedPositionInt(i);
        int i2 = this.mSelectedPosition;
        boolean z = false;
        if (i2 >= 0) {
            if (i == i2 - 1) {
                z = true;
            } else {
                z = false;
                if (i == i2 + 1) {
                    z = true;
                }
            }
        }
        if (this.mPositionScroller != null) {
            this.mPositionScroller.stop();
        }
        layoutChildren();
        if (z) {
            awakenScrollBars();
        }
    }

    @Override // android.widget.AbsListView
    @RemotableViewMethod
    public void smoothScrollByOffset(int i) {
        super.smoothScrollByOffset(i);
    }

    @Override // android.widget.AbsListView
    @RemotableViewMethod
    public void smoothScrollToPosition(int i) {
        super.smoothScrollToPosition(i);
    }
}
