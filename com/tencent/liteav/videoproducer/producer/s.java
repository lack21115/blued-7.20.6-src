package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/s.class */
final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23485a;
    private final VideoProducerDef.StreamType b;

    /* renamed from: c  reason: collision with root package name */
    private final GLConstants.Orientation f23486c;
    private final VideoEncodeParams d;

    private s(f fVar, VideoProducerDef.StreamType streamType, GLConstants.Orientation orientation, VideoEncodeParams videoEncodeParams) {
        this.f23485a = fVar;
        this.b = streamType;
        this.f23486c = orientation;
        this.d = videoEncodeParams;
    }

    public static Runnable a(f fVar, VideoProducerDef.StreamType streamType, GLConstants.Orientation orientation, VideoEncodeParams videoEncodeParams) {
        return new s(fVar, streamType, orientation, videoEncodeParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23485a, this.b, this.f23486c, this.d);
    }
}
