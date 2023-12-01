package com.tencent.liteav.videoconsumer.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/s.class */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f36841a;

    private s(g gVar) {
        this.f36841a = gVar;
    }

    public static Runnable a(g gVar) {
        return new s(gVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.b(this.f36841a);
    }
}
