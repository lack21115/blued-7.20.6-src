package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/b.class */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BeautyProcessor f37058a;
    private final float b;

    private b(BeautyProcessor beautyProcessor, float f) {
        this.f37058a = beautyProcessor;
        this.b = f;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, float f) {
        return new b(beautyProcessor, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        BeautyProcessor.lambda$setBeautyLevel$1(this.f37058a, this.b);
    }
}
