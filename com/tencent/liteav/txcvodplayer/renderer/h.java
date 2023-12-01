package com.tencent.liteav.txcvodplayer.renderer;

import com.tencent.liteav.videobase.base.GLConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/h.class */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f36572a;
    private final GLConstants.GLScaleType b;

    private h(c cVar, GLConstants.GLScaleType gLScaleType) {
        this.f36572a = cVar;
        this.b = gLScaleType;
    }

    public static Runnable a(c cVar, GLConstants.GLScaleType gLScaleType) {
        return new h(cVar, gLScaleType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f36572a, this.b);
    }
}
