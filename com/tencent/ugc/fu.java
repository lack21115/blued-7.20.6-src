package com.tencent.ugc;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fu.class */
public final /* synthetic */ class fu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f26706a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final float f26707c;
    private final Bitmap d;
    private final float e;
    private final float f;

    private fu(UGCVideoProcessor uGCVideoProcessor, Bitmap bitmap, float f, Bitmap bitmap2, float f2, float f3) {
        this.f26706a = uGCVideoProcessor;
        this.b = bitmap;
        this.f26707c = f;
        this.d = bitmap2;
        this.e = f2;
        this.f = f3;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, Bitmap bitmap, float f, Bitmap bitmap2, float f2, float f3) {
        return new fu(uGCVideoProcessor, bitmap, f, bitmap2, f2, f3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.lambda$setFilter$12(this.f26706a, this.b, this.f26707c, this.d, this.e, this.f);
    }
}
