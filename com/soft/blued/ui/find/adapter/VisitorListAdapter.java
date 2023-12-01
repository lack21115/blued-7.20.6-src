package com.soft.blued.ui.find.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.nativead.api.ATNative;
import com.anythink.nativead.api.ATNativeAdView;
import com.anythink.nativead.api.ATNativeEventListener;
import com.anythink.nativead.api.ATNativeNetworkListener;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.api.NativeAd;
import com.anythink.network.gdt.GDTATConst;
import com.anythink.network.toutiao.TTATConst;
import com.blued.ad.ADConstants;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.adx.banner.AdxNativeUnifiedManager;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.adx.blued.unified.BluedNativeAdDataAdapter;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.das.login.LoginAndRegisterProtos;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.nativead.MediaView;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdLoader;
import com.huawei.hms.ads.nativead.NativeView;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.customview.BluedADConstraintLayout;
import com.soft.blued.customview.SelfRenderViewUtil;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.ab_test.models.AdxConfig;
import com.soft.blued.ui.find.adapter.VisitorListAdapter;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import com.soft.blued.ui.find.viewholder.VisitorViewHolder;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.utils.ADClosePopOptionsUtils;
import com.soft.blued.utils.HWAppDownloadStyle;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.third.TTADUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorListAdapter.class */
public class VisitorListAdapter extends BaseAdapter {

    /* renamed from: c  reason: collision with root package name */
    private static int f30155c = 13;
    private Context d;
    private IRequestHost e;
    private LayoutInflater f;
    private int h;
    private LoadOptions j;
    private String k;
    private ATNative l;
    private ConcurrentHashMap<String, NativeAd> m;
    private int n;
    private int o;
    private int p;
    private int q;
    private List<BluedMyVisitorList> g = new ArrayList();
    private int i = 0;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30156a = false;
    public List<String> b = new ArrayList();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorListAdapter$AdViewHolder.class */
    class AdViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public BannerADView f30161a;

        /* renamed from: c  reason: collision with root package name */
        private BluedMyVisitorList f30162c;
        private int d;

        public AdViewHolder(View view) {
            this.f30161a = (BannerADView) view.findViewById(R.id.banner_ad);
        }

        public void a(final BluedMyVisitorList bluedMyVisitorList, int i) {
            this.f30162c = bluedMyVisitorList;
            this.d = i;
            this.f30161a.a(VisitorListAdapter.this.e, bluedMyVisitorList, ADConstants.AD_POSITION.VISITOR_BANNER, new BannerADView.ADListener() { // from class: com.soft.blued.ui.find.adapter.VisitorListAdapter.AdViewHolder.1
                @Override // com.soft.blued.customview.BannerADView.ADListener
                public void a() {
                    VisitorListAdapter.this.g.remove(bluedMyVisitorList);
                    VisitorListAdapter.this.notifyDataSetChanged();
                }

                @Override // com.soft.blued.customview.BannerADView.ADListener
                public void b() {
                    VisitorListAdapter.this.g.remove(bluedMyVisitorList);
                    VisitorListAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorListAdapter$HWOriginADViewHolder.class */
    public class HWOriginADViewHolder {
        private ImageView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f30165c;
        private ImageView d;
        private TextView e;
        private TextView f;
        private MediaView g;
        private TextView h;
        private ViewGroup i;
        private NativeView j;
        private View k;
        private BluedMyVisitorList l;
        private int m;
        private BluedADConstraintLayout n;

        public HWOriginADViewHolder(View view) {
            this.d = (ImageView) view.findViewById(2131364232);
            this.b = (ImageView) view.findViewById(R.id.img_style_1_ad_icon);
            this.f30165c = (ImageView) view.findViewById(R.id.img_style_2_ad_icon);
            this.e = (TextView) view.findViewById(2131368652);
            this.f = (TextView) view.findViewById(2131371262);
            this.g = (MediaView) view.findViewById(R.id.ad_media);
            this.h = (TextView) view.findViewById(R.id.native_ad_install_btn);
            this.i = (ViewGroup) view.findViewById(R.id.cl_download_layout);
            this.j = (NativeView) view.findViewById(R.id.hw_native_view);
            this.n = (BluedADConstraintLayout) view.findViewById(2131363859);
            this.k = view.findViewById(2131364488);
        }

        public void a() {
            this.b.setVisibility(0);
            this.f30165c.setVisibility(0);
            this.j.setTitleView(this.e);
            this.j.setMediaView(this.g);
            this.j.setAdSourceView(this.f);
            this.j.setCallToActionView(this.h);
            this.j.setIconView(this.d);
            if (this.l.hwNativeAd == null) {
                this.n.setVisibility(8);
                return;
            }
            this.n.setVisibility(0);
            int creativeType = this.l.hwNativeAd.getCreativeType();
            if (creativeType == 103 || creativeType == 106) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
            this.f30165c.setImageResource(2131233444);
            ImageLoader.a(VisitorListAdapter.this.e, (this.l.hwNativeAd.getIcon() == null || this.l.hwNativeAd.getIcon().getUri() == null) ? "" : this.l.hwNativeAd.getIcon().getUri().toString()).b(2131237310).c().a(this.d);
            ((TextView) this.j.getTitleView()).setText(this.l.hwNativeAd.getAdSource());
            this.j.getMediaView().setMediaContent(this.l.hwNativeAd.getMediaContent());
            if (this.l.hwNativeAd.getAdSource() != null) {
                ((TextView) this.j.getAdSourceView()).setText(this.l.hwNativeAd.getTitle());
            }
            this.j.getAdSourceView().setVisibility(this.l.hwNativeAd.getAdSource() != null ? 0 : 4);
            if (this.l.hwNativeAd.getCallToAction() != null) {
                ((TextView) this.j.getCallToActionView()).setText(this.l.hwNativeAd.getCallToAction());
            }
            this.j.setNativeAd(this.l.hwNativeAd);
            AppDownloadButton appDownloadButton = (AppDownloadButton) this.j.findViewById(R.id.app_download_btn);
            appDownloadButton.setAppDownloadButtonStyle(new HWAppDownloadStyle(VisitorListAdapter.this.d));
            if (this.j.register(appDownloadButton)) {
                appDownloadButton.setVisibility(0);
                appDownloadButton.refreshAppStatus();
                this.j.getCallToActionView().setVisibility(8);
            } else {
                appDownloadButton.setVisibility(8);
                this.j.getCallToActionView().setVisibility(0);
            }
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.VisitorListAdapter.HWOriginADViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    Log.v("drb", "closeView onClick");
                    if (HWOriginADViewHolder.this.l.can_close == 1) {
                        Context context = VisitorListAdapter.this.d;
                        BluedMyVisitorList bluedMyVisitorList = HWOriginADViewHolder.this.l;
                        View view2 = HWOriginADViewHolder.this.k;
                        ADConstants.AD_POSITION ad_position = ADConstants.AD_POSITION.VISITOR_ORIGIN;
                        final HWOriginADViewHolder hWOriginADViewHolder = HWOriginADViewHolder.this;
                        ADClosePopOptionsUtils.a(context, bluedMyVisitorList, view2, ad_position, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$qilCK-2NE0UIoqDTezSPokM59eQ
                            @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
                            public final void onRemoved() {
                                VisitorListAdapter.HWOriginADViewHolder.this.b();
                            }
                        });
                    }
                }
            });
        }

        public void a(BluedMyVisitorList bluedMyVisitorList, int i) {
            this.l = bluedMyVisitorList;
            this.m = i;
            a();
        }

        public void b() {
            if (this.m < VisitorListAdapter.this.g.size()) {
                VisitorListAdapter.this.g.remove(this.m);
            }
            VisitorListAdapter.this.notifyDataSetChanged();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorListAdapter$KSOriginADViewHolder.class */
    class KSOriginADViewHolder extends NativeAdViewHolder {
        private ImageView o;
        private ImageView p;

        public KSOriginADViewHolder(View view) {
            super(view);
            this.o = (ImageView) view.findViewById(R.id.img_style_1_ad_icon);
            this.p = (ImageView) view.findViewById(R.id.img_style_2_ad_icon);
        }

        @Override // com.soft.blued.ui.find.adapter.VisitorListAdapter.NativeAdViewHolder
        public void a() {
            super.a();
            this.o.setVisibility(0);
            this.p.setVisibility(0);
        }

        @Override // com.soft.blued.ui.find.adapter.VisitorListAdapter.NativeAdViewHolder
        public void a(final BluedMyVisitorList bluedMyVisitorList, int i) {
            super.a(bluedMyVisitorList, i);
            this.g.a(bluedMyVisitorList, new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$VisitorListAdapter$KSOriginADViewHolder$Q18XspdUsATf20QhQPdeK-QKeng
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                }
            });
            this.o.setImageResource(2131233453);
            this.p.setImageResource(2131233453);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.g);
            if (bluedMyVisitorList.ksNativeAd != null) {
                bluedMyVisitorList.ksNativeAd.registerViewForInteraction((Activity) VisitorListAdapter.this.d, this.g, arrayList, new KsNativeAd.AdInteractionListener() { // from class: com.soft.blued.ui.find.adapter.VisitorListAdapter.KSOriginADViewHolder.1
                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                        return false;
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdClicked(View view, KsNativeAd ksNativeAd) {
                        FindHttpUtils.b(bluedMyVisitorList.click_url);
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdShow(KsNativeAd ksNativeAd) {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogShow() {
                    }
                });
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorListAdapter$MIOriginADViewHolder.class */
    class MIOriginADViewHolder extends NativeAdViewHolder {
        private ImageView o;
        private ImageView p;

        public MIOriginADViewHolder(View view) {
            super(view);
            this.o = (ImageView) view.findViewById(R.id.img_style_1_ad_icon);
            this.p = (ImageView) view.findViewById(R.id.img_style_2_ad_icon);
        }

        @Override // com.soft.blued.ui.find.adapter.VisitorListAdapter.NativeAdViewHolder
        public void a() {
            super.a();
            this.o.setVisibility(0);
            this.p.setVisibility(0);
        }

        @Override // com.soft.blued.ui.find.adapter.VisitorListAdapter.NativeAdViewHolder
        public void a(BluedMyVisitorList bluedMyVisitorList, int i) {
            super.a(bluedMyVisitorList, i);
            this.o.setImageResource(R.drawable.icon_xiaomi_ad_icon);
            this.p.setImageResource(R.drawable.icon_xiaomi_ad_icon);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorListAdapter$NativeAdViewHolder.class */
    public class NativeAdViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private BluedMyVisitorList f30170a;
        public LinearLayout b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f30171c;
        public TextView d;
        public ImageView e;
        public TextView f;
        public BluedADConstraintLayout g;
        public ImageView h;
        ImageView i;
        ImageView j;
        ConstraintLayout k;
        ConstraintLayout l;
        ViewGroup m;
        private int o;

        public NativeAdViewHolder(View view) {
            this.b = (LinearLayout) view.findViewById(R.id.layout_native_ad);
            this.f30171c = (ImageView) view.findViewById(2131364232);
            this.d = (TextView) view.findViewById(2131368652);
            this.e = (ImageView) view.findViewById(2131364488);
            this.f = (TextView) view.findViewById(2131371262);
            this.g = (BluedADConstraintLayout) view.findViewById(2131363859);
            this.h = (ImageView) view.findViewById(R.id.iv_resource);
            this.i = (ImageView) view.findViewById(R.id.img_style_1_ad_icon);
            this.j = (ImageView) view.findViewById(R.id.img_style_2_ad_icon);
            this.k = (ConstraintLayout) view.findViewById(R.id.cl_style_1);
            this.l = (ConstraintLayout) view.findViewById(R.id.cl_style_2);
            this.m = (ViewGroup) view.findViewById(2131363153);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            Tracker.onClick(view);
            ADClosePopOptionsUtils.a(VisitorListAdapter.this.d, this.f30170a, this.e, ADConstants.AD_POSITION.VISITOR_ORIGIN, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$VisitorListAdapter$NativeAdViewHolder$qPbFDSVbrac3B5xH6PbWEH_fq7w
                @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
                public final void onRemoved() {
                    VisitorListAdapter.NativeAdViewHolder.this.b();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.o < VisitorListAdapter.this.g.size()) {
                VisitorListAdapter.this.g.remove(this.o);
            }
            VisitorListAdapter.this.notifyDataSetChanged();
        }

        public void a() {
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            this.g.setADData(this.f30170a);
            ImageLoader.a(VisitorListAdapter.this.e, this.f30170a.avatar).b(2131237310).c().a(this.f30171c);
            this.d.setText(this.f30170a.name);
            this.f.setText(this.f30170a.description);
            if (this.f30170a.can_close == 1) {
                this.e.setVisibility(0);
                this.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$VisitorListAdapter$NativeAdViewHolder$LMEfSZKgbWIrsPIEa5QAJSjf60Q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VisitorListAdapter.NativeAdViewHolder.this.a(view);
                    }
                });
            } else {
                this.e.setVisibility(8);
            }
            if (StringUtils.a(this.f30170a.last_visit_time, 0L) < StringUtils.a(this.f30170a.visitors_time, 0L)) {
                this.b.setBackground(new ColorDrawable(BluedSkinUtils.a(VisitorListAdapter.this.d, 2131101796)));
            } else {
                this.b.setBackground(BluedSkinUtils.b(VisitorListAdapter.this.d, 2131236289));
            }
            if (this.f30170a.is_show_adm_icon == 1) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
            if (this.f30170a.style_view != 2 || TextUtils.isEmpty(this.f30170a.style_material)) {
                this.h.setVisibility(8);
                this.m.setVisibility(8);
                this.k.setVisibility(0);
                return;
            }
            this.h.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
            layoutParams.height = VisitorListAdapter.this.q;
            this.h.setLayoutParams(layoutParams);
            ImageLoader.a(VisitorListAdapter.this.e, this.f30170a.style_material).a(this.h);
            this.m.setVisibility(0);
            this.k.setVisibility(8);
        }

        public void a(BluedMyVisitorList bluedMyVisitorList, int i) {
            this.f30170a = bluedMyVisitorList;
            this.o = i;
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorListAdapter$NativeAdxViewHolder.class */
    public class NativeAdxViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f30172a;
        public NativeAdContainer b;

        /* renamed from: c  reason: collision with root package name */
        public View f30173c;
        public BluedADConstraintLayout d;
        private BluedMyVisitorList f;
        private int g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.soft.blued.ui.find.adapter.VisitorListAdapter$NativeAdxViewHolder$1  reason: invalid class name */
        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorListAdapter$NativeAdxViewHolder$1.class */
        public class AnonymousClass1 implements View.OnClickListener {
            AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (NativeAdxViewHolder.this.g < VisitorListAdapter.this.g.size()) {
                    VisitorListAdapter.this.g.remove(NativeAdxViewHolder.this.g);
                }
                VisitorListAdapter.this.notifyDataSetChanged();
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ADClosePopOptionsUtils.a(VisitorListAdapter.this.d, NativeAdxViewHolder.this.f, NativeAdxViewHolder.this.f30173c, ADConstants.AD_POSITION.VISITOR_ORIGIN, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$VisitorListAdapter$NativeAdxViewHolder$1$Wr4eQGIQ7C-stiMEx6qqLXGY7XQ
                    @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
                    public final void onRemoved() {
                        VisitorListAdapter.NativeAdxViewHolder.AnonymousClass1.this.a();
                    }
                });
            }
        }

        public NativeAdxViewHolder(View view) {
            this.d = (BluedADConstraintLayout) view.findViewById(2131363859);
            this.b = (NativeAdContainer) view.findViewById(R.id.native_adx_item_content);
            this.f30173c = view.findViewById(2131364488);
            this.f30172a = (LinearLayout) view.findViewById(R.id.layout_native_ad);
        }

        public void a() {
            if (this.f.nativeUnifiedADData == null) {
                this.b.setVisibility(8);
                return;
            }
            this.b.setVisibility(0);
            if ("0".equalsIgnoreCase(this.f.adm_type_source)) {
                Log.v("adx", "当前是直客原生，配置点击事件");
                this.d.setADData(this.f);
            } else {
                Log.v("adx", "当前是第三方原生，配置点击事件");
            }
            SelfRenderViewUtil.a(VisitorListAdapter.this.d, this.b, this.f);
            if (!"0".equalsIgnoreCase(this.f.adm_type_source)) {
                this.f30173c.setVisibility(0);
            } else if (this.f.can_close == 1) {
                this.f30173c.setVisibility(0);
            } else {
                this.f30173c.setVisibility(8);
            }
            this.f30173c.setOnClickListener(new AnonymousClass1());
            if (StringUtils.a(this.f.last_visit_time, 0L) < StringUtils.a(this.f.visitors_time, 0L)) {
                this.f30172a.setBackground(new ColorDrawable(BluedSkinUtils.a(VisitorListAdapter.this.d, 2131101796)));
            } else {
                this.f30172a.setBackground(BluedSkinUtils.b(VisitorListAdapter.this.d, 2131236289));
            }
        }

        public void a(BluedMyVisitorList bluedMyVisitorList, int i) {
            this.f = bluedMyVisitorList;
            this.g = i;
            a();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorListAdapter$ShowVipViewHolder.class */
    class ShowVipViewHolder implements View.OnClickListener {
        private BluedMyVisitorList b;

        /* renamed from: c  reason: collision with root package name */
        private int f30176c;
        private ConstraintLayout d;
        private LinearLayout e;
        private TextView f;
        private RecyclerView g;
        private VisitorGitVipAvatarAdapter h;
        private ImageView i;
        private ImageView j;
        private boolean k = false;

        public ShowVipViewHolder(View view) {
            this.d = (ConstraintLayout) view.findViewById(R.id.layout_no_vip);
            this.e = (LinearLayout) view.findViewById(R.id.layout_is_vip);
            this.f = (TextView) view.findViewById(R.id.tv_git_it_now);
            this.g = (RecyclerView) view.findViewById(2131369105);
            this.i = (ImageView) view.findViewById(2131364437);
            this.j = (ImageView) view.findViewById(R.id.img_fuzzy_profile_picture);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(VisitorListAdapter.this.d) { // from class: com.soft.blued.ui.find.adapter.VisitorListAdapter.ShowVipViewHolder.1
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean canScrollVertically() {
                    return false;
                }
            };
            linearLayoutManager.setOrientation(0);
            this.g.setLayoutManager(linearLayoutManager);
        }

        private void a() {
            if (this.k) {
                return;
            }
            this.k = true;
            if (this.b.is_vip == 0) {
                InstantLog.a("visitor_vip_show");
            }
        }

        private void b() {
            if (this.b.is_vip == 1) {
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                return;
            }
            this.d.setVisibility(0);
            this.e.setVisibility(8);
            this.f.setOnClickListener(this);
            if (this.g.getAdapter() == null) {
                VisitorGitVipAvatarAdapter visitorGitVipAvatarAdapter = new VisitorGitVipAvatarAdapter(VisitorListAdapter.this.d, VisitorListAdapter.this.e);
                this.h = visitorGitVipAvatarAdapter;
                this.g.setAdapter(visitorGitVipAvatarAdapter);
            }
            this.h.setNewData(this.b.profile_picture);
            this.h.notifyDataSetChanged();
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.d = 2131237313;
            loadOptions.b = 2131237313;
            loadOptions.a(VisitorListAdapter.this.h >> 1, VisitorListAdapter.this.h >> 1);
            if (this.b.profile_picture == null || this.b.profile_picture.size() <= 0) {
                this.i.setVisibility(8);
                this.g.setVisibility(8);
            } else {
                ImageLoader.a(VisitorListAdapter.this.e, this.b.profile_picture.get(0).url).b(2131237313).a(2.0f, VisitorListAdapter.this.d.getResources().getColor(2131101191)).a(this.i);
                this.i.setVisibility(0);
                this.g.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.b.fuzzy_profile_picture)) {
                this.j.setVisibility(8);
                return;
            }
            this.j.setVisibility(0);
            ImageLoader.a(VisitorListAdapter.this.e, this.b.profile_picture.get(0).url).b(2131237313).a(2.0f, VisitorListAdapter.this.d.getResources().getColor(2131101191)).d().a(this.j);
        }

        public void a(BluedMyVisitorList bluedMyVisitorList, int i) {
            this.b = bluedMyVisitorList;
            this.f30176c = i;
            b();
            a();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (view.getId() != 2131371555) {
                return;
            }
            InstantLog.a("visitor_vip_buy_click");
            PayUtils.a(VisitorListAdapter.this.d, 12, "nearby_visit_bottom_buy");
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorListAdapter$TTOriginADViewHolder.class */
    class TTOriginADViewHolder extends NativeAdViewHolder {
        private ImageView o;
        private ImageView p;

        public TTOriginADViewHolder(View view) {
            super(view);
            this.o = (ImageView) view.findViewById(R.id.img_style_1_ad_icon);
            this.p = (ImageView) view.findViewById(R.id.img_style_2_ad_icon);
        }

        @Override // com.soft.blued.ui.find.adapter.VisitorListAdapter.NativeAdViewHolder
        public void a() {
            super.a();
            this.o.setVisibility(0);
            this.p.setVisibility(0);
        }

        @Override // com.soft.blued.ui.find.adapter.VisitorListAdapter.NativeAdViewHolder
        public void a(final BluedMyVisitorList bluedMyVisitorList, int i) {
            super.a(bluedMyVisitorList, i);
            this.o.setImageResource(2131233931);
            this.p.setImageResource(2131233931);
            this.g.a(bluedMyVisitorList, new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$VisitorListAdapter$TTOriginADViewHolder$CfQNlUWmFBan5UfearwN8lYLoqE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                }
            });
            if (bluedMyVisitorList.ttNativeAdData != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.b);
                bluedMyVisitorList.ttNativeAdData.registerViewForInteraction(this.b, arrayList, arrayList, new TTNativeAd.AdInteractionListener() { // from class: com.soft.blued.ui.find.adapter.VisitorListAdapter.TTOriginADViewHolder.1
                    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                        FindHttpUtils.b(bluedMyVisitorList.click_url);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                        FindHttpUtils.b(bluedMyVisitorList.click_url);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                    public void onAdShow(TTNativeAd tTNativeAd) {
                    }
                });
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorListAdapter$TopAdViewHolder.class */
    public class TopAdViewHolder {

        /* renamed from: a  reason: collision with root package name */
        ATNativeAdView f30180a;
        View b;

        /* renamed from: c  reason: collision with root package name */
        int f30181c;

        TopAdViewHolder(View view) {
            this.b = view;
            this.f30180a = (ATNativeAdView) view.findViewById(2131361988);
        }

        private void a(NativeAd nativeAd, View view, final BluedMyVisitorList bluedMyVisitorList) {
            ATNativeAdView aTNativeAdView = (ATNativeAdView) view.findViewById(2131361988);
            View findViewById = aTNativeAdView.findViewById(R.id.self_render_view);
            nativeAd.setNativeEventListener(new ATNativeEventListener() { // from class: com.soft.blued.ui.find.adapter.VisitorListAdapter.TopAdViewHolder.1
                @Override // com.anythink.nativead.api.ATNativeEventListener
                public void onAdClicked(ATNativeAdView aTNativeAdView2, ATAdInfo aTAdInfo) {
                    FindHttpUtils.b(bluedMyVisitorList.click_url);
                    Log.i("ddrb", "native ad onAdClicked--------\n" + aTAdInfo.toString());
                }

                @Override // com.anythink.nativead.api.ATNativeEventListener
                public void onAdImpressed(ATNativeAdView aTNativeAdView2, ATAdInfo aTAdInfo) {
                    FindHttpUtils.b(bluedMyVisitorList.show_url);
                    Log.i("ddrb", "native ad onAdImpressed--------\n" + aTAdInfo.toString());
                }

                @Override // com.anythink.nativead.api.ATNativeEventListener
                public void onAdVideoEnd(ATNativeAdView aTNativeAdView2) {
                    Log.i("ddrb", "native ad onAdVideoEnd--------");
                }

                @Override // com.anythink.nativead.api.ATNativeEventListener
                public void onAdVideoProgress(ATNativeAdView aTNativeAdView2, int i) {
                    Log.i("ddrb", "native ad onAdVideoProgress--------:" + i);
                }

                @Override // com.anythink.nativead.api.ATNativeEventListener
                public void onAdVideoStart(ATNativeAdView aTNativeAdView2) {
                    Log.i("ddrb", "native ad onAdVideoStart--------");
                }
            });
            try {
                Log.i("ddrb", "native ad start to render ad------------- ");
                aTNativeAdView.removeAllViews();
                ATNativePrepareInfo aTNativePrepareInfo = null;
                if (nativeAd.isNativeExpress()) {
                    Log.i("ddrb", "topon原生模版");
                    nativeAd.renderAdContainer(aTNativeAdView, null);
                    findViewById.setVisibility(8);
                } else {
                    Log.i("ddrb", "topon原生自渲染");
                    aTNativePrepareInfo = new ATNativePrepareInfo();
                    findViewById.setVisibility(0);
                    SelfRenderViewUtil.a(aTNativeAdView.getContext(), nativeAd.getAdMaterial(), findViewById, aTNativePrepareInfo, nativeAd.getAdInfo().getNetworkFirmId());
                    nativeAd.renderAdContainer(aTNativeAdView, findViewById);
                }
                final View findViewById2 = findViewById.findViewById(2131364488);
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.VisitorListAdapter.TopAdViewHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        Log.v("drb", "closeView onClick");
                        if (bluedMyVisitorList.can_close == 1) {
                            Context context = VisitorListAdapter.this.d;
                            BluedMyVisitorList bluedMyVisitorList2 = bluedMyVisitorList;
                            View view3 = findViewById2;
                            ADConstants.AD_POSITION ad_position = ADConstants.AD_POSITION.VISITOR_ORIGIN;
                            final TopAdViewHolder topAdViewHolder = TopAdViewHolder.this;
                            ADClosePopOptionsUtils.a(context, bluedMyVisitorList2, view3, ad_position, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$wx4ygazb84PruxdTTzXxbOKgwMY
                                @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
                                public final void onRemoved() {
                                    VisitorListAdapter.TopAdViewHolder.this.a();
                                }
                            });
                        }
                    }
                });
                nativeAd.prepare(aTNativeAdView, aTNativePrepareInfo);
                nativeAd.onResume();
                nativeAd.setVideoMute(true);
            } catch (Exception e) {
                Log.v("drb", "topon原生 e:" + e.toString());
                e.printStackTrace();
            }
        }

        public void a() {
            if (this.f30181c < VisitorListAdapter.this.g.size()) {
                VisitorListAdapter.this.g.remove(this.f30181c);
            }
            VisitorListAdapter.this.notifyDataSetChanged();
        }

        public void a(BluedMyVisitorList bluedMyVisitorList, int i) {
            boolean z;
            this.f30181c = i;
            if (bluedMyVisitorList.nativeAd == null) {
                bluedMyVisitorList.nativeAd = VisitorListAdapter.this.l.getNativeAd();
                z = true;
            } else {
                z = false;
            }
            if (z || bluedMyVisitorList.nativeAd == null) {
                Log.i("ddrb", "start to request new ad object.");
                VisitorListAdapter.this.l.makeAdRequest();
            }
            if (bluedMyVisitorList.nativeAd == null) {
                Log.i("ddrb", "onBindAdViewHolder: NativeAd is null, it would be gone now.");
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    layoutParams.width = 0;
                    this.b.setLayoutParams(layoutParams);
                }
                this.b.setVisibility(8);
                return;
            }
            Log.i("ddrb", "onBindAdViewHolder: NativeAd exist, start to render view.");
            Log.i("ddrb", "onBindAdViewHolder: RenderAd: " + bluedMyVisitorList.nativeAd.getAdInfo().toString());
            this.b.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = -2;
                layoutParams2.width = -1;
                this.b.setLayoutParams(layoutParams2);
            }
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 1;
            this.f30180a.setLayoutParams(layoutParams3);
            VisitorListAdapter.this.m.put(String.valueOf(bluedMyVisitorList.nativeAd.hashCode()), bluedMyVisitorList.nativeAd);
            a(bluedMyVisitorList.nativeAd, this.b, bluedMyVisitorList);
        }
    }

    public VisitorListAdapter(Context context, IRequestHost iRequestHost) {
        this.d = context;
        this.e = iRequestHost;
        this.f = LayoutInflater.from(context);
        this.h = context.getResources().getDisplayMetrics().widthPixels;
        LoadOptions loadOptions = new LoadOptions();
        this.j = loadOptions;
        loadOptions.d = 2131237310;
        this.j.b = 2131237310;
        LoadOptions loadOptions2 = this.j;
        int i = this.h;
        loadOptions2.a(i >> 1, i >> 1);
        this.m = new ConcurrentHashMap<>();
        int a2 = AppInfo.l - DensityUtils.a(context, 24.0f);
        this.n = a2;
        this.o = (int) (a2 * 0.75f);
        int a3 = AppInfo.l - DensityUtil.a(95.0f);
        this.p = a3;
        this.q = (int) (a3 / 2.3f);
    }

    private void a(int i) {
        List<BluedMyVisitorList> list = this.g;
        if (list == null || list.size() <= 4 || this.g.get(4).isShowAdVisited || 1 != this.i || i != 4) {
            return;
        }
        this.g.get(4).isShowAdVisited = true;
    }

    private void a(int i, AdxConfig adxConfig, long j, final BluedMyVisitorList bluedMyVisitorList) {
        if (bluedMyVisitorList.adxNativeManager == null) {
            bluedMyVisitorList.adxNativeManager = new AdxNativeUnifiedManager(this.d, i, adxConfig.type, adxConfig.parallel_num, j, new ADListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$VisitorListAdapter$FM3SknB3CkMTKbLRq5aW_5WrwZA
                @Override // com.blued.android.module.common.adx.base.ADListener
                public final void onADEvent(ADEvent aDEvent) {
                    VisitorListAdapter.this.a(bluedMyVisitorList, aDEvent);
                }
            });
        }
        bluedMyVisitorList.adxNativeManager.a(j, adxConfig.type, adxConfig.parallel_num);
        List<UserBasicModel> list = bluedMyVisitorList.adx.data;
        if (list != null) {
            for (UserBasicModel userBasicModel : list) {
                if ("0".equalsIgnoreCase(userBasicModel.adm_type_source)) {
                    userBasicModel.nativeModel = new BluedADExtra.NativeModel();
                    userBasicModel.nativeModel.name = userBasicModel.name;
                    userBasicModel.nativeModel.ads_pics = userBasicModel.ads_pics;
                    userBasicModel.nativeModel.avatar = userBasicModel.avatar;
                    userBasicModel.nativeModel.style_material = userBasicModel.style_material;
                    userBasicModel.nativeModel.description = userBasicModel.description;
                }
            }
        }
        bluedMyVisitorList.adxNativeManager.a((ArrayList) list);
    }

    private void a(BluedMyVisitorList bluedMyVisitorList, int i) {
        int i2;
        boolean z;
        if (i > this.g.size() - 1) {
            i2 = this.g.size() - 1;
            z = true;
        } else {
            i2 = i;
            z = false;
        }
        BluedMyVisitorList bluedMyVisitorList2 = this.g.get(i2);
        if (bluedMyVisitorList2 != null) {
            if (bluedMyVisitorList2.is_interested != 1 && bluedMyVisitorList2.is_ads != 1) {
                bluedMyVisitorList.visitors_time = bluedMyVisitorList2.visitors_time;
            } else if (z) {
            } else {
                a(bluedMyVisitorList, i2 + 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BluedMyVisitorList bluedMyVisitorList, ADEvent aDEvent) {
        if (aDEvent == null) {
            return;
        }
        BluedADExtra bluedADExtra = (BluedADExtra) aDEvent.a(BluedADExtra.class);
        int type = aDEvent.getType();
        if (type == 100) {
            Log.v("adx", "业务层接收到广告数据，准备渲染");
            if ("0".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
                bluedMyVisitorList.nativeUnifiedADData = new BluedNativeAdDataAdapter(this.d, bluedADExtra);
            } else {
                bluedMyVisitorList.nativeUnifiedADData = bluedADExtra.baseNativeExpressAd.b();
            }
            bluedMyVisitorList.adm_type_source = bluedADExtra.adm_type_source;
            bluedMyVisitorList.is_show_adm_icon = bluedADExtra.is_show_adm_icon;
            bluedMyVisitorList.can_close = bluedADExtra.can_close;
            bluedMyVisitorList.show_url = bluedADExtra.show_url;
            bluedMyVisitorList.click_url = bluedADExtra.click_url;
            bluedMyVisitorList.hidden_url = bluedADExtra.hidden_url;
            notifyDataSetChanged();
        } else if (type == 103) {
            Log.v("adx", "上报show_url曝光埋点");
            FindHttpUtils.b(bluedADExtra.show_url);
        } else {
            switch (type) {
                case 105:
                    Log.v("adx", "上报click_url点击埋点");
                    FindHttpUtils.b(bluedADExtra.click_url);
                    return;
                case 106:
                    Log.v("adx", "上报hidden_url关闭埋点");
                    FindHttpUtils.b(bluedADExtra.hidden_url);
                    return;
                case 107:
                    this.g.remove(bluedMyVisitorList);
                    notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BluedMyVisitorList bluedMyVisitorList, com.huawei.hms.ads.nativead.NativeAd nativeAd) {
        Log.v("drb", "华为原生成功");
        LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE;
        EventTrackLoginAndRegister.b(event, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited");
        bluedMyVisitorList.hwNativeAd = nativeAd;
        bluedMyVisitorList.can_close = 1;
        notifyDataSetChanged();
    }

    public void a(final BluedMyVisitorList bluedMyVisitorList) {
        if (this.l == null) {
            this.l = new ATNative(this.d, bluedMyVisitorList.third_id, new ATNativeNetworkListener() { // from class: com.soft.blued.ui.find.adapter.VisitorListAdapter.4
                @Override // com.anythink.nativead.api.ATNativeNetworkListener
                public void onNativeAdLoadFail(AdError adError) {
                    Log.v("ddrb", "topon原生广告载入失败：" + adError.getFullErrorInfo());
                    LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE_FAIL;
                    EventTrackLoginAndRegister.c(event, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited", adError.getFullErrorInfo());
                }

                @Override // com.anythink.nativead.api.ATNativeNetworkListener
                public void onNativeAdLoaded() {
                    VisitorListAdapter.this.notifyDataSetChanged();
                    Log.v("ddrb", "topon原生广告载入成功");
                    LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE;
                    EventTrackLoginAndRegister.b(event, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited");
                }
            });
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(this.n));
        hashMap.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(this.o));
        hashMap.put(TTATConst.NATIVE_AD_IMAGE_HEIGHT, 0);
        hashMap.put(GDTATConst.AD_HEIGHT, -2);
        this.l.setLocalExtra(hashMap);
        this.l.makeAdRequest();
        LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_REQUEST;
        EventTrackLoginAndRegister.b(event, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited");
        Log.i("ddrb", "native ad start to load ad------------- ");
    }

    public void a(String str) {
        this.k = str;
    }

    public void a(List<BluedMyVisitorList> list, int i) {
        this.i = i;
        this.f30156a = false;
        this.g.clear();
        this.b.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                Log.v("adx", "来访原生数据条数 mDataList：" + this.g.size() + " -- items:" + list.size());
                this.g.addAll(list);
                notifyDataSetChanged();
                return;
            }
            this.b.add(list.get(i3).uid + list.get(i3).aid + list.get(i3).is_ads);
            if (BlueAppLocal.d()) {
                list.get(i3).height = StringUtils.a(list.get(i3).height, BlueAppLocal.c(), false);
                list.get(i3).weight = StringUtils.b(list.get(i3).weight, BlueAppLocal.c(), false);
            } else {
                list.get(i3).height = StringUtils.a(list.get(i3).height, BlueAppLocal.c(), true);
                list.get(i3).weight = StringUtils.b(list.get(i3).weight, BlueAppLocal.c(), true);
            }
            final BluedMyVisitorList bluedMyVisitorList = list.get(i3);
            if (FlexDebugSevConfig.a().b().android_forbidden_origin_ad == 1) {
                this.g.remove(bluedMyVisitorList);
                notifyDataSetChanged();
                return;
            }
            if (bluedMyVisitorList.is_ads == 1) {
                if (bluedMyVisitorList.isAdx()) {
                    a(bluedMyVisitorList.adx.position_code, bluedMyVisitorList.adx.serial_parallel, bluedMyVisitorList.adx.timeout, bluedMyVisitorList);
                } else if ("4".equalsIgnoreCase(bluedMyVisitorList.adms_type) && "user".equalsIgnoreCase(bluedMyVisitorList.adms_mark)) {
                    LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_REQUEST;
                    EventTrackLoginAndRegister.b(event, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited");
                    TTADUtils.a(this.d, bluedMyVisitorList.third_id, new TTADUtils.TTOriginAdListener() { // from class: com.soft.blued.ui.find.adapter.VisitorListAdapter.1
                        @Override // com.soft.blued.utils.third.TTADUtils.TTOriginAdListener
                        public void a() {
                            VisitorListAdapter.this.g.remove(bluedMyVisitorList);
                            VisitorListAdapter.this.notifyDataSetChanged();
                        }

                        @Override // com.soft.blued.utils.third.TTADUtils.TTOriginAdListener
                        public void a(int i4, String str) {
                            VisitorListAdapter.this.g.remove(bluedMyVisitorList);
                            VisitorListAdapter.this.notifyDataSetChanged();
                            EventTrackLoginAndRegister.c(LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE_FAIL, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited", i4 + str);
                        }

                        @Override // com.soft.blued.utils.third.TTADUtils.TTOriginAdListener
                        public void a(TTFeedAd tTFeedAd) {
                            bluedMyVisitorList.avatar = tTFeedAd.getImageList().get(0).getImageUrl();
                            bluedMyVisitorList.name = tTFeedAd.getTitle();
                            bluedMyVisitorList.description = tTFeedAd.getDescription();
                            bluedMyVisitorList.can_close = 1;
                            bluedMyVisitorList.ttNativeAdData = tTFeedAd;
                            VisitorListAdapter.this.notifyDataSetChanged();
                            LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE;
                            EventTrackLoginAndRegister.b(event2, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited");
                        }
                    });
                } else if ("6".equalsIgnoreCase(bluedMyVisitorList.adms_type) && "user".equalsIgnoreCase(bluedMyVisitorList.adms_mark)) {
                    a(bluedMyVisitorList);
                    bluedMyVisitorList.can_close = 1;
                } else if ("13".equalsIgnoreCase(bluedMyVisitorList.adms_type) && "user".equalsIgnoreCase(bluedMyVisitorList.adms_mark)) {
                    LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.AD_NATIVE_REQUEST;
                    EventTrackLoginAndRegister.b(event2, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited");
                    Log.v("drb", "快手原生");
                    long j = 0L;
                    try {
                        j = Long.parseLong(bluedMyVisitorList.third_id);
                    } catch (Exception e) {
                    }
                    KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(j).adNum(1).build(), new KsLoadManager.NativeAdListener() { // from class: com.soft.blued.ui.find.adapter.VisitorListAdapter.2
                        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                        public void onError(int i4, String str) {
                            Log.v("drb", "快手原生onError:" + i4 + "--" + str);
                            VisitorListAdapter.this.g.remove(bluedMyVisitorList);
                            VisitorListAdapter.this.notifyDataSetChanged();
                            EventTrackLoginAndRegister.c(LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE_FAIL, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited", i4 + str);
                        }

                        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                        public void onNativeAdLoad(List<KsNativeAd> list2) {
                            if (list2 == null || list2.size() <= 0) {
                                return;
                            }
                            LoginAndRegisterProtos.Event event3 = LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE;
                            EventTrackLoginAndRegister.b(event3, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited");
                            KsNativeAd ksNativeAd = list2.get(0);
                            bluedMyVisitorList.avatar = ksNativeAd.getAppIconUrl();
                            if (ksNativeAd.getInteractionType() == 1) {
                                bluedMyVisitorList.name = ksNativeAd.getAppName();
                            } else {
                                bluedMyVisitorList.name = ksNativeAd.getProductName();
                            }
                            bluedMyVisitorList.description = ksNativeAd.getAdDescription();
                            bluedMyVisitorList.can_close = 1;
                            bluedMyVisitorList.ksNativeAd = ksNativeAd;
                            Log.v("drb", "快手原生 avatar：" + bluedMyVisitorList.avatar);
                            Log.v("drb", "快手原生 name：" + bluedMyVisitorList.name);
                            VisitorListAdapter.this.notifyDataSetChanged();
                        }
                    });
                } else if ("12".equalsIgnoreCase(bluedMyVisitorList.adms_type) && "user".equalsIgnoreCase(bluedMyVisitorList.adms_mark)) {
                    LoginAndRegisterProtos.Event event3 = LoginAndRegisterProtos.Event.AD_NATIVE_REQUEST;
                    EventTrackLoginAndRegister.b(event3, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited");
                    NativeAdLoader.Builder builder = new NativeAdLoader.Builder(this.d, bluedMyVisitorList.third_id);
                    builder.build().loadAd(new AdParam.Builder().build());
                    builder.setNativeAdLoadedListener(new NativeAd.NativeAdLoadedListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$VisitorListAdapter$7J2iJyQH5Ak7gtHoP3vimkYN5Zk
                        @Override // com.huawei.hms.ads.nativead.NativeAd.NativeAdLoadedListener
                        public final void onNativeAdLoaded(com.huawei.hms.ads.nativead.NativeAd nativeAd) {
                            VisitorListAdapter.this.a(bluedMyVisitorList, nativeAd);
                        }
                    }).setAdListener(new AdListener() { // from class: com.soft.blued.ui.find.adapter.VisitorListAdapter.3
                        @Override // com.huawei.hms.ads.AdListener
                        public void onAdClicked() {
                            Log.v("drb", "华为原生点击");
                            FindHttpUtils.b(bluedMyVisitorList.click_url);
                        }

                        @Override // com.huawei.hms.ads.AdListener
                        public void onAdFailed(int i4) {
                            VisitorListAdapter.this.g.remove(bluedMyVisitorList);
                            VisitorListAdapter.this.notifyDataSetChanged();
                            Log.v("drb", "华为原生失败 errorCode:" + i4);
                            EventTrackLoginAndRegister.c(LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE_FAIL, bluedMyVisitorList.ads_id + "", bluedMyVisitorList.adms_type, "visited", i4 + "");
                        }

                        @Override // com.huawei.hms.ads.AdListener
                        public void onAdLoaded() {
                            Log.v("drb", "华为原生 onAdLoaded 曝光");
                            FindHttpUtils.b(bluedMyVisitorList.show_url);
                        }
                    });
                }
            }
            i2 = i3 + 1;
        }
    }

    public void b(List<BluedMyVisitorList> list, int i) {
        this.i = i;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<BluedMyVisitorList> it = list.iterator();
        while (it.hasNext()) {
            BluedMyVisitorList next = it.next();
            if (this.b.contains(next.uid + next.aid + next.is_ads)) {
                it.remove();
            } else if (BlueAppLocal.d()) {
                next.height = StringUtils.a(next.height, BlueAppLocal.c(), false);
                next.weight = StringUtils.b(next.weight, BlueAppLocal.c(), false);
            } else {
                next.height = StringUtils.a(next.height, BlueAppLocal.c(), true);
                next.weight = StringUtils.b(next.weight, BlueAppLocal.c(), true);
            }
        }
        this.g.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.g.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
        if (r0.equals("6") != false) goto L30;
     */
    @Override // android.widget.BaseAdapter, android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getItemViewType(int r4) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.find.adapter.VisitorListAdapter.getItemViewType(int):int");
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        AdViewHolder adViewHolder;
        View view2;
        NativeAdViewHolder nativeAdViewHolder;
        ShowVipViewHolder showVipViewHolder;
        View view3;
        TTOriginADViewHolder tTOriginADViewHolder;
        View view4;
        TopAdViewHolder topAdViewHolder;
        View view5;
        KSOriginADViewHolder kSOriginADViewHolder;
        View view6;
        MIOriginADViewHolder mIOriginADViewHolder;
        View view7;
        HWOriginADViewHolder hWOriginADViewHolder;
        View view8;
        NativeAdxViewHolder nativeAdxViewHolder;
        VisitorViewHolder visitorViewHolder;
        a(i);
        int i2 = i + 1;
        BluedMyVisitorList bluedMyVisitorList = this.g.get(i);
        bluedMyVisitorList.last_visit_time = this.k;
        switch (getItemViewType(i)) {
            case 1:
            case 5:
            case 8:
                if (view == null) {
                    view = this.f.inflate(R.layout.item_visitor_ad, (ViewGroup) null);
                    adViewHolder = new AdViewHolder(view);
                    view.setTag(adViewHolder);
                } else {
                    adViewHolder = (AdViewHolder) view.getTag();
                }
                adViewHolder.a(bluedMyVisitorList, i);
                return view;
            case 2:
                if (view == null) {
                    view2 = this.f.inflate(R.layout.native_ad_item, (ViewGroup) null);
                    nativeAdViewHolder = new NativeAdViewHolder(view2);
                    view2.setTag(nativeAdViewHolder);
                } else {
                    view2 = view;
                    nativeAdViewHolder = (NativeAdViewHolder) view.getTag();
                }
                a(bluedMyVisitorList, i2);
                nativeAdViewHolder.a(bluedMyVisitorList, i);
                return view2;
            case 3:
                if (!this.f30156a) {
                    this.f30156a = true;
                }
                if (view == null) {
                    view = this.f.inflate(R.layout.item_visitor_show_vip, (ViewGroup) null);
                    showVipViewHolder = new ShowVipViewHolder(view);
                    view.setTag(showVipViewHolder);
                } else {
                    showVipViewHolder = (ShowVipViewHolder) view.getTag();
                }
                showVipViewHolder.a(bluedMyVisitorList, i);
                return view;
            case 4:
                if (view == null) {
                    view3 = this.f.inflate(R.layout.native_ad_item, (ViewGroup) null);
                    tTOriginADViewHolder = new TTOriginADViewHolder(view3);
                    view3.setTag(tTOriginADViewHolder);
                } else {
                    view3 = view;
                    tTOriginADViewHolder = (TTOriginADViewHolder) view.getTag();
                }
                a(bluedMyVisitorList, i2);
                tTOriginADViewHolder.a(bluedMyVisitorList, i);
                return view3;
            case 6:
            default:
                if (view == null) {
                    view = this.f.inflate(R.layout.item_visitor_my_visitor, (ViewGroup) null);
                    visitorViewHolder = new VisitorViewHolder(this.d, this.e, view, this.j, this.i);
                    view.setTag(visitorViewHolder);
                } else {
                    visitorViewHolder = (VisitorViewHolder) view.getTag();
                }
                visitorViewHolder.a(bluedMyVisitorList, i);
                return view;
            case 7:
                if (view == null) {
                    view4 = this.f.inflate(R.layout.native_list_ad_item, (ViewGroup) null);
                    topAdViewHolder = new TopAdViewHolder(view4);
                    view4.setTag(topAdViewHolder);
                } else {
                    view4 = view;
                    topAdViewHolder = (TopAdViewHolder) view.getTag();
                }
                a(bluedMyVisitorList, i2);
                Log.v("drb", "这是topon广告 position：" + i);
                topAdViewHolder.a(bluedMyVisitorList, i);
                return view4;
            case 9:
                if (view == null) {
                    view5 = this.f.inflate(R.layout.native_ad_item, (ViewGroup) null);
                    kSOriginADViewHolder = new KSOriginADViewHolder(view5);
                    view5.setTag(kSOriginADViewHolder);
                } else {
                    view5 = view;
                    kSOriginADViewHolder = (KSOriginADViewHolder) view.getTag();
                }
                a(bluedMyVisitorList, i2);
                Log.v("drb", "这是快手广告 position：" + i);
                kSOriginADViewHolder.a(bluedMyVisitorList, i);
                return view5;
            case 10:
                if (view == null) {
                    view6 = this.f.inflate(R.layout.native_ad_item, (ViewGroup) null);
                    mIOriginADViewHolder = new MIOriginADViewHolder(view6);
                    view6.setTag(mIOriginADViewHolder);
                } else {
                    view6 = view;
                    mIOriginADViewHolder = (MIOriginADViewHolder) view.getTag();
                }
                a(bluedMyVisitorList, i2);
                Log.v("drb", "这是小米广告 position：" + i);
                mIOriginADViewHolder.a(bluedMyVisitorList, i);
                return view6;
            case 11:
                if (view == null) {
                    view7 = this.f.inflate(R.layout.native_hw_ad_item, (ViewGroup) null);
                    hWOriginADViewHolder = new HWOriginADViewHolder(view7);
                    view7.setTag(hWOriginADViewHolder);
                } else {
                    view7 = view;
                    hWOriginADViewHolder = (HWOriginADViewHolder) view.getTag();
                }
                a(bluedMyVisitorList, i2);
                Log.v("drb", "这是华为广告 position：" + i);
                hWOriginADViewHolder.a(bluedMyVisitorList, i);
                return view7;
            case 12:
                if (view == null) {
                    view8 = this.f.inflate(R.layout.native_adx_item, (ViewGroup) null);
                    nativeAdxViewHolder = new NativeAdxViewHolder(view8);
                    view8.setTag(nativeAdxViewHolder);
                } else {
                    view8 = view;
                    nativeAdxViewHolder = (NativeAdxViewHolder) view.getTag();
                }
                a(bluedMyVisitorList, i2);
                nativeAdxViewHolder.a(bluedMyVisitorList, i);
                return view8;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return f30155c;
    }
}
