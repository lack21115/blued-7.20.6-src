package com.tencent.ugc;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fu.class */
public final /* synthetic */ class fu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40397a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final float f40398c;
    private final Bitmap d;
    private final float e;
    private final float f;

    private fu(UGCVideoProcessor uGCVideoProcessor, Bitmap bitmap, float f, Bitmap bitmap2, float f2, float f3) {
        this.f40397a = uGCVideoProcessor;
        this.b = bitmap;
        this.f40398c = f;
        this.d = bitmap2;
        this.e = f2;
        this.f = f3;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, Bitmap bitmap, float f, Bitmap bitmap2, float f2, float f3) {
        return new fu(uGCVideoProcessor, bitmap, f, bitmap2, f2, f3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.lambda$setFilter$12(this.f40397a, this.b, this.f40398c, this.d, this.e, this.f);
    }
}
