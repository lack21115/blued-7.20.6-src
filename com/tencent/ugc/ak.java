package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ak.class */
public final /* synthetic */ class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26535a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26536c;

    private ak(TXVideoEditer tXVideoEditer, long j, long j2) {
        this.f26535a = tXVideoEditer;
        this.b = j;
        this.f26536c = j2;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, long j, long j2) {
        return new ak(tXVideoEditer, j, j2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$startPlayFromTime$40(this.f26535a, this.b, this.f26536c);
    }
}
