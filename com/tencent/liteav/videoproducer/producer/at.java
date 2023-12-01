package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/at.class */
final /* synthetic */ class at implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37135a;
    private final CaptureSourceInterface.SourceType b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoProducerDef.ProducerMode f37136c;
    private final CaptureSourceInterface.CaptureParams d;

    private at(f fVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.ProducerMode producerMode, CaptureSourceInterface.CaptureParams captureParams) {
        this.f37135a = fVar;
        this.b = sourceType;
        this.f37136c = producerMode;
        this.d = captureParams;
    }

    public static Runnable a(f fVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.ProducerMode producerMode, CaptureSourceInterface.CaptureParams captureParams) {
        return new at(fVar, sourceType, producerMode, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37135a, this.b, this.f37136c, this.d);
    }
}
