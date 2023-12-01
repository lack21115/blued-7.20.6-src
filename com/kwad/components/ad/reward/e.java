package com.kwad.components.ad.reward;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.s;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/e.class */
public final class e {
    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(SceneImpl sceneImpl, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (AdTemplate adTemplate : list) {
            if (adTemplate != null) {
                if (adTemplate.mAdScene == null) {
                    adTemplate.mAdScene = sceneImpl;
                }
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                if (com.kwad.sdk.core.response.a.a.bJ(cb) || com.kwad.sdk.core.response.a.a.cq(cb) || !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(cb))) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void loadRewardVideoAd(KsScene ksScene, final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.components.ad.reward.monitor.a.a(true, covert.getPosId());
        boolean a2 = com.kwad.components.core.r.k.pP().a(covert, "loadRewardVideoAd");
        covert.setAdStyle(2);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0357a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.reward.e.1
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(AdResultData adResultData, boolean z) {
                List<AdTemplate> a3 = e.a(SceneImpl.this, adResultData.getProceedTemplateList());
                if (a3.isEmpty()) {
                    onError(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData.testErrorMsg);
                    com.kwad.sdk.utils.i.Z("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                final ArrayList<KsRewardVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : a3) {
                    arrayList.add(new f(adTemplate));
                    adTemplate.setLoadDataTime(elapsedRealtime2);
                    adTemplate.setLoadFromCache(z);
                }
                com.kwad.components.ad.reward.monitor.a.a(true, (AdTemplate) a3.get(0), a3.size(), elapsedRealtime);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "dataReady").report();
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            KsAdLoadManager.ac().b(arrayList);
                            rewardVideoAdListener.onRewardVideoResult(arrayList);
                        } catch (Throwable th) {
                        }
                        try {
                            s.a((Object) rewardVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable th2) {
                        }
                    }
                });
                final ArrayList arrayList2 = new ArrayList();
                boolean z2 = false;
                for (KsRewardVideoAd ksRewardVideoAd : arrayList) {
                    AdTemplate adTemplate2 = ((f) ksRewardVideoAd).getAdTemplate();
                    AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate2);
                    if (com.kwad.sdk.core.response.a.a.bJ(cb) || com.kwad.sdk.core.response.a.a.cq(cb)) {
                        arrayList2.add(ksRewardVideoAd);
                        z2 = true;
                    } else if (com.kwad.components.ad.b.a.a(adTemplate2, true)) {
                        arrayList2.add(ksRewardVideoAd);
                    }
                }
                if (z2 || !arrayList2.isEmpty()) {
                    com.kwad.components.ad.reward.monitor.a.b(true, (AdTemplate) a3.get(0), a3.size(), elapsedRealtime);
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.utils.i.Z("rewardAd_", "onRewardVideoAdCacheSuccess");
                            rewardVideoAdListener.onRewardVideoAdLoad(arrayList2);
                        }
                    });
                    return;
                }
                onError(com.kwad.sdk.core.network.f.ago.errorCode, com.kwad.sdk.core.network.f.ago.msg);
                com.kwad.sdk.utils.i.Z("rewardAd_", "onRewardVideoAdCacheFailed");
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.a.a(true, i, str, SceneImpl.this.getPosId());
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        rewardVideoAdListener.onError(i, str);
                    }
                });
            }
        }).pj());
    }
}
