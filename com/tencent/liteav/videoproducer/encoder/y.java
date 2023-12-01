package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/y.class */
public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f37045a;

    private y(x xVar) {
        this.f37045a = xVar;
    }

    public static Runnable a(x xVar) {
        return new y(xVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f37045a;
        if (xVar.e != null) {
            xVar.e.a();
        }
    }
}
