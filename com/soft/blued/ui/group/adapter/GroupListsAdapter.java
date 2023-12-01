package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.pulltorefresh.PinnedSectionListView;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.DistanceUtils;
import com.soft.blued.R;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupListsAdapter.class */
public class GroupListsAdapter extends BaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<BluedGroupLists> f17215a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f17216c;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupListsAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f17217a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f17218c;
        public ImageView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public ImageView i;

        public ViewHolder() {
        }
    }

    public GroupListsAdapter(Context context) {
        this.f17215a = new ArrayList();
        this.b = LayoutInflater.from(context);
    }

    public GroupListsAdapter(Context context, IRequestHost iRequestHost, List<BluedGroupLists> list) {
        this.f17215a = list;
        this.f17216c = iRequestHost;
        this.b = LayoutInflater.from(context);
    }

    public void a(ViewHolder viewHolder, BluedGroupLists bluedGroupLists) {
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.d = R.drawable.group_default_head;
        loadOptions.b = R.drawable.group_default_head;
        viewHolder.f17217a.setVisibility(8);
        viewHolder.f17218c.setVisibility(0);
        if (bluedGroupLists.is_title == 2) {
            viewHolder.f17218c.setBackgroundColor(Color.parseColor("#f7f7f7"));
        } else {
            viewHolder.f17218c.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        ImageLoader.a(this.f17216c, bluedGroupLists.groups_avatar).b(2131237310).c().a(viewHolder.d);
        if (StringUtils.d(bluedGroupLists.groups_name)) {
            viewHolder.e.setVisibility(4);
        } else {
            viewHolder.e.setVisibility(0);
            viewHolder.e.setText(bluedGroupLists.groups_name);
        }
        if (BlueAppLocal.d()) {
            if (StringUtils.d(bluedGroupLists.groups_members_count)) {
                viewHolder.f.setVisibility(4);
            } else {
                viewHolder.f.setVisibility(0);
                TextView textView = viewHolder.f;
                textView.setText(StringUtils.a(bluedGroupLists.groups_members_count) + "人");
            }
        } else if (StringUtils.d(bluedGroupLists.groups_members_count)) {
            viewHolder.f.setVisibility(4);
        } else {
            viewHolder.f.setVisibility(0);
            viewHolder.f.setText(StringUtils.a(bluedGroupLists.groups_members_count));
        }
        if (StringUtils.d(bluedGroupLists.groups_description)) {
            viewHolder.h.setVisibility(4);
        } else {
            viewHolder.h.setVisibility(0);
            viewHolder.h.setText(bluedGroupLists.groups_description);
        }
        if (StringUtils.d(bluedGroupLists.groups_distance)) {
            viewHolder.g.setVisibility(4);
        } else {
            viewHolder.g.setVisibility(0);
            viewHolder.g.setText(DistanceUtils.b(bluedGroupLists.groups_distance, BlueAppLocal.c(), false));
        }
        UserInfoHelper.a(viewHolder.i, bluedGroupLists.vbadge, 3);
    }

    public void a(List<BluedGroupLists> list) {
        if (list != null) {
            List<BluedGroupLists> list2 = this.f17215a;
            if (list2 == null) {
                this.f17215a = new ArrayList();
                return;
            }
            list2.clear();
            b(list);
        }
    }

    public boolean a(int i) {
        return i == 1;
    }

    public void b(List<BluedGroupLists> list) {
        if (this.f17215a == null) {
            this.f17215a = new ArrayList();
        }
        this.f17215a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17215a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f17215a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((BluedGroupLists) getItem(i)).is_title;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        BluedGroupLists bluedGroupLists = this.f17215a.get(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = this.b.inflate(R.layout.item_group_list_show, (ViewGroup) null);
            viewHolder.f17217a = (LinearLayout) view.findViewById(R.id.ll_group_list_title);
            viewHolder.b = (TextView) view.findViewById(R.id.tv_group_list_title);
            viewHolder.f17218c = (LinearLayout) view.findViewById(R.id.ll_group_info);
            viewHolder.d = (ImageView) view.findViewById(R.id.iv_group_profile_photo);
            viewHolder.e = (TextView) view.findViewById(R.id.tv_group_name_info);
            viewHolder.f = (TextView) view.findViewById(R.id.tv_groupSize);
            viewHolder.h = (TextView) view.findViewById(R.id.tv_group_location_details);
            viewHolder.g = (TextView) view.findViewById(R.id.tv_group_distance);
            viewHolder.i = (ImageView) view.findViewById(R.id.iv_verify_icon);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        a(viewHolder, bluedGroupLists);
        return view;
    }
}
