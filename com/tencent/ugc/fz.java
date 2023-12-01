package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fz.class */
public final /* synthetic */ class fz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f26712a;

    private fz(UGCVideoProcessor uGCVideoProcessor) {
        this.f26712a = uGCVideoProcessor;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor) {
        return new fz(uGCVideoProcessor);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26712a.stopEncoder();
    }
}
