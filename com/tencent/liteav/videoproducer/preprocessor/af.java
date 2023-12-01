package com.tencent.liteav.videoproducer.preprocessor;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/af.class */
final /* synthetic */ class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f23366a;
    private final Bitmap b;

    private af(VideoPreprocessor videoPreprocessor, Bitmap bitmap) {
        this.f23366a = videoPreprocessor;
        this.b = bitmap;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, Bitmap bitmap) {
        return new af(videoPreprocessor, bitmap);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.mPreprocessor.a(1.0f, this.b, this.f23366a.mLookupMixLevel, null, 0.0f);
    }
}
