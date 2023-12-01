package com.blued.android.framework.view.stickygridheaders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.android.internal.R;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersSimpleArrayAdapter.class */
public class StickyGridHeadersSimpleArrayAdapter<T> extends BaseAdapter implements StickyGridHeadersSimpleAdapter {
    protected static final String a = StickyGridHeadersSimpleArrayAdapter.class.getSimpleName();
    private int b;
    private LayoutInflater c;
    private int d;
    private List<T> e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersSimpleArrayAdapter$HeaderViewHolder.class */
    public class HeaderViewHolder {
        public TextView a;

        protected HeaderViewHolder() {
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersSimpleArrayAdapter$ViewHolder.class */
    public class ViewHolder {
        public TextView a;

        protected ViewHolder() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.CharSequence] */
    @Override // com.blued.android.framework.view.stickygridheaders.StickyGridHeadersSimpleAdapter
    public long a(int i) {
        T item = getItem(i);
        return (item instanceof CharSequence ? (CharSequence) item : item.toString()).subSequence(0, 1).charAt(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.CharSequence] */
    @Override // com.blued.android.framework.view.stickygridheaders.StickyGridHeadersSimpleAdapter
    public View a(int i, View view, ViewGroup viewGroup) {
        HeaderViewHolder headerViewHolder;
        if (view == null) {
            view = this.c.inflate(this.b, viewGroup, false);
            headerViewHolder = new HeaderViewHolder();
            headerViewHolder.a = (TextView) view.findViewById(R.id.text1);
            view.setTag(headerViewHolder);
        } else {
            headerViewHolder = (HeaderViewHolder) view.getTag();
        }
        T item = getItem(i);
        headerViewHolder.a.setText((item instanceof CharSequence ? (CharSequence) item : item.toString()).subSequence(0, 1));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.e.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.c.inflate(this.d, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.a = (TextView) view.findViewById(R.id.text1);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        T item = getItem(i);
        if (item instanceof CharSequence) {
            viewHolder.a.setText((CharSequence) item);
            return view;
        }
        viewHolder.a.setText(item.toString());
        return view;
    }
}
