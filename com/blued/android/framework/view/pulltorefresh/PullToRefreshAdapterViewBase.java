package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.blued.android.framework.R;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshAdapterViewBase.class */
public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements AbsListView.OnScrollListener {
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private PauseOnScrollListener f10246c;
    private AbsListView.OnScrollListener d;
    private PullToRefreshBase.OnLastItemVisibleListener e;
    private View f;
    private IndicatorLayout g;
    private IndicatorLayout h;
    private boolean i;
    private boolean j;

    /* renamed from: com.blued.android.framework.view.pulltorefresh.PullToRefreshAdapterViewBase$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshAdapterViewBase$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10247a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            f10247a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10247a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public PullToRefreshAdapterViewBase(Context context) {
        super(context);
        this.j = true;
        this.f10246c = new PauseOnScrollListener(false, true);
        ((AbsListView) this.f10248a).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        this.f10246c = new PauseOnScrollListener(false, true);
        ((AbsListView) this.f10248a).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        this.j = true;
        this.f10246c = new PauseOnScrollListener(false, true);
        ((AbsListView) this.f10248a).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
        this.j = true;
        this.f10246c = new PauseOnScrollListener(false, true);
        ((AbsListView) this.f10248a).setOnScrollListener(this);
    }

    private static FrameLayout.LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                layoutParams2.gravity = ((LinearLayout.LayoutParams) layoutParams).gravity;
                return layoutParams2;
            }
            layoutParams2.gravity = 17;
            return layoutParams2;
        }
        return null;
    }

    private boolean getShowIndicatorInternal() {
        return this.i && g();
    }

    private void o() {
        IndicatorLayout indicatorLayout;
        IndicatorLayout indicatorLayout2;
        PullToRefreshBase.Mode mode = getMode();
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (mode.c() && this.g == null) {
            this.g = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.indicator_right_padding);
            layoutParams.gravity = 53;
            refreshableViewWrapper.addView(this.g, layoutParams);
        } else if (!mode.c() && (indicatorLayout = this.g) != null) {
            refreshableViewWrapper.removeView(indicatorLayout);
            this.g = null;
        }
        if (mode.d() && this.h == null) {
            this.h = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = getResources().getDimensionPixelSize(R.dimen.indicator_right_padding);
            layoutParams2.gravity = 85;
            refreshableViewWrapper.addView(this.h, layoutParams2);
        } else if (mode.d() || (indicatorLayout2 = this.h) == null) {
        } else {
            refreshableViewWrapper.removeView(indicatorLayout2);
            this.h = null;
        }
    }

    private boolean p() {
        View childAt;
        if (((AbsListView) this.f10248a).getAdapter() == null) {
            return true;
        }
        return ((AbsListView) this.f10248a).getFirstVisiblePosition() <= 1 && (childAt = ((AbsListView) this.f10248a).getChildAt(0)) != null && childAt.getTop() >= ((AbsListView) this.f10248a).getTop();
    }

    private boolean q() {
        ListAdapter adapter = ((AbsListView) this.f10248a).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int count = ((AbsListView) this.f10248a).getCount();
        int lastVisiblePosition = ((AbsListView) this.f10248a).getLastVisiblePosition();
        if (lastVisiblePosition >= (count - 1) - 1) {
            View childAt = ((AbsListView) this.f10248a).getChildAt(lastVisiblePosition - ((AbsListView) this.f10248a).getFirstVisiblePosition());
            return childAt != null && childAt.getBottom() <= ((AbsListView) this.f10248a).getBottom();
        }
        return false;
    }

    private void r() {
        if (this.g != null) {
            getRefreshableViewWrapper().removeView(this.g);
            this.g = null;
        }
        if (this.h != null) {
            getRefreshableViewWrapper().removeView(this.h);
            this.h = null;
        }
    }

    private void s() {
        if (this.g != null) {
            if (i() || !d()) {
                if (this.g.a()) {
                    this.g.b();
                }
            } else if (!this.g.a()) {
                this.g.c();
            }
        }
        if (this.h != null) {
            if (i() || !e()) {
                if (this.h.a()) {
                    this.h.b();
                }
            } else if (this.h.a()) {
            } else {
                this.h.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public void a() {
        super.a();
        if (getShowIndicatorInternal()) {
            int i = AnonymousClass1.f10247a[getCurrentMode().ordinal()];
            if (i == 1) {
                this.h.e();
            } else if (i != 2) {
            } else {
                this.g.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public void a(TypedArray typedArray) {
        this.i = typedArray.getBoolean(R.styleable.PullToRefresh_ptrShowIndicator, !h());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public void a(boolean z) {
        super.a(z);
        if (getShowIndicatorInternal()) {
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public void b() {
        super.b();
        if (getShowIndicatorInternal()) {
            int i = AnonymousClass1.f10247a[getCurrentMode().ordinal()];
            if (i == 1) {
                this.h.d();
            } else if (i != 2) {
            } else {
                this.g.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public void c() {
        super.c();
        if (getShowIndicatorInternal()) {
            s();
        }
    }

    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    protected boolean d() {
        return p();
    }

    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    protected boolean e() {
        return q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public void f() {
        super.f();
        if (getShowIndicatorInternal()) {
            o();
        } else {
            r();
        }
    }

    public boolean getShowIndicator() {
        return this.i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f10246c.onScroll(absListView, i, i2, i3);
        if (this.e != null) {
            this.b = i3 > 0 && i + i2 >= i3 - 1;
        }
        if (getShowIndicatorInternal()) {
            s();
        }
        AbsListView.OnScrollListener onScrollListener = this.d;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        View view = this.f;
        if (view == null || this.j) {
            return;
        }
        view.scrollTo(-i, -i2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener;
        this.f10246c.onScrollStateChanged(absListView, i);
        if (i == 0 && (onLastItemVisibleListener = this.e) != null && this.b) {
            onLastItemVisibleListener.a();
        }
        AbsListView.OnScrollListener onScrollListener = this.d;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        ((AdapterView) this.f10248a).setAdapter(listAdapter);
    }

    public final void setEmptyView(View view) {
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (view != null) {
            view.setClickable(true);
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            FrameLayout.LayoutParams a2 = a(view.getLayoutParams());
            if (a2 != null) {
                refreshableViewWrapper.addView(view, a2);
            } else {
                refreshableViewWrapper.addView(view);
            }
        }
        if (this.f10248a instanceof EmptyViewMethodAccessor) {
            ((EmptyViewMethodAccessor) this.f10248a).setEmptyViewInternal(view);
        } else {
            ((AbsListView) this.f10248a).setEmptyView(view);
        }
        this.f = view;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        ((AbsListView) this.f10248a).setOnItemClickListener(onItemClickListener);
    }

    public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener) {
        this.e = onLastItemVisibleListener;
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.d = onScrollListener;
    }

    public final void setScrollEmptyView(boolean z) {
        this.j = z;
    }

    public void setShowIndicator(boolean z) {
        this.i = z;
        if (getShowIndicatorInternal()) {
            o();
        } else {
            r();
        }
    }
}
