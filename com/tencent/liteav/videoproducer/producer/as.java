package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/as.class */
final /* synthetic */ class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23443a;

    private as(f fVar) {
        this.f23443a = fVar;
    }

    public static Runnable a(f fVar) {
        return new as(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23443a.c();
    }
}
