package com.tencent.liteav.videoconsumer.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/h.class */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f36827a;
    private final VideoRenderListener b;

    private h(g gVar, VideoRenderListener videoRenderListener) {
        this.f36827a = gVar;
        this.b = videoRenderListener;
    }

    public static Runnable a(g gVar, VideoRenderListener videoRenderListener) {
        return new h(gVar, videoRenderListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.a(this.f36827a, this.b);
    }
}
