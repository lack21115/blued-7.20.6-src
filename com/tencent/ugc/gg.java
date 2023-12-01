package com.tencent.ugc;

import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.ugc.UGCVideoProcessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gg.class */
final /* synthetic */ class gg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor.AnonymousClass2 f40416a;
    private final PixelFrame b;

    private gg(UGCVideoProcessor.AnonymousClass2 anonymousClass2, PixelFrame pixelFrame) {
        this.f40416a = anonymousClass2;
        this.b = pixelFrame;
    }

    public static Runnable a(UGCVideoProcessor.AnonymousClass2 anonymousClass2, PixelFrame pixelFrame) {
        return new gg(anonymousClass2, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.AnonymousClass2 anonymousClass2 = this.f40416a;
        PixelFrame pixelFrame = this.b;
        if (UGCVideoProcessor.this.mVideoProcessManager != null) {
            UGCVideoProcessor.this.mVideoProcessManager.processByVideoEffect(pixelFrame);
        }
        pixelFrame.release();
    }
}
