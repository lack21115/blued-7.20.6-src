package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/v.class */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40447a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final long f40448c;

    private v(TXVideoEditer tXVideoEditer, int i, long j) {
        this.f40447a = tXVideoEditer;
        this.b = i;
        this.f40448c = j;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, long j) {
        return new v(tXVideoEditer, i, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$startEffect$28(this.f40447a, this.b, this.f40448c);
    }
}
