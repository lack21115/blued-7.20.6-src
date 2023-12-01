package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/r.class */
public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f23250a;
    private final float b;

    private r(CameraCaptureSingleton cameraCaptureSingleton, float f) {
        this.f23250a = cameraCaptureSingleton;
        this.b = f;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, float f) {
        return new r(cameraCaptureSingleton, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23250a.setZoomInternal(this.b);
    }
}
