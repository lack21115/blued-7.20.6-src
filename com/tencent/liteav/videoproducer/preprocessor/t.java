package com.tencent.liteav.videoproducer.preprocessor;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/t.class */
final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f23398a;
    private final List b;

    private t(VideoPreprocessor videoPreprocessor, List list) {
        this.f23398a = videoPreprocessor;
        this.b = list;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, List list) {
        return new t(videoPreprocessor, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setWatermarkList$11(this.f23398a, this.b);
    }
}
