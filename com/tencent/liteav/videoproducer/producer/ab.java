package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ab.class */
final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23417a;

    private ab(f fVar) {
        this.f23417a = fVar;
    }

    public static Runnable a(f fVar) {
        return new ab(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.g(this.f23417a);
    }
}
