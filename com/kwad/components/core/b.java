package com.kwad.components.core;

import android.app.Activity;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kwad.components.ad.a.d;
import com.kwad.components.ad.a.e;
import com.kwad.components.ad.a.g;
import com.kwad.components.ad.a.h;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b.class */
public final class b implements KsLoadManager {
    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestToken(KsScene ksScene) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) c.f(com.kwad.components.ad.a.a.class);
        return aVar != null ? aVar.getBidRequestToken(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestTokenV2(KsScene ksScene) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) c.f(com.kwad.components.ad.a.a.class);
        return aVar != null ? aVar.getBidRequestTokenV2(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadConfigFeedAd(KsScene ksScene, final KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.sdk.g.a.U(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "loadRequest").bw(ksScene.getAdNum()).report();
        com.kwad.components.ad.a.c cVar = (com.kwad.components.ad.a.c) c.f(com.kwad.components.ad.a.c.class);
        if (cVar != null) {
            cVar.loadConfigFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.4
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i, String str) {
                    feedAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
            com.kwad.sdk.g.a.V(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            feedAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadDrawAd(KsScene ksScene, final KsLoadManager.DrawAdListener drawAdListener) {
        com.kwad.sdk.g.a.U("draw", "request");
        com.kwad.components.ad.a.b bVar = (com.kwad.components.ad.a.b) c.f(com.kwad.components.ad.a.b.class);
        if (bVar != null) {
            bVar.loadDrawAd(ksScene, new KsLoadManager.DrawAdListener() { // from class: com.kwad.components.core.b.5
                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onDrawAdLoad(List<KsDrawAd> list) {
                    drawAdListener.onDrawAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onError(int i, String str) {
                    drawAdListener.onError(i, str);
                }
            });
            com.kwad.sdk.g.a.V("draw", "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            drawAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFeedAd(KsScene ksScene, final KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.sdk.g.a.U(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "loadRequest").bw(ksScene.getAdNum()).report();
        com.kwad.components.ad.a.c cVar = (com.kwad.components.ad.a.c) c.f(com.kwad.components.ad.a.c.class);
        if (cVar != null) {
            cVar.loadFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.3
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i, String str) {
                    feedAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
            com.kwad.sdk.g.a.V(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            feedAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFullScreenVideoAd(KsScene ksScene, final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        com.kwad.sdk.g.a.U("fullscreen", "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FULLSCREEN, "loadRequest").report();
        d dVar = (d) c.f(d.class);
        if (dVar != null) {
            dVar.loadFullScreenVideoAd(ksScene, new KsLoadManager.FullScreenVideoAdListener() { // from class: com.kwad.components.core.b.1
                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onError(int i, String str) {
                    fullScreenVideoAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoResult(List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoResult(list);
                }
            });
            com.kwad.sdk.g.a.V("fullscreen", "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            fullScreenVideoAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadInterstitialAd(KsScene ksScene, final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        com.kwad.sdk.g.a.U(com.anythink.expressad.foundation.g.a.f.d, "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_INTERSTITIAL, "loadRequest").report();
        e eVar = (e) c.f(e.class);
        if (eVar != null) {
            eVar.loadInterstitialAd(ksScene, new KsLoadManager.InterstitialAdListener() { // from class: com.kwad.components.core.b.8
                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onError(int i, String str) {
                    interstitialAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onInterstitialAdLoad(List<KsInterstitialAd> list) {
                    interstitialAdListener.onInterstitialAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onRequestResult(int i) {
                    interstitialAdListener.onRequestResult(i);
                }
            });
            com.kwad.sdk.g.a.V(com.anythink.expressad.foundation.g.a.f.d, "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            interstitialAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(KsScene ksScene, final KsLoadManager.NativeAdListener nativeAdListener) {
        com.kwad.sdk.g.a.U(com.anythink.expressad.foundation.g.a.f.f4992a, "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "loadRequest").bw(ksScene.getAdNum()).report();
        com.kwad.components.ad.a.f fVar = (com.kwad.components.ad.a.f) c.f(com.kwad.components.ad.a.f.class);
        if (fVar != null) {
            fVar.loadNativeAd(ksScene, new KsLoadManager.NativeAdListener() { // from class: com.kwad.components.core.b.6
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onError(int i, String str) {
                    nativeAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onNativeAdLoad(List<KsNativeAd> list) {
                    nativeAdListener.onNativeAdLoad(list);
                }
            });
            com.kwad.sdk.g.a.V(com.anythink.expressad.foundation.g.a.f.f4992a, "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar2 = f.agk;
            nativeAdListener.onError(fVar2.errorCode, fVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(String str, KsLoadManager.NativeAdListener nativeAdListener) {
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "loadRequest").aW(true).report();
        com.kwad.components.ad.a.f fVar = (com.kwad.components.ad.a.f) c.f(com.kwad.components.ad.a.f.class);
        if (fVar != null) {
            fVar.loadNativeAd(str, nativeAdListener);
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar2 = f.agk;
            nativeAdListener.onError(fVar2.errorCode, fVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadRewardVideoAd(KsScene ksScene, final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        com.kwad.sdk.g.a.U("reward", "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "loadRequest").report();
        g gVar = (g) c.f(g.class);
        if (gVar != null) {
            gVar.loadRewardVideoAd(ksScene, new KsLoadManager.RewardVideoAdListener() { // from class: com.kwad.components.core.b.2
                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onError(int i, String str) {
                    rewardVideoAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoResult(List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoResult(list);
                }
            });
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            rewardVideoAdListener.onError(fVar.errorCode, fVar.msg);
        }
        com.kwad.sdk.g.a.V("reward", "request");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadSplashScreenAd(KsScene ksScene, final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        com.kwad.sdk.g.a.U(com.anythink.expressad.foundation.g.a.f.f, "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "loadRequest").report();
        h hVar = (h) c.f(h.class);
        if (hVar != null) {
            hVar.loadSplashScreenAd(ksScene, new KsLoadManager.SplashScreenAdListener() { // from class: com.kwad.components.core.b.7
                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onError(int i, String str) {
                    splashScreenAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onRequestResult(int i) {
                    splashScreenAdListener.onRequestResult(i);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
                    splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                }
            });
            com.kwad.sdk.g.a.V(com.anythink.expressad.foundation.g.a.f.f, "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            splashScreenAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) c.f(com.kwad.components.ad.a.a.class);
        if (aVar != null) {
            return aVar.showInstallDialog(activity, ksExitInstallListener);
        }
        return false;
    }
}
