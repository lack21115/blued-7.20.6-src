package com.zego.zegoliveroom.entity;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/entity/ZegoAudioFrame.class */
public class ZegoAudioFrame {
    public int bufLen;
    public ByteBuffer buffer;
    public int bytesPerSample;
    public int channels;
    public int configLen;
    public int frameType;
    public int sampleRate;
    public int samples;
    public double timeStamp;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/entity/ZegoAudioFrame$FrameType.class */
    public static final class FrameType {
        public static final int AAC_STREAM = 4099;
        public static final int PCM = 4097;
    }
}
