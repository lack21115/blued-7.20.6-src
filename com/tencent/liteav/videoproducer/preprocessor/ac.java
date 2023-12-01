package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/ac.class */
final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f37052a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f37053c;

    private ac(VideoPreprocessor videoPreprocessor, String str, boolean z) {
        this.f37052a = videoPreprocessor;
        this.b = str;
        this.f37053c = z;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, String str, boolean z) {
        return new ac(videoPreprocessor, str, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setGreenScreenFile$5(this.f37052a, this.b, this.f37053c);
    }
}
