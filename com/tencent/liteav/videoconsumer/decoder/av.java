package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/av.class */
public final /* synthetic */ class av implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f23076a;

    private av(VideoDecodeController videoDecodeController) {
        this.f23076a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new av(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f23076a;
        LiteavLog.i(videoDecodeController.f23043a, "signalEndOfStream");
        if (videoDecodeController.k == null) {
            videoDecodeController.onDecodeCompleted();
            return;
        }
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        encodedVideoFrame.isEosFrame = true;
        videoDecodeController.b(encodedVideoFrame);
    }
}
