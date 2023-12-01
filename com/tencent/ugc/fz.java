package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fz.class */
public final /* synthetic */ class fz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40403a;

    private fz(UGCVideoProcessor uGCVideoProcessor) {
        this.f40403a = uGCVideoProcessor;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor) {
        return new fz(uGCVideoProcessor);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40403a.stopEncoder();
    }
}
