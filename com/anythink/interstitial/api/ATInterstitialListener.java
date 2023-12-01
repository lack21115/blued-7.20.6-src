package com.anythink.interstitial.api;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/api/ATInterstitialListener.class */
public interface ATInterstitialListener {
    void onInterstitialAdClicked(ATAdInfo aTAdInfo);

    void onInterstitialAdClose(ATAdInfo aTAdInfo);

    void onInterstitialAdLoadFail(AdError adError);

    void onInterstitialAdLoaded();

    void onInterstitialAdShow(ATAdInfo aTAdInfo);

    void onInterstitialAdVideoEnd(ATAdInfo aTAdInfo);

    void onInterstitialAdVideoError(AdError adError);

    void onInterstitialAdVideoStart(ATAdInfo aTAdInfo);
}
