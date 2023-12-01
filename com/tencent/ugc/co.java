package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/co.class */
final /* synthetic */ class co implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f40298a;
    private final long b;

    private co(UGCImageProvider uGCImageProvider, long j) {
        this.f40298a = uGCImageProvider;
        this.b = j;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider, long j) {
        return new co(uGCImageProvider, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCImageProvider.lambda$seekTo$4(this.f40298a, this.b);
    }
}
