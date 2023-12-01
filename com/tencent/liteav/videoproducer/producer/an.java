package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/an.class */
final /* synthetic */ class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37125a;
    private final CaptureSourceInterface.SourceType b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoProducerDef.ProducerMode f37126c;
    private final CaptureSourceInterface.CaptureParams d;

    private an(f fVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.ProducerMode producerMode, CaptureSourceInterface.CaptureParams captureParams) {
        this.f37125a = fVar;
        this.b = sourceType;
        this.f37126c = producerMode;
        this.d = captureParams;
    }

    public static Runnable a(f fVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.ProducerMode producerMode, CaptureSourceInterface.CaptureParams captureParams) {
        return new an(fVar, sourceType, producerMode, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.b(this.f37125a, this.b, this.f37126c, this.d);
    }
}
