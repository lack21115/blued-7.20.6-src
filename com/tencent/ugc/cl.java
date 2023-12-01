package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cl.class */
final /* synthetic */ class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f26604a;

    private cl(UGCImageProvider uGCImageProvider) {
        this.f26604a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new cl(uGCImageProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCImageProvider.lambda$uninitialize$1(this.f26604a);
    }
}
