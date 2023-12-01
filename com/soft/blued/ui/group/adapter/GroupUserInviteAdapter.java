package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.group.GroupMemberInviteFragment;
import com.soft.blued.ui.group.model.BluedUserInviteList;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupUserInviteAdapter.class */
public class GroupUserInviteAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f30939a;
    private List<BluedUserInviteList> b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f30940c;
    private String d;
    private String e;
    private String f;
    private int g;
    private String h;
    private LoadOptions i;
    private IRequestHost j;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupUserInviteAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f30947a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f30948c;
        public TextView d;
        public TextView e;
        public TextView f;
        public CheckBox g;
        public ImageView h;
        public ImageView i;

        public ViewHolder() {
        }
    }

    public GroupUserInviteAdapter(Context context, IRequestHost iRequestHost, List<BluedUserInviteList> list) {
        this.f30939a = context;
        this.j = iRequestHost;
        this.b = list;
        this.f30940c = LayoutInflater.from(context);
        LoadOptions loadOptions = new LoadOptions();
        this.i = loadOptions;
        loadOptions.d = 2131237310;
        this.i.b = 2131237310;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        final BluedUserInviteList bluedUserInviteList = this.b.get(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.f30940c.inflate(R.layout.item_group_member_invite_show, viewGroup, false);
            viewHolder.f30947a = (ImageView) view2.findViewById(2131366011);
            viewHolder.b = (TextView) view2.findViewById(2131372879);
            viewHolder.f30948c = (TextView) view2.findViewById(R.id.tv_user_distance);
            viewHolder.d = (TextView) view2.findViewById(R.id.tv_online_time);
            viewHolder.e = (TextView) view2.findViewById(R.id.tv_user_location);
            viewHolder.f = (TextView) view2.findViewById(R.id.tv_group_user_details);
            viewHolder.g = (CheckBox) view2.findViewById(R.id.cb_member_invite);
            viewHolder.h = (ImageView) view2.findViewById(R.id.iv_verify_icon);
            viewHolder.i = (ImageView) view2.findViewById(2131364726);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        ImageLoader.a(this.j, bluedUserInviteList.avatar).b(2131237310).c().a(viewHolder.f30947a);
        UserRelationshipUtils.a(viewHolder.i, bluedUserInviteList);
        if (!StringUtils.d(bluedUserInviteList.note)) {
            viewHolder.b.setText(bluedUserInviteList.note);
        } else if (StringUtils.d(bluedUserInviteList.name)) {
            viewHolder.b.setVisibility(4);
        } else {
            viewHolder.b.setText(bluedUserInviteList.name);
        }
        UserRelationshipUtils.a(this.f30939a, viewHolder.b, bluedUserInviteList);
        if (StringUtils.d(bluedUserInviteList.distance)) {
            viewHolder.f30948c.setVisibility(4);
        } else {
            viewHolder.f30948c.setText(DistanceUtils.a(bluedUserInviteList.distance, BlueAppLocal.c(), false));
        }
        DistanceUtils.a(this.f30939a, viewHolder.f30948c, bluedUserInviteList, 1);
        if (StringUtils.d(bluedUserInviteList.last_operate)) {
            viewHolder.d.setText("");
        } else {
            viewHolder.d.setText(TimeAndDateUtils.f(this.f30939a, TimeAndDateUtils.c(bluedUserInviteList.last_operate)));
        }
        TypefaceUtils.a(this.f30939a, viewHolder.d, bluedUserInviteList.is_hide_last_operate, 1);
        if (StringUtils.d(bluedUserInviteList.city_settled)) {
            viewHolder.e.setVisibility(4);
        } else {
            viewHolder.e.setText(AreaUtils.getAreaTxt(bluedUserInviteList.city_settled, BlueAppLocal.c()));
        }
        TypefaceUtils.b(this.f30939a, viewHolder.e, bluedUserInviteList.is_hide_city_settled, 1);
        TextView textView = viewHolder.f;
        textView.setText(bluedUserInviteList.age + " / " + bluedUserInviteList.height + " / " + bluedUserInviteList.weight + " " + this.f30939a.getResources().getString(2131891624) + " " + UserInfoHelper.a(this.f30939a, bluedUserInviteList.role));
        if (this.b.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.b.size()) {
                    break;
                }
                bluedUserInviteList.isCheckedFlag = false;
                bluedUserInviteList.isEnabledFlag = true;
                i2 = i3 + 1;
            }
        }
        if (GroupMemberInviteFragment.f30810a.size() > 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= GroupMemberInviteFragment.f30810a.size()) {
                    break;
                }
                if (GroupMemberInviteFragment.f30810a.get(i5).equals(bluedUserInviteList.uid) && 2 == GroupMemberInviteFragment.e.get(i5).shortValue()) {
                    bluedUserInviteList.isCheckedFlag = true;
                    bluedUserInviteList.isEnabledFlag = true;
                }
                i4 = i5 + 1;
            }
        }
        if (GroupMemberInviteFragment.g.size() > 0) {
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= GroupMemberInviteFragment.g.size()) {
                    break;
                }
                if (!StringUtils.d(bluedUserInviteList.uid) && !StringUtils.d(GroupMemberInviteFragment.g.get(i7)) && bluedUserInviteList.uid.equals(GroupMemberInviteFragment.g.get(i7))) {
                    bluedUserInviteList.isCheckedFlag = true;
                    bluedUserInviteList.isEnabledFlag = false;
                }
                i6 = i7 + 1;
            }
        }
        final ViewHolder viewHolder2 = viewHolder;
        viewHolder.g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.group.adapter.GroupUserInviteAdapter.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                if (!z) {
                    viewHolder2.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupUserInviteAdapter.1.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            Tracker.onClick(view3);
                            GroupUserInviteAdapter.this.h = ((BluedUserInviteList) GroupUserInviteAdapter.this.b.get(i)).uid;
                            if (GroupMemberInviteFragment.f30810a != null) {
                                int i8 = 0;
                                while (true) {
                                    int i9 = i8;
                                    if (i9 >= GroupMemberInviteFragment.f30810a.size()) {
                                        break;
                                    }
                                    if (GroupMemberInviteFragment.f30810a.get(i9).equals(GroupUserInviteAdapter.this.h)) {
                                        GroupMemberInviteFragment.b.remove(GroupMemberInviteFragment.b.get(i9));
                                        GroupMemberInviteFragment.f30811c.remove(GroupMemberInviteFragment.f30811c.get(i9));
                                        GroupMemberInviteFragment.f30810a.remove(GroupMemberInviteFragment.f30810a.get(i9));
                                        GroupMemberInviteFragment.d.remove(GroupMemberInviteFragment.d.get(i9));
                                        GroupMemberInviteFragment.e.remove(GroupMemberInviteFragment.e.get(i9));
                                    }
                                    i8 = i9 + 1;
                                }
                            }
                            bluedUserInviteList.isCheckedFlag = false;
                        }
                    });
                    return;
                }
                GroupUserInviteAdapter groupUserInviteAdapter = GroupUserInviteAdapter.this;
                groupUserInviteAdapter.d = ((BluedUserInviteList) groupUserInviteAdapter.b.get(i)).uid;
                GroupUserInviteAdapter groupUserInviteAdapter2 = GroupUserInviteAdapter.this;
                groupUserInviteAdapter2.e = ((BluedUserInviteList) groupUserInviteAdapter2.b.get(i)).name;
                GroupUserInviteAdapter groupUserInviteAdapter3 = GroupUserInviteAdapter.this;
                groupUserInviteAdapter3.f = ((BluedUserInviteList) groupUserInviteAdapter3.b.get(i)).avatar;
                GroupUserInviteAdapter groupUserInviteAdapter4 = GroupUserInviteAdapter.this;
                groupUserInviteAdapter4.g = ((BluedUserInviteList) groupUserInviteAdapter4.b.get(i)).vbadge;
                viewHolder2.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupUserInviteAdapter.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                        if (GroupMemberInviteFragment.f30810a.size() >= 8) {
                            viewHolder2.g.setChecked(false);
                            AppMethods.d((int) R.string.only_9_invite);
                            return;
                        }
                        if (!StringUtils.d(GroupUserInviteAdapter.this.d)) {
                            GroupMemberInviteFragment.f30810a.add(GroupUserInviteAdapter.this.d);
                            GroupMemberInviteFragment.b.add(GroupUserInviteAdapter.this.e);
                            GroupMemberInviteFragment.f30811c.add(GroupUserInviteAdapter.this.f);
                            GroupMemberInviteFragment.d.add(Integer.valueOf(GroupUserInviteAdapter.this.g));
                            GroupMemberInviteFragment.e.add((short) 2);
                        }
                        bluedUserInviteList.isCheckedFlag = true;
                    }
                });
            }
        });
        viewHolder.g.setChecked(bluedUserInviteList.isCheckedFlag);
        viewHolder.g.setEnabled(bluedUserInviteList.isEnabledFlag);
        final ViewHolder viewHolder3 = viewHolder;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupUserInviteAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                UserInfoFragmentNew.a(GroupUserInviteAdapter.this.f30939a, bluedUserInviteList, "", viewHolder3.f30947a);
            }
        });
        UserInfoHelper.a(viewHolder.h, bluedUserInviteList.vbadge, 3);
        return view2;
    }
}
