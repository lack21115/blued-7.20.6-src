package com.baidu.mobads.sdk.api;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/SplashInteractionListener.class */
public interface SplashInteractionListener extends SplashAdListener {
    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdDismissed();

    void onAdPresent();

    void onLpClosed();
}
