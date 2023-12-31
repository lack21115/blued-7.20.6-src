package com.qq.e.ads.interstitial2;

import com.qq.e.comm.util.AdError;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/interstitial2/UnifiedInterstitialMediaListener.class */
public interface UnifiedInterstitialMediaListener {
    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoading();

    void onVideoPageClose();

    void onVideoPageOpen();

    void onVideoPause();

    void onVideoReady(long j);

    void onVideoStart();
}
