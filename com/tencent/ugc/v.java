package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/v.class */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26756a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26757c;

    private v(TXVideoEditer tXVideoEditer, int i, long j) {
        this.f26756a = tXVideoEditer;
        this.b = i;
        this.f26757c = j;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, long j) {
        return new v(tXVideoEditer, i, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$startEffect$28(this.f26756a, this.b, this.f26757c);
    }
}
