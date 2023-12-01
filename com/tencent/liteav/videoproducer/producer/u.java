package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/u.class */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23489a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoProducerDef.StreamType f23490c;

    private u(f fVar, int i, VideoProducerDef.StreamType streamType) {
        this.f23489a = fVar;
        this.b = i;
        this.f23490c = streamType;
    }

    public static Runnable a(f fVar, int i, VideoProducerDef.StreamType streamType) {
        return new u(fVar, i, streamType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23489a, this.b, this.f23490c);
    }
}
