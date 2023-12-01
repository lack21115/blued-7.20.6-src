package com.blued.android.framework.view.stickygridheaders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersSimpleArrayAdapter.class */
public class StickyGridHeadersSimpleArrayAdapter<T> extends BaseAdapter implements StickyGridHeadersSimpleAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f10322a = StickyGridHeadersSimpleArrayAdapter.class.getSimpleName();
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f10323c;
    private int d;
    private List<T> e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersSimpleArrayAdapter$HeaderViewHolder.class */
    public class HeaderViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f10324a;

        protected HeaderViewHolder() {
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickygridheaders/StickyGridHeadersSimpleArrayAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f10325a;

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
            view = this.f10323c.inflate(this.b, viewGroup, false);
            headerViewHolder = new HeaderViewHolder();
            headerViewHolder.f10324a = (TextView) view.findViewById(16908308);
            view.setTag(headerViewHolder);
        } else {
            headerViewHolder = (HeaderViewHolder) view.getTag();
        }
        T item = getItem(i);
        headerViewHolder.f10324a.setText((item instanceof CharSequence ? (CharSequence) item : item.toString()).subSequence(0, 1));
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
            view = this.f10323c.inflate(this.d, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.f10325a = (TextView) view.findViewById(16908308);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        T item = getItem(i);
        if (item instanceof CharSequence) {
            viewHolder.f10325a.setText((CharSequence) item);
            return view;
        }
        viewHolder.f10325a.setText(item.toString());
        return view;
    }
}
