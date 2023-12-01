package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/f.class */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f36927a;
    private final CaptureSourceInterface.a b;

    /* renamed from: c  reason: collision with root package name */
    private final CameraCaptureParams f36928c;

    private f(CameraCaptureSingleton cameraCaptureSingleton, CaptureSourceInterface.a aVar, CameraCaptureParams cameraCaptureParams) {
        this.f36927a = cameraCaptureSingleton;
        this.b = aVar;
        this.f36928c = cameraCaptureParams;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, CaptureSourceInterface.a aVar, CameraCaptureParams cameraCaptureParams) {
        return new f(cameraCaptureSingleton, aVar, cameraCaptureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$start$12(this.f36927a, this.b, this.f36928c);
    }
}
