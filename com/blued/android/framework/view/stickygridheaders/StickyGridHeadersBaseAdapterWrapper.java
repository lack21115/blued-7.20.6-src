package com.blued.android.framework.view.stickygridheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersBaseAdapterWrapper.class */
public class StickyGridHeadersBaseAdapterWrapper extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10296a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10297c = false;
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

        /* renamed from: a  reason: collision with root package name */
        protected int f10301a;
        protected int b;

        protected Position(int i, int i2) {
            this.b = i;
            this.f10301a = i2;
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
                StickyGridHeadersBaseAdapterWrapper.this.f10297c = false;
            }
        };
        this.d = dataSetObserver;
        this.i = 1;
        this.f10296a = context;
        this.e = stickyGridHeadersBaseAdapter;
        this.f = stickyGridHeadersGridView;
        stickyGridHeadersBaseAdapter.registerDataSetObserver(dataSetObserver);
    }

    private FillerView a(View view, ViewGroup viewGroup, View view2) {
        FillerView fillerView = (FillerView) view;
        FillerView fillerView2 = fillerView;
        if (fillerView == null) {
            fillerView2 = new FillerView(this.f10296a);
        }
        fillerView2.setMeasureTarget(view2);
        return fillerView2;
    }

    private HeaderFillerView b(int i, View view, ViewGroup viewGroup) {
        HeaderFillerView headerFillerView = (HeaderFillerView) view;
        HeaderFillerView headerFillerView2 = headerFillerView;
        if (headerFillerView == null) {
            headerFillerView2 = new HeaderFillerView(this.f10296a);
        }
        return headerFillerView2;
    }

    private int d(int i) {
        if (this.i == 0) {
            return 0;
        }
        int a2 = this.e.a(i);
        int i2 = this.i;
        int i3 = a2 % i2;
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
        return this.e.a(c(i).f10301a, view, viewGroup);
    }

    protected void a() {
        this.b = 0;
        int a2 = this.e.a();
        if (a2 == 0) {
            this.b = this.e.getCount();
            this.f10297c = true;
            return;
        }
        for (int i = 0; i < a2; i++) {
            this.b += this.e.a(i) + this.i;
        }
        this.f10297c = true;
    }

    public void a(int i) {
        this.i = i;
        this.f10297c = false;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long b(int i) {
        return c(i).f10301a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Position c(int i) {
        int a2 = this.e.a();
        if (a2 == 0) {
            return i >= this.e.getCount() ? new Position(-1, 0) : new Position(i, 0);
        }
        int i2 = i;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= a2) {
                return new Position(-1, i5);
            }
            int a3 = this.e.a(i5);
            if (i3 == 0) {
                return new Position(-2, i5);
            }
            int i6 = this.i;
            int i7 = i3 - i6;
            if (i7 < 0) {
                return new Position(-3, i5);
            }
            int i8 = i2 - i6;
            if (i7 < a3) {
                return new Position(i8, i5);
            }
            int d = d(i5);
            i2 = i8 - d;
            i3 = i7 - (a3 + d);
            if (i3 < 0) {
                return new Position(-1, i5);
            }
            i4 = i5 + 1;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f10297c) {
            return this.b;
        }
        this.b = 0;
        int a2 = this.e.a();
        if (a2 == 0) {
            int count = this.e.getCount();
            this.b = count;
            this.f10297c = true;
            return count;
        }
        for (int i = 0; i < a2; i++) {
            this.b += this.e.a(i) + d(i) + this.i;
        }
        this.f10297c = true;
        return this.b;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) throws ArrayIndexOutOfBoundsException {
        Position c2 = c(i);
        if (c2.b == -1 || c2.b == -2) {
            return null;
        }
        return this.e.getItem(c2.b);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Position c2 = c(i);
        if (c2.b == -2) {
            return -1L;
        }
        if (c2.b == -1) {
            return -2L;
        }
        if (c2.b == -3) {
            return -3L;
        }
        return this.e.getItemId(c2.b);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Position c2 = c(i);
        if (c2.b == -2) {
            return 1;
        }
        if (c2.b == -1) {
            return 0;
        }
        if (c2.b == -3) {
            return 2;
        }
        int itemViewType = this.e.getItemViewType(c2.b);
        return itemViewType == -1 ? itemViewType : itemViewType + 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Position c2 = c(i);
        if (c2.b == -2) {
            HeaderFillerView b = b(c2.f10301a, view, viewGroup);
            View a2 = this.e.a(c2.f10301a, (View) b.getTag(), viewGroup);
            this.f.b((View) b.getTag());
            b.setTag(a2);
            this.f.a(a2);
            this.g = b;
            b.forceLayout();
            return b;
        } else if (c2.b == -3) {
            FillerView a3 = a(view, viewGroup, this.g);
            a3.forceLayout();
            return a3;
        } else if (c2.b == -1) {
            return a(view, viewGroup, this.h);
        } else {
            View view2 = this.e.getView(c2.b, view, viewGroup);
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
        Position c2 = c(i);
        if (c2.b == -1 || c2.b == -2) {
            return false;
        }
        return this.e.isEnabled(c2.b);
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
