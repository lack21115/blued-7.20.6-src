package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/g.class */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37160a;

    private g(f fVar) {
        this.f37160a = fVar;
    }

    public static Runnable a(f fVar) {
        return new g(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.c(this.f37160a);
    }
}
