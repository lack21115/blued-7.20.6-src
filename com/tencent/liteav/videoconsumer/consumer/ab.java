package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/ab.class */
final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f23001a;
    private final VideoDecoderDef.ConsumerScene b;

    private ab(j jVar, VideoDecoderDef.ConsumerScene consumerScene) {
        this.f23001a = jVar;
        this.b = consumerScene;
    }

    public static Runnable a(j jVar, VideoDecoderDef.ConsumerScene consumerScene) {
        return new ab(jVar, consumerScene);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f23001a;
        VideoDecoderDef.ConsumerScene consumerScene = this.b;
        jVar.t = consumerScene;
        if (jVar.f != null) {
            jVar.f.a(consumerScene);
        }
    }
}
