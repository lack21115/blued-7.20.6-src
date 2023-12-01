package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ar.class */
final /* synthetic */ class ar implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f36991a;

    private ar(ai aiVar) {
        this.f36991a = aiVar;
    }

    public static Runnable a(ai aiVar) {
        return new ar(aiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36991a.i();
    }
}
