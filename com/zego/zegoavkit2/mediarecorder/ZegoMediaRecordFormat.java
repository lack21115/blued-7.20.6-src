package com.zego.zegoavkit2.mediarecorder;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mediarecorder/ZegoMediaRecordFormat.class */
public enum ZegoMediaRecordFormat {
    FLV(1),
    MP4(2),
    AAC(4),
    M3U(7);
    
    private int mType;

    ZegoMediaRecordFormat(int i) {
        this.mType = i;
    }

    public int value() {
        return this.mType;
    }
}
