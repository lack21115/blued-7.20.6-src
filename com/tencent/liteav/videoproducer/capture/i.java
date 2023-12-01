package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/i.class */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f23240a;

    private i(CameraCaptureSingleton cameraCaptureSingleton) {
        this.f23240a = cameraCaptureSingleton;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton) {
        return new i(cameraCaptureSingleton);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.resumeInternal(this.f23240a.mCurrentCaptureParams);
    }
}
