package com.tencent.liteav.beauty.a;

import android.graphics.SurfaceTexture;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/a/a.class */
public final class a implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public Thread f22659a;
    public volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0757a f22660c;
    private volatile boolean d;

    /* renamed from: com.tencent.liteav.beauty.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/a/a$a.class */
    public interface InterfaceC0757a {
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.d = true;
    }
}
