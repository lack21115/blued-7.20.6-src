package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/y.class */
public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f37094a;
    private final CaptureSourceInterface.SourceType b;

    private y(VideoPreprocessor videoPreprocessor, CaptureSourceInterface.SourceType sourceType) {
        this.f37094a = videoPreprocessor;
        this.b = sourceType;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, CaptureSourceInterface.SourceType sourceType) {
        return new y(videoPreprocessor, sourceType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37094a.mPreprocessor.h = this.b;
    }
}
