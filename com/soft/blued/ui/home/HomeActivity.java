package com.soft.blued.ui.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityStack;
import com.blued.android.core.ui.BaseActivity;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.badgeview.Badge;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.statistics.BluedStatistics;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.HomeTabBubble;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.utils.CommunityPreferences;
import com.blued.das.authority.SystemAuthorityProtos;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.live.LiveProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.MyFragmentTabHost;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.MessageEventUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.log.track.EventTrackSystemAuthority;
import com.soft.blued.ui.discover.fragment.DiscoveryPageFragment;
import com.soft.blued.ui.discover.fragment.SendFeedFloatManager;
import com.soft.blued.ui.discover.observer.SystemNoticeViewModel;
import com.soft.blued.ui.find.fragment.NearbyHomeFragment;
import com.soft.blued.ui.find.observer.AdFloatObserver;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.home.HomeContract;
import com.soft.blued.ui.home.model.ALinkActionModel;
import com.soft.blued.ui.home.model.HomeViewModel;
import com.soft.blued.ui.home.model.PhoneDialogModel;
import com.soft.blued.ui.home.pop.DialogALink;
import com.soft.blued.ui.home.pop.HomeTabBubblePop;
import com.soft.blued.ui.live.fragment.LiveFragment;
import com.soft.blued.ui.live.presenter.LiveListManager;
import com.soft.blued.ui.login_register.model.MarketPraiseGuide;
import com.soft.blued.ui.mine.fragment.MineNewFragment;
import com.soft.blued.ui.msg.MessagePageFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import com.soft.blued.ui.notify.model.ViewpointNoticeCount;
import com.soft.blued.ui.setting.fragment.LockPatternSetupFragment;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import com.soft.blued.ui.web.WebLinkManager;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.ExperimentConfig;
import com.soft.blued.user.UserInfoUtils;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.DurationUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.MarketTool;
import com.soft.blued.utils.StringUtils;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeActivity.class */
public class HomeActivity extends BaseFragmentActivity implements View.OnClickListener, SingleSessionListener, AdFloatObserver.IAdFloatObserver, HomeContract.View {
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static HomeActivity f30985c;
    private MyFragmentTabHost e;
    private LinearLayout i;
    private TabHost.TabSpec j;
    private HomeContract.Presenter l;
    private View m;
    private HomeViewModel q;
    private HomeTabBubblePop r;
    private HomeTabBubble s;
    private View t;
    private View u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private ALinkActionModel y;
    private String f = "";
    private String g = "";
    private String h = "";
    private final Map<String, TabItem> k = new ArrayMap();
    private boolean n = false;
    private boolean o = false;
    private final List<QBadgeContainer> p = new ArrayList();
    private boolean z = false;
    public boolean d = false;
    private boolean A = false;

    /* renamed from: com.soft.blued.ui.home.HomeActivity$16  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeActivity$16.class */
    class AnonymousClass16 extends BluedUIHttpResponse {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f30993a;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            BluedPreferences.a(this.f30993a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.home.HomeActivity$9  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeActivity$9.class */
    public class AnonymousClass9 extends BluedUIHttpResponse<BluedEntityA<PhoneDialogModel>> {
        AnonymousClass9(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            HomeActivity.this.a(false);
            WebViewShowInfoFragment.show(HomeActivity.this, H5Url.a(9), -1);
            EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.PHONE_CONFIRM_CHANGE_CLICK);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            HomeActivity.this.a(true);
            EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.PHONE_CONFIRM_USE_CLICK);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<PhoneDialogModel> bluedEntityA) {
            if (bluedEntityA == null || bluedEntityA.getSingleData() == null || bluedEntityA.getSingleData().is_need != 1) {
                return;
            }
            EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.PHONE_CONFIRM_POP_SHOW);
            HomeActivity homeActivity = HomeActivity.this;
            BluedAlertDialog a2 = CommonAlertDialog.a(homeActivity, 0, homeActivity.getResources().getString(2131890636), "", HomeActivity.this.getResources().getString(2131890638), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$9$QOtAHCixKwOsleKCTbeZYmpIEXA
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    HomeActivity.AnonymousClass9.this.b(dialogInterface, i);
                }
            }, HomeActivity.this.getResources().getString(2131890637), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$9$axd9yc6-ZYyjLZ8fZPTmZYr5-tk
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    HomeActivity.AnonymousClass9.this.a(dialogInterface, i);
                }
            }, (DialogInterface.OnDismissListener) null, 1);
            a2.b().setTextAlignment(2);
            a2.c().setVisibility(8);
            a2.g().setVisibility(8);
            a2.setCancelable(false);
            TextView textView = new TextView(HomeActivity.this);
            textView.setTextSize(18.0f);
            textView.setTextColor(BluedSkinUtils.a(HomeActivity.this, 2131102254));
            textView.setText(bluedEntityA.getSingleData().mobile);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = DensityUtils.a(HomeActivity.this, 5.0f);
            layoutParams.gravity = 1;
            textView.setLayoutParams(layoutParams);
            textView.setTextAlignment(4);
            FrameLayout frameLayout = (FrameLayout) a2.a();
            frameLayout.setVisibility(0);
            frameLayout.addView(textView);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            return true;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeActivity$TabItem.class */
    public static class TabItem {
        private static boolean k = true;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f31010a;
        public ImageView b;

        /* renamed from: c  reason: collision with root package name */
        public String f31011c;
        public int d;
        public int e;
        public TextView f;
        public QBadgeContainer g;
        public ImageView h;
        public View i;
        private boolean j;
        private boolean l = true;
        private boolean m = false;

        public void a(boolean z) {
            this.m = z;
            this.f.setSelected(z);
            this.b.setSelected(z);
            if (!z) {
                this.j = true;
                ImageView imageView = this.b;
                imageView.setImageDrawable(BluedSkinUtils.b(imageView.getContext(), this.e));
            } else if (!k && this.l) {
                this.j = false;
                ImageLoader.c(null, this.f31011c).f().g(1).a(new ImageLoader.OnAnimationStateListener() { // from class: com.soft.blued.ui.home.HomeActivity.TabItem.1
                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void a() {
                    }

                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void b() {
                        if (TabItem.this.j) {
                            return;
                        }
                        TabItem.this.b.setImageDrawable(BluedSkinUtils.b(TabItem.this.b.getContext(), TabItem.this.d));
                    }
                }).a(this.b);
            } else {
                k = false;
                ImageView imageView2 = this.b;
                imageView2.setImageDrawable(BluedSkinUtils.b(imageView2.getContext(), this.d));
            }
        }

        public void b(boolean z) {
            this.l = z;
        }
    }

    private void A() {
        v();
        this.u.setVisibility(0);
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        HomeTabBubblePop homeTabBubblePop = this.r;
        if (homeTabBubblePop == null || !homeTabBubblePop.s()) {
            return;
        }
        this.r.post(new Runnable() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$9BCZIyIwks_I88zuv4aZWlzIbJo
            @Override // java.lang.Runnable
            public final void run() {
                HomeActivity.this.E();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        this.v.animate().translationY(this.v.getHeight()).alpha(0.0f).setDuration(250L).setStartDelay(100L).setInterpolator(new AnticipateInterpolator(1.5f)).setListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.home.HomeActivity.23
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                HomeActivity.this.v.setVisibility(8);
            }
        }).start();
        if (this.t.getAlpha() < 0.1f) {
            this.t.setTranslationY(this.v.getHeight());
            this.t.post(new Runnable() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$bthihLl8v4lQOaG06V4KLBetS9w
                @Override // java.lang.Runnable
                public final void run() {
                    HomeActivity.this.C();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_main_live);
        if ("live".equals(f())) {
            imageView.setImageResource(R.drawable.icon_live_sel);
        } else {
            imageView.setImageResource(R.drawable.icon_live_nor);
        }
        this.t.animate().translationY(0.0f).alpha(1.0f).setDuration(250L).setStartDelay(100L).setInterpolator(new OvershootInterpolator(1.5f)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        HomeTabBubblePop homeTabBubblePop = this.r;
        if (homeTabBubblePop != null) {
            homeTabBubblePop.p();
            this.r = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        HomeTabBubblePop homeTabBubblePop = this.r;
        if (homeTabBubblePop != null) {
            homeTabBubblePop.p();
            this.r = null;
        }
    }

    private void a(Intent intent) {
        this.p.clear();
        View findViewById = findViewById(2131362488);
        this.m = findViewById;
        if (findViewById != null) {
            findViewById.setBackgroundColor(BluedSkinUtils.a(this, 2131102258));
        }
        this.i = (LinearLayout) findViewById(R.id.main_navigation);
        MyFragmentTabHost myFragmentTabHost = (MyFragmentTabHost) findViewById(16908306);
        this.e = myFragmentTabHost;
        if (myFragmentTabHost != null) {
            myFragmentTabHost.setup(this, getSupportFragmentManager(), 16908305);
            TabItem tabItem = new TabItem();
            tabItem.f31010a = (ViewGroup) findViewById(R.id.ll_main_find);
            tabItem.g = (QBadgeContainer) findViewById(R.id.find_badge_container);
            tabItem.g.a(tabItem.f31010a);
            tabItem.b = (ImageView) findViewById(R.id.iv_main_find);
            tabItem.f31011c = "icon_find_anim.png";
            tabItem.d = R.drawable.icon_find_sel;
            tabItem.e = R.drawable.icon_find_nor;
            tabItem.f = (TextView) findViewById(R.id.tv_main_find);
            tabItem.i = findViewById(R.id.tv_find_dot);
            tabItem.h = (ImageView) findViewById(R.id.iv_find_mark);
            tabItem.f31010a.setOnClickListener(this);
            tabItem.g.setBackgroundColor(BluedSkinUtils.a(this, 2131101780));
            tabItem.g.a(BluedSkinUtils.a(this, 2131101780), 1.0f, true);
            this.k.put("find", tabItem);
            TabHost.TabSpec indicator = this.e.newTabSpec("find").setIndicator("find");
            this.j = indicator;
            this.e.addTab(indicator, NearbyHomeFragment.class, HomeArgumentHelper.a(intent));
            this.p.add(tabItem.g);
            TabItem tabItem2 = new TabItem();
            tabItem2.f31010a = (ViewGroup) findViewById(R.id.ll_main_live);
            this.t = tabItem2.f31010a;
            this.v = (ImageView) findViewById(R.id.image_live_bubble);
            tabItem2.g = (QBadgeContainer) findViewById(R.id.live_badge_container);
            tabItem2.g.a(tabItem2.f31010a);
            tabItem2.f31010a.setVisibility(0);
            tabItem2.b = (ImageView) findViewById(R.id.iv_main_live);
            tabItem2.f31011c = "icon_live_anim.png";
            tabItem2.d = R.drawable.icon_live_sel;
            tabItem2.e = R.drawable.icon_live_nor;
            tabItem2.f = (TextView) findViewById(R.id.tv_main_live);
            tabItem2.h = (ImageView) findViewById(R.id.iv_live_mark);
            tabItem2.i = findViewById(R.id.tv_live_dot);
            tabItem2.f31010a.setOnClickListener(this);
            tabItem2.g.setBackgroundColor(BluedSkinUtils.a(this, 2131101780));
            tabItem2.g.a(BluedSkinUtils.a(this, 2131101780), 1.0f, true);
            this.k.put("live", tabItem2);
            TabHost.TabSpec indicator2 = this.e.newTabSpec("live").setIndicator("live");
            this.j = indicator2;
            this.e.addTab(indicator2, LiveFragment.class, HomeArgumentHelper.a(intent));
            if (BluedPreferences.aO()) {
                d("live");
            } else {
                k("live");
            }
            this.p.add(tabItem2.g);
            TabItem tabItem3 = new TabItem();
            tabItem3.f31010a = (ViewGroup) findViewById(R.id.ll_main_feed);
            this.u = findViewById(R.id.ll_main_feed);
            this.w = (ImageView) findViewById(R.id.img_discovery_bubble_avatar);
            this.x = (ImageView) findViewById(R.id.img_discovery_bubble);
            tabItem3.g = (QBadgeContainer) findViewById(R.id.feed_badge_container);
            tabItem3.g.a(tabItem3.f31010a);
            tabItem3.b = (ImageView) findViewById(R.id.iv_main_feed);
            tabItem3.f31011c = "icon_discovery_anim.png";
            tabItem3.d = R.drawable.icon_discovery_sel;
            tabItem3.e = R.drawable.icon_discovery_nor;
            tabItem3.f = (TextView) findViewById(R.id.tv_main_feed);
            tabItem3.h = (ImageView) findViewById(R.id.iv_feed_mark);
            tabItem3.i = findViewById(R.id.tv_feed_dot);
            tabItem3.f31010a.setOnClickListener(this);
            tabItem3.g.setBackgroundColor(BluedSkinUtils.a(this, 2131101780));
            tabItem3.g.a(BluedSkinUtils.a(this, 2131101780), 1.0f, true);
            this.k.put(IAdInterListener.AdProdType.PRODUCT_FEEDS, tabItem3);
            TabHost.TabSpec indicator3 = this.e.newTabSpec(IAdInterListener.AdProdType.PRODUCT_FEEDS).setIndicator(IAdInterListener.AdProdType.PRODUCT_FEEDS);
            this.j = indicator3;
            this.e.addTab(indicator3, DiscoveryPageFragment.class, HomeArgumentHelper.a(intent));
            this.p.add(tabItem3.g);
            TabItem tabItem4 = new TabItem();
            tabItem4.f31010a = (ViewGroup) findViewById(R.id.ll_main_msg);
            tabItem4.g = (QBadgeContainer) findViewById(R.id.msg_badge_container);
            tabItem4.g.a(tabItem4.f31010a);
            tabItem4.b = (ImageView) findViewById(R.id.iv_main_msg);
            tabItem4.f31011c = "icon_msg_anim.png";
            tabItem4.d = R.drawable.icon_msg_sel;
            tabItem4.e = R.drawable.icon_msg_nor;
            tabItem4.f = (TextView) findViewById(R.id.tv_main_msg);
            tabItem4.i = findViewById(R.id.tv_msg_dot);
            tabItem4.h = (ImageView) findViewById(R.id.iv_msg_mark);
            tabItem4.f31010a.setOnClickListener(this);
            tabItem4.g.setBackgroundColor(BluedSkinUtils.a(this, 2131101780));
            tabItem4.g.b(5.0f, true);
            tabItem4.g.f10205a.a(BluedSkinUtils.a(this, 2131101780), 1.0f, true);
            this.k.put("msg", tabItem4);
            TabHost.TabSpec indicator4 = this.e.newTabSpec("msg").setIndicator("msg");
            this.j = indicator4;
            this.e.addTab(indicator4, MessagePageFragment.class, HomeArgumentHelper.a(intent));
            this.p.add(tabItem4.g);
            TabItem tabItem5 = new TabItem();
            tabItem5.f31010a = (ViewGroup) findViewById(R.id.ll_main_others);
            tabItem5.g = (QBadgeContainer) findViewById(R.id.other_badge_container);
            tabItem5.g.a(tabItem5.f31010a);
            tabItem5.b = (ImageView) findViewById(R.id.iv_main_others);
            tabItem5.f31011c = "icon_mine_anim.png";
            tabItem5.d = R.drawable.icon_mine_sel;
            tabItem5.e = R.drawable.icon_mine_nor;
            tabItem5.f = (TextView) findViewById(R.id.tv_main_others);
            tabItem5.h = (ImageView) findViewById(R.id.iv_others_mark);
            tabItem5.i = findViewById(2131372203);
            tabItem5.f31010a.setOnClickListener(this);
            tabItem5.g.setBackgroundColor(BluedSkinUtils.a(this, 2131101780));
            Log.v("drb", "BluedSkinUtils.getSkinColor(this, R.color.syc_b):" + BluedSkinUtils.a(this, 2131101780));
            tabItem5.g.a(BluedSkinUtils.a(this, 2131101780), 1.0f, true);
            this.k.put("mine", tabItem5);
            TabHost.TabSpec indicator5 = this.e.newTabSpec("mine").setIndicator("mine");
            this.j = indicator5;
            this.e.addTab(indicator5, MineNewFragment.class, HomeArgumentHelper.a(intent));
            if (BluedPreferences.bt()) {
                d("mine");
            }
            this.p.add(tabItem5.g);
            if (TextUtils.isEmpty(this.f) || !this.k.containsKey(this.f)) {
                this.f = "find";
            }
            this.k.get(this.f).a(true);
            a(this.f);
            this.e.setCurrentTabByTag(this.f);
            Log.v("drb", "BluedConfig.getInstance().isUseNewMinePage():" + BluedConfig.a().F());
            Log.v("drb", "currentTabTag:" + this.f);
            Log.v("drb", "BluedPreferences.getIS_SHOW_HOME_MINE_TIP():" + BluedPreferences.ez());
            if (BluedConfig.a().F() && "find".equals(this.f) && BluedPreferences.ez()) {
                BluedPreferences.eA();
                BluedPreferences.eH();
                final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.cl_mine_new_tip);
                viewGroup.setVisibility(0);
                viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.HomeActivity.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                    }
                });
                ((TextView) findViewById(2131372161)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.HomeActivity.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        viewGroup.setVisibility(8);
                    }
                });
            }
            ServiceHelper.f33645a.a(this, new ServiceHelper.ZhiChiNewMsgListener() { // from class: com.soft.blued.ui.home.HomeActivity.13
                @Override // com.soft.blued.ui.setting.tools.ServiceHelper.ZhiChiNewMsgListener
                public void a() {
                    if (!HomeActivity.this.f.equals("mine")) {
                        HomeActivity.this.d("mine");
                    }
                    LiveEventBus.get(EventBusConstant.KEY_EVENT_ZHI_CHI_MSG).post(null);
                }
            });
            Log.e("HomeActivity", "listQBadgeContainer size: " + this.p.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        i("live");
        n();
        EventTrackFeed.a(FeedProtos.Event.FIND_DOWN_BUBBLE_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ALinkActionModel aLinkActionModel) {
        if (aLinkActionModel == null) {
            return;
        }
        if (AppInfo.l >= 720) {
            aLinkActionModel.setPopup_image(aLinkActionModel.getPopup_image_max());
        } else {
            aLinkActionModel.setPopup_image(aLinkActionModel.getPopup_image_min());
        }
        ImageFileLoader.a(a()).a(aLinkActionModel.getPopup_image()).a(new ImageLoadResult(a()) { // from class: com.soft.blued.ui.home.HomeActivity.8
            @Override // com.blued.android.core.image.ImageLoadResult
            public void a() {
                DialogALink.a(HomeActivity.this, aLinkActionModel);
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final Boolean bool) {
        String str;
        if (!"find".equalsIgnoreCase(this.f)) {
            this.k.get("find").b.setImageResource(this.k.get("find").e);
            this.k.get("find").f.setText(R.string.common_main_find);
            return;
        }
        this.o = bool.booleanValue();
        if (bool.booleanValue()) {
            this.k.get("find").f.setText(2131887964);
            EventTrackFeed.d(FeedProtos.Event.FEED_BACK_TOP_SHOW);
            str = "home_tab_find_to_refresh.png";
        } else {
            this.k.get("find").f.setText(R.string.common_main_find);
            str = "home_tab_refresh_to_find.png";
        }
        final ImageView imageView = this.k.get("find").b;
        ImageLoader.c(a(), str).g().a(new ImageLoader.OnAnimationStateListener() { // from class: com.soft.blued.ui.home.HomeActivity.7
            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void a() {
            }

            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void b() {
                LogUtils.c("onAnimationEnd: " + bool);
                if (bool.booleanValue()) {
                    imageView.setImageResource(R.drawable.icon_find_top_sel);
                } else if (((TabItem) HomeActivity.this.k.get("find")).m) {
                    imageView.setImageResource(((TabItem) HomeActivity.this.k.get("find")).d);
                } else {
                    imageView.setImageResource(((TabItem) HomeActivity.this.k.get("find")).e);
                }
            }
        }).a(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        if (num.intValue() == 0) {
            return;
        }
        if (!"live".equals(this.f) && num.intValue() == 1) {
            i("live");
        } else if (!IAdInterListener.AdProdType.PRODUCT_FEEDS.equals(this.f) && num.intValue() == 2) {
            i(IAdInterListener.AdProdType.PRODUCT_FEEDS);
        } else if (!"msg".equals(this.f) && num.intValue() == 3) {
            i("msg");
        } else if ("mine".equals(this.f) || num.intValue() != 4) {
        } else {
            i("mine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        NearbyHttpUtils.a(new BluedUIHttpResponse() { // from class: com.soft.blued.ui.home.HomeActivity.10
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, z);
    }

    private void a(boolean z, Intent intent) {
        if (intent != null) {
            String b = HomeArgumentHelper.b(intent, "arg_select_tab_tag");
            String a2 = HomeArgumentHelper.a(intent, "to_message_tab");
            this.g = a2;
            if ("0".equals(a2)) {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_NOTICE_NEED_REFRESH).postDelay(null, 500L);
            }
            Logger.c("HomeActivity", "toMessageTab = " + this.g + "activity=== " + this);
            if (!TextUtils.isEmpty(b)) {
                if (z) {
                    this.f = b;
                } else if (!TextUtils.isEmpty(b) && !TextUtils.equals(this.f, b)) {
                    i(b);
                }
            }
            HomeArgumentHelper.a(this, intent);
            HomeArgumentHelper.b(this, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        i("live");
        n();
        EventTrackLive.a(LiveProtos.Event.LIVE_DOWN_GUIDE_IMAGE_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        i(IAdInterListener.AdProdType.PRODUCT_FEEDS);
        A();
        EventTrackFeed.d(FeedProtos.Event.FIND_DOWN_BUBBLE_CLICK, this.s.bubble_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Tracker.onClick(view);
        i(IAdInterListener.AdProdType.PRODUCT_FEEDS);
        A();
        EventTrackFeed.d(FeedProtos.Event.FIND_DOWN_BUBBLE_CLICK, this.s.bubble_id);
    }

    private void i(String str) {
        a(str, HomeContract.TabRefresh.DEFAULT);
    }

    private void j(String str) {
        Log.e("HomeActivity", "setSelectedTabUI tabsMap size: " + this.k.size());
        for (Map.Entry<String, TabItem> entry : this.k.entrySet()) {
            entry.getValue().g.setBackgroundColor(BluedSkinUtils.a(this, 2131101780));
            if (TextUtils.equals(entry.getKey(), str)) {
                entry.getValue().b(!TextUtils.equals(this.h, str));
                entry.getValue().a(true);
            } else {
                entry.getValue().a(false);
            }
        }
    }

    private void o() {
        LiveEventBus.get("aLink_live_dot").observe(this, new Observer<Object>() { // from class: com.soft.blued.ui.home.HomeActivity.4
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                if (HomeActivity.this.h("live")) {
                    return;
                }
                HomeActivity.this.d("live");
            }
        });
        LiveEventBus.get("aLink_home_pop", ALinkActionModel.class).observe(this, new Observer<ALinkActionModel>() { // from class: com.soft.blued.ui.home.HomeActivity.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(ALinkActionModel aLinkActionModel) {
                if (HomeActivity.this.f.equals("find")) {
                    HomeActivity.this.a(aLinkActionModel);
                } else {
                    HomeActivity.this.y = aLinkActionModel;
                }
            }
        });
        LiveEventBus.get("home_tab_bubble", HomeTabBubble.class).observe(this, new Observer<HomeTabBubble>() { // from class: com.soft.blued.ui.home.HomeActivity.6
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(HomeTabBubble homeTabBubble) {
                HomeActivity.this.s = homeTabBubble;
                HomeActivity.this.w();
            }
        });
        LiveEventBus.get("EVENT_CLICK_HOME_TAB_INDEX", Integer.class).observe(this, new Observer() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$zK00BJZArlw3Kk2EWeN8RRVb8IY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeActivity.this.a((Integer) obj);
            }
        });
        LiveEventBus.get("FEED_LIST_REFRESH_GUIDE", Boolean.class).observe(this, new Observer() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$lp6Ee2fcTqoGBavJo5nYEcm66tI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeActivity.this.a((Boolean) obj);
            }
        });
        AdFloatObserver.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        NearbyHttpUtils.c(new AnonymousClass9(a()), a());
    }

    private void q() {
        ((SystemNoticeViewModel) ViewModelProviders.of(this).get(SystemNoticeViewModel.class)).d.observe(this, new Observer<Integer>() { // from class: com.soft.blued.ui.home.HomeActivity.14
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                HomeActivity.this.a("msg", num.intValue());
            }
        });
    }

    private void r() {
        ALinkActionModel aLinkActionModel = this.y;
        if (aLinkActionModel != null) {
            a(aLinkActionModel);
            this.y = null;
        }
    }

    private void s() {
        long currentTimeMillis = System.currentTimeMillis();
        Time time = new Time();
        time.set(currentTimeMillis);
        Time time2 = new Time();
        time2.set(currentTimeMillis);
        time2.hour = 17;
        time2.minute = 0;
        Time time3 = new Time();
        time3.set(currentTimeMillis);
        time3.hour = 17;
        time3.minute = 29;
        if (time.before(time2) || time.after(time3)) {
            return;
        }
        AppHttpUtils.c();
    }

    private void t() {
        if (this.z) {
            TabItem tabItem = this.k.get("msg");
            if (tabItem != null) {
                QBadgeContainer qBadgeContainer = tabItem.g;
                if (qBadgeContainer.getBageVisible() == 0) {
                    qBadgeContainer.a("");
                    qBadgeContainer.b(5.0f, true);
                    qBadgeContainer.a(11.0f, true);
                    qBadgeContainer.a(10.0f, 0.0f, true);
                }
            }
            BluedPreferences.b(UserInfo.getInstance().getLoginUserInfo().uid, System.currentTimeMillis());
            this.z = false;
        }
    }

    private void u() {
        List<QBadgeContainer> list = this.p;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (QBadgeContainer qBadgeContainer : this.p) {
            Log.e("HomeActivity", "updateBadgeBorder countView 。。。");
            qBadgeContainer.a(BluedSkinUtils.a(this, 2131101780), 1.0f, true);
            qBadgeContainer.setBackgroundColor(BluedSkinUtils.a(this, 2131101780));
        }
    }

    private void v() {
        HomeTabBubble homeTabBubble = this.s;
        if (homeTabBubble == null || TextUtils.isEmpty(homeTabBubble.bubble_click)) {
            return;
        }
        NearbyHttpUtils.b(null, this.s.bubble_click, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.s == null) {
            this.s = new HomeTabBubble();
        }
        LogUtils.c("noticeGetBubbleData.is_send_feed_msg:" + BluedConfig.a().b().is_send_feed_msg);
        LogUtils.c("noticeGetBubbleData.today:" + TimeAndDateUtils.a());
        LogUtils.c("noticeGetBubbleData.getEnterCityDate:" + BluedPreferences.fh());
        LogUtils.c("noticeGetBubbleData.showFeedSignCityTopCommonGuide:" + BluedPreferences.ff());
        boolean z = false;
        if (this.s.bubble_type == 6) {
            LiveEventBus.get(EventBusConstant.KEY_EVENT_CITY_NEW).post(this.s);
            z = true;
        }
        boolean z2 = z;
        if (!z) {
            z2 = z;
            if (CommunityManager.f19086a.a().a() != null) {
                z2 = z;
                if (CommunityManager.f19086a.a().a().extra_bubble_type != 3) {
                    HomeTabBubble homeTabBubble = new HomeTabBubble();
                    homeTabBubble.bubble_text = CommunityManager.f19086a.a().a().extra_bubble_text;
                    homeTabBubble.bubble_type = 1102;
                    LiveEventBus.get(EventBusConstant.KEY_EVENT_CITY_NEW).postDelay(homeTabBubble, 2000L);
                    z2 = true;
                }
            }
        }
        if (!z2 && BluedConfig.a().b().is_send_feed_msg == 0) {
            long a2 = TimeAndDateUtils.a();
            HomeTabBubble homeTabBubble2 = new HomeTabBubble();
            if (a2 > BluedPreferences.fh() && BluedPreferences.ff()) {
                homeTabBubble2.bubble_text = "他刚冒泡";
                homeTabBubble2.bubble_type = 1101;
                BluedPreferences.fg();
                LiveEventBus.get(EventBusConstant.KEY_EVENT_CITY_NEW).postDelay(homeTabBubble2, 2000L);
            }
        }
        if (CommunityManager.f19086a.a().f()) {
            this.A = true;
        } else {
            x();
        }
    }

    private void x() {
        HomeTabBubble homeTabBubble = this.s;
        if (homeTabBubble != null && homeTabBubble.bubble_type > 0) {
            if (this.s.bubble_position != 1) {
                if (this.s.bubble_position == 2) {
                    m();
                }
            } else if (this.s.bubble_group == 2) {
                y();
            } else {
                z();
            }
        }
    }

    private void y() {
        TabItem tabItem = this.k.get(IAdInterListener.AdProdType.PRODUCT_FEEDS);
        if (tabItem == null || this.s == null) {
            return;
        }
        this.l.a(true);
        if (tabItem.h.getVisibility() != 0) {
            tabItem.g.setBageVisible(0);
        }
        tabItem.g.a(this.s.bubble_experiment_text);
        EventTrackFeed.d(FeedProtos.Event.FIND_DOWN_BUBBLE_SHOW, this.s.bubble_id);
        AppUtils.a(tabItem.f31010a);
    }

    private void z() {
        HomeTabBubble homeTabBubble = this.s;
        if (homeTabBubble == null || TextUtils.isEmpty(homeTabBubble.bubble_img)) {
            return;
        }
        EventTrackFeed.d(FeedProtos.Event.FIND_DOWN_BUBBLE_SHOW, this.s.bubble_id);
        ImageView imageView = this.x;
        ImageView imageView2 = imageView;
        if (!TextUtils.isEmpty(this.s.bubble_img)) {
            ImageLoadResult imageLoadResult = new ImageLoadResult(a()) { // from class: com.soft.blued.ui.home.HomeActivity.19
                @Override // com.blued.android.core.image.ImageLoadResult
                public void a() {
                    HomeActivity.this.u.setVisibility(4);
                }
            };
            if (this.s.bubble_type == 2 || this.s.bubble_type == 3 || this.s.bubble_type == 7) {
                imageView2 = this.w;
                imageView2.setVisibility(0);
                ImageLoader.a(a(), this.s.bubble_img).b(2131237310).c().a(imageLoadResult).a(this.w);
            } else {
                this.x.setVisibility(0);
                ImageLoader.a(a(), this.s.bubble_img).a(imageLoadResult).a(this.x);
                imageView2 = imageView;
            }
        }
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$6skKiz60zxP6UNPHiRMBdkAMEKk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeActivity.this.d(view);
                }
            });
        }
        String str = this.s.bubble_text;
        if (this.s.bubble_type == 2) {
            str = getResources().getString(this.s.getFeedBubbleStringId());
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.r = new HomeTabBubblePop(this);
        final String str2 = str;
        new XPopup.Builder(this).a(new SimpleCallback() { // from class: com.soft.blued.ui.home.HomeActivity.20
            @Override // com.blued.android.framework.ui.xpop.interfaces.SimpleCallback, com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void a(BasePopupView basePopupView) {
                super.a(basePopupView);
                HomeActivity.this.r.setText(str2);
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.SimpleCallback, com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void d(BasePopupView basePopupView) {
                super.d(basePopupView);
                HomeActivity.this.r = null;
            }
        }).d((Boolean) false).c(true).b(true).a(PopupPosition.Top).a(imageView2).a(PopupAnimation.ScaleAlphaFromCenter).c((Boolean) false).a((BasePopupView) this.r).h();
        this.r.postDelayed(new Runnable() { // from class: com.soft.blued.ui.home.HomeActivity.21
            @Override // java.lang.Runnable
            public void run() {
                if (HomeActivity.this.r != null) {
                    HomeActivity.this.r.p();
                }
            }
        }, 5000L);
        this.r.setRootClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$WJD6Y8VijdGWerG3MoBHCe6FjW4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeActivity.this.c(view);
            }
        });
        AppUtils.a(imageView2);
        AppUtils.a(this.r);
    }

    public void a(int i) {
        this.g = i + "";
    }

    public void a(String str) {
        for (String str2 : this.k.keySet()) {
            TabItem tabItem = this.k.get(str2);
            if (TextUtils.equals(str, str2)) {
                tabItem.g.a(new Badge.OnDragStateChangedListener() { // from class: com.soft.blued.ui.home.HomeActivity.15
                    @Override // com.blued.android.framework.view.badgeview.Badge.OnDragStateChangedListener
                    public void a(int i, Badge badge, View view) {
                        int id = view.getId();
                        if (id == 2131368000) {
                            if (i == 5) {
                                ChatHelperV4.a().a(3L);
                                ChatHelperV4.a().a(11L);
                                ChatHelperV4.a().a(22L);
                            }
                        } else if (id == 2131368003 && i == 5) {
                            EventTrackMessage.a(MessageProtos.Event.MSG_UNREAD_DRAG_REMOVE);
                            SystemNoticeViewModel systemNoticeViewModel = (SystemNoticeViewModel) ViewModelProviders.of(HomeActivity.this).get(SystemNoticeViewModel.class);
                            systemNoticeViewModel.b = new ViewpointNoticeCount();
                            systemNoticeViewModel.f29847c = 0;
                            systemNoticeViewModel.f29846a = 0;
                            systemNoticeViewModel.f.postValue(0);
                            LiveEventBus.get(EventBusConstant.KEY_EVENT_CLEAR_MESSAGE_CHAT).post(null);
                            LiveEventBus.get(EventBusConstant.KEY_EVENT_CLEAR_MESSAGE_NOTIFY).post(null);
                        }
                    }
                });
            } else {
                tabItem.g.a((Badge.OnDragStateChangedListener) null);
            }
        }
    }

    @Override // com.soft.blued.ui.home.HomeContract.View
    public void a(String str, int i) {
        TabItem tabItem = this.k.get(str);
        if (tabItem != null) {
            if (tabItem.h.getVisibility() != 0) {
                tabItem.g.setBageVisible(0);
            }
            if (TextUtils.equals(str, "msg")) {
                if (this.z && i == 0) {
                    return;
                }
                t();
            }
            tabItem.g.a(i);
        }
    }

    public void a(String str, HomeContract.TabRefresh tabRefresh) {
        TabItem tabItem;
        try {
            this.h = this.f;
            this.f = str;
            if ((tabRefresh == HomeContract.TabRefresh.DEFAULT && TextUtils.equals(str, this.e.getCurrentTabTag())) || tabRefresh == HomeContract.TabRefresh.FORCE_REFRESH) {
                Logger.e("MsgFragment", "selectTab===" + str);
                HomeTabClick.a(str);
            } else {
                if ((TextUtils.equals(str, "find") || TextUtils.equals(str, "msg")) && FlashPhotoManager.a().b().flash_left_times == 0 && FlashPhotoManager.a().b().stimulate_flash == 0 && UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                    LiveEventBus.get(EventBusConstant.KEY_EVENT_FLASH_FREE_TIMES_TO_POST).post(Boolean.valueOf(TextUtils.equals(str, "find")));
                }
                if (!TextUtils.equals(str, "live")) {
                    s();
                }
            }
            this.e.setCurrentTabByTag(str);
            j(str);
            a(str);
            if ("find".equals(str)) {
                EventTrackSettings.a(SettingsProtos.Event.APP_NEARBY_CLICK);
            } else if ("msg".equals(str)) {
                EventTrackSettings.a(SettingsProtos.Event.APP_MSG_CLICK);
            } else if ("live".equals(str)) {
                EventTrackSettings.a(SettingsProtos.Event.APP_LIVE_CLICK);
            } else if (IAdInterListener.AdProdType.PRODUCT_FEEDS.equals(str)) {
                EventTrackSettings.a(SettingsProtos.Event.APP_FIND_CLICK);
            } else if ("mine".equals(str)) {
                EventTrackSettings.a(SettingsProtos.Event.APP_ME_CLICK);
            }
            if (IAdInterListener.AdProdType.PRODUCT_FEEDS.equals(str) && h(IAdInterListener.AdProdType.PRODUCT_FEEDS)) {
                k(IAdInterListener.AdProdType.PRODUCT_FEEDS);
            }
            if (IAdInterListener.AdProdType.PRODUCT_FEEDS.equals(str) && (tabItem = this.k.get(IAdInterListener.AdProdType.PRODUCT_FEEDS)) != null && this.s != null && tabItem.g.getBageVisible() == 0 && !TextUtils.isEmpty(tabItem.g.getBadgeText())) {
                tabItem.g.setBageVisible(8);
                EventTrackFeed.d(FeedProtos.Event.FIND_DOWN_BUBBLE_CLICK, this.s.bubble_id);
                v();
            }
            if ("live".equals(str) && h("live")) {
                k("live");
                BluedPreferences.aP();
            }
            if ("msg".equals(str)) {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_NOTICE_NEED_REFRESH).post(null);
                t();
            }
            if ("mine".equals(str) && h("mine")) {
                k("mine");
            }
            if (!TextUtils.equals("live", this.h) && TextUtils.equals("live", str)) {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_HOME_CLICK_LIVE_TAB).post(null);
            }
            if (this.h.equalsIgnoreCase(str)) {
                return;
            }
            if (this.h.equalsIgnoreCase("find")) {
                this.k.get("find").f.setText(R.string.common_main_find);
            }
            LiveEventBus.get("FEED_LIST_REFRESH_TAB_CHANGED").post(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.soft.blued.ui.find.observer.AdFloatObserver.IAdFloatObserver
    public void ae_() {
        if (this.A) {
            this.A = false;
            x();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        StatusBarHelper.a((Activity) this);
        super.applySkin();
        Log.e("HomeActivity", "HomeActivity apply skin");
        if (this.m != null) {
            Log.e("HomeActivity", "bottom_line color");
            this.m.setBackgroundColor(BluedSkinUtils.a(this, 2131102258));
        }
        Log.e("HomeActivity", "applySkin listQBadgeContainer size: " + this.p.size());
        j(this.f);
        u();
    }

    @Override // com.soft.blued.ui.home.HomeContract.View
    public void b(String str, int i) {
        TabItem tabItem = this.k.get(str);
        if (tabItem == null || tabItem.h == null) {
            return;
        }
        tabItem.i.setVisibility(8);
        tabItem.g.setBageVisible(4);
        tabItem.h.setImageResource(i);
        tabItem.h.setVisibility(0);
    }

    @Override // com.soft.blued.ui.home.HomeContract.View
    public boolean b(String str) {
        TabItem tabItem = this.k.get(str);
        boolean z = false;
        if (tabItem != null) {
            z = false;
            if (tabItem.g.getBageVisible() == 0) {
                if (tabItem.g.getBadgeNumber() == 0) {
                    return false;
                }
                z = false;
                if (tabItem.g.getBageVisible() == 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // com.soft.blued.ui.home.HomeContract.View
    public void c(String str) {
        TabItem tabItem = this.k.get(str);
        if (tabItem != null) {
            if (TextUtils.equals(str, "msg") && this.z) {
                return;
            }
            tabItem.g.b(true);
        }
    }

    @Override // com.soft.blued.ui.home.HomeContract.View
    public void d(String str) {
        if (TextUtils.equals(str, "msg")) {
            this.d = true;
        }
        TabItem tabItem = this.k.get(str);
        if (tabItem == null || this.f.equals("live")) {
            return;
        }
        tabItem.i.setVisibility(0);
    }

    @Override // com.soft.blued.ui.home.HomeContract.View
    /* renamed from: e */
    public void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals(str, "msg")) {
            this.d = false;
        }
        TabItem tabItem = this.k.get(str);
        if (tabItem != null) {
            tabItem.i.setVisibility(4);
        }
    }

    public String f() {
        return this.f;
    }

    @Override // com.soft.blued.ui.home.HomeContract.View
    public void f(String str) {
        TabItem tabItem = this.k.get(str);
        if (tabItem == null || tabItem.h == null) {
            return;
        }
        tabItem.h.setVisibility(8);
        String badgeText = tabItem.g.getBadgeText();
        if (TextUtils.isEmpty(badgeText) || badgeText.equals("0")) {
            return;
        }
        tabItem.g.setBageVisible(0);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        Logger.e("HomeActivity", "finish ... ");
    }

    public int g() {
        return StringUtils.a(this.g, 1);
    }

    @Override // com.soft.blued.ui.home.HomeContract.View
    public void g(String str) {
        TabItem tabItem;
        if (this.z || (tabItem = this.k.get("msg")) == null) {
            return;
        }
        QBadgeContainer qBadgeContainer = tabItem.g;
        if (qBadgeContainer.getBageVisible() != 0 || TextUtils.isEmpty(qBadgeContainer.getBadgeText())) {
            this.z = true;
            qBadgeContainer.a(10.0f, true);
            qBadgeContainer.b(4.0f, true);
            qBadgeContainer.a(str);
            qBadgeContainer.a(1.0f, 0.0f, true);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tabItem.g.getBadgeView(), "rotation", 0.0f, -3.0f, 0.0f, 0.0f, 0.0f, -3.0f, 0.0f);
            ofFloat.setDuration(600L);
            ofFloat.start();
        }
    }

    public HomeTabBubble h() {
        HomeTabBubble homeTabBubble = this.s;
        HomeTabBubble homeTabBubble2 = homeTabBubble;
        if (homeTabBubble == null) {
            homeTabBubble2 = new HomeTabBubble();
        }
        return homeTabBubble2;
    }

    public boolean h(String str) {
        TabItem tabItem = this.k.get(str);
        boolean z = false;
        if (tabItem != null) {
            z = false;
            if (tabItem.i.getVisibility() == 0) {
                z = true;
            }
        }
        return z;
    }

    public void i() {
        this.s = new HomeTabBubble();
    }

    public void j() {
        MarketPraiseGuide s = BluedConfig.a().s();
        if (s == null || s.count <= 0) {
            return;
        }
        UserHttpUtils.a("show", 0, s.type);
        MarketTool a2 = MarketTool.a();
        String str = s.title;
        String str2 = s.content;
        String str3 = s.confirm;
        String str4 = s.cancel;
        a2.a(this, str, str2, str3, str4, s.type + "");
    }

    public void k() {
        String a2 = BluedPreferences.a("com.soft.blued.icon0");
        if ("com.soft.blued.icon0".equals(a2)) {
            return;
        }
        PackageManager packageManager = getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(this, a2), 2, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(this, "com.soft.blued.icon0"), 1, 1);
        BluedPreferences.b("com.soft.blued.icon0");
    }

    public String[] l() {
        HomeTabBubble homeTabBubble = this.s;
        if (homeTabBubble != null) {
            String[] strArr = new String[4];
            if (homeTabBubble.bubble_uid != null) {
                strArr[0] = this.s.bubble_uid.name;
                strArr[1] = this.s.bubble_uid.value;
            }
            if (this.s.bubble_tid != null) {
                strArr[2] = this.s.bubble_tid.name;
                strArr[3] = this.s.bubble_tid.value;
            }
            return strArr;
        }
        return null;
    }

    public void m() {
        this.v.setTranslationY(0.0f);
        this.v.setAlpha(1.0f);
        this.v.setVisibility(0);
        this.t.setAlpha(0.0f);
        EventTrackLive.a(LiveProtos.Event.LIVE_DOWN_GUIDE_IMAGE_SHOW);
        if (this.s != null) {
            ImageLoader.a(a(), this.s.bubble_img).a(this.v);
        }
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$_Al9ZRsuZCpgJMAWxwycqRjGEEQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeActivity.this.b(view);
            }
        });
        HomeTabBubble homeTabBubble = this.s;
        if (homeTabBubble == null || TextUtils.isEmpty(homeTabBubble.bubble_text)) {
            return;
        }
        HomeTabBubblePop homeTabBubblePop = this.r;
        if (homeTabBubblePop == null || !homeTabBubblePop.s()) {
            this.r = new HomeTabBubblePop(this);
            new XPopup.Builder(this).a(new SimpleCallback() { // from class: com.soft.blued.ui.home.HomeActivity.22
                @Override // com.blued.android.framework.ui.xpop.interfaces.SimpleCallback, com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void a(BasePopupView basePopupView) {
                    super.a(basePopupView);
                    HomeActivity.this.r.setText(HomeActivity.this.s.bubble_text);
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.SimpleCallback, com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void d(BasePopupView basePopupView) {
                    super.d(basePopupView);
                    HomeActivity.this.r = null;
                }
            }).d((Boolean) false).c(true).b(true).a(PopupPosition.Top).a(this.v).a(PopupAnimation.ScaleAlphaFromCenter).c((Boolean) false).c((int) ((-((View) this.v.getParent()).getHeight()) * 0.09f)).a((BasePopupView) this.r).h().a(10000L);
            this.r.setRootClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$kIYerHgsAS-Hpt52ErokiWmM9UI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeActivity.this.a(view);
                }
            });
            AppUtils.a(this.v);
        }
    }

    public void n() {
        v();
        HomeTabBubblePop homeTabBubblePop = this.r;
        if (homeTabBubblePop != null && homeTabBubblePop.s()) {
            this.r.post(new Runnable() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$8EOto7u7gxIMxeayKLLcrcKkGcg
                @Override // java.lang.Runnable
                public final void run() {
                    HomeActivity.this.D();
                }
            });
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.post(new Runnable() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$FjSYflYb9v12rr8V02OhRnjmPfM
                @Override // java.lang.Runnable
                public final void run() {
                    HomeActivity.this.B();
                }
            });
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.l.e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.ll_main_feed /* 2131368000 */:
                i(IAdInterListener.AdProdType.PRODUCT_FEEDS);
                HomeTabBubble homeTabBubble = this.s;
                if (homeTabBubble != null && homeTabBubble.bubble_group == 2) {
                    c(IAdInterListener.AdProdType.PRODUCT_FEEDS);
                }
                AppUtils.a(this.i, 999);
                return;
            case R.id.ll_main_find /* 2131368001 */:
                i("find");
                r();
                if (this.o) {
                    EventTrackFeed.d(FeedProtos.Event.FEED_BACK_TOP_CLICK);
                }
                AppUtils.a(this.i);
                return;
            case R.id.ll_main_live /* 2131368002 */:
                i("live");
                AppUtils.a(this.i, 999);
                return;
            case R.id.ll_main_msg /* 2131368003 */:
                i("msg");
                MessageEventUtils.a();
                AppUtils.a(this.i, 999);
                return;
            case R.id.ll_main_others /* 2131368004 */:
                i("mine");
                AppUtils.a(this.i, 999);
                return;
            default:
                return;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AreaUtils.initArea();
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        f30985c = this;
        this.q = (HomeViewModel) ViewModelProviders.of(this).get(HomeViewModel.class);
        if (AppInfo.p()) {
            try {
                this.n = StatusBarHelper.a((Activity) this);
            } catch (Exception e) {
            }
        }
        LiveListManager.a().a(this);
        super.onCreate(bundle);
        BluedPreferences.X(true);
        BaseActivity.f9718a = "";
        this.l = new HomePresenter(this, HomeArgumentHelper.a(getIntent(), "from_tag_page"), this, a());
        HomeTabClick.a(getClass());
        setContentView(2131558441);
        if (bundle != null) {
            this.f = bundle.getString("current_tag");
        }
        a(true, getIntent());
        a(getIntent());
        o();
        q();
        if (!BluedPreferences.w()) {
            if (BluedPreferences.aY()) {
                InstantLog.a("pattern_lock_open");
                EventTrackSettings.a(SettingsProtos.Event.PATTERN_LOCK_OPEN);
            } else {
                InstantLog.a("pattern_lock_close");
                EventTrackSettings.a(SettingsProtos.Event.PATTERN_LOCK_CLOSE);
            }
            BluedPreferences.x();
        }
        if (!DeviceUtils.b(this)) {
            InstantLog.a("close_push");
        }
        if (UserInfo.getInstance().getLoginUserInfo() != null && UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            k();
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.home.HomeActivity.1
            @Override // java.lang.Runnable
            public void run() {
                Log.v("dddrb", "HomeActivity updateConfigData");
                if (Build.VERSION.SDK_INT >= 19) {
                    try {
                        EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.SYSTEM_AUTHORITY, SystemAuthorityProtos.Type.PUSH, NotificationManagerCompat.from(HomeActivity.this.getApplication()).areNotificationsEnabled());
                    } catch (SecurityException e2) {
                        e2.printStackTrace();
                    }
                }
                HomeActivity.this.j();
                ExperimentConfig.a().c();
                TencentMapInitializer.setAgreePrivacy(true);
            }
        }, 2000L);
        InstantLog.a("app_start");
        EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.APP_START);
        if (BluedPreferences.aC() == -1) {
            if (StringUtils.d(BluedPreferences.C())) {
                BluedPreferences.c(0);
            } else {
                BluedPreferences.c(1);
            }
        }
        ActivityStack.a().a(HomeActivity.class);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.home.HomeActivity.2
            @Override // java.lang.Runnable
            public void run() {
                TabItem tabItem = (TabItem) HomeActivity.this.k.get("mine");
                if (tabItem != null) {
                    UserInfoUtils.a(tabItem);
                }
                HomeActivity.this.p();
            }
        }, 1000L);
        DurationUtils.a("App启动");
        LiveEventBus.get("into_new_yy_room", String.class).observe(this, new Observer<String>() { // from class: com.soft.blued.ui.home.HomeActivity.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                YYRoomInfoManager.e().a((BaseFragmentActivity) HomeActivity.this, str, YYRoomInfoManager.e().f, true);
            }
        });
        if (TextUtils.equals("armeabi-v7a", Build.CPU_ABI)) {
            BluedStatistics.c().a("CPU_ABI", 0L, 0, "");
        }
        this.l.f();
        LiveEventBus.get("EVENT_HIDE_HOME_TAB_DOT", String.class).observe(this, new Observer() { // from class: com.soft.blued.ui.home.-$$Lambda$HomeActivity$N9HFYIO0Jh52l4jDfX52KcdV1As
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeActivity.this.k((String) obj);
            }
        });
        DateTodayManager.f32404a.h();
        WebLinkManager.f34474a.a();
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AdFloatObserver.a().b(this);
        super.onDestroy();
        Logger.e("HomeActivity", "onDestroy ... ");
        LiveLogUtils.a("HomeActivity --> onDestroy --> closeLiveRoom");
        HomeTabClick.a();
        this.l.c();
        f30985c = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        a(false, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
        ChatHelperV4.a().d(this);
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        SendFeedFloatManager.a().a(getApplicationContext());
        LiveHttpUtils.a();
        MineHttpUtils.a();
        if (TimeAndDateUtils.a() > CommunityPreferences.C()) {
            CommunityPreferences.D();
            CommunityPreferences.F();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.v("drb", "跳转首页绘制完成");
        MobclickAgent.onResume(this);
        this.l.d();
        if (CommonConstants.f28315a.booleanValue()) {
            TerminalActivity.d(this, LockPatternSetupFragment.class, null);
        }
        Log.e("HomeActivity", "bluedAppHandoverListener" + BluedApplicationLike.bluedAppHandoverListener.a());
        if (BluedApplicationLike.bluedAppHandoverListener != null && !BluedApplicationLike.bluedAppHandoverListener.a()) {
            BluedApplicationLike.bluedAppHandoverListener.onAppFore(this);
        }
        ChatHelperV4.a().c(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.cl_mine_new_tip);
        if (this.f.equals("find")) {
            AppUtils.a(this.i);
            AppUtils.a(viewGroup);
            return;
        }
        AppUtils.a(this.i, 999);
        AppUtils.a(viewGroup, 999);
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        bundle.putString("current_tag", this.f);
    }

    @Override // com.blued.android.chat.listener.SingleSessionListener
    public void onSessionDataChanged(final SessionModel sessionModel) {
        if (sessionModel.sessionId == 4) {
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.home.HomeActivity.17
                @Override // java.lang.Runnable
                public void run() {
                    if (sessionModel.noReadMsgCount <= 0) {
                        HomeActivity.this.k("mine");
                        return;
                    }
                    BluedPreferences.G(true);
                    HomeActivity.this.d("mine");
                }
            });
        }
    }

    @Override // com.blued.android.chat.listener.SingleSessionListener
    public void onSessionRemoved(short s, long j) {
        if (s == 1 && j == 4) {
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.home.HomeActivity.18
                @Override // java.lang.Runnable
                public void run() {
                    HomeActivity.this.k("mine");
                }
            });
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.l.d();
        this.l.ar_();
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.l.b();
    }
}
