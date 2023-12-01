package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.ServerVideoConsumerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/u.class */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f23036a;
    private final ServerVideoConsumerConfig b;

    private u(j jVar, ServerVideoConsumerConfig serverVideoConsumerConfig) {
        this.f23036a = jVar;
        this.b = serverVideoConsumerConfig;
    }

    public static Runnable a(j jVar, ServerVideoConsumerConfig serverVideoConsumerConfig) {
        return new u(jVar, serverVideoConsumerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f23036a;
        final ServerVideoConsumerConfig serverVideoConsumerConfig = this.b;
        LiteavLog.i(jVar.f23014a, "setServerConfig=".concat(String.valueOf(serverVideoConsumerConfig)));
        if (jVar.f != null) {
            final VideoDecodeController videoDecodeController = jVar.f;
            videoDecodeController.a(new Runnable(videoDecodeController, serverVideoConsumerConfig) { // from class: com.tencent.liteav.videoconsumer.decoder.aq

                /* renamed from: a  reason: collision with root package name */
                private final VideoDecodeController f23071a;
                private final ServerVideoConsumerConfig b;

                {
                    this.f23071a = videoDecodeController;
                    this.b = serverVideoConsumerConfig;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    VideoDecodeController videoDecodeController2 = this.f23071a;
                    videoDecodeController2.o = this.b;
                    d dVar = videoDecodeController2.f23044c;
                    ServerVideoConsumerConfig serverVideoConsumerConfig2 = videoDecodeController2.o;
                    if (serverVideoConsumerConfig2 != null) {
                        dVar.m = serverVideoConsumerConfig2.hwDecoderMaxCacheForHighRes;
                        dVar.n = serverVideoConsumerConfig2.hwDecoderMaxCacheForLowRes;
                        LiteavLog.i(dVar.f23088a, "set hardware decoder max cache to highResolution: %d, lowResolution: %d", Integer.valueOf(dVar.m), Integer.valueOf(dVar.n));
                    }
                }
            });
        }
    }
}
