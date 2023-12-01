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
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.igexin.assist.sdk.AssistPushConsts;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATRewardedVideoAdapter.class */
public class KSATRewardedVideoAdapter extends CustomRewardVideoAdapter {

    /* renamed from: a  reason: collision with root package name */
    long f6167a;
    int b;
    boolean d;
    String e;
    double f;
    KsRewardVideoAd g;

    /* renamed from: c  reason: collision with root package name */
    boolean f6168c = false;
    boolean h = false;
    boolean i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.ks.KSATRewardedVideoAdapter$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATRewardedVideoAdapter$4.class */
    public final class AnonymousClass4 implements KsLoadManager.RewardVideoAdListener {
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onError(int i, String str) {
            KSATRewardedVideoAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
            KSATRewardedVideoAdapter.this.g = (list == null || list.size() <= 0) ? null : list.get(0);
            if (KSATRewardedVideoAdapter.this.g == null) {
                KSATRewardedVideoAdapter.this.notifyATLoadFail("", "KuaiShou: List<KsRewardVideoAd> is empty");
            } else if (!KSATRewardedVideoAdapter.this.h) {
                if (KSATRewardedVideoAdapter.this.mLoadListener != null) {
                    KSATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (KSATRewardedVideoAdapter.this.mBiddingListener != null) {
                double d = 0.0d;
                try {
                    d = KSATRewardedVideoAdapter.this.g.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(KSATRewardedVideoAdapter.this.g);
                ATBiddingListener aTBiddingListener = KSATRewardedVideoAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onRewardVideoResult(List<KsRewardVideoAd> list) {
            if (KSATRewardedVideoAdapter.this.mLoadListener != null) {
                KSATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }
    }

    static /* synthetic */ void A(KSATRewardedVideoAdapter kSATRewardedVideoAdapter) {
        HashMap hashMap = new HashMap();
        hashMap.put("thirdUserId", kSATRewardedVideoAdapter.mUserId);
        if (!TextUtils.isEmpty(kSATRewardedVideoAdapter.mUserData) && kSATRewardedVideoAdapter.mUserData.contains("{network_placement_id}")) {
            String str = kSATRewardedVideoAdapter.mUserData;
            StringBuilder sb = new StringBuilder();
            sb.append(kSATRewardedVideoAdapter.f6167a);
            kSATRewardedVideoAdapter.mUserData = str.replace("{network_placement_id}", sb.toString());
        }
        hashMap.put("extraData", kSATRewardedVideoAdapter.mUserData);
        int i = 1;
        KsScene.Builder adNum = new KsScene.Builder(kSATRewardedVideoAdapter.f6167a).adNum(1);
        if (kSATRewardedVideoAdapter.b == 2) {
            i = 2;
        }
        KsScene.Builder rewardCallbackExtraData = adNum.screenOrientation(i).rewardCallbackExtraData(hashMap);
        if (!TextUtils.isEmpty(kSATRewardedVideoAdapter.e)) {
            rewardCallbackExtraData.setBidResponseV2(kSATRewardedVideoAdapter.e);
        }
        KsAdSDK.getLoadManager().loadRewardVideoAd(rewardCallbackExtraData.build(), new AnonymousClass4());
    }

    private void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("thirdUserId", this.mUserId);
        if (!TextUtils.isEmpty(this.mUserData) && this.mUserData.contains("{network_placement_id}")) {
            String str = this.mUserData;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6167a);
            this.mUserData = str.replace("{network_placement_id}", sb.toString());
        }
        hashMap.put("extraData", this.mUserData);
        int i = 1;
        KsScene.Builder adNum = new KsScene.Builder(this.f6167a).adNum(1);
        if (this.b == 2) {
            i = 2;
        }
        KsScene.Builder rewardCallbackExtraData = adNum.screenOrientation(i).rewardCallbackExtraData(hashMap);
        if (!TextUtils.isEmpty(this.e)) {
            rewardCallbackExtraData.setBidResponseV2(this.e);
        }
        KsAdSDK.getLoadManager().loadRewardVideoAd(rewardCallbackExtraData.build(), new AnonymousClass4());
    }

    private boolean a(Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.f6167a = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException e) {
        }
        if (map.containsKey("orientation")) {
            this.b = ATInitMediation.getIntFromMap(map, "orientation");
        }
        this.d = true;
        if (map.containsKey("video_muted")) {
            this.d = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "video_muted"));
        }
        if (map2.containsKey(KSATConst.REWARDEDVIDEO_SKIP_AFTER_THIRTY_SECOND)) {
            this.f6168c = ATInitMediation.getBooleanFromMap(map2, KSATConst.REWARDEDVIDEO_SKIP_AFTER_THIRTY_SECOND);
        }
        if (map.containsKey("anythink_gsp")) {
            this.f = ATInitMediation.getDoubleFromMap(map, "anythink_gsp");
        }
        if (map.containsKey(AssistPushConsts.MSG_TYPE_PAYLOAD)) {
            this.e = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD), this.f);
            return true;
        }
        return true;
    }

    static /* synthetic */ int i(KSATRewardedVideoAdapter kSATRewardedVideoAdapter) {
        kSATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ int v(KSATRewardedVideoAdapter kSATRewardedVideoAdapter) {
        kSATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    public void destory() {
        KsRewardVideoAd ksRewardVideoAd = this.g;
        if (ksRewardVideoAd != null) {
            ksRewardVideoAd.setRewardAdInteractionListener(null);
            this.g.setRewardPlayAgainInteractionListener(null);
            this.g = null;
        }
    }

    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.f6167a = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    public String getNetworkName() {
        return KSATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        try {
            return String.valueOf(this.f6167a);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getNetworkSDKVersion() {
        return KSATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        KsRewardVideoAd ksRewardVideoAd = this.g;
        return ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable();
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (a(map, map2)) {
            KSATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATRewardedVideoAdapter.3
                public final void onFail(String str) {
                    KSATRewardedVideoAdapter.this.notifyATLoadFail("", str);
                }

                public final void onSuccess() {
                    KSATRewardedVideoAdapter.A(KSATRewardedVideoAdapter.this);
                }
            });
        } else {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        KsRewardVideoAd ksRewardVideoAd = this.g;
        if (ksRewardVideoAd == null || activity == null) {
            return;
        }
        try {
            ksRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.ks.KSATRewardedVideoAdapter.1
                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onAdClicked() {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onExtraRewardVerify(int i) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    if (KSATRewardedVideoAdapter.this.i) {
                        return;
                    }
                    KSATRewardedVideoAdapter.this.i = true;
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardStepVerify(int i, int i2) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify() {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onReward();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayEnd() {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayError(int i, int i2) {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed(String.valueOf(i), "");
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    try {
                        KSATInitManager.getInstance().a(KSATRewardedVideoAdapter.this.getTrackingInfo().l(), new WeakReference(KSATRewardedVideoAdapter.this.g));
                    } catch (Throwable th) {
                    }
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoSkipToEnd(long j) {
                    KSATRewardedVideoAdapter.i(KSATRewardedVideoAdapter.this);
                }
            });
            this.g.setRewardPlayAgainInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.ks.KSATRewardedVideoAdapter.2
                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onAdClicked() {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onExtraRewardVerify(int i) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    if (KSATRewardedVideoAdapter.this.i) {
                        return;
                    }
                    KSATRewardedVideoAdapter.this.i = true;
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardStepVerify(int i, int i2) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify() {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onAgainReward();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayEnd() {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayEnd();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayError(int i, int i2) {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayFailed(String.valueOf(i), "Again AD, Callback VideoError");
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayStart();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoSkipToEnd(long j) {
                    KSATRewardedVideoAdapter.v(KSATRewardedVideoAdapter.this);
                }
            });
            KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().showLandscape(this.b == 2).skipThirtySecond(this.f6168c).videoSoundEnable(this.d).build();
            this.i = false;
            this.g.showRewardVideoAd(activity, build);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
