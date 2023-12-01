package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/bb.class */
final /* synthetic */ class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ScreenCapturer f23218a;

    private bb(ScreenCapturer screenCapturer) {
        this.f23218a = screenCapturer;
    }

    public static Runnable a(ScreenCapturer screenCapturer) {
        return new bb(screenCapturer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.a(this.f23218a);
    }
}
