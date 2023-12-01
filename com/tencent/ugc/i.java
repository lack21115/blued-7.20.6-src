package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/i.class */
final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40430a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f40431c;

    private i(TXVideoEditer tXVideoEditer, long j, long j2) {
        this.f40430a = tXVideoEditer;
        this.b = j;
        this.f40431c = j2;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, long j, long j2) {
        return new i(tXVideoEditer, j, j2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setBGMFadeInOutDuration$16(this.f40430a, this.b, this.f40431c);
    }
}
