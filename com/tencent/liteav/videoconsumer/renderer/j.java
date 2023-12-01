package com.tencent.liteav.videoconsumer.renderer;

import android.view.Surface;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/j.class */
final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f36830a;
    private final Surface b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36831c;
    private final int d;
    private final boolean e;

    private j(g gVar, Surface surface, int i, int i2, boolean z) {
        this.f36830a = gVar;
        this.b = surface;
        this.f36831c = i;
        this.d = i2;
        this.e = z;
    }

    public static Runnable a(g gVar, Surface surface, int i, int i2, boolean z) {
        return new j(gVar, surface, i, i2, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.a(this.f36830a, this.b, this.f36831c, this.d, this.e);
    }
}
