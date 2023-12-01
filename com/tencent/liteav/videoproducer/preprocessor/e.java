package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/e.class */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BeautyProcessor f23370a;
    private final float b;

    private e(BeautyProcessor beautyProcessor, float f) {
        this.f23370a = beautyProcessor;
        this.b = f;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, float f) {
        return new e(beautyProcessor, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        BeautyProcessor.lambda$setRuddyLevel$4(this.f23370a, this.b);
    }
}
