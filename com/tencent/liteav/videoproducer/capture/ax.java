package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ax.class */
final /* synthetic */ class ax implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ScreenCapturer f36889a;

    private ax(ScreenCapturer screenCapturer) {
        this.f36889a = screenCapturer;
    }

    public static Runnable a(ScreenCapturer screenCapturer) {
        return new ax(screenCapturer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.d(this.f36889a);
    }
}
