package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ay.class */
public final /* synthetic */ class ay implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f37000a;
    private final VideoEncodeParams b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoEncoderDef.VideoEncoderDataListener f37001c;

    private ay(ai aiVar, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        this.f37000a = aiVar;
        this.b = videoEncodeParams;
        this.f37001c = videoEncoderDataListener;
    }

    public static Runnable a(ai aiVar, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        return new ay(aiVar, videoEncodeParams, videoEncoderDataListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f37000a, this.b, this.f37001c);
    }
}
