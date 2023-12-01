package com.anythink.interstitial.api;

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
import com.anythink.core.common.b.b;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.v;
import com.anythink.interstitial.a.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/api/ATInterstitial.class */
public class ATInterstitial {
    public static final String TAG = ATInterstitial.class.getSimpleName();
    WeakReference<Activity> mActivityWef;
    a mAdLoadManager;
    b mAdSourceEventListener;
    public Context mContext;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATEventInterface mDownloadListener;
    public ATInterstitialListener mInterstitialListener;
    public String mPlacementId;
    Map<String, Object> mTKExtraMap;
    private ATInterstitialExListener mInterListener = new ATInterstitialExListener() { // from class: com.anythink.interstitial.api.ATInterstitial.1
        @Override // com.anythink.interstitial.api.ATInterstitialExListener
        public void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATInterstitial.this.mInterstitialListener == null || !(ATInterstitial.this.mInterstitialListener instanceof ATInterstitialExListener)) {
                        return;
                    }
                    ((ATInterstitialExListener) ATInterstitial.this.mInterstitialListener).onDeeplinkCallback(aTAdInfo, z);
                }
            });
        }

        @Override // com.anythink.interstitial.api.ATInterstitialExListener
        public void onDownloadConfirm(final Context context, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATInterstitial.this.mInterstitialListener == null || !(ATInterstitial.this.mInterstitialListener instanceof ATInterstitialExListener)) {
                        return;
                    }
                    ATInterstitialExListener aTInterstitialExListener = (ATInterstitialExListener) ATInterstitial.this.mInterstitialListener;
                    Context context2 = context;
                    Context context3 = context2;
                    if (context2 == null) {
                        context3 = ATInterstitial.this.mContext;
                    }
                    aTInterstitialExListener.onDownloadConfirm(context3, aTAdInfo, aTNetworkConfirmInfo);
                }
            });
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdClicked(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.7
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATInterstitial.this.mInterstitialListener != null) {
                        ATInterstitial.this.mInterstitialListener.onInterstitialAdClicked(aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdClose(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATInterstitial.this.mInterstitialListener != null) {
                        ATInterstitial.this.mInterstitialListener.onInterstitialAdClose(aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdLoadFail(AdError adError) {
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdLoaded() {
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdShow(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.8
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATInterstitial.this.mInterstitialListener != null) {
                        ATInterstitial.this.mInterstitialListener.onInterstitialAdShow(aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdVideoEnd(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATInterstitial.this.mInterstitialListener != null) {
                        ATInterstitial.this.mInterstitialListener.onInterstitialAdVideoEnd(aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdVideoError(final AdError adError) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATInterstitial.this.mInterstitialListener != null) {
                        ATInterstitial.this.mInterstitialListener.onInterstitialAdVideoError(adError);
                    }
                }
            });
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdVideoStart(final ATAdInfo aTAdInfo) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATInterstitial.this.mInterstitialListener != null) {
                        ATInterstitial.this.mInterstitialListener.onInterstitialAdVideoStart(aTAdInfo);
                    }
                }
            });
        }
    };
    com.anythink.core.common.b.a adLoadListener = new com.anythink.core.common.b.a() { // from class: com.anythink.interstitial.api.ATInterstitial.2
        @Override // com.anythink.core.common.b.a
        public void onAdLoadFail(final AdError adError) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.2.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATInterstitial.this.mInterstitialListener != null) {
                        ATInterstitial.this.mInterstitialListener.onInterstitialAdLoadFail(adError);
                    }
                }
            });
        }

        @Override // com.anythink.core.common.b.a
        public void onAdLoaded() {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATInterstitial.this.mInterstitialListener != null) {
                        ATInterstitial.this.mInterstitialListener.onInterstitialAdLoaded();
                    }
                }
            });
        }
    };

    public ATInterstitial(Context context, String str) {
        this.mContext = context.getApplicationContext();
        if (context instanceof Activity) {
            this.mActivityWef = new WeakReference<>((Activity) context);
        }
        this.mPlacementId = str;
        this.mAdLoadManager = a.a(context, str);
    }

    private void controlShow(Activity activity, String str) {
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.j, g.i.s, g.i.h, "");
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            Log.e(TAG, "Show error: SDK init error!");
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
            Log.e(TAG, "Interstitial Show Activity is null.");
        }
        this.mAdLoadManager.a(activity2, str, this.mInterListener, this.mDownloadListener, this.mTKExtraMap);
    }

    public static void entryAdScenario(String str, String str2) {
        n.a().a(str, str2, "3", (Map<String, Object>) null);
    }

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        n.a().a(str, str2, "3", map);
    }

    private ATAdStatusInfo getAdStatus() {
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            Log.e(TAG, "SDK init error!");
            return null;
        }
        return this.mAdLoadManager.a(this.mContext, this.mTKExtraMap);
    }

    private Context getRequestContext() {
        WeakReference<Activity> weakReference = this.mActivityWef;
        Activity activity = weakReference != null ? weakReference.get() : null;
        return activity != null ? activity : this.mContext;
    }

    private void load(Context context, int i) {
        com.anythink.core.common.k.n.a(this.mPlacementId, g.i.j, g.i.q, g.i.h, "", true);
        this.mAdLoadManager.a(context, i, this.adLoadListener, this.mAdSourceEventListener, this.mTKExtraMap);
    }

    public ATAdStatusInfo checkAdStatus() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return new ATAdStatusInfo(false, false, null);
        }
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.j, g.i.u, adStatus.toString(), "");
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
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.j, g.i.t, String.valueOf(isReady), "");
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

    public void setAdListener(ATInterstitialListener aTInterstitialListener) {
        this.mInterstitialListener = aTInterstitialListener;
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
