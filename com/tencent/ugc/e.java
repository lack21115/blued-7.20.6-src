package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/e.class */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40341a;
    private final boolean b;

    private e(TXVideoEditer tXVideoEditer, boolean z) {
        this.f40341a = tXVideoEditer;
        this.b = z;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, boolean z) {
        return new e(tXVideoEditer, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setBGMLoop$12(this.f40341a, this.b);
    }
}
