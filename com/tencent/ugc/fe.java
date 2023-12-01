package com.tencent.ugc;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fe.class */
final /* synthetic */ class fe implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f26687a;
    private final PixelFrame b;

    private fe(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, PixelFrame pixelFrame) {
        this.f26687a = uGCSingleFilePixelFrameProvider;
        this.b = pixelFrame;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, PixelFrame pixelFrame) {
        return new fe(uGCSingleFilePixelFrameProvider, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26687a.onDecodeFrameInternal(this.b);
    }
}
