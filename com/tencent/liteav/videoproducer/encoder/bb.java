package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/bb.class */
public final /* synthetic */ class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f37005a;

    private bb(ai aiVar) {
        this.f37005a = aiVar;
    }

    public static Runnable a(ai aiVar) {
        return new bb(aiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.d(this.f37005a);
    }
}
