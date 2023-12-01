package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/k.class */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f23242a;
    private final ServerVideoProducerConfig b;

    private k(CameraCaptureSingleton cameraCaptureSingleton, ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f23242a = cameraCaptureSingleton;
        this.b = serverVideoProducerConfig;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, ServerVideoProducerConfig serverVideoProducerConfig) {
        return new k(cameraCaptureSingleton, serverVideoProducerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$setServerConfig$1(this.f23242a, this.b);
    }
}
