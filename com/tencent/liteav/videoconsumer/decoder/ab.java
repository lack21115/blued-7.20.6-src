package com.tencent.liteav.videoconsumer.decoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ab.class */
public final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f23055a;

    private ab(VideoDecodeController videoDecodeController) {
        this.f23055a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new ab(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f23055a;
        videoDecodeController.j = false;
        videoDecodeController.g = null;
        if (videoDecodeController.f != null) {
            videoDecodeController.f.a();
            videoDecodeController.f = null;
        }
        videoDecodeController.d.a();
        videoDecodeController.h();
        videoDecodeController.j();
    }
}
