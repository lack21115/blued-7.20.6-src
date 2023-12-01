package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/n.class */
final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f23245a;
    private final boolean b;

    private n(CameraCaptureSingleton cameraCaptureSingleton, boolean z) {
        this.f23245a = cameraCaptureSingleton;
        this.b = z;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, boolean z) {
        return new n(cameraCaptureSingleton, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$enableTapToFocus$4(this.f23245a, this.b);
    }
}
