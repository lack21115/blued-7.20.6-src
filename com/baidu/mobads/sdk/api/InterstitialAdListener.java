package com.baidu.mobads.sdk.api;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/InterstitialAdListener.class */
public interface InterstitialAdListener {
    void onAdClick(InterstitialAd interstitialAd);

    void onAdDismissed();

    void onAdFailed(String str);

    void onAdPresent();

    void onAdReady();
}
