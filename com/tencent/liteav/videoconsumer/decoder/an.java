package com.tencent.liteav.videoconsumer.decoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/an.class */
public final /* synthetic */ class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f36759a;

    private an(VideoDecodeController videoDecodeController) {
        this.f36759a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new an(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f36759a;
        if (videoDecodeController.g != null) {
            videoDecodeController.g.onDecodeCompleted();
        }
    }
}
