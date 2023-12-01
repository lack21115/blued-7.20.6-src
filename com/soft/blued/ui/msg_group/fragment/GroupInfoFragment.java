package com.soft.blued.ui.msg_group.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.group.GroupMemberModel;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.event.fragment.EventDetailsFragment;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.databinding.ViewGroupAuidtingBinding;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.ui.msg_group.adapter.GroupManagerAdapter;
import com.soft.blued.ui.msg_group.constant.GroupConstant;
import com.soft.blued.ui.msg_group.event.UpdateAnnouncementEvent;
import com.soft.blued.ui.msg_group.event.UpdateGroupGradeEvent;
import com.soft.blued.ui.msg_group.model.GroupPrivilegeModel;
import com.soft.blued.ui.msg_group.pop.ApplyGroupHintPop;
import com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.msg_group.viewmodel.GroupInfoVM;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.umeng.analytics.pro.d;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupInfoFragment.class */
public class GroupInfoFragment extends MvpKeyBoardFragment<GroupInfoPresenter> {
    public static final String k = GroupInfoFragment.class.getSimpleName();
    @BindView
    View apply_reason;
    @BindView
    EditText et_reason;
    @BindView
    ImageView group_identity_change;
    @BindView
    ImageView group_setting_at_mute;
    @BindView
    ImageView group_setting_mute;
    @BindView
    ImageView group_setting_mute_notify;
    @BindView
    ImageView group_setting_recommend;
    @BindView
    ImageView group_setting_top;
    @BindView
    ImageView group_setting_verify;
    @BindView
    ShapeTextView group_super_red_point;
    @BindView
    ImageView ivOnline;
    @BindView
    ImageView iv_arrow_right;
    @BindView
    ImageView iv_icon;
    @BindView
    ImageView iv_manager_setting;
    @BindView
    ImageView iv_user_avatar;
    private ImageView l;
    @BindView
    RecyclerView list_manager;
    @BindView
    ShapeLinearLayout ll_apply;
    @BindView
    LinearLayout ll_clear_msg;
    @BindView
    LinearLayout ll_exit;
    @BindView
    LinearLayout ll_freeze;
    @BindView
    KeyboardListenLinearLayout ll_keyboard;
    @BindView
    LinearLayout ll_owner_modify;
    @BindView
    LinearLayout ll_report;
    @BindView
    LinearLayout ll_setting;
    private View m;
    private GroupManagerAdapter n;
    private GroupInfoVM o;
    @BindView
    RelativeLayout rl_allow_recommend;
    @BindView
    RelativeLayout rl_announcement;
    @BindView
    RelativeLayout rl_category;
    @BindView
    RelativeLayout rl_change;
    @BindView
    RelativeLayout rl_description;
    @BindView
    RelativeLayout rl_et;
    @BindView
    RelativeLayout rl_group_link;
    @BindView
    RelativeLayout rl_setting_at_notify;
    @BindView
    RelativeLayout rl_super;
    @BindView
    RelativeLayout rl_verify;
    @BindView
    ScrollView scrollView;
    @BindView
    CommonTopTitleNoTrans title;
    @BindView
    TextView tvOnlineNum;
    @BindView
    ShapeTextView tv_add_group;
    @BindView
    TextView tv_announcement;
    @BindView
    ShapeTextView tv_apply;
    @BindView
    TextView tv_apply_hint;
    @BindView
    TextView tv_base_name;
    @BindView
    TextView tv_category;
    @BindView
    TextView tv_city;
    @BindView
    TextView tv_clear_msg;
    @BindView
    TextView tv_desc;
    @BindView
    TextView tv_dismiss_hint;
    @BindView
    TextView tv_exit;
    @BindView
    ShapeTextView tv_frozen;
    @BindView
    TextView tv_go_chat;
    @BindView
    TextView tv_group_name;
    @BindView
    TextView tv_group_super;
    @BindView
    ShapeTextView tv_group_type;
    @BindView
    TextView tv_hint_link;
    @BindView
    TextView tv_member_num;
    @BindView
    TextView tv_report;
    @BindView
    TextView tv_super;

    public static void a(Context context, String str, GroupInfoModel groupInfoModel, SocialNetWorkProtos.SourceType sourceType) {
        if (a(str, groupInfoModel)) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(Contacts.GroupMembership.GROUP_ID, str);
        }
        if (groupInfoModel != null) {
            bundle.putSerializable(d.K, groupInfoModel);
        }
        bundle.putSerializable("page_from", sourceType);
        TerminalActivity.d(context, GroupInfoFragment.class, bundle);
    }

    public static void a(Context context, String str, GroupInfoModel groupInfoModel, SocialNetWorkProtos.SourceType sourceType, boolean z) {
        if (a(str, groupInfoModel)) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(Contacts.GroupMembership.GROUP_ID, str);
        }
        if (groupInfoModel != null) {
            bundle.putSerializable(d.K, groupInfoModel);
        }
        bundle.putBoolean("addImmediately", z);
        bundle.putSerializable("page_from", sourceType);
        TerminalActivity.d(context, GroupInfoFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(GroupPrivilegeModel groupPrivilegeModel) {
        if (((GroupInfoPresenter) j()).m().is_super == 1) {
            CommonAlertDialog.a(getContext(), getString(R.string.group_degrade_dialog_title), String.format(getString(R.string.group_degrade_dialog_desc), groupPrivilegeModel.getNormal_group_max_admin() + ""), getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    dialogInterface.dismiss();
                    GroupInfoVM groupInfoVM = GroupInfoFragment.this.o;
                    groupInfoVM.b(((GroupInfoPresenter) GroupInfoFragment.this.j()).m().group_id + "");
                }
            }, getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    dialogInterface.dismiss();
                }
            }, (DialogInterface.OnDismissListener) null);
        } else if (groupPrivilegeModel.getPrivilege() != 1) {
            WebViewShowInfoFragment.show(getContext(), GroupConstant.f32663a + "group_up");
        } else {
            int super_max_group = groupPrivilegeModel.getSuper_max_group() - groupPrivilegeModel.getSuper_group();
            if (super_max_group <= 0) {
                CommonAlertDialog.a(getContext(), getString(R.string.group_upgrade_failed_dialog_title), String.format(getString(R.string.group_upgrade_failed_dialog_desc), groupPrivilegeModel.getSuper_group() + ""), getString(R.string.group_manager_super_group), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.13
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        dialogInterface.dismiss();
                        Context context = GroupInfoFragment.this.getContext();
                        WebViewShowInfoFragment.show(context, GroupConstant.f32663a + "group_up");
                    }
                }, getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.14
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        dialogInterface.dismiss();
                    }
                }, (DialogInterface.OnDismissListener) null);
                return;
            }
            CommonAlertDialog.a(getContext(), getString(R.string.group_upgrade_dialog_title), String.format(getString(R.string.group_upgrade_dialog_desc), super_max_group + "", groupPrivilegeModel.getSuper_max_population() + "", groupPrivilegeModel.getSuper_max_admin() + ""), getString(R.string.group_upgrade_dialog_ok), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.15
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    dialogInterface.dismiss();
                    GroupInfoVM groupInfoVM = GroupInfoFragment.this.o;
                    groupInfoVM.a(((GroupInfoPresenter) GroupInfoFragment.this.j()).m().group_id + "");
                }
            }, getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.16
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    dialogInterface.dismiss();
                }
            }, (DialogInterface.OnDismissListener) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<GroupMemberModel> list) {
        GroupManagerAdapter groupManagerAdapter = this.n;
        if (groupManagerAdapter != null) {
            groupManagerAdapter.setNewData(list);
            return;
        }
        GroupManagerAdapter groupManagerAdapter2 = new GroupManagerAdapter(list, getFragmentActive());
        this.n = groupManagerAdapter2;
        this.list_manager.setAdapter(groupManagerAdapter2);
        this.n.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.23
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                UserInfoFragmentNew.a(GroupInfoFragment.this.getContext(), ((GroupMemberModel) baseQuickAdapter.getData().get(i)).uid, "group_chatting");
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r3.group_id == 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r2, com.blued.android.module.common.group.GroupInfoModel r3) {
        /*
            r0 = r2
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r6
            if (r0 == 0) goto L1e
            r0 = r3
            if (r0 == 0) goto L1c
            r0 = r5
            r4 = r0
            r0 = r3
            int r0 = r0.group_id
            if (r0 != 0) goto L1e
        L1c:
            r0 = 1
            r4 = r0
        L1e:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.a(java.lang.String, com.blued.android.module.common.group.GroupInfoModel):boolean");
    }

    private void c(GroupInfoModel groupInfoModel) {
        if (groupInfoModel.type == 3) {
            if (groupInfoModel.is_super == 1) {
                this.tv_super.setVisibility(0);
                this.tv_group_super.setText(getString(R.string.group_degrade_member_cnt));
            } else {
                this.tv_group_super.setText(getString(R.string.group_upgrade_member_cnt));
            }
            if (BluedPreferences.eD()) {
                return;
            }
            this.group_super_red_point.setVisibility(0);
        }
    }

    private void d(final GroupInfoModel groupInfoModel) {
        this.rl_group_link.setVisibility(8);
        int i = groupInfoModel.type;
        if (i == 1) {
            if (groupInfoModel.circle != null) {
                this.rl_group_link.setVisibility(0);
                this.iv_user_avatar.setVisibility(8);
                this.tv_base_name.setVisibility(0);
                this.tv_base_name.setText(groupInfoModel.circle.title);
                this.tv_hint_link.setText(getString(R.string.group_type_circle_title));
                this.rl_group_link.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (!BluedConfig.a().K()) {
                            ToastUtils.a(GroupInfoFragment.this.getString(2131887260));
                            return;
                        }
                        Context context = GroupInfoFragment.this.getContext();
                        CircleDetailsFragment.a(context, groupInfoModel.circle.id + "", CircleConstants.CIRCLE_FROM_PAGE.GROUP);
                    }
                });
                return;
            }
            return;
        }
        if (i != 2) {
            if (i == 4) {
                if (groupInfoModel.event != null) {
                    this.rl_group_link.setVisibility(0);
                    this.iv_user_avatar.setVisibility(8);
                    this.tv_base_name.setVisibility(0);
                    this.tv_base_name.setText(groupInfoModel.event.name);
                    this.tv_hint_link.setText(getString(2131887728));
                    this.rl_group_link.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.22
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            EventLogData eventLogData = new EventLogData();
                            eventLogData.setEventId(groupInfoModel.event.id + "");
                            eventLogData.setSourcePage(FeedProtos.SourcePage.GROUP_ACTIVITY);
                            EventDetailsFragment.Companion companion = EventDetailsFragment.f19534a;
                            Context context = GroupInfoFragment.this.getContext();
                            companion.a(context, groupInfoModel.event.id + "", eventLogData);
                        }
                    });
                    return;
                }
                return;
            } else if (i != 5) {
                return;
            }
        }
        if (groupInfoModel.anchor != null) {
            this.rl_group_link.setVisibility(0);
            this.iv_user_avatar.setVisibility(0);
            this.tv_base_name.setVisibility(8);
            this.tv_hint_link.setText(groupInfoModel.anchor.name);
            GroupUtil.a((IRequestHost) getFragmentActive(), groupInfoModel.anchor.avatar, this.iv_user_avatar);
            this.rl_group_link.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    Context context = GroupInfoFragment.this.getContext();
                    UserInfoFragmentNew.a(context, groupInfoModel.anchor.uid + "", "group_chatting");
                }
            });
        }
    }

    private void w() {
        LiveEventBus.get("refresh_manager_list", GroupInfoModel.class).observe(this, new Observer<GroupInfoModel>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(GroupInfoModel groupInfoModel) {
                if (((GroupInfoPresenter) GroupInfoFragment.this.j()).m() == null || groupInfoModel == null || groupInfoModel.admin == null) {
                    return;
                }
                ((GroupInfoPresenter) GroupInfoFragment.this.j()).m().admin = groupInfoModel.admin;
                GroupInfoFragment.this.a(groupInfoModel.admin);
            }
        });
        LiveEventBus.get("modify_group_info", Void.class).observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r4) {
                ((GroupInfoPresenter) GroupInfoFragment.this.j()).a(true);
                GroupInfoFragment.this.l();
            }
        });
        LiveEventBus.get("add_group", String.class).observe(this, new Observer<String>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.6
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                ((GroupInfoPresenter) GroupInfoFragment.this.j()).d(str);
            }
        });
        LiveEventBus.get("update_announcement", UpdateAnnouncementEvent.class).observe(this, new Observer<UpdateAnnouncementEvent>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.7
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(UpdateAnnouncementEvent updateAnnouncementEvent) {
                if (((GroupInfoPresenter) GroupInfoFragment.this.j()).m() == null || ((GroupInfoPresenter) GroupInfoFragment.this.j()).m().group_id != updateAnnouncementEvent.a()) {
                    return;
                }
                ((GroupInfoPresenter) GroupInfoFragment.this.j()).m().announcement = updateAnnouncementEvent.b();
                GroupInfoFragment groupInfoFragment = GroupInfoFragment.this;
                groupInfoFragment.c(GroupUtil.a(((GroupInfoPresenter) groupInfoFragment.j()).m()));
            }
        });
        LiveEventBus.get("send_announcement", UpdateAnnouncementEvent.class).observe(this, new Observer<UpdateAnnouncementEvent>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.8
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(UpdateAnnouncementEvent updateAnnouncementEvent) {
                if (((GroupInfoPresenter) GroupInfoFragment.this.j()).m() == null || ((GroupInfoPresenter) GroupInfoFragment.this.j()).m().group_id != updateAnnouncementEvent.a()) {
                    return;
                }
                ((GroupInfoPresenter) GroupInfoFragment.this.j()).e(updateAnnouncementEvent.b());
            }
        });
        LiveEventBus.get("group_update_grade", UpdateGroupGradeEvent.class).observe(this, new Observer<UpdateGroupGradeEvent>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.9
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(UpdateGroupGradeEvent updateGroupGradeEvent) {
                GroupInfoFragment.this.l();
            }
        });
        this.o.f().observe(this, new Observer<Integer>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.10
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                GroupInfoFragment.this.l();
            }
        });
        this.o.e().observe(this, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupInfoFragment$YHeIIZ19LFA0QPZpUNvmEWqDbL0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupInfoFragment.this.a((GroupPrivilegeModel) obj);
            }
        });
        this.o.d().observe(this, new Observer<String>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.17
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                CommonAlertDialog.a(GroupInfoFragment.this.getContext(), GroupInfoFragment.this.getString(R.string.group_degrade_failed), str, GroupInfoFragment.this.getContext().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.17.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        dialogInterface.dismiss();
                    }
                }, (DialogInterface.OnDismissListener) null, 0);
            }
        });
    }

    private void x() {
        this.rl_super.setVisibility(8);
        this.rl_verify.setVisibility(8);
        this.rl_allow_recommend.setVisibility(8);
        this.rl_change.setVisibility(8);
        this.ll_owner_modify.setVisibility(8);
        this.tv_go_chat.setVisibility(8);
        this.ll_setting.setVisibility(8);
        this.ll_report.setVisibility(8);
        this.ll_clear_msg.setVisibility(8);
        this.ll_exit.setVisibility(8);
        this.tv_dismiss_hint.setVisibility(4);
        this.iv_manager_setting.setVisibility(8);
        this.iv_arrow_right.setVisibility(4);
        this.rl_announcement.setVisibility(8);
        this.tv_city.setVisibility(8);
        this.l.setVisibility(4);
        this.ll_freeze.setVisibility(8);
        this.tv_super.setVisibility(8);
        this.tv_frozen.setVisibility(8);
        this.rl_category.setVisibility(8);
        y();
    }

    private void y() {
        this.apply_reason.setVisibility(8);
        ShapeHelper.b(this.tv_apply, 2131101766);
        ShapeHelper.a((ShapeHelper.ShapeView) this.tv_apply, 2131102170);
        this.tv_apply.setClickable(true);
        this.tv_apply_hint.setVisibility(0);
        this.rl_et.setVisibility(0);
        ShapeHelper.b(this.ll_apply, 2131101780);
        this.tv_apply.setText(getString(R.string.btn_joingroup));
        this.tv_add_group.setVisibility(8);
        ShapeHelper.b(this.tv_add_group, 2131101766);
        ShapeHelper.a((ShapeHelper.ShapeView) this.tv_add_group, 2131102170);
        this.tv_add_group.setClickable(true);
        this.tv_add_group.setText(getString(R.string.group_join_now));
    }

    private void z() {
        new XPopup.Builder(getContext()).a(PopupAnimation.ScaleAlphaFromCenter).c((Boolean) false).d((Boolean) true).a((BasePopupView) new ApplyGroupHintPop(getContext(), new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ((GroupInfoPresenter) GroupInfoFragment.this.j()).d(GroupInfoFragment.this.et_reason.getText().toString());
                KeyboardUtils.a(GroupInfoFragment.this.getActivity());
            }
        }, new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                KeyboardUtils.a(GroupInfoFragment.this.getActivity());
            }
        })).h();
    }

    @Override // com.blued.android.framework.ui.custom.MvpKeyBoardFragment
    public void a(int i) {
        if (i == -3) {
            this.apply_reason.setClickable(true);
        } else if (i != -2) {
        } else {
            this.apply_reason.setClickable(false);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.scrollView.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131102360));
        this.title.getLeftImg().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GroupInfoFragment.this.t();
            }
        });
        this.title.getRightImg().setVisibility(0);
        this.title.getRightImg().setImageDrawable(BluedSkinUtils.b(getContext(), 2131233917));
        this.title.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ((GroupInfoPresenter) GroupInfoFragment.this.j()).b(GroupInfoFragment.this.iv_icon);
            }
        });
        View inflate = View.inflate(getContext(), R.layout.view_group_auidting, null);
        this.m = inflate;
        ViewGroupAuidtingBinding.a(inflate).b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GroupUtil.a(GroupInfoFragment.this.getContext());
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.title.getContent().addView(this.m, layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.l = imageView;
        imageView.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_group_edit));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.l.setPadding(DensityUtils.a(getContext(), 15.0f), DensityUtils.a(getContext(), 5.0f), DensityUtils.a(getContext(), 0.0f), DensityUtils.a(getContext(), 5.0f));
        layoutParams2.addRule(0, 2131369384);
        layoutParams2.addRule(15);
        layoutParams2.addRule(15);
        this.title.getContent().addView(this.l, layoutParams2);
        this.l.setVisibility(4);
        this.list_manager.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.o = (GroupInfoVM) new ViewModelProvider(this).get(GroupInfoVM.class);
        a(this.ll_keyboard);
        w();
        if (getArguments() == null || !getArguments().getBoolean("addImmediately", false)) {
            return;
        }
        z();
    }

    public void a(GroupInfoModel groupInfoModel) {
        if (groupInfoModel != null) {
            x();
            int i = groupInfoModel.group_role;
            if (i == 0) {
                this.ll_report.setVisibility(0);
                String str = k;
                Logger.c(str, "allow_join : " + groupInfoModel.allow_join);
                String str2 = k;
                Logger.c(str2, "apply_status : " + groupInfoModel.apply_status);
                if (groupInfoModel.apply_status != 0) {
                    v();
                } else if (groupInfoModel.allow_join != 1) {
                    this.apply_reason.setVisibility(0);
                } else {
                    this.tv_add_group.setVisibility(0);
                }
            } else if (i == 1) {
                this.rl_verify.setVisibility(0);
                if (groupInfoModel.type != 2 && groupInfoModel.type != 5) {
                    this.rl_allow_recommend.setVisibility(0);
                }
                this.rl_change.setVisibility(0);
                if (groupInfoModel.type != 4) {
                    this.ll_owner_modify.setVisibility(0);
                    this.l.setVisibility(0);
                }
                this.tv_go_chat.setVisibility(0);
                this.ll_setting.setVisibility(0);
                this.ll_clear_msg.setVisibility(0);
                if (groupInfoModel.type != 4) {
                    this.ll_exit.setVisibility(0);
                    this.tv_exit.setText(getString(R.string.btn_dismissgroup));
                }
                this.iv_manager_setting.setVisibility(0);
                this.rl_announcement.setVisibility(0);
                this.m.setVisibility(8);
                this.iv_arrow_right.setVisibility(0);
                this.l.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_group_edit));
                this.l.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.18
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(d.K, ((GroupInfoPresenter) GroupInfoFragment.this.j()).m());
                        TerminalActivity.d(GroupInfoFragment.this.getContext(), GroupInfoEditFragment.class, bundle);
                    }
                });
                if (groupInfoModel.type == 3 && groupInfoModel.group_status != 5) {
                    this.rl_super.setVisibility(0);
                }
                if (groupInfoModel.group_status == 5) {
                    this.ll_freeze.setVisibility(0);
                    this.rl_verify.setVisibility(8);
                    this.rl_allow_recommend.setVisibility(8);
                    this.ll_setting.setVisibility(8);
                    this.iv_manager_setting.setVisibility(8);
                }
                this.ll_report.setVisibility(0);
            } else if (i == 2 || i == 3) {
                this.tv_go_chat.setVisibility(0);
                this.ll_setting.setVisibility(0);
                this.ll_clear_msg.setVisibility(0);
                this.ll_exit.setVisibility(0);
                if (groupInfoModel.type == 4) {
                    this.tv_exit.setText(getString(R.string.group_event_exit_hint));
                } else {
                    this.tv_exit.setText(getString(R.string.btn_quitgroup));
                }
                this.ll_report.setVisibility(0);
                this.iv_arrow_right.setVisibility(0);
                this.rl_announcement.setVisibility(0);
                if (groupInfoModel.group_status == 5) {
                    this.ll_setting.setVisibility(8);
                }
            }
            GroupUtil.a(this.tv_frozen, groupInfoModel.group_role, groupInfoModel.group_status);
            GroupUtil.b(getFragmentActive(), groupInfoModel.group_cover, this.iv_icon);
            if (!TextUtils.isEmpty(groupInfoModel.group_desc)) {
                this.tv_desc.setText(groupInfoModel.group_desc);
            }
            if (groupInfoModel.group_role == 1 && groupInfoModel.auditing == 1) {
                this.m.setVisibility(0);
            }
            this.tv_desc.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (GroupInfoFragment.this.tv_desc.getMaxLines() == 4) {
                        GroupInfoFragment.this.tv_desc.setMaxLines(100);
                    } else {
                        GroupInfoFragment.this.tv_desc.setMaxLines(4);
                    }
                }
            });
            this.tv_announcement.setText(GroupUtil.a(groupInfoModel));
            if (!TextUtils.isEmpty(groupInfoModel.city)) {
                this.tv_city.setVisibility(0);
                this.tv_city.setText(groupInfoModel.city);
            }
            GroupUtil.a(groupInfoModel, this.tv_group_name);
            TextView textView = this.tv_member_num;
            textView.setText(groupInfoModel.group_now_population + BridgeUtil.SPLIT_MARK + groupInfoModel.group_max_population);
            if (groupInfoModel.group_now_population > groupInfoModel.group_max_population) {
                this.tv_member_num.setTextColor(BluedSkinUtils.a(getContext(), 2131102251));
            } else {
                this.tv_member_num.setTextColor(BluedSkinUtils.a(getContext(), 2131102263));
            }
            if (groupInfoModel.online > 0) {
                this.ivOnline.setVisibility(0);
                this.tvOnlineNum.setVisibility(0);
                TextView textView2 = this.tvOnlineNum;
                textView2.setText(groupInfoModel.online + getContext().getString(R.string.group_online_number) + " | ");
            } else {
                this.ivOnline.setVisibility(8);
                this.tvOnlineNum.setVisibility(8);
            }
            if (groupInfoModel.type == 4) {
                this.title.getRightImg().setVisibility(8);
            } else {
                this.title.getRightImg().setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupInfoModel.category_zh)) {
                this.rl_category.setVisibility(0);
                this.tv_category.setText(groupInfoModel.category_zh);
            }
            GroupUtil.a(this.tv_group_type, groupInfoModel, new boolean[0]);
            a(groupInfoModel.admin);
            b(groupInfoModel);
            d(groupInfoModel);
            c(groupInfoModel);
        }
    }

    public void a(Integer num) {
        ImageView imageView = this.group_setting_top;
        boolean z = true;
        if (num.intValue() != 1) {
            z = false;
        }
        imageView.setSelected(z);
    }

    public void b(GroupInfoModel groupInfoModel) {
        if (groupInfoModel.group_role != 0) {
            this.group_setting_mute.setSelected(groupInfoModel.message_is_mute == 1);
            if (this.group_setting_mute.isSelected()) {
                this.group_setting_at_mute.setSelected(groupInfoModel.at_message_is_mute == 1);
            }
            this.rl_setting_at_notify.setVisibility(groupInfoModel.message_is_mute == 1 ? 0 : 8);
            this.group_setting_mute_notify.setSelected(groupInfoModel.notice_is_mute == 1);
        }
        if (groupInfoModel.group_role == 1) {
            this.group_setting_verify.setSelected(groupInfoModel.allow_join == 2);
            ImageView imageView = this.group_setting_recommend;
            boolean z = false;
            if (groupInfoModel.nearby_or_recommend == 1) {
                z = true;
            }
            imageView.setSelected(z);
        }
    }

    public void c(String str) {
        this.tv_announcement.setText(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fm_msg_group_info;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().getWindow().setSoftInputMode(19);
        this.apply_reason.setClickable(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 888 && i2 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("string_edit");
            String str = stringExtra;
            if (stringExtra == null) {
                str = "";
            }
            ((GroupInfoPresenter) j()).e(str);
        }
    }

    @OnClick
    public void onClick(View view) {
        if (((GroupInfoPresenter) j()).m() == null) {
            return;
        }
        int i = 1;
        switch (view.getId()) {
            case R.id.apply_reason /* 2131362296 */:
                KeyboardUtils.a(getActivity());
                return;
            case R.id.group_setting_at_mute /* 2131364158 */:
                GroupInfoPresenter groupInfoPresenter = (GroupInfoPresenter) j();
                int i2 = 1;
                if (this.group_setting_at_mute.isSelected()) {
                    i2 = 2;
                }
                groupInfoPresenter.a("at_message_is_mute", i2);
                return;
            case R.id.group_setting_mute /* 2131364159 */:
                GroupInfoPresenter groupInfoPresenter2 = (GroupInfoPresenter) j();
                int i3 = 1;
                if (this.group_setting_mute.isSelected()) {
                    i3 = 2;
                }
                groupInfoPresenter2.a("message_is_mute", i3);
                return;
            case R.id.group_setting_mute_notify /* 2131364160 */:
                GroupInfoPresenter groupInfoPresenter3 = (GroupInfoPresenter) j();
                int i4 = 1;
                if (this.group_setting_mute_notify.isSelected()) {
                    i4 = 2;
                }
                groupInfoPresenter3.a("notice_is_mute", i4);
                return;
            case R.id.group_setting_recommend /* 2131364161 */:
                GroupInfoPresenter groupInfoPresenter4 = (GroupInfoPresenter) j();
                int i5 = 1;
                if (this.group_setting_recommend.isSelected()) {
                    i5 = 2;
                }
                groupInfoPresenter4.a("nearby_or_recommend", i5);
                return;
            case R.id.group_setting_top /* 2131364163 */:
                ((GroupInfoPresenter) j()).a(this.group_setting_top);
                return;
            case R.id.group_setting_verify /* 2131364164 */:
                GroupInfoPresenter groupInfoPresenter5 = (GroupInfoPresenter) j();
                if (!this.group_setting_verify.isSelected()) {
                    i = 2;
                }
                groupInfoPresenter5.a("allow_join", i);
                return;
            case R.id.iv_manager_setting /* 2131365615 */:
                Bundle bundle = new Bundle();
                bundle.putSerializable(d.K, ((GroupInfoPresenter) j()).m());
                TerminalActivity.d(getContext(), GroupManagerFragment.class, bundle);
                return;
            case R.id.rl_announcement /* 2131369230 */:
                if (((GroupInfoPresenter) j()).m() != null) {
                    GroupAnnouncementFragment.f32668a.a(getActivity(), ((GroupInfoPresenter) j()).m());
                    return;
                }
                return;
            case R.id.rl_change /* 2131369252 */:
                SearchMemberFragment.a(getContext(), 2, ((GroupInfoPresenter) j()).m().group_id + "", ((GroupInfoPresenter) j()).m().group_role);
                return;
            case R.id.rl_member /* 2131369355 */:
                if (((GroupInfoPresenter) j()).m().group_role == 0) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("group_role", ((GroupInfoPresenter) j()).m().group_role);
                bundle2.putString(Contacts.GroupMembership.GROUP_ID, ((GroupInfoPresenter) j()).m().group_id + "");
                bundle2.putInt("group_type", ((GroupInfoPresenter) j()).m().type);
                TerminalActivity.d(getContext(), GroupMemberFragment.class, bundle2);
                return;
            case R.id.rl_super /* 2131369409 */:
                if (!BluedPreferences.eD()) {
                    BluedPreferences.eE();
                    this.group_super_red_point.setVisibility(8);
                }
                this.o.g();
                return;
            case R.id.tv_add_group /* 2131370841 */:
            case R.id.tv_apply /* 2131370897 */:
                EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_JOIN_CLICK, ((GroupInfoPresenter) j()).m().group_id + "", ((GroupInfoPresenter) j()).o());
                z();
                return;
            case R.id.tv_clear_msg /* 2131371119 */:
                if (((GroupInfoPresenter) j()).n() != null) {
                    CommonAlertDialog.a(getContext(), getContext().getResources().getString(R.string.biao_new_signin_tip), getContext().getResources().getString(R.string.chat_delete_yesorno), getContext().getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.24
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i6) {
                            Tracker.onClick(dialogInterface, i6);
                            ChatManager.getInstance().deleteSessionAndChatting((short) 3, Long.valueOf(((GroupInfoPresenter) GroupInfoFragment.this.j()).n().sessionId).longValue());
                        }
                    }, getContext().getResources().getString(2131887258), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.25
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i6) {
                            Tracker.onClick(dialogInterface, i6);
                        }
                    }, (DialogInterface.OnDismissListener) null);
                    return;
                }
                return;
            case 2131371378:
                ((GroupInfoPresenter) j()).q();
                return;
            case R.id.tv_freeze /* 2131371493 */:
                WebViewShowInfoFragment.show(getContext(), GroupConstant.f32663a + "relieve");
                return;
            case R.id.tv_go_chat /* 2131371563 */:
                ((GroupInfoPresenter) j()).s();
                return;
            case 2131372428:
                ReportFragmentNew.a(getActivity(), 4, ((GroupInfoPresenter) j()).m().group_id + "", ((GroupInfoPresenter) j()).m().group_title);
                return;
            default:
                return;
        }
    }

    public void v() {
        if (((GroupInfoPresenter) j()).m() == null) {
            return;
        }
        if (((GroupInfoPresenter) j()).m().allow_join == 1) {
            this.tv_add_group.setVisibility(0);
            ShapeHelper.b(this.tv_add_group, 2131102264);
            ShapeHelper.a((ShapeHelper.ShapeView) this.tv_add_group, 2131102263);
            this.tv_add_group.setText(((GroupInfoPresenter) j()).m().apply_status == 1 ? getString(R.string.group_apply_sent) : getString(R.string.group_join_reject));
            this.tv_add_group.setClickable(false);
            return;
        }
        this.apply_reason.setVisibility(0);
        ShapeHelper.b(this.tv_apply, 2131102264);
        ShapeHelper.a((ShapeHelper.ShapeView) this.tv_apply, 2131102263);
        this.tv_apply.setClickable(false);
        this.tv_apply_hint.setVisibility(4);
        this.rl_et.setVisibility(4);
        ShapeHelper.b(this.ll_apply, 2131102360);
        this.tv_apply.setText(((GroupInfoPresenter) j()).m().apply_status == 1 ? getString(R.string.group_apply_sent) : getString(R.string.group_join_reject));
    }
}
