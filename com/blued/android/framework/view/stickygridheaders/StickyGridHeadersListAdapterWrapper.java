package com.blued.android.framework.view.stickygridheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersListAdapterWrapper.class */
public class StickyGridHeadersListAdapterWrapper extends BaseAdapter implements StickyGridHeadersBaseAdapter {
    private DataSetObserver a;
    private ListAdapter b;

    public StickyGridHeadersListAdapterWrapper(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = new DataSetObserver() { // from class: com.blued.android.framework.view.stickygridheaders.StickyGridHeadersListAdapterWrapper.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                StickyGridHeadersListAdapterWrapper.this.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                StickyGridHeadersListAdapterWrapper.this.notifyDataSetInvalidated();
            }
        };
        this.a = dataSetObserver;
        this.b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // com.blued.android.framework.view.stickygridheaders.StickyGridHeadersBaseAdapter
    public int a() {
        return 0;
    }

    @Override // com.blued.android.framework.view.stickygridheaders.StickyGridHeadersBaseAdapter
    public int a(int i) {
        return 0;
    }

    @Override // com.blued.android.framework.view.stickygridheaders.StickyGridHeadersBaseAdapter
    public View a(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ListAdapter listAdapter = this.b;
        if (listAdapter == null) {
            return 0;
        }
        return listAdapter.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ListAdapter listAdapter = this.b;
        if (listAdapter == null) {
            return null;
        }
        return listAdapter.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.b.getItemId(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.b.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.b.getView(i, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.b.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.b.hasStableIds();
    }
}
