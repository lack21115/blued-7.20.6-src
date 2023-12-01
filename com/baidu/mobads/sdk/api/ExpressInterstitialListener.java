package com.baidu.mobads.sdk.api;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/ExpressInterstitialListener.class */
public interface ExpressInterstitialListener {
    void onADExposed();

    void onADExposureFailed();

    void onADLoaded();

    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdClose();

    void onAdFailed(int i, String str);

    void onLpClosed();

    void onNoAd(int i, String str);

    @Deprecated
    void onVideoDownloadFailed();

    @Deprecated
    void onVideoDownloadSuccess();
}
