package com.soft.blued.ui.msg_group.presenter;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.Contacts;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg_group.model.GroupApplyExtra;
import com.soft.blued.ui.msg_group.model.GroupApplyResp;
import com.soft.blued.ui.msg_group.pop.PopGroupHelpCreate;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.share.BluedShareUtils;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.utils.BluedPreferences;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/presenter/GroupInfoPresenter.class */
public class GroupInfoPresenter extends MvpPresenter implements FetchDataListener<SessionModel> {
    private boolean i;
    private GroupInfoModel j;
    private SessionModel k;
    private GroupApplyResp m;
    private int n;
    private String h = "";
    private SocialNetWorkProtos.SourceType l = SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, final boolean z) {
        CommonAlertDialog.a(h(), str, str2, AppUtils.a((int) R.string.group_buy_vip), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (z) {
                    EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_NEW_GUIDE_POP_BUY_CLICK);
                } else {
                    EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_OLD_GUIDE_POP_BUY_CLICK);
                }
                PayUtils.a(GroupInfoPresenter.this.h(), 0, "groups_expand_pop", 34, VipProtos.FromType.UNKNOWN_FROM);
            }
        }, AppUtils.a(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private void t() {
        SessionModel sessionModel = this.k;
        if (sessionModel != null) {
            a("switch_top", (String) Integer.valueOf(sessionModel.lieTop));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        SessionModel sessionModel;
        if (this.j == null || (sessionModel = this.k) == null || sessionModel.sessionSettingModel == null) {
            return;
        }
        SessionSettingModel sessionSettingModel = (SessionSettingModel) this.k.sessionSettingModel;
        sessionSettingModel.is_super = this.j.is_super;
        sessionSettingModel.group_status = this.j.group_status;
        sessionSettingModel.setGroupCreateId(this.j.group_uid);
        HashMap hashMap = new HashMap();
        hashMap.put("is_super", Integer.valueOf(sessionSettingModel.is_super));
        hashMap.put("groupCreateId", Long.valueOf(sessionSettingModel.getGroupCreateId()));
        hashMap.put("group_status", Integer.valueOf(sessionSettingModel.group_status));
        ChatManager.getInstance().updateSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_INVITE_TASK_DOING_POP_SHOW);
        SocialNetWorkProtos.Event event = SocialNetWorkProtos.Event.GROUP_JOIN_LIMIT_POP_SHOW;
        EventTrackGroup.a(event, this.j.group_id + "", SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE);
        XPopup.Builder d = new XPopup.Builder(h()).a(PopupAnimation.ScaleAlphaFromCenter).d((Boolean) true);
        Activity h = h();
        int i = this.n;
        d.a((BasePopupView) new PopGroupHelpCreate(h, i, this.j.group_id + "", this.m, g())).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        SessionSettingModel sessionSettingModel = new SessionSettingModel();
        sessionSettingModel.setLoadName(Long.parseLong(UserInfo.getInstance().getLoginUserInfo().getUid()));
        sessionSettingModel.setSessionId(this.j.group_id);
        sessionSettingModel.setSessionType((short) 3);
        sessionSettingModel.is_super = this.j.is_super;
        ChatManager.getInstance().setSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), sessionSettingModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        MsgGroupHttpUtils.b(g(), this.h, new BluedUIHttpResponse<BluedEntityA>(g()) { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    if (GroupInfoPresenter.this.j != null) {
                        BluedPreferences.q(GroupInfoPresenter.this.j.group_id);
                        LiveEventBus.get("exit_group", Integer.class).post(Integer.valueOf(GroupInfoPresenter.this.j.group_id));
                        ChatManager.getInstance().deleteSessionAndChatting((short) 3, GroupInfoPresenter.this.j.group_id);
                        GroupInfoPresenter.this.j.group_role = 0;
                        GroupInfoPresenter.this.j.group_now_population--;
                    }
                    GroupInfoPresenter.this.r();
                    GroupInfoPresenter.this.i();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        HashMap hashMap = new HashMap();
        hashMap.put("group_status", "3");
        IRequestHost g = g();
        MsgGroupHttpUtils.a(g, this.j.group_id + "", hashMap, new BluedUIHttpResponse<BluedEntityA>(g()) { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                GroupInfoPresenter.this.b(d.K, z);
                if (z) {
                    try {
                        if (GroupInfoPresenter.this.j != null) {
                            BluedPreferences.q(GroupInfoPresenter.this.j.group_id);
                            LiveEventBus.get("exit_group", Integer.class).post(Integer.valueOf(GroupInfoPresenter.this.j.group_id));
                            ChatManager.getInstance().deleteSessionAndChatting((short) 3, GroupInfoPresenter.this.j.group_id);
                            GroupInfoPresenter.this.j.group_status = 3;
                        }
                        LiveEventBus.get("common_group_dismiss", GroupInfoModel.class).post(GroupInfoPresenter.this.j);
                        GroupInfoPresenter.this.i();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                GroupInfoPresenter.this.d_(d.K);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.j != null) {
            SessionSettingModel sessionSettingModel = null;
            SessionModel sessionModel = this.k;
            if (sessionModel != null) {
                sessionSettingModel = (SessionSettingModel) sessionModel.sessionSettingModel;
            }
            int a2 = GroupUtil.a(this.j.message_is_mute, this.j.at_message_is_mute, this.j.notice_is_mute);
            if (sessionSettingModel != null) {
                sessionSettingModel.setRemindAudio(a2);
                HashMap hashMap = new HashMap();
                hashMap.put("remindAudio", Integer.valueOf(a2));
                ChatManager.getInstance().updateSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), hashMap);
                return;
            }
            SessionSettingModel sessionSettingModel2 = new SessionSettingModel();
            sessionSettingModel2.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
            sessionSettingModel2.setSessionId(Long.valueOf(this.j.group_id).longValue());
            sessionSettingModel2.setSessionType((short) 3);
            sessionSettingModel2.setRemindAudio(a2);
            ChatManager.getInstance().setSessionSetting(sessionSettingModel2.getSessionType(), sessionSettingModel2.getSessionId(), sessionSettingModel2);
        }
    }

    public void a(ImageView imageView) {
        SessionModel sessionModel = this.k;
        if (sessionModel != null) {
            GroupUtil.a(sessionModel, imageView, g());
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            this.h = bundle.getString(Contacts.GroupMembership.GROUP_ID);
            if (bundle.containsKey("page_from")) {
                this.l = (SocialNetWorkProtos.SourceType) bundle.getSerializable("page_from");
            }
            if (!TextUtils.isEmpty(this.h)) {
                EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_PROFILE_SHOW, this.h, this.l);
            }
            GroupInfoModel groupInfoModel = (GroupInfoModel) bundle.getSerializable(d.K);
            this.j = groupInfoModel;
            if (groupInfoModel != null) {
                if (groupInfoModel.group_id != 0) {
                    this.h = this.j.group_id + "";
                }
                a(d.K, (String) this.j);
            }
            SessionModel snapSessionModel = ChatManager.getInstance().getSnapSessionModel((short) 3, Long.valueOf(this.h).longValue());
            this.k = snapSessionModel;
            if (snapSessionModel == null) {
                ChatManager.getInstance().getSessionModel((short) 3, Long.valueOf(this.h).longValue(), this);
            } else {
                t();
            }
        }
    }

    @Override // com.blued.android.chat.listener.FetchDataListener
    /* renamed from: a */
    public void onFetchData(SessionModel sessionModel) {
        this.k = sessionModel;
        t();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        MsgGroupHttpUtils.a(g(), this.h, new BluedUIHttpResponse<BluedEntityA<GroupInfoModel>>(g()) { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GroupInfoModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    GroupInfoPresenter.this.j = bluedEntityA.data.get(0);
                    GroupInfoPresenter.this.z();
                    GroupInfoPresenter.this.u();
                    GroupInfoPresenter groupInfoPresenter = GroupInfoPresenter.this;
                    groupInfoPresenter.a(d.K, (String) groupInfoPresenter.j);
                    if (GroupInfoPresenter.this.i) {
                        GroupInfoPresenter.this.r();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 40319010 || i == 40319059) {
                    GroupInfoPresenter.this.i();
                }
                return super.onUIFailure(i, str);
            }
        });
    }

    public void a(String str, int i) {
        if (this.j == null) {
            return;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(str, i + "");
        if ("message_is_mute".equals(str) && i == 2) {
            hashMap.put("at_message_is_mute", "2");
        }
        IRequestHost g = g();
        MsgGroupHttpUtils.a(g, this.j.group_id + "", hashMap, new BluedUIHttpResponse<BluedEntityA>(g()) { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                GroupInfoPresenter.this.b(d.K, z);
                if (z) {
                    try {
                        if (GroupInfoPresenter.this.j == null) {
                            return;
                        }
                        for (Map.Entry entry : hashMap.entrySet()) {
                            GroupUtil.a(GroupInfoPresenter.this.j, (String) entry.getKey(), Integer.valueOf((String) entry.getValue()));
                        }
                        GroupInfoPresenter.this.z();
                        GroupInfoPresenter.this.a("switch", (String) GroupInfoPresenter.this.j);
                        GroupInfoPresenter.this.r();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                GroupInfoPresenter.this.d_(d.K);
            }
        });
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void b(final ImageView imageView) {
        if (!GroupUtil.f32829c) {
            ToastUtils.a(imageView.getContext().getString(R.string.group_disable_share));
        } else if (this.j != null) {
            final BluedGroupLists bluedGroupLists = new BluedGroupLists();
            bluedGroupLists.groups_gid = this.j.group_id + "";
            bluedGroupLists.groups_is_admins = this.j.group_role + "";
            bluedGroupLists.groups_is_created = this.j.group_role + "";
            bluedGroupLists.groups_name = this.j.group_title;
            bluedGroupLists.groups_description = this.j.group_desc;
            bluedGroupLists.groups_avatar = this.j.group_cover;
            bluedGroupLists.groups_city = AreaUtils.getAreaTxt(this.j.city, BlueAppLocal.c());
            final String b = BluedHttpUrl.b(this.h);
            final String format = String.format(h().getString(R.string.group_share_title), this.j.group_title);
            final String string = h().getString(R.string.group_share_content);
            ImageFileLoader.a(g()).a(bluedGroupLists.groups_avatar).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.11
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public void onUIFinish(File file, Exception exc) {
                    Bitmap decodeFile = (file == null || !file.exists()) ? null : BitmapFactory.decodeFile(file.getPath());
                    BluedShareUtils b2 = BluedShareUtils.b();
                    Activity h = GroupInfoPresenter.this.h();
                    String str = bluedGroupLists.groups_avatar;
                    ImageView imageView2 = imageView;
                    String str2 = b;
                    String str3 = format;
                    String str4 = string;
                    b2.a(h, 0, str, imageView2, decodeFile, str2, str3, str4, str4, 0, bluedGroupLists);
                }
            }).a();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void d(String str) {
        if (this.j == null) {
            return;
        }
        MsgGroupHttpUtils.b(g(), this.h, str, this.j.allow_join, new BluedUIHttpResponse<BluedEntity<GroupApplyResp, GroupApplyExtra>>(g()) { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                if (i == 40319016) {
                    GroupInfoPresenter.this.e();
                } else if (i == 40319017) {
                    GroupUtil.a(GroupInfoPresenter.this.h(), AppUtils.a((int) R.string.group_notice_title), AppUtils.a((int) R.string.group_not_fans), (DialogInterface.OnClickListener) null);
                    return true;
                } else if (i == 40319018) {
                    GroupUtil.a(GroupInfoPresenter.this.h(), AppUtils.a((int) R.string.group_notice_title), AppUtils.a((int) R.string.group_not_circle_member), (DialogInterface.OnClickListener) null);
                    return true;
                } else if (i == 40319055) {
                    GroupUtil.a(GroupInfoPresenter.this.h(), AppUtils.a((int) R.string.group_add_limit), str2, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.2.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Tracker.onClick(dialogInterface, i2);
                            EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_UP_LIMITE_POP_YES_CLICK);
                        }
                    });
                    EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_UP_LIMITE_POP_SHOW);
                    return true;
                } else if (i == 40319056) {
                    GroupInfoPresenter.this.a(AppUtils.a((int) R.string.group_add_limit), str2, true);
                    EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_NEW_GUIDE_POP_SHOW);
                    return true;
                } else if (i == 40319057) {
                    GroupInfoPresenter.this.a(AppUtils.a((int) R.string.group_add_limit), str2, false);
                    EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_OLD_GUIDE_POP_SHOW);
                    return true;
                }
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                GroupInfoPresenter.this.b("addGroup", z);
                if (GroupInfoPresenter.this.m != null && GroupInfoPresenter.this.j != null) {
                    if (GroupInfoPresenter.this.n == 1 || (GroupInfoPresenter.this.m.getUsers() != null && GroupInfoPresenter.this.m.getUsers().size() > 0)) {
                        GroupInfoPresenter.this.v();
                    } else {
                        GroupInfoPresenter.this.p();
                    }
                } else if (!z || GroupInfoPresenter.this.j == null) {
                } else {
                    if (GroupInfoPresenter.this.j.is_super == 1) {
                        GroupInfoPresenter.this.w();
                    }
                    if (GroupInfoPresenter.this.j.allow_join == 2) {
                        GroupInfoPresenter.this.j.apply_status = 1;
                        GroupInfoPresenter.this.f_("apply_succeed");
                    } else {
                        GroupInfoPresenter.this.j.group_now_population++;
                        GroupInfoPresenter.this.j.group_role = 3;
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                GroupInfoPresenter.this.s();
                            }
                        }, 200L);
                    }
                    GroupInfoPresenter.this.r();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                GroupInfoPresenter.this.d_("addGroup");
                GroupInfoPresenter.this.m = null;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<GroupApplyResp, GroupApplyExtra> bluedEntity) {
                if (bluedEntity.hasData()) {
                    GroupInfoPresenter.this.m = bluedEntity.data.get(0);
                }
                if (bluedEntity.extra != null) {
                    GroupInfoPresenter.this.n = bluedEntity.extra.getVip();
                }
            }
        });
    }

    public void e(String str) {
        GroupInfoModel groupInfoModel = this.j;
        if (groupInfoModel != null) {
            GroupUtil.a(str, groupInfoModel.group_id, g());
        }
    }

    public GroupInfoModel m() {
        return this.j;
    }

    public SessionModel n() {
        return this.k;
    }

    public SocialNetWorkProtos.SourceType o() {
        return this.l;
    }

    public void p() {
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_INVITE_TASK_TRIGGER_POP_SHOW);
        BluedAlertDialog a2 = CommonAlertDialog.a(h(), 0, AppUtils.a((int) R.string.group_add_limit), AppUtils.a((int) R.string.group_add_limit_help), null, AppUtils.a(this.n == 2 ? 2131888277 : 2131888276), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_INVITE_TASK_TRIGGER_POP_BUY_CLICK);
                PayUtils.a(GroupInfoPresenter.this.h(), 0, "groups_task_trigger", 34, VipProtos.FromType.UNKNOWN_FROM);
            }
        }, AppUtils.a((int) R.string.group_add_limit_invite), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (GroupInfoPresenter.this.m == null) {
                    return;
                }
                PopGroupHelpCreate.f32798c.a(GroupInfoPresenter.this.h(), GroupInfoPresenter.this.m.getCode(), GroupInfoPresenter.this.h);
            }
        }, null, true, 1, 0, true, false);
        if (this.n == 1) {
            a2.d().setVisibility(8);
            return;
        }
        a2.d().setBackgroundResource(2131236234);
        a2.d().setTextColor(ContextCompat.getColor(h(), 2131102254));
    }

    public void q() {
        String string;
        String string2;
        Activity h;
        int i;
        Activity h2;
        int i2;
        Activity h3;
        int i3;
        GroupInfoModel groupInfoModel = this.j;
        if (groupInfoModel == null) {
            return;
        }
        if (groupInfoModel.type != 4) {
            if (this.j.group_role == 1) {
                h2 = h();
                i2 = 2131886822;
            } else {
                h2 = h();
                i2 = 2131888555;
            }
            String string3 = h2.getString(i2);
            if (this.j.group_role == 1) {
                h3 = h();
                i3 = 2131888367;
            } else {
                h3 = h();
                i3 = 2131888386;
            }
            string = string3;
            string2 = h3.getString(i3);
        } else {
            string = h().getString(R.string.group_event_exit_dialog_hint_title);
            string2 = h().getString(R.string.group_event_exit_dialog_hint);
        }
        if (this.j.group_role == 1) {
            h = h();
            i = 2131887320;
        } else {
            h = h();
            i = 2131887281;
        }
        CommonAlertDialog.a(h(), string, string2, h.getString(i), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                Tracker.onClick(dialogInterface, i4);
                if (GroupInfoPresenter.this.j.group_role == 1) {
                    GroupInfoPresenter.this.y();
                } else if (GroupInfoPresenter.this.j.group_role == 2 || GroupInfoPresenter.this.j.group_role == 3) {
                    GroupInfoPresenter.this.x();
                }
            }
        }, h().getResources().getString(2131887258), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                Tracker.onClick(dialogInterface, i4);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    public void r() {
        LiveEventBus.get("common_refresh_circle_group", GroupInfoModel.class).post(this.j);
    }

    public void s() {
        if (this.j == null) {
            return;
        }
        LogData logData = new LogData();
        logData.from = d.K;
        ChatHelperV4.a().a(h(), Long.valueOf(this.j.group_id).longValue(), this.j.group_title, this.j.group_cover, 0, 0, 0, 0, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
    }
}
