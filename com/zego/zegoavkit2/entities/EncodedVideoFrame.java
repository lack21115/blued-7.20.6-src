package com.zego.zegoavkit2.entities;

import com.zego.zegoavkit2.enums.VideoCodecType;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/entities/EncodedVideoFrame.class */
public class EncodedVideoFrame {
    public VideoCodecType codecType;
    public ByteBuffer data;
    public boolean isKeyFrame;
    public double reference_time_ms;
    public int rotation;
}
