package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ao.class */
final /* synthetic */ class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f36760a;
    private final boolean b;

    private ao(VideoDecodeController videoDecodeController, boolean z) {
        this.f36760a = videoDecodeController;
        this.b = z;
    }

    public static Runnable a(VideoDecodeController videoDecodeController, boolean z) {
        return new ao(videoDecodeController, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f36760a;
        boolean z = this.b;
        d dVar = videoDecodeController.f36735c;
        dVar.v = z;
        String str = dVar.f36779a;
        LiteavLog.i(str, "setUsingLowLatencyDecoder:" + dVar.v);
    }
}
