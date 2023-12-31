package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.ScreenCapturer;
import com.tencent.liteav.videoproducer.capture.ah;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ak.class */
final /* synthetic */ class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah f23181a;
    private final CaptureSourceInterface.CaptureParams b;

    /* renamed from: c  reason: collision with root package name */
    private final CaptureSourceInterface.a f23182c;
    private final Object d;

    private ak(ah ahVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.a aVar, Object obj) {
        this.f23181a = ahVar;
        this.b = captureParams;
        this.f23182c = aVar;
        this.d = obj;
    }

    public static Runnable a(ah ahVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.a aVar, Object obj) {
        return new ak(ahVar, captureParams, aVar, obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar = this.f23181a;
        CaptureSourceInterface.CaptureParams captureParams = this.b;
        CaptureSourceInterface.a aVar = this.f23182c;
        Object obj = this.d;
        if (ahVar.k != ah.a.STOPED) {
            LiteavLog.w("CaptureController", "Start capture but mStatus is " + ahVar.k);
            return;
        }
        ahVar.m.b();
        ahVar.k = ah.a.STARTED;
        if (captureParams instanceof CameraCaptureParams) {
            ahVar.f23174c = new s(ahVar.h, ahVar.f);
        } else if (captureParams instanceof ScreenCapturer.ScreenCaptureParams) {
            ahVar.f23174c = new ScreenCapturer(ahVar.g, ahVar.f, ahVar.h);
        } else {
            LiteavLog.w("CaptureController", "initCaptureSource： param is VirtualCameraParams");
        }
        ahVar.e = aVar;
        ahVar.d = captureParams;
        ahVar.i = obj;
        if (ahVar.f23174c != null) {
            ahVar.f23174c.start(obj, captureParams, ahVar.n);
        }
    }
}
