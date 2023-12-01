package com.blued.android.framework.view.wheel.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.blued.android.framework.R;
import com.blued.android.framework.view.wheel.widget.WheelScroller;
import com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/wheel/widget/WheelView.class */
public class WheelView extends View {
    private static final int[] c = {-15658735, 11184810, 11184810};
    boolean a;
    WheelScroller.ScrollingListener b;
    private int d;
    private int e;
    private int f;
    private Drawable g;
    private GradientDrawable h;
    private GradientDrawable i;
    private WheelScroller j;
    private boolean k;
    private int l;
    private LinearLayout m;
    private int n;
    private WheelViewAdapter o;
    private WheelRecycle p;
    private List<OnWheelChangedListener> q;
    private List<OnWheelScrollListener> r;
    private List<OnWheelClickedListener> s;
    private DataSetObserver t;

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.e = 5;
        this.f = 0;
        this.a = false;
        this.p = new WheelRecycle(this);
        this.q = new LinkedList();
        this.r = new LinkedList();
        this.s = new LinkedList();
        this.b = new WheelScroller.ScrollingListener() { // from class: com.blued.android.framework.view.wheel.widget.WheelView.1
            @Override // com.blued.android.framework.view.wheel.widget.WheelScroller.ScrollingListener
            public void a() {
                WheelView.this.k = true;
                WheelView.this.a();
            }

            @Override // com.blued.android.framework.view.wheel.widget.WheelScroller.ScrollingListener
            public void a(int i) {
                WheelView.this.b(i);
                int height = WheelView.this.getHeight();
                if (WheelView.this.l > height) {
                    WheelView.this.l = height;
                    WheelView.this.j.a();
                    return;
                }
                int i2 = -height;
                if (WheelView.this.l < i2) {
                    WheelView.this.l = i2;
                    WheelView.this.j.a();
                }
            }

            @Override // com.blued.android.framework.view.wheel.widget.WheelScroller.ScrollingListener
            public void b() {
                if (WheelView.this.k) {
                    WheelView.this.b();
                    WheelView.this.k = false;
                }
                WheelView.this.l = 0;
                WheelView.this.invalidate();
            }

            @Override // com.blued.android.framework.view.wheel.widget.WheelScroller.ScrollingListener
            public void c() {
                if (Math.abs(WheelView.this.l) > 1) {
                    WheelView.this.j.a(WheelView.this.l, 0);
                }
            }
        };
        this.t = new DataSetObserver() { // from class: com.blued.android.framework.view.wheel.widget.WheelView.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                WheelView.this.a(false);
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                WheelView.this.a(true);
            }
        };
        a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.e = 5;
        this.f = 0;
        this.a = false;
        this.p = new WheelRecycle(this);
        this.q = new LinkedList();
        this.r = new LinkedList();
        this.s = new LinkedList();
        this.b = new WheelScroller.ScrollingListener() { // from class: com.blued.android.framework.view.wheel.widget.WheelView.1
            @Override // com.blued.android.framework.view.wheel.widget.WheelScroller.ScrollingListener
            public void a() {
                WheelView.this.k = true;
                WheelView.this.a();
            }

            @Override // com.blued.android.framework.view.wheel.widget.WheelScroller.ScrollingListener
            public void a(int i2) {
                WheelView.this.b(i2);
                int height = WheelView.this.getHeight();
                if (WheelView.this.l > height) {
                    WheelView.this.l = height;
                    WheelView.this.j.a();
                    return;
                }
                int i22 = -height;
                if (WheelView.this.l < i22) {
                    WheelView.this.l = i22;
                    WheelView.this.j.a();
                }
            }

            @Override // com.blued.android.framework.view.wheel.widget.WheelScroller.ScrollingListener
            public void b() {
                if (WheelView.this.k) {
                    WheelView.this.b();
                    WheelView.this.k = false;
                }
                WheelView.this.l = 0;
                WheelView.this.invalidate();
            }

            @Override // com.blued.android.framework.view.wheel.widget.WheelScroller.ScrollingListener
            public void c() {
                if (Math.abs(WheelView.this.l) > 1) {
                    WheelView.this.j.a(WheelView.this.l, 0);
                }
            }
        };
        this.t = new DataSetObserver() { // from class: com.blued.android.framework.view.wheel.widget.WheelView.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                WheelView.this.a(false);
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                WheelView.this.a(true);
            }
        };
        a(context);
    }

    private int a(LinearLayout linearLayout) {
        if (linearLayout != null && linearLayout.getChildAt(0) != null) {
            this.f = linearLayout.getChildAt(0).getMeasuredHeight();
        }
        int i = this.f;
        return Math.max((this.e * i) - ((i * 10) / 50), getSuggestedMinimumHeight());
    }

    private void a(Context context) {
        this.j = new WheelScroller(getContext(), this.b);
    }

    private void a(Canvas canvas) {
        canvas.save();
        canvas.translate(10.0f, (-(((this.d - this.n) * getItemHeight()) + ((getItemHeight() - getHeight()) / 2))) + this.l);
        this.m.draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        int i2;
        int i3;
        int i4;
        this.l += i;
        int itemHeight = getItemHeight();
        int i5 = this.l / itemHeight;
        int i6 = this.d - i5;
        int a = this.o.a();
        int i7 = this.l % itemHeight;
        int i8 = i7;
        if (Math.abs(i7) <= itemHeight / 2) {
            i8 = 0;
        }
        if (this.a && a > 0) {
            if (i8 > 0) {
                i4 = i6 - 1;
                i2 = i5 + 1;
            } else {
                i2 = i5;
                i4 = i6;
                if (i8 < 0) {
                    i4 = i6 + 1;
                    i2 = i5 - 1;
                }
            }
            while (i4 < 0) {
                i4 += a;
            }
            i3 = i4 % a;
        } else if (i6 < 0) {
            i2 = this.d;
            i3 = 0;
        } else if (i6 >= a) {
            i2 = (this.d - a) + 1;
            i3 = a - 1;
        } else if (i6 <= 0 || i8 <= 0) {
            i2 = i5;
            i3 = i6;
            if (i6 < a - 1) {
                i2 = i5;
                i3 = i6;
                if (i8 < 0) {
                    i3 = i6 + 1;
                    i2 = i5 - 1;
                }
            }
        } else {
            i3 = i6 - 1;
            i2 = i5 + 1;
        }
        int i9 = this.l;
        if (i3 != this.d) {
            a(i3, false);
        } else {
            invalidate();
        }
        int i10 = i9 - (i2 * itemHeight);
        this.l = i10;
        if (i10 > getHeight()) {
            this.l = (this.l % getHeight()) + getHeight();
        }
    }

    private void b(Canvas canvas) {
        int height = getHeight() / 2;
        int itemHeight = (int) ((getItemHeight() / 2) * 1.2d);
        this.g.setBounds(0, height - itemHeight, getWidth(), height + itemHeight);
        this.g.draw(canvas);
    }

    private boolean b(int i, boolean z) {
        View d = d(i);
        if (d != null) {
            if (z) {
                this.m.addView(d, 0);
                return true;
            }
            this.m.addView(d);
            return true;
        }
        return false;
    }

    private int c(int i, int i2) {
        d();
        this.m.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.m.measure(View.MeasureSpec.makeMeasureSpec(i, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = this.m.getMeasuredWidth();
        if (i2 != 1073741824) {
            int max = Math.max(measuredWidth + 20, getSuggestedMinimumWidth());
            if (i2 != Integer.MIN_VALUE || i >= max) {
                i = max;
            }
        }
        this.m.measure(View.MeasureSpec.makeMeasureSpec(i - 20, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return i;
    }

    private boolean c(int i) {
        WheelViewAdapter wheelViewAdapter = this.o;
        if (wheelViewAdapter == null || wheelViewAdapter.a() <= 0) {
            return false;
        }
        if (this.a) {
            return true;
        }
        return i >= 0 && i < this.o.a();
    }

    private View d(int i) {
        WheelViewAdapter wheelViewAdapter = this.o;
        if (wheelViewAdapter == null || wheelViewAdapter.a() == 0) {
            return null;
        }
        int a = this.o.a();
        int i2 = i;
        if (c(i)) {
            while (i2 < 0) {
                i2 += a;
            }
            return this.o.a(i2 % a, this.p.a(), this.m);
        }
        return this.o.a(this.p.b(), this.m);
    }

    private void d() {
        if (this.g == null) {
            this.g = getContext().getResources().getDrawable(R.drawable.horizontal_line);
        }
        if (this.h == null) {
            this.h = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, c);
        }
        if (this.i == null) {
            this.i = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, c);
        }
    }

    private void d(int i, int i2) {
        this.m.layout(0, 0, i - 20, i2);
    }

    private boolean e() {
        boolean z;
        ItemsRange itemsRange = getItemsRange();
        LinearLayout linearLayout = this.m;
        if (linearLayout != null) {
            int a = this.p.a(linearLayout, this.n, itemsRange);
            z = this.n != a;
            this.n = a;
        } else {
            g();
            z = true;
        }
        boolean z2 = z;
        if (!z) {
            z2 = (this.n == itemsRange.a() && this.m.getChildCount() == itemsRange.c()) ? false : true;
        }
        if (this.n > itemsRange.a() && this.n <= itemsRange.b()) {
            int i = this.n;
            while (true) {
                int i2 = i - 1;
                if (i2 < itemsRange.a() || !b(i2, true)) {
                    break;
                }
                this.n = i2;
                i = i2;
            }
        } else {
            this.n = itemsRange.a();
        }
        int i3 = this.n;
        int childCount = this.m.getChildCount();
        while (childCount < itemsRange.c()) {
            int i4 = i3;
            if (!b(this.n + childCount, false)) {
                i4 = i3;
                if (this.m.getChildCount() == 0) {
                    i4 = i3 + 1;
                }
            }
            childCount++;
            i3 = i4;
        }
        this.n = i3;
        return z2;
    }

    private void f() {
        if (e()) {
            c(getWidth(), 1073741824);
            d(getWidth(), getHeight());
        }
    }

    private void g() {
        if (this.m == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.m = linearLayout;
            linearLayout.setOrientation(1);
        }
    }

    private int getItemHeight() {
        int i = this.f;
        if (i != 0) {
            return i;
        }
        LinearLayout linearLayout = this.m;
        if (linearLayout == null || linearLayout.getChildAt(0) == null) {
            return getHeight() / this.e;
        }
        int height = this.m.getChildAt(0).getHeight();
        this.f = height;
        return height;
    }

    private ItemsRange getItemsRange() {
        int i;
        if (getItemHeight() == 0) {
            return null;
        }
        int i2 = this.d;
        int i3 = 1;
        while (true) {
            i = i3;
            if (getItemHeight() * i >= getHeight()) {
                break;
            }
            i2--;
            i3 = i + 2;
        }
        int i4 = this.l;
        int i5 = i2;
        int i6 = i;
        if (i4 != 0) {
            int i7 = i2;
            if (i4 > 0) {
                i7 = i2 - 1;
            }
            int itemHeight = this.l / getItemHeight();
            i5 = i7 - itemHeight;
            i6 = (int) (i + 1 + Math.asin(itemHeight));
        }
        return new ItemsRange(i5, i6);
    }

    private void h() {
        LinearLayout linearLayout = this.m;
        if (linearLayout != null) {
            this.p.a(linearLayout, this.n, new ItemsRange());
        } else {
            g();
        }
        int i = this.e / 2;
        int i2 = this.d + i;
        while (true) {
            int i3 = i2;
            if (i3 < this.d - i) {
                return;
            }
            if (b(i3, true)) {
                this.n = i3;
            }
            i2 = i3 - 1;
        }
    }

    protected void a() {
        for (OnWheelScrollListener onWheelScrollListener : this.r) {
            onWheelScrollListener.a(this);
        }
    }

    protected void a(int i) {
        for (OnWheelClickedListener onWheelClickedListener : this.s) {
            onWheelClickedListener.a(this, i);
        }
    }

    protected void a(int i, int i2) {
        for (OnWheelChangedListener onWheelChangedListener : this.q) {
            onWheelChangedListener.a(this, i, i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r5 >= r0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r5, boolean r6) {
        /*
            r4 = this;
            r0 = r4
            com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter r0 = r0.o
            r11 = r0
            r0 = r11
            if (r0 == 0) goto Lad
            r0 = r11
            int r0 = r0.a()
            if (r0 != 0) goto L16
            return
        L16:
            r0 = r4
            com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter r0 = r0.o
            int r0 = r0.a()
            r9 = r0
            r0 = r5
            if (r0 < 0) goto L2d
            r0 = r5
            r7 = r0
            r0 = r5
            r1 = r9
            if (r0 < r1) goto L45
        L2d:
            r0 = r4
            boolean r0 = r0.a
            if (r0 == 0) goto Lad
        L34:
            r0 = r5
            if (r0 >= 0) goto L40
            r0 = r5
            r1 = r9
            int r0 = r0 + r1
            r5 = r0
            goto L34
        L40:
            r0 = r5
            r1 = r9
            int r0 = r0 % r1
            r7 = r0
        L45:
            r0 = r4
            int r0 = r0.d
            r10 = r0
            r0 = r7
            r1 = r10
            if (r0 == r1) goto Lad
            r0 = r6
            if (r0 == 0) goto L98
            r0 = r7
            r1 = r10
            int r0 = r0 - r1
            r8 = r0
            r0 = r8
            r5 = r0
            r0 = r4
            boolean r0 = r0.a
            if (r0 == 0) goto L91
            r0 = r9
            r1 = r7
            r2 = r10
            int r1 = java.lang.Math.min(r1, r2)
            int r0 = r0 + r1
            r1 = r7
            r2 = r4
            int r2 = r2.d
            int r1 = java.lang.Math.max(r1, r2)
            int r0 = r0 - r1
            r7 = r0
            r0 = r8
            r5 = r0
            r0 = r7
            r1 = r8
            int r1 = java.lang.Math.abs(r1)
            if (r0 >= r1) goto L91
            r0 = r8
            if (r0 >= 0) goto L8e
            r0 = r7
            r5 = r0
            goto L91
        L8e:
            r0 = r7
            int r0 = -r0
            r5 = r0
        L91:
            r0 = r4
            r1 = r5
            r2 = 0
            r0.b(r1, r2)
            return
        L98:
            r0 = r4
            r1 = 0
            r0.l = r1
            r0 = r4
            r1 = r7
            r0.d = r1
            r0 = r4
            r1 = r10
            r2 = r7
            r0.a(r1, r2)
            r0 = r4
            r0.invalidate()
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.view.wheel.widget.WheelView.a(int, boolean):void");
    }

    public void a(boolean z) {
        if (z) {
            this.p.c();
            LinearLayout linearLayout = this.m;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.l = 0;
        } else {
            LinearLayout linearLayout2 = this.m;
            if (linearLayout2 != null) {
                this.p.a(linearLayout2, this.n, new ItemsRange());
            }
        }
        invalidate();
    }

    protected void b() {
        for (OnWheelScrollListener onWheelScrollListener : this.r) {
            onWheelScrollListener.b(this);
        }
    }

    public void b(int i, int i2) {
        int itemHeight = getItemHeight();
        this.j.a((i * itemHeight) - this.l, i2);
    }

    public boolean c() {
        return this.a;
    }

    public int getCurrentItem() {
        return this.d;
    }

    public WheelViewAdapter getViewAdapter() {
        return this.o;
    }

    public int getVisibleItems() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        WheelViewAdapter wheelViewAdapter = this.o;
        if (wheelViewAdapter == null || wheelViewAdapter.a() <= 0) {
            return;
        }
        f();
        a(canvas);
        b(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        d(i3 - i, i4 - i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        h();
        int c2 = c(size, mode);
        if (mode2 != 1073741824) {
            int a = a(this.m);
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(a, size2) : a;
        }
        setMeasuredDimension(c2, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || getViewAdapter() == null) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2 && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (!this.k) {
            int y = ((int) motionEvent.getY()) - (getHeight() / 2);
            int itemHeight = (y > 0 ? y + (getItemHeight() / 2) : y - (getItemHeight() / 2)) / getItemHeight();
            if (itemHeight != 0 && c(this.d + itemHeight)) {
                a(this.d + itemHeight);
            }
        }
        return this.j.a(motionEvent);
    }

    public void setCurrentItem(int i) {
        a(i, false);
    }

    public void setCyclic(boolean z) {
        this.a = z;
        a(false);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.j.a(interpolator);
    }

    public void setViewAdapter(WheelViewAdapter wheelViewAdapter) {
        WheelViewAdapter wheelViewAdapter2 = this.o;
        if (wheelViewAdapter2 != null) {
            wheelViewAdapter2.b(this.t);
        }
        this.o = wheelViewAdapter;
        if (wheelViewAdapter != null) {
            wheelViewAdapter.a(this.t);
        }
        a(true);
    }

    public void setVisibleItems(int i) {
        this.e = i;
    }
}
