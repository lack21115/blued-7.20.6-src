package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.capture.s;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ac.class */
final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s.AnonymousClass1 f36858a;

    private ac(s.AnonymousClass1 anonymousClass1) {
        this.f36858a = anonymousClass1;
    }

    public static Runnable a(s.AnonymousClass1 anonymousClass1) {
        return new ac(anonymousClass1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.AnonymousClass1 anonymousClass1 = this.f36858a;
        if (s.this.f36942a != null) {
            s.this.f36942a.notifyError(h.a.ERR_VIDEO_CAPTURE_CAMERA_INVALID_DEVICE, "create EGLCore failed", new Object[0]);
        }
        if (s.this.f36943c != null) {
            s.this.f36943c.a();
        }
    }
}
