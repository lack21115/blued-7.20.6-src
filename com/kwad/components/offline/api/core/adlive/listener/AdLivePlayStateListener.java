package com.kwad.components.offline.api.core.adlive.listener;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/adlive/listener/AdLivePlayStateListener.class */
public interface AdLivePlayStateListener {
    void onLiveAudioEnableChange(boolean z);

    void onLivePlayCompleted();

    void onLivePlayEnd();

    void onLivePlayPause();

    void onLivePlayProgress(long j);

    void onLivePlayResume();

    void onLivePlayStart();

    void onLivePrepared();
}
