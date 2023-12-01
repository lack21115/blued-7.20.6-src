package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/m.class */
final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f23244a;
    private final boolean b;

    private m(CameraCaptureSingleton cameraCaptureSingleton, boolean z) {
        this.f23244a = cameraCaptureSingleton;
        this.b = z;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, boolean z) {
        return new m(cameraCaptureSingleton, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$turnOnTorch$3(this.f23244a, this.b);
    }
}
