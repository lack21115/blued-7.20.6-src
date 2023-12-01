package com.tencent.liteav.videoproducer.preprocessor;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/s.class */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f23396a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final float f23397c;
    private final float d;
    private final float e;

    private s(VideoPreprocessor videoPreprocessor, Bitmap bitmap, float f, float f2, float f3) {
        this.f23396a = videoPreprocessor;
        this.b = bitmap;
        this.f23397c = f;
        this.d = f2;
        this.e = f3;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, Bitmap bitmap, float f, float f2, float f3) {
        return new s(videoPreprocessor, bitmap, f, f2, f3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setWatermark$10(this.f23396a, this.b, this.f23397c, this.d, this.e);
    }
}
