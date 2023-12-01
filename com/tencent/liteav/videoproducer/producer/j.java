package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/j.class */
final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37165a;
    private final VideoProducerDef.StreamType b;

    private j(f fVar, VideoProducerDef.StreamType streamType) {
        this.f37165a = fVar;
        this.b = streamType;
    }

    public static Runnable a(f fVar, VideoProducerDef.StreamType streamType) {
        return new j(fVar, streamType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.b(this.f37165a, this.b);
    }
}
