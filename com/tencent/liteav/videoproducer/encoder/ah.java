package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ah.class */
final /* synthetic */ class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f36977a;

    private ah(x xVar) {
        this.f36977a = xVar;
    }

    public static Runnable a(x xVar) {
        return new ah(xVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f36977a;
        xVar.a();
        xVar.f37044c.removeCallbacks(xVar.n);
        xVar.a(xVar.d);
        xVar.d = null;
    }
}
