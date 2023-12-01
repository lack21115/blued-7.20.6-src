package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/av.class */
final /* synthetic */ class av implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23448a;

    private av(f fVar) {
        this.f23448a = fVar;
    }

    public static Runnable a(f fVar) {
        return new av(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.e(this.f23448a);
    }
}
