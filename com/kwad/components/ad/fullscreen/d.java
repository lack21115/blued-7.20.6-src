package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.s;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/fullscreen/d.class */
public final class d {
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
                if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(cb)) || com.kwad.sdk.core.response.a.a.cq(cb)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void loadFullScreenVideoAd(KsScene ksScene, final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.components.ad.reward.monitor.a.a(false, covert.getPosId());
        boolean a2 = k.pP().a(covert, "loadFullScreenVideoAd");
        covert.setAdStyle(3);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0357a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.fullscreen.d.1
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(AdResultData adResultData, boolean z) {
                List<AdTemplate> a3 = d.a(SceneImpl.this, adResultData.getAdTemplateList());
                if (a3.isEmpty()) {
                    onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                    i.Z("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                final ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : a3) {
                    arrayList.add(new e(adTemplate));
                    adTemplate.setLoadDataTime(elapsedRealtime2);
                    adTemplate.setLoadFromCache(z);
                }
                com.kwad.components.ad.reward.monitor.a.a(false, (AdTemplate) a3.get(0), a3.size(), elapsedRealtime);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FULLSCREEN, "dataReady").report();
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            fullScreenVideoAdListener.onFullScreenVideoResult(arrayList);
                        } catch (Throwable th) {
                        }
                        try {
                            s.a((Object) fullScreenVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable th2) {
                        }
                    }
                });
                ArrayList arrayList2 = new ArrayList();
                for (KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                    AdTemplate adTemplate2 = ((e) ksFullScreenVideoAd).getAdTemplate();
                    if (com.kwad.components.ad.b.a.a(adTemplate2, false) || com.kwad.sdk.core.response.a.a.cq(com.kwad.sdk.core.response.a.d.cb(adTemplate2))) {
                        arrayList2.add(ksFullScreenVideoAd);
                    }
                }
                if (arrayList2.isEmpty()) {
                    onError(f.ago.errorCode, f.ago.msg);
                    i.Z("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.reward.monitor.a.b(false, (AdTemplate) a3.get(0), a3.size(), elapsedRealtime);
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.Z("fullAd_", "onFullScreenVideoAdCacheFailed");
                        KsAdLoadManager.ac().b(arrayList);
                        fullScreenVideoAdListener.onFullScreenVideoAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.a.a(false, i, str, SceneImpl.this.getPosId());
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        fullScreenVideoAdListener.onError(i, str);
                    }
                });
            }
        }).pj());
    }
}
