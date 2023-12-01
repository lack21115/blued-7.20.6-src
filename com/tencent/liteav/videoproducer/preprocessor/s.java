package com.tencent.liteav.videoproducer.preprocessor;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/s.class */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f37087a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final float f37088c;
    private final float d;
    private final float e;

    private s(VideoPreprocessor videoPreprocessor, Bitmap bitmap, float f, float f2, float f3) {
        this.f37087a = videoPreprocessor;
        this.b = bitmap;
        this.f37088c = f;
        this.d = f2;
        this.e = f3;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, Bitmap bitmap, float f, float f2, float f3) {
        return new s(videoPreprocessor, bitmap, f, f2, f3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setWatermark$10(this.f37087a, this.b, this.f37088c, this.d, this.e);
    }
}
