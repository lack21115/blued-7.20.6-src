package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/n.class */
final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f23026a;
    private final VideoDecodeController.DecodeStrategy b;

    private n(j jVar, VideoDecodeController.DecodeStrategy decodeStrategy) {
        this.f23026a = jVar;
        this.b = decodeStrategy;
    }

    public static Runnable a(j jVar, VideoDecodeController.DecodeStrategy decodeStrategy) {
        return new n(jVar, decodeStrategy);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f23026a;
        final VideoDecodeController.DecodeStrategy decodeStrategy = this.b;
        LiteavLog.i(jVar.f23014a, "setDecoderType: ".concat(String.valueOf(decodeStrategy)));
        if (jVar.f != null) {
            final VideoDecodeController videoDecodeController = jVar.f;
            videoDecodeController.a(new Runnable(videoDecodeController, decodeStrategy) { // from class: com.tencent.liteav.videoconsumer.decoder.ac

                /* renamed from: a  reason: collision with root package name */
                private final VideoDecodeController f23056a;
                private final VideoDecodeController.DecodeStrategy b;

                {
                    this.f23056a = videoDecodeController;
                    this.b = decodeStrategy;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    VideoDecodeController videoDecodeController2 = this.f23056a;
                    VideoDecodeController.DecodeStrategy decodeStrategy2 = this.b;
                    d dVar = videoDecodeController2.f23044c;
                    if (dVar.g != decodeStrategy2) {
                        dVar.g = decodeStrategy2;
                        dVar.h = null;
                        if (decodeStrategy2 == VideoDecodeController.DecodeStrategy.USE_HARDWARE_ONLY) {
                            dVar.D = 3;
                        } else {
                            dVar.D = 1;
                        }
                        LiteavLog.i(dVar.f23088a, "set decode strategy to %s", dVar.g);
                    }
                }
            });
        }
    }
}
