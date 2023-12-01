package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ed.class */
final /* synthetic */ class ed implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFilePixelFrameProvider f40346a;

    private ed(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        this.f40346a = uGCMultiFilePixelFrameProvider;
    }

    public static Runnable a(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        return new ed(uGCMultiFilePixelFrameProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40346a.readFrameToQueue();
    }
}
