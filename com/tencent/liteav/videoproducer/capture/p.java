package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/p.class */
final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f23248a;
    private final boolean b;

    private p(CameraCaptureSingleton cameraCaptureSingleton, boolean z) {
        this.f23248a = cameraCaptureSingleton;
        this.b = z;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, boolean z) {
        return new p(cameraCaptureSingleton, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$enableCameraZoom$6(this.f23248a, this.b);
    }
}
