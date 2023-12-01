package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/aw.class */
final /* synthetic */ class aw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ScreenCapturer f23197a;
    private final CaptureSourceInterface.CaptureParams b;

    private aw(ScreenCapturer screenCapturer, CaptureSourceInterface.CaptureParams captureParams) {
        this.f23197a = screenCapturer;
        this.b = captureParams;
    }

    public static Runnable a(ScreenCapturer screenCapturer, CaptureSourceInterface.CaptureParams captureParams) {
        return new aw(screenCapturer, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.a(this.f23197a, this.b);
    }
}
