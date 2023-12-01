package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/am.class */
public final /* synthetic */ class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f36985a;
    private final int b;

    private am(ai aiVar, int i) {
        this.f36985a = aiVar;
        this.b = i;
    }

    public static Runnable a(ai aiVar, int i) {
        return new am(aiVar, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.b(this.f36985a, this.b);
    }
}
