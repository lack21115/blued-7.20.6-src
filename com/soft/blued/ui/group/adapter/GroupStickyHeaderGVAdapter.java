package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.blued.android.framework.view.stickygridheaders.StickyGridHeadersSimpleAdapter;
import com.soft.blued.R;
import com.soft.blued.ui.group.model.BluedGroupTypeGridItem;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupStickyHeaderGVAdapter.class */
public class GroupStickyHeaderGVAdapter extends BaseAdapter implements StickyGridHeadersSimpleAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f17246a;
    private List<BluedGroupTypeGridItem> b;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupStickyHeaderGVAdapter$HeaderViewHolder.class */
    class HeaderViewHolder {

        /* renamed from: a  reason: collision with root package name */
        TextView f17247a;

        HeaderViewHolder() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupStickyHeaderGVAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        TextView f17248a;

        ViewHolder() {
        }
    }

    public GroupStickyHeaderGVAdapter(Context context, List<BluedGroupTypeGridItem> list) {
        this.f17246a = LayoutInflater.from(context);
        this.b = list;
    }

    public long a(int i) {
        return this.b.get(i).getType();
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        HeaderViewHolder headerViewHolder;
        if (view == null) {
            HeaderViewHolder headerViewHolder2 = new HeaderViewHolder();
            View inflate = this.f17246a.inflate(R.layout.group_type_grid_header, viewGroup, false);
            headerViewHolder2.f17247a = (TextView) inflate.findViewById(R.id.tvHeader);
            inflate.setTag(headerViewHolder2);
            headerViewHolder = headerViewHolder2;
            view = inflate;
        } else {
            headerViewHolder = (HeaderViewHolder) view.getTag();
        }
        headerViewHolder.f17247a.setText(this.b.get(i).getName());
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            ViewHolder viewHolder2 = new ViewHolder();
            View inflate = this.f17246a.inflate(R.layout.group_type_grid_item, viewGroup, false);
            viewHolder2.f17248a = (TextView) inflate.findViewById(R.id.tv_group_type_tag);
            inflate.setTag(viewHolder2);
            viewHolder = viewHolder2;
            view = inflate;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.f17248a.setText(this.b.get(i).getTags());
        return view;
    }
}
