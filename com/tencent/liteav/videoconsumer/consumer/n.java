package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/n.class */
final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f36717a;
    private final VideoDecodeController.DecodeStrategy b;

    private n(j jVar, VideoDecodeController.DecodeStrategy decodeStrategy) {
        this.f36717a = jVar;
        this.b = decodeStrategy;
    }

    public static Runnable a(j jVar, VideoDecodeController.DecodeStrategy decodeStrategy) {
        return new n(jVar, decodeStrategy);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f36717a;
        final VideoDecodeController.DecodeStrategy decodeStrategy = this.b;
        LiteavLog.i(jVar.f36705a, "setDecoderType: ".concat(String.valueOf(decodeStrategy)));
        if (jVar.f != null) {
            final VideoDecodeController videoDecodeController = jVar.f;
            videoDecodeController.a(new Runnable(videoDecodeController, decodeStrategy) { // from class: com.tencent.liteav.videoconsumer.decoder.ac

                /* renamed from: a  reason: collision with root package name */
                private final VideoDecodeController f36747a;
                private final VideoDecodeController.DecodeStrategy b;

                {
                    this.f36747a = videoDecodeController;
                    this.b = decodeStrategy;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    VideoDecodeController videoDecodeController2 = this.f36747a;
                    VideoDecodeController.DecodeStrategy decodeStrategy2 = this.b;
                    d dVar = videoDecodeController2.f36735c;
                    if (dVar.g != decodeStrategy2) {
                        dVar.g = decodeStrategy2;
                        dVar.h = null;
                        if (decodeStrategy2 == VideoDecodeController.DecodeStrategy.USE_HARDWARE_ONLY) {
                            dVar.D = 3;
                        } else {
                            dVar.D = 1;
                        }
                        LiteavLog.i(dVar.f36779a, "set decode strategy to %s", dVar.g);
                    }
                }
            });
        }
    }
}
