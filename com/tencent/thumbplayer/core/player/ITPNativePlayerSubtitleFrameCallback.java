package com.tencent.thumbplayer.core.player;

import com.tencent.thumbplayer.core.common.TPSubtitleFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/player/ITPNativePlayerSubtitleFrameCallback.class */
public interface ITPNativePlayerSubtitleFrameCallback {
    public static final int FLAG_EOS = 1;

    void onSubtitleFrame(TPSubtitleFrame tPSubtitleFrame, int i);
}
