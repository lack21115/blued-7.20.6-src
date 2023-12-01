package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/c.class */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f23233a;
    private final float b;

    private c(CameraCaptureSingleton cameraCaptureSingleton, float f) {
        this.f23233a = cameraCaptureSingleton;
        this.b = f;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, float f) {
        return new c(cameraCaptureSingleton, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$setExposureCompensation$9(this.f23233a, this.b);
    }
}
