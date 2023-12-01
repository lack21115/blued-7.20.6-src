package com.tencent.liteav.videoproducer.encoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ag.class */
final /* synthetic */ class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f23285a;
    private final String b;

    private ag(x xVar, String str) {
        this.f23285a = xVar;
        this.b = str;
    }

    public static Runnable a(x xVar, String str) {
        return new ag(xVar, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f23285a;
        String str = this.b;
        if (xVar.e != null) {
            xVar.e.a(str);
        }
    }
}
