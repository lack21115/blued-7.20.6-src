package com.zego.zegoavkit2.entities;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/entities/VideoFrame.class */
public class VideoFrame {
    public int height;
    public int width;
    public ByteBuffer[] byteBuffers = new ByteBuffer[4];
    public int[] strides = new int[4];
}
