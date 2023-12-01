package com.soft.blued.ui.group.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.group.GroupMembersListFragment;
import com.soft.blued.ui.group.model.BluedGroupAllMembers;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupMemberListAdapter.class */
public class GroupMemberListAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f30909a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private Context f30910c;
    private List<BluedGroupAllMembers> d;
    private LoadOptions e;
    private String f;
    private String g;
    private TextView h;
    private TextView i;
    private IRequestHost j;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupMemberListAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        LinearLayout f30918a;
        ImageView b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f30919c;
        TextView d;
        TextView e;
        TextView f;
        TextView g;
        TextView h;
        CheckBox i;
        ImageView j;

        private ViewHolder() {
        }
    }

    public GroupMemberListAdapter(Context context, IRequestHost iRequestHost, List<BluedGroupAllMembers> list, TextView textView, TextView textView2) {
        this.f30910c = context;
        this.j = iRequestHost;
        this.d = list;
        this.b = LayoutInflater.from(context);
        LoadOptions loadOptions = new LoadOptions();
        this.e = loadOptions;
        this.h = textView;
        this.i = textView2;
        loadOptions.d = 2131237310;
        this.e.b = 2131237310;
    }

    public void a() {
        this.d.clear();
        notifyDataSetChanged();
    }

    public void a(List<BluedGroupAllMembers> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.d.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        final BluedGroupAllMembers bluedGroupAllMembers = this.d.get(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.b.inflate(R.layout.item_group_member_show, (ViewGroup) null);
            viewHolder.f30918a = (LinearLayout) view2.findViewById(R.id.ll_group_member_list_item);
            viewHolder.b = (ImageView) view2.findViewById(2131366011);
            viewHolder.f30919c = (ImageView) view2.findViewById(R.id.member_img_verify);
            viewHolder.d = (TextView) view2.findViewById(2131372879);
            viewHolder.e = (TextView) view2.findViewById(R.id.tv_group_user_details);
            viewHolder.f = (TextView) view2.findViewById(R.id.tv_user_distance);
            viewHolder.g = (TextView) view2.findViewById(R.id.tv_last_activate_time);
            viewHolder.h = (TextView) view2.findViewById(R.id.tv_group_member_role_show);
            viewHolder.i = (CheckBox) view2.findViewById(R.id.cb_member_remove);
            viewHolder.j = (ImageView) view2.findViewById(2131364726);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        UserRelationshipUtils.a(viewHolder.j, bluedGroupAllMembers);
        viewHolder.f30918a.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.group.adapter.GroupMemberListAdapter.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                View currentFocus = ((Activity) GroupMemberListAdapter.this.f30910c).getCurrentFocus();
                if (currentFocus != null) {
                    currentFocus.clearFocus();
                    return false;
                }
                return false;
            }
        });
        final ViewHolder viewHolder2 = viewHolder;
        viewHolder.f30918a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupMemberListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                UserInfoFragmentNew.a(GroupMemberListAdapter.this.f30910c, bluedGroupAllMembers, "", viewHolder2.b);
            }
        });
        if (GroupMembersListFragment.j.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= GroupMembersListFragment.j.size()) {
                    break;
                }
                if (GroupMembersListFragment.j.get(i3).equals(bluedGroupAllMembers.uid)) {
                    bluedGroupAllMembers.isCheckedFlag = true;
                    bluedGroupAllMembers.isEnabledFlag = true;
                }
                i2 = i3 + 1;
            }
        }
        if (this.f30909a) {
            viewHolder.i.setVisibility(0);
        } else {
            viewHolder.i.setVisibility(8);
        }
        viewHolder.h.setVisibility(8);
        ImageLoader.a(this.j, bluedGroupAllMembers.avatar).b(2131237310).c().a(viewHolder.b);
        UserInfoHelper.a(viewHolder.f30919c, bluedGroupAllMembers.vbadge, 3);
        if (!StringUtils.d(bluedGroupAllMembers.note)) {
            viewHolder.d.setText(bluedGroupAllMembers.note);
        } else if (StringUtils.d(bluedGroupAllMembers.name)) {
            viewHolder.d.setVisibility(4);
        } else {
            viewHolder.d.setText(bluedGroupAllMembers.name);
        }
        UserRelationshipUtils.a(this.f30910c, viewHolder.d, bluedGroupAllMembers);
        if (StringUtils.d(bluedGroupAllMembers.distance)) {
            viewHolder.f.setVisibility(4);
        } else {
            viewHolder.f.setText(DistanceUtils.a(bluedGroupAllMembers.distance, BlueAppLocal.c(), false));
        }
        DistanceUtils.a(this.f30910c, viewHolder.f, bluedGroupAllMembers, 1);
        if (StringUtils.d(bluedGroupAllMembers.last_active_time)) {
            viewHolder.g.setText("");
        } else {
            viewHolder.g.setText(TimeAndDateUtils.g(this.f30910c, TimeAndDateUtils.c(bluedGroupAllMembers.last_active_time)));
        }
        TextView textView = viewHolder.e;
        textView.setText(bluedGroupAllMembers.age + " / " + bluedGroupAllMembers.height + " / " + bluedGroupAllMembers.weight + " " + this.f30910c.getResources().getString(2131891624) + " " + UserInfoHelper.a(this.f30910c, bluedGroupAllMembers.role));
        if (!StringUtils.d(bluedGroupAllMembers.is_creator) && "1".equals(bluedGroupAllMembers.is_creator)) {
            if (this.f30909a) {
                viewHolder.i.setVisibility(4);
            }
            viewHolder.h.setVisibility(0);
            viewHolder.h.setBackgroundResource(R.drawable.shape_common_round_yellow_solid);
            viewHolder.h.setText(this.f30910c.getResources().getString(R.string.group_member_role));
        }
        if (!StringUtils.d(bluedGroupAllMembers.is_admin) && "1".equals(bluedGroupAllMembers.is_admin)) {
            if (this.f30909a) {
                if (GroupMembersListFragment.q.equals("1")) {
                    viewHolder.i.setVisibility(0);
                } else {
                    viewHolder.i.setVisibility(4);
                }
            }
            viewHolder.h.setVisibility(0);
            viewHolder.h.setBackgroundResource(R.drawable.shape_common_round_blue_solid_6px_corner);
            viewHolder.h.setText(this.f30910c.getResources().getString(R.string.group_admin_show));
        }
        final ViewHolder viewHolder3 = viewHolder;
        viewHolder.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.group.adapter.GroupMemberListAdapter.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                if (z) {
                    viewHolder3.i.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupMemberListAdapter.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            Tracker.onClick(view3);
                            bluedGroupAllMembers.isCheckedFlag = true;
                            GroupMemberListAdapter.this.f = bluedGroupAllMembers.uid;
                            if (StringUtils.d(GroupMemberListAdapter.this.f)) {
                                return;
                            }
                            GroupMembersListFragment.j.add(GroupMemberListAdapter.this.f);
                            if (GroupMembersListFragment.j.size() > 0) {
                                GroupMemberListAdapter.this.i.setText(GroupMemberListAdapter.this.f30910c.getResources().getString(2131887320));
                            } else {
                                GroupMemberListAdapter.this.i.setText(GroupMemberListAdapter.this.f30910c.getResources().getString(2131886885));
                            }
                            TextView textView2 = GroupMemberListAdapter.this.h;
                            textView2.setText(" (" + GroupMembersListFragment.j.size() + BridgeUtil.SPLIT_MARK + GroupMembersListFragment.n + ") ");
                        }
                    });
                } else {
                    viewHolder3.i.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupMemberListAdapter.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            Tracker.onClick(view3);
                            bluedGroupAllMembers.isCheckedFlag = false;
                            GroupMemberListAdapter.this.g = bluedGroupAllMembers.uid;
                            if (GroupMembersListFragment.j != null) {
                                for (int i4 = 0; i4 < GroupMembersListFragment.j.size(); i4++) {
                                    if (GroupMembersListFragment.j.get(i4).equals(GroupMemberListAdapter.this.g)) {
                                        GroupMembersListFragment.j.remove(GroupMembersListFragment.j.get(i4));
                                        if (GroupMembersListFragment.j.size() > 0) {
                                            GroupMemberListAdapter.this.i.setText(GroupMemberListAdapter.this.f30910c.getResources().getString(2131887320));
                                        } else {
                                            GroupMemberListAdapter.this.i.setText(GroupMemberListAdapter.this.f30910c.getResources().getString(2131886885));
                                        }
                                        GroupMemberListAdapter.this.h.setText(" (" + GroupMembersListFragment.j.size() + BridgeUtil.SPLIT_MARK + GroupMembersListFragment.n + ") ");
                                    }
                                }
                            }
                        }
                    });
                }
            }
        });
        viewHolder.i.setChecked(bluedGroupAllMembers.isCheckedFlag);
        return view2;
    }
}
