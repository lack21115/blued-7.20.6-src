package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ba.class */
final /* synthetic */ class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ScreenCapturer f23216a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23217c;

    private ba(ScreenCapturer screenCapturer, boolean z, boolean z2) {
        this.f23216a = screenCapturer;
        this.b = z;
        this.f23217c = z2;
    }

    public static Runnable a(ScreenCapturer screenCapturer, boolean z, boolean z2) {
        return new ba(screenCapturer, z, z2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.a(this.f23216a, this.b, this.f23217c);
    }
}
