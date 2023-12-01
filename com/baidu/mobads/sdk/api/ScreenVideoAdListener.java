package com.baidu.mobads.sdk.api;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/ScreenVideoAdListener.class */
public interface ScreenVideoAdListener {
    void onAdClick();

    void onAdClose(float f);

    void onAdFailed(String str);

    void onAdLoaded();

    void onAdShow();

    void onAdSkip(float f);

    void onVideoDownloadFailed();

    void onVideoDownloadSuccess();

    void playCompletion();
}
