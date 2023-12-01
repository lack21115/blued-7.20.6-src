package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ad.class */
final /* synthetic */ class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37110a;
    private final PixelFrame b;

    /* renamed from: c  reason: collision with root package name */
    private final int f37111c;
    private final int d;

    private ad(f fVar, PixelFrame pixelFrame, int i, int i2) {
        this.f37110a = fVar;
        this.b = pixelFrame;
        this.f37111c = i;
        this.d = i2;
    }

    public static Runnable a(f fVar, PixelFrame pixelFrame, int i, int i2) {
        return new ad(fVar, pixelFrame, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37110a, this.b, this.f37111c, this.d);
    }
}
