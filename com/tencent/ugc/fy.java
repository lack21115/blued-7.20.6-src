package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fy.class */
public final /* synthetic */ class fy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40402a;
    private final boolean b;

    private fy(UGCVideoProcessor uGCVideoProcessor, boolean z) {
        this.f40402a = uGCVideoProcessor;
        this.b = z;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, boolean z) {
        return new fy(uGCVideoProcessor, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40402a.mIsRecord = this.b;
    }
}
