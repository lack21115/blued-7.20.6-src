package com.blued.android.module.common.widget.consecutivescroller;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.common.R;
import java.util.ArrayList;
import java.util.List;
import skin.support.widget.SkinCompatBackgroundHelper;
import skin.support.widget.SkinCompatSupportable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/consecutivescroller/ConsecutiveScrollerLayout.class */
public class ConsecutiveScrollerLayout extends ViewGroup implements NestedScrollingChild2, NestedScrollingParent2, ScrollingView, SkinCompatSupportable {
    static final Interpolator b = new Interpolator() { // from class: com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private int A;
    private EdgeEffect B;
    private EdgeEffect C;
    private int D;
    private boolean E;
    private int F;
    private View G;
    private final List<View> H;
    private final List<View> I;
    private int J;
    private final List<View> K;
    private int L;
    private OnStickyChangeListener M;
    private OnPermanentStickyChangeListener N;
    private int O;
    private SkinCompatBackgroundHelper P;
    protected OnScrollChangeListener a;
    private int c;
    private int d;
    private OverScroller e;
    private VelocityTracker f;
    private VelocityTracker g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private float n;
    private final int[] o;
    private boolean p;
    private int q;
    private int r;
    private NestedScrollingParentHelper s;
    private NestedScrollingChildHelper t;
    private final int[] u;
    private final int[] v;
    private View w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout$3  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/consecutivescroller/ConsecutiveScrollerLayout$3.class */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[LayoutParams.Align.values().length];
            a = iArr;
            try {
                iArr[LayoutParams.Align.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[LayoutParams.Align.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[LayoutParams.Align.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/consecutivescroller/ConsecutiveScrollerLayout$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public boolean a;
        public boolean b;
        public boolean c;
        public Align d;

        /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/consecutivescroller/ConsecutiveScrollerLayout$LayoutParams$Align.class */
        public enum Align {
            LEFT(1),
            RIGHT(2),
            CENTER(3);
            
            int d;

            Align(int i) {
                this.d = i;
            }

            static Align a(int i) {
                return i != 1 ? i != 2 ? i != 3 ? LEFT : CENTER : RIGHT : LEFT;
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = true;
            this.b = true;
            this.c = false;
            this.d = Align.LEFT;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArray;
            this.a = true;
            this.b = true;
            this.c = false;
            this.d = Align.LEFT;
            TypedArray typedArray2 = null;
            TypedArray typedArray3 = null;
            try {
                try {
                    typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ConsecutiveScrollerLayout_Layout);
                    this.a = typedArray.getBoolean(R.styleable.ConsecutiveScrollerLayout_Layout_layout_isConsecutive, true);
                    this.c = typedArray.getBoolean(R.styleable.ConsecutiveScrollerLayout_Layout_layout_isSticky, false);
                    this.b = typedArray.getBoolean(R.styleable.ConsecutiveScrollerLayout_Layout_layout_isNestedScroll, true);
                    typedArray3 = typedArray;
                    typedArray2 = typedArray;
                    this.d = Align.a(typedArray.getInt(R.styleable.ConsecutiveScrollerLayout_Layout_layout_align, 1));
                    if (typedArray == null) {
                        return;
                    }
                } catch (Exception e) {
                    typedArray3 = typedArray2;
                    e.printStackTrace();
                    if (typedArray2 == null) {
                        return;
                    }
                    typedArray = typedArray2;
                }
                typedArray.recycle();
            } catch (Throwable th) {
                if (typedArray3 != null) {
                    typedArray3.recycle();
                }
                throw th;
            }
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = true;
            this.b = true;
            this.c = false;
            this.d = Align.LEFT;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/consecutivescroller/ConsecutiveScrollerLayout$OnPermanentStickyChangeListener.class */
    public interface OnPermanentStickyChangeListener {
        void a(List<View> list);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/consecutivescroller/ConsecutiveScrollerLayout$OnScrollChangeListener.class */
    public interface OnScrollChangeListener {
        void a(View view, int i, int i2, int i3);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/consecutivescroller/ConsecutiveScrollerLayout$OnStickyChangeListener.class */
    public interface OnStickyChangeListener {
        void a(View view, View view2);
    }

    public ConsecutiveScrollerLayout(Context context) {
        this(context, null);
    }

    public ConsecutiveScrollerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConsecutiveScrollerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = new int[2];
        this.p = false;
        this.q = 0;
        this.u = new int[2];
        this.v = new int[2];
        this.y = -1;
        this.z = 0;
        this.A = 0;
        this.F = 0;
        this.H = new ArrayList();
        this.I = new ArrayList();
        this.J = 0;
        this.K = new ArrayList();
        this.L = 0;
        this.O = 0;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.P = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
        TypedArray typedArray = null;
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConsecutiveScrollerLayout);
            typedArray = obtainStyledAttributes;
            this.E = obtainStyledAttributes.getBoolean(R.styleable.ConsecutiveScrollerLayout_isPermanent, false);
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
            this.e = new OverScroller(getContext(), b);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.h = viewConfiguration.getScaledMaximumFlingVelocity();
            this.i = viewConfiguration.getScaledMinimumFlingVelocity();
            this.j = ViewConfiguration.getTouchSlop();
            setWillNotDraw(false);
            setVerticalScrollBarEnabled(true);
            this.s = new NestedScrollingParentHelper(this);
            this.t = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
            setChildrenDrawingOrderEnabled(true);
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    private int a(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            i3 = size;
        } else {
            i3 = i2;
            if (mode == Integer.MIN_VALUE) {
                i3 = Math.min(i2, size);
            }
        }
        return resolveSizeAndState(Math.max(i3, getSuggestedMinimumWidth()), i, 0);
    }

    private int a(View view, int i, int i2, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = AnonymousClass3.a[layoutParams.d.ordinal()];
        return i4 != 1 ? i4 != 2 ? i2 + layoutParams.leftMargin : layoutParams.leftMargin + i2 + ((((((i - view.getMeasuredWidth()) - i2) - layoutParams.leftMargin) - i3) - layoutParams.rightMargin) / 2) : ((i - view.getMeasuredWidth()) - i3) - layoutParams.rightMargin;
    }

    private int a(List<View> list, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += list.get(i3).getMeasuredHeight();
        }
        return i2;
    }

    private void a(int i) {
        if (Math.abs(i) > this.i) {
            float f = i;
            if (dispatchNestedPreFling(0.0f, f)) {
                return;
            }
            dispatchNestedFling(0.0f, f, (i < 0 && !d()) || (i > 0 && !e()));
            this.e.fling(0, this.c, 1, i, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            startNestedScroll(2, 1);
            setScrollState(2);
            this.D = this.c;
            invalidate();
        }
    }

    private void a(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
        view.setOverScrollMode(2);
        ViewCompat.setNestedScrollingEnabled(view, false);
    }

    private void a(View view, View view2) {
        OnStickyChangeListener onStickyChangeListener = this.M;
        if (onStickyChangeListener != null) {
            onStickyChangeListener.a(view, view2);
        }
    }

    private void a(List<View> list) {
        OnPermanentStickyChangeListener onPermanentStickyChangeListener = this.N;
        if (onPermanentStickyChangeListener != null) {
            onPermanentStickyChangeListener.a(list);
        }
    }

    private void a(boolean z, boolean z2) {
        View view = this.w;
        if (view == null || !z) {
            e(getScrollY());
        } else if (indexOfChild(view) != -1) {
            e(this.w.getTop() + this.x);
        }
        this.w = null;
        this.x = 0;
        b(true, z2);
        r();
        s();
    }

    private boolean a(MotionEvent motionEvent) {
        int findPointerIndex = motionEvent.findPointerIndex(this.r);
        if (findPointerIndex < 0 || findPointerIndex >= motionEvent.getPointerCount()) {
            return false;
        }
        return d(ScrollUtils.a(this, motionEvent, findPointerIndex), ScrollUtils.b(this, motionEvent, findPointerIndex));
    }

    private int b(View view) {
        int measuredWidth = view.getMeasuredWidth();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin;
    }

    private void b(int i) {
        if (i > 0) {
            c(i);
        } else if (i < 0) {
            d(i);
        }
    }

    private void b(int i, int i2) {
        OnScrollChangeListener onScrollChangeListener = this.a;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.a(this, i, i2, this.O);
        }
    }

    private void b(View view, int i) {
        RecyclerView h = ScrollUtils.h(view);
        if (h instanceof AbsListView) {
            AbsListView absListView = (AbsListView) h;
            if (Build.VERSION.SDK_INT >= 19) {
                absListView.scrollListBy(i);
                return;
            }
            return;
        }
        boolean a = h instanceof RecyclerView ? ScrollUtils.a(h) : false;
        h.scrollBy(0, i);
        if (a) {
            final RecyclerView recyclerView = h;
            recyclerView.postDelayed(new Runnable() { // from class: com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    ScrollUtils.b(recyclerView);
                }
            }, 0L);
        }
    }

    private void b(List<View> list) {
        this.I.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            View view = list.get(i2);
            int a = a(list, i2);
            if (getScrollY() > 0 && view.getTop() <= getStickyY() + a) {
                view.setY(getStickyY() + a);
                view.setClickable(true);
                this.I.add(view);
            }
            i = i2 + 1;
        }
        if (v()) {
            return;
        }
        this.H.clear();
        this.H.addAll(this.I);
        this.I.clear();
        a(this.H);
    }

    private void b(boolean z, boolean z2) {
        int i;
        int i2;
        if (z2 || (!this.p && this.e.isFinished() && this.y == -1)) {
            int i3 = this.c;
            View b2 = b();
            if (b2 == null) {
                return;
            }
            int indexOfChild = indexOfChild(b2);
            if (z) {
                int e = ScrollUtils.e(b2);
                int top = b2.getTop() - getScrollY();
                if (e > 0 && top < 0) {
                    int min = Math.min(e, -top);
                    e(getScrollY() - min);
                    b(b2, min);
                }
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                i = indexOfChild;
                if (i5 >= indexOfChild) {
                    break;
                }
                View childAt = getChildAt(i5);
                if (ScrollUtils.g(childAt)) {
                    if (childAt instanceof IConsecutiveScroller) {
                        List<View> scrolledViews = ((IConsecutiveScroller) childAt).getScrolledViews();
                        if (scrolledViews != null && !scrolledViews.isEmpty()) {
                            int size = scrolledViews.size();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 < size) {
                                    d(scrolledViews.get(i7));
                                    i6 = i7 + 1;
                                }
                            }
                        }
                    } else {
                        d(childAt);
                    }
                }
                i4 = i5 + 1;
            }
            while (true) {
                int i8 = i + 1;
                if (i8 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i8);
                i = i8;
                if (ScrollUtils.g(childAt2)) {
                    if (i8 == getChildCount() - 1 && (childAt2 instanceof ConsecutiveViewPager) && getScrollY() >= this.d) {
                        i = i8;
                    } else if (childAt2 instanceof IConsecutiveScroller) {
                        List<View> scrolledViews2 = ((IConsecutiveScroller) childAt2).getScrolledViews();
                        i = i8;
                        if (scrolledViews2 != null) {
                            i = i8;
                            if (!scrolledViews2.isEmpty()) {
                                int size2 = scrolledViews2.size();
                                int i9 = 0;
                                while (true) {
                                    int i10 = i9;
                                    i = i8;
                                    if (i10 < size2) {
                                        c(scrolledViews2.get(i10));
                                        i9 = i10 + 1;
                                    }
                                }
                            }
                        }
                    } else {
                        c(childAt2);
                        i = i8;
                    }
                }
            }
            k();
            if (z && i3 != (i2 = this.c)) {
                b(i2, i3);
            }
            s();
        }
    }

    private View c(int i, int i2) {
        for (View view : getNonGoneChildren()) {
            if (ScrollUtils.b(view, i, i2)) {
                return view;
            }
        }
        return null;
    }

    private void c(int i) {
        int i2;
        int i3;
        int i4;
        int i5 = this.c;
        int i6 = i;
        do {
            int i7 = this.y;
            if (i7 != -1) {
                int top = getChildAt(i7).getTop();
                int i8 = this.A;
                i2 = top - i8;
                int f = i8 < 0 ? f(this.y) : 0;
                if (getScrollY() + getPaddingTop() + f < i2) {
                    i3 = f;
                    if (e()) {
                    }
                }
                this.y = -1;
                this.z = 0;
                this.A = 0;
                setScrollState(0);
                break;
            }
            i2 = 0;
            i3 = 0;
            int i9 = 0;
            i4 = i6;
            if (!e()) {
                View b2 = getScrollY() < this.d ? b() : getBottomView();
                i9 = 0;
                i4 = i6;
                if (b2 != null) {
                    awakenScrollBars();
                    int e = ScrollUtils.e(b2);
                    if (e > 0) {
                        int min = Math.min(i6, e);
                        i9 = min;
                        if (this.y != -1) {
                            i9 = Math.min(min, i2 - ((getScrollY() + getPaddingTop()) + i3));
                        }
                        b(b2, i9);
                    } else {
                        int min2 = Math.min(i6, (b2.getBottom() - getPaddingTop()) - getScrollY());
                        i9 = min2;
                        if (this.y != -1) {
                            i9 = Math.min(min2, i2 - ((getScrollY() + getPaddingTop()) + i3));
                        }
                        e(getScrollY() + i9);
                    }
                    this.c += i9;
                    i4 = i6 - i9;
                }
            }
            if (i9 <= 0) {
                break;
            }
            i6 = i4;
        } while (i4 > 0);
        int i10 = this.c;
        if (i5 != i10) {
            b(i10, i5);
        }
    }

    private void c(View view) {
        int i;
        do {
            i = 0;
            int d = ScrollUtils.d(view);
            if (d < 0) {
                int a = ScrollUtils.a(view);
                b(view, d);
                i = a - ScrollUtils.a(view);
            }
        } while (i != 0);
    }

    private void c(View view, int i) {
        view.setY(getStickyY() - i);
        view.setClickable(true);
    }

    private void d(int i) {
        int i2;
        int i3;
        int i4;
        int i5 = this.c;
        int i6 = i;
        do {
            int i7 = this.y;
            if (i7 != -1) {
                i2 = getChildAt(i7).getTop() - this.A;
                i3 = f(this.y);
                if (getScrollY() + getPaddingTop() + i3 <= i2 || d()) {
                    this.y = -1;
                    this.z = 0;
                    this.A = 0;
                    setScrollState(0);
                    break;
                }
            } else {
                i2 = 0;
                i3 = 0;
            }
            int i8 = 0;
            i4 = i6;
            if (!d()) {
                View c = c();
                i8 = 0;
                i4 = i6;
                if (c != null) {
                    awakenScrollBars();
                    int d = ScrollUtils.d(c);
                    if (d < 0) {
                        int max = Math.max(i6, d);
                        i8 = max;
                        if (this.y != -1) {
                            i8 = Math.max(max, i2 - ((getScrollY() + getPaddingTop()) + i3));
                        }
                        b(c, i8);
                    } else {
                        int scrollY = getScrollY();
                        int max2 = Math.max(Math.max(i6, ((c.getTop() + getPaddingBottom()) - scrollY) - getHeight()), -scrollY);
                        i8 = max2;
                        if (this.y != -1) {
                            i8 = Math.max(max2, i2 - ((getScrollY() + getPaddingTop()) + i3));
                        }
                        e(scrollY + i8);
                    }
                    this.c += i8;
                    i4 = i6 - i8;
                }
            }
            if (i8 >= 0) {
                break;
            }
            i6 = i4;
        } while (i4 < 0);
        int i9 = this.c;
        if (i5 != i9) {
            b(i9, i5);
        }
    }

    private void d(View view) {
        int i;
        do {
            i = 0;
            int e = ScrollUtils.e(view);
            if (e > 0) {
                int a = ScrollUtils.a(view);
                b(view, e);
                i = a - ScrollUtils.a(view);
            }
        } while (i != 0);
    }

    private boolean d(int i, int i2) {
        View c = c(i, i2);
        if (c != null) {
            return ScrollUtils.g(c);
        }
        return false;
    }

    private void e(int i) {
        int i2;
        if (i < 0) {
            i2 = 0;
        } else {
            int i3 = this.d;
            i2 = i;
            if (i > i3) {
                i2 = i3;
            }
        }
        super.scrollTo(0, i2);
    }

    private void e(int i, int i2) {
        int i3 = this.c;
        b(i);
        int i4 = this.c - i3;
        this.t.dispatchNestedScroll(0, i4, 0, i - i4, (int[]) null, i2);
    }

    private boolean e(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            return ((LayoutParams) layoutParams).c;
        }
        return false;
    }

    private int f(int i) {
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= size) {
                return i3;
            }
            View view = nonGoneChildren.get(i);
            int i4 = i3;
            if (view.getVisibility() != 8) {
                i4 = i3;
                if (ScrollUtils.g(view)) {
                    i4 = i3 + ScrollUtils.a(view);
                }
            }
            i++;
            i2 = i4;
        }
    }

    private void f() {
        int i;
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (!e(childAt)) {
                arrayList.add(childAt);
            }
            i2 = i3 + 1;
        }
        for (i = 0; i < childCount; i++) {
            View childAt2 = getChildAt(i);
            if (e(childAt2)) {
                arrayList.add(childAt2);
            }
        }
        this.K.clear();
        this.K.addAll(arrayList);
    }

    private void g() {
        View w = w();
        this.w = w;
        if (w != null) {
            this.x = getScrollY() - this.w.getTop();
        }
    }

    private View getBottomView() {
        List<View> effectiveChildren = getEffectiveChildren();
        if (effectiveChildren.isEmpty()) {
            return null;
        }
        return effectiveChildren.get(effectiveChildren.size() - 1);
    }

    private List<View> getEffectiveChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return arrayList;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && childAt.getHeight() > 0) {
                arrayList.add(childAt);
            }
            i = i2 + 1;
        }
    }

    private List<View> getNonGoneChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return arrayList;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                arrayList.add(childAt);
            }
            i = i2 + 1;
        }
    }

    private int getScrollRange() {
        int i = 0;
        if (getChildCount() > 0) {
            i = Math.max(0, computeVerticalScrollRange() - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        }
        return i;
    }

    private List<View> getStickyChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return arrayList;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && e(childAt)) {
                arrayList.add(childAt);
            }
            i = i2 + 1;
        }
    }

    private int getStickyY() {
        return getScrollY() + getPaddingTop() + this.F;
    }

    private boolean h() {
        return (d() && e()) ? false : true;
    }

    private void i() {
        EdgeEffect edgeEffect = this.B;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.C.onRelease();
        }
    }

    private void j() {
        if (getOverScrollMode() == 2) {
            this.B = null;
            this.C = null;
        } else if (this.B == null) {
            Context context = getContext();
            this.B = new EdgeEffect(context);
            this.C = new EdgeEffect(context);
        }
    }

    private void k() {
        this.c = computeVerticalScrollOffset();
    }

    private void l() {
        VelocityTracker velocityTracker = this.f;
        if (velocityTracker == null) {
            this.f = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void m() {
        VelocityTracker velocityTracker = this.f;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f = null;
        }
    }

    private void n() {
        VelocityTracker velocityTracker = this.g;
        if (velocityTracker == null) {
            this.g = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void o() {
        if (this.g == null) {
            this.g = VelocityTracker.obtain();
        }
    }

    private void p() {
        VelocityTracker velocityTracker = this.g;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.g = null;
        }
    }

    private void q() {
        this.e.abortAnimation();
        stopNestedScroll(1);
        if (this.y == -1) {
            setScrollState(0);
        }
    }

    private void r() {
        for (View view : getNonGoneChildren()) {
            view.setTranslationY(0.0f);
        }
    }

    private void s() {
        View view;
        View view2;
        List<View> stickyChildren = getStickyChildren();
        if (stickyChildren.isEmpty()) {
            t();
            u();
            return;
        }
        int size = stickyChildren.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            stickyChildren.get(i2).setTranslationY(0.0f);
            i = i2 + 1;
        }
        if (this.E) {
            t();
            b(stickyChildren);
            return;
        }
        u();
        int i3 = size - 1;
        int i4 = i3;
        while (true) {
            int i5 = i4;
            view = null;
            view2 = null;
            if (i5 < 0) {
                view2 = null;
                break;
            }
            view = stickyChildren.get(i5);
            if (getScrollY() <= 0 || view.getTop() > getStickyY()) {
                i4 = i5 - 1;
            } else if (i5 != i3) {
                view2 = stickyChildren.get(i5 + 1);
            }
        }
        View view3 = this.G;
        if (view != null) {
            int i6 = 0;
            if (view2 != null) {
                i6 = Math.max(0, view.getHeight() - (view2.getTop() - getStickyY()));
            }
            c(view, i6);
        }
        if (view3 != view) {
            this.G = view;
            a(view3, view);
        }
    }

    private void t() {
        View view = this.G;
        if (view != null) {
            this.G = null;
            a(view, (View) null);
        }
    }

    private void u() {
        if (this.H.isEmpty()) {
            return;
        }
        this.H.clear();
        a(this.H);
    }

    private boolean v() {
        if (this.I.size() != this.H.size()) {
            return false;
        }
        int size = this.I.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return true;
            }
            if (this.I.get(i2) != this.H.get(i2)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private View w() {
        int scrollY = getScrollY() + getPaddingTop();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            View view = nonGoneChildren.get(i2);
            if (view.getTop() <= scrollY && view.getBottom() >= scrollY) {
                return view;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
        if ((getScrollY() + getPaddingTop()) < r0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
        if (((getScrollY() + getPaddingTop()) + r0) < r0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006d, code lost:
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.view.View r4, int r5) {
        /*
            r3 = this;
            r0 = r3
            r1 = r4
            int r0 = r0.indexOfChild(r1)
            r8 = r0
            r0 = 0
            r10 = r0
            r0 = -1
            r6 = r0
            r0 = r8
            r1 = -1
            if (r0 == r1) goto Lae
            r0 = r4
            int r0 = r0.getTop()
            r1 = r5
            int r0 = r0 - r1
            r7 = r0
            r0 = r5
            if (r0 < 0) goto L40
            r0 = r3
            int r0 = r0.getScrollY()
            r1 = r3
            int r1 = r1.getPaddingTop()
            int r0 = r0 + r1
            r1 = r7
            if (r0 <= r1) goto L2f
            goto L74
        L2f:
            r0 = r3
            int r0 = r0.getScrollY()
            r1 = r3
            int r1 = r1.getPaddingTop()
            int r0 = r0 + r1
            r1 = r7
            if (r0 >= r1) goto L72
            goto L6d
        L40:
            r0 = r3
            r1 = r8
            int r0 = r0.f(r1)
            r9 = r0
            r0 = r3
            int r0 = r0.getScrollY()
            r1 = r3
            int r1 = r1.getPaddingTop()
            int r0 = r0 + r1
            r1 = r9
            int r0 = r0 + r1
            r1 = r7
            if (r0 <= r1) goto L5c
            goto L74
        L5c:
            r0 = r3
            int r0 = r0.getScrollY()
            r1 = r3
            int r1 = r1.getPaddingTop()
            int r0 = r0 + r1
            r1 = r9
            int r0 = r0 + r1
            r1 = r7
            if (r0 >= r1) goto L72
        L6d:
            r0 = 1
            r6 = r0
            goto L74
        L72:
            r0 = 0
            r6 = r0
        L74:
            r0 = r6
            r7 = r0
            r0 = r6
            if (r0 == 0) goto Lb1
            r0 = r3
            r1 = r8
            r0.y = r1
            r0 = r3
            r0.q()
            r0 = r3
            r1 = r5
            r0.A = r1
            r0 = r3
            r1 = 2
            r0.setScrollState(r1)
            r0 = r6
            if (r0 >= 0) goto L9d
            r0 = r3
            r1 = -200(0xffffffffffffff38, float:NaN)
            r0.z = r1
            goto La4
        L9d:
            r0 = r3
            r1 = 200(0xc8, float:2.8E-43)
            r0.z = r1
        La4:
            r0 = r3
            r0.invalidate()
            r0 = r6
            r7 = r0
            goto Lb1
        Lae:
            r0 = 0
            r7 = r0
        Lb1:
            r0 = r7
            if (r0 == 0) goto Lb9
            r0 = 1
            r10 = r0
        Lb9:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout.a(android.view.View, int):boolean");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        List<View> scrolledViews;
        if (layoutParams instanceof LayoutParams) {
            LayoutParamsUtils.a((LayoutParams) layoutParams);
        }
        super.addView(view, i, layoutParams);
        if (ScrollUtils.g(view)) {
            a(view);
            if ((view instanceof IConsecutiveScroller) && (scrolledViews = ((IConsecutiveScroller) view).getScrolledViews()) != null && !scrolledViews.isEmpty()) {
                int size = scrolledViews.size();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= size) {
                        break;
                    }
                    a(scrolledViews.get(i3));
                    i2 = i3 + 1;
                }
            }
        }
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).setClipToPadding(false);
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.P;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    public View b() {
        int scrollY = getScrollY() + getPaddingTop();
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            View view = effectiveChildren.get(i2);
            if (view.getTop() <= scrollY && view.getBottom() > scrollY) {
                return view;
            }
            i = i2 + 1;
        }
    }

    public View c() {
        int height = (getHeight() - getPaddingBottom()) + getScrollY();
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            View view = effectiveChildren.get(i2);
            if (view.getTop() < height && view.getBottom() >= height) {
                return view;
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return i > 0 ? !e() : !d();
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0088, code lost:
        if (e() != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00de  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void computeScroll() {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout.computeScroll():void");
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        int scrollY = getScrollY();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int i = 0;
        while (i < size) {
            View view = nonGoneChildren.get(i);
            int i2 = scrollY;
            if (ScrollUtils.g(view)) {
                i2 = scrollY + ScrollUtils.a(view);
            }
            i++;
            scrollY = i2;
        }
        return scrollY;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int height;
        int i;
        int b2;
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            View view = nonGoneChildren.get(i3);
            if (!ScrollUtils.g(view)) {
                height = view.getHeight();
            } else if (ScrollUtils.f(view)) {
                View h = ScrollUtils.h(view);
                i = i2;
                b2 = ScrollUtils.b(h) + h.getPaddingTop() + h.getPaddingBottom();
                i2 = i + b2;
            } else {
                height = view.getHeight();
            }
            i = i2;
            b2 = height;
            i2 = i + b2;
        }
        return i2;
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [com.blued.android.module.common.widget.consecutivescroller.ConsecutiveViewPager, android.view.View] */
    public boolean d() {
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        boolean z = true;
        boolean z2 = true;
        if (size > 0) {
            View view = effectiveChildren.get(0);
            if (getScrollY() > 0 || ScrollUtils.a(view, -1)) {
                z2 = false;
            }
            z = z2;
            if (z2) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = z2;
                    if (i2 >= size) {
                        break;
                    }
                    View view2 = effectiveChildren.get(i2);
                    if (view2 instanceof ConsecutiveViewPager) {
                        ?? r0 = (ConsecutiveViewPager) view2;
                        if (r0.getAdjustHeight() > 0 && ScrollUtils.g(r0) && ScrollUtils.a(r0, -1)) {
                            return false;
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
        return z;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.t.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.t.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.t.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.t.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.t.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x01ab, code lost:
        if (d(r0[0], r0[1]) != false) goto L67;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 874
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ff, code lost:
        if (getClipToPadding() != false) goto L41;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r6) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout.draw(android.graphics.Canvas):void");
    }

    public boolean e() {
        List<View> effectiveChildren = getEffectiveChildren();
        boolean z = true;
        if (effectiveChildren.size() > 0) {
            View view = effectiveChildren.get(effectiveChildren.size() - 1);
            if (getScrollY() >= this.d && !ScrollUtils.a(view, 1)) {
                return true;
            }
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        return this.K.size() > i2 ? indexOfChild(this.K.get(i2)) : super.getChildDrawingOrder(i, i2);
    }

    public View getCurrentStickyView() {
        return this.G;
    }

    public List<View> getCurrentStickyViews() {
        return this.H;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.s.getNestedScrollAxes();
    }

    public OnPermanentStickyChangeListener getOnPermanentStickyChangeListener() {
        return this.N;
    }

    public OnStickyChangeListener getOnStickyChangeListener() {
        return this.M;
    }

    public OnScrollChangeListener getOnVerticalScrollChangeListener() {
        return this.a;
    }

    public int getOwnScrollY() {
        return this.c;
    }

    public int getScrollState() {
        return this.O;
    }

    public int getStickyOffset() {
        return this.F;
    }

    public boolean hasNestedScrollingParent(int i) {
        return this.t.hasNestedScrollingParent(i);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.t.isNestedScrollingEnabled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        LayoutParamsUtils.a((LayoutParams) view.getLayoutParams());
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r0 != 3) goto L9;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            r0 = r6
            int r0 = r0.getActionMasked()
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L47
            r0 = r7
            r1 = 1
            if (r0 == r1) goto L3f
            r0 = r7
            r1 = 2
            if (r0 == r1) goto L1b
            r0 = r7
            r1 = 3
            if (r0 == r1) goto L3f
            goto L53
        L1b:
            r0 = r5
            int r0 = r0.q
            r1 = 2
            if (r0 == r1) goto L53
            r0 = r5
            r1 = r6
            boolean r0 = r0.a(r1)
            if (r0 != 0) goto L3d
            r0 = r5
            int[] r0 = r0.o
            r8 = r0
            r0 = r5
            r1 = r8
            r2 = 0
            r1 = r1[r2]
            r2 = r8
            r3 = 1
            r2 = r2[r3]
            boolean r0 = r0.d(r1, r2)
            if (r0 == 0) goto L53
        L3d:
            r0 = 1
            return r0
        L3f:
            r0 = r5
            r1 = 0
            r0.stopNestedScroll(r1)
            goto L53
        L47:
            r0 = r5
            r0.l()
            r0 = r5
            android.view.VelocityTracker r0 = r0.f
            r1 = r6
            r0.addMovement(r1)
        L53:
            r0 = r5
            r1 = r6
            boolean r0 = super.onInterceptTouchEvent(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.d = 0;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int measuredWidth = getMeasuredWidth();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int i5 = 0;
        while (i5 < size) {
            View view = nonGoneChildren.get(i5);
            int measuredHeight = view.getMeasuredHeight() + paddingTop;
            int a = a(view, measuredWidth, paddingLeft, paddingRight);
            view.layout(a, paddingTop, view.getMeasuredWidth() + a, measuredHeight);
            this.d += view.getHeight();
            i5++;
            paddingTop = measuredHeight;
        }
        int measuredHeight2 = this.d - ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        this.d = measuredHeight2;
        if (measuredHeight2 < 0) {
            this.d = 0;
        }
        a(z, false);
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        g();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            View view = nonGoneChildren.get(i5);
            measureChildWithMargins(view, i, 0, i2, 0);
            i3 = Math.max(i3, b(view));
            i4 += view.getMeasuredHeight();
        }
        setMeasuredDimension(a(i, i3 + getPaddingLeft() + getPaddingRight()), a(i2, i4 + getPaddingTop() + getPaddingBottom()));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        a((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        dispatchNestedPreScroll(i, i2, iArr, null, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        e(i4, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        e(i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.s.onNestedScrollAccepted(view, view2, i, i2);
        b(false, false);
        startNestedScroll(2, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        boolean z = false;
        if (layoutParams instanceof LayoutParams ? ((LayoutParams) layoutParams).b : false) {
            z = false;
            if ((i & 2) != 0) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        this.s.onStopNestedScroll(view, i);
        stopNestedScroll(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
        if (r0 != 6) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0188, code lost:
        if (r0 > 0) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0288  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        scrollTo(0, this.c + i2);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        b(i2 - this.c);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.P;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.t.setNestedScrollingEnabled(z);
    }

    public void setOnPermanentStickyChangeListener(OnPermanentStickyChangeListener onPermanentStickyChangeListener) {
        this.N = onPermanentStickyChangeListener;
    }

    @Override // android.view.View
    @Deprecated
    public void setOnScrollChangeListener(View.OnScrollChangeListener onScrollChangeListener) {
    }

    public void setOnStickyChangeListener(OnStickyChangeListener onStickyChangeListener) {
        this.M = onStickyChangeListener;
    }

    public void setOnVerticalScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.a = onScrollChangeListener;
    }

    public void setPermanent(boolean z) {
        if (this.E != z) {
            this.E = z;
            s();
        }
    }

    void setScrollState(int i) {
        if (i == this.O) {
            return;
        }
        this.O = i;
        int i2 = this.c;
        b(i2, i2);
    }

    public void setStickyOffset(int i) {
        if (this.F != i) {
            this.F = i;
            s();
        }
    }

    public boolean startNestedScroll(int i, int i2) {
        return this.t.startNestedScroll(i, i2);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public void stopNestedScroll(int i) {
        this.t.stopNestedScroll();
    }
}
