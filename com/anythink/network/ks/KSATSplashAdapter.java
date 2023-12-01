package com.anythink.network.ks;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.b.g;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATSplashAdapter.class */
public class KSATSplashAdapter extends CustomSplashAdapter {

    /* renamed from: a  reason: collision with root package name */
    long f9013a;
    KsSplashScreenAd b;

    /* renamed from: c  reason: collision with root package name */
    View f9014c;
    boolean d;
    Context e;
    String f;
    double g;
    private final String i = getClass().getSimpleName();
    private boolean j = false;
    boolean h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.ks.KSATSplashAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATSplashAdapter$2.class */
    public final class AnonymousClass2 implements KsLoadManager.SplashScreenAdListener {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onError(int i, String str) {
            KSATSplashAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onRequestResult(int i) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            KSATSplashAdapter.this.b = ksSplashScreenAd;
            if (!KSATSplashAdapter.this.h) {
                if (KSATSplashAdapter.this.mLoadListener != null) {
                    KSATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (KSATSplashAdapter.this.mBiddingListener != null) {
                double d = 0.0d;
                try {
                    d = ksSplashScreenAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(ksSplashScreenAd);
                ATBiddingListener aTBiddingListener = KSATSplashAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }
    }

    private void a() {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        KsScene.Builder adNum = new KsScene.Builder(this.f9013a).adNum(1);
        if (!TextUtils.isEmpty(this.f)) {
            adNum.setBidResponseV2(this.f);
        }
        KsAdSDK.getLoadManager().loadSplashScreenAd(adNum.build(), anonymousClass2);
    }

    static /* synthetic */ void a(KSATSplashAdapter kSATSplashAdapter) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        KsScene.Builder adNum = new KsScene.Builder(kSATSplashAdapter.f9013a).adNum(1);
        if (!TextUtils.isEmpty(kSATSplashAdapter.f)) {
            adNum.setBidResponseV2(kSATSplashAdapter.f);
        }
        KsAdSDK.getLoadManager().loadSplashScreenAd(adNum.build(), anonymousClass2);
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.f9013a = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException e) {
        }
        if (map.containsKey("zoomoutad_sw")) {
            this.j = TextUtils.equals("2", ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
        if (map.containsKey(g.k.o)) {
            this.g = ATInitMediation.getDoubleFromMap(map, g.k.o);
        }
        if (map.containsKey("payload")) {
            this.f = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.g);
            return true;
        }
        return true;
    }

    private void b() {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdClicked();
        }
    }

    static /* synthetic */ int g(KSATSplashAdapter kSATSplashAdapter) {
        kSATSplashAdapter.mDismissType = 99;
        return 99;
    }

    static /* synthetic */ int k(KSATSplashAdapter kSATSplashAdapter) {
        kSATSplashAdapter.mDismissType = 3;
        return 3;
    }

    static /* synthetic */ int p(KSATSplashAdapter kSATSplashAdapter) {
        kSATSplashAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.b = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.f9013a = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return KSATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        try {
            return String.valueOf(this.f9013a);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return KSATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        KsSplashScreenAd ksSplashScreenAd = this.b;
        return ksSplashScreenAd != null && ksSplashScreenAd.isAdEnable();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        if (!a(map)) {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
            return;
        }
        this.e = context.getApplicationContext();
        KSATInitManager.getInstance().initSDK(this.e, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATSplashAdapter.1
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                KSATSplashAdapter.this.notifyATLoadFail("", str);
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                if (KSATSplashAdapter.this.getMixedFormatAdType() != 0) {
                    KSATSplashAdapter.a(KSATSplashAdapter.this);
                    return;
                }
                if (!map.containsKey("video_sound")) {
                    map.put("video_sound", 0);
                }
                KSATSplashAdapter.this.thirdPartyLoad(new KSATAdapter(), KSATSplashAdapter.this.e, map, map2);
            }
        });
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        KsSplashScreenAd ksSplashScreenAd = this.b;
        if (ksSplashScreenAd != null) {
            try {
                View view = ksSplashScreenAd.getView(viewGroup.getContext().getApplicationContext(), new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.anythink.network.ks.KSATSplashAdapter.3
                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdClicked() {
                        if (KSATSplashAdapter.this.mImpressionListener != null) {
                            KSATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdShowEnd() {
                        KSATSplashAdapter.k(KSATSplashAdapter.this);
                        if (KSATSplashAdapter.this.d || KSATSplashAdapter.this.mImpressionListener == null) {
                            return;
                        }
                        KSATSplashAdapter.this.d = true;
                        KSATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdShowError(int i, String str) {
                        String str2 = KSATSplashAdapter.this.i;
                        Log.e(str2, "onAdShowError: " + i + ", " + str);
                        KSATSplashAdapter.g(KSATSplashAdapter.this);
                        if (KSATSplashAdapter.this.d || KSATSplashAdapter.this.mImpressionListener == null) {
                            return;
                        }
                        KSATSplashAdapter.this.d = true;
                        KSATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, String.valueOf(i), str));
                        KSATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdShowStart() {
                        try {
                            KSATInitManager.getInstance().a(KSATSplashAdapter.this.getTrackingInfo().l(), new WeakReference(KSATSplashAdapter.this.b));
                        } catch (Throwable th) {
                        }
                        if (KSATSplashAdapter.this.mImpressionListener != null) {
                            KSATSplashAdapter.this.mImpressionListener.onSplashAdShow();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onDownloadTipsDialogCancel() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onDownloadTipsDialogShow() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onSkippedAd() {
                        KSATSplashAdapter.p(KSATSplashAdapter.this);
                        if (KSATSplashAdapter.this.d || KSATSplashAdapter.this.mImpressionListener == null) {
                            return;
                        }
                        KSATSplashAdapter.this.d = true;
                        KSATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    }
                });
                if (!this.j) {
                    viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
                    return;
                }
                this.f9014c = view;
                viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            } catch (Throwable th) {
                Log.e(this.i, th.getMessage());
                th.printStackTrace();
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        if (getMixedFormatAdType() == 0) {
            return false;
        }
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
