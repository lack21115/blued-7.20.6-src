package com.tencent.liteav.videoproducer.capture.b;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import com.tencent.liteav.videoproducer.capture.b.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/b/d.class */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a.AnonymousClass4 f23212a;
    private final TotalCaptureResult b;

    /* renamed from: c  reason: collision with root package name */
    private final CameraCaptureSession f23213c;
    private final CaptureRequest d;

    private d(a.AnonymousClass4 anonymousClass4, TotalCaptureResult totalCaptureResult, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest) {
        this.f23212a = anonymousClass4;
        this.b = totalCaptureResult;
        this.f23213c = cameraCaptureSession;
        this.d = captureRequest;
    }

    public static Runnable a(a.AnonymousClass4 anonymousClass4, TotalCaptureResult totalCaptureResult, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest) {
        return new d(anonymousClass4, totalCaptureResult, cameraCaptureSession, captureRequest);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.AnonymousClass4.a(this.f23212a, this.b, this.f23213c, this.d);
    }
}
