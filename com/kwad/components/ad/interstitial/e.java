package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/e.class */
public final class e {
    public static void loadInterstitialAd(KsScene ksScene, final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            com.kwad.sdk.core.d.b.e("KsAdInterstitialLoadManager", "loadInterstitialAd please init sdk first");
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    KsLoadManager.InterstitialAdListener interstitialAdListener2 = KsLoadManager.InterstitialAdListener.this;
                    int i = f.agn.errorCode;
                    interstitialAdListener2.onError(i, f.agn.msg + "sdk not init");
                }
            });
            return;
        }
        final SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a2 = k.pP().a(covert, "loadInterstitialAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        covert.setAdStyle(13);
        com.kwad.components.ad.interstitial.monitor.b.cR();
        com.kwad.components.ad.interstitial.monitor.b.g(covert.getPosId());
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0357a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.interstitial.e.2
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(AdResultData adResultData, boolean z) {
                b bVar;
                final List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                if (adTemplateList.isEmpty()) {
                    onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                    i.Z("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            interstitialAdListener.onRequestResult(adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                });
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.a(adTemplateList.get(0), elapsedRealtime, z);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_INTERSTITIAL, "dataReady").report();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            adTemplate.mAdScene = SceneImpl.this;
                        }
                        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
                            bVar = new b(SceneImpl.this, adTemplate);
                        } else if (com.kwad.components.ad.interstitial.monitor.a.f(adTemplate)) {
                            bVar = new b(SceneImpl.this, adTemplate);
                        }
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() == 0) {
                    onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                    i.Z("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.b(adTemplateList.get(0), elapsedRealtime2, z);
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsAdLoadManager.ac().b(arrayList);
                        i.Z("insertAd_", "onInterstitialAdCacheSuccess");
                        interstitialAdListener.onInterstitialAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.a(i, str, SceneImpl.this.getPosId());
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        interstitialAdListener.onError(i, str);
                    }
                });
            }
        }).pj());
    }
}
