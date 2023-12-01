package com.tencent.thumbplayer.api;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPSurfaceListener.class */
public interface ITPSurfaceListener {
    void onFlush();

    void onRenderInfo(TPSurfaceRenderInfo tPSurfaceRenderInfo);

    void onVideoPacket(TPVideoPacketBuffer tPVideoPacketBuffer);
}
