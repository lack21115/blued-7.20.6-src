package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/u.class */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26755a;

    private u(TXVideoEditer tXVideoEditer) {
        this.f26755a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new u(tXVideoEditer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$deleteLastTransitionEffect$27(this.f26755a);
    }
}
