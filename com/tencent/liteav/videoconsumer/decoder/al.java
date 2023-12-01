package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/al.class */
public final /* synthetic */ class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f23066a;

    private al(VideoDecodeController videoDecodeController) {
        this.f23066a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new al(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f23066a;
        LiteavLog.i(videoDecodeController.f23043a, "decoder onAbandonDecodingFramesCompleted");
        videoDecodeController.n.b();
        videoDecodeController.m.set(0);
        if (videoDecodeController.g != null) {
            videoDecodeController.g.onAbandonDecodingFramesCompleted();
        }
    }
}
