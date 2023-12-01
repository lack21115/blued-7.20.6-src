package com.tencent.liteav.videoconsumer.decoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/au.class */
public final /* synthetic */ class au implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f36766a;

    private au(VideoDecodeController videoDecodeController) {
        this.f36766a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new au(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36766a.d();
    }
}
