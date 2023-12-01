package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.utils.Rotation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/p.class */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f36838a;
    private final Rotation b;

    private p(g gVar, Rotation rotation) {
        this.f36838a = gVar;
        this.b = rotation;
    }

    public static Runnable a(g gVar, Rotation rotation) {
        return new p(gVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.a(this.f36838a, this.b);
    }
}
