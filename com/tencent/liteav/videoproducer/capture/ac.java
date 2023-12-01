package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.capture.s;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ac.class */
final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s.AnonymousClass1 f23167a;

    private ac(s.AnonymousClass1 anonymousClass1) {
        this.f23167a = anonymousClass1;
    }

    public static Runnable a(s.AnonymousClass1 anonymousClass1) {
        return new ac(anonymousClass1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.AnonymousClass1 anonymousClass1 = this.f23167a;
        if (s.this.f23251a != null) {
            s.this.f23251a.notifyError(h.a.ERR_VIDEO_CAPTURE_CAMERA_INVALID_DEVICE, "create EGLCore failed", new Object[0]);
        }
        if (s.this.f23252c != null) {
            s.this.f23252c.a();
        }
    }
}
