package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.videoconsumer.consumer.ServerVideoConsumerConfig;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/y.class */
final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final r f36811a;
    private final ServerVideoConsumerConfig b;

    private y(r rVar, ServerVideoConsumerConfig serverVideoConsumerConfig) {
        this.f36811a = rVar;
        this.b = serverVideoConsumerConfig;
    }

    public static Runnable a(r rVar, ServerVideoConsumerConfig serverVideoConsumerConfig) {
        return new y(rVar, serverVideoConsumerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.a(this.f36811a, this.b);
    }
}
