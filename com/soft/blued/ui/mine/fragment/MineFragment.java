package com.soft.blued.ui.mine.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageOptions;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.BluedADConstraintLayout;
import com.soft.blued.customview.DividerGridItemDecoration;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.mine.adapter.MineFourEntryAdapter;
import com.soft.blued.ui.mine.adapter.MineNineEntryAdapter;
import com.soft.blued.ui.mine.fragment.MineSettingDialogFragment;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.ui.mine.presenter.MinePresenter;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.fragment.FollowedAndFansFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentFeed;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.manager.AvatarWidgetManager;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.welcome.BaseADVideoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineFragment.class */
public class MineFragment extends MvpFragment<MinePresenter> {

    /* renamed from: a  reason: collision with root package name */
    private List<MineEntryInfo.VipBroadcast> f31596a;
    @BindView
    BluedADConstraintLayout adViewLayout;
    @BindView
    ImageView avatarWidget;

    /* renamed from: c  reason: collision with root package name */
    private MineFourEntryAdapter f31597c;
    @BindView
    CardView cvAd;
    @BindView
    CardView cvAnchors;
    @BindView
    CardView cvHealth;
    @BindView
    CardView cvOther;
    @BindView
    CardView cvService;
    private List<MineEntryInfo.ColumnsItem> d;
    private MineNineEntryAdapter e;
    private List<MineEntryInfo.ColumnsItem> f;
    private MineNineEntryAdapter g;
    @BindView
    ImageView headerView;
    @BindView
    ImageView imgAd;
    @BindView
    ImageView ivBgIcon;
    @BindView
    ImageView ivEdit;
    @BindView
    ImageView ivMore;
    @BindView
    ImageView ivVerify;
    @BindView
    ImageView ivVipBg;
    @BindView
    ImageView ivVipBtn;
    @BindView
    ImageView ivVipIcon;
    private List<MineEntryInfo.ColumnsItem> k;
    private List<View> l;
    @BindView
    LinearLayout layoutHeaderName;
    @BindView
    LinearLayout layoutName;
    @BindView
    LinearLayout layoutVip;
    @BindView
    ShapeLinearLayout layoutVipBtn;
    @BindView
    LinearLayout linearLayout;
    @BindView
    LinearLayout llHealthFlipper;
    @BindView
    LinearLayout llMyAttentions;
    @BindView
    LinearLayout llMyFans;
    @BindView
    LinearLayout llMyFeed;
    @BindView
    LinearLayout ll_my_group;
    private List<MineEntryInfo.TvBanner> m;
    private MineNineEntryAdapter n;
    private List<MineEntryInfo.ColumnsItem> o;
    private Context q;
    @BindView
    RecyclerView rvAnchorsEntry;
    @BindView
    RecyclerView rvHealthEntry;
    @BindView
    RecyclerView rvOthersEntry;
    @BindView
    RecyclerView rvServiceEntry;
    private DividerGridItemDecoration s;
    @BindView
    ScrollView scrollPage;
    private DividerGridItemDecoration t;
    @BindView
    FrameLayout top;
    @BindView
    TextView tvAttentionsCount;
    @BindView
    TextView tvAvatarAuditing;
    @BindView
    TextView tvFansCount;
    @BindView
    TextView tvFeedCount;
    @BindView
    TextView tvFeedName;
    @BindView
    TextView tvMyName;
    @BindView
    TextView tvVipBtn;
    @BindView
    TextView tvVipTitle;
    @BindView
    TextView tv_my_group_cnt;
    private DividerGridItemDecoration u;
    private DividerGridItemDecoration v;
    @BindView
    ViewFlipper vfHealth;
    @BindView
    ViewFlipper vfVipAd;
    private List<Unbinder> b = new ArrayList();
    private List<Unbinder> p = new ArrayList();
    private boolean r = false;

    /* renamed from: com.soft.blued.ui.mine.fragment.MineFragment$7  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineFragment$7.class */
    class AnonymousClass7 implements MineSettingDialogFragment.OnMineSettingListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MineFragment f31605a;

        @Override // com.soft.blued.ui.mine.fragment.MineSettingDialogFragment.OnMineSettingListener
        public void a(boolean z, boolean z2) {
            this.f31605a.j().a(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineFragment$BannerViewHolder.class */
    public class BannerViewHolder {
        @BindView
        TextView content;
        @BindView
        TextView title;

        BannerViewHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineFragment$BannerViewHolder_ViewBinding.class */
    public class BannerViewHolder_ViewBinding implements Unbinder {
        private BannerViewHolder b;

        public BannerViewHolder_ViewBinding(BannerViewHolder bannerViewHolder, View view) {
            this.b = bannerViewHolder;
            bannerViewHolder.title = (TextView) Utils.a(view, R.id.tv_ad_title, "field 'title'", TextView.class);
            bannerViewHolder.content = (TextView) Utils.a(view, 2131370825, "field 'content'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            BannerViewHolder bannerViewHolder = this.b;
            if (bannerViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            bannerViewHolder.title = null;
            bannerViewHolder.content = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineFragment$VipViewHolder.class */
    public class VipViewHolder {
        @BindView
        TextView content;
        @BindView
        ImageView icon;

        VipViewHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineFragment$VipViewHolder_ViewBinding.class */
    public class VipViewHolder_ViewBinding implements Unbinder {
        private VipViewHolder b;

        public VipViewHolder_ViewBinding(VipViewHolder vipViewHolder, View view) {
            this.b = vipViewHolder;
            vipViewHolder.icon = (ImageView) Utils.a(view, R.id.iv_vip_ad_icon, "field 'icon'", ImageView.class);
            vipViewHolder.content = (TextView) Utils.a(view, 2131371186, "field 'content'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            VipViewHolder vipViewHolder = this.b;
            if (vipViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            vipViewHolder.icon = null;
            vipViewHolder.content = null;
        }
    }

    private void A() {
        DividerGridItemDecoration dividerGridItemDecoration = this.s;
        if (dividerGridItemDecoration != null) {
            dividerGridItemDecoration.applySkin();
        }
        DividerGridItemDecoration dividerGridItemDecoration2 = this.t;
        if (dividerGridItemDecoration2 != null) {
            dividerGridItemDecoration2.applySkin();
        }
        DividerGridItemDecoration dividerGridItemDecoration3 = this.u;
        if (dividerGridItemDecoration3 != null) {
            dividerGridItemDecoration3.applySkin();
        }
        DividerGridItemDecoration dividerGridItemDecoration4 = this.v;
        if (dividerGridItemDecoration4 != null) {
            dividerGridItemDecoration4.applySkin();
        }
    }

    private void a(final MineEntryInfo.ImgBanner imgBanner) {
        if (imgBanner == null || TextUtils.isEmpty(imgBanner.img)) {
            this.cvAd.setVisibility(8);
            return;
        }
        ImageLoader.a(getFragmentActive(), imgBanner.img).a(12.0f).a(this.imgAd);
        this.adViewLayout.a(imgBanner, new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackSettings.a(SettingsProtos.Event.MINE_BTN_CLICK, imgBanner.link, null, BluedConfig.a().g().is_chat_shadow == 1);
                if (imgBanner.adm_type == 2) {
                    BaseADVideoFragment.a(MineFragment.this.q, imgBanner, 1);
                } else if (TextUtils.isEmpty(imgBanner.deep_link_url)) {
                    WebViewShowInfoFragment.show(MineFragment.this.q, imgBanner.link, 9);
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(imgBanner.deep_link_url));
                    if (AppUtils.a(intent)) {
                        MineFragment.this.q.startActivity(intent);
                    } else {
                        WebViewShowInfoFragment.show(MineFragment.this.q, imgBanner.link, 9);
                    }
                }
            }
        }));
        this.cvAd.setVisibility(0);
    }

    private void a(List<MineEntryInfo.ColumnsItem> list) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.clear();
        if (list == null || list.size() <= 0) {
            this.cvAnchors.setVisibility(8);
        } else {
            this.d.addAll(list);
            this.cvAnchors.setVisibility(0);
        }
        this.f31597c.setNewData(this.d);
    }

    private void a(List<MineEntryInfo.ColumnsItem> list, final List<MineEntryInfo.TvBanner> list2) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.clear();
        if (list == null || list.size() <= 0) {
            this.rvHealthEntry.setVisibility(8);
        } else {
            this.k.addAll(list);
            this.rvHealthEntry.setVisibility(0);
        }
        this.g.setNewData(this.k);
        this.m = list2;
        List<View> list3 = this.l;
        if (list3 == null) {
            this.l = new ArrayList();
        } else {
            list3.clear();
        }
        this.vfHealth.removeAllViews();
        if (list2 == null || list2.size() <= 0) {
            this.llHealthFlipper.setVisibility(8);
        } else {
            int i = 0;
            while (true) {
                final int i2 = i;
                if (i2 >= list2.size()) {
                    break;
                }
                final MineEntryInfo.TvBanner tvBanner = list2.get(i2);
                if (!TextUtils.isEmpty(tvBanner.title) && !TextUtils.isEmpty(tvBanner.content)) {
                    BannerViewHolder bannerViewHolder = new BannerViewHolder();
                    View inflate = getLayoutInflater().inflate(R.layout.item_mine_ad, (ViewGroup) null);
                    this.p.add(ButterKnife.a(bannerViewHolder, inflate));
                    try {
                        bannerViewHolder.title.setText(tvBanner.title);
                        bannerViewHolder.title.setTextColor(Color.parseColor(tvBanner.title_color));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        bannerViewHolder.content.setText(tvBanner.content);
                        bannerViewHolder.content.setTextColor(Color.parseColor(tvBanner.content_color));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    inflate.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
                            String str = ((MineEntryInfo.TvBanner) MineFragment.this.m.get(i2)).link;
                            String str2 = ((MineEntryInfo.TvBanner) MineFragment.this.m.get(i2)).id;
                            boolean z = true;
                            if (BluedConfig.a().g().is_chat_shadow != 1) {
                                z = false;
                            }
                            EventTrackSettings.a(event, str, str2, z);
                            WebViewShowInfoFragment.show(MineFragment.this.q, tvBanner.link, 9);
                        }
                    }));
                    this.l.add(inflate);
                    this.vfHealth.addView(inflate);
                }
                i = i2 + 1;
            }
            this.vfHealth.getInAnimation().setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (MineFragment.this.vfHealth.getGlobalVisibleRect(new Rect()) && MineFragment.this.m != null && MineFragment.this.m.size() > MineFragment.this.vfHealth.getDisplayedChild()) {
                        EventTrackSettings.a(SettingsProtos.Event.MINE_AREA_SHOW, SettingsProtos.ModuleType.HEALTH, ((MineEntryInfo.TvBanner) MineFragment.this.m.get(MineFragment.this.vfHealth.getDisplayedChild())).link, ((MineEntryInfo.TvBanner) MineFragment.this.m.get(MineFragment.this.vfHealth.getDisplayedChild())).id, BluedConfig.a().g().is_chat_shadow == 1);
                    }
                    if (list2.size() <= 1) {
                        MineFragment.this.vfHealth.stopFlipping();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            boolean z = true;
            if (list2.size() > 1) {
                this.vfHealth.startFlipping();
            } else {
                this.vfHealth.stopFlipping();
                SettingsProtos.Event event = SettingsProtos.Event.MINE_AREA_SHOW;
                SettingsProtos.ModuleType moduleType = SettingsProtos.ModuleType.HEALTH;
                String str = list2.get(0).link;
                String str2 = list2.get(0).id;
                if (BluedConfig.a().g().is_chat_shadow != 1) {
                    z = false;
                }
                EventTrackSettings.a(event, moduleType, str, str2, z);
            }
            this.llHealthFlipper.setVisibility(0);
        }
        if ((list == null || list.size() <= 0) && (list2 == null || list2.size() <= 0)) {
            this.cvHealth.setVisibility(8);
        } else {
            this.cvHealth.setVisibility(0);
        }
    }

    private void a(final List<MineEntryInfo.VipBroadcast> list, boolean z) {
        this.f31596a = list;
        this.vfVipAd.removeAllViews();
        this.vfVipAd.getCurrentView();
        if (list == null || list.size() <= 0) {
            this.vfVipAd.setVisibility(8);
            return;
        }
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            MineEntryInfo.VipBroadcast vipBroadcast = list.get(i2);
            if (!TextUtils.isEmpty(vipBroadcast.text)) {
                VipViewHolder vipViewHolder = new VipViewHolder();
                View inflate = getLayoutInflater().inflate(R.layout.item_mine_vip_ad, (ViewGroup) null);
                this.b.add(ButterKnife.a(vipViewHolder, inflate));
                vipViewHolder.content.setText(vipBroadcast.text);
                if (z) {
                    vipViewHolder.icon.setVisibility(8);
                    vipViewHolder.content.setTextColor(this.q.getResources().getColor(2131102478));
                    vipViewHolder.content.setBackground(null);
                    vipViewHolder.content.setPadding(DensityUtils.a(this.q, 5.0f), 0, 0, 0);
                } else {
                    int i3 = vipBroadcast.type;
                    if (i3 == 1) {
                        vipViewHolder.icon.setImageResource(R.drawable.mine_vip_icon);
                        vipViewHolder.icon.setVisibility(0);
                        vipViewHolder.content.setTextColor(this.q.getResources().getColor(2131099663));
                        vipViewHolder.content.setBackgroundResource(R.drawable.mine_vip_ad_bg);
                        vipViewHolder.content.setPadding(DensityUtils.a(this.q, 10.0f), 0, 0, 0);
                    } else if (i3 != 2) {
                        vipViewHolder.icon.setVisibility(8);
                        vipViewHolder.content.setTextColor(BluedSkinUtils.a(this.q, 2131102263));
                        vipViewHolder.content.setBackground(null);
                        vipViewHolder.content.setPadding(DensityUtils.a(this.q, 5.0f), 0, 0, 0);
                    } else {
                        vipViewHolder.icon.setImageResource(R.drawable.mine_bluedx_icon);
                        vipViewHolder.icon.setVisibility(0);
                        vipViewHolder.content.setTextColor(this.q.getResources().getColor(2131099658));
                        vipViewHolder.content.setBackgroundResource(R.drawable.mine_bluedx_ad_bg);
                        vipViewHolder.content.setPadding(DensityUtils.a(this.q, 10.0f), 0, 0, 0);
                    }
                }
                inflate.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        EventTrackSettings.a(SettingsProtos.Event.MINE_VIP_BANNER_COPYWRITING_CLICK, ((MineEntryInfo.VipBroadcast) MineFragment.this.f31596a.get(i2)).url, i2);
                        InstantLog.a("mine_vip_banner_right_click");
                        WebViewShowInfoFragment.show(MineFragment.this.q, ((MineEntryInfo.VipBroadcast) MineFragment.this.f31596a.get(i2)).url, 0);
                    }
                }));
                this.vfVipAd.addView(inflate);
            }
            i = i2 + 1;
        }
        this.vfVipAd.getInAnimation().setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (MineFragment.this.vfVipAd.getGlobalVisibleRect(new Rect()) && MineFragment.this.f31596a != null && MineFragment.this.f31596a.size() > MineFragment.this.vfVipAd.getDisplayedChild()) {
                    EventTrackSettings.a(SettingsProtos.Event.MINE_VIP_BANNER_COPYWRITING_SHOW, ((MineEntryInfo.VipBroadcast) MineFragment.this.f31596a.get(MineFragment.this.vfVipAd.getDisplayedChild())).url, MineFragment.this.vfVipAd.getDisplayedChild());
                }
                if (list.size() <= 1) {
                    MineFragment.this.vfVipAd.stopFlipping();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        if (list.size() > 1) {
            this.vfVipAd.startFlipping();
        } else {
            this.vfVipAd.stopFlipping();
            EventTrackSettings.a(SettingsProtos.Event.MINE_VIP_BANNER_COPYWRITING_SHOW, this.f31596a.get(0).url, 0);
        }
        this.vfVipAd.setVisibility(0);
    }

    private void b(List<MineEntryInfo.ColumnsItem> list) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.clear();
        if (list == null || list.size() <= 0) {
            this.cvService.setVisibility(8);
        } else {
            this.f.addAll(list);
            this.cvService.setVisibility(0);
        }
        this.e.setNewData(this.f);
    }

    private void c(List<MineEntryInfo.ColumnsItem> list) {
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.clear();
        if (list != null && list.size() > 0) {
            this.o.addAll(list);
        }
        this.n.setNewData(this.o);
    }

    private void d() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_ZHI_CHI_MSG).observe(this, new Observer<Object>() { // from class: com.soft.blued.ui.mine.fragment.MineFragment.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                MineFragment.this.n.notifyDataSetChanged();
            }
        });
    }

    private void e() {
        if (UserInfo.getInstance().getLoginUserInfo() == null) {
            this.tvMyName.setText("");
            this.tvAttentionsCount.setText("0");
            this.tvFansCount.setText("0");
            this.tv_my_group_cnt.setText("0");
            return;
        }
        ImageOptions imageOptions = new ImageOptions();
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            imageOptions.f9508c = 2131237313;
            imageOptions.f9507a = 2131237313;
        } else {
            imageOptions.f9508c = R.drawable.user_bg_round_border_vip;
            imageOptions.f9507a = R.drawable.user_bg_round_border_vip;
        }
        int i = this.q.getResources().getDisplayMetrics().widthPixels;
        this.tvAttentionsCount.setText(UserInfo.getInstance().getLoginUserInfo().getFollowedCount());
        this.tvFansCount.setText(UserInfo.getInstance().getLoginUserInfo().getFollowerCount());
        this.tvFeedCount.setText(UserInfo.getInstance().getLoginUserInfo().getMyTicktocksCount());
        String groupsCount = UserInfo.getInstance().getLoginUserInfo().getGroupsCount();
        if (StringUtils.d(groupsCount) || "0".equals(groupsCount)) {
            this.ll_my_group.setVisibility(8);
        } else if (BluedConstant.f28239a) {
            this.ll_my_group.setVisibility(8);
        } else {
            this.ll_my_group.setVisibility(0);
            this.tv_my_group_cnt.setText(UserInfo.getInstance().getLoginUserInfo().getGroupsCount());
        }
        int vBadge = UserInfo.getInstance().getLoginUserInfo().getVBadge();
        if (vBadge == 0) {
            this.ivVerify.setImageDrawable(this.q.getResources().getDrawable(2131237327));
        } else {
            UserInfoHelper.a(this.ivVerify, vBadge, 1);
        }
        this.tvMyName.setText(UserInfo.getInstance().getLoginUserInfo().getName());
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, UserInfo.getInstance().getLoginUserInfo().getAvatar())).a(imageOptions).c().a(this.headerView);
    }

    private void v() {
        if (StatusBarHelper.a()) {
            ViewGroup.LayoutParams layoutParams = this.top.getLayoutParams();
            layoutParams.height = StatusBarHelper.a((Context) getActivity());
            this.top.setLayoutParams(layoutParams);
        }
    }

    private void w() {
        if (BluedConstant.f28239a) {
            return;
        }
        this.ll_my_group.setVisibility(0);
    }

    private void x() {
        this.rvAnchorsEntry.setLayoutManager(new GridLayoutManager(this.q, 2));
        MineFourEntryAdapter mineFourEntryAdapter = new MineFourEntryAdapter(this.q, getFragmentActive());
        this.f31597c = mineFourEntryAdapter;
        this.rvAnchorsEntry.setAdapter(mineFourEntryAdapter);
        this.rvServiceEntry.setLayoutManager(new GridLayoutManager(this.q, 3));
        MineNineEntryAdapter mineNineEntryAdapter = new MineNineEntryAdapter(this.q, getFragmentActive());
        this.e = mineNineEntryAdapter;
        this.rvServiceEntry.setAdapter(mineNineEntryAdapter);
        this.rvHealthEntry.setLayoutManager(new GridLayoutManager(this.q, 3));
        MineNineEntryAdapter mineNineEntryAdapter2 = new MineNineEntryAdapter(this.q, getFragmentActive());
        this.g = mineNineEntryAdapter2;
        this.rvHealthEntry.setAdapter(mineNineEntryAdapter2);
        this.rvOthersEntry.setLayoutManager(new GridLayoutManager(this.q, 3));
        MineNineEntryAdapter mineNineEntryAdapter3 = new MineNineEntryAdapter(this.q, getFragmentActive());
        this.n = mineNineEntryAdapter3;
        this.rvOthersEntry.setAdapter(mineNineEntryAdapter3);
        z();
    }

    private void y() {
    }

    private void z() {
        if (this.rvAnchorsEntry == null || this.rvServiceEntry == null || this.rvHealthEntry == null || this.rvOthersEntry == null) {
            return;
        }
        int a2 = DensityUtils.a(this.q, 0.5f);
        DividerGridItemDecoration dividerGridItemDecoration = new DividerGridItemDecoration(this.rvAnchorsEntry, a2, 2131102272);
        this.s = dividerGridItemDecoration;
        this.rvAnchorsEntry.addItemDecoration(dividerGridItemDecoration);
        DividerGridItemDecoration dividerGridItemDecoration2 = new DividerGridItemDecoration(this.rvServiceEntry, a2, 2131102272);
        this.t = dividerGridItemDecoration2;
        this.rvServiceEntry.addItemDecoration(dividerGridItemDecoration2);
        DividerGridItemDecoration dividerGridItemDecoration3 = new DividerGridItemDecoration(this.rvHealthEntry, a2, 2131102272);
        this.u = dividerGridItemDecoration3;
        this.rvHealthEntry.addItemDecoration(dividerGridItemDecoration3);
        DividerGridItemDecoration dividerGridItemDecoration4 = new DividerGridItemDecoration(this.rvOthersEntry, a2, 2131102272);
        this.v = dividerGridItemDecoration4;
        this.rvOthersEntry.addItemDecoration(dividerGridItemDecoration4);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.q = getContext();
        v();
        w();
        x();
        y();
        e();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(MineEntryInfo mineEntryInfo) {
        if (mineEntryInfo != null) {
            if (BluedConfig.a().q()) {
                this.ivEdit.setVisibility(8);
            } else {
                this.ivEdit.setVisibility(0);
            }
            e();
            if (mineEntryInfo.user.avatar_audited == 0) {
                this.tvAvatarAuditing.setVisibility(0);
            } else {
                this.tvAvatarAuditing.setVisibility(8);
            }
            if (mineEntryInfo.broadcast != null) {
                a(mineEntryInfo.broadcast.carousels, mineEntryInfo.broadcast.is_broadcast_test == 0);
                this.tvVipTitle.setText(mineEntryInfo.broadcast.title);
                this.tvVipTitle.setTextColor(BluedSkinUtils.a(this.q, 2131102254));
                this.tvVipBtn.setText(mineEntryInfo.broadcast.btn);
                if (mineEntryInfo.broadcast.is_broadcast_test == 0) {
                    this.ivVipBg.setImageResource(R.drawable.mine_vip_old_bg);
                    this.ivVipBg.setImageAlpha(255);
                    this.ivBgIcon.setImageDrawable(null);
                    this.tvVipBtn.setTextColor(BluedSkinUtils.a(this.q, 2131102203));
                    this.ivVipBtn.setImageResource(R.drawable.mine_icon_no_vip_btn);
                    this.tvVipTitle.setTextColor(this.q.getResources().getColor(2131102478));
                    ShapeHelper.b(this.layoutVipBtn, 2131102170);
                } else {
                    int i = mineEntryInfo.broadcast.vip_grade;
                    if (i == 1) {
                        this.ivVipBg.setImageDrawable(BluedSkinUtils.b(this.q, R.drawable.shape_mine_vip_bg));
                        this.ivVipBg.setImageAlpha(33);
                        this.ivBgIcon.setImageResource(R.drawable.mine_vip_watermark);
                        this.tvVipBtn.setTextColor(BluedSkinUtils.a(this.q, 2131099662));
                        this.ivVipBtn.setImageResource(R.drawable.mine_icon_vip_btn);
                    } else if (i != 2) {
                        this.ivVipBg.setImageDrawable(null);
                        this.ivBgIcon.setImageDrawable(null);
                        this.tvVipBtn.setTextColor(BluedSkinUtils.a(this.q, 2131102254));
                        this.ivVipBtn.setImageResource(R.drawable.mine_icon_no_vip_btn);
                    } else {
                        this.ivVipBg.setImageDrawable(BluedSkinUtils.b(this.q, R.drawable.shape_mine_bluedx_bg));
                        this.ivVipBg.setImageAlpha(33);
                        this.ivBgIcon.setImageResource(R.drawable.mine_bluedx_watermark);
                        this.tvVipBtn.setTextColor(BluedSkinUtils.a(this.q, 2131099660));
                        this.ivVipBtn.setImageResource(R.drawable.mine_icon_bluedx_btn);
                    }
                    if (mineEntryInfo.broadcast.vip_grade != 0) {
                        this.ivVipIcon.setVisibility(0);
                        UserRelationshipUtils.a(this.ivVipIcon, mineEntryInfo.broadcast);
                        ShapeHelper.b(this.layoutVipBtn, 2131101780);
                    } else {
                        this.ivVipIcon.setVisibility(8);
                        ShapeHelper.b(this.layoutVipBtn, 2131102360);
                    }
                }
            } else {
                this.ivVipBg.setImageDrawable(null);
                this.ivBgIcon.setImageDrawable(null);
                this.tvVipBtn.setTextColor(BluedSkinUtils.a(this.q, 2131102254));
                this.ivVipBtn.setImageResource(R.drawable.mine_icon_no_vip_btn);
                this.ivVipIcon.setVisibility(8);
            }
            if (mineEntryInfo.columns != null) {
                a(mineEntryInfo.columns.anchors);
                b(mineEntryInfo.columns.service);
                a(mineEntryInfo.img_banner);
                a(mineEntryInfo.columns.health, mineEntryInfo.text_banner);
                c(mineEntryInfo.columns.others);
            }
            a(Integer.valueOf(mineEntryInfo.user.theme_pendant));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Integer num) {
        ImageLoader.a(getFragmentActive(), AvatarWidgetManager.a().a(num.intValue())).a(this.avatarWidget);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (this.o == null) {
            this.o = new ArrayList();
        }
        if (this.o.size() == 0) {
            MineEntryInfo.ColumnsItem columnsItem = new MineEntryInfo.ColumnsItem();
            columnsItem.icon = "http://www.bldimg.com/img/mine_setting.png";
            columnsItem.title = this.q.getResources().getString(2131891641);
            columnsItem.url = "http://native.blued.cn?action=setting";
            this.o.add(columnsItem);
            this.n.setNewData(this.o);
            this.n.notifyDataSetChanged();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        List<Unbinder> list = this.p;
        if (list != null) {
            for (Unbinder unbinder : list) {
                unbinder.unbind();
            }
            this.p.clear();
        }
        List<Unbinder> list2 = this.b;
        if (list2 != null) {
            for (Unbinder unbinder2 : list2) {
                unbinder2.unbind();
            }
            this.b.clear();
        }
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.r = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.scrollPage.smoothScrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_mine;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.r) {
            j().d();
        }
        this.r = true;
        A();
    }

    @OnClick
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case 2131364232:
            case 2131365652:
            case R.id.layout_header_name /* 2131366788 */:
            case R.id.tv_my_name /* 2131372038 */:
                InstantLog.b("my_model", 1);
                UserBasicModel userBasicModel = new UserBasicModel();
                userBasicModel.uid = UserInfo.getInstance().getLoginUserInfo().uid;
                userBasicModel.name = UserInfo.getInstance().getLoginUserInfo().name;
                userBasicModel.avatar = UserInfo.getInstance().getLoginUserInfo().avatar;
                userBasicModel.vip_grade = UserInfo.getInstance().getLoginUserInfo().vip_grade;
                UserInfoFragmentNew.a(this.q, userBasicModel, "", false, (MsgSourceEntity) null);
                return;
            case R.id.iv_edit /* 2131365277 */:
                if (YYRoomInfoManager.e().y()) {
                    AppMethods.a(this.q.getResources().getText(2131893032));
                    return;
                } else if (PopMenuUtils.a(this.q)) {
                    return;
                } else {
                    InstantLog.b("my_model", 2);
                    InstantLog.a("modify_user_profile", (Object) 0);
                    ModifyUserInfoFragment.a(this.q, 601, false);
                    return;
                }
            case R.id.layout_vip /* 2131366837 */:
            case R.id.layout_vip_btn /* 2131366838 */:
                EventTrackSettings.a(SettingsProtos.Event.MINE_VIP_BANNER_CENTER_CLICK, EventTrackSettings.a(j().n().vip_expire_state, j().n().expire_type));
                String m = j().m();
                String str = m;
                if (StringUtils.d(m)) {
                    str = BluedHttpUrl.g();
                }
                InstantLog.b("my_model", 14);
                WebViewShowInfoFragment.show(this.q, str, 0);
                return;
            case R.id.ll_my_attentions /* 2131368053 */:
                BluedConstant.d = 0;
                Bundle bundle = new Bundle();
                bundle.putString("followed_or_fan", "followed");
                bundle.putString("uid", UserInfo.getInstance().getLoginUserInfo().getUid());
                TerminalActivity.d(getActivity(), FollowedAndFansFragment.class, bundle);
                return;
            case R.id.ll_my_fans /* 2131368054 */:
                BluedConstant.d = 1;
                Bundle bundle2 = new Bundle();
                bundle2.putString("followed_or_fan", "fans");
                bundle2.putString("uid", UserInfo.getInstance().getLoginUserInfo().getUid());
                TerminalActivity.d(getActivity(), FollowedAndFansFragment.class, bundle2);
                return;
            case R.id.ll_my_feed /* 2131368055 */:
                UserInfoFragmentFeed.a(this.q);
                return;
            case R.id.ll_my_group /* 2131368056 */:
                MyGroupFragmentNew.f32768a.a(getContext(), null);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean q() {
        return true;
    }
}
