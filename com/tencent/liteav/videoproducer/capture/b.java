package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/b.class */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f23201a;
    private final CaptureSourceInterface.a b;

    private b(CameraCaptureSingleton cameraCaptureSingleton, CaptureSourceInterface.a aVar) {
        this.f23201a = cameraCaptureSingleton;
        this.b = aVar;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, CaptureSourceInterface.a aVar) {
        return new b(cameraCaptureSingleton, aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23201a.mListenerManager.b(this.b);
    }
}
