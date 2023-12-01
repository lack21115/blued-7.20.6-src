package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/w.class */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s f23257a;
    private final CaptureSourceInterface.CaptureParams b;

    /* renamed from: c  reason: collision with root package name */
    private final CaptureSourceInterface.a f23258c;
    private final Object d;

    private w(s sVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.a aVar, Object obj) {
        this.f23257a = sVar;
        this.b = captureParams;
        this.f23258c = aVar;
        this.d = obj;
    }

    public static Runnable a(s sVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.a aVar, Object obj) {
        return new w(sVar, captureParams, aVar, obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.f23257a;
        CaptureSourceInterface.CaptureParams captureParams = this.b;
        CaptureSourceInterface.a aVar = this.f23258c;
        Object obj = this.d;
        sVar.d = false;
        sVar.f = new CameraCaptureParams((CameraCaptureParams) captureParams);
        sVar.f23252c = aVar;
        CameraCaptureSingleton.getInstance().start(obj, sVar.f, sVar.g);
        sVar.f.f23151a = null;
    }
}
