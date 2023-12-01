package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.nativead.DislikeAdListener;
import com.huawei.hms.ads.nativead.DislikeAdReason;
import com.huawei.hms.ads.nativead.IUnityNativeAdPresenter;
import com.huawei.hms.ads.nativead.MediaContent;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.nativead.NativeAdMonitor;
import com.huawei.hms.ads.nativead.NativeView;
import com.huawei.hms.ads.nativead.c;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.b;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bs.class */
public class bs extends NativeAd implements IUnityNativeAdPresenter, PPSNativeView.b, PPSNativeView.e {
    private VideoOperator D;
    private NativeView I;
    private DislikeAdListener L;
    private Image S;
    private com.huawei.openalliance.ad.inter.data.n V;
    private NativeAdMonitor Z;

    /* renamed from: a  reason: collision with root package name */
    private boolean f8834a;
    private AdListener b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8835c;
    private String d;
    private Context e;
    private AdFeedbackListener f;
    private List<DislikeAdReason> B = new ArrayList();
    private List<Image> C = new ArrayList();
    private DislikeAdListener g = new DislikeAdListener() { // from class: com.huawei.hms.ads.bs.1
        @Override // com.huawei.hms.ads.nativead.DislikeAdListener
        public void onAdDisliked() {
            if (bs.this.L != null) {
                bs.this.L.onAdDisliked();
            }
        }
    };
    private AdFeedbackListener h = new AdFeedbackListener() { // from class: com.huawei.hms.ads.bs.2
        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdDisliked() {
            if (bs.this.f != null) {
                bs.this.f.onAdDisliked();
            }
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdFeedbackShowFailed() {
            if (bs.this.f != null) {
                bs.this.f.onAdFeedbackShowFailed();
            }
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdLiked() {
            if (bs.this.f != null) {
                bs.this.f.onAdLiked();
            }
        }
    };

    public bs(Context context, com.huawei.openalliance.ad.inter.data.g gVar) {
        this.e = context;
        if (gVar == null || !(gVar instanceof com.huawei.openalliance.ad.inter.data.n)) {
            return;
        }
        com.huawei.openalliance.ad.inter.data.n nVar = (com.huawei.openalliance.ad.inter.data.n) gVar;
        this.V = nVar;
        this.d = nVar.D();
    }

    private boolean C() {
        NativeAdConfiguration ad;
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null || (ad = nVar.ad()) == null) {
            return false;
        }
        return ad.isReturnUrlsForImages();
    }

    private Context S() {
        NativeView nativeView = this.I;
        return nativeView != null ? nativeView.getContext() : this.e;
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
    public void B() {
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onAdImpression();
        }
    }

    public com.huawei.openalliance.ad.inter.data.g Code() {
        return this.V;
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView.b
    public void Code(View view) {
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onAdClicked();
        }
    }

    public void Code(AdListener adListener) {
        this.b = adListener;
    }

    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        if (nativeAdConfiguration == null) {
            return;
        }
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            nVar.Code(nativeAdConfiguration);
        }
        Code(nativeAdConfiguration.Code());
    }

    public void Code(NativeAdMonitor nativeAdMonitor) {
        this.Z = nativeAdMonitor;
        if (nativeAdMonitor != null) {
            nativeAdMonitor.Code((PPSNativeView.e) this);
            this.Z.Code((PPSNativeView.b) this);
            this.Z.Code(this.g);
        }
    }

    public void Code(NativeView nativeView) {
        this.I = nativeView;
        if (nativeView != null) {
            nativeView.setOnNativeAdStatusTrackingListener(this);
            this.I.setOnNativeAdClickListener(this);
            this.I.setDislikeAdListener(this.g);
            this.I.setAdFeedbackListener(this.h);
        }
    }

    public void Code(boolean z) {
        this.f8834a = z;
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
    public void I() {
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onAdLeave();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
    public void V() {
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onAdOpened();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
    public void Z() {
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onAdClosed();
        }
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void destroy() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            nVar.ac();
        }
        this.I = null;
        this.Z = null;
        this.L = null;
        this.f = null;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void dislikeAd(DislikeAdReason dislikeAdReason) {
        if (isCustomDislikeThisAdEnabled()) {
            NativeView nativeView = this.I;
            if (nativeView != null) {
                if (dislikeAdReason == null) {
                    nativeView.F();
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(dislikeAdReason.getDescription())) {
                        arrayList.add(dislikeAdReason.getDescription());
                    }
                    this.I.Code(arrayList);
                }
            }
            NativeAdMonitor nativeAdMonitor = this.Z;
            if (nativeAdMonitor != null) {
                if (dislikeAdReason == null) {
                    nativeAdMonitor.Z();
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                if (!TextUtils.isEmpty(dislikeAdReason.getDescription())) {
                    arrayList2.add(dislikeAdReason.getDescription());
                }
                this.Z.Code(arrayList2);
            }
        }
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getAbilityDetailInfo() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.O();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getAdSign() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        return nVar == null ? "2" : nVar.L();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getAdSource() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.W();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public List<AdvertiserInfo> getAdvertiserInfo() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.A();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getCallToAction() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return dp.Code(this.e, nVar.v(), this.V.F());
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public NativeAd.ChoicesInfo getChoicesInfo() {
        return new a();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public int getCreativeType() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return -1;
        }
        return nVar.a();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getDescription() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.V();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public List<DislikeAdReason> getDislikeAdReasons() {
        if (this.V == null || !isCustomDislikeThisAdEnabled()) {
            return new ArrayList();
        }
        if (aa.Code(this.B)) {
            this.B = new ArrayList();
            List<String> n = this.V.n();
            if (aa.Code(n)) {
                return new ArrayList();
            }
            for (String str : n) {
                if (!TextUtils.isEmpty(str)) {
                    this.B.add(new bq(str));
                }
            }
        }
        return this.B;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getDspLogo() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.M();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getDspName() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.K();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public Map<String, String> getExt() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.q();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public Bundle getExtraBundle() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.ab();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getHwChannelId() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.P();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public Image getIcon() {
        com.huawei.openalliance.ad.inter.data.k I;
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        if (this.S == null && (I = nVar.I()) != null) {
            t tVar = new t(I, C());
            this.S = tVar;
            tVar.Code(this.d);
        }
        return this.S;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public List<Image> getImages() {
        if (this.V == null) {
            return new ArrayList();
        }
        if (aa.Code(this.C)) {
            this.C = new ArrayList();
            List<com.huawei.openalliance.ad.inter.data.k> Z = this.V.Z();
            if (aa.Code(Z)) {
                return new ArrayList();
            }
            boolean C = C();
            for (com.huawei.openalliance.ad.inter.data.k kVar : Z) {
                if (kVar != null) {
                    t tVar = new t(kVar, C);
                    tVar.Code(this.d);
                    this.C.add(tVar);
                }
            }
        }
        return this.C;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getMarket() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.Y();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public MediaContent getMediaContent() {
        VideoOperator videoOperator = getVideoOperator();
        if (videoOperator instanceof c) {
            return ((c) videoOperator).Code();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public int getMinEffectiveShowRatio() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null || !nVar.x()) {
            return 0;
        }
        return this.V.s();
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public long getMinEffectiveShowTime() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null || !nVar.x()) {
            return 0L;
        }
        return this.V.r();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getPrice() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.aa();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public Double getRating() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.X();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getTitle() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.Code();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getUniqueId() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return null;
        }
        return nVar.u();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public Video getVideo() {
        com.huawei.openalliance.ad.inter.data.v B;
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null || (B = nVar.B()) == null) {
            return null;
        }
        return new v(B);
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public VideoOperator getVideoOperator() {
        if (this.D == null) {
            this.D = new c(new bt(this));
        }
        return this.D;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getWhyThisAd() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        return nVar == null ? com.huawei.openalliance.ad.constant.t.al : nVar.g();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void gotoWhyThisAdPage(Context context) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return;
        }
        nVar.Code(context);
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean hasAdvertiserInfo() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return false;
        }
        return nVar.g_();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean isAutoDownloadApp() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return false;
        }
        return nVar.l_();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean isCustomClickAllowed() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        return nVar != null && nVar.x() && this.f8835c;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean isCustomDislikeThisAdEnabled() {
        return this.f8834a;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void onAdClose(Context context, List<String> list) {
        com.huawei.openalliance.ad.inter.data.n nVar;
        if (context == null || (nVar = this.V) == null) {
            return;
        }
        nVar.Code(context, list);
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public boolean onUnityAdClick() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null || !nVar.x()) {
            return false;
        }
        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(this.e, this.V.l(), this.V.ae());
        if (Code.Code()) {
            new g(this.e, this.V).Code(Code.I(), b.Code(this.I));
            return true;
        }
        return false;
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void onUnityAdClose(List<String> list) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null || !nVar.x()) {
            return;
        }
        new g(this.e, this.V).V(list);
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void onUnityAdPhyShow(long j, int i) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null || !nVar.x()) {
            return;
        }
        new g(this.e, this.V).Code(j, i);
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void onUnityAdShow(Long l, Integer num, Integer num2) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null || !nVar.x()) {
            return;
        }
        new g(this.e, this.V).Code(l, num, num2, b.Code(this.I));
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void onUnityAdShowStart() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null || !nVar.x()) {
            return;
        }
        new g(this.e, this.V).Code();
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void onUnityGoWhyShowThis() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null || !nVar.x()) {
            return;
        }
        if (dt.Code(this.e).V()) {
            ge.I("NativeAdImpl", "china rom should not call gotoWhyThisAdPage method");
            return;
        }
        com.huawei.openalliance.ad.utils.v.Code(this.e, this.V.g());
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void recordClickEvent() {
        if (isCustomClickAllowed()) {
            new g(this.e, this.V).Code(b.Code(this.I));
        }
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean recordClickEvent(Bundle bundle) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            return nVar.I(S(), bundle);
        }
        return false;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean recordImpressionEvent(Bundle bundle) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            return nVar.V(S(), bundle);
        }
        return false;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean recordShowStartEvent(Bundle bundle) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return false;
        }
        return nVar.Code(S(), bundle);
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void recordTouchEvent(Bundle bundle) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            nVar.Code(bundle);
        }
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setAdFeedbackListener(AdFeedbackListener adFeedbackListener) {
        this.f = adFeedbackListener;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setAllowCustomClick() {
        this.f8835c = true;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setAutoDownloadApp(boolean z) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return;
        }
        nVar.I(z);
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setDislikeAdListener(DislikeAdListener dislikeAdListener) {
        this.L = dislikeAdListener;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            return;
        }
        nVar.Code(rewardVerifyConfig);
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void triggerClick(Bundle bundle) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null || !nVar.Z(S(), bundle)) {
            return;
        }
        V();
        I();
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void updateContent() {
        long Code = com.huawei.openalliance.ad.utils.v.Code();
        AdContentData l = this.V.l();
        if (l != null) {
            l.V(String.valueOf(Code));
        }
    }
}
