package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/v.class */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f23400a;
    private final int b;

    private v(VideoPreprocessor videoPreprocessor, int i) {
        this.f23400a = videoPreprocessor;
        this.b = i;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, int i) {
        return new v(videoPreprocessor, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23400a.mPreprocessor.e.setHomeOrientation(this.b);
    }
}
