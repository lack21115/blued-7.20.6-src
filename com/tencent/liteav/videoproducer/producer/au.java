package com.tencent.liteav.videoproducer.producer;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/au.class */
final /* synthetic */ class au implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37137a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final int f37138c;

    private au(f fVar, Bitmap bitmap, int i) {
        this.f37137a = fVar;
        this.b = bitmap;
        this.f37138c = i;
    }

    public static Runnable a(f fVar, Bitmap bitmap, int i) {
        return new au(fVar, bitmap, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37137a, this.b, this.f37138c);
    }
}
