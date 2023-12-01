package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ec.class */
final /* synthetic */ class ec implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFilePixelFrameProvider f40344a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f40345c;

    private ec(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider, long j, boolean z) {
        this.f40344a = uGCMultiFilePixelFrameProvider;
        this.b = j;
        this.f40345c = z;
    }

    public static Runnable a(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider, long j, boolean z) {
        return new ec(uGCMultiFilePixelFrameProvider, j, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMultiFilePixelFrameProvider.lambda$seekTo$2(this.f40344a, this.b, this.f40345c);
    }
}
