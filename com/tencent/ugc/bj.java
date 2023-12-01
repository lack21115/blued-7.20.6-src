package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bj.class */
public final /* synthetic */ class bj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26566a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26567c;
    private final int d;

    private bj(TXVideoEditer tXVideoEditer, int i, long j, int i2) {
        this.f26566a = tXVideoEditer;
        this.b = i;
        this.f26567c = j;
        this.d = i2;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, long j, int i2) {
        return new bj(tXVideoEditer, i, j, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$null$0(this.f26566a, this.b, this.f26567c, this.d);
    }
}
