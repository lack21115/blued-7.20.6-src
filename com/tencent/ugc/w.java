package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/w.class */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40462a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final long f40463c;

    private w(TXVideoEditer tXVideoEditer, int i, long j) {
        this.f40462a = tXVideoEditer;
        this.b = i;
        this.f40463c = j;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, long j) {
        return new w(tXVideoEditer, i, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$stopEffect$29(this.f40462a, this.b, this.f40463c);
    }
}
