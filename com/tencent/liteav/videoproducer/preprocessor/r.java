package com.tencent.liteav.videoproducer.preprocessor;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/r.class */
public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f37085a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f37086c;
    private final float d;
    private final Bitmap e;
    private final float f;

    private r(VideoPreprocessor videoPreprocessor, float f, Bitmap bitmap, float f2, Bitmap bitmap2, float f3) {
        this.f37085a = videoPreprocessor;
        this.b = f;
        this.f37086c = bitmap;
        this.d = f2;
        this.e = bitmap2;
        this.f = f3;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, float f, Bitmap bitmap, float f2, Bitmap bitmap2, float f3) {
        return new r(videoPreprocessor, f, bitmap, f2, bitmap2, f3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37085a.mPreprocessor.a(this.b, this.f37086c, this.d, this.e, this.f);
    }
}
