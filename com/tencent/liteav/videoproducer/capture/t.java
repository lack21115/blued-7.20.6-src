package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/t.class */
final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s f36945a;

    private t(s sVar) {
        this.f36945a = sVar;
    }

    public static Runnable a(s sVar) {
        return new t(sVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.f36945a;
        if (sVar.d) {
            sVar.d = false;
            if (!sVar.e) {
                CameraCaptureSingleton.getInstance().resume();
                return;
            }
            sVar.e = false;
            CameraCaptureSingleton.getInstance().updateParams(sVar.f);
            sVar.f.f36842a = null;
        }
    }
}
