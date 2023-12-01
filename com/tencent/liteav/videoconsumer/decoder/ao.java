package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ao.class */
final /* synthetic */ class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f23069a;
    private final boolean b;

    private ao(VideoDecodeController videoDecodeController, boolean z) {
        this.f23069a = videoDecodeController;
        this.b = z;
    }

    public static Runnable a(VideoDecodeController videoDecodeController, boolean z) {
        return new ao(videoDecodeController, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f23069a;
        boolean z = this.b;
        d dVar = videoDecodeController.f23044c;
        dVar.v = z;
        String str = dVar.f23088a;
        LiteavLog.i(str, "setUsingLowLatencyDecoder:" + dVar.v);
    }
}
