package com.blued.android.module.live_china.mine;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/PagerGridLayoutManager.class */
public class PagerGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13875a = PagerGridLayoutManager.class.getSimpleName();
    private int b;
    private int e;
    private int f;
    private int g;
    private int m;
    private int n;
    private RecyclerView q;

    /* renamed from: c  reason: collision with root package name */
    private int f13876c = 0;
    private int d = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int o = 0;
    private boolean p = true;
    private boolean r = true;
    private int s = -1;
    private int t = -1;
    private PageListener u = null;
    private SparseArray<Rect> h = new SparseArray<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/PagerGridLayoutManager$OrientationType.class */
    public @interface OrientationType {
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/PagerGridLayoutManager$PageListener.class */
    public interface PageListener {
        void a(int i);

        void b(int i);
    }

    public PagerGridLayoutManager(int i, int i2, int i3) {
        this.b = i3;
        this.e = i;
        this.f = i2;
        this.g = i * i2;
    }

    private void a(int i, boolean z) {
        PageListener pageListener;
        if (i == this.t) {
            return;
        }
        if (e()) {
            this.t = i;
        } else if (!z) {
            this.t = i;
        }
        if ((!z || this.r) && i >= 0 && (pageListener = this.u) != null) {
            pageListener.b(i);
        }
    }

    private void a(RecyclerView.Recycler recycler, Rect rect, int i) {
        View viewForPosition = recycler.getViewForPosition(i);
        Rect d = d(i);
        if (!Rect.intersects(rect, d)) {
            removeAndRecycleView(viewForPosition, recycler);
            return;
        }
        addView(viewForPosition);
        measureChildWithMargins(viewForPosition, this.k, this.l);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
        layoutDecorated(viewForPosition, (d.left - this.f13876c) + layoutParams.leftMargin + getPaddingLeft(), (d.top - this.d) + layoutParams.topMargin + getPaddingTop(), ((d.right - this.f13876c) - layoutParams.rightMargin) + getPaddingLeft(), ((d.bottom - this.d) - layoutParams.bottomMargin) + getPaddingTop());
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        if (state.isPreLayout()) {
            return;
        }
        Rect rect = new Rect(this.f13876c - this.i, this.d - this.j, f() + this.f13876c + this.i, g() + this.d + this.j);
        int i = 0;
        rect.intersect(0, 0, this.m + f(), this.n + g());
        int i2 = i();
        int i3 = this.g;
        int i4 = (i2 * i3) - (i3 * 2);
        if (i4 >= 0) {
            i = i4;
        }
        int i5 = (this.g * 4) + i;
        int i6 = i5;
        if (i5 > getItemCount()) {
            i6 = getItemCount();
        }
        detachAndScrapAttachedViews(recycler);
        if (z) {
            while (i < i6) {
                a(recycler, rect, i);
                i++;
            }
            return;
        }
        while (true) {
            i6--;
            if (i6 < i) {
                return;
            }
            a(recycler, rect, i6);
        }
    }

    private Rect d(int i) {
        int g;
        Rect rect = this.h.get(i);
        Rect rect2 = rect;
        if (rect == null) {
            rect2 = new Rect();
            int i2 = i / this.g;
            int i3 = 0;
            if (canScrollHorizontally()) {
                i3 = (f() * i2) + 0;
                g = 0;
            } else {
                g = (g() * i2) + 0;
            }
            int i4 = i % this.g;
            int i5 = this.f;
            int i6 = i4 / i5;
            int i7 = i3 + ((i4 - (i5 * i6)) * this.i);
            int i8 = g + (i6 * this.j);
            rect2.left = i7;
            rect2.top = i8;
            rect2.right = i7 + this.i;
            rect2.bottom = i8 + this.j;
            this.h.put(i, rect2);
        }
        return rect2;
    }

    private int e(int i) {
        return i / this.g;
    }

    private int f() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int[] f(int i) {
        int[] iArr = new int[2];
        int e = e(i);
        if (canScrollHorizontally()) {
            iArr[0] = e * f();
            iArr[1] = 0;
            return iArr;
        }
        iArr[0] = 0;
        iArr[1] = e * g();
        return iArr;
    }

    private int g() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private void g(int i) {
        if (i >= 0) {
            PageListener pageListener = this.u;
            if (pageListener != null && i != this.s) {
                pageListener.a(i);
            }
            this.s = i;
        }
    }

    private int h() {
        if (getItemCount() <= 0) {
            return 0;
        }
        int itemCount = getItemCount() / this.g;
        int i = itemCount;
        if (getItemCount() % this.g != 0) {
            i = itemCount + 1;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
        if ((r0 % r0) > (r0 / 2)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        if ((r0 % r0) > (r0 / 2)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
        r5 = r6 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int i() {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.canScrollVertically()
            r9 = r0
            r0 = 0
            r5 = r0
            r0 = r9
            if (r0 == 0) goto L37
            r0 = r4
            int r0 = r0.g()
            r7 = r0
            r0 = r4
            int r0 = r0.d
            r8 = r0
            r0 = r8
            if (r0 <= 0) goto L62
            r0 = r7
            if (r0 > 0) goto L23
            r0 = 0
            return r0
        L23:
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
            if (r0 <= r1) goto L62
            goto L5e
        L37:
            r0 = r4
            int r0 = r0.f()
            r7 = r0
            r0 = r4
            int r0 = r0.f13876c
            r8 = r0
            r0 = r8
            if (r0 <= 0) goto L62
            r0 = r7
            if (r0 > 0) goto L4d
            r0 = 0
            return r0
        L4d:
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
            if (r0 <= r1) goto L62
        L5e:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
        L62:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.mine.PagerGridLayoutManager.i():int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        int i = this.t + 1;
        int i2 = i;
        if (i >= h()) {
            i2 = h() - 1;
        }
        return i2 * this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(int i) {
        int[] f = f(i);
        return new int[]{f[0] - this.f13876c, f[1] - this.d};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i = this.t - 1;
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        return i2 * this.g;
    }

    public void b(int i) {
        if (i < 0 || i >= this.s) {
            String str = f13875a;
            Log.e(str, "pageIndex is outOfIndex, must in [0, " + this.s + ").");
        } else if (this.q == null) {
            Log.e(f13875a, "RecyclerView Not Found!");
        } else {
            int i2 = i();
            if (Math.abs(i - i2) > 3) {
                if (i > i2) {
                    c(i - 3);
                } else if (i < i2) {
                    c(i + 3);
                }
            }
            PagerGridSmoothScroller pagerGridSmoothScroller = new PagerGridSmoothScroller(this.q);
            pagerGridSmoothScroller.setTargetPosition(i * this.g);
            startSmoothScroll(pagerGridSmoothScroller);
        }
    }

    public View c() {
        if (getFocusedChild() != null) {
            return getFocusedChild();
        }
        if (getChildCount() <= 0) {
            return null;
        }
        int i = i();
        int i2 = this.g;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= getChildCount()) {
                return getChildAt(0);
            }
            if (getPosition(getChildAt(i4)) == i * i2) {
                return getChildAt(i4);
            }
            i3 = i4 + 1;
        }
    }

    public void c(int i) {
        int f;
        int i2;
        if (i < 0 || i >= this.s) {
            Log.e(f13875a, "pageIndex = " + i + " is out of bounds, mast in [0, " + this.s + ")");
        } else if (this.q == null) {
            Log.e(f13875a, "RecyclerView Not Found!");
        } else {
            if (canScrollVertically()) {
                i2 = (g() * i) - this.d;
                f = 0;
            } else {
                f = (f() * i) - this.f13876c;
                i2 = 0;
            }
            this.q.scrollBy(f, i2);
            a(i, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.b == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.b == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        PointF pointF = new PointF();
        int[] a2 = a(i);
        pointF.x = a2[0];
        pointF.y = a2[1];
        return pointF;
    }

    public int d() {
        int i = this.t;
        if (i < 0) {
            return 0;
        }
        int i2 = this.s;
        return i > i2 ? i2 : i;
    }

    public boolean e() {
        return this.p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.q = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout() || !state.didStructureChange()) {
            return;
        }
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            g(0);
            a(0, false);
            return;
        }
        g(h());
        a(i(), false);
        int itemCount = getItemCount() / this.g;
        int i = itemCount;
        if (getItemCount() % this.g != 0) {
            i = itemCount + 1;
        }
        if (canScrollHorizontally()) {
            int f = (i - 1) * f();
            this.m = f;
            this.n = 0;
            if (this.f13876c > f) {
                this.f13876c = f;
            }
        } else {
            this.m = 0;
            int g = (i - 1) * g();
            this.n = g;
            if (this.d > g) {
                this.d = g;
            }
        }
        if (this.i <= 0) {
            this.i = f() / this.f;
        }
        if (this.j <= 0) {
            this.j = g() / this.e;
        }
        this.k = f() - this.i;
        this.l = g() - this.j;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.g * 2) {
                break;
            }
            d(i3);
            i2 = i3 + 1;
        }
        if (this.f13876c == 0 && this.d == 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.g || i5 >= getItemCount()) {
                    break;
                }
                View viewForPosition = recycler.getViewForPosition(i5);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, this.k, this.l);
                i4 = i5 + 1;
            }
        }
        a(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (state.isPreLayout()) {
            return;
        }
        g(h());
        a(i(), false);
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
        this.o = i;
        super.onScrollStateChanged(i);
        if (i == 0) {
            a(i(), false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = this.f13876c;
        int i3 = i2 + i;
        int i4 = this.m;
        if (i3 > i4) {
            i = i4 - i2;
        } else if (i3 < 0) {
            i = 0 - i2;
        }
        this.f13876c += i;
        a(i(), true);
        offsetChildrenHorizontal(-i);
        if (i > 0) {
            a(recycler, state, true);
            return i;
        }
        a(recycler, state, false);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        c(e(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = this.d;
        int i3 = i2 + i;
        int i4 = this.n;
        if (i3 > i4) {
            i = i4 - i2;
        } else if (i3 < 0) {
            i = 0 - i2;
        }
        this.d += i;
        a(i(), true);
        offsetChildrenVertical(-i);
        if (i > 0) {
            a(recycler, state, true);
            return i;
        }
        a(recycler, state, false);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        b(e(i));
    }
}
