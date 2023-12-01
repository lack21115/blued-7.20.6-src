package com.soft.blued.ui.find.fragment;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.anythink.banner.api.ATBannerView;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.interstitial.api.ATInterstitialAutoAd;
import com.anythink.interstitial.api.ATInterstitialAutoEventListener;
import com.anythink.interstitial.api.ATInterstitialAutoLoadListener;
import com.blued.ad.ADConstants;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.UserTagAll;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.RefreshUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.utils.gaode.GaoDeUtils;
import com.blued.android.module.common.utils.gaode.OnLocationListener;
import com.blued.android.module.common.view.CustomTwoLevelHeader;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.android.module.live.base.utils.LiveSettingConfig;
import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import com.blued.android.statistics.BluedStatistics;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.OperatePromotionPopup;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.square.model.NearbyTransformersExtra;
import com.blued.community.utils.CommEventBusUtil;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.utils.CommunityPreferences;
import com.blued.das.authority.SystemAuthorityProtos;
import com.blued.das.guy.GuyProtos;
import com.blued.das.live.LiveProtos;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.das.vip.VipProtos;
import com.blued.login.auto.LoginServiceManager;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.nativead.NativeAd;
import com.igexin.push.config.c;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.customview.smartrefresh.TwoLevelNearbyRefreshView;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.HttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.bytedance.GuyEventUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.log.track.EventTrackSystemAuthority;
import com.soft.blued.ui.ab_test.models.ShortEntranceExtra;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.adapter.RedPackGuideListAdapter;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.manager.FilterHelper;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.manager.NearbyTopBannerManager;
import com.soft.blued.ui.find.manager.SpannedGridLayoutManager;
import com.soft.blued.ui.find.model.CallHelloModel;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.FindDataExtra;
import com.soft.blued.ui.find.model.FindRecommendExtra;
import com.soft.blued.ui.find.model.NearbyChatRoomModel;
import com.soft.blued.ui.find.model.NearbyModelInsertData;
import com.soft.blued.ui.find.model.OperateUserADExtra;
import com.soft.blued.ui.find.model.UserFindExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.model.UsersNewCallBubbleModel;
import com.soft.blued.ui.find.observer.AdFloatObserver;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.find.presenter.NearbyPeoplePresenter;
import com.soft.blued.ui.find.view.NearbyChatHostRoomView;
import com.soft.blued.ui.find.view.NearbyChatRoomView;
import com.soft.blued.ui.find.view.NearbyGridLayoutManager;
import com.soft.blued.ui.find.view.RecommendViewMixedInNearby;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.fragment.LiveTwoLevelFragment;
import com.soft.blued.ui.login_register.SetTagFragment;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.login_register.model.NearbyPeopleTabModel;
import com.soft.blued.ui.search.SearchGlobalFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.welcome.BluedInterstitialFragment;
import com.soft.blued.ui.welcome.model.NearbyTwoFloorModel;
import com.soft.blued.ui.welcome.model.TwoFloorModel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.AdTestManager;
import com.soft.blued.utils.AdTestObserve;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.third.TTADUtils;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment.class */
public class NearbyPeopleFragment extends MvpFragment<NearbyPeoplePresenter> implements View.OnClickListener, HomeTabClick.TabClickListener, AdTestObserve {
    private TipHeaderHolder D;
    private Unbinder G;
    private RedPackGuideListAdapter H;
    private int I;
    private Timer J;
    private int T;
    private BluedADExtra U;

    /* renamed from: a  reason: collision with root package name */
    public View f16763a;
    @BindView
    public AppBarLayout appbar;
    public BannerADView b;
    @BindView
    ConstraintLayout clCashOutGuide;
    @BindView
    ConstraintLayout clRedPackGuide;
    @BindView
    CoordinatorLayout coordinator;
    public OnLocationListener d;
    @BindView
    public FrameLayout flBanner;
    @BindView
    public CustomTwoLevelHeader header;
    @BindView
    ImageView ivRedPackGuideAnimation;
    @BindView
    ImageView ivRedPackGuideClose;
    @BindView
    public ImageView iv_close;
    @BindView
    public ImageView iv_icon;
    private Context k;
    private boolean l;
    @BindView
    public LinearLayout layoutFilterReset;
    @BindView
    LinearLayout llGuideAnimation;
    @BindView
    public LinearLayout llRefresh;
    @BindView
    public NoDataAndLoadFailView locationNoDataView;
    private PeopleGridQuickAdapter m;
    @BindView
    public RelativeLayout mCallBtn;
    @BindView
    public RelativeLayout mCallBtnState;
    @BindView
    public RecommendViewMixedInNearby mRecommendViewMixedInNearby;
    @BindView
    public RecyclerView mRecyclerView;
    @BindView
    public SmartRefreshLayout mRefreshLayout;
    private PeopleListQuickAdapter n;
    @BindView
    public NearbyChatHostRoomView nearbyChatRoomHostView;
    @BindView
    public NearbyChatRoomView nearbyChatRoomView;
    @BindView
    public NoDataAndLoadFailView noDataAndLoadFailView;
    private List<UserFindResult> o;
    private List<UserFindResult> p;
    private List<List<String>> q;
    @BindView
    RecyclerView redPackRecyclerView;
    @BindView
    public TwoLevelNearbyRefreshView refresh_view;
    @BindView
    public RelativeLayout rl_location_root;
    @BindView
    ShapeLinearLayout search_layout;
    @BindView
    public LinearLayout sortTabBar;
    @BindView
    public ShapeTextView stvFilterReset;
    @BindView
    public LinearLayout tabBar;
    @BindView
    TextView tvCardGuide;
    @BindView
    ShapeTextView tvCashOutBtn;
    @BindView
    TextView tvRedPackGuideSubtitle;
    @BindView
    TextView tvRedPackGuideTitle;
    @BindView
    public TextView tv_distance;
    @BindView
    public TextView tv_location;
    private TwoFloorModel v;
    private boolean z;
    private List<PopMenu> r = new ArrayList();
    private int s = 0;
    private boolean t = false;
    private boolean u = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 0;
    private boolean A = false;
    private List<TabHolder> B = new ArrayList();
    private List<MenuHolder> C = new ArrayList();
    private List<Unbinder> E = new ArrayList();
    private List<Unbinder> F = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f16764c = true;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    long e = 86400;
    public int f = 0;
    public int g = 0;
    private AppBarLayout.OnOffsetChangedListener N = new AppBarLayout.OnOffsetChangedListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.22
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (i < (-RefreshUtils.a)) {
                if (NearbyPeopleFragment.this.f16764c) {
                    NearbyPeopleFragment.this.f16764c = false;
                    NearbyPeopleFragment.this.nearbyChatRoomView.d();
                    if (NearbyPeopleFragment.this.nearbyChatRoomHostView != null) {
                        NearbyPeopleFragment.this.nearbyChatRoomHostView.c();
                    }
                }
            } else if (!NearbyPeopleFragment.this.f16764c) {
                NearbyPeopleFragment.this.f16764c = true;
                NearbyPeopleFragment.this.nearbyChatRoomView.c();
                if (NearbyPeopleFragment.this.nearbyChatRoomHostView != null) {
                    NearbyPeopleFragment.this.nearbyChatRoomHostView.b();
                }
            }
            Logger.c("onOffsetChanged", new Object[]{"i: " + i});
            NearbyPeopleFragment.this.y = -i;
            if (NearbyPeopleFragment.this.y >= (NearbyPeopleFragment.this.appbar.getHeight() - NearbyPeopleFragment.this.tabBar.getHeight()) - NearbyPeopleFragment.this.llRefresh.getHeight()) {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_NEARBY_TITLE_SYC_B).post(true);
            } else {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_NEARBY_TITLE_SYC_B).post(false);
            }
        }
    };
    private RecyclerView.OnScrollListener O = new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.23
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int childLayoutPosition;
            super.onScrollStateChanged(recyclerView, i);
            if (NearbyPeopleFragment.this.l) {
                if (i != 0) {
                    if (i != 1 || NearbyPeopleFragment.this.m == null) {
                        return;
                    }
                    NearbyPeopleFragment.this.m.c(true);
                    return;
                }
                NearbyPeopleFragment.this.e();
                if (NearbyPeopleFragment.this.m != null) {
                    NearbyPeopleFragment.this.m.c(false);
                    NearbyPeopleFragment.this.m.h();
                }
                if (NearbyPeopleFragment.this.mRecommendViewMixedInNearby != null) {
                    NearbyPeopleFragment.this.mRecommendViewMixedInNearby.a(NearbyPeopleFragment.this.y);
                }
                if (NearbyPeopleFragment.this.mRecyclerView != null && (childLayoutPosition = NearbyPeopleFragment.this.mRecyclerView.getChildLayoutPosition(NearbyPeopleFragment.this.mRecyclerView.getChildAt(NearbyPeopleFragment.this.mRecyclerView.getChildCount() - 1))) > NearbyPeopleFragment.this.I) {
                    NearbyPeopleFragment.this.I = childLayoutPosition;
                    BluedPreferences.a(childLayoutPosition);
                    BluedPreferences.g(UserFindResult.USER_SORT_BY.NEARBY.equals(((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j) ? "DISTANCE_SORT" : UserFindResult.USER_SORT_BY.ONLINE.equals(((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j) ? "ONLINE_TIME_SORT" : "");
                    BluedPreferences.h(((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).q().if_grid ? "PALACE_SHOW" : "LIST_SHOW");
                }
                if (CommunityManager.a.a().g().size() > 0) {
                    CommEventBusUtil.f6855a.a();
                }
                RecyclerView.LayoutManager layoutManager = NearbyPeopleFragment.this.mRecyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    NearbyPeopleFragment.this.U();
                } else if (layoutManager instanceof SpannedGridLayoutManager) {
                    NearbyPeopleFragment.this.V();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
        }
    };
    private int P = 0;
    private boolean Q = false;
    private boolean R = true;
    private boolean S = false;
    private boolean V = false;

    /* renamed from: com.soft.blued.ui.find.fragment.NearbyPeopleFragment$44  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment$44.class */
    class AnonymousClass44 implements TTADUtils.TTOriginAdListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FindDataExtra._adms_user f16812a;
        final /* synthetic */ int b;

        AnonymousClass44(FindDataExtra._adms_user _adms_userVar, int i) {
            this.f16812a = _adms_userVar;
            this.b = i;
        }

        @Override // com.soft.blued.utils.third.TTADUtils.TTOriginAdListener
        public void a() {
        }

        @Override // com.soft.blued.utils.third.TTADUtils.TTOriginAdListener
        public void a(int i, String str) {
            EventTrackLoginAndRegister.c(LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE_FAIL, this.f16812a.ads_id + "", this.f16812a.adms_type, NearbyPeopleFragment.this.ae(), i + str);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x00e5 -> B:4:0x00af). Please submit an issue!!! */
        @Override // com.soft.blued.utils.third.TTADUtils.TTOriginAdListener
        public void a(TTFeedAd tTFeedAd) {
            UserFindResult userFindResult = new UserFindResult();
            userFindResult.itemType = 14;
            userFindResult.avatar = tTFeedAd.getImageList().get(0).getImageUrl();
            userFindResult.name = tTFeedAd.getTitle();
            userFindResult.description = tTFeedAd.getDescription();
            userFindResult.can_close = 1;
            userFindResult.ttNativeAdData = tTFeedAd;
            userFindResult.show_url = this.f16812a.show_url;
            userFindResult.click_url = this.f16812a.click_url;
            userFindResult.hidden_url = this.f16812a.hidden_url;
            userFindResult.adms_type = this.f16812a.adms_type;
            userFindResult.uid = this.f16812a.adms_type + this.f16812a.ads_id;
            try {
                NearbyPeopleFragment.this.n.addData(this.b, userFindResult);
                NearbyPeopleFragment.this.n.notifyDataSetChanged();
            } catch (Exception e) {
            }
            LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE;
            EventTrackLoginAndRegister.b(event, this.f16812a.ads_id + "", this.f16812a.adms_type, NearbyPeopleFragment.this.ae());
        }
    }

    /* renamed from: com.soft.blued.ui.find.fragment.NearbyPeopleFragment$45  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment$45.class */
    class AnonymousClass45 implements KsLoadManager.NativeAdListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FindDataExtra._adms_user f16814a;
        final /* synthetic */ int b;

        AnonymousClass45(FindDataExtra._adms_user _adms_userVar, int i) {
            this.f16814a = _adms_userVar;
            this.b = i;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
            Log.v("drb", "快手原生失败:" + i + " -- " + str);
            LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE_FAIL;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f16814a.ads_id);
            sb.append("");
            String sb2 = sb.toString();
            String str2 = this.f16814a.adms_type;
            String ae = NearbyPeopleFragment.this.ae();
            EventTrackLoginAndRegister.c(event, sb2, str2, ae, i + str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(List<KsNativeAd> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE;
            EventTrackLoginAndRegister.b(event, this.f16814a.ads_id + "", this.f16814a.adms_type, NearbyPeopleFragment.this.ae());
            KsNativeAd ksNativeAd = list.get(0);
            UserFindResult userFindResult = new UserFindResult();
            userFindResult.itemType = 18;
            userFindResult.avatar = ksNativeAd.getAppIconUrl();
            if (ksNativeAd.getInteractionType() == 1) {
                userFindResult.name = ksNativeAd.getAppName();
            } else {
                userFindResult.name = ksNativeAd.getProductName();
            }
            userFindResult.description = ksNativeAd.getAdDescription();
            userFindResult.can_close = 1;
            userFindResult.ksNativeAd = ksNativeAd;
            userFindResult.show_url = this.f16814a.show_url;
            userFindResult.click_url = this.f16814a.click_url;
            userFindResult.hidden_url = this.f16814a.hidden_url;
            userFindResult.adms_type = this.f16814a.adms_type;
            userFindResult.uid = this.f16814a.adms_type + this.f16814a.ads_id;
            try {
                NearbyPeopleFragment.this.n.addData(this.b, userFindResult);
                NearbyPeopleFragment.this.n.notifyDataSetChanged();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.soft.blued.ui.find.fragment.NearbyPeopleFragment$46  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment$46.class */
    class AnonymousClass46 extends AdListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FindDataExtra._adms_user f16816a;

        AnonymousClass46(FindDataExtra._adms_user _adms_userVar) {
            this.f16816a = _adms_userVar;
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdClicked() {
            Log.v("drb", "华为原生点击");
            FindHttpUtils.b(this.f16816a.click_url);
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdFailed(int i) {
            Log.v("drb", "华为原生失败 errorCode:" + i);
            EventTrackLoginAndRegister.c(LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE_FAIL, this.f16816a.ads_id + "", this.f16816a.adms_type, NearbyPeopleFragment.this.ae(), i + "");
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdImpression() {
            if (this.f16816a.ttShowSet.contains(Long.valueOf(this.f16816a.ads_id))) {
                return;
            }
            this.f16816a.ttShowSet.add(Long.valueOf(this.f16816a.ads_id));
            FindHttpUtils.b(this.f16816a.show_url);
            Log.v("drb", "华为原生 曝光");
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdLoaded() {
            Log.v("drb", "华为原生 onAdLoaded ");
        }
    }

    /* renamed from: com.soft.blued.ui.find.fragment.NearbyPeopleFragment$47  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment$47.class */
    class AnonymousClass47 implements NativeAd.NativeAdLoadedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FindDataExtra._adms_user f16817a;
        final /* synthetic */ int b;

        AnonymousClass47(FindDataExtra._adms_user _adms_userVar, int i) {
            this.f16817a = _adms_userVar;
            this.b = i;
        }

        @Override // com.huawei.hms.ads.nativead.NativeAd.NativeAdLoadedListener
        public void onNativeAdLoaded(NativeAd nativeAd) {
            Log.v("drb", "华为原生成功");
            LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE;
            EventTrackLoginAndRegister.b(event, this.f16817a.ads_id + "", this.f16817a.adms_type, NearbyPeopleFragment.this.ae());
            UserFindResult userFindResult = new UserFindResult();
            userFindResult.itemType = 27;
            userFindResult.hwNativeAd = nativeAd;
            userFindResult.show_url = this.f16817a.show_url;
            userFindResult.click_url = this.f16817a.click_url;
            userFindResult.hidden_url = this.f16817a.hidden_url;
            userFindResult.is_show_adm_icon = this.f16817a.is_show_adm_icon;
            userFindResult.can_close = this.f16817a.can_close;
            userFindResult.adms_type = this.f16817a.adms_type;
            userFindResult.third_id = this.f16817a.third_id;
            userFindResult.uid = this.f16817a.adms_type + this.f16817a.ads_id;
            try {
                NearbyPeopleFragment.this.n.addData(this.b, userFindResult);
                NearbyPeopleFragment.this.n.notifyDataSetChanged();
            } catch (Exception e) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment$MenuHolder.class */
    public class MenuHolder {
        @BindView
        ImageView ivSortMenu;
        @BindView
        TextView tvSortMenu;

        public MenuHolder() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment$MenuHolder_ViewBinding.class */
    public class MenuHolder_ViewBinding implements Unbinder {
        private MenuHolder b;

        public MenuHolder_ViewBinding(MenuHolder menuHolder, View view) {
            this.b = menuHolder;
            menuHolder.tvSortMenu = (TextView) Utils.a(view, R.id.tv_sort, "field 'tvSortMenu'", TextView.class);
            menuHolder.ivSortMenu = (ImageView) Utils.a(view, R.id.iv_sort, "field 'ivSortMenu'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            MenuHolder menuHolder = this.b;
            if (menuHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            menuHolder.tvSortMenu = null;
            menuHolder.ivSortMenu = null;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment$TabHolder.class */
    public class TabHolder {
        @BindView
        ImageView ivSortTab;
        @BindView
        ShapeLinearLayout layoutSortTab;
        @BindView
        ShapeTextView tvSortTab;

        public TabHolder() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment$TabHolder_ViewBinding.class */
    public class TabHolder_ViewBinding implements Unbinder {
        private TabHolder b;

        public TabHolder_ViewBinding(TabHolder tabHolder, View view) {
            this.b = tabHolder;
            tabHolder.layoutSortTab = (ShapeLinearLayout) Utils.a(view, R.id.layout_sort, "field 'layoutSortTab'", ShapeLinearLayout.class);
            tabHolder.tvSortTab = (ShapeTextView) Utils.a(view, R.id.tv_sort, "field 'tvSortTab'", ShapeTextView.class);
            tabHolder.ivSortTab = (ImageView) Utils.a(view, R.id.iv_sort, "field 'ivSortTab'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            TabHolder tabHolder = this.b;
            if (tabHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            tabHolder.layoutSortTab = null;
            tabHolder.tvSortTab = null;
            tabHolder.ivSortTab = null;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment$TipHeaderHolder.class */
    public class TipHeaderHolder {
        @BindView
        ImageView imgHeader;

        public TipHeaderHolder() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment$TipHeaderHolder_ViewBinding.class */
    public class TipHeaderHolder_ViewBinding implements Unbinder {
        private TipHeaderHolder b;

        public TipHeaderHolder_ViewBinding(TipHeaderHolder tipHeaderHolder, View view) {
            this.b = tipHeaderHolder;
            tipHeaderHolder.imgHeader = (ImageView) Utils.a(view, 2131364232, "field 'imgHeader'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            TipHeaderHolder tipHeaderHolder = this.b;
            if (tipHeaderHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            tipHeaderHolder.imgHeader = null;
        }
    }

    private void G() {
        long fj = BluedPreferences.fj();
        long currentTimeMillis = System.currentTimeMillis();
        if (fj <= 0 || currentTimeMillis - fj <= 1800000) {
            return;
        }
        this.mRefreshLayout.i();
        BluedPreferences.D(0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void H() {
        LiveEventBus.get("APP_CHANGE_TO_BACKGROUND", Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    NearbyPeopleFragment.this.L = false;
                }
            }
        });
        LiveEventBus.get("APP_CHANGE_TO_BACKGROUND", Boolean.class).observe(this, new Observer() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyPeopleFragment$RsNyC0r9LyLVLVtD-6Yhqn_gOck
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearbyPeopleFragment.this.c((Boolean) obj);
            }
        });
        LiveEventBus.get("Nearby_Transformers_Extra", NearbyTransformersExtra.class).observe(this, new Observer() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyPeopleFragment$nmBMRhK8hr7Gj0hc0DhkTA8H5zc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearbyPeopleFragment.this.a((NearbyTransformersExtra) obj);
            }
        });
    }

    private void I() {
        if (this.b == null) {
            BannerADView bannerADView = new BannerADView(this.k);
            this.b = bannerADView;
            bannerADView.setRadius(6.0f);
        }
        this.flBanner.addView(this.b);
    }

    private void J() {
        this.stvFilterReset.setOnClickListener(this);
        this.search_layout.setOnClickListener(this);
        this.mRecommendViewMixedInNearby.a((IRequestHost) getFragmentActive());
        this.mRecommendViewMixedInNearby.a(this.mCallBtn, this.mCallBtnState);
        if (MapFindManager.a().b()) {
            X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        RecyclerView recyclerView = this.mRecyclerView;
        int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1)) - 2;
        int z = BluedPreferences.z();
        if (childLayoutPosition < 0 || z < 0) {
            return;
        }
        GuyEventUtils.a(BluedPreferences.A(), BluedPreferences.B(), Math.max(childLayoutPosition, z));
        BluedPreferences.a(0);
    }

    private boolean L() {
        boolean z = false;
        for (PopMenu popMenu : this.r) {
            if (popMenu.a()) {
                popMenu.d();
                z = true;
            }
        }
        return z;
    }

    private void M() {
        FilterHelper.d().e();
    }

    private void N() {
        if (this.q == null) {
            this.q = BluedConfig.a().b(this.k);
        }
        this.r.clear();
        this.B.clear();
        this.E.clear();
        this.C.clear();
        this.F.clear();
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= this.q.size()) {
                return;
            }
            List<String> list = this.q.get(i2);
            if (list != null && list.size() > 0) {
                View inflate = LayoutInflater.from(this.k).inflate(R.layout.layout_nearby_people_tab, (ViewGroup) null);
                final TabHolder tabHolder = new TabHolder();
                Unbinder a2 = ButterKnife.a(tabHolder, inflate);
                tabHolder.layoutSortTab.setTag(true);
                this.sortTabBar.addView(inflate);
                this.B.add(tabHolder);
                this.E.add(a2);
                tabHolder.tvSortTab.setTag(list.get(0));
                tabHolder.tvSortTab.setText(f(list.get(0)));
                inflate.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (NearbyPeopleFragment.this.s == i2) {
                            ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j = tabHolder.tvSortTab.getTag().toString();
                            NearbyPeopleFragment nearbyPeopleFragment = NearbyPeopleFragment.this;
                            nearbyPeopleFragment.a(((NearbyPeoplePresenter) nearbyPeopleFragment.j()).j, 0);
                            return;
                        }
                        NearbyPeopleFragment.this.m.c(((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j);
                        NearbyPeopleFragment.this.n.c(((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j);
                        NearbyPeopleFragment.this.s = i2;
                        ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j = tabHolder.tvSortTab.getTag().toString();
                        NearbyPeopleFragment nearbyPeopleFragment2 = NearbyPeopleFragment.this;
                        nearbyPeopleFragment2.a(((NearbyPeoplePresenter) nearbyPeopleFragment2.j()).j, 220);
                        if (NearbyPeopleFragment.this.M) {
                            NearbyPeopleFragment.this.L = false;
                            NearbyPeopleFragment.this.P();
                        }
                        NearbyPeopleFragment.this.M = false;
                    }
                }));
                if (TextUtils.isEmpty(((NearbyPeoplePresenter) j()).j)) {
                    ((NearbyPeoplePresenter) j()).j = list.get(0);
                }
                if (((NearbyPeoplePresenter) j()).j.equals(list.get(0))) {
                    this.s = i2;
                }
                if (list.size() > 1) {
                    tabHolder.ivSortTab.setVisibility(0);
                    tabHolder.ivSortTab.setImageDrawable(BluedSkinUtils.b(this.k, (int) R.drawable.icon_nearby_arrow1));
                    LinearLayout linearLayout = new LinearLayout(this.k);
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    linearLayout.setOrientation(1);
                    final PopMenu popMenu = new PopMenu(this.k, linearLayout);
                    this.r.add(popMenu);
                    popMenu.a(new PopMenu.onShowListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.4
                        @Override // com.soft.blued.customview.PopMenu.onShowListener
                        public void a() {
                            NearbyPeopleFragment.this.w();
                            tabHolder.ivSortTab.setImageDrawable(BluedSkinUtils.b(NearbyPeopleFragment.this.k, (int) R.drawable.icon_nearby_arrow3));
                        }
                    });
                    popMenu.a(new PopupWindow.OnDismissListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.5
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            NearbyPeopleFragment.this.w();
                            tabHolder.ivSortTab.setImageDrawable(BluedSkinUtils.b(NearbyPeopleFragment.this.k, (int) R.drawable.icon_nearby_arrow2));
                        }
                    });
                    inflate.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            int i3 = NearbyPeopleFragment.this.s;
                            int i4 = i2;
                            if (i3 == i4) {
                                if (NearbyPeopleFragment.this.mRefreshLayout.getState() != RefreshState.None || NearbyPeopleFragment.this.t) {
                                    return;
                                }
                                popMenu.a(NearbyPeopleFragment.this.sortTabBar);
                                return;
                            }
                            NearbyPeopleFragment.this.s = i4;
                            ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j = tabHolder.tvSortTab.getTag().toString();
                            NearbyPeopleFragment nearbyPeopleFragment = NearbyPeopleFragment.this;
                            nearbyPeopleFragment.a(((NearbyPeoplePresenter) nearbyPeopleFragment.j()).j, 220);
                        }
                    }));
                    final ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= list.size()) {
                            break;
                        }
                        View inflate2 = LayoutInflater.from(this.k).inflate(R.layout.item_nearby_people_sort, (ViewGroup) null);
                        final MenuHolder menuHolder = new MenuHolder();
                        Unbinder a3 = ButterKnife.a(menuHolder, inflate2);
                        arrayList.add(menuHolder.ivSortMenu);
                        final String str = list.get(i4);
                        this.C.add(menuHolder);
                        this.F.add(a3);
                        if (TextUtils.isEmpty(((NearbyPeoplePresenter) j()).j)) {
                            ((NearbyPeoplePresenter) j()).j = str;
                        }
                        if (((NearbyPeoplePresenter) j()).j.equals(str)) {
                            this.s = i2;
                            menuHolder.ivSortMenu.setVisibility(0);
                            tabHolder.tvSortTab.setTag(list.get(i4));
                            tabHolder.tvSortTab.setText(f(list.get(i4)));
                            tabHolder.ivSortTab.setImageDrawable(BluedSkinUtils.b(this.k, (int) R.drawable.icon_nearby_arrow2));
                            z = true;
                        }
                        inflate2.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Tracker.onClick(view);
                                popMenu.d();
                                for (ImageView imageView : arrayList) {
                                    imageView.setVisibility(8);
                                }
                                menuHolder.ivSortMenu.setVisibility(0);
                                tabHolder.tvSortTab.setTag(str);
                                tabHolder.tvSortTab.setText(NearbyPeopleFragment.this.f(str));
                                ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j = str;
                                NearbyPeopleFragment nearbyPeopleFragment = NearbyPeopleFragment.this;
                                nearbyPeopleFragment.a(((NearbyPeoplePresenter) nearbyPeopleFragment.j()).j, 220);
                            }
                        }));
                        menuHolder.tvSortMenu.setText(f(list.get(i4)));
                        linearLayout.addView(inflate2);
                        i3 = i4 + 1;
                    }
                    if (!z) {
                        ((ImageView) arrayList.get(0)).setVisibility(0);
                    }
                } else {
                    tabHolder.ivSortTab.setVisibility(8);
                }
            }
            i = i2 + 1;
        }
    }

    private void O() {
        P();
        this.mRefreshLayout.l(false);
        PeopleListQuickAdapter peopleListQuickAdapter = new PeopleListQuickAdapter(new ArrayList(), getActivity(), getFragmentActive(), ((NearbyPeoplePresenter) j()).j, this.mRecyclerView);
        this.n = peopleListQuickAdapter;
        peopleListQuickAdapter.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.n.setNewData(this.p);
        this.n.b(1);
        this.n.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.8
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_IS_SHOW_TIP).post(true);
                ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).f();
            }
        }, this.mRecyclerView);
        this.n.a(new PeopleGridQuickAdapter.OnDrawPeopleListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.9
            @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter.OnDrawPeopleListener
            public void a() {
                if (NearbyPeopleFragment.this.mRecommendViewMixedInNearby != null) {
                    NearbyPeopleFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NearbyPeopleFragment.this.mRecommendViewMixedInNearby.c();
                            NearbyPeopleFragment.this.mRecommendViewMixedInNearby.a(false);
                        }
                    }, 500L);
                }
                if (UserFindResult.USER_SORT_BY.NEARBY.equals(((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j)) {
                    NearbyPeopleFragment.this.f++;
                } else {
                    NearbyPeopleFragment.this.g++;
                }
                LogUtils.c("nearbyDistanceDrawCount: " + NearbyPeopleFragment.this.f + ", nearbyTimeDrawCount:" + NearbyPeopleFragment.this.g);
                if (NearbyPeopleFragment.this.f == 48 || NearbyPeopleFragment.this.g == 48) {
                    long a2 = TimeAndDateUtils.a();
                    long ai = CommunityPreferences.ai();
                    boolean r = CommunityManager.a.a().r();
                    LogUtils.c("nearbyPeopleDraw48.today:" + a2 + ", lastDay:" + ai + ", isTopBubbleShowing:" + r);
                    if (a2 <= ai || r) {
                        return;
                    }
                    ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).v();
                }
            }
        });
        this.n.a(this.mRecyclerView);
        PeopleGridQuickAdapter peopleGridQuickAdapter = new PeopleGridQuickAdapter(new ArrayList(), getActivity(), getFragmentActive(), ((NearbyPeoplePresenter) j()).j, this.mRecyclerView);
        this.m = peopleGridQuickAdapter;
        peopleGridQuickAdapter.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.m.setNewData(this.o);
        this.m.b(1);
        this.m.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.10
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_IS_SHOW_TIP).post(true);
                ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).f();
            }
        }, this.mRecyclerView);
        this.m.a(new PeopleGridQuickAdapter.OnDrawPeopleListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.11
            @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter.OnDrawPeopleListener
            public void a() {
                if (NearbyPeopleFragment.this.mRecommendViewMixedInNearby != null) {
                    NearbyPeopleFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NearbyPeopleFragment.this.mRecommendViewMixedInNearby.c();
                            NearbyPeopleFragment.this.mRecommendViewMixedInNearby.a(false);
                        }
                    }, 500L);
                }
            }
        });
        this.m.a(this.mRecyclerView);
        this.m.a(true);
        this.noDataAndLoadFailView.setOnTouchEvent(false);
        this.noDataAndLoadFailView.setTopSpace(DensityUtils.a(this.k, 40.0f));
        this.noDataAndLoadFailView.setImageScale(0.7f);
        this.noDataAndLoadFailView.setNoDataStr((int) R.string.people_search_no_data_tip);
        this.noDataAndLoadFailView.setNoDataImg(2131233637);
        this.noDataAndLoadFailView.setNoDataBtnListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyPeopleFragment.this.Z();
            }
        });
        ShapeTextView btn = this.noDataAndLoadFailView.getBtn();
        btn.getLayoutParams().width = DensityUtils.a(this.k, 160.0f);
        btn.getLayoutParams().height = DensityUtils.a(this.k, 44.0f);
        btn.setText((int) R.string.people_search_no_data_btn);
        ShapeHelper.b(btn, 2131102212);
        ShapeHelper.c(btn, 2131102355);
        ShapeHelper.a(btn, DensityUtils.a(this.k, 18.0f));
        ShapeHelper.a(btn, 2131102163);
        this.header.a(new OnTwoLevelListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.13
            @Override // com.scwang.smartrefresh.layout.api.OnTwoLevelListener
            public boolean onTwoLevel(RefreshLayout refreshLayout) {
                return false;
            }
        });
        this.d = new OnLocationListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.14
            private void a() {
                ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).p();
                if (HomeActivity.f17295c != null) {
                    ((NearbyViewModel) ViewModelProviders.of((FragmentActivity) HomeActivity.f17295c).get(NearbyViewModel.class)).d.postValue(null);
                }
            }

            private void b() {
                if (((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).e("people")) {
                    NearbyPeopleFragment.this.mRefreshLayout.j();
                    return;
                }
                NearbyPeopleFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NearbyPeopleFragment.this.K();
                    }
                }, 1000L);
                ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).e();
                a();
            }

            public void a(double d, double d2) {
                CommunityManager.a.a().a((float) d2);
                CommunityManager.a.a().b((float) d);
                b();
                if (NearbyPeopleFragment.this.locationNoDataView != null) {
                    NearbyPeopleFragment.this.locationNoDataView.d();
                }
            }

            public void a(int i) {
                b();
                AppMethods.a(NearbyPeopleFragment.this.k.getResources().getString(R.string.location_fail_try_again) + "(" + i + ")");
                BluedStatistics.c().a("LOCATION", 0L, i, (String) null);
            }
        };
        this.mRefreshLayout.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.15
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void a(RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3) {
                super.a(refreshHeader, z, f, i, i2, i3);
                if (NearbyPeopleFragment.this.getParentFragment() instanceof NearbyHomeFragment) {
                    ((NearbyHomeFragment) NearbyPeopleFragment.this.getParentFragment()).a(f, i);
                }
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
            public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
                if (refreshState2 == RefreshState.None) {
                    NearbyPeopleFragment.this.aa();
                    if (NearbyPeopleFragment.this.v != null) {
                        if (NearbyPeopleFragment.this.v.is_op_ad == 1 && (NearbyPeopleFragment.this.v.show_type == 1 || NearbyPeopleFragment.this.v.show_type == 2)) {
                            if (NearbyPeopleFragment.this.v != null && NearbyPeopleFragment.this.v.anchor != null && !TextUtils.isEmpty(NearbyPeopleFragment.this.v.preload_image)) {
                                EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_IMAGE_SHOW, NearbyPeopleFragment.this.v.anchor.live_id, NearbyPeopleFragment.this.v.anchor.uid + "", NearbyPeopleFragment.this.v.id + "");
                            }
                            if (NearbyPeopleFragment.this.v != null) {
                                EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_WORD_SHOW, NearbyPeopleFragment.this.v.anchor.live_id, NearbyPeopleFragment.this.v.anchor.uid + "", NearbyPeopleFragment.this.v.id + "");
                            }
                            if (NearbyPeopleFragment.this.v != null && NearbyPeopleFragment.this.v.anchor != null) {
                                EventTrackGuy.a(GuyProtos.Event.REFRESH_SECOND_SHOW, "live", NearbyPeopleFragment.this.v.id + "", NearbyPeopleFragment.this.v.anchor.live_urls, NearbyPeopleFragment.this.v.anchor.live_id, NearbyPeopleFragment.this.v.anchor.uid + "");
                            }
                            Log.v("drb", "====二楼曝光====");
                            FindHttpUtils.b(NearbyPeopleFragment.this.v.show_url);
                        }
                        if (NearbyPeopleFragment.this.v.is_op_ad == 1 && NearbyPeopleFragment.this.v.show_type == 3) {
                            EventTrackGuy.a(GuyProtos.Event.REFRESH_SECOND_SHOW, "op", NearbyPeopleFragment.this.v.id + "", NearbyPeopleFragment.this.v.target_url, "", "");
                            FindHttpUtils.b(NearbyPeopleFragment.this.v.show_url);
                        }
                        if (NearbyPeopleFragment.this.v.is_op_ad != 2 || NearbyPeopleFragment.this.v == null) {
                            return;
                        }
                        EventTrackGuy.a(GuyProtos.Event.REFRESH_SECOND_SHOW, "ad", NearbyPeopleFragment.this.v.id + "", NearbyPeopleFragment.this.v.target_url, "", "");
                    }
                } else if (refreshState2 == RefreshState.ReleaseToTwoLevel || refreshState2 != RefreshState.TwoLevelReleased || NearbyPeopleFragment.this.v == null) {
                } else {
                    if (NearbyPeopleFragment.this.v.is_op_ad != 1) {
                        if (NearbyPeopleFragment.this.v.is_op_ad == 2) {
                            EventTrackGuy.a(GuyProtos.Event.REFRESH_SECOND_ENTER, "ad", NearbyPeopleFragment.this.v.id + "", NearbyPeopleFragment.this.v.target_url, "", "");
                            if ("0".equalsIgnoreCase(NearbyPeopleFragment.this.v.adm_type_source)) {
                                BluedInterstitialFragment.a(NearbyPeopleFragment.this.k, NearbyPeopleFragment.this.v);
                            } else if ("6".equalsIgnoreCase(NearbyPeopleFragment.this.v.adm_type_source)) {
                                if (ATInterstitialAutoAd.isAdReady(NearbyPeopleFragment.this.v.third_id)) {
                                    ATInterstitialAutoAd.show(NearbyPeopleFragment.this.getActivity(), NearbyPeopleFragment.this.v.third_id, new ATInterstitialAutoEventListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.15.1
                                        @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                                        public void onInterstitialAdClicked(ATAdInfo aTAdInfo) {
                                            Log.v("drb", "Topon插屏广告点击");
                                            FindHttpUtils.b(NearbyPeopleFragment.this.v.click_url);
                                        }

                                        @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                                        public void onInterstitialAdClose(ATAdInfo aTAdInfo) {
                                            Log.v("drb", "Topon插屏广告关闭");
                                            FindHttpUtils.b(NearbyPeopleFragment.this.v.hidden_url);
                                        }

                                        @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                                        public void onInterstitialAdShow(ATAdInfo aTAdInfo) {
                                            Log.v("drb", "Topon插屏广告曝光");
                                            FindHttpUtils.b(NearbyPeopleFragment.this.v.show_url);
                                            NearbyPeopleFragment.this.v();
                                        }

                                        @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                                        public void onInterstitialAdVideoEnd(ATAdInfo aTAdInfo) {
                                        }

                                        @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                                        public void onInterstitialAdVideoError(AdError adError) {
                                            NearbyPeopleFragment.this.v();
                                        }

                                        @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                                        public void onInterstitialAdVideoStart(ATAdInfo aTAdInfo) {
                                        }
                                    });
                                    return;
                                }
                                NearbyPeopleFragment.this.v();
                                Log.v("drb", "Topon插屏广告未下载完，请稍后重试");
                            }
                        }
                    } else if (NearbyPeopleFragment.this.v.show_type == 3 && !TextUtils.isEmpty(NearbyPeopleFragment.this.v.target_url) && NearbyPeopleFragment.this.v.anchor != null) {
                        FindHttpUtils.b(NearbyPeopleFragment.this.v.click_url);
                        EventTrackGuy.a(GuyProtos.Event.REFRESH_SECOND_ENTER, "op", NearbyPeopleFragment.this.v.id + "", NearbyPeopleFragment.this.v.target_url, "", "");
                        EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_LIVE_ENTER, NearbyPeopleFragment.this.v.anchor.live_id, NearbyPeopleFragment.this.v.anchor.uid + "", NearbyPeopleFragment.this.v.id + "");
                        WebViewShowInfoFragment.show(NearbyPeopleFragment.this.k, NearbyPeopleFragment.this.v.target_url, 14);
                    } else if ((NearbyPeopleFragment.this.v.show_type == 1 || NearbyPeopleFragment.this.v.show_type == 2) && NearbyPeopleFragment.this.v.anchor != null) {
                        FindHttpUtils.b(NearbyPeopleFragment.this.v.click_url);
                        EventTrackGuy.a(GuyProtos.Event.REFRESH_SECOND_ENTER, "live", NearbyPeopleFragment.this.v.id + "", NearbyPeopleFragment.this.v.anchor.live_urls, NearbyPeopleFragment.this.v.anchor.live_id, NearbyPeopleFragment.this.v.anchor.uid + "");
                        EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_LIVE_ENTER, NearbyPeopleFragment.this.v.anchor.live_id, NearbyPeopleFragment.this.v.anchor.uid + "", NearbyPeopleFragment.this.v.id + "");
                        LiveTwoFloorModel liveTwoFloorModel = new LiveTwoFloorModel();
                        liveTwoFloorModel.id = NearbyPeopleFragment.this.v.id + "";
                        liveTwoFloorModel.lid = NearbyPeopleFragment.this.v.anchor.live_id;
                        liveTwoFloorModel.live_play = NearbyPeopleFragment.this.v.anchor.live_urls;
                        liveTwoFloorModel.screen_pattern = NearbyPeopleFragment.this.v.anchor.live_screen_pattern;
                        UserBasicModel userBasicModel = new UserBasicModel();
                        userBasicModel.uid = NearbyPeopleFragment.this.v.anchor.uid + "";
                        userBasicModel.name = NearbyPeopleFragment.this.v.anchor.name;
                        userBasicModel.vbadge = NearbyPeopleFragment.this.v.anchor.vbadge;
                        userBasicModel.avatar = NearbyPeopleFragment.this.v.anchor.avatar;
                        liveTwoFloorModel.anchor = userBasicModel;
                        LiveTwoLevelFragment.a(NearbyPeopleFragment.this.k, "two_floor_nearby", liveTwoFloorModel);
                    }
                }
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                if (NearbyPeopleFragment.this.getParentFragment() instanceof NearbyHomeFragment) {
                    ((NearbyHomeFragment) NearbyPeopleFragment.this.getParentFragment()).x();
                }
                EventTrackGuy.b("friend");
                NearbyPeopleFragment.this.Q();
                if (UserFindResult.USER_SORT_BY.NEARBY.equals(((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j)) {
                    ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).t();
                }
                ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).o();
                ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).n();
                NearbyPeopleFragment.this.c(false);
                if (((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).r() && NearbyPeopleFragment.this.m != null) {
                    NearbyPeopleFragment.this.m.g();
                    NearbyPeopleFragment.this.V();
                    NearbyPeopleFragment.this.m.c(((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j);
                } else if (!((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).r() && NearbyPeopleFragment.this.n != null) {
                    NearbyPeopleFragment.this.n.g();
                    NearbyPeopleFragment.this.U();
                    NearbyPeopleFragment.this.n.c(((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j);
                }
                if (NearbyPeopleFragment.this.b != null) {
                    NearbyPeopleFragment.this.b.setVisibility(8);
                }
                NearbyPeopleFragment.this.P = 0;
            }
        });
        this.n.a(new PeopleListQuickAdapter.OnShowRegisterUserGuideDialogListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.16
            @Override // com.soft.blued.ui.find.adapter.PeopleListQuickAdapter.OnShowRegisterUserGuideDialogListener
            public void a() {
                NearbyPeopleFragment.this.T();
            }
        });
        this.m.a(new PeopleListQuickAdapter.OnShowRegisterUserGuideDialogListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.17
            @Override // com.soft.blued.ui.find.adapter.PeopleListQuickAdapter.OnShowRegisterUserGuideDialogListener
            public void a() {
                NearbyPeopleFragment.this.T();
            }
        });
        this.mRecyclerView.addOnScrollListener(this.O);
        this.appbar.addOnOffsetChangedListener(this.N);
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.18
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Log.v("onGlobalLayout", "isAdvResDlgShowed = " + NearbyPeopleFragment.this.L);
                if (NearbyPeopleFragment.this.L) {
                    return;
                }
                if (((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).s()) {
                    if (NearbyPeopleFragment.this.n == null || NearbyPeopleFragment.this.n.getItemCount() <= 0) {
                        return;
                    }
                } else if (NearbyPeopleFragment.this.m == null || NearbyPeopleFragment.this.m.getItemCount() <= 0) {
                    return;
                }
                List data = NearbyPeopleFragment.this.m.getData();
                if (((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).s()) {
                    data = NearbyPeopleFragment.this.n.getData();
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= data.size()) {
                        return;
                    }
                    UserFindResult userFindResult = (UserFindResult) data.get(i2);
                    if (userFindResult.operate_promotion != null && userFindResult.operate_promotion.popup != null) {
                        OperatePromotionPopup operatePromotionPopup = userFindResult.operate_promotion.popup;
                        RecyclerView.ViewHolder findViewHolderForAdapterPosition = NearbyPeopleFragment.this.mRecyclerView.findViewHolderForAdapterPosition(i2);
                        if (findViewHolderForAdapterPosition != null && ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j.equals(operatePromotionPopup.getSourcePage())) {
                            int[] iArr = new int[2];
                            findViewHolderForAdapterPosition.itemView.getLocationInWindow(iArr);
                            LogUtils.c("loc:" + iArr[0] + ", " + iArr[1]);
                            if (iArr[0] >= 0 && iArr[1] > 0) {
                                LogUtils.c("onGlobalLayout: " + ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).j + ",  popup.getSourcePage: " + operatePromotionPopup.getSourcePage());
                                NearbyPeopleFragment.this.L = true;
                                if (CommunityManager.a.a().f()) {
                                    LogUtils.c("NearbyPromotionPopup: 广告浮窗正在显示");
                                    return;
                                } else if (CommunityManager.a.a().j()) {
                                    LogUtils.c("NearbyPromotionPopup: 新功能介绍正在显示");
                                    return;
                                } else if (CommunityManager.a.a().k()) {
                                    LogUtils.c("NearbyPromotionPopup: 协议变更窗口正在显示");
                                    return;
                                } else if (CommunityManager.a.a().l()) {
                                    LogUtils.c("NearbyPromotionPopup: 版本更新窗口正在显示");
                                    return;
                                } else {
                                    int measuredWidth = findViewHolderForAdapterPosition.itemView.getMeasuredWidth() / 2;
                                    int measuredHeight = findViewHolderForAdapterPosition.itemView.getMeasuredHeight() / 3;
                                    CommRouteUtil.a(NearbyPeopleFragment.this, operatePromotionPopup, userFindResult.operate_promotion.deep_link_url, NearbyPeopleFragment.this.s, iArr[0] + measuredWidth, iArr[1], new Bundle(), FlexDebugSevConfig.a().b().gray_count, userFindResult.operate_promotion.ads_id, userFindResult.operate_promotion.department, userFindResult.operate_promotion.business_line);
                                }
                            }
                            NearbyPeopleFragment.this.mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            return;
                        }
                    }
                    i = i2 + 1;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (!d()) {
            GaoDeUtils.a(this.d);
            return;
        }
        EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.SYSTEM_AUTHORITY, SystemAuthorityProtos.Type.LOCATION, PermissionUtils.a(new String[]{"android.permission.ACCESS_FINE_LOCATION"}));
        PermissionUtils.c(new PermissionCallbacks() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.19
            public void U_() {
                GaoDeUtils.a(NearbyPeopleFragment.this.d);
            }

            public void a(String[] strArr) {
                GaoDeUtils.a(NearbyPeopleFragment.this.d);
                BluedStatistics.c().a("LOCATION", 0L, -1001, (String) null);
            }
        });
    }

    private void R() {
        if (BluedPreferences.bP()) {
            return;
        }
        Bundle bundle = new Bundle();
        TransparentActivity.a(bundle);
        TransparentActivity.b(AppInfo.d(), HomeGuideFragment.class, bundle);
        ActivityChangeAnimationUtils.a(getActivity());
    }

    private void S() {
        if (!UserInfo.getInstance().isBindPhone()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_bind_phone", true);
            bundle.putBoolean("from_register", true);
            bundle.putBoolean("is_from_home", true);
            LoginServiceManager.a().a(getActivity(), bundle);
        }
        if (getActivity().getIntent() != null) {
            Bundle bundleExtra = getActivity().getIntent().getBundleExtra("arg_subfragment_args");
            boolean z = false;
            if (bundleExtra != null) {
                z = bundleExtra.getBoolean("show_tag_page", false);
            }
            if (z && UserInfo.getInstance().isBindPhone() && !BluedPreferences.eU()) {
                FindHttpUtils.a((Context) getActivity(), (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.20
                    /* JADX INFO: Access modifiers changed from: protected */
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<UserTagAll> bluedEntityA) {
                        if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                            return;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable("login_data_tag", (Serializable) bluedEntityA.data.get(0));
                        TerminalActivity.d(NearbyPeopleFragment.this.getActivity(), SetTagFragment.class, bundle2);
                    }
                }, (IRequestHost) getFragmentActive());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        UserHttpUtils.g(new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.21
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
                String str;
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                try {
                    str = AesCrypto.e(((UserInfoEntity) bluedEntityA.getSingleData()).registration_time_encrypt);
                } catch (Exception e) {
                    e.printStackTrace();
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                float i = (float) (TimeAndDateUtils.i(System.currentTimeMillis()) - Long.parseLong(str));
                if ((BluedConfig.a().U() != 1 || i <= ((float) NearbyPeopleFragment.this.e) || i >= ((float) (NearbyPeopleFragment.this.e * 30)) || !isActive()) && !(BluedConfig.a().U() == 0 && i < ((float) (NearbyPeopleFragment.this.e * 30)) && isActive())) {
                    return;
                }
                new XPopup.Builder(NearbyPeopleFragment.this.k).a(PopupAnimation.a).c(false).d(true).a(new VIPGuidePopupWindow(NearbyPeopleFragment.this.k)).h();
            }
        }, UserInfo.getInstance().getLoginUserInfo().uid, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!(this.mRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        int i = this.P;
        if (i > 0) {
            findFirstVisibleItemPosition = i;
        } else {
            this.P = findLastVisibleItemPosition;
        }
        List<T> data = this.n.getData();
        if (data == 0 || data.size() == 0 || data.size() <= findLastVisibleItemPosition || findFirstVisibleItemPosition < 0) {
            return;
        }
        int i2 = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition >= findLastVisibleItemPosition) {
            return;
        }
        while (true) {
            int i3 = findLastVisibleItemPosition + 1;
            if (i2 >= i3) {
                this.P = i3;
                return;
            }
            UserFindResult userFindResult = (UserFindResult) data.get(i2);
            if (userFindResult.itemType == 10 || userFindResult.itemType == 20 || userFindResult.itemType == 19 || userFindResult.itemType == 24 || userFindResult.itemType == 26 || userFindResult.itemType == 25) {
                this.n.b(i2, userFindResult);
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (!(this.mRecyclerView.getLayoutManager() instanceof SpannedGridLayoutManager)) {
            return;
        }
        SpannedGridLayoutManager spannedGridLayoutManager = (SpannedGridLayoutManager) this.mRecyclerView.getLayoutManager();
        int a2 = spannedGridLayoutManager.a();
        int c2 = spannedGridLayoutManager.c();
        int i = this.P;
        if (i > 0) {
            a2 = i;
        } else {
            this.P = c2;
        }
        List<T> data = this.m.getData();
        if (data == 0 || data.size() == 0 || data.size() <= c2 || a2 < 0) {
            return;
        }
        int i2 = a2;
        if (a2 >= c2) {
            return;
        }
        while (true) {
            int i3 = c2 + 1;
            if (i2 >= i3) {
                this.P = i3;
                return;
            }
            UserFindResult userFindResult = (UserFindResult) data.get(i2);
            if (userFindResult.itemType == 10 || userFindResult.itemType == 19 || userFindResult.itemType == 20 || userFindResult.itemType == 24 || userFindResult.itemType == 25 || userFindResult.itemType == 26) {
                this.m.b(i2, userFindResult);
            }
            i2++;
        }
    }

    private void W() {
        BluedConfig.a().b(new BluedConfig.UpdateBluedConfigListner() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.24
            @Override // com.soft.blued.user.BluedConfig.UpdateBluedConfigListner
            public void a() {
                NearbyPeopleFragment.this.a((Boolean) false);
                if (!BluedConfig.a().u()) {
                    NearbyPeopleFragment.this.f16763a = null;
                    return;
                }
                NearbyPeopleFragment nearbyPeopleFragment = NearbyPeopleFragment.this;
                nearbyPeopleFragment.f16763a = LayoutInflater.from(nearbyPeopleFragment.k).inflate(R.layout.layout_nearby_people_edit_tip, (ViewGroup) null);
                NearbyPeopleFragment nearbyPeopleFragment2 = NearbyPeopleFragment.this;
                nearbyPeopleFragment2.D = new TipHeaderHolder();
                NearbyPeopleFragment nearbyPeopleFragment3 = NearbyPeopleFragment.this;
                nearbyPeopleFragment3.G = ButterKnife.a(nearbyPeopleFragment3.D, NearbyPeopleFragment.this.f16763a);
                ImageLoader.a(NearbyPeopleFragment.this.getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().avatar).b(2131237310).c().a(NearbyPeopleFragment.this.D.imgHeader);
                NearbyPeopleFragment.this.f16763a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.24.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_NEW_CLICK);
                        if (PopMenuUtils.a(NearbyPeopleFragment.this.k)) {
                            return;
                        }
                        ModifyUserInfoFragment.a(NearbyPeopleFragment.this.k, 0, false);
                    }
                });
                if (NearbyPeopleFragment.this.n != null) {
                    NearbyPeopleFragment.this.n.addHeaderView(NearbyPeopleFragment.this.f16763a);
                    EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_NEW_SHOW);
                }
            }

            @Override // com.soft.blued.user.BluedConfig.UpdateBluedConfigListner
            public void b() {
            }
        });
        LiveSettingConfig.a().a(AppHttpUtils.b());
    }

    private void X() {
        this.rl_location_root.setVisibility(8);
        this.iv_close.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$NearbyPeopleFragment$STA4_qZKFi0-oyeYZRnZIXefFCI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NearbyPeopleFragment.this.a(view);
            }
        });
        this.rl_location_root.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PermissionUtils.c(new PermissionCallbacks() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.32.1
                    public void U_() {
                        FindSearchMapFragment.b(NearbyPeopleFragment.this.getActivity(), 2);
                    }

                    public void a(String[] strArr) {
                    }
                });
            }
        });
        if (this.rl_location_root == null || !MapFindManager.a().b()) {
            return;
        }
        this.rl_location_root.setVisibility(0);
        double d = MapFindManager.a().c().f16910c;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        this.rl_location_root.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101766));
        this.tv_distance.setText(decimalFormat.format(d) + " km");
        this.tv_location.setText(MapFindManager.a().c().d);
        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        final int a2 = BluedSkinUtils.a(getContext(), 2131101766);
        final int a3 = BluedSkinUtils.a(getContext(), 2131101796);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(c.j);
        ofFloat.setStartDelay(c.j);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.33
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NearbyPeopleFragment.this.rl_location_root != null) {
                    NearbyPeopleFragment.this.rl_location_root.setBackgroundColor(((Integer) argbEvaluator.evaluate(((Float) valueAnimator.getAnimatedValue()).floatValue(), Integer.valueOf(a2), Integer.valueOf(a3))).intValue());
                }
            }
        });
        ofFloat.start();
    }

    private void Y() {
        if (TextUtils.isEmpty(((NearbyPeoplePresenter) j()).j)) {
            ((NearbyPeoplePresenter) j()).j = BluedPreferences.aB();
        }
        if (TextUtils.isEmpty(((NearbyPeoplePresenter) j()).j) && BluedPreferences.bT()) {
            ((NearbyPeoplePresenter) j()).j = BluedConfig.a().b().default_home_tabs;
            BluedPreferences.bU();
        }
        if (!TextUtils.isEmpty(BluedConfig.a().b().default_home_tabs)) {
            ((NearbyPeoplePresenter) j()).j = BluedConfig.a().b().default_home_tabs;
        }
        if (h(((NearbyPeoplePresenter) j()).j)) {
            return;
        }
        ((NearbyPeoplePresenter) j()).j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z() {
        if (FilterDialogFragment.b) {
            return false;
        }
        new FilterDialogFragment().show(getChildFragmentManager(), "");
        return true;
    }

    private OperateUserADExtra a(List<OperateUserADExtra> list, List<OperateUserADExtra> list2, int i) {
        OperateUserADExtra operateUserADExtra = list2.get(i);
        Collections.sort(list, new Comparator<OperateUserADExtra>() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.48
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(OperateUserADExtra operateUserADExtra2, OperateUserADExtra operateUserADExtra3) {
                return operateUserADExtra2.position < operateUserADExtra3.position ? -1 : 1;
            }
        });
        int i2 = 0;
        while (i2 < list.size() && list.get(i2).position <= list2.get(i).position) {
            int i3 = i2 + 1;
            if (i3 < list.size() && list.get(i2).layout > 0 && list.get(i3).layout > 0 && list.get(i2).is_super_privilege_user != 1 && list.get(i3).is_super_privilege_user != 1 && list.get(i2).position == list.get(i3).position && list2.get(i).is_super_privilege_user == 1) {
                return null;
            }
            OperateUserADExtra operateUserADExtra2 = operateUserADExtra;
            if (list.get(i2).position > 0) {
                operateUserADExtra2 = operateUserADExtra;
                if (list.get(i2).position == list2.get(i).position) {
                    OperateUserADExtra operateUserADExtra3 = (list.get(i2).is_super_privilege_user == 1 || list2.get(i).is_super_privilege_user == 1 || list.get(i2).layout == 0 || list.get(i2).layout == list2.get(i).layout) ? null : list2.get(i);
                    OperateUserADExtra operateUserADExtra4 = operateUserADExtra3;
                    if (list.get(i2).layout == 2) {
                        operateUserADExtra4 = operateUserADExtra3;
                        if (list2.get(i).is_super_privilege_user == 1) {
                            list2.get(i).layout = 3;
                            operateUserADExtra4 = list2.get(i);
                        }
                    }
                    OperateUserADExtra operateUserADExtra5 = operateUserADExtra4;
                    if (list.get(i2).layout == 3) {
                        operateUserADExtra5 = operateUserADExtra4;
                        if (list2.get(i).is_super_privilege_user == 1) {
                            list2.get(i).layout = 2;
                            operateUserADExtra5 = list2.get(i);
                        }
                    }
                    operateUserADExtra2 = operateUserADExtra5;
                    if (list.get(i2).is_super_privilege_user == 1) {
                        operateUserADExtra2 = operateUserADExtra5;
                        if (list2.get(i).layout > 0) {
                            operateUserADExtra2 = operateUserADExtra5;
                            if (list2.get(i).is_super_privilege_user != 1) {
                                operateUserADExtra2 = null;
                            }
                        }
                    }
                }
            }
            i2 = i3;
            operateUserADExtra = operateUserADExtra2;
        }
        return operateUserADExtra;
    }

    private ArrayList<NearbyModelInsertData> a(FindDataExtra findDataExtra, ArrayList<NearbyModelInsertData> arrayList) {
        if (findDataExtra.adms_operating != null && findDataExtra.adms_operating.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= findDataExtra.adms_operating.size()) {
                    break;
                }
                UserFindExtra userFindExtra = findDataExtra.adms_operating.get(i2);
                userFindExtra.distanceStr = DistanceUtils.a(userFindExtra.distance, BlueAppLocal.c(), false);
                userFindExtra.last_operate_time_stamp = userFindExtra.last_operate;
                userFindExtra.last_operate_str = TimeAndDateUtils.a(this.k, TimeAndDateUtils.c(userFindExtra.last_operate));
                if (TextUtils.isEmpty(userFindExtra.last_operate_str)) {
                    userFindExtra.last_operate_str = AppInfo.d().getString(R.string.unknown);
                }
                if (userFindExtra.size == 1) {
                    userFindExtra.itemType = 19;
                } else if (userFindExtra.size == 3) {
                    userFindExtra.itemType = 22;
                } else {
                    userFindExtra.itemType = 10;
                }
                userFindExtra.position--;
                if (userFindExtra.chatroom != null) {
                    userFindExtra.is_insert_chatroom = 1;
                }
                NearbyModelInsertData nearbyModelInsertData = new NearbyModelInsertData();
                nearbyModelInsertData.adms_operating = userFindExtra;
                nearbyModelInsertData.position = userFindExtra.position;
                arrayList.add(nearbyModelInsertData);
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private void a(int i, boolean z) {
        if (this.mRecyclerView == null || this.mRefreshLayout == null) {
            return;
        }
        if (getParentFragment() instanceof NearbyHomeFragment) {
            ((NearbyHomeFragment) getParentFragment()).x();
        }
        this.mRecyclerView.scrollToPosition(0);
        RefreshUtils.a(this.appbar);
        this.refresh_view.setClickBottomTabToRefresh(z);
        this.mRefreshLayout.d(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        ac();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(NearbyTransformersExtra nearbyTransformersExtra) {
        NearbyTransformersExtra.PopupExtraJson popupExtraJson;
        if (nearbyTransformersExtra == null || (popupExtraJson = nearbyTransformersExtra.adv_extra_json) == null || popupExtraJson.popup == null) {
            return;
        }
        if (CommunityManager.a.a().f()) {
            LogUtils.c("NearbyPromotionPopup: 广告浮窗正在显示");
        } else if (CommunityManager.a.a().j()) {
            LogUtils.c("NearbyPromotionPopup: 新功能介绍正在显示");
        } else if (CommunityManager.a.a().k()) {
            LogUtils.c("NearbyPromotionPopup: 协议变更窗口正在显示");
        } else if (CommunityManager.a.a().l()) {
            LogUtils.c("NearbyPromotionPopup: 版本更新窗口正在显示");
        } else if (CommunityManager.a.a().m()) {
            LogUtils.c("NearbyPromotionPopup: ADV窗口正在显示");
        } else if (CommunityManager.a.a().n()) {
            LogUtils.c("NearbyPromotionPopup: ADV窗口显示过了");
        } else {
            int i = AppInfo.l / 2;
            int c2 = FeedMethods.c(30);
            int c3 = FeedMethods.c(50);
            Bundle bundle = new Bundle();
            bundle.putString("activity_img", popupExtraJson.pic);
            bundle.putString("activity_id", popupExtraJson.activity_id);
            bundle.putString("activity_text", popupExtraJson.popup.getExtra_bubble_text());
            CommRouteUtil.a(this, popupExtraJson.popup, "", 12, i + c2, c3, bundle, FlexDebugSevConfig.a().b().gray_count, nearbyTransformersExtra.ads_id, nearbyTransformersExtra.department, nearbyTransformersExtra.business_line);
        }
    }

    private void a(ShortEntranceExtra shortEntranceExtra, boolean z) {
        if (shortEntranceExtra.ads == null || shortEntranceExtra.ads.data == null || shortEntranceExtra.ads.data.size() <= 0) {
            this.b.setVisibility(8);
            return;
        }
        for (BluedADExtra bluedADExtra : shortEntranceExtra.ads.data) {
            if (z && bluedADExtra.show_url != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < bluedADExtra.show_url.length) {
                        String lowerCase = bluedADExtra.show_url[i2].toLowerCase();
                        if (lowerCase.startsWith(BluedHttpUrl.q())) {
                            Map a2 = BluedHttpTools.a();
                            a2.put("is_cache", "1");
                            bluedADExtra.show_url[i2] = HttpUtils.a(a2, lowerCase);
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        if (BluedPreferences.E() && AdTestManager.f21022a.a()) {
            AdTestManager.f21022a.b().a(this.b);
        }
        this.b.a((IRequestHost) getFragmentActive(), shortEntranceExtra.ads, new BannerADView.ADListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.51
            @Override // com.soft.blued.customview.BannerADView.ADListener
            public void a() {
                Log.v("drb", "广告关闭回调 onClose");
                NearbyPeopleFragment.this.b.setVisibility(8);
            }

            @Override // com.soft.blued.customview.BannerADView.ADListener
            public void b() {
                if (NearbyPeopleFragment.this.b != null) {
                    Log.v("drb", "没有广告回调 onNoAD");
                    NearbyPeopleFragment.this.b.setVisibility(8);
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void a(FindDataExtra._adms _admsVar, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void a(FindDataExtra._adms_user _adms_userVar, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void a(UserFindExtra userFindExtra) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.m.getData().size()) {
                break;
            }
            UserFindResult userFindResult = (UserFindResult) this.m.getData().get(i2);
            if ((userFindResult instanceof UserFindExtra) && ((UserFindExtra) userFindResult).position == userFindExtra.position) {
                userFindExtra.isInsert = true;
            }
            i = i2 + 1;
        }
        if (userFindExtra.position >= 0 && this.n.getData().size() > userFindExtra.position && (!userFindExtra.isInsert || ((NearbyPeoplePresenter) j()).n == 1)) {
            this.n.addData(userFindExtra.position, userFindExtra);
        }
        this.n.notifyDataSetChanged();
    }

    private void a(final AppConfigModel appConfigModel) {
        if (appConfigModel.sign_day_total >= 30 && appConfigModel.is_sign_today == 1) {
            this.redPackRecyclerView.setVisibility(8);
            this.tvCardGuide.setVisibility(8);
            this.clCashOutGuide.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.clRedPackGuide.getLayoutParams();
            layoutParams.height = DensityUtils.a(this.k, 72.0f);
            this.clRedPackGuide.setLayoutParams(layoutParams);
            this.tvCashOutBtn.getBackground().setAlpha(100);
            if (BluedPreferences.cK()) {
                this.tvCashOutBtn.setTextColor(Color.parseColor("#F7F7F7"));
            } else {
                this.tvCashOutBtn.setTextColor(Color.parseColor("#7D7D7D"));
            }
            this.tvCashOutBtn.setOnClickListener((View.OnClickListener) null);
            if (BluedPreferences.cK()) {
                String string = this.k.getString(R.string.already_obtained_money);
                this.tvRedPackGuideTitle.setText(Html.fromHtml(String.format(string, appConfigModel.sign_money_total + "")));
            } else {
                String string2 = this.k.getString(R.string.already_obtained_money_dark);
                this.tvRedPackGuideTitle.setText(Html.fromHtml(String.format(string2, appConfigModel.sign_money_total + "")));
            }
            this.tvRedPackGuideSubtitle.setText(this.k.getResources().getString(R.string.tomorrow_cash_out));
        } else if (appConfigModel.sign_day_total < 30 || appConfigModel.is_sign_today != 0) {
            this.redPackRecyclerView.setVisibility(0);
            this.tvCardGuide.setVisibility(0);
            this.clCashOutGuide.setVisibility(8);
            if (BluedSkinUtils.c()) {
                this.tvCardGuide.setText(Html.fromHtml(this.k.getString(R.string.sign_receive_money_guide)));
            } else {
                this.tvCardGuide.setText(Html.fromHtml(this.k.getString(R.string.sign_receive_money_guide_dark)));
            }
            this.H.a(appConfigModel.sign_day_total);
            this.H.a(appConfigModel.sign_url);
            if (!BluedPreferences.ev().booleanValue()) {
                this.H.setNewData(appConfigModel.sign_data);
            }
            this.H.notifyDataSetChanged();
            if (appConfigModel.sign_day_total >= 2) {
                postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        NearbyPeopleFragment.this.b(appConfigModel.sign_day_total - 1);
                    }
                }, 100L);
            }
        } else {
            this.redPackRecyclerView.setVisibility(8);
            this.tvCardGuide.setVisibility(8);
            this.clCashOutGuide.setVisibility(0);
            this.tvRedPackGuideTitle.setText(this.k.getResources().getString(R.string.done_sign_task));
            ViewGroup.LayoutParams layoutParams2 = this.clRedPackGuide.getLayoutParams();
            layoutParams2.height = DensityUtils.a(this.k, 72.0f);
            this.clRedPackGuide.setLayoutParams(layoutParams2);
            this.tvCashOutBtn.getBackground().setAlpha(100);
            this.tvCashOutBtn.setOnClickListener((View.OnClickListener) null);
            this.tvRedPackGuideSubtitle.setText(Html.fromHtml(String.format(this.k.getString(R.string.get_money), appConfigModel.sign_money_total)));
            this.tvCashOutBtn.setText(this.k.getString(R.string.cash_out_now_btn));
            this.tvCashOutBtn.getBackground().setAlpha(255);
            this.tvCashOutBtn.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.28
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(NearbyPeopleFragment.this.k, appConfigModel.withdraw_url, 9);
                }
            });
        }
        this.ivRedPackGuideClose.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyPeopleFragment.this.clRedPackGuide.setVisibility(8);
            }
        });
        if (this.R) {
            this.R = false;
            Timer timer = new Timer();
            this.J = timer;
            timer.schedule(new TimerTask() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.31
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    NearbyPeopleFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.31.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NearbyPeopleFragment.this.clRedPackGuide != null) {
                                NearbyPeopleFragment.this.clRedPackGuide.setVisibility(8);
                            }
                        }
                    });
                    NearbyPeopleFragment.this.Q = true;
                }
            }, appConfigModel.sign_show_duration, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (((NearbyPeoplePresenter) j()).e("people")) {
            return;
        }
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_SORT_CLICK, EventTrackGuy.c(((NearbyPeoplePresenter) j()).j), MapFindManager.a().b());
        this.P = 0;
        g(str);
        this.mRecyclerView.scrollToPosition(0);
        if (UserFindResult.USER_SORT_BY.NEARBY.equals(((NearbyPeoplePresenter) j()).j)) {
            ((NearbyPeoplePresenter) j()).t();
        }
        ((NearbyPeoplePresenter) j()).e();
        if (this.mRefreshLayout.getState() == RefreshState.None) {
            c(true);
        }
    }

    private void a(List<NearbyModelInsertData> list, boolean z) {
        Collections.sort(list, new Comparator<NearbyModelInsertData>() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.49
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(NearbyModelInsertData nearbyModelInsertData, NearbyModelInsertData nearbyModelInsertData2) {
                return nearbyModelInsertData.position < nearbyModelInsertData2.position ? -1 : 1;
            }
        });
        if (BluedPreferences.E() && AdTestManager.f21022a.b().h() != -1) {
            AdTestManager.f21022a.b().a((String) null);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            NearbyModelInsertData nearbyModelInsertData = list.get(i2);
            if (nearbyModelInsertData.adms_user != null) {
                a(nearbyModelInsertData.adms_user, z);
            } else if (nearbyModelInsertData.adms != null) {
                a(nearbyModelInsertData.adms, z);
            } else if (nearbyModelInsertData.adms_operating != null) {
                a(nearbyModelInsertData.adms_operating);
            } else if (nearbyModelInsertData.super_call != null) {
                a(nearbyModelInsertData.super_call);
            } else if (nearbyModelInsertData.nearby_dating != null) {
                a(nearbyModelInsertData.nearby_dating);
            }
            Log.v("xxxxx", "insertList    position = " + nearbyModelInsertData.position);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        String str;
        boolean z;
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout != null && smartRefreshLayout.getState() == RefreshState.None && (getParentFragment() instanceof NearbyHomeFragment)) {
            this.header.a(this.w);
            TwoFloorModel twoFloorModel = this.v;
            if (twoFloorModel != null) {
                str = twoFloorModel.preload_image;
                z = this.v.is_op_ad == 2 && this.v.is_show_adm_icon == 1 && this.v.is_show_adm_icon_outside == 1;
                Log.v("drb", "setTwoLevel twoLevelUrl:" + str + " -- isAd:" + z);
            } else {
                str = "";
                z = false;
            }
            if (TextUtils.isEmpty(str)) {
                this.refresh_view.a(this.w, false);
                this.header.setBackgroundColor(BluedSkinUtils.a(this.k, 2131101796));
            } else {
                this.refresh_view.a(this.w, true);
                this.header.setBackground((Drawable) null);
            }
            ((NearbyHomeFragment) getParentFragment()).a(this.w, str, z);
            TwoFloorModel twoFloorModel2 = this.v;
            if (twoFloorModel2 == null || twoFloorModel2.anchor == null || TextUtils.isEmpty(this.v.anchor.avatar)) {
                return;
            }
            ImageFileLoader.a(getFragmentActive()).a(this.v.anchor.avatar).a();
        }
    }

    private void ab() {
        a(0, false);
    }

    private void ac() {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
            ad();
            return;
        }
        EventTrackGuy.b(GuyProtos.Event.MAP_FIND_BUY_VIP_POP_SHOW);
        CommonAlertDialog.a(this.k, (int) R.drawable.map_buy_vip_tip, getString(R.string.map_use_want_end_now_tip), (String) null, getString(R.string.map_use_want_end_now_buy_vip), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.39
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                EventTrackGuy.b(GuyProtos.Event.MAP_FIND_BUY_VIP_POP_OPEN_CLICK);
                PayUtils.a(NearbyPeopleFragment.this.getActivity(), 21, "map_find_pop", VipProtos.FromType.MAP_FIND_BUY);
            }
        }, getString(R.string.map_use_want_end_now_close), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.40
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                EventTrackGuy.b(GuyProtos.Event.MAP_FIND_BUY_VIP_POP_CLOSE_CLICK);
                NearbyPeopleFragment.this.ad();
            }
        }, (DialogInterface.OnDismissListener) null, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad() {
        this.rl_location_root.setVisibility(8);
        MapFindManager.a().a(null);
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ae() {
        return (!TextUtils.equals(((NearbyPeoplePresenter) j()).j, UserFindResult.USER_SORT_BY.NEARBY) && TextUtils.equals(((NearbyPeoplePresenter) j()).j, UserFindResult.USER_SORT_BY.ONLINE)) ? "home_online" : "home_nearby";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006c, code lost:
        if (r0.itemType == 17) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00aa, code lost:
        if (r7 > r6) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b(com.soft.blued.ui.find.model.UserFindExtra r5) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.b(com.soft.blued.ui.find.model.UserFindExtra):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.soft.blued.ui.find.model.UserFindExtra] */
    private ArrayList<NearbyModelInsertData> b(FindDataExtra findDataExtra, ArrayList<NearbyModelInsertData> arrayList) {
        if (findDataExtra.nearby_dating != null && findDataExtra.nearby_dating.size() > 0) {
            List<OperateUserADExtra> list = findDataExtra.nearby_dating;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                list.get(i2).position = list.get(i2).show_layer;
                i = i2 + 1;
            }
            int i3 = 0;
            if (list.size() < 8) {
                i3 = 0;
                if (findDataExtra.super_call != null) {
                    i3 = 0;
                    if (findDataExtra.super_call.size() > 0) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            i3 = 0;
                            if (i5 >= findDataExtra.super_call.size()) {
                                break;
                            }
                            OperateUserADExtra operateUserADExtra = findDataExtra.super_call.get(i5);
                            operateUserADExtra.is_super_privilege_user = 1;
                            OperateUserADExtra a2 = a(list, findDataExtra.super_call, i5);
                            if (list.size() < 8 && a2 != null) {
                                operateUserADExtra.layout = a2.layout;
                                operateUserADExtra.distanceStr = DistanceUtils.a(operateUserADExtra.distance, BlueAppLocal.c(), false);
                                operateUserADExtra.last_operate_time_stamp = operateUserADExtra.last_operate;
                                operateUserADExtra.last_operate_str = TimeAndDateUtils.a(this.k, TimeAndDateUtils.c(operateUserADExtra.last_operate));
                                list.add(operateUserADExtra);
                            }
                            i4 = i5 + 1;
                        }
                    }
                }
            }
            while (i3 < list.size()) {
                OperateUserADExtra operateUserADExtra2 = list.get(i3);
                if (operateUserADExtra2 != null) {
                    OperateUserADExtra userFindExtra = new UserFindExtra();
                    if (operateUserADExtra2.is_super_privilege_user == 1) {
                        userFindExtra = operateUserADExtra2;
                    }
                    userFindExtra.operate_promotion = operateUserADExtra2;
                    userFindExtra.itemType = operateUserADExtra2.is_super_privilege_user == 1 ? 19 : 22;
                    userFindExtra.position = (operateUserADExtra2.is_super_privilege_user == 1 ? operateUserADExtra2.position : operateUserADExtra2.show_layer) - 1;
                    ((UserFindExtra) userFindExtra).show_url = operateUserADExtra2.show_url;
                    ((UserFindExtra) userFindExtra).click_url = operateUserADExtra2.click_url;
                    userFindExtra.size = operateUserADExtra2.is_super_privilege_user == 1 ? 1 : 3;
                    NearbyModelInsertData nearbyModelInsertData = new NearbyModelInsertData();
                    nearbyModelInsertData.nearby_dating = userFindExtra;
                    nearbyModelInsertData.position = userFindExtra.position;
                    arrayList.add(nearbyModelInsertData);
                }
                i3++;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        RecyclerView recyclerView = this.redPackRecyclerView;
        if (recyclerView == null) {
            return;
        }
        int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
        RecyclerView recyclerView2 = this.redPackRecyclerView;
        int childLayoutPosition2 = recyclerView2.getChildLayoutPosition(recyclerView2.getChildAt(recyclerView2.getChildCount() - 1));
        if (i < childLayoutPosition) {
            this.redPackRecyclerView.smoothScrollToPosition(i);
        } else if (i > childLayoutPosition2) {
            this.redPackRecyclerView.smoothScrollToPosition(i);
            this.T = i;
            this.S = true;
        } else {
            int i2 = i - childLayoutPosition;
            if (i2 < 0 || i2 >= this.redPackRecyclerView.getChildCount()) {
                return;
            }
            this.redPackRecyclerView.smoothScrollBy(this.redPackRecyclerView.getChildAt(i2).getLeft(), 0);
        }
    }

    private void b(FindDataExtra._adms _admsVar, boolean z) {
        int i;
        if (_admsVar.data == null || _admsVar.data.size() <= 0 || (i = _admsVar.line) <= 1) {
            return;
        }
        UserFindResult userFindResult = _admsVar.data.get(0);
        userFindResult.uid = userFindResult.adms_type + userFindResult.ads_id;
        List<T> data = this.m.getData();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < data.size(); i4++) {
            if (((UserFindResult) data.get(i4)).itemType == 10) {
                i2++;
            } else {
                i3++;
            }
        }
        int ceil = (int) Math.ceil(i2 / ((NearbyPeoplePresenter) j()).l);
        if (z && userFindResult.show_url != null && userFindResult.show_url.length > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= userFindResult.show_url.length) {
                    break;
                }
                String lowerCase = userFindResult.show_url[i6].toLowerCase();
                if (lowerCase.startsWith(BluedHttpUrl.q())) {
                    Map a2 = BluedHttpTools.a();
                    a2.put("is_cache", "1");
                    userFindResult.show_url[i6] = HttpUtils.a(a2, lowerCase);
                }
                i5 = i6 + 1;
            }
        }
        ATBannerView aTBannerView = new ATBannerView(this.k);
        aTBannerView.setPlacementId(userFindResult.third_id);
        int i7 = getResources().getDisplayMetrics().widthPixels;
        int round = Math.round(i7 / 4.0f);
        HashMap hashMap = new HashMap();
        hashMap.put("key_width", Integer.valueOf(i7));
        hashMap.put("key_height", Integer.valueOf(round));
        aTBannerView.setLocalExtra(hashMap);
        if (i <= ceil + i3) {
            int i8 = ((i - 1) * ((NearbyPeoplePresenter) j()).l) + this.m.m;
            int i9 = i8;
            if (this.m.m > 0) {
                i9 = i8 - (this.m.m * 3);
            }
            if (i9 < this.m.getData().size()) {
                userFindResult.itemType = 11;
                Log.v("drb", "banner2宫格 banner");
                this.m.addData(i9, userFindResult);
                this.m.m++;
                NearbyTopBannerManager.a().a(Long.valueOf(userFindResult.ads_id), aTBannerView);
                this.m.notifyDataSetChanged();
            }
        }
    }

    private void b(List<NearbyModelInsertData> list, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            NearbyModelInsertData nearbyModelInsertData = list.get(i2);
            if (nearbyModelInsertData.adms != null) {
                nearbyModelInsertData.position = ((nearbyModelInsertData.adms.line - 1) * ((NearbyPeoplePresenter) j()).l) + this.m.m;
            } else if (nearbyModelInsertData.adms_operating != null) {
                nearbyModelInsertData.position = b(nearbyModelInsertData.adms_operating);
            } else if (nearbyModelInsertData.super_call != null) {
                nearbyModelInsertData.position = b(nearbyModelInsertData.super_call);
            } else if (nearbyModelInsertData.nearby_dating != null) {
                nearbyModelInsertData.position = b(nearbyModelInsertData.nearby_dating);
            }
            i = i2 + 1;
        }
        Collections.sort(list, new Comparator<NearbyModelInsertData>() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.50
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(NearbyModelInsertData nearbyModelInsertData2, NearbyModelInsertData nearbyModelInsertData3) {
                return nearbyModelInsertData2.position < nearbyModelInsertData3.position ? -1 : 1;
            }
        });
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= list.size()) {
                return;
            }
            NearbyModelInsertData nearbyModelInsertData2 = list.get(i4);
            if (nearbyModelInsertData2.adms != null) {
                b(nearbyModelInsertData2.adms, z);
            } else if (nearbyModelInsertData2.adms_operating != null) {
                c(nearbyModelInsertData2.adms_operating);
            } else if (nearbyModelInsertData2.super_call != null) {
                c(nearbyModelInsertData2.super_call);
            } else if (nearbyModelInsertData2.nearby_dating != null) {
                c(nearbyModelInsertData2.nearby_dating);
            }
            Log.v("xxxxx", " insertGrid    position = " + nearbyModelInsertData2.position);
            i3 = i4 + 1;
        }
    }

    private void b(boolean z) {
        for (TabHolder tabHolder : this.B) {
            if (((tabHolder.layoutSortTab.getTag() instanceof Boolean) && ((Boolean) tabHolder.layoutSortTab.getTag()).booleanValue()) || z) {
                ShapeHelper.a(tabHolder.tvSortTab, 2131102263);
                tabHolder.tvSortTab.setTextSize(15.0f);
                tabHolder.ivSortTab.setImageDrawable(BluedSkinUtils.b(this.k, (int) R.drawable.icon_nearby_arrow1));
                tabHolder.layoutSortTab.setTag(false);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.soft.blued.ui.find.model.UserFindExtra] */
    private ArrayList<NearbyModelInsertData> c(FindDataExtra findDataExtra, ArrayList<NearbyModelInsertData> arrayList) {
        if (findDataExtra.super_call != null && findDataExtra.super_call.size() > 0) {
            List<OperateUserADExtra> list = findDataExtra.super_call;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                list.get(i2).is_super_privilege_user = 1;
                i = i2 + 1;
            }
            if (list.size() < 4 && findDataExtra.nearby_dating != null && findDataExtra.nearby_dating.size() > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= findDataExtra.nearby_dating.size()) {
                        break;
                    }
                    findDataExtra.nearby_dating.get(i4).position = findDataExtra.nearby_dating.get(i4).show_layer;
                    if (list.size() < 4 && a(list, findDataExtra.nearby_dating, i4) != null) {
                        list.add(findDataExtra.nearby_dating.get(i4));
                    }
                    i3 = i4 + 1;
                }
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= list.size()) {
                    break;
                }
                OperateUserADExtra operateUserADExtra = list.get(i6);
                if (operateUserADExtra != null) {
                    OperateUserADExtra userFindExtra = new UserFindExtra();
                    if (operateUserADExtra.is_super_privilege_user == 1) {
                        ((UserFindExtra) operateUserADExtra).distanceStr = DistanceUtils.a(((UserFindExtra) operateUserADExtra).distance, BlueAppLocal.c(), false);
                        ((UserFindExtra) operateUserADExtra).last_operate_time_stamp = ((UserFindExtra) operateUserADExtra).last_operate;
                        ((UserFindExtra) operateUserADExtra).last_operate_str = TimeAndDateUtils.a(this.k, TimeAndDateUtils.c(((UserFindExtra) operateUserADExtra).last_operate));
                        userFindExtra = operateUserADExtra;
                    }
                    userFindExtra.operate_promotion = operateUserADExtra;
                    userFindExtra.itemType = operateUserADExtra.is_super_privilege_user == 1 ? 19 : 22;
                    userFindExtra.position = (operateUserADExtra.is_super_privilege_user == 1 ? operateUserADExtra.position : operateUserADExtra.show_layer) - 1;
                    ((UserFindExtra) userFindExtra).show_url = operateUserADExtra.show_url;
                    ((UserFindExtra) userFindExtra).click_url = operateUserADExtra.click_url;
                    userFindExtra.size = operateUserADExtra.is_super_privilege_user == 1 ? 1 : 3;
                    NearbyModelInsertData nearbyModelInsertData = new NearbyModelInsertData();
                    nearbyModelInsertData.super_call = userFindExtra;
                    nearbyModelInsertData.position = userFindExtra.position;
                    arrayList.add(nearbyModelInsertData);
                }
                i5 = i6 + 1;
            }
        }
        return arrayList;
    }

    private void c(UserFindExtra userFindExtra) {
        userFindExtra.insertGridPosition = b(userFindExtra);
        if (userFindExtra.insertGridPosition >= 0 && this.m.getData().size() > userFindExtra.insertGridPosition && (!userFindExtra.isInsert || ((NearbyPeoplePresenter) j()).n == 1)) {
            this.m.addData(userFindExtra.insertGridPosition, userFindExtra);
        }
        this.m.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Boolean bool) {
        if (bool.booleanValue()) {
            this.M = true;
        }
    }

    private void c(List<UserFindResult> list) {
        this.m.setNewData(list);
        this.n.setNewData(list);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.43
            @Override // java.lang.Runnable
            public void run() {
                NearbyPeopleFragment.this.mRecommendViewMixedInNearby.b(NearbyPeopleFragment.this.K);
                NearbyPeopleFragment.this.K = true;
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        ValueAnimator ofInt;
        if (this.t == z) {
            return;
        }
        this.t = z;
        this.llRefresh.clearAnimation();
        if (this.t) {
            ofInt = ValueAnimator.ofInt(this.llRefresh.getHeight(), DensityUtils.a(this.k, 44.0f));
            ofInt.setInterpolator(new DecelerateInterpolator());
        } else {
            ofInt = ValueAnimator.ofInt(this.llRefresh.getHeight(), 0);
            ofInt.setInterpolator(new AccelerateInterpolator());
        }
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.38
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NearbyPeopleFragment.this.llRefresh == null) {
                    valueAnimator.cancel();
                    return;
                }
                NearbyPeopleFragment.this.llRefresh.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                NearbyPeopleFragment.this.llRefresh.requestLayout();
            }
        });
        ofInt.setDuration(300L);
        ofInt.start();
    }

    private void d(List<UserFindResult> list) {
        this.m.addData((Collection<? extends UserFindResult>) list);
        this.n.addData((Collection<? extends UserFindResult>) list);
    }

    public static boolean d() {
        return !BluedPreferences.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(String str) {
        List<NearbyPeopleTabModel> a2 = BluedConfig.a().a(this.k);
        String str2 = str;
        if (a2 != null) {
            str2 = str;
            if (a2.size() > 0) {
                Iterator<NearbyPeopleTabModel> it = a2.iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    NearbyPeopleTabModel next = it.next();
                    if (next.sort_by.equals(str)) {
                        str2 = next.getTitle();
                        break;
                    }
                }
            }
        }
        return str2;
    }

    private void g(String str) {
        ((NearbyPeoplePresenter) j()).j = str;
        ((NearbyPeoplePresenter) j()).j = str;
        if (TextUtils.isEmpty(str)) {
            ((NearbyPeoplePresenter) j()).j = BluedConfig.a().b().default_home_tabs;
        }
        this.n.b(((NearbyPeoplePresenter) j()).j);
        this.m.b(((NearbyPeoplePresenter) j()).j);
        BluedPreferences.A(((NearbyPeoplePresenter) j()).j);
        int size = this.C.size();
        int i = this.s;
        if (size > i) {
            TextView textView = this.C.get(i).tvSortMenu;
            textView.setTag(str);
            textView.setText(f(str));
        }
        w();
    }

    private boolean h(String str) {
        if (this.q == null) {
            this.q = BluedConfig.a().b(this.k);
        }
        List<List<String>> list = this.q;
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (List<String> list2 : this.q) {
            for (String str2 : list2) {
                if (!TextUtils.isEmpty(str) && str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int i(String str) {
        if (!h(str)) {
            return -1;
        }
        if (this.q == null) {
            this.q = BluedConfig.a().b(this.k);
        }
        List<List<String>> list = this.q;
        if (list == null || list.size() <= 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.q.size()) {
                return -1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.q.get(i2).size()) {
                    if (!TextUtils.isEmpty(str) && str.equals(this.q.get(i2).get(i4))) {
                        return i2;
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void A() {
        if (this.mRecommendViewMixedInNearby != null) {
            if (((NearbyPeoplePresenter) j()).t == null) {
                this.mRecommendViewMixedInNearby.a();
                return;
            }
            if (((NearbyPeoplePresenter) j()).t.hasData()) {
                this.mRecommendViewMixedInNearby.setMakeFriendRecommend(((NearbyPeoplePresenter) j()).t.data);
            } else {
                this.mRecommendViewMixedInNearby.setMakeFriendRecommendNoData((FindRecommendExtra) ((NearbyPeoplePresenter) j()).t.extra);
            }
            this.mRecommendViewMixedInNearby.setMakeFriendRecommendExtra((FindRecommendExtra) ((NearbyPeoplePresenter) j()).t.extra);
            CallHelloManager.a().a(getContext(), (IRequestHost) getFragmentActive(), this.mRecommendViewMixedInNearby.getFromPage(), (CallHelloManager.ToOpenListener) null);
        }
    }

    public void B() {
        if (this.mRecommendViewMixedInNearby == null || ((NearbyPeoplePresenter) j()).n != 1) {
            return;
        }
        this.mRecommendViewMixedInNearby.d();
        a(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.41
            @Override // java.lang.Runnable
            public void run() {
                NearbyPeopleFragment.this.mRecommendViewMixedInNearby.a(true);
            }
        }, c.j);
    }

    public void C() {
        this.w = false;
        this.v = null;
        aa();
    }

    public void D() {
        if (((NearbyPeoplePresenter) j()).e("people")) {
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        if (PermissionUtils.a()) {
            if (UserFindResult.USER_SORT_BY.NEARBY.equals(((NearbyPeoplePresenter) j()).j)) {
                ((NearbyPeoplePresenter) j()).t();
            }
            ((NearbyPeoplePresenter) j()).e();
            SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
            if (smartRefreshLayout != null && smartRefreshLayout.getState() == RefreshState.None) {
                c(true);
            }
            M();
        }
    }

    public void E() {
        ab();
    }

    public void F() {
        BluedPreferences.ac(false);
        BluedPreferences.w(1);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.n.getData().size()) {
                break;
            } else if (((UserFindResult) this.n.getData().get(i2)).itemType == 17) {
                this.n.getData().remove(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        this.n.notifyDataSetChanged();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.m.getData().size()) {
                break;
            } else if (((UserFindResult) this.m.getData().get(i4)).itemType == 17) {
                this.m.getData().remove(i4);
                break;
            } else {
                i3 = i4 + 1;
            }
        }
        this.m.notifyDataSetChanged();
    }

    @Override // com.soft.blued.utils.AdTestObserve
    public void a(int i) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.smoothScrollBy(0, i);
        }
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        if (CommunityManager.a.a().i()) {
            CommunityManager.a.a().d(false);
        }
        this.k = getActivity();
        if (BluedPreferences.E()) {
            AdTestManager.f21022a.b().a(this);
        }
        this.t = false;
        ((NearbyPeoplePresenter) j()).m = 0;
        J();
        I();
        M();
        Y();
        N();
        O();
        W();
        g(((NearbyPeoplePresenter) j()).j);
        a(Integer.valueOf(((NearbyPeoplePresenter) j()).k));
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (NearbyPeopleFragment.this.u) {
                    return;
                }
                NearbyPeopleFragment.this.mRefreshLayout.b((RefreshHeader) NearbyPeopleFragment.this.header);
                NearbyPeopleFragment.this.u = true;
            }
        });
        aa();
        if (((NearbyPeoplePresenter) j()).n == 1 && !((NearbyPeoplePresenter) j()).o) {
            ((NearbyPeoplePresenter) j()).o();
        }
        ((NearbyPeoplePresenter) j()).o = false;
        RelativeLayout relativeLayout = this.rl_location_root;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.rl_location_root.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101796));
        }
        if (((NearbyPeoplePresenter) j()).r != null) {
            a(((NearbyPeoplePresenter) j()).r);
            ((NearbyPeoplePresenter) j()).r = null;
        }
        ((NearbyPeoplePresenter) j()).a(true);
        try {
            String e = AesCrypto.e("RUWuOMHXFQFVVJY+qrweSxn5fddG9vUeHNPKtjeZWzgBDg==");
            Log.e("XFM", "registerTime: " + e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        S();
        H();
    }

    public void a(ShortEntranceExtra shortEntranceExtra) {
        a(shortEntranceExtra, false);
    }

    public void a(CallHelloModel callHelloModel) {
        RecommendViewMixedInNearby recommendViewMixedInNearby = this.mRecommendViewMixedInNearby;
        if (recommendViewMixedInNearby != null) {
            recommendViewMixedInNearby.b(callHelloModel.countDown);
        }
    }

    public void a(CallMeStatusData callMeStatusData) {
        RecommendViewMixedInNearby recommendViewMixedInNearby = this.mRecommendViewMixedInNearby;
        if (recommendViewMixedInNearby != null) {
            recommendViewMixedInNearby.a(callMeStatusData);
        }
    }

    public void a(FindDataExtra findDataExtra) {
        a(findDataExtra, false);
    }

    public void a(FindDataExtra findDataExtra, boolean z) {
        if (findDataExtra != null) {
            ((NearbyPeoplePresenter) j()).q().next_min_dist = findDataExtra.next_min_dist;
            ((NearbyPeoplePresenter) j()).q().next_skip_uid = findDataExtra.next_skip_uid;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (findDataExtra.adms_user != null && findDataExtra.adms_user.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= findDataExtra.adms_user.size()) {
                        break;
                    }
                    NearbyModelInsertData nearbyModelInsertData = new NearbyModelInsertData();
                    nearbyModelInsertData.adms_user = findDataExtra.adms_user.get(i2);
                    nearbyModelInsertData.position = nearbyModelInsertData.adms_user.layer;
                    arrayList.add(nearbyModelInsertData);
                    arrayList2.add(nearbyModelInsertData);
                    i = i2 + 1;
                }
            }
            if (findDataExtra.adms != null && findDataExtra.adms.size() > 0) {
                Log.v("drb", "banner2广告数量：" + findDataExtra.adms.size());
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= findDataExtra.adms.size()) {
                        break;
                    }
                    NearbyModelInsertData nearbyModelInsertData2 = new NearbyModelInsertData();
                    FindDataExtra._adms _admsVar = findDataExtra.adms.get(i4);
                    nearbyModelInsertData2.adms = _admsVar;
                    nearbyModelInsertData2.position = nearbyModelInsertData2.adms.line;
                    if (_admsVar.data.size() > 0 && _admsVar.data.get(0) != null) {
                        if (_admsVar.data.get(0).layout == 1) {
                            arrayList.add(nearbyModelInsertData2);
                            arrayList2.add(nearbyModelInsertData2);
                        } else if (_admsVar.data.get(0).layout == 2) {
                            arrayList.add(nearbyModelInsertData2);
                        } else if (_admsVar.data.get(0).layout == 3) {
                            arrayList2.add(nearbyModelInsertData2);
                        }
                    }
                    i3 = i4 + 1;
                }
            }
            if (!BluedPreferences.fH().equals("super_call") || !UserFindResult.USER_SORT_BY.ONLINE.equals(((NearbyPeoplePresenter) j()).j) || findDataExtra.super_call == null || findDataExtra.super_call.size() <= 0) {
                Log.v("xxxx", "运营位");
                Iterator<NearbyModelInsertData> it = b(findDataExtra, new ArrayList<>()).iterator();
                while (it.hasNext()) {
                    NearbyModelInsertData next = it.next();
                    if (next.nearby_dating.is_super_privilege_user != 1) {
                        if (next.nearby_dating.operate_promotion.layout == 2) {
                            arrayList.add(next);
                        }
                        if (next.nearby_dating.operate_promotion.layout == 3) {
                            arrayList2.add(next);
                        }
                    } else if (next.nearby_dating.operate_promotion.layout == 2) {
                        arrayList.add(next);
                    } else if (next.nearby_dating.operate_promotion.layout == 3) {
                        arrayList2.add(next);
                    } else {
                        arrayList.add(next);
                        arrayList2.add(next);
                    }
                }
            } else {
                Log.v("xxxx", "超级呼唤");
                Iterator<NearbyModelInsertData> it2 = c(findDataExtra, new ArrayList<>()).iterator();
                while (it2.hasNext()) {
                    NearbyModelInsertData next2 = it2.next();
                    UserFindExtra userFindExtra = next2.super_call;
                    if (userFindExtra != null && userFindExtra.is_super_privilege_user != 1) {
                        if (userFindExtra.operate_promotion.layout == 2) {
                            arrayList.add(next2);
                        }
                        if (userFindExtra.operate_promotion.layout == 3) {
                            arrayList2.add(next2);
                        }
                    } else if (userFindExtra != null && userFindExtra.operate_promotion != null && userFindExtra.operate_promotion.layout == 2) {
                        arrayList.add(next2);
                    } else if (userFindExtra == null || userFindExtra.operate_promotion == null || userFindExtra.operate_promotion.layout != 3) {
                        arrayList.add(next2);
                        arrayList2.add(next2);
                    } else {
                        arrayList2.add(next2);
                    }
                }
            }
            ArrayList<NearbyModelInsertData> a2 = a(findDataExtra, new ArrayList<>());
            arrayList.addAll(a2);
            arrayList2.addAll(a2);
            a(arrayList, z);
            b(arrayList2, z);
            if (((NearbyPeoplePresenter) j()).n == 1) {
                if (this.U == null || findDataExtra.adms_activity == null) {
                    if (this.V) {
                        return;
                    }
                    LiveEventBus.get(EventBusConstant.KEY_EVENT_NEARBY_ACTIVITY).post(findDataExtra.adms_activity);
                    this.U = findDataExtra.adms_activity;
                    this.V = true;
                    return;
                }
                Log.v("drb", "第二次广告id:" + findDataExtra.adms_activity.ads_id + " -- 图片：" + findDataExtra.adms_activity.ads_pics);
                if (this.U.ads_id == findDataExtra.adms_activity.ads_id && TextUtils.equals(this.U.ads_pics, findDataExtra.adms_activity.ads_pics) && TextUtils.equals(this.U.ads_apng, findDataExtra.adms_activity.ads_apng) && TextUtils.equals(this.U.ads_gif, findDataExtra.adms_activity.ads_gif)) {
                    return;
                }
                LiveEventBus.get(EventBusConstant.KEY_EVENT_NEARBY_ACTIVITY).post(findDataExtra.adms_activity);
                this.U = findDataExtra.adms_activity;
            }
        }
    }

    public void a(NearbyChatRoomModel nearbyChatRoomModel) {
        if (nearbyChatRoomModel == null) {
            this.nearbyChatRoomView.setVisibility(8);
            this.nearbyChatRoomHostView.setVisibility(8);
        } else if (!nearbyChatRoomModel.show) {
            this.nearbyChatRoomView.setVisibility(8);
            this.nearbyChatRoomHostView.setVisibility(8);
        } else if (nearbyChatRoomModel.show_new) {
            this.nearbyChatRoomHostView.setVisibility(0);
            this.nearbyChatRoomView.setVisibility(8);
            this.nearbyChatRoomHostView.a();
            if (nearbyChatRoomModel.room_data == null || nearbyChatRoomModel.room_data.size() == 1) {
                nearbyChatRoomModel.room_data = new ArrayList<>();
            }
            this.nearbyChatRoomHostView.setText(nearbyChatRoomModel.text);
            this.nearbyChatRoomHostView.a(nearbyChatRoomModel, (BaseFragment) this);
        } else {
            this.nearbyChatRoomHostView.setVisibility(8);
            this.nearbyChatRoomView.setVisibility(0);
            if (this.f16764c) {
                this.nearbyChatRoomView.a();
            } else {
                this.nearbyChatRoomView.b();
            }
            this.nearbyChatRoomView.setText(nearbyChatRoomModel.text);
            if (StringUtils.d(nearbyChatRoomModel.ceremony_text)) {
                return;
            }
            this.nearbyChatRoomView.setTextNotice(nearbyChatRoomModel.ceremony_text);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.soft.blued.utils.AdTestObserve
    public void a(UserFindResult userFindResult) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void a(UsersNewCallBubbleModel usersNewCallBubbleModel) {
        this.mRecommendViewMixedInNearby.a(usersNewCallBubbleModel);
    }

    public void a(Boolean bool) {
        if (this.clRedPackGuide == null || this.redPackRecyclerView == null || this.tvCardGuide == null || this.llGuideAnimation == null || this.ivRedPackGuideAnimation == null || this.tvCashOutBtn == null || this.tvRedPackGuideTitle == null || this.tvRedPackGuideSubtitle == null || this.ivRedPackGuideClose == null || this.Q) {
            return;
        }
        final AppConfigModel b = BluedConfig.a().b();
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        Log.e("xfm", "showRedPackGuide: ====" + format);
        int al = BluedPreferences.al(format + UserInfo.getInstance().getLoginUserInfo().uid);
        if (bool.booleanValue()) {
            if (b.sign_day_total == 29) {
                b.sign_day_total = 30;
            }
            b.is_sign_today = 1;
            this.A = true;
        }
        if (b.is_open_sign != 1 || ((b.is_sign_today == 1 && b.sign_day_total < 30) || al > b.sign_show_rate)) {
            ConstraintLayout constraintLayout = this.clRedPackGuide;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
        } else {
            this.clRedPackGuide.setVisibility(0);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.k);
            linearLayoutManager.setOrientation(0);
            this.redPackRecyclerView.setLayoutManager(linearLayoutManager);
            this.redPackRecyclerView.setVisibility(0);
            RedPackGuideListAdapter redPackGuideListAdapter = new RedPackGuideListAdapter(this.k, getFragmentActive());
            this.H = redPackGuideListAdapter;
            this.redPackRecyclerView.setAdapter(redPackGuideListAdapter);
            if (BluedPreferences.ev().booleanValue()) {
                this.H.setNewData(b.sign_data);
                this.H.a(b.sign_url);
                this.H.a(b.sign_day_total);
                if (BluedSkinUtils.c()) {
                    this.tvCardGuide.setText(Html.fromHtml(this.k.getString(R.string.sign_receive_money_guide)));
                } else {
                    this.tvCardGuide.setText(Html.fromHtml(this.k.getString(R.string.sign_receive_money_guide_dark)));
                }
                if (b.sign_day_total >= 2) {
                    postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.25
                        @Override // java.lang.Runnable
                        public void run() {
                            NearbyPeopleFragment.this.b(b.sign_day_total - 1);
                        }
                    }, 50L);
                }
                if (b.sign_day_total < 30) {
                    postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.26
                        @Override // java.lang.Runnable
                        public void run() {
                            int i;
                            int i2;
                            NearbyPeopleFragment.this.llGuideAnimation.setVisibility(0);
                            int childCount = b.sign_day_total == 0 ? 0 : (b.sign_day_total < 1 || b.sign_day_total >= 25) ? NearbyPeopleFragment.this.redPackRecyclerView.getChildCount() - (30 - b.sign_day_total) : 1;
                            int left = NearbyPeopleFragment.this.redPackRecyclerView.getChildAt(childCount) != null ? NearbyPeopleFragment.this.redPackRecyclerView.getChildAt(childCount).getLeft() : 0;
                            if (childCount == 0) {
                                i = left + DensityUtils.a(NearbyPeopleFragment.this.k, 7.0f) + 3;
                                i2 = 6;
                            } else {
                                i = left - 5;
                                i2 = 3;
                            }
                            NearbyPeopleFragment.this.llGuideAnimation.setPadding(i, i2, 0, 0);
                            Log.e("xfm", "run: -------> " + i);
                            ImageLoader.c(NearbyPeopleFragment.this.getFragmentActive(), "icon_red_pack_get_animation.png").f().g(1).a(new ImageLoader.OnAnimationStateListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.26.1
                                public void a() {
                                }

                                public void b() {
                                    LiveEventBus.get(EventBusConstant.KEY_EVENT_SHOW_GOLD_ANIMAITON).post(true);
                                    if (NearbyPeopleFragment.this.llGuideAnimation != null) {
                                        NearbyPeopleFragment.this.llGuideAnimation.setVisibility(8);
                                    }
                                }
                            }).a(NearbyPeopleFragment.this.ivRedPackGuideAnimation);
                        }
                    }, 2500L);
                } else {
                    a(b);
                }
                BluedPreferences.ew();
            } else {
                a(b);
            }
            if (b.is_sign_today == 0 && Long.parseLong(format) > BluedPreferences.ex().longValue()) {
                int i = b.sign_day_total;
                if (b.sign_day_total < 30) {
                    String string = this.k.getString(R.string.sign_some_days_to_cash_out);
                    LiveEventBus.get(EventBusConstant.KEY_EVENT_SHOW_SHOW_RED_PACK_SIGN_TIP).post(String.format(string, (30 - i) + ""));
                    BluedPreferences.am(format);
                }
            }
            if (UserInfo.getInstance().getLoginUserInfo().isShowRedPackGuide) {
                BluedPreferences.a(format + UserInfo.getInstance().getLoginUserInfo().uid, al + 1);
                UserInfo.getInstance().getLoginUserInfo().isShowRedPackGuide = false;
            }
        }
        RecyclerView recyclerView = this.redPackRecyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.27
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView2, int i2) {
                    super.onScrollStateChanged(recyclerView2, i2);
                    if (NearbyPeopleFragment.this.S && i2 == 0) {
                        NearbyPeopleFragment.this.S = false;
                        NearbyPeopleFragment nearbyPeopleFragment = NearbyPeopleFragment.this;
                        nearbyPeopleFragment.b(nearbyPeopleFragment.T);
                    }
                }
            });
        }
    }

    public void a(Integer num) {
        if (this.mRecyclerView == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.mRecyclerView.setAdapter(this.m);
            new NearbyGridLayoutManager(this.k, ((NearbyPeoplePresenter) j()).l);
            this.m.notifyDataSetChanged();
            this.mRecyclerView.setLayoutManager(new SpannedGridLayoutManager(new SpannedGridLayoutManager.GridSpanLookup() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.34
                @Override // com.soft.blued.ui.find.manager.SpannedGridLayoutManager.GridSpanLookup
                public SpannedGridLayoutManager.SpanInfo a(int i) {
                    int i2;
                    int itemViewType;
                    int i3 = 1;
                    if (NearbyPeopleFragment.this.m != null && NearbyPeopleFragment.this.m.getItem(i) != 0 && (itemViewType = NearbyPeopleFragment.this.m.getItemViewType(i)) != 10) {
                        if (itemViewType == 11 || itemViewType == 17) {
                            i2 = ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).l;
                        } else {
                            if (itemViewType != 22 && itemViewType != 19 && itemViewType != 20) {
                                switch (itemViewType) {
                                    case 24:
                                    case 25:
                                        break;
                                    case 26:
                                        break;
                                    default:
                                        i2 = ((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).l;
                                        break;
                                }
                            }
                            i3 = 2;
                            i2 = 2;
                        }
                        return new SpannedGridLayoutManager.SpanInfo(i2, i3);
                    }
                    i2 = 1;
                    return new SpannedGridLayoutManager.SpanInfo(i2, i3);
                }
            }, ((NearbyPeoplePresenter) j()).l, 1.0f));
            this.m.notifyDataSetChanged();
            ((NearbyPeoplePresenter) j()).q().if_grid = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRecyclerView.getLayoutParams();
            marginLayoutParams.leftMargin = DisplayUtil.a(this.k, 12.0f);
            marginLayoutParams.rightMargin = DisplayUtil.a(this.k, 6.0f);
            this.mRecyclerView.setLayoutParams(marginLayoutParams);
            e();
        } else {
            this.mRecyclerView.setAdapter(this.n);
            NearbyGridLayoutManager nearbyGridLayoutManager = new NearbyGridLayoutManager(this.k, 1);
            nearbyGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.35
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    return 1;
                }
            });
            this.mRecyclerView.setLayoutManager(nearbyGridLayoutManager);
            this.n.notifyDataSetChanged();
            ((NearbyPeoplePresenter) j()).q().if_grid = false;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mRecyclerView.getLayoutParams();
            marginLayoutParams2.leftMargin = DisplayUtil.a(this.k, 0.0f);
            marginLayoutParams2.rightMargin = DisplayUtil.a(this.k, 0.0f);
            this.mRecyclerView.setLayoutParams(marginLayoutParams2);
            this.n.c();
            this.m.g();
        }
        ((NearbyPeoplePresenter) j()).c(num.intValue());
    }

    public void a(String str, boolean z) {
        super.a(str, z);
        if (TextUtils.equals(str, "_load_type_refresh_")) {
            RefreshUtils.b(this.appbar);
        }
        boolean z2 = true;
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = true;
            }
        } else if (str.equals("_load_type_refresh_")) {
            z2 = false;
        }
        if (!z2 || z2) {
            if (z) {
                if (str == "_load_type_refresh_") {
                    V();
                    U();
                }
                if (this.m.getData().size() != 0) {
                    this.noDataAndLoadFailView.d();
                    NoDataAndLoadFailView noDataAndLoadFailView = this.locationNoDataView;
                    if (noDataAndLoadFailView != null) {
                        noDataAndLoadFailView.d();
                    }
                } else if (PermissionUtils.a()) {
                    this.noDataAndLoadFailView.a();
                } else {
                    NoDataAndLoadFailView noDataAndLoadFailView2 = this.locationNoDataView;
                    if (noDataAndLoadFailView2 != null) {
                        noDataAndLoadFailView2.a();
                    }
                }
                if (this.m.getItemCount() < 1 || this.m.getItemCount() > 9) {
                    this.layoutFilterReset.setVisibility(8);
                } else {
                    this.layoutFilterReset.setVisibility(0);
                }
            } else if (this.m.getData().size() == 0) {
                this.noDataAndLoadFailView.b();
            } else {
                this.noDataAndLoadFailView.d();
            }
            e();
            ((NearbyPeoplePresenter) j()).m--;
            if (((NearbyPeoplePresenter) j()).m == 0) {
                c(false);
            }
            this.mRefreshLayout.j();
            this.m.loadMoreComplete();
            this.n.loadMoreComplete();
        }
    }

    public void a(List<UserFindResult> list) {
        if (((NearbyPeoplePresenter) j()).n == 1) {
            c(list);
        } else {
            d(list);
        }
    }

    public void af_() {
        PeopleListQuickAdapter peopleListQuickAdapter = this.n;
        if (peopleListQuickAdapter != null) {
            this.p = peopleListQuickAdapter.getData();
        }
        PeopleGridQuickAdapter peopleGridQuickAdapter = this.m;
        if (peopleGridQuickAdapter != null) {
            this.o = peopleGridQuickAdapter.getData();
        }
        RecommendViewMixedInNearby recommendViewMixedInNearby = this.mRecommendViewMixedInNearby;
        if (recommendViewMixedInNearby != null) {
            recommendViewMixedInNearby.e();
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.O);
        }
        AppBarLayout appBarLayout = this.appbar;
        if (appBarLayout != null) {
            appBarLayout.removeOnOffsetChangedListener(this.N);
        }
        FrameLayout frameLayout = this.flBanner;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        super.af_();
        for (Unbinder unbinder : this.E) {
            if (unbinder != null) {
                unbinder.unbind();
            }
        }
        for (Unbinder unbinder2 : this.F) {
            if (unbinder2 != null) {
                unbinder2.unbind();
            }
        }
        Unbinder unbinder3 = this.G;
        if (unbinder3 != null) {
            unbinder3.unbind();
            this.G = null;
        }
    }

    @Override // com.soft.blued.utils.AdTestObserve
    public void b() {
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.i();
        }
    }

    public void b(ShortEntranceExtra shortEntranceExtra) {
    }

    public void b(CallHelloModel callHelloModel) {
        RecommendViewMixedInNearby recommendViewMixedInNearby = this.mRecommendViewMixedInNearby;
        if (recommendViewMixedInNearby == null || callHelloModel == null) {
            return;
        }
        recommendViewMixedInNearby.a(callHelloModel.isShowCount, callHelloModel.count);
    }

    public void b(FindDataExtra findDataExtra) {
        a(findDataExtra, true);
    }

    public void b(Boolean bool) {
        if (!bool.booleanValue()) {
            ac();
            return;
        }
        X();
        D();
    }

    public void b(List<NearbyTwoFloorModel> list) {
        NearbyTwoFloorModel nearbyTwoFloorModel = list.get(0);
        Log.v("drb", "setTwoLevelData nearbyTwoFloorModel:" + nearbyTwoFloorModel);
        if (nearbyTwoFloorModel != null && nearbyTwoFloorModel._1009 != null && nearbyTwoFloorModel._1009.size() > 0) {
            this.v = nearbyTwoFloorModel._1009.get(0);
        }
        Log.v("drb", "setTwoLevelData mTwoFloorModel:" + this.v);
        TwoFloorModel twoFloorModel = this.v;
        if (twoFloorModel == null) {
            this.w = false;
        } else if (twoFloorModel.show_type == 1 && this.v.anchor != null && StringUtils.a(this.v.anchor.live_id, 0) <= 0) {
            this.w = false;
        } else if (this.v.show_type == 3 && TextUtils.isEmpty(this.v.target_url)) {
            this.w = false;
        } else if (this.v.show_type == 2) {
            this.w = false;
        } else if (this.v != null) {
            Log.v("drb", "setTwoLevelData --------- preload_image：" + this.v.preload_image);
            if (TextUtils.isEmpty(this.v.preload_image)) {
                this.w = false;
            } else {
                ImageFileLoader.a(getFragmentActive()).a(this.v.preload_image).a();
                if (this.v.is_op_ad == 2) {
                    if ("0".equalsIgnoreCase(this.v.adm_type_source)) {
                        ImageFileLoader.a(getFragmentActive()).a(this.v.master_image).a();
                    } else if ("6".equalsIgnoreCase(this.v.adm_type_source)) {
                        Log.v("drb", "mTwoFloorModel.third_id:" + this.v.third_id);
                        ATInterstitialAutoAd.init(getActivity(), new String[]{this.v.third_id}, new ATInterstitialAutoLoadListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.42
                            @Override // com.anythink.interstitial.api.ATInterstitialAutoLoadListener
                            public void onInterstitialAutoLoadFail(String str, AdError adError) {
                                NearbyPeopleFragment.this.v();
                                Log.v("drb", "Topon插屏广告加载失败：" + adError.toString());
                            }

                            @Override // com.anythink.interstitial.api.ATInterstitialAutoLoadListener
                            public void onInterstitialAutoLoaded(String str) {
                                Log.v("drb", "Topon插屏广告加载成功");
                            }
                        });
                    }
                    EventTrackGuy.a(GuyProtos.Event.HOME_REFRESH_SECOND_AD_RETURN, this.v.id);
                }
                this.w = true;
            }
        }
        aa();
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if ("find".equals(str)) {
            a(0, true);
        }
    }

    @Override // com.soft.blued.utils.AdTestObserve
    public boolean c() {
        RecyclerView recyclerView = this.mRecyclerView;
        boolean z = false;
        if (recyclerView != null) {
            z = false;
            if (recyclerView.getAdapter() == this.n) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        c(str);
    }

    public void e() {
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.36
            @Override // java.lang.Runnable
            public void run() {
                if (((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).r() && NearbyPeopleFragment.this.m != null) {
                    NearbyPeopleFragment.this.m.b(NearbyPeopleFragment.this.l);
                    if (NearbyPeopleFragment.this.l && NearbyPeopleFragment.this.z) {
                        NearbyPeopleFragment.this.m.c();
                    } else {
                        NearbyPeopleFragment.this.m.g();
                    }
                } else if (((NearbyPeoplePresenter) NearbyPeopleFragment.this.j()).r() || NearbyPeopleFragment.this.n == null) {
                } else {
                    NearbyPeopleFragment.this.n.b(NearbyPeopleFragment.this.l);
                    if (NearbyPeopleFragment.this.l && NearbyPeopleFragment.this.z) {
                        NearbyPeopleFragment.this.n.c();
                    } else {
                        NearbyPeopleFragment.this.n.g();
                    }
                }
            }
        });
    }

    public void e(String str) {
        int i;
        if (TextUtils.isEmpty(str) || !h(str) || (i = i(str)) < 0 || i >= this.B.size()) {
            return;
        }
        this.s = i;
        g(str);
        if (UserFindResult.USER_SORT_BY.NEARBY.equals(((NearbyPeoplePresenter) j()).j)) {
            ((NearbyPeoplePresenter) j()).t();
        }
        ab();
    }

    public int g() {
        return R.layout.fragment_nearby_home;
    }

    public String getSimpleRouterName() {
        return "A18";
    }

    public void l() {
        if (!PermissionUtils.a()) {
            ((NearbyPeoplePresenter) j()).o();
            NoDataAndLoadFailView noDataAndLoadFailView = this.locationNoDataView;
            if (noDataAndLoadFailView != null) {
                noDataAndLoadFailView.a();
                return;
            }
            return;
        }
        ((NearbyPeoplePresenter) j()).t();
        this.mRefreshLayout.i();
        NoDataAndLoadFailView noDataAndLoadFailView2 = this.locationNoDataView;
        if (noDataAndLoadFailView2 != null) {
            noDataAndLoadFailView2.d();
        }
    }

    public void o() {
        super.o();
        this.m.setEnableLoadMore(true);
        this.n.setEnableLoadMore(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131369673) {
            EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_FRAME_CLICK);
            TerminalActivity.d(getContext(), SearchGlobalFragment.class, (Bundle) null);
        } else if (id != 2131370390) {
        } else {
            Z();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        HomeTabClick.b("find", this);
        NearbyChatHostRoomView nearbyChatHostRoomView = this.nearbyChatRoomHostView;
        if (nearbyChatHostRoomView != null) {
            nearbyChatHostRoomView.d();
        }
        Timer timer = this.J;
        if (timer != null) {
            timer.cancel();
        }
        PeopleListQuickAdapter peopleListQuickAdapter = this.n;
        if (peopleListQuickAdapter != null) {
            peopleListQuickAdapter.k();
        }
        if (BluedPreferences.E()) {
            AdTestManager.f21022a.b().a((AdTestObserve) null);
            if (this.b != null) {
                AdTestManager.f21022a.b().b(this.b);
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.z = false;
        if (this.l) {
            PeopleGridQuickAdapter peopleGridQuickAdapter = this.m;
            if (peopleGridQuickAdapter != null) {
                peopleGridQuickAdapter.g();
            }
            PeopleListQuickAdapter peopleListQuickAdapter = this.n;
            if (peopleListQuickAdapter != null) {
                peopleListQuickAdapter.g();
            }
        }
        PeopleListQuickAdapter peopleListQuickAdapter2 = this.n;
        if (peopleListQuickAdapter2 != null) {
            peopleListQuickAdapter2.j();
        }
    }

    public void onResume() {
        super.onResume();
        this.z = true;
        x();
        PeopleListQuickAdapter peopleListQuickAdapter = this.n;
        if (peopleListQuickAdapter != null) {
            peopleListQuickAdapter.i();
            this.n.notifyDataSetChanged();
        }
        if (this.A) {
            LiveEventBus.get(EventBusConstant.KEY_EVENT_SHOW_SHOW_RED_PACK_SIGN_TIP).post(this.k.getString(R.string.done_everyday_task));
            this.A = false;
        }
        G();
        e();
        AppUtils.a(this.appbar);
        AppUtils.a((View) this.header);
        AppUtils.a(this.nearbyChatRoomView);
        AppUtils.a(this.nearbyChatRoomHostView);
    }

    public void onStart() {
        super.onStart();
        M();
    }

    public void onStop() {
        PeopleListQuickAdapter peopleListQuickAdapter;
        PeopleGridQuickAdapter peopleGridQuickAdapter;
        super.onStop();
        L();
        if (((NearbyPeoplePresenter) j()).r() && (peopleGridQuickAdapter = this.m) != null) {
            peopleGridQuickAdapter.c(((NearbyPeoplePresenter) j()).j);
        } else if (((NearbyPeoplePresenter) j()).r() || (peopleListQuickAdapter = this.n) == null) {
        } else {
            peopleListQuickAdapter.c(((NearbyPeoplePresenter) j()).j);
        }
    }

    public void p() {
        super.p();
        this.m.setEnableLoadMore(false);
        this.n.setEnableLoadMore(false);
    }

    public boolean q() {
        return true;
    }

    public boolean r() {
        return true;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.l = z;
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SET_TIP_VISIBILITY).post(true);
        if (z) {
            HomeTabClick.a("find", this);
            RecommendViewMixedInNearby recommendViewMixedInNearby = this.mRecommendViewMixedInNearby;
            if (recommendViewMixedInNearby != null) {
                recommendViewMixedInNearby.b(CallHelloManager.a().b());
            }
        } else {
            L();
        }
        e();
    }

    public void v() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleFragment.37
            @Override // java.lang.Runnable
            public void run() {
                if (NearbyPeopleFragment.this.header != null) {
                    NearbyPeopleFragment.this.header.a();
                }
            }
        }, 300L);
    }

    public void w() {
        int size = this.B.size();
        int i = this.s;
        if (size > i) {
            TabHolder tabHolder = this.B.get(i);
            b(false);
            ShapeHelper.a(tabHolder.tvSortTab, 2131102254);
            tabHolder.tvSortTab.setTextSize(17.0f);
            tabHolder.ivSortTab.setImageDrawable(BluedSkinUtils.b(this.k, (int) R.drawable.icon_nearby_arrow2));
            tabHolder.layoutSortTab.setTag(true);
        }
    }

    public void x() {
        if (this.z) {
            if (!((NearbyPeoplePresenter) j()).h) {
                AdFloatObserver.a().b();
                return;
            }
            AdvertFloatFragment.a(this.k, ((NearbyPeoplePresenter) j()).i, ADConstants.AD_POSITION.NEARBY_FLOAT_AD);
            ((NearbyPeoplePresenter) j()).h = false;
        }
    }

    public void y() {
        if (((NearbyPeoplePresenter) j()).s()) {
            EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_LIST_BTN_CLICK, GuyProtos.ShowType.PALACE_SHOW);
            a((Integer) 0);
            return;
        }
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_LIST_BTN_CLICK, GuyProtos.ShowType.LIST_SHOW);
        a((Integer) 1);
    }

    public void z() {
        if (((NearbyPeoplePresenter) j()).n == 1) {
            c((List<UserFindResult>) null);
        }
    }
}
