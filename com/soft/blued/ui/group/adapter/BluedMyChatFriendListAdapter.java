package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.group.GroupInviteFromChatListFragment;
import com.soft.blued.ui.group.GroupMemberInviteFragment;
import com.soft.blued.ui.msg.adapter.ChatFriendListAdapter;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.Date;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/BluedMyChatFriendListAdapter.class */
public class BluedMyChatFriendListAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f30882a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private GroupInviteFromChatListFragment f30883c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/BluedMyChatFriendListAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        TextView f30888a;
        View b;

        /* renamed from: c  reason: collision with root package name */
        TextView f30889c;
        ImageView d;
        CheckBox e;
        ImageView f;
        ImageView g;
        View h;
        TextView i;
        ImageView j;

        private ViewHolder() {
        }
    }

    private void a(SessionModel sessionModel, SessionSettingModel sessionSettingModel, TextView textView) {
        String str = sessionModel.nickName;
        String sessinoNote = sessionSettingModel != null ? sessionSettingModel.getSessinoNote() : "";
        if (!TextUtils.isEmpty(sessinoNote)) {
            textView.setText(sessinoNote);
        } else if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText(sessionModel.sessionId + "");
        }
    }

    private void a(SessionModel sessionModel, SessionSettingModel sessionSettingModel, ViewHolder viewHolder) {
        if (sessionModel == null) {
            return;
        }
        String str = "";
        if (sessionModel.sessionType == 3) {
            str = "";
            if (sessionModel.lastMsgFromId != Long.parseLong(UserInfo.getInstance().getLoginUserInfo().getUid())) {
                str = "";
                if (MsgType.getClassify(sessionModel.lastMsgType) != 1) {
                    str = sessionModel.lastMsgFromNickname + ":";
                    if (StringUtils.d(str)) {
                        str = "";
                    }
                }
            }
        }
        viewHolder.f30889c.setTextColor(this.b.getResources().getColor(2131100365));
        ChatFriendListAdapter.a(this.b, viewHolder.b, viewHolder.f30889c, sessionModel, str);
        if (TimeAndDateUtils.f(sessionModel.lastMsgTime)) {
            this.d = TimeAndDateUtils.f10914c.get().format(new Date(sessionModel.lastMsgTime));
        } else {
            this.d = TimeAndDateUtils.d.get().format(new Date(sessionModel.lastMsgTime));
        }
        if (sessionSettingModel == null || sessionSettingModel.getRemindAudio() == 0) {
            viewHolder.h.setVisibility(8);
        } else {
            viewHolder.h.setVisibility(0);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f30883c.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f30883c.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        SessionModel sessionModel;
        ActivityFragmentActive activityFragmentActive = null;
        if (view == null) {
            view = this.f30882a.inflate(R.layout.item_invite_from_msg_friend_list, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.f = (ImageView) view.findViewById(R.id.msg_friend_item_avatar);
            viewHolder.g = (ImageView) view.findViewById(R.id.msg_friend_item_avatar_v);
            viewHolder.i = (TextView) view.findViewById(R.id.tv_group_icon);
            viewHolder.f30888a = (TextView) view.findViewById(R.id.msg_friend_item_name);
            viewHolder.e = (CheckBox) view.findViewById(R.id.cb_member_invite);
            viewHolder.b = view.findViewById(R.id.lay_secret);
            viewHolder.f30889c = (TextView) view.findViewById(R.id.msg_friend_item_content);
            viewHolder.d = (ImageView) view.findViewById(R.id.msg_friend_item_status);
            viewHolder.h = view.findViewById(R.id.msg_group_remind_soundoff);
            viewHolder.j = (ImageView) view.findViewById(2131364726);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (this.f30883c.b != null && this.f30883c.b.size() != 0) {
            if (i < this.f30883c.b.size() && (sessionModel = this.f30883c.b.get(i)) != null) {
                SessionSettingModel sessionSettingModel = (SessionSettingModel) sessionModel.sessionSettingModel;
                if (sessionModel.lastMsgStateCode == 7) {
                    viewHolder.d.setImageResource(R.drawable.chat_fail_resend);
                    viewHolder.d.setVisibility(0);
                } else if (sessionModel.lastMsgStateCode == 1) {
                    viewHolder.d.setImageResource(R.drawable.icon_msg_sending);
                    viewHolder.d.setVisibility(0);
                } else if (sessionModel.lastMsgStateCode == 6) {
                    viewHolder.d.setImageResource(R.drawable.chat_fail_resend);
                    viewHolder.d.setVisibility(0);
                } else {
                    viewHolder.d.setVisibility(8);
                }
                viewHolder.e.setChecked(false);
                viewHolder.e.setEnabled(true);
                viewHolder.j.setVisibility(8);
                short s = sessionModel.sessionType;
                if (s != 1) {
                    if (s == 2) {
                        GroupInviteFromChatListFragment groupInviteFromChatListFragment = this.f30883c;
                        ImageLoader.a(groupInviteFromChatListFragment == null ? null : groupInviteFromChatListFragment.getFragmentActive(), AvatarUtils.a(0, sessionModel.avatar)).b(2131237310).c().a(viewHolder.f);
                        viewHolder.i.setVisibility(8);
                        a(sessionModel, sessionSettingModel, viewHolder.f30888a);
                        UserBasicModel userBasicModel = new UserBasicModel();
                        userBasicModel.vip_grade = sessionModel.vipGrade;
                        userBasicModel.is_vip_annual = sessionModel.vipAnnual;
                        userBasicModel.is_hide_vip_look = sessionModel.hideVipLook;
                        userBasicModel.vip_exp_lvl = sessionModel.vipExpLvl;
                        UserRelationshipUtils.a(viewHolder.j, userBasicModel);
                        UserRelationshipUtils.a(this.b, viewHolder.f30888a, userBasicModel);
                        UserInfoHelper.a(viewHolder.g, sessionModel.vBadge, 3);
                    } else if (s == 3) {
                        GroupInviteFromChatListFragment groupInviteFromChatListFragment2 = this.f30883c;
                        if (groupInviteFromChatListFragment2 != null) {
                            activityFragmentActive = groupInviteFromChatListFragment2.getFragmentActive();
                        }
                        ImageLoader.a(activityFragmentActive, sessionModel.avatar).b(R.drawable.group_default_head).c().a(viewHolder.f);
                        viewHolder.i.setVisibility(0);
                        a(sessionModel, sessionSettingModel, viewHolder.f30888a);
                        UserInfoHelper.a(viewHolder.g, sessionModel.vBadge, 3);
                        if (GroupInviteFromChatListFragment.f30800c != null && GroupInviteFromChatListFragment.f30800c.equals(String.valueOf(sessionModel.sessionId))) {
                            viewHolder.e.setChecked(true);
                            viewHolder.e.setEnabled(false);
                        }
                    }
                } else if (sessionModel.sessionId == 2) {
                    viewHolder.f.setImageResource(R.drawable.msg_group_notify);
                    viewHolder.i.setVisibility(8);
                    viewHolder.f30888a.setText(this.b.getResources().getString(R.string.biao_v4_msg_groupnotice));
                    viewHolder.g.setVisibility(8);
                }
                a(sessionModel, sessionSettingModel, viewHolder);
                final String valueOf = String.valueOf(sessionModel.sessionId);
                final String str = sessionModel.nickName;
                final String str2 = sessionModel.avatar;
                final int i2 = sessionModel.vBadge;
                final short s2 = sessionModel.sessionType;
                if (GroupMemberInviteFragment.f30810a.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= GroupMemberInviteFragment.f30810a.size()) {
                            break;
                        }
                        if (GroupMemberInviteFragment.f30810a.get(i4).equals(valueOf) && s2 == GroupMemberInviteFragment.e.get(i4).shortValue()) {
                            viewHolder.e.setChecked(true);
                            viewHolder.e.setEnabled(true);
                        }
                        i3 = i4 + 1;
                    }
                }
                if (GroupMemberInviteFragment.g.size() > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= GroupMemberInviteFragment.g.size()) {
                            break;
                        }
                        if (!StringUtils.d(valueOf) && !StringUtils.d(GroupMemberInviteFragment.g.get(i6)) && valueOf.equals(GroupMemberInviteFragment.g.get(i6))) {
                            viewHolder.e.setChecked(true);
                            viewHolder.e.setEnabled(false);
                        }
                        i5 = i6 + 1;
                    }
                }
                final ViewHolder viewHolder2 = viewHolder;
                viewHolder.e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.group.adapter.BluedMyChatFriendListAdapter.1
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        Tracker.onCheckedChanged(compoundButton, z);
                        if (z) {
                            viewHolder2.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.BluedMyChatFriendListAdapter.1.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    Tracker.onClick(view2);
                                    if (GroupMemberInviteFragment.f30810a.size() >= 8) {
                                        viewHolder2.e.setChecked(false);
                                        AppMethods.d((int) R.string.only_9_invite);
                                        return;
                                    }
                                    if (!StringUtils.d(valueOf)) {
                                        GroupMemberInviteFragment.e.add(Short.valueOf(s2));
                                        GroupMemberInviteFragment.f30810a.add(valueOf);
                                        GroupMemberInviteFragment.b.add(str);
                                        GroupMemberInviteFragment.f30811c.add(str2);
                                        GroupMemberInviteFragment.d.add(Integer.valueOf(i2));
                                    }
                                    viewHolder2.e.setChecked(true);
                                }
                            });
                        } else {
                            viewHolder2.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.BluedMyChatFriendListAdapter.1.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    Tracker.onClick(view2);
                                    if (GroupMemberInviteFragment.f30810a != null) {
                                        int i7 = 0;
                                        while (true) {
                                            int i8 = i7;
                                            if (i8 >= GroupMemberInviteFragment.f30810a.size()) {
                                                break;
                                            }
                                            if (GroupMemberInviteFragment.f30810a.get(i8).equals(valueOf)) {
                                                GroupMemberInviteFragment.f30810a.remove(GroupMemberInviteFragment.f30810a.get(i8));
                                                GroupMemberInviteFragment.b.remove(GroupMemberInviteFragment.b.get(i8));
                                                GroupMemberInviteFragment.f30811c.remove(GroupMemberInviteFragment.f30811c.get(i8));
                                                GroupMemberInviteFragment.d.remove(GroupMemberInviteFragment.d.get(i8));
                                                GroupMemberInviteFragment.e.remove(GroupMemberInviteFragment.e.get(i8));
                                            }
                                            i7 = i8 + 1;
                                        }
                                    }
                                    viewHolder2.e.setChecked(false);
                                }
                            });
                        }
                    }
                });
            }
            return view;
        }
        return view;
    }
}
