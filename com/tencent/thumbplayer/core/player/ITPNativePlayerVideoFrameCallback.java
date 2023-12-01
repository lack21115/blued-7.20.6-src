package com.tencent.thumbplayer.core.player;

import com.tencent.thumbplayer.core.common.TPVideoFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/player/ITPNativePlayerVideoFrameCallback.class */
public interface ITPNativePlayerVideoFrameCallback {
    public static final int FLAG_EOS = 1;
    public static final int FLAG_MULTITRACK_END = 4;
    public static final int FLAG_MULTITRACK_START = 2;

    void onVideoFrame(TPVideoFrame tPVideoFrame, int i);
}
