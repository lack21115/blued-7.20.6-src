package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/ad.class */
final /* synthetic */ class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f37054a;
    private final GLConstants.GLScaleType b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f37055c;

    private ad(VideoPreprocessor videoPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z) {
        this.f37054a = videoPreprocessor;
        this.b = gLScaleType;
        this.f37055c = z;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z) {
        return new ad(videoPreprocessor, gLScaleType, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setGreenScreenParam$6(this.f37054a, this.b, this.f37055c);
    }
}
