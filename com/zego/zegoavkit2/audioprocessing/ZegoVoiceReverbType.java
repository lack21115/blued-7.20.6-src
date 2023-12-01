package com.zego.zegoavkit2.audioprocessing;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioprocessing/ZegoVoiceReverbType.class */
public enum ZegoVoiceReverbType {
    OFF(0),
    SOFT_ROOM(1),
    WARM_CLUB(2),
    CONCERT_HALL(3),
    LARGE_AUDITORIUM(4),
    RECORDING_STUDIO(5),
    BASEMENT(6),
    KTV(7),
    POPULAR(8),
    ROCK(9),
    VOCAL_CONCERT(10),
    HIPHOP(11),
    MISTY(12),
    THREE_DIMENSIONAL_VOICE(13),
    GRAMOPHONE(14),
    KTV2(15);
    
    private int mCode;

    ZegoVoiceReverbType(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }
}
