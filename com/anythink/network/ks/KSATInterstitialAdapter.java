package com.anythink.network.ks;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.igexin.assist.sdk.AssistPushConsts;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATInterstitialAdapter.class */
public class KSATInterstitialAdapter extends CustomInterstitialAdapter {

    /* renamed from: a  reason: collision with root package name */
    long f6154a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    boolean f6155c;
    String e;
    KsFullScreenVideoAd f;
    KsInterstitialAd g;
    double i;
    int d = 1;
    boolean h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.ks.KSATInterstitialAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATInterstitialAdapter$2.class */
    public final class AnonymousClass2 implements KsLoadManager.InterstitialAdListener {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onError(int i, String str) {
            KSATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onInterstitialAdLoad(List<KsInterstitialAd> list) {
            KSATInterstitialAdapter.this.g = (list == null || list.size() <= 0) ? null : list.get(0);
            if (KSATInterstitialAdapter.this.g == null) {
                KSATInterstitialAdapter.this.notifyATLoadFail("", "KuaiShou: List<KsInterstitialAd> is empty.");
            } else if (!KSATInterstitialAdapter.this.h) {
                if (KSATInterstitialAdapter.this.mLoadListener != null) {
                    KSATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (KSATInterstitialAdapter.this.mBiddingListener == null) {
                KSATInterstitialAdapter.this.notifyATLoadFail("", "KuaiShou: KsInterstitialAd had been destroyed.");
            } else {
                double d = 0.0d;
                try {
                    d = KSATInterstitialAdapter.this.g.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(KSATInterstitialAdapter.this.g);
                ATBiddingListener aTBiddingListener = KSATInterstitialAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onRequestResult(int i) {
            if (KSATInterstitialAdapter.this.mLoadListener != null) {
                KSATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.ks.KSATInterstitialAdapter$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATInterstitialAdapter$3.class */
    public final class AnonymousClass3 implements KsLoadManager.FullScreenVideoAdListener {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onError(int i, String str) {
            KSATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list) {
            KSATInterstitialAdapter.this.f = (list == null || list.size() <= 0) ? null : list.get(0);
            if (KSATInterstitialAdapter.this.f == null) {
                KSATInterstitialAdapter.this.notifyATLoadFail("", "KuaiShou: List<KsFullScreenVideoAd> is empty.");
            } else if (!KSATInterstitialAdapter.this.h) {
                if (KSATInterstitialAdapter.this.mLoadListener != null) {
                    KSATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (KSATInterstitialAdapter.this.mBiddingListener == null) {
                KSATInterstitialAdapter.this.notifyATLoadFail("", "KuaiShou: KsFullScreenVideoAd had been destroyed.");
            } else {
                double d = 0.0d;
                try {
                    d = KSATInterstitialAdapter.this.f.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(KSATInterstitialAdapter.this.f);
                ATBiddingListener aTBiddingListener = KSATInterstitialAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onFullScreenVideoResult(List<KsFullScreenVideoAd> list) {
            if (KSATInterstitialAdapter.this.mLoadListener != null) {
                KSATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }
    }

    static /* synthetic */ int H(KSATInterstitialAdapter kSATInterstitialAdapter) {
        kSATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    private void a() {
        int i = 1;
        KsScene.Builder adNum = new KsScene.Builder(this.f6154a).adNum(1);
        if (this.b == 2) {
            i = 2;
        }
        KsScene.Builder screenOrientation = adNum.screenOrientation(i);
        if (!TextUtils.isEmpty(this.e)) {
            screenOrientation.setBidResponseV2(this.e);
        }
        KsScene build = screenOrientation.build();
        if (this.d == 0) {
            KsAdSDK.getLoadManager().loadInterstitialAd(build, new AnonymousClass2());
        } else {
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(build, new AnonymousClass3());
        }
    }

    static /* synthetic */ void a(KSATInterstitialAdapter kSATInterstitialAdapter) {
        int i = 1;
        KsScene.Builder adNum = new KsScene.Builder(kSATInterstitialAdapter.f6154a).adNum(1);
        if (kSATInterstitialAdapter.b == 2) {
            i = 2;
        }
        KsScene.Builder screenOrientation = adNum.screenOrientation(i);
        if (!TextUtils.isEmpty(kSATInterstitialAdapter.e)) {
            screenOrientation.setBidResponseV2(kSATInterstitialAdapter.e);
        }
        KsScene build = screenOrientation.build();
        if (kSATInterstitialAdapter.d == 0) {
            KsAdSDK.getLoadManager().loadInterstitialAd(build, new AnonymousClass2());
        } else {
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(build, new AnonymousClass3());
        }
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.f6154a = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException e) {
        }
        this.f6155c = true;
        if (map.containsKey("video_muted")) {
            this.f6155c = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "video_muted"));
        }
        if (map.containsKey("orientation")) {
            this.b = ATInitMediation.getIntFromMap(map, "orientation");
        }
        if (map.containsKey("is_video")) {
            this.d = ATInitMediation.getIntFromMap(map, "is_video", 1);
        }
        if (map.containsKey("anythink_gsp")) {
            this.i = ATInitMediation.getDoubleFromMap(map, "anythink_gsp");
        }
        if (map.containsKey(AssistPushConsts.MSG_TYPE_PAYLOAD)) {
            this.e = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD), this.i);
            return true;
        }
        return true;
    }

    static /* synthetic */ int u(KSATInterstitialAdapter kSATInterstitialAdapter) {
        kSATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    public void destory() {
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f;
        if (ksFullScreenVideoAd != null) {
            ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
            this.f = null;
        }
    }

    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.f6154a = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    public String getNetworkName() {
        return KSATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        try {
            return String.valueOf(this.f6154a);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getNetworkSDKVersion() {
        return KSATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        if (this.d == 0) {
            return this.g != null;
        }
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f;
        return ksFullScreenVideoAd != null && ksFullScreenVideoAd.isAdEnable();
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (a(map)) {
            KSATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATInterstitialAdapter.1
                public final void onFail(String str) {
                    KSATInterstitialAdapter.this.notifyATLoadFail("", str);
                }

                public final void onSuccess() {
                    KSATInterstitialAdapter.a(KSATInterstitialAdapter.this);
                }
            });
        } else {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().showLandscape(this.b == 2).skipThirtySecond(false).videoSoundEnable(this.f6155c).build();
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f;
        if (ksFullScreenVideoAd != null && activity != null) {
            ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new KsFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.anythink.network.ks.KSATInterstitialAdapter.4
                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onAdClicked() {
                    if (KSATInterstitialAdapter.this.mImpressListener != null) {
                        KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    if (KSATInterstitialAdapter.this.mImpressListener != null) {
                        KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onSkippedVideo() {
                    KSATInterstitialAdapter.u(KSATInterstitialAdapter.this);
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayEnd() {
                    if (KSATInterstitialAdapter.this.mImpressListener != null) {
                        KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayError(int i, int i2) {
                    if (KSATInterstitialAdapter.this.mImpressListener != null) {
                        KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(String.valueOf(i), "");
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayStart() {
                    try {
                        KSATInitManager.getInstance().a(KSATInterstitialAdapter.this.getTrackingInfo().l(), new WeakReference(KSATInterstitialAdapter.this.f));
                    } catch (Throwable th) {
                    }
                    if (KSATInterstitialAdapter.this.mImpressListener != null) {
                        KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                        KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
                    }
                }
            });
            this.f.showFullScreenVideoAd(activity, build);
        }
        KsInterstitialAd ksInterstitialAd = this.g;
        if (ksInterstitialAd == null || activity == null) {
            return;
        }
        ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.anythink.network.ks.KSATInterstitialAdapter.5
            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onAdClicked() {
                if (KSATInterstitialAdapter.this.mImpressListener != null) {
                    KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onAdClosed() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onAdShow() {
                try {
                    KSATInitManager.getInstance().a(KSATInterstitialAdapter.this.getTrackingInfo().l(), new WeakReference(KSATInterstitialAdapter.this.g));
                } catch (Throwable th) {
                }
                if (KSATInterstitialAdapter.this.mImpressListener != null) {
                    KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onPageDismiss() {
                if (KSATInterstitialAdapter.this.mImpressListener != null) {
                    KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onSkippedAd() {
                KSATInterstitialAdapter.H(KSATInterstitialAdapter.this);
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onVideoPlayEnd() {
                if (KSATInterstitialAdapter.this.mImpressListener != null) {
                    KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onVideoPlayError(int i, int i2) {
                if (KSATInterstitialAdapter.this.mImpressListener != null) {
                    KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(String.valueOf(i), String.valueOf(i2));
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onVideoPlayStart() {
                if (KSATInterstitialAdapter.this.mImpressListener != null) {
                    KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
                }
            }
        });
        this.g.showInterstitialAd(activity, build);
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
