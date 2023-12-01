package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/v.class */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23491a;
    private final VideoProducerDef.StreamType b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23492c;
    private final int d;

    private v(f fVar, VideoProducerDef.StreamType streamType, int i, int i2) {
        this.f23491a = fVar;
        this.b = streamType;
        this.f23492c = i;
        this.d = i2;
    }

    public static Runnable a(f fVar, VideoProducerDef.StreamType streamType, int i, int i2) {
        return new v(fVar, streamType, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23491a, this.b, this.f23492c, this.d);
    }
}
