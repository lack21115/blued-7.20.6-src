package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ac.class */
final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23418a;
    private final ServerVideoProducerConfig b;

    private ac(f fVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f23418a = fVar;
        this.b = serverVideoProducerConfig;
    }

    public static Runnable a(f fVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        return new ac(fVar, serverVideoProducerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23418a, this.b);
    }
}
