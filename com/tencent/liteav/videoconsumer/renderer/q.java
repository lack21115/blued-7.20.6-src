package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/q.class */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f23148a;
    private final boolean b;

    private q(g gVar, boolean z) {
        this.f23148a = gVar;
        this.b = z;
    }

    public static Runnable a(g gVar, boolean z) {
        return new q(gVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.b(this.f23148a, this.b);
    }
}
