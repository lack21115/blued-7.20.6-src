package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/ab.class */
public final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f23359a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final ag f23360c;

    private ab(VideoPreprocessor videoPreprocessor, int i, ag agVar) {
        this.f23359a = videoPreprocessor;
        this.b = i;
        this.f23360c = agVar;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, int i, ag agVar) {
        return new ab(videoPreprocessor, i, agVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$unregisterVideoProcessedListener$4(this.f23359a, this.b, this.f23360c);
    }
}
