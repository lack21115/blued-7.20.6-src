package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/h.class */
final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f23012a;
    private final PixelFrame b;

    private h(a aVar, PixelFrame pixelFrame) {
        this.f23012a = aVar;
        this.b = pixelFrame;
    }

    public static Runnable a(a aVar, PixelFrame pixelFrame) {
        return new h(aVar, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.b(this.f23012a, this.b);
    }
}
