package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fd.class */
final /* synthetic */ class fd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f26686a;
    private final boolean b;

    private fd(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, boolean z) {
        this.f26686a = uGCSingleFilePixelFrameProvider;
        this.b = z;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, boolean z) {
        return new fd(uGCSingleFilePixelFrameProvider, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26686a.setReverseInternal(this.b);
    }
}
