package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/n.class */
final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37170a;
    private final String b;

    private n(f fVar, String str) {
        this.f37170a = fVar;
        this.b = str;
    }

    public static Runnable a(f fVar, String str) {
        return new n(fVar, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37170a, this.b);
    }
}
