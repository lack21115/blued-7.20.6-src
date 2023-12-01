package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/p.class */
final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37173a;
    private final VideoProducerDef.GSensorMode b;

    private p(f fVar, VideoProducerDef.GSensorMode gSensorMode) {
        this.f37173a = fVar;
        this.b = gSensorMode;
    }

    public static Runnable a(f fVar, VideoProducerDef.GSensorMode gSensorMode) {
        return new p(fVar, gSensorMode);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37173a, this.b);
    }
}
