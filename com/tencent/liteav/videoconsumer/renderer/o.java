package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.base.GLConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/o.class */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f23146a;
    private final GLConstants.GLScaleType b;

    private o(g gVar, GLConstants.GLScaleType gLScaleType) {
        this.f23146a = gVar;
        this.b = gLScaleType;
    }

    public static Runnable a(g gVar, GLConstants.GLScaleType gLScaleType) {
        return new o(gVar, gLScaleType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.a(this.f23146a, this.b);
    }
}
