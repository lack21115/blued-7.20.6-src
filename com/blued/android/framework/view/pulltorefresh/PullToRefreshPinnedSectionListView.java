package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.framework.R;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshPinnedSectionListView.class */
public class PullToRefreshPinnedSectionListView extends PullToRefreshAdapterViewBase<ListView> {
    private LoadingLayout b;
    private LoadingLayout c;
    private FrameLayout d;
    private boolean e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshPinnedSectionListView$InternalListView.class */
    public class InternalListView extends ListView implements EmptyViewMethodAccessor {
        final /* synthetic */ PullToRefreshPinnedSectionListView a;
        private boolean b;

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
            if (this.a.d != null && !this.b) {
                addFooterView(this.a.d, null, false);
                this.b = true;
            }
            super.setAdapter(listAdapter);
        }

        @Override // android.widget.AdapterView
        public void setEmptyView(View view) {
            this.a.setEmptyView(view);
        }

        @Override // com.blued.android.framework.view.pulltorefresh.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshPinnedSectionListView$InternalListViewSDK9.class */
    final class InternalListViewSDK9 extends InternalListView {
        final /* synthetic */ PullToRefreshPinnedSectionListView b;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            OverscrollHelper.a(this.b, i, i3, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshPinnedSectionListView(Context context) {
        super(context);
    }

    public PullToRefreshPinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshPinnedSectionListView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshPinnedSectionListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
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

    protected ListView b(Context context, AttributeSet attributeSet) {
        return new PinnedSectionListView(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    /* renamed from: c */
    public ListView a(Context context, AttributeSet attributeSet) {
        ListView b = b(context, attributeSet);
        b.setId(com.android.internal.R.id.list);
        return b;
    }

    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        return PullToRefreshBase.Orientation.VERTICAL;
    }
}
