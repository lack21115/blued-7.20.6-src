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
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATRewardedVideoAdapter.class */
public class BaiduATRewardedVideoAdapter extends CustomRewardVideoAdapter {

    /* renamed from: c  reason: collision with root package name */
    private static final String f6053c = BaiduATRewardedVideoAdapter.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    RewardVideoAd f6054a;
    private String d = "";
    private String e = "";
    private double f = 0.0d;
    boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.baidu.BaiduATRewardedVideoAdapter$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATRewardedVideoAdapter$1.class */
    public final class AnonymousClass1 implements RewardVideoAd.RewardVideoAdListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClick() {
            if (BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClose(float f) {
            if (BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdFailed(String str) {
            BaiduATRewardedVideoAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdLoaded() {
            if (BaiduATRewardedVideoAdapter.this.mLoadListener != null) {
                BaiduATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdShow() {
            if (BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdSkip(float f) {
            BaiduATRewardedVideoAdapter.j(BaiduATRewardedVideoAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        public final void onRewardVerify(boolean z) {
            if (BaiduATRewardedVideoAdapter.this.mImpressionListener == null || !z) {
                return;
            }
            BaiduATRewardedVideoAdapter.this.mImpressionListener.onReward();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadFailed() {
            BaiduATRewardedVideoAdapter.this.notifyATLoadFail("", "BaiduRewardedVideo: onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadSuccess() {
            BaiduATRewardedVideoAdapter.g(BaiduATRewardedVideoAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void playCompletion() {
            if (BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }
    }

    private void a() {
        if (!this.b) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        } else if (this.mBiddingListener != null) {
            RewardVideoAd rewardVideoAd = this.f6054a;
            if (rewardVideoAd == null) {
                notifyATLoadFail("", "Baidu: RewardVideoAd had been destroyed.");
                return;
            }
            String eCPMLevel = rewardVideoAd.getECPMLevel();
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
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(this.f6054a);
            ATBiddingListener aTBiddingListener = this.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
        }
    }

    private void a(Context context) {
        this.f6054a = new RewardVideoAd(context.getApplicationContext(), this.d, new AnonymousClass1());
        if (this.b && this.f > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATRewardedVideo", "setBidFloor:" + ((int) this.f));
            }
            this.f6054a.setBidFloor((int) this.f);
        }
        if (!TextUtils.isEmpty(this.mUserId)) {
            this.f6054a.setUserId(this.mUserId);
        }
        if (!TextUtils.isEmpty(this.mUserData)) {
            if (this.mUserData.contains("{network_placement_id}")) {
                this.mUserData = this.mUserData.replace("{network_placement_id}", this.d);
            }
            this.f6054a.setExtraInfo(this.mUserData);
        }
        this.f6054a.load();
    }

    static /* synthetic */ void a(BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter, Context context) {
        baiduATRewardedVideoAdapter.f6054a = new RewardVideoAd(context.getApplicationContext(), baiduATRewardedVideoAdapter.d, new AnonymousClass1());
        if (baiduATRewardedVideoAdapter.b && baiduATRewardedVideoAdapter.f > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATRewardedVideo", "setBidFloor:" + ((int) baiduATRewardedVideoAdapter.f));
            }
            baiduATRewardedVideoAdapter.f6054a.setBidFloor((int) baiduATRewardedVideoAdapter.f);
        }
        if (!TextUtils.isEmpty(baiduATRewardedVideoAdapter.mUserId)) {
            baiduATRewardedVideoAdapter.f6054a.setUserId(baiduATRewardedVideoAdapter.mUserId);
        }
        if (!TextUtils.isEmpty(baiduATRewardedVideoAdapter.mUserData)) {
            if (baiduATRewardedVideoAdapter.mUserData.contains("{network_placement_id}")) {
                baiduATRewardedVideoAdapter.mUserData = baiduATRewardedVideoAdapter.mUserData.replace("{network_placement_id}", baiduATRewardedVideoAdapter.d);
            }
            baiduATRewardedVideoAdapter.f6054a.setExtraInfo(baiduATRewardedVideoAdapter.mUserData);
        }
        baiduATRewardedVideoAdapter.f6054a.load();
    }

    private void a(Map<String, Object> map) {
        this.e = ATInitMediation.getStringFromMap(map, "app_id");
        this.d = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f = ATInitMediation.getDoubleFromMap(map, "bid_floor");
    }

    static /* synthetic */ void g(BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter) {
        if (!baiduATRewardedVideoAdapter.b) {
            if (baiduATRewardedVideoAdapter.mLoadListener != null) {
                baiduATRewardedVideoAdapter.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        } else if (baiduATRewardedVideoAdapter.mBiddingListener != null) {
            RewardVideoAd rewardVideoAd = baiduATRewardedVideoAdapter.f6054a;
            if (rewardVideoAd == null) {
                baiduATRewardedVideoAdapter.notifyATLoadFail("", "Baidu: RewardVideoAd had been destroyed.");
                return;
            }
            String eCPMLevel = rewardVideoAd.getECPMLevel();
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
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(baiduATRewardedVideoAdapter.f6054a);
            ATBiddingListener aTBiddingListener = baiduATRewardedVideoAdapter.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
        }
    }

    static /* synthetic */ int j(BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter) {
        baiduATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    public void destory() {
        this.f6054a = null;
    }

    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.d;
    }

    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        RewardVideoAd rewardVideoAd = this.f6054a;
        if (rewardVideoAd != null) {
            return rewardVideoAd.isReady();
        }
        return false;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.e = ATInitMediation.getStringFromMap(map, "app_id");
        this.d = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.d)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        BaiduATInitManager.getInstance().initSDK(applicationContext, map, new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATRewardedVideoAdapter.2
            public final void onFail(String str) {
                if (BaiduATRewardedVideoAdapter.this.mLoadListener != null) {
                    BaiduATRewardedVideoAdapter.this.mLoadListener.onAdLoadError("", str);
                }
            }

            public final void onSuccess() {
                try {
                    BaiduATRewardedVideoAdapter.a(BaiduATRewardedVideoAdapter.this, applicationContext);
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (BaiduATRewardedVideoAdapter.this.mLoadListener != null) {
                        ATCustomLoadListener aTCustomLoadListener = BaiduATRewardedVideoAdapter.this.mLoadListener;
                        aTCustomLoadListener.onAdLoadError("", "Baidu: init error, " + th.getMessage());
                    }
                }
            }
        });
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        try {
            this.f6054a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.b = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
