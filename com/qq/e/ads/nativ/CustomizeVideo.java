package com.qq.e.ads.nativ;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/nativ/CustomizeVideo.class */
public interface CustomizeVideo {
    String getVideoUrl();

    void reportVideoCompleted();

    void reportVideoError(long j, int i, int i2);

    void reportVideoPause(long j);

    void reportVideoPreload();

    void reportVideoResume(long j);

    void reportVideoStart();
}
