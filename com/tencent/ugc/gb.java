package com.tencent.ugc;

import com.tencent.liteav.videobase.base.GLConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gb.class */
public final /* synthetic */ class gb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40408a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40409c;
    private final GLConstants.GLScaleType d;

    private gb(UGCVideoProcessor uGCVideoProcessor, int i, int i2, GLConstants.GLScaleType gLScaleType) {
        this.f40408a = uGCVideoProcessor;
        this.b = i;
        this.f40409c = i2;
        this.d = gLScaleType;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, int i, int i2, GLConstants.GLScaleType gLScaleType) {
        return new gb(uGCVideoProcessor, i, i2, gLScaleType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.lambda$setOutputSize$3(this.f40408a, this.b, this.f40409c, this.d);
    }
}
