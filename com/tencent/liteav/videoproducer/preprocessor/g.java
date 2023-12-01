package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/g.class */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BeautyProcessor f23373a;
    private final boolean b;

    private g(BeautyProcessor beautyProcessor, boolean z) {
        this.f23373a = beautyProcessor;
        this.b = z;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, boolean z) {
        return new g(beautyProcessor, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        BeautyProcessor.lambda$setPerformanceMode$6(this.f23373a, this.b);
    }
}
