package com.tencent.liteav.txcvodplayer.renderer;

import android.graphics.SurfaceTexture;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/k.class */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f22884a;
    private final SurfaceTexture b;

    private k(c cVar, SurfaceTexture surfaceTexture) {
        this.f22884a = cVar;
        this.b = surfaceTexture;
    }

    public static Runnable a(c cVar, SurfaceTexture surfaceTexture) {
        return new k(cVar, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f22884a, this.b);
    }
}
