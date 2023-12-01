package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ax.class */
public final /* synthetic */ class ax implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f23308a;
    private final ServerVideoProducerConfig b;

    private ax(ai aiVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f23308a = aiVar;
        this.b = serverVideoProducerConfig;
    }

    public static Runnable a(ai aiVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        return new ax(aiVar, serverVideoProducerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23308a.m = this.b;
    }
}
