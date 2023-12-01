package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ao.class */
public final /* synthetic */ class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f23296a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23297c;

    private ao(ai aiVar, int i, int i2) {
        this.f23296a = aiVar;
        this.b = i;
        this.f23297c = i2;
    }

    public static Runnable a(ai aiVar, int i, int i2) {
        return new ao(aiVar, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f23296a, this.b, this.f23297c);
    }
}
