package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ad.class */
public final /* synthetic */ class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f36748a;

    private ad(VideoDecodeController videoDecodeController) {
        this.f36748a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new ad(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f36748a;
        videoDecodeController.j();
        if (videoDecodeController.k != null) {
            videoDecodeController.k.abandonDecodingFrames();
        } else {
            videoDecodeController.onAbandonDecodingFramesCompleted();
        }
    }
}
