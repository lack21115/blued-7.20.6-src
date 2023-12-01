package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/t.class */
final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s f23254a;

    private t(s sVar) {
        this.f23254a = sVar;
    }

    public static Runnable a(s sVar) {
        return new t(sVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.f23254a;
        if (sVar.d) {
            sVar.d = false;
            if (!sVar.e) {
                CameraCaptureSingleton.getInstance().resume();
                return;
            }
            sVar.e = false;
            CameraCaptureSingleton.getInstance().updateParams(sVar.f);
            sVar.f.f23151a = null;
        }
    }
}
