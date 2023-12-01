package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cd.class */
final /* synthetic */ class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40286a;

    private cd(TXVideoEditer tXVideoEditer) {
        this.f40286a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new cd(tXVideoEditer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40286a.stopPlay();
    }
}
