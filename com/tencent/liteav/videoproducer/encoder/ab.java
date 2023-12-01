package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ab.class */
final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f23279a;
    private final ServerVideoProducerConfig b;

    private ab(x xVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f23279a = xVar;
        this.b = serverVideoProducerConfig;
    }

    public static Runnable a(x xVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        return new ab(xVar, serverVideoProducerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23279a.i = this.b;
    }
}
