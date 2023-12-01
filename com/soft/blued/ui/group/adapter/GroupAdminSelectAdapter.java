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
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.soft.blued.R;
import com.soft.blued.ui.group.model.BluedGroupAllMembers;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupAdminSelectAdapter.class */
public class GroupAdminSelectAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f17200a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private List<BluedGroupAllMembers> f17201c;
    private LoadOptions d;
    private IRequestHost e;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupAdminSelectAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        ImageView f17202a;
        TextView b;

        /* renamed from: c  reason: collision with root package name */
        TextView f17203c;
        TextView d;
        TextView e;
        ImageView f;

        private ViewHolder() {
        }
    }

    public GroupAdminSelectAdapter(Context context, IRequestHost iRequestHost, List<BluedGroupAllMembers> list) {
        this.b = context;
        this.e = iRequestHost;
        this.f17201c = list;
        this.f17200a = LayoutInflater.from(context);
        LoadOptions loadOptions = new LoadOptions();
        this.d = loadOptions;
        loadOptions.d = 2131237310;
        this.d.b = 2131237310;
    }

    public void a() {
        this.f17201c.clear();
        notifyDataSetChanged();
    }

    public void a(List<BluedGroupAllMembers> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f17201c.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17201c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f17201c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        BluedGroupAllMembers bluedGroupAllMembers = this.f17201c.get(i);
        if (view == null) {
            ViewHolder viewHolder2 = new ViewHolder();
            View inflate = this.f17200a.inflate(R.layout.item_group_member_select, viewGroup, false);
            viewHolder2.f17202a = (ImageView) inflate.findViewById(R.id.iv_user_head);
            viewHolder2.b = (TextView) inflate.findViewById(R.id.tv_user_name);
            viewHolder2.f17203c = (TextView) inflate.findViewById(R.id.tv_group_user_details);
            viewHolder2.d = (TextView) inflate.findViewById(R.id.tv_user_distance);
            viewHolder2.e = (TextView) inflate.findViewById(R.id.tv_last_activate_time);
            viewHolder2.f = (ImageView) inflate.findViewById(R.id.member_img_verify);
            inflate.setTag(viewHolder2);
            viewHolder = viewHolder2;
            view = inflate;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ImageLoader.a(this.e, bluedGroupAllMembers.avatar).b(2131237310).c().a(viewHolder.f17202a);
        UserInfoHelper.a(viewHolder.f, bluedGroupAllMembers.vbadge, 3);
        if (StringUtils.d(bluedGroupAllMembers.name)) {
            viewHolder.b.setVisibility(4);
        } else {
            viewHolder.b.setText(bluedGroupAllMembers.name);
        }
        if (StringUtils.d(bluedGroupAllMembers.distance)) {
            viewHolder.d.setVisibility(4);
        } else {
            viewHolder.d.setText(DistanceUtils.a(bluedGroupAllMembers.distance, BlueAppLocal.c(), false));
        }
        if (StringUtils.d(bluedGroupAllMembers.last_active_time)) {
            viewHolder.e.setText("");
        } else {
            viewHolder.e.setText(TimeAndDateUtils.f(this.b, TimeAndDateUtils.c(bluedGroupAllMembers.last_active_time)));
        }
        TextView textView = viewHolder.f17203c;
        textView.setText(bluedGroupAllMembers.age + " / " + bluedGroupAllMembers.height + " / " + bluedGroupAllMembers.weight + " " + this.b.getResources().getString(R.string.separator) + " " + UserInfoHelper.a(this.b, bluedGroupAllMembers.role));
        return view;
    }
}
