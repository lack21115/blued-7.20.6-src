package com.zego.zegoavkit2.enums;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/enums/VideoCodecType.class */
public enum VideoCodecType {
    CODEC_TYPE_AVC_AVCC(0),
    CODEC_TYPE_AVC_ANNEXB(1);
    
    private int mValue;

    VideoCodecType(int i) {
        this.mValue = i;
    }

    public static VideoCodecType valueOf(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return CODEC_TYPE_AVC_ANNEXB;
        }
        return CODEC_TYPE_AVC_AVCC;
    }

    public int value() {
        return this.mValue;
    }
}
