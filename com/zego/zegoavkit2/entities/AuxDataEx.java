package com.zego.zegoavkit2.entities;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/entities/AuxDataEx.class */
public class AuxDataEx {
    public ByteBuffer auxDataBuf;
    public int channelCount;
    public ByteBuffer mediaSideInfoBuf;
    public int sampleRate;
    public int auxDataBufLen = 0;
    public int mediaSideInfoBufLen = 0;
    public boolean packet = false;
}
