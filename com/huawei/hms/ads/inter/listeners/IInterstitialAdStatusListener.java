package com.huawei.hms.ads.inter.listeners;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/inter/listeners/IInterstitialAdStatusListener.class */
public interface IInterstitialAdStatusListener {
    void onAdClicked();

    void onAdClosed();

    void onAdCompleted();

    void onAdError(int i, int i2);

    void onAdShown();

    void onLeftApp();

    void onRewarded();
}
