package com.qiniu.pili.droid.streaming.microphone;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/microphone/OnAudioMixListener.class */
public interface OnAudioMixListener {

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/microphone/OnAudioMixListener$MixStatus.class */
    public enum MixStatus {
        Finish
    }

    void onProgress(long j, long j2);

    void onStatusChanged(MixStatus mixStatus);
}
