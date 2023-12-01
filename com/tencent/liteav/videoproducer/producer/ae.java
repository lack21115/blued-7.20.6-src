package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ae.class */
final /* synthetic */ class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37112a;

    private ae(f fVar) {
        this.f37112a = fVar;
    }

    public static Runnable a(f fVar) {
        return new ae(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37112a);
    }
}
