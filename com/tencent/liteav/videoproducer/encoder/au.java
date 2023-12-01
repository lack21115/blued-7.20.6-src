package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/au.class */
final /* synthetic */ class au implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f23303a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23304c;

    private au(ai aiVar, boolean z, int i) {
        this.f23303a = aiVar;
        this.b = z;
        this.f23304c = i;
    }

    public static Runnable a(ai aiVar, boolean z, int i) {
        return new au(aiVar, z, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f23303a, this.b, this.f23304c);
    }
}
