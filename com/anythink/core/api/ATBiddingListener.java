package com.anythink.core.api;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATBiddingListener.class */
public interface ATBiddingListener {
    void onC2SBidResult(ATBiddingResult aTBiddingResult);

    void onC2SBiddingResultWithCache(ATBiddingResult aTBiddingResult, BaseAd baseAd);
}
