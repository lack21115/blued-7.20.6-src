package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ba.class */
final /* synthetic */ class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ScreenCapturer f36907a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f36908c;

    private ba(ScreenCapturer screenCapturer, boolean z, boolean z2) {
        this.f36907a = screenCapturer;
        this.b = z;
        this.f36908c = z2;
    }

    public static Runnable a(ScreenCapturer screenCapturer, boolean z, boolean z2) {
        return new ba(screenCapturer, z, z2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.a(this.f36907a, this.b, this.f36908c);
    }
}
