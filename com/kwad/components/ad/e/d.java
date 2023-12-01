package com.kwad.components.ad.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.applog.tracker.Tracker;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.components.ad.e.b;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.tencent.ugc.UGCTransitionRules;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/d.class */
public final class d extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.components.core.internal.api.a {
    private Vibrator eg;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private b.c mE;
    private boolean mI;
    private KsNativeAd.AdInteractionListener mJ;
    private f mK;
    private e mL;
    private KsNativeAd.VideoPlayListener mM;
    private bh mTimerHelper;
    private boolean mN = false;
    private com.kwad.components.core.internal.api.c cg = new com.kwad.components.core.internal.api.c();
    private int mO = 0;
    private int mP = 0;
    private KsNativeAd.VideoPlayListener mQ = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.components.ad.e.d.8
        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (d.this.mM != null) {
                d.this.mM.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i, int i2) {
            if (d.this.mM != null) {
                d.this.mM.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (d.this.mM != null) {
                try {
                    d.this.mM.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (d.this.mM != null) {
                try {
                    d.this.mM.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (d.this.mM != null) {
                try {
                    d.this.mM.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (d.this.mM != null) {
                d.this.mM.onVideoPlayStart();
            }
        }
    };
    private a mR = new a() { // from class: com.kwad.components.ad.e.d.9
        @Override // com.kwad.components.ad.e.d.a
        public final void eO() {
            if (d.this.mJ != null) {
                d.this.mJ.onAdShow(d.this);
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (d.this.mJ != null) {
                try {
                    return d.this.mJ.handleDownloadDialog(onClickListener);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    return false;
                }
            }
            return false;
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void l(View view) {
            if (d.this.mJ != null) {
                d.this.mJ.onAdClicked(new FrameLayout(k.dl(view.getContext())), d.this);
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void onDownloadTipsDialogDismiss() {
            if (d.this.mJ != null) {
                try {
                    d.this.mJ.onDownloadTipsDialogDismiss();
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void onDownloadTipsDialogShow() {
            if (d.this.mJ != null) {
                try {
                    d.this.mJ.onDownloadTipsDialogShow();
                } catch (Throwable th) {
                }
            }
        }
    };

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/d$a.class */
    public interface a {
        void eO();

        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        void l(View view);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public d(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mAdInfo = cb;
        if (com.kwad.sdk.core.response.a.a.ax(cb)) {
            com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mApkDownloadHelper.a(new c.a() { // from class: com.kwad.components.ad.e.d.1
                @Override // com.kwad.components.core.d.b.c.a
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return d.this.mR.handleDownloadDialog(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.H(this.mAdInfo), this.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (this.eg == null) {
            this.eg = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }
        return this.eg;
    }

    private View a(Context context, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        if (aVar == null || !aVar.hasLiveCompoReady()) {
            return null;
        }
        if (this.mL == null) {
            e eVar = new e(context);
            this.mL = eVar;
            eVar.setInnerAdInteractionListener(this.mR);
            this.mL.setVideoPlayListener(this.mQ);
            this.mL.a(context, this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.mL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, final View view, final ac.a aVar, int i, boolean z, final int i2) {
        Context context = activity;
        if (activity == null) {
            context = view.getContext();
        }
        a.C0519a ao = new a.C0519a(k.wrapContextIfNeed(context)).I(this.mAdTemplate).b(this.mApkDownloadHelper).aq(i).ao(true);
        e eVar = this.mL;
        com.kwad.components.core.d.b.a.a(ao.q((eVar == null || eVar.eV == null) ? 0L : this.mL.eV.getPlayDuration()).av(z).a(new a.b() { // from class: com.kwad.components.ad.e.d.4
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new i().c(aVar).bj(i2), (JSONObject) null);
                d.this.mR.l(view);
            }
        }));
    }

    private void a(final Activity activity, final ViewGroup viewGroup, final int i, final View view, final boolean z) {
        final ac.a aVar = new ac.a();
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.e.d.2
            private int[] mT = new int[2];

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    aVar.u(viewGroup.getWidth(), viewGroup.getHeight());
                    viewGroup.getLocationOnScreen(this.mT);
                    aVar.f(Math.abs(motionEvent.getRawX() - this.mT[0]), Math.abs(motionEvent.getRawY() - this.mT[1]));
                    return false;
                } else if (action != 1) {
                    return false;
                } else {
                    aVar.g(Math.abs(motionEvent.getRawX() - this.mT[0]), Math.abs(motionEvent.getRawY() - this.mT[1]));
                    if (d.this.b(aVar)) {
                        view.setPressed(false);
                        d.this.a(activity, view2, aVar, i, z, 153);
                        return false;
                    }
                    return false;
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.e.d.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Tracker.onClick(view2);
                d.this.a(activity, view2, aVar, i, z, 0);
            }
        });
    }

    private void a(Activity activity, ViewGroup viewGroup, List<View> list) {
        for (View view : list) {
            a(activity, viewGroup, 0, view, false);
        }
    }

    private void a(Activity activity, ViewGroup viewGroup, Map<View, Integer> map) {
        for (View view : map.keySet()) {
            if (map.get(view) != null) {
                a(activity, viewGroup, map.get(view).intValue(), view, true);
            }
        }
    }

    private void a(final ViewGroup viewGroup) {
        if (!this.mI) {
            this.mI = true;
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "callShow").report();
        }
        if (!com.kwad.sdk.core.config.d.uH() && com.kwad.sdk.core.config.d.uG() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0544a() { // from class: com.kwad.components.ad.e.d.5
                @Override // com.kwad.components.core.widget.a.InterfaceC0544a
                public final void eM() {
                    if (d.this.mAdTemplate.mPvReported && d.this.mN) {
                        com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, d.this.getTimerHelper().EZ(), (JSONObject) null);
                        d.this.mN = false;
                        b.eI().a(d.this.mE);
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0544a
                public final void k(View view) {
                    if (!d.this.mAdTemplate.mPvReported) {
                        d.this.mR.eO();
                        d.this.eL();
                        i iVar = new i();
                        iVar.q(viewGroup.getHeight(), viewGroup.getWidth());
                        if (com.kwad.sdk.core.response.a.a.cq(d.this.mAdInfo)) {
                            y.a aVar2 = new y.a();
                            aVar2.showLiveStyle = d.this.mP;
                            aVar2.showLiveStatus = d.this.mO;
                            iVar.a(aVar2);
                        }
                        com.kwad.components.core.r.b.pK().a(d.this.mAdTemplate, null, iVar);
                    }
                    if (!d.this.mN) {
                        d.this.j(view);
                        d.this.getTimerHelper().startTiming();
                        d.this.cg.a(d.this);
                    }
                    d.this.mN = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0544a
                public final void onViewAttached() {
                    KsAdGlobalWatcher.getInstance().watch(d.this);
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0544a
                public final void onViewDetached() {
                    if (d.this.mAdTemplate.mPvReported && d.this.mN) {
                        com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, d.this.getTimerHelper().EZ(), (JSONObject) null);
                        d.this.mN = false;
                    }
                    d.this.getTimerHelper().EZ();
                    d.this.cg.b(d.this);
                    b.eI().a(d.this.mE);
                    KsAdGlobalWatcher.getInstance().unwatch(d.this);
                }
            });
            aVar.rt();
            return;
        }
        View b = b(viewGroup);
        View view = b;
        if (b == null) {
            view = new com.kwad.components.core.widget.c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(view);
        }
        view.setViewCallback(new c.a() { // from class: com.kwad.components.ad.e.d.6
            @Override // com.kwad.components.core.widget.c.a
            public final void eN() {
                if (!d.this.mAdTemplate.mPvReported) {
                    d.this.mR.eO();
                }
                d.this.eL();
                i iVar = new i();
                iVar.q(viewGroup.getHeight(), viewGroup.getWidth());
                if (com.kwad.sdk.core.response.a.a.cq(d.this.mAdInfo)) {
                    y.a aVar2 = new y.a();
                    aVar2.showLiveStyle = d.this.mP;
                    aVar2.showLiveStatus = d.this.mO;
                    iVar.a(aVar2);
                }
                com.kwad.components.core.r.b.pK().a(d.this.mAdTemplate, null, iVar);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "adShowSuccess").report();
            }
        });
        view.setNeedCheckingShow(true);
    }

    private View b(Context context, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.d.b.w("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.mK == null) {
            f fVar = new f(context);
            this.mK = fVar;
            fVar.setInnerAdInteractionListener(this.mR);
            this.mK.setVideoPlayListener(this.mQ);
            this.mK.a(this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.mK;
    }

    private static com.kwad.components.core.widget.c b(ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return null;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.components.core.widget.c) {
                return (com.kwad.components.core.widget.c) childAt;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ac.a aVar) {
        return ((Math.abs(aVar.DH() - aVar.DJ()) > 20) || (Math.abs(aVar.DI() - aVar.DK()) > 20)) && com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate);
    }

    private static void c(ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.api.KsNativeAd
    /* renamed from: eK */
    public com.kwad.components.core.internal.api.d getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature aN = com.kwad.sdk.core.response.a.a.aN(this.mAdInfo);
        if (TextUtils.isEmpty(aN.coverUrl)) {
            return null;
        }
        return new com.kwad.components.core.internal.api.d(aN.width, aN.height, aN.coverUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL() {
        try {
            this.mO = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStatus;
            this.mP = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStyle;
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final View view) {
        if (com.kwad.sdk.core.response.a.a.Z(this.mAdInfo)) {
            float aa = com.kwad.sdk.core.response.a.a.aa(this.mAdInfo);
            this.mE = new b.c() { // from class: com.kwad.components.ad.e.d.7
                @Override // com.kwad.components.ad.e.b.c
                public final void f(final double d) {
                    if (d.this.mAdInfo.status == 3 || d.this.mAdInfo.status == 2) {
                        return;
                    }
                    com.kwad.components.core.d.b.a.a(new a.C0519a(k.wrapContextIfNeed(view.getContext())).I(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).av(false).a(new a.b() { // from class: com.kwad.components.ad.e.d.7.1
                        @Override // com.kwad.components.core.d.b.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new i().bj(157).i(d), (JSONObject) null);
                            d.this.mR.l(view);
                        }
                    }));
                    bi.a(view.getContext(), d.this.F(view.getContext()));
                }
            };
            b.eI().a(aa, view, this.mE);
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.cg.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ao() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.cg.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getActionDescription() {
        return com.kwad.sdk.core.response.a.a.aw(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAdDescription() {
        return com.kwad.sdk.core.response.a.a.an(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAdSource() {
        return com.kwad.sdk.core.response.a.a.av(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAdSourceLogoUrl(int i) {
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null) {
            return null;
        }
        return i != 1 ? adInfo.adBaseInfo.adMarkIcon : adInfo.adBaseInfo.adGrayMarkIcon;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.a.a.ar(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppIconUrl() {
        return com.kwad.sdk.core.response.a.a.bM(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppName() {
        return com.kwad.sdk.core.response.a.a.ao(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppPackageName() {
        return com.kwad.sdk.core.response.a.a.aq(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final long getAppPackageSize() {
        return com.kwad.sdk.core.response.a.a.bu(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.a.a.bs(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final float getAppScore() {
        return com.kwad.sdk.core.response.a.a.as(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppVersion() {
        return com.kwad.sdk.core.response.a.a.bt(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getCorporationName() {
        return com.kwad.sdk.core.response.a.a.bp(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aJ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        int aW = com.kwad.sdk.core.response.a.a.aW(this.mAdInfo);
        if (aW == 2 || aW == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : cb.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.components.core.internal.api.d(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aI(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aW(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.ur()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getPermissionInfo() {
        return com.kwad.sdk.core.response.a.a.bq(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getPermissionInfoUrl() {
        return com.kwad.sdk.core.response.a.a.br(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getProductName() {
        return com.kwad.sdk.core.response.a.a.ap(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final Bitmap getSdkLogo() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ksad_sdk_logo);
    }

    public final bh getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bh();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoDuration() {
        return com.kwad.sdk.core.response.a.a.F(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoHeight() {
        if (com.kwad.sdk.core.response.a.a.cq(this.mAdInfo)) {
            return 1280;
        }
        return com.kwad.sdk.core.response.a.a.aN(this.mAdInfo).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getVideoUrl() {
        return com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (context == null || !KsAdSDKImpl.get().hasInitFinish()) {
            return null;
        }
        View view = null;
        Context context2 = context;
        try {
            Context wrapContextIfNeed = k.wrapContextIfNeed(context);
            com.kwad.sdk.g.a.U(com.anythink.expressad.foundation.g.a.f.f7832a, "show");
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl ? (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig : new KSAdVideoPlayConfigImpl();
            View a2 = com.kwad.sdk.core.response.a.a.cq(this.mAdInfo) ? a(wrapContextIfNeed, kSAdVideoPlayConfigImpl) : b(wrapContextIfNeed, kSAdVideoPlayConfigImpl);
            view = a2;
            context2 = wrapContextIfNeed;
            com.kwad.sdk.g.a.V(com.anythink.expressad.foundation.g.a.f.f7832a, "show");
            return a2;
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("getVideoView fail--context:" + context2.getClass().getName() + "--classloader:" + context2.getClassLoader().getClass().getName());
            if (KsAdSDKImpl.get().getIsExternal()) {
                if (Build.VERSION.SDK_INT >= 19) {
                    runtimeException.addSuppressed(th);
                }
                com.kwad.components.core.c.a.b(runtimeException);
                return view;
            }
            throw th;
        }
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, boolean z) {
        if (context == null || !KsAdSDKImpl.get().hasInitFinish()) {
            return null;
        }
        return getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).build());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoWidth() {
        return com.kwad.sdk.core.response.a.a.cq(this.mAdInfo) ? UGCTransitionRules.DEFAULT_IMAGE_WIDTH : com.kwad.sdk.core.response.a.a.aN(this.mAdInfo).videoWidth;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.mR.onDownloadTipsDialogDismiss();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        a aVar = this.mR;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.mJ = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.mJ = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, map);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(ViewGroup viewGroup, List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayEnd() {
        com.kwad.sdk.core.report.a.av(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayStart() {
        com.kwad.sdk.core.report.a.h(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(long j, long j2) {
        this.mAdTemplate.mBidEcpm = j;
        com.kwad.sdk.core.report.a.i(this.mAdTemplate, j2);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar == null || ksAppDownloadListener == null) {
            return;
        }
        cVar.b(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mM = videoPlayListener;
    }
}
