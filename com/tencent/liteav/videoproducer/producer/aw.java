package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/aw.class */
final /* synthetic */ class aw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23449a;

    private aw(f fVar) {
        this.f23449a = fVar;
    }

    public static Runnable a(f fVar) {
        return new aw(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.f(this.f23449a);
    }
}
