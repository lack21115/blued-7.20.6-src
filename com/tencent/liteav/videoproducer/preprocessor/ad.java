package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/ad.class */
final /* synthetic */ class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f23363a;
    private final GLConstants.GLScaleType b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23364c;

    private ad(VideoPreprocessor videoPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z) {
        this.f23363a = videoPreprocessor;
        this.b = gLScaleType;
        this.f23364c = z;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z) {
        return new ad(videoPreprocessor, gLScaleType, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setGreenScreenParam$6(this.f23363a, this.b, this.f23364c);
    }
}
