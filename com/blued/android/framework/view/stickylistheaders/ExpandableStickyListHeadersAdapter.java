package com.blued.android.framework.view.stickylistheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/ExpandableStickyListHeadersAdapter.class */
class ExpandableStickyListHeadersAdapter extends BaseAdapter implements StickyListHeadersAdapter {
    DualHashMap<View, Long> a = new DualHashMap<>();
    DistinctMultiHashMap<Integer, View> b = new DistinctMultiHashMap<>();
    List<Long> c = new ArrayList();
    private final StickyListHeadersAdapter d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpandableStickyListHeadersAdapter(StickyListHeadersAdapter stickyListHeadersAdapter) {
        this.d = stickyListHeadersAdapter;
    }

    @Override // com.blued.android.framework.view.stickylistheaders.StickyListHeadersAdapter
    public long a(int i) {
        return this.d.a(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.d.areAllItemsEnabled();
    }

    @Override // com.blued.android.framework.view.stickylistheaders.StickyListHeadersAdapter
    public View b(int i, View view, ViewGroup viewGroup) {
        return this.d.b(i, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.d.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.d.getItemId(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.d.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = this.d.getView(i, view, viewGroup);
        this.a.a(view2, Long.valueOf(getItemId(i)));
        this.b.a((DistinctMultiHashMap<Integer, View>) Integer.valueOf((int) a(i)), (Integer) view2);
        if (this.c.contains(Long.valueOf(a(i)))) {
            view2.setVisibility(8);
            return view2;
        }
        view2.setVisibility(0);
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.d.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.d.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.d.isEmpty();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return this.d.isEnabled(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.d.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.d.unregisterDataSetObserver(dataSetObserver);
    }
}
