package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cq.class */
final /* synthetic */ class cq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f40300a;

    private cq(UGCImageProvider uGCImageProvider) {
        this.f40300a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new cq(uGCImageProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40300a.decodeBitmapFrame();
    }
}
