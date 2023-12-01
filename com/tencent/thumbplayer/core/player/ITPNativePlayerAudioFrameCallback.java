package com.tencent.thumbplayer.core.player;

import com.tencent.thumbplayer.core.common.TPAudioFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/player/ITPNativePlayerAudioFrameCallback.class */
public interface ITPNativePlayerAudioFrameCallback {
    public static final int FLAG_EOS = 1;

    void onAudioFrame(TPAudioFrame tPAudioFrame, int i);
}
