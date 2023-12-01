package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ad.class */
public final /* synthetic */ class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f36973a;

    private ad(x xVar) {
        this.f36973a = xVar;
    }

    public static Runnable a(x xVar) {
        return new ad(xVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f36973a;
        if (xVar.f.fullIFrame) {
            xVar.b();
        }
    }
}
