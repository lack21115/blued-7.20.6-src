package com.kwad.sdk.core.video.videoview;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/videoview/c.class */
public interface c {
    int getBufferPercentage();

    long getCurrentPosition();

    long getDuration();

    boolean isIdle();

    boolean isPaused();

    void pause();

    void release();

    void restart();

    void setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a aVar);

    void start();

    boolean yr();
}
