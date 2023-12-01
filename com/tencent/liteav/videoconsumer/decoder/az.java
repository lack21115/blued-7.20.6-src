package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/az.class */
public interface az {
    void onAbandonDecodingFramesCompleted();

    void onDecodeCompleted();

    void onDecodeFailed();

    void onDecodeFrame(PixelFrame pixelFrame, long j);

    void onDecodeLatencyChanged(boolean z);

    void onFrameEnqueuedToDecoder();

    void onRequestKeyFrame();
}
