package com.tencent.liteav.videoproducer.producer;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ag.class */
final /* synthetic */ class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23424a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final float f23425c;
    private final float d;
    private final float e;

    private ag(f fVar, Bitmap bitmap, float f, float f2, float f3) {
        this.f23424a = fVar;
        this.b = bitmap;
        this.f23425c = f;
        this.d = f2;
        this.e = f3;
    }

    public static Runnable a(f fVar, Bitmap bitmap, float f, float f2, float f3) {
        return new ag(fVar, bitmap, f, f2, f3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23424a.f23465c.setWatermark(this.b, this.f23425c, this.d, this.e);
    }
}
