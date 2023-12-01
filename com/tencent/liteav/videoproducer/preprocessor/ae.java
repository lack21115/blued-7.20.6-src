package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/ae.class */
public final /* synthetic */ class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f23365a;
    private final float b;

    private ae(VideoPreprocessor videoPreprocessor, float f) {
        this.f23365a = videoPreprocessor;
        this.b = f;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, float f) {
        return new ae(videoPreprocessor, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setFilterMixLevel$7(this.f23365a, this.b);
    }
}
