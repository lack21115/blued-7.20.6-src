package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ag.class */
final /* synthetic */ class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26531a;

    private ag(TXVideoEditer tXVideoEditer) {
        this.f26531a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new ag(tXVideoEditer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$release$37(this.f26531a);
    }
}
