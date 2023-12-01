package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.stickylistheaders.StickyListHeadersAdapter;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.DistanceUtils;
import com.soft.blued.R;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/MyGroupListsAdapter.class */
public class MyGroupListsAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<BluedGroupLists> f17259a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private LoadOptions f17260c;
    private boolean d;
    private IRequestHost e;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/MyGroupListsAdapter$HeaderViewHolder.class */
    class HeaderViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17261a;

        private HeaderViewHolder() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/MyGroupListsAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f17262a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17263c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public TextView g;

        private ViewHolder() {
        }
    }

    public MyGroupListsAdapter(Context context, IRequestHost iRequestHost, List<BluedGroupLists> list, boolean z) {
        this.f17259a = list;
        this.e = iRequestHost;
        this.d = z;
        this.b = LayoutInflater.from(context);
        LoadOptions loadOptions = new LoadOptions();
        this.f17260c = loadOptions;
        loadOptions.d = R.drawable.group_default_head;
        this.f17260c.b = R.drawable.group_default_head;
    }

    public long a(int i) {
        return this.f17259a.get(i).type;
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        HeaderViewHolder headerViewHolder;
        if (view == null) {
            HeaderViewHolder headerViewHolder2 = new HeaderViewHolder();
            View inflate = this.b.inflate(R.layout.fragment_my_group_lists_header, viewGroup, false);
            headerViewHolder2.f17261a = (TextView) inflate.findViewById(R.id.tvHeader);
            inflate.setTag(headerViewHolder2);
            headerViewHolder = headerViewHolder2;
            view = inflate;
        } else {
            headerViewHolder = (HeaderViewHolder) view.getTag();
        }
        if (!this.d) {
            headerViewHolder.f17261a.setVisibility(8);
            return view;
        }
        headerViewHolder.f17261a.setVisibility(0);
        headerViewHolder.f17261a.setText(this.f17259a.get(i).header_name);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17259a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f17259a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        BluedGroupLists bluedGroupLists = this.f17259a.get(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.b.inflate(R.layout.item_group_list_show, viewGroup, false);
            viewHolder.f17262a = (ImageView) view2.findViewById(R.id.iv_group_profile_photo);
            viewHolder.b = (TextView) view2.findViewById(R.id.tv_group_name_info);
            viewHolder.f17263c = (TextView) view2.findViewById(R.id.tv_groupSize);
            viewHolder.d = (TextView) view2.findViewById(R.id.tv_group_location_details);
            viewHolder.e = (TextView) view2.findViewById(R.id.tv_group_distance);
            viewHolder.f = (ImageView) view2.findViewById(R.id.iv_verify_icon);
            viewHolder.g = (TextView) view2.findViewById(R.id.tv_group_lock_icon);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (bluedGroupLists.groups_is_locked == 1) {
            viewHolder.g.setVisibility(0);
        } else {
            viewHolder.g.setVisibility(8);
        }
        ImageLoader.a(this.e, bluedGroupLists.groups_avatar).b(2131237310).c().a(viewHolder.f17262a);
        if (StringUtils.d(bluedGroupLists.groups_name)) {
            viewHolder.b.setVisibility(4);
        } else {
            viewHolder.b.setText(bluedGroupLists.groups_name);
        }
        if (BlueAppLocal.d()) {
            if (StringUtils.d(bluedGroupLists.groups_members_count)) {
                viewHolder.f17263c.setVisibility(4);
            } else {
                TextView textView = viewHolder.f17263c;
                textView.setText(StringUtils.a(bluedGroupLists.groups_members_count) + "人");
            }
        } else if (StringUtils.d(bluedGroupLists.groups_members_count)) {
            viewHolder.f17263c.setVisibility(4);
        } else {
            viewHolder.f17263c.setText(StringUtils.a(bluedGroupLists.groups_members_count));
        }
        if (StringUtils.d(bluedGroupLists.groups_city)) {
            viewHolder.d.setVisibility(4);
        } else {
            viewHolder.d.setText(bluedGroupLists.groups_description);
        }
        if (StringUtils.d(bluedGroupLists.groups_distance)) {
            viewHolder.e.setVisibility(4);
        } else {
            viewHolder.e.setText(DistanceUtils.a(bluedGroupLists.groups_distance, BlueAppLocal.c(), false));
        }
        UserInfoHelper.a(viewHolder.f, bluedGroupLists.vbadge, 3);
        return view2;
    }
}
