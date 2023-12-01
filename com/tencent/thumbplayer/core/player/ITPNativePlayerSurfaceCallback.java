package com.tencent.thumbplayer.core.player;

import com.tencent.thumbplayer.core.common.TPVideoPacket;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/player/ITPNativePlayerSurfaceCallback.class */
public interface ITPNativePlayerSurfaceCallback {
    void onFlush();

    void onRenderInfo(TPNativePlayerSurfaceRenderInfo tPNativePlayerSurfaceRenderInfo);

    void onVideoPacket(TPVideoPacket tPVideoPacket);
}
