package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/VideoRenderListener.class */
public interface VideoRenderListener {
    void onRenderFrame(PixelFrame pixelFrame);

    void onRenderTargetSizeChanged(int i, int i2);
}
