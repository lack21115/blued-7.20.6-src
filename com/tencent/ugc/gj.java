package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gj.class */
public final /* synthetic */ class gj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCWatermarkAlphaTextureFilter f40419a;
    private final boolean b;

    private gj(UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter, boolean z) {
        this.f40419a = uGCWatermarkAlphaTextureFilter;
        this.b = z;
    }

    public static Runnable a(UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter, boolean z) {
        return new gj(uGCWatermarkAlphaTextureFilter, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40419a.mIsShowBackImageMoment = this.b;
    }
}
