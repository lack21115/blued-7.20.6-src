package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fx.class */
public final /* synthetic */ class fx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40401a;

    private fx(UGCVideoProcessor uGCVideoProcessor) {
        this.f40401a = uGCVideoProcessor;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor) {
        return new fx(uGCVideoProcessor);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.lambda$unInitialize$0(this.f40401a);
    }
}
