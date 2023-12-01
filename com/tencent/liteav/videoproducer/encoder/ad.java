package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ad.class */
final /* synthetic */ class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f23282a;

    private ad(x xVar) {
        this.f23282a = xVar;
    }

    public static Runnable a(x xVar) {
        return new ad(xVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f23282a;
        if (xVar.f.fullIFrame) {
            xVar.b();
        }
    }
}
