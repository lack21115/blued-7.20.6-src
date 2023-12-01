package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fc.class */
final /* synthetic */ class fc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f40375a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f40376c;

    private fc(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, long j, boolean z) {
        this.f40375a = uGCSingleFilePixelFrameProvider;
        this.b = j;
        this.f40376c = z;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, long j, boolean z) {
        return new fc(uGCSingleFilePixelFrameProvider, j, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCSingleFilePixelFrameProvider.lambda$seekTo$0(this.f40375a, this.b, this.f40376c);
    }
}
