package com.anythink.core.api;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.b.d;
import com.anythink.core.common.b.o;
import com.anythink.core.common.k.g;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATBaseAdAdapter.class */
public abstract class ATBaseAdAdapter extends d {
    public ATBiddingListener mBiddingListener;
    public ATEventInterface mDownloadListener;
    public ATCustomLoadListener mLoadListener;
    public String mUserId = "";
    public String mUserData = "";
    protected String mScenario = "";
    protected int mMixedFormatAdType = -1;
    public int mDismissType = 0;

    private void cleanLoadListener() {
        this.mBiddingListener = null;
        this.mLoadListener = null;
    }

    private void fillParams(Map<String, Object> map) {
        if (getTrackingInfo() != null) {
            g.a(map, getTrackingInfo().N());
        }
    }

    private void parseGloableParams(Map<String, Object> map, Map<String, Object> map2) {
        if (map2 != null) {
            this.mUserId = map2.get("user_id") != null ? map2.get("user_id").toString() : "";
            this.mUserData = map2.get(ATAdConst.KEY.USER_CUSTOM_DATA) != null ? map2.get(ATAdConst.KEY.USER_CUSTOM_DATA).toString() : "";
        }
        if (map == null || !map.containsKey("ad_type")) {
            return;
        }
        this.mMixedFormatAdType = Integer.parseInt(map.get("ad_type").toString());
    }

    public abstract void destory();

    public BaseAd getBaseAdObject(Context context) {
        return null;
    }

    public MediationBidManager getBidManager() {
        return null;
    }

    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onFailed(ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE);
        }
    }

    public final int getDismissType() {
        return this.mDismissType;
    }

    public String getILRD() {
        return null;
    }

    public ATInitMediation getMediationInitManager() {
        return null;
    }

    public final int getMixedFormatAdType() {
        return this.mMixedFormatAdType;
    }

    public Map<String, Object> getNetworkInfoMap() {
        return null;
    }

    public abstract String getNetworkName();

    public abstract String getNetworkPlacementId();

    public abstract String getNetworkSDKVersion();

    public final String getUserCustomData() {
        return this.mUserData;
    }

    public final String getUserId() {
        return this.mUserId;
    }

    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        return false;
    }

    public final boolean internalInitNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        fillParams(map);
        parseGloableParams(map, map2);
        return initNetworkObjectByPlacementId(context, map, map2);
    }

    public final void internalLoad(Context context, Map<String, Object> map, Map<String, Object> map2, ATCustomLoadListener aTCustomLoadListener) {
        this.mLoadListener = aTCustomLoadListener;
        fillParams(map);
        parseGloableParams(map, map2);
        loadCustomNetworkAd(context, map, map2);
    }

    public final boolean internalStartBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        fillParams(map);
        parseGloableParams(map, map2);
        this.mBiddingListener = aTBiddingListener;
        boolean startBiddingRequest = startBiddingRequest(context, map, map2, aTBiddingListener);
        if (!startBiddingRequest) {
            this.mBiddingListener = null;
        }
        return startBiddingRequest;
    }

    public abstract boolean isAdReady();

    public abstract void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2);

    public final void notifyATLoadFail(String str, String str2) {
        String str3;
        if (this.mBiddingListener != null) {
            if (TextUtils.isEmpty(str)) {
                str3 = str2;
            } else {
                str3 = str + "|" + str2;
            }
            this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(str3), null);
        }
        ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdLoadError(str, str2);
        }
    }

    public void releaseLoadResource() {
        cleanLoadListener();
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    public final void setScenario(String str) {
        this.mScenario = str;
    }

    public boolean setUserDataConsent(Context context, boolean z, boolean z2) {
        return false;
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        return false;
    }

    public boolean supportImpressionCallback() {
        return true;
    }

    public final void thirdPartyLoad(ATBaseAdAdapter aTBaseAdAdapter, Context context, Map<String, Object> map, Map<String, Object> map2) {
        aTBaseAdAdapter.internalLoad(context, map, map2, new o(this.mLoadListener, map));
    }
}
