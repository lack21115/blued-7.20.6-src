package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/o.class */
final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23480a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23481c;

    private o(f fVar, int i, int i2) {
        this.f23480a = fVar;
        this.b = i;
        this.f23481c = i2;
    }

    public static Runnable a(f fVar, int i, int i2) {
        return new o(fVar, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23480a, this.b, this.f23481c);
    }
}
