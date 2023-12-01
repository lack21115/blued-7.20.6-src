package com.tencent.liteav.videoproducer.capture;

import android.graphics.SurfaceTexture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/e.class */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f23235a;
    private final SurfaceTexture b;

    private e(CameraCaptureSingleton cameraCaptureSingleton, SurfaceTexture surfaceTexture) {
        this.f23235a = cameraCaptureSingleton;
        this.b = surfaceTexture;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, SurfaceTexture surfaceTexture) {
        return new e(cameraCaptureSingleton, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$onFrameAvailable$11(this.f23235a, this.b);
    }
}
