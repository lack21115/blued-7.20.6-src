package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/j.class */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f36932a;
    private final CameraCaptureParams b;

    private j(CameraCaptureSingleton cameraCaptureSingleton, CameraCaptureParams cameraCaptureParams) {
        this.f36932a = cameraCaptureSingleton;
        this.b = cameraCaptureParams;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, CameraCaptureParams cameraCaptureParams) {
        return new j(cameraCaptureSingleton, cameraCaptureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$updateParams$15(this.f36932a, this.b);
    }
}
