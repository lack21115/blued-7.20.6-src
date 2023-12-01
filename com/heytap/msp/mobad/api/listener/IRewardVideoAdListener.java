package com.heytap.msp.mobad.api.listener;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/listener/IRewardVideoAdListener.class */
public interface IRewardVideoAdListener extends IRewardListener {
    void onAdClick(long j);

    void onAdFailed(int i, String str);

    @Deprecated
    void onAdFailed(String str);

    void onAdSuccess();

    void onLandingPageClose();

    void onLandingPageOpen();

    void onVideoPlayClose(long j);

    void onVideoPlayComplete();

    void onVideoPlayError(String str);

    void onVideoPlayStart();
}
