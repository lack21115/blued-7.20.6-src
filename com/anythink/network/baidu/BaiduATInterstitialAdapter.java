package com.anythink.network.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.InterstitialAd;
import com.baidu.mobads.sdk.api.InterstitialAdListener;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATInterstitialAdapter.class */
public class BaiduATInterstitialAdapter extends CustomInterstitialAdapter {
    private static final String g = BaiduATInterstitialAdapter.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    InterstitialAd f8867a;
    FullScreenVideoAd b;

    /* renamed from: c  reason: collision with root package name */
    ExpressInterstitialAd f8868c;
    FullScreenVideoAd.FullScreenVideoAdListener d;
    private String h = "";
    private String i = "";
    private String j = "";
    private String k = "";
    private double l = 0.0d;
    boolean e = false;
    boolean f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATInterstitialAdapter$1.class */
    public final class AnonymousClass1 implements FullScreenVideoAd.FullScreenVideoAdListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClick() {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClose(float f) {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdFailed(String str) {
            BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: ".concat(String.valueOf(str)));
        }

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdLoaded() {
            if (BaiduATInterstitialAdapter.this.mLoadListener != null) {
                BaiduATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdShow() {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdSkip(float f) {
            BaiduATInterstitialAdapter.k(BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadFailed() {
            BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadSuccess() {
            BaiduATInterstitialAdapter.h(BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void playCompletion() {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATInterstitialAdapter$2.class */
    public final class AnonymousClass2 implements InterstitialAdListener {
        AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        public final void onAdClick(InterstitialAd interstitialAd) {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        public final void onAdDismissed() {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        public final void onAdFailed(String str) {
            if (BaiduATInterstitialAdapter.this.mLoadListener != null) {
                BaiduATInterstitialAdapter.this.mLoadListener.onAdLoadError("", str);
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        public final void onAdPresent() {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        public final void onAdReady() {
            if (BaiduATInterstitialAdapter.this.mLoadListener != null) {
                BaiduATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATInterstitialAdapter$3.class */
    public final class AnonymousClass3 implements ExpressInterstitialListener {
        AnonymousClass3() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADExposed() {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADExposureFailed() {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError("", "Baidu: onADExposureFailed()");
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADLoaded() {
            if (BaiduATInterstitialAdapter.this.mLoadListener != null) {
                BaiduATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdCacheFailed() {
            BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: onAdCacheFailed");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdCacheSuccess() {
            BaiduATInterstitialAdapter.H(BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdClick() {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdClose() {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdFailed(int i, String str) {
            BaiduATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onNoAd(int i, String str) {
            BaiduATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), "onNoAd:".concat(String.valueOf(str)));
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onVideoDownloadSuccess() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATInterstitialAdapter$4.class */
    public final class AnonymousClass4 implements ExpressInterstitialAd.InterAdDownloadWindowListener {
        AnonymousClass4() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void adDownloadWindowClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void adDownloadWindowShow() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPermissionClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPermissionShow() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPrivacyClick() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPrivacyClose() {
        }
    }

    static /* synthetic */ void H(BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        if (!baiduATInterstitialAdapter.f) {
            if (baiduATInterstitialAdapter.mLoadListener != null) {
                baiduATInterstitialAdapter.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        } else if (baiduATInterstitialAdapter.mBiddingListener != null) {
            ExpressInterstitialAd expressInterstitialAd = baiduATInterstitialAdapter.f8868c;
            if (expressInterstitialAd == null) {
                baiduATInterstitialAdapter.notifyATLoadFail("", "Baidu: ExpressInterstitialAd had been destroyed.");
                return;
            }
            String eCPMLevel = expressInterstitialAd.getECPMLevel();
            String str = eCPMLevel;
            if (TextUtils.isEmpty(eCPMLevel)) {
                str = "0";
            }
            double d = 0.0d;
            try {
                d = Double.parseDouble(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(baiduATInterstitialAdapter.f8868c);
            ATBiddingListener aTBiddingListener = baiduATInterstitialAdapter.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    private void a() {
        if (!this.f) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        } else if (this.mBiddingListener != null) {
            FullScreenVideoAd fullScreenVideoAd = this.b;
            if (fullScreenVideoAd == null) {
                notifyATLoadFail("", "Baidu: FullScreenVideoAd had been destroyed.");
                return;
            }
            String eCPMLevel = fullScreenVideoAd.getECPMLevel();
            String str = eCPMLevel;
            if (TextUtils.isEmpty(eCPMLevel)) {
                str = "0";
            }
            double d = 0.0d;
            try {
                d = Double.parseDouble(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(this.b);
            ATBiddingListener aTBiddingListener = this.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    private void a(Context context) {
        boolean z;
        String str = this.k;
        int hashCode = str.hashCode();
        if (hashCode != 49) {
            if (hashCode == 50 && str.equals("2")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("1")) {
                z = false;
            }
            z = true;
        }
        if (!z) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            this.d = anonymousClass1;
            this.b = new FullScreenVideoAd(context, this.i, anonymousClass1, false);
            if (this.f && this.l > 0.0d) {
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) this.l));
                }
                this.b.setBidFloor((int) this.l);
            }
            this.b.load();
        } else if (!z) {
            if (this.f) {
                notifyATLoadFail("", "Baidu C2S Interstitial only support ExpressInterstitialAd and FullScreenVideoAd");
                return;
            }
            InterstitialAd interstitialAd = new InterstitialAd(context, this.i);
            this.f8867a = interstitialAd;
            interstitialAd.setListener(new AnonymousClass2());
            this.f8867a.loadAd();
        } else {
            this.f8868c = new ExpressInterstitialAd(context.getApplicationContext(), this.i);
            if (this.f && this.l > 0.0d) {
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) (this.l * 100.0d)));
                }
                this.f8868c.setBidFloor((int) (this.l * 100.0d));
            }
            this.f8868c.setLoadListener(new AnonymousClass3());
            this.f8868c.setDownloadListener(new AnonymousClass4());
            this.f8868c.setDialogFrame(this.e);
            this.f8868c.load();
        }
    }

    static /* synthetic */ void a(BaiduATInterstitialAdapter baiduATInterstitialAdapter, Context context) {
        boolean z;
        String str = baiduATInterstitialAdapter.k;
        int hashCode = str.hashCode();
        if (hashCode != 49) {
            if (hashCode == 50 && str.equals("2")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("1")) {
                z = false;
            }
            z = true;
        }
        if (!z) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            baiduATInterstitialAdapter.d = anonymousClass1;
            baiduATInterstitialAdapter.b = new FullScreenVideoAd(context, baiduATInterstitialAdapter.i, anonymousClass1, false);
            if (baiduATInterstitialAdapter.f && baiduATInterstitialAdapter.l > 0.0d) {
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) baiduATInterstitialAdapter.l));
                }
                baiduATInterstitialAdapter.b.setBidFloor((int) baiduATInterstitialAdapter.l);
            }
            baiduATInterstitialAdapter.b.load();
        } else if (!z) {
            if (baiduATInterstitialAdapter.f) {
                baiduATInterstitialAdapter.notifyATLoadFail("", "Baidu C2S Interstitial only support ExpressInterstitialAd and FullScreenVideoAd");
                return;
            }
            InterstitialAd interstitialAd = new InterstitialAd(context, baiduATInterstitialAdapter.i);
            baiduATInterstitialAdapter.f8867a = interstitialAd;
            interstitialAd.setListener(new AnonymousClass2());
            baiduATInterstitialAdapter.f8867a.loadAd();
        } else {
            baiduATInterstitialAdapter.f8868c = new ExpressInterstitialAd(context.getApplicationContext(), baiduATInterstitialAdapter.i);
            if (baiduATInterstitialAdapter.f && baiduATInterstitialAdapter.l > 0.0d) {
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) (baiduATInterstitialAdapter.l * 100.0d)));
                }
                baiduATInterstitialAdapter.f8868c.setBidFloor((int) (baiduATInterstitialAdapter.l * 100.0d));
            }
            baiduATInterstitialAdapter.f8868c.setLoadListener(new AnonymousClass3());
            baiduATInterstitialAdapter.f8868c.setDownloadListener(new AnonymousClass4());
            baiduATInterstitialAdapter.f8868c.setDialogFrame(baiduATInterstitialAdapter.e);
            baiduATInterstitialAdapter.f8868c.load();
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.h = ATInitMediation.getStringFromMap(map, "app_id");
        this.i = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.k = ATInitMediation.getStringFromMap(map, "unit_type");
        try {
            if (map.containsKey("bid_floor")) {
                this.l = Double.parseDouble(map.get("bid_floor").toString());
            }
        } catch (Throwable th) {
        }
        if (map2 != null) {
            try {
                if (map2.containsKey(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS)) {
                    this.e = Boolean.parseBoolean(map2.get(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS).toString());
                }
            } catch (Exception e) {
            }
        }
        this.j = ATInitMediation.getStringFromMap(map, "payload");
    }

    private void b() {
        if (!this.f) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        } else if (this.mBiddingListener != null) {
            ExpressInterstitialAd expressInterstitialAd = this.f8868c;
            if (expressInterstitialAd == null) {
                notifyATLoadFail("", "Baidu: ExpressInterstitialAd had been destroyed.");
                return;
            }
            String eCPMLevel = expressInterstitialAd.getECPMLevel();
            String str = eCPMLevel;
            if (TextUtils.isEmpty(eCPMLevel)) {
                str = "0";
            }
            double d = 0.0d;
            try {
                d = Double.parseDouble(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(this.f8868c);
            ATBiddingListener aTBiddingListener = this.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    private void b(Context context) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.d = anonymousClass1;
        this.b = new FullScreenVideoAd(context, this.i, anonymousClass1, false);
        if (this.f && this.l > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) this.l));
            }
            this.b.setBidFloor((int) this.l);
        }
        this.b.load();
    }

    private void c(Context context) {
        if (this.f) {
            notifyATLoadFail("", "Baidu C2S Interstitial only support ExpressInterstitialAd and FullScreenVideoAd");
            return;
        }
        InterstitialAd interstitialAd = new InterstitialAd(context, this.i);
        this.f8867a = interstitialAd;
        interstitialAd.setListener(new AnonymousClass2());
        this.f8867a.loadAd();
    }

    private void d(Context context) {
        this.f8868c = new ExpressInterstitialAd(context, this.i);
        if (this.f && this.l > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) (this.l * 100.0d)));
            }
            this.f8868c.setBidFloor((int) (this.l * 100.0d));
        }
        this.f8868c.setLoadListener(new AnonymousClass3());
        this.f8868c.setDownloadListener(new AnonymousClass4());
        this.f8868c.setDialogFrame(this.e);
        this.f8868c.load();
    }

    static /* synthetic */ void h(BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        if (!baiduATInterstitialAdapter.f) {
            if (baiduATInterstitialAdapter.mLoadListener != null) {
                baiduATInterstitialAdapter.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        } else if (baiduATInterstitialAdapter.mBiddingListener != null) {
            FullScreenVideoAd fullScreenVideoAd = baiduATInterstitialAdapter.b;
            if (fullScreenVideoAd == null) {
                baiduATInterstitialAdapter.notifyATLoadFail("", "Baidu: FullScreenVideoAd had been destroyed.");
                return;
            }
            String eCPMLevel = fullScreenVideoAd.getECPMLevel();
            String str = eCPMLevel;
            if (TextUtils.isEmpty(eCPMLevel)) {
                str = "0";
            }
            double d = 0.0d;
            try {
                d = Double.parseDouble(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(baiduATInterstitialAdapter.b);
            ATBiddingListener aTBiddingListener = baiduATInterstitialAdapter.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    static /* synthetic */ int k(BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        baiduATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        if (this.b != null) {
            this.b = null;
            this.d = null;
        }
        InterstitialAd interstitialAd = this.f8867a;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.f8867a = null;
        }
        ExpressInterstitialAd expressInterstitialAd = this.f8868c;
        if (expressInterstitialAd != null) {
            expressInterstitialAd.destroy();
            this.f8868c = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.i;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        boolean z;
        String str = this.k;
        int hashCode = str.hashCode();
        if (hashCode != 49) {
            if (hashCode == 50 && str.equals("2")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("1")) {
                z = false;
            }
            z = true;
        }
        if (!z) {
            FullScreenVideoAd fullScreenVideoAd = this.b;
            if (fullScreenVideoAd != null) {
                return fullScreenVideoAd.isReady();
            }
            return false;
        } else if (!z) {
            InterstitialAd interstitialAd = this.f8867a;
            if (interstitialAd != null) {
                return interstitialAd.isAdReady();
            }
            return false;
        } else {
            ExpressInterstitialAd expressInterstitialAd = this.f8868c;
            if (expressInterstitialAd != null) {
                return expressInterstitialAd.isReady();
            }
            return false;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.h = ATInitMediation.getStringFromMap(map, "app_id");
        this.i = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.k = ATInitMediation.getStringFromMap(map, "unit_type");
        try {
            if (map.containsKey("bid_floor")) {
                this.l = Double.parseDouble(map.get("bid_floor").toString());
            }
        } catch (Throwable th) {
        }
        if (map2 != null) {
            try {
                if (map2.containsKey(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS)) {
                    this.e = Boolean.parseBoolean(map2.get(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS).toString());
                }
            } catch (Exception e) {
            }
        }
        this.j = ATInitMediation.getStringFromMap(map, "payload");
        if (TextUtils.isEmpty(this.h) || TextUtils.isEmpty(this.i)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
        } else if ((TextUtils.isEmpty(this.k) || this.k.equals("0")) && !(context instanceof Activity)) {
            notifyATLoadFail("", "Baidu InterstitialAd context must be activity.");
        } else {
            BaiduATInitManager.getInstance().initSDK(context.getApplicationContext(), map, TextUtils.equals("0", this.k), new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATInterstitialAdapter.5
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    if (BaiduATInterstitialAdapter.this.mLoadListener != null) {
                        BaiduATInterstitialAdapter.this.mLoadListener.onAdLoadError("", str);
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        BaiduATInterstitialAdapter.a(BaiduATInterstitialAdapter.this, context);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        if (BaiduATInterstitialAdapter.this.mLoadListener != null) {
                            ATCustomLoadListener aTCustomLoadListener = BaiduATInterstitialAdapter.this.mLoadListener;
                            aTCustomLoadListener.onAdLoadError("", "Baidu: init error, " + th2.getMessage());
                        }
                    }
                }
            });
        }
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        try {
            String str = this.k;
            boolean z = true;
            int hashCode = str.hashCode();
            if (hashCode != 49) {
                if (hashCode == 50 && str.equals("2")) {
                    z = true;
                }
            } else if (str.equals("1")) {
                z = false;
            }
            if (!z) {
                if (this.b != null) {
                    this.b.show();
                }
            } else if (!z) {
                if (this.f8867a != null) {
                    this.f8867a.showAd();
                }
            } else if (this.f8868c != null) {
                this.f8868c.show(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
