package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/o.class */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSingleton f36937a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36938c;

    private o(CameraCaptureSingleton cameraCaptureSingleton, int i, int i2) {
        this.f36937a = cameraCaptureSingleton;
        this.b = i;
        this.f36938c = i2;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, int i, int i2) {
        return new o(cameraCaptureSingleton, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$startAutoFocusAtPosition$5(this.f36937a, this.b, this.f36938c);
    }
}
