package com.tencent.trtc;

import com.tencent.liteav.trtc.AudioCustomTrackJni;
import com.tencent.trtc.TRTCCloudDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/trtc/TRTCAudioCustomTrack.class */
public class TRTCAudioCustomTrack {
    private AudioCustomTrackJni mAudioCustomTrackJni;

    public TRTCAudioCustomTrack() {
        this.mAudioCustomTrackJni = null;
        this.mAudioCustomTrackJni = new AudioCustomTrackJni();
    }

    public void clean() {
        this.mAudioCustomTrackJni.clean();
    }

    public void enablePlayout(boolean z) {
        this.mAudioCustomTrackJni.enablePlayout(z);
    }

    public void pause() {
        this.mAudioCustomTrackJni.pause();
    }

    public void resume() {
        this.mAudioCustomTrackJni.resume();
    }

    public void seek() {
        this.mAudioCustomTrackJni.seek();
    }

    public void setPlayoutVolume(int i) {
        this.mAudioCustomTrackJni.setPlayoutVolume(i);
    }

    public int writeData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        return this.mAudioCustomTrackJni.writeData(tRTCAudioFrame);
    }
}
