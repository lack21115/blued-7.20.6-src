package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/t.class */
final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37178a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoProducerDef.StreamType f37179c;

    private t(f fVar, int i, VideoProducerDef.StreamType streamType) {
        this.f37178a = fVar;
        this.b = i;
        this.f37179c = streamType;
    }

    public static Runnable a(f fVar, int i, VideoProducerDef.StreamType streamType) {
        return new t(fVar, i, streamType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.b(this.f37178a, this.b, this.f37179c);
    }
}
