package com.soft.blued.customview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.anythink.banner.api.ATBannerListener;
import com.anythink.banner.api.ATBannerView;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.nativead.api.ATNativeAdView;
import com.blued.ad.ADConstants;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageOptions;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.adx.banner.AdxNativeManager;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.utils.ImageUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.banner.BannerView;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.soft.blued.R;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.customview.banner.BannerAdListenerAdapter;
import com.soft.blued.customview.banner.BannerAdManager;
import com.soft.blued.customview.banner.HWBannerManager;
import com.soft.blued.customview.banner.TOPBannerManager;
import com.soft.blued.customview.banner.TTBannerManager;
import com.soft.blued.customview.banner.TTTemplateBannerManager;
import com.soft.blued.customview.banner.TXBannerManager;
import com.soft.blued.customview.banner.TopNativeTemplateManager;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.ab_test.models.AdxConfig;
import com.soft.blued.ui.ab_test.models.BannerAdExtra;
import com.soft.blued.ui.find.manager.NearbyTopBannerManager;
import com.soft.blued.ui.pay.alipay.AlipayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.welcome.AdMiniAppDialogFragment;
import com.soft.blued.ui.welcome.BaseADVideoFragment;
import com.soft.blued.utils.ADClosePopOptionsUtils;
import com.soft.blued.utils.AdBannerTestObserve;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.WeChatUtils;
import com.soft.blued.utils.activity.BDActivityManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BannerADView.class */
public class BannerADView extends LinearLayout implements AdBannerTestObserve {
    private TextView A;
    private TextView B;
    private TextView C;
    private ImageView D;
    private TextView E;
    private ATBannerView F;
    private ATNativeAdView G;
    private BannerView H;
    private UnifiedBannerView I;
    private TTNativeExpressAd J;
    private AdxNativeManager K;

    /* renamed from: a  reason: collision with root package name */
    public Context f28322a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public List<BluedADExtra> f28323c;
    public BannerAdManager d;
    public BannerAdManager e;
    ATBannerListener f;
    private IRequestHost g;
    private View h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private TextView l;
    private View m;
    private View n;
    private CardView o;
    private LinearLayout p;
    private ImageOptions q;
    private boolean r;
    private boolean s;
    private BluedADConstraintLayout t;
    private ADListener u;
    private View v;
    private ADConstants.AD_POSITION w;
    private TTFeedAd x;
    private ConstraintLayout y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.customview.BannerADView$13  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BannerADView$13.class */
    public class AnonymousClass13 implements ImageFileLoader.OnLoadFileListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BluedADExtra f28332a;
        final /* synthetic */ ImageSize b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f28333c;
        final /* synthetic */ BannerAdListener d;

        AnonymousClass13(BluedADExtra bluedADExtra, ImageSize imageSize, int i, BannerAdListener bannerAdListener) {
            this.f28332a = bluedADExtra;
            this.b = imageSize;
            this.f28333c = i;
            this.d = bannerAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            BannerADView.this.b();
            if (BannerADView.this.u == null || !BannerADView.this.g.isActive()) {
                return;
            }
            BannerADView.this.u.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BluedADExtra bluedADExtra, View view) {
            Tracker.onClick(view);
            ADClosePopOptionsUtils.a(BannerADView.this.f28322a, bluedADExtra, BannerADView.this.j, BannerADView.this.w, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$13$THHwCHlmz2scidxW6k8wIpPp1Rg
                @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
                public final void onRemoved() {
                    BannerADView.AnonymousClass13.this.a();
                }
            });
        }

        @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
        public void onUIFinish(File file, Exception exc) {
            if (file == null || !file.exists()) {
                Log.v("drb", "直客广告加载完成 文件不存在：" + this.f28332a.ads_pics);
                if (BannerADView.this.u != null && BannerADView.this.g.isActive()) {
                    BannerADView.this.u.b();
                }
                BannerAdListener bannerAdListener = this.d;
                if (bannerAdListener != null) {
                    bannerAdListener.a(0, "");
                    return;
                }
                return;
            }
            Log.v("drb", "直客广告加载完成 文件存在：" + this.f28332a.ads_pics);
            float a2 = (float) this.b.a();
            float b = (float) this.b.b();
            if ("7".equalsIgnoreCase(this.f28332a.adms_type) && (BannerADView.this.w == ADConstants.AD_POSITION.NEARBY_HOME_TOP || BannerADView.this.w == ADConstants.AD_POSITION.NEARBY_HOME_LIST_BANNER)) {
                int a3 = DensityUtils.a(BannerADView.this.f28322a, this.f28333c);
                int round = Math.round(a3 / 4.0f);
                int[] a4 = ImageUtils.a((int) a2, (int) b, a3, round, a3, round);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) BannerADView.this.i.getLayoutParams();
                layoutParams.width = a4[0];
                layoutParams.height = a4[1];
                BannerADView.this.i.setLayoutParams(layoutParams);
                BannerADView.this.i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                Log.v("drb", "imglp.width:" + layoutParams.width + " -- imglp.height:" + layoutParams.height);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) BannerADView.this.n.getLayoutParams();
                layoutParams2.height = layoutParams.height;
                BannerADView.this.n.setLayoutParams(layoutParams2);
            } else {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) BannerADView.this.i.getLayoutParams();
                layoutParams3.width = DensityUtils.a(BannerADView.this.f28322a, this.f28333c);
                layoutParams3.height = (int) ((layoutParams3.width * b) / a2);
                BannerADView.this.i.setLayoutParams(layoutParams3);
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) BannerADView.this.n.getLayoutParams();
                layoutParams4.height = layoutParams3.height;
                BannerADView.this.n.setLayoutParams(layoutParams4);
                BannerADView.this.i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            ImageLoader.a(BannerADView.this.g, file).a(BannerADView.this.q).a(BannerADView.this.i);
            if (this.f28332a.can_close == 1) {
                Log.v("drb", "直客广告 展示关闭按钮");
                BannerADView.this.j.setVisibility(0);
                BannerADView.this.v.setVisibility(0);
                View view = BannerADView.this.v;
                final BluedADExtra bluedADExtra = this.f28332a;
                view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$13$qqq1hpwv7yGY2s6Hx5Yy6qUni4E
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        BannerADView.AnonymousClass13.this.a(bluedADExtra, view2);
                    }
                });
            } else {
                BannerADView.this.j.setVisibility(8);
                BannerADView.this.v.setOnClickListener(null);
            }
            BannerAdListener bannerAdListener2 = this.d;
            if (bannerAdListener2 != null) {
                bannerAdListener2.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.customview.BannerADView$16  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BannerADView$16.class */
    public class AnonymousClass16 implements TTNativeExpressAd.ExpressAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BluedADExtra f28338a;

        AnonymousClass16(BluedADExtra bluedADExtra) {
            this.f28338a = bluedADExtra;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            BannerADView.this.b();
            if (BannerADView.this.J != null) {
                BannerADView.this.J = null;
            }
            if (BannerADView.this.u == null || !BannerADView.this.g.isActive()) {
                return;
            }
            BannerADView.this.u.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BluedADExtra bluedADExtra, View view) {
            Tracker.onClick(view);
            ADClosePopOptionsUtils.a(BannerADView.this.f28322a, bluedADExtra, BannerADView.this.v, BannerADView.this.w, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$16$NBJewN0Rf5YBwI84FQX_1XCeDo0
                @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
                public final void onRemoved() {
                    BannerADView.AnonymousClass16.this.a();
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i) {
            Log.v("drb", "banner1穿山甲广告：onAdClicked");
            FindHttpUtils.b(this.f28338a.click_url);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i) {
            Log.v("drb", "banner1穿山甲广告：onAdShow");
            FindHttpUtils.b(this.f28338a.show_url);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i) {
            Log.v("drb", "banner1穿山甲广告：onRenderFail");
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f, float f2) {
            Log.v("drb", "banner1穿山甲广告：onRenderSuccess");
            BannerADView.this.v.setVisibility(0);
            View view2 = BannerADView.this.v;
            final BluedADExtra bluedADExtra = this.f28338a;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$16$QnWv5wcakcK52kwlsWKf5TK-A1o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    BannerADView.AnonymousClass16.this.a(bluedADExtra, view3);
                }
            });
            BannerADView.this.p.setVisibility(0);
            BannerADView.this.p.removeAllViews();
            ViewGroup.LayoutParams layoutParams = BannerADView.this.p.getLayoutParams();
            layoutParams.height = -2;
            BannerADView.this.p.setLayoutParams(layoutParams);
            BannerADView.this.p.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.customview.BannerADView$21  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BannerADView$21.class */
    public static /* synthetic */ class AnonymousClass21 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28347a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ADConstants.AD_POSITION.values().length];
            f28347a = iArr;
            try {
                iArr[ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f28347a[ADConstants.AD_POSITION.USER_PROFILE_TAB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.customview.BannerADView$8  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BannerADView$8.class */
    public class AnonymousClass8 implements BannerAdListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BluedADExtra f28354a;

        AnonymousClass8(BluedADExtra bluedADExtra) {
            this.f28354a = bluedADExtra;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BluedADExtra bluedADExtra, View view) {
            Tracker.onClick(view);
            Log.v("drb", "banner1点击：" + bluedADExtra.adm_type + " -- " + bluedADExtra.adms_type);
            if ("2".equals(bluedADExtra.adms_type) && AlipayUtils.a()) {
                WebViewShowInfoFragment.show(BannerADView.this.f28322a, bluedADExtra.deep_link_url, 9);
            } else if (BannerADView.this.b(bluedADExtra)) {
            } else {
                if ("7".equals(bluedADExtra.adms_type)) {
                    if (TextUtils.isEmpty(bluedADExtra.deep_link_url)) {
                        WebViewShowInfoFragment.show(BannerADView.this.f28322a, bluedADExtra.target_url, 9);
                        return;
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(bluedADExtra.deep_link_url));
                    if (AppUtils.a(intent)) {
                        BannerADView.this.f28322a.startActivity(intent);
                    } else {
                        WebViewShowInfoFragment.show(BannerADView.this.f28322a, bluedADExtra.target_url, 9);
                    }
                } else if (bluedADExtra.adm_type == 2) {
                    BaseADVideoFragment.a(BannerADView.this.f28322a, bluedADExtra, 1);
                } else if (TextUtils.isEmpty(bluedADExtra.deep_link_url)) {
                    WebViewShowInfoFragment.show(BannerADView.this.f28322a, bluedADExtra.target_url, 9);
                } else {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(bluedADExtra.deep_link_url));
                    if (AppUtils.a(intent2)) {
                        BannerADView.this.f28322a.startActivity(intent2);
                    } else {
                        WebViewShowInfoFragment.show(BannerADView.this.f28322a, bluedADExtra.target_url, 9);
                    }
                }
            }
        }

        @Override // com.soft.blued.customview.BannerADView.BannerAdListener
        public void a() {
            Log.v("drb", "banner1直客广告 展示成功:" + BannerADView.this.getVisibility());
            LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE;
            EventTrackLoginAndRegister.b(event, this.f28354a.ads_id + "", this.f28354a.adm_type_source);
            BluedADConstraintLayout bluedADConstraintLayout = BannerADView.this.t;
            final BluedADExtra bluedADExtra = this.f28354a;
            bluedADConstraintLayout.a(bluedADExtra, new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$8$aqE67IAb2oS77PJPf0baezM-AC0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BannerADView.AnonymousClass8.this.a(bluedADExtra, view);
                }
            });
        }

        @Override // com.soft.blued.customview.BannerADView.BannerAdListener
        public void a(int i, String str) {
            BannerADView.this.a("banner1直客广告展示失败 -- 删除广告id:");
            EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE_FAIL, this.f28354a.ads_id + "", str, i + "", this.f28354a.adm_type_source);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BannerADView$ADListener.class */
    public interface ADListener {
        void a();

        void b();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BannerADView$BannerAdListener.class */
    public interface BannerAdListener {
        void a();

        void a(int i, String str);
    }

    public BannerADView(Context context) {
        super(context);
        this.r = false;
        this.s = true;
        a(context, (AttributeSet) null);
    }

    public BannerADView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = false;
        this.s = true;
        a(context, attributeSet);
    }

    public BannerADView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = false;
        this.s = true;
        a(context, attributeSet);
    }

    private void a(int i, AdxConfig adxConfig, long j) {
        if (this.K == null) {
            this.K = new AdxNativeManager(this.f28322a, i, adxConfig.type, adxConfig.parallel_num, j, new com.blued.android.module.common.adx.base.ADListener() { // from class: com.soft.blued.customview.BannerADView.1
                @Override // com.blued.android.module.common.adx.base.ADListener
                public void onADEvent(ADEvent aDEvent) {
                    if (aDEvent == null) {
                        return;
                    }
                    BluedADExtra bluedADExtra = (BluedADExtra) aDEvent.a(BluedADExtra.class);
                    int type = aDEvent.getType();
                    if (type != 100) {
                        if (type == 103) {
                            Log.v("adx", "上报show_url曝光埋点");
                            FindHttpUtils.b(bluedADExtra.show_url);
                            return;
                        }
                        switch (type) {
                            case 105:
                                Log.v("adx", "上报click_url点击埋点");
                                FindHttpUtils.b(bluedADExtra.click_url);
                                return;
                            case 106:
                                Log.v("adx", "上报hidden_url关闭埋点");
                                FindHttpUtils.b(bluedADExtra.hidden_url);
                                if ("15".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
                                    BannerADView.this.p.removeAllViews();
                                    BannerADView.this.p.setVisibility(8);
                                    BannerADView.this.b();
                                    return;
                                }
                                return;
                            case 107:
                                BannerADView.this.b();
                                return;
                            default:
                                return;
                        }
                    }
                    BannerADView.this.d();
                    if ("0".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
                        BannerADView.this.p.removeAllViews();
                        BannerADView.this.p.setVisibility(8);
                        BannerADView.this.y.setVisibility(8);
                        BannerADView.this.a(bluedADExtra);
                        return;
                    }
                    BannerADView.this.n.setVisibility(8);
                    BannerADView.this.y.setVisibility(8);
                    BannerADView.this.p.removeAllViews();
                    BannerADView.this.p.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = BannerADView.this.p.getLayoutParams();
                    layoutParams.height = -2;
                    BannerADView.this.p.setLayoutParams(layoutParams);
                    NativeExpressADView a2 = bluedADExtra.baseNativeExpressAd.a();
                    if (a2 != null) {
                        BannerADView.this.p.addView(a2);
                        a2.render();
                        return;
                    }
                    Log.v("adx", "快手广告容易在绘制的时候 广告控件被回收，导致无法展示");
                    BannerADView.this.b();
                }
            });
        }
        this.K.a(j, adxConfig.type, adxConfig.parallel_num);
        this.K.a((ArrayList) this.f28323c);
    }

    private void a(View view) {
        this.z = (ImageView) view.findViewById(R.id.img_tt_cover);
        this.A = (TextView) view.findViewById(R.id.tv_tt_title);
        this.B = (TextView) view.findViewById(R.id.tv_tt_ad);
        this.C = (TextView) view.findViewById(R.id.tv_tt_desc);
        this.D = (ImageView) view.findViewById(R.id.img_tt_ad_close);
        this.E = (TextView) view.findViewById(R.id.tv_click_area);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedADExtra bluedADExtra) {
        if (!StringUtils.d(bluedADExtra.ads_pics)) {
            this.E.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$d1DtgI47pOi-dv9zGEv92bRfQrg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BannerADView.this.d(view);
                }
            });
            a(bluedADExtra, DensityUtils.b(this.f28322a, AppInfo.l) - 20, new AnonymousClass8(bluedADExtra));
            return;
        }
        Log.v("drb", "banner1直客广告 图片资源为空，开始展示下一个");
        if (this.f28323c.size() > 0) {
            this.f28323c.remove(0);
            a();
        }
    }

    private void a(final BluedADExtra bluedADExtra, int i) {
        if (bluedADExtra == null) {
            b();
            return;
        }
        Log.v("drb", "banner2  adms_type:" + bluedADExtra.adms_type + " -- third_id:" + bluedADExtra.third_id);
        d();
        this.v.setVisibility(0);
        if ("3".equalsIgnoreCase(bluedADExtra.adms_type)) {
            this.t.setADData(bluedADExtra);
            e(bluedADExtra, null);
        } else if ("4".equalsIgnoreCase(bluedADExtra.adms_type)) {
            this.t.setADData(bluedADExtra);
            i(bluedADExtra, null);
        } else if (!"6".equalsIgnoreCase(bluedADExtra.adms_type)) {
            if ("7".equalsIgnoreCase(bluedADExtra.adms_type)) {
                if (StringUtils.d(bluedADExtra.ads_pics)) {
                    b();
                    return;
                }
                this.E.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$wsKqM8u-z-90hQdje2qB-9xPRVc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BannerADView.this.c(view);
                    }
                });
                this.t.a(bluedADExtra, new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$VISwU4Ku26qmPWycDlawZL-MHuI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BannerADView.this.c(bluedADExtra, view);
                    }
                });
                a(bluedADExtra, i, (BannerAdListener) null);
            } else if (StringUtils.d(bluedADExtra.ads_pics)) {
                b();
            } else {
                this.E.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$AkO8DwbaGtES1kn3Lf5Yw2kWcj0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BannerADView.this.b(view);
                    }
                });
                this.t.a(bluedADExtra, new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$IJX9Y5Yp2lKPU09cW7WSGhgDx3E
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BannerADView.this.b(bluedADExtra, view);
                    }
                });
                a(bluedADExtra, i, (BannerAdListener) null);
            }
        } else {
            if (!bluedADExtra.topRequestSet.contains(Long.valueOf(bluedADExtra.ads_id))) {
                bluedADExtra.topRequestSet.add(Long.valueOf(bluedADExtra.ads_id));
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.OPEN_AD_REQUEST, bluedADExtra);
            }
            this.t.setADData(bluedADExtra);
            bluedADExtra.bannerWidthUnitDP = i;
            if (bluedADExtra.third_style_view == 1) {
                d(bluedADExtra, new BannerAdListener() { // from class: com.soft.blued.customview.BannerADView.9
                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a() {
                        EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.OPEN_AD_RETURN_SUCCESS, bluedADExtra);
                    }

                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a(int i2, String str) {
                        LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.OPEN_AD_RETURN_FAIL;
                        BluedADExtra bluedADExtra2 = bluedADExtra;
                        EventTrackLoginAndRegister.a(event, bluedADExtra2, str, i2 + "");
                    }
                });
            } else if (bluedADExtra.third_style_view == 2) {
                b(bluedADExtra, new BannerAdListener() { // from class: com.soft.blued.customview.BannerADView.10
                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a() {
                        EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.OPEN_AD_RETURN_SUCCESS, bluedADExtra);
                    }

                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a(int i2, String str) {
                        LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.OPEN_AD_RETURN_FAIL;
                        BluedADExtra bluedADExtra2 = bluedADExtra;
                        EventTrackLoginAndRegister.a(event, bluedADExtra2, str, i2 + "");
                    }
                });
            } else {
                Log.v("drb", "banner2 topon广告类型传入错误：" + bluedADExtra.third_style_view);
            }
        }
    }

    private void a(BluedADExtra bluedADExtra, int i, BannerAdListener bannerAdListener) {
        Log.v("drb", "调用直客方法 showBluedAD");
        this.n.setVisibility(0);
        this.y.setVisibility(8);
        this.p.setVisibility(8);
        this.G.setVisibility(8);
        UnifiedBannerView unifiedBannerView = this.I;
        if (unifiedBannerView != null) {
            unifiedBannerView.setVisibility(8);
            this.I.destroy();
        }
        ATBannerView aTBannerView = this.F;
        if (aTBannerView != null) {
            aTBannerView.setVisibility(8);
            this.F.destroy();
        }
        Log.v("adx", "**当前is_show_adm_icon字段为：" + bluedADExtra.is_show_adm_icon);
        if (bluedADExtra.is_show_adm_icon != 1) {
            Log.v("adx", "**隐藏广告标识**");
            this.k.setVisibility(8);
            this.l.setVisibility(8);
        } else if ("7".equalsIgnoreCase(bluedADExtra.adms_type)) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
        } else {
            Log.v("adx", "**展示广告标识**");
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        }
        ImageSize imageSize = new ImageSize();
        ImageFileLoader.a(this.g).a(bluedADExtra.ads_pics).a(imageSize).a(new AnonymousClass13(bluedADExtra, imageSize, i, bannerAdListener)).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BluedADExtra bluedADExtra, View view) {
        Tracker.onClick(view);
        ADClosePopOptionsUtils.a(this.f28322a, bluedADExtra, this.D, this.w, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$8Eu9R-8DoM-pG5rnRWeLHQptD5U
            @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
            public final void onRemoved() {
                BannerADView.this.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedADExtra bluedADExtra, TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setExpressInteractionListener(new AnonymousClass16(bluedADExtra));
    }

    private void a(final BluedADExtra bluedADExtra, final BannerAdListener bannerAdListener, BannerAdManager bannerAdManager) {
        String str = this.w == ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER ? "b63c0c6b8c390f" : bluedADExtra.third_id;
        Log.v("drb", "bannerPosition:" + this.w + " -- third_id:" + str);
        bannerAdManager.a(this.f28322a, str, new BannerAdListenerAdapter() { // from class: com.soft.blued.customview.BannerADView.7
            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void a() {
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void a(int i, String str2) {
                if (BannerADView.this.u != null && BannerADView.this.g.isActive()) {
                    BannerADView.this.u.b();
                }
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.a(i, str2);
                }
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void b() {
                FindHttpUtils.b(bluedADExtra.click_url);
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void c() {
                BannerADView.this.b();
                if (BannerADView.this.u != null && BannerADView.this.g.isActive()) {
                    BannerADView.this.u.a();
                }
                FindHttpUtils.b(bluedADExtra.hidden_url);
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void d() {
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.a();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.f28323c.size() > 0) {
            BluedADExtra remove = this.f28323c.remove(0);
            Log.v("drb", str + remove.ads_id);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        this.t.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(BluedADExtra bluedADExtra, View view) {
        Tracker.onClick(view);
        Log.v("drb", "---------click:" + bluedADExtra.adm_type);
        if ("2".equals(bluedADExtra.adms_type) && AlipayUtils.a()) {
            WebViewShowInfoFragment.show(this.f28322a, bluedADExtra.deep_link_url, 9);
        } else if (b(bluedADExtra)) {
        } else {
            if (bluedADExtra.adm_type == 2) {
                BaseADVideoFragment.a(this.f28322a, bluedADExtra, 1);
            } else if (TextUtils.isEmpty(bluedADExtra.deep_link_url)) {
                WebViewShowInfoFragment.show(this.f28322a, bluedADExtra.target_url, 9);
            } else {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(bluedADExtra.deep_link_url));
                if (AppUtils.a(intent)) {
                    this.f28322a.startActivity(intent);
                } else {
                    WebViewShowInfoFragment.show(this.f28322a, bluedADExtra.target_url, 9);
                }
            }
        }
    }

    private void b(BluedADExtra bluedADExtra, BannerAdListener bannerAdListener) {
        this.n.setVisibility(8);
        this.y.setVisibility(8);
        this.p.setVisibility(8);
        UnifiedBannerView unifiedBannerView = this.I;
        if (unifiedBannerView != null) {
            unifiedBannerView.setVisibility(8);
            this.I.destroy();
        }
        BannerView bannerView = this.H;
        if (bannerView != null) {
            bannerView.setVisibility(8);
            this.H.destroy();
        }
        if (this.w == ADConstants.AD_POSITION.NEARBY_HOME_TOP) {
            if (bluedADExtra.topShowSet.contains(Long.valueOf(bluedADExtra.ads_id))) {
                Log.v("drb", "banner1 信息流广告已经加载过一次，本次不加载");
                return;
            }
            TopNativeTemplateManager topNativeTemplateManager = new TopNativeTemplateManager(this.G, bluedADExtra);
            bluedADExtra.topShowSet.add(Long.valueOf(bluedADExtra.ads_id));
            a(bluedADExtra, bannerAdListener, topNativeTemplateManager);
            Log.v("drb", "banner1 信息流广告加载广告");
        } else if (this.w == ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER) {
            if (this.e == null) {
                this.e = new TopNativeTemplateManager(this.G, bluedADExtra);
            }
            a(bluedADExtra, bannerAdListener, this.e);
            Log.v("drb", "banner2 宫格 信息流广告加载广告");
        } else if (this.w == ADConstants.AD_POSITION.NEARBY_HOME_LIST_BANNER) {
            if (this.d == null) {
                this.d = new TopNativeTemplateManager(this.G, bluedADExtra);
            }
            a(bluedADExtra, bannerAdListener, this.d);
            Log.v("drb", "banner2 列表 信息流广告加载广告");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(BluedADExtra bluedADExtra) {
        if (bluedADExtra.wx == null || TextUtils.isEmpty(bluedADExtra.wx.id) || TextUtils.isEmpty(bluedADExtra.wx.path)) {
            return false;
        }
        if (bluedADExtra.wx.is_popup != 1) {
            WeChatUtils.a(this.f28322a, bluedADExtra.wx.id, bluedADExtra.wx.path);
            return true;
        } else if (BDActivityManager.f34819a.a() != null) {
            Activity a2 = BDActivityManager.f34819a.a();
            if (a2 instanceof FragmentActivity) {
                AdMiniAppDialogFragment.a(((FragmentActivity) a2).getSupportFragmentManager(), bluedADExtra.wx.id, bluedADExtra.wx.path, bluedADExtra);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private ATBannerView c(final BluedADExtra bluedADExtra, final BannerAdListener bannerAdListener) {
        ATBannerView aTBannerView = this.F;
        if (aTBannerView != null) {
            return aTBannerView;
        }
        if (this.w == ADConstants.AD_POSITION.FEED_DETAILS) {
            bluedADExtra.third_id = "b63901578de9d5";
        }
        this.F = (ATBannerView) new TOPBannerManager().a(this.f28322a, bluedADExtra.third_id, bluedADExtra.bannerWidthUnitDP, new BannerAdListenerAdapter() { // from class: com.soft.blued.customview.BannerADView.11

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.soft.blued.customview.BannerADView$11$1  reason: invalid class name */
            /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BannerADView$11$1.class */
            public class AnonymousClass1 implements View.OnClickListener {
                AnonymousClass1() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void a() {
                    BannerADView.this.b();
                    if (BannerADView.this.u == null || !BannerADView.this.g.isActive()) {
                        return;
                    }
                    BannerADView.this.u.a();
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    ADClosePopOptionsUtils.a(BannerADView.this.f28322a, bluedADExtra, BannerADView.this.v, BannerADView.this.w, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$11$1$snDMoasMH1Yf5o6EKtJX2R9C92E
                        @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
                        public final void onRemoved() {
                            BannerADView.AnonymousClass11.AnonymousClass1.this.a();
                        }
                    });
                }
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void a() {
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void a(int i, String str) {
                if (BannerADView.this.u != null && BannerADView.this.g.isActive()) {
                    BannerADView.this.u.b();
                }
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.a(i, str);
                }
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void b() {
                FindHttpUtils.b(bluedADExtra.click_url);
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void c() {
                if (BannerADView.this.F != null && BannerADView.this.F.getParent() != null) {
                    ((ViewGroup) BannerADView.this.F.getParent()).removeView(BannerADView.this.F);
                }
                Log.v("anythink", "onBannerClose");
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void d() {
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.a();
                }
                BannerADView.this.v.setVisibility(0);
                BannerADView.this.v.setOnClickListener(new AnonymousClass1());
                Log.v("anythink", "onBannerShow");
            }
        });
        this.p.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
        layoutParams.height = -2;
        this.p.setLayoutParams(layoutParams);
        this.p.addView(this.F, new FrameLayout.LayoutParams(-1, -2));
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        this.t.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final BluedADExtra bluedADExtra) {
        TTFeedAd tTFeedAd = this.x;
        if (tTFeedAd == null || tTFeedAd.getImageList() == null || this.x.getImageList().isEmpty()) {
            b();
            return;
        }
        this.D.setVisibility(0);
        this.v.setVisibility(0);
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$YHkVfiGDbKnVJXCRvk5uI5REQiU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerADView.this.a(bluedADExtra, view);
            }
        });
        TTImage tTImage = this.x.getImageList().get(0);
        Log.v("drb", "image url:" + tTImage.getImageUrl());
        if (tTImage != null) {
            final ImageSize imageSize = new ImageSize();
            ImageFileLoader.a(this.g).a(tTImage.getImageUrl()).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.customview.BannerADView.18
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public void onUIFinish(File file, Exception exc) {
                    if (file == null || !file.exists()) {
                        if (BannerADView.this.u == null || !BannerADView.this.g.isActive()) {
                            return;
                        }
                        BannerADView.this.u.b();
                        return;
                    }
                    BannerADView.this.y.setVisibility(0);
                    float a2 = imageSize.a();
                    float b = imageSize.b();
                    Log.v("drb", "imgWidth:" + a2);
                    Log.v("drb", "imgHeight:" + b);
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) BannerADView.this.z.getLayoutParams();
                    layoutParams.width = (int) ((((float) layoutParams.height) * a2) / b);
                    BannerADView.this.z.setLayoutParams(layoutParams);
                    Log.v("drb", "imglp.width:" + layoutParams.width);
                    ImageLoader.a(BannerADView.this.g, file).a(BannerADView.this.q).b(2131231620).a(BannerADView.this.z);
                }
            }).a();
        }
        this.A.setText(this.x.getTitle());
        this.C.setText(this.x.getDescription());
        TTFeedAd tTFeedAd2 = this.x;
        if (tTFeedAd2 != null) {
            tTFeedAd2.registerViewForInteraction(this.y, this.E, new TTNativeAd.AdInteractionListener() { // from class: com.soft.blued.customview.BannerADView.19
                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                    FindHttpUtils.b(bluedADExtra.click_url);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                    FindHttpUtils.b(bluedADExtra.click_url);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdShow(TTNativeAd tTNativeAd) {
                    FindHttpUtils.b(bluedADExtra.show_url);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(BluedADExtra bluedADExtra, View view) {
        Tracker.onClick(view);
        Log.v("drb", "---------click:" + bluedADExtra.adm_type);
        WebViewShowInfoFragment.show(this.f28322a, bluedADExtra.target_url, 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Tracker.onClick(view);
        this.t.callOnClick();
    }

    private void d(BluedADExtra bluedADExtra, BannerAdListener bannerAdListener) {
        this.n.setVisibility(8);
        this.y.setVisibility(8);
        this.G.setVisibility(8);
        if (this.w != ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER && this.w != ADConstants.AD_POSITION.NEARBY_HOME_LIST_BANNER) {
            this.F = c(bluedADExtra, bannerAdListener);
            if (this.s) {
                this.s = false;
                int a2 = DensityUtils.a(this.f28322a, bluedADExtra.bannerWidthUnitDP);
                int round = Math.round(a2 / 4.0f);
                HashMap hashMap = new HashMap();
                hashMap.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(a2));
                hashMap.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(round));
                this.F.setLocalExtra(hashMap);
                this.F.loadAd();
                Log.v("drb", "banner1 topon Banner loadAd()");
                return;
            }
            return;
        }
        Log.v("drb", "banner2 topon first loadAd()");
        ATBannerView a3 = NearbyTopBannerManager.a().a(bluedADExtra.ads_id);
        a3.setBannerAdListener(a(bluedADExtra, bannerAdListener));
        this.p.setVisibility(0);
        this.p.removeAllViews();
        if (a3 != null && a3.getParent() != null) {
            ((ViewGroup) a3.getParent()).removeView(a3);
        }
        ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
        layoutParams.height = -2;
        this.p.setLayoutParams(layoutParams);
        this.p.addView(a3, new FrameLayout.LayoutParams(-1, -2));
        a3.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        b();
        this.y.setVisibility(8);
        if (this.x != null) {
            this.x = null;
        }
        if (this.u == null || !this.g.isActive()) {
            return;
        }
        this.u.a();
    }

    private void e(BluedADExtra bluedADExtra, BannerAdListener bannerAdListener) {
        this.n.setVisibility(8);
        this.y.setVisibility(8);
        this.G.setVisibility(8);
        UnifiedBannerView j = j(bluedADExtra, bannerAdListener);
        this.I = j;
        j.loadAD();
    }

    private void f(BluedADExtra bluedADExtra, BannerAdListener bannerAdListener) {
        this.n.setVisibility(8);
        this.y.setVisibility(8);
        this.G.setVisibility(8);
        this.H = g(bluedADExtra, bannerAdListener);
        this.H.loadAd(new AdParam.Builder().build());
    }

    private BannerView g(final BluedADExtra bluedADExtra, final BannerAdListener bannerAdListener) {
        BannerView bannerView = this.H;
        if (bannerView != null) {
            return bannerView;
        }
        this.H = (BannerView) new HWBannerManager().a(this.f28322a, bluedADExtra.third_id, new BannerAdListenerAdapter() { // from class: com.soft.blued.customview.BannerADView.14
            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void a(int i, String str) {
                if (BannerADView.this.u != null && BannerADView.this.g.isActive()) {
                    BannerADView.this.u.b();
                }
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.a(i, str);
                }
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void b() {
                FindHttpUtils.b(bluedADExtra.click_url);
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void c() {
                Log.v("drb", "华为banner广告 onAdClosed postSplashUrl");
                BannerADView.this.b();
                if (BannerADView.this.u != null && BannerADView.this.g.isActive()) {
                    BannerADView.this.u.a();
                }
                FindHttpUtils.b(bluedADExtra.hidden_url);
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void d() {
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.a();
                }
                FindHttpUtils.b(bluedADExtra.show_url);
            }
        });
        this.p.removeAllViews();
        ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
        layoutParams.height = -2;
        this.p.setLayoutParams(layoutParams);
        this.p.addView(this.H);
        this.p.setVisibility(0);
        return this.H;
    }

    private FrameLayout.LayoutParams getUnifiedBannerLayoutParams() {
        int a2 = AppInfo.l - DensityUtils.a(this.f28322a, 20.0f);
        return new FrameLayout.LayoutParams(a2, Math.round(a2 / 6.4f));
    }

    private void h(final BluedADExtra bluedADExtra, final BannerAdListener bannerAdListener) {
        this.n.setVisibility(8);
        this.y.setVisibility(8);
        this.G.setVisibility(8);
        UnifiedBannerView unifiedBannerView = this.I;
        if (unifiedBannerView != null) {
            unifiedBannerView.setVisibility(8);
            this.I.destroy();
        }
        BannerView bannerView = this.H;
        if (bannerView != null) {
            bannerView.setVisibility(8);
            this.H.destroy();
        }
        if (!this.r) {
            a(bluedADExtra, this.J);
            return;
        }
        this.r = false;
        new TTTemplateBannerManager().a(this.f28322a, bluedADExtra.third_id, new BannerAdListenerAdapter() { // from class: com.soft.blued.customview.BannerADView.15
            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void a(int i, String str) {
                Log.v("drb", "banner1穿山甲广告：onAdError");
                BannerADView.this.b();
                if (BannerADView.this.u != null && BannerADView.this.g.isActive()) {
                    BannerADView.this.u.b();
                }
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.a(i, str);
                }
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void a(TTNativeExpressAd tTNativeExpressAd) {
                Log.v("drb", "banner1穿山甲广告：onAdLoaded");
                BannerADView.this.J = tTNativeExpressAd;
                BannerADView bannerADView = BannerADView.this;
                bannerADView.a(bluedADExtra, bannerADView.J);
                try {
                    BannerADView.this.J.render();
                } catch (OutOfMemoryError e) {
                    MemoryRequest.a().b();
                }
            }
        });
    }

    private void i(final BluedADExtra bluedADExtra, final BannerAdListener bannerAdListener) {
        this.n.setVisibility(8);
        this.G.setVisibility(8);
        UnifiedBannerView unifiedBannerView = this.I;
        if (unifiedBannerView != null) {
            unifiedBannerView.setVisibility(8);
            this.I.destroy();
        }
        int a2 = DensityUtils.a(this.f28322a, 10.0f);
        int i = AnonymousClass21.f28347a[this.w.ordinal()];
        if (i == 1 || i == 2) {
            a2 = 0;
        }
        ConstraintLayout constraintLayout = this.y;
        constraintLayout.setPadding(a2, constraintLayout.getPaddingTop(), a2, this.y.getPaddingBottom());
        if (this.w == ADConstants.AD_POSITION.FEED_DETAILS) {
            bluedADExtra.third_id = "950594749";
        }
        if (bluedADExtra.ttShowSet.contains(Long.valueOf(bluedADExtra.ads_id))) {
            c(bluedADExtra);
            return;
        }
        bluedADExtra.ttShowSet.add(Long.valueOf(bluedADExtra.ads_id));
        new TTBannerManager().a(this.f28322a, bluedADExtra.third_id, new BannerAdListenerAdapter() { // from class: com.soft.blued.customview.BannerADView.17
            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void a(int i2, String str) {
                BannerADView.this.b();
                if (BannerADView.this.u != null && BannerADView.this.g.isActive()) {
                    BannerADView.this.u.b();
                }
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.a(i2, str);
                }
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void a(TTFeedAd tTFeedAd) {
                BannerADView.this.x = tTFeedAd;
                BannerADView.this.c(bluedADExtra);
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void d() {
                Log.v("drb", "banner2 穿山甲广告 曝光成功");
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.a();
                }
            }
        });
    }

    private UnifiedBannerView j(final BluedADExtra bluedADExtra, final BannerAdListener bannerAdListener) {
        UnifiedBannerView unifiedBannerView = this.I;
        if (unifiedBannerView != null) {
            return unifiedBannerView;
        }
        if (this.w == ADConstants.AD_POSITION.FEED_DETAILS) {
            bluedADExtra.third_id = "2094656821672498";
        }
        this.I = (UnifiedBannerView) new TXBannerManager().a(this.f28322a, bluedADExtra.third_id, new BannerAdListenerAdapter() { // from class: com.soft.blued.customview.BannerADView.20

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.soft.blued.customview.BannerADView$20$1  reason: invalid class name */
            /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BannerADView$20$1.class */
            public class AnonymousClass1 implements View.OnClickListener {
                AnonymousClass1() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void a() {
                    BannerADView.this.b();
                    if (BannerADView.this.u == null || !BannerADView.this.g.isActive()) {
                        return;
                    }
                    BannerADView.this.u.a();
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    ADClosePopOptionsUtils.a(BannerADView.this.f28322a, bluedADExtra, BannerADView.this.v, BannerADView.this.w, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$20$1$tULhTt4ySN_8_mwXRY0SJnDTfmY
                        @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
                        public final void onRemoved() {
                            BannerADView.AnonymousClass20.AnonymousClass1.this.a();
                        }
                    });
                }
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void a() {
                BannerADView.this.v.setVisibility(0);
                BannerADView.this.v.setOnClickListener(new AnonymousClass1());
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void a(int i, String str) {
                BannerADView.this.b();
                if (BannerADView.this.u != null && BannerADView.this.g.isActive()) {
                    BannerADView.this.u.b();
                }
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.a(i, str);
                }
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void b() {
                FindHttpUtils.b(bluedADExtra.click_url);
            }

            @Override // com.soft.blued.customview.banner.BannerAdListenerAdapter, com.soft.blued.customview.banner.BannerAdListener
            public void d() {
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.a();
                }
                FindHttpUtils.b(bluedADExtra.show_url);
            }
        });
        ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
        layoutParams.height = DensityUtils.a(this.f28322a, 84.0f);
        this.p.setLayoutParams(layoutParams);
        this.p.addView(this.I, getUnifiedBannerLayoutParams());
        this.p.setVisibility(0);
        return this.I;
    }

    public ATBannerListener a(final BluedADExtra bluedADExtra, final BannerAdListener bannerAdListener) {
        ATBannerListener aTBannerListener = this.f;
        if (aTBannerListener != null) {
            return aTBannerListener;
        }
        ATBannerListener aTBannerListener2 = new ATBannerListener() { // from class: com.soft.blued.customview.BannerADView.12

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.soft.blued.customview.BannerADView$12$1  reason: invalid class name */
            /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BannerADView$12$1.class */
            public class AnonymousClass1 implements View.OnClickListener {
                AnonymousClass1() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void a() {
                    BannerADView.this.b();
                    if (BannerADView.this.u == null || !BannerADView.this.g.isActive()) {
                        return;
                    }
                    BannerADView.this.u.a();
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    ADClosePopOptionsUtils.a(BannerADView.this.f28322a, bluedADExtra, BannerADView.this.v, BannerADView.this.w, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.customview.-$$Lambda$BannerADView$12$1$ffNX_4Lo7XWQ_3uIJgG_r1HwfHs
                        @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
                        public final void onRemoved() {
                            BannerADView.AnonymousClass12.AnonymousClass1.this.a();
                        }
                    });
                }
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerAutoRefreshFail(AdError adError) {
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerAutoRefreshed(ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerClicked(ATAdInfo aTAdInfo) {
                Log.v("drb", "banner2 onBannerClicked");
                FindHttpUtils.b(bluedADExtra.click_url);
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerClose(ATAdInfo aTAdInfo) {
                if (BannerADView.this.F != null && BannerADView.this.F.getParent() != null) {
                    ((ViewGroup) BannerADView.this.F.getParent()).removeView(BannerADView.this.F);
                }
                Log.v("drb", "banner2 onBannerClose");
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerFailed(AdError adError) {
                Log.v("drb", "banner2 onBannerFailed:" + adError.toString());
                if (BannerADView.this.u != null && BannerADView.this.g.isActive()) {
                    BannerADView.this.u.b();
                }
                try {
                    bannerAdListener.a(Integer.parseInt(adError.getCode()), adError.getDesc());
                } catch (Exception e) {
                }
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerLoaded() {
                Log.v("drb", "banner2 onBannerLoaded");
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerShow(ATAdInfo aTAdInfo) {
                bannerAdListener.a();
                BannerADView.this.v.setVisibility(0);
                BannerADView.this.v.setOnClickListener(new AnonymousClass1());
                Log.v("drb", "banner2 onBannerShow");
            }
        };
        this.f = aTBannerListener2;
        return aTBannerListener2;
    }

    public void a() {
        Log.v("drb", "bannerNext adList.size():" + this.f28323c.size());
        List<BluedADExtra> list = this.f28323c;
        if (list == null || list.size() <= 0) {
            b();
            return;
        }
        final BluedADExtra bluedADExtra = this.f28323c.get(0);
        d();
        LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_HOME_BANNER1_REQUEST;
        EventTrackLoginAndRegister.b(event, bluedADExtra.ads_id + "", bluedADExtra.adm_type_source);
        Log.v("drb", "当前banner1广告类型：" + bluedADExtra.adm_type_source + " -- 广告id:" + bluedADExtra.ads_id + " -- 广告third_id:" + bluedADExtra.third_id + " -- adExtra.adm_type:" + bluedADExtra.adm_type + " -- adExtra.third_style_view:" + bluedADExtra.third_style_view);
        if ("12".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
            if (c(bluedADExtra.adm_type)) {
                f(bluedADExtra, new BannerAdListener() { // from class: com.soft.blued.customview.BannerADView.2
                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a() {
                        Log.v("drb", "banner1华为广告展示成功");
                        BannerADView.this.t.setADData(bluedADExtra);
                        LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE;
                        EventTrackLoginAndRegister.b(event2, bluedADExtra.ads_id + "", bluedADExtra.adm_type_source);
                    }

                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a(int i, String str) {
                        BannerADView.this.a("banner1华为广告展示失败 -- 删除广告id:");
                        EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE_FAIL, bluedADExtra.ads_id + "", str, i + "", bluedADExtra.adm_type_source);
                    }
                });
                return;
            }
            a("banner1华为广告类型错误:" + bluedADExtra.adm_type);
        } else if ("3".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
            if (a(bluedADExtra.adm_type)) {
                a(bluedADExtra);
            } else if (c(bluedADExtra.adm_type)) {
                e(bluedADExtra, new BannerAdListener() { // from class: com.soft.blued.customview.BannerADView.3
                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a() {
                        Log.v("drb", "banner1广点通广告展示成功");
                        BannerADView.this.t.setADData(bluedADExtra);
                        LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE;
                        EventTrackLoginAndRegister.b(event2, bluedADExtra.ads_id + "", bluedADExtra.adm_type_source);
                    }

                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a(int i, String str) {
                        BannerADView.this.a("banner1广点通广告展示失败 -- 删除广告id:");
                        EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE_FAIL, bluedADExtra.ads_id + "", str, i + "", bluedADExtra.adm_type_source);
                    }
                });
            } else {
                a("banner1广点通广告类型错误:" + bluedADExtra.adm_type);
            }
        } else if ("4".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
            if (a(bluedADExtra.adm_type)) {
                a(bluedADExtra);
            } else if (c(bluedADExtra.adm_type)) {
                if (bluedADExtra.isShowUrlVisited) {
                    this.r = false;
                } else {
                    this.r = true;
                }
                h(bluedADExtra, new BannerAdListener() { // from class: com.soft.blued.customview.BannerADView.4
                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a() {
                        Log.v("drb", "banner1穿山甲广告展示成功");
                        BannerADView.this.t.setADData(bluedADExtra);
                        LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE;
                        EventTrackLoginAndRegister.b(event2, bluedADExtra.ads_id + "", bluedADExtra.adm_type_source);
                    }

                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a(int i, String str) {
                        BannerADView.this.a("banner1穿山甲广告展示失败 -- 删除广告id:");
                        EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE_FAIL, bluedADExtra.ads_id + "", str, i + "", bluedADExtra.adm_type_source);
                    }
                });
            } else {
                a("banner1穿山甲广告类型错误:" + bluedADExtra.adm_type);
            }
        } else if ("13".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
            if (a(bluedADExtra.adm_type)) {
                a(bluedADExtra);
                return;
            }
            a("banner1快手广告类型错误:" + bluedADExtra.adm_type);
        } else if (!"6".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
            if ("7".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
                if (c(bluedADExtra.adm_type)) {
                    a(bluedADExtra);
                    return;
                }
                a("banner1小米广告类型错误:" + bluedADExtra.adm_type);
            } else if (b(bluedADExtra.adm_type)) {
                a(bluedADExtra);
            } else {
                a("banner1直客广告类型错误:" + bluedADExtra.adm_type);
            }
        } else if (a(bluedADExtra.adm_type)) {
            a(bluedADExtra);
        } else if (!c(bluedADExtra.adm_type)) {
            a("banner1topon广告类型错误:" + bluedADExtra.adm_type);
        } else {
            this.s = true;
            if (bluedADExtra.third_style_view == 1) {
                bluedADExtra.bannerWidthUnitDP = DensityUtils.b(this.f28322a, AppInfo.l) - 24;
                d(bluedADExtra, new BannerAdListener() { // from class: com.soft.blued.customview.BannerADView.5
                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a() {
                        Log.v("drb", "banner1topon广告展示成功");
                        BannerADView.this.t.setADData(bluedADExtra);
                        LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE;
                        EventTrackLoginAndRegister.b(event2, bluedADExtra.ads_id + "", bluedADExtra.adm_type_source);
                    }

                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a(int i, String str) {
                        BannerADView.this.a("banner1topon广告展示失败 -- 删除广告id:");
                        EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE_FAIL, bluedADExtra.ads_id + "", str, i + "", bluedADExtra.adm_type_source);
                    }
                });
            } else if (bluedADExtra.third_style_view == 2) {
                b(bluedADExtra, new BannerAdListener() { // from class: com.soft.blued.customview.BannerADView.6
                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a() {
                        Log.v("drb", "banner1topon广告展示成功");
                        LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE;
                        EventTrackLoginAndRegister.b(event2, bluedADExtra.ads_id + "", bluedADExtra.adm_type_source);
                    }

                    @Override // com.soft.blued.customview.BannerADView.BannerAdListener
                    public void a(int i, String str) {
                        BannerADView.this.a("banner1topon广告展示失败 -- 删除广告id:");
                        EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.AD_HOME_BANNER1_RESPONSE_FAIL, bluedADExtra.ads_id + "", str, i + "", bluedADExtra.adm_type_source);
                    }
                });
            } else {
                a("banner1topon广告类型错误:" + bluedADExtra.adm_type);
            }
        }
    }

    public void a(Context context, AttributeSet attributeSet) {
        this.f28322a = context;
        ImageOptions imageOptions = new ImageOptions();
        this.q = imageOptions;
        imageOptions.f9507a = 2131231620;
        this.q.f9508c = 2131231620;
        View inflate = LayoutInflater.from(this.f28322a).inflate(R.layout.ad_banner_layout, this);
        this.b = inflate;
        this.G = (ATNativeAdView) inflate.findViewById(2131361988);
        this.h = this.b.findViewById(2131370746);
        this.i = (ImageView) this.b.findViewById(2131364414);
        this.j = (ImageView) this.b.findViewById(R.id.img_ad_close);
        this.k = (ImageView) this.b.findViewById(2131364417);
        this.l = (TextView) this.b.findViewById(R.id.tv_ad_icon);
        this.m = this.b.findViewById(R.id.btm_line);
        this.n = this.b.findViewById(R.id.fl_blued_ad);
        this.o = (CardView) this.b.findViewById(R.id.fl_ad_content);
        this.p = (LinearLayout) this.b.findViewById(R.id.ll_third_ad);
        this.y = (ConstraintLayout) this.b.findViewById(R.id.fl_tt_banner);
        this.t = (BluedADConstraintLayout) this.b.findViewById(R.id.ad_view_layout);
        this.v = this.b.findViewById(R.id.tv_transparent_close);
        a(this.b);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.f28322a.obtainStyledAttributes(attributeSet, R.styleable.BannerADView);
            boolean z = obtainStyledAttributes.getBoolean(2, false);
            boolean z2 = obtainStyledAttributes.getBoolean(1, false);
            float dimension = obtainStyledAttributes.getDimension(0, 0.0f);
            obtainStyledAttributes.recycle();
            if (z) {
                this.h.setVisibility(0);
            }
            if (z2) {
                this.m.setVisibility(0);
            }
            if (dimension > 0.0f) {
                this.o.setRadius(dimension);
            }
        }
        b();
    }

    public void a(IRequestHost iRequestHost, BluedADExtra bluedADExtra, ADConstants.AD_POSITION ad_position, ADListener aDListener) {
        if (FlexDebugSevConfig.a().b().android_forbidden_banner2_ad == 1) {
            b();
            return;
        }
        this.u = aDListener;
        this.w = ad_position;
        bluedADExtra.bannerPosition = ad_position;
        this.g = iRequestHost;
        int b = (ad_position == ADConstants.AD_POSITION.USER_PROFILE_TAB || ad_position == ADConstants.AD_POSITION.NEARBY_HOME_TOP) ? DensityUtils.b(this.f28322a, AppInfo.l) - 20 : ad_position == ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER ? DensityUtils.b(this.f28322a, AppInfo.l) - 6 : DensityUtils.b(this.f28322a, AppInfo.l);
        if (bluedADExtra.isShowUrlVisited) {
            this.r = false;
        } else {
            this.r = true;
        }
        Log.v("drb", "showAD banner2广告：position:" + ad_position + " -- " + bluedADExtra.isShowUrlVisited);
        if (bluedADExtra.isShowUrlVisited) {
            this.s = false;
        } else {
            this.s = true;
        }
        a(bluedADExtra, b);
    }

    public void a(IRequestHost iRequestHost, BannerAdExtra bannerAdExtra, ADListener aDListener) {
        if (FlexDebugSevConfig.a().b().android_forbidden_banner1_ad == 1) {
            b();
            return;
        }
        this.g = iRequestHost;
        this.f28323c = bannerAdExtra.data;
        this.u = aDListener;
        this.w = ADConstants.AD_POSITION.NEARBY_HOME_TOP;
        if (bannerAdExtra.connect_type == 1) {
            a(bannerAdExtra.position_code, bannerAdExtra.serial_parallel, bannerAdExtra.timeout);
            return;
        }
        Collections.sort(this.f28323c);
        a();
    }

    @Override // com.soft.blued.utils.AdBannerTestObserve
    public void a(BluedADExtra bluedADExtra, ADConstants.AD_POSITION ad_position, ADListener aDListener) {
        a(this.g, bluedADExtra, ad_position, aDListener);
    }

    @Override // com.soft.blued.utils.AdBannerTestObserve
    public void a(BannerAdExtra bannerAdExtra, ADListener aDListener) {
        a(this.g, bannerAdExtra, aDListener);
    }

    public boolean a(int i) {
        return 2 == i;
    }

    public void b() {
        this.v.setVisibility(8);
        setVisibility(8);
    }

    public boolean b(int i) {
        return 1 == i;
    }

    public void c() {
        UnifiedBannerView unifiedBannerView = this.I;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
        ATBannerView aTBannerView = this.F;
        if (aTBannerView != null) {
            aTBannerView.destroy();
        }
        TTFeedAd tTFeedAd = this.x;
        if (tTFeedAd != null) {
            tTFeedAd.destroy();
        }
        TTNativeExpressAd tTNativeExpressAd = this.J;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    public boolean c(int i) {
        return 4 == i;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setRadius(float f) {
        if (f > 0.0f) {
            this.o.setRadius(DensityUtils.a(this.f28322a, f));
        }
    }
}
