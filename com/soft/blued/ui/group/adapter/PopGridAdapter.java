package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.FilterInfo;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/PopGridAdapter.class */
public class PopGridAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f30954a;
    private List<FilterInfo> b;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/PopGridAdapter$ViewHolder.class */
    final class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        TextView f30955a;

        private ViewHolder() {
        }
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
            view = LayoutInflater.from(this.f30954a).inflate(R.layout.popmenu_grid_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.f30955a = (TextView) view.findViewById(R.id.tv_group_type_tag);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.f30955a.setText(this.b.get(i).mName);
        return view;
    }
}
