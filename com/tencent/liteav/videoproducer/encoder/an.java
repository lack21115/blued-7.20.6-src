package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/an.class */
public final /* synthetic */ class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f23295a;
    private final int b;

    private an(ai aiVar, int i) {
        this.f23295a = aiVar;
        this.b = i;
    }

    public static Runnable a(ai aiVar, int i) {
        return new an(aiVar, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f23295a, this.b);
    }
}
