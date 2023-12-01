package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/k.class */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f23141a;

    private k(g gVar) {
        this.f23141a = gVar;
    }

    public static Runnable a(g gVar) {
        return new k(gVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.a(this.f23141a);
    }
}
