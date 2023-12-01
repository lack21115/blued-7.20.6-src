package com.tencent.liteav.videoconsumer.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/l.class */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f36833a;
    private final boolean b;

    private l(g gVar, boolean z) {
        this.f36833a = gVar;
        this.b = z;
    }

    public static Runnable a(g gVar, boolean z) {
        return new l(gVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.c(this.f36833a, this.b);
    }
}
