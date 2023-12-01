package com.tencent.ugc;

import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.ugc.UGCVideoProcessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gi.class */
final /* synthetic */ class gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor.AnonymousClass4 f26727a;
    private final PixelFrame b;

    private gi(UGCVideoProcessor.AnonymousClass4 anonymousClass4, PixelFrame pixelFrame) {
        this.f26727a = anonymousClass4;
        this.b = pixelFrame;
    }

    public static Runnable a(UGCVideoProcessor.AnonymousClass4 anonymousClass4, PixelFrame pixelFrame) {
        return new gi(anonymousClass4, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.AnonymousClass4.a(this.f26727a, this.b);
    }
}
