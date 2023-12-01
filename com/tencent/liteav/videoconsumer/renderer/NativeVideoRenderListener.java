package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.frame.PixelFrame;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/NativeVideoRenderListener.class */
class NativeVideoRenderListener implements VideoRenderListener {
    private long mNativeHandler;

    public NativeVideoRenderListener(long j) {
        this.mNativeHandler = j;
    }

    private static native void nativeOnRenderFrame(long j, PixelFrame pixelFrame);

    private static native void nativeOnRenderTargetSizeChanged(long j, int i, int i2);

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
    public void onRenderFrame(PixelFrame pixelFrame) {
        synchronized (this) {
            if (this.mNativeHandler != 0) {
                nativeOnRenderFrame(this.mNativeHandler, pixelFrame);
            }
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
    public void onRenderTargetSizeChanged(int i, int i2) {
        synchronized (this) {
            if (this.mNativeHandler != 0) {
                nativeOnRenderTargetSizeChanged(this.mNativeHandler, i, i2);
            }
        }
    }

    public void reset() {
        synchronized (this) {
            this.mNativeHandler = 0L;
        }
    }
}
