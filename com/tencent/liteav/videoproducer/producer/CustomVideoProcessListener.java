package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/CustomVideoProcessListener.class */
public interface CustomVideoProcessListener {
    void onGLContextCreated();

    void onGLContextDestroy();

    void onProcessFrame(PixelFrame pixelFrame, PixelFrame pixelFrame2);
}
