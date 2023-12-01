package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/r.class */
final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23484a;

    private r(f fVar) {
        this.f23484a = fVar;
    }

    public static Runnable a(f fVar) {
        return new r(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.b(this.f23484a);
    }
}
