package com.zego.zegoavkit2.audioobserver;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioobserver/ZegoAudioObserverSource.class */
public enum ZegoAudioObserverSource {
    CAPTURE(1),
    PLAYBACK(2),
    MIX(4);
    
    private int mSource;

    ZegoAudioObserverSource(int i) {
        this.mSource = i;
    }

    public int value() {
        return this.mSource;
    }
}
