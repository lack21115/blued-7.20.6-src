package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/s.class */
final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final r f23113a;
    private final VideoDecoderDef.ConsumerScene b;

    private s(r rVar, VideoDecoderDef.ConsumerScene consumerScene) {
        this.f23113a = rVar;
        this.b = consumerScene;
    }

    public static Runnable a(r rVar, VideoDecoderDef.ConsumerScene consumerScene) {
        return new s(rVar, consumerScene);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23113a.q = this.b;
    }
}
