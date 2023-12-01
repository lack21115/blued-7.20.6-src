package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/c.class */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BeautyProcessor f23368a;
    private final float b;

    private c(BeautyProcessor beautyProcessor, float f) {
        this.f23368a = beautyProcessor;
        this.b = f;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, float f) {
        return new c(beautyProcessor, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        BeautyProcessor.lambda$setWhitenessLevel$2(this.f23368a, this.b);
    }
}
