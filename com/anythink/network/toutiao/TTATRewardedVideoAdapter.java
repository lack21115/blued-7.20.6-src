package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.igexin.assist.sdk.AssistPushConsts;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATRewardedVideoAdapter.class */
public class TTATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    boolean b;
    private TTRewardVideoAd i;
    private Map<String, Object> j;
    private final String h = getClass().getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f6295a = "";

    /* renamed from: c  reason: collision with root package name */
    String f6296c = "";
    boolean d = false;
    TTAdNative.RewardVideoAdListener e = new TTAdNative.RewardVideoAdListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.1
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public final void onError(int i, String str) {
            TTATRewardedVideoAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            try {
                if (TTATRewardedVideoAdapter.this.mLoadListener != null) {
                    TTATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            TTATRewardedVideoAdapter.this.i = tTRewardVideoAd;
            try {
                Map<String, Object> mediaExtraInfo = TTATRewardedVideoAdapter.this.i.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (TTATRewardedVideoAdapter.this.j == null) {
                        TTATRewardedVideoAdapter.this.j = new HashMap(3);
                    }
                    TTATRewardedVideoAdapter.this.j.putAll(mediaExtraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (TTATRewardedVideoAdapter.this.d) {
                try {
                    TTATInitManager.getInstance().a(TTATRewardedVideoAdapter.this.j, TTATRewardedVideoAdapter.this.i, TTATRewardedVideoAdapter.this.mBiddingListener);
                    return;
                } catch (Throwable th2) {
                    return;
                }
            }
            try {
                if (TTATRewardedVideoAdapter.this.mLoadListener != null) {
                    TTATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    };
    TTRewardVideoAd.RewardAdInteractionListener f = new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.2
        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdClose() {
            if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdShow() {
            try {
                TTATInitManager.getInstance().a(TTATRewardedVideoAdapter.this.getTrackingInfo().l(), new WeakReference(TTATRewardedVideoAdapter.this.i));
            } catch (Exception e) {
            }
            if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdVideoBarClick() {
            if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onRewardArrived(boolean z, int i, Bundle bundle) {
            Log.i(TTATRewardedVideoAdapter.this.h, "onRewardArrived(), rewardVerify: ".concat(String.valueOf(z)));
            if (!z || TTATRewardedVideoAdapter.this.b || TTATRewardedVideoAdapter.this.mImpressionListener == null) {
                return;
            }
            TTATRewardedVideoAdapter.this.b = true;
            TTATRewardedVideoAdapter.this.mImpressionListener.onReward();
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onSkippedVideo() {
            TTATRewardedVideoAdapter.o(TTATRewardedVideoAdapter.this);
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onVideoComplete() {
            if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onVideoError() {
            if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed("", "Callback VideoError");
            }
        }
    };
    private boolean k = false;
    TTAppDownloadListener g = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.6
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, String str, String str2) {
            if (TTATRewardedVideoAdapter.this.k) {
                if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                TTATRewardedVideoAdapter.this.mDownloadListener.onDownloadUpdate(j, j2, str, str2);
                return;
            }
            TTATRewardedVideoAdapter.M(TTATRewardedVideoAdapter.this);
            if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATRewardedVideoAdapter.this.mDownloadListener.onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, String str, String str2) {
            if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATRewardedVideoAdapter.this.mDownloadListener.onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, String str, String str2) {
            if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATRewardedVideoAdapter.this.mDownloadListener.onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, String str, String str2) {
            if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATRewardedVideoAdapter.this.mDownloadListener.onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATRewardedVideoAdapter.this.mDownloadListener.onInstalled(str, str2);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.toutiao.TTATRewardedVideoAdapter$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATRewardedVideoAdapter$3.class */
    public final class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6299a;
        final /* synthetic */ Map b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f6300c;

        AnonymousClass3(Context context, Map map, Map map2) {
            this.f6299a = context;
            this.b = map;
            this.f6300c = map2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(this.f6299a);
            TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(TTATRewardedVideoAdapter.this.f6295a, this.b, this.f6300c);
            int i = this.f6299a.getResources().getDisplayMetrics().widthPixels;
            int i2 = this.f6299a.getResources().getDisplayMetrics().heightPixels;
            try {
                String obj = this.b.get("personalized_template").toString();
                if (!TextUtils.isEmpty(obj) && TextUtils.equals("1", obj)) {
                    tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(TTATRewardedVideoAdapter.a(this.f6299a, i), TTATRewardedVideoAdapter.a(this.f6299a, i2));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Map map = this.f6300c;
            if (map != null) {
                try {
                    tTATCustomAdSlotBuilder.setSupportDeepLink(((Boolean) map.get("ad_is_support_deep_link")).booleanValue());
                } catch (Exception e) {
                }
                try {
                    int parseInt = Integer.parseInt(this.f6300c.get("ad_orientation").toString());
                    if (parseInt == 1) {
                        tTATCustomAdSlotBuilder.setOrientation(1);
                    } else if (parseInt == 2) {
                        tTATCustomAdSlotBuilder.setOrientation(2);
                    }
                } catch (Exception e2) {
                }
            }
            if (!TextUtils.isEmpty(TTATRewardedVideoAdapter.this.mUserId)) {
                tTATCustomAdSlotBuilder.setUserID(TTATRewardedVideoAdapter.this.mUserId);
            }
            if (!TextUtils.isEmpty(TTATRewardedVideoAdapter.this.mUserData)) {
                if (TTATRewardedVideoAdapter.this.mUserData.contains("{network_placement_id}")) {
                    TTATRewardedVideoAdapter tTATRewardedVideoAdapter = TTATRewardedVideoAdapter.this;
                    tTATRewardedVideoAdapter.mUserData = tTATRewardedVideoAdapter.mUserData.replace("{network_placement_id}", TTATRewardedVideoAdapter.this.f6295a);
                }
                tTATCustomAdSlotBuilder.setMediaExtra(TTATRewardedVideoAdapter.this.mUserData);
            }
            tTATCustomAdSlotBuilder.setAdCount(1);
            createAdNative.loadRewardVideoAd(tTATCustomAdSlotBuilder.build(), TTATRewardedVideoAdapter.this.e);
        }
    }

    static /* synthetic */ int K(TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ boolean M(TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.k = true;
        return true;
    }

    static /* synthetic */ int a(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = f2;
        if (f2 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f / f3) + 0.5f);
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        runOnNetworkRequestThread(new AnonymousClass3(context.getApplicationContext(), map, map2));
    }

    static /* synthetic */ void a(TTATRewardedVideoAdapter tTATRewardedVideoAdapter, Context context, Map map, Map map2) {
        tTATRewardedVideoAdapter.runOnNetworkRequestThread(new AnonymousClass3(context.getApplicationContext(), map, map2));
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.f6295a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.f6295a)) {
            return false;
        }
        this.f6296c = ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD);
        return true;
    }

    private static int b(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = f2;
        if (f2 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f / f3) + 0.5f);
    }

    static /* synthetic */ int o(TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    public void destory() {
        TTRewardVideoAd tTRewardVideoAd = this.i;
        if (tTRewardVideoAd != null) {
            tTRewardVideoAd.setRewardAdInteractionListener(null);
            this.i.setRewardPlayAgainInteractionListener(null);
            this.i = null;
        }
        this.e = null;
        this.f = null;
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.j;
    }

    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.f6295a;
    }

    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        return this.i != null;
    }

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        boolean z;
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.f6295a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.f6295a)) {
            z = false;
        } else {
            this.f6296c = ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD);
            z = true;
        }
        if (z) {
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.5
                public final void onFail(String str) {
                    TTATRewardedVideoAdapter.this.notifyATLoadFail("", str);
                }

                public final void onSuccess() {
                    try {
                        TTATRewardedVideoAdapter.a(TTATRewardedVideoAdapter.this, context, map, map2);
                    } catch (Throwable th) {
                        TTATRewardedVideoAdapter.this.notifyATLoadFail("", th.getMessage());
                    }
                }
            });
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        TTRewardVideoAd tTRewardVideoAd;
        if (activity == null || (tTRewardVideoAd = this.i) == null) {
            return;
        }
        tTRewardVideoAd.setRewardAdInteractionListener(this.f);
        this.i.setDownloadListener(this.g);
        this.i.setRewardPlayAgainInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.4
            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onAdClose() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onAdShow() {
                TTATRewardedVideoAdapter.this.b = false;
                try {
                    Map<String, Object> mediaExtraInfo = TTATRewardedVideoAdapter.this.i.getMediaExtraInfo();
                    if (mediaExtraInfo != null) {
                        if (TTATRewardedVideoAdapter.this.j == null) {
                            TTATRewardedVideoAdapter.this.j = new HashMap(3);
                        }
                        TTATRewardedVideoAdapter.this.j.clear();
                        TTATRewardedVideoAdapter.this.j.putAll(mediaExtraInfo);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                    TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayStart();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onAdVideoBarClick() {
                if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                    TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onRewardArrived(boolean z, int i, Bundle bundle) {
                Log.i(TTATRewardedVideoAdapter.this.h, "Again AD, onRewardArrived(), rewardVerify: ".concat(String.valueOf(z)));
                if (!z || TTATRewardedVideoAdapter.this.b || TTATRewardedVideoAdapter.this.mImpressionListener == null) {
                    return;
                }
                TTATRewardedVideoAdapter.this.b = true;
                TTATRewardedVideoAdapter.this.mImpressionListener.onAgainReward();
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onSkippedVideo() {
                TTATRewardedVideoAdapter.K(TTATRewardedVideoAdapter.this);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onVideoComplete() {
                if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                    TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayEnd();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onVideoError() {
                if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                    TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayFailed("", "Again AD, Callback VideoError");
                }
            }
        });
        this.i.showRewardVideoAd(activity);
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.d = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
