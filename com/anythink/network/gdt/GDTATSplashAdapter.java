package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.api.ATSplashEyeAdListener;
import com.anythink.splashad.api.IATSplashEyeAd;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATSplashAdapter.class */
public class GDTATSplashAdapter extends CustomSplashAdapter implements SplashADZoomOutListener {
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    GDTATSplashEyeAd f8966c;
    ViewGroup d;
    String e;
    private String g;
    private String h;
    private boolean i;
    private SplashAD j;
    private boolean k;

    /* renamed from: a  reason: collision with root package name */
    final String f8965a = GDTATSplashAdapter.class.getSimpleName();
    private boolean l = false;
    boolean f = false;

    private void a(Context context, Map<String, Object> map) {
        if (TextUtils.isEmpty(this.e) || this.f) {
            SplashAD splashAD = new SplashAD(context, this.h, this, this.mFetchAdTimeout);
            this.j = splashAD;
            GDTATInitManager.getInstance();
            splashAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.j = new SplashAD(context, this.h, this, this.mFetchAdTimeout, this.e);
        }
        this.j.fetchAdOnly();
    }

    static /* synthetic */ void a(GDTATSplashAdapter gDTATSplashAdapter, Context context, Map map) {
        if (TextUtils.isEmpty(gDTATSplashAdapter.e) || gDTATSplashAdapter.f) {
            SplashAD splashAD = new SplashAD(context, gDTATSplashAdapter.h, gDTATSplashAdapter, gDTATSplashAdapter.mFetchAdTimeout);
            gDTATSplashAdapter.j = splashAD;
            GDTATInitManager.getInstance();
            splashAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            gDTATSplashAdapter.j = new SplashAD(context, gDTATSplashAdapter.h, gDTATSplashAdapter, gDTATSplashAdapter.mFetchAdTimeout, gDTATSplashAdapter.e);
        }
        gDTATSplashAdapter.j.fetchAdOnly();
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.g = ATInitMediation.getStringFromMap(map, "app_id");
        this.h = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getStringFromMap(map, "payload");
        this.i = false;
        this.k = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (map.containsKey("zoomoutad_sw")) {
            this.l = TextUtils.equals("2", ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.j = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.h = ATInitMediation.getStringFromMap(map, "unit_id");
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
        return this.h;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public IATSplashEyeAd getSplashEyeAd() {
        return this.f8966c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        return this.i;
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public boolean isSupportZoomOut() {
        return this.l;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.g = ATInitMediation.getStringFromMap(map, "app_id");
        this.h = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getStringFromMap(map, "payload");
        this.i = false;
        this.k = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (map.containsKey("zoomoutad_sw")) {
            this.l = TextUtils.equals("2", ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
        if (TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.h)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATSplashAdapter.1
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                GDTATSplashAdapter.this.notifyATLoadFail("", str);
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                if (GDTATSplashAdapter.this.getMixedFormatAdType() != 0) {
                    GDTATSplashAdapter.a(GDTATSplashAdapter.this, applicationContext, map);
                    return;
                }
                if (!map.containsKey("video_muted")) {
                    map.put("video_muted", "1");
                }
                GDTATSplashAdapter.this.thirdPartyLoad(new GDTATAdapter(), context, map, map2);
            }
        });
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdClicked();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        ATSplashEyeAdListener splashEyeAdListener;
        if (!this.l || !this.b) {
            if (this.mImpressionListener != null) {
                this.mImpressionListener.onSplashAdDismiss();
                return;
            }
            return;
        }
        GDTATSplashEyeAd gDTATSplashEyeAd = this.f8966c;
        if (gDTATSplashEyeAd == null || (splashEyeAdListener = gDTATSplashEyeAd.getSplashEyeAdListener()) == null) {
            return;
        }
        splashEyeAdListener.onAdDismiss(true, "");
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        try {
            GDTATInitManager.getInstance().a(getTrackingInfo().l(), new WeakReference(this.j));
        } catch (Throwable th) {
        }
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdShow();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j) {
        this.i = true;
        SplashAD splashAD = this.j;
        if (splashAD != null && this.k) {
            splashAD.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATSplashAdapter.2
                @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                    if (GDTATSplashAdapter.this.mImpressionListener != null) {
                        GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                        gDTDownloadFirmInfo.appInfoUrl = str;
                        gDTDownloadFirmInfo.scenes = i;
                        gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                        GDTATSplashAdapter.this.mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                    }
                }
            });
        }
        if (!this.f) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        } else if (this.mBiddingListener != null) {
            SplashAD splashAD2 = this.j;
            if (splashAD2 == null) {
                notifyATLoadFail("", "GDT: SplashAD had been destroy.");
                return;
            }
            double ecpm = splashAD2.getECPM();
            GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(this.j);
            ATBiddingListener aTBiddingListener = this.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j) {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        StringBuilder sb = new StringBuilder();
        sb.append(adError.getErrorCode());
        notifyATLoadFail(sb.toString(), adError.getErrorMsg());
        if (this.mImpressionListener != null) {
            String str = this.f8965a;
            Log.e(str, "GDT Splash show fail:[errorCode:" + adError.getErrorCode() + ",errorMsg:" + adError.getErrorMsg() + "]");
            this.mDismissType = 99;
            CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(adError.getErrorCode());
            customSplashEventListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, sb2.toString(), adError.getErrorMsg()));
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public void onZoomOut() {
        this.b = true;
        if (this.l) {
            GDTATSplashEyeAd gDTATSplashEyeAd = new GDTATSplashEyeAd(this, this.j);
            this.f8966c = gDTATSplashEyeAd;
            gDTATSplashEyeAd.setSplashView(this.d);
            if (this.mImpressionListener != null) {
                this.mImpressionListener.onSplashAdDismiss();
            }
        }
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public void onZoomOutPlayFinish() {
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        SplashAD splashAD;
        if (!this.i || (splashAD = this.j) == null) {
            return;
        }
        if (!this.l) {
            splashAD.showAd(viewGroup);
            return;
        }
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        this.d = frameLayout;
        viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.j.showAd(this.d);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f = true;
        if (getMixedFormatAdType() == 0) {
            return false;
        }
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
