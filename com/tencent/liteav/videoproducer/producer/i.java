package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/i.class */
final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23472a;
    private final VideoProducerDef.StreamType b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoEncodeParams f23473c;
    private final VideoEncoderDef.VideoEncoderDataListener d;

    private i(f fVar, VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        this.f23472a = fVar;
        this.b = streamType;
        this.f23473c = videoEncodeParams;
        this.d = videoEncoderDataListener;
    }

    public static Runnable a(f fVar, VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        return new i(fVar, streamType, videoEncodeParams, videoEncoderDataListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23472a, this.b, this.f23473c, this.d);
    }
}
