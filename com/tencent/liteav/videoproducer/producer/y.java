package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/y.class */
final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23495a;
    private final GLConstants.GLScaleType b;

    private y(f fVar, GLConstants.GLScaleType gLScaleType) {
        this.f23495a = fVar;
        this.b = gLScaleType;
    }

    public static Runnable a(f fVar, GLConstants.GLScaleType gLScaleType) {
        return new y(fVar, gLScaleType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23495a, this.b);
    }
}
