package com.tencent.liteav.videoproducer.encoder;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/w.class */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    final String f37041a;
    a h;
    double b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    long f37042c = 0;
    long d = 0;
    long e = 0;
    long f = 0;
    long g = 0;
    int i = Math.max(1000, 1000);
    int j = Math.max(1000, 1000);

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/w$a.class */
    public interface a {
        void a(double d);

        void a(long j);
    }

    public w(a aVar, VideoProducerDef.StreamType streamType) {
        this.h = aVar;
        this.f37041a = "RealFpsAndBitrateCaculate_" + streamType + BridgeUtil.UNDERLINE_STR + hashCode();
    }
}
