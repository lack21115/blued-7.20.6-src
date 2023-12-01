package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/d.class */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BeautyProcessor f37060a;
    private final float b;

    private d(BeautyProcessor beautyProcessor, float f) {
        this.f37060a = beautyProcessor;
        this.b = f;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, float f) {
        return new d(beautyProcessor, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        BeautyProcessor.lambda$setSharpenLevel$3(this.f37060a, this.b);
    }
}
