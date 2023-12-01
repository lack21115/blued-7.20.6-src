package com.soft.blued.ui.group.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.Fragment;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.group.GroupAdminSetFragment;
import com.soft.blued.ui.group.GroupEditNameIconFragment;
import com.soft.blued.ui.group.GroupJoinVerifyFragment;
import com.soft.blued.ui.group.GroupMembersListFragment;
import com.soft.blued.ui.group.GroupUpdateCountFragment;
import com.soft.blued.ui.group.ModifyGroupProfileFragment;
import com.soft.blued.ui.group.contract.IGroupInfoContract;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.BluedGroupAllMembers;
import com.soft.blued.ui.group.presenter.GroupInfoPresenter;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import com.soft.blued.ui.user.fragment.ChooseCountryFragment;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.CommonDataRefreshObserver;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.tencent.thumbplayer.api.TPErrorCode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/fragment/GroupInfoFragment.class */
public class GroupInfoFragment extends BaseFragment implements View.OnClickListener, IGroupInfoContract.IView {
    private ImageView A;
    private RelativeLayout B;
    private ImageView C;
    private ImageView D;
    private RelativeLayout E;
    private ImageView F;
    private ImageView G;
    private RelativeLayout H;
    private ImageView I;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private ImageView M;
    private LinearLayout N;
    private LinearLayout O;
    private LinearLayout P;
    private LinearLayout Q;
    private LabeledTextView R;
    private LinearLayout S;
    private LinearLayout T;
    private Button U;
    private Button V;
    private ToggleButton W;
    private TextView X;
    private TextView Y;
    private LinearLayout Z;
    private ImageView aa;
    private ImageView ab;
    private LinearLayout ac;
    private TextView ad;
    private ImageView ae;
    private ImageView af;
    private TextView ag;
    private LinearLayout ah;
    private LinearLayout ai;
    private LinearLayout aj;
    private LinearLayout ak;
    private TextView al;
    private ImageView am;
    private LinearLayout an;
    private TextView ao;
    private ScrollView ap;
    private NoDataAndLoadFailView aq;

    /* renamed from: ar  reason: collision with root package name */
    private LinearLayout f17267ar;
    private LinearLayout as;
    private TextView at;
    private BluedCreatedGroupInfo au;
    private GroupInfoPresenter b;

    /* renamed from: c  reason: collision with root package name */
    private Context f17268c;
    private View d;
    private LoadOptions e;
    private String f;
    private String g;
    private String h;
    private CommonTopTitleNoTrans i;
    private ImageView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private ImageView r;
    private RelativeLayout s;
    private ImageView t;
    private ImageView u;
    private RelativeLayout v;
    private ImageView w;
    private ImageView x;
    private RelativeLayout y;
    private ImageView z;

    /* renamed from: a  reason: collision with root package name */
    private String f17266a = GroupInfoFragment.class.getSimpleName();
    private List<BluedGroupAllMembers> av = new ArrayList();

    public static void a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("gid", str);
        TerminalActivity.d(context, GroupInfoFragment.class, bundle);
    }

    public static void a(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gid", str);
        bundle.putString("from_page", str2);
        TerminalActivity.d(context, GroupInfoFragment.class, bundle);
    }

    private void a(View view) {
        this.j = (ImageView) view.findViewById(R.id.iv_group_profile_pic);
        this.k = (TextView) view.findViewById(R.id.tv_group_name);
        this.l = (TextView) view.findViewById(R.id.tv_group_no);
        this.m = (TextView) view.findViewById(R.id.tv_group_members_amount);
        this.n = (TextView) view.findViewById(R.id.tv_group_intro_top);
        this.o = (TextView) view.findViewById(R.id.tv_group_location_info);
        this.p = (TextView) view.findViewById(R.id.tv_group_intro);
        this.q = (ImageView) view.findViewById(R.id.iv_first_member);
        this.r = (ImageView) view.findViewById(R.id.tv_first_member_role);
        this.s = (RelativeLayout) view.findViewById(R.id.rl_first_member);
        this.t = (ImageView) view.findViewById(R.id.iv_second_member);
        this.u = (ImageView) view.findViewById(R.id.tv_second_member_role);
        this.v = (RelativeLayout) view.findViewById(R.id.rl_second_member);
        this.w = (ImageView) view.findViewById(R.id.iv_third_member);
        this.x = (ImageView) view.findViewById(R.id.tv_third_member_role);
        this.y = (RelativeLayout) view.findViewById(R.id.rl_third_member);
        this.z = (ImageView) view.findViewById(R.id.iv_fourth_member);
        this.A = (ImageView) view.findViewById(R.id.tv_fourth_member_role);
        this.B = (RelativeLayout) view.findViewById(R.id.rl_fourth_member);
        this.C = (ImageView) view.findViewById(R.id.iv_fifth_member);
        this.D = (ImageView) view.findViewById(R.id.tv_fifth_member_role);
        this.E = (RelativeLayout) view.findViewById(R.id.rl_fifth_member);
        this.F = (ImageView) view.findViewById(R.id.iv_sixth_member);
        this.G = (ImageView) view.findViewById(R.id.tv_sixth_member_role);
        this.H = (RelativeLayout) view.findViewById(R.id.rl_sixth_member);
        this.I = (ImageView) view.findViewById(R.id.iv_add_memebers_second);
        this.J = (ImageView) view.findViewById(R.id.iv_add_memebers_third);
        this.K = (ImageView) view.findViewById(R.id.iv_add_memebers_fourth);
        this.L = (ImageView) view.findViewById(R.id.iv_add_memebers_fifth);
        this.M = (ImageView) view.findViewById(R.id.iv_add_memebers_sixth);
        this.N = (LinearLayout) view.findViewById(R.id.ll_group_member);
        this.O = (LinearLayout) view.findViewById(R.id.ll_group_member_lists);
        this.P = (LinearLayout) view.findViewById(R.id.ll_groupinfo_location);
        this.Q = (LinearLayout) view.findViewById(R.id.liner_group_clear_chat);
        LabeledTextView labeledTextView = (LabeledTextView) view.findViewById(R.id.chat_setting_bg);
        this.R = labeledTextView;
        labeledTextView.a(Boolean.valueOf(BluedPreferences.e(1)));
        this.S = (LinearLayout) view.findViewById(R.id.ll_group_term);
        this.T = (LinearLayout) view.findViewById(R.id.tv_group_report);
        this.U = (Button) view.findViewById(R.id.btn_group_options);
        this.V = (Button) view.findViewById(R.id.bt_chat_start);
        this.W = (ToggleButton) view.findViewById(R.id.sbt_msgRemind_onoff);
        this.X = (TextView) view.findViewById(R.id.tv_group_intro_title_top);
        this.Y = (TextView) view.findViewById(R.id.tv_group_intro_title);
        this.Z = (LinearLayout) view.findViewById(R.id.ll_group_info_custom_service);
        this.aa = (ImageView) view.findViewById(R.id.tv_group_create_arrow);
        this.ab = (ImageView) view.findViewById(R.id.tv_location_arrow);
        this.ac = (LinearLayout) view.findViewById(R.id.only_create_liner);
        this.ad = (TextView) view.findViewById(R.id.tv_group_reportz_line);
        this.ae = (ImageView) view.findViewById(R.id.tv_arrow);
        this.af = (ImageView) view.findViewById(R.id.iv_group_head_icon);
        this.ag = (TextView) view.findViewById(R.id.ll_group_msgRemind_line);
        this.ah = (LinearLayout) view.findViewById(R.id.ll_group_msgRemind);
        this.ai = (LinearLayout) view.findViewById(R.id.ll_group_intro);
        this.aj = (LinearLayout) view.findViewById(R.id.ll_group_name_icon);
        this.ak = (LinearLayout) view.findViewById(R.id.liner_group_count_set);
        this.ap = (ScrollView) view.findViewById(R.id.sv_group_info_detail);
        this.al = (TextView) view.findViewById(R.id.tv_group_lock_icon);
        this.am = (ImageView) view.findViewById(R.id.tv_members_count_arrow);
        this.an = (LinearLayout) view.findViewById(R.id.liner_group_admins_set);
        this.ao = (TextView) view.findViewById(R.id.ll_group_intro_line);
        NoDataAndLoadFailView findViewById = view.findViewById(R.id.iv_group_info_dissolution);
        this.aq = findViewById;
        findViewById.setNoDataImg((int) R.drawable.group_dismissed);
        this.aq.setNoDataStr((int) R.string.group_info_dissolution);
        this.aq.d();
        this.f17267ar = (LinearLayout) view.findViewById(R.id.ll_group_info_bottom);
        this.as = (LinearLayout) view.findViewById(R.id.ll_group_intro_top);
        this.at = (TextView) view.findViewById(R.id.tv_group_intro_top_line);
        this.j.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.ai.setOnClickListener(this);
        this.aj.setOnClickListener(this);
        this.ak.setOnClickListener(this);
        this.an.setOnClickListener(this);
    }

    public static void a(Fragment fragment, String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("gid", str);
        TerminalActivity.a(fragment, GroupInfoFragment.class, bundle, i);
    }

    public static void a(Fragment fragment, String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("gid", str);
        bundle.putString("from_page", str2);
        TerminalActivity.a(fragment, GroupInfoFragment.class, bundle, i);
    }

    private void a(List<BluedGroupAllMembers> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.v);
        arrayList.add(this.y);
        arrayList.add(this.B);
        arrayList.add(this.E);
        arrayList.add(this.H);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.t);
        arrayList2.add(this.w);
        arrayList2.add(this.z);
        arrayList2.add(this.C);
        arrayList2.add(this.F);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(this.u);
        arrayList3.add(this.x);
        arrayList3.add(this.A);
        arrayList3.add(this.D);
        arrayList3.add(this.G);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(this.I);
        arrayList4.add(this.J);
        arrayList4.add(this.K);
        arrayList4.add(this.L);
        arrayList4.add(this.M);
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            if (list.size() > i2) {
                i++;
                ImageLoader.a(getFragmentActive(), list.get(i2).avatar).c().b(2131237310).a((ImageView) arrayList2.get(i2));
                if ("1".equals(list.get(i2).is_admin)) {
                    ((ImageView) arrayList3.get(i2)).setVisibility(0);
                } else {
                    ((ImageView) arrayList3.get(i2)).setVisibility(8);
                }
            } else {
                ((RelativeLayout) arrayList.get(i2)).setVisibility(4);
            }
        }
        if (this.b.c()) {
            int i3 = i;
            if (i == 5) {
                i3 = i - 1;
            }
            ((ImageView) arrayList2.get(i3)).setVisibility(8);
            ((ImageView) arrayList3.get(i3)).setVisibility(8);
            ((RelativeLayout) arrayList.get(i3)).setVisibility(0);
            ((ImageView) arrayList4.get(i3)).setVisibility(0);
            ((ImageView) arrayList4.get(i3)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.fragment.GroupInfoFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (GroupInfoFragment.this.au == null || !BluedConstant.f14549a) {
                        return;
                    }
                    AppMethods.d((int) R.string.msg_toast_group_function_close);
                }
            });
        }
    }

    private void h() {
        LoadOptions loadOptions = new LoadOptions();
        this.e = loadOptions;
        loadOptions.d = 2131237310;
        this.e.b = 2131237310;
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.f = arguments.getString("gid");
        this.h = arguments.getString("iid");
        String string = arguments.getString("from_page");
        this.g = string;
        if (!StringUtils.d(string)) {
            InstantLog.a("group_detail", (Object) this.g);
        }
        this.b.b(this.f);
        this.W.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.group.fragment.GroupInfoFragment.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                if (z) {
                    GroupInfoFragment.this.b.a(1);
                } else {
                    GroupInfoFragment.this.b.a(0);
                }
                GroupInfoFragment.this.b.b(z);
            }
        });
    }

    private void i() {
        CommonTopTitleNoTrans findViewById = this.d.findViewById(R.id.top_title);
        this.i = findViewById;
        findViewById.a();
        this.i.setCenterText(getString(R.string.group_info));
        this.i.setLeftClickListener(this);
        this.i.setRightClickListener(this);
        this.i.setRightImg((int) R.drawable.icon_title_group_share);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j() {
        if (this.au != null) {
            String json = AppInfo.f().toJson(this.au);
            Bundle bundle = new Bundle();
            bundle.putString("membersCount", this.au.groups_members_count);
            bundle.putString("gid", this.au.groups_gid);
            bundle.putString("member", this.au.groups_in_members);
            bundle.putString("admin", this.au.groups_is_admins);
            bundle.putString("creator", this.au.groups_is_created);
            bundle.putString("group_info_json", json);
            TerminalActivity.a(this, GroupMembersListFragment.class, bundle, 7000);
        }
    }

    @Override // com.soft.blued.ui.group.contract.IGroupInfoContract.IView
    public Bundle a() {
        return getArguments();
    }

    @Override // com.soft.blued.ui.group.contract.IGroupInfoContract.IView
    public void a(BluedCreatedGroupInfo bluedCreatedGroupInfo) {
        this.au = bluedCreatedGroupInfo;
        if (StringUtils.d(bluedCreatedGroupInfo.groups_avatar)) {
            this.j.setImageResource(R.drawable.group_default_head);
        } else {
            ImageLoader.a(getFragmentActive(), bluedCreatedGroupInfo.groups_avatar).c().b(2131237310).a(this.j);
        }
        if (StringUtils.d(bluedCreatedGroupInfo.groups_name)) {
            this.k.setVisibility(8);
        } else {
            this.k.setText(bluedCreatedGroupInfo.groups_name);
        }
        if (StringUtils.d(bluedCreatedGroupInfo.groups_gid)) {
            this.l.setVisibility(8);
        } else {
            this.l.setText(bluedCreatedGroupInfo.groups_gid);
        }
        if (StringUtils.d(bluedCreatedGroupInfo.groups_members_count) && StringUtils.d(bluedCreatedGroupInfo.groups_members_total)) {
            this.m.setVisibility(8);
        } else {
            TextView textView = this.m;
            textView.setText(" " + StringUtils.a(bluedCreatedGroupInfo.groups_members_count) + "/" + StringUtils.a(bluedCreatedGroupInfo.groups_members_total) + " ");
        }
        if (StringUtils.d(bluedCreatedGroupInfo.groups_description)) {
            this.p.setVisibility(8);
            this.n.setVisibility(8);
        } else {
            this.p.setText(bluedCreatedGroupInfo.groups_description);
            this.n.setText(bluedCreatedGroupInfo.groups_description);
        }
        if (StringUtils.d(bluedCreatedGroupInfo.groups_city)) {
            this.o.setVisibility(8);
        } else {
            this.o.setText(AreaUtils.getAreaTxt(bluedCreatedGroupInfo.groups_city, BlueAppLocal.c()));
        }
        ImageLoader.a(getFragmentActive(), bluedCreatedGroupInfo.created_avatar).c().b(2131237310).a(this.q);
        this.r.setVisibility(0);
        this.av.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bluedCreatedGroupInfo.groups_admins.size()) {
                break;
            }
            BluedGroupAllMembers bluedGroupAllMembers = new BluedGroupAllMembers();
            bluedGroupAllMembers.is_admin = "1";
            bluedGroupAllMembers.avatar = bluedCreatedGroupInfo.groups_admins.get(i2).users_avatar;
            this.av.add(bluedGroupAllMembers);
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= bluedCreatedGroupInfo.groups_members.size()) {
                break;
            }
            BluedGroupAllMembers bluedGroupAllMembers2 = new BluedGroupAllMembers();
            bluedGroupAllMembers2.is_admin = "0";
            bluedGroupAllMembers2.avatar = bluedCreatedGroupInfo.groups_members.get(i4).users_avatar;
            this.av.add(bluedGroupAllMembers2);
            i3 = i4 + 1;
        }
        a(this.av);
        if (this.b.c()) {
            this.R.setVisibility(0);
            this.as.setVisibility(8);
            this.X.setVisibility(8);
            this.at.setVisibility(8);
            this.ai.setVisibility(0);
            this.Y.setVisibility(0);
            if (StringUtils.d(this.g) || !this.g.equals(MsgChattingFragment.class.getSimpleName())) {
                this.V.setText(R.string.chat_start);
                this.V.setVisibility(0);
            } else {
                this.V.setVisibility(8);
            }
            if ("1".equals(bluedCreatedGroupInfo.groups_is_created)) {
                if (bluedCreatedGroupInfo.groups_is_locked == 1) {
                    this.Z.setVisibility(0);
                }
                this.ab.setVisibility(0);
                this.U.setText(R.string.btn_dismissgroup);
                this.aa.setVisibility(0);
                this.ac.setVisibility(0);
                this.T.setVisibility(8);
                this.ad.setVisibility(8);
                this.af.setVisibility(0);
                this.ae.setVisibility(0);
                if (2 == bluedCreatedGroupInfo.vbadge) {
                    UserInfoHelper.a(this.af, bluedCreatedGroupInfo.vbadge, 3);
                }
            } else {
                this.Z.setVisibility(8);
                if ("1".equals(bluedCreatedGroupInfo.groups_is_admins)) {
                    this.ab.setVisibility(0);
                    this.aa.setVisibility(0);
                    this.U.setText(R.string.btn_quitgroup);
                    this.T.setVisibility(0);
                    this.ad.setVisibility(0);
                    this.ag.setVisibility(0);
                    this.af.setVisibility(0);
                    this.ae.setVisibility(0);
                    this.P.setEnabled(true);
                    this.ai.setEnabled(true);
                    if (2 == bluedCreatedGroupInfo.vbadge) {
                        UserInfoHelper.a(this.af, bluedCreatedGroupInfo.vbadge, 3);
                    }
                } else {
                    this.U.setText(R.string.btn_quitgroup);
                    this.P.setEnabled(false);
                    this.ab.setVisibility(8);
                    this.ai.setEnabled(false);
                    this.ae.setVisibility(8);
                    this.ad.setVisibility(8);
                    if (2 == bluedCreatedGroupInfo.vbadge) {
                        UserInfoHelper.a(this.af, 2, 3);
                    } else {
                        this.af.setVisibility(8);
                    }
                    if (StringUtils.d(bluedCreatedGroupInfo.groups_avatar)) {
                        this.j.setEnabled(false);
                    } else {
                        this.j.setEnabled(true);
                    }
                }
            }
        } else {
            this.R.setVisibility(8);
            this.n.setVisibility(0);
            this.X.setVisibility(0);
            this.as.setVisibility(0);
            this.at.setVisibility(0);
            this.ai.setVisibility(8);
            this.Y.setVisibility(8);
            this.ao.setVisibility(8);
            this.Z.setVisibility(8);
            this.ab.setVisibility(8);
            this.U.setVisibility(8);
            this.V.setText(R.string.btn_joingroup);
            this.ah.setVisibility(8);
            this.P.setEnabled(false);
            if (!StringUtils.d(this.h)) {
                this.V.setText(R.string.group_join_agree);
            }
            if (2 == bluedCreatedGroupInfo.vbadge) {
                UserInfoHelper.a(this.af, 2, 3);
            } else {
                this.af.setVisibility(8);
            }
            if (StringUtils.d(bluedCreatedGroupInfo.groups_avatar)) {
                this.j.setEnabled(false);
            } else {
                this.j.setEnabled(true);
            }
        }
        if (bluedCreatedGroupInfo.groups_is_locked == 1) {
            this.al.setVisibility(0);
            this.ah.setVisibility(8);
            this.ac.setVisibility(8);
            this.V.setVisibility(8);
            this.ab.setVisibility(8);
            this.ae.setVisibility(8);
            this.aa.setVisibility(8);
            this.T.setVisibility(8);
            this.ad.setVisibility(8);
            this.am.setVisibility(8);
            this.i.a();
            this.ak.setEnabled(false);
            this.N.setEnabled(false);
            this.aj.setEnabled(false);
            this.ai.setEnabled(false);
            this.P.setEnabled(false);
            this.j.setEnabled(false);
            this.m.setEnabled(false);
            this.O.setEnabled(false);
            this.I.setEnabled(false);
            this.J.setEnabled(false);
            this.K.setEnabled(false);
            this.L.setEnabled(false);
            this.M.setEnabled(false);
        }
        this.ap.setVisibility(0);
    }

    @Override // com.soft.blued.ui.group.contract.IGroupInfoContract.IView
    public void a(String str) {
        ImageLoader.d(getFragmentActive(), str).c().b(2131237310).a(this.j);
    }

    @Override // com.soft.blued.ui.group.contract.IGroupInfoContract.IView
    public void a(final boolean z) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.group.fragment.GroupInfoFragment.7
            @Override // java.lang.Runnable
            public void run() {
                GroupInfoFragment.this.W.setChecked(z);
            }
        });
    }

    @Override // com.soft.blued.ui.group.contract.IGroupInfoContract.IView
    public void a(String[] strArr) {
        BasePhotoFragment.a(this.f17268c, strArr, 0, 2, this.e);
    }

    @Override // com.soft.blued.ui.group.contract.IGroupInfoContract.IView
    public void b() {
        PhotoSelectFragment.a(this, 3, 22);
    }

    @Override // com.soft.blued.ui.group.contract.IGroupInfoContract.IView
    public void c() {
        try {
            this.b.g();
            AppMethods.d((int) R.string.btn_dismissgroup_prompt);
            UserInfo.getInstance().getLoginUserInfo().setGroupsCount(-1);
            CommonDataRefreshObserver.a().b();
            if (MsgChattingFragment.class.getSimpleName().equals(this.g)) {
                HomeArgumentHelper.a(getActivity(), "msg", (Bundle) null);
            } else {
                getActivity().finish();
            }
        } catch (Exception e) {
            AppMethods.d(2131887272);
            e.printStackTrace();
        }
    }

    @Override // com.soft.blued.ui.group.contract.IGroupInfoContract.IView
    public void d() {
        AppMethods.d((int) R.string.btn_quitgroup_prompt);
        UserInfo.getInstance().getLoginUserInfo().setGroupsCount(-1);
        CommonDataRefreshObserver.a().b();
        ChatManager.getInstance().deleteSessionAndChatting((short) 3, Long.parseLong(this.au.groups_gid));
        if (MsgChattingFragment.class.getSimpleName().equals(this.g)) {
            HomeArgumentHelper.a(getActivity(), "msg", (Bundle) null);
        } else {
            getActivity().finish();
        }
    }

    @Override // com.soft.blued.ui.group.contract.IGroupInfoContract.IView
    public void e() {
        BluedCreatedGroupInfo bluedCreatedGroupInfo = this.au;
        if (bluedCreatedGroupInfo == null || bluedCreatedGroupInfo == null) {
            return;
        }
        LogData logData = new LogData();
        logData.from = "none";
        ChatHelperV4.a().a(this.f17268c, Long.parseLong(bluedCreatedGroupInfo.groups_gid), bluedCreatedGroupInfo.groups_name, bluedCreatedGroupInfo.groups_avatar, bluedCreatedGroupInfo.vbadge, 0, 0, 0, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
        getActivity().finish();
    }

    @Override // com.soft.blued.ui.group.contract.IGroupInfoContract.IView
    public void f() {
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.group.fragment.GroupInfoFragment.8
            @Override // java.lang.Runnable
            public void run() {
                GroupInfoFragment.this.ap.setVisibility(8);
                GroupInfoFragment.this.f17267ar.setVisibility(8);
                GroupInfoFragment.this.aq.a();
                GroupInfoFragment.this.i.a();
            }
        });
    }

    @Override // com.soft.blued.ui.group.contract.IGroupInfoContract.IView
    public void g() {
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.group.fragment.GroupInfoFragment.9
            @Override // java.lang.Runnable
            public void run() {
                GroupInfoFragment.this.V.setText(R.string.btn_joingroup);
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 22) {
                if (i == 1000) {
                    if (intent != null && !StringUtils.d(intent.getStringExtra("name"))) {
                        this.b.g(intent.getStringExtra("name"));
                    }
                    if (intent != null && !StringUtils.d(intent.getStringExtra("icon"))) {
                        String stringExtra = intent.getStringExtra("icon");
                        ImageLoader.d(getFragmentActive(), stringExtra).c().b(2131237310).a(this.j);
                        this.b.h(stringExtra);
                    }
                } else if (i == 2000) {
                    if (intent != null && !StringUtils.d(intent.getStringExtra(MediaFormat.KEY_PROFILE))) {
                        this.p.setText(intent.getStringExtra(MediaFormat.KEY_PROFILE));
                        this.n.setText(intent.getStringExtra(MediaFormat.KEY_PROFILE));
                    }
                    this.b.f(intent.getStringExtra(MediaFormat.KEY_PROFILE));
                } else if (i != 3000) {
                    if (i == 4000) {
                        this.b.a(false);
                    } else if (i == 5000) {
                        this.b.a(false);
                    } else if (i == 6000) {
                        this.b.d((intent == null || StringUtils.d(intent.getStringExtra("string_edit"))) ? "" : intent.getStringExtra("string_edit"));
                    } else if (i == 7000) {
                        this.b.a(false);
                    } else if (i == 8000) {
                        this.b.a(false);
                    } else if (i == 9000) {
                        onBackPressed();
                    }
                } else if (intent != null && !StringUtils.d(intent.getStringExtra("areacode"))) {
                    this.b.e(intent.getStringExtra("areacode"));
                }
            } else if (intent != null) {
                this.b.a(intent.getStringExtra("photo_path"));
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public boolean onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("passby_nick_name", this.k.getText().toString());
        getActivity().setResult(-1, intent);
        getActivity().finish();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == 2131363120) {
            onBackPressed();
        } else if (this.au == null) {
        } else {
            switch (view.getId()) {
                case R.id.bt_chat_start /* 2131362504 */:
                    if (this.b.h()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("gid", this.au.groups_gid);
                        if (!StringUtils.d(this.g)) {
                            InstantLog.a("join_group", (Object) this.g);
                        }
                        TerminalActivity.d(getActivity(), GroupJoinVerifyFragment.class, bundle);
                        return;
                    } else if (!StringUtils.d(this.h) && "0".equals(this.au.groups_in_members)) {
                        this.b.c(this.h);
                        return;
                    } else if ("1".equals(this.au.groups_in_members)) {
                        e();
                        return;
                    } else {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("gid", this.au.groups_gid);
                        if (!StringUtils.d(this.g)) {
                            InstantLog.a("join_group", (Object) this.g);
                        }
                        TerminalActivity.d(getActivity(), GroupJoinVerifyFragment.class, bundle2);
                        return;
                    }
                case R.id.btn_group_options /* 2131362588 */:
                    String str = this.au.created_uid;
                    if (StringUtils.d(str)) {
                        return;
                    }
                    if (UserInfo.getInstance().getLoginUserInfo().getUid().equals(str)) {
                        Context context = this.f17268c;
                        CommonAlertDialog.a(context, context.getResources().getString(R.string.common_string_notice), this.f17268c.getResources().getString(R.string.group_dismiss_dialog), this.f17268c.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.group.fragment.GroupInfoFragment.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Tracker.onClick(dialogInterface, i);
                                GroupInfoFragment.this.b.e();
                            }
                        }, this.f17268c.getResources().getString(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                        return;
                    } else if ("1".equals(this.au.groups_in_members)) {
                        Context context2 = this.f17268c;
                        CommonAlertDialog.a(context2, context2.getResources().getString(R.string.common_string_notice), this.f17268c.getResources().getString(R.string.group_quit_dialog), this.f17268c.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.group.fragment.GroupInfoFragment.5
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Tracker.onClick(dialogInterface, i);
                                GroupInfoFragment.this.b.f();
                            }
                        }, this.f17268c.getResources().getString(R.string.common_cancel), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.group.fragment.GroupInfoFragment.6
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Tracker.onClick(dialogInterface, i);
                            }
                        }, (DialogInterface.OnDismissListener) null);
                        return;
                    } else {
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("gid", this.au.groups_gid);
                        if (!StringUtils.d(this.g)) {
                            InstantLog.a("join_group", (Object) this.g);
                        }
                        TerminalActivity.d(getActivity(), GroupJoinVerifyFragment.class, bundle3);
                        return;
                    }
                case R.id.chat_setting_bg /* 2131362822 */:
                    LabeledTextView labeledTextView = this.R;
                    if (labeledTextView != null) {
                        labeledTextView.a((Boolean) false);
                    }
                    GroupInfoPresenter groupInfoPresenter = this.b;
                    if (groupInfoPresenter != null) {
                        groupInfoPresenter.a(this, 9000);
                        return;
                    }
                    return;
                case 2131363126:
                    this.b.a(this.k.getText().toString(), this.j);
                    return;
                case R.id.iv_group_profile_pic /* 2131365467 */:
                    this.b.b();
                    return;
                case R.id.liner_group_admins_set /* 2131366882 */:
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("gid", this.au.groups_gid);
                    if (!StringUtils.d(this.au.groups_admins_total)) {
                        bundle4.putString("admin_total", this.au.groups_admins_total);
                    }
                    if (!StringUtils.d(this.au.groups_admins_count)) {
                        bundle4.putString("admin_amount", this.au.groups_admins_count);
                    }
                    TerminalActivity.a(this, GroupAdminSetFragment.class, bundle4, (int) TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY);
                    return;
                case R.id.liner_group_clear_chat /* 2131366884 */:
                    CommonAlertDialog.a(this.f17268c, getString(R.string.common_string_notice), getString(R.string.biao_v4_chat_clearchat), getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.group.fragment.GroupInfoFragment.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            GroupInfoFragment.this.b.d();
                            AppMethods.d((int) R.string.group_chat_delete_success);
                        }
                    }, getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                    return;
                case R.id.liner_group_count_set /* 2131366885 */:
                    Bundle bundle5 = new Bundle();
                    bundle5.putString("gid", this.au.groups_gid);
                    bundle5.putInt("up_group_type", this.au.vbadge);
                    bundle5.putString("up_group_total", this.au.groups_members_total);
                    bundle5.putInt("groups_member_vip", this.au.groups_member_vip);
                    TerminalActivity.a(this, GroupUpdateCountFragment.class, bundle5, 8000);
                    return;
                case R.id.ll_group_info_custom_service /* 2131367849 */:
                    ServiceHelper.f19954a.a(this.f17268c);
                    return;
                case R.id.ll_group_intro /* 2131367850 */:
                    if (StringUtils.d(this.au.groups_is_created) || StringUtils.d(this.au.groups_is_admins)) {
                        return;
                    }
                    if (("1".equals(this.au.groups_is_created) || "1".equals(this.au.groups_is_admins)) && !PopMenuUtils.a(this.f17268c)) {
                        Bundle bundle6 = new Bundle();
                        bundle6.putString(MediaFormat.KEY_PROFILE, this.p.getText().toString());
                        TerminalActivity.a(this, ModifyGroupProfileFragment.class, bundle6, 2000);
                        return;
                    }
                    return;
                case R.id.ll_group_member /* 2131367855 */:
                    j();
                    return;
                case R.id.ll_group_member_lists /* 2131367857 */:
                    j();
                    return;
                case R.id.ll_group_name_icon /* 2131367862 */:
                    if (StringUtils.d(this.au.groups_is_created) || StringUtils.d(this.au.groups_is_admins)) {
                        return;
                    }
                    if (("1".equals(this.au.groups_is_created) || "1".equals(this.au.groups_is_admins)) && !PopMenuUtils.a(this.f17268c)) {
                        Bundle bundle7 = new Bundle();
                        bundle7.putString("icon", this.au.groups_avatar);
                        bundle7.putString("name", this.k.getText().toString());
                        bundle7.putString("gid", this.au.groups_gid);
                        TerminalActivity.a(this, GroupEditNameIconFragment.class, bundle7, 1000);
                        return;
                    }
                    return;
                case R.id.ll_group_term /* 2131367876 */:
                    WebViewShowInfoFragment.show(this.f17268c, H5Url.a(27), 0);
                    return;
                case R.id.ll_groupinfo_location /* 2131367881 */:
                    if (StringUtils.d(this.au.groups_is_created) || StringUtils.d(this.au.groups_is_admins)) {
                        return;
                    }
                    if ("1".equals(this.au.groups_is_created) || "1".equals(this.au.groups_is_admins)) {
                        Bundle bundle8 = new Bundle();
                        bundle8.putString("currentLoc", this.o.getText().toString());
                        bundle8.putString("locTitle", this.f17268c.getResources().getString(R.string.group_location_modification));
                        ChooseCountryFragment.a(this, 3000);
                        return;
                    }
                    return;
                case R.id.tv_group_report /* 2131371633 */:
                    if (this.au == null) {
                        return;
                    }
                    ReportFragmentNew.a(getActivity(), 4, this.au.groups_gid, this.au.groups_name);
                    return;
                default:
                    return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f17268c = getActivity();
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_group_info, (ViewGroup) null);
            this.b = new GroupInfoPresenter(this.f17268c, this, this.e, getFragmentActive());
            a(this.d);
            i();
            h();
            this.b.a(true);
        } else {
            ((ViewGroup) view.getParent()).removeView(this.d);
        }
        a(this.d);
        return this.d;
    }
}
