package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/u.class */
public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f37090a;
    private final float b;

    private u(VideoPreprocessor videoPreprocessor, float f) {
        this.f37090a = videoPreprocessor;
        this.b = f;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, float f) {
        return new u(videoPreprocessor, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setGaussianBlurLevel$12(this.f37090a, this.b);
    }
}
