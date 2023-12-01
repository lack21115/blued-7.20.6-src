package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.dm;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/RewardVideoAd.class */
public class RewardVideoAd {
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private static final String TAG = "RewardVideoAd";
    private dm mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/RewardVideoAd$RewardVideoAdListener.class */
    public interface RewardVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdLoaded();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f);

        void onRewardVerify(boolean z);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener) {
        this(context, str, rewardVideoAdListener, false);
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener, boolean z) {
        this.mContext = context;
        dm dmVar = new dm(this.mContext, str, z);
        this.mAdProd = dmVar;
        dmVar.a(rewardVideoAdListener);
        if (TextUtils.isEmpty(str)) {
            av.c().e("RewardVideoAd初始化异常：广告位为空");
        }
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.a(false, str, hashMap);
        }
    }

    public void biddingSuccess(String str) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.a(true, str);
        }
    }

    public String getBiddingToken() {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            return dmVar.m();
        }
        return null;
    }

    public String getECPMLevel() {
        dm dmVar = this.mAdProd;
        return dmVar != null ? dmVar.h() : "";
    }

    public boolean isReady() {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            return dmVar.g();
        }
        return false;
    }

    public void load() {
        synchronized (this) {
            if (this.mAdProd != null) {
                this.mAdProd.a();
            }
        }
    }

    public void loadBiddingAd(String str) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.c(str);
        }
    }

    public void setAppSid(String str) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.g(str);
        }
    }

    public void setBidFloor(int i) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.p = i;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.b(str);
        }
    }

    public void setDownloadAppConfirmPolicy(int i) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.a(i);
        }
    }

    public void setExtraInfo(String str) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.i(str);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        dm dmVar;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (dmVar = this.mAdProd) == null) {
            return;
        }
        dmVar.a(requestParameters);
    }

    public void setShowDialogOnSkip(boolean z) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showDialogOnSkip", z);
                this.mAdProd.a(jSONObject);
            } catch (Throwable th) {
                bq.a().c(th);
            }
        }
    }

    public void setUseRewardCountdown(boolean z) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("useRewardCountdown", z);
                this.mAdProd.a(jSONObject);
            } catch (Throwable th) {
                bq.a().c(th);
            }
        }
    }

    public void setUserId(String str) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.a(str);
        }
    }

    public void show() {
        synchronized (this) {
            if (this.mAdProd != null) {
                this.mAdProd.f();
            }
        }
    }
}
