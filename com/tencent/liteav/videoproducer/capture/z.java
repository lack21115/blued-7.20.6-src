package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/z.class */
final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s f23261a;

    private z(s sVar) {
        this.f23261a = sVar;
    }

    public static Runnable a(s sVar) {
        return new z(sVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.f23261a;
        if (sVar.d) {
            return;
        }
        sVar.d = true;
        CameraCaptureSingleton.getInstance().pause();
    }
}
