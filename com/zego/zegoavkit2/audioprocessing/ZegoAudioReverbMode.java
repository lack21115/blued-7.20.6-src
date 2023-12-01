package com.zego.zegoavkit2.audioprocessing;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioprocessing/ZegoAudioReverbMode.class */
public enum ZegoAudioReverbMode {
    SOFT_ROOM(0),
    WARM_CLUB(1),
    CONCERT_HALL(2),
    LARGE_AUDITORIUM(3);
    
    private int mCode;

    ZegoAudioReverbMode(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }
}
