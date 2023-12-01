package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import com.bytedance.applog.tracker.Tracker;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/AdapterWrapper.class */
class AdapterWrapper extends BaseAdapter implements StickyListHeadersAdapter {

    /* renamed from: a  reason: collision with root package name */
    final StickyListHeadersAdapter f10326a;
    private final List<View> b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    private final Context f10327c;
    private Drawable d;
    private int e;
    private OnHeaderClickListener f;
    private DataSetObserver g;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/AdapterWrapper$OnHeaderClickListener.class */
    interface OnHeaderClickListener {
        void a(View view, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdapterWrapper(Context context, StickyListHeadersAdapter stickyListHeadersAdapter) {
        DataSetObserver dataSetObserver = new DataSetObserver() { // from class: com.blued.android.framework.view.stickylistheaders.AdapterWrapper.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AdapterWrapper.super.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                AdapterWrapper.this.b.clear();
                AdapterWrapper.super.notifyDataSetInvalidated();
            }
        };
        this.g = dataSetObserver;
        this.f10327c = context;
        this.f10326a = stickyListHeadersAdapter;
        stickyListHeadersAdapter.registerDataSetObserver(dataSetObserver);
    }

    private View a() {
        if (this.b.size() > 0) {
            return this.b.remove(0);
        }
        return null;
    }

    private View a(WrapperView wrapperView, final int i) {
        View b = this.f10326a.b(i, wrapperView.d == null ? a() : wrapperView.d, wrapperView);
        if (b != null) {
            b.setClickable(true);
            b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.framework.view.stickylistheaders.AdapterWrapper.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (AdapterWrapper.this.f != null) {
                        AdapterWrapper.this.f.a(view, i, AdapterWrapper.this.f10326a.a(i));
                    }
                }
            });
            return b;
        }
        throw new NullPointerException("Header view must not be null.");
    }

    private void a(WrapperView wrapperView) {
        View view = wrapperView.d;
        if (view != null) {
            view.setVisibility(0);
            this.b.add(view);
        }
    }

    private boolean b(int i) {
        return i != 0 && this.f10326a.a(i) == this.f10326a.a(i - 1);
    }

    @Override // com.blued.android.framework.view.stickylistheaders.StickyListHeadersAdapter
    public long a(int i) {
        return this.f10326a.a(i);
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public WrapperView getView(int i, View view, ViewGroup viewGroup) {
        CheckableWrapperView checkableWrapperView;
        WrapperView wrapperView = view == null ? new WrapperView(this.f10327c) : (WrapperView) view;
        View view2 = this.f10326a.getView(i, wrapperView.f10346a, viewGroup);
        View view3 = null;
        if (b(i)) {
            a(wrapperView);
        } else {
            view3 = a(wrapperView, i);
        }
        boolean z = view2 instanceof Checkable;
        if (!z || (wrapperView instanceof CheckableWrapperView)) {
            checkableWrapperView = wrapperView;
            if (!z) {
                checkableWrapperView = wrapperView;
                if (wrapperView instanceof CheckableWrapperView) {
                    checkableWrapperView = new WrapperView(this.f10327c);
                }
            }
        } else {
            checkableWrapperView = new CheckableWrapperView(this.f10327c);
        }
        checkableWrapperView.update(view2, view3, this.d, this.e);
        return checkableWrapperView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable, int i) {
        this.d = drawable;
        this.e = i;
        notifyDataSetChanged();
    }

    public void a(OnHeaderClickListener onHeaderClickListener) {
        this.f = onHeaderClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.f10326a.areAllItemsEnabled();
    }

    @Override // com.blued.android.framework.view.stickylistheaders.StickyListHeadersAdapter
    public View b(int i, View view, ViewGroup viewGroup) {
        return this.f10326a.b(i, view, viewGroup);
    }

    public boolean equals(Object obj) {
        return this.f10326a.equals(obj);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10326a.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return ((BaseAdapter) this.f10326a).getDropDownView(i, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f10326a.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f10326a.getItemId(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.f10326a.getItemViewType(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f10326a.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.f10326a.hasStableIds();
    }

    public int hashCode() {
        return this.f10326a.hashCode();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.f10326a.isEmpty();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return this.f10326a.isEnabled(i);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        ((BaseAdapter) this.f10326a).notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        ((BaseAdapter) this.f10326a).notifyDataSetInvalidated();
    }

    public String toString() {
        return this.f10326a.toString();
    }
}
