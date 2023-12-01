package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/au.class */
final /* synthetic */ class au implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f36994a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36995c;

    private au(ai aiVar, boolean z, int i) {
        this.f36994a = aiVar;
        this.b = z;
        this.f36995c = i;
    }

    public static Runnable a(ai aiVar, boolean z, int i) {
        return new au(aiVar, z, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f36994a, this.b, this.f36995c);
    }
}
