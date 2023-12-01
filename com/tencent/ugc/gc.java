package com.tencent.ugc;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gc.class */
public final /* synthetic */ class gc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f26719a;
    private final DisplayTarget b;

    /* renamed from: c  reason: collision with root package name */
    private final GLConstants.GLScaleType f26720c;

    private gc(UGCVideoProcessor uGCVideoProcessor, DisplayTarget displayTarget, GLConstants.GLScaleType gLScaleType) {
        this.f26719a = uGCVideoProcessor;
        this.b = displayTarget;
        this.f26720c = gLScaleType;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, DisplayTarget displayTarget, GLConstants.GLScaleType gLScaleType) {
        return new gc(uGCVideoProcessor, displayTarget, gLScaleType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.lambda$setDisplayView$4(this.f26719a, this.b, this.f26720c);
    }
}
