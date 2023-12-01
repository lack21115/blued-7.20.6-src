package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/u.class */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final int f36946a;
    private final int b;

    private u(int i, int i2) {
        this.f36946a = i;
        this.b = i2;
    }

    public static Runnable a(int i, int i2) {
        return new u(i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.getInstance().startAutoFocusAtPosition(this.f36946a, this.b);
    }
}
