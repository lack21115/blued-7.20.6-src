package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.ad.ADConstants;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.customview.BluedADConstraintLayout;
import com.soft.blued.databinding.FragmentUserinfoNewProfileBinding;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.live.view.SwipeAnchorBadge;
import com.soft.blued.ui.msg.event.OpenGiftPackageEvent;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.pop.UserGiftDialogFragment;
import com.soft.blued.ui.msg_group.fragment.GroupInfoFragment;
import com.soft.blued.ui.user.adapter.UserMedalsAdapter;
import com.soft.blued.ui.user.adapter.UserProfileGiftdapter;
import com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.UserGift;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserinfoFragmentProfileTab.class */
public class UserinfoFragmentProfileTab extends BaseFragment {
    private ImageView A;
    private ImageView B;
    private LinearLayout C;
    private RecyclerView D;
    private LayoutInflater E;
    private ImageView F;
    private TextView G;
    private ViewGroup H;
    private ViewGroup I;
    private ViewGroup J;
    private UserInfoEntity K;
    private boolean L = false;
    private boolean M = false;
    private LinearLayout N;
    private TextView O;
    private TextView P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private FlowLayout U;
    private FlowLayout V;
    private FlowLayout W;
    private FlowLayout X;
    private FlowLayout Y;
    private FlowLayout Z;

    /* renamed from: a  reason: collision with root package name */
    public Context f20395a;
    private TextView aa;
    private TextView ab;
    private FragmentUserinfoNewProfileBinding ac;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    private BannerADView f20396c;
    private BluedADConstraintLayout d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private LinearLayout o;
    private FrameLayout p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private LinearLayout y;
    private LinearLayout z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab$8  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserinfoFragmentProfileTab$8.class */
    public class AnonymousClass8 extends BluedUIHttpResponse<BluedEntityA<UserGift>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserInfoEntity f20405a;
        final /* synthetic */ TextView b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView f20406c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(IRequestHost iRequestHost, UserInfoEntity userInfoEntity, TextView textView, RecyclerView recyclerView) {
            super(iRequestHost);
            this.f20405a = userInfoEntity;
            this.b = textView;
            this.f20406c = recyclerView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(UserInfoEntity userInfoEntity, View view, int i) {
            UserinfoFragmentProfileTab.this.F.setVisibility(8);
            if (!BluedPreferences.aR() && UserInfo.getInstance().getLoginUserInfo().uid.equals(userInfoEntity.uid)) {
                BluedPreferences.aS();
            }
            if (!userInfoEntity.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
                UserGiftDialogFragment.a(UserinfoFragmentProfileTab.this.getActivity(), UserinfoFragmentProfileTab.this.getFragmentActive(), userInfoEntity.uid, "user_page_gift", new UserGiftDialogFragment.BuySucceedListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab.8.1
                    @Override // com.soft.blued.ui.msg.pop.UserGiftDialogFragment.BuySucceedListener
                    public void a(UserGiftDialogFragment userGiftDialogFragment, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
                        userGiftDialogFragment.dismiss();
                        ((UserInfoFragmentNew) UserinfoFragmentProfileTab.this.getParentFragment()).a(giftGivingOptionForJsonParse);
                    }
                }, userInfoEntity.relationship, userInfoEntity.name, new int[0]);
                return;
            }
            WebViewShowInfoFragment.show(UserinfoFragmentProfileTab.this.f20395a, H5Url.a(44), 0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<UserGift> bluedEntityA) {
            if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData() == null) {
                this.f20406c.setVisibility(8);
                return;
            }
            if (((UserGift) bluedEntityA.getSingleData()).number != 0) {
                this.b.setText(StringUtils.a(((UserGift) bluedEntityA.getSingleData()).number + ""));
            } else if (TextUtils.equals(UserInfo.getInstance().getLoginUserInfo().uid, this.f20405a.uid)) {
                this.b.setText(UserinfoFragmentProfileTab.this.f20395a.getResources().getString(R.string.you_no_gift_yet));
            } else {
                this.b.setText(UserinfoFragmentProfileTab.this.f20395a.getResources().getString(R.string.he_no_gift_yet));
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(((UserGift) bluedEntityA.getSingleData()).gift_list);
            UserProfileGiftdapter userProfileGiftdapter = new UserProfileGiftdapter(UserinfoFragmentProfileTab.this.getFragmentActive(), UserinfoFragmentProfileTab.this.f20395a, arrayList);
            final UserInfoEntity userInfoEntity = this.f20405a;
            userProfileGiftdapter.a(new UserProfileGiftdapter.RecyclerViewItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserinfoFragmentProfileTab$8$xbX2GDOKwI5WE69f3ALUbu_aaps
                @Override // com.soft.blued.ui.user.adapter.UserProfileGiftdapter.RecyclerViewItemClickListener
                public final void onItemClick(View view, int i) {
                    UserinfoFragmentProfileTab.AnonymousClass8.this.a(userInfoEntity, view, i);
                }
            });
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UserinfoFragmentProfileTab.this.f20395a);
            linearLayoutManager.setStackFromEnd(true);
            linearLayoutManager.setOrientation(0);
            linearLayoutManager.scrollToPosition(0);
            this.f20406c.setLayoutManager(linearLayoutManager);
            this.f20406c.setHasFixedSize(true);
            this.f20406c.setAdapter(userProfileGiftdapter);
            userProfileGiftdapter.notifyDataSetChanged();
            if (userProfileGiftdapter.getItemCount() > 0) {
                this.f20406c.setVisibility(0);
            } else {
                this.f20406c.setVisibility(8);
            }
        }

        public boolean onUIFailure(int i, String str) {
            this.f20406c.setVisibility(8);
            return super.onUIFailure(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PROFILE_GIFT_LIST_CLICK);
        WebViewShowInfoFragment.show(this.f20395a, H5Url.a(44), 0);
        this.F.setVisibility(8);
        if (BluedPreferences.aR()) {
            return;
        }
        BluedPreferences.aS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        UserGiftDialogFragment.a(getActivity(), getFragmentActive(), userInfoEntity.uid, "user_page_gift", new UserGiftDialogFragment.BuySucceedListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab.7
            @Override // com.soft.blued.ui.msg.pop.UserGiftDialogFragment.BuySucceedListener
            public void a(UserGiftDialogFragment userGiftDialogFragment, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
                userGiftDialogFragment.dismiss();
                ((UserInfoFragmentNew) UserinfoFragmentProfileTab.this.getParentFragment()).a(giftGivingOptionForJsonParse);
            }
        }, userInfoEntity.relationship, userInfoEntity.name, new int[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(UserInfoEntity userInfoEntity, View view, int i) {
        SwipeAnchorBadge.a(this.f20395a, userInfoEntity.uid, i, getFragmentActive());
    }

    private boolean a(String str) {
        return SubscribeNumberManager.f18759a.a(str, (Short) 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(getActivity(), H5Url.a(26), -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(getActivity(), BluedHttpUrl.c(userInfoEntity.uid), -1);
    }

    private void b(List<GroupInfoModel> list, FlowLayout flowLayout) {
        if (list == null || list.size() <= 0) {
            return;
        }
        flowLayout.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            final GroupInfoModel groupInfoModel = list.get(i2);
            View inflate = this.E.inflate(R.layout.user_profile_groups_tag, (ViewGroup) null);
            ((TextView) inflate.findViewById(2131372684)).setText(groupInfoModel.group_title);
            flowLayout.addView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    Context context = UserinfoFragmentProfileTab.this.getContext();
                    GroupInfoFragment.a(context, groupInfoModel.group_id + "", groupInfoModel, SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE);
                }
            });
            i = i2 + 1;
        }
    }

    private boolean b() {
        UserInfoEntity userInfoEntity = this.K;
        if (userInfoEntity == null || a(userInfoEntity.uid)) {
            return false;
        }
        if (TextUtils.isEmpty(this.K.health_test_result) || TextUtils.equals(this.K.health_test_result, "0") || TextUtils.equals(this.K.health_test_result, "-1")) {
            if (TextUtils.isEmpty(this.K.health_test_time) || TextUtils.equals(this.K.health_test_time, "0") || TextUtils.equals(this.K.health_test_time, "-1")) {
                return (TextUtils.isEmpty(this.K.health_prpe_use_situation) || TextUtils.equals(this.K.health_prpe_use_situation, "0") || TextUtils.equals(this.K.health_prpe_use_situation, "-1")) ? false : true;
            }
            return true;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_OPEN_GIFT_PACKAGE, OpenGiftPackageEvent.class).observe(this, new Observer<OpenGiftPackageEvent>() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(OpenGiftPackageEvent openGiftPackageEvent) {
                if (openGiftPackageEvent.f18638a == null || !openGiftPackageEvent.f18638a.equals(UserinfoFragmentProfileTab.this.getFragmentActive())) {
                    return;
                }
                UserGiftDialogFragment.a(UserinfoFragmentProfileTab.this.getContext(), UserinfoFragmentProfileTab.this.getFragmentActive(), UserinfoFragmentProfileTab.this.K.uid, "chat_page_gift", new UserGiftDialogFragment.BuySucceedListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab.2.1
                    @Override // com.soft.blued.ui.msg.pop.UserGiftDialogFragment.BuySucceedListener
                    public void a(UserGiftDialogFragment userGiftDialogFragment, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
                        userGiftDialogFragment.dismiss();
                        ((UserInfoFragmentNew) UserinfoFragmentProfileTab.this.getParentFragment()).a(giftGivingOptionForJsonParse);
                    }
                }, UserinfoFragmentProfileTab.this.K.relationship, UserinfoFragmentProfileTab.this.K.name, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        this.p.setVisibility(8);
        BluedPreferences.cQ();
        HealthDialogFragment.a(this.f20395a);
    }

    private void d() {
        this.f20396c = (BannerADView) this.b.findViewById(R.id.bannerView);
        this.d = (BluedADConstraintLayout) this.b.findViewById(R.id.ad_view_layout);
        this.e = (TextView) this.b.findViewById(R.id.tv_constellation);
        this.f = (TextView) this.b.findViewById(R.id.tv_constellation_title);
        this.g = (TextView) this.b.findViewById(R.id.tv_relationship);
        this.h = (TextView) this.b.findViewById(R.id.tv_relationship_title);
        this.i = (TextView) this.b.findViewById(R.id.tv_bloodtype);
        this.j = (TextView) this.b.findViewById(R.id.tv_bloodtype_title);
        this.k = (TextView) this.b.findViewById(R.id.tv_health_title);
        this.l = (TextView) this.b.findViewById(R.id.tv_health_result);
        this.m = (TextView) this.b.findViewById(R.id.tv_health_time);
        this.n = (TextView) this.b.findViewById(R.id.tv_health_prep);
        this.o = (LinearLayout) this.b.findViewById(R.id.ll_health_details);
        this.q = (TextView) this.b.findViewById(R.id.tv_register);
        this.r = (TextView) this.b.findViewById(R.id.tv_register_title);
        this.p = (FrameLayout) this.b.findViewById(R.id.fl_health_tips);
        this.s = (TextView) this.b.findViewById(R.id.tv_hometown);
        this.t = (TextView) this.b.findViewById(R.id.tv_hometown_title);
        this.u = (TextView) this.b.findViewById(R.id.tv_goal);
        this.v = (TextView) this.b.findViewById(R.id.tv_goal_title);
        this.w = (TextView) this.b.findViewById(R.id.tv_job);
        this.x = (TextView) this.b.findViewById(R.id.tv_job_title);
        this.N = (LinearLayout) this.b.findViewById(R.id.ll_tags);
        this.y = (LinearLayout) this.b.findViewById(R.id.ll_rich_rank);
        this.z = (LinearLayout) this.b.findViewById(R.id.ll_anchor_rank);
        this.A = (ImageView) this.b.findViewById(R.id.img_rich_rank);
        this.B = (ImageView) this.b.findViewById(R.id.img_anchor_rank);
        this.C = (LinearLayout) this.b.findViewById(R.id.ll_medals_all);
        this.D = (RecyclerView) this.b.findViewById(R.id.lv_medals);
        this.aa = (TextView) this.b.findViewById(R.id.my_tags_title);
        this.ab = (TextView) this.b.findViewById(R.id.tv_lookfor_tags_title);
        this.O = (TextView) this.b.findViewById(R.id.tv_my_figure);
        this.P = (TextView) this.b.findViewById(R.id.tv_my_chara);
        this.Q = (TextView) this.b.findViewById(R.id.tv_my_hobby);
        this.R = (TextView) this.b.findViewById(R.id.tv_my_entertainment);
        this.S = (TextView) this.b.findViewById(R.id.tv_lookfor_figure);
        this.T = (TextView) this.b.findViewById(R.id.tv_lookfor_chara);
        this.U = this.b.findViewById(R.id.flow_my_figure);
        this.V = this.b.findViewById(R.id.flow_my_chara);
        this.W = this.b.findViewById(R.id.flow_my_hobby);
        this.X = this.b.findViewById(R.id.flow_my_entertainment);
        this.Y = this.b.findViewById(R.id.flow_lookfor_figure);
        this.Z = this.b.findViewById(R.id.flow_lookfor_chara);
        this.F = (ImageView) this.b.findViewById(R.id.img_his_gift_red_dot);
        this.G = (TextView) this.b.findViewById(R.id.tv_personal_info);
        this.H = (ViewGroup) this.b.findViewById(R.id.lay_personal_info);
        this.I = (ViewGroup) this.b.findViewById(R.id.lay_tags);
        this.J = (ViewGroup) this.b.findViewById(R.id.lay_lookfor_tags);
    }

    private void f(UserInfoEntity userInfoEntity) {
        if (this.ac == null) {
            return;
        }
        if (userInfoEntity.is_access_groups.equals("0") || userInfoEntity.mine_group == null || userInfoEntity.mine_group.size() == 0) {
            this.ac.t.setVisibility(8);
            return;
        }
        this.ac.t.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (GroupInfoModel groupInfoModel : userInfoEntity.mine_group) {
            if (groupInfoModel.group_role == 1) {
                arrayList.add(groupInfoModel);
            } else {
                arrayList2.add(groupInfoModel);
            }
        }
        if (arrayList.size() == 0) {
            this.ac.Z.setVisibility(8);
            this.ac.j.setVisibility(8);
        } else {
            this.ac.Z.setVisibility(0);
            this.ac.j.setVisibility(0);
            b(arrayList, this.ac.j);
        }
        if (arrayList2.size() == 0) {
            this.ac.S.setVisibility(8);
            this.ac.d.setVisibility(8);
            return;
        }
        this.ac.S.setVisibility(0);
        this.ac.d.setVisibility(0);
        b(arrayList2, this.ac.d);
    }

    private void g(UserInfoEntity userInfoEntity) {
        Log.v("drb", "服务端返回 userInfo.health_test_result：" + userInfoEntity.health_test_result + " -- userInfo.health_test_time：" + userInfoEntity.health_test_time + " -- userInfo.health_prpe_use_situation：" + userInfoEntity.health_prpe_use_situation);
        if (b()) {
            this.o.setVisibility(0);
            this.k.setVisibility(0);
            if (StringUtils.d(userInfoEntity.health_test_result)) {
                this.l.setVisibility(8);
            } else if (TextUtils.equals(userInfoEntity.health_test_result, "-1")) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                this.l.setText(UserRelationshipUtils.e().get(userInfoEntity.health_test_result));
            }
            if (StringUtils.d(userInfoEntity.health_test_time) || TextUtils.equals(userInfoEntity.health_test_time, "-1") || TextUtils.equals(userInfoEntity.health_test_time, "0")) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                if (TextUtils.equals(userInfoEntity.health_test_time, "1")) {
                    TextView textView = this.m;
                    textView.setText(getString(R.string.hiv_detection_time14) + getString(R.string.hiv_detection_time_test));
                } else if (TextUtils.equals(userInfoEntity.health_test_time, "-1")) {
                    this.m.setVisibility(8);
                } else {
                    TextView textView2 = this.m;
                    textView2.setText(TimeAndDateUtils.e(userInfoEntity.health_test_time) + getString(R.string.hiv_detection_time_test));
                }
            }
            if (StringUtils.d(userInfoEntity.health_prpe_use_situation)) {
                this.n.setVisibility(8);
            } else if (TextUtils.equals(userInfoEntity.health_prpe_use_situation, "-1")) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.n.setText(UserRelationshipUtils.f().get(userInfoEntity.health_prpe_use_situation));
            }
        } else {
            this.o.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        }
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                HealthDialogFragment.a(UserinfoFragmentProfileTab.this.f20395a);
            }
        });
    }

    public void a() {
        if (this.K.ads_banner == null || this.K.ads_banner.size() <= 0) {
            this.f20396c.b();
            return;
        }
        this.f20396c.a(getFragmentActive(), this.K.ads_banner.get(0), ADConstants.AD_POSITION.USER_PROFILE_TAB, new BannerADView.ADListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab.3
            @Override // com.soft.blued.customview.BannerADView.ADListener
            public void a() {
                UserinfoFragmentProfileTab.this.f20396c.b();
            }

            @Override // com.soft.blued.customview.BannerADView.ADListener
            public void b() {
                if (UserinfoFragmentProfileTab.this.f20396c != null) {
                    UserinfoFragmentProfileTab.this.f20396c.b();
                }
            }
        });
        this.d.setADData(this.K.ads_banner.get(0));
    }

    public void a(UserInfoEntity userInfoEntity) {
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid)) {
            return;
        }
        this.K = userInfoEntity;
        b(userInfoEntity);
        if (this.f20395a == null || this.L) {
            return;
        }
        this.L = true;
        a();
    }

    public void a(List<UserTag> list, FlowLayout flowLayout) {
        if (list == null || list.size() <= 0) {
            return;
        }
        flowLayout.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            View inflate = this.E.inflate(R.layout.user_profile_tag, (ViewGroup) null);
            ((TextView) inflate.findViewById(2131372684)).setText(list.get(i2).name);
            flowLayout.addView(inflate);
            i = i2 + 1;
        }
    }

    public void b(final UserInfoEntity userInfoEntity) {
        String a2;
        String areaTxt;
        String a3;
        String str;
        String str2;
        if (UserInfo.getInstance().getLoginUserInfo().getUid().equals(userInfoEntity.uid)) {
            this.M = true;
        }
        this.f20395a = getActivity();
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid) || !getFragmentActive().isActive() || this.f20395a == null) {
            return;
        }
        if ((userInfoEntity.vbadge == 3 || userInfoEntity.vbadge == 5 || a(userInfoEntity.uid)) && !this.M) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
        }
        String a4 = StringUtils.a(this.f20395a.getResources().getStringArray(R.array.constellation), this.f20395a.getResources().getStringArray(R.array.constellation_key), userInfoEntity.astro);
        if (StringUtils.d(a4) || ((userInfoEntity.vbadge == 3 || userInfoEntity.vbadge == 5 || a(userInfoEntity.uid)) && !this.M)) {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        } else {
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.e.setText(a4);
        }
        if (userInfoEntity.tags == null || userInfoEntity.tags.work == null || userInfoEntity.tags.work.size() == 0 || ((userInfoEntity.vbadge == 3 || userInfoEntity.vbadge == 5 || a(userInfoEntity.uid)) && !this.M)) {
            this.x.setVisibility(8);
            this.w.setVisibility(8);
        } else {
            this.x.setVisibility(0);
            this.w.setVisibility(0);
            String str3 = "";
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= userInfoEntity.tags.work.size()) {
                    break;
                }
                if (i2 == 0) {
                    str2 = ((UserTag) userInfoEntity.tags.work.get(i2)).name;
                } else {
                    str2 = str3 + "、" + ((UserTag) userInfoEntity.tags.work.get(i2)).name;
                }
                str3 = str2;
                i = i2 + 1;
            }
            this.w.setText(str3);
        }
        if (userInfoEntity.tags == null || userInfoEntity.tags.i_want == null || userInfoEntity.tags.i_want.size() <= 0) {
            this.v.setVisibility(8);
            this.u.setVisibility(8);
        } else if ((userInfoEntity.vbadge == 3 || userInfoEntity.vbadge == 5 || a(userInfoEntity.uid)) && !this.M) {
            this.v.setVisibility(8);
            this.u.setVisibility(8);
        } else {
            String str4 = "";
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= userInfoEntity.tags.i_want.size()) {
                    break;
                }
                if (i4 == 0) {
                    str = ((UserTag) userInfoEntity.tags.i_want.get(i4)).name;
                } else {
                    str = str4 + "、" + ((UserTag) userInfoEntity.tags.i_want.get(i4)).name;
                }
                str4 = str;
                i3 = i4 + 1;
            }
            this.v.setVisibility(0);
            this.u.setVisibility(0);
            this.u.setText(str4);
        }
        try {
            Log.v("drb", "服务器返回 userInfo.mate:" + userInfoEntity.mate);
            a3 = StringUtils.a(this.f20395a, BlueAppLocal.c(), Integer.parseInt(userInfoEntity.mate));
            Log.v("drb", "服务器返回解析后 userInfo.mate:" + a3);
        } catch (Exception e) {
            this.g.setVisibility(8);
            this.h.setVisibility(8);
        }
        if (!StringUtils.d(a3) && ((userInfoEntity.vbadge != 3 && userInfoEntity.vbadge != 5 && !a(userInfoEntity.uid)) || this.M)) {
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            this.g.setText(a3);
            a2 = StringUtils.a(this.f20395a.getResources().getStringArray(R.array.bloodtype), this.f20395a.getResources().getStringArray(R.array.bloodtype_key), userInfoEntity.blood_type);
            if (!StringUtils.d(a2) || this.f20395a.getResources().getString(R.string.hidden).equals(a2) || ((userInfoEntity.vbadge == 3 || userInfoEntity.vbadge == 5 || a(userInfoEntity.uid)) && !this.M)) {
                this.i.setVisibility(8);
                this.j.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.i.setText(a2);
            }
            areaTxt = AreaUtils.getAreaTxt(userInfoEntity.hometown, BlueAppLocal.c());
            if (!StringUtils.d(areaTxt) || ((userInfoEntity.vbadge == 3 || userInfoEntity.vbadge == 5 || a(userInfoEntity.uid)) && !this.M)) {
                this.s.setVisibility(8);
                this.t.setVisibility(8);
            } else {
                this.s.setVisibility(0);
                this.t.setVisibility(0);
                this.s.setText(areaTxt);
            }
            if ((userInfoEntity.vbadge != 5 || a(userInfoEntity.uid)) && !this.M) {
                this.y.setVisibility(8);
            } else {
                BitmapUtils.a(this.f20395a, this.A, userInfoEntity.rich_level, false);
                if (userInfoEntity.anchor == 1) {
                    LiveUtils.a(this.f20395a, this.B, userInfoEntity.anchor_level, false);
                    if (UserInfo.getInstance().getLoginUserInfo().uid.equalsIgnoreCase(userInfoEntity.uid)) {
                        this.y.setVisibility(0);
                        this.z.setVisibility(0);
                        this.z.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserinfoFragmentProfileTab$Z70P8OGKwU6njKd1mu3h3lIUGO0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                UserinfoFragmentProfileTab.this.b(view);
                            }
                        });
                    } else {
                        if (userInfoEntity.rich_level == 0) {
                            this.y.setVisibility(8);
                        } else {
                            this.y.setVisibility(0);
                        }
                        if (userInfoEntity.anchor_level == 0) {
                            this.z.setVisibility(8);
                        } else {
                            this.z.setVisibility(0);
                        }
                    }
                } else {
                    this.z.setVisibility(8);
                }
            }
            Log.v("drb", "服务端返回 userInfo.registration_time：" + userInfoEntity.registration_time);
            if (userInfoEntity.registration_time != 0 || a(userInfoEntity.uid)) {
                this.q.setVisibility(8);
                this.r.setVisibility(8);
            } else {
                this.q.setVisibility(0);
                this.r.setVisibility(0);
                this.q.setText(UserRelationshipUtils.g().get(userInfoEntity.registration_time + ""));
            }
            this.y.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserinfoFragmentProfileTab$GgOrxw_JS4AxaZtBdba2zMPBavo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserinfoFragmentProfileTab.this.b(userInfoEntity, view);
                }
            });
            UserInfoHelper.a(userInfoEntity.vbadge, this.G);
            UserInfoHelper.a(userInfoEntity.vbadge, this.H);
            g(userInfoEntity);
            c(userInfoEntity);
            d(userInfoEntity);
            e(userInfoEntity);
            f(userInfoEntity);
        }
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        a2 = StringUtils.a(this.f20395a.getResources().getStringArray(R.array.bloodtype), this.f20395a.getResources().getStringArray(R.array.bloodtype_key), userInfoEntity.blood_type);
        if (StringUtils.d(a2)) {
        }
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        areaTxt = AreaUtils.getAreaTxt(userInfoEntity.hometown, BlueAppLocal.c());
        if (StringUtils.d(areaTxt)) {
        }
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        if (userInfoEntity.vbadge != 5) {
        }
        this.y.setVisibility(8);
        Log.v("drb", "服务端返回 userInfo.registration_time：" + userInfoEntity.registration_time);
        if (userInfoEntity.registration_time != 0) {
        }
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.y.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserinfoFragmentProfileTab$GgOrxw_JS4AxaZtBdba2zMPBavo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserinfoFragmentProfileTab.this.b(userInfoEntity, view);
            }
        });
        UserInfoHelper.a(userInfoEntity.vbadge, this.G);
        UserInfoHelper.a(userInfoEntity.vbadge, this.H);
        g(userInfoEntity);
        c(userInfoEntity);
        d(userInfoEntity);
        e(userInfoEntity);
        f(userInfoEntity);
    }

    public void c(UserInfoEntity userInfoEntity) {
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid) || userInfoEntity.tags == null || ((UserInfoHelper.c(userInfoEntity.vbadge) || a(userInfoEntity.uid)) && !this.M)) {
            this.N.setVisibility(8);
            return;
        }
        int size = userInfoEntity.tags.type == null ? 0 : userInfoEntity.tags.type.size();
        int size2 = userInfoEntity.tags.character == null ? 0 : userInfoEntity.tags.character.size();
        int size3 = userInfoEntity.tags.hobbies == null ? 0 : userInfoEntity.tags.hobbies.size();
        int size4 = userInfoEntity.tags.recreation == null ? 0 : userInfoEntity.tags.recreation.size();
        int size5 = userInfoEntity.tags.love_type == null ? 0 : userInfoEntity.tags.love_type.size();
        int size6 = userInfoEntity.tags.love_character == null ? 0 : userInfoEntity.tags.love_character.size();
        int i = size + size2 + size3 + size4;
        if (i + size5 + size6 == 0) {
            this.N.setVisibility(8);
            return;
        }
        this.N.setVisibility(0);
        if (i == 0) {
            this.aa.setVisibility(8);
        } else {
            this.aa.setVisibility(0);
        }
        if (size5 + size6 == 0) {
            this.ab.setVisibility(8);
        } else {
            this.ab.setVisibility(0);
        }
        if (size == 0) {
            this.O.setVisibility(8);
            this.U.setVisibility(8);
        } else {
            this.O.setVisibility(0);
            this.U.setVisibility(0);
            a(userInfoEntity.tags.type, this.U);
        }
        if (size2 == 0) {
            this.P.setVisibility(8);
            this.V.setVisibility(8);
        } else {
            this.P.setVisibility(0);
            this.V.setVisibility(0);
            a(userInfoEntity.tags.character, this.V);
        }
        if (size3 == 0) {
            this.Q.setVisibility(8);
            this.W.setVisibility(8);
        } else {
            this.Q.setVisibility(0);
            this.W.setVisibility(0);
            a(userInfoEntity.tags.hobbies, this.W);
        }
        if (size4 == 0) {
            this.R.setVisibility(8);
            this.X.setVisibility(8);
        } else {
            this.R.setVisibility(0);
            this.X.setVisibility(0);
            a(userInfoEntity.tags.recreation, this.X);
        }
        if (size5 == 0) {
            this.S.setVisibility(8);
            this.Y.setVisibility(8);
        } else {
            this.S.setVisibility(0);
            this.Y.setVisibility(0);
            a(userInfoEntity.tags.love_type, this.Y);
        }
        if (size6 == 0) {
            this.T.setVisibility(8);
            this.Z.setVisibility(8);
        } else {
            this.T.setVisibility(0);
            this.Z.setVisibility(0);
            a(userInfoEntity.tags.love_character, this.Z);
        }
        this.N.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int intValue = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(UserinfoFragmentProfileTab.this.O.getWidth()), Integer.valueOf(UserinfoFragmentProfileTab.this.P.getWidth()), Integer.valueOf(UserinfoFragmentProfileTab.this.Q.getWidth()), Integer.valueOf(UserinfoFragmentProfileTab.this.R.getWidth()), Integer.valueOf(UserinfoFragmentProfileTab.this.S.getWidth()), Integer.valueOf(UserinfoFragmentProfileTab.this.T.getWidth())))).intValue();
                UserinfoFragmentProfileTab.this.O.setWidth(intValue);
                UserinfoFragmentProfileTab.this.P.setWidth(intValue);
                UserinfoFragmentProfileTab.this.Q.setWidth(intValue);
                UserinfoFragmentProfileTab.this.R.setWidth(intValue);
                UserinfoFragmentProfileTab.this.S.setWidth(intValue);
                UserinfoFragmentProfileTab.this.T.setWidth(intValue);
                UserinfoFragmentProfileTab.this.N.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public void d(final UserInfoEntity userInfoEntity) {
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid) || userInfoEntity.badge == null || userInfoEntity.badge.size() == 0) {
            this.C.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(userInfoEntity.badge);
        UserMedalsAdapter userMedalsAdapter = new UserMedalsAdapter(getFragmentActive(), this.f20395a, arrayList);
        userMedalsAdapter.a(new UserMedalsAdapter.RecyclerViewItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserinfoFragmentProfileTab$QGZAzy-b8srPmFmZKktF5xsE5Ws
            @Override // com.soft.blued.ui.user.adapter.UserMedalsAdapter.RecyclerViewItemClickListener
            public final void onItemClick(View view, int i) {
                UserinfoFragmentProfileTab.this.a(userInfoEntity, view, i);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f20395a);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setOrientation(0);
        linearLayoutManager.scrollToPosition(0);
        this.D.setLayoutManager(linearLayoutManager);
        this.D.setHasFixedSize(true);
        this.D.setAdapter(userMedalsAdapter);
        userMedalsAdapter.notifyDataSetChanged();
        if (userMedalsAdapter.getItemCount() > 0) {
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
    }

    public void e(final UserInfoEntity userInfoEntity) {
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ll_user_gift);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_user_gift_title);
        TextView textView2 = (TextView) this.b.findViewById(R.id.tv_user_gift_count);
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R.id.lv_user_gift);
        if (!userInfoEntity.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid) || BluedPreferences.aR()) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
        }
        if (TextUtils.equals(UserInfo.getInstance().getLoginUserInfo().uid, userInfoEntity.uid)) {
            textView.setText(this.f20395a.getResources().getString(R.string.my_gift));
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserinfoFragmentProfileTab$ZEGyYP8S0VMRHnFQ6RUgOrk0zHU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserinfoFragmentProfileTab.this.a(view);
                }
            });
        } else {
            textView.setText(this.f20395a.getResources().getString(R.string.his_gift));
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserinfoFragmentProfileTab$XPuq4FoenAMFelHUdfI4pIdekqA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserinfoFragmentProfileTab.this.a(userInfoEntity, view);
                }
            });
        }
        UserHttpUtils.b((BluedUIHttpResponse) new AnonymousClass8(getFragmentActive(), userInfoEntity, textView2, recyclerView), userInfoEntity.uid, (IRequestHost) getFragmentActive());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20395a = getActivity();
        this.E = layoutInflater;
        View view = this.b;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_userinfo_new_profile, viewGroup, false);
            this.b = inflate;
            this.ac = FragmentUserinfoNewProfileBinding.a(inflate);
            d();
            c();
            UserInfoEntity userInfoEntity = this.K;
            if (userInfoEntity != null) {
                a(userInfoEntity);
            }
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onDestroy() {
        super.onDestroy();
        BannerADView bannerADView = this.f20396c;
        if (bannerADView != null) {
            bannerADView.c();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && !this.M && b()) {
            if (!BluedPreferences.cP()) {
                this.p.setVisibility(0);
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UserinfoFragmentProfileTab.this.p.setVisibility(8);
                        BluedPreferences.cQ();
                    }
                }, 5000L);
            }
            this.p.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserinfoFragmentProfileTab$XtCJj7_UiWQyQYiVevJxB8ia4Bw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserinfoFragmentProfileTab.this.c(view);
                }
            });
        }
    }
}
