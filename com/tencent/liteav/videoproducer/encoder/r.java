package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/r.class */
final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final p f23342a;
    private final String b;

    private r(p pVar, String str) {
        this.f23342a = pVar;
        this.b = str;
    }

    public static Runnable a(p pVar, String str) {
        return new r(pVar, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a(this.f23342a, this.b);
    }
}
