package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/al.class */
public final /* synthetic */ class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f36984a;

    private al(ai aiVar) {
        this.f36984a = aiVar;
    }

    public static Runnable a(ai aiVar) {
        return new al(aiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.c(this.f36984a);
    }
}
