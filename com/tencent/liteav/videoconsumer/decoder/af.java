package com.tencent.liteav.videoconsumer.decoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/af.class */
public final /* synthetic */ class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f23059a;

    private af(VideoDecodeController videoDecodeController) {
        this.f23059a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new af(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23059a.c();
    }
}
