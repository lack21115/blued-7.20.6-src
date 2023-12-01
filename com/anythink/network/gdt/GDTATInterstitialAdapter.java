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
import com.igexin.assist.sdk.AssistPushConsts;
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
    UnifiedInterstitialAD f6098a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f6099c;
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
            if (GDTATInterstitialAdapter.this.f6098a != null) {
                GDTATInterstitialAdapter.this.f6098a.destroy();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADExposure() {
            try {
                GDTATInitManager.getInstance().a(GDTATInterstitialAdapter.this.getTrackingInfo().l(), new WeakReference(GDTATInterstitialAdapter.this.f6098a));
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
            if (GDTATInterstitialAdapter.this.f6098a != null && GDTATInterstitialAdapter.this.g) {
                GDTATInterstitialAdapter.this.f6098a.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATInterstitialAdapter.1.1
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
                double ecpm = GDTATInterstitialAdapter.this.f6098a.getECPM();
                GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(GDTATInterstitialAdapter.this.f6098a);
                ATBiddingListener aTBiddingListener = GDTATInterstitialAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
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
            UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.f6099c, anonymousClass1);
            this.f6098a = unifiedInterstitialAD;
            GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.f6098a = new UnifiedInterstitialAD((Activity) context, this.f6099c, anonymousClass1, null, this.d);
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.f6098a != null) {
            VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1);
            boolean z = false;
            if (intFromMap == 1) {
                z = true;
            }
            this.f6098a.setVideoOption(autoPlayMuted.setDetailPageMuted(z).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.f6098a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", this.f)) {
            this.f6098a.loadFullScreenAD();
        } else {
            this.f6098a.loadAD();
        }
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.f = ATInitMediation.getStringFromMap(map, "is_fullscreen", "0");
        this.g = ATInitMediation.getBooleanFromMap(map2, "ad_click_confirm_status", false);
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        if (TextUtils.isEmpty(this.d) || this.h) {
            UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.f6099c, anonymousClass1);
            this.f6098a = unifiedInterstitialAD;
            GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.f6098a = new UnifiedInterstitialAD((Activity) context, this.f6099c, anonymousClass1, null, this.d);
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.f6098a != null) {
            VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1);
            boolean z = false;
            if (intFromMap == 1) {
                z = true;
            }
            this.f6098a.setVideoOption(autoPlayMuted.setDetailPageMuted(z).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.f6098a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", this.f)) {
            this.f6098a.loadFullScreenAD();
        } else {
            this.f6098a.loadAD();
        }
    }

    static /* synthetic */ void a(GDTATInterstitialAdapter gDTATInterstitialAdapter, Context context, Map map, Map map2) {
        gDTATInterstitialAdapter.f = ATInitMediation.getStringFromMap(map, "is_fullscreen", "0");
        gDTATInterstitialAdapter.g = ATInitMediation.getBooleanFromMap(map2, "ad_click_confirm_status", false);
        if (!(context instanceof Activity)) {
            gDTATInterstitialAdapter.notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        if (TextUtils.isEmpty(gDTATInterstitialAdapter.d) || gDTATInterstitialAdapter.h) {
            UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, gDTATInterstitialAdapter.f6099c, anonymousClass1);
            gDTATInterstitialAdapter.f6098a = unifiedInterstitialAD;
            GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            gDTATInterstitialAdapter.f6098a = new UnifiedInterstitialAD((Activity) context, gDTATInterstitialAdapter.f6099c, anonymousClass1, null, gDTATInterstitialAdapter.d);
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (gDTATInterstitialAdapter.f6098a != null) {
            VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1);
            boolean z = false;
            if (intFromMap == 1) {
                z = true;
            }
            gDTATInterstitialAdapter.f6098a.setVideoOption(autoPlayMuted.setDetailPageMuted(z).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                gDTATInterstitialAdapter.f6098a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", gDTATInterstitialAdapter.f)) {
            gDTATInterstitialAdapter.f6098a.loadFullScreenAD();
        } else {
            gDTATInterstitialAdapter.f6098a.loadAD();
        }
    }

    private void a(Map<String, Object> map) {
        this.b = ATInitMediation.getStringFromMap(map, "app_id");
        this.f6099c = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.d = ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD);
    }

    private void b(Map<String, Object> map) {
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.f6098a != null) {
            VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1);
            boolean z = false;
            if (intFromMap == 1) {
                z = true;
            }
            this.f6098a.setVideoOption(autoPlayMuted.setDetailPageMuted(z).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.f6098a.setMaxVideoDuration(intFromMap3);
            }
        }
    }

    public void destory() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f6098a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(null);
            this.f6098a.destroy();
            this.f6098a = null;
        }
    }

    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.f6099c = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.f6099c;
    }

    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f6098a;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.isValid();
        }
        return false;
    }

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.b = ATInitMediation.getStringFromMap(map, "app_id");
        this.f6099c = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.d = ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD);
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f6099c)) {
            notifyATLoadFail("", "GDT appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATInterstitialAdapter.2
                public final void onFail(String str) {
                    GDTATInterstitialAdapter.this.notifyATLoadFail("", str);
                }

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
        UnifiedInterstitialAD unifiedInterstitialAD = this.f6098a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(this);
            if (TextUtils.equals("1", this.f)) {
                if (activity == null) {
                    Log.e(TAG, "Gdt (Full Screen) show fail: context need be Activity");
                    return;
                }
                GDTATInitManager.getInstance().a(this.f6099c, this.f6098a);
                this.f6098a.showFullScreenAD(activity);
                return;
            }
            GDTATInitManager.getInstance().a(this.f6099c, this.f6098a);
            if (activity != null) {
                this.f6098a.show(activity);
            } else {
                this.f6098a.show();
            }
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
