package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ar.class */
final /* synthetic */ class ar implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37133a;
    private final float b;

    private ar(f fVar, float f) {
        this.f37133a = fVar;
        this.b = f;
    }

    public static Runnable a(f fVar, float f) {
        return new ar(fVar, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37133a, this.b);
    }
}
