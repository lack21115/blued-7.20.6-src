package com.anythink.rewardvideo.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.c.e;
import com.anythink.core.common.b.b;
import com.anythink.core.common.b.d;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.v;
import com.anythink.rewardvideo.a.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/rewardvideo/api/ATRewardVideoAd.class */
public class ATRewardVideoAd {
    WeakReference<Activity> mActivityWef;
    a mAdLoadManager;
    b mAdSourceEventListener;
    Context mContext;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATEventInterface mDownloadListener;
    ATRewardVideoListener mListener;
    String mPlacementId;
    Map<String, Object> mTKExtraMap;
    final String TAG = getClass().getSimpleName();
    private ATRewardVideoExListener mInterListener = new ATRewardVideoExListener() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1
        @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
        public void onAgainReward(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.11
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                        return;
                    }
                    ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onAgainReward(aTAdInfo);
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
        public void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                        return;
                    }
                    ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onDeeplinkCallback(aTAdInfo, z);
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
        public void onDownloadConfirm(final Context context, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                        return;
                    }
                    ATRewardVideoExListener aTRewardVideoExListener = (ATRewardVideoExListener) ATRewardVideoAd.this.mListener;
                    Context context2 = context;
                    Context context3 = context2;
                    if (context2 == null) {
                        context3 = ATRewardVideoAd.this.mContext;
                    }
                    aTRewardVideoExListener.onDownloadConfirm(context3, aTAdInfo, aTNetworkConfirmInfo);
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onReward(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onReward(aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
        public void onRewardedVideoAdAgainPlayClicked(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.10
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                        return;
                    }
                    ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onRewardedVideoAdAgainPlayClicked(aTAdInfo);
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
        public void onRewardedVideoAdAgainPlayEnd(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.8
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                        return;
                    }
                    ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onRewardedVideoAdAgainPlayEnd(aTAdInfo);
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
        public void onRewardedVideoAdAgainPlayFailed(final AdError adError, final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.9
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                        return;
                    }
                    ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onRewardedVideoAdAgainPlayFailed(adError, aTAdInfo);
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
        public void onRewardedVideoAdAgainPlayStart(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.7
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                        return;
                    }
                    ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onRewardedVideoAdAgainPlayStart(aTAdInfo);
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdClosed(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdClosed(aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdFailed(AdError adError) {
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdLoaded() {
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdPlayClicked(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdPlayClicked(aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdPlayEnd(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.13
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdPlayEnd(aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdPlayFailed(final AdError adError, final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdPlayFailed(adError, aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdPlayStart(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.12
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdPlayStart(aTAdInfo);
                    }
                }
            });
        }
    };
    com.anythink.core.common.b.a adLoadListener = new com.anythink.core.common.b.a() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.2
        @Override // com.anythink.core.common.b.a
        public void onAdLoadFail(final AdError adError) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.2.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdFailed(adError);
                    }
                }
            });
        }

        @Override // com.anythink.core.common.b.a
        public void onAdLoaded() {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdLoaded();
                    }
                }
            });
        }
    };

    public ATRewardVideoAd(Context context, String str) {
        this.mPlacementId = str;
        this.mContext = context.getApplicationContext();
        if (context instanceof Activity) {
            this.mActivityWef = new WeakReference<>((Activity) context);
        }
        this.mAdLoadManager = a.a(context, str);
    }

    private void controlShow(Activity activity, String str) {
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.k, g.i.s, g.i.h, "");
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.exception, "", "sdk init error");
            ATRewardVideoListener aTRewardVideoListener = this.mListener;
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, j.a((d) null));
            }
            Log.e(this.TAG, "SDK init error!");
            return;
        }
        Activity activity2 = activity;
        if (activity == null) {
            Context context = this.mContext;
            activity2 = activity;
            if (context instanceof Activity) {
                activity2 = (Activity) context;
            }
        }
        if (activity2 == null) {
            Log.e(this.TAG, "RewardedVideo Show Activity is null.");
        }
        this.mAdLoadManager.a(activity2, str, this.mInterListener, this.mDownloadListener, this.mTKExtraMap);
    }

    public static void entryAdScenario(String str, String str2) {
        n.a().a(str, str2, "1", (Map<String, Object>) null);
    }

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        n.a().a(str, str2, "1", map);
    }

    private ATAdStatusInfo getAdStatus() {
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            Log.e(this.TAG, "SDK init error!");
            return null;
        }
        return this.mAdLoadManager.a(this.mContext, this.mTKExtraMap);
    }

    private Context getRequestContext() {
        WeakReference<Activity> weakReference = this.mActivityWef;
        Activity activity = weakReference != null ? weakReference.get() : null;
        return activity != null ? activity : this.mContext;
    }

    private boolean isPlaceStrategyNeedAutoLoad() {
        com.anythink.core.c.d a2 = e.a(n.a().g()).a(this.mPlacementId);
        return a2 != null && a2.V() == 1;
    }

    private void load(Context context, int i) {
        com.anythink.core.common.k.n.a(this.mPlacementId, g.i.k, g.i.q, g.i.h, "", true);
        this.mAdLoadManager.a(context, i, this.adLoadListener, this.mAdSourceEventListener, this.mTKExtraMap);
    }

    public ATAdStatusInfo checkAdStatus() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return new ATAdStatusInfo(false, false, null);
        }
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.k, g.i.u, adStatus.toString(), "");
        return adStatus;
    }

    public List<ATAdInfo> checkValidAdCaches() {
        a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(this.mContext);
        }
        return null;
    }

    public boolean isAdReady() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return false;
        }
        boolean isReady = adStatus.isReady();
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.k, g.i.t, String.valueOf(isReady), "");
        return isReady;
    }

    public void load() {
        load(getRequestContext(), 0);
    }

    public void load(Context context) {
        if (context == null) {
            context = getRequestContext();
        }
        load(context, 0);
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    public void setAdListener(ATRewardVideoListener aTRewardVideoListener) {
        this.mListener = aTRewardVideoListener;
    }

    public void setAdSourceStatusListener(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (this.mAdSourceEventListener == null) {
            this.mAdSourceEventListener = new b();
        }
        this.mDeveloperStatusListener = aTAdSourceStatusListener;
        this.mAdSourceEventListener.a(aTAdSourceStatusListener);
    }

    public void setLocalExtra(Map<String, Object> map) {
        v.a().a(this.mPlacementId, map);
    }

    public void setTKExtra(Map<String, Object> map) {
        if (this.mTKExtraMap == null) {
            this.mTKExtraMap = new ConcurrentHashMap();
        }
        this.mTKExtraMap.clear();
        this.mTKExtraMap.putAll(map);
    }

    public void show(Activity activity) {
        controlShow(activity, "");
    }

    public void show(Activity activity, String str) {
        if (!com.anythink.core.common.k.g.c(str)) {
            str = "";
        }
        controlShow(activity, str);
    }
}
