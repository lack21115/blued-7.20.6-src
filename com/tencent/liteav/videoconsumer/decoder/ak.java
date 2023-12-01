package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ak.class */
final /* synthetic */ class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f23065a;

    private ak(VideoDecodeController videoDecodeController) {
        this.f23065a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new ak(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f23065a;
        if (videoDecodeController.g != null) {
            videoDecodeController.g.onRequestKeyFrame();
        }
    }
}
