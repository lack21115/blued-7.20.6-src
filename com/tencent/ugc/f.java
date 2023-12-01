package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/f.class */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40372a;
    private final long b;

    private f(TXVideoEditer tXVideoEditer, long j) {
        this.f40372a = tXVideoEditer;
        this.b = j;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, long j) {
        return new f(tXVideoEditer, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setBGMAtVideoTime$13(this.f40372a, this.b);
    }
}
