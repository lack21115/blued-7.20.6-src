package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/q.class */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final p f37032a;

    private q(p pVar) {
        this.f37032a = pVar;
    }

    public static Runnable a(p pVar) {
        return new q(pVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a(this.f37032a);
    }
}
