package com.kwad.components.ad.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.feed.c;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/e.class */
public final class e {

    /* renamed from: com.kwad.components.ad.feed.e$2  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/e$2.class */
    static final class AnonymousClass2 extends com.kwad.components.core.n.c {
        final /* synthetic */ KsLoadManager.FeedAdListener ek;
        final /* synthetic */ SceneImpl el;
        final /* synthetic */ boolean em;
        final /* synthetic */ long en;

        AnonymousClass2(KsLoadManager.FeedAdListener feedAdListener, SceneImpl sceneImpl, boolean z, long j) {
            this.ek = feedAdListener;
            this.el = sceneImpl;
            this.em = z;
            this.en = j;
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void a(AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adResultData.getAdTemplateList().size());
            String str = null;
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                if (adTemplate != null) {
                    AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                    if (FeedType.checkTypeValid(adTemplate)) {
                        adTemplate.mAdScene = this.el;
                        arrayList.add(new c(adTemplate, this.em));
                    } else {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.a.a.aW(cb)), FeedType.fromInt(adTemplate.type));
                    }
                }
            }
            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            com.kwad.components.ad.feed.monitor.a.x(arrayList.size());
            if (!arrayList.isEmpty()) {
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "dataReady").bw(arrayList.size()).report();
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        final c.a aVar = new c.a(arrayList.size());
                        for (final KsFeedAd ksFeedAd : arrayList) {
                            final c cVar = (c) ksFeedAd;
                            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                            final long elapsedRealtime = SystemClock.elapsedRealtime();
                            cVar.a(new c.b() { // from class: com.kwad.components.ad.feed.e.2.2.1
                                @Override // com.kwad.components.ad.feed.c.b
                                public final void c(int i, String str2) {
                                    com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar + " cnt: " + aVar.aZ());
                                    com.kwad.components.ad.feed.monitor.a.a(((c) ksFeedAd).getAdTemplate(), i, SystemClock.elapsedRealtime() - elapsedRealtime, str2);
                                    if (aVar.ba()) {
                                        com.kwad.components.ad.feed.monitor.a.a(aVar.aZ(), SystemClock.elapsedRealtime() - AnonymousClass2.this.en);
                                        KsAdLoadManager.ac().b(arrayList);
                                        AnonymousClass2.this.ek.onFeedAdLoad(arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            com.kwad.components.ad.feed.monitor.a.d(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg + str : adResultData.testErrorMsg);
            onError(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg + str : adResultData.testErrorMsg);
            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onError");
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void onError(final int i, final String str) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                    com.kwad.components.ad.feed.monitor.a.d(i, str);
                    AnonymousClass2.this.ek.onError(i, str);
                }
            });
        }
    }

    public static void a(KsScene ksScene, final KsLoadManager.FeedAdListener feedAdListener, boolean z) {
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            com.kwad.sdk.core.d.b.e("KsAdFeedLoadManager", "loadConfigFeedAd please init sdk first");
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    KsLoadManager.FeedAdListener feedAdListener2 = KsLoadManager.FeedAdListener.this;
                    int i = com.kwad.sdk.core.network.f.agn.errorCode;
                    feedAdListener2.onError(i, com.kwad.sdk.core.network.f.agn.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl covert = SceneImpl.covert(ksScene);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.a.w(covert.getAdNum());
        boolean a2 = k.pP().a(covert, "loadConfigFeedAd");
        covert.setAdStyle(1);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0527a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new AnonymousClass2(feedAdListener, covert, z, elapsedRealtime)).pj());
    }
}
