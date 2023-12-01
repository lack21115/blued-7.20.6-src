package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/k.class */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23475a;
    private final VideoProducerDef.StreamType b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoEncoderDef.EncodeStrategy f23476c;

    private k(f fVar, VideoProducerDef.StreamType streamType, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        this.f23475a = fVar;
        this.b = streamType;
        this.f23476c = encodeStrategy;
    }

    public static Runnable a(f fVar, VideoProducerDef.StreamType streamType, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        return new k(fVar, streamType, encodeStrategy);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23475a, this.b, this.f23476c);
    }
}
