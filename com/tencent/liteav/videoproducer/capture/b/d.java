package com.tencent.liteav.videoproducer.capture.b;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import com.tencent.liteav.videoproducer.capture.b.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/b/d.class */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a.AnonymousClass4 f36903a;
    private final TotalCaptureResult b;

    /* renamed from: c  reason: collision with root package name */
    private final CameraCaptureSession f36904c;
    private final CaptureRequest d;

    private d(a.AnonymousClass4 anonymousClass4, TotalCaptureResult totalCaptureResult, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest) {
        this.f36903a = anonymousClass4;
        this.b = totalCaptureResult;
        this.f36904c = cameraCaptureSession;
        this.d = captureRequest;
    }

    public static Runnable a(a.AnonymousClass4 anonymousClass4, TotalCaptureResult totalCaptureResult, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest) {
        return new d(anonymousClass4, totalCaptureResult, cameraCaptureSession, captureRequest);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.AnonymousClass4.a(this.f36903a, this.b, this.f36904c, this.d);
    }
}
