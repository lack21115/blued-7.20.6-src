package com.soft.blued.ui.find.manager;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/SpannedGridLayoutManager.class */
public class SpannedGridLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: a  reason: collision with root package name */
    private GridSpanLookup f16914a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private float f16915c;
    private int d;
    private int[] e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private SparseArray<GridCell> k;
    private List<Integer> l;
    private int m;
    private final Rect n = new Rect();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/SpannedGridLayoutManager$GridCell.class */
    public static class GridCell {

        /* renamed from: a  reason: collision with root package name */
        final int f16917a;
        final int b;

        /* renamed from: c  reason: collision with root package name */
        final int f16918c;
        final int d;

        GridCell(int i, int i2, int i3, int i4) {
            this.f16917a = i;
            this.b = i2;
            this.f16918c = i3;
            this.d = i4;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/SpannedGridLayoutManager$GridSpanLookup.class */
    public interface GridSpanLookup {
        SpanInfo a(int i);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/SpannedGridLayoutManager$LayoutParams.class */
    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f16919a;
        int b;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/SpannedGridLayoutManager$SpanInfo.class */
    public static class SpanInfo {

        /* renamed from: c  reason: collision with root package name */
        public static final SpanInfo f16920c = new SpanInfo(1, 1);

        /* renamed from: a  reason: collision with root package name */
        public int f16921a;
        public int b;

        public SpanInfo(int i, int i2) {
            this.f16921a = i;
            this.b = i2;
        }
    }

    public SpannedGridLayoutManager(GridSpanLookup gridSpanLookup, int i, float f) {
        this.b = 1;
        this.f16915c = 1.0f;
        this.f16914a = gridSpanLookup;
        this.b = i;
        this.f16915c = f;
        setAutoMeasureEnabled(true);
    }

    private int a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i) - i2) - i3, mode) : i;
    }

    private int a(int i, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int d = d(i);
        int a2 = a(i, state);
        int childCount = i < this.h ? 0 : getChildCount();
        int i3 = d;
        boolean z = false;
        while (i3 <= a2) {
            View view = null;
            try {
                view = recycler.getViewForPosition(i3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (view != null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                boolean isItemRemoved = layoutParams.isItemRemoved();
                GridCell gridCell = this.k.get(i3);
                addView(view, childCount);
                a(view, getChildMeasureSpec(this.e[gridCell.f16918c + gridCell.d] - this.e[gridCell.f16918c], 1073741824, 0, layoutParams.width, false), getChildMeasureSpec(gridCell.b * this.d, 1073741824, 0, layoutParams.height, true));
                int i4 = layoutParams.leftMargin + this.e[gridCell.f16918c];
                int i5 = layoutParams.topMargin + i2 + (gridCell.f16917a * this.d);
                layoutDecorated(view, i4, i5, i4 + getDecoratedMeasuredWidth(view), i5 + getDecoratedMeasuredHeight(view));
                layoutParams.f16919a = gridCell.d;
                layoutParams.b = gridCell.b;
                z |= isItemRemoved;
            }
            i3++;
            childCount++;
        }
        if (d < this.f) {
            this.f = d;
            this.h = b(d);
        }
        if (a2 > this.g) {
            this.g = a2;
            this.i = b(a2);
        }
        if (z) {
            return 0;
        }
        GridCell gridCell2 = this.k.get(d) != null ? this.k.get(d) : new GridCell(d, a(d).b, this.b, a(d).f16921a);
        GridCell gridCell3 = this.k.get(a2) != null ? this.k.get(a2) : new GridCell(a2, a(a2).b, this.b, a(a2).f16921a);
        return ((gridCell3.f16917a + gridCell3.b) - gridCell2.f16917a) * this.d;
    }

    private int a(int i, RecyclerView.State state) {
        int c2 = c(i);
        return (c2 != d() ? d(c2) : state.getItemCount()) - 1;
    }

    private SpanInfo a(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= getChildCount()) {
                return SpanInfo.f16920c;
            }
            View childAt = getChildAt(i3);
            if (i == getPosition(childAt)) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                return new SpanInfo(layoutParams.f16919a, layoutParams.b);
            }
            i2 = i3 + 1;
        }
    }

    private void a(int i, int i2) {
        if (d() < i + 1) {
            this.l.add(Integer.valueOf(i2));
        }
    }

    private void a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int d = d(i);
        int a2 = a(i, state);
        int i2 = a2;
        while (true) {
            int i3 = i2;
            if (i3 < d) {
                break;
            }
            removeAndRecycleViewAt(i3 - this.f, recycler);
            i2 = i3 - 1;
        }
        if (i == this.h) {
            int i4 = a2 + 1;
            this.f = i4;
            this.h = b(i4);
        }
        if (i == this.i) {
            int i5 = d - 1;
            this.g = i5;
            this.i = b(i5);
        }
    }

    private void a(View view, int i, int i2) {
        calculateItemDecorationsForChild(view, this.n);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        view.measure(a(i, layoutParams.leftMargin + this.n.left, layoutParams.rightMargin + this.n.right), a(i2, layoutParams.topMargin + this.n.top, layoutParams.bottomMargin + this.n.bottom));
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int itemCount = state.getItemCount();
        this.k = new SparseArray<>(itemCount);
        this.l = new ArrayList();
        a(0, 0);
        int i = this.b;
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i2 >= itemCount) {
                break;
            }
            int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i2);
            SpanInfo a2 = convertPreLayoutPositionToPostLayout != -1 ? this.f16914a.a(convertPreLayoutPositionToPostLayout) : a(i2);
            int i6 = a2.f16921a;
            int i7 = this.b;
            if (i6 > i7) {
                a2.f16921a = i7;
            }
            int i8 = i2;
            int i9 = i3;
            int i10 = i5;
            SpanInfo spanInfo = a2;
            if (a2.f16921a + i3 > this.b) {
                int i11 = i5 + 1;
                a(i11, i2);
                spanInfo = a2;
                i10 = i11;
                i9 = 0;
                i8 = i2;
            }
            while (iArr[i9] > i10) {
                int i12 = i9 + 1;
                i9 = i12;
                if (spanInfo.f16921a + i12 > this.b) {
                    int i13 = i10 + 1;
                    a(i13, i8);
                    spanInfo = spanInfo;
                    i10 = i13;
                    i9 = 0;
                    i8 = i8;
                }
            }
            this.k.put(i8, new GridCell(i10, spanInfo.b, i9, spanInfo.f16921a));
            int i14 = 0;
            while (true) {
                int i15 = i14;
                if (i15 >= spanInfo.f16921a) {
                    break;
                }
                iArr[i9 + i15] = spanInfo.b + i10;
                i14 = i15 + 1;
            }
            if (spanInfo.b > 1) {
                int d = d(i10);
                int i16 = 1;
                while (true) {
                    int i17 = i16;
                    if (i17 < spanInfo.b) {
                        a(i10 + i17, d);
                        i16 = i17 + 1;
                    }
                }
            }
            i3 = i9 + spanInfo.f16921a;
            i2 = i8 + 1;
            i4 = i10;
        }
        this.m = iArr[0];
        int i18 = 1;
        while (true) {
            int i19 = i18;
            if (i19 >= i) {
                return;
            }
            if (iArr[i19] > this.m) {
                this.m = iArr[i19];
            }
            i18 = i19 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        SparseArray<GridCell> sparseArray = this.k;
        if (sparseArray == null || sparseArray.size() <= i || this.k.get(i) == null) {
            return -1;
        }
        return this.k.get(i).f16917a;
    }

    private int c(int i) {
        int d = d(i);
        do {
            i++;
            if (i >= d()) {
                break;
            }
        } while (d(i) == d);
        return i;
    }

    private int d() {
        List<Integer> list = this.l;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private int d(int i) {
        List<Integer> list = this.l;
        if (list == null || i <= -1 || list.size() <= i) {
            return 0;
        }
        return this.l.get(i).intValue();
    }

    private void e() {
        this.d = (int) Math.floor(((int) Math.floor(((getWidth() - getPaddingLeft()) - getPaddingRight()) / this.b)) * (1.0f / this.f16915c));
        i();
    }

    private void f() {
        this.k = null;
        this.l = null;
        this.f = 0;
        this.h = 0;
        this.g = 0;
        this.i = 0;
        this.d = 0;
        this.j = false;
    }

    private void g() {
        int h = h();
        if (this.h > h) {
            this.h = h;
        }
        int d = d(this.h);
        this.f = d;
        this.i = this.h;
        this.g = d;
    }

    private int h() {
        int ceil = ((int) Math.ceil(getHeight() / this.d)) + 1;
        int i = this.m;
        if (i < ceil) {
            return 0;
        }
        return b(d(i - ceil));
    }

    private void i() {
        int i;
        int i2 = 1;
        this.e = new int[this.b + 1];
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i3 = 0;
        this.e[0] = paddingLeft;
        int i4 = this.b;
        int i5 = width / i4;
        int i6 = width % i4;
        while (true) {
            int i7 = this.b;
            if (i2 > i7) {
                return;
            }
            i3 += i6;
            if (i3 <= 0 || i7 - i3 >= i6) {
                i = i5;
            } else {
                i = i5 + 1;
                i3 -= i7;
            }
            paddingLeft += i;
            this.e[i2] = paddingLeft;
            i2++;
        }
    }

    public int a() {
        return this.f;
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return getHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return (getPaddingTop() + (this.h * this.d)) - getDecoratedTop(getChildAt(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return (d() * this.d) + getPaddingTop() + getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i) {
        int i2 = this.f;
        if (i < i2 || i > this.g) {
            return null;
        }
        return getChildAt(i - i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
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
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
        f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        e();
        a(recycler, state);
        int i = 0;
        if (state.getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            this.h = 0;
            g();
            return;
        }
        int paddingTop = getPaddingTop();
        if (this.j) {
            paddingTop = -(this.h * this.d);
            this.j = false;
        } else if (getChildCount() != 0) {
            i = getDecoratedTop(getChildAt(0));
            paddingTop = i - (this.h * this.d);
            g();
        }
        detachAndScrapAttachedViews(recycler);
        int i2 = this.h;
        int height = getHeight() - i;
        int itemCount = state.getItemCount();
        int i3 = i2;
        while (true) {
            int i4 = i3;
            if (height <= 0 || this.g >= itemCount - 1) {
                return;
            }
            height -= a(i4, paddingTop, recycler, state);
            i3 = c(i4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        int i2 = i;
        if (i >= getItemCount()) {
            i2 = getItemCount() - 1;
        }
        this.h = b(i2);
        g();
        this.j = true;
        removeAllViews();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        int decoratedTop = getDecoratedTop(getChildAt(0));
        if (i < 0) {
            int i6 = i;
            if (this.h == 0) {
                i6 = Math.max(i, -(getPaddingTop() - decoratedTop));
            }
            if (decoratedTop - i6 >= 0 && (i5 = (i4 = this.h) - 1) >= 0) {
                a(i5, decoratedTop - (i4 * this.d), recycler, state);
            }
            int d = d(this.i);
            int i7 = 0;
            if (getChildAt(d - this.f) != null) {
                i7 = getDecoratedTop(getChildAt(d - this.f));
            }
            i2 = i6;
            if (i7 - i6 > getHeight()) {
                a(this.i, recycler, state);
                i2 = i6;
            }
        } else {
            int decoratedBottom = getDecoratedBottom(getChildAt(getChildCount() - 1));
            int i8 = i;
            if (this.g == getItemCount() - 1) {
                i8 = Math.min(i, Math.max((decoratedBottom - getHeight()) + getPaddingBottom(), 0));
            }
            if (decoratedBottom - i8 < getHeight() && (i3 = this.i + 1) < d()) {
                a(i3, decoratedTop - (this.h * this.d), recycler, state);
            }
            i2 = i8;
            if (getDecoratedBottom(getChildAt(a(this.h, state) - this.f)) - i8 < 0) {
                a(this.h, recycler, state);
                i2 = i8;
            }
        }
        offsetChildrenVertical(-i2);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        int i2 = i;
        if (i >= getItemCount()) {
            i2 = getItemCount() - 1;
        }
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.soft.blued.ui.find.manager.SpannedGridLayoutManager.1
            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i3) {
                return new PointF(0.0f, (SpannedGridLayoutManager.this.b(i3) - SpannedGridLayoutManager.this.h) * SpannedGridLayoutManager.this.d);
            }
        };
        linearSmoothScroller.setTargetPosition(i2);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return true;
    }
}
