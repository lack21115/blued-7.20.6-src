package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/al.class */
final /* synthetic */ class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23431a;
    private final boolean b;

    private al(f fVar, boolean z) {
        this.f23431a = fVar;
        this.b = z;
    }

    public static Runnable a(f fVar, boolean z) {
        return new al(fVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23431a, this.b);
    }
}
