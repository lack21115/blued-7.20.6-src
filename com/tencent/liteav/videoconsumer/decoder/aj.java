package com.tencent.liteav.videoconsumer.decoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/aj.class */
public final /* synthetic */ class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f23064a;

    private aj(VideoDecodeController videoDecodeController) {
        this.f23064a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new aj(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23064a.b();
    }
}
