package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/d.class */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f36925a;
    private final ad b;

    private d(CameraCaptureSingleton cameraCaptureSingleton, ad adVar) {
        this.f36925a = cameraCaptureSingleton;
        this.b = adVar;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, ad adVar) {
        return new d(cameraCaptureSingleton, adVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$onCameraError$10(this.f36925a, this.b);
    }
}
