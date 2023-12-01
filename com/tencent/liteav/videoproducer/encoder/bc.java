package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/bc.class */
public final /* synthetic */ class bc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f23315a;
    private final VideoEncoderDef.EncodeStrategy b;

    private bc(ai aiVar, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        this.f23315a = aiVar;
        this.b = encodeStrategy;
    }

    public static Runnable a(ai aiVar, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        return new bc(aiVar, encodeStrategy);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f23315a, this.b);
    }
}
