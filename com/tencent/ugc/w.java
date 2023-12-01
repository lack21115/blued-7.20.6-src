package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/w.class */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26771a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26772c;

    private w(TXVideoEditer tXVideoEditer, int i, long j) {
        this.f26771a = tXVideoEditer;
        this.b = i;
        this.f26772c = j;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, long j) {
        return new w(tXVideoEditer, i, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$stopEffect$29(this.f26771a, this.b, this.f26772c);
    }
}
