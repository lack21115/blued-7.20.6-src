package com.tencent.ugc;

import com.tencent.liteav.videobase.utils.Rotation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gd.class */
public final /* synthetic */ class gd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f26721a;
    private final Rotation b;

    private gd(UGCVideoProcessor uGCVideoProcessor, Rotation rotation) {
        this.f26721a = uGCVideoProcessor;
        this.b = rotation;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, Rotation rotation) {
        return new gd(uGCVideoProcessor, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.lambda$setRenderRotation$5(this.f26721a, this.b);
    }
}
