package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATInterstitialAdapter.class */
public class GDTATInterstitialAdapter extends CustomInterstitialAdapter implements UnifiedInterstitialMediaListener {
    public static String TAG = GDTATInterstitialAdapter.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    UnifiedInterstitialAD f8938a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f8939c;
    String d;
    int e = 0;
    String f;
    boolean g;
    boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.gdt.GDTATInterstitialAdapter$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATInterstitialAdapter$1.class */
    public final class AnonymousClass1 implements UnifiedInterstitialADListener {
        AnonymousClass1() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClicked() {
            if (GDTATInterstitialAdapter.this.mImpressListener != null) {
                GDTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClosed() {
            GDTATInitManager.getInstance().b();
            if (GDTATInterstitialAdapter.this.mImpressListener != null) {
                GDTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
            if (GDTATInterstitialAdapter.this.f8938a != null) {
                GDTATInterstitialAdapter.this.f8938a.destroy();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADExposure() {
            try {
                GDTATInitManager.getInstance().a(GDTATInterstitialAdapter.this.getTrackingInfo().l(), new WeakReference(GDTATInterstitialAdapter.this.f8938a));
            } catch (Throwable th) {
            }
            if (GDTATInterstitialAdapter.this.mImpressListener != null) {
                GDTATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADReceive() {
            if (GDTATInterstitialAdapter.this.f8938a != null && GDTATInterstitialAdapter.this.g) {
                GDTATInterstitialAdapter.this.f8938a.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATInterstitialAdapter.1.1
                    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                    public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                        if (GDTATInterstitialAdapter.this.mImpressListener != null) {
                            GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                            gDTDownloadFirmInfo.appInfoUrl = str;
                            gDTDownloadFirmInfo.scenes = i;
                            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                            GDTATInterstitialAdapter.this.mImpressListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                        }
                    }
                });
            }
            if (!GDTATInterstitialAdapter.this.h) {
                if (GDTATInterstitialAdapter.this.mLoadListener != null) {
                    GDTATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
                }
            } else if (GDTATInterstitialAdapter.this.mBiddingListener != null) {
                double ecpm = GDTATInterstitialAdapter.this.f8938a.getECPM();
                GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(GDTATInterstitialAdapter.this.f8938a);
                ATBiddingListener aTBiddingListener = GDTATInterstitialAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onNoAD(AdError adError) {
            GDTATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderFail() {
            GDTATInterstitialAdapter.this.notifyATLoadFail("", "GDT: onRenderFail()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderSuccess() {
            if (GDTATInterstitialAdapter.this.mLoadListener != null) {
                GDTATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onVideoCached() {
        }
    }

    private void a(Context context, Map<String, Object> map) {
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        if (TextUtils.isEmpty(this.d) || this.h) {
            UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.f8939c, anonymousClass1);
            this.f8938a = unifiedInterstitialAD;
            GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.f8938a = new UnifiedInterstitialAD((Activity) context, this.f8939c, anonymousClass1, null, this.d);
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.f8938a != null) {
            VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1);
            boolean z = false;
            if (intFromMap == 1) {
                z = true;
            }
            this.f8938a.setVideoOption(autoPlayMuted.setDetailPageMuted(z).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.f8938a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", this.f)) {
            this.f8938a.loadFullScreenAD();
        } else {
            this.f8938a.loadAD();
        }
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.f = ATInitMediation.getStringFromMap(map, "is_fullscreen", "0");
        this.g = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        if (TextUtils.isEmpty(this.d) || this.h) {
            UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.f8939c, anonymousClass1);
            this.f8938a = unifiedInterstitialAD;
            GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.f8938a = new UnifiedInterstitialAD((Activity) context, this.f8939c, anonymousClass1, null, this.d);
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.f8938a != null) {
            VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1);
            boolean z = false;
            if (intFromMap == 1) {
                z = true;
            }
            this.f8938a.setVideoOption(autoPlayMuted.setDetailPageMuted(z).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.f8938a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", this.f)) {
            this.f8938a.loadFullScreenAD();
        } else {
            this.f8938a.loadAD();
        }
    }

    static /* synthetic */ void a(GDTATInterstitialAdapter gDTATInterstitialAdapter, Context context, Map map, Map map2) {
        gDTATInterstitialAdapter.f = ATInitMediation.getStringFromMap(map, "is_fullscreen", "0");
        gDTATInterstitialAdapter.g = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (!(context instanceof Activity)) {
            gDTATInterstitialAdapter.notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        if (TextUtils.isEmpty(gDTATInterstitialAdapter.d) || gDTATInterstitialAdapter.h) {
            UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, gDTATInterstitialAdapter.f8939c, anonymousClass1);
            gDTATInterstitialAdapter.f8938a = unifiedInterstitialAD;
            GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            gDTATInterstitialAdapter.f8938a = new UnifiedInterstitialAD((Activity) context, gDTATInterstitialAdapter.f8939c, anonymousClass1, null, gDTATInterstitialAdapter.d);
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (gDTATInterstitialAdapter.f8938a != null) {
            VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1);
            boolean z = false;
            if (intFromMap == 1) {
                z = true;
            }
            gDTATInterstitialAdapter.f8938a.setVideoOption(autoPlayMuted.setDetailPageMuted(z).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                gDTATInterstitialAdapter.f8938a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", gDTATInterstitialAdapter.f)) {
            gDTATInterstitialAdapter.f8938a.loadFullScreenAD();
        } else {
            gDTATInterstitialAdapter.f8938a.loadAD();
        }
    }

    private void a(Map<String, Object> map) {
        this.b = ATInitMediation.getStringFromMap(map, "app_id");
        this.f8939c = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.d = ATInitMediation.getStringFromMap(map, "payload");
    }

    private void b(Map<String, Object> map) {
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.f8938a != null) {
            VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1);
            boolean z = false;
            if (intFromMap == 1) {
                z = true;
            }
            this.f8938a.setVideoOption(autoPlayMuted.setDetailPageMuted(z).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.f8938a.setMaxVideoDuration(intFromMap3);
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f8938a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(null);
            this.f8938a.destroy();
            this.f8938a = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.f8939c = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f8939c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f8938a;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.isValid();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.b = ATInitMediation.getStringFromMap(map, "app_id");
        this.f8939c = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.d = ATInitMediation.getStringFromMap(map, "payload");
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f8939c)) {
            notifyATLoadFail("", "GDT appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATInterstitialAdapter.2
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    GDTATInterstitialAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    if (GDTATInterstitialAdapter.this.getMixedFormatAdType() == 0) {
                        GDTATInterstitialAdapter.this.thirdPartyLoad(new GDTATAdapter(), context, map, map2);
                    } else {
                        GDTATInterstitialAdapter.a(GDTATInterstitialAdapter.this, context, map, map2);
                    }
                }
            });
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoComplete() {
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdVideoEnd();
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoError(AdError adError) {
        GDTATInitManager.getInstance().b();
        if (this.mImpressListener != null) {
            CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
            StringBuilder sb = new StringBuilder();
            sb.append(adError.getErrorCode());
            customInterstitialEventListener.onInterstitialAdVideoError(sb.toString(), adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageClose() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageOpen() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPause() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoReady(long j) {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoStart() {
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdVideoStart();
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f8938a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(this);
            if (TextUtils.equals("1", this.f)) {
                if (activity == null) {
                    Log.e(TAG, "Gdt (Full Screen) show fail: context need be Activity");
                    return;
                }
                GDTATInitManager.getInstance().a(this.f8939c, this.f8938a);
                this.f8938a.showFullScreenAD(activity);
                return;
            }
            GDTATInitManager.getInstance().a(this.f8939c, this.f8938a);
            if (activity != null) {
                this.f8938a.show(activity);
            } else {
                this.f8938a.show();
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
