package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/q.class */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f23249a;
    private final float b;

    private q(CameraCaptureSingleton cameraCaptureSingleton, float f) {
        this.f23249a = cameraCaptureSingleton;
        this.b = f;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, float f) {
        return new q(cameraCaptureSingleton, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$setZoomLevel$7(this.f23249a, this.b);
    }
}
