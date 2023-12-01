package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ak.class */
final /* synthetic */ class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23430a;
    private final boolean b;

    private ak(f fVar, boolean z) {
        this.f23430a = fVar;
        this.b = z;
    }

    public static Runnable a(f fVar, boolean z) {
        return new ak(fVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.b(this.f23430a, this.b);
    }
}
