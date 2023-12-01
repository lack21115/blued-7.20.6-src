package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ak.class */
final /* synthetic */ class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f36756a;

    private ak(VideoDecodeController videoDecodeController) {
        this.f36756a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new ak(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f36756a;
        if (videoDecodeController.g != null) {
            videoDecodeController.g.onRequestKeyFrame();
        }
    }
}
