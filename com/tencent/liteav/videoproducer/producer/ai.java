package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ai.class */
final /* synthetic */ class ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37119a;

    private ai(f fVar) {
        this.f37119a = fVar;
    }

    public static Runnable a(f fVar) {
        return new ai(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37119a.i();
    }
}
