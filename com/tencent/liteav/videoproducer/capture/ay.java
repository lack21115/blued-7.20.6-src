package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ay.class */
final /* synthetic */ class ay implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ScreenCapturer f23199a;

    private ay(ScreenCapturer screenCapturer) {
        this.f23199a = screenCapturer;
    }

    public static Runnable a(ScreenCapturer screenCapturer) {
        return new ay(screenCapturer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.c(this.f23199a);
    }
}
