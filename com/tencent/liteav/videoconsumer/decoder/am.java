package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/am.class */
final /* synthetic */ class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f36758a;

    private am(VideoDecodeController videoDecodeController) {
        this.f36758a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new am(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f36758a;
        if (videoDecodeController.g != null) {
            videoDecodeController.g.onFrameEnqueuedToDecoder();
        }
    }
}
