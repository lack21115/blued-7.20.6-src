package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/g.class */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26713a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26714c;

    private g(TXVideoEditer tXVideoEditer, long j, long j2) {
        this.f26713a = tXVideoEditer;
        this.b = j;
        this.f26714c = j2;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, long j, long j2) {
        return new g(tXVideoEditer, j, j2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setBGMStartTime$14(this.f26713a, this.b, this.f26714c);
    }
}
