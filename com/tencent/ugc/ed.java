package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ed.class */
final /* synthetic */ class ed implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFilePixelFrameProvider f26655a;

    private ed(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        this.f26655a = uGCMultiFilePixelFrameProvider;
    }

    public static Runnable a(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        return new ed(uGCMultiFilePixelFrameProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26655a.readFrameToQueue();
    }
}
