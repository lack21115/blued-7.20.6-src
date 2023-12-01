package com.heytap.msp.mobad.api.listener;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/listener/IHotSplashListener.class */
public interface IHotSplashListener {
    void onAdClick();

    void onAdDismissed();

    void onAdFailed(int i, String str);

    void onAdReady();

    void onAdShow(String str);
}
