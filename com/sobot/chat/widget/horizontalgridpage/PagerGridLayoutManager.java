package com.sobot.chat.widget.horizontalgridpage;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.sobot.chat.utils.LogUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/PagerGridLayoutManager.class */
public class PagerGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 1;
    private static final String TAG = PagerGridLayoutManager.class.getSimpleName();
    public static final int VERTICAL = 0;
    private int mColumns;
    private int mMaxScrollX;
    private int mMaxScrollY;
    private int mOnePageSize;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mRows;
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int mItemWidth = 0;
    private int mItemHeight = 0;
    private int mWidthUsed = 0;
    private int mHeightUsed = 0;
    private int mScrollState = 0;
    private boolean mAllowContinuousScroll = true;
    private boolean mChangeSelectInScrolling = true;
    private int mLastPageCount = -1;
    private int mLastPageIndex = -1;
    private PageListener mPageListener = null;
    private SparseArray<Rect> mItemFrames = new SparseArray<>();

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/PagerGridLayoutManager$OrientationType.class */
    public @interface OrientationType {
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/PagerGridLayoutManager$PageListener.class */
    public interface PageListener {
        void onPageSelect(int i);

        void onPageSizeChanged(int i);
    }

    public PagerGridLayoutManager(int i, int i2, int i3) {
        this.mOrientation = i3;
        this.mRows = i;
        this.mColumns = i2;
        this.mOnePageSize = i * i2;
    }

    private void addOrRemove(RecyclerView.Recycler recycler, Rect rect, int i) {
        View viewForPosition = recycler.getViewForPosition(i);
        Rect itemFrameByPosition = getItemFrameByPosition(i);
        if (!Rect.intersects(rect, itemFrameByPosition)) {
            removeAndRecycleView(viewForPosition, recycler);
            return;
        }
        addView(viewForPosition);
        measureChildWithMargins(viewForPosition, this.mWidthUsed, this.mHeightUsed);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
        layoutDecorated(viewForPosition, (itemFrameByPosition.left - this.mOffsetX) + layoutParams.leftMargin + getPaddingLeft(), (itemFrameByPosition.top - this.mOffsetY) + layoutParams.topMargin + getPaddingTop(), ((itemFrameByPosition.right - this.mOffsetX) - layoutParams.rightMargin) + getPaddingLeft(), ((itemFrameByPosition.bottom - this.mOffsetY) - layoutParams.bottomMargin) + getPaddingTop());
    }

    private Rect getItemFrameByPosition(int i) {
        int usableHeight;
        Rect rect = this.mItemFrames.get(i);
        Rect rect2 = rect;
        if (rect == null) {
            rect2 = new Rect();
            int i2 = i / this.mOnePageSize;
            int i3 = 0;
            if (canScrollHorizontally()) {
                i3 = (getUsableWidth() * i2) + 0;
                usableHeight = 0;
            } else {
                usableHeight = (getUsableHeight() * i2) + 0;
            }
            int i4 = i % this.mOnePageSize;
            int i5 = this.mColumns;
            int i6 = i4 / i5;
            int i7 = i4 - (i5 * i6);
            int i8 = i3 + (this.mItemWidth * i7);
            int i9 = usableHeight + (this.mItemHeight * i6);
            LogUtils.i("pagePos = " + i4);
            LogUtils.i("行 = " + i6);
            LogUtils.i("列 = " + i7);
            LogUtils.i("offsetX = " + i8);
            LogUtils.i("offsetY = " + i9);
            rect2.left = i8;
            rect2.top = i9;
            rect2.right = i8 + this.mItemWidth;
            rect2.bottom = i9 + this.mItemHeight;
            this.mItemFrames.put(i, rect2);
        }
        return rect2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
        if ((r0 % r0) > (r0 / 2)) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
        if ((r0 % r0) > (r0 / 2)) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
        r5 = r6 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getPageIndexByOffset() {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.canScrollVertically()
            r9 = r0
            r0 = 0
            r6 = r0
            r0 = r9
            if (r0 == 0) goto L3c
            r0 = r4
            int r0 = r0.getUsableHeight()
            r7 = r0
            r0 = r4
            int r0 = r0.mOffsetY
            r8 = r0
            r0 = r6
            r5 = r0
            r0 = r8
            if (r0 <= 0) goto L6c
            r0 = r7
            if (r0 > 0) goto L28
            r0 = r6
            r5 = r0
            goto L6c
        L28:
            r0 = r8
            r1 = r7
            int r0 = r0 / r1
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r8
            r1 = r7
            int r0 = r0 % r1
            r1 = r7
            r2 = 2
            int r1 = r1 / r2
            if (r0 <= r1) goto L6c
            goto L68
        L3c:
            r0 = r4
            int r0 = r0.getUsableWidth()
            r7 = r0
            r0 = r4
            int r0 = r0.mOffsetX
            r8 = r0
            r0 = r6
            r5 = r0
            r0 = r8
            if (r0 <= 0) goto L6c
            r0 = r7
            if (r0 > 0) goto L57
            r0 = r6
            r5 = r0
            goto L6c
        L57:
            r0 = r8
            r1 = r7
            int r0 = r0 / r1
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r8
            r1 = r7
            int r0 = r0 % r1
            r1 = r7
            r2 = 2
            int r1 = r1 / r2
            if (r0 <= r1) goto L6c
        L68:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
        L6c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            java.lang.String r1 = "getPageIndexByOffset pageIndex = "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r0 = r0.toString()
            com.sobot.chat.utils.LogUtils.i(r0)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.horizontalgridpage.PagerGridLayoutManager.getPageIndexByOffset():int");
    }

    private int getPageIndexByPos(int i) {
        return i / this.mOnePageSize;
    }

    private int[] getPageLeftTopByPosition(int i) {
        int[] iArr = new int[2];
        int pageIndexByPos = getPageIndexByPos(i);
        if (canScrollHorizontally()) {
            iArr[0] = pageIndexByPos * getUsableWidth();
            iArr[1] = 0;
            return iArr;
        }
        iArr[0] = 0;
        iArr[1] = pageIndexByPos * getUsableHeight();
        return iArr;
    }

    private int getTotalPageCount() {
        if (getItemCount() <= 0) {
            return 0;
        }
        int itemCount = getItemCount() / this.mOnePageSize;
        int i = itemCount;
        if (getItemCount() % this.mOnePageSize != 0) {
            i = itemCount + 1;
        }
        return i;
    }

    private int getUsableHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getUsableWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void recycleAndFillItems(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        if (state.isPreLayout()) {
            return;
        }
        LogUtils.i("mOffsetX = " + this.mOffsetX);
        LogUtils.i("mOffsetY = " + this.mOffsetY);
        Rect rect = new Rect(this.mOffsetX - this.mItemWidth, this.mOffsetY - this.mItemHeight, getUsableWidth() + this.mOffsetX + this.mItemWidth, getUsableHeight() + this.mOffsetY + this.mItemHeight);
        int i = 0;
        rect.intersect(0, 0, this.mMaxScrollX + getUsableWidth(), this.mMaxScrollY + getUsableHeight());
        LogUtils.e("displayRect = " + rect.toString());
        int pageIndexByOffset = getPageIndexByOffset() * this.mOnePageSize;
        LogUtils.i("startPos = " + pageIndexByOffset);
        int i2 = pageIndexByOffset - (this.mOnePageSize * 2);
        if (i2 >= 0) {
            i = i2;
        }
        int i3 = (this.mOnePageSize * 4) + i;
        int i4 = i3;
        if (i3 > getItemCount()) {
            i4 = getItemCount();
        }
        LogUtils.e("startPos = " + i);
        LogUtils.e("stopPos = " + i4);
        detachAndScrapAttachedViews(recycler);
        if (!z) {
            while (true) {
                i4--;
                if (i4 < i) {
                    break;
                }
                addOrRemove(recycler, rect, i4);
            }
        } else {
            while (i < i4) {
                addOrRemove(recycler, rect, i);
                i++;
            }
        }
        LogUtils.e("child count = " + getChildCount());
    }

    private void setPageCount(int i) {
        if (i >= 0) {
            PageListener pageListener = this.mPageListener;
            if (pageListener != null && i != this.mLastPageCount) {
                pageListener.onPageSizeChanged(i);
            }
            this.mLastPageCount = i;
        }
    }

    private void setPageIndex(int i, boolean z) {
        PageListener pageListener;
        LogUtils.e("setPageIndex = " + i + ":" + z);
        if (i == this.mLastPageIndex) {
            return;
        }
        if (isAllowContinuousScroll()) {
            this.mLastPageIndex = i;
        } else if (!z) {
            this.mLastPageIndex = i;
        }
        if ((!z || this.mChangeSelectInScrolling) && i >= 0 && (pageListener = this.mPageListener) != null) {
            pageListener.onPageSelect(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        PointF pointF = new PointF();
        int[] snapOffset = getSnapOffset(i);
        pointF.x = snapOffset[0];
        pointF.y = snapOffset[1];
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findNextPageFirstPos() {
        int i = this.mLastPageIndex + 1;
        int i2 = i;
        if (i >= getTotalPageCount()) {
            i2 = getTotalPageCount() - 1;
        }
        LogUtils.e("computeScrollVectorForPosition next = " + i2);
        return i2 * this.mOnePageSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findPrePageFirstPos() {
        int i = this.mLastPageIndex - 1;
        LogUtils.e("computeScrollVectorForPosition pre = " + i);
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        LogUtils.e("computeScrollVectorForPosition pre = " + i2);
        return i2 * this.mOnePageSize;
    }

    public View findSnapView() {
        if (getFocusedChild() != null) {
            return getFocusedChild();
        }
        if (getChildCount() <= 0) {
            return null;
        }
        int pageIndexByOffset = getPageIndexByOffset();
        int i = this.mOnePageSize;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= getChildCount()) {
                return getChildAt(0);
            }
            if (getPosition(getChildAt(i3)) == pageIndexByOffset * i) {
                return getChildAt(i3);
            }
            i2 = i3 + 1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getOffsetX() {
        return this.mOffsetX;
    }

    public int getOffsetY() {
        return this.mOffsetY;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getSnapOffset(int i) {
        int[] pageLeftTopByPosition = getPageLeftTopByPosition(i);
        return new int[]{pageLeftTopByPosition[0] - this.mOffsetX, pageLeftTopByPosition[1] - this.mOffsetY};
    }

    public boolean isAllowContinuousScroll() {
        return this.mAllowContinuousScroll;
    }

    public boolean isFirstPage() {
        LogUtils.i("getPageIndexByOffset = " + getPageIndexByOffset() + "   mLastPageCount=" + this.mLastPageCount + ")");
        return getPageIndexByOffset() == 0;
    }

    public boolean isLastPage() {
        LogUtils.i("getPageIndexByOffset = " + (getPageIndexByOffset() + 1) + "   mLastPageCount=" + this.mLastPageCount + ")");
        return getPageIndexByOffset() + 1 == this.mLastPageCount;
    }

    public void nextPage() {
        scrollToPage(getPageIndexByOffset() + 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        LogUtils.i("Item onLayoutChildren");
        LogUtils.i("Item onLayoutChildren isPreLayout = " + state.isPreLayout());
        LogUtils.i("Item onLayoutChildren isMeasuring = " + state.isMeasuring());
        LogUtils.e("Item onLayoutChildren state = " + state);
        if (state.isPreLayout() || !state.didStructureChange()) {
            return;
        }
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            setPageCount(0);
            setPageIndex(0, false);
            return;
        }
        setPageCount(getTotalPageCount());
        setPageIndex(getPageIndexByOffset(), false);
        int itemCount = getItemCount() / this.mOnePageSize;
        int i = itemCount;
        if (getItemCount() % this.mOnePageSize != 0) {
            i = itemCount + 1;
        }
        if (canScrollHorizontally()) {
            int usableWidth = (i - 1) * getUsableWidth();
            this.mMaxScrollX = usableWidth;
            this.mMaxScrollY = 0;
            if (this.mOffsetX > usableWidth) {
                this.mOffsetX = usableWidth;
            }
        } else {
            this.mMaxScrollX = 0;
            int usableHeight = (i - 1) * getUsableHeight();
            this.mMaxScrollY = usableHeight;
            if (this.mOffsetY > usableHeight) {
                this.mOffsetY = usableHeight;
            }
        }
        LogUtils.i("count = " + getItemCount());
        if (this.mItemWidth <= 0) {
            this.mItemWidth = getUsableWidth() / this.mColumns;
        }
        if (this.mItemHeight <= 0) {
            this.mItemHeight = getUsableHeight() / this.mRows;
        }
        this.mWidthUsed = getUsableWidth() - this.mItemWidth;
        this.mHeightUsed = getUsableHeight() - this.mItemHeight;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mOnePageSize * 2) {
                break;
            }
            getItemFrameByPosition(i3);
            i2 = i3 + 1;
        }
        if (this.mOffsetX == 0 && this.mOffsetY == 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.mOnePageSize || i5 >= getItemCount()) {
                    break;
                }
                View viewForPosition = recycler.getViewForPosition(i5);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, this.mWidthUsed, this.mHeightUsed);
                i4 = i5 + 1;
            }
        }
        recycleAndFillItems(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (state.isPreLayout()) {
            return;
        }
        setPageCount(getTotalPageCount());
        setPageIndex(getPageIndexByOffset(), false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        super.onMeasure(recycler, state, i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i3 = mode;
        if (mode != 1073741824) {
            i3 = mode;
            if (size > 0) {
                i3 = 1073741824;
            }
        }
        int i4 = mode2;
        if (mode2 != 1073741824) {
            i4 = mode2;
            if (size2 > 0) {
                i4 = 1073741824;
            }
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, i3), View.MeasureSpec.makeMeasureSpec(size2, i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        LogUtils.i("onScrollStateChanged = " + i);
        this.mScrollState = i;
        super.onScrollStateChanged(i);
        if (i == 0) {
            setPageIndex(getPageIndexByOffset(), false);
        }
    }

    public void prePage() {
        scrollToPage(getPageIndexByOffset() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = this.mOffsetX;
        int i3 = i2 + i;
        int i4 = this.mMaxScrollX;
        if (i3 > i4) {
            i = i4 - i2;
        } else if (i3 < 0) {
            i = 0 - i2;
        }
        this.mOffsetX += i;
        setPageIndex(getPageIndexByOffset(), true);
        offsetChildrenHorizontal(-i);
        if (i > 0) {
            recycleAndFillItems(recycler, state, true);
            return i;
        }
        recycleAndFillItems(recycler, state, false);
        return i;
    }

    public void scrollToPage(int i) {
        int usableWidth;
        int i2;
        if (i < 0 || i >= this.mLastPageCount) {
            LogUtils.e("pageIndex = " + i + " is out of bounds, mast in [0, " + this.mLastPageCount + ")");
        } else if (this.mRecyclerView == null) {
            LogUtils.e("RecyclerView Not Found!");
        } else {
            if (canScrollVertically()) {
                i2 = (getUsableHeight() * i) - this.mOffsetY;
                usableWidth = 0;
            } else {
                usableWidth = (getUsableWidth() * i) - this.mOffsetX;
                i2 = 0;
            }
            LogUtils.e("mTargetOffsetXBy = " + usableWidth);
            LogUtils.e("mTargetOffsetYBy = " + i2);
            this.mRecyclerView.scrollBy(usableWidth, i2);
            setPageIndex(i, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        scrollToPage(getPageIndexByPos(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = this.mOffsetY;
        int i3 = i2 + i;
        int i4 = this.mMaxScrollY;
        if (i3 > i4) {
            i = i4 - i2;
        } else if (i3 < 0) {
            i = 0 - i2;
        }
        this.mOffsetY += i;
        setPageIndex(getPageIndexByOffset(), true);
        offsetChildrenVertical(-i);
        if (i > 0) {
            recycleAndFillItems(recycler, state, true);
            return i;
        }
        recycleAndFillItems(recycler, state, false);
        return i;
    }

    public void setAllowContinuousScroll(boolean z) {
        this.mAllowContinuousScroll = z;
    }

    public void setChangeSelectInScrolling(boolean z) {
        this.mChangeSelectInScrolling = z;
    }

    public int setOrientationType(int i) {
        if (this.mOrientation == i || this.mScrollState != 0) {
            return this.mOrientation;
        }
        this.mOrientation = i;
        this.mItemFrames.clear();
        int i2 = this.mOffsetX;
        this.mOffsetX = (this.mOffsetY / getUsableHeight()) * getUsableWidth();
        this.mOffsetY = (i2 / getUsableWidth()) * getUsableHeight();
        int i3 = this.mMaxScrollX;
        this.mMaxScrollX = (this.mMaxScrollY / getUsableHeight()) * getUsableWidth();
        this.mMaxScrollY = (i3 / getUsableWidth()) * getUsableHeight();
        return this.mOrientation;
    }

    public void setPageListener(PageListener pageListener) {
        this.mPageListener = pageListener;
    }

    public void smoothNextPage() {
        smoothScrollToPage(getPageIndexByOffset() + 1);
    }

    public void smoothPrePage() {
        smoothScrollToPage(getPageIndexByOffset() - 1);
    }

    public void smoothScrollToPage(int i) {
        if (i < 0 || i >= this.mLastPageCount) {
            LogUtils.e("pageIndex is outOfIndex, must in [0, " + this.mLastPageCount + ").");
        } else if (this.mRecyclerView == null) {
            LogUtils.e("RecyclerView Not Found!");
        } else {
            int pageIndexByOffset = getPageIndexByOffset();
            if (Math.abs(i - pageIndexByOffset) > 3) {
                if (i > pageIndexByOffset) {
                    scrollToPage(i - 3);
                } else if (i < pageIndexByOffset) {
                    scrollToPage(i + 3);
                }
            }
            PagerGridSmoothScroller pagerGridSmoothScroller = new PagerGridSmoothScroller(this.mRecyclerView);
            pagerGridSmoothScroller.setTargetPosition(i * this.mOnePageSize);
            startSmoothScroll(pagerGridSmoothScroller);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        smoothScrollToPage(getPageIndexByPos(i));
    }
}
