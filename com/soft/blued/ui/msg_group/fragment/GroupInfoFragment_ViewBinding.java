package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupInfoFragment_ViewBinding.class */
public class GroupInfoFragment_ViewBinding implements Unbinder {
    private GroupInfoFragment b;

    /* renamed from: c  reason: collision with root package name */
    private View f19033c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private View n;
    private View o;
    private View p;
    private View q;
    private View r;
    private View s;
    private View t;
    private View u;

    public GroupInfoFragment_ViewBinding(final GroupInfoFragment groupInfoFragment, View view) {
        this.b = groupInfoFragment;
        groupInfoFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
        groupInfoFragment.iv_icon = (ImageView) Utils.a(view, 2131365504, "field 'iv_icon'", ImageView.class);
        groupInfoFragment.tv_group_name = (TextView) Utils.a(view, R.id.tv_group_name, "field 'tv_group_name'", TextView.class);
        groupInfoFragment.tv_member_num = (TextView) Utils.a(view, R.id.tv_member_num, "field 'tv_member_num'", TextView.class);
        groupInfoFragment.list_manager = (RecyclerView) Utils.a(view, R.id.list_manager, "field 'list_manager'", RecyclerView.class);
        groupInfoFragment.iv_arrow_right = (ImageView) Utils.a(view, R.id.iv_arrow_right, "field 'iv_arrow_right'", ImageView.class);
        View a2 = Utils.a(view, R.id.tv_go_chat, "field 'tv_go_chat' and method 'onClick'");
        groupInfoFragment.tv_go_chat = (TextView) Utils.b(a2, R.id.tv_go_chat, "field 'tv_go_chat'", TextView.class);
        this.f19033c = a2;
        a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        View a3 = Utils.a(view, R.id.group_setting_top, "field 'group_setting_top' and method 'onClick'");
        groupInfoFragment.group_setting_top = (ImageView) Utils.b(a3, R.id.group_setting_top, "field 'group_setting_top'", ImageView.class);
        this.d = a3;
        a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        View a4 = Utils.a(view, R.id.group_setting_mute, "field 'group_setting_mute' and method 'onClick'");
        groupInfoFragment.group_setting_mute = (ImageView) Utils.b(a4, R.id.group_setting_mute, "field 'group_setting_mute'", ImageView.class);
        this.e = a4;
        a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        View a5 = Utils.a(view, R.id.group_setting_at_mute, "field 'group_setting_at_mute' and method 'onClick'");
        groupInfoFragment.group_setting_at_mute = (ImageView) Utils.b(a5, R.id.group_setting_at_mute, "field 'group_setting_at_mute'", ImageView.class);
        this.f = a5;
        a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        View a6 = Utils.a(view, R.id.group_setting_mute_notify, "field 'group_setting_mute_notify' and method 'onClick'");
        groupInfoFragment.group_setting_mute_notify = (ImageView) Utils.b(a6, R.id.group_setting_mute_notify, "field 'group_setting_mute_notify'", ImageView.class);
        this.g = a6;
        a6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        groupInfoFragment.group_identity_change = (ImageView) Utils.a(view, R.id.group_identity_change, "field 'group_identity_change'", ImageView.class);
        View a7 = Utils.a(view, R.id.rl_change, "field 'rl_change' and method 'onClick'");
        groupInfoFragment.rl_change = (RelativeLayout) Utils.b(a7, R.id.rl_change, "field 'rl_change'", RelativeLayout.class);
        this.h = a7;
        a7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        View a8 = Utils.a(view, R.id.tv_report, "field 'tv_report' and method 'onClick'");
        groupInfoFragment.tv_report = (TextView) Utils.b(a8, R.id.tv_report, "field 'tv_report'", TextView.class);
        this.i = a8;
        a8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        View a9 = Utils.a(view, R.id.tv_clear_msg, "field 'tv_clear_msg' and method 'onClick'");
        groupInfoFragment.tv_clear_msg = (TextView) Utils.b(a9, R.id.tv_clear_msg, "field 'tv_clear_msg'", TextView.class);
        this.j = a9;
        a9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        View a10 = Utils.a(view, R.id.tv_exit, "field 'tv_exit' and method 'onClick'");
        groupInfoFragment.tv_exit = (TextView) Utils.b(a10, R.id.tv_exit, "field 'tv_exit'", TextView.class);
        this.k = a10;
        a10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        groupInfoFragment.tv_dismiss_hint = (TextView) Utils.a(view, R.id.tv_dismiss_hint, "field 'tv_dismiss_hint'", TextView.class);
        groupInfoFragment.rl_description = (RelativeLayout) Utils.a(view, R.id.rl_description, "field 'rl_description'", RelativeLayout.class);
        groupInfoFragment.ll_owner_modify = (LinearLayout) Utils.a(view, R.id.ll_owner_modify, "field 'll_owner_modify'", LinearLayout.class);
        groupInfoFragment.ll_setting = (LinearLayout) Utils.a(view, R.id.ll_setting, "field 'll_setting'", LinearLayout.class);
        View a11 = Utils.a(view, R.id.iv_manager_setting, "field 'iv_manager_setting' and method 'onClick'");
        groupInfoFragment.iv_manager_setting = (ImageView) Utils.b(a11, R.id.iv_manager_setting, "field 'iv_manager_setting'", ImageView.class);
        this.l = a11;
        a11.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        View a12 = Utils.a(view, R.id.tv_add_group, "field 'tv_add_group' and method 'onClick'");
        groupInfoFragment.tv_add_group = (ShapeTextView) Utils.b(a12, R.id.tv_add_group, "field 'tv_add_group'", ShapeTextView.class);
        this.m = a12;
        a12.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        groupInfoFragment.rl_verify = (RelativeLayout) Utils.a(view, R.id.rl_verify, "field 'rl_verify'", RelativeLayout.class);
        View a13 = Utils.a(view, R.id.group_setting_verify, "field 'group_setting_verify' and method 'onClick'");
        groupInfoFragment.group_setting_verify = (ImageView) Utils.b(a13, R.id.group_setting_verify, "field 'group_setting_verify'", ImageView.class);
        this.n = a13;
        a13.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        groupInfoFragment.rl_setting_at_notify = (RelativeLayout) Utils.a(view, R.id.rl_setting_at_notify, "field 'rl_setting_at_notify'", RelativeLayout.class);
        groupInfoFragment.rl_allow_recommend = (RelativeLayout) Utils.a(view, R.id.rl_allow_recommend, "field 'rl_allow_recommend'", RelativeLayout.class);
        View a14 = Utils.a(view, R.id.group_setting_recommend, "field 'group_setting_recommend' and method 'onClick'");
        groupInfoFragment.group_setting_recommend = (ImageView) Utils.b(a14, R.id.group_setting_recommend, "field 'group_setting_recommend'", ImageView.class);
        this.o = a14;
        a14.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        View a15 = Utils.a(view, R.id.rl_super, "field 'rl_super' and method 'onClick'");
        groupInfoFragment.rl_super = (RelativeLayout) Utils.b(a15, R.id.rl_super, "field 'rl_super'", RelativeLayout.class);
        this.p = a15;
        a15.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.14
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        groupInfoFragment.tv_group_super = (TextView) Utils.a(view, R.id.tv_group_super, "field 'tv_group_super'", TextView.class);
        groupInfoFragment.group_super_red_point = (ShapeTextView) Utils.a(view, R.id.group_super_red_point, "field 'group_super_red_point'", ShapeTextView.class);
        View a16 = Utils.a(view, R.id.apply_reason, "field 'apply_reason' and method 'onClick'");
        groupInfoFragment.apply_reason = a16;
        this.q = a16;
        a16.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.15
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        groupInfoFragment.et_reason = (EditText) Utils.a(view, R.id.et_reason, "field 'et_reason'", EditText.class);
        View a17 = Utils.a(view, R.id.tv_apply, "field 'tv_apply' and method 'onClick'");
        groupInfoFragment.tv_apply = (ShapeTextView) Utils.b(a17, R.id.tv_apply, "field 'tv_apply'", ShapeTextView.class);
        this.r = a17;
        a17.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.16
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        groupInfoFragment.rl_et = (RelativeLayout) Utils.a(view, R.id.rl_et, "field 'rl_et'", RelativeLayout.class);
        groupInfoFragment.tv_apply_hint = (TextView) Utils.a(view, R.id.tv_apply_hint, "field 'tv_apply_hint'", TextView.class);
        groupInfoFragment.ll_apply = (ShapeLinearLayout) Utils.a(view, R.id.ll_apply, "field 'll_apply'", ShapeLinearLayout.class);
        groupInfoFragment.tv_desc = (TextView) Utils.a(view, R.id.tv_desc, "field 'tv_desc'", TextView.class);
        groupInfoFragment.scrollView = (ScrollView) Utils.a(view, 2131369639, "field 'scrollView'", ScrollView.class);
        groupInfoFragment.ll_keyboard = (KeyboardListenLinearLayout) Utils.a(view, R.id.ll_keyboard, "field 'll_keyboard'", KeyboardListenLinearLayout.class);
        groupInfoFragment.ll_freeze = (LinearLayout) Utils.a(view, R.id.ll_freeze, "field 'll_freeze'", LinearLayout.class);
        groupInfoFragment.ll_report = (LinearLayout) Utils.a(view, R.id.ll_report, "field 'll_report'", LinearLayout.class);
        groupInfoFragment.ll_clear_msg = (LinearLayout) Utils.a(view, R.id.ll_clear_msg, "field 'll_clear_msg'", LinearLayout.class);
        groupInfoFragment.ll_exit = (LinearLayout) Utils.a(view, R.id.ll_exit, "field 'll_exit'", LinearLayout.class);
        groupInfoFragment.tv_group_type = (ShapeTextView) Utils.a(view, R.id.tv_group_type, "field 'tv_group_type'", ShapeTextView.class);
        groupInfoFragment.rl_group_link = (RelativeLayout) Utils.a(view, R.id.rl_group_link, "field 'rl_group_link'", RelativeLayout.class);
        groupInfoFragment.tv_base_name = (TextView) Utils.a(view, R.id.tv_base_name, "field 'tv_base_name'", TextView.class);
        groupInfoFragment.tv_hint_link = (TextView) Utils.a(view, R.id.tv_hint_link, "field 'tv_hint_link'", TextView.class);
        groupInfoFragment.iv_user_avatar = (ImageView) Utils.a(view, R.id.iv_user_avatar, "field 'iv_user_avatar'", ImageView.class);
        View a18 = Utils.a(view, R.id.rl_announcement, "field 'rl_announcement' and method 'onClick'");
        groupInfoFragment.rl_announcement = (RelativeLayout) Utils.b(a18, R.id.rl_announcement, "field 'rl_announcement'", RelativeLayout.class);
        this.s = a18;
        a18.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.17
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        groupInfoFragment.tv_announcement = (TextView) Utils.a(view, R.id.tv_announcement, "field 'tv_announcement'", TextView.class);
        groupInfoFragment.tv_city = (TextView) Utils.a(view, R.id.tv_city, "field 'tv_city'", TextView.class);
        groupInfoFragment.tv_super = (TextView) Utils.a(view, R.id.tv_super, "field 'tv_super'", TextView.class);
        groupInfoFragment.tv_frozen = (ShapeTextView) Utils.a(view, R.id.tv_frozen, "field 'tv_frozen'", ShapeTextView.class);
        groupInfoFragment.rl_category = (RelativeLayout) Utils.a(view, R.id.rl_category, "field 'rl_category'", RelativeLayout.class);
        groupInfoFragment.tv_category = (TextView) Utils.a(view, R.id.tv_category, "field 'tv_category'", TextView.class);
        groupInfoFragment.ivOnline = (ImageView) Utils.a(view, R.id.iv_online, "field 'ivOnline'", ImageView.class);
        groupInfoFragment.tvOnlineNum = (TextView) Utils.a(view, R.id.tv_online_num, "field 'tvOnlineNum'", TextView.class);
        View a19 = Utils.a(view, R.id.rl_member, "method 'onClick'");
        this.t = a19;
        a19.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.18
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
        View a20 = Utils.a(view, R.id.tv_freeze, "method 'onClick'");
        this.u = a20;
        a20.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_ViewBinding.19
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoFragment.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        GroupInfoFragment groupInfoFragment = this.b;
        if (groupInfoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        groupInfoFragment.title = null;
        groupInfoFragment.iv_icon = null;
        groupInfoFragment.tv_group_name = null;
        groupInfoFragment.tv_member_num = null;
        groupInfoFragment.list_manager = null;
        groupInfoFragment.iv_arrow_right = null;
        groupInfoFragment.tv_go_chat = null;
        groupInfoFragment.group_setting_top = null;
        groupInfoFragment.group_setting_mute = null;
        groupInfoFragment.group_setting_at_mute = null;
        groupInfoFragment.group_setting_mute_notify = null;
        groupInfoFragment.group_identity_change = null;
        groupInfoFragment.rl_change = null;
        groupInfoFragment.tv_report = null;
        groupInfoFragment.tv_clear_msg = null;
        groupInfoFragment.tv_exit = null;
        groupInfoFragment.tv_dismiss_hint = null;
        groupInfoFragment.rl_description = null;
        groupInfoFragment.ll_owner_modify = null;
        groupInfoFragment.ll_setting = null;
        groupInfoFragment.iv_manager_setting = null;
        groupInfoFragment.tv_add_group = null;
        groupInfoFragment.rl_verify = null;
        groupInfoFragment.group_setting_verify = null;
        groupInfoFragment.rl_setting_at_notify = null;
        groupInfoFragment.rl_allow_recommend = null;
        groupInfoFragment.group_setting_recommend = null;
        groupInfoFragment.rl_super = null;
        groupInfoFragment.tv_group_super = null;
        groupInfoFragment.group_super_red_point = null;
        groupInfoFragment.apply_reason = null;
        groupInfoFragment.et_reason = null;
        groupInfoFragment.tv_apply = null;
        groupInfoFragment.rl_et = null;
        groupInfoFragment.tv_apply_hint = null;
        groupInfoFragment.ll_apply = null;
        groupInfoFragment.tv_desc = null;
        groupInfoFragment.scrollView = null;
        groupInfoFragment.ll_keyboard = null;
        groupInfoFragment.ll_freeze = null;
        groupInfoFragment.ll_report = null;
        groupInfoFragment.ll_clear_msg = null;
        groupInfoFragment.ll_exit = null;
        groupInfoFragment.tv_group_type = null;
        groupInfoFragment.rl_group_link = null;
        groupInfoFragment.tv_base_name = null;
        groupInfoFragment.tv_hint_link = null;
        groupInfoFragment.iv_user_avatar = null;
        groupInfoFragment.rl_announcement = null;
        groupInfoFragment.tv_announcement = null;
        groupInfoFragment.tv_city = null;
        groupInfoFragment.tv_super = null;
        groupInfoFragment.tv_frozen = null;
        groupInfoFragment.rl_category = null;
        groupInfoFragment.tv_category = null;
        groupInfoFragment.ivOnline = null;
        groupInfoFragment.tvOnlineNum = null;
        this.f19033c.setOnClickListener(null);
        this.f19033c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
        this.h.setOnClickListener(null);
        this.h = null;
        this.i.setOnClickListener(null);
        this.i = null;
        this.j.setOnClickListener(null);
        this.j = null;
        this.k.setOnClickListener(null);
        this.k = null;
        this.l.setOnClickListener(null);
        this.l = null;
        this.m.setOnClickListener(null);
        this.m = null;
        this.n.setOnClickListener(null);
        this.n = null;
        this.o.setOnClickListener(null);
        this.o = null;
        this.p.setOnClickListener(null);
        this.p = null;
        this.q.setOnClickListener(null);
        this.q = null;
        this.r.setOnClickListener(null);
        this.r = null;
        this.s.setOnClickListener(null);
        this.s = null;
        this.t.setOnClickListener(null);
        this.t = null;
        this.u.setOnClickListener(null);
        this.u = null;
    }
}
