package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/i.class */
final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f36704a;
    private final PixelFrame b;

    private i(a aVar, PixelFrame pixelFrame) {
        this.f36704a = aVar;
        this.b = pixelFrame;
    }

    public static Runnable a(a aVar, PixelFrame pixelFrame) {
        return new i(aVar, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f36704a, this.b);
    }
}
