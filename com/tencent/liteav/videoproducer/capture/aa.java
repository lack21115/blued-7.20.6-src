package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.capture.af;
import com.tencent.liteav.videoproducer.capture.s;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/aa.class */
final /* synthetic */ class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s.AnonymousClass1 f23165a;
    private final boolean b;

    private aa(s.AnonymousClass1 anonymousClass1, boolean z) {
        this.f23165a = anonymousClass1;
        this.b = z;
    }

    public static Runnable a(s.AnonymousClass1 anonymousClass1, boolean z) {
        return new aa(anonymousClass1, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.AnonymousClass1 anonymousClass1 = this.f23165a;
        boolean z = this.b;
        s sVar = s.this;
        if (sVar.f23251a != null) {
            af.a cameraAPIType = CameraCaptureSingleton.getInstance().getCameraAPIType();
            if (z) {
                IVideoReporter iVideoReporter = sVar.f23251a;
                h.b bVar = h.b.EVT_VIDEO_CAPTURE_CAMERA_START_SUCCESS;
                iVideoReporter.notifyEvent(bVar, "cameraAPIType " + cameraAPIType + " params:" + sVar.f, new Object[0]);
            } else {
                IVideoReporter iVideoReporter2 = sVar.f23251a;
                h.a aVar = h.a.ERR_VIDEO_CAPTURE_CAMERA_INVALID_DEVICE;
                iVideoReporter2.notifyError(aVar, "cameraAPIType " + cameraAPIType + " params:" + sVar.f, new Object[0]);
            }
        }
        if (s.this.f23252c != null) {
            s.this.f23252c.a(z);
        }
    }
}
