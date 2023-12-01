package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ft.class */
public final /* synthetic */ class ft implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40396a;
    private final float b;

    private ft(UGCVideoProcessor uGCVideoProcessor, float f) {
        this.f40396a = uGCVideoProcessor;
        this.b = f;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, float f) {
        return new ft(uGCVideoProcessor, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.lambda$setSpecialRatio$11(this.f40396a, this.b);
    }
}
