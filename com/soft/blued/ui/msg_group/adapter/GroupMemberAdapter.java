package com.soft.blued.ui.msg_group.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.group.GroupMemberModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.ui.find.adapter.RecommendListAdapter;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/adapter/GroupMemberAdapter.class */
public class GroupMemberAdapter extends RecommendListAdapter<GroupMemberModel> {
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f32633c;
    public int d;

    public GroupMemberAdapter(Context context, int i, int i2, IRequestHost iRequestHost) {
        super(context, i, iRequestHost);
        this.f32633c = new HashSet();
        this.d = 3;
        this.d = i2;
    }

    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f30116a.size()) {
                this.f32633c.clear();
                this.b = false;
                notifyDataSetChanged();
                return;
            }
            int i3 = i2;
            if (this.f32633c.contains(((GroupMemberModel) this.f30116a.get(i2)).uid)) {
                this.f30116a.remove(i2);
                i3 = i2 - 1;
            }
            i = i3 + 1;
        }
    }

    @Override // com.soft.blued.ui.find.adapter.RecommendListAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final View view2 = super.getView(i, view, viewGroup);
        final RecommendListAdapter.ViewHolder viewHolder = (RecommendListAdapter.ViewHolder) view2.getTag();
        final GroupMemberModel groupMemberModel = (GroupMemberModel) this.f30116a.get(i);
        GroupUtil.a(viewHolder.n, groupMemberModel.group_role);
        viewHolder.p.setVisibility(8);
        if (this.b) {
            viewHolder.o.setSelected(this.f32633c.contains(groupMemberModel.uid));
            viewHolder.o.setVisibility(0);
            if ((this.d == 2 && groupMemberModel.group_role == 2) || groupMemberModel.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid) || groupMemberModel.group_role == 1) {
                viewHolder.o.setVisibility(4);
            } else {
                viewHolder.o.setVisibility(0);
            }
            viewHolder.o.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupMemberAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    if (viewHolder.o.isSelected()) {
                        GroupMemberAdapter.this.f32633c.remove(groupMemberModel.uid);
                        viewHolder.o.setSelected(false);
                        return;
                    }
                    GroupMemberAdapter.this.f32633c.add(groupMemberModel.uid);
                    viewHolder.o.setSelected(true);
                }
            });
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupMemberAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    viewHolder.o.performClick();
                }
            });
            viewHolder.f30124a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupMemberAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    UserInfoFragmentNew.a(view2.getContext(), groupMemberModel, "group_chatting", viewHolder.f30124a, (LogData) null, new MsgSourceEntity(MessageProtos.StrangerSource.GROUP_CHAT, ""));
                }
            });
        } else {
            viewHolder.o.setSelected(false);
            viewHolder.o.setVisibility(8);
        }
        view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupMemberAdapter.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view3) {
                LiveEventBus.get("delete_member", GroupMemberModel.class).post(groupMemberModel);
                return true;
            }
        });
        return view2;
    }
}
