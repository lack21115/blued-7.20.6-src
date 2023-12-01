package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/as.class */
final /* synthetic */ class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f23301a;
    private final String b;

    private as(ai aiVar, String str) {
        this.f23301a = aiVar;
        this.b = str;
    }

    public static Runnable a(ai aiVar, String str) {
        return new as(aiVar, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f23301a, this.b);
    }
}
