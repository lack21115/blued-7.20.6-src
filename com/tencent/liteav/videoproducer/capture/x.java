package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/x.class */
final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s f36950a;

    private x(s sVar) {
        this.f36950a = sVar;
    }

    public static Runnable a(s sVar) {
        return new x(sVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.f36950a;
        sVar.f36943c = null;
        CameraCaptureSingleton.getInstance().removeListener(sVar.g);
        sVar.d = true;
        sVar.e = false;
        CameraCaptureSingleton.getInstance().stop();
    }
}
