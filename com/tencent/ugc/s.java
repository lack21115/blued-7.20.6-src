package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/s.class */
final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40443a;
    private final boolean b;

    private s(TXVideoEditer tXVideoEditer, boolean z) {
        this.f40443a = tXVideoEditer;
        this.b = z;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, boolean z) {
        return new s(tXVideoEditer, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setReverse$25(this.f40443a, this.b);
    }
}
