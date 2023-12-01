package com.kwad.components.ad.reward;

import android.app.Activity;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/f.class */
public final class f implements com.kwad.components.core.internal.api.a, KsRewardVideoAd {
    private final AdInfo mAdInfo;
    private final AdTemplate mAdTemplate;
    private com.kwad.components.ad.reward.d.g oC;
    private KsRewardVideoAd.RewardAdInteractionListener oD;
    private com.kwad.components.core.g.d oy;
    private com.kwad.components.core.internal.api.c cg = new com.kwad.components.core.internal.api.c();
    public int rewardType = 1;

    public f(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        KsAdGlobalWatcher.getInstance().watch(this);
    }

    private void a(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        fp();
        if (com.kwad.sdk.core.response.a.a.bJ(this.mAdInfo)) {
            AdRewardPreviewActivityProxy.launch(activity, this.mAdTemplate, com.kwad.sdk.core.response.a.a.aK(this.mAdInfo), this.oC);
        } else {
            KSRewardVideoActivityProxy.launch(activity, this.mAdTemplate, ksVideoPlayConfig, this.oC, this.oD, this.oy, this.rewardType);
        }
    }

    private void fp() {
        AdInfo adInfo;
        if (com.kwad.components.ad.reward.b.c.a(this.oC) || (adInfo = this.mAdInfo) == null) {
            return;
        }
        adInfo.adBaseInfo.extraClickReward = false;
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

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aJ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aI(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
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

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final boolean isAdEnable() {
        if (com.kwad.sdk.core.config.d.ux() >= 0) {
            return true;
        }
        return com.kwad.components.core.video.h.i(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setBidEcpm(long j, long j2) {
        this.mAdTemplate.mBidEcpm = j;
        com.kwad.sdk.core.report.a.i(this.mAdTemplate, j2);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener) {
        this.oy = new com.kwad.components.core.g.d(ksInnerAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (this.oC == null) {
            this.oC = new com.kwad.components.ad.reward.d.g() { // from class: com.kwad.components.ad.reward.f.1
                @Override // com.kwad.components.ad.reward.d.g, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    f.this.cg.b(f.this);
                }

                @Override // com.kwad.components.ad.reward.d.g, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    f.this.cg.a(f.this);
                }
            };
        }
        this.oC.b(rewardAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setRewardPlayAgainInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.oD = rewardAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.b.e("KsRewardVideoAdControl", "showRewardVideoAd error, activity is null or finished");
            return;
        }
        com.kwad.sdk.g.a.U("reward", "show");
        com.kwad.components.ad.reward.monitor.a.a(true, this.mAdTemplate);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "callShow").report();
        if (!isAdEnable()) {
            com.kwad.sdk.core.d.b.i("KsRewardVideoAdControl", "isAdEnable is false");
            com.kwad.sdk.g.a.V("reward", "show");
            return;
        }
        KsVideoPlayConfig ksVideoPlayConfig2 = ksVideoPlayConfig;
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig2 = new KsVideoPlayConfig.Builder().build();
        }
        a(activity, ksVideoPlayConfig2);
    }
}
