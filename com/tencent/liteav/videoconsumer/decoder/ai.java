package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.h;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ai.class */
final /* synthetic */ class ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f23063a;

    private ai(VideoDecodeController videoDecodeController) {
        this.f23063a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new ai(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f23063a;
        LiteavLog.i(videoDecodeController.f23043a, "on decode failed, type: %s", videoDecodeController.f());
        videoDecodeController.f23044c.r = true;
        aw awVar = videoDecodeController.d;
        awVar.j++;
        awVar.b();
        videoDecodeController.b.notifyWarning(h.c.WARNING_VIDEO_DECODE_ABNORMAL, "decode error try restart", new Object[0]);
    }
}
