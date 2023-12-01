package com.soft.blued.ui.find.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.HomeTabBubble;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.dialog.SelectCityDialogFragment;
import com.blued.community.utils.CommunityPreferences;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.BluedADConstraintLayout;
import com.soft.blued.customview.NearbyHomeTabIndicator;
import com.soft.blued.customview.NearbyHomeViewPager;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.community.view.NearbyGuideDlgFragment;
import com.soft.blued.ui.find.adapter.NearbyHomePagerAdapter;
import com.soft.blued.ui.find.model.MapChanceEncounterStatusModel;
import com.soft.blued.ui.find.observer.AdFloatObserver;
import com.soft.blued.ui.find.observer.NearbyFindSetSelectedTab;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.find.presenter.NearbyHomePresenter;
import com.soft.blued.ui.group.UserGroupListsFragment;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.search.SearchAllFragment;
import com.soft.blued.ui.user.fragment.VipInvisibleDialogFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.welcome.PrivacyClauseDialog;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.AdTestManager;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.SplashUtil;
import com.soft.blued.version.update.UpdateVersionHelper;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.UETool;
import skin.support.observe.SkinObservable;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyHomeFragment.class */
public class NearbyHomeFragment extends MvpFragment<NearbyHomePresenter> implements SingleSessionListener, BluedSkinObserver, AdFloatObserver.IAdFloatObserver, NearbyFindSetSelectedTab.INearbyFindSetSelectedTab {

    /* renamed from: a  reason: collision with root package name */
    public static int f16702a;
    @BindView
    BluedADConstraintLayout adConstraintLayout;
    @BindView
    ImageView adNearbyImg;

    /* renamed from: c  reason: collision with root package name */
    private PopHolder f16703c;
    private Unbinder e;
    @BindView
    FrameLayout fl_floor;
    private NearbyHomePagerAdapter g;
    @BindView
    ShapeTextView imgNewLeftRemind;
    @BindView
    NearbyHomeTabIndicator indicatorTitle;
    @BindView
    ImageView ivGoldGuide1;
    @BindView
    ImageView ivGoldGuide2;
    @BindView
    ImageView ivGoldGuide3;
    @BindView
    ImageView ivGoldGuide4;
    @BindView
    ImageView ivGoldGuide5;
    private PopMenu k;
    private Context l;
    @BindView
    View layoutGoldGuide;
    @BindView
    View mTitle;
    @BindView
    ImageView mTitleLeft;
    @BindView
    ImageView mTitleRight;
    @BindView
    ShapeTextView mTitleRightDot;
    @BindView
    FrameLayout mTitleRightMenu;
    @BindView
    TextView mTitleRightText;
    @BindView
    NearbyHomeViewPager mViewPager;
    @BindView
    TextView nearbyActivityTip;
    private BluedADExtra s;
    @BindView
    ImageView second_floor;
    @BindView
    ShapeTextView second_floor_ad_icon;
    @BindView
    TextView tvMapTip;
    @BindView
    TextView tvSignDaysTip;
    @BindView
    TextView tvTip;
    private int u;
    private boolean v;
    @BindView
    TextView viewCityNew;
    private String w;
    private SplashUtil x;
    private List<Unbinder> d = new ArrayList();
    private boolean f = false;
    private boolean m = false;
    private boolean n = false;
    private HomeTabBubble o = null;
    private boolean p = false;
    private HomeTabBubble q = null;
    public boolean b = false;
    private ViewPager.OnPageChangeListener r = new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.14
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = ((NearbyHomePresenter) NearbyHomeFragment.this.j()).j.get(i).tab_id;
            if (i2 == 1) {
                NearbyHomeFragment.this.mTitleRightMenu.setVisibility(0);
                NearbyHomeFragment.this.mTitleRightText.setVisibility(8);
                Log.v("drb", "onPageSelected showNearbyActivity");
                NearbyHomeFragment nearbyHomeFragment = NearbyHomeFragment.this;
                nearbyHomeFragment.a(nearbyHomeFragment.s);
                NearbyHomeFragment.this.mTitleRight.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.14.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (NearbyHomeFragment.this.k.a()) {
                            NearbyHomeFragment.this.k.d();
                        } else {
                            NearbyHomeFragment.this.k.a(NearbyHomeFragment.this.mTitle);
                        }
                        NearbyHomeFragment.this.mTitleRightDot.setVisibility(8);
                        BluedPreferences.dk();
                    }
                });
            } else if (i2 == 2) {
                BluedPreferences.n();
                NearbyHomeFragment.this.mTitleRightMenu.setVisibility(8);
                NearbyHomeFragment.this.mTitleRightText.setVisibility(8);
                NearbyHomeFragment.this.adConstraintLayout.setVisibility(8);
                BluedPreferences.fi();
                CommunityPreferences.G();
            } else if (i2 == 3) {
                NearbyHomeFragment.this.mTitleRightMenu.setVisibility(0);
                NearbyHomeFragment.this.mTitleRight.setImageResource(R.drawable.icon_title_my_group);
                NearbyHomeFragment.this.mTitleRightText.setVisibility(8);
                NearbyHomeFragment.this.adConstraintLayout.setVisibility(8);
                NearbyHomeFragment.this.mTitleRight.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.14.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        InstantLog.a("my_group");
                        TerminalActivity.d(NearbyHomeFragment.this.l, UserGroupListsFragment.class, (Bundle) null);
                    }
                });
            }
            NearbyHomeFragment.f16702a = ((NearbyHomePresenter) NearbyHomeFragment.this.j()).j.get(i).tab_id;
        }
    };
    private int t = 0;

    /* renamed from: com.soft.blued.ui.find.fragment.NearbyHomeFragment$24  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyHomeFragment$24.class */
    class AnonymousClass24 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NearbyHomeFragment f16722a;

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f16722a.getFragmentActive().isActive() || this.f16722a.nearbyActivityTip == null) {
                return;
            }
            this.f16722a.nearbyActivityTip.setVisibility(8);
            Log.v("drb", "showNearbyBubble GONE");
        }
    }

    /* renamed from: com.soft.blued.ui.find.fragment.NearbyHomeFragment$25  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyHomeFragment$25.class */
    class AnonymousClass25 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NearbyHomeFragment f16723a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.f16723a.adConstraintLayout.performClick();
            EventTrackGuy.b(GuyProtos.Event.CHECK_IN_BUBBLE_CLICK);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyHomeFragment$PopHolder.class */
    public class PopHolder {
        @BindView
        TextView avatarIsOpening;
        @BindView
        View ivFilterDot;
        @BindView
        ImageView ivFilterMode;
        @BindView
        ImageView ivListMode;
        @BindView
        View ivMapDot;
        @BindView
        ImageView ivSplashToggle;
        @BindView
        ImageView ivSplashToggleHome;
        @BindView
        ImageView ivUEToolToggle;
        @BindView
        LinearLayout llCustomInvisible;
        @BindView
        LinearLayout llFilter;
        @BindView
        LinearLayout llList;
        @BindView
        LinearLayout llMap;
        @BindView
        LinearLayout llSearch;
        @BindView
        LinearLayout llSplash;
        @BindView
        LinearLayout llSplashHome;
        @BindView
        LinearLayout llUETool;
        @BindView
        TextView tvCustomInvisible;
        @BindView
        TextView tvFilterMode;
        @BindView
        TextView tvListMode;

        PopHolder() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyHomeFragment$PopHolder_ViewBinding.class */
    public class PopHolder_ViewBinding implements Unbinder {
        private PopHolder b;

        public PopHolder_ViewBinding(PopHolder popHolder, View view) {
            this.b = popHolder;
            popHolder.llFilter = (LinearLayout) Utils.a(view, R.id.ll_filter, "field 'llFilter'", LinearLayout.class);
            popHolder.ivFilterDot = Utils.a(view, R.id.iv_filter_dot, "field 'ivFilterDot'");
            popHolder.ivFilterMode = (ImageView) Utils.a(view, R.id.iv_filter_mode, "field 'ivFilterMode'", ImageView.class);
            popHolder.tvFilterMode = (TextView) Utils.a(view, R.id.tv_filter_mode, "field 'tvFilterMode'", TextView.class);
            popHolder.llMap = (LinearLayout) Utils.a(view, R.id.ll_map, "field 'llMap'", LinearLayout.class);
            popHolder.llSearch = (LinearLayout) Utils.a(view, R.id.ll_search, "field 'llSearch'", LinearLayout.class);
            popHolder.llList = (LinearLayout) Utils.a(view, R.id.ll_list, "field 'llList'", LinearLayout.class);
            popHolder.llSplash = (LinearLayout) Utils.a(view, R.id.ll_splash, "field 'llSplash'", LinearLayout.class);
            popHolder.ivSplashToggle = (ImageView) Utils.a(view, R.id.iv_splash_toggle, "field 'ivSplashToggle'", ImageView.class);
            popHolder.llUETool = (LinearLayout) Utils.a(view, R.id.ll_uetool, "field 'llUETool'", LinearLayout.class);
            popHolder.ivUEToolToggle = (ImageView) Utils.a(view, R.id.iv_uetool_toggle, "field 'ivUEToolToggle'", ImageView.class);
            popHolder.llSplashHome = (LinearLayout) Utils.a(view, R.id.ll_splash_home, "field 'llSplashHome'", LinearLayout.class);
            popHolder.ivSplashToggleHome = (ImageView) Utils.a(view, R.id.iv_splash_toggle_home, "field 'ivSplashToggleHome'", ImageView.class);
            popHolder.ivListMode = (ImageView) Utils.a(view, R.id.iv_list_mode, "field 'ivListMode'", ImageView.class);
            popHolder.tvListMode = (TextView) Utils.a(view, R.id.tv_list_mode, "field 'tvListMode'", TextView.class);
            popHolder.llCustomInvisible = (LinearLayout) Utils.a(view, R.id.ll_custom_invisible, "field 'llCustomInvisible'", LinearLayout.class);
            popHolder.tvCustomInvisible = (TextView) Utils.a(view, R.id.tv_custom_invisible, "field 'tvCustomInvisible'", TextView.class);
            popHolder.avatarIsOpening = (TextView) Utils.a(view, R.id.avatar_is_opening, "field 'avatarIsOpening'", TextView.class);
            popHolder.ivMapDot = Utils.a(view, R.id.iv_map_dot, "field 'ivMapDot'");
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            PopHolder popHolder = this.b;
            if (popHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            popHolder.llFilter = null;
            popHolder.ivFilterDot = null;
            popHolder.ivFilterMode = null;
            popHolder.tvFilterMode = null;
            popHolder.llMap = null;
            popHolder.llSearch = null;
            popHolder.llList = null;
            popHolder.llSplash = null;
            popHolder.ivSplashToggle = null;
            popHolder.llUETool = null;
            popHolder.ivUEToolToggle = null;
            popHolder.llSplashHome = null;
            popHolder.ivSplashToggleHome = null;
            popHolder.ivListMode = null;
            popHolder.tvListMode = null;
            popHolder.llCustomInvisible = null;
            popHolder.tvCustomInvisible = null;
            popHolder.avatarIsOpening = null;
            popHolder.ivMapDot = null;
        }
    }

    private void A() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 1.0f);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                NearbyHomeFragment.this.viewCityNew.setVisibility(0);
            }
        });
        scaleAnimation.setStartOffset(400L);
        scaleAnimation.setDuration(750L);
        this.viewCityNew.startAnimation(scaleAnimation);
    }

    private void B() {
        if (this.q == null) {
            return;
        }
        LogUtils.c("tab顶切 点击：" + this.q.bubble_text + ", type:" + this.q.bubble_type);
        if (this.q.bubble_type == 1101 || this.q.bubble_type == 1102) {
            CommunityManager.a.a().a(true);
        }
        EventTrackFeed.a(FeedProtos.Event.CITY_TOP_BUBBLE_CLICK, this.q.bubble_type);
        this.mViewPager.setCurrentItem(((NearbyHomePresenter) j()).k);
        this.r.onPageSelected(((NearbyHomePresenter) j()).k);
        this.q = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.indicatorTitle.d(((NearbyHomePresenter) j()).k);
        c();
    }

    private void D() {
        Context context = this.l;
        if (context == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.pop_nearby_people_right_menu, (ViewGroup) null);
        PopHolder popHolder = new PopHolder();
        this.f16703c = popHolder;
        Unbinder a2 = ButterKnife.a(popHolder, viewGroup);
        this.e = a2;
        this.d.add(a2);
        if (!BluedPreferences.dl()) {
            this.f16703c.ivFilterDot.setVisibility(0);
        }
        if (BluedPreferences.en()) {
            this.f16703c.ivMapDot.setVisibility(0);
        }
        Log.v("drb", "initPop:");
        a((Boolean) false);
        PopMenu popMenu = new PopMenu(this.l, viewGroup);
        this.k = popMenu;
        popMenu.a(new PopMenu.onShowListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.3
            @Override // com.soft.blued.customview.PopMenu.onShowListener
            public void a() {
                EventTrackGuy.a(GuyProtos.Event.NEARBY_SETTINGS_BTN_CLICK);
                if (NearbyHomeFragment.this.f16703c.ivFilterMode == null || NearbyHomeFragment.this.f16703c.tvFilterMode == null || NearbyHomeFragment.this.f16703c.ivListMode == null || NearbyHomeFragment.this.f16703c.tvListMode == null) {
                    return;
                }
                if (BluedPreferences.H()) {
                    NearbyHomeFragment.this.f16703c.ivFilterMode.setImageDrawable(BluedSkinUtils.b(NearbyHomeFragment.this.l, (int) R.drawable.icon_nearby_filter_on));
                    NearbyHomeFragment.this.f16703c.tvFilterMode.setText(R.string.opened);
                    NearbyHomeFragment.this.f16703c.tvFilterMode.setTextColor(BluedSkinUtils.a(NearbyHomeFragment.this.l, 2131102254));
                } else {
                    NearbyHomeFragment.this.f16703c.ivFilterMode.setImageDrawable(BluedSkinUtils.b(NearbyHomeFragment.this.l, (int) R.drawable.icon_nearby_filter_off));
                    NearbyHomeFragment.this.f16703c.tvFilterMode.setText(R.string.closed);
                    NearbyHomeFragment.this.f16703c.tvFilterMode.setTextColor(BluedSkinUtils.a(NearbyHomeFragment.this.l, 2131102263));
                }
                if (BluedPreferences.J() == 0) {
                    NearbyHomeFragment.this.f16703c.ivListMode.setImageDrawable(BluedSkinUtils.b(NearbyHomeFragment.this.l, (int) R.drawable.icon_nearby_list_mode));
                    NearbyHomeFragment.this.f16703c.tvListMode.setText(R.string.list_model);
                } else {
                    NearbyHomeFragment.this.f16703c.ivListMode.setImageDrawable(BluedSkinUtils.b(NearbyHomeFragment.this.l, (int) R.drawable.icon_nearby_grid_mode));
                    NearbyHomeFragment.this.f16703c.tvListMode.setText(R.string.gird_model);
                }
                if (BluedPreferences.E()) {
                    NearbyHomeFragment.this.f16703c.llSplash.setVisibility(0);
                    NearbyHomeFragment.this.f16703c.llSplashHome.setVisibility(0);
                    if (AdTestManager.f21022a.a()) {
                        NearbyHomeFragment.this.f16703c.ivSplashToggleHome.setImageResource(2131237259);
                    } else {
                        NearbyHomeFragment.this.f16703c.ivSplashToggleHome.setImageResource(2131237258);
                    }
                }
                NearbyHomeFragment.this.E();
                NearbyHomeFragment.this.b(999);
            }
        });
        this.k.a(new PopupWindow.OnDismissListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                NearbyHomeFragment.this.z();
            }
        });
        this.f16703c.llFilter.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyHomeFragment.this.k.d();
                if (NearbyHomeFragment.this.H()) {
                    EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_FILTER_BTN_CLICK);
                    InstantLog.a("nearby_filter_btn_click");
                    if (BluedPreferences.dl()) {
                        return;
                    }
                    BluedPreferences.dm();
                    NearbyHomeFragment.this.f16703c.ivFilterDot.setVisibility(8);
                }
            }
        });
        this.f16703c.llCustomInvisible.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyHomeFragment.this.k.d();
                NearbyHomeFragment.this.I();
                EventTrackGuy.a(GuyProtos.Event.NEARBY_SETTINGS_HIDE_CLICK);
            }
        });
        this.f16703c.llMap.setVisibility(8);
        this.f16703c.llMap.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyHomeFragment.this.k.d();
                NearbyHomeFragment.this.J();
                GuyProtos.Event event = GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_CLICK;
                boolean z = true;
                if (BluedConfig.a().g().is_chat_shadow != 1) {
                    z = false;
                }
                EventTrackGuy.c(event, z);
                if (BluedPreferences.en()) {
                    BluedPreferences.eo();
                    NearbyHomeFragment.this.f16703c.ivMapDot.setVisibility(8);
                }
            }
        });
        this.f16703c.llSearch.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyHomeFragment.this.k.d();
                SearchAllFragment.a(NearbyHomeFragment.this.l, 0);
            }
        });
        this.f16703c.llList.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyHomeFragment.this.k.d();
                if (HomeActivity.f17295c != null) {
                    ((NearbyViewModel) ViewModelProviders.of((FragmentActivity) HomeActivity.f17295c).get(NearbyViewModel.class)).b.postValue(null);
                }
            }
        });
        this.f16703c.llSplash.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                BluedPreferences.b(!BluedPreferences.F());
                if (!BluedPreferences.F()) {
                    NearbyHomeFragment.this.f16703c.ivSplashToggle.setImageResource(2131237258);
                    return;
                }
                NearbyHomeFragment.this.f16703c.ivSplashToggle.setImageResource(2131237259);
                if (NearbyHomeFragment.this.x != null) {
                    NearbyHomeFragment.this.x.a(NearbyHomeFragment.this.x.a());
                }
            }
        });
        this.f16703c.llSplashHome.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (AdTestManager.f21022a.a()) {
                    NearbyHomeFragment.this.f16703c.ivSplashToggleHome.setImageResource(2131237258);
                    AdTestManager.f21022a.b().m();
                    return;
                }
                TerminalActivity.d(NearbyHomeFragment.this.getActivity(), AdTestFragment.class, new Bundle());
                NearbyHomeFragment.this.k.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (AppInfo.m()) {
            this.f16703c.llUETool.setVisibility(0);
            if (BluedPreferences.G()) {
                this.f16703c.ivUEToolToggle.setImageResource(2131237259);
            } else {
                this.f16703c.ivUEToolToggle.setImageResource(2131237258);
            }
        } else {
            this.f16703c.llUETool.setVisibility(8);
        }
        this.f16703c.ivUEToolToggle.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(NearbyHomeFragment.this.getContext())) {
                    UETool.a();
                    return;
                }
                BluedPreferences.c(!BluedPreferences.G());
                if (BluedPreferences.G()) {
                    UETool.a();
                    NearbyHomeFragment.this.f16703c.ivUEToolToggle.setImageResource(2131237259);
                    return;
                }
                UETool.b();
                NearbyHomeFragment.this.f16703c.ivUEToolToggle.setImageResource(2131237258);
            }
        });
    }

    private void F() {
        int i = 0;
        this.tvMapTip.setBackground(NinePatchUtils.a(NinePatchUtils.GuideArrowPosition.a, new int[0]));
        this.tvSignDaysTip.setBackground(NinePatchUtils.a(NinePatchUtils.GuideArrowPosition.c, new int[0]));
        if (this.g == null) {
            this.g = new NearbyHomePagerAdapter(getChildFragmentManager(), ((NearbyHomePresenter) j()).j);
        }
        this.mViewPager.setAdapter(this.g);
        this.mViewPager.setOffscreenPageLimit(((NearbyHomePresenter) j()).j.size());
        this.indicatorTitle.setViewPager(this.mViewPager);
        this.indicatorTitle.setOnPageChangeListener(this.r);
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.13
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                NearbyHomeFragment.this.c(i2);
                NearbyHomeFragment.this.b(i2);
                NearbyHomeFragment.this.C();
            }
        });
        int o = BluedConfig.a().o();
        while (true) {
            if (i >= ((NearbyHomePresenter) j()).j.size()) {
                break;
            } else if (o == ((NearbyHomePresenter) j()).j.get(i).tab_id) {
                this.mViewPager.setCurrentItem(i);
                this.r.onPageSelected(i);
                break;
            } else {
                i++;
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fl_floor.getLayoutParams();
        layoutParams.width = AppInfo.l;
        int i2 = (int) (AppInfo.l * 1.2666667f);
        this.t = i2;
        layoutParams.height = i2;
        this.fl_floor.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void G() {
        if (this.x == null) {
            this.x = new SplashUtil(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H() {
        if (FilterDialogFragment.b) {
            return false;
        }
        new FilterDialogFragment().show(getChildFragmentManager(), "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        VipInvisibleDialogFragment vipInvisibleDialogFragment = new VipInvisibleDialogFragment();
        vipInvisibleDialogFragment.b = this.l.getResources().getString(R.string.custom_invisible);
        vipInvisibleDialogFragment.f20471c = "nearby_settings_hide";
        vipInvisibleDialogFragment.show(getChildFragmentManager(), NearbyHomeFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        PermissionUtils.c(new PermissionCallbacks() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.15
            public void U_() {
                FindSearchMapFragment.a(NearbyHomeFragment.this.getActivity(), 2);
            }

            public void a(String[] strArr) {
            }
        });
    }

    private void K() {
        z();
        this.mTitleRightText.setVisibility(8);
        this.mTitleRightMenu.setVisibility(0);
        if (StatusBarHelper.a()) {
            this.mTitle.setPadding(0, StatusBarHelper.a(getActivity()), 0, 0);
        }
        if (BluedPreferences.dj()) {
            this.mTitleRightDot.setVisibility(0);
        }
        if (BluedPreferences.H()) {
            this.mTitleRight.setImageDrawable(BluedSkinUtils.b(this.l, (int) R.drawable.icon_title_filter_open));
        } else {
            this.mTitleRight.setImageDrawable(BluedSkinUtils.b(this.l, (int) R.drawable.icon_title_filter_off));
        }
        this.mTitleLeft.setVisibility(0);
        this.mTitleLeft.setImageDrawable(BluedSkinUtils.b(this.l, (int) R.drawable.icon_title_map_finder));
        if (BluedPreferences.eG()) {
            L();
        } else {
            this.tvMapTip.setVisibility(8);
        }
        if (BluedPreferences.en()) {
            this.imgNewLeftRemind.setVisibility(0);
        }
        this.mTitleLeft.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                BluedPreferences.eo();
                GuyProtos.Event event = GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_CLICK;
                boolean z = true;
                if (BluedConfig.a().g().is_chat_shadow != 1) {
                    z = false;
                }
                EventTrackGuy.c(event, z);
                NearbyHomeFragment.this.J();
                NearbyHomeFragment.this.imgNewLeftRemind.setVisibility(8);
            }
        });
        this.mTitleRight.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyHomeFragment.this.k.a(NearbyHomeFragment.this.mTitle);
                NearbyHomeFragment.this.mTitleRightDot.setVisibility(8);
                BluedPreferences.dk();
            }
        });
        this.mTitle.post(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.18
            @Override // java.lang.Runnable
            public void run() {
                if (NearbyHomeFragment.this.mTitle != null) {
                    NearbyHomeFragment nearbyHomeFragment = NearbyHomeFragment.this;
                    nearbyHomeFragment.u = nearbyHomeFragment.mTitle.getHeight();
                }
            }
        });
    }

    private void L() {
        this.tvMapTip.setVisibility(0);
        a(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.19
            @Override // java.lang.Runnable
            public void run() {
                if (NearbyHomeFragment.this.tvMapTip != null) {
                    NearbyHomeFragment.this.tvMapTip.setVisibility(8);
                }
            }
        }, m.ag);
        BluedPreferences.eH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.tvTip, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(2000L);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (NearbyHomeFragment.this.tvTip != null) {
                    NearbyHomeFragment.this.tvTip.setVisibility(8);
                }
                BluedPreferences.ad(UserInfo.getInstance().getLoginUserInfo().uid);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        this.indicatorTitle.d(((NearbyHomePresenter) j()).k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O() {
        if (!this.m) {
            c();
            return;
        }
        HomeTabBubble homeTabBubble = null;
        if (HomeActivity.f17295c != null) {
            homeTabBubble = HomeActivity.f17295c.h();
        }
        a(homeTabBubble);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, View view) {
        Tracker.onClick(view);
        if (this.mViewPager.getCurrentItem() != i) {
            this.mViewPager.setCurrentItem(i);
        } else if (getFragmentManager() != null) {
            SelectCityDialogFragment.a.a(getFragmentManager());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        this.b = true;
        this.tvTip.setVisibility(8);
        BluedPreferences.ad(UserInfo.getInstance().getLoginUserInfo().uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        if (CommunityManager.a.a().f()) {
            this.p = true;
        } else {
            NearbyGuideDlgFragment.f16111a.a(this);
        }
    }

    private void a(String str, int i) {
        if (this.tvSignDaysTip != null) {
            ((RelativeLayout.LayoutParams) this.tvSignDaysTip.getLayoutParams()).topMargin = this.mTitle.getBottom() - DensityUtils.a(this.l, 10.0f);
            this.tvSignDaysTip.setVisibility(0);
            this.tvSignDaysTip.setText(str);
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.28
                @Override // java.lang.Runnable
                public void run() {
                    if (!NearbyHomeFragment.this.getFragmentActive().isActive() || NearbyHomeFragment.this.nearbyActivityTip == null) {
                        return;
                    }
                    NearbyHomeFragment.this.tvSignDaysTip.setVisibility(8);
                    Log.v("drb", "showNearbyBubble GONE");
                }
            }, i * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.mTitle == null) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < ((NearbyHomePresenter) j()).j.size(); i3++) {
            if (((NearbyHomePresenter) j()).j.get(i3).tab_id == 1) {
                i2 = i3;
            }
        }
        if (i2 == i) {
            z();
        } else {
            this.mTitle.setBackgroundColor(BluedSkinUtils.a(this.l, 2131101780));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final BluedADExtra bluedADExtra) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.23
            @Override // java.lang.Runnable
            public void run() {
                ImageLoader.a(NearbyHomeFragment.this.getFragmentActive(), bluedADExtra.ads_pics).a(NearbyHomeFragment.this.adNearbyImg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(HomeTabBubble homeTabBubble) {
        if (homeTabBubble == null || TextUtils.isEmpty(homeTabBubble.bubble_text)) {
            c();
            return;
        }
        if (homeTabBubble.bubble_type == 6) {
            BluedPreferences.n();
        }
        LogUtils.c("bubble: " + homeTabBubble.bubble_text);
        LogUtils.c("bubble: isShowAdFloat: " + CommunityManager.a.a().f());
        if (CommunityManager.a.a().f()) {
            this.o = homeTabBubble;
        } else {
            a(homeTabBubble);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        final int i2 = ((NearbyHomePresenter) j()).k;
        Drawable b = BluedSkinUtils.b(this.l, 2131233901);
        b.setBounds(0, 0, b.getMinimumWidth(), b.getMinimumHeight());
        if (i2 == i) {
            this.indicatorTitle.e(i2).setCompoundDrawables(null, null, b, null);
        } else {
            this.indicatorTitle.e(i2).setCompoundDrawables(null, null, null, null);
        }
        this.indicatorTitle.e(i2).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyHomeFragment$E5RcxnQs722Y65BzRATkNQ_6ygg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NearbyHomeFragment.this.a(i2, view);
            }
        });
        if (((NearbyHomePresenter) j()).j.get(i).tab_id != 2 || this.q == null) {
            return;
        }
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Boolean bool) {
        if (this.n != bool.booleanValue()) {
            this.n = bool.booleanValue();
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        View view = this.mTitle;
        if (view == null) {
            return;
        }
        if (this.n) {
            view.setBackgroundColor(BluedSkinUtils.a(this.l, 2131101780));
        } else {
            view.setBackgroundColor(BluedSkinUtils.a(this.l, 2131101796));
        }
    }

    public void a(float f, int i) {
        FrameLayout frameLayout = this.fl_floor;
        if (frameLayout == null || frameLayout.getVisibility() != 0) {
            return;
        }
        View view = this.mTitle;
        if (view != null) {
            view.setAlpha(1.0f - Math.min(f * 1.8f, 1.0f));
        }
        FrameLayout frameLayout2 = this.fl_floor;
        if (frameLayout2 != null) {
            frameLayout2.setTranslationY(Math.min((i - this.t) + this.u, 0));
        }
    }

    @Override // com.soft.blued.ui.find.observer.NearbyFindSetSelectedTab.INearbyFindSetSelectedTab
    public void a(int i) {
        NearbyHomeViewPager nearbyHomeViewPager = this.mViewPager;
        if (nearbyHomeViewPager == null || i < 0 || nearbyHomeViewPager.getChildCount() <= i) {
            return;
        }
        this.mViewPager.setCurrentItem(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Rect rect) {
        this.mViewPager.setIgnoreRect(rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Bundle bundle) {
        super.a(bundle);
        D();
        G();
        K();
        F();
        a(this.v, "", false);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CITY_NEW, HomeTabBubble.class).observe(this, new Observer() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyHomeFragment$gQDj99EirIv6uGjdM6nkuaNe3WQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearbyHomeFragment.this.b((HomeTabBubble) obj);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_NEARBY_TITLE_SYC_B, Boolean.class).observe(this, new Observer() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyHomeFragment$t54ygk9g5SGz-KbzTd2CbFVIMhA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearbyHomeFragment.this.c((Boolean) obj);
            }
        });
        LiveEventBus.get("EVENT_NEARBY_GUIDE_POP", Object.class).observe(this, new Observer() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyHomeFragment$olJ52RmUETxuIDy_eymeC2k6qb0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearbyHomeFragment.this.a(obj);
            }
        });
        a(new Runnable() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyHomeFragment$QFR9lZffOgV-duiyaX76zTBvNvM
            @Override // java.lang.Runnable
            public final void run() {
                NearbyHomeFragment.this.O();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final BluedADExtra bluedADExtra) {
        Log.v("drb", "showNearbyActivity:" + bluedADExtra);
        if (bluedADExtra == null) {
            this.adConstraintLayout.setVisibility(8);
            return;
        }
        this.s = bluedADExtra;
        this.adConstraintLayout.setVisibility(0);
        this.adConstraintLayout.a(bluedADExtra, new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackGuy.b(GuyProtos.Event.NEARBY_SETTINGS_AD_ENTER_CLICK);
                WebViewShowInfoFragment.show(NearbyHomeFragment.this.l, bluedADExtra.target_url, 9);
            }
        });
        boolean z = !TextUtils.isEmpty(bluedADExtra.ads_apng);
        if (!TextUtils.isEmpty(bluedADExtra.ads_gif)) {
            z = true;
        }
        boolean z2 = z;
        if (!TextUtils.isEmpty(bluedADExtra.ads_apng)) {
            z2 = z;
            if (!TextUtils.isEmpty(bluedADExtra.ads_gif)) {
                z2 = true;
            }
        }
        if (!z2) {
            b(bluedADExtra);
        } else if (z2) {
            ImageLoader.a(getFragmentActive(), bluedADExtra.ads_apng).f().a(new ImageLoader.OnAnimationStateListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.21
                public void a() {
                }

                public void b() {
                    if (NearbyHomeFragment.this.getFragmentActive().isActive()) {
                        NearbyHomeFragment.this.b(bluedADExtra);
                    }
                }
            }).a(this.adNearbyImg);
        } else if (z2) {
            ImageLoader.a(getFragmentActive(), bluedADExtra.ads_gif).h().a(new ImageLoader.OnAnimationStateListener() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.22
                public void a() {
                }

                public void b() {
                    if (NearbyHomeFragment.this.getFragmentActive().isActive()) {
                        NearbyHomeFragment.this.b(bluedADExtra);
                    }
                }
            }).a(this.adNearbyImg);
        }
        EventTrackGuy.b(GuyProtos.Event.NEARBY_SETTINGS_AD_ENTER_SHOW);
    }

    public void a(HomeTabBubble homeTabBubble) {
        String str;
        int i;
        if (homeTabBubble == null || TextUtils.isEmpty(homeTabBubble.bubble_text)) {
            return;
        }
        this.q = homeTabBubble;
        LogUtils.c("tab顶切 显示：" + this.q.bubble_text + ", type:" + this.q.bubble_type);
        this.viewCityNew.setText(homeTabBubble.bubble_text);
        TextView e = this.indicatorTitle.e(((NearbyHomePresenter) j()).k);
        int[] iArr = new int[2];
        e.getLocationInWindow(iArr);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.viewCityNew.getLayoutParams();
        layoutParams.leftMargin = Math.max(iArr[0], AppInfo.l / 2) + ((e.getMeasuredWidth() == 0 ? FeedMethods.c(35) : e.getMeasuredWidth()) / 2);
        layoutParams.topMargin = iArr[1] - DensityUtils.a(this.l, 13.0f);
        this.viewCityNew.setLayoutParams(layoutParams);
        if (homeTabBubble.bubble_type == 1101) {
            if (CommunityManager.a.a().s()) {
                this.viewCityNew.setBackgroundResource(R.drawable.nearby_bubble_blue_bg_dark);
            } else {
                this.viewCityNew.setBackgroundResource(R.drawable.nearby_bubble_blue_bg);
            }
        } else if (CommunityManager.a.a().s()) {
            this.viewCityNew.setBackgroundResource(R.drawable.nearby_bubble_red_bg_dark);
        } else {
            this.viewCityNew.setBackgroundResource(R.drawable.nearby_bubble_red_bg);
        }
        this.viewCityNew.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyHomeFragment$ycDynSYp7eggUyAjX940DBxQX8c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NearbyHomeFragment.this.b(view);
            }
        });
        EventTrackFeed.a(FeedProtos.Event.CITY_TOP_BUBBLE_SHOW, homeTabBubble.bubble_type);
        this.m = true;
        if (homeTabBubble.bubble_type != 1101 || CommunityManager.a.a().a() == null || CommunityManager.a.a().a().getDouble_click_feed_id() <= 0) {
            str = null;
            i = 12;
            if (homeTabBubble.bubble_type == 1102) {
                str = null;
                i = 12;
                if (CommunityManager.a.a().a() != null) {
                    str = null;
                    i = 12;
                    if (CommunityManager.a.a().a().extra_bubble_img != null) {
                        String str2 = CommunityManager.a.a().a().extra_bubble_img;
                        str = str2;
                        i = 12;
                        if (CommunityManager.a.a().a().extra_bubble_type == 2) {
                            i = 4;
                            str = str2;
                        }
                    }
                }
            }
        } else {
            str = CommunityManager.a.a().a().double_click_feed_avatar;
            i = 12;
        }
        if (!TextUtils.isEmpty(str)) {
            this.indicatorTitle.a(((NearbyHomePresenter) j()).k, str, i);
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyHomeFragment$jGiHMby0V8E3VrVQ8FgpWEdAK60
                @Override // java.lang.Runnable
                public final void run() {
                    NearbyHomeFragment.this.N();
                }
            }, 5300L);
        }
        A();
        CommunityManager.a.a().j(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(MapChanceEncounterStatusModel mapChanceEncounterStatusModel) {
        if (BluedPreferences.en()) {
            return;
        }
        if (mapChanceEncounterStatusModel.is_update) {
            this.imgNewLeftRemind.setVisibility(0);
        } else {
            this.imgNewLeftRemind.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Boolean bool) {
        Log.v("drb", "--setInvisibleState:" + bool);
        if (bool.booleanValue()) {
            this.f16703c.tvCustomInvisible.setText(R.string.opened);
            this.f16703c.tvCustomInvisible.setTextColor(BluedSkinUtils.a(this.l, 2131102254));
            return;
        }
        this.f16703c.tvCustomInvisible.setText(R.string.closed);
        this.f16703c.tvCustomInvisible.setTextColor(BluedSkinUtils.a(this.l, 2131102263));
    }

    public void a(SkinObservable skinObservable, Object obj) {
        if (this.mTitle == null || this.indicatorTitle == null) {
            return;
        }
        z();
        c(this.mViewPager.getCurrentItem());
    }

    public void a(boolean z, String str, boolean z2) {
        if (this.fl_floor == null || this.mTitle == null) {
            return;
        }
        this.v = z;
        this.w = str;
        if (TextUtils.isEmpty(str)) {
            View view = this.mTitle;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            FrameLayout frameLayout = this.fl_floor;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else {
            FrameLayout frameLayout2 = this.fl_floor;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            if (this.second_floor != null) {
                ImageLoader.a(getFragmentActive(), str).a(this.second_floor);
            }
        }
        if (z2) {
            this.second_floor_ad_icon.setVisibility(0);
        } else {
            this.second_floor_ad_icon.setVisibility(8);
        }
        a(0.0f, 0);
    }

    @Override // com.soft.blued.ui.find.observer.AdFloatObserver.IAdFloatObserver
    public void ae_() {
        if (this.p) {
            this.p = false;
            NearbyGuideDlgFragment.f16111a.a(this);
        }
        LogUtils.c("bubble: onAdFloatClose: ");
        if (this.o == null || !k() || getFragmentActive() == null || !getFragmentActive().isActive()) {
            return;
        }
        HomeTabBubble homeTabBubble = new HomeTabBubble();
        ReflectionUtils.a(this.o, homeTabBubble);
        a(homeTabBubble);
        this.o = null;
    }

    public void af_() {
        super.af_();
        Unbinder unbinder = this.e;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Boolean bool) {
        if (bool.booleanValue()) {
            this.f16703c.avatarIsOpening.setVisibility(0);
            this.f16703c.avatarIsOpening.setText(R.string.header_location_is_open);
            this.f16703c.avatarIsOpening.setTextColor(BluedSkinUtils.a(this.l, 2131102263));
            return;
        }
        this.f16703c.avatarIsOpening.setVisibility(8);
        this.f16703c.avatarIsOpening.setText(R.string.header_location_is_open);
        this.f16703c.avatarIsOpening.setTextColor(BluedSkinUtils.a(this.l, 2131102254));
    }

    public void c() {
        this.viewCityNew.setVisibility(8);
        this.m = false;
        CommunityManager.a.a().j(false);
    }

    public void c(String str) {
        a(str, 5);
    }

    public void d() {
        if (this.b) {
            return;
        }
        this.tvTip.setVisibility(0);
        this.tvTip.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyHomeFragment$UR-b4cub00naCzCo3xdL_k1iqOw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NearbyHomeFragment.this.a(view);
            }
        });
        a(new Runnable() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyHomeFragment$UpBp_31Qo5DgmE08z7zFEiQW_yM
            @Override // java.lang.Runnable
            public final void run() {
                NearbyHomeFragment.this.M();
            }
        }, 5000L);
        BluedPreferences.dg();
        this.b = true;
    }

    public void e() {
        this.tvTip.setVisibility(8);
    }

    public int g() {
        return R.layout.fragment_main_find;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        SplashUtil splashUtil = this.x;
        if (splashUtil != null) {
            splashUtil.a(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = getActivity();
        NearbyFindSetSelectedTab.a().a(this);
        BluedSkinUtils.a(this);
        AdFloatObserver.a().a(this);
    }

    public void onDestroy() {
        super.onDestroy();
        NearbyFindSetSelectedTab.a().b(this);
        BluedSkinUtils.b(this);
        AdFloatObserver.a().b(this);
    }

    public void onPause() {
        BluedPreferences.n();
        BluedConfig.a().f21008a = false;
        super.onPause();
    }

    public void onResume() {
        ShapeTextView shapeTextView;
        super.onResume();
        if (!this.f) {
            this.f = true;
            UpdateVersionHelper.b(this.l);
            a(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.26
                @Override // java.lang.Runnable
                public void run() {
                    PrivacyClauseDialog.a(NearbyHomeFragment.this.l, (IRequestHost) NearbyHomeFragment.this.getFragmentActive());
                }
            }, 1000L);
        }
        if (!BluedPreferences.be() && (shapeTextView = this.imgNewLeftRemind) != null) {
            shapeTextView.setVisibility(8);
        }
        if (BluedPreferences.en()) {
            this.imgNewLeftRemind.setVisibility(0);
        }
        x();
        AppUtils.a(this.fl_floor);
        AppUtils.a(this.second_floor);
        AppUtils.a((View) this.second_floor_ad_icon);
        AppUtils.a(this.layoutGoldGuide);
        AppUtils.a(this.mTitle);
        AppUtils.a(this.viewCityNew);
        AppUtils.a(this.nearbyActivityTip);
        AppUtils.a(this.tvTip);
        AppUtils.a(this.tvSignDaysTip);
        AppUtils.a(this.tvMapTip);
    }

    public void onSessionDataChanged(SessionModel sessionModel) {
        if (sessionModel.sessionId == 4) {
            postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyHomeFragment.27
                @Override // java.lang.Runnable
                public void run() {
                    NearbyHomeFragment.this.imgNewLeftRemind.setVisibility(8);
                }
            });
        }
    }

    public void onSessionRemoved(short s, long j) {
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public boolean q() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        this.indicatorTitle.b();
        c(this.mViewPager.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        if (BluedPreferences.H()) {
            this.mTitleRight.setImageDrawable(BluedSkinUtils.b(this.l, (int) R.drawable.icon_title_filter_open));
        } else {
            this.mTitleRight.setImageDrawable(BluedSkinUtils.b(this.l, (int) R.drawable.icon_title_filter_off));
        }
    }

    public void x() {
        ((NearbyHomePresenter) j()).a((IRequestHost) getFragmentActive());
    }

    public void y() {
        AnimationUtils.a(this.ivGoldGuide1, 350.0f, 2, 800, 400L);
        AnimationUtils.a(this.ivGoldGuide2, 350.0f, 2, 800, 200L);
        AnimationUtils.a(this.ivGoldGuide3, 350.0f, 2, 800, 0L);
        AnimationUtils.a(this.ivGoldGuide4, 350.0f, 2, 800, 80L);
        AnimationUtils.a(this.ivGoldGuide5, 350.0f, 2, 800, 600L);
    }
}
