package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/bc.class */
final /* synthetic */ class bc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ScreenCapturer f36910a;
    private final boolean b;

    private bc(ScreenCapturer screenCapturer, boolean z) {
        this.f36910a = screenCapturer;
        this.b = z;
    }

    public static Runnable a(ScreenCapturer screenCapturer, boolean z) {
        return new bc(screenCapturer, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.a(this.f36910a, this.b);
    }
}
