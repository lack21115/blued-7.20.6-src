package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/r.class */
final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f23149a;
    private final boolean b;

    private r(g gVar, boolean z) {
        this.f23149a = gVar;
        this.b = z;
    }

    public static Runnable a(g gVar, boolean z) {
        return new r(gVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.a(this.f23149a, this.b);
    }
}
