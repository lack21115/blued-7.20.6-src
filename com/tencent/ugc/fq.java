package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fq.class */
public final /* synthetic */ class fq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f26701a;
    private final int b;

    private fq(UGCVideoProcessor uGCVideoProcessor, int i) {
        this.f26701a = uGCVideoProcessor;
        this.b = i;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, int i) {
        return new fq(uGCVideoProcessor, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26701a.mTransitionType = this.b;
    }
}
