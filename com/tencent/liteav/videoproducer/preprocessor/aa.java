package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videobase.base.GLConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/aa.class */
public final /* synthetic */ class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f23357a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.liteav.videobase.videobase.a f23358c;
    private final GLConstants.PixelBufferType d;
    private final GLConstants.PixelFormatType e;
    private final boolean f;
    private final ag g;

    private aa(VideoPreprocessor videoPreprocessor, int i, com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z, ag agVar) {
        this.f23357a = videoPreprocessor;
        this.b = i;
        this.f23358c = aVar;
        this.d = pixelBufferType;
        this.e = pixelFormatType;
        this.f = z;
        this.g = agVar;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, int i, com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z, ag agVar) {
        return new aa(videoPreprocessor, i, aVar, pixelBufferType, pixelFormatType, z, agVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$registerVideoProcessedListener$3(this.f23357a, this.b, this.f23358c, this.d, this.e, this.f, this.g);
    }
}
