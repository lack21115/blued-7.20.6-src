package com.tencent.liteav.videoproducer.capture.b;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import com.tencent.liteav.videoproducer.capture.b.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/b/e.class */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a.AnonymousClass4 f23214a;
    private final CaptureRequest b;

    /* renamed from: c  reason: collision with root package name */
    private final CameraCaptureSession f23215c;

    private e(a.AnonymousClass4 anonymousClass4, CaptureRequest captureRequest, CameraCaptureSession cameraCaptureSession) {
        this.f23214a = anonymousClass4;
        this.b = captureRequest;
        this.f23215c = cameraCaptureSession;
    }

    public static Runnable a(a.AnonymousClass4 anonymousClass4, CaptureRequest captureRequest, CameraCaptureSession cameraCaptureSession) {
        return new e(anonymousClass4, captureRequest, cameraCaptureSession);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.AnonymousClass4.a(this.f23214a, this.b, this.f23215c);
    }
}
