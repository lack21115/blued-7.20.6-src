package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/eu.class */
final /* synthetic */ class eu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f26675a;

    private eu(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        this.f26675a = uGCSingleFilePixelFrameProvider;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        return new eu(uGCSingleFilePixelFrameProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCSingleFilePixelFrameProvider.lambda$onAbandonDecodingFramesCompleted$4(this.f26675a);
    }
}
