package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.framework.R;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshListView.class */
public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView> {
    private LoadingLayout b;
    private LoadingLayout c;
    private FrameLayout d;
    private boolean e;

    /* renamed from: com.blued.android.framework.view.pulltorefresh.PullToRefreshListView$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshListView$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshListView$InternalListView.class */
    public class InternalListView extends ListView implements EmptyViewMethodAccessor {
        private boolean b;

        public InternalListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView
        public void setAdapter(ListAdapter listAdapter) {
            if (PullToRefreshListView.this.d != null && !this.b) {
                addFooterView(PullToRefreshListView.this.d, null, false);
                this.b = true;
            }
            super.setAdapter(listAdapter);
        }

        @Override // android.widget.AdapterView
        public void setEmptyView(View view) {
            PullToRefreshListView.this.setEmptyView(view);
        }

        @Override // com.blued.android.framework.view.pulltorefresh.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshListView$InternalListViewSDK9.class */
    public final class InternalListViewSDK9 extends InternalListView {
        public InternalListViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            OverscrollHelper.a(PullToRefreshListView.this, i, i3, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshListView(Context context) {
        super(context);
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshAdapterViewBase, com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public void a(TypedArray typedArray) {
        super.a(typedArray);
        boolean z = typedArray.getBoolean(R.styleable.PullToRefresh_ptrListViewExtrasEnabled, true);
        this.e = z;
        if (z) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
            FrameLayout frameLayout = new FrameLayout(getContext());
            LoadingLayout a = a(getContext(), PullToRefreshBase.Mode.PULL_FROM_START, typedArray);
            this.b = a;
            a.setVisibility(8);
            frameLayout.addView(this.b, layoutParams);
            ((ListView) this.a).addHeaderView(frameLayout, null, false);
            this.d = new FrameLayout(getContext());
            LoadingLayout a2 = a(getContext(), PullToRefreshBase.Mode.PULL_FROM_END, typedArray);
            this.c = a2;
            a2.setVisibility(8);
            this.d.addView(this.c, layoutParams);
            if (typedArray.hasValue(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled)) {
                return;
            }
            setScrollingWhileRefreshingEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshAdapterViewBase, com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public void a(boolean z) {
        LoadingLayout loadingLayout;
        int count;
        int scrollY;
        LoadingLayout loadingLayout2;
        LoadingLayout loadingLayout3;
        ListAdapter adapter = ((ListView) this.a).getAdapter();
        if (!this.e || !getShowViewWhileRefreshing() || adapter == null || adapter.isEmpty() || z) {
            ((ListView) this.a).setSelection(0);
            super.a(z);
            return;
        }
        super.a(false);
        int i = AnonymousClass1.a[getCurrentMode().ordinal()];
        if (i == 1 || i == 2) {
            LoadingLayout footerLayout = getFooterLayout();
            LoadingLayout loadingLayout4 = this.c;
            loadingLayout = this.b;
            count = ((ListView) this.a).getCount() - 1;
            scrollY = getScrollY() - getFooterSize();
            loadingLayout2 = loadingLayout4;
            loadingLayout3 = footerLayout;
        } else {
            loadingLayout3 = getHeaderLayout();
            loadingLayout2 = this.b;
            loadingLayout = this.c;
            scrollY = getScrollY() + getHeaderSize();
            count = 0;
        }
        loadingLayout3.reset();
        loadingLayout3.hideAllViews();
        loadingLayout.setVisibility(8);
        loadingLayout2.setVisibility(0);
        loadingLayout2.refreshing();
        if (z) {
            l();
            setHeaderScroll(scrollY);
            ((ListView) this.a).setSelection(count);
            a(0);
        }
    }

    protected ListView b(Context context, AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 9 ? new InternalListViewSDK9(context, attributeSet) : new InternalListView(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public LoadingLayoutProxy b(boolean z, boolean z2) {
        LoadingLayoutProxy b = super.b(z, z2);
        if (this.e) {
            PullToRefreshBase.Mode mode = getMode();
            if (z && mode.c()) {
                b.a(this.b);
            }
            if (z2 && mode.d()) {
                b.a(this.c);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    /* renamed from: c */
    public ListView a(Context context, AttributeSet attributeSet) {
        ListView b = b(context, attributeSet);
        b.setDrawSelectorOnTop(false);
        b.setFadingEdgeLength(0);
        b.setDivider(null);
        b.setDividerHeight(0);
        b.setFooterDividersEnabled(false);
        b.setHeaderDividersEnabled(false);
        b.setSelector(new ColorDrawable(0));
        b.setCacheColorHint(0);
        b.setId(com.android.internal.R.id.list);
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshAdapterViewBase, com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public void c() {
        LoadingLayout footerLayout;
        LoadingLayout loadingLayout;
        int footerSize;
        if (!this.e) {
            super.c();
            return;
        }
        int i = AnonymousClass1.a[getCurrentMode().ordinal()];
        int i2 = 0;
        boolean z = false;
        if (i == 1 || i == 2) {
            footerLayout = getFooterLayout();
            loadingLayout = this.c;
            i2 = ((ListView) this.a).getCount() - 1;
            footerSize = getFooterSize();
            if (Math.abs(((ListView) this.a).getLastVisiblePosition() - i2) <= 1) {
                z = true;
            }
        } else {
            footerLayout = getHeaderLayout();
            loadingLayout = this.b;
            int i3 = -getHeaderSize();
            if (Math.abs(((ListView) this.a).getFirstVisiblePosition() - 0) <= 1) {
                z = true;
                footerSize = i3;
            } else {
                z = false;
                footerSize = i3;
            }
        }
        if (loadingLayout.getVisibility() == 0) {
            footerLayout.showInvisibleViews();
            loadingLayout.setVisibility(8);
            if (z && getState() != PullToRefreshBase.State.MANUAL_REFRESHING) {
                ((ListView) this.a).setSelection(i2);
                setHeaderScroll(footerSize);
            }
        }
        super.c();
    }

    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        return PullToRefreshBase.Orientation.VERTICAL;
    }
}
