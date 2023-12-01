package com.qq.e.ads.interstitial2;

import com.qq.e.comm.util.AdError;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/interstitial2/UnifiedInterstitialADListener.class */
public interface UnifiedInterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(AdError adError);

    void onRenderFail();

    void onRenderSuccess();

    void onVideoCached();
}
