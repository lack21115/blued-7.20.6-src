package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/y.class */
final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s f36951a;
    private final CaptureSourceInterface.CaptureParams b;

    private y(s sVar, CaptureSourceInterface.CaptureParams captureParams) {
        this.f36951a = sVar;
        this.b = captureParams;
    }

    public static Runnable a(s sVar, CaptureSourceInterface.CaptureParams captureParams) {
        return new y(sVar, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.f36951a;
        sVar.f = new CameraCaptureParams((CameraCaptureParams) this.b);
        if (sVar.d) {
            sVar.e = true;
            return;
        }
        CameraCaptureSingleton.getInstance().updateParams(sVar.f);
        sVar.f.f36842a = null;
    }
}
