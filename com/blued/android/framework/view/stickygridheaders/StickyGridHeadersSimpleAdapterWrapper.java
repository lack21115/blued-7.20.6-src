package com.blued.android.framework.view.stickygridheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersSimpleAdapterWrapper.class */
public class StickyGridHeadersSimpleAdapterWrapper extends BaseAdapter implements StickyGridHeadersBaseAdapter {
    private StickyGridHeadersSimpleAdapter a;
    private HeaderData[] b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersSimpleAdapterWrapper$DataSetObserverExtension.class */
    final class DataSetObserverExtension extends DataSetObserver {
        private DataSetObserverExtension() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper = StickyGridHeadersSimpleAdapterWrapper.this;
            stickyGridHeadersSimpleAdapterWrapper.b = stickyGridHeadersSimpleAdapterWrapper.a(stickyGridHeadersSimpleAdapterWrapper.a);
            StickyGridHeadersSimpleAdapterWrapper.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper = StickyGridHeadersSimpleAdapterWrapper.this;
            stickyGridHeadersSimpleAdapterWrapper.b = stickyGridHeadersSimpleAdapterWrapper.a(stickyGridHeadersSimpleAdapterWrapper.a);
            StickyGridHeadersSimpleAdapterWrapper.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersSimpleAdapterWrapper$HeaderData.class */
    public class HeaderData {
        private int b = 0;
        private int c;

        public HeaderData(int i) {
            this.c = i;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public void c() {
            this.b++;
        }
    }

    public StickyGridHeadersSimpleAdapterWrapper(StickyGridHeadersSimpleAdapter stickyGridHeadersSimpleAdapter) {
        this.a = stickyGridHeadersSimpleAdapter;
        stickyGridHeadersSimpleAdapter.registerDataSetObserver(new DataSetObserverExtension());
        this.b = a(stickyGridHeadersSimpleAdapter);
    }

    @Override // com.blued.android.framework.view.stickygridheaders.StickyGridHeadersBaseAdapter
    public int a() {
        return this.b.length;
    }

    @Override // com.blued.android.framework.view.stickygridheaders.StickyGridHeadersBaseAdapter
    public int a(int i) {
        return this.b[i].a();
    }

    @Override // com.blued.android.framework.view.stickygridheaders.StickyGridHeadersBaseAdapter
    public View a(int i, View view, ViewGroup viewGroup) {
        return this.a.a(this.b[i].b(), view, viewGroup);
    }

    protected HeaderData[] a(StickyGridHeadersSimpleAdapter stickyGridHeadersSimpleAdapter) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stickyGridHeadersSimpleAdapter.getCount()) {
                return (HeaderData[]) arrayList.toArray(new HeaderData[arrayList.size()]);
            }
            long a = stickyGridHeadersSimpleAdapter.a(i2);
            HeaderData headerData = (HeaderData) hashMap.get(Long.valueOf(a));
            HeaderData headerData2 = headerData;
            if (headerData == null) {
                headerData2 = new HeaderData(i2);
                arrayList.add(headerData2);
            }
            headerData2.c();
            hashMap.put(Long.valueOf(a), headerData2);
            i = i2 + 1;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.a.getItemId(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.a.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.a.getView(i, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.a.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.a.hasStableIds();
    }
}
