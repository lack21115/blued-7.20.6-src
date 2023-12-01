package com.blued.android.framework.view.stickygridheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersBaseAdapterWrapper.class */
public class StickyGridHeadersBaseAdapterWrapper extends BaseAdapter {
    private final Context a;
    private int b;
    private boolean c = false;
    private DataSetObserver d;
    private final StickyGridHeadersBaseAdapter e;
    private StickyGridHeadersGridView f;
    private View g;
    private View h;
    private int i;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersBaseAdapterWrapper$FillerView.class */
    public class FillerView extends View {
        private View b;

        public FillerView(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.b.getMeasuredHeight(), 1073741824));
        }

        public void setMeasureTarget(View view) {
            this.b = view;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersBaseAdapterWrapper$HeaderFillerView.class */
    public class HeaderFillerView extends FrameLayout {
        private int b;

        public HeaderFillerView(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.view.ViewGroup
        public FrameLayout.LayoutParams generateDefaultLayoutParams() {
            return new FrameLayout.LayoutParams(-1, -1);
        }

        public int getHeaderId() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            View view = (View) getTag();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams;
            if (layoutParams == 0) {
                layoutParams2 = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams2);
            }
            if (view.getVisibility() != 8) {
                view.measure(getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(StickyGridHeadersBaseAdapterWrapper.this.f.getWidth(), 1073741824), 0, layoutParams2.width), getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, layoutParams2.height));
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i), view.getMeasuredHeight());
        }

        public void setHeaderId(int i) {
            this.b = i;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersBaseAdapterWrapper$HeaderHolder.class */
    public class HeaderHolder {
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersBaseAdapterWrapper$Position.class */
    public class Position {
        protected int a;
        protected int b;

        protected Position(int i, int i2) {
            this.b = i;
            this.a = i2;
        }
    }

    public StickyGridHeadersBaseAdapterWrapper(Context context, StickyGridHeadersGridView stickyGridHeadersGridView, StickyGridHeadersBaseAdapter stickyGridHeadersBaseAdapter) {
        DataSetObserver dataSetObserver = new DataSetObserver() { // from class: com.blued.android.framework.view.stickygridheaders.StickyGridHeadersBaseAdapterWrapper.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                StickyGridHeadersBaseAdapterWrapper.this.a();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                StickyGridHeadersBaseAdapterWrapper.this.c = false;
            }
        };
        this.d = dataSetObserver;
        this.i = 1;
        this.a = context;
        this.e = stickyGridHeadersBaseAdapter;
        this.f = stickyGridHeadersGridView;
        stickyGridHeadersBaseAdapter.registerDataSetObserver(dataSetObserver);
    }

    private FillerView a(View view, ViewGroup viewGroup, View view2) {
        FillerView fillerView = (FillerView) view;
        FillerView fillerView2 = fillerView;
        if (fillerView == null) {
            fillerView2 = new FillerView(this.a);
        }
        fillerView2.setMeasureTarget(view2);
        return fillerView2;
    }

    private HeaderFillerView b(int i, View view, ViewGroup viewGroup) {
        HeaderFillerView headerFillerView = (HeaderFillerView) view;
        HeaderFillerView headerFillerView2 = headerFillerView;
        if (headerFillerView == null) {
            headerFillerView2 = new HeaderFillerView(this.a);
        }
        return headerFillerView2;
    }

    private int d(int i) {
        if (this.i == 0) {
            return 0;
        }
        int a = this.e.a(i);
        int i2 = this.i;
        int i3 = a % i2;
        if (i3 == 0) {
            return 0;
        }
        return i2 - i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(int i, View view, ViewGroup viewGroup) {
        if (this.e.a() == 0) {
            return null;
        }
        return this.e.a(c(i).a, view, viewGroup);
    }

    protected void a() {
        this.b = 0;
        int a = this.e.a();
        if (a == 0) {
            this.b = this.e.getCount();
            this.c = true;
            return;
        }
        for (int i = 0; i < a; i++) {
            this.b += this.e.a(i) + this.i;
        }
        this.c = true;
    }

    public void a(int i) {
        this.i = i;
        this.c = false;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long b(int i) {
        return c(i).a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Position c(int i) {
        int a = this.e.a();
        if (a == 0) {
            return i >= this.e.getCount() ? new Position(-1, 0) : new Position(i, 0);
        }
        int i2 = i;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= a) {
                return new Position(-1, i5);
            }
            int a2 = this.e.a(i5);
            if (i3 == 0) {
                return new Position(-2, i5);
            }
            int i6 = this.i;
            int i7 = i3 - i6;
            if (i7 < 0) {
                return new Position(-3, i5);
            }
            int i8 = i2 - i6;
            if (i7 < a2) {
                return new Position(i8, i5);
            }
            int d = d(i5);
            i2 = i8 - d;
            i3 = i7 - (a2 + d);
            if (i3 < 0) {
                return new Position(-1, i5);
            }
            i4 = i5 + 1;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c) {
            return this.b;
        }
        this.b = 0;
        int a = this.e.a();
        if (a == 0) {
            int count = this.e.getCount();
            this.b = count;
            this.c = true;
            return count;
        }
        for (int i = 0; i < a; i++) {
            this.b += this.e.a(i) + d(i) + this.i;
        }
        this.c = true;
        return this.b;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) throws ArrayIndexOutOfBoundsException {
        Position c = c(i);
        if (c.b == -1 || c.b == -2) {
            return null;
        }
        return this.e.getItem(c.b);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Position c = c(i);
        if (c.b == -2) {
            return -1L;
        }
        if (c.b == -1) {
            return -2L;
        }
        if (c.b == -3) {
            return -3L;
        }
        return this.e.getItemId(c.b);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Position c = c(i);
        if (c.b == -2) {
            return 1;
        }
        if (c.b == -1) {
            return 0;
        }
        if (c.b == -3) {
            return 2;
        }
        int itemViewType = this.e.getItemViewType(c.b);
        return itemViewType == -1 ? itemViewType : itemViewType + 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Position c = c(i);
        if (c.b == -2) {
            HeaderFillerView b = b(c.a, view, viewGroup);
            View a = this.e.a(c.a, (View) b.getTag(), viewGroup);
            this.f.b((View) b.getTag());
            b.setTag(a);
            this.f.a(a);
            this.g = b;
            b.forceLayout();
            return b;
        } else if (c.b == -3) {
            FillerView a2 = a(view, viewGroup, this.g);
            a2.forceLayout();
            return a2;
        } else if (c.b == -1) {
            return a(view, viewGroup, this.h);
        } else {
            View view2 = this.e.getView(c.b, view, viewGroup);
            this.h = view2;
            return view2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.e.getViewTypeCount() + 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.e.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.e.isEmpty();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        Position c = c(i);
        if (c.b == -1 || c.b == -2) {
            return false;
        }
        return this.e.isEnabled(c.b);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.e.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.e.unregisterDataSetObserver(dataSetObserver);
    }
}
