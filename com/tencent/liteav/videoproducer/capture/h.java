package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/h.class */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f23239a;

    private h(CameraCaptureSingleton cameraCaptureSingleton) {
        this.f23239a = cameraCaptureSingleton;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton) {
        return new h(cameraCaptureSingleton);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23239a.pauseInternal();
    }
}
