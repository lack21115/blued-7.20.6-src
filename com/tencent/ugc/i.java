package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/i.class */
final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26739a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26740c;

    private i(TXVideoEditer tXVideoEditer, long j, long j2) {
        this.f26739a = tXVideoEditer;
        this.b = j;
        this.f26740c = j2;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, long j, long j2) {
        return new i(tXVideoEditer, j, j2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setBGMFadeInOutDuration$16(this.f26739a, this.b, this.f26740c);
    }
}
