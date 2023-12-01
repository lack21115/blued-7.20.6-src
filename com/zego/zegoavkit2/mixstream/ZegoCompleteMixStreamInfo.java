package com.zego.zegoavkit2.mixstream;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mixstream/ZegoCompleteMixStreamInfo.class */
public final class ZegoCompleteMixStreamInfo {
    public ZegoMixStreamInfo[] inputStreamList;
    public int outputAudioBitrate;
    public String outputBackgroundImage;
    public int outputBitrate;
    public int outputFps;
    public int outputHeight;
    public boolean outputIsUrl;
    public String outputStreamId;
    public int outputWidth;
    public ByteBuffer userData;
    public int outputAudioConfig = 0;
    public int lenOfUserData = 0;
    public int channels = 1;
    public int outputBackgroundColor = 0;
    public boolean withSoundLevel = false;
    public int extra = 0;
}
