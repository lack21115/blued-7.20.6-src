package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/am.class */
final /* synthetic */ class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37123a;
    private final PixelFrame b;

    /* renamed from: c  reason: collision with root package name */
    private final CaptureSourceInterface f37124c;

    private am(f fVar, PixelFrame pixelFrame, CaptureSourceInterface captureSourceInterface) {
        this.f37123a = fVar;
        this.b = pixelFrame;
        this.f37124c = captureSourceInterface;
    }

    public static Runnable a(f fVar, PixelFrame pixelFrame, CaptureSourceInterface captureSourceInterface) {
        return new am(fVar, pixelFrame, captureSourceInterface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37123a, this.b, this.f37124c);
    }
}
