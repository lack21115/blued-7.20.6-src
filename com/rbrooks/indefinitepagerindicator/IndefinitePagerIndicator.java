package com.rbrooks.indefinitepagerindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator.class */
public final class IndefinitePagerIndicator extends View implements ViewPager.OnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private static final Companion f27932a = new Companion(null);
    private RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f27933c;
    private ViewPager2 d;
    private InternalRecyclerScrollListener e;
    private InternalPageChangeCallback f;
    private final DecelerateInterpolator g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private Paint q;
    private Paint r;
    private int s;
    private int t;
    private float u;

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator$Companion.class */
    static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator$InternalPageChangeCallback.class */
    public final class InternalPageChangeCallback extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IndefinitePagerIndicator f27934a;

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            this.f27934a.onPageScrolled(i, f, i2);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            this.f27934a.onPageSelected(i);
        }
    }

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator$InternalRecyclerScrollListener.class */
    public final class InternalRecyclerScrollListener extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IndefinitePagerIndicator f27935a;
        private View b;

        private final float a(View view) {
            int left = view.getLeft();
            int right = view.getRight();
            int width = view.getWidth();
            if (left >= 0) {
                if (right <= this.f27935a.getWidth()) {
                    return 1.0f;
                }
                right = this.f27935a.getWidth() - left;
            }
            return right / width;
        }

        private final View a() {
            RecyclerView.LayoutManager layoutManager;
            RecyclerView.LayoutManager layoutManager2;
            RecyclerView recyclerView = this.f27935a.b;
            Integer valueOf = (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) ? null : Integer.valueOf(layoutManager.getChildCount());
            Intrinsics.a(valueOf);
            int intValue = valueOf.intValue() - 1;
            if (intValue < 0) {
                return null;
            }
            float f = 0.0f;
            View view = null;
            while (true) {
                View view2 = view;
                int i = intValue - 1;
                RecyclerView recyclerView2 = this.f27935a.b;
                View childAt = (recyclerView2 == null || (layoutManager2 = recyclerView2.getLayoutManager()) == null) ? null : layoutManager2.getChildAt(intValue);
                float f2 = f;
                View view3 = view2;
                if (childAt != null) {
                    float a2 = a(childAt);
                    f2 = f;
                    view3 = view2;
                    if (a2 >= f) {
                        f2 = a2;
                        view3 = childAt;
                    }
                }
                if (i < 0) {
                    return view3;
                }
                intValue = i;
                f = f2;
                view = view3;
            }
        }

        private final void b(View view) {
            RecyclerView.ViewHolder findContainingViewHolder;
            RecyclerView recyclerView = this.f27935a.b;
            if (recyclerView == null || (findContainingViewHolder = recyclerView.findContainingViewHolder(view)) == null) {
                return;
            }
            int layoutPosition = findContainingViewHolder.getLayoutPosition();
            IndefinitePagerIndicator indefinitePagerIndicator = this.f27935a;
            int i = layoutPosition;
            if (indefinitePagerIndicator.b()) {
                i = layoutPosition;
                if (!indefinitePagerIndicator.n) {
                    i = indefinitePagerIndicator.b(layoutPosition);
                }
            }
            indefinitePagerIndicator.t = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.e(recyclerView, "recyclerView");
            View a2 = a();
            if (a2 != null) {
                b(a2);
                this.f27935a.u = a2.getLeft() / a2.getMeasuredWidth();
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            IndefinitePagerIndicator indefinitePagerIndicator = this.f27935a;
            if (this.b != linearLayoutManager.findViewByPosition(i >= 0 ? linearLayoutManager.findLastVisibleItemPosition() : linearLayoutManager.findFirstVisibleItemPosition())) {
                indefinitePagerIndicator.s = indefinitePagerIndicator.t;
            }
            this.b = a2;
            this.f27935a.invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndefinitePagerIndicator(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndefinitePagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndefinitePagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.g = new DecelerateInterpolator();
        this.h = 5;
        this.i = 1;
        this.j = d(4.0f);
        this.k = d(2.0f);
        this.l = d(10.0f);
        this.o = ContextCompat.getColor(context, 2131102208);
        this.p = ContextCompat.getColor(context, 2131102163);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.IndefinitePagerIndicator, 0, 0);
            Intrinsics.c(obtainStyledAttributes, "context.theme.obtainStyl…          0\n            )");
            this.h = obtainStyledAttributes.getInteger(1, 5);
            this.i = obtainStyledAttributes.getInt(4, 1);
            this.k = obtainStyledAttributes.getDimensionPixelSize(2, this.k);
            this.j = obtainStyledAttributes.getDimensionPixelSize(6, this.j);
            this.o = obtainStyledAttributes.getColor(0, this.o);
            this.p = obtainStyledAttributes.getColor(5, this.p);
            this.l = obtainStyledAttributes.getDimensionPixelSize(3, this.l);
            this.m = obtainStyledAttributes.getBoolean(7, false);
            this.n = obtainStyledAttributes.getBoolean(8, false);
            obtainStyledAttributes.recycle();
        }
        this.q = a(this, null, false, this.p, 3, null);
        this.r = a(this, null, false, this.o, 3, null);
    }

    public /* synthetic */ IndefinitePagerIndicator(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final float a(int i) {
        return ((i - this.t) * getDistanceBetweenTheCenterOfTwoDots()) + (getDistanceBetweenTheCenterOfTwoDots() * this.u);
    }

    private final Paint a(Paint.Style style, boolean z, int i) {
        Paint paint = new Paint();
        paint.setStyle(style);
        paint.setAntiAlias(z);
        paint.setColor(i);
        return paint;
    }

    static /* synthetic */ Paint a(IndefinitePagerIndicator indefinitePagerIndicator, Paint.Style style, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            style = Paint.Style.FILL;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return indefinitePagerIndicator.a(style, z, i);
    }

    private final Pair<Float, Float> a(float f) {
        float width;
        float dotYCoordinate;
        if (this.n) {
            float height = (getHeight() / 2) + f;
            width = getDotYCoordinate();
            dotYCoordinate = height;
        } else {
            width = (getWidth() / 2) + f;
            dotYCoordinate = getDotYCoordinate();
        }
        return new Pair<>(Float.valueOf(width), Float.valueOf(dotYCoordinate));
    }

    private final void a() {
        ViewPager2 viewPager2;
        RecyclerView recyclerView;
        InternalRecyclerScrollListener internalRecyclerScrollListener = this.e;
        if (internalRecyclerScrollListener != null && (recyclerView = this.b) != null) {
            recyclerView.removeOnScrollListener(internalRecyclerScrollListener);
        }
        ViewPager viewPager = this.f27933c;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this);
        }
        InternalPageChangeCallback internalPageChangeCallback = this.f;
        if (internalPageChangeCallback != null && (viewPager2 = this.d) != null) {
            viewPager2.unregisterOnPageChangeCallback(internalPageChangeCallback);
        }
        this.b = null;
        this.f27933c = null;
        this.d = null;
    }

    private final float b(float f) {
        int i;
        float abs = Math.abs(f);
        float distanceBetweenTheCenterOfTwoDots = (this.h / 2) * getDistanceBetweenTheCenterOfTwoDots();
        if (abs < getDistanceBetweenTheCenterOfTwoDots() / 2) {
            i = this.j;
        } else if (abs > distanceBetweenTheCenterOfTwoDots) {
            return this.g.getInterpolation(1 - ((abs - distanceBetweenTheCenterOfTwoDots) / ((getCalculatedWidth() / 2.01f) - distanceBetweenTheCenterOfTwoDots))) * this.k;
        } else {
            i = this.k;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b(int i) {
        return (getItemCount() - i) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    private final Paint c(float f) {
        return Math.abs(f) < ((float) (getDistanceBetweenTheCenterOfTwoDots() / 2)) ? this.q : this.r;
    }

    private final int d(float f) {
        return (int) (f * (getResources().getDisplayMetrics().densityDpi / 160));
    }

    private final int getCalculatedWidth() {
        return (((this.h + (this.i * 2)) - 1) * getDistanceBetweenTheCenterOfTwoDots()) + (this.k * 2);
    }

    private final int getDistanceBetweenTheCenterOfTwoDots() {
        return (this.k * 2) + this.l;
    }

    private final int getDotYCoordinate() {
        return this.j;
    }

    private final int getItemCount() {
        RecyclerView.Adapter adapter;
        PagerAdapter adapter2;
        RecyclerView.Adapter adapter3;
        RecyclerView recyclerView = this.b;
        int i = 0;
        if (recyclerView != null) {
            if (recyclerView == null || (adapter3 = recyclerView.getAdapter()) == null) {
                return 0;
            }
            return adapter3.getItemCount();
        }
        ViewPager viewPager = this.f27933c;
        if (viewPager != null) {
            if (viewPager == null || (adapter2 = viewPager.getAdapter()) == null) {
                return 0;
            }
            return adapter2.getCount();
        }
        ViewPager2 viewPager2 = this.d;
        if (viewPager2 != null) {
            if (viewPager2 == null || (adapter = viewPager2.getAdapter()) == null) {
                return 0;
            }
            i = adapter.getItemCount();
        }
        return i;
    }

    public final void a(ViewPager viewPager) {
        a();
        this.f27933c = viewPager;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(this);
        }
        this.s = viewPager == null ? 0 : viewPager.getCurrentItem();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.e(canvas, "canvas");
        super.onDraw(canvas);
        IntRange b = RangesKt.b(0, getItemCount());
        ArrayList<Number> arrayList = new ArrayList(CollectionsKt.a(b, 10));
        Iterator<Integer> it = b.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(a(((IntIterator) it).nextInt())));
        }
        for (Number number : arrayList) {
            float floatValue = number.floatValue();
            Pair<Float, Float> a2 = a(floatValue);
            canvas.drawCircle(a2.c().floatValue(), a2.d().floatValue(), b(floatValue), c(floatValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.j * 2;
        if (this.n) {
            setMeasuredDimension(i3, getCalculatedWidth());
        } else {
            setMeasuredDimension(getCalculatedWidth(), i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.m && b()) {
            int b = b(i);
            this.s = b;
            this.t = b;
            this.u = f * 1;
        } else {
            this.s = i;
            this.t = i;
            this.u = f * (-1);
        }
        invalidate();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.t = this.s;
        int i2 = i;
        if (this.m) {
            i2 = i;
            if (b()) {
                i2 = b(i);
            }
        }
        this.s = i2;
        invalidate();
    }

    public final void setDotColor(int i) {
        this.o = i;
        this.r.setColor(i);
        invalidate();
    }

    public final void setDotCount(int i) {
        this.h = i;
        invalidate();
    }

    public final void setDotRadius(int i) {
        this.k = d(i);
        invalidate();
    }

    public final void setDotSeparationDistance(int i) {
        this.l = d(i);
        invalidate();
    }

    public final void setFadingDotCount(int i) {
        this.i = i;
        invalidate();
    }

    public final void setRTLSupport(boolean z) {
        this.m = z;
        invalidate();
    }

    public final void setSelectedDotColor(int i) {
        this.p = i;
        this.q.setColor(i);
        invalidate();
    }

    public final void setSelectedDotRadius(int i) {
        this.j = d(i);
        invalidate();
    }

    public final void setVerticalSupport(boolean z) {
        this.n = z;
        invalidate();
    }
}
