package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/w.class */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s f36948a;
    private final CaptureSourceInterface.CaptureParams b;

    /* renamed from: c  reason: collision with root package name */
    private final CaptureSourceInterface.a f36949c;
    private final Object d;

    private w(s sVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.a aVar, Object obj) {
        this.f36948a = sVar;
        this.b = captureParams;
        this.f36949c = aVar;
        this.d = obj;
    }

    public static Runnable a(s sVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.a aVar, Object obj) {
        return new w(sVar, captureParams, aVar, obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.f36948a;
        CaptureSourceInterface.CaptureParams captureParams = this.b;
        CaptureSourceInterface.a aVar = this.f36949c;
        Object obj = this.d;
        sVar.d = false;
        sVar.f = new CameraCaptureParams((CameraCaptureParams) captureParams);
        sVar.f36943c = aVar;
        CameraCaptureSingleton.getInstance().start(obj, sVar.f, sVar.g);
        sVar.f.f36842a = null;
    }
}
