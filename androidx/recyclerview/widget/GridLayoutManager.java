package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/GridLayoutManager.class */
public class GridLayoutManager extends LinearLayoutManager {
    public static final int DEFAULT_SPAN_COUNT = -1;

    /* renamed from: a  reason: collision with root package name */
    boolean f3271a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    int[] f3272c;
    View[] d;
    final SparseIntArray e;
    final SparseIntArray f;
    SpanSizeLookup g;
    final Rect h;
    private boolean i;

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/GridLayoutManager$DefaultSpanSizeLookup.class */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return 1;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/GridLayoutManager$LayoutParams.class */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;

        /* renamed from: a  reason: collision with root package name */
        int f3273a;
        int b;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3273a = -1;
            this.b = 0;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3273a = -1;
            this.b = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3273a = -1;
            this.b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3273a = -1;
            this.b = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3273a = -1;
            this.b = 0;
        }

        public int getSpanIndex() {
            return this.f3273a;
        }

        public int getSpanSize() {
            return this.b;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup.class */
    public static abstract class SpanSizeLookup {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        int getCachedSpanGroupIndex(int i, int i2) {
            if (this.mCacheSpanGroupIndices) {
                int i3 = this.mSpanGroupIndexCache.get(i, -1);
                if (i3 != -1) {
                    return i3;
                }
                int spanGroupIndex = getSpanGroupIndex(i, i2);
                this.mSpanGroupIndexCache.put(i, spanGroupIndex);
                return spanGroupIndex;
            }
            return getSpanGroupIndex(i, i2);
        }

        int getCachedSpanIndex(int i, int i2) {
            if (this.mCacheSpanIndices) {
                int i3 = this.mSpanIndexCache.get(i, -1);
                if (i3 != -1) {
                    return i3;
                }
                int spanIndex = getSpanIndex(i, i2);
                this.mSpanIndexCache.put(i, spanIndex);
                return spanIndex;
            }
            return getSpanIndex(i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int getSpanGroupIndex(int r5, int r6) {
            /*
                Method dump skipped, instructions count: 192
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanGroupIndex(int, int):int");
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0058 -> B:20:0x0075). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x006b -> B:20:0x0075). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006e -> B:20:0x0075). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int getSpanIndex(int r5, int r6) {
            /*
                r4 = this;
                r0 = r4
                r1 = r5
                int r0 = r0.getSpanSize(r1)
                r12 = r0
                r0 = r12
                r1 = r6
                if (r0 != r1) goto Lf
                r0 = 0
                return r0
            Lf:
                r0 = r4
                boolean r0 = r0.mCacheSpanIndices
                if (r0 == 0) goto L39
                r0 = r4
                android.util.SparseIntArray r0 = r0.mSpanIndexCache
                r1 = r5
                int r0 = findFirstKeyLessThan(r0, r1)
                r9 = r0
                r0 = r9
                if (r0 < 0) goto L39
                r0 = r4
                android.util.SparseIntArray r0 = r0.mSpanIndexCache
                r1 = r9
                int r0 = r0.get(r1)
                r1 = r4
                r2 = r9
                int r1 = r1.getSpanSize(r2)
                int r0 = r0 + r1
                r7 = r0
                goto L75
            L39:
                r0 = 0
                r8 = r0
                r0 = 0
                r7 = r0
            L3e:
                r0 = r8
                r1 = r5
                if (r0 >= r1) goto L7e
                r0 = r4
                r1 = r8
                int r0 = r0.getSpanSize(r1)
                r10 = r0
                r0 = r7
                r1 = r10
                int r0 = r0 + r1
                r11 = r0
                r0 = r11
                r1 = r6
                if (r0 != r1) goto L61
                r0 = 0
                r7 = r0
                r0 = r8
                r9 = r0
                goto L75
            L61:
                r0 = r8
                r9 = r0
                r0 = r11
                r7 = r0
                r0 = r11
                r1 = r6
                if (r0 <= r1) goto L75
                r0 = r10
                r7 = r0
                r0 = r8
                r9 = r0
            L75:
                r0 = r9
                r1 = 1
                int r0 = r0 + r1
                r8 = r0
                goto L3e
            L7e:
                r0 = r12
                r1 = r7
                int r0 = r0 + r1
                r1 = r6
                if (r0 > r1) goto L88
                r0 = r7
                return r0
            L88:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.f3271a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new DefaultSpanSizeLookup();
        this.h = new Rect();
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f3271a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new DefaultSpanSizeLookup();
        this.h = new Rect();
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3271a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new DefaultSpanSizeLookup();
        this.h = new Rect();
        setSpanCount(getProperties(context, attributeSet, i, i2).spanCount);
    }

    private int a(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (state.isPreLayout()) {
            int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
            if (convertPreLayoutPositionToPostLayout == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
                return 0;
            }
            return this.g.getCachedSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.b);
        }
        return this.g.getCachedSpanGroupIndex(i, this.b);
    }

    private int a(RecyclerView.State state) {
        if (getChildCount() == 0 || state.getItemCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
        View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
        if (findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null) {
            return 0;
        }
        if (isSmoothScrollbarEnabled()) {
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd);
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart);
            int cachedSpanGroupIndex = this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.b);
            return (int) (((decoratedEnd - decoratedStart) / ((this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.b) - cachedSpanGroupIndex) + 1)) * (this.g.getCachedSpanGroupIndex(state.getItemCount() - 1, this.b) + 1));
        }
        return this.g.getCachedSpanGroupIndex(state.getItemCount() - 1, this.b) + 1;
    }

    private void a() {
        this.e.clear();
        this.f.clear();
    }

    private void a(float f, int i) {
        a(Math.max(Math.round(f * this.b), i));
    }

    private void a(int i) {
        this.f3272c = a(this.f3272c, this.b, i);
    }

    private void a(View view, int i, int i2, boolean z) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z ? shouldReMeasureChild(view, i, i2, layoutParams) : shouldMeasureChild(view, i, i2, layoutParams)) {
            view.measure(i, i2);
        }
    }

    private void a(View view, int i, boolean z) {
        int childMeasureSpec;
        int childMeasureSpec2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.d;
        int i2 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i3 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int a2 = a(layoutParams.f3273a, layoutParams.b);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = getChildMeasureSpec(a2, i, i3, layoutParams.width, false);
            childMeasureSpec = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i2, layoutParams.height, true);
        } else {
            childMeasureSpec = getChildMeasureSpec(a2, i, i2, layoutParams.height, false);
            childMeasureSpec2 = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i3, layoutParams.width, true);
        }
        a(view, childMeasureSpec2, childMeasureSpec, z);
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i3 = 1;
            i5 = i;
            i2 = 0;
        } else {
            i2 = i - 1;
            i3 = -1;
        }
        while (i2 != i5) {
            View view = this.d[i2];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.b = c(recycler, state, getPosition(view));
            layoutParams.f3273a = i4;
            i4 += layoutParams.b;
            i2 += i3;
        }
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        int i2;
        int b;
        boolean z = i == 1;
        int b2 = b(recycler, state, anchorInfo.b);
        if (z) {
            while (b2 > 0 && anchorInfo.b > 0) {
                anchorInfo.b--;
                b2 = b(recycler, state, anchorInfo.b);
            }
            return;
        }
        int itemCount = state.getItemCount();
        int i3 = anchorInfo.b;
        while (i3 < itemCount - 1 && (b = b(recycler, state, (i2 = i3 + 1))) > b2) {
            i3 = i2;
            b2 = b;
        }
        anchorInfo.b = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r4[r4.length - 1] != r6) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int[] a(int[] r4, int r5, int r6) {
        /*
            r0 = 1
            r8 = r0
            r0 = r4
            if (r0 == 0) goto L1c
            r0 = r4
            int r0 = r0.length
            r1 = r5
            r2 = 1
            int r1 = r1 + r2
            if (r0 != r1) goto L1c
            r0 = r4
            r12 = r0
            r0 = r4
            r1 = r4
            int r1 = r1.length
            r2 = 1
            int r1 = r1 - r2
            r0 = r0[r1]
            r1 = r6
            if (r0 == r1) goto L23
        L1c:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            int[] r0 = new int[r0]
            r12 = r0
        L23:
            r0 = 0
            r9 = r0
            r0 = r12
            r1 = 0
            r2 = 0
            r0[r1] = r2
            r0 = r6
            r1 = r5
            int r0 = r0 / r1
            r10 = r0
            r0 = r6
            r1 = r5
            int r0 = r0 % r1
            r11 = r0
            r0 = 0
            r7 = r0
            r0 = r9
            r6 = r0
        L3a:
            r0 = r8
            r1 = r5
            if (r0 > r1) goto L76
            r0 = r6
            r1 = r11
            int r0 = r0 + r1
            r6 = r0
            r0 = r6
            if (r0 <= 0) goto L5e
            r0 = r5
            r1 = r6
            int r0 = r0 - r1
            r1 = r11
            if (r0 >= r1) goto L5e
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            r0 = r6
            r1 = r5
            int r0 = r0 - r1
            r6 = r0
            goto L62
        L5e:
            r0 = r10
            r9 = r0
        L62:
            r0 = r7
            r1 = r9
            int r0 = r0 + r1
            r7 = r0
            r0 = r12
            r1 = r8
            r2 = r7
            r0[r1] = r2
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L3a
        L76:
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(int[], int, int):int[]");
    }

    private int b(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (state.isPreLayout()) {
            int i2 = this.f.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
            if (convertPreLayoutPositionToPostLayout == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
                return 0;
            }
            return this.g.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.b);
        }
        return this.g.getCachedSpanIndex(i, this.b);
    }

    private int b(RecyclerView.State state) {
        if (getChildCount() == 0 || state.getItemCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
        View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
        if (findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null) {
            return 0;
        }
        int cachedSpanGroupIndex = this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.b);
        int cachedSpanGroupIndex2 = this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.b);
        int max = this.mShouldReverseLayout ? Math.max(0, ((this.g.getCachedSpanGroupIndex(state.getItemCount() - 1, this.b) + 1) - Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2)) - 1) : Math.max(0, Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2));
        if (isSmoothScrollbarEnabled) {
            return Math.round((max * (Math.abs(this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart)) / ((this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.b) - this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.b)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart)));
        }
        return max;
    }

    private void b() {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.e.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.f.put(viewLayoutPosition, layoutParams.getSpanIndex());
            i = i2 + 1;
        }
    }

    private int c(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (state.isPreLayout()) {
            int i2 = this.e.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
            if (convertPreLayoutPositionToPostLayout == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
                return 1;
            }
            return this.g.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        return this.g.getSpanSize(i);
    }

    private void c() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        a(height - paddingTop);
    }

    private void d() {
        View[] viewArr = this.d;
        if (viewArr == null || viewArr.length != this.b) {
            this.d = new View[this.b];
        }
    }

    int a(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.f3272c;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.f3272c;
        int i3 = this.b;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = this.b;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.b || !layoutState.a(state) || i <= 0) {
                return;
            }
            int i4 = layoutState.d;
            layoutPrefetchRegistry.addPosition(i4, Math.max(0, layoutState.g));
            i -= this.g.getSpanSize(i4);
            layoutState.d += layoutState.e;
            i2 = i3 + 1;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.i ? b(state) : super.computeHorizontalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.i ? a(state) : super.computeHorizontalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.i ? b(state) : super.computeVerticalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.i ? a(state) : super.computeVerticalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3) {
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (true) {
            View view3 = view2;
            if (i == i2) {
                return view != null ? view : view3;
            }
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            View view4 = view;
            View view5 = view3;
            if (position >= 0) {
                view4 = view;
                view5 = view3;
                if (position >= i3) {
                    continue;
                } else if (b(recycler, state, position) != 0) {
                    view4 = view;
                    view5 = view3;
                } else if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    view4 = view;
                    view5 = view3;
                    if (view3 == null) {
                        view5 = childAt;
                        view4 = view;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    view4 = view;
                    view5 = view3;
                    if (view == null) {
                        view4 = childAt;
                        view5 = view3;
                    }
                }
            }
            i += i4;
            view = view4;
            view2 = view5;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.b;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return a(recycler, state, state.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.b;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return a(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getSpanCount() {
        return this.b;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.g;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.i;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int makeMeasureSpec;
        int childMeasureSpec;
        View a2;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        boolean z = modeInOther != 1073741824;
        int i9 = getChildCount() > 0 ? this.f3272c[this.b] : 0;
        if (z) {
            c();
        }
        boolean z2 = layoutState.e == 1;
        int i10 = this.b;
        if (!z2) {
            i10 = b(recycler, state, layoutState.d) + c(recycler, state, layoutState.d);
        }
        int i11 = 0;
        while (true) {
            i = i11;
            if (i >= this.b || !layoutState.a(state) || i10 <= 0) {
                break;
            }
            int i12 = layoutState.d;
            int c2 = c(recycler, state, i12);
            if (c2 > this.b) {
                throw new IllegalArgumentException("Item at position " + i12 + " requires " + c2 + " spans but GridLayoutManager has only " + this.b + " spans.");
            }
            i10 -= c2;
            if (i10 < 0 || (a2 = layoutState.a(recycler)) == null) {
                break;
            }
            this.d[i] = a2;
            i11 = i + 1;
        }
        if (i == 0) {
            layoutChunkResult.mFinished = true;
            return;
        }
        float f = 0.0f;
        a(recycler, state, i, z2);
        int i13 = 0;
        int i14 = 0;
        while (i13 < i) {
            View view = this.d[i13];
            if (layoutState.l == null) {
                if (z2) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z2) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.h);
            a(view, modeInOther, false);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
            int i15 = i14;
            if (decoratedMeasurement > i14) {
                i15 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther = (this.mOrientationHelper.getDecoratedMeasurementInOther(view) * 1.0f) / ((LayoutParams) view.getLayoutParams()).b;
            float f2 = f;
            if (decoratedMeasurementInOther > f) {
                f2 = decoratedMeasurementInOther;
            }
            i13++;
            i14 = i15;
            f = f2;
        }
        int i16 = i14;
        if (z) {
            a(f, i9);
            int i17 = 0;
            int i18 = 0;
            while (true) {
                int i19 = i18;
                i16 = i19;
                if (i17 >= i) {
                    break;
                }
                View view2 = this.d[i17];
                a(view2, 1073741824, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view2);
                int i20 = i19;
                if (decoratedMeasurement2 > i19) {
                    i20 = decoratedMeasurement2;
                }
                i17++;
                i18 = i20;
            }
        }
        int i21 = 0;
        while (true) {
            int i22 = i21;
            if (i22 >= i) {
                break;
            }
            View view3 = this.d[i22];
            if (this.mOrientationHelper.getDecoratedMeasurement(view3) != i16) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.d;
                int i23 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i24 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int a3 = a(layoutParams.f3273a, layoutParams.b);
                if (this.mOrientation == 1) {
                    makeMeasureSpec = getChildMeasureSpec(a3, 1073741824, i24, layoutParams.width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16 - i23, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16 - i24, 1073741824);
                    childMeasureSpec = getChildMeasureSpec(a3, 1073741824, i23, layoutParams.height, false);
                }
                a(view3, makeMeasureSpec, childMeasureSpec, true);
            }
            i21 = i22 + 1;
        }
        int i25 = 0;
        layoutChunkResult.mConsumed = i16;
        if (this.mOrientation == 1) {
            if (layoutState.f == -1) {
                i4 = layoutState.b;
                i5 = i4 - i16;
            } else {
                int i26 = layoutState.b;
                i5 = i26;
                i4 = i16 + i26;
            }
            i3 = 0;
            i2 = 0;
        } else if (layoutState.f == -1) {
            i3 = layoutState.b;
            i2 = i3 - i16;
            i5 = 0;
            i4 = 0;
        } else {
            i2 = layoutState.b;
            i3 = i16 + i2;
            i4 = 0;
            i5 = 0;
        }
        while (i25 < i) {
            View view4 = this.d[i25];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                int paddingTop = getPaddingTop() + this.f3272c[layoutParams2.f3273a];
                i6 = paddingTop;
                i4 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingTop;
            } else if (isLayoutRTL()) {
                i3 = getPaddingLeft() + this.f3272c[this.b - layoutParams2.f3273a];
                i2 = i3 - this.mOrientationHelper.getDecoratedMeasurementInOther(view4);
                i6 = i5;
            } else {
                int paddingLeft = getPaddingLeft() + this.f3272c[layoutParams2.f3273a];
                i3 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingLeft;
                i7 = i5;
                i8 = paddingLeft;
                layoutDecoratedWithMargins(view4, i8, i7, i3, i4);
                if (!layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                    layoutChunkResult.mIgnoreConsumed = true;
                }
                layoutChunkResult.mFocusable |= view4.hasFocusable();
                i25++;
                int i27 = i8;
                i5 = i7;
                i2 = i27;
            }
            i8 = i2;
            i7 = i6;
            layoutDecoratedWithMargins(view4, i8, i7, i3, i4);
            if (!layoutParams2.isItemRemoved()) {
            }
            layoutChunkResult.mIgnoreConsumed = true;
            layoutChunkResult.mFocusable |= view4.hasFocusable();
            i25++;
            int i272 = i8;
            i5 = i7;
            i2 = i272;
        }
        Arrays.fill(this.d, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        super.onAnchorReady(recycler, state, anchorInfo, i);
        c();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            a(recycler, state, anchorInfo, i);
        }
        d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x018e, code lost:
        if (r15 == (r0 > r18)) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01d3, code lost:
        if (r15 == r13) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0228 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01e4  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r7, int r8, androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int a2 = a(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), a2, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(a2, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            b();
        }
        super.onLayoutChildren(recycler, state);
        a();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f3271a = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        c();
        d();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        c();
        d();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.f3272c == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            int chooseSize = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f3272c;
            int chooseSize2 = chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
            i4 = chooseSize;
            i3 = chooseSize2;
        } else {
            int chooseSize3 = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f3272c;
            int chooseSize4 = chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
            i3 = chooseSize3;
            i4 = chooseSize4;
        }
        setMeasuredDimension(i3, i4);
    }

    public void setSpanCount(int i) {
        if (i == this.b) {
            return;
        }
        this.f3271a = true;
        if (i >= 1) {
            this.b = i;
            this.g.invalidateSpanIndexCache();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.g = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z) {
        this.i = z;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f3271a;
    }
}
