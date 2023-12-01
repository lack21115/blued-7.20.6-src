package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.igexin.assist.sdk.AssistPushConsts;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATInterstitialAdapter.class */
public class TTATInterstitialAdapter extends CustomInterstitialAdapter {
    private TTInteractionAd k;
    private TTFullScreenVideoAd l;
    private Map<String, Object> m;
    private final String j = getClass().getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f6266a = "";
    int b = 1;

    /* renamed from: c  reason: collision with root package name */
    String f6267c = "";
    boolean d = false;
    TTAdNative.InteractionAdListener e = new TTAdNative.InteractionAdListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.1
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public final void onError(int i, String str) {
            TTATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener
        public final void onInteractionAdLoad(TTInteractionAd tTInteractionAd) {
            TTATInterstitialAdapter.this.k = tTInteractionAd;
            try {
                Map<String, Object> mediaExtraInfo = TTATInterstitialAdapter.this.k.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (TTATInterstitialAdapter.this.m == null) {
                        TTATInterstitialAdapter.this.m = new HashMap(3);
                    }
                    TTATInterstitialAdapter.this.m.putAll(mediaExtraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (TTATInterstitialAdapter.this.d) {
                try {
                    TTATInitManager.getInstance().a(TTATInterstitialAdapter.this.m, TTATInterstitialAdapter.this.k, TTATInterstitialAdapter.this.mBiddingListener);
                    return;
                } catch (Throwable th2) {
                    return;
                }
            }
            try {
                if (TTATInterstitialAdapter.this.mLoadListener != null) {
                    TTATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    };
    TTInteractionAd.AdInteractionListener f = new TTInteractionAd.AdInteractionListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.2
        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public final void onAdClicked() {
            if (TTATInterstitialAdapter.this.mImpressListener != null) {
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public final void onAdDismiss() {
            if (TTATInterstitialAdapter.this.mImpressListener != null) {
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public final void onAdShow() {
            try {
                TTATInitManager.getInstance().a(TTATInterstitialAdapter.this.getTrackingInfo().l(), new WeakReference(TTATInterstitialAdapter.this.k));
            } catch (Throwable th) {
            }
            if (TTATInterstitialAdapter.this.mImpressListener != null) {
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
            }
        }
    };
    TTAdNative.FullScreenVideoAdListener g = new TTAdNative.FullScreenVideoAdListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.3
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public final void onError(int i, String str) {
            TTATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            try {
                if (TTATInterstitialAdapter.this.mLoadListener != null) {
                    TTATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
                }
            } catch (Throwable th) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            TTATInterstitialAdapter.this.l = tTFullScreenVideoAd;
            try {
                Map<String, Object> mediaExtraInfo = TTATInterstitialAdapter.this.l.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (TTATInterstitialAdapter.this.m == null) {
                        TTATInterstitialAdapter.this.m = new HashMap(3);
                    }
                    TTATInterstitialAdapter.this.m.putAll(mediaExtraInfo);
                }
            } catch (Throwable th) {
            }
            if (TTATInterstitialAdapter.this.d) {
                try {
                    TTATInitManager.getInstance().a(TTATInterstitialAdapter.this.m, TTATInterstitialAdapter.this.l, TTATInterstitialAdapter.this.mBiddingListener);
                    return;
                } catch (Throwable th2) {
                    return;
                }
            }
            try {
                if (TTATInterstitialAdapter.this.mLoadListener != null) {
                    TTATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } catch (Throwable th3) {
            }
        }
    };
    TTFullScreenVideoAd.FullScreenVideoAdInteractionListener h = new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.4
        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdClose() {
            if (TTATInterstitialAdapter.this.mImpressListener != null) {
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdShow() {
            try {
                TTATInitManager.getInstance().a(TTATInterstitialAdapter.this.getTrackingInfo().l(), new WeakReference(TTATInterstitialAdapter.this.l));
            } catch (Exception e) {
            }
            if (TTATInterstitialAdapter.this.mImpressListener != null) {
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdVideoBarClick() {
            if (TTATInterstitialAdapter.this.mImpressListener != null) {
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onSkippedVideo() {
            TTATInterstitialAdapter.y(TTATInterstitialAdapter.this);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onVideoComplete() {
            if (TTATInterstitialAdapter.this.mImpressListener != null) {
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
            }
        }
    };
    private boolean n = false;
    TTAppDownloadListener i = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.7
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, String str, String str2) {
            if (TTATInterstitialAdapter.this.n) {
                if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                TTATInterstitialAdapter.this.mDownloadListener.onDownloadUpdate(j, j2, str, str2);
                return;
            }
            TTATInterstitialAdapter.A(TTATInterstitialAdapter.this);
            if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATInterstitialAdapter.this.mDownloadListener.onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, String str, String str2) {
            if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATInterstitialAdapter.this.mDownloadListener.onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, String str, String str2) {
            if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATInterstitialAdapter.this.mDownloadListener.onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, String str, String str2) {
            if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATInterstitialAdapter.this.mDownloadListener.onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATInterstitialAdapter.this.mDownloadListener.onInstalled(str, str2);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.toutiao.TTATInterstitialAdapter$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATInterstitialAdapter$5.class */
    public final class AnonymousClass5 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6272a;
        final /* synthetic */ Map b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f6273c;

        AnonymousClass5(Context context, Map map, Map map2) {
            this.f6272a = context;
            this.b = map;
            this.f6273c = map2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(this.f6272a);
            TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(TTATInterstitialAdapter.this.f6266a, this.b, this.f6273c);
            tTATCustomAdSlotBuilder.setAdCount(1);
            tTATCustomAdSlotBuilder.setOrientation(TTATInterstitialAdapter.this.b);
            createAdNative.loadFullScreenVideoAd(tTATCustomAdSlotBuilder.build(), TTATInterstitialAdapter.this.g);
        }
    }

    static /* synthetic */ boolean A(TTATInterstitialAdapter tTATInterstitialAdapter) {
        tTATInterstitialAdapter.n = true;
        return true;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        runOnNetworkRequestThread(new AnonymousClass5(context.getApplicationContext(), map, map2));
    }

    static /* synthetic */ void a(TTATInterstitialAdapter tTATInterstitialAdapter, Context context, Map map, Map map2) {
        tTATInterstitialAdapter.runOnNetworkRequestThread(new AnonymousClass5(context.getApplicationContext(), map, map2));
    }

    private boolean a(Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.f6266a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.f6266a)) {
            return false;
        }
        try {
            int intFromMap = ATInitMediation.getIntFromMap(map2, "ad_orientation", 1);
            if (intFromMap == 1) {
                this.b = 1;
            } else if (intFromMap == 2) {
                this.b = 2;
            }
        } catch (Exception e) {
        }
        this.f6267c = ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD);
        return true;
    }

    static /* synthetic */ int y(TTATInterstitialAdapter tTATInterstitialAdapter) {
        tTATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    public void destory() {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.l;
        if (tTFullScreenVideoAd != null) {
            tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
            this.l = null;
        }
        TTInteractionAd tTInteractionAd = this.k;
        if (tTInteractionAd != null) {
            tTInteractionAd.setAdInteractionListener(null);
            this.k.setDownloadListener(null);
            this.k = null;
        }
        this.f = null;
        this.e = null;
        this.h = null;
        this.g = null;
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.m;
    }

    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.f6266a;
    }

    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        return (this.k == null && this.l == null) ? false : true;
    }

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        if (a(map, map2)) {
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.6
                public final void onFail(String str) {
                    TTATInterstitialAdapter.this.notifyATLoadFail("", str);
                }

                public final void onSuccess() {
                    try {
                        TTATInterstitialAdapter.a(TTATInterstitialAdapter.this, context, map, map2);
                    } catch (Throwable th) {
                        TTATInterstitialAdapter.this.notifyATLoadFail("", th.getMessage());
                    }
                }
            });
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        try {
            if (this.k != null && activity != null) {
                this.k.setAdInteractionListener(this.f);
                this.k.setDownloadListener(this.i);
                this.k.showInteractionAd(activity);
            }
            if (this.l == null || activity == null) {
                return;
            }
            this.l.setFullScreenVideoAdInteractionListener(this.h);
            this.l.setDownloadListener(this.i);
            this.l.showFullScreenVideoAd(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.d = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
