package com.tencent.liteav.videoconsumer.decoder;

import android.graphics.SurfaceTexture;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/z.class */
final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final r f23121a;
    private final SurfaceTexture b;

    private z(r rVar, SurfaceTexture surfaceTexture) {
        this.f23121a = rVar;
        this.b = surfaceTexture;
    }

    public static Runnable a(r rVar, SurfaceTexture surfaceTexture) {
        return new z(rVar, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.a(this.f23121a, this.b);
    }
}
