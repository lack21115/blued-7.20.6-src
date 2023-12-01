package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/w.class */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37184a;
    private final VideoProducerDef.StreamType b;

    private w(f fVar, VideoProducerDef.StreamType streamType) {
        this.f37184a = fVar;
        this.b = streamType;
    }

    public static Runnable a(f fVar, VideoProducerDef.StreamType streamType) {
        return new w(fVar, streamType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37184a, this.b);
    }
}
