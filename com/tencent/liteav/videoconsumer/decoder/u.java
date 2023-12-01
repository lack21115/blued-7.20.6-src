package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/u.class */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final r f36807a;

    private u(r rVar) {
        this.f36807a = rVar;
    }

    public static Runnable a(r rVar) {
        return new u(rVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36807a.a();
    }
}
