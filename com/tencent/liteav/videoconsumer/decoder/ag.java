package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ag.class */
public final /* synthetic */ class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f23060a;

    private ag(VideoDecodeController videoDecodeController) {
        this.f23060a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new ag(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f23060a;
        String str = videoDecodeController.f23043a;
        LiteavLog.i(str, "pixelFrameQueue:" + videoDecodeController.n.c());
    }
}
