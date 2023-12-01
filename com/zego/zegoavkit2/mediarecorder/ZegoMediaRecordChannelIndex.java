package com.zego.zegoavkit2.mediarecorder;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mediarecorder/ZegoMediaRecordChannelIndex.class */
public enum ZegoMediaRecordChannelIndex {
    MAIN(0),
    AUX(1),
    THIRD(2),
    FOURTH(3);
    
    private int mType;

    ZegoMediaRecordChannelIndex(int i) {
        this.mType = i;
    }

    public int value() {
        return this.mType;
    }
}
