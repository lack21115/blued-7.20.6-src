package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/aq.class */
final /* synthetic */ class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26542a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26543c;

    private aq(TXVideoEditer tXVideoEditer, long j, long j2) {
        this.f26542a = tXVideoEditer;
        this.b = j;
        this.f26543c = j2;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, long j, long j2) {
        return new aq(tXVideoEditer, j, j2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setCutFromTime$46(this.f26542a, this.b, this.f26543c);
    }
}
