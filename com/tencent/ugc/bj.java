package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bj.class */
public final /* synthetic */ class bj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40257a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final long f40258c;
    private final int d;

    private bj(TXVideoEditer tXVideoEditer, int i, long j, int i2) {
        this.f40257a = tXVideoEditer;
        this.b = i;
        this.f40258c = j;
        this.d = i2;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, long j, int i2) {
        return new bj(tXVideoEditer, i, j, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$null$0(this.f40257a, this.b, this.f40258c, this.d);
    }
}
