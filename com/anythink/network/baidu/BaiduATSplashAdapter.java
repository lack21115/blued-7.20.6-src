package com.anythink.network.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATSplashAdapter.class */
public class BaiduATSplashAdapter extends CustomSplashAdapter {
    SplashAd b;

    /* renamed from: c  reason: collision with root package name */
    String f8898c;
    private final String g = BaiduATSplashAdapter.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f8897a = "";
    private double h = 0.0d;
    boolean d = false;
    boolean e = false;
    boolean f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.baidu.BaiduATSplashAdapter$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATSplashAdapter$1.class */
    public final class AnonymousClass1 implements SplashInteractionListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public final void onADLoaded() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdCacheFailed() {
            if (BaiduATSplashAdapter.this.e) {
                return;
            }
            BaiduATSplashAdapter.this.notifyATLoadFail("", "onAdCacheFailed");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdCacheSuccess() {
            BaiduATSplashAdapter.this.e = true;
            BaiduATSplashAdapter.l(BaiduATSplashAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdClick() {
            if (BaiduATSplashAdapter.this.mImpressionListener != null) {
                BaiduATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdDismissed() {
            if (BaiduATSplashAdapter.this.mImpressionListener != null) {
                BaiduATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public final void onAdFailed(String str) {
            if (!BaiduATSplashAdapter.this.e) {
                BaiduATSplashAdapter.this.notifyATLoadFail("", str);
                return;
            }
            Log.e(BaiduATSplashAdapter.this.g, "onAdFailed: ".concat(String.valueOf(str)));
            BaiduATSplashAdapter.d(BaiduATSplashAdapter.this);
            if (BaiduATSplashAdapter.this.mImpressionListener != null) {
                BaiduATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", str));
                BaiduATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdPresent() {
            if (BaiduATSplashAdapter.this.mImpressionListener != null) {
                BaiduATSplashAdapter.this.mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onLpClosed() {
        }
    }

    private static int a(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = f2;
        if (f2 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f / f3) + 0.5f);
    }

    private void a() {
        if (!this.f) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        } else if (this.mBiddingListener != null) {
            SplashAd splashAd = this.b;
            if (splashAd == null) {
                notifyATLoadFail("", "Baidu: SplashAd had been destroyed.");
                return;
            }
            String eCPMLevel = splashAd.getECPMLevel();
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

    private void a(Context context, boolean z, Map<String, Object> map) {
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", String.valueOf(this.mFetchAdTimeout));
        builder.addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true");
        builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, String.valueOf(z));
        int intFromMap = ATInitMediation.getIntFromMap(map, ATAdConst.KEY.AD_WIDTH, 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, ATAdConst.KEY.AD_HEIGHT, 0);
        if (intFromMap > 0 && intFromMap2 > 0) {
            builder.setWidth(a(context, intFromMap));
            builder.setHeight(a(context, intFromMap2));
        }
        this.b = new SplashAd(context.getApplicationContext(), this.f8897a, builder.build(), new AnonymousClass1());
        if (this.f && this.h > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATSplashAdapter", "setBidFloor:" + ((int) this.h));
            }
            this.b.setBidFloor((int) this.h);
        }
        this.b.load();
    }

    static /* synthetic */ void a(BaiduATSplashAdapter baiduATSplashAdapter, Context context, boolean z, Map map) {
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", String.valueOf(baiduATSplashAdapter.mFetchAdTimeout));
        builder.addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true");
        builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, String.valueOf(z));
        int intFromMap = ATInitMediation.getIntFromMap(map, ATAdConst.KEY.AD_WIDTH, 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, ATAdConst.KEY.AD_HEIGHT, 0);
        if (intFromMap > 0 && intFromMap2 > 0) {
            builder.setWidth(a(context, intFromMap));
            builder.setHeight(a(context, intFromMap2));
        }
        baiduATSplashAdapter.b = new SplashAd(context.getApplicationContext(), baiduATSplashAdapter.f8897a, builder.build(), new AnonymousClass1());
        if (baiduATSplashAdapter.f && baiduATSplashAdapter.h > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATSplashAdapter", "setBidFloor:" + ((int) baiduATSplashAdapter.h));
            }
            baiduATSplashAdapter.b.setBidFloor((int) baiduATSplashAdapter.h);
        }
        baiduATSplashAdapter.b.load();
    }

    private void a(Map<String, Object> map) {
        this.f8898c = ATInitMediation.getStringFromMap(map, "app_id");
        this.f8897a = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.h = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.d = ATInitMediation.getBooleanFromMap(map, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS);
    }

    static /* synthetic */ int d(BaiduATSplashAdapter baiduATSplashAdapter) {
        baiduATSplashAdapter.mDismissType = 99;
        return 99;
    }

    static /* synthetic */ void l(BaiduATSplashAdapter baiduATSplashAdapter) {
        if (!baiduATSplashAdapter.f) {
            if (baiduATSplashAdapter.mLoadListener != null) {
                baiduATSplashAdapter.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        } else if (baiduATSplashAdapter.mBiddingListener != null) {
            SplashAd splashAd = baiduATSplashAdapter.b;
            if (splashAd == null) {
                baiduATSplashAdapter.notifyATLoadFail("", "Baidu: SplashAd had been destroyed.");
                return;
            }
            String eCPMLevel = splashAd.getECPMLevel();
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
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(baiduATSplashAdapter.b);
            ATBiddingListener aTBiddingListener = baiduATSplashAdapter.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        SplashAd splashAd = this.b;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f8897a;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        SplashAd splashAd = this.b;
        if (splashAd != null) {
            return splashAd.isReady();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.e = false;
        this.f8898c = ATInitMediation.getStringFromMap(map, "app_id");
        this.f8897a = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.h = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.d = ATInitMediation.getBooleanFromMap(map, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS);
        if (TextUtils.isEmpty(this.f8898c) || TextUtils.isEmpty(this.f8897a)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        BaiduATInitManager.getInstance().initSDK(applicationContext, map, new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATSplashAdapter.2
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                if (BaiduATSplashAdapter.this.mLoadListener != null) {
                    BaiduATSplashAdapter.this.mLoadListener.onAdLoadError("", str);
                }
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                if (BaiduATSplashAdapter.this.getMixedFormatAdType() == 0) {
                    BaiduATSplashAdapter.this.thirdPartyLoad(new BaiduATAdapter(), context, map, map2);
                    return;
                }
                BaiduATSplashAdapter baiduATSplashAdapter = BaiduATSplashAdapter.this;
                BaiduATSplashAdapter.a(baiduATSplashAdapter, applicationContext, baiduATSplashAdapter.d, map2);
            }
        });
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        SplashAd splashAd = this.b;
        if (splashAd != null) {
            splashAd.show(viewGroup);
            return;
        }
        this.mDismissType = 99;
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "Baidu Splash show fail: mSplashAd = null"));
            this.mImpressionListener.onSplashAdDismiss();
        }
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
