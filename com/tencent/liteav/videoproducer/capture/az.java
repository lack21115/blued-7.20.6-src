package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/az.class */
final /* synthetic */ class az implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ScreenCapturer f36891a;

    private az(ScreenCapturer screenCapturer) {
        this.f36891a = screenCapturer;
    }

    public static Runnable a(ScreenCapturer screenCapturer) {
        return new az(screenCapturer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.b(this.f36891a);
    }
}
