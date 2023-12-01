package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videoproducer.capture.s;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ab.class */
final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s.AnonymousClass1 f23166a;
    private final PixelFrame b;

    private ab(s.AnonymousClass1 anonymousClass1, PixelFrame pixelFrame) {
        this.f23166a = anonymousClass1;
        this.b = pixelFrame;
    }

    public static Runnable a(s.AnonymousClass1 anonymousClass1, PixelFrame pixelFrame) {
        return new ab(anonymousClass1, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.AnonymousClass1 anonymousClass1 = this.f23166a;
        PixelFrame pixelFrame = this.b;
        if (s.this.d) {
            pixelFrame.release();
        } else if (s.this.f23252c == null) {
            pixelFrame.release();
        } else {
            s.this.f23252c.a(s.this, pixelFrame);
            pixelFrame.release();
        }
    }
}
