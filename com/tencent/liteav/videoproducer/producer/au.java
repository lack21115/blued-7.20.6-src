package com.tencent.liteav.videoproducer.producer;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/au.class */
final /* synthetic */ class au implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23446a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23447c;

    private au(f fVar, Bitmap bitmap, int i) {
        this.f23446a = fVar;
        this.b = bitmap;
        this.f23447c = i;
    }

    public static Runnable a(f fVar, Bitmap bitmap, int i) {
        return new au(fVar, bitmap, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23446a, this.b, this.f23447c);
    }
}
