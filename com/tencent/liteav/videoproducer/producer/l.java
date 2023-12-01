package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/l.class */
final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23477a;
    private final boolean b;

    private l(f fVar, boolean z) {
        this.f23477a = fVar;
        this.b = z;
    }

    public static Runnable a(f fVar, boolean z) {
        return new l(fVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.d(this.f23477a, this.b);
    }
}
