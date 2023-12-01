package com.tencent.txcopyrightedmedia.agora;

import com.tencent.txcopyrightedmedia.TXCMAudioFrameInfo;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/agora/ITXCMAgoraRtcEngine.class */
public interface ITXCMAgoraRtcEngine {
    int pushExternalAudioFrame(TXCMAudioFrameInfo tXCMAudioFrameInfo, long j);

    int pushExternalAudioFrame(TXCMAudioFrameInfo tXCMAudioFrameInfo, long j, int i, int i2, int i3, int i4);
}
