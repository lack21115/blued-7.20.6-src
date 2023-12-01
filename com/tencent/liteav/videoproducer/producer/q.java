package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/q.class */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37174a;
    private final VideoProducerDef.HomeOrientation b;

    private q(f fVar, VideoProducerDef.HomeOrientation homeOrientation) {
        this.f37174a = fVar;
        this.b = homeOrientation;
    }

    public static Runnable a(f fVar, VideoProducerDef.HomeOrientation homeOrientation) {
        return new q(fVar, homeOrientation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37174a, this.b);
    }
}
