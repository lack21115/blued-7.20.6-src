package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/a.class */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BeautyProcessor f23356a;
    private final int b;

    private a(BeautyProcessor beautyProcessor, int i) {
        this.f23356a = beautyProcessor;
        this.b = i;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, int i) {
        return new a(beautyProcessor, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.updateBeautyInternal(this.b, r0.mBeautyLevel, r0.mWhitenessLevel, r0.mRuddyLevel, this.f23356a.mSharpnessLevel);
    }
}
