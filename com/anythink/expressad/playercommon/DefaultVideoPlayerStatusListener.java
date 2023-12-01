package com.anythink.expressad.playercommon;

import com.anythink.expressad.foundation.h.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/playercommon/DefaultVideoPlayerStatusListener.class */
public class DefaultVideoPlayerStatusListener implements VideoPlayerStatusListener {
    protected static final String TAG = "DefaultVideoPlayerStatusListener";

    @Override // com.anythink.expressad.playercommon.VideoPlayerStatusListener
    public void onBufferingEnd() {
        o.a(TAG, "OnBufferingEnd");
    }

    @Override // com.anythink.expressad.playercommon.VideoPlayerStatusListener
    public void onBufferingStart(String str) {
        o.a(TAG, "OnBufferingStart:".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.playercommon.VideoPlayerStatusListener
    public void onPlayCompleted() {
        o.a(TAG, "onPlayCompleted");
    }

    @Override // com.anythink.expressad.playercommon.VideoPlayerStatusListener
    public void onPlayError(String str) {
        o.a(TAG, "onPlayError:".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.playercommon.VideoPlayerStatusListener
    public void onPlayProgress(int i, int i2) {
        o.a(TAG, "onPlayProgress:" + i + ",allDuration:" + i2);
    }

    @Override // com.anythink.expressad.playercommon.VideoPlayerStatusListener
    public void onPlayProgressMS(int i, int i2) {
        o.a(TAG, "onPlayProgressMS:");
    }

    @Override // com.anythink.expressad.playercommon.VideoPlayerStatusListener
    public void onPlaySetDataSourceError(String str) {
        o.a(TAG, "onPlaySetDataSourceError:".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i) {
        o.a(TAG, "onPlayStarted:".concat(String.valueOf(i)));
    }

    @Override // com.anythink.expressad.playercommon.VideoPlayerStatusListener
    public void onVideoDownloadResume() {
        o.a(TAG, "onVideoDownloadResume:");
    }
}
