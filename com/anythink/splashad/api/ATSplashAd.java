package com.anythink.splashad.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATMediationRequestInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.c.a;
import com.anythink.core.common.b.b;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.h;
import com.anythink.core.common.v;
import com.anythink.splashad.a.c;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/api/ATSplashAd.class */
public class ATSplashAd {
    public final int DEFAULT_SPLASH_TIMEOUT_TIME;
    final String TAG;
    WeakReference<Activity> mActivityWeakRef;
    c mAdLoadManager;
    b mAdSourceEventListener;
    Context mContext;
    String mDefaultAdSourceConfig;
    ATMediationRequestInfo mDefaultRequestInfo;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATEventInterface mDownloadListener;
    int mFetchAdTimeout;
    ATSplashAdListener mListener;
    String mPlacementId;
    Map<String, Object> mTKExtraMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.splashad.api.ATSplashAd$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/api/ATSplashAd$1.class */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ int val$loadType;

        /* renamed from: com.anythink.splashad.api.ATSplashAd$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/api/ATSplashAd$1$1.class */
        class C01161 extends com.anythink.splashad.a.b {
            boolean hasCacheWhenTimeout = false;

            C01161() {
            }

            @Override // com.anythink.splashad.a.b
            public void onAdLoaded(String str, final boolean z) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.1.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onAdLoaded(!C01161.this.hasCacheWhenTimeout && z);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.b
            public void onNoAdError(String str, final AdError adError) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.1.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onNoAdError(adError);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.b
            public void onTimeout(String str) {
                if (ATSplashAd.this.mAdLoadManager.a(ATSplashAd.this.mContext, false, false, ATSplashAd.this.mTKExtraMap) != null) {
                    this.hasCacheWhenTimeout = true;
                    h c2 = ATSplashAd.this.mAdLoadManager.c(str);
                    if (c2 != null) {
                        String str2 = ATSplashAd.this.TAG;
                        Log.i(str2, "has cache when timeout: " + ATSplashAd.this.mPlacementId);
                        c2.b(9);
                        return;
                    }
                }
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.1.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onAdLoadTimeout();
                        }
                    }
                });
            }
        }

        AnonymousClass1(int i) {
            this.val$loadType = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = ATSplashAd.this.mFetchAdTimeout;
            int i2 = i;
            if (i <= 0) {
                a b = com.anythink.core.c.b.a(ATSplashAd.this.mContext).b(n.a().p());
                i2 = b.V() == 0 ? 5000 : (int) b.V();
            }
            C01161 c01161 = null;
            Activity activity = ATSplashAd.this.mActivityWeakRef != null ? ATSplashAd.this.mActivityWeakRef.get() : null;
            if (this.val$loadType == 0) {
                c01161 = new C01161();
                c01161.startCountDown(i2);
            }
            c cVar = ATSplashAd.this.mAdLoadManager;
            if (activity == null) {
                activity = ATSplashAd.this.mContext;
            }
            cVar.a(activity, ATSplashAd.this.mDefaultRequestInfo, ATSplashAd.this.mDefaultAdSourceConfig, c01161, i2, this.val$loadType, ATSplashAd.this.mAdSourceEventListener, ATSplashAd.this.mTKExtraMap);
        }
    }

    @Deprecated
    public ATSplashAd(Context context, String str, ATMediationRequestInfo aTMediationRequestInfo, ATSplashAdListener aTSplashAdListener) {
        this(context, str, aTMediationRequestInfo, aTSplashAdListener, 0);
    }

    @Deprecated
    public ATSplashAd(Context context, String str, ATMediationRequestInfo aTMediationRequestInfo, ATSplashAdListener aTSplashAdListener, int i) {
        this.TAG = getClass().getSimpleName();
        this.DEFAULT_SPLASH_TIMEOUT_TIME = 5000;
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mListener = aTSplashAdListener;
        this.mDefaultRequestInfo = aTMediationRequestInfo;
        this.mFetchAdTimeout = i;
        if (context instanceof Activity) {
            this.mActivityWeakRef = new WeakReference<>((Activity) context);
        }
        ATMediationRequestInfo aTMediationRequestInfo2 = this.mDefaultRequestInfo;
        if (aTMediationRequestInfo2 != null) {
            aTMediationRequestInfo2.setFormat("4");
        }
        this.mAdLoadManager = c.a(context, str);
    }

    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener) {
        this(context, str, aTSplashAdListener, 0, "");
    }

    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener, int i, String str2) {
        this.TAG = getClass().getSimpleName();
        this.DEFAULT_SPLASH_TIMEOUT_TIME = 5000;
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mListener = aTSplashAdListener;
        this.mDefaultAdSourceConfig = str2;
        this.mFetchAdTimeout = i;
        if (context instanceof Activity) {
            this.mActivityWeakRef = new WeakReference<>((Activity) context);
        }
        ATMediationRequestInfo aTMediationRequestInfo = this.mDefaultRequestInfo;
        if (aTMediationRequestInfo != null) {
            aTMediationRequestInfo.setFormat("4");
        }
        this.mAdLoadManager = c.a(context, str);
    }

    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener, String str2) {
        this(context, str, aTSplashAdListener, 0, str2);
    }

    @Deprecated
    public static void checkSplashDefaultConfigList(Context context, String str, Map<String, Object> map) {
        n.a().a(context, str, map);
    }

    public static void entryAdScenario(String str, String str2) {
        n.a().a(str, str2, "4", (Map) null);
    }

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        n.a().a(str, str2, "4", map);
    }

    private ATAdStatusInfo getAdStatus() {
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            Log.e(this.TAG, "SDK init error!");
            return null;
        }
        return this.mAdLoadManager.a(this.mContext, this.mTKExtraMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(int i) {
        com.anythink.core.common.k.n.a(this.mPlacementId, g.i.m, g.i.q, g.i.h, "", true);
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass1(i));
    }

    public ATAdStatusInfo checkAdStatus() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return new ATAdStatusInfo(false, false, (ATAdInfo) null);
        }
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.m, g.i.u, adStatus.toString(), "");
        return adStatus;
    }

    public List<ATAdInfo> checkValidAdCaches() {
        c cVar = this.mAdLoadManager;
        if (cVar != null) {
            return cVar.a(this.mContext);
        }
        return null;
    }

    public boolean isAdReady() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return false;
        }
        boolean isReady = adStatus.isReady();
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.m, g.i.t, String.valueOf(isReady), "");
        return isReady;
    }

    public void loadAd() {
        loadAd(0);
    }

    @Deprecated
    public void onDestory() {
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    public void setAdListener(ATSplashAdListener aTSplashAdListener) {
        this.mListener = aTSplashAdListener;
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

    public void show(Activity activity, ViewGroup viewGroup) {
        show(activity, viewGroup, null, "");
    }

    public void show(Activity activity, ViewGroup viewGroup, ATSplashSkipInfo aTSplashSkipInfo) {
        show(activity, viewGroup, aTSplashSkipInfo, "");
    }

    public void show(Activity activity, ViewGroup viewGroup, ATSplashSkipInfo aTSplashSkipInfo, String str) {
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.m, g.i.s, g.i.h, "");
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            Log.e(this.TAG, "SDK init error!");
            return;
        }
        if (activity == null) {
            Log.e(this.TAG, "Splash Activity is null.");
        }
        if (viewGroup == null) {
            Log.e(this.TAG, "Splash Container is null.");
            return;
        }
        com.anythink.splashad.a.a aVar = new com.anythink.splashad.a.a() { // from class: com.anythink.splashad.api.ATSplashAd.2
            @Override // com.anythink.splashad.a.a
            public void onAdClick(final ATAdInfo aTAdInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onAdClick(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.a
            public void onAdDismiss(final ATAdInfo aTAdInfo, final ATSplashAdExtraInfo aTSplashAdExtraInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onAdDismiss(aTAdInfo, aTSplashAdExtraInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.a
            public void onAdShow(final ATAdInfo aTAdInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onAdShow(aTAdInfo);
                        }
                    }
                });
                if (ATSplashAd.this.mAdLoadManager.a((ATAdStatusInfo) null)) {
                    ATSplashAd.this.loadAd(6);
                }
            }

            @Override // com.anythink.splashad.a.a
            public void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener == null || !(ATSplashAd.this.mListener instanceof ATSplashExListener)) {
                            return;
                        }
                        ((ATSplashExListener) ATSplashAd.this.mListener).onDeeplinkCallback(aTAdInfo, z);
                    }
                });
            }

            @Override // com.anythink.splashad.a.a
            public void onDownloadConfirm(final Context context, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener == null || !(ATSplashAd.this.mListener instanceof ATSplashExListener)) {
                            return;
                        }
                        ATSplashExListener aTSplashExListener = (ATSplashExListener) ATSplashAd.this.mListener;
                        Context context2 = context;
                        Context context3 = context2;
                        if (context2 == null) {
                            context3 = ATSplashAd.this.mContext;
                        }
                        aTSplashExListener.onDownloadConfirm(context3, aTAdInfo, aTNetworkConfirmInfo);
                    }
                });
            }
        };
        if (!com.anythink.core.common.k.g.c(str)) {
            str = "";
        }
        this.mAdLoadManager.a(activity, viewGroup, aVar, this.mDownloadListener, aTSplashSkipInfo, str, this.mTKExtraMap);
    }

    public void show(Activity activity, ViewGroup viewGroup, String str) {
        show(activity, viewGroup, null, str);
    }
}
