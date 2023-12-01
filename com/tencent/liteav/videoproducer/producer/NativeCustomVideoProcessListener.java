package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.frame.PixelFrame;

@JNINamespace("liteav::video")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/NativeCustomVideoProcessListener.class */
public class NativeCustomVideoProcessListener implements CustomVideoProcessListener {
    private long mNativeVideoCustomProcessListener;

    private NativeCustomVideoProcessListener(long j) {
        this.mNativeVideoCustomProcessListener = 0L;
        this.mNativeVideoCustomProcessListener = j;
    }

    private native void nativeOnGLContextCreated(long j);

    private native void nativeOnGLContextDestroy(long j);

    private native void nativeOnProcessFrame(long j, PixelFrame pixelFrame, PixelFrame pixelFrame2, int i, int i2, long j2, int i3);

    private void reset() {
        synchronized (this) {
            this.mNativeVideoCustomProcessListener = 0L;
        }
    }

    @Override // com.tencent.liteav.videoproducer.producer.CustomVideoProcessListener
    public void onGLContextCreated() {
        synchronized (this) {
            if (this.mNativeVideoCustomProcessListener != 0) {
                nativeOnGLContextCreated(this.mNativeVideoCustomProcessListener);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.producer.CustomVideoProcessListener
    public void onGLContextDestroy() {
        synchronized (this) {
            if (this.mNativeVideoCustomProcessListener != 0) {
                nativeOnGLContextDestroy(this.mNativeVideoCustomProcessListener);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.producer.CustomVideoProcessListener
    public void onProcessFrame(PixelFrame pixelFrame, PixelFrame pixelFrame2) {
        synchronized (this) {
            if (this.mNativeVideoCustomProcessListener != 0) {
                nativeOnProcessFrame(this.mNativeVideoCustomProcessListener, pixelFrame, pixelFrame2, pixelFrame.getWidth(), pixelFrame.getHeight(), pixelFrame.getTimestamp(), pixelFrame.getPixelFormatType().getValue());
            }
        }
    }
}
