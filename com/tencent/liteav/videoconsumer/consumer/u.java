package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.ServerVideoConsumerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/u.class */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f36727a;
    private final ServerVideoConsumerConfig b;

    private u(j jVar, ServerVideoConsumerConfig serverVideoConsumerConfig) {
        this.f36727a = jVar;
        this.b = serverVideoConsumerConfig;
    }

    public static Runnable a(j jVar, ServerVideoConsumerConfig serverVideoConsumerConfig) {
        return new u(jVar, serverVideoConsumerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f36727a;
        final ServerVideoConsumerConfig serverVideoConsumerConfig = this.b;
        LiteavLog.i(jVar.f36705a, "setServerConfig=".concat(String.valueOf(serverVideoConsumerConfig)));
        if (jVar.f != null) {
            final VideoDecodeController videoDecodeController = jVar.f;
            videoDecodeController.a(new Runnable(videoDecodeController, serverVideoConsumerConfig) { // from class: com.tencent.liteav.videoconsumer.decoder.aq

                /* renamed from: a  reason: collision with root package name */
                private final VideoDecodeController f36762a;
                private final ServerVideoConsumerConfig b;

                {
                    this.f36762a = videoDecodeController;
                    this.b = serverVideoConsumerConfig;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    VideoDecodeController videoDecodeController2 = this.f36762a;
                    videoDecodeController2.o = this.b;
                    d dVar = videoDecodeController2.f36735c;
                    ServerVideoConsumerConfig serverVideoConsumerConfig2 = videoDecodeController2.o;
                    if (serverVideoConsumerConfig2 != null) {
                        dVar.m = serverVideoConsumerConfig2.hwDecoderMaxCacheForHighRes;
                        dVar.n = serverVideoConsumerConfig2.hwDecoderMaxCacheForLowRes;
                        LiteavLog.i(dVar.f36779a, "set hardware decoder max cache to highResolution: %d, lowResolution: %d", Integer.valueOf(dVar.m), Integer.valueOf(dVar.n));
                    }
                }
            });
        }
    }
}
