package com.zego.zegoavkit2.mediarecorder;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mediarecorder/ZegoMediaRecordType.class */
public enum ZegoMediaRecordType {
    AUDIO(1),
    VIDEO(2),
    BOTH(3);
    
    private int mType;

    ZegoMediaRecordType(int i) {
        this.mType = i;
    }

    public int value() {
        return this.mType;
    }
}
