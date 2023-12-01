package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/z.class */
public final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f37095a;
    private final PixelFrame b;

    /* renamed from: c  reason: collision with root package name */
    private final long f37096c;

    private z(VideoPreprocessor videoPreprocessor, PixelFrame pixelFrame, long j) {
        this.f37095a = videoPreprocessor;
        this.b = pixelFrame;
        this.f37096c = j;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, PixelFrame pixelFrame, long j) {
        return new z(videoPreprocessor, pixelFrame, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$processFrame$2(this.f37095a, this.b, this.f37096c);
    }
}
