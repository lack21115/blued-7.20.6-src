package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gk.class */
public final /* synthetic */ class gk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCWatermarkAlphaTextureFilter f40420a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40421c;
    private final int d;
    private final float e;
    private final float f;
    private final float g;

    private gk(UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter, int i, int i2, int i3, float f, float f2, float f3) {
        this.f40420a = uGCWatermarkAlphaTextureFilter;
        this.b = i;
        this.f40421c = i2;
        this.d = i3;
        this.e = f;
        this.f = f2;
        this.g = f3;
    }

    public static Runnable a(UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter, int i, int i2, int i3, float f, float f2, float f3) {
        return new gk(uGCWatermarkAlphaTextureFilter, i, i2, i3, f, f2, f3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCWatermarkAlphaTextureFilter.lambda$setTextureWatermark$1(this.f40420a, this.b, this.f40421c, this.d, this.e, this.f, this.g);
    }
}
