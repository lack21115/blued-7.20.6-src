package com.tencent.txcopyrightedmedia.zego;

import com.tencent.txcopyrightedmedia.TXCMAudioFrameInfo;
import im.zego.zegoexpress.entity.ZegoAudioFrameParam;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/zego/TXCMZegoAudioMixingData.class */
public class TXCMZegoAudioMixingData {
    public ByteBuffer SEIData;
    public int SEIDataLength;
    public int audioDataLength;
    public TXCMAudioFrameInfo audioInfo;
    public ZegoAudioFrameParam param = new ZegoAudioFrameParam();
}
