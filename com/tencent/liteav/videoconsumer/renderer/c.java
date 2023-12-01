package com.tencent.liteav.videoconsumer.renderer;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/c.class */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f23126a;
    private final Surface b;

    private c(a aVar, Surface surface) {
        this.f23126a = aVar;
        this.b = surface;
    }

    public static Runnable a(a aVar, Surface surface) {
        return new c(aVar, surface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.f23126a;
        Surface surface = this.b;
        aVar.c();
        aVar.b = surface;
        if (aVar.f23122a != null) {
            if (surface == null) {
                aVar.f23122a.a();
            } else {
                aVar.f23122a.a(surface, aVar.d.f22649a, aVar.d.b, false);
            }
        }
    }
}
