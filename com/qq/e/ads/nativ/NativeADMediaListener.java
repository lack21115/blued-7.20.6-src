package com.qq.e.ads.nativ;

import com.qq.e.comm.util.AdError;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/nativ/NativeADMediaListener.class */
public interface NativeADMediaListener {
    void onVideoClicked();

    void onVideoCompleted();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoaded(int i);

    void onVideoLoading();

    void onVideoPause();

    void onVideoReady();

    void onVideoResume();

    void onVideoStart();

    void onVideoStop();
}
