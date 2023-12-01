package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/NativeCustomRenderListener.class */
public class NativeCustomRenderListener implements VideoRenderListener {
    public static final String TAG = "NativeCustomRenderListener";
    private long mNativeVideoCustomRenderListener;

    private NativeCustomRenderListener(long j) {
        this.mNativeVideoCustomRenderListener = 0L;
        this.mNativeVideoCustomRenderListener = j;
    }

    private native void nativeOnCustomRenderFrame(long j, PixelFrame pixelFrame, int i, int i2, long j2, int i3);

    private void reset() {
        synchronized (this) {
            this.mNativeVideoCustomRenderListener = 0L;
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
    public void onRenderFrame(PixelFrame pixelFrame) {
        synchronized (this) {
            if (this.mNativeVideoCustomRenderListener != 0) {
                if (pixelFrame.getPixelFormatType() == null) {
                    LiteavLog.i(TAG, "PixelFrame PixelFormatType is null.");
                    return;
                }
                nativeOnCustomRenderFrame(this.mNativeVideoCustomRenderListener, pixelFrame, pixelFrame.getWidth(), pixelFrame.getHeight(), pixelFrame.getTimestamp(), pixelFrame.getPixelFormatType().getValue());
            }
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
    public void onRenderTargetSizeChanged(int i, int i2) {
    }
}
