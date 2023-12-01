package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/x.class */
public final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f23402a;
    private final com.tencent.liteav.videobase.a.a b;

    private x(VideoPreprocessor videoPreprocessor, com.tencent.liteav.videobase.a.a aVar) {
        this.f23402a = videoPreprocessor;
        this.b = aVar;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, com.tencent.liteav.videobase.a.a aVar) {
        return new x(videoPreprocessor, aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setInterceptorBeforeWatermark$14(this.f23402a, this.b);
    }
}
