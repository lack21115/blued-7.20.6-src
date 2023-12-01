package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/be.class */
public final class be implements r.a {

    /* renamed from: a  reason: collision with root package name */
    final String f23317a;
    IVideoReporter b;

    /* renamed from: c  reason: collision with root package name */
    Map<Long, Long> f23318c = new HashMap();
    long d = 0;
    long e = 0;
    com.tencent.liteav.base.util.r f;

    public be(IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType) {
        this.b = iVideoReporter;
        this.f23317a = "VECStatistics_" + streamType + "_" + hashCode();
    }

    @Override // com.tencent.liteav.base.util.r.a
    public final void a_() {
        if (this.e > 0) {
            this.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODE_AVERAGE_ENCODE_COST, Long.valueOf(this.d / this.e));
        }
    }
}
