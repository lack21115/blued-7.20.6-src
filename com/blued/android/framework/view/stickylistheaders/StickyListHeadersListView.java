package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.blued.android.framework.R;
import com.blued.android.framework.view.stickylistheaders.AdapterWrapper;
import com.blued.android.framework.view.stickylistheaders.WrapperViewList;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/StickyListHeadersListView.class */
public class StickyListHeadersListView extends FrameLayout {
    private WrapperViewList a;
    private View b;
    private Long c;
    private Integer d;
    private Integer e;
    private AbsListView.OnScrollListener f;
    private AdapterWrapper g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private OnHeaderClickListener p;
    private OnStickyHeaderOffsetChangedListener q;
    private OnStickyHeaderChangedListener r;
    private AdapterWrapperDataSetObserver s;
    private Drawable t;
    private int u;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/StickyListHeadersListView$AdapterWrapperDataSetObserver.class */
    class AdapterWrapperDataSetObserver extends DataSetObserver {
        private AdapterWrapperDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            StickyListHeadersListView.this.b();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            StickyListHeadersListView.this.b();
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/StickyListHeadersListView$AdapterWrapperHeaderClickHandler.class */
    class AdapterWrapperHeaderClickHandler implements AdapterWrapper.OnHeaderClickListener {
        private AdapterWrapperHeaderClickHandler() {
        }

        @Override // com.blued.android.framework.view.stickylistheaders.AdapterWrapper.OnHeaderClickListener
        public void a(View view, int i, long j) {
            StickyListHeadersListView.this.p.a(StickyListHeadersListView.this, view, i, j, false);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener.class */
    public interface OnHeaderClickListener {
        void a(StickyListHeadersListView stickyListHeadersListView, View view, int i, long j, boolean z);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/StickyListHeadersListView$OnStickyHeaderChangedListener.class */
    public interface OnStickyHeaderChangedListener {
        void a(StickyListHeadersListView stickyListHeadersListView, View view, int i, long j);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/StickyListHeadersListView$OnStickyHeaderOffsetChangedListener.class */
    public interface OnStickyHeaderOffsetChangedListener {
        void a(StickyListHeadersListView stickyListHeadersListView, View view, int i);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/StickyListHeadersListView$WrapperListScrollListener.class */
    class WrapperListScrollListener implements AbsListView.OnScrollListener {
        private WrapperListScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (StickyListHeadersListView.this.f != null) {
                StickyListHeadersListView.this.f.onScroll(absListView, i, i2, i3);
            }
            StickyListHeadersListView stickyListHeadersListView = StickyListHeadersListView.this;
            stickyListHeadersListView.b(stickyListHeadersListView.a.a());
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (StickyListHeadersListView.this.f != null) {
                StickyListHeadersListView.this.f.onScrollStateChanged(absListView, i);
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/StickyListHeadersListView$WrapperViewListLifeCycleListener.class */
    class WrapperViewListLifeCycleListener implements WrapperViewList.LifeCycleListener {
        private WrapperViewListLifeCycleListener() {
        }

        @Override // com.blued.android.framework.view.stickylistheaders.WrapperViewList.LifeCycleListener
        public void a(Canvas canvas) {
            if (Build.VERSION.SDK_INT < 8) {
                StickyListHeadersListView stickyListHeadersListView = StickyListHeadersListView.this;
                stickyListHeadersListView.b(stickyListHeadersListView.a.a());
            }
            if (StickyListHeadersListView.this.b != null) {
                if (!StickyListHeadersListView.this.i) {
                    StickyListHeadersListView stickyListHeadersListView2 = StickyListHeadersListView.this;
                    stickyListHeadersListView2.drawChild(canvas, stickyListHeadersListView2.b, 0L);
                    return;
                }
                canvas.save();
                canvas.clipRect(0, StickyListHeadersListView.this.m, StickyListHeadersListView.this.getRight(), StickyListHeadersListView.this.getBottom());
                StickyListHeadersListView stickyListHeadersListView3 = StickyListHeadersListView.this;
                stickyListHeadersListView3.drawChild(canvas, stickyListHeadersListView3.b, 0L);
                canvas.restore();
            }
        }
    }

    public StickyListHeadersListView(Context context) {
        this(context, null);
    }

    public StickyListHeadersListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickyListHeadersListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        WrapperViewList wrapperViewList = new WrapperViewList(context);
        this.a = wrapperViewList;
        this.t = wrapperViewList.getDivider();
        this.u = this.a.getDividerHeight();
        this.a.setDivider(null);
        this.a.setDividerHeight(0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.StickyListHeadersListView, 0, 0);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_padding, 0);
                this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingLeft, dimensionPixelSize);
                this.m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingTop, dimensionPixelSize);
                this.n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingRight, dimensionPixelSize);
                int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingBottom, dimensionPixelSize);
                this.o = dimensionPixelSize2;
                setPadding(this.l, this.m, this.n, dimensionPixelSize2);
                this.i = obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_android_clipToPadding, true);
                super.setClipToPadding(true);
                this.a.setClipToPadding(this.i);
                int i2 = obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_scrollbars, 512);
                this.a.setVerticalScrollBarEnabled((i2 & 512) != 0);
                this.a.setHorizontalScrollBarEnabled((i2 & 256) != 0);
                if (Build.VERSION.SDK_INT >= 9) {
                    this.a.setOverScrollMode(obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_overScrollMode, 0));
                }
                this.a.setFadingEdgeLength(obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_fadingEdgeLength, this.a.getVerticalFadingEdgeLength()));
                int i3 = obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_requiresFadingEdge, 0);
                if (i3 == 4096) {
                    this.a.setVerticalFadingEdgeEnabled(false);
                    this.a.setHorizontalFadingEdgeEnabled(true);
                } else if (i3 == 8192) {
                    this.a.setVerticalFadingEdgeEnabled(true);
                    this.a.setHorizontalFadingEdgeEnabled(false);
                } else {
                    this.a.setVerticalFadingEdgeEnabled(false);
                    this.a.setHorizontalFadingEdgeEnabled(false);
                }
                this.a.setCacheColorHint(obtainStyledAttributes.getColor(R.styleable.StickyListHeadersListView_android_cacheColorHint, this.a.getCacheColorHint()));
                if (Build.VERSION.SDK_INT >= 11) {
                    this.a.setChoiceMode(obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_choiceMode, this.a.getChoiceMode()));
                }
                this.a.setDrawSelectorOnTop(obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_android_drawSelectorOnTop, false));
                this.a.setFastScrollEnabled(obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_android_fastScrollEnabled, this.a.isFastScrollEnabled()));
                if (Build.VERSION.SDK_INT >= 11) {
                    this.a.setFastScrollAlwaysVisible(obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_android_fastScrollAlwaysVisible, this.a.isFastScrollAlwaysVisible()));
                }
                this.a.setScrollBarStyle(obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_scrollbarStyle, 0));
                if (obtainStyledAttributes.hasValue(R.styleable.StickyListHeadersListView_android_listSelector)) {
                    this.a.setSelector(obtainStyledAttributes.getDrawable(R.styleable.StickyListHeadersListView_android_listSelector));
                }
                this.a.setScrollingCacheEnabled(obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_android_scrollingCache, this.a.isScrollingCacheEnabled()));
                if (obtainStyledAttributes.hasValue(R.styleable.StickyListHeadersListView_android_divider)) {
                    this.t = obtainStyledAttributes.getDrawable(R.styleable.StickyListHeadersListView_android_divider);
                }
                this.u = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_dividerHeight, this.u);
                this.a.setTranscriptMode(obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_transcriptMode, 0));
                this.h = obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_hasStickyHeaders, true);
                this.j = obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_isDrawingListUnderStickyHeader, true);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.a.a(new WrapperViewListLifeCycleListener());
        this.a.setOnScrollListener(new WrapperListScrollListener());
        addView(this.a);
    }

    private void a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        } else if (layoutParams.height == -1 || layoutParams.width == -2) {
            layoutParams.height = -2;
            layoutParams.width = -1;
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        View view = this.b;
        if (view != null) {
            removeView(view);
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.a.a(0);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
        if (r5 < 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(int r5) {
        /*
            r4 = this;
            r0 = r4
            com.blued.android.framework.view.stickylistheaders.AdapterWrapper r0 = r0.g
            r10 = r0
            r0 = 0
            r9 = r0
            r0 = r10
            if (r0 != 0) goto L13
            r0 = 0
            r6 = r0
            goto L19
        L13:
            r0 = r10
            int r0 = r0.getCount()
            r6 = r0
        L19:
            r0 = r6
            if (r0 == 0) goto Lb7
            r0 = r4
            boolean r0 = r0.h
            if (r0 != 0) goto L25
            return
        L25:
            r0 = r5
            r1 = r4
            com.blued.android.framework.view.stickylistheaders.WrapperViewList r1 = r1.a
            int r1 = r1.getHeaderViewsCount()
            int r0 = r0 - r1
            r7 = r0
            r0 = r7
            r5 = r0
            r0 = r4
            com.blued.android.framework.view.stickylistheaders.WrapperViewList r0 = r0.a
            int r0 = r0.getChildCount()
            if (r0 <= 0) goto L53
            r0 = r7
            r5 = r0
            r0 = r4
            com.blued.android.framework.view.stickylistheaders.WrapperViewList r0 = r0.a
            r1 = 0
            android.view.View r0 = r0.getChildAt(r1)
            int r0 = r0.getBottom()
            r1 = r4
            int r1 = r1.d()
            if (r0 >= r1) goto L53
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
        L53:
            r0 = r4
            com.blued.android.framework.view.stickylistheaders.WrapperViewList r0 = r0.a
            int r0 = r0.getChildCount()
            if (r0 == 0) goto L62
            r0 = 1
            r7 = r0
            goto L64
        L62:
            r0 = 0
            r7 = r0
        L64:
            r0 = r7
            if (r0 == 0) goto L8a
            r0 = r4
            com.blued.android.framework.view.stickylistheaders.WrapperViewList r0 = r0.a
            int r0 = r0.getFirstVisiblePosition()
            if (r0 != 0) goto L8a
            r0 = r4
            com.blued.android.framework.view.stickylistheaders.WrapperViewList r0 = r0.a
            r1 = 0
            android.view.View r0 = r0.getChildAt(r1)
            int r0 = r0.getTop()
            r1 = r4
            int r1 = r1.d()
            if (r0 < r1) goto L8a
            r0 = 1
            r8 = r0
            goto L8d
        L8a:
            r0 = 0
            r8 = r0
        L8d:
            r0 = r5
            r1 = r6
            r2 = 1
            int r1 = r1 - r2
            if (r0 > r1) goto L9b
            r0 = r9
            r6 = r0
            r0 = r5
            if (r0 >= 0) goto L9d
        L9b:
            r0 = 1
            r6 = r0
        L9d:
            r0 = r7
            if (r0 == 0) goto Lb3
            r0 = r6
            if (r0 != 0) goto Lb3
            r0 = r8
            if (r0 == 0) goto Lad
            goto Lb3
        Lad:
            r0 = r4
            r1 = r5
            r0.c(r1)
            return
        Lb3:
            r0 = r4
            r0.b()
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.view.stickylistheaders.StickyListHeadersListView.b(int):void");
    }

    private void b(View view) {
        if (view != null) {
            measureChild(view, View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.l) - this.n, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    private void c() {
        int d;
        View view = this.b;
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight();
            Integer num = this.e;
            d = measuredHeight + (num != null ? num.intValue() : 0) + this.k;
        } else {
            d = d();
        }
        int childCount = this.a.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = this.a.getChildAt(i2);
            if (childAt instanceof WrapperView) {
                WrapperView wrapperView = (WrapperView) childAt;
                if (wrapperView.a()) {
                    View view2 = wrapperView.d;
                    if (wrapperView.getTop() < d) {
                        if (view2.getVisibility() != 4) {
                            view2.setVisibility(4);
                        }
                    } else if (view2.getVisibility() != 0) {
                        view2.setVisibility(0);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private void c(int i) {
        int i2;
        int i3;
        View childAt;
        Integer num = this.d;
        if (num == null || num.intValue() != i) {
            this.d = Integer.valueOf(i);
            long a = this.g.a(i);
            Long l = this.c;
            if (l == null || l.longValue() != a) {
                this.c = Long.valueOf(a);
                View b = this.g.b(this.d.intValue(), this.b, this);
                if (this.b != b) {
                    if (b == null) {
                        throw new NullPointerException("header may not be null");
                    }
                    c(b);
                }
                a(this.b);
                b(this.b);
                OnStickyHeaderChangedListener onStickyHeaderChangedListener = this.r;
                if (onStickyHeaderChangedListener != null) {
                    onStickyHeaderChangedListener.a(this, this.b, i, this.c.longValue());
                }
                this.e = null;
            }
        }
        int measuredHeight = this.b.getMeasuredHeight();
        int d = d();
        while (true) {
            int i4 = i2;
            i3 = 0;
            if (i4 >= this.a.getChildCount()) {
                break;
            }
            childAt = this.a.getChildAt(i4);
            i2 = (childAt.getTop() < d() || !(((childAt instanceof WrapperView) && ((WrapperView) childAt).a()) || this.a.a(childAt))) ? i4 + 1 : 0;
        }
        i3 = Math.min(childAt.getTop() - (measuredHeight + d), 0);
        setHeaderOffet(i3);
        if (!this.j) {
            this.a.a(this.b.getMeasuredHeight() + this.e.intValue());
        }
        c();
    }

    private void c(View view) {
        View view2 = this.b;
        if (view2 != null) {
            removeView(view2);
        }
        this.b = view;
        addView(view);
        if (this.p != null) {
            this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.framework.view.stickylistheaders.StickyListHeadersListView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    OnHeaderClickListener onHeaderClickListener = StickyListHeadersListView.this.p;
                    StickyListHeadersListView stickyListHeadersListView = StickyListHeadersListView.this;
                    onHeaderClickListener.a(stickyListHeadersListView, stickyListHeadersListView.b, StickyListHeadersListView.this.d.intValue(), StickyListHeadersListView.this.c.longValue(), true);
                }
            });
        }
        this.b.setClickable(true);
    }

    private int d() {
        return this.k + (this.i ? this.m : 0);
    }

    private boolean d(int i) {
        boolean z = true;
        if (i != 0) {
            if (this.g.a(i) != this.g.a(i - 1)) {
                return true;
            }
            z = false;
        }
        return z;
    }

    private boolean e(int i) {
        if (Build.VERSION.SDK_INT < i) {
            Log.e("StickyListHeaders", "Api lvl must be at least " + i + " to call this method");
            return false;
        }
        return true;
    }

    private void setHeaderOffet(int i) {
        Integer num = this.e;
        if (num == null || num.intValue() != i) {
            this.e = Integer.valueOf(i);
            if (Build.VERSION.SDK_INT >= 11) {
                this.b.setTranslationY(this.e.intValue());
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
                marginLayoutParams.topMargin = this.e.intValue();
                this.b.setLayoutParams(marginLayoutParams);
            }
            OnStickyHeaderOffsetChangedListener onStickyHeaderOffsetChangedListener = this.q;
            if (onStickyHeaderOffsetChangedListener != null) {
                onStickyHeaderOffsetChangedListener.a(this, this.b, -this.e.intValue());
            }
        }
    }

    public int a(int i) {
        if (d(Math.max(0, i - getHeaderViewsCount()))) {
            return 0;
        }
        View b = this.g.b(i, null, this.a);
        if (b != null) {
            a(b);
            b(b);
            return b.getMeasuredHeight();
        }
        throw new NullPointerException("header may not be null");
    }

    public void a(int i, int i2) {
        int i3 = 0;
        int a = this.g == null ? 0 : a(i);
        if (!this.i) {
            i3 = this.m;
        }
        this.a.setSelectionFromTop(i, (i2 + a) - i3);
    }

    public boolean a() {
        return this.h;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.a.canScrollVertically(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.a.getVisibility() == 0 || this.a.getAnimation() != null) {
            drawChild(canvas, this.a, 0L);
        }
    }

    public StickyListHeadersAdapter getAdapter() {
        AdapterWrapper adapterWrapper = this.g;
        if (adapterWrapper == null) {
            return null;
        }
        return adapterWrapper.a;
    }

    @Deprecated
    public boolean getAreHeadersSticky() {
        return a();
    }

    public int getCheckedItemCount() {
        if (e(11)) {
            return this.a.getCheckedItemCount();
        }
        return 0;
    }

    public long[] getCheckedItemIds() {
        if (e(8)) {
            return this.a.getCheckedItemIds();
        }
        return null;
    }

    public int getCheckedItemPosition() {
        return this.a.getCheckedItemPosition();
    }

    public SparseBooleanArray getCheckedItemPositions() {
        return this.a.getCheckedItemPositions();
    }

    public int getCount() {
        return this.a.getCount();
    }

    public Drawable getDivider() {
        return this.t;
    }

    public int getDividerHeight() {
        return this.u;
    }

    public View getEmptyView() {
        return this.a.getEmptyView();
    }

    public int getFirstVisiblePosition() {
        return this.a.getFirstVisiblePosition();
    }

    public int getFooterViewsCount() {
        return this.a.getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return this.a.getHeaderViewsCount();
    }

    public int getLastVisiblePosition() {
        return this.a.getLastVisiblePosition();
    }

    public int getListChildCount() {
        return this.a.getChildCount();
    }

    @Override // android.view.View
    public int getOverScrollMode() {
        if (e(9)) {
            return this.a.getOverScrollMode();
        }
        return 0;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return this.o;
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return this.l;
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return this.n;
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return this.m;
    }

    @Override // android.view.View
    public int getScrollBarStyle() {
        return this.a.getScrollBarStyle();
    }

    public int getStickyHeaderTopOffset() {
        return this.k;
    }

    public ListView getWrappedList() {
        return this.a;
    }

    @Override // android.view.View
    public boolean isHorizontalScrollBarEnabled() {
        return this.a.isHorizontalScrollBarEnabled();
    }

    @Override // android.view.View
    public boolean isVerticalScrollBarEnabled() {
        return this.a.isVerticalScrollBarEnabled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WrapperViewList wrapperViewList = this.a;
        wrapperViewList.layout(0, 0, wrapperViewList.getMeasuredWidth(), getHeight());
        View view = this.b;
        if (view != null) {
            int d = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin + d();
            View view2 = this.b;
            view2.layout(this.l, d, view2.getMeasuredWidth() + this.l, this.b.getMeasuredHeight() + d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        b(this.b);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(View.BaseSavedState.EMPTY_STATE);
        this.a.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        if (super.onSaveInstanceState() == View.BaseSavedState.EMPTY_STATE) {
            return this.a.onSaveInstanceState();
        }
        throw new IllegalStateException("Handling non empty state of parent class is not implemented");
    }

    public void setAdapter(StickyListHeadersAdapter stickyListHeadersAdapter) {
        if (stickyListHeadersAdapter == null) {
            this.a.setAdapter((ListAdapter) null);
            b();
            return;
        }
        AdapterWrapper adapterWrapper = this.g;
        if (adapterWrapper != null) {
            adapterWrapper.unregisterDataSetObserver(this.s);
        }
        if (stickyListHeadersAdapter instanceof SectionIndexer) {
            this.g = new SectionIndexerAdapterWrapper(getContext(), stickyListHeadersAdapter);
        } else {
            this.g = new AdapterWrapper(getContext(), stickyListHeadersAdapter);
        }
        AdapterWrapperDataSetObserver adapterWrapperDataSetObserver = new AdapterWrapperDataSetObserver();
        this.s = adapterWrapperDataSetObserver;
        this.g.registerDataSetObserver(adapterWrapperDataSetObserver);
        if (this.p != null) {
            this.g.a(new AdapterWrapperHeaderClickHandler());
        } else {
            this.g.a((AdapterWrapper.OnHeaderClickListener) null);
        }
        this.g.a(this.t, this.u);
        this.a.setAdapter((ListAdapter) this.g);
        b();
    }

    public void setAreHeadersSticky(boolean z) {
        this.h = z;
        if (z) {
            b(this.a.a());
        } else {
            b();
        }
        this.a.invalidate();
    }

    public void setBlockLayoutChildren(boolean z) {
        this.a.a(z);
    }

    public void setChoiceMode(int i) {
        this.a.setChoiceMode(i);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        WrapperViewList wrapperViewList = this.a;
        if (wrapperViewList != null) {
            wrapperViewList.setClipToPadding(z);
        }
        this.i = z;
    }

    public void setDivider(Drawable drawable) {
        this.t = drawable;
        AdapterWrapper adapterWrapper = this.g;
        if (adapterWrapper != null) {
            adapterWrapper.a(drawable, this.u);
        }
    }

    public void setDividerHeight(int i) {
        this.u = i;
        AdapterWrapper adapterWrapper = this.g;
        if (adapterWrapper != null) {
            adapterWrapper.a(this.t, i);
        }
    }

    public void setDrawingListUnderStickyHeader(boolean z) {
        this.j = z;
        this.a.a(0);
    }

    public void setEmptyView(View view) {
        this.a.setEmptyView(view);
    }

    public void setFastScrollAlwaysVisible(boolean z) {
        if (e(11)) {
            this.a.setFastScrollAlwaysVisible(z);
        }
    }

    public void setFastScrollEnabled(boolean z) {
        this.a.setFastScrollEnabled(z);
    }

    @Override // android.view.View
    public void setHorizontalScrollBarEnabled(boolean z) {
        this.a.setHorizontalScrollBarEnabled(z);
    }

    public void setMultiChoiceModeListener(AbsListView.MultiChoiceModeListener multiChoiceModeListener) {
        if (e(11)) {
            this.a.setMultiChoiceModeListener(multiChoiceModeListener);
        }
    }

    @Override // android.view.View
    public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener onCreateContextMenuListener) {
        this.a.setOnCreateContextMenuListener(onCreateContextMenuListener);
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.p = onHeaderClickListener;
        AdapterWrapper adapterWrapper = this.g;
        if (adapterWrapper != null) {
            if (onHeaderClickListener == null) {
                adapterWrapper.a((AdapterWrapper.OnHeaderClickListener) null);
                return;
            }
            adapterWrapper.a(new AdapterWrapperHeaderClickHandler());
            View view = this.b;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.framework.view.stickylistheaders.StickyListHeadersListView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        OnHeaderClickListener onHeaderClickListener2 = StickyListHeadersListView.this.p;
                        StickyListHeadersListView stickyListHeadersListView = StickyListHeadersListView.this;
                        onHeaderClickListener2.a(stickyListHeadersListView, stickyListHeadersListView.b, StickyListHeadersListView.this.d.intValue(), StickyListHeadersListView.this.c.longValue(), true);
                    }
                });
            }
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.a.setOnItemClickListener(onItemClickListener);
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.a.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f = onScrollListener;
    }

    public void setOnStickyHeaderChangedListener(OnStickyHeaderChangedListener onStickyHeaderChangedListener) {
        this.r = onStickyHeaderChangedListener;
    }

    public void setOnStickyHeaderOffsetChangedListener(OnStickyHeaderOffsetChangedListener onStickyHeaderOffsetChangedListener) {
        this.q = onStickyHeaderOffsetChangedListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(final View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.a.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.framework.view.stickylistheaders.StickyListHeadersListView.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return onTouchListener.onTouch(StickyListHeadersListView.this, motionEvent);
                }
            });
        } else {
            this.a.setOnTouchListener(null);
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        WrapperViewList wrapperViewList;
        if (!e(9) || (wrapperViewList = this.a) == null) {
            return;
        }
        wrapperViewList.setOverScrollMode(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.l = i;
        this.m = i2;
        this.n = i3;
        this.o = i4;
        WrapperViewList wrapperViewList = this.a;
        if (wrapperViewList != null) {
            wrapperViewList.setPadding(i, i2, i3, i4);
        }
        super.setPadding(0, 0, 0, 0);
        requestLayout();
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        this.a.setScrollBarStyle(i);
    }

    public void setSelection(int i) {
        a(i, 0);
    }

    public void setSelector(int i) {
        this.a.setSelector(i);
    }

    public void setSelector(Drawable drawable) {
        this.a.setSelector(drawable);
    }

    public void setStickyHeaderTopOffset(int i) {
        this.k = i;
        b(this.a.a());
    }

    public void setTranscriptMode(int i) {
        this.a.setTranscriptMode(i);
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        this.a.setVerticalScrollBarEnabled(z);
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        return this.a.showContextMenu();
    }
}
