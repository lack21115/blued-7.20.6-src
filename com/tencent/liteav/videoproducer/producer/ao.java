package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ao.class */
final /* synthetic */ class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37127a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final PixelFrame f37128c;

    private ao(f fVar, int i, PixelFrame pixelFrame) {
        this.f37127a = fVar;
        this.b = i;
        this.f37128c = pixelFrame;
    }

    public static Runnable a(f fVar, int i, PixelFrame pixelFrame) {
        return new ao(fVar, i, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37127a, this.b, this.f37128c);
    }
}
