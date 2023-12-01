package com.soft.blued.ui.live.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.group.GroupInviteFromChatListFragment;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/ShareWithContactAdapter.class */
public class ShareWithContactAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<SessionModel> f31106a;
    public List<SessionModel> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SessionModel> f31107c = new ArrayList();
    public List<SessionModel> d = new ArrayList();
    private LayoutInflater e;
    private Context f;
    private IRequestHost g;
    private String h;
    private int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/ShareWithContactAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        TextView f31113a;
        CheckBox b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f31114c;
        ImageView d;
        ImageView e;
        TextView f;
        LinearLayout g;

        private ViewHolder() {
        }
    }

    public ShareWithContactAdapter(IRequestHost iRequestHost, Context context, List<SessionModel> list, int i) {
        this.f31106a = new ArrayList();
        this.i = 1;
        this.f = context;
        this.g = iRequestHost;
        this.e = LayoutInflater.from(context);
        if (i > 1) {
            this.i = i;
        }
        this.f31106a = list;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f31106a.size()) {
                return;
            }
            this.b.add(this.f31106a.get(i3));
            this.f31107c.add(this.f31106a.get(i3));
            if (this.f31106a.get(i3).checked) {
                this.d.add(this.f31106a.get(i3));
            }
            i2 = i3 + 1;
        }
    }

    private String a(SessionModel sessionModel, SessionSettingModel sessionSettingModel) {
        String str = sessionModel.nickName;
        String sessinoNote = sessionSettingModel != null ? sessionSettingModel.getSessinoNote() : "";
        if (TextUtils.isEmpty(sessinoNote)) {
            if (TextUtils.isEmpty(str)) {
                return sessionModel.sessionId + "";
            }
            return str;
        }
        return sessinoNote;
    }

    private void a(SessionModel sessionModel, SessionSettingModel sessionSettingModel, ViewHolder viewHolder) {
        if (sessionModel == null) {
            return;
        }
        if (sessionModel.sessionType == 3 && sessionModel.lastMsgFromId != Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue() && MsgType.getClassify(sessionModel.lastMsgType) != 1) {
            TextUtils.isEmpty(sessionModel.lastMsgFromNickname + ":");
        }
        if (!TextUtils.isEmpty(sessionModel.lastMsgContent)) {
            if (MsgType.getClassify(sessionModel.lastMsgType) == 1 || sessionModel.lastMsgType == 8) {
                TextUtils.isEmpty(sessionModel.lastMsgContent);
            } else {
                short s = sessionModel.lastMsgType;
                if (s == 1) {
                    TextUtils.isEmpty(sessionModel.lastMsgContent);
                } else if (s != 3) {
                    if ((s == 9 || s == 10) && sessionModel.sessionType != 2) {
                        short s2 = sessionModel.sessionType;
                    }
                } else if (IMV4Method.a(sessionModel.lastMsgFromId) == 1) {
                    short s3 = sessionModel.lastMsgStateCode;
                }
            }
        }
        if (TimeAndDateUtils.f(sessionModel.lastMsgTime)) {
            this.h = TimeAndDateUtils.f10914c.get().format(new Date(sessionModel.lastMsgTime));
        } else {
            this.h = TimeAndDateUtils.d.get().format(new Date(sessionModel.lastMsgTime));
        }
        if (sessionSettingModel == null || sessionSettingModel.getRemindAudio() == 0) {
            viewHolder.e.setVisibility(8);
        } else {
            viewHolder.e.setVisibility(0);
        }
    }

    public void a(String str) {
        List<SessionModel> list = this.b;
        if (list != null && list.size() > 0) {
            this.f31107c.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    break;
                }
                SessionModel sessionModel = this.b.get(i2);
                if (a(sessionModel, (SessionSettingModel) sessionModel.sessionSettingModel).contains(str)) {
                    this.f31107c.add(this.b.get(i2));
                }
                i = i2 + 1;
            }
            this.f31106a.clear();
            if (TextUtils.isEmpty(str)) {
                this.f31106a.addAll(this.b);
            } else {
                this.f31106a.addAll(this.f31107c);
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f31106a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f31106a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.e.inflate(R.layout.item_share_with_contact, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.g = (LinearLayout) view.findViewById(R.id.ll_msg_f_root);
            viewHolder.f31114c = (ImageView) view.findViewById(R.id.msg_friend_item_avatar);
            viewHolder.d = (ImageView) view.findViewById(R.id.msg_friend_item_avatar_v);
            viewHolder.f = (TextView) view.findViewById(R.id.tv_group_icon);
            viewHolder.f31113a = (TextView) view.findViewById(R.id.msg_friend_item_name);
            viewHolder.b = (CheckBox) view.findViewById(R.id.cb_member_invite);
            viewHolder.e = (ImageView) view.findViewById(R.id.msg_group_remind_soundoff);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final SessionModel sessionModel = this.f31106a.get(i);
        List<SessionModel> list = this.f31106a;
        if (list != null && list.size() != 0) {
            if (i < this.f31106a.size() && sessionModel != null) {
                SessionSettingModel sessionSettingModel = (SessionSettingModel) sessionModel.sessionSettingModel;
                viewHolder.b.setChecked(false);
                viewHolder.b.setEnabled(true);
                short s = sessionModel.sessionType;
                if (s != 1) {
                    if (s == 2) {
                        ImageLoader.a(this.g, AvatarUtils.a(0, sessionModel.avatar)).b(2131237310).c().a(viewHolder.f31114c);
                        viewHolder.f.setVisibility(8);
                        viewHolder.f31113a.setText(a(sessionModel, sessionSettingModel));
                        UserInfoHelper.a(viewHolder.d, sessionModel.vBadge, 3);
                    } else if (s == 3) {
                        ImageLoader.a(this.g, sessionModel.avatar).b(R.drawable.group_default_head).c().a(viewHolder.f31114c);
                        viewHolder.f.setVisibility(0);
                        viewHolder.f31113a.setText(a(sessionModel, sessionSettingModel));
                        UserInfoHelper.a(viewHolder.d, sessionModel.vBadge, 3);
                        if (GroupInviteFromChatListFragment.f30800c != null && GroupInviteFromChatListFragment.f30800c.equals(String.valueOf(sessionModel.sessionId))) {
                            viewHolder.b.setChecked(true);
                            viewHolder.b.setEnabled(false);
                        }
                    }
                } else if (sessionModel.sessionId == 2) {
                    viewHolder.f31114c.setImageResource(R.drawable.msg_group_notify);
                    viewHolder.f.setVisibility(8);
                    viewHolder.f31113a.setText(this.f.getResources().getString(R.string.biao_v4_msg_groupnotice));
                    viewHolder.d.setVisibility(8);
                }
                a(sessionModel, sessionSettingModel, viewHolder);
                long j = sessionModel.sessionId;
                String str = sessionModel.nickName;
                String str2 = sessionModel.avatar;
                int i2 = sessionModel.vBadge;
                final short s2 = sessionModel.sessionType;
                if (this.i == 1) {
                    viewHolder.b.setVisibility(8);
                    LinearLayout linearLayout = viewHolder.g;
                    final String valueOf = String.valueOf(j);
                    linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.ShareWithContactAdapter.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Tracker.onClick(view2);
                            CommonAlertDialog.a(ShareWithContactAdapter.this.f, (View) null, ShareWithContactAdapter.this.f.getResources().getString(2131888879), ShareWithContactAdapter.this.f.getResources().getString(2131889191), (String) null, (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.ShareWithContactAdapter.1.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i3) {
                                    Tracker.onClick(dialogInterface, i3);
                                    Intent intent = new Intent();
                                    String str3 = valueOf;
                                    short s3 = s2;
                                    intent.putExtra("CHOOSED_UID", new String[]{str3});
                                    intent.putExtra("CHOOSED_TYPE", new String[]{String.valueOf((int) s3)});
                                    ((Activity) ShareWithContactAdapter.this.f).setResult(-1, intent);
                                    ((Activity) ShareWithContactAdapter.this.f).finish();
                                }
                            }, (DialogInterface.OnClickListener) null, (DialogInterface.OnCancelListener) null, true);
                        }
                    });
                    return view;
                }
                if (sessionModel.chooseable) {
                    viewHolder.b.setVisibility(0);
                } else {
                    viewHolder.b.setVisibility(4);
                }
                viewHolder.b.setChecked(sessionModel.checked);
                viewHolder.b.setClickable(false);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.ShareWithContactAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        if (!sessionModel.chooseable) {
                            AppMethods.a((CharSequence) ShareWithContactAdapter.this.f.getResources().getString(2131889190));
                            return;
                        }
                        if (sessionModel.checked) {
                            ShareWithContactAdapter.this.d.remove(sessionModel);
                            ShareWithContactAdapter.this.f31106a.get(i).checked = false;
                        } else {
                            ShareWithContactAdapter.this.d.add(sessionModel);
                            ShareWithContactAdapter.this.f31106a.get(i).checked = true;
                        }
                        if (ShareWithContactAdapter.this.d.size() >= ShareWithContactAdapter.this.i) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= ShareWithContactAdapter.this.f31106a.size()) {
                                    break;
                                }
                                SessionModel sessionModel2 = ShareWithContactAdapter.this.f31106a.get(i4);
                                if (ShareWithContactAdapter.this.d.contains(sessionModel2)) {
                                    sessionModel2.chooseable = true;
                                } else {
                                    sessionModel2.chooseable = false;
                                }
                                i3 = i4 + 1;
                            }
                        } else {
                            for (int i5 = 0; i5 < ShareWithContactAdapter.this.f31106a.size(); i5++) {
                                ShareWithContactAdapter.this.f31106a.get(i5).chooseable = true;
                            }
                        }
                        ShareWithContactAdapter.this.notifyDataSetChanged();
                    }
                });
            }
            return view;
        }
        return view;
    }
}
